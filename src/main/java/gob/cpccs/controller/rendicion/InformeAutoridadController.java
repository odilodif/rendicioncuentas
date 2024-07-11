/*  Juan Carlos Vega Frm_Informe_RC_Autoridad.jsp */



package gob.cpccs.controller.rendicion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import gob.cpccs.controller.HomeController;
import gob.cpccs.model.catalogos.TblInstitucion;
import gob.cpccs.model.dto.rendicion.RendicionDignidadDTO;
import gob.cpccs.model.dto.rendicion.TblAmecanismosPcDTO;
import gob.cpccs.model.dto.rendicion.TblFuncionesAutoridadesDTO;
import gob.cpccs.model.dto.rendicion.TblPlanTrabajoDTO;
import gob.cpccs.model.dto.rendicion.TblPropuestasDTO;
import gob.cpccs.model.dto.rendicion.TblProyectoComunicacionalDTO;
import gob.cpccs.model.rendicion.TblAmecanismosPc;
import gob.cpccs.model.rendicion.TblCoberturaInstitucional;
import gob.cpccs.model.rendicion.TblFuncionesAutoridades;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblInformeAutoridad;
import gob.cpccs.model.rendicion.TblModalidadEstudios;
import gob.cpccs.model.rendicion.TblPlanTrabajo;
import gob.cpccs.model.rendicion.TblPresupuestoEducacion;
import gob.cpccs.model.rendicion.TblPropuestas;
import gob.cpccs.model.rendicion.TblProyectoComunicacional;
import gob.cpccs.model.rendicion.TblSede;
import gob.cpccs.model.usuario.TblAutoridad;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.repository.rendicion.FuncionesAutoridadesRepository;
import gob.cpccs.service.autoridad.AutoridadServicio;
import gob.cpccs.service.mail.EmailService;
import gob.cpccs.service.rendicion.FuncionesAutoridadesServices;
import gob.cpccs.service.rendicion.InformeServicio;
import gob.cpccs.service.rendicion.MecanismosAutoridadesService;
import gob.cpccs.service.rendicion.PlanTrabajoAutoridadService;
import gob.cpccs.service.rendicion.PropuestasAutoridadesService;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;

@Controller
public class InformeAutoridadController {
	@Autowired
    private HomeController hc;
	@Autowired
	private UsuarioServicio usu;
	@Autowired
	private InformeServicio infor;
	@Autowired
	private PlanTrabajoAutoridadService pts;
	@Autowired
	private FuncionesAutoridadesServices fas;
	@Autowired
	private PropuestasAutoridadesService pas;
	@Autowired
	private MecanismosAutoridadesService mas;
	@Autowired
	private AutoridadServicio autori;
	@Autowired
    private EmailService ms;

