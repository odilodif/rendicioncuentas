
package gob.cpccs.utilidades.webService.Bsg.senescyt;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para nivelTitulosDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="nivelTitulosDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="titulo" type="{http://10.180.1.154:8080/ConsultaTitulosSenescytWSv3/ServicioConsultaTitulo}tituloRegistradoDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace="http://www.test34.com",name = "nivelTitulosDTO", propOrder = {
    "titulo"
})
public class NivelTitulosDTO {

    @XmlElement(nillable = true)
    protected List<TituloRegistradoDTO> titulo;

    /**
     * Gets the value of the titulo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the titulo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTitulo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TituloRegistradoDTO }
     * 
     * 
     */
    public List<TituloRegistradoDTO> getTitulo() {
        if (titulo == null) {
            titulo = new ArrayList<TituloRegistradoDTO>();
        }
        return this.titulo;
    }

}
