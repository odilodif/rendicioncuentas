
package gob.cpccs.utilidades.webService.Bsg.senescyt;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WSConsultaTitulosService", targetNamespace = "http://10.180.1.154:8080/ConsultaTitulosSenescytWSv3/ServicioConsultaTitulo")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSConsultaTitulosService {


    /**
     * 
     * @param cedulaTitulado
     * @return
     *     returns gob.cpccs.utilidades.webService.Bsg.senescyt.GraduadoReporteDTO
     * @throws ConsWsException
     */
    @WebMethod(operationName = "ConsultadeTitulosRequest", action = "Buscar")
    @WebResult(name = "detalleGraduado", targetNamespace = "")
    @RequestWrapper(localName = "ConsultadeTitulosRequest", targetNamespace = "http://10.180.1.154:8080/ConsultaTitulosSenescytWSv3/ServicioConsultaTitulo", className = "gob.cpccs.utilidades.webService.Bsg.senescyt.ConsultadeTitulosRequest")
    @ResponseWrapper(localName = "ConsultadeTitulosRequestResponse", targetNamespace = "http://10.180.1.154:8080/ConsultaTitulosSenescytWSv3/ServicioConsultaTitulo", className = "gob.cpccs.utilidades.webService.Bsg.senescyt.ConsultadeTitulosRequestResponse")
    public GraduadoReporteDTO consultadeTitulosRequest(
        @WebParam(name = "CedulaTitulado", targetNamespace = "")
        String cedulaTitulado)
        throws ConsWsException
    ;

}
