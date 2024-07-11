package gob.cpccs.controller.rendicion;


import java.text.DateFormat;
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

import gob.cpccs.controller.HomeController;
import gob.cpccs.model.catalogos.TblInstitucion;
import gob.cpccs.model.dto.rendicion.CoberturaFDEDTO;
import gob.cpccs.model.dto.rendicion.CumplimientoObligacionesIESDTO;
import gob.cpccs.model.dto.rendicion.IncorporacionAportesCiudadanosIESDTO;
import gob.cpccs.model.dto.rendicion.MecanismosIESDTO;
import gob.cpccs.model.dto.rendicion.ObligacionesInternasIESDTO;
import gob.cpccs.model.dto.rendicion.PlanificacionIESDTO;
import gob.cpccs.model.dto.rendicion.PlanificacionParticipativaIESDTO;
import gob.cpccs.model.dto.rendicion.PoliticasIgualdadGADDTO;
import gob.cpccs.model.dto.rendicion.SedesExtensionesIESDTO;
import gob.cpccs.model.rendicion.TblArticulacionPp;
import gob.cpccs.model.rendicion.TblCoberturaGeografica;
import gob.cpccs.model.rendicion.TblCoberturaNacional;
import gob.cpccs.model.rendicion.TblCompromisosInformeant;
import gob.cpccs.model.rendicion.TblPlanificacionParticipativa;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblMecanismoParticipacionCiudadana;
import gob.cpccs.model.usuario.TblResponables;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.service.catalogos.CatalogosServicio;
import gob.cpccs.service.catalogos.InstitucionServicio;
import gob.cpccs.service.mail.EmailService;
import gob.cpccs.service.rendicion.CoberturaGeograficaService;
import gob.cpccs.service.rendicion.CoberturaNacionalService;
import gob.cpccs.service.rendicion.CompromisosInformeAntioresService;
import gob.cpccs.service.rendicion.InformeServicio;
import gob.cpccs.service.rendicion.MecanismoParticipacionServicio;
import gob.cpccs.service.rendicion.PlanificacionParticipativaService;
import gob.cpccs.service.rendicion.PlanificacionPoliticasPublicasService;
import gob.cpccs.service.usuario.ResponsableServicio;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;

@Controller
public class InformeFuncionesEstadoController {
	@Autowired
    private HomeController hc;
	@Autowired
	private UsuarioServicio usu;
	@Autowired
	private InformeServicio infor;
	@Autowired
	private CatalogosServicio gcs;
	@Autowired
	private CoberturaNacionalService CoberturaNacionalService;
	@Autowired
	private CoberturaGeograficaService CoberGeogr;
	@Autowired
	private PlanificacionParticipativaService PlanifPart;
	@Autowired
	private MecanismoParticipacionServicio Meparticipacion;
	@Autowired
	private CompromisosInformeAntioresService ComproInforAnter;
	@Autowired
	private PlanificacionPoliticasPublicasService PlaniPoliti;
	@Autowired
    private EmailService ms;
	@Autowired
	private ResponsableServicio respon;
	@Autowired
	private InstitucionServicio is;
	@Autowired
	private InstitucionServicio servicioinstitucion;
	
