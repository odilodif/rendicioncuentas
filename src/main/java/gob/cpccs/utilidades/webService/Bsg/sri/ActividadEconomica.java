
package gob.cpccs.utilidades.webService.Bsg.sri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actividadEconomica complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actividadEconomica">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actividadGeneral" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codN1Familia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codN2Grupo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codN3SubGrupo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codN4Clase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codN5SubClase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codN6Actividad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="n1Familia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="n2Grupo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="n3SubGrupo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="n4Clase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="n5SubClase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="n6Actividad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace="http://www.test2.com",name = "actividadEconomica", propOrder = {
    "actividadGeneral",
    "codN1Familia",
    "codN2Grupo",
    "codN3SubGrupo",
    "codN4Clase",
    "codN5SubClase",
    "codN6Actividad",
    "n1Familia",
    "n2Grupo",
    "n3SubGrupo",
    "n4Clase",
    "n5SubClase",
    "n6Actividad"
})
public class ActividadEconomica {

    protected String actividadGeneral;
    protected String codN1Familia;
    protected String codN2Grupo;
    protected String codN3SubGrupo;
    protected String codN4Clase;
    protected String codN5SubClase;
    protected String codN6Actividad;
    protected String n1Familia;
    protected String n2Grupo;
    protected String n3SubGrupo;
    protected String n4Clase;
    protected String n5SubClase;
    protected String n6Actividad;

    /**
     * Obtiene el valor de la propiedad actividadGeneral.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActividadGeneral() {
        return actividadGeneral;
    }

    /**
     * Define el valor de la propiedad actividadGeneral.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActividadGeneral(String value) {
        this.actividadGeneral = value;
    }

    /**
     * Obtiene el valor de la propiedad codN1Familia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodN1Familia() {
        return codN1Familia;
    }

    /**
     * Define el valor de la propiedad codN1Familia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodN1Familia(String value) {
        this.codN1Familia = value;
    }

    /**
     * Obtiene el valor de la propiedad codN2Grupo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodN2Grupo() {
        return codN2Grupo;
    }

    /**
     * Define el valor de la propiedad codN2Grupo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodN2Grupo(String value) {
        this.codN2Grupo = value;
    }

    /**
     * Obtiene el valor de la propiedad codN3SubGrupo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodN3SubGrupo() {
        return codN3SubGrupo;
    }

    /**
     * Define el valor de la propiedad codN3SubGrupo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodN3SubGrupo(String value) {
        this.codN3SubGrupo = value;
    }

    /**
     * Obtiene el valor de la propiedad codN4Clase.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodN4Clase() {
        return codN4Clase;
    }

    /**
     * Define el valor de la propiedad codN4Clase.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodN4Clase(String value) {
        this.codN4Clase = value;
    }

    /**
     * Obtiene el valor de la propiedad codN5SubClase.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodN5SubClase() {
        return codN5SubClase;
    }

    /**
     * Define el valor de la propiedad codN5SubClase.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodN5SubClase(String value) {
        this.codN5SubClase = value;
    }

    /**
     * Obtiene el valor de la propiedad codN6Actividad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodN6Actividad() {
        return codN6Actividad;
    }

    /**
     * Define el valor de la propiedad codN6Actividad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodN6Actividad(String value) {
        this.codN6Actividad = value;
    }

    /**
     * Obtiene el valor de la propiedad n1Familia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getN1Familia() {
        return n1Familia;
    }

    /**
     * Define el valor de la propiedad n1Familia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setN1Familia(String value) {
        this.n1Familia = value;
    }

    /**
     * Obtiene el valor de la propiedad n2Grupo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getN2Grupo() {
        return n2Grupo;
    }

    /**
     * Define el valor de la propiedad n2Grupo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setN2Grupo(String value) {
        this.n2Grupo = value;
    }

    /**
     * Obtiene el valor de la propiedad n3SubGrupo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getN3SubGrupo() {
        return n3SubGrupo;
    }

    /**
     * Define el valor de la propiedad n3SubGrupo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setN3SubGrupo(String value) {
        this.n3SubGrupo = value;
    }

    /**
     * Obtiene el valor de la propiedad n4Clase.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getN4Clase() {
        return n4Clase;
    }

    /**
     * Define el valor de la propiedad n4Clase.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setN4Clase(String value) {
        this.n4Clase = value;
    }

    /**
     * Obtiene el valor de la propiedad n5SubClase.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getN5SubClase() {
        return n5SubClase;
    }

    /**
     * Define el valor de la propiedad n5SubClase.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setN5SubClase(String value) {
        this.n5SubClase = value;
    }

    /**
     * Obtiene el valor de la propiedad n6Actividad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getN6Actividad() {
        return n6Actividad;
    }

    /**
     * Define el valor de la propiedad n6Actividad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setN6Actividad(String value) {
        this.n6Actividad = value;
    }

}
