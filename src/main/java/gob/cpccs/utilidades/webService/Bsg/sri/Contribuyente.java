
package gob.cpccs.utilidades.webService.Bsg.sri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para contribuyente complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="contribuyente">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actividadEconomica" type="{http://sri.gov.ec/wsConsultaContribuyente}actividadEconomica" minOccurs="0"/>
 *         &lt;element name="codClaseContrib" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codEstado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desClaseContrib" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desEstado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direccionCorta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreComercial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroRuc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="razonSocial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telefonoDomicilio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telefonoTrabajo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoContribuyente" type="{http://sri.gov.ec/wsConsultaContribuyente}tipoContribuyente" minOccurs="0"/>
 *         &lt;element name="ubicacionGeografica" type="{http://sri.gov.ec/wsConsultaContribuyente}ubicacionGeografica" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace="http://www.test5.com",name = "contribuyente", propOrder = {
    "actividadEconomica",
    "codClaseContrib",
    "codEstado",
    "desClaseContrib",
    "desEstado",
    "direccionCorta",
    "email",
    "nombreComercial",
    "numeroRuc",
    "razonSocial",
    "telefonoDomicilio",
    "telefonoTrabajo",
    "tipoContribuyente",
    "ubicacionGeografica"
})
@XmlSeeAlso({
    ContribuyenteOnLine.class,
    ContribuyenteCompleto.class
})
public class Contribuyente {

    protected ActividadEconomica actividadEconomica;
    protected String codClaseContrib;
    protected String codEstado;
    protected String desClaseContrib;
    protected String desEstado;
    protected String direccionCorta;
    protected String email;
    protected String nombreComercial;
    protected String numeroRuc;
    protected String razonSocial;
    protected String telefonoDomicilio;
    protected String telefonoTrabajo;
    protected TipoContribuyente tipoContribuyente;
    protected UbicacionGeografica ubicacionGeografica;

    /**
     * Obtiene el valor de la propiedad actividadEconomica.
     * 
     * @return
     *     possible object is
     *     {@link ActividadEconomica }
     *     
     */
    public ActividadEconomica getActividadEconomica() {
        return actividadEconomica;
    }

    /**
     * Define el valor de la propiedad actividadEconomica.
     * 
     * @param value
     *     allowed object is
     *     {@link ActividadEconomica }
     *     
     */
    public void setActividadEconomica(ActividadEconomica value) {
        this.actividadEconomica = value;
    }

    /**
     * Obtiene el valor de la propiedad codClaseContrib.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodClaseContrib() {
        return codClaseContrib;
    }

    /**
     * Define el valor de la propiedad codClaseContrib.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodClaseContrib(String value) {
        this.codClaseContrib = value;
    }

    /**
     * Obtiene el valor de la propiedad codEstado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEstado() {
        return codEstado;
    }

    /**
     * Define el valor de la propiedad codEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEstado(String value) {
        this.codEstado = value;
    }

    /**
     * Obtiene el valor de la propiedad desClaseContrib.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesClaseContrib() {
        return desClaseContrib;
    }

    /**
     * Define el valor de la propiedad desClaseContrib.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesClaseContrib(String value) {
        this.desClaseContrib = value;
    }

    /**
     * Obtiene el valor de la propiedad desEstado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesEstado() {
        return desEstado;
    }

    /**
     * Define el valor de la propiedad desEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesEstado(String value) {
        this.desEstado = value;
    }

    /**
     * Obtiene el valor de la propiedad direccionCorta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionCorta() {
        return direccionCorta;
    }

    /**
     * Define el valor de la propiedad direccionCorta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionCorta(String value) {
        this.direccionCorta = value;
    }

    /**
     * Obtiene el valor de la propiedad email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define el valor de la propiedad email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreComercial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreComercial() {
        return nombreComercial;
    }

    /**
     * Define el valor de la propiedad nombreComercial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreComercial(String value) {
        this.nombreComercial = value;
    }

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
     * Obtiene el valor de la propiedad razonSocial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Define el valor de la propiedad razonSocial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazonSocial(String value) {
        this.razonSocial = value;
    }

    /**
     * Obtiene el valor de la propiedad telefonoDomicilio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefonoDomicilio() {
        return telefonoDomicilio;
    }

    /**
     * Define el valor de la propiedad telefonoDomicilio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefonoDomicilio(String value) {
        this.telefonoDomicilio = value;
    }

    /**
     * Obtiene el valor de la propiedad telefonoTrabajo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    /**
     * Define el valor de la propiedad telefonoTrabajo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefonoTrabajo(String value) {
        this.telefonoTrabajo = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoContribuyente.
     * 
     * @return
     *     possible object is
     *     {@link TipoContribuyente }
     *     
     */
    public TipoContribuyente getTipoContribuyente() {
        return tipoContribuyente;
    }

    /**
     * Define el valor de la propiedad tipoContribuyente.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoContribuyente }
     *     
     */
    public void setTipoContribuyente(TipoContribuyente value) {
        this.tipoContribuyente = value;
    }

    /**
     * Obtiene el valor de la propiedad ubicacionGeografica.
     * 
     * @return
     *     possible object is
     *     {@link UbicacionGeografica }
     *     
     */
    public UbicacionGeografica getUbicacionGeografica() {
        return ubicacionGeografica;
    }

    /**
     * Define el valor de la propiedad ubicacionGeografica.
     * 
     * @param value
     *     allowed object is
     *     {@link UbicacionGeografica }
     *     
     */
    public void setUbicacionGeografica(UbicacionGeografica value) {
        this.ubicacionGeografica = value;
    }

}
