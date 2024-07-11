package gob.cpccs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

//import gob.cpccs.model.usuario.TblUsuarios;
import gob.cpccs.utilidades.Constantes;
import gob.cpccs.utilidades.webService.Bsg.ServiciosBsg;
import gob.cpccs.utilidades.webService.Bsg.accesoBsgService.ValidarPermisoRespuesta;
import gob.cpccs.utilidades.webService.Bsg.registroCivil.Ciudadano;
import gob.cpccs.utilidades.webService.Bsg.senescyt.GraduadoReporteDTO;
import gob.cpccs.utilidades.webService.Bsg.senescyt.NivelTitulosDTO;
import gob.cpccs.utilidades.webService.Bsg.sri.ContribuyenteCompleto;

@Controller
public class UtilidadesController {
	
	  @SuppressWarnings("finally")
	     @RequestMapping(value = "/consultarWebServiceBSG1")
	     public @ResponseBody String consultarWebServiceBSG1(@Param("tipoIdentificacion") String tipoIdentificacion, @Param("identificador") String identificador, @Param("tipo") String tipo) {

	          JSONObject mensaje = new JSONObject();
	          mensaje.put("estado", "error");
	          mensaje.put("mensaje", "Ha ocurrido un error!");
	          try{

	               Boolean puedeAcceder = false;
	               String rutaWebService = null;
	               Integer numUsuario=null;
	              // System.out.println("WebServ-->"+tipoIdentificacion);
	               switch (tipoIdentificacion) {
	                    case "Cédula":
	                         puedeAcceder = true;
	                         rutaWebService = Constantes.URL_WEB_SERVICES_REGISTRO_CIVIL;
	                    break;
	                    case "Ruc":
	                         puedeAcceder = true;
	                         rutaWebService = Constantes.URL_WEB_SERVICES_SRI;
	                    break;
	                    case "Pasaporte":
	                         puedeAcceder = true;
	                    break;
	                    case "Senescyt":
	                         puedeAcceder = true;
	                         rutaWebService = Constantes.URL_WEB_SERVICES_SENESCYT;
	                    break;
	                    default:
	                         puedeAcceder = false;
	               }

	               if (puedeAcceder){
	                   if(tipo.equals("interno")) {
	                        numUsuario=0;
	                   }else {
	                       //  numUsuario=us.contarUsuarioXidentificador(tblUsuarios.getIdentificador());
	                   }
	                    
	                    if(numUsuario<=0) {
	                    ValidarPermisoRespuesta acceso = ServiciosBsg.consultarWebServicesAutenticacion(rutaWebService);

	                    switch (tipoIdentificacion) {

	                         case "Cédula":

	                              Ciudadano datosC = ServiciosBsg.consultarWebServicesCedula(acceso, identificador);
	                              if (datosC.getCodigoError().equals("000")){
	                                   mensaje.put("estado", "exito");
	                                   mensaje.put("mensaje", datosC.getDesError());
	                                   Gson gson = new Gson();
	                                   String jsonString = gson.toJson(datosC);
	                                   JSONObject datosCedula = new JSONObject(jsonString);
	                                   mensaje.put("datos", datosCedula);
	                                   
	                              }if (datosC.getCodigoError().equals("005")) {
	                                   mensaje.put("estado", "error");
	                                   mensaje.put("mensaje", "Debe digitar 10 Digitos!");
	                                   
	                                   
	                              } else{
	                                   System.out.println("ERROR:" + datosC.getDesError());
	                                   mensaje.put("mensaje", datosC.getDesError());
	                              }
	                         break;

	                         case "Ruc":
	                              ContribuyenteCompleto datosR = ServiciosBsg.consultarWebServicesRUC(acceso, identificador);
	                              if (datosR.getCodError().equals("000")){
	                                   mensaje.put("estado", "exito");
	                                   mensaje.put("mensaje", datosR.getDesError());

	                                   Gson gson = new Gson();
	                                   String jsonString = gson.toJson(datosR);
	                                   JSONObject datosRuc = new JSONObject(jsonString);
	                                   mensaje.put("datos", datosRuc);


	                              } else{
	                                   mensaje.put("mensaje", datosR.getDesError());
	                              }
	                         break;

	                         case "Pasaporte":
	                              if (identificador.length() >= 7 && identificador.length() <= 13){
	                                   mensaje.put("estado", "exito");
	                                   mensaje.put("mensaje", "Pasaporte ingresado.");
	                              } else{
	                                   mensaje.put("mensaje", "Pasaporte debe tener entre 7 a 13 digitos.");

	                              }
	                         break;

	                         case "Senescyt":
	                              GraduadoReporteDTO datosCe = ServiciosBsg.consultarWebServicesSenescyt(acceso, identificador);

	                              List<NivelTitulosDTO> DatosDC = datosCe.getNiveltitulos();
	                              if (DatosDC.size() > 0){
	                                   mensaje.put("estado", "exito");
	                                   mensaje.put("mensaje", "Datos encontrados.");
	                                   ObjectMapper objectMapper = new ObjectMapper();
	                                   JsonNode listNode = objectMapper.valueToTree(DatosDC);
	                                   JSONArray datosCenescyt = new org.json.JSONArray(listNode.toString());
	                                   mensaje.put("datos", datosCenescyt);


	                              } else{
	                                   mensaje.put("mensaje", "Dato no encontrado.");
	                                   mensaje.put("datos", "");
	                              }

	                         break;

	                    }
	                     }
	                    else{
	                         mensaje.put("estado", "error");
	                         mensaje.put("mensaje", "Usuario ya se encuentra registrado!");
	                    }

	               }

	          } catch (Exception e){
	               mensaje.put("mensaje", e.getMessage());
	          } finally{
	               return mensaje.toString();
	          }
	     }
	  @RequestMapping(value = "errores", method = RequestMethod.GET)
	     public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
	          
	         ModelAndView errorPage = new ModelAndView("error/paginaError");
	         String errorMsg = "";
	         
	         Integer httpErrorCode = getErrorCode(httpRequest);
	         String errorUri = getRequestUri(httpRequest);
	       
	         switch (httpErrorCode) {
	             case 400: {
	                 errorMsg = "Se produjo un error de http: <b>400.</b><br/>Solicitud incorrecta.";
	                 break;
	             }
	             case 401: {
	                 errorMsg = "Se produjo un error de http: <b>401.</b><br/>No autorizado.";
	                 break;
	             }
	             case 403: {
	                  errorMsg = "Se produjo un error http: <b>403.</b><br/>Acceso a la página denegado.";
	                  break;
	              }
	             case 404: {
	                 errorMsg = "Se produjo un error http: <span><b>404.</b></span><br/>Página solicitada no encontrada.";
	                 break;
	             }case 405: {
	                  errorMsg = "Se produjo un error http: <span><b>405.</b></span><br/>Método de la solicitud no permitido.";
	                  break;
	              }
	             case 500: {
	                 errorMsg = "Se produjo un error de http: <b>500.</b><br/>Error interno del servidor.";
	                 break;
	             }
	         }
	      
	         errorPage.addObject("errorMsg", errorMsg);
	         errorPage.addObject("errorUri", errorUri);
	         
	         return errorPage;
	     }
	      
	     private int getErrorCode(HttpServletRequest httpRequest) {
	         return (Integer) httpRequest
	           .getAttribute("javax.servlet.error.status_code");
	     }
	     

	     private String getRequestUri(HttpServletRequest httpRequest) {
	          
	          return (String) httpRequest
	            .getAttribute("javax.servlet.error.request_uri");
	      }




}
