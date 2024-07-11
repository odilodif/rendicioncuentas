
package gob.cpccs.utilidades.webService.Bsg.sri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoContribuyente complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tipoContribuyente">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="nivel1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nivel2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nivel3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nivel4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ultimoNivel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace="http://www.test20.com",name = "tipoContribuyente", propOrder = {
    "id",
    "nivel1",
    "nivel2",
    "nivel3",
    "nivel4",
    "ultimoNivel"
})
public class TipoContribuyente {

    protected Long id;
    protected String nivel1;
    protected String nivel2;
    protected String nivel3;
    protected String nivel4;
    protected String ultimoNivel;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad nivel1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNivel1() {
        return nivel1;
    }

    /**
     * Define el valor de la propiedad nivel1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNivel1(String value) {
        this.nivel1 = value;
    }

    /**
     * Obtiene el valor de la propiedad nivel2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNivel2() {
        return nivel2;
    }

    /**
     * Define el valor de la propiedad nivel2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNivel2(String value) {
        this.nivel2 = value;
    }

    /**
     * Obtiene el valor de la propiedad nivel3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNivel3() {
        return nivel3;
    }

    /**
     * Define el valor de la propiedad nivel3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNivel3(String value) {
        this.nivel3 = value;
    }

    /**
     * Obtiene el valor de la propiedad nivel4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNivel4() {
        return nivel4;
    }

    /**
     * Define el valor de la propiedad nivel4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNivel4(String value) {
        this.nivel4 = value;
    }

    /**
     * Obtiene el valor de la propiedad ultimoNivel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUltimoNivel() {
        return ultimoNivel;
    }

    /**
     * Define el valor de la propiedad ultimoNivel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUltimoNivel(String value) {
        this.ultimoNivel = value;
    }

}
