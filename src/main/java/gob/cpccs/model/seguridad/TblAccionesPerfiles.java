/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.seguridad;

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
 * @author CAMM
 */
@Entity
@Table(name = "tbl_acciones_perfiles", catalog = "rendiciondb", schema = "esq_seguridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAccionesPerfiles.findAll", query = "SELECT t FROM TblAccionesPerfiles t")
    , @NamedQuery(name = "TblAccionesPerfiles.findByIdAccionPerfil", query = "SELECT t FROM TblAccionesPerfiles t WHERE t.idAccionPerfil = :idAccionPerfil")
    , @NamedQuery(name = "TblAccionesPerfiles.findByIdPerfil", query = "SELECT t FROM TblAccionesPerfiles t WHERE t.idPerfil = :idPerfil")
    , @NamedQuery(name = "TblAccionesPerfiles.findByIdAccion", query = "SELECT t FROM TblAccionesPerfiles t WHERE t.idAccion = :idAccion")})
public class TblAccionesPerfiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_accion_perfil", nullable = false)
    private Integer idAccionPerfil;
    @Basic(optional = false)
    @Column(name = "id_perfil", nullable = false)
    private int idPerfil;
    @Basic(optional = false)
    @Column(name = "id_accion", nullable = false)
    private int idAccion;

    public TblAccionesPerfiles() {
    }

    public TblAccionesPerfiles(Integer idAccionPerfil) {
        this.idAccionPerfil = idAccionPerfil;
    }

    public TblAccionesPerfiles(Integer idAccionPerfil, int idPerfil, int idAccion) {
        this.idAccionPerfil = idAccionPerfil;
        this.idPerfil = idPerfil;
        this.idAccion = idAccion;
    }

    public Integer getIdAccionPerfil() {
        return idAccionPerfil;
    }

    public void setIdAccionPerfil(Integer idAccionPerfil) {
        this.idAccionPerfil = idAccionPerfil;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(int idAccion) {
        this.idAccion = idAccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccionPerfil != null ? idAccionPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAccionesPerfiles)) {
            return false;
        }
        TblAccionesPerfiles other = (TblAccionesPerfiles) object;
        if ((this.idAccionPerfil == null && other.idAccionPerfil != null) || (this.idAccionPerfil != null && !this.idAccionPerfil.equals(other.idAccionPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.seguridad.TblAccionesPerfiles[ idAccionPerfil=" + idAccionPerfil + " ]";
    }
    
}
