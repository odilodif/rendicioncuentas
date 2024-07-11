/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.usuario;

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
@Table(name = "tbl_usuario_rol", catalog = "rendiciondb", schema = "esq_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUsuarioRol.findAll", query = "SELECT t FROM TblUsuarioRol t")
    , @NamedQuery(name = "TblUsuarioRol.findByUsurolId", query = "SELECT t FROM TblUsuarioRol t WHERE t.usurolId = :usurolId")
    , @NamedQuery(name = "TblUsuarioRol.findByUsurolEstado", query = "SELECT t FROM TblUsuarioRol t WHERE t.usurolEstado = :usurolEstado")
    , @NamedQuery(name = "TblUsuarioRol.findByUsurolDescripcion", query = "SELECT t FROM TblUsuarioRol t WHERE t.usurolDescripcion = :usurolDescripcion")})
public class TblUsuarioRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usurol_id", nullable = false)
    private Integer usurolId;
    @Column(name = "usurol_estado")
    private Integer usurolEstado;
    @Column(name = "usurol_descripcion", length = 500)
    private String usurolDescripcion;
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil")
    @ManyToOne
    private TblPerfil idPerfil;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne
    private TblRol idRol;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne
    private TblUsuario idUser;

    public TblUsuarioRol() {
    }

    public TblUsuarioRol(Integer usurolId) {
        this.usurolId = usurolId;
    }

    public Integer getUsurolId() {
        return usurolId;
    }

    public void setUsurolId(Integer usurolId) {
        this.usurolId = usurolId;
    }

    public Integer getUsurolEstado() {
        return usurolEstado;
    }

    public void setUsurolEstado(Integer usurolEstado) {
        this.usurolEstado = usurolEstado;
    }

    public String getUsurolDescripcion() {
        return usurolDescripcion;
    }

    public void setUsurolDescripcion(String usurolDescripcion) {
        this.usurolDescripcion = usurolDescripcion;
    }

    public TblPerfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(TblPerfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    public TblRol getIdRol() {
        return idRol;
    }

    public void setIdRol(TblRol idRol) {
        this.idRol = idRol;
    }

    public TblUsuario getIdUser() {
        return idUser;
    }

    public void setIdUser(TblUsuario idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usurolId != null ? usurolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUsuarioRol)) {
            return false;
        }
        TblUsuarioRol other = (TblUsuarioRol) object;
        if ((this.usurolId == null && other.usurolId != null) || (this.usurolId != null && !this.usurolId.equals(other.usurolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.usuario.TblUsuarioRol[ usurolId=" + usurolId + " ]";
    }
    
}
