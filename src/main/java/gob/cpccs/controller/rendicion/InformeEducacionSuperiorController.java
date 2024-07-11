package gob.cpccs.controller.rendicion;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import gob.cpccs.controller.HomeController;
import gob.cpccs.model.catalogos.TblInstitucion;
import gob.cpccs.model.catalogos.TblLocalizacion;
import gob.cpccs.model.dto.rendicion.AspectosPresupuestariosIESDTO;
import gob.cpccs.model.dto.rendicion.CumplimientoObligacionesIESDTO;
import gob.cpccs.model.dto.rendicion.MecanismosGADDTO;
import gob.cpccs.model.dto.rendicion.ModalidadEstudiosIESDTO;
import gob.cpccs.model.dto.rendicion.ObligacionesInternasIESDTO;
import gob.cpccs.model.dto.rendicion.PoliticasIgualdadGADDTO;
import gob.cpccs.model.dto.rendicion.ReporteAvanceGADDTO;
import gob.cpccs.model.dto.rendicion.SedesExtensionesIESDTO;
import gob.cpccs.model.rendicion.TblCoberturaNacional;
import gob.cpccs.model.rendicion.TblCompromisosInformeant;
import gob.cpccs.model.rendicion.TblEjecucionProgramatica;
import gob.cpccs.model.rendicion.TblFuncionesObjetivos;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblModalidadEstudios;
import gob.cpccs.model.rendicion.TblObjetivosPlanDesarrollo;
import gob.cpccs.model.rendicion.TblObligacionesEducacion;
import gob.cpccs.model.rendicion.TblPlanTrabajoGad;
import gob.cpccs.model.rendicion.TblPresupuestoEducacion;
import gob.cpccs.model.rendicion.TblPresupuestoInstitucional;
import gob.cpccs.model.rendicion.TblSede;
import gob.cpccs.model.usuario.TblResponables;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.service.AplicacionesUsuarioJPAServicio;
import gob.cpccs.service.catalogos.CatalogosServicio;
import gob.cpccs.service.catalogos.InstitucionServicio;
import gob.cpccs.service.mail.EmailService;
import gob.cpccs.service.rendicion.InformeServicio;
import gob.cpccs.service.rendicion.ModalidadEstudioService;
import gob.cpccs.service.rendicion.SedeService;
import gob.cpccs.service.usuario.ResponsableServicio;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;
import gob.cpccs.service.rendicion.ObligacionesEducacionService;
import gob.cpccs.service.rendicion.PresupuestoEducacionService;

@Controller
public class InformeEducacionSuperiorController {
	
	@Autowired
    private HomeController hc;
	@Autowired
	private UsuarioServicio usu;
	@Autowired
	private InformeServicio infor;
	@Autowired
	private ModalidadEstudioService mes;
	@Autowired
	private CatalogosServicio gcs;
	@Autowired
	private SedeService ss;
	@Autowired
	private	CatalogosServicio cs;
	@Autowired
	private AplicacionesUsuarioJPAServicio auis;
	@Autowired
	private	ObligacionesEducacionService oes;
	@Autowired
	private ResponsableServicio respon;
	@Autowired
	private PresupuestoEducacionService pes;
	@Autowired
    private EmailService ms;
	@Autowired
	private InstitucionServicio servicioinstitucion;
	
