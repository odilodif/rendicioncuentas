package gob.cpccs.controller.rendicion;

import java.math.BigDecimal;
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
import org.springframework.format.annotation.DateTimeFormat;
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
import gob.cpccs.model.dto.rendicion.TblCoberturaNacionalDTO;
import gob.cpccs.model.dto.rendicion.TblCumplimientoMediosDTO;
import gob.cpccs.model.dto.rendicion.TblDatosMedioDTO;
import gob.cpccs.model.dto.rendicion.TblDerechosAutorDTO;
import gob.cpccs.model.dto.rendicion.TblFinanciamientoDTO;
import gob.cpccs.model.dto.rendicion.TblProduccionAudiovisualDTO;
import gob.cpccs.model.dto.rendicion.TblProyectoComunicacionalDTO;
import gob.cpccs.model.dto.rendicion.TblReclamosMediosDTO;
import gob.cpccs.model.rendicion.TblCoberturaInstitucional;
import gob.cpccs.model.rendicion.TblCoberturaNacional;
import gob.cpccs.model.rendicion.TblCumplimientoMedios;
import gob.cpccs.model.rendicion.TblCumplimientoObligaciones;
import gob.cpccs.model.rendicion.TblDatosMedio;
import gob.cpccs.model.rendicion.TblDerechosAutor;
import gob.cpccs.model.rendicion.TblEnajenacionBienes;
import gob.cpccs.model.rendicion.TblFinanciamiento;
import gob.cpccs.model.rendicion.TblImplementacionPresupuesto;
import gob.cpccs.model.rendicion.TblInformacionFinanciera;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblMecanismoParticipacionCiudadana;
import gob.cpccs.model.rendicion.TblMecanismosContolSocial;
import gob.cpccs.model.rendicion.TblMecanismosTranparenciaAccInf;
import gob.cpccs.model.rendicion.TblParticipacionCiudadana;
import gob.cpccs.model.rendicion.TblProduccionAudiovisual;
import gob.cpccs.model.rendicion.TblProyectoComunicacional;
import gob.cpccs.model.rendicion.TblReclamosMedios;
import gob.cpccs.model.usuario.TblResponables;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.service.AplicacionesUsuarioJPAServicio;
import gob.cpccs.service.catalogos.CatalogosServicio;
import gob.cpccs.service.catalogos.InstitucionServicio;
import gob.cpccs.service.mail.EmailService;
import gob.cpccs.service.rendicion.CoberturaNacionalService;
import gob.cpccs.service.rendicion.CumplimientoMediosService;
import gob.cpccs.service.rendicion.DatosMediosService;
import gob.cpccs.service.rendicion.DerechosAutoresService;
import gob.cpccs.service.rendicion.FinanciamientoService;
import gob.cpccs.service.rendicion.InformeServicio;
import gob.cpccs.service.rendicion.MecanismoControlSocialService;
import gob.cpccs.service.rendicion.MecanismoParticipacionServicio;
import gob.cpccs.service.rendicion.ParticipacionCiudadanaGadService;
import gob.cpccs.service.rendicion.ProduccionAudiovisualService;
import gob.cpccs.service.rendicion.ProyectoComunicacionalService;
import gob.cpccs.service.rendicion.ReclamosMediosService;
import gob.cpccs.service.rendicion.TrasparenciaInformacionService;
import gob.cpccs.service.usuario.ResponsableServicio;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;

@Controller
public class InformeMediosComunicacionController {
	@Autowired
    private HomeController hc;
	@Autowired
	private UsuarioServicio usu;
	@Autowired
	private InformeServicio infor;
	@Autowired
	private ProyectoComunicacionalService proyecto;
	@Autowired
	private DatosMediosService datosmedio;
	@Autowired
	private CoberturaNacionalService CoberturaNacionalService;
	@Autowired
	private CumplimientoMediosService medioscumplimiento;
	@Autowired
	private DerechosAutoresService derechomedios;
	@Autowired
	private MecanismoParticipacionServicio Meparticipacion;
	 @Autowired
	    private MecanismoControlSocialService ControlSol;
	 @Autowired
	    private ReclamosMediosService reclamos;
	 @Autowired
		private TrasparenciaInformacionService Trasparencia;
	 @Autowired
	    private ProduccionAudiovisualService audiovisual;
	 @Autowired
		private AplicacionesUsuarioJPAServicio auis;
	 @Autowired
	 private FinanciamientoService financiamiento;
	 @Autowired
	    private EmailService ms;
	 @Autowired
		private CatalogosServicio gcs;
		@Autowired
		private ResponsableServicio respon;
		@Autowired
		private InstitucionServicio servicioinstitucion;
		
		
		private static final String MESSAGE_OK_JSON = "{\"data\": ";
		private static final String MESSAGE_EMPTY_JSON = "{\"data\": []}";
		private static final String MESSAGE_ERROR_JSON = "{\"error\" : \"true\", \"message\": " + "ERROR:--> ";	
	 
