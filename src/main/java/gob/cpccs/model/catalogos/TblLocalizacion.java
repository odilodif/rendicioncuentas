/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.catalogos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_localizacion", catalog = "rendiciondb", schema = "esq_catalogos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblLocalizacion.findAll", query = "SELECT t FROM TblLocalizacion t")
    , @NamedQuery(name = "TblLocalizacion.findByIdLocalizacion", query = "SELECT t FROM TblLocalizacion t WHERE t.idLocalizacion = :idLocalizacion")
    , @NamedQuery(name = "TblLocalizacion.findByCodigo", query = "SELECT t FROM TblLocalizacion t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TblLocalizacion.findByNombre", query = "SELECT t FROM TblLocalizacion t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblLocalizacion.findByIdLocalizacionPadre", query = "SELECT t FROM TblLocalizacion t WHERE t.idLocalizacionPadre = :idLocalizacionPadre")
    , @NamedQuery(name = "TblLocalizacion.findByCategoria", query = "SELECT t FROM TblLocalizacion t WHERE t.categoria = :categoria")
    , @NamedQuery(name = "TblLocalizacion.findByOtros", query = "SELECT t FROM TblLocalizacion t WHERE t.otros = :otros")
    , @NamedQuery(name = "TblLocalizacion.findByLatitud", query = "SELECT t FROM TblLocalizacion t WHERE t.latitud = :latitud")
    , @NamedQuery(name = "TblLocalizacion.findByLongitud", query = "SELECT t FROM TblLocalizacion t WHERE t.longitud = :longitud")
    , @NamedQuery(name = "TblLocalizacion.findByZona", query = "SELECT t FROM TblLocalizacion t WHERE t.zona = :zona")
    , @NamedQuery(name = "TblLocalizacion.findByCodigoVue", query = "SELECT t FROM TblLocalizacion t WHERE t.codigoVue = :codigoVue")
    , @NamedQuery(name = "TblLocalizacion.findByNombreIngles", query = "SELECT t FROM TblLocalizacion t WHERE t.nombreIngles = :nombreIngles")
    , @NamedQuery(name = "TblLocalizacion.findByGeograficoMfin", query = "SELECT t FROM TblLocalizacion t WHERE t.geograficoMfin = :geograficoMfin")
    , @NamedQuery(name = "TblLocalizacion.findByEstado", query = "SELECT t FROM TblLocalizacion t WHERE t.estado = :estado")})
public class TblLocalizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_localizacion", nullable = false)
    private Integer idLocalizacion;
    @Column(name = "codigo", length = 16)
    private String codigo;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 64)
    private String nombre;
    @Column(name = "id_localizacion_padre")
    private Integer idLocalizacionPadre;
    @Column(name = "categoria")
    private Integer categoria;
    @Column(name = "otros", length = 512)
    private String otros;
    @Column(name = "latitud", length = 128)
    private String latitud;
    @Column(name = "longitud", length = 128)
    private String longitud;
    @Column(name = "zona", length = 128)
    private String zona;
    @Column(name = "codigo_vue", length = 8)
    private String codigoVue;
    @Column(name = "nombre_ingles", length = 64)
    private String nombreIngles;
    @Column(name = "geografico_mfin", length = 4)
    private String geograficoMfin;
    @Column(name = "estado", length = 16)
    private String estado;

    public TblLocalizacion() {
    }

    public TblLocalizacion(Integer idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public TblLocalizacion(Integer idLocalizacion, String nombre) {
        this.idLocalizacion = idLocalizacion;
        this.nombre = nombre;
    }

    public Integer getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(Integer idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdLocalizacionPadre() {
        return idLocalizacionPadre;
    }

    public void setIdLocalizacionPadre(Integer idLocalizacionPadre) {
        this.idLocalizacionPadre = idLocalizacionPadre;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getCodigoVue() {
        return codigoVue;
    }

    public void setCodigoVue(String codigoVue) {
        this.codigoVue = codigoVue;
    }

    public String getNombreIngles() {
        return nombreIngles;
    }

    public void setNombreIngles(String nombreIngles) {
        this.nombreIngles = nombreIngles;
    }

    public String getGeograficoMfin() {
        return geograficoMfin;
    }

    public void setGeograficoMfin(String geograficoMfin) {
        this.geograficoMfin = geograficoMfin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocalizacion != null ? idLocalizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblLocalizacion)) {
            return false;
        }
        TblLocalizacion other = (TblLocalizacion) object;
        if ((this.idLocalizacion == null && other.idLocalizacion != null) || (this.idLocalizacion != null && !this.idLocalizacion.equals(other.idLocalizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.catalogos.TblLocalizacion[ idLocalizacion=" + idLocalizacion + " ]";
    }
    
}
