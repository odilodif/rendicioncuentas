
package gob.cpccs.utilidades.webService.Bsg.senescyt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ConsultadeTitulosRequestResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ConsultadeTitulosRequestResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="detalleGraduado" type="{http://10.180.1.154:8080/ConsultaTitulosSenescytWSv3/ServicioConsultaTitulo}graduadoReporteDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace="http://www.test31.com",name = "ConsultadeTitulosRequestResponse", propOrder = {
    "detalleGraduado"
})
public class ConsultadeTitulosRequestResponse {

    protected GraduadoReporteDTO detalleGraduado;

    /**
     * Obtiene el valor de la propiedad detalleGraduado.
     * 
     * @return
     *     possible object is
     *     {@link GraduadoReporteDTO }
     *     
     */
    public GraduadoReporteDTO getDetalleGraduado() {
        return detalleGraduado;
    }

    /**
     * Define el valor de la propiedad detalleGraduado.
     * 
     * @param value
     *     allowed object is
     *     {@link GraduadoReporteDTO }
     *     
     */
    public void setDetalleGraduado(GraduadoReporteDTO value) {
        this.detalleGraduado = value;
    }

}