	@RequestMapping("/view/rendicion/Frm_ProyectoComunicacional")
    public String Frm_ProyectoComunicacional(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", "vacio");		

   	 	}else {
      	     List<TblProyectoComunicacional> verificarMatriz= proyecto.obtenerRegistrosproyectos(verificarInforme.getInfCod());

   	 	if(verificarMatriz.size() ==0) {
      	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
      	 	model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
    		model.addAttribute("infCod", verificarInforme.getInfCod());
   		}
   		else {
   			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
   	        model.addAttribute("acciones", listaAcciones);
   	     if (verificarInforme.getInfEstado().equals("finalizado"))
   	     {
    			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
   			}
   	     else {
   	    	model.addAttribute("infestado", "matriz");
   			}
   			model.addAttribute("infCod", verificarInforme.getInfCod());
   		}		
   	 	}
         return "rendicion/Frm_ProyectoComunicacional";
    }
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarProyecto")
    public @ResponseBody String guardarProyecto(HttpServletRequest request,@RequestParam("infCod") int infCod,@RequestParam(value = "proNombre") String proNombre, 
    		@RequestParam(value = "proOpcion") String proOpcion) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
        	   
 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
 			   List<TblProyectoComunicacional> verificarMatriz= proyecto.obtenerRegistrosproyectos(tblInforme.getInfCod());
 				if(verificarMatriz.size() ==0) {
 			    TblProyectoComunicacional tblGuardarRegistro = new TblProyectoComunicacional();
 			    tblGuardarRegistro.setInfCod(tblInforme);
 			    tblGuardarRegistro.setProNombre(proNombre);
 			   tblGuardarRegistro.setProOpcion(proOpcion);
 			  tblGuardarRegistro.setProEstado(Constantes.ESTADO);
 			 proyecto.guardarRegistrosProyectos(tblGuardarRegistro);
 			   
 			    
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
 				}else {
 					mensaje.put("estado", "ERROR");
 					mensaje.put("mensaje", "Los datos ya se han guardado anteriormente.! "); 
 				}
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }
	 @RequestMapping(value = {"/obtenerRegistrosProyectos"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerRegistrosCumplimientoInformacion(Authentication authentication,@RequestParam("infCod") Integer infCod) {
	         String json = "";
	         ObjectMapper mapper = new ObjectMapper();
	         List<TblProyectoComunicacionalDTO> listaProyectoComunicacionalDTO = new ArrayList<>();
	     	try {
	     		List<TblProyectoComunicacional> listaRegistros =proyecto.obtenerRegistrosproyectos(infCod);

	     		listaProyectoComunicacionalDTO = listaRegistros.stream()
						.map(obj -> TblProyectoComunicacionalDTO.builder()
								.proCodigo(obj.getProCodigo())
								.proNombre(obj.getProNombre())
								.proOpcion(obj.getProOpcion())
								.build())
						.collect(Collectors.toList());
			
				
				json = (!listaProyectoComunicacionalDTO.isEmpty())
						? MESSAGE_OK_JSON + mapper.writeValueAsString(listaProyectoComunicacionalDTO) + "}"
						: MESSAGE_EMPTY_JSON;

			} catch (Exception e) {
				json = MESSAGE_ERROR_JSON + e.getMessage() + "}";
			}
	         return json;
	    }
	 

		 
	 
		@RequestMapping("/view/rendicion/Frm_DatosMedio")
	    public String Frm_DatosMedio(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
			model.addAttribute("email", authentication.getName());
			
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
	   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
	   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){	   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
	   	 	}else {
	   			List<TblDatosMedio> verificarMatrizCoberturaTerritorial = datosmedio.obtenerRegistroDatosmedios(verificarInforme.getInfCod());

	   	 	if(verificarMatrizCoberturaTerritorial.size() ==0) {
	   	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
	 		model.addAttribute("infCod", verificarInforme.getInfCod());
			}
			else {
				List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
		        model.addAttribute("acciones", listaAcciones);
				model.addAttribute("infestado", "matriz");
				 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());

				model.addAttribute("infCod", verificarInforme.getInfCod());
			}		
			}
	         return "rendicion/Frm_DatosMedio";
	    }
		@RequestMapping("/view/rendicion/Frm_CoberturaMedios")
	    public String Frm_CoberturaMedios(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
			model.addAttribute("email", authentication.getName());
			
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
	   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
	   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){	   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
	   	 	}else {
	   	 	List<TblCoberturaNacional> listaCoberturaTerritorial= CoberturaNacionalService.obtenerRegistroCoberturaNacionalXInfCodAndTipo(verificarInforme.getInfCod(),"MDC");   

	   	 	if(listaCoberturaTerritorial.size() ==0) {
	   	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
	 		model.addAttribute("infCod", verificarInforme.getInfCod());
			}
			else {
				List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
		        model.addAttribute("acciones", listaAcciones);
				model.addAttribute("infestado", "matriz");
				 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				 model.addAttribute("Tipo_Formulario","MDC");
				model.addAttribute("infCod", verificarInforme.getInfCod());
			}		
			}
	         return "rendicion/Frm_CoberturaMedios";
	    }
		 @RequestMapping(value = {"/obtenerCoberturasNacionalesMedios"}, method = RequestMethod.POST)
			@ResponseBody 
			public String obtenerCoberturasNacionalesMedios(Authentication authentication,@Param(value = "infCod") Integer infCod, @Param(value = "TipoFormulario") String TipoFormulario) {
		         String json = "";
		         ObjectMapper mapper = new ObjectMapper();
		         List<TblCoberturaNacionalDTO> listaCoberturaNacionalDTO = new ArrayList<>();
		     	try {
		     		TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
		     		List<TblCoberturaNacional> listaCoberturaTerritorial = CoberturaNacionalService.obtenerRegistroCoberturaNacionalXInfCodAndTipo(tblInforme.getInfCod(),TipoFormulario);
					
		     		listaCoberturaNacionalDTO = listaCoberturaTerritorial.stream()
							.map(obj -> TblCoberturaNacionalDTO.builder()
									.cnCod(obj.getCnCod())
									.cnCobertura(obj.getCnCobertura())
									.cnUnidades(obj.getCnUnidades())
									.build())
							.collect(Collectors.toList());
									
					json = (!listaCoberturaNacionalDTO.isEmpty())
							? MESSAGE_OK_JSON + mapper.writeValueAsString(listaCoberturaNacionalDTO) + "}"
							: MESSAGE_EMPTY_JSON;
	
				} catch (Exception e) {
					json = MESSAGE_ERROR_JSON + e.getMessage() + "}";
				}
				 return json;
			} 
		@SuppressWarnings("finally")
	    @RequestMapping(value = "/view/rendicion/guardarDatosMedio")
	    public @ResponseBody String guardarDatosMedio(HttpServletRequest request,@RequestParam("infCod") int infCod,@RequestParam(value = "dmFrecuencia") String dmFrecuencia, 
	    		@RequestParam(value = "dmNumrepetidoras") String dmNumrepetidoras,@RequestParam(value = "dmUbicrepetidoras") String dmUbicrepetidoras ,@RequestParam(value = "dmFechinicioconcesion") @DateTimeFormat(pattern = "dd/MM/yyyy") Date dmFechinicioconcesion,
	    		@RequestParam(value = "dmFechfinconcesion") @DateTimeFormat(pattern = "dd/MM/yyyy") Date dmFechfinconcesion ,@RequestParam(value = "dmNumscursales") int dmNumscursales,@RequestParam(value = "dmUbicsucursales") String dmUbicsucursales,@RequestParam(value = "dmProductos") String dmProductos) {
	         JSONObject mensaje = new JSONObject();
	         mensaje.put("estado", "error");
	         mensaje.put("mensaje", "Ha ocurrido un error!");	        
	         try{
	        	 
	        	   
	 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
	 			   
	 			    TblDatosMedio tblGuardarRegistro = new TblDatosMedio();
	 			    tblGuardarRegistro.setInfCod(tblInforme);
	 			    tblGuardarRegistro.setDmFrecuencia(dmFrecuencia);
	 			    tblGuardarRegistro.setDmNumrepetidoras(dmNumrepetidoras);
	 			    tblGuardarRegistro.setDmNumscursales(dmNumscursales);
	 			    tblGuardarRegistro.setDmProductos(dmProductos);
	 			    tblGuardarRegistro.setDmUbicrepetidoras(dmUbicrepetidoras);
	 			    tblGuardarRegistro.setDmUbicsucursales(dmUbicsucursales);
	 			    tblGuardarRegistro.setDmFechinicioconcesion(dmFechinicioconcesion);
	 			    tblGuardarRegistro.setDmFechfinconcesion(dmFechfinconcesion);
	 			   datosmedio.guardarDatosMedios(tblGuardarRegistro);
	 			    
					mensaje.put("estado", "exito");
					mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
					 
	         } catch (Exception e){
	              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
	         } finally{
	              return mensaje.toString();
	         }
	    }
		 @RequestMapping(value = {"/obtenerDatosMedio"}, method = RequestMethod.POST)
		    @ResponseBody
		    public String obtenerDatosMedio(Authentication authentication,@RequestParam("infCod") Integer infCod) {
		         String json;
		         ObjectMapper mapper = new ObjectMapper();
		         List<TblDatosMedioDTO> listaDatosMediosDTO = new ArrayList<>();
		     	try {
		     		List<TblDatosMedio> listaRegistros =datosmedio.obtenerRegistroDatosmedios(infCod);
                   
		     		listaDatosMediosDTO = listaRegistros.stream()
							.map(obj -> TblDatosMedioDTO.builder()
										.dmCod(obj.getDmCod())
										.dmFrecuencia(obj.getDmFrecuencia())
										.dmUbicrepetidoras(obj.getDmUbicrepetidoras())
										.dmProductos(obj.getDmProductos())
										.dmUbicsucursales(obj.getDmUbicsucursales())
										.dmNumscursales(obj.getDmNumscursales())
										.dmFechinicioconcesion(obj.getDmFechinicioconcesion())
										.dmFechfinconcesion(obj.getDmFechfinconcesion())
										.dmNumrepetidoras(obj.getDmNumrepetidoras())
									.build())
							.collect(Collectors.toList());
				
					
					json = (!listaDatosMediosDTO.isEmpty())
							? MESSAGE_OK_JSON + mapper.writeValueAsString(listaDatosMediosDTO) + "}"
							: MESSAGE_EMPTY_JSON;

				} catch (Exception e) {
					json = MESSAGE_ERROR_JSON + e.getMessage() + "}";
				}

		         return json;
		    }
			@RequestMapping(value = "view/rendicion/Frm_NuevoDatosInforme",method = RequestMethod.POST)
		    public String Frm_NuevoDatosInforme(Model model, Authentication authentication) {	
				model.addAttribute("email", authentication.getName());
				
				TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
		   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
				if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){		   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
		   	 	}else {
		   			
		   	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
		 		model.addAttribute("infCod", verificarInforme.getInfCod());
					
				}
		         return "rendicion/Frm_NuevoDatosInforme";
		    }
			@RequestMapping(value = "view/rendicion/Frm_CoberturaMediosNuevo",method = RequestMethod.POST)
		    public String Frm_CoberturaMediosNuevo(Model model, Authentication authentication) {	
				model.addAttribute("email", authentication.getName());
				
				TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
		   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
				if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){		   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
		   	 	}else {
		   			
		   	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
		 		model.addAttribute("infCod", verificarInforme.getInfCod());
					
				}
		         return "rendicion/Frm_CoberturaMediosNuevo";
		    }
			
			@RequestMapping("/view/rendicion/Frm_PromocionDerechos")
		    public String Frm_PromocionDerechos(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
				model.addAttribute("email", authentication.getName());
				
				TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
		   	 	
		   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
				if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){		   	   	 	
					model.addAttribute("infestado", Constantes.TIPO_INFORME_ESTADO_VACIO);		

		   	 	}else {
		   	 	TblProyectoComunicacional proyectodato=proyecto.obtenerRegistrosproyectosC(verificarInforme.getInfCod());
		   	    if(proyectodato==null) {
		   	    	model.addAttribute("infestado", "proyecto");
		   	    }else {
		   	    	
		   	    	model.addAttribute("infestado", verificarInforme.getInfEstado());	
			   	    model.addAttribute("codigo_informe", verificarInforme.getInfCod());	
			   	    model.addAttribute("tipo", "PROMOCIÓN DE DERECHOS");	
			      	 model.addAttribute("proyecto", proyectodato.getProOpcion());
		   	    }
		   	 		
		   	 	}
		         return "rendicion/Frm_PromocionDerechos";
		    }
			@RequestMapping("/view/rendicion/Frm_ParticipacionMedios")
		    public String Frm_ParticipacionMedios(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
				model.addAttribute("email", authentication.getName());
				
				TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
		   	 	
		   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
				if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){		   	   	 	model.addAttribute("infestado", Constantes.TIPO_INFORME_ESTADO_VACIO);		

		   	 	}else {
		   	 	TblProyectoComunicacional proyectodato=proyecto.obtenerRegistrosproyectosC(verificarInforme.getInfCod());
		   	 if(proyectodato==null) {
		   	    	model.addAttribute("infestado", "proyecto");
		   	    }else {
		   	 	model.addAttribute("infestado", verificarInforme.getInfEstado());	
		   	    model.addAttribute("codigo_informe", verificarInforme.getInfCod());	
		   	    model.addAttribute("proyecto", proyectodato.getProOpcion());	
		   	    model.addAttribute("tipo", "PARTICIPACIÓN");}	
		   	 	}
		         return "rendicion/Frm_ParticipacionMedios";
		    }
			@RequestMapping("/view/rendicion/Frm_DialogoMedios")
		    public String Frm_DialogoMedios(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
				model.addAttribute("email", authentication.getName());
				
				TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
		   	 	
		   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
				if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){		   	   	 	model.addAttribute("infestado", Constantes.TIPO_INFORME_ESTADO_VACIO);		

		   	 	}else {
		   	 	TblProyectoComunicacional proyectodato=proyecto.obtenerRegistrosproyectosC(verificarInforme.getInfCod());
		   	 if(proyectodato==null) {
		   	    	model.addAttribute("infestado", "proyecto");
		   	    }else {
		   	 	model.addAttribute("infestado", verificarInforme.getInfEstado());	
		   	    model.addAttribute("codigo_informe", verificarInforme.getInfCod());	
		   	    model.addAttribute("proyecto", proyectodato.getProOpcion());	
		   	    model.addAttribute("tipo", "DIÁLOGO");	}
		   	 	}
		         return "rendicion/Frm_DialogoMedios";
		    }
			@RequestMapping("/view/rendicion/Frm_ReclamosMedios")
		    public String Frm_ReclamosMedios(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
				model.addAttribute("email", authentication.getName());
				
				TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
		   	 	
		   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
				if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){		   	   	 	model.addAttribute("infestado", Constantes.TIPO_INFORME_ESTADO_VACIO);		

		   	 	}else {
		   	 	model.addAttribute("infestado", verificarInforme.getInfEstado());	
		   	    model.addAttribute("codigo_informe", verificarInforme.getInfCod());
		   	 	}
		         return "rendicion/Frm_ReclamosMedios";
		    }
			@RequestMapping("/view/rendicion/Frm_TipoDerechos")
		    public String Frm_TipoDerechos(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
				model.addAttribute("email", authentication.getName());
				
				TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
		   	 	
		   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
				if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){		   	   	 	model.addAttribute("infestado", Constantes.TIPO_INFORME_ESTADO_VACIO);		

		   	 	}else {
		   	 	model.addAttribute("infestado", verificarInforme.getInfEstado());	
		   	    model.addAttribute("codigo_informe", verificarInforme.getInfCod());	
		   	 	}
		         return "rendicion/Frm_TipoDerechos";
		    }
			
			@RequestMapping("/view/rendicion/Frm_FinanciamientoMedios")
		    public String Frm_FinanciamientoMedios(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
				model.addAttribute("email", authentication.getName());
				
				TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
		   	 	
		   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
				if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){		   	   	 	model.addAttribute("infestado", Constantes.TIPO_INFORME_ESTADO_VACIO);		

		   	 	}else {
		   	 	List<TblFinanciamiento> listaCoberturaTerritorial= financiamiento.obtenerRegistroFinanciamiento(verificarInforme.getInfCod());   
		   	 if(listaCoberturaTerritorial.size() ==0) {
		   	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
		 		model.addAttribute("infCod", verificarInforme.getInfCod());
				}
				else {
					List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
			        model.addAttribute("acciones", listaAcciones);
					model.addAttribute("infestado", "matriz");
					 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
					model.addAttribute("infCod", verificarInforme.getInfCod());
				}
		   	    
		   	 	}
		         return "rendicion/Frm_FinanciamientoMedios";
		    }
			@SuppressWarnings("finally")
		    @RequestMapping(value = "/view/rendicion/guardarTblCumplimientoMedios")
		    public @ResponseBody String guardarTblCumplimientoMedios(HttpServletRequest request,@RequestParam("infCod") int infCod,@RequestParam(value = "cmValidaProyecto") String cmValidaProyecto, 
		    		@RequestParam(value = "cmDescParametro") String cmDescParametro,@RequestParam(value = "cmOpciones") String cmOpciones ,@RequestParam(value = "cmNomPrograma") String cmNomPrograma,
		    		@RequestParam(value = "cmFrecuencia")String cmFrecuencia ,@RequestParam(value = "cmDescProgramacion") String cmDescProgramacion,@RequestParam(value = "cmPorcDifusion") String cmPorcDifusion,@RequestParam(value = "cmLink") String cmLink,@RequestParam(value = "CmTipo") String CmTipo) {
		         JSONObject mensaje = new JSONObject();
		         mensaje.put("estado", "error");
		         mensaje.put("mensaje", "Ha ocurrido un error!");	        
		         try{
		        	 
		        	   
		 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
		 			   
		 			    TblCumplimientoMedios tblGuardarRegistro = new TblCumplimientoMedios();
		 			   tblGuardarRegistro.setCmDescParametro(cmDescParametro);
		 			   tblGuardarRegistro.setCmDescProgramacion(cmDescProgramacion);
		 			   tblGuardarRegistro.setCmFrecuencia(cmFrecuencia);
		 			   tblGuardarRegistro.setCmNomPrograma(cmNomPrograma);
		 			   tblGuardarRegistro.setCmOpciones(cmOpciones);
		 			   tblGuardarRegistro.setCmLink(cmLink);
		 			   tblGuardarRegistro.setCmValidaProyecto(cmValidaProyecto);
		 			   tblGuardarRegistro.setCmPorcDifusion(new BigDecimal(cmPorcDifusion));
		 			   tblGuardarRegistro.setCmTipo(CmTipo);
		 			   tblGuardarRegistro.setInfCod(tblInforme);
		 			   medioscumplimiento.guardarCumplimientoMedio(tblGuardarRegistro); 
						mensaje.put("estado", "exito");
						mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
						 
		         } catch (Exception e){
		              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		         } finally{
		              return mensaje.toString();
		         }
		    }
			@SuppressWarnings("finally")
		    @RequestMapping(value = "/view/rendicion/guardarTblFinanciamiento")
		    public @ResponseBody String guardarTblFinanciamiento(HttpServletRequest request,@RequestParam("infCod") int infCod,@RequestParam(value = "finAsignacion") String finAsignacion, 
		    		@RequestParam(value = "finIngresoventa") String finIngresoventa,@RequestParam(value = "finIngresoproducto") String finIngresoproducto ,@RequestParam(value = "finFondos") String finFondos) {
		         JSONObject mensaje = new JSONObject();
		         mensaje.put("estado", "error");
		         mensaje.put("mensaje", "Ha ocurrido un error!");	        
		         try{
		        	 
		        	   
		 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
		 			   
		 			    TblFinanciamiento tblGuardarRegistro = new TblFinanciamiento();
		 			   String venta=finIngresoventa.toString().replace(",", "").trim();
						String producto=finIngresoproducto.toString().replace(",", "").trim();
						   String asignado=finAsignacion.toString().replace(",", "").trim();
							String fondos=finFondos.toString().replace(",", "").trim();
		 			tblGuardarRegistro.setInfCod(tblInforme);
		 			tblGuardarRegistro.setFinAsignacion(new BigDecimal(asignado));
		 			tblGuardarRegistro.setFinIngresoproducto(new BigDecimal(producto));
		 			tblGuardarRegistro.setFinIngresoventa(new BigDecimal(venta));
		 			tblGuardarRegistro.setFinFondos(new BigDecimal(fondos));
		 			  financiamiento.guardarFinanciamiento(tblGuardarRegistro);
						mensaje.put("estado", "exito");
						mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
						 
		         } catch (Exception e){
		              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		         } finally{
		              return mensaje.toString();
		         }
		    }
			@SuppressWarnings("finally")
		    @RequestMapping(value = "/view/rendicion/guardarTblReclamosMedios")
		    public @ResponseBody String guardarTblReclamosMedios(HttpServletRequest request,@RequestParam("infCod") int infCod,@RequestParam(value = "rmPresentado") String rmPresentado, 
		    		@RequestParam(value = "rmNreclamos") int rmNreclamos,@RequestParam(value = "rmNproceso") int rmNproceso ,@RequestParam(value = "rmLink") String rmLink,
		    		@RequestParam(value = "rmNreclamofavorable")int rmNreclamofavorable ,@RequestParam(value = "rmNreclamodesfavorable") int rmNreclamodesfavorable,@RequestParam(value = "rmTipoReclamo") String rmTipoReclamo) {
		         JSONObject mensaje = new JSONObject();
		         mensaje.put("estado", "error");
		         mensaje.put("mensaje", "Ha ocurrido un error!");	        
		         try{
		        	 
		        	   
		 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
		 			   
		 			    TblReclamosMedios tblGuardarRegistro = new TblReclamosMedios();
		 			tblGuardarRegistro.setInfCod(tblInforme);
		 			tblGuardarRegistro.setRmLink(rmLink);
		 			tblGuardarRegistro.setRmNproceso(rmNproceso);
		 			tblGuardarRegistro.setRmNreclamodesfavorable(rmNreclamodesfavorable);
		 			tblGuardarRegistro.setRmNreclamofavorable(rmNreclamofavorable);
		 			tblGuardarRegistro.setRmNreclamos(rmNreclamos);
		 			tblGuardarRegistro.setRmTipoReclamo(rmTipoReclamo);
		 			tblGuardarRegistro.setRmPresentado(rmPresentado);
		 			reclamos.guardarRegistrosReclamos(tblGuardarRegistro);
						mensaje.put("estado", "exito");
						mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
						 
		         } catch (Exception e){
		              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		         } finally{
		              return mensaje.toString();
		         }
		    }
			
			@SuppressWarnings("finally")
		    @RequestMapping(value = "/view/rendicion/guardarTblDerechosAutor")
		    public @ResponseBody String guardarTblDerechosAutor(HttpServletRequest request,@RequestParam("infCod") int infCod,@RequestParam(value = "daTipo") String daTipo, 
		    		@RequestParam(value = "daNumero") int daNumero,@RequestParam(value = "daNumeropagado") int daNumeropagado ,@RequestParam(value = "dalink1") String dalink1
		    		) {
		         JSONObject mensaje = new JSONObject();
		         mensaje.put("estado", "error");
		         mensaje.put("mensaje", "Ha ocurrido un error!");	        
		         try{
		        	 
		        	   
		 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
		 			   
		 			    TblDerechosAutor tblGuardarRegistro = new TblDerechosAutor();
		 			tblGuardarRegistro.setInfCod(tblInforme);
		 			tblGuardarRegistro.setDaTipo(daTipo);
		 			tblGuardarRegistro.setDaNumero(daNumero);
		 			tblGuardarRegistro.setDaNumeropagado(daNumeropagado);
		 			tblGuardarRegistro.setDalink(dalink1);
		 			derechomedios.guardarCumplimientoDerechosMedio(tblGuardarRegistro);
						mensaje.put("estado", "exito");
						mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
						 
		         } catch (Exception e){
		              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		         } finally{
		              return mensaje.toString();
		         }
		    }
			 @RequestMapping(value = {"/obtenerCumplimientoMediosDerechos"}, method = RequestMethod.POST)
			    @ResponseBody
			    public String obtenerCumplimientoMediosDerechos(Authentication authentication,@RequestParam("infCod") Integer infCod,@RequestParam("tipo") String tipo) {
		         String json;
		         ObjectMapper mapper = new ObjectMapper();
		         List<TblCumplimientoMediosDTO> listaCumplimientoMediosDTO = new ArrayList<>();
		     	try {
		     		List<TblCumplimientoMedios> listaRegistros =medioscumplimiento.obtenerRegistroCumplimientoMedio(infCod,tipo);	

		     		listaCumplimientoMediosDTO = listaRegistros.stream()
							.map(obj -> TblCumplimientoMediosDTO.builder()
									.cmCod(obj.getCmCod())
									.cmValidaProyecto(obj.getCmValidaProyecto())
									.cmDescParametro(obj.getCmDescParametro())
									.cmOpciones(obj.getCmOpciones())
									.cmNomPrograma(obj.getCmNomPrograma())
									.cmFrecuencia(obj.getCmFrecuencia())
									.cmDescProgramacion(obj.getCmDescProgramacion())
									.cmPorcDifusion(obj.getCmPorcDifusion())
									.cmLink(obj.getCmLink())
									.build())
							.collect(Collectors.toList());
				
					
					json = (!listaCumplimientoMediosDTO.isEmpty())
							? MESSAGE_OK_JSON + mapper.writeValueAsString(listaCumplimientoMediosDTO) + "}"
							: MESSAGE_EMPTY_JSON;

				} catch (Exception e) {
					json = MESSAGE_ERROR_JSON + e.getMessage() + "}";
				} 
				 

			         return json;
			    }
			 

			 @RequestMapping(value = {"/obtenerReclamosmedios"}, method = RequestMethod.POST)
			    @ResponseBody
			    public String obtenerReclamosmedios(Authentication authentication,@RequestParam("infCod") Integer infCod,@RequestParam("tipo") String tipo) {
		         String json;
		         ObjectMapper mapper = new ObjectMapper();
		         List<TblReclamosMediosDTO> listaReclamosMediosDTO = new ArrayList<>();
		     	try {
		     		List<TblReclamosMedios> listaRegistros =reclamos.obtenerRegistrosReclamos(infCod);		

		     		listaReclamosMediosDTO = listaRegistros.stream()
							.map(obj -> TblReclamosMediosDTO.builder()
									.rmCod(obj.getRmCod())
									.rmPresentado(obj.getRmPresentado())
									.rmNreclamos(obj.getRmNreclamos())
									.rmNproceso(obj.getRmNproceso())
									.rmNreclamofavorable(obj.getRmNreclamofavorable())
									.rmNreclamodesfavorable(obj.getRmNreclamodesfavorable())
									.rmTipoReclamo(obj.getRmTipoReclamo())
									.rmLink(obj.getRmLink())
									.build())
							.collect(Collectors.toList());	
					json = (!listaReclamosMediosDTO.isEmpty())
							? MESSAGE_OK_JSON + mapper.writeValueAsString(listaReclamosMediosDTO) + "}"
							: MESSAGE_EMPTY_JSON;

				} catch (Exception e) {
					json = MESSAGE_ERROR_JSON + e.getMessage() + "}";
				}  
		     	return json;
			    }
			 @RequestMapping(value = {"/obtenerMediosDerechos"}, method = RequestMethod.POST)
			    @ResponseBody
			    public String obtenerMediosDerechos(Authentication authentication,@RequestParam("infCod") Integer infCod) {
		         String json;
		         ObjectMapper mapper = new ObjectMapper();
		         List<TblDerechosAutorDTO> listaDerechosAutorDTO = new ArrayList<>();
		     	try {
		     		List<TblDerechosAutor> listaRegistros =derechomedios.obtenerRegistroDerechosMedio(infCod);

		     		listaDerechosAutorDTO = listaRegistros.stream()
							.map(obj -> TblDerechosAutorDTO.builder()
									.daCod(obj.getDaCod())
									.daTipo(obj.getDaTipo())
									.daNumero(obj.getDaNumero())
									.daNumeropagado(obj.getDaNumeropagado())
									.dalink(obj.getDalink())
									.build())
							.collect(Collectors.toList());
				
					
					json = (!listaDerechosAutorDTO.isEmpty())
							? MESSAGE_OK_JSON + mapper.writeValueAsString(listaDerechosAutorDTO) + "}"
							: MESSAGE_EMPTY_JSON;

				} catch (Exception e) {
					json = MESSAGE_ERROR_JSON + e.getMessage() + "}";
				} 

			         return json;
			    }
			 @RequestMapping("/view/rendicion/Frm_MecanismosParticipacionMedios")
			    public String Frm_MecanismosParticipacionMedios(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {		
					TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
			   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
					if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){			   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
			   	 	}else {
			   	 	  List<TblMecanismoParticipacionCiudadana> listaMecanismosPartici =Meparticipacion.obtenerRegistroMecanismosPaticipacion(verificarInforme.getInfCod());
			   		if(listaMecanismosPartici.size() ==0) {
			   	 	model.addAttribute("inf_estado", verificarInforme.getInfEstado());
			 		model.addAttribute("inf_Cod", verificarInforme.getInfCod());
					}
					else {			
						model.addAttribute("inf_estado", "matriz");
						model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
						model.addAttribute("inf_Cod", verificarInforme.getInfCod());
					}		
					}
			         return "rendicion/Frm_MecanismosParticipacionMedios";
			    }
				@RequestMapping("/view/rendicion/Frm_MecanicanismosControlMedios")
				public String Frm_MecanicanismosControlMedios(Model model, @RequestParam("opcion") int idMenu,
					Authentication authentication) {
					TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
					TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
					TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
					if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
						model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);
						} 
					else{
						List<TblMecanismosContolSocial> listaControlSocial=ControlSol.obtenerRegistroControlSocial(verificarInforme.getInfCod());

					   if(listaControlSocial.size() ==0) {
							model.addAttribute("inf_estado", verificarInforme.getInfEstado());
							model.addAttribute("inf_Cod", verificarInforme.getInfCod());
						}
						else {
									model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_MATRIZ);
									model.addAttribute("inf_Cod", verificarInforme.getInfCod());
									model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
						}		
						
					}
					return "rendicion/Frm_MecanicanismosControlMedios";
				}
				private void GuardarControlSocial(TblInforme tblInforme,String part, String seleccion,Integer numero, String link) {
					TblMecanismosContolSocial tblMecanismosContolSocial= new TblMecanismosContolSocial();
					tblMecanismosContolSocial.setInfCod(tblInforme);
					tblMecanismosContolSocial.setMecNombre(part);			
					tblMecanismosContolSocial.setMecImplementado(seleccion);
					tblMecanismosContolSocial.setMecNumero(numero);	
					tblMecanismosContolSocial.setMecMedioverifica(link);
					tblMecanismosContolSocial.setMecTi("MECANISMOS DE CONTROL SOCIAL");
			        lista_ControlSocial.add(tblMecanismosContolSocial);
					
				}
				 private List<TblMecanismosContolSocial> lista_ControlSocial= new ArrayList<TblMecanismosContolSocial>();
				@SuppressWarnings("finally")
				@RequestMapping(value = "view/rendicion/guardarMecaContSocialMedios")
				public @ResponseBody String guardarMecaContSocialMedios(HttpServletRequest request,@RequestParam(value = "infCod") Integer inf_Cod,	
						@RequestParam(value = "part1") String part1,
						@RequestParam(value = "seleccion1") String seleccion1,			
						@RequestParam(value = "numero1", required = false) Integer numero1,
						@RequestParam(value = "link1", required = false) String link1,
						@RequestParam(value = "part2") String part2,
						@RequestParam(value = "seleccion2") String seleccion2,
						@RequestParam(value = "numero2", required = false) Integer numero2,
						@RequestParam(value = "link2", required = false) String link2,
						@RequestParam(value = "part5") String part5,
						@RequestParam(value = "seleccion5") String seleccion5,
						@RequestParam(value = "numero5", required = false) Integer numero5,
						@RequestParam(value = "link5", required = false) String link5) {
			            
					JSONObject mensaje = new JSONObject();
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Ha ocurrido un error!");
					try {	
						TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());	
					    lista_ControlSocial.clear();
					    GuardarControlSocial(tblInforme, part1, seleccion1,numero1, link1);
					    GuardarControlSocial(tblInforme, part2, seleccion2,numero2, link2);
					    GuardarControlSocial(tblInforme, part5, seleccion5,numero5, link5);
						
						
						if (lista_ControlSocial.size()==3) {	
						for (TblMecanismosContolSocial item : lista_ControlSocial) {	
							Integer valor=ControlSol.ContadorMCS(inf_Cod, item.getMecNombre());
							if(valor==0) {
								TblMecanismosContolSocial tblMecanismosContolSocial= new TblMecanismosContolSocial();
								tblMecanismosContolSocial.setInfCod(item.getInfCod());
								tblMecanismosContolSocial.setMecNombre(item.getMecNombre());			
								tblMecanismosContolSocial.setMecImplementado(item.getMecImplementado());
								tblMecanismosContolSocial.setMecNumero(item.getMecNumero());	
								tblMecanismosContolSocial.setMecMedioverifica(item.getMecMedioverifica());
								tblMecanismosContolSocial.setMecTi(item.getMecTi());
								ControlSol.guardarControlSocial(tblMecanismosContolSocial);
							}
							else {
								TblMecanismosContolSocial tblMecanismosContolSocial= ControlSol.ObtenerRegistroContrSocialNombre(inf_Cod, item.getMecNombre());
								tblMecanismosContolSocial.setInfCod(item.getInfCod());
								tblMecanismosContolSocial.setMecNombre(item.getMecNombre());			
								tblMecanismosContolSocial.setMecImplementado(item.getMecImplementado());
								tblMecanismosContolSocial.setMecNumero(item.getMecNumero());	
								tblMecanismosContolSocial.setMecMedioverifica(item.getMecMedioverifica());
								tblMecanismosContolSocial.setMecTi(item.getMecTi());
								ControlSol.guardarControlSocial(tblMecanismosContolSocial);
							}
						
							
						}
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
				@RequestMapping("/view/rendicion/Frm_TrasparenciaInformacionMedios")
			    public String Frm_TrasparenciaInformacionMedios(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
					model.addAttribute("email", authentication.getName());
					
					TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
			   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
					if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){			   	   	 	model.addAttribute("inf_estado", "vacio");		

			   	 	}else {
			      	     List<TblMecanismosTranparenciaAccInf> verificarMatriz= Trasparencia.obtenerRegistroTrasparenciaInformacion(verificarInforme.getInfCod());

			   	 	if(verificarMatriz.size() ==0) {
			      	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
			      	 	model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			    		model.addAttribute("infCod", verificarInforme.getInfCod());
			   		}
			   		else {
			   			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
			   	        model.addAttribute("acciones", listaAcciones);
			   	     if (verificarInforme.getInfEstado().equals("finalizado"))
			   	     {
			    			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			   			}
			   	     else {
			   	    	model.addAttribute("infestado", "matriz");
			   			}
			   			model.addAttribute("infCod", verificarInforme.getInfCod());
			   		}		
			   	 	}
			         return "rendicion/Frm_TrasparenciaInformacionMedios";
			    }
				@RequestMapping("/view/rendicion/Frm_ProduccionNacional")
				public String Frm_ProduccionNacional(Model model, @RequestParam("opcion") int idMenu,
					Authentication authentication) {
				   model.addAttribute("email", authentication.getName());

					TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
					TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
					TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
					if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
						model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);
						} 
					else{
						
						List<TblProduccionAudiovisual> listaParticiCiudadana=audiovisual.obtenerRegistrosAudiovisual(verificarInforme.getInfCod(),"PRODUCCIÓN NACIONAL");

					   if(listaParticiCiudadana.size() ==0) {
							model.addAttribute("inf_estado", verificarInforme.getInfEstado());
							model.addAttribute("inf_Cod", verificarInforme.getInfCod());
						}
						else {
							 if (verificarInforme.getInfEstado().equals("finalizado"))
					   	     {
								 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
								 model.addAttribute("inf_estado",verificarInforme.getInfEstado());
					   	     }else {
						   	    	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_MATRIZ);
						   	    	model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
					   			}
									model.addAttribute("inf_Cod", verificarInforme.getInfCod());
						}		
						
					}
					return "rendicion/Frm_ProduccionNacional";
				}
				@RequestMapping("/view/rendicion/Frm_ProduccionIndependiente")
				public String Frm_ProduccionIndependiente(Model model, @RequestParam("opcion") int idMenu,
					Authentication authentication) {
				   model.addAttribute("email", authentication.getName());

					TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
					TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
					TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
					if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
						model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);
						} 
					else{
						
						List<TblProduccionAudiovisual> listaParticiCiudadana=audiovisual.obtenerRegistrosAudiovisual(verificarInforme.getInfCod(),"PRODUCCIÓN NACIONAL INDEPENDIENTE");

					   if(listaParticiCiudadana.size() ==0) {
							model.addAttribute("inf_estado", verificarInforme.getInfEstado());
							model.addAttribute("inf_Cod", verificarInforme.getInfCod());
						}
						else {
							
							if (verificarInforme.getInfEstado().equals("finalizado"))
					   	     {
								 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
								 model.addAttribute("inf_estado",verificarInforme.getInfEstado());
					   	     }else {
						   	    	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_MATRIZ);
						   	    	model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
					   			}
									model.addAttribute("inf_Cod", verificarInforme.getInfCod());
						}		
						
					}
					return "rendicion/Frm_ProduccionIndependiente";
				}
				@SuppressWarnings("finally")
				@RequestMapping(value = "view/rendicion/guardarProduccionAudiovisual")
				public @ResponseBody String guardarProduccionAudiovisual(TblImplementacionPresupuesto tblImplementacionPresupuesto,
						HttpServletRequest request, @RequestParam(value = "infCod") Integer inf_Cod,
						@RequestParam(value = "paTipo", required = false) String paTipo,
						@RequestParam(value = "paPorcentaje", required = false) String[] paPorcentaje,
						@RequestParam(value = "paContenido", required = false) String[] paContenido,
						@RequestParam(value = "paPeriocidad", required = false) String[] paPeriocidad,
						@RequestParam(value = "paMedio", required = false) String[] paMedio) {

					JSONObject mensaje = new JSONObject();
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Ha ocurrido un error!");
					try {
					
						TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());
						  for (int i = 0; i < paPorcentaje.length; i++){
							  Integer valor= audiovisual.CountProduccion(inf_Cod, paTipo, paContenido[i]);
							  if(valor==0) {
								  TblProduccionAudiovisual lista_implementa = new TblProduccionAudiovisual();
								  lista_implementa.setInfCod(tblInforme);
								  lista_implementa.setPaTipo(paTipo);
								  lista_implementa.setPaContenido(paContenido[i]);
								  lista_implementa.setPaPorcentaje(new BigDecimal(paPorcentaje[i]));
								  lista_implementa.setPaPeriocidad(paPeriocidad[i]);
								  lista_implementa.setPaMedio(paMedio[i]);
								  audiovisual.guardarRegistrosAudiovisual(lista_implementa);
							  }else {
								  TblProduccionAudiovisual lista_implementa = audiovisual.obtenerPAudiovisualNombre(inf_Cod, paTipo, paContenido[i]);
								  lista_implementa.setInfCod(tblInforme);
								  lista_implementa.setPaTipo(paTipo);
								  lista_implementa.setPaContenido(paContenido[i]);
								  lista_implementa.setPaPorcentaje(new BigDecimal(paPorcentaje[i]));
								  lista_implementa.setPaPeriocidad(paPeriocidad[i]);
								  lista_implementa.setPaMedio(paMedio[i]);
								  audiovisual.guardarRegistrosAudiovisual(lista_implementa); 
							  }
							
						  }
						mensaje.put("estado", "exito");
						mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
					} catch (Exception e) {
						mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
					} finally {
						return mensaje.toString();
					}

				}
				 @RequestMapping(value = {"/obtenerProduccionAudiovisual"}, method = RequestMethod.POST)
				    @ResponseBody
				    public String obtenerProduccionAudiovisual(Authentication authentication,@RequestParam("infCod") Integer infCod,@RequestParam("tipo") String tipo) {
			         String json;
			         ObjectMapper mapper = new ObjectMapper();
			         List<TblProduccionAudiovisualDTO> listaProduccionAudiovisualDTO = new ArrayList<>();
			     	try {
			     		List<TblProduccionAudiovisual> listaRegistros =audiovisual.obtenerRegistrosAudiovisual(infCod,tipo);

			     		listaProduccionAudiovisualDTO = listaRegistros.stream()
								.map(obj -> TblProduccionAudiovisualDTO.builder()
										.paCod(obj.getPaCod())
										.paTipo(obj.getPaTipo())
										.paPorcentaje(obj.getPaPorcentaje())
										.paContenido(obj.getPaContenido())
										.paPeriocidad(obj.getPaPeriocidad())
										.paMedio(obj.getPaMedio())
										.build())
								.collect(Collectors.toList());
						json = (!listaProduccionAudiovisualDTO.isEmpty())
								? MESSAGE_OK_JSON + mapper.writeValueAsString(listaProduccionAudiovisualDTO) + "}"
								: MESSAGE_EMPTY_JSON;

					} catch (Exception e) {
						json = MESSAGE_ERROR_JSON + e.getMessage() + "}";
					}  
			     	return json;
				    }
				 @SuppressWarnings("finally")
			     @RequestMapping(value = "/view/rendicion/eliminarDatosproduccion", method = RequestMethod.POST)
			     public @ResponseBody String eliminarDatos(Model model, @RequestParam("codigo") int codigo,@RequestParam("tabla") String tabla,@RequestParam("campo") String campo,@RequestParam("tipo") String tipo,@RequestParam("valor") String valor) {
			          JSONObject mensaje = new JSONObject();
			          mensaje.put("estado", "error");
			          mensaje.put("mensaje", "Ha ocurrido un error!");
			          try{
			            
			        	  auis.eliminarTablaCampoandvalor(codigo, tabla, campo, tipo, valor);
			                
			               mensaje.put("estado", "exito");
			               mensaje.put("mensaje", "Los datos se han Eliminado correctamente.! ");
			          } catch (Exception e){
			               mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			          } finally{
			               return mensaje.toString();
			          }
			     }
				 @RequestMapping(value = {"/obtenerRegistrosFinanciamiento"}, method = RequestMethod.POST)
				    @ResponseBody
				    public String obtenerRegistrosFinanciamiento(Authentication authentication,@RequestParam("infCod") Integer infCod) {
			         String json;
			         ObjectMapper mapper = new ObjectMapper();
			         List<TblFinanciamientoDTO> listaFinanciamientoDTO = new ArrayList<>();
			     	try {
			     		List<TblFinanciamiento> listaRegistros =financiamiento.obtenerRegistroFinanciamiento(infCod);	 
			     		DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
                        simbolo.setDecimalSeparator('.');
                         simbolo.setGroupingSeparator(',');
                        DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
			     		listaFinanciamientoDTO = listaRegistros.stream()
								.map(obj -> TblFinanciamientoDTO.builder()
										.finCod(obj.getFinCod())
										.finAsignacion(formateador.format(obj.getFinAsignacion()))
										.finIngresoventa(formateador.format(obj.getFinIngresoventa()))
										.finIngresoproducto(formateador.format(obj.getFinIngresoproducto()))
										.finFondos(formateador.format(obj.getFinFondos()))
										.build())
								.collect(Collectors.toList());
						json = (!listaFinanciamientoDTO.isEmpty())
								? MESSAGE_OK_JSON + mapper.writeValueAsString(listaFinanciamientoDTO) + "}"
								: MESSAGE_EMPTY_JSON;

					} catch (Exception e) {
						json = MESSAGE_ERROR_JSON + e.getMessage() + "}";
					}    
					

				         return json;
				    }
				 
				 
				 @RequestMapping("/view/rendicion/Frm_Finalizar_Medios_Comunicacion")
				    public String Frm_Finalizar_Medios_Comunicacion(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
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
				   	 	 	String verificador = verificarInformeMedios(codigoInforme, Constantes.periodo());
					   	 	model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
							model.addAttribute("infAutCod", verificarInforme.getInstCod());
							model.addAttribute("infAutPeriodo", verificarInforme.getInfPeriodo());
							model.addAttribute("infAutPeriodo", verificarInforme.getInfPeriodo());
							model.addAttribute("infocod", verificarInforme.getInfCod());
				   	 	 	if(verificador.equals("completo") && !verificarInforme.getInfEstado().trim().equals("finalizado")) {
				   	 	 	model.addAttribute("inf_estado", "completo");	 		
				   	 	 	}else {
				   	 	 	model.addAttribute("inf_estado",verificarInforme.getInfEstado());
				   	 	 
				   	 	 	model.addAttribute("mensaje", verificador);
				   	 	 	
							
				   	 	 	}
				   	 	}
				         return "rendicion/Frm_Finalizar_Medios_Comunicacion";
				    }
					
					@RequestMapping(value = "view/rendicion/verificarInformeMedios")
					public @ResponseBody String verificarInformeMedios(@RequestParam(value = "infAutCod") Integer infCod,  @RequestParam(value = "infAutPeriodo") Integer infAutPeriodo) {
						JSONObject mensaje = new JSONObject();
						mensaje.put("estado", "error");
						mensaje.put("mensaje", "Ha ocurrido un error!");
						String resultado="";
					
						try {
							String verificaInfAut = infor.listarInstitucionMedios(infCod, infAutPeriodo);
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
					@RequestMapping(value = "view/rendicion/FinalizarInformeMedios")
					public @ResponseBody String FinalizarInformeMedios(Authentication authentication,@RequestParam(value = "infAutCod") Integer instCod,  @RequestParam(value = "infAutPeriodo") Integer infPeriodo
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
								Date fechaControl = format.parse(Constantes.FECHA_CIERRE_INFORME_MEDIOS_COMUNICACION);
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
