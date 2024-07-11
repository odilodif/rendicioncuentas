
package gob.cpccs.utilidades.webService.Bsg.senescyt;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para graduadoReporteDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="graduadoReporteDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="msg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="niveltitulos" type="{http://10.180.1.154:8080/ConsultaTitulosSenescytWSv3/ServicioConsultaTitulo}nivelTitulosDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace="http://www.test33.com",name = "graduadoReporteDTO", propOrder = {
    "msg",
    "niveltitulos"
})
public class GraduadoReporteDTO {

    protected String msg;
    @XmlElement(nillable = true)
    protected List<NivelTitulosDTO> niveltitulos;

    /**
     * Obtiene el valor de la propiedad msg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Define el valor de la propiedad msg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsg(String value) {
        this.msg = value;
    }

    /**
     * Gets the value of the niveltitulos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the niveltitulos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNiveltitulos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NivelTitulosDTO }
     * 
     * 
     */
    public List<NivelTitulosDTO> getNiveltitulos() {
        if (niveltitulos == null) {
            niveltitulos = new ArrayList<NivelTitulosDTO>();
        }
        return this.niveltitulos;
    }

}
