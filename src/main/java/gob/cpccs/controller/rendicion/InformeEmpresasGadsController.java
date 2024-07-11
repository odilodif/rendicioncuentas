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
import gob.cpccs.model.dto.rendicion.AspectosPresupuestariosIESDTO;
import gob.cpccs.model.dto.rendicion.CumplimientoObligacionesIESDTO;
import gob.cpccs.model.dto.rendicion.InformacionFinancieraEPGADDTO;
import gob.cpccs.model.dto.rendicion.MecanismosGADDTO;
import gob.cpccs.model.rendicion.TblCumplimientoObligaciones;
import gob.cpccs.model.rendicion.TblInformacionFinanciera;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.usuario.TblResponables;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.service.catalogos.CatalogosServicio;
import gob.cpccs.service.catalogos.InstitucionServicio;
import gob.cpccs.service.mail.EmailService;
import gob.cpccs.service.rendicion.CumplimientoObligacionesServicio;
import gob.cpccs.service.rendicion.InformacionFinancieraService;
import gob.cpccs.service.rendicion.InformeServicio;
import gob.cpccs.service.usuario.ResponsableServicio;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;

@Controller
public class InformeEmpresasGadsController {
	@Autowired
    private HomeController hc;
	@Autowired
	private UsuarioServicio usu;
	@Autowired
	private InformeServicio infor;
	@Autowired
	private CumplimientoObligacionesServicio cumplimiento;
	@Autowired
	private InformacionFinancieraService informacion;
	@Autowired
	private CatalogosServicio gcs;
	@Autowired
    private EmailService ms;
	@Autowired
	private ResponsableServicio respon;
	@Autowired
	private InstitucionServicio servicioinstitucion;
	
	@RequestMapping("/view/rendicion/Frm_InformacionFinanciera")
    public String Frm_InformacionFinanciera(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
   	 	
   	   	 	model.addAttribute("inf_estado", "vacio");		

   	 	}else {
      	     List<TblInformacionFinanciera> verificarMatriz= informacion.obtenerRegistroInfromacionFinanciera(verificarInforme.getInfCod());

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
         return "rendicion/Frm_InformacionFinanciera";
    }
	@RequestMapping("/view/rendicion/FrmCumplimientoObligaciones")
    public String FrmCumplimientoObligaciones(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
   	   	 	model.addAttribute("inf_estado", "vacio");		

   	 	}else {
      	     List<TblCumplimientoObligaciones> verificarMatriz= cumplimiento.obtenerRegistroCumplimientoObligaciones(verificarInforme.getInfCod());

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
         return "rendicion/FrmCumplimientoObligaciones";
    }
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarInformacionFinanciera")
    public @ResponseBody String guardarInformacionFinanciera(HttpServletRequest request,@RequestParam("infCod") int infCod,@RequestParam(value = "infActivos") String infActivos, 
    		@RequestParam(value = "infPasivos") String infPasivos,@RequestParam(value = "infPatrimonio") String infPatrimonio,@RequestParam(value = "infLinkbalance") String infLinkbalance		) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
        	   
 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
 			  
 			    TblInformacionFinanciera tblMecanismosTrasparencia = new TblInformacionFinanciera();
 			   String activos=infActivos.toString().replace(",", "").trim();
 			  String pasivos=infPasivos.toString().replace(",", "").trim();
 			 String patrimonio=infPatrimonio.toString().replace(",", "").trim();
 				  tblMecanismosTrasparencia.setInfActivos(new BigDecimal(activos));
 				   tblMecanismosTrasparencia.setInfCod(tblInforme);
 				  tblMecanismosTrasparencia.setInfPasivos(new BigDecimal(pasivos));
 				 tblMecanismosTrasparencia.setInfPatrimonio(new BigDecimal(patrimonio));
 				 tblMecanismosTrasparencia.setInfLinkbalance(infLinkbalance);
 				informacion.guardarInformacionFinanciera(tblMecanismosTrasparencia);
 			   
 			   
 			    
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
				 
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarCumplimientoObligaciones")
	public @ResponseBody String guardarCumplimientoObligaciones(HttpServletRequest request,@RequestParam("infCod") int infCod,@RequestParam(value = "infLaborales") String infLaborales, 
    		@RequestParam(value = "infTributarias") String infTributarias,@RequestParam(value = "infLinkcumplimiento") String infLinkcumplimiento		) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
        	   
 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
 			  