	@RequestMapping("/view/rendicion/Frm_Informe_RC_Autoridad")
    public String Frm_Informe_RC_Autoridad(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInformeAutoridad verificarInforme = infor.obtenerRegistroInformexIdentificador(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
		if (verificarInforme==null){
   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   			
   	 		
   	 		if(verificarInforme.getFechaRendicion()==null) {
   	 		model.addAttribute("inf_estado", verificarInforme.getInfAutEstado());
   	 		model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
   	 		
   	 		
   	 		}else {
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
	        model.addAttribute("acciones", listaAcciones);
			model.addAttribute("inf_estado", "matriz");
			model.addAttribute("infestadoinforme", verificarInforme.getInfAutEstado());
			model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
			String   fechaDesignacion = "";
			 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			 fechaDesignacion = df.format(verificarInforme.getFechaRendicion());
			model.addAttribute("inf_aut_fecha_rendicion", fechaDesignacion);
			model.addAttribute("inf_aut_lugar", verificarInforme.getLugar());
			model.addAttribute("inf_aut_numero_asistentes", verificarInforme.getNumeroAsistentes());
   	 		}
		}		
	
         return "rendicion/Frm_Informe_RC_Autoridad";
    }
	
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/actualizarInformeAutoridad")
	public @ResponseBody String guardarActualizarSedeDetalle(HttpServletRequest request,  @RequestParam("infAutCod") int infAutCod) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			TblInformeAutoridad tblInformeAutoridad = new TblInformeAutoridad();
			Date fechaRendicion2 = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fechaRendicion"));
			tblInformeAutoridad.setFechaRendicion(fechaRendicion2);
			tblInformeAutoridad.setLugar(request.getParameter("lugar").toUpperCase());
			if(Integer.parseInt(request.getParameter("numeroAsistentes")) > 0) {//controlamos que solo se guarde si ingresa mas de cero assitentes
				tblInformeAutoridad.setNumeroAsistentes(Integer.parseInt(request.getParameter("numeroAsistentes")));
			}
			infor.ActualizarInformeAutoridad(tblInformeAutoridad.getFechaRendicion(), tblInformeAutoridad.getLugar(), tblInformeAutoridad.getNumeroAsistentes(), infAutCod);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	@RequestMapping("/view/rendicion/Frm_Plan_trabajo_Autoridad")
    public String Frm_Plan_trabajo_Autoridad(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInformeAutoridad verificarInforme = infor.obtenerRegistroInformexIdentificador(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
		if (verificarInforme==null){
   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   			
   	 	List<TblPlanTrabajo> RegistrosPlanTrabajo = pts.obtenerRegistrosPlanTrabajoAutoridad(verificarInforme.getInfAutCod());
   	 		
   	 		if(RegistrosPlanTrabajo.size()==0) {
   	 			
   	 		model.addAttribute("inf_estado", verificarInforme.getInfAutEstado());
			model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
   	 			
   	 		}else {
   	 		
   	 		
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
			
			model.addAttribute("acciones", listaAcciones);
			model.addAttribute("inf_estado", "matriz");
			model.addAttribute("infestadoinforme", verificarInforme.getInfAutEstado());
			model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
			
		}		
   	 	}
         return "rendicion/Frm_Plan_trabajo_Autoridad";
    }
	
	@RequestMapping(value = "view/rendicion/Frm_Plan_trabajo_Autoridad_Nuevo",method = RequestMethod.POST)
    public String Frm_Plan_trabajo_Autoridad_Nuevo(Model model, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInformeAutoridad verificarInforme = infor.obtenerRegistroInformexIdentificador(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
   	 	model.addAttribute("inf_estado", "matriz");
		model.addAttribute("infestadoinforme", verificarInforme.getInfAutEstado());
		model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
		return "rendicion/Frm_Plan_trabajo_Autoridad_Nuevo";
    }
	
	
	
	@RequestMapping("/view/rendicion/Frm_Finalizar_Informe_Autoridad")
    public String Frm_Finalizar_Informe_Autoridad(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInformeAutoridad verificarInforme = infor.obtenerRegistroInformexIdentificador(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
   	     ArrayList matriz = new ArrayList();
		if (verificarInforme==null){
   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   	 		TblAutoridad datosAutoridad = autori.buscarAutordadCodAutPeriodo(datosUsuario.getCodigoIntitucionAutorida(), datosUsuario.getPeriodo());
   	 		Integer codigoInforme = verificarInforme.getInfAutCod();
   	 	 	String verificador = verificarInformeAutoridad(codigoInforme, Constantes.periodo());
	   	 	model.addAttribute("infestadoinforme", verificarInforme.getInfAutEstado());
			model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
			model.addAttribute("infAutPeriodo", verificarInforme.getInfAutPeriodo());
			model.addAttribute("infAutEstado", verificarInforme.getInfAutEstado());	
	   	 	model.addAttribute("nombreAutoridad", datosAutoridad.getNombre());
	   	 	model.addAttribute("identificadorAutoridad", datosAutoridad.getIdentificador());
	   	 	model.addAttribute("institucionDignidad", datosAutoridad.getInstitucionDignidad());
	   	 	model.addAttribute("dignidad", datosAutoridad.getDignidad());
	   	    model.addAttribute("ambito", datosAutoridad.getAmbito());
	   	    model.addAttribute("periodo", datosAutoridad.getPeriodo());
   	 	 	if(verificador.equals("completo") && !verificarInforme.getInfAutEstado().trim().equals("finalizado")) {
   	 	 	model.addAttribute("inf_estado", "completo");	 		
   	 	 	}else {
   	 	 	model.addAttribute("inf_estado",verificarInforme.getInfAutEstado());
   	 	 
   	 	 	model.addAttribute("mensaje", verificador);
   	 	 	
			
   	 	 	}
   	 	}
         return "rendicion/Frm_Finalizar_Informe_Autoridad";
    }
	
	@RequestMapping(value = "view/rendicion/verificarInformeAutoridad")
	public @ResponseBody String verificarInformeAutoridad(@RequestParam(value = "infAutCod") Integer infAutCod,  @RequestParam(value = "infAutPeriodo") Integer infAutPeriodo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		String resultado="";
	
		try {
			String verificaInfAut = infor.listar(infAutCod, infAutPeriodo);
			Integer contador = verificaInfAut.length();
			if (contador==20) {
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
	@RequestMapping(value = "view/rendicion/FinalizarInformeAutoridad")
	public @ResponseBody String FinalizarInformeAutoridad(Authentication authentication,@RequestParam(value = "infAutCod") Integer infAutCod,  @RequestParam(value = "infAutPeriodo") Integer infAutPeriodo
			) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			TblInformeAutoridad verificarInforme = infor.obtenerRegistroInformeAutCod(infAutCod,infAutPeriodo );
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblAutoridad datosAutoridad = autori.buscarAutordadCodAutPeriodo(datosUsuario.getCodigoIntitucionAutorida(), datosUsuario.getPeriodo());
			String tipo = "AutoridadFinInformeRC";
			if (verificarInforme==null) {
				
				mensaje.put("estado", "error");
				mensaje.put("mensaje", "No hay informe!");
			}else {
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
				Date infAutFechafin = new Date();
				DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				if(datosAutoridad.getDignidad().equals("ASAMBLEÍSTA NACIONAL")||datosAutoridad.getDignidad().equals("ASAMBLEÍSTA PROVINCIAL")||datosAutoridad.getDignidad().equals("ASAMBLEÍSTA POR CIRCUNSCRIPCIÓN TERRITORIAL")||datosAutoridad.getDignidad().equals("ASAMBLEÍSTA REPRESENTANTE EXTRANJERO")||datosAutoridad.getDignidad().equals("PARLAMENTARIA / PARLAMENTARIO ANDINO")||datosAutoridad.getDignidad().equals("CONSEJERA/ CONSEJERO DEL CPCCS")||datosAutoridad.getDignidad().equals("PRESIDENTE DE LA REPÚBLICA")||datosAutoridad.getDignidad().equals("VICEPRESIDENTE DE LA REPÚBLICA")) {
					Date fechaControl = format.parse(Constantes.FECHA_CIERRE_INFORME_AUTORIDAD_ASAMBLEISTA);
						if(infAutFechafin.before(fechaControl)) {
							infor.finalizarInforme(infAutCod, Constantes.ESTADO_INFORME_FINALIZADO, infAutFechafin, Constantes.ESTADO_INFORME_A_TIEMPO);
							autori.actualizarAutoridadVerificador(verificarInforme.getIdentificador(), Constantes.periodo(), Constantes.ESTADO_PROCESO_CUMPLIDO);
						}else{					
							infor.finalizarInforme(infAutCod, Constantes.ESTADO_INFORME_FINALIZADO, infAutFechafin, Constantes.ESTADO_INFORME_A_DESTIEMPO);
							autori.actualizarAutoridadVerificador(verificarInforme.getIdentificador(), Constantes.periodo(), Constantes.ESTADO_PROCESO_INCUMPLIDO);

						}
				}else {
					
					Date fechaControl = format.parse(Constantes.FECHA_CIERRE_INFORME_AUTORIDAD);
					if(infAutFechafin.before(fechaControl)) {
						infor.finalizarInforme(infAutCod, Constantes.ESTADO_INFORME_FINALIZADO, infAutFechafin, Constantes.ESTADO_INFORME_A_TIEMPO);
						autori.actualizarAutoridadVerificador(verificarInforme.getIdentificador(), Constantes.periodo(), Constantes.ESTADO_PROCESO_CUMPLIDO);
					}else{					
						infor.finalizarInforme(infAutCod, Constantes.ESTADO_INFORME_FINALIZADO, infAutFechafin, Constantes.ESTADO_INFORME_A_DESTIEMPO);
						autori.actualizarAutoridadVerificador(verificarInforme.getIdentificador(), Constantes.periodo(), Constantes.ESTADO_PROCESO_INCUMPLIDO);

					}
				}
			}
			TblInformeAutoridad verificarInformeFinalizado = infor.obtenerRegistroInformeAutCod(infAutCod,infAutPeriodo );

			if (verificarInformeFinalizado.getInfAutEstado().trim().equals(Constantes.ESTADO_INFORME_FINALIZADO)) {
				
				ms.mailFinalziarInforme(datosUsuario.getEmail(), datosUsuario.getNombre(), datosUsuario.getIdentificador(), verificarInformeFinalizado.getInfAutFechafin(), verificarInformeFinalizado.getInfAutVerificador(), tipo, true);
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
	
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarPlanTrabajo")
	public @ResponseBody String guardarPlanTrabajo(HttpServletRequest request,  @RequestParam(value = "infAutCod") Integer infAutCod
			) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			
			TblPlanTrabajo tblPlanTrabajo = new TblPlanTrabajo();
			TblInformeAutoridad tblInformeAutoridad = infor.obtenerRegistroInformeAutCod(infAutCod,  Constantes.periodo());        
			tblPlanTrabajo.setInfAutCod(tblInformeAutoridad);
			tblPlanTrabajo.setPltPlan(request.getParameter("pltPlan").toUpperCase());
			tblPlanTrabajo.setPtlAcciones(request.getParameter("ptlAcciones").toUpperCase()); 
			tblPlanTrabajo.setPtlResultados(request.getParameter("ptlResultados").toUpperCase()); 
			tblPlanTrabajo.setPtlObs(request.getParameter("ptlObs").toUpperCase()); 
			pts.guardarPlanTrabajo(tblPlanTrabajo);

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	@RequestMapping(value = {"/obtenerPlanTrabajo"}, method = RequestMethod.POST)
	@ResponseBody 
	public String obtenerPlanTrabajo(Authentication authentication,@Param(value = "infAutCod") Integer infAutCod) {
		 String json = "";
         ObjectMapper mapper = new ObjectMapper();
         List<TblPlanTrabajoDTO> listaTblPlanTrabajoDTO = new ArrayList<>();
     	try {
     		List<TblPlanTrabajo> RegistrosPlanTrabajo = pts.obtenerRegistrosPlanTrabajoAutoridad(infAutCod);

     		listaTblPlanTrabajoDTO = RegistrosPlanTrabajo.stream()
					.map(obj -> TblPlanTrabajoDTO.builder()
									.pltCod(obj.getPltCod())
									.contador(RegistrosPlanTrabajo.indexOf(obj) + 1)
									.pltPlan(obj.getPltPlan())
									.ptlAcciones(obj.getPtlAcciones())
									.ptlResultados(obj.getPtlResultados())
									.ptlObs(obj.getPtlObs())
							.build())
					.collect(Collectors.toList());
		
			
			json = (!listaTblPlanTrabajoDTO.isEmpty())
					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(listaTblPlanTrabajoDTO) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";
		}
		 return json;
	} 
	
	
	@RequestMapping("/view/rendicion/Frm_CumplimientoFunciones_Autoridad")
    public String Frm_CumplimientoFunciones_Autoridad(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInformeAutoridad verificarInforme = infor.obtenerRegistroInformexIdentificador(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
		if (verificarInforme==null){
   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   			
   	 	List<TblFuncionesAutoridades> RegistrosFuncionesAutoridades =  fas.obtenerRegistrosFuncionesAutoridades(verificarInforme.getInfAutCod()); 
   	 		
   	 	
   	 	if(RegistrosFuncionesAutoridades.size()==0) {
   	 			
   	 		model.addAttribute("inf_estado", verificarInforme.getInfAutEstado());
			model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
   	 			
   	 		}else {
   	 		
   	 		
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
	        model.addAttribute("acciones", listaAcciones);
			model.addAttribute("inf_estado", "matriz");
			model.addAttribute("infestadoinforme", verificarInforme.getInfAutEstado());
			model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
		}		
   	 	}
         return "rendicion/Frm_CumplimientoFunciones_Autoridad";
    }
	
	
		@RequestMapping(value = "view/rendicion/Frm_CumplimientoFunciones_Autoridad_Nuevo",method = RequestMethod.POST)
    public String Frm_CumplimientoFunciones_Autoridad_Nuevo(Model model, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInformeAutoridad verificarInforme = infor.obtenerRegistroInformexIdentificador(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
   	 	model.addAttribute("inf_estado", "matriz");
		model.addAttribute("infestadoinforme", verificarInforme.getInfAutEstado());
		model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
		return "rendicion/Frm_CumplimientoFunciones_Autoridad_Nuevo";
    }
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarFuncionesAutoridades")
	public @ResponseBody String guardarFuncionesAutoridades(HttpServletRequest request,  @RequestParam(value = "infAutCod") Integer infAutCod
			) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			
			TblFuncionesAutoridades tblFuncionesAutoridades = new TblFuncionesAutoridades();
			TblInformeAutoridad tblInformeAutoridad = infor.obtenerRegistroInformeAutCod(infAutCod,  Constantes.periodo());        
			tblFuncionesAutoridades.setInfAutCod(tblInformeAutoridad);
			tblFuncionesAutoridades.setFaFuncion(request.getParameter("faFuncion").toUpperCase());
			tblFuncionesAutoridades.setFaAcciones(request.getParameter("faAcciones").toUpperCase());
			tblFuncionesAutoridades.setFaResultado(request.getParameter("faResultado").toUpperCase());
			tblFuncionesAutoridades.setFaObs(request.getParameter("faObs").toUpperCase());
			fas.guardarFuncionesAutoridades(tblFuncionesAutoridades);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	@RequestMapping(value = {"/obtenerFuncionesAutoridades"}, method = RequestMethod.POST)
	@ResponseBody 
	public String obtenerFuncionesAutoridades(Authentication authentication,@Param(value = "infAutCod") Integer infAutCod) {
		String json = "";
        ObjectMapper mapper = new ObjectMapper();
        List<TblFuncionesAutoridadesDTO> listaTblFuncionesAutoridadesDTO = new ArrayList<>();
    	try {
    		List<TblFuncionesAutoridades> RegistrosFuncionesAutoridades =  fas.obtenerRegistrosFuncionesAutoridades(infAutCod); 
			
    		listaTblFuncionesAutoridadesDTO = RegistrosFuncionesAutoridades.stream()
					.map(obj -> TblFuncionesAutoridadesDTO.builder()
									.fa_cod(obj.getFaCod())
									.contador(RegistrosFuncionesAutoridades.indexOf(obj) + 1)
									.funcion(obj.getFaFuncion())
									.accion(obj.getFaAcciones())
									.resultado(obj.getFaResultado())
									.observacion(obj.getFaObs())
							.build())
					.collect(Collectors.toList());
		
			
			json = (!listaTblFuncionesAutoridadesDTO.isEmpty())
					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(listaTblFuncionesAutoridadesDTO) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";
		}
		 return json;
	} 
	
	@RequestMapping("/view/rendicion/Frm_Obligaciones_Autoridad")
    public String Frm_Obligaciones_Autoridad(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInformeAutoridad verificarInforme = infor.obtenerRegistroInformexIdentificador(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
		if (verificarInforme==null){
   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   			
   	 	if ( verificarInforme.getInfAutTributo().trim().equals("VACIO")) {
   	 		
   	 		model.addAttribute("inf_estado", verificarInforme.getInfAutEstado());
   	 		model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
   	 		
   	 	}else {
   	 		
   	 		List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
	        model.addAttribute("acciones", listaAcciones);
			model.addAttribute("inf_estado", "matriz");
			model.addAttribute("infestadoinforme", verificarInforme.getInfAutEstado());
			model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
			model.addAttribute("inf_aut_tributo", verificarInforme.getInfAutTributo());
			model.addAttribute("inf_aut_medio_tributario", verificarInforme.getInfAutMedioTributario());
   	 	}
		}		
	
         return "rendicion/Frm_Obligaciones_Autoridad";
    }
	
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarObligacionesAutoridad")
	public @ResponseBody String guardarObligacionesAutoridad(HttpServletRequest request,  @RequestParam("infAutCod") int infAutCod) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			TblInformeAutoridad tblInformeAutoridad = new TblInformeAutoridad();
			tblInformeAutoridad.setInfAutTributo(request.getParameter("infAutTributo"));
			if(tblInformeAutoridad.getInfAutTributo().equals("SI")) {
				tblInformeAutoridad.setInfAutMedioTributario(request.getParameter("infAutMedioTributario"));
			}else {
				
				tblInformeAutoridad.setInfAutMedioTributario("S/N");
			}
			
			infor.ActualizarInformeObligaciones(tblInformeAutoridad.getInfAutTributo(), tblInformeAutoridad.getInfAutMedioTributario(), infAutCod);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}
	
	
	
	
	@RequestMapping("/view/rendicion/Frm_Propuestas_Autoridad")
    public String Frm_Propuestas_Autoridad(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInformeAutoridad verificarInforme = infor.obtenerRegistroInformexIdentificador(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
		if (verificarInforme==null){
   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   			
   	 	List<TblPropuestas> RegistrosPropuestasAutoridad = pas.obtenerRegistrosPropuestasAutoridades(verificarInforme.getInfAutCod());
   	 	
   	 	if(RegistrosPropuestasAutoridad.size()==0) {
   	 			
   	 		model.addAttribute("inf_estado", verificarInforme.getInfAutEstado());
			model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
   	 			
   	 		}else {
   	 		
   	 		
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
	        model.addAttribute("acciones", listaAcciones);
			model.addAttribute("inf_estado", "matriz");
			model.addAttribute("infestadoinforme", verificarInforme.getInfAutEstado());
			model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
		}		
   	 	}
         return "rendicion/Frm_Propuestas_Autoridad";
    }
	
	
		@RequestMapping(value = "view/rendicion/Frm_Propuestas_Autoridad_Nuevo",method = RequestMethod.POST)
    public String Frm_Propuestas_Autoridad_Nuevo(Model model, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInformeAutoridad verificarInforme = infor.obtenerRegistroInformexIdentificador(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
   	 	model.addAttribute("inf_estado", "matriz");
		model.addAttribute("infestadoinforme", verificarInforme.getInfAutEstado());
		model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
		return "rendicion/Frm_Propuestas_Autoridad_Nuevo";
    }
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarPropuestasAutoridad")
	public @ResponseBody String guardarPropuestasAutoridad(HttpServletRequest request,  @RequestParam(value = "infAutCod") Integer infAutCod
			) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			
			TblPropuestas tblPropuestas = new TblPropuestas();
			TblInformeAutoridad tblInformeAutoridad = infor.obtenerRegistroInformeAutCod(infAutCod,  Constantes.periodo());        
			tblPropuestas.setInfAutCod(tblInformeAutoridad);
			tblPropuestas.setProDescripcion(request.getParameter("proDescripcion").toUpperCase());
			tblPropuestas.setProResultados(request.getParameter("proResultados").toUpperCase());
			pas.guardarPropuestasAutoridades(tblPropuestas);;
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	
	
	
	@RequestMapping(value = {"/obtenerPropuestasAutoridad"}, method = RequestMethod.POST)
	@ResponseBody 
	public String obtenerPropuestasAutoridad(Authentication authentication,@Param(value = "infAutCod") Integer infAutCod) {
		String json = "";
        ObjectMapper mapper = new ObjectMapper();
        List<TblPropuestasDTO> listaTblPropuestasDTO = new ArrayList<>();
    	try {
    		List<TblPropuestas> RegistrosPropuestasAutoridad = pas.obtenerRegistrosPropuestasAutoridades(infAutCod); 
			
    		listaTblPropuestasDTO = RegistrosPropuestasAutoridad.stream()
					.map(obj -> TblPropuestasDTO.builder()
								.pro_id(obj.getProId())
								.contador(RegistrosPropuestasAutoridad.lastIndexOf(obj)+1)
								.descripcion(obj.getProDescripcion())
								.resultado(obj.getProResultados())
							.build())
					.collect(Collectors.toList());
		
			
			json = (!listaTblPropuestasDTO.isEmpty())
					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(listaTblPropuestasDTO) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";
		}
		 return json;
	} 
	
	
	@RequestMapping("/view/rendicion/Frm_Mecanismos_Autoridades")
    public String Frm_Mecanismos_Autoridades(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInformeAutoridad verificarInforme = infor.obtenerRegistroInformexIdentificador(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
		if (verificarInforme==null){
   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   	 	List<TblAmecanismosPc> RegistrosMecanismosAutoridades = mas.obtenerRegistrosMecanismosAutoridades(verificarInforme.getInfAutCod());
   	 	if(RegistrosMecanismosAutoridades.size()==0) {
   	 		model.addAttribute("inf_estado", verificarInforme.getInfAutEstado());
			model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
   	 		}else {
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
	        model.addAttribute("acciones", listaAcciones);
			model.addAttribute("inf_estado", "matriz");
			model.addAttribute("infestadoinforme", verificarInforme.getInfAutEstado());
			model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
		}		
   	 	}
         return "rendicion/Frm_Mecanismos_Autoridades";
    }
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarAmecanismosPc")
	public @ResponseBody String guardarAmecanismosPc(HttpServletRequest request,  @RequestParam(value = "infAutCod") Integer infAutCod
			) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			
			
			TblInformeAutoridad tblInformeAutoridad = infor.obtenerRegistroInformeAutCod(infAutCod,  Constantes.periodo());        
			TblAmecanismosPc tblAmecanismosPc = new TblAmecanismosPc();
			tblAmecanismosPc.setInfAutCod(tblInformeAutoridad);
			tblAmecanismosPc.setAmeDesc(request.getParameter("ameDesc1"));
			tblAmecanismosPc.setAmeMedio(request.getParameter("ameMedio1"));			
			tblAmecanismosPc.setAmeTipo("ASAMBLEA LOCAL");
			mas.guardarMecanismosAutoridades(tblAmecanismosPc);
			
			TblAmecanismosPc tblAmecanismosPc2 = new TblAmecanismosPc();
			tblAmecanismosPc2.setInfAutCod(tblInformeAutoridad);
			tblAmecanismosPc2.setAmeDesc(request.getParameter("ameDesc2"));
			tblAmecanismosPc2.setAmeMedio(request.getParameter("ameMedio2"));			
			tblAmecanismosPc2.setAmeTipo("AUDIENCIA PÚBLICA");
			mas.guardarMecanismosAutoridades(tblAmecanismosPc2);
			
			TblAmecanismosPc tblAmecanismosPc3 = new TblAmecanismosPc();
			tblAmecanismosPc3.setInfAutCod(tblInformeAutoridad);
			tblAmecanismosPc3.setAmeDesc(request.getParameter("ameDesc3"));
			tblAmecanismosPc3.setAmeMedio(request.getParameter("ameMedio3"));			
			tblAmecanismosPc3.setAmeTipo("CABILDO POPULAR");
			mas.guardarMecanismosAutoridades(tblAmecanismosPc3);
			
			TblAmecanismosPc tblAmecanismosPc4 = new TblAmecanismosPc();
			tblAmecanismosPc4.setInfAutCod(tblInformeAutoridad);
			tblAmecanismosPc4.setAmeDesc(request.getParameter("ameDesc4"));
			tblAmecanismosPc4.setAmeMedio(request.getParameter("ameMedio4"));			
			tblAmecanismosPc4.setAmeTipo("CONSEJO DE PLANIFICACIÓN LOCAL");
			mas.guardarMecanismosAutoridades(tblAmecanismosPc4);
			
			TblAmecanismosPc tblAmecanismosPc5 = new TblAmecanismosPc();
			tblAmecanismosPc5.setInfAutCod(tblInformeAutoridad);
			tblAmecanismosPc5.setAmeDesc(request.getParameter("ameDesc5"));
			tblAmecanismosPc5.setAmeMedio(request.getParameter("ameMedio5"));			
			tblAmecanismosPc5.setAmeTipo("OTROS");
			mas.guardarMecanismosAutoridades(tblAmecanismosPc5);
			
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}
	
	@RequestMapping(value = {"/obtenerTablaAmecanismosPc"}, method = RequestMethod.POST)
	@ResponseBody 
	public String obtenerTablaAmecanismosPc(Authentication authentication,@Param(value = "infAutCod") Integer infAutCod) {
		String json = "";
        ObjectMapper mapper = new ObjectMapper();
        List<TblAmecanismosPcDTO> listaTblAmecanismosPcDTO = new ArrayList<>();
    	try {
    		List<TblAmecanismosPc> RegistrosMecanismosAutoridades = mas.obtenerRegistrosMecanismosAutoridades(infAutCod); 
			
    		listaTblAmecanismosPcDTO = RegistrosMecanismosAutoridades.stream()
					.map(obj -> TblAmecanismosPcDTO.builder()
							.ame_cod(obj.getAmeCod())
							.contador(RegistrosMecanismosAutoridades.indexOf(obj)+1)
							.tipo(obj.getAmeTipo())
							.descripcion(obj.getAmeDesc())
							.medio(obj.getAmeMedio())
						.build())
					.collect(Collectors.toList());
		
			
			json = (!listaTblAmecanismosPcDTO.isEmpty())
					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(listaTblAmecanismosPcDTO) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";
		}
		 return json;
	} 
	
	
	@RequestMapping("/view/rendicion/Frm_Rendicion_Autoridad")
    public String Frm_Rendicion_Autoridad(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		RendicionDignidadDTO listaRendicionAutoridad = new RendicionDignidadDTO();
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInformeAutoridad verificarInforme = infor.obtenerRegistroInformexIdentificador(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
           
   	 	if (verificarInforme==null){
   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   			
   	 		
   	 		if(verificarInforme.getInaProcesoRc().trim().equals("VACIO")) {
   	 		model.addAttribute("inf_estado", verificarInforme.getInfAutEstado());
   	 		model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
   	 		
   	 		
   	 		}else {
   	 		listaRendicionAutoridad.setInfAutCod(verificarInforme.getInfAutCod());
   	 	    listaRendicionAutoridad.setProceso(verificarInforme.getInaProcesoRc().toString());
   	 		List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
	        model.addAttribute("acciones", listaAcciones);
			model.addAttribute("inf_estado", "matriz");
			model.addAttribute("infestadoinforme", verificarInforme.getInfAutEstado());
			model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
			model.addAttribute("ina_proceso_rc",listaRendicionAutoridad.getProceso().toString().replaceAll(Constantes.CADENA1," ").replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3,Constantes.REMPLAZO3).replaceAll(Constantes.CADENA4,Constantes.REMPLAZO4));
   	 	 }
		}		
	
         return "rendicion/Frm_Rendicion_Autoridad";
    }
	
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/actualizarInformeAutoridadRC")
	public @ResponseBody String guardarActualizarRendicionAutoridad(HttpServletRequest request,  @RequestParam("infAutCod") int infAutCod) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			TblInformeAutoridad tblInformeAutoridad = new TblInformeAutoridad();
			tblInformeAutoridad.setInaProcesoRc(request.getParameter("inaProcesoRc").toUpperCase());
			infor.ActualizarInformeRendicion( tblInformeAutoridad.getInaProcesoRc().replaceAll(System.getProperty("line.separator"), " "),  infAutCod);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	
	@RequestMapping("/view/rendicion/Frm_Aportes_Ciudadanos_Autoridad")
    public String Frm_Aportes_Ciudadanos_Autoridad(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInformeAutoridad verificarInforme = infor.obtenerRegistroInformexIdentificador(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
		if (verificarInforme==null){
   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   			
   	 		
   	 		if(verificarInforme.getInaAportesCiu().trim().equals("VACIO")) {
   	 		model.addAttribute("inf_estado", verificarInforme.getInfAutEstado());
   	 		model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
   	 		
   	 		
   	 		}else {
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
	        model.addAttribute("acciones", listaAcciones);
			model.addAttribute("inf_estado", "matriz");
			model.addAttribute("infestadoinforme", verificarInforme.getInfAutEstado());
			model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
			model.addAttribute("ina_aportes_ciu", verificarInforme.getInaAportesCiu().toString().replaceAll(Constantes.CADENA1," ").replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3,Constantes.REMPLAZO3).replaceAll(Constantes.CADENA4,Constantes.REMPLAZO4));
   	 		}
		}		
	
         return "rendicion/Frm_Aportes_Ciudadanos_Autoridad";
    }
	
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/actualizarInformeAutoridadAporte")
	public @ResponseBody String guardarActualizarAportesCiudadanosAutoridad(HttpServletRequest request,  @RequestParam("infAutCod") int infAutCod) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			TblInformeAutoridad tblInformeAutoridad = new TblInformeAutoridad();
			tblInformeAutoridad.setInaAportesCiu(request.getParameter("inaAportesCiu").toUpperCase());
			infor.ActualizarInformeAportes(tblInformeAutoridad.getInaAportesCiu().replaceAll(System.getProperty("line.separator"), " "), infAutCod);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	  @RequestMapping(value = {"/view/rendicion/ImprimirAutoridad"}, method = RequestMethod.POST)
	     public String ImprimirAutoridad(Authentication authentication,Model model, HttpServletRequest request,HttpServletResponse response,@RequestParam("infocod") int infocod) {
			String Autoridades="Autoridades";
		   TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
	   	 	TblInformeAutoridad informeAutoridad = infor.obtenerRegistroInformexIdentificador(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
			model.addAttribute("rutaPDF",Constantes.URL_SERVIDOR_REPORTES+Autoridades+"&Codigo="+informeAutoridad.getInfAutCod()+"&anio="+Constantes.periodo());
			return "rendicion/generarReportePDF";
		}
}