
package gob.cpccs.utilidades.webService.Bsg.sri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para obtenerSimple complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="obtenerSimple">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroRuc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fuenteDatos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace="http://www.test17.com",name = "obtenerSimple", propOrder = {
    "numeroRuc",
    "fuenteDatos"
})
public class ObtenerSimple {

    protected String numeroRuc;
    protected String fuenteDatos;

    /**
     * Obtiene el valor de la propiedad numeroRuc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroRuc() {
        return numeroRuc;
    }

    /**
     * Define el valor de la propiedad numeroRuc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroRuc(String value) {
        this.numeroRuc = value;
    }

    /**
     * Obtiene el valor de la propiedad fuenteDatos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuenteDatos() {
        return fuenteDatos;
    }

    /**
     * Define el valor de la propiedad fuenteDatos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuenteDatos(String value) {
        this.fuenteDatos = value;
    }

}
