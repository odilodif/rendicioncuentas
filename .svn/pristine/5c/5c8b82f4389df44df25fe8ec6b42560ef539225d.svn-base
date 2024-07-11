package gob.cpccs.utilidades.webService.Bsg;

import java.rmi.RemoteException;
import gob.cpccs.utilidades.webService.Bsg.senescyt.ConsWsException;
import gob.cpccs.utilidades.webService.Bsg.senescyt.GraduadoReporteDTO;
import gob.cpccs.utilidades.webService.Bsg.senescyt.ServicioConsultaTituloService;
import gob.cpccs.utilidades.webService.Bsg.senescyt.WSConsultaTitulosService;
import gob.cpccs.utilidades.webService.Bsg.sri.ContribuyenteCompleto;
import gob.cpccs.utilidades.webService.Bsg.sri.WebServiceContribuyenteService;
import gob.cpccs.utilidades.webService.Bsg.sri.WsConsultaContribuyente;
import gob.cpccs.utilidades.Constantes;
import gob.cpccs.utilidades.webService.Bsg.accesoBsgService.BSG04_Acceder_BSGProxy;
import gob.cpccs.utilidades.webService.Bsg.accesoBsgService.ValidarPermisoPeticion;
import gob.cpccs.utilidades.webService.Bsg.accesoBsgService.ValidarPermisoRespuesta;
import gob.cpccs.utilidades.webService.Bsg.registroCivil.Ciudadano;
import gob.cpccs.utilidades.webService.Bsg.registroCivil.ConsultaCiudadano;
import gob.cpccs.utilidades.webService.Bsg.registroCivil.ConsultaCiudadano_Service;

public class ServiciosBsg {


     public static DatosHeader construirDatosHeader(ValidarPermisoRespuesta validarPermisoRespuesta) {
          DatosHeader datosHeader = new DatosHeader();
          datosHeader.setDigest(validarPermisoRespuesta.getDigest());
          datosHeader.setFecha(validarPermisoRespuesta.getFecha());
          datosHeader.setFechaf(validarPermisoRespuesta.getFechaF());
          datosHeader.setNonce(validarPermisoRespuesta.getNonce());
          datosHeader.setUsuario(Constantes.USUARIO_ACCESO_WEBSERVICES_BSG);
          return datosHeader;
     }

     public static DatosHeader construirDatosHeaderAccesoAgro(ValidarPermisoRespuesta validarPermisoRespuesta) {
          DatosHeader datosHeader = new DatosHeader();
          datosHeader.setDigest(validarPermisoRespuesta.getDigest());
          datosHeader.setFecha(validarPermisoRespuesta.getFecha());
          datosHeader.setFechaf(validarPermisoRespuesta.getFechaF());
          datosHeader.setNonce(validarPermisoRespuesta.getNonce());
          datosHeader.setUsuario(Constantes.USUARIO_ACCESO_WEBSERVICES_BSG_AGRO);
          return datosHeader;
     }

     public static ValidarPermisoRespuesta consultarWebServicesAutenticacion(String urlWebServices) {

          String usuarioWebServices = null;
          if (urlWebServices == Constantes.URL_WEB_SERVICES_REGISTRO_CIVIL){
               usuarioWebServices = Constantes.USUARIO_ACCESO_WEBSERVICES_BSG_AGRO;
          } else{
               usuarioWebServices = Constantes.USUARIO_ACCESO_WEBSERVICES_BSG;
          }
          
          ValidarPermisoPeticion peticionClienteAcceso = new ValidarPermisoPeticion(usuarioWebServices, urlWebServices);
          BSG04_Acceder_BSGProxy accesoServidor = new BSG04_Acceder_BSGProxy();
          ValidarPermisoRespuesta validarPermisoRespuesta = null;
          
          try{
               validarPermisoRespuesta = accesoServidor.validarPermiso(peticionClienteAcceso);
               if (validarPermisoRespuesta.getMensaje().getCodError().equals("000")){
                    if (validarPermisoRespuesta.getTienePermiso().equals("S"))
                         return validarPermisoRespuesta;
               }

          } catch (RemoteException e){
               //System.out.println("ERROR: " + e.getMessage());
               e.printStackTrace();

          }

          return validarPermisoRespuesta;
     }

     public static ContribuyenteCompleto consultarWebServicesRUC(ValidarPermisoRespuesta validarPermisoRespuesta, String identificadorCiudadano) {
          DatosHeader datosHeader = construirDatosHeader(validarPermisoRespuesta);
          HeaderHandlerResolver headerHandlerResolver = new HeaderHandlerResolver(datosHeader);
          WebServiceContribuyenteService servicio = new WebServiceContribuyenteService();
          servicio.setHandlerResolver(headerHandlerResolver);
          WsConsultaContribuyente puerto = servicio.getWsConsultaContribuyentePort();
          ContribuyenteCompleto datosRespuestaR = puerto.obtenerCompleto(identificadorCiudadano, "");

          return datosRespuestaR;



     }

     public static Ciudadano consultarWebServicesCedula(ValidarPermisoRespuesta validarPermisoRespuesta, String identificadorCiudadano) {
          DatosHeader datosHeader = construirDatosHeaderAccesoAgro(validarPermisoRespuesta);
          HeaderHandlerResolver headerHandlerResolver = new HeaderHandlerResolver(datosHeader);

          ConsultaCiudadano_Service servicioCedula = new ConsultaCiudadano_Service();
          servicioCedula.setHandlerResolver(headerHandlerResolver);
          ConsultaCiudadano puerto = servicioCedula.getConsultaCiudadanoPort();
          Ciudadano datosRespuestaC = puerto.busquedaPorNui("3", "117", "agrocalidad1", "GmLyT36-S", identificadorCiudadano);

          return datosRespuestaC;
     }

     public static GraduadoReporteDTO consultarWebServicesSenescyt(ValidarPermisoRespuesta validarPermisoRespuesta, String identificadorCiudadano) throws ConsWsException {
          DatosHeader datosHeader = construirDatosHeader(validarPermisoRespuesta);
          HeaderHandlerResolver headerHandlerResolver = new HeaderHandlerResolver(datosHeader);
          ServicioConsultaTituloService servicio = new ServicioConsultaTituloService();
          servicio.setHandlerResolver(headerHandlerResolver);

          WSConsultaTitulosService puerto = servicio.getWSConsultaTitulosServicePort();
          GraduadoReporteDTO datosRespuestaR = puerto.consultadeTitulosRequest(identificadorCiudadano);

          return datosRespuestaR;
     }

}
