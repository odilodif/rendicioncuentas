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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_menus", catalog = "rendiciondb", schema = "esq_aplicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMenus.findAll", query = "SELECT t FROM TblMenus t")
    , @NamedQuery(name = "TblMenus.findByIdMenu", query = "SELECT t FROM TblMenus t WHERE t.idMenu = :idMenu")
    , @NamedQuery(name = "TblMenus.findByNombre", query = "SELECT t FROM TblMenus t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblMenus.findByEstiloImagen", query = "SELECT t FROM TblMenus t WHERE t.estiloImagen = :estiloImagen")
    , @NamedQuery(name = "TblMenus.findByPagina", query = "SELECT t FROM TblMenus t WHERE t.pagina = :pagina")
    , @NamedQuery(name = "TblMenus.findByNivel", query = "SELECT t FROM TblMenus t WHERE t.nivel = :nivel")
    , @NamedQuery(name = "TblMenus.findByOrden", query = "SELECT t FROM TblMenus t WHERE t.orden = :orden")
    , @NamedQuery(name = "TblMenus.findByIdPadre", query = "SELECT t FROM TblMenus t WHERE t.idPadre = :idPadre")
    , @NamedQuery(name = "TblMenus.findByEstadoMenu", query = "SELECT t FROM TblMenus t WHERE t.estadoMenu = :estadoMenu")})
public class TblMenus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_menu", nullable = false)
    private Integer idMenu;
    @Column(name = "nombre", length = 64)
    private String nombre;
    @Column(name = "estilo_imagen", length = 64)
    private String estiloImagen;
    @Column(name = "pagina", length = 128)
    private String pagina;
    @Column(name = "nivel")
    private Integer nivel;
    @Column(name = "orden")
    private Integer orden;
    @Column(name = "id_padre")
    private Integer idPadre;
    @Column(name = "estado_menu", length = 16)
    private String estadoMenu;
    @JoinColumn(name = "id_aplicacion", referencedColumnName = "id_aplicacion", nullable = false)
    @ManyToOne(optional = false)
    private TblAplicaciones idAplicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMenu")
    private List<TblAcciones> tblAccionesList;

    public TblMenus() {
    }

    public TblMenus(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstiloImagen() {
        return estiloImagen;
    }

    public void setEstiloImagen(String estiloImagen) {
        this.estiloImagen = estiloImagen;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
    }

    public String getEstadoMenu() {
        return estadoMenu;
    }

    public void setEstadoMenu(String estadoMenu) {
        this.estadoMenu = estadoMenu;
    }

    public TblAplicaciones getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(TblAplicaciones idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    @XmlTransient
    public List<TblAcciones> getTblAccionesList() {
        return tblAccionesList;
    }

    public void setTblAccionesList(List<TblAcciones> tblAccionesList) {
        this.tblAccionesList = tblAccionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMenus)) {
            return false;
        }
        TblMenus other = (TblMenus) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.aplicacion.TblMenus[ idMenu=" + idMenu + " ]";
    }
    
}