	@RequestMapping("/view/rendicion/Frm_ModalidadEstudios")
    public String Frm_ModalidadEstudios(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
    	TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   			List<TblModalidadEstudios> verificarModalidadEstudios =  mes.OntenerModalidadEstudiosXcod(verificarInforme);

   	 	if(verificarModalidadEstudios.isEmpty()) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("infCod", verificarInforme.getInfCod());
		}
		else {
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
	        model.addAttribute("acciones", listaAcciones);
			model.addAttribute("inf_estado", "matriz");
			model.addAttribute("infCod", verificarInforme.getInfCod());
			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			
		}		
		}
		
         return "rendicion/Frm_ModalidadEstudios";
    }
	
	@RequestMapping(value = "view/rendicion/Frm_ModalidadEstudiosNuevo",method = RequestMethod.POST)
    public String Frm_ModalidadEstudiosNuevo(Model model, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
		
			model.addAttribute("inf_estado", verificarInforme.getInfEstado());
			model.addAttribute("infCod", verificarInforme.getInfCod());
			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			
         return "rendicion/Frm_ModalidadEstudiosNuevo";
    }
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarModalidadEstudios")
	public @ResponseBody String guardarModalidadEstudios(HttpServletRequest request,  @RequestParam(value = "infCod") Integer infCod
			,  @RequestParam(value = "mosTipo") String mosTipo
						) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			
			 
			TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				if (mosTipo != null ) {
					TblModalidadEstudios tblModalidadEstudios = new TblModalidadEstudios();
					tblModalidadEstudios.setInfCod(tblInforme);
					tblModalidadEstudios.setMosTipo(mosTipo.toUpperCase());
					mes.guardarModalidadEstudios(tblModalidadEstudios);  
				}
				   
			

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	
	 @RequestMapping(value = {"/obtenerModalidadEstudios"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerModalidadEstudios(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
			List<ModalidadEstudiosIESDTO> lista = new ArrayList<>();
			try {
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				List<Object[]> listaModalidad = mes.obtenerRegistroModalidadEstudiosXcod(tblInforme);
				if (listaModalidad.size()> 0) {	
					
					lista=listaModalidad.stream().map(obj->ModalidadEstudiosIESDTO.builder()
							.imple_cod((Integer)obj[0])
							.contador(listaModalidad.indexOf(obj)+1)
							.objetivo(obj[1].toString())
							.build())
							.collect(Collectors.toList());
					json = (!lista.isEmpty())
							? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
							: Constantes.MESSAGE_EMPTY_JSON;
				}else{
	                json = "{\"data\": []}";
	           }
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
	 
	
	@RequestMapping("/view/rendicion/Frm_GrupoEducacionSuperior")
    public String Frm_GrupoEducacionSuperior(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
    	TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {

   	 	if(verificarInforme.getInfGprEducacion()==null) {
   	 		model.addAttribute("inf_estado", verificarInforme.getInfEstado());
   	 		model.addAttribute("infCod", verificarInforme.getInfCod());
		}
		else {
			model.addAttribute("inf_estado", "matriz");
			model.addAttribute("infCod", verificarInforme.getInfCod());
			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			model.addAttribute("inf_gpr_educacion", verificarInforme.getInfGprEducacion());
			
		}		
		}
		
         return "rendicion/Frm_GrupoEducacionSuperior";
    }
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarGrupoEducacion")
	public @ResponseBody String guardarGrupoEducacion( @RequestParam(value = "infCod") Integer infCod
			,  @RequestParam(value = "infGprEducacion") String infGprEducacion
						) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
				if (infGprEducacion != null ) {
					infor.ActualizarGrupoEducacion(infGprEducacion, infCod);
				}

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	@RequestMapping("/view/rendicion/Frm_InformacionSedesExtensiones")
    public String Frm_InformacionSedesExtensiones(Model model, @RequestParam("opcion") int idMenu, Authentication authentication ) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 	Date date = new Date();
   	 	DateFormat formatter = new SimpleDateFormat("yyyy");
   	 	String anio = formatter.format(date);
   	 	model.addAttribute("anio", anio);
   	 	List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacion(1, "activo");
   	 	model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
   	 	List<TblLocalizacion> listadoLocalizacionCanton = gcs.obtenerLocalizacion(2, "activo");
   	 	model.addAttribute("listadoLocalizacionCanton", listadoLocalizacionCanton);
   	 	List<TblLocalizacion> listadoLocalizacionParroquia = gcs.obtenerLocalizacion(4, "activo");
   	 	model.addAttribute("listadoLocalizacionParroquia", listadoLocalizacionParroquia);
		
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
		List<TblSede> verificarSedes = ss.obtenerSedes(verificarInforme);
   	 	if(verificarSedes.size() == 0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("infCod", verificarInforme.getInfCod());
		}
		else {
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
	        model.addAttribute("acciones", listaAcciones);
			model.addAttribute("inf_estado", "matriz");
			model.addAttribute("infCod",  verificarInforme.getInfCod());
			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
		}		
		}
         return "rendicion/Frm_InformacionSedesExtensiones";
    }
	
	
	
	@RequestMapping(value = "/view/rendicion/Frm_InformacionSedesExtensionesActualizarSede",method = RequestMethod.POST)
    public String Frm_InformacionSedesExtensionesActualizarSede(Model model,Authentication authentication, @RequestParam("id") Integer id) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 	Date date = new Date();
   	 	DateFormat formatter = new SimpleDateFormat("yyyy");
   	 	String anio = formatter.format(date);
   	 	model.addAttribute("anio", anio);
   	 	List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacion(1, "activo");
   	 	model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
   	 	List<TblLocalizacion> listadoLocalizacionCanton = gcs.obtenerLocalizacion(2, "activo");
   	 	model.addAttribute("listadoLocalizacionCanton", listadoLocalizacionCanton);
   	 	List<TblLocalizacion> listadoLocalizacionParroquia = gcs.obtenerLocalizacion(4, "activo");
   	 	model.addAttribute("listadoLocalizacionParroquia", listadoLocalizacionParroquia);
		
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
		List<TblSede> verificarSedes = ss.obtenerSedes(verificarInforme);
   	 	if(verificarSedes.size() == 0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("infCod", verificarInforme.getInfCod());
		}
		else {
			model.addAttribute("inf_estado", verificarInforme.getInfEstado());
			model.addAttribute("infCod",  verificarInforme.getInfCod());
			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			model.addAttribute("seCod", id);
			TblSede datoSede = ss.obtenerSedesXcodigo(id);
			model.addAttribute("nombreSede", datoSede.getSeNombre());
			model.addAttribute("provincia", datoSede.getSeProvincia());
			model.addAttribute("canton", datoSede.getSeCanton());
			model.addAttribute("parroquia", datoSede.getSeParroquia());
			model.addAttribute("direccion", datoSede.getSeDireccion());
			model.addAttribute("mail", datoSede.getSeMail());
			model.addAttribute("web", datoSede.getSeWeb());
			model.addAttribute("ruc", datoSede.getSeRuc());
			
		}		
		}
         return "rendicion/Frm_InformacionSedesExtensionesActualizarSede";
    }
	
	
	@RequestMapping(value = "/view/rendicion/Frm_InformacionSedesExtensionesActualizarSedeDetalle",method = RequestMethod.POST)
    public String Frm_InformacionSedesExtensionesActualizarSedeDetalle(Model model,Authentication authentication, @RequestParam("id") Integer id) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
		List<TblSede> verificarSedes = ss.obtenerSedes(verificarInforme);
   	 	if(verificarSedes.size() == 0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("infCod", verificarInforme.getInfCod());
		}
		else {
			model.addAttribute("inf_estado", verificarInforme.getInfEstado());
			model.addAttribute("infCod",  verificarInforme.getInfCod());
			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			model.addAttribute("seCod", id);
			TblSede datoSede = ss.obtenerSedesXcodigo(id);
			model.addAttribute("nombreRepresentante", datoSede.getSeRepresentante());
			model.addAttribute("cargo", datoSede.getSeCargo());
			model.addAttribute("correo", datoSede.getSeMailrep());
			Date tipoFecha = datoSede.getSeDesignacion();
	   	 	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	   	 	String fechaDesignacion = formatter.format(tipoFecha);
			model.addAttribute("designacion", fechaDesignacion);
			model.addAttribute("telefono", datoSede.getSeTelrep());
		
		}		
		}
         return "rendicion/Frm_InformacionSedesExtensionesActualizarSedeDetalle";
    }
	
	@RequestMapping(value = "/view/rendicion/Frm_InformacionSedesExtensionesActualizarSedeDetalle2",method = RequestMethod.POST)
    public String Frm_InformacionSedesExtensionesActualizarSedeDetalle2(Model model,Authentication authentication, @RequestParam("id") Integer id) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
		List<TblSede> verificarSedes = ss.obtenerSedes(verificarInforme);
   	 	if(verificarSedes.size() == 0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("infCod", verificarInforme.getInfCod());
		}
		else {
			model.addAttribute("inf_estado", verificarInforme.getInfEstado());
			model.addAttribute("infCod",  verificarInforme.getInfCod());
			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			model.addAttribute("seCod", id);
			TblSede datoSede = ss.obtenerSedesXcodigo(id);
			model.addAttribute("numeroUnidades", datoSede.getSeUnidades());
			model.addAttribute("cobertura", datoSede.getSeCobertura());
			model.addAttribute("estudiantes", datoSede.getSeEstudiantes());
			model.addAttribute("hombre", datoSede.getSeHombre());
			model.addAttribute("mujer", datoSede.getSeMujeres());
			model.addAttribute("glbti", datoSede.getSeGlbti());
			model.addAttribute("montubio", datoSede.getSeMontubios());
			model.addAttribute("mestizo", datoSede.getSeMestizos());
			model.addAttribute("cholo", datoSede.getSeCholos());
			model.addAttribute("indigena", datoSede.getSeIndigenas());
			model.addAttribute("afro", datoSede.getSeAfroecuatorianos());
			model.addAttribute("extranjeros", datoSede.getSeExtranjeros());
			model.addAttribute("discapacidad", datoSede.getSeDiscapacitados());
			model.addAttribute("link", datoSede.getSeLink());
		}		
		}
         return "rendicion/Frm_InformacionSedesExtensionesActualizarSedeDetalle2";
    }
	
	@RequestMapping(value = "/view/rendicion/Frm_InformacionSedesExtensionesNuevo",method = RequestMethod.POST)
    public String Frm_InformacionSedesExtensionesNuevo(Model model, Authentication authentication ) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 	Date date = new Date();
   	 	DateFormat formatter = new SimpleDateFormat("yyyy");
   	 	String anio = formatter.format(date);
   	 	model.addAttribute("anio", anio);
   	 	List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacion(1, "activo");
   	 	model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
   	 	List<TblLocalizacion> listadoLocalizacionCanton = gcs.obtenerLocalizacion(2, "activo");
   	 	model.addAttribute("listadoLocalizacionCanton", listadoLocalizacionCanton);
   	 	List<TblLocalizacion> listadoLocalizacionParroquia = gcs.obtenerLocalizacion(4, "activo");
   	 	model.addAttribute("listadoLocalizacionParroquia", listadoLocalizacionParroquia);
		
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
		List<TblSede> verificarSedes = ss.obtenerSedes(verificarInforme);
   	 	if(verificarSedes.size() == 0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("infCod", verificarInforme.getInfCod());
		}
		else {
			model.addAttribute("inf_estado", verificarInforme.getInfEstado());
			model.addAttribute("infCod",  verificarInforme.getInfCod());
			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
		}		
		}
         return "rendicion/Frm_InformacionSedesExtensionesNuevo";
    }
	
	
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarActualizarSede")
	public @ResponseBody String guardarActualizarSede(HttpServletRequest request, @RequestParam("seCod") Integer seCod) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			TblSede tblSede = new TblSede();
			tblSede.setSeNombre(request.getParameter("seNombre").toUpperCase());
			tblSede.setSeProvincia(Integer.parseInt(request.getParameter("seProvincia")));
			tblSede.setSeCanton(Integer.parseInt(request.getParameter("seCanton")));
			tblSede.setSeParroquia(Integer.parseInt(request.getParameter("seParroquia")));
			tblSede.setSeDireccion(request.getParameter("seDireccion"));
			tblSede.setSeMail(request.getParameter("seMail"));
			tblSede.setSeWeb(request.getParameter("seWeb"));
			tblSede.setSeRuc(request.getParameter("seRuc"));
			ss.actualizarDatosSede(seCod, tblSede.getSeNombre(), tblSede.getSeProvincia(),tblSede.getSeParroquia(), tblSede.getSeCanton(), tblSede.getSeDireccion(), tblSede.getSeMail(), tblSede.getSeWeb(), tblSede.getSeRuc());	
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarActualizarSedeDetalle")
	public @ResponseBody String guardarActualizarSedeDetalle(HttpServletRequest request, @RequestParam("seCod") Integer seCod) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			TblSede tblSede = new TblSede();
			tblSede.setSeRepresentante(request.getParameter("seRepresentante").toUpperCase());
			tblSede.setSeCargo(request.getParameter("seCargo").toUpperCase());
			tblSede.setSeMailrep(request.getParameter("seMailrep"));
			Date fechaDesignacion = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("seDesignacion"));
			tblSede.setSeDesignacion(fechaDesignacion);
			tblSede.setSeTelrep(request.getParameter("seTelrep"));
			ss.actualizarDatosSedeDetalle(seCod, tblSede.getSeRepresentante(), tblSede.getSeCargo(),tblSede.getSeMailrep(), fechaDesignacion, tblSede.getSeTelrep());	
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarActualizarSedeDetalle2")
	public @ResponseBody String guardarActualizarSedeDetalle2(HttpServletRequest request, @RequestParam("seCod") Integer seCod) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			TblSede tblSede = new TblSede();
			tblSede.setSeUnidades(Integer.parseInt(request.getParameter("seUnidades")));
			tblSede.setSeCobertura(request.getParameter("seCobertura").toUpperCase());
			tblSede.setSeEstudiantes(Integer.parseInt(request.getParameter("seEstudiantes")));
			tblSede.setSeHombre(Integer.parseInt(request.getParameter("seHombre")));
			tblSede.setSeMujeres(Integer.parseInt(request.getParameter("seMujeres")));
			tblSede.setSeGlbti(Integer.parseInt(request.getParameter("seGlbti")));
			tblSede.setSeMontubios(Integer.parseInt(request.getParameter("seMontubios")));
			tblSede.setSeMestizos(Integer.parseInt(request.getParameter("seMestizos")));
			tblSede.setSeCholos(Integer.parseInt(request.getParameter("seCholos")));
			tblSede.setSeIndigenas(Integer.parseInt(request.getParameter("seIndigenas")));
			tblSede.setSeAfroecuatorianos(Integer.parseInt(request.getParameter("seAfroecuatorianos")));
			tblSede.setSeExtranjeros(Integer.parseInt(request.getParameter("seExtranjeros")));
			tblSede.setSeDiscapacitados(Integer.parseInt(request.getParameter("seDiscapacitados")));
			tblSede.setSeLink(request.getParameter("seLink").replaceAll(System.getProperty("line.separator"), ""));
			ss.actualizarDatosSedeDetalle2(seCod, tblSede.getSeUnidades(), tblSede.getSeCobertura(),tblSede.getSeEstudiantes(), 
					tblSede.getSeHombre(), tblSede.getSeMujeres(), tblSede.getSeGlbti(), tblSede.getSeMontubios(), tblSede.getSeMestizos(),
					tblSede.getSeCholos(), tblSede.getSeIndigenas(), tblSede.getSeAfroecuatorianos(),tblSede.getSeExtranjeros(),
					tblSede.getSeDiscapacitados(),tblSede.getSeLink() );	
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarSede")
	public @ResponseBody String guardarSede(HttpServletRequest request) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
		
			TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(Integer.parseInt(request.getParameter("infCod")), Constantes.periodo());

			TblSede tblSede = new TblSede();
			tblSede.setInfCod(tblInforme);
			tblSede.setSeNombre(request.getParameter("seNombre").toUpperCase());
			tblSede.setSeProvincia(Integer.parseInt(request.getParameter("seProvincia")));
			tblSede.setSeCanton(Integer.parseInt(request.getParameter("seCanton")));
			tblSede.setSeParroquia(Integer.parseInt(request.getParameter("seParroquia")));
			tblSede.setSeDireccion(request.getParameter("seDireccion"));
			tblSede.setSeMail(request.getParameter("seMail"));
			tblSede.setSeWeb(request.getParameter("seWeb"));
			tblSede.setSeRuc(request.getParameter("seRuc"));
			tblSede.setSeRepresentante(request.getParameter("seRepresentante").toUpperCase());
			tblSede.setSeCargo(request.getParameter("seCargo").toUpperCase());
			tblSede.setSeMailrep(request.getParameter("seMailrep"));
			Date fechaDesignacion = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("seDesignacion"));
			tblSede.setSeDesignacion(fechaDesignacion);
			tblSede.setSeTelrep(request.getParameter("seTelrep"));
			tblSede.setSeUnidades(Integer.parseInt(request.getParameter("seUnidades")));
			tblSede.setSeCobertura(request.getParameter("seCobertura").toUpperCase());
			tblSede.setSeEstudiantes(Integer.parseInt(request.getParameter("seEstudiantes")));
			tblSede.setSeHombre(Integer.parseInt(request.getParameter("seHombre")));
			tblSede.setSeMujeres(Integer.parseInt(request.getParameter("seMujeres")));
			tblSede.setSeGlbti(Integer.parseInt(request.getParameter("seGlbti")));
			tblSede.setSeMontubios(Integer.parseInt(request.getParameter("seMontubios")));
			tblSede.setSeMestizos(Integer.parseInt(request.getParameter("seMestizos")));
			tblSede.setSeCholos(Integer.parseInt(request.getParameter("seCholos")));
			tblSede.setSeIndigenas(Integer.parseInt(request.getParameter("seIndigenas")));
			tblSede.setSeAfroecuatorianos(Integer.parseInt(request.getParameter("seAfroecuatorianos")));
			tblSede.setSeExtranjeros(Integer.parseInt(request.getParameter("seExtranjeros")));
			tblSede.setSeDiscapacitados(Integer.parseInt(request.getParameter("seDiscapacitados")));
			tblSede.setSeLink(request.getParameter("seLink").replaceAll(System.getProperty("line.separator"), ""));
			
			
			ss.guardarSede(tblSede);	
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	 @RequestMapping(value = {"/obtenerSedes"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerSedes(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
			List<SedesExtensionesIESDTO> lista = new ArrayList<>();
			try {
				
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				List<Object[]> listaSedes = ss.obtenerSedesXcod(tblInforme);
				if (listaSedes.size()> 0) {			

					for (Object[] item : listaSedes) {					
						SedesExtensionesIESDTO tabla1= new SedesExtensionesIESDTO();
						int p =  Integer.parseInt(item[0].toString());
	                	TblSede datoSede = ss.obtenerSedesXcodigo(p);
						TblLocalizacion nombreProvincia = cs.obtenerNombreLocalizacion(1, datoSede.getSeProvincia(), Constantes.ESTADO);
						TblLocalizacion nombreCanton = cs.obtenerNombreLocalizacion(2, datoSede.getSeCanton(), Constantes.ESTADO);
						TblLocalizacion nombreParroquia = cs.obtenerNombreLocalizacion(4, datoSede.getSeParroquia(), Constantes.ESTADO);

						tabla1.setSe_cod((Integer)item[0]);
						tabla1.setContador(listaSedes.indexOf(item)+1);
						tabla1.setNombreSede(item[1].toString());
						tabla1.setProvincia(nombreProvincia.getNombre());
						tabla1.setCanton(nombreCanton.getNombre());
						tabla1.setParroquia(nombreParroquia.getNombre());
						tabla1.setDireccion(item[5].toString());
						tabla1.setCorreo(item[6].toString());
						tabla1.setPaginaWeb(item[7].toString());
						tabla1.setRuc(item[8].toString());
						lista.add(tabla1);
					}
					json = (!lista.isEmpty())
							? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
							: Constantes.MESSAGE_EMPTY_JSON;
					   //json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
				
				}else{
	                json = "{\"data\": []}";
	           }
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
	 @RequestMapping(value = {"/obtenerSedesDetalle"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerSedesDetalle(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
			List<SedesExtensionesIESDTO> lista = new ArrayList<>();
			try {
				
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				List<Object[]> listaSedes = ss.obtenerSedesXcod(tblInforme);
				if (listaSedes.size()> 0) {			
					   
					lista=listaSedes.stream().map(obj->SedesExtensionesIESDTO.builder()
							.se_cod((Integer)obj[0])
							.contador(listaSedes.indexOf(obj)+1)
							.nombreSede(obj[1].toString())
							.representanteLegal(obj[9].toString())
							.cargo(obj[10].toString())
							.fecha(obj[11].toString())
							.correo(obj[12].toString())
							.telefono(obj[13].toString())
							.build())
							.collect(Collectors.toList());
					json = (!lista.isEmpty())
							? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
							: Constantes.MESSAGE_EMPTY_JSON;
				}else{
	                json = "{\"data\": []}";
	           }
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
	 
	 @RequestMapping(value = {"/obtenerSedesDetalle2"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerSedesDetalle2(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
			List<SedesExtensionesIESDTO> lista = new ArrayList<>();
			try {
				
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				List<Object[]> listaSedes = ss.obtenerSedesXcod(tblInforme);
				if (listaSedes.size()> 0) {			
					   lista=listaSedes.stream().map(obj->SedesExtensionesIESDTO.builder()
							   .se_cod((Integer)obj[0])
							   .contador(listaSedes.indexOf(obj)+1)
							   .nombreSede(obj[1].toString())
							   .nroSedes(obj[14].toString())
							   .cobertura(obj[15].toString())
							   .estudiantes(obj[16].toString())
							   .hombre(obj[17].toString())
							   .mujer(obj[18].toString())
							   .glbti(obj[19].toString())
							   .montubio(obj[20].toString())
							   .mestizo(obj[21].toString())
							   .cholo(obj[22].toString())
							   .indigena(obj[24].toString())
							   .afro(obj[23].toString())
							   .extranjero(obj[25].toString())
							   .discapacitado(obj[26].toString())
							   .link(obj[27].toString()) 
							   .build())
							   .collect(Collectors.toList());
					   json = (!lista.isEmpty())
								? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
								: Constantes.MESSAGE_EMPTY_JSON;
					   }else{
	                json = "{\"data\": []}";
	           }
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
	
	 
		@RequestMapping("/view/rendicion/Frm_CumplimientoObligacionesIES")
	    public String Frm_CumplimientoObligacionesIES(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {		
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
	   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
	   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
	   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
	   	 	}else {
	   	 	  List<TblObligacionesEducacion> listaObligacionesEducacion = oes.ObtenerObligacionesEducacionxInforme(verificarInforme.getInfCod());
	   		if(listaObligacionesEducacion.size() ==0) {
	   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
	 		model.addAttribute("inf_Cod", verificarInforme.getInfCod());
	 		
			}
			else {			
				model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_MATRIZ);
				 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				model.addAttribute("inf_Cod", verificarInforme.getInfCod());
				List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
		        model.addAttribute("acciones", listaAcciones);
			}		
			}
	         return "rendicion/Frm_CumplimientoObligacionesIES";
	    }
		
		
		
		@RequestMapping(value = "/view/rendicion/Frm_CumplimientoObligacionesIESNuevo",method = RequestMethod.POST)
	 public String Frm_CumplimientoObligacionesIESNuevo(Model model, Authentication authentication) {		
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
	   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
	   	 	if (verificarInforme==null){
	   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
	   	 	}else {
	   	 	  List<TblObligacionesEducacion> listaObligacionesEducacion = oes.ObtenerObligacionesEducacionxInforme(verificarInforme.getInfCod());
	   		if(listaObligacionesEducacion.size() ==0) {
	   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
	 		model.addAttribute("inf_Cod", verificarInforme.getInfCod());
	 		
			}
			else {			
				model.addAttribute("inf_estado", verificarInforme.getInfEstado());
				 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				model.addAttribute("inf_Cod", verificarInforme.getInfCod());
			}		
			}
	         return "rendicion/Frm_CumplimientoObligacionesIESNuevo";
	    }	
	 
		@SuppressWarnings("finally")
		@RequestMapping(value = "view/rendicion/guardarCumplimientoObligacionesIES")
		public @ResponseBody String guardarCumplimientoObligacionesIES(HttpServletRequest request) {

			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {
				
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(Integer.parseInt(request.getParameter("infCod")), Constantes.periodo());
		
				TblObligacionesEducacion tblObligacionesEducacion = new TblObligacionesEducacion();
				tblObligacionesEducacion.setInfCod(tblInforme);
				String descripcion =     request.getParameter("oeObligacion");
				tblObligacionesEducacion.setOeObligacion(descripcion== null ? "S/N" : descripcion.isEmpty() ? "S/N" : descripcion.toString());
				tblObligacionesEducacion.setOeCumple(request.getParameter("oeCumple"));
				tblObligacionesEducacion.setOeAcciones(request.getParameter("oeAcciones").toUpperCase());	
				tblObligacionesEducacion.setOeResultados(request.getParameter("oeResultados").toUpperCase());
				oes.guardarObligacionesEducacion(tblObligacionesEducacion);
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}

		}
		
		
		@RequestMapping(value = {"/obtenerCumplimientoObligacionesIES"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerCumplimientoObligacionesIES(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
	    	List<ObligacionesInternasIESDTO> lista = new ArrayList<>();
			try {
		   	 	  List<TblObligacionesEducacion> listaObligacionesEducacion = oes.ObtenerObligacionesEducacionxInforme(infCod);
		   	 	 
				if (listaObligacionesEducacion.size()> 0) {		
					
					lista=listaObligacionesEducacion.stream().map(obj->ObligacionesInternasIESDTO.builder()
							.oe_cod(obj.getOeCod())
							.contador(listaObligacionesEducacion.indexOf(obj)+1)
							.obligacion(obj.getOeObligacion())
							.cumple(obj.getOeCumple())
							.acciones(obj.getOeAcciones())
							.resultado(obj.getOeResultados())
							.build())
							.collect(Collectors.toList());
					json = (!lista.isEmpty())
							? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
							: Constantes.MESSAGE_EMPTY_JSON;
					
				}else{
	                json = "{\"data\": []}";
	           }
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		} 
		
		
		
		
		@RequestMapping("/view/rendicion/Frm_PresupuestariosEducacion")
	    public String Frm_PresupuestariosEducacion(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
			model.addAttribute("email", authentication.getName());
			
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
	   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
			 
	   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
	   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
	   	 	}else {
	   	 	List<TblPresupuestoEducacion> verificarPresupuestoEducacion = pes.obtenerPresupuestoEducacion(verificarInforme.getInfCod());              
	   	 	if(verificarPresupuestoEducacion.size() ==0) {
	   	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
	 		model.addAttribute("infCod", verificarInforme.getInfCod());
			}
			else {
				List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
		        model.addAttribute("acciones", listaAcciones);
				model.addAttribute("infestado", "matriz");
				model.addAttribute("infCod", verificarInforme.getInfCod());
				model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			}		
			}
	         return "rendicion/Frm_PresupuestariosEducacion";
	    }
		
		
		
		@RequestMapping(value = "/view/rendicion/Frm_PresupuestariosEducacionNuevo",method = RequestMethod.POST)
	    public String Frm_PresupuestariosEducacionNuevo(Model model, Authentication authentication) {	
			model.addAttribute("email", authentication.getName());
			
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
	   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
			 
	   	 	List<TblPresupuestoEducacion> verificarPresupuestoEducacion = pes.obtenerPresupuestoEducacion(verificarInforme.getInfCod());              
	   	
	   	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
	 		model.addAttribute("infCod", verificarInforme.getInfCod());
		
				
		
	         return "rendicion/Frm_PresupuestariosEducacionNuevo";
	    }
		
		@SuppressWarnings("finally")
		@RequestMapping(value = "view/rendicion/guardarPresupuestoEducacion")
		public @ResponseBody String guardarPresupuestoEducacion(HttpServletRequest request) {

			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {
				
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(Integer.parseInt(request.getParameter("infCod")), Constantes.periodo());
				
				String pePlanificadoString=request.getParameter("pePlanificado").toString().replace(",", "").trim();
				String peEjecutadoString=request.getParameter("peEjecutado").toString().replace(",", "").trim();
				String peTotalString=request.getParameter("peTotal").toString().replace(",", "").trim();

				Double pePlanificadoDouble = Double.valueOf(pePlanificadoString== null ? "0" : pePlanificadoString.isEmpty() ? "0" : pePlanificadoString.toString());
				Double peEjecutadoDouble = Double.valueOf(peEjecutadoString== null ? "0" : peEjecutadoString.isEmpty() ? "0" : peEjecutadoString.toString());
				Double peTotalDouble = Double.valueOf(peTotalString== null ? "0" : peTotalString.isEmpty() ? "0" : peTotalString.toString());

				TblPresupuestoEducacion tblPresupuestoEducacion = new TblPresupuestoEducacion();
				tblPresupuestoEducacion.setInfCod(tblInforme);
				tblPresupuestoEducacion.setPeAspecto(request.getParameter("peAspecto").toUpperCase());
				tblPresupuestoEducacion.setPePlanificado(new BigDecimal(pePlanificadoDouble, MathContext.DECIMAL64));
				tblPresupuestoEducacion.setPeEjecutado(new BigDecimal(peEjecutadoDouble, MathContext.DECIMAL64));	
				tblPresupuestoEducacion.setPeTotal(new BigDecimal(peTotalDouble, MathContext.DECIMAL64));
				pes.guardarPresupuestoEducacion(tblPresupuestoEducacion);
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}

		}
		
		@RequestMapping(value = {"/obtenerPresupuestoEducacion"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerPresupuestoEducacion(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
	    	List<AspectosPresupuestariosIESDTO> lista = new ArrayList<>();
			try {
				List<TblPresupuestoEducacion> verificarPresupuestoEducacion = pes.obtenerPresupuestoEducacion(infCod);              
			   	DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		  		simbolo.setDecimalSeparator('.');
	         	simbolo.setGroupingSeparator(',');
	         	DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
				if (verificarPresupuestoEducacion.size()> 0) {	
				
					lista=verificarPresupuestoEducacion.stream().map(obj->AspectosPresupuestariosIESDTO.builder()
							.pe_cod(obj.getPeCod())
							.contador(verificarPresupuestoEducacion.indexOf(obj) + 1)
							.peAspecto(obj.getPeAspecto())
							//.pePlanificado(formateador.format(obj.getPePlanificado().toString())) // cambiado a pedido del ticker 1635
							.pePlanificado(formateador.format(obj.getPePlanificado()).equals("0") ? "0 - NO APLICA" : formateador.format(obj.getPePlanificado()))
							.peEjecutado(formateador.format(obj.getPeEjecutado()))
							.peCumplimiento(obj.getPeCumplimiento())
							.peTotal(formateador.format(obj.getPeTotal()).toString())
							.build())
							.collect(Collectors.toList());
					json = (!lista.isEmpty())
							? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
							: Constantes.MESSAGE_EMPTY_JSON;
					}else{
	                json = "{\"data\": []}";
	           }
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
		
		@RequestMapping("/view/rendicion/Frm_Finalizar_Educacion_Superior")
	    public String Frm_Finalizar_Educacion_Superior(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
			model.addAttribute("email", authentication.getName());
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());

	   	     ArrayList matriz = new ArrayList();
	   	  TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
				
				model.addAttribute("inf_estado",Constantes.ESTADO_SIN_INFORME);		
	   	 	}else {
	   	 	String periodo = String.valueOf(Constantes.periodo());
			List<TblResponables> datosResponsables = respon.buscarResponsableXcodigoInstitucion(verificarInforme.getInstCod(), periodo);

			for (TblResponables datos : datosResponsables) {
				if (datos.getResponEmail() != null && !datos.getResponEmail().equals("")) {
					
				}

			}
	   	 		
	   	 		
	   	 		Integer codigoInforme = verificarInforme.getInfCod();
	   	 	 	String verificador = verificarInformeES(codigoInforme, Constantes.periodo());
		   	 	model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				model.addAttribute("infAutCod", verificarInforme.getInstCod());
				model.addAttribute("infAutPeriodo", verificarInforme.getInfPeriodo());
	   	 	 	if(verificador.equals("completo") && !verificarInforme.getInfEstado().trim().equals("finalizado")) {
	   	 	 	model.addAttribute("inf_estado", "completo");	 		
	   	 	 	}else {
	   	 	 	model.addAttribute("inf_estado",verificarInforme.getInfEstado());
	   	 	 
	   	 	 	model.addAttribute("mensaje", verificador);
	   	 	 	
				
	   	 	 	}
	   	 	}
	         return "rendicion/Frm_Finalizar_Educacion_Superior";
	    }
		
		@RequestMapping(value = "view/rendicion/verificarInformeES")
		public @ResponseBody String verificarInformeES(@RequestParam(value = "infAutCod") Integer infCod,  @RequestParam(value = "infAutPeriodo") Integer infAutPeriodo) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			String resultado="";
		
			try {
				String verificaInfAut = infor.listarEudcacionSuperior(infCod, infAutPeriodo);
				Integer contador = verificaInfAut.length();
				if (contador==65) {
					resultado ="completo";
				}else {
					resultado = verificaInfAut;
					String[] items = resultado.split("NO");
					for (String item: items) {
					
					}
				}
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			}
			return resultado;
		} 
		
		
		@SuppressWarnings("finally")
		@RequestMapping(value = "view/rendicion/FinalizarInformeES")
		public @ResponseBody String FinalizarInformeES(Authentication authentication,@RequestParam(value = "infAutCod") Integer instCod,  @RequestParam(value = "infAutPeriodo") Integer infPeriodo
				) {

			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {
				TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(instCod, infPeriodo);				
				if (verificarInforme==null){					
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "No hay informe!");
				}else {
					mensaje.put("estado", "exito");
					mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
					Date infAutFechafin = new Date();
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date fechaControl = format.parse(Constantes.FECHA_CIERRE_INFORME_EDUCACION_SUPERIOR);
					if(infAutFechafin.before(fechaControl)) {
						infor.finalizarInformeInstitucion(instCod, Constantes.ESTADO_INFORME_FINALIZADO, infAutFechafin, Constantes.ESTADO_INFORME_A_TIEMPO);	
						servicioinstitucion.actualizarInstVerificador(instCod, infPeriodo, Constantes.ESTADO_PROCESO_CUMPLIDO);

					}else
					{
						infor.finalizarInformeInstitucion(instCod, Constantes.ESTADO_INFORME_FINALIZADO, infAutFechafin, Constantes.ESTADO_INFORME_A_DESTIEMPO);
						servicioinstitucion.actualizarInstVerificador(instCod, infPeriodo, Constantes.ESTADO_PROCESO_INCUMPLIDO);

					}
					
					
					
				}
				TblInforme verificarInformeFinalizado = infor.obtenerRegistroInformeInstitucion(instCod, infPeriodo);
				
				if (verificarInformeFinalizado.getInfEstado().trim().equals(Constantes.ESTADO_INFORME_FINALIZADO)) {
					
					String periodo = String.valueOf(Constantes.periodo());
					List<TblResponables> datosResponsables = respon.buscarResponsableXcodigoInstitucion(verificarInforme.getInstCod(), periodo);
					TblInstitucion datosInstitucion = gcs.ObtenerInstitucionesXidEstado(instCod,Constantes.ESTADO, Constantes.periodo());
					for (TblResponables datos : datosResponsables) {
						if (datos.getResponEmail() != null && !datos.getResponEmail().equals("")) {
							
							ms.mailFinalziarInformeInstitucion(datos.getResponEmail(), datos.getResponNombre(), datosInstitucion.getInstRuc(),datosInstitucion.getInstNom() ,verificarInformeFinalizado.getInfFechafin(), verificarInformeFinalizado.getInfVerificador(), true);

						}

					}
					
					
				}else
				{
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "no se finalilzo el informe vuelva a intetarlo!");
				}
				
				
				
				
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}

		}
		
}