 			    TblCumplimientoObligaciones tblGuardarregistro = new TblCumplimientoObligaciones();
 				 tblGuardarregistro.setInfCod(tblInforme);
 				tblGuardarregistro.setInfLaborales(infLaborales);
 				tblGuardarregistro.setInfTributarias(infTributarias);
 				tblGuardarregistro.setInfLinkcumplimiento(infLinkcumplimiento.replaceAll(System.getProperty("line.separator"), " "));
 				cumplimiento.guardarCumplimientoObligaciones(tblGuardarregistro);
 			   
 			   
 			    
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
				 
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }
	 @RequestMapping(value = {"/obtenerRegistrosInformacionFinanciera"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerRegistrosInformacionFinanciera(Authentication authentication,@RequestParam("infCod") Integer infCod) {
	         String json;
	         ObjectMapper mapper = new ObjectMapper(); 
			 List<InformacionFinancieraEPGADDTO> lista = new ArrayList<>();
	         try{
	              StringBuilder resultado = new StringBuilder();
	              List<TblInformacionFinanciera> listaRegistros =informacion.obtenerRegistroInfromacionFinanciera(infCod);	               
	              DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
                  simbolo.setDecimalSeparator('.');
                  simbolo.setGroupingSeparator(',');
                  DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
	              if (listaRegistros.size() > 0){
	            	  
	            	  lista=listaRegistros.stream().map(obj->InformacionFinancieraEPGADDTO.builder()
	            			  .codFinan(obj.getCodFinan())
	            			  .contador(listaRegistros.indexOf(obj)+1)
	            			  .activo(formateador.format(obj.getInfActivos()).toString())
	            			  .pasivos(formateador.format(obj.getInfPasivos()).toString())
	            			  .patrimonio(formateador.format(obj.getInfPatrimonio()).toString())
	            			  .link(obj.getInfLinkbalance())
	            			  .build())
	            			  .collect(Collectors.toList());
	            	  json = (!lista.isEmpty())
								? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
								: Constantes.MESSAGE_EMPTY_JSON;
	            	  
	                   /*for (TblInformacionFinanciera datos : listaRegistros){

                       DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
                         simbolo.setDecimalSeparator('.');
                          simbolo.setGroupingSeparator(',');
                         DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
                          String activos=formateador.format(datos.getInfActivos()); 
                          String pasivos=formateador.format(datos.getInfPasivos());
                          String patrimonio=formateador.format(datos.getInfPatrimonio());
	                        resultado.append("{\"CodFinan\":\"" + datos.getCodFinan() + "\",\"" + "contador\":\""
	                             + (listaRegistros.indexOf(datos) + 1) + "\",\"" + "activo\":\"" + activos+ "\",\"" 
	                             + "pasivos\":\""+ pasivos + "\",\"" + "patrimonio\":\"" + patrimonio + "\",\"" + "link\":\"" + datos.getInfLinkbalance()
	                             + "\"}").append(",");

	                   }

	                   json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
	             */ } else{
	            	  json = "{\"Error\": []}";
	              }

	         } catch (Exception e){
	              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

	         }

	         return json;
	    }
	 
	 @RequestMapping(value = {"/obtenerRegistrosCumplimientoInformacion"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerRegistrosCumplimientoInformacion(Authentication authentication,@RequestParam("infCod") Integer infCod) {
	         String json;
	         ObjectMapper mapper = new ObjectMapper(); 
		    List<CumplimientoObligacionesIESDTO> lista = new ArrayList<>();
	         try{
	              List<TblCumplimientoObligaciones> listaRegistros =cumplimiento.obtenerRegistroCumplimientoObligaciones(infCod);	               
	              if (listaRegistros.size() > 0){
	            	  lista=listaRegistros.stream().map(obj->CumplimientoObligacionesIESDTO.builder()
	            			  .cumOblCod(obj.getCumOblCod())
	            			  .contador(listaRegistros.indexOf(obj)+1)
	            			  .laborales(obj.getInfLaborales())
	            			  .tributarios(obj.getInfTributarias())
	            			  .link(obj.getInfLinkcumplimiento())
	            			  .build())
	            			  .collect(Collectors.toList());
	            	  json = (!lista.isEmpty())
								? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
								: Constantes.MESSAGE_EMPTY_JSON;
	            	  
	                   /*for (TblCumplimientoObligaciones datos : listaRegistros){
;
	                        resultado.append("{\"CumOblCod\":\"" + datos.getCumOblCod() + "\",\"" + "contador\":\""
	                             + (listaRegistros.indexOf(datos) + 1) + "\",\"" + "laborales\":\"" + datos.getInfLaborales()+ "\",\"" 
	                             + "tributarios\":\""+ datos.getInfTributarias() + "\",\"" + "link\":\"" + datos.getInfLinkcumplimiento()
	                             + "\"}").append(",");

	                   }

	                   json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
	              */} else{
	            	  json = "{\"Error\": []}";
	              }

	         } catch (Exception e){
	              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

	         }

	         return json;
	    }
	
	   
	   @RequestMapping("/view/rendicion/Frm_Finalizar_Informe_Gad_Ep")
	    public String Frm_Finalizar_Informe_Gad_Ep(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
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
	   	 	 	String verificador = verificarInformeGadEP(codigoInforme, Constantes.periodo());
		   	 	model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				model.addAttribute("infAutCod", verificarInforme.getInstCod());
				model.addAttribute("infAutPeriodo", verificarInforme.getInfPeriodo());
				model.addAttribute("infocod", verificarInforme.getInfCod());
	   	 	 	if(verificador.equals("completo") && !verificarInforme.getInfEstado().trim().equals("finalizado")) {
	   	 	 	model.addAttribute("inf_estado", "completo");	 		
	   	 	 	}else {
	   	 	 	model.addAttribute("inf_estado",verificarInforme.getInfEstado());
	   	 	 
	   	 	 	model.addAttribute("mensaje", verificador);
	   	 	 	
				
	   	 	 	}
	   	 	}
	         return "rendicion/Frm_Finalizar_Informe_Gad_Ep";
	    }
		
		@RequestMapping(value = "view/rendicion/verificarInformeGadEP")
		public @ResponseBody String verificarInformeGadEP(@RequestParam(value = "infAutCod") Integer infCod,  @RequestParam(value = "infAutPeriodo") Integer infAutPeriodo) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			String resultado="";
		
			try {
				String verificaInfAut = infor.listarInstitucionGADEP(infCod, infAutPeriodo);
				Integer contador = verificaInfAut.length();
				if (contador==71) {
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
		@RequestMapping(value = "view/rendicion/FinalizarInformeGadEP")
		public @ResponseBody String FinalizarInformeGadEP(Authentication authentication,@RequestParam(value = "infAutCod") Integer instCod,  @RequestParam(value = "infAutPeriodo") Integer infPeriodo
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
					Date fechaControl = format.parse(Constantes.FECHA_CIERRE_INFORME_GAD_EP);
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