	//Cobertura Territorial Funciones del Estado//
	@RequestMapping(value = {"/obtenerCoberturaTerritoriales"}, method = RequestMethod.POST)
	@ResponseBody 
	public String obtenerCoberturaTerritoriales(Authentication authentication,@Param(value = "infCod") Integer infCod) {
		String json;
		ObjectMapper mapper = new ObjectMapper(); 
    	List<CoberturaFDEDTO> lista = new ArrayList<>();
		
		try {
			
			TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
			
			//List<Object[]> listaCoberturaTerritorial = CoberturaNacionalService.OntenerRegistrosImplCoberturaNacionalXcod(tblInforme);
			List<TblCoberturaNacional> listaCoberturaTerritorial= CoberturaNacionalService.obtenerRegistroCoberturaNacionalXInfCodAndTipo(tblInforme.getInfCod(),"EOD");    		
			
			if (listaCoberturaTerritorial.size()> 0) {			
				
				lista=listaCoberturaTerritorial.stream().map(obj->CoberturaFDEDTO.builder()
						.cn_cod(obj.getCnCod())
						.contador(listaCoberturaTerritorial.indexOf(obj)+1)
						.cobertura(obj.getCnCobertura())
						.unidades(obj.getCnUnidades())
						.descripcion(obj.getCnDescripcion())
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
	
	@RequestMapping("/view/rendicion/Frm_EjecutivoCoberturaTerritorial")
    public String Frm_EjecutivoCoberturaTerritorial(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   	 
   		List<TblCoberturaNacional> listaCoberturaTerritorial= CoberturaNacionalService.obtenerRegistroCoberturaNacionalXInfCodAndTipo(verificarInforme.getInfCod(),"EOD");    
 
        TblInstitucion	tblInstitucion=gcs.ObtenerInstitucionesXidEstado(verificarInforme.getInstCod(), Constantes.ESTADO, Constantes.periodo());
   		if(listaCoberturaTerritorial.size() ==0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("inf_Cod", verificarInforme.getInfCod());
 		model.addAttribute("inst_tip_des", tblInstitucion.getInstTipDes());
		}
		else {
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
	        model.addAttribute("acciones", listaAcciones);
			model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_MATRIZ);
			 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			model.addAttribute("inf_Cod", verificarInforme.getInfCod());
			model.addAttribute("inst_tip_des", tblInstitucion.getInstTipDes());
		}		
		}
         return "rendicion/Frm_EjecutivoCoberturaTerritorial";
    }
	
	@RequestMapping(value = "/view/rendicion/Frm_EjecutivoCoberturaTerritorialActul", method = RequestMethod.POST)
    public String Frm_EjecutivoCoberturaTerritorialActul(Model model, Authentication authentication) {			
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
  		model.addAttribute("inf_Cod", verificarInforme.getInfCod());		
		
         return "rendicion/Frm_EjecutivoCoberturaTerritorialActul";
    }
	
	
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarCoberturaTerritorial")
    public @ResponseBody String guardarCoberturaTerritorial(HttpServletRequest request,@RequestParam("infCod") int infCod,
    		@RequestParam("cnCobertura") String cnCobertura,
    		@RequestParam("cnUnidades") int cnUnidades,
    		@RequestParam("cnDescripcion") String cnDescripcion,
    		@RequestParam("tipo") String tipo) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
        	    TblCoberturaNacional tblCoberturaNacional = new TblCoberturaNacional();
 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
        	    tblCoberturaNacional.setCnCobertura(cnCobertura);
        		tblCoberturaNacional.setCnUnidades(cnUnidades);
        		tblCoberturaNacional.setCnDescripcion(cnDescripcion.toUpperCase());
        		tblCoberturaNacional.setCnTipo(tipo);
        		tblCoberturaNacional.setCnestado(Constantes.ESTADO);
        		tblCoberturaNacional.setInfCod(tblInforme);
        		CoberturaNacionalService.guardarCoberturaNacional(tblCoberturaNacional);
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
				 
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }
	// Fin Cobertura Territorial //
	
   //Cobertura Geografica //
	
	@RequestMapping(value = {"/obtenerCoberturaGeografica"}, method = RequestMethod.POST)
	@ResponseBody 
	public String obtenerCoberturaGeografica(Authentication authentication,@Param(value = "infCod") Integer infCod) {
		String json;
		ObjectMapper mapper = new ObjectMapper(); 
    	List<CoberturaFDEDTO> lista = new ArrayList<>();
		try {
			
			List<TblCoberturaGeografica> listaCoberturaGeografica= CoberGeogr.ObtenerRegistrosCoberturaGeograficaXInfCod(infCod);    		
			
			if (listaCoberturaGeografica.size()> 0) {			
				
				lista=listaCoberturaGeografica.stream().map(obj->CoberturaFDEDTO.builder()
						.cg_cod(obj.getCgCod())
						.contador(listaCoberturaGeografica.indexOf(obj)+1)
						.nivel(obj.getCgTipocobertura())
						.numeroatencion(obj.getCgCantidad())
						.cobertura(obj.getCgDescCobertura())
						.numerousuarios(obj.getCgTotal())
						.hombre(obj.getCgHombres())
						.mujer(obj.getCgMujeres())
						.glbti(obj.getCgGlbti())
						.montubios(obj.getCgMontubios())
						.cholos(obj.getCgCholos())
						.indigenas(obj.getCgIndigenas())
						.mestizos(obj.getCgMestizos())
						.afroecuatorianos(obj.getCgAfroecuatoriano())
						.link(obj.getCgLink())
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
	@RequestMapping("/view/rendicion/Frm_EjecutivoCoberturaGeografica")
    public String Frm_EjecutivoCoberturaGeografica(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   	 
   		List<TblCoberturaGeografica> listaCoberturaGeografica= CoberGeogr.ObtenerRegistrosCoberturaGeograficaXInfCod(verificarInforme.getInfCod());    
 
        TblInstitucion	tblInstitucion=gcs.ObtenerInstitucionesXidEstado(verificarInforme.getInstCod(), Constantes.ESTADO, Constantes.periodo());
   		if(listaCoberturaGeografica.size() ==0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("inf_Cod", verificarInforme.getInfCod());
 		model.addAttribute("inst_tip_des", tblInstitucion.getInstTipDes());
		}
		else {
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
	        model.addAttribute("acciones", listaAcciones);
			model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_MATRIZ);
			 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			model.addAttribute("inf_Cod", verificarInforme.getInfCod());
			model.addAttribute("inst_tip_des", tblInstitucion.getInstTipDes());
		}		
		}
         return "rendicion/Frm_EjecutivoCoberturaGeografica";
    }
		
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarCoberturaGeografica")
    public @ResponseBody String guardarCoberturaGeografica(HttpServletRequest request,@RequestParam("infCod") int infCod,
    		@RequestParam("cgDescCobertura") String cgDescCobertura,
    		@RequestParam("cgTipocobertura") String cgTipocobertura,    		
    		@RequestParam("cgCantidad") Integer cgCantidad,
    		@RequestParam("cgTotal") Integer cgTotal,
    		@RequestParam("cgHombres") Integer cgHombres,
    		@RequestParam("cgMujeres") Integer cgMujeres,
    		@RequestParam("cgGlbti") Integer cgGlbti,
    		@RequestParam("cgMontubios") Integer cgMontubios,
    		@RequestParam("cgMestizos") Integer cgMestizos,
    		@RequestParam("cgCholos") Integer cgCholos,
    		@RequestParam("cgIndigenas") Integer cgIndigenas,
    		@RequestParam("cgAfroecuatoriano") Integer cgAfroecuatoriano,    		
    		@RequestParam("cgLink") String cgLink) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
	        	 TblCoberturaGeografica tblCoberturaGeografica= new TblCoberturaGeografica();
				 TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
	              
			    tblCoberturaGeografica.setInfCod(tblInforme);
			    tblCoberturaGeografica.setCgTipocobertura(cgTipocobertura);
	     	    tblCoberturaGeografica.setCgDescCobertura(cgDescCobertura.toUpperCase());	     	    
	     	    tblCoberturaGeografica.setCgCantidad(cgCantidad);
	     	    tblCoberturaGeografica.setCgTotal(cgTotal);
	     	    tblCoberturaGeografica.setCgHombres(cgHombres);
	     	    tblCoberturaGeografica.setCgMujeres(cgMujeres);
	     	    tblCoberturaGeografica.setCgGlbti(cgGlbti);
	     	    tblCoberturaGeografica.setCgMontubios(cgMontubios);
	     	    tblCoberturaGeografica.setCgCholos(cgCholos);
	     	    tblCoberturaGeografica.setCgIndigenas(cgIndigenas);
	     	    tblCoberturaGeografica.setCgMestizos(cgMestizos);	
	     	    tblCoberturaGeografica.setCgAfroecuatoriano(cgAfroecuatoriano);
	     	    tblCoberturaGeografica.setCgLink(cgLink);
        		CoberGeogr.guardarCoberturaGeografica(tblCoberturaGeografica);
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
				 
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }
	
	@RequestMapping(value = "/view/rendicion/Frm_EjecutivoCoberturaGeograficaAgregarNew", method = RequestMethod.POST)
    public String Frm_EjecutivoCoberturaGeograficaAgregarNew(Model model, Authentication authentication) {			
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
  		model.addAttribute("inf_Cod", verificarInforme.getInfCod());		
		
         return "rendicion/Frm_EjecutivoCoberturaGeograficaAgregarNew";
    }
	// Fin cobertura Geografica//
	
	//Planificacion Participativa//
	 private List<TblPlanificacionParticipativa> lista_PlanificacionParticipativa= new ArrayList<TblPlanificacionParticipativa>();
	 @RequestMapping(value = {"/PlanificacionParticipativa"}, method = RequestMethod.POST)
		@ResponseBody 
		public String PlanificacionParticipativa(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
			List<PlanificacionParticipativaIESDTO> lista = new ArrayList<>();
			try {
				
				List<TblPlanificacionParticipativa> listaPlaniPartic=PlanifPart.ObtenerRegistrosPlanificacionPartipativaXinfCod(infCod);
						
				if (listaPlaniPartic.size()>0) {
					
					lista=listaPlaniPartic.stream().map(obj->PlanificacionParticipativaIESDTO.builder()
							.pla_cod(obj.getPlaCod())
							.contador(listaPlaniPartic.indexOf(obj)+1)
							.planificacion(obj.getPlaDescripcion())
							.seleccion(obj.getPlaCumple())
							.link(obj.getPlaLink() == null ? "S/N": obj.getPlaLink().isEmpty() ? "S/N"  : obj.getPlaLink().toString())
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
		
	
	@RequestMapping("/view/rendicion/Frm_EjecutivoPlanificacion")
    public String Frm_EjecutivoPlanificacion(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   	 
   		List<TblPlanificacionParticipativa> listaPlanificacionParticipativa= PlanifPart.ObtenerRegistrosPlanificacionPartipativaXinfCod(verificarInforme.getInfCod());    
   		if(listaPlanificacionParticipativa.size() ==0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("inf_Cod", verificarInforme.getInfCod());
 		
		}
		else {			
			model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_MATRIZ);
			 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			model.addAttribute("inf_Cod", verificarInforme.getInfCod());
		}		
		}
         return "rendicion/Frm_EjecutivoPlanificacion";
    }
	
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarPlanificacionPart")
	public @ResponseBody String guardarPlanificacionPart(HttpServletRequest request,@RequestParam(value = "infCod") Integer inf_Cod,	
			@RequestParam(value = "part1") String part1,
			@RequestParam(value = "seleccion1") String seleccion1,
			@RequestParam(value = "link1", required = false) String link1,		
			@RequestParam(value = "part2") String part2,
			@RequestParam(value = "seleccion2") String seleccion2,
			@RequestParam(value = "link2", required = false) String link2) {
            
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {	
			TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());	
			List<TblPlanificacionParticipativa> listaPlanificacionParticipativa= PlanifPart.ObtenerRegistrosPlanificacionPartipativaXinfCod(tblInforme.getInfCod());
			if(listaPlanificacionParticipativa.size()==0) {
			lista_PlanificacionParticipativa.clear();
			GuardarPlaniPart(tblInforme, part1, seleccion1, link1);
			GuardarPlaniPart(tblInforme, part2, seleccion2, link2);
			if (lista_PlanificacionParticipativa.size()==2) {	
			for (TblPlanificacionParticipativa item : lista_PlanificacionParticipativa) {	
				Integer valor=PlanifPart.ObtenerRegistrosCount(inf_Cod, item.getPlaDescripcion());
				if(valor==0) {
				TblPlanificacionParticipativa tblPlanificacionParticipativa= new TblPlanificacionParticipativa();
				tblPlanificacionParticipativa.setInfCod(item.getInfCod());
				tblPlanificacionParticipativa.setPlaDescripcion(item.getPlaDescripcion());
				tblPlanificacionParticipativa.setPlaCumple(item.getPlaCumple());
				tblPlanificacionParticipativa.setPlaLink(item.getPlaLink());
				PlanifPart.GuardarPlanificacionParticipativa(tblPlanificacionParticipativa);
				}else { 
					TblPlanificacionParticipativa tblPlanificacionParticipativa= PlanifPart.ObtenerRegistrosPlanificacionPartipativaXinfCodNombre(inf_Cod, item.getPlaDescripcion());
					tblPlanificacionParticipativa.setInfCod(item.getInfCod());
					tblPlanificacionParticipativa.setPlaDescripcion(item.getPlaDescripcion());
					tblPlanificacionParticipativa.setPlaCumple(item.getPlaCumple());
					tblPlanificacionParticipativa.setPlaLink(item.getPlaLink());
					PlanifPart.GuardarPlanificacionParticipativa(tblPlanificacionParticipativa);	
				}
			}
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			
			}else {
				mensaje.put("estado", "ERROR");
				mensaje.put("mensaje", "Las Políticas no han sido ingresadas correctamente. Por favor revise.! ");
			}}
			else {
					mensaje.put("estado", "ERROR");
					mensaje.put("mensaje", "Los datos ya se han guardado anteriormente.! "); 
				}

			
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	private void GuardarPlaniPart(TblInforme tblInforme,String part, String seleccion, String link) {
		TblPlanificacionParticipativa tblPlanificacionParticipativa= new TblPlanificacionParticipativa();
		tblPlanificacionParticipativa.setInfCod(tblInforme);
		tblPlanificacionParticipativa.setPlaDescripcion(part);
		tblPlanificacionParticipativa.setPlaCumple(seleccion);
		tblPlanificacionParticipativa.setPlaLink(link);		
		lista_PlanificacionParticipativa.add(tblPlanificacionParticipativa);
		
	}
	
	
	//Fin Planificacion Participativa//
	
	// Mecanismos de Participacion ciudadana Ejecutio//
	 @RequestMapping(value = {"/obtenerMecanismoParticipacionEjecutivo"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerMecanismoParticipacionEjecutivo(Authentication authentication,@RequestParam("infCod") Integer infCod) {
	         String json;
	         ObjectMapper mapper = new ObjectMapper(); 
			 List<MecanismosIESDTO> lista = new ArrayList<>();
	         try{
	              List<TblMecanismoParticipacionCiudadana> listaRegistros =Meparticipacion.obtenerRegistroMecanismosPaticipacion(infCod);
	              if (listaRegistros.size() > 0){
	            	  
	            	  lista=listaRegistros.stream().map(obj->MecanismosIESDTO.builder()
	            			  .meca_cod(obj.getMecaCod())
	            			  .contador(listaRegistros.indexOf(obj)+1)
	            			  .nombre(obj.getMecaNombre())
	            			  .implementado(obj.getMecaImplementado())
	            			  .numero(obj.getMecaNumero())
	            			  .link(obj.getMecaMedioverifica())
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
	
	@RequestMapping("/view/rendicion/Frm_EjecutivoMecanismosParticipacion")
    public String Frm_EjecutivoMecanismosParticipacion(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   	 	  List<TblMecanismoParticipacionCiudadana> listaMecanismosPartici =Meparticipacion.obtenerRegistroMecanismosPaticipacion(verificarInforme.getInfCod());
   	 	
   	 	  if(listaMecanismosPartici.size() ==0) {
   	 	model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("inf_Cod", verificarInforme.getInfCod());
 		TblInstitucion TipoFormulario = is.ObtenerInstitucionesXIdcodigo(verificarInforme.getInstCod());
		model.addAttribute("Tipo_Formulario", TipoFormulario.getInstTfCod().getTfCod());
		}
		else {			
			model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_MATRIZ);
			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			model.addAttribute("inf_Cod", verificarInforme.getInfCod());
		}		
		}
         return "rendicion/Frm_EjecutivoMecanismosParticipacion";
    }
	
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarMecanismoParticipacionEjecutivo")
    public @ResponseBody String guardarMecanismoParticipacionEjecutivo(HttpServletRequest request,@RequestParam("infCod") int infCod,
    		@RequestParam("mecaNombre[]") String[] mecaNombre,
    		@RequestParam("mecaImplementado[]") String[] mecaImplementado,
    		@RequestParam("mecaNumero[]") String[] mecaNumero,
    		@RequestParam("mecaMedioverifica[]") String[] mecaMedioverifica) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
        	   
 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
 			   for (int i = 0; i < mecaNombre.length; i++){
 				   Integer valor=Meparticipacion.ContarMPC(infCod, mecaNombre[i]);
 				   if(valor==0) {
 					  TblMecanismoParticipacionCiudadana tblMecanismoParticipacionCiudadana = new TblMecanismoParticipacionCiudadana();			  
 		 				tblMecanismoParticipacionCiudadana.setMecaNombre(mecaNombre[i]);
 		 				tblMecanismoParticipacionCiudadana.setMecaImplementado(mecaImplementado[i]);
 		 				tblMecanismoParticipacionCiudadana.setMecaMedioverifica(mecaMedioverifica[i]);
 		 				tblMecanismoParticipacionCiudadana.setMecaNumero(Integer.parseInt(mecaNumero[i])); 	
 		 				tblMecanismoParticipacionCiudadana.setMecaTi("MECANISMOS DE PARTICIPACION CIUDADANA");
 		 				tblMecanismoParticipacionCiudadana.setInfCod(tblInforme);
 		 			   Meparticipacion.guardarMecanismos(tblMecanismoParticipacionCiudadana);
 				   }else {
 					  TblMecanismoParticipacionCiudadana tblMecanismoParticipacionCiudadana = Meparticipacion.obtenerRegistroMecanismosPaticipacionNombre(infCod, mecaNombre[i]);
		 				tblMecanismoParticipacionCiudadana.setMecaNombre(mecaNombre[i]);
		 				tblMecanismoParticipacionCiudadana.setMecaImplementado(mecaImplementado[i]);
		 				tblMecanismoParticipacionCiudadana.setMecaMedioverifica(mecaMedioverifica[i]);
		 				tblMecanismoParticipacionCiudadana.setMecaNumero(Integer.parseInt(mecaNumero[i])); 	
		 				tblMecanismoParticipacionCiudadana.setMecaTi("MECANISMOS DE PARTICIPACION CIUDADANA");
		 				tblMecanismoParticipacionCiudadana.setInfCod(tblInforme);
		 			   Meparticipacion.guardarMecanismos(tblMecanismoParticipacionCiudadana);
 				   }
 				  
 			  }
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
				 
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }
	
	//Fin Mecanismos de Participacion ciudadana Ejecutio//
	
	//Incorporacion de aportes ciudadanos Ejecutivo//
	
	
	 @RequestMapping(value = {"/obtenerRegistrosCompromisosAnteriores"}, method = RequestMethod.POST)
    @ResponseBody
    public String obtenerRegistrosCompromisosAnteriores(Authentication authentication,@RequestParam("infCod") Integer infCod) {
         String json;
         ObjectMapper mapper = new ObjectMapper(); 
		 List<IncorporacionAportesCiudadanosIESDTO> lista = new ArrayList<>();
         try{
              List<TblCompromisosInformeant> listaRegistrosCompromisosInformeant =ComproInforAnter.ObtenerRegistrosCompromisosAnterioresXInfCod(infCod);
              if (listaRegistrosCompromisosInformeant.size() > 0){
            	  
                   for (TblCompromisosInformeant datos : listaRegistrosCompromisosInformeant){
                	   IncorporacionAportesCiudadanosIESDTO tabla1 = new IncorporacionAportesCiudadanosIESDTO();  
                	   tabla1.setCa_cod(datos.getCaCod());
                	   tabla1.setContador(listaRegistrosCompromisosInformeant.indexOf(datos)+1);
                	   if(datos.getCaNombre().isEmpty() || datos.getCaNombre()==null) {tabla1.setNombre("S/N");}else {tabla1.setNombre(datos.getCaNombre().toString());}
                	   tabla1.setImplementado(datos.getCaImplementado());
                	   tabla1.setAvance(datos.getCaAvance());
                	   if(datos.getCaDes().isEmpty() || datos.getCaDes()==null) {tabla1.setDescripcion("S/N");}else {tabla1.setDescripcion(datos.getCaDes().toString());}
                	   tabla1.setLink(datos.getCaMedioverif());
                	   lista.add(tabla1);

                   }
                  
                   json = (!lista.isEmpty())
							? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
							: Constantes.MESSAGE_EMPTY_JSON;

                   //json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
              	} else{
            	  json = "{\"Error\": []}";
              }

         } catch (Exception e){
              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

         }

         return json;
    }
	
	@RequestMapping("/view/rendicion/Frm_EjecutivoAportes")
    public String Frm_EjecutivoAportes(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   	 	  List<TblCompromisosInformeant> listaComproInforAnter = ComproInforAnter.ObtenerRegistrosCompromisosAnterioresXInfCod(verificarInforme.getInfCod());
   		if(listaComproInforAnter.size() ==0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("inf_Cod", verificarInforme.getInfCod());
 		
		}
		else {			
			model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_MATRIZ);
			 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			model.addAttribute("inf_Cod", verificarInforme.getInfCod());
		}		
		}
         return "rendicion/Frm_EjecutivoAportes";
    }
	
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarCompromisosInformesAnter")
    public @ResponseBody String guardarCompromisosInformesAnter(HttpServletRequest request,@RequestParam("infCod") int infCod,
    		@RequestParam(value = "caNombre", required = false) String caNombre,
    		@RequestParam("caImplementado") String caImplementado,
    		@RequestParam(value = "caAvance", required = false) String caAvance,
    		@RequestParam(value ="caDes", required = false) String caDes,    		
    		@RequestParam(value ="caMedioverif", required = false) String caMedioverif) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
        	   
 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
 				 TblCompromisosInformeant tblCompromisosInformeant = new TblCompromisosInformeant();
 				 tblCompromisosInformeant.setCaNombre(caNombre);
 				 tblCompromisosInformeant.setCaImplementado(caImplementado);
 				 tblCompromisosInformeant.setCaAvance(caAvance);
 				 tblCompromisosInformeant.setCaDes(caDes);
 				 tblCompromisosInformeant.setCaMedioverif(caMedioverif);
 				 tblCompromisosInformeant.setInfCod(tblInforme);
 			   ComproInforAnter.guardarCoberturaGeografica(tblCompromisosInformeant);
 			  
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
				 
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }

	//Fin Incorporacion de aportes ciudadanos Ejecutivo//
	
	// Planificacion: se refiere a politicas publicas //
	 @RequestMapping(value = {"/obtenerRegistrosPlanificacionPoliticas"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerRegistrosPlanificacionPoliticas(Authentication authentication,@RequestParam("infCod") Integer infCod) {
	         String json;
	         ObjectMapper mapper = new ObjectMapper(); 
		     List<PlanificacionIESDTO> lista = new ArrayList<>();
	         try{
	              List<TblArticulacionPp> listaRegistrosPlaificacionPoliticas =PlaniPoliti.obtenerRegistrosPlanificacionPoliticasPublicasXinfoCod(infCod);
	              if (listaRegistrosPlaificacionPoliticas.size() > 0){
	            	  
	            	  lista=listaRegistrosPlaificacionPoliticas.stream().map(obj->PlanificacionIESDTO.builder()
	            			  .app_cod(obj.getAppCod())
	            			  .contador(listaRegistrosPlaificacionPoliticas.indexOf(obj)+1)
	            			  .nombre(obj.getAppDescripcion())
	            			  .valida(obj.getAppArticulacion())
	            			  .link(obj.getAppMedioverif())
	            			  .build())
	            			  .collect(Collectors.toList());
	            	  json = (!lista.isEmpty())
								? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
								: Constantes.MESSAGE_EMPTY_JSON;
	            	  } else{
	            	  json = "{\"Error\": []}";
	              }

	         } catch (Exception e){
	              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

	         }

	         return json;
	    }
	
	@RequestMapping("/view/rendicion/Frm_EjecutivoArticulacion")
    public String Frm_EjecutivoArticulacion(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   	 	  List<TblArticulacionPp> listaPlanificacionPoliticas = PlaniPoliti.obtenerRegistrosPlanificacionPoliticasPublicasXinfoCod(verificarInforme.getInfCod());
   		if(listaPlanificacionPoliticas.size() ==0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("inf_Cod", verificarInforme.getInfCod());
 		TblInstitucion TipoFormulario = is.ObtenerInstitucionesXIdcodigo(verificarInforme.getInstCod());
		model.addAttribute("Tipo_Formulario", TipoFormulario.getInstTfCod().getTfCod());
 		
		}
		else {			
			model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_MATRIZ);
			 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			model.addAttribute("inf_Cod", verificarInforme.getInfCod());
		}		
		}
         return "rendicion/Frm_EjecutivoArticulacion";
    }
	
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarArticulacionPolitica")
    public @ResponseBody String guardarArticulacionPolitica(HttpServletRequest request,@RequestParam("infCod") int infCod,
    		@RequestParam("appDescripcion[]") String[] appDescripcion,
    		@RequestParam("appArticulacion[]") String[] appArticulacion,
    		@RequestParam("appMedioverif[]") String[] appMedioverif) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
        	   
 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
 			   for (int i = 0; i < appDescripcion.length; i++){
 				   Integer valor=PlaniPoliti.CountarPoliticaP(infCod, appDescripcion[i]);
 				   if(valor==0) {
 					  TblArticulacionPp tblArticulacionPp = new TblArticulacionPp();
 		 			  	tblArticulacionPp.setAppDescripcion(appDescripcion[i]);
 		 			  	tblArticulacionPp.setAppArticulacion(appArticulacion[i]);
 		 			  	tblArticulacionPp.setAppMedioverif(appMedioverif[i]); 			  	
 		 			  	tblArticulacionPp.setInfCod(tblInforme);
 		 			  	PlaniPoliti.guardarPlanificacionPoliticas(tblArticulacionPp); 
 				   }else {
 					  TblArticulacionPp tblArticulacionPp =PlaniPoliti.PlanificacionPoliticasPublicasXinfoCodNombre(infCod, appDescripcion[i]);
		 			  	tblArticulacionPp.setAppDescripcion(appDescripcion[i]);
		 			  	tblArticulacionPp.setAppArticulacion(appArticulacion[i]);
		 			  	tblArticulacionPp.setAppMedioverif(appMedioverif[i]); 			  	
		 			  	tblArticulacionPp.setInfCod(tblInforme);
		 			  	PlaniPoliti.guardarPlanificacionPoliticas(tblArticulacionPp);
 				   }
 				
 			  }
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
				 
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }
	
	//Fin Planificacion: se refiere a politicas publicas//
	
	  @RequestMapping("/view/rendicion/Frm_Finalizar_Funciones_Estado")
	    public String Frm_Finalizar_Funciones_Estado(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
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
	   	 	 	String verificador = verificarInformeFE(codigoInforme, Constantes.periodo());
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
	         return "rendicion/Frm_Finalizar_Funciones_Estado";
	    }
		
		@RequestMapping(value = "view/rendicion/verificarInformeFE")
		public @ResponseBody String verificarInformeFE(@RequestParam(value = "infAutCod") Integer infCod,  @RequestParam(value = "infAutPeriodo") Integer infAutPeriodo) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			String resultado="";
		
			try {
				String verificaInfAut = infor.listarInstitucionFE(infCod, infAutPeriodo);
				Integer contador = verificaInfAut.length();
				if (contador==56) {
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
		@RequestMapping(value = "view/rendicion/FinalizarInformeFE")
		public @ResponseBody String FinalizarInformeFE(Authentication authentication,@RequestParam(value = "infAutCod") Integer instCod,  @RequestParam(value = "infAutPeriodo") Integer infPeriodo
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
					Date fechaControl = format.parse(Constantes.FECHA_CIERRE_INFORME_FUNCIONES_ESTADO);
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
