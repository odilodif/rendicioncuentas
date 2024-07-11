/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.aplicacion;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_acciones", catalog = "rendiciondb", schema = "esq_aplicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAcciones.findAll", query = "SELECT t FROM TblAcciones t")
    , @NamedQuery(name = "TblAcciones.findByIdAccion", query = "SELECT t FROM TblAcciones t WHERE t.idAccion = :idAccion")
    , @NamedQuery(name = "TblAcciones.findByIdAplicacion", query = "SELECT t FROM TblAcciones t WHERE t.idAplicacion = :idAplicacion")
    , @NamedQuery(name = "TblAcciones.findByPagina", query = "SELECT t FROM TblAcciones t WHERE t.pagina = :pagina")
    , @NamedQuery(name = "TblAcciones.findByEstiloImagen", query = "SELECT t FROM TblAcciones t WHERE t.estiloImagen = :estiloImagen")
    , @NamedQuery(name = "TblAcciones.findByEstiloColor", query = "SELECT t FROM TblAcciones t WHERE t.estiloColor = :estiloColor")
    , @NamedQuery(name = "TblAcciones.findByDescripcion", query = "SELECT t FROM TblAcciones t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TblAcciones.findByOrden", query = "SELECT t FROM TblAcciones t WHERE t.orden = :orden")})
public class TblAcciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_accion", nullable = false)
    private Integer idAccion;
    @Basic(optional = false)
    @Column(name = "id_aplicacion", nullable = false)
    private int idAplicacion;
    @Column(name = "pagina", length = 256)
    private String pagina;
    @Column(name = "estilo_imagen", length = 64)
    private String estiloImagen;
    @Column(name = "estilo_color", length = 64)
    private String estiloColor;
    @Column(name = "descripcion", length = 256)
    private String descripcion;
    @Column(name = "orden")
    private Integer orden;
    @JoinColumn(name = "id_menu", referencedColumnName = "id_menu", nullable = false)
    @ManyToOne(optional = false)
    private TblMenus idMenu;

    public TblAcciones() {
    }

    public TblAcciones(Integer idAccion) {
        this.idAccion = idAccion;
    }

    public TblAcciones(Integer idAccion, int idAplicacion) {
        this.idAccion = idAccion;
        this.idAplicacion = idAplicacion;
    }

    public Integer getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(Integer idAccion) {
        this.idAccion = idAccion;
    }

    public int getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(int idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getEstiloImagen() {
        return estiloImagen;
    }

    public void setEstiloImagen(String estiloImagen) {
        this.estiloImagen = estiloImagen;
    }

    public String getEstiloColor() {
        return estiloColor;
    }

    public void setEstiloColor(String estiloColor) {
        this.estiloColor = estiloColor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public TblMenus getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(TblMenus idMenu) {
        this.idMenu = idMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccion != null ? idAccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAcciones)) {
            return false;
        }
        TblAcciones other = (TblAcciones) object;
        if ((this.idAccion == null && other.idAccion != null) || (this.idAccion != null && !this.idAccion.equals(other.idAccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.aplicacion.TblAcciones[ idAccion=" + idAccion + " ]";
    }
    
}
