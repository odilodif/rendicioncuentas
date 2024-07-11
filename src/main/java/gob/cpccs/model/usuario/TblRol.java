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
@Table(name = "tbl_rol", catalog = "rendiciondb", schema = "esq_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRol.findAll", query = "SELECT t FROM TblRol t")
    , @NamedQuery(name = "TblRol.findByIdRol", query = "SELECT t FROM TblRol t WHERE t.idRol = :idRol")
    , @NamedQuery(name = "TblRol.findByRolDescripcion", query = "SELECT t FROM TblRol t WHERE t.rolDescripcion = :rolDescripcion")
    , @NamedQuery(name = "TblRol.findByRolEstado", query = "SELECT t FROM TblRol t WHERE t.rolEstado = :rolEstado")})
public class TblRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_rol", nullable = false)
    private Integer idRol;
    @Column(name = "rol_descripcion", length = 50)
    private String rolDescripcion;
    @Column(name = "rol_estado", length = 15)
    private String rolEstado;
    @OneToMany(mappedBy = "idRol")
    private List<TblUsuarioRol> tblUsuarioRolList;

    public TblRol() {
    }

    public TblRol(Integer idRol) {
        this.idRol = idRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }

    public String getRolEstado() {
        return rolEstado;
    }

    public void setRolEstado(String rolEstado) {
        this.rolEstado = rolEstado;
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
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRol)) {
            return false;
        }
        TblRol other = (TblRol) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.usuario.TblRol[ idRol=" + idRol + " ]";
    }
    
}
