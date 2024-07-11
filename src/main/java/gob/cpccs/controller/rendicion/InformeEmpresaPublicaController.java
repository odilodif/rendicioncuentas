package gob.cpccs.controller.rendicion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

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

import gob.cpccs.service.catalogos.CatalogosServicio;
import gob.cpccs.service.catalogos.InstitucionServicio;
import gob.cpccs.service.mail.EmailService;
import gob.cpccs.controller.HomeController;
import gob.cpccs.model.catalogos.TblInstitucion;
import gob.cpccs.model.dto.rendicion.PlanificacionEjecucionGADDTO;
import gob.cpccs.model.dto.rendicion.PoliticasIgualdadGADDTO;
import gob.cpccs.model.dto.rendicion.PresupuestoInstitucionalFDEDTO;
import gob.cpccs.model.dto.rendicion.ProcesoRendicionCuentasIESDTO;
import gob.cpccs.model.dto.rendicion.SedesExtensionesIESDTO;
import gob.cpccs.model.rendicion.TblCoberturaNacional;
import gob.cpccs.model.rendicion.TblDetalleEjecucionp;
import gob.cpccs.model.rendicion.TblEjecucionProgramatica;
import gob.cpccs.model.rendicion.TblFuncionesObjetivos;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblMecanismoRendicionCuentas;
import gob.cpccs.model.rendicion.TblObjetivosPlanDesarrollo;
import gob.cpccs.model.usuario.TblResponables;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.service.rendicion.ActualizarDetallePoaService;
import gob.cpccs.service.rendicion.InformeServicio;
import gob.cpccs.service.rendicion.RendicionCuentasGadService;
import gob.cpccs.service.usuario.ResponsableServicio;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;

@Controller
public class InformeEmpresaPublicaController {

	
	@Autowired
    private HomeController hc;
	@Autowired
	private UsuarioServicio usu;
	@Autowired
	private InformeServicio infor;
	@Autowired
    private RendicionCuentasGadService RendiCuent;
	@Autowired
	private InformeServicio is;
	@Autowired
	private CatalogosServicio gcs;
	@Autowired
    private EmailService ms;
	@Autowired
	private ResponsableServicio respon;
	@Autowired
	private InstitucionServicio servicioinstitucion;
	@Autowired
	private ActualizarDetallePoaService adps;
	
