
package gob.cpccs.utilidades.webService.Bsg.sri;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para contribuyenteCompleto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="contribuyenteCompleto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://sri.gov.ec/wsConsultaContribuyente}contribuyente">
 *       &lt;sequence>
 *         &lt;element name="agenteRetencion" type="{http://sri.gov.ec/wsConsultaContribuyente}agenteRetencion" minOccurs="0"/>
 *         &lt;element name="calificacionArtesanal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contador" type="{http://sri.gov.ec/wsConsultaContribuyente}contador" minOccurs="0"/>
 *         &lt;element name="direccionLarga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estructuraOrganizacional" type="{http://sri.gov.ec/wsConsultaContribuyente}estructuraOrganizacional" minOccurs="0"/>
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaAltaParaEspecial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaCalificacionArtesanal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaCambioObligado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaInicioActividades" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaNacimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaNotificacionEspeciales" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaUltimaDeclaracion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listaBlanca" type="{http://sri.gov.ec/wsConsultaContribuyente}listaBlanca" minOccurs="0"/>
 *         &lt;element name="mediosContacto" type="{http://sri.gov.ec/wsConsultaContribuyente}medioContacto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="numeroCalificacionArtesanal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="obligadoContabilidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="representanteLegal" type="{http://sri.gov.ec/wsConsultaContribuyente}representanteLegal" minOccurs="0"/>
 *         &lt;element name="resolucionAltaParaEspecial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoCalificacionArtesanal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ultimoPeriodoFiscalCumplido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace="http://www.test6.com",name = "contribuyenteCompleto", propOrder = {
    "agenteRetencion",
    "calificacionArtesanal",
    "contador",
    "direccionLarga",
    "estructuraOrganizacional",
    "fax",
    "fechaAltaParaEspecial",
    "fechaCalificacionArtesanal",
    "fechaCambioObligado",
    "fechaInicioActividades",
    "fechaNacimiento",
    "fechaNotificacionEspeciales",
    "fechaUltimaDeclaracion",
    "listaBlanca",
    "mediosContacto",
    "numeroCalificacionArtesanal",
    "obligadoContabilidad",
    "representanteLegal",
    "resolucionAltaParaEspecial",
    "tipoCalificacionArtesanal",
    "ultimoPeriodoFiscalCumplido",
    "codError",
    "desError"
})
public class ContribuyenteCompleto
    extends Contribuyente
{

    protected AgenteRetencion agenteRetencion;
    protected String calificacionArtesanal;
    protected Contador contador;
    protected String direccionLarga;
    protected EstructuraOrganizacional estructuraOrganizacional;
    protected String fax;
    protected String fechaAltaParaEspecial;
    protected String fechaCalificacionArtesanal;
    protected String fechaCambioObligado;
    protected String fechaInicioActividades;
    protected String fechaNacimiento;
    protected String fechaNotificacionEspeciales;
    protected String fechaUltimaDeclaracion;
    protected ListaBlanca listaBlanca;
    @XmlElement(nillable = true)
    protected List<MedioContacto> mediosContacto;
    protected String numeroCalificacionArtesanal;
    protected String obligadoContabilidad;
    protected RepresentanteLegal representanteLegal;
    protected String resolucionAltaParaEspecial;
    protected String tipoCalificacionArtesanal;
    protected String ultimoPeriodoFiscalCumplido;
    protected String codError;
    protected String desError;
    public String getCodError() {
     return codError;
}

public void setCodError(String codError) {
     this.codError = codError;
}

public String getDesError() {
     return desError;
}

public void setDesError(String desError) {
     this.desError = desError;
}

/**
     * Obtiene el valor de la propiedad agenteRetencion.
     * 
     * @return
     *     possible object is
     *     {@link AgenteRetencion }
     *     
     */
    public AgenteRetencion getAgenteRetencion() {
        return agenteRetencion;
    }

    /**
     * Define el valor de la propiedad agenteRetencion.
     * 
     * @param value
     *     allowed object is
     *     {@link AgenteRetencion }
     *     
     */
    public void setAgenteRetencion(AgenteRetencion value) {
        this.agenteRetencion = value;
    }

    /**
     * Obtiene el valor de la propiedad calificacionArtesanal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalificacionArtesanal() {
        return calificacionArtesanal;
    }

    /**
     * Define el valor de la propiedad calificacionArtesanal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalificacionArtesanal(String value) {
        this.calificacionArtesanal = value;
    }

    /**
     * Obtiene el valor de la propiedad contador.
     * 
     * @return
     *     possible object is
     *     {@link Contador }
     *     
     */
    public Contador getContador() {
        return contador;
    }

    /**
     * Define el valor de la propiedad contador.
     * 
     * @param value
     *     allowed object is
     *     {@link Contador }
     *     
     */
    public void setContador(Contador value) {
        this.contador = value;
    }

    /**
     * Obtiene el valor de la propiedad direccionLarga.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionLarga() {
        return direccionLarga;
    }

    /**
     * Define el valor de la propiedad direccionLarga.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionLarga(String value) {
        this.direccionLarga = value;
    }

    /**
     * Obtiene el valor de la propiedad estructuraOrganizacional.
     * 
     * @return
     *     possible object is
     *     {@link EstructuraOrganizacional }
     *     
     */
    public EstructuraOrganizacional getEstructuraOrganizacional() {
        return estructuraOrganizacional;
    }

    /**
     * Define el valor de la propiedad estructuraOrganizacional.
     * 
     * @param value
     *     allowed object is
     *     {@link EstructuraOrganizacional }
     *     
     */
    public void setEstructuraOrganizacional(EstructuraOrganizacional value) {
        this.estructuraOrganizacional = value;
    }

    /**
     * Obtiene el valor de la propiedad fax.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Define el valor de la propiedad fax.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaAltaParaEspecial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaAltaParaEspecial() {
        return fechaAltaParaEspecial;
    }

    /**
     * Define el valor de la propiedad fechaAltaParaEspecial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaAltaParaEspecial(String value) {
        this.fechaAltaParaEspecial = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaCalificacionArtesanal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaCalificacionArtesanal() {
        return fechaCalificacionArtesanal;
    }

    /**
     * Define el valor de la propiedad fechaCalificacionArtesanal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaCalificacionArtesanal(String value) {
        this.fechaCalificacionArtesanal = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaCambioObligado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaCambioObligado() {
        return fechaCambioObligado;
    }

    /**
     * Define el valor de la propiedad fechaCambioObligado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaCambioObligado(String value) {
        this.fechaCambioObligado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaInicioActividades.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaInicioActividades() {
        return fechaInicioActividades;
    }

    /**
     * Define el valor de la propiedad fechaInicioActividades.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaInicioActividades(String value) {
        this.fechaInicioActividades = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaNacimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Define el valor de la propiedad fechaNacimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaNacimiento(String value) {
        this.fechaNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaNotificacionEspeciales.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaNotificacionEspeciales() {
        return fechaNotificacionEspeciales;
    }

    /**
     * Define el valor de la propiedad fechaNotificacionEspeciales.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaNotificacionEspeciales(String value) {
        this.fechaNotificacionEspeciales = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaUltimaDeclaracion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaUltimaDeclaracion() {
        return fechaUltimaDeclaracion;
    }

    /**
     * Define el valor de la propiedad fechaUltimaDeclaracion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaUltimaDeclaracion(String value) {
        this.fechaUltimaDeclaracion = value;
    }

    /**
     * Obtiene el valor de la propiedad listaBlanca.
     * 
     * @return
     *     possible object is
     *     {@link ListaBlanca }
     *     
     */
    public ListaBlanca getListaBlanca() {
        return listaBlanca;
    }

    /**
     * Define el valor de la propiedad listaBlanca.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaBlanca }
     *     
     */
    public void setListaBlanca(ListaBlanca value) {
        this.listaBlanca = value;
    }

    /**
     * Gets the value of the mediosContacto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mediosContacto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMediosContacto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MedioContacto }
     * 
     * 
     */
    public List<MedioContacto> getMediosContacto() {
        if (mediosContacto == null) {
            mediosContacto = new ArrayList<MedioContacto>();
        }
        return this.mediosContacto;
    }

    /**
     * Obtiene el valor de la propiedad numeroCalificacionArtesanal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCalificacionArtesanal() {
        return numeroCalificacionArtesanal;
    }

    /**
     * Define el valor de la propiedad numeroCalificacionArtesanal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCalificacionArtesanal(String value) {
        this.numeroCalificacionArtesanal = value;
    }

    /**
     * Obtiene el valor de la propiedad obligadoContabilidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObligadoContabilidad() {
        return obligadoContabilidad;
    }

    /**
     * Define el valor de la propiedad obligadoContabilidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObligadoContabilidad(String value) {
        this.obligadoContabilidad = value;
    }

    /**
     * Obtiene el valor de la propiedad representanteLegal.
     * 
     * @return
     *     possible object is
     *     {@link RepresentanteLegal }
     *     
     */
    public RepresentanteLegal getRepresentanteLegal() {
        return representanteLegal;
    }

    /**
     * Define el valor de la propiedad representanteLegal.
     * 
     * @param value
     *     allowed object is
     *     {@link RepresentanteLegal }
     *     
     */
    public void setRepresentanteLegal(RepresentanteLegal value) {
        this.representanteLegal = value;
    }

    /**
     * Obtiene el valor de la propiedad resolucionAltaParaEspecial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResolucionAltaParaEspecial() {
        return resolucionAltaParaEspecial;
    }

    /**
     * Define el valor de la propiedad resolucionAltaParaEspecial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResolucionAltaParaEspecial(String value) {
        this.resolucionAltaParaEspecial = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCalificacionArtesanal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCalificacionArtesanal() {
        return tipoCalificacionArtesanal;
    }

    /**
     * Define el valor de la propiedad tipoCalificacionArtesanal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCalificacionArtesanal(String value) {
        this.tipoCalificacionArtesanal = value;
    }

    /**
     * Obtiene el valor de la propiedad ultimoPeriodoFiscalCumplido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUltimoPeriodoFiscalCumplido() {
        return ultimoPeriodoFiscalCumplido;
    }

    /**
     * Define el valor de la propiedad ultimoPeriodoFiscalCumplido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUltimoPeriodoFiscalCumplido(String value) {
        this.ultimoPeriodoFiscalCumplido = value;
    }

}
