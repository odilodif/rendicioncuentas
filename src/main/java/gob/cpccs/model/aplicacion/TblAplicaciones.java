/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.aplicacion;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_aplicaciones", catalog = "rendiciondb", schema = "esq_aplicacion", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"codificacion_aplicacion"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAplicaciones.findAll", query = "SELECT t FROM TblAplicaciones t")
    , @NamedQuery(name = "TblAplicaciones.findByIdAplicacion", query = "SELECT t FROM TblAplicaciones t WHERE t.idAplicacion = :idAplicacion")
    , @NamedQuery(name = "TblAplicaciones.findByCodificacionAplicacion", query = "SELECT t FROM TblAplicaciones t WHERE t.codificacionAplicacion = :codificacionAplicacion")
    , @NamedQuery(name = "TblAplicaciones.findByNombre", query = "SELECT t FROM TblAplicaciones t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblAplicaciones.findByVersionApp", query = "SELECT t FROM TblAplicaciones t WHERE t.versionApp = :versionApp")
    , @NamedQuery(name = "TblAplicaciones.findByRuta", query = "SELECT t FROM TblAplicaciones t WHERE t.ruta = :ruta")
    , @NamedQuery(name = "TblAplicaciones.findByDescripcion", query = "SELECT t FROM TblAplicaciones t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TblAplicaciones.findByColor", query = "SELECT t FROM TblAplicaciones t WHERE t.color = :color")
    , @NamedQuery(name = "TblAplicaciones.findByImagen", query = "SELECT t FROM TblAplicaciones t WHERE t.imagen = :imagen")
    , @NamedQuery(name = "TblAplicaciones.findByEstadoAplicacion", query = "SELECT t FROM TblAplicaciones t WHERE t.estadoAplicacion = :estadoAplicacion")
    , @NamedQuery(name = "TblAplicaciones.findByVisitas", query = "SELECT t FROM TblAplicaciones t WHERE t.visitas = :visitas")})
public class TblAplicaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aplicacion", nullable = false)
    private Integer idAplicacion;
    @Column(name = "codificacion_aplicacion", length = 17)
    private String codificacionAplicacion;
    @Column(name = "nombre", length = 256)
    private String nombre;
    @Column(name = "version_app", length = 10)
    private String versionApp;
    @Column(name = "ruta", length = 1024)
    private String ruta;
    @Column(name = "descripcion", length = 1024)
    private String descripcion;
    @Column(name = "color", length = 16)
    private String color;
    @Column(name = "imagen", length = 32)
    private String imagen;
    @Column(name = "estado_aplicacion", length = 64)
    private String estadoAplicacion;
    @Column(name = "visitas")
    private Integer visitas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAplicacion")
    private List<TblAplicacionesRegistradas> tblAplicacionesRegistradasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAplicacion")
    private List<TblMenus> tblMenusList;

    public TblAplicaciones() {
    }

    public TblAplicaciones(Integer idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public Integer getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(Integer idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public String getCodificacionAplicacion() {
        return codificacionAplicacion;
    }

    public void setCodificacionAplicacion(String codificacionAplicacion) {
        this.codificacionAplicacion = codificacionAplicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersionApp() {
        return versionApp;
    }

    public void setVersionApp(String versionApp) {
        this.versionApp = versionApp;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstadoAplicacion() {
        return estadoAplicacion;
    }

    public void setEstadoAplicacion(String estadoAplicacion) {
        this.estadoAplicacion = estadoAplicacion;
    }

    public Integer getVisitas() {
        return visitas;
    }

    public void setVisitas(Integer visitas) {
        this.visitas = visitas;
    }

    @XmlTransient
    public List<TblAplicacionesRegistradas> getTblAplicacionesRegistradasList() {
        return tblAplicacionesRegistradasList;
    }

    public void setTblAplicacionesRegistradasList(List<TblAplicacionesRegistradas> tblAplicacionesRegistradasList) {
        this.tblAplicacionesRegistradasList = tblAplicacionesRegistradasList;
    }

    @XmlTransient
    public List<TblMenus> getTblMenusList() {
        return tblMenusList;
    }

    public void setTblMenusList(List<TblMenus> tblMenusList) {
        this.tblMenusList = tblMenusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAplicacion != null ? idAplicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAplicaciones)) {
            return false;
        }
        TblAplicaciones other = (TblAplicaciones) object;
        if ((this.idAplicacion == null && other.idAplicacion != null) || (this.idAplicacion != null && !this.idAplicacion.equals(other.idAplicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.aplicacion.TblAplicaciones[ idAplicacion=" + idAplicacion + " ]";
    }
    
}