	@RequestMapping("/view/rendicion/Frm_Fases_RendicionCuentas")
	public String Frm_Fases_RendicionCuentas(Model model, @RequestParam("opcion") int idMenu,
		Authentication authentication) {
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
		 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){			model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);
			} 
		else{
			List<TblMecanismoRendicionCuentas> listaRendicionCuentas=RendiCuent.ObtenerRegistrosXInfoCod(verificarInforme.getInfCod());
		   if(listaRendicionCuentas.size() ==0) {
				model.addAttribute("inf_estado", verificarInforme.getInfEstado());
				model.addAttribute("inf_Cod", verificarInforme.getInfCod());
			}
			else {
						model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_MATRIZ);
						model.addAttribute("inf_Cod", verificarInforme.getInfCod());
						model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			}		
		}
		return "rendicion/Frm_Fases_RendicionCuentas";
	}	
	
	@RequestMapping(value = "/view/rendicion/Frm_RendicionCuentasFaseAportes",method = RequestMethod.POST)
	public String Frm_RendicionCuentasFaseAportes(Model model,Authentication authentication, @RequestParam("id") Integer id) {	
		TblMecanismoRendicionCuentas verificarRendicionCuentas=RendiCuent.ObtenerRegistroendicionCuentas(id);

			if(verificarRendicionCuentas !=null) {	
				model.addAttribute("mecanismo_cod",verificarRendicionCuentas.getMecanismoCod());
				model.addAttribute("mecanismo_fase",verificarRendicionCuentas.getMecanismoFase());
				model.addAttribute("mecanismo_nombre", verificarRendicionCuentas.getMecanismoNombre().toString().replaceAll(Constantes.CADENA1,Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3,Constantes.REMPLAZO3).replaceAll(Constantes.CADENA4,Constantes.REMPLAZO4).replaceAll(Constantes.CADENA4,Constantes.REMPLAZO4));
				
				}
		
		return "rendicion/Frm_RendicionCuentasFaseAportes";
	}
	
	
	@RequestMapping(value = "/view/rendicion/Frm_RendicionCuentasFasesActualizar",method = RequestMethod.POST)
	public String Frm_RendicionCuentasFasesActualizar(Model model,Authentication authentication, @RequestParam("id") Integer id) {	
		TblMecanismoRendicionCuentas verificarRendicionCuentas=RendiCuent.ObtenerRegistroendicionCuentas(id);

			if(verificarRendicionCuentas !=null) {	
				model.addAttribute("mecanismo_cod",verificarRendicionCuentas.getMecanismoCod());
				model.addAttribute("mecanismo_fase",verificarRendicionCuentas.getMecanismoFase());
				model.addAttribute("mecanismo_nombre", verificarRendicionCuentas.getMecanismoNombre());
				model.addAttribute("mecanismo_implementado", verificarRendicionCuentas.getMecanismoImplementado());
				model.addAttribute("mecanismo_ejecucion", verificarRendicionCuentas.getMecanismoEjecucion().toString().replaceAll(Constantes.CADENA1,Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3,Constantes.REMPLAZO3).replaceAll(Constantes.CADENA4,Constantes.REMPLAZO4).replaceAll(Constantes.CADENA4,Constantes.REMPLAZO4));					
				model.addAttribute("mecanismo_medioverifica", verificarRendicionCuentas.getMecanismoMedioverifica());
				
				}
		
		return "rendicion/Frm_RendicionCuentasFasesActualizar";
	}
	
	 private List<TblMecanismoRendicionCuentas> lista_RendicionCuentas=new ArrayList<TblMecanismoRendicionCuentas>();
	 
	 private void GuardarRendicionCuentas(TblInforme tblInforme,String fase,String rc, String seleccion,String descripcion, String link) {
			TblMecanismoRendicionCuentas tblMecanismoRendicionCuentas= new TblMecanismoRendicionCuentas();
			tblMecanismoRendicionCuentas.setInfCod(tblInforme);
			tblMecanismoRendicionCuentas.setMecanismoFase(fase);			
			tblMecanismoRendicionCuentas.setMecanismoNombre(rc);
			tblMecanismoRendicionCuentas.setMecanismoImplementado(seleccion);	
			tblMecanismoRendicionCuentas.setMecanismoEjecucion(descripcion);
			tblMecanismoRendicionCuentas.setMecanismoMedioverifica(link);
			tblMecanismoRendicionCuentas.setMecanismoObservacion("Ninguna");
			tblMecanismoRendicionCuentas.setMecanismoTipo("RENDICION DE CUENTAS");
	        tblMecanismoRendicionCuentas.setMecanismoEstado(Constantes.ESTADO);
			lista_RendicionCuentas.add(tblMecanismoRendicionCuentas);
			
		}
	
	 
	 @SuppressWarnings("finally")
		@RequestMapping(value = "view/rendicion/GuardarFaseAportes")
		public @ResponseBody String guardarRendiconCuentasFase2(HttpServletRequest request,	@RequestParam(value = "infCod") Integer inf_Cod ) {
	 
		 	JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {
				
			
			
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}
		}
		
		 
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarFasesRendicionCuentas")
	public @ResponseBody String guardarRendiconCuentasFase2(
			HttpServletRequest request,
			@RequestParam(value = "infCod") Integer inf_Cod,	
			@RequestParam(value = "fase0") String fase0,
			@RequestParam(value = "rc1") String rc1,
			@RequestParam(value = "seleccion1") String seleccion1,			
			@RequestParam(value = "descripcion1", required = false) String descripcion1,
			@RequestParam(value = "link1", required = false) String link1,
			@RequestParam(value = "rc2") String rc2,
			@RequestParam(value = "seleccion2") String seleccion2,			
			@RequestParam(value = "descripcion2", required = false) String descripcion2,
			@RequestParam(value = "link2", required = false) String link2,
			@RequestParam(value = "fase1") String fase1,
			@RequestParam(value = "rc3") String rc3,
			@RequestParam(value = "seleccion3") String seleccion3,			
			@RequestParam(value = "descripcion3", required = false) String descripcion3,
			@RequestParam(value = "link3", required = false) String link3,
			@RequestParam(value = "rc4") String rc4,
			@RequestParam(value = "seleccion4") String seleccion4,			
			@RequestParam(value = "descripcion4", required = false) String descripcion4,
			@RequestParam(value = "link4", required = false) String link4,
			@RequestParam(value = "rc5") String rc5,
			@RequestParam(value = "seleccion5") String seleccion5,			
			@RequestParam(value = "descripcion5", required = false) String descripcion5,
			@RequestParam(value = "link5", required = false) String link5,
			@RequestParam(value = "rc6") String rc6,
			@RequestParam(value = "seleccion6") String seleccion6,			
			@RequestParam(value = "descripcion6", required = false) String descripcion6,
			@RequestParam(value = "link6", required = false) String link6,
			@RequestParam(value = "fase2") String fase2,
			@RequestParam(value = "rc7") String rc7,
			@RequestParam(value = "seleccion7") String seleccion7,			
			@RequestParam(value = "descripcion7", required = false) String descripcion7,
			@RequestParam(value = "link7", required = false) String link7,
			@RequestParam(value = "rc8") String rc8,
			@RequestParam(value = "seleccion8") String seleccion8,			
			@RequestParam(value = "descripcion8", required = false) String descripcion8,
			@RequestParam(value = "link8", required = false) String link8,
			@RequestParam(value = "rc9") String rc9,
			@RequestParam(value = "seleccion9") String seleccion9,			
			@RequestParam(value = "descripcion9", required = false) String descripcion9,
			@RequestParam(value = "link9", required = false) String link9,
			@RequestParam(value = "rc10") String rc10,
			@RequestParam(value = "seleccion10") String seleccion10,			
			@RequestParam(value = "descripcion10", required = false) String descripcion10,
			@RequestParam(value = "link10", required = false) String link10,
			@RequestParam(value = "rc11") String rc11,
			@RequestParam(value = "seleccion11") String seleccion11,			
			@RequestParam(value = "descripcion11", required = false) String descripcion11,
			@RequestParam(value = "link11", required = false) String link11,
			@RequestParam(value = "fase3") String fase3,
			@RequestParam(value = "rc12") String rc12,
			@RequestParam(value = "seleccion12") String seleccion12,			
			@RequestParam(value = "descripcion12", required = false) String descripcion12,
			@RequestParam(value = "link12", required = false) String link12,
			@RequestParam(value = "describaAporte", required = false) String describaAporte,
			@RequestParam(value = "describa", required = false) String describa
			) {
         
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {	
			TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());	
		    lista_RendicionCuentas.clear();
		    GuardarRendicionCuentas(tblInforme, fase0, rc1, seleccion1, descripcion1, link1);
		    GuardarRendicionCuentas(tblInforme, fase0, rc2, seleccion2, descripcion2, link2);
			GuardarRendicionCuentas(tblInforme, fase1, rc3, seleccion3, descripcion3, link3);
			GuardarRendicionCuentas(tblInforme, fase1, rc4, seleccion4, descripcion4, link4);
			GuardarRendicionCuentas(tblInforme, fase1, rc5, seleccion5, descripcion5, link5);
		    GuardarRendicionCuentas(tblInforme, fase1, rc6, seleccion6, descripcion6, link6);
		    GuardarRendicionCuentas(tblInforme, fase2, rc7, seleccion7, descripcion7, link7);
			GuardarRendicionCuentas(tblInforme, fase2, rc8, seleccion8, descripcion8, link8);
			GuardarRendicionCuentas(tblInforme, fase2, rc9, seleccion9, descripcion9, link9);
			GuardarRendicionCuentas(tblInforme, fase2, rc10, seleccion10, descripcion10, link10);
			GuardarRendicionCuentas(tblInforme, fase2, rc11, seleccion11, descripcion11, link11);
			GuardarRendicionCuentas(tblInforme, fase3, rc12, seleccion12, descripcion12, link12);
			if (lista_RendicionCuentas.size()==12) {	
			for (TblMecanismoRendicionCuentas item : lista_RendicionCuentas) {	
				Integer valor =RendiCuent.CountMRC(inf_Cod, item.getMecanismoNombre());
				if(valor==0) {
					TblMecanismoRendicionCuentas tblMecanismoRendicionCuentas= new TblMecanismoRendicionCuentas();
					tblMecanismoRendicionCuentas.setInfCod(tblInforme);
					tblMecanismoRendicionCuentas.setMecanismoFase(item.getMecanismoFase());			
					tblMecanismoRendicionCuentas.setMecanismoNombre(item.getMecanismoNombre());
					tblMecanismoRendicionCuentas.setMecanismoImplementado(item.getMecanismoImplementado());	
					tblMecanismoRendicionCuentas.setMecanismoEjecucion(item.getMecanismoEjecucion());
					tblMecanismoRendicionCuentas.setMecanismoMedioverifica(item.getMecanismoMedioverifica());
					tblMecanismoRendicionCuentas.setMecanismoObservacion(item.getMecanismoObservacion());					
					tblMecanismoRendicionCuentas.setMecanismoTipo(item.getMecanismoTipo());
					tblMecanismoRendicionCuentas.setMecanismoEstado(item.getMecanismoEstado());
					RendiCuent.guadarRendicioncuentas(tblMecanismoRendicionCuentas);
				}else {
					TblMecanismoRendicionCuentas tblMecanismoRendicionCuentas= RendiCuent.ObtenerRegistrosXInfoCodNombre(inf_Cod,item.getMecanismoNombre());
					tblMecanismoRendicionCuentas.setInfCod(tblInforme);
					tblMecanismoRendicionCuentas.setMecanismoFase(item.getMecanismoFase());			
					tblMecanismoRendicionCuentas.setMecanismoNombre(item.getMecanismoNombre());
					tblMecanismoRendicionCuentas.setMecanismoImplementado(item.getMecanismoImplementado());	
					tblMecanismoRendicionCuentas.setMecanismoEjecucion(item.getMecanismoEjecucion());
					tblMecanismoRendicionCuentas.setMecanismoMedioverifica(item.getMecanismoMedioverifica());
					tblMecanismoRendicionCuentas.setMecanismoObservacion(item.getMecanismoObservacion());					
					tblMecanismoRendicionCuentas.setMecanismoTipo(item.getMecanismoTipo());
					tblMecanismoRendicionCuentas.setMecanismoEstado(item.getMecanismoEstado());
					RendiCuent.guadarRendicioncuentas(tblMecanismoRendicionCuentas);
				}
				
			}
			TblInforme tblInforme2 = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());	
			TblMecanismoRendicionCuentas tblMecanismoRendicionCuentas2= new TblMecanismoRendicionCuentas();
			tblMecanismoRendicionCuentas2.setInfCod(tblInforme2);
			tblMecanismoRendicionCuentas2.setMecanismoFase(describa);			
			tblMecanismoRendicionCuentas2.setMecanismoNombre(describaAporte.toUpperCase());
			tblMecanismoRendicionCuentas2.setMecanismoTipo("RENDICION DE CUENTAS PRINCIPALES APORTES");
			tblMecanismoRendicionCuentas2.setMecanismoEstado(Constantes.ESTADO);
			RendiCuent.guadarRendicioncuentas(tblMecanismoRendicionCuentas2);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			}else {
				mensaje.put("estado", "ERROR");
				mensaje.put("mensaje", "Las Participaciones Ciudadanas no han sido ingresadas correctamente. Por favor revise.! ");
			}
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}
	
	 @RequestMapping(value = {"/obtenerRendicionFases"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerRendicionFases(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
			List<ProcesoRendicionCuentasIESDTO> lista = new ArrayList<>();
			try {		
				List<TblMecanismoRendicionCuentas> listaRendicionCuentas=RendiCuent.ObtenerRegistrosXInfoCod(infCod);
				if (listaRendicionCuentas.size()>0) {	
					lista=listaRendicionCuentas.stream().filter(obj-> !obj.getMecanismoTipo().equals("RENDICION DE CUENTAS PRINCIPALES APORTES"))
							.map(obj->ProcesoRendicionCuentasIESDTO.builder()
							.mecanismo_cod(obj.getMecanismoCod())
							.contador(listaRendicionCuentas.indexOf(obj)+1)
							.mecanismo(obj.getMecanismoFase())
							.proceso(obj.getMecanismoNombre())
							.seleccion(obj.getMecanismoImplementado())
							.describa(obj.getMecanismoEjecucion())
							.link(obj.getMecanismoMedioverifica())
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
	
	 @RequestMapping(value = {"/obtenerRendicionAporte"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerRendicionAporte(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
			List<ProcesoRendicionCuentasIESDTO> lista = new ArrayList<>();
			try {	
				List<TblMecanismoRendicionCuentas> listaRendicionCuentas=RendiCuent.ObtenerRegistrosXInfoCod(infCod);
				if (listaRendicionCuentas.size()>0) {
					
						lista=listaRendicionCuentas.stream().filter(obj-> obj.getMecanismoTipo().equals("RENDICION DE CUENTAS PRINCIPALES APORTES"))
								.map(obj->ProcesoRendicionCuentasIESDTO.builder()
										.mecanismo_cod(obj.getMecanismoCod())
										.contador(listaRendicionCuentas.indexOf(obj)+1)
										.proceso(obj.getMecanismoFase())
										.describa(obj.getMecanismoNombre())
								.build())
								.collect(Collectors.toList());
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

	 @RequestMapping("/view/rendicion/Frm_Ejectuvio_EjecucionProgramatica")
	    public String Frm_Ejectuvio_EjecucionProgramatica(Model model, @RequestParam("opcion") int idMenu, Authentication authentication ) {	
			model.addAttribute("email", authentication.getName());
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
	   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());

	   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
				model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
	   	 	}else {
	   			List<TblEjecucionProgramatica> registrosTotalEP = infor.obtenerTotalesEjecucionProgramatica(verificarInforme.getInfCod());		   			
	   			if(registrosTotalEP.size() ==0) {
	   				List<TblFuncionesObjetivos> verificarFuncionesObjetivos = is.obtenerRegistroInformeInstitucionFuncionesObjetivos(datosUsuario.getCodigoIntitucionAutorida());
		   			if(verificarFuncionesObjetivos.size()==0) {
		   				model.addAttribute("inf_estado", "sinObjetivo");
		   				model.addAttribute("infCod", verificarInforme.getInfCod());
		   			}else {	   				
	   				model.addAttribute("listadoFuncionesObjetivos", verificarFuncionesObjetivos);
	   				model.addAttribute("inf_estado", verificarInforme.getInfEstado());
	   				model.addAttribute("infCod", verificarInforme.getInfCod());
		   			}	   	   			
				}else {
					List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
			        model.addAttribute("acciones", listaAcciones);
					model.addAttribute("inf_estado", "matriz");
					model.addAttribute("infCod", verificarInforme.getInfCod());
					model.addAttribute("registrosTotalEP", registrosTotalEP);
					model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());					
				}		
			}
	         return "rendicion/Frm_Ejectuvio_EjecucionProgramatica";
	    }
	 
	 
	 @RequestMapping(value = "view/rendicion/Frm_Ejectuvio_EjecucionProgramaticaNuevo",method = RequestMethod.POST)
	    public String Frm_Ejectuvio_EjecucionProgramaticaNuevo(Model model, Authentication authentication ) {	
			model.addAttribute("email", authentication.getName());
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
	   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());

	   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){	   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
	   	 	}else {
	   	 		
	   			List<TblFuncionesObjetivos> verificarFuncionesObjetivos = is.obtenerRegistroInformeInstitucionFuncionesObjetivos(datosUsuario.getCodigoIntitucionAutorida());
	   			model.addAttribute("listadoFuncionesObjetivos", verificarFuncionesObjetivos);
	   			List<TblEjecucionProgramatica> registrosTotalEP = infor.obtenerTotalesEjecucionProgramatica(verificarInforme.getInfCod());	
	   			
	   			if(registrosTotalEP.size() ==0) {

	   				model.addAttribute("inf_estado", verificarInforme.getInfEstado());
	   				model.addAttribute("infCod", verificarInforme.getInfCod());

	   	   			
			}
			else {
				model.addAttribute("inf_estado", verificarInforme.getInfEstado());
				model.addAttribute("infCod", verificarInforme.getInfCod());
				model.addAttribute("registrosTotalEP", registrosTotalEP);
				model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				
			}		
			}
	         return "rendicion/Frm_Ejectuvio_EjecucionProgramaticaNuevo";
	    }
	 
	 @SuppressWarnings("finally")
	 @RequestMapping(value = "view/rendicion/guardarEjecutivoEjecucionProgramatica")
		public @ResponseBody String guardarEjecucionProgramatica(HttpServletRequest request,
				@RequestParam(value = "infCod") Integer infCod,   @RequestParam(value = "eprNumero") BigInteger eprNumero,
				@RequestParam(value = "eprMeta") String eprMeta, @RequestParam(value = "eprIndicador") String eprIndicador,
				@RequestParam(value = "eprPresultadopl") String eprPresultadopl, @RequestParam(value = "eprPresultadocm") String eprPresultadocm, 
				@RequestParam(value = "eprAporteResult") String eprAporteResult,
				@RequestParam(value = "foCod", required = false) Integer foCod, 
				@RequestParam( value = "eprGestion") String eprGestion) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {
				Double eprTotal = (double) 0;
				Double eprsuma = (double) 0;
				Double eprsumaTotal = (double) 0;
				
				String eprPresultadoplNumero=eprPresultadopl.toString().replace(",", "").trim();
				String eprPresultadocmtNumero=eprPresultadocm.toString().replace(",", "").trim();
				String perdiodoRC = Constantes.periodo().toString();

				
				Double pl = Double.valueOf(eprPresultadoplNumero== null ? "0" : eprPresultadoplNumero.isEmpty() ? "0" : eprPresultadoplNumero.toString());
				Double cm = Double.valueOf(eprPresultadocmtNumero== null ? "0" : eprPresultadocmtNumero.isEmpty() ? "0" : eprPresultadocmtNumero.toString());
				
				if (pl==0) {
					eprTotal=(double) 0;
				}else {
				eprTotal= (cm*100)/pl;
				}
				
				TblEjecucionProgramatica tblEjecucionProgramatica = new TblEjecucionProgramatica(); 
				  tblEjecucionProgramatica.setInfCod(infCod);
				  tblEjecucionProgramatica.setEprNumero(eprNumero);
				  tblEjecucionProgramatica.setEprTipoCompetencia("OBJETIVO ESTRATÉGICOS/FUNCIONES");   
				  tblEjecucionProgramatica.setEprMeta(eprMeta.toUpperCase());
				  tblEjecucionProgramatica.setEprIndicador(eprIndicador.toUpperCase());
				  tblEjecucionProgramatica.setEprPresultadopl(new BigDecimal(pl, MathContext.DECIMAL64));
				  tblEjecucionProgramatica.setEprPresultadocm(new BigDecimal(cm, MathContext.DECIMAL64));
				  tblEjecucionProgramatica.setEprGestion(eprGestion.toUpperCase());
				  tblEjecucionProgramatica.setEprEstado(Constantes.ESTADO);
				  tblEjecucionProgramatica.setFoCod(foCod);
				  TblFuncionesObjetivos listaFuncionesObjetivos =	is.obtenerRegistroFuncionObjetivo(foCod, perdiodoRC);
				  tblEjecucionProgramatica.setEprCompetenciaConcurr(listaFuncionesObjetivos.getFoNom().toUpperCase());
				  tblEjecucionProgramatica.setEprAporteResult(eprAporteResult.toUpperCase());
				  tblEjecucionProgramatica.setEprTotal(new BigDecimal(eprTotal, MathContext.DECIMAL64));
				  infor.guardarEjecucionProgramtica(tblEjecucionProgramatica);
				  List<TblEjecucionProgramatica> registrosTotalEP = infor.obtenerTotalesEjecucionProgramatica(infCod);
				  if (registrosTotalEP.size()==1) {
					  
					  tblEjecucionProgramatica.setEprSuma(new BigDecimal(eprTotal, MathContext.DECIMAL64));
					  infor.ActualizarTotalEjecucionProgramatica(tblEjecucionProgramatica.getEprSuma(), infCod);
				  }else {
					      for (int i = 0; i < registrosTotalEP.size(); i++) {
						  
					    	  eprsuma+= registrosTotalEP.get(i).getEprTotal().doubleValue(); 
						  }
					      eprsumaTotal= eprsuma/registrosTotalEP.size();
						  tblEjecucionProgramatica.setEprSuma(new BigDecimal(eprsumaTotal, MathContext.DECIMAL64));
						  infor.ActualizarTotalEjecucionProgramatica(tblEjecucionProgramatica.getEprSuma(), infCod);
				  }
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}
		}

	 
	 
	 
	 
	 @RequestMapping(value = {"/obtenerEjecucionesProgramaticasEjecutivo"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerEjecucionesProgramaticasEjecutivo(Authentication authentication,@RequestParam("infCod") Integer infCod) {
	         String json;
	         ObjectMapper mapper = new ObjectMapper();
	         List<PresupuestoInstitucionalFDEDTO> lista = new ArrayList<>();
	         try{
	      		  List<TblEjecucionProgramatica> registrosTotalEP = infor.obtenerTotalesEjecucionProgramatica(infCod);


	              if (registrosTotalEP.size() > 0){
	            	  DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
	            	  simbolo.setDecimalSeparator('.');
	            	  simbolo.setGroupingSeparator(',');
	            	  DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
	            	  
	            	  lista=registrosTotalEP.stream().map(obj->PresupuestoInstitucionalFDEDTO.builder()
	            			  .eprCod(obj.getEprCod())
	            			  .contador(registrosTotalEP.indexOf(obj)+1)
	            			  .objetivo(obj.getEprCompetenciaConcurr())
	            			  .tipoCompetencia(obj.getEprTipoCompetencia())
	            			  .descripcionCompetencian(obj.getEprCompetenciaConcurr())
	            			  .numeroMeta(obj.getEprNumero())
	            			  .meta(obj.getEprMeta())
	            			  .indicadorMeta(obj.getEprIndicador())
	            			  .tP(formateador.format(obj.getEprPresultadopl()).toString())
	            			  .tC(formateador.format(obj.getEprPresultadocm()).toString())
	            			  .porcentajeGestion(obj.getEprTotal())
	            			  .descripcionGestion(obj.getEprGestion())
	            			  .bandera(adps.obtenerregistroDetalle(infCod, obj.getEprMeta()).size())
	            			  .aporte(obj.getEprAporteResult())
	            			  .build())
	            			  .collect(Collectors.toList());
	            	  json = (!lista.isEmpty())
								? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
								: Constantes.MESSAGE_EMPTY_JSON;
	            	  } else{
	            	  json = "{\"data\": []}";
	              }

	         } catch (Exception e){
	              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

	         }

	         return json;
	    }

	 @RequestMapping("/view/rendicion/Frm_Finalizar_Funciones_Estado_Ep")
	    public String Frm_Finalizar_Funciones_Estado_Ep(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
			model.addAttribute("email", authentication.getName());
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());

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
	   	 	 	String verificador = verificarInformeFEEP(codigoInforme, Constantes.periodo());
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
	         return "rendicion/Frm_Finalizar_Funciones_Estado_Ep";
	    }
		
		@RequestMapping(value = "view/rendicion/verificarInformeFEEP")
		public @ResponseBody String verificarInformeFEEP(@RequestParam(value = "infAutCod") Integer infCod,  @RequestParam(value = "infAutPeriodo") Integer infAutPeriodo) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			String resultado="";
		
			try {
				String verificaInfAut = infor.listarInstitucionFEEP(infCod, infAutPeriodo);
				Integer contador = verificaInfAut.length();
				if (contador==62) {
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
		@RequestMapping(value = "view/rendicion/FinalizarInformeFEEP")
		public @ResponseBody String FinalizarInformeFEEP(Authentication authentication,@RequestParam(value = "infAutCod") Integer instCod,  @RequestParam(value = "infAutPeriodo") Integer infPeriodo
				) {

			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {

				TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(instCod, infPeriodo);
				if (verificarInforme==null) {
					
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "No hay informe!");
				}else {
					mensaje.put("estado", "exito");
					mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
					Date infAutFechafin = new Date();
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date fechaControl = format.parse(Constantes.FECHA_CIERRE_INFORME_FUNCIONES_ESTADO_EP);
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
