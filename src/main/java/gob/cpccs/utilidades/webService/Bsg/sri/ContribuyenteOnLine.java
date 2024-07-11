
package gob.cpccs.utilidades.webService.Bsg.sri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para contribuyenteOnLine complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="contribuyenteOnLine">
 *   &lt;complexContent>
 *     &lt;extension base="{http://sri.gov.ec/wsConsultaContribuyente}contribuyente">
 *       &lt;sequence>
 *         &lt;element name="actEcoPrin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activEstablec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codActEcoPrin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codEstrucOrganizacional" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desUbicaGeograf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descEstructOrganizacional" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descTipoContri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaIniAct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idRepreLegal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreRepreLegal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telefonos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoContri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ubicaGeograf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace="http://www.test7.com",name = "contribuyenteOnLine", propOrder = {
    "actEcoPrin",
    "activEstablec",
    "codActEcoPrin",
    "codEstrucOrganizacional",
    "desUbicaGeograf",
    "descEstructOrganizacional",
    "descTipoContri",
    "fechaIniAct",
    "idRepreLegal",
    "nombreRepreLegal",
    "telefonos",
    "tipoContri",
    "ubicaGeograf"
})
public class ContribuyenteOnLine
    extends Contribuyente
{

    protected String actEcoPrin;
    protected String activEstablec;
    protected String codActEcoPrin;
    protected String codEstrucOrganizacional;
    protected String desUbicaGeograf;
    protected String descEstructOrganizacional;
    protected String descTipoContri;
    protected String fechaIniAct;
    protected String idRepreLegal;
    protected String nombreRepreLegal;
    protected String telefonos;
    protected String tipoContri;
    protected String ubicaGeograf;

    /**
     * Obtiene el valor de la propiedad actEcoPrin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActEcoPrin() {
        return actEcoPrin;
    }

    /**
     * Define el valor de la propiedad actEcoPrin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActEcoPrin(String value) {
        this.actEcoPrin = value;
    }

    /**
     * Obtiene el valor de la propiedad activEstablec.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivEstablec() {
        return activEstablec;
    }

    /**
     * Define el valor de la propiedad activEstablec.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivEstablec(String value) {
        this.activEstablec = value;
    }

    /**
     * Obtiene el valor de la propiedad codActEcoPrin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodActEcoPrin() {
        return codActEcoPrin;
    }

    /**
     * Define el valor de la propiedad codActEcoPrin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodActEcoPrin(String value) {
        this.codActEcoPrin = value;
    }

    /**
     * Obtiene el valor de la propiedad codEstrucOrganizacional.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEstrucOrganizacional() {
        return codEstrucOrganizacional;
    }

    /**
     * Define el valor de la propiedad codEstrucOrganizacional.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEstrucOrganizacional(String value) {
        this.codEstrucOrganizacional = value;
    }

    /**
     * Obtiene el valor de la propiedad desUbicaGeograf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesUbicaGeograf() {
        return desUbicaGeograf;
    }

    /**
     * Define el valor de la propiedad desUbicaGeograf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesUbicaGeograf(String value) {
        this.desUbicaGeograf = value;
    }

    /**
     * Obtiene el valor de la propiedad descEstructOrganizacional.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescEstructOrganizacional() {
        return descEstructOrganizacional;
    }

    /**
     * Define el valor de la propiedad descEstructOrganizacional.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescEstructOrganizacional(String value) {
        this.descEstructOrganizacional = value;
    }

    /**
     * Obtiene el valor de la propiedad descTipoContri.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescTipoContri() {
        return descTipoContri;
    }

    /**
     * Define el valor de la propiedad descTipoContri.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescTipoContri(String value) {
        this.descTipoContri = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaIniAct.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaIniAct() {
        return fechaIniAct;
    }

    /**
     * Define el valor de la propiedad fechaIniAct.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaIniAct(String value) {
        this.fechaIniAct = value;
    }

    /**
     * Obtiene el valor de la propiedad idRepreLegal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdRepreLegal() {
        return idRepreLegal;
    }

    /**
     * Define el valor de la propiedad idRepreLegal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdRepreLegal(String value) {
        this.idRepreLegal = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreRepreLegal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreRepreLegal() {
        return nombreRepreLegal;
    }

    /**
     * Define el valor de la propiedad nombreRepreLegal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreRepreLegal(String value) {
        this.nombreRepreLegal = value;
    }

    /**
     * Obtiene el valor de la propiedad telefonos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefonos() {
        return telefonos;
    }

    /**
     * Define el valor de la propiedad telefonos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefonos(String value) {
        this.telefonos = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoContri.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoContri() {
        return tipoContri;
    }

    /**
     * Define el valor de la propiedad tipoContri.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoContri(String value) {
        this.tipoContri = value;
    }

    /**
     * Obtiene el valor de la propiedad ubicaGeograf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbicaGeograf() {
        return ubicaGeograf;
    }

    /**
     * Define el valor de la propiedad ubicaGeograf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbicaGeograf(String value) {
        this.ubicaGeograf = value;
    }

}
