/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.usuario;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tbl_perfil", catalog = "rendiciondb", schema = "esq_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPerfil.findAll", query = "SELECT t FROM TblPerfil t")
    , @NamedQuery(name = "TblPerfil.findByIdPerfil", query = "SELECT t FROM TblPerfil t WHERE t.idPerfil = :idPerfil")
    , @NamedQuery(name = "TblPerfil.findByDescripcion", query = "SELECT t FROM TblPerfil t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TblPerfil.findByEstado", query = "SELECT t FROM TblPerfil t WHERE t.estado = :estado")})
public class TblPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_perfil", nullable = false)
    private Integer idPerfil;
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    @Column(name = "estado", length = 10)
    private String estado;
    @OneToMany(mappedBy = "idPerfil")
    private List<TblUsuarioRol> tblUsuarioRolList;

    public TblPerfil() {
    }

    public TblPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<TblUsuarioRol> getTblUsuarioRolList() {
        return tblUsuarioRolList;
    }

    public void setTblUsuarioRolList(List<TblUsuarioRol> tblUsuarioRolList) {
        this.tblUsuarioRolList = tblUsuarioRolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPerfil)) {
            return false;
        }
        TblPerfil other = (TblPerfil) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.usuario.TblPerfil[ idPerfil=" + idPerfil + " ]";
    }
    
}
