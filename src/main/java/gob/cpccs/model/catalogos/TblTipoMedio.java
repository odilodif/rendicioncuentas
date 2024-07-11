/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.catalogos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "tbl_tipo_medio", catalog = "rendiciondb", schema = "esq_catalogos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTipoMedio.findAll", query = "SELECT t FROM TblTipoMedio t")
    , @NamedQuery(name = "TblTipoMedio.findByTmeCod", query = "SELECT t FROM TblTipoMedio t WHERE t.tmeCod = :tmeCod")
    , @NamedQuery(name = "TblTipoMedio.findByTmeDes", query = "SELECT t FROM TblTipoMedio t WHERE t.tmeDes = :tmeDes")
    , @NamedQuery(name = "TblTipoMedio.findByTmeEst", query = "SELECT t FROM TblTipoMedio t WHERE t.tmeEst = :tmeEst")})
public class TblTipoMedio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tme_cod", nullable = false)
    private Integer tmeCod;
    @Basic(optional = false)
    @Column(name = "tme_des", nullable = false, length = 50)
    private String tmeDes;
    @Basic(optional = false)
    @Column(name = "tme_est", nullable = false, length = 8)
    private String tmeEst;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instTmeCod")
    private List<TblInstitucion> tblInstitucionList;

    public TblTipoMedio() {
    }

    public TblTipoMedio(Integer tmeCod) {
        this.tmeCod = tmeCod;
    }

    public TblTipoMedio(Integer tmeCod, String tmeDes, String tmeEst) {
        this.tmeCod = tmeCod;
        this.tmeDes = tmeDes;
        this.tmeEst = tmeEst;
    }

    public Integer getTmeCod() {
        return tmeCod;
    }

    public void setTmeCod(Integer tmeCod) {
        this.tmeCod = tmeCod;
    }

    public String getTmeDes() {
        return tmeDes;
    }

    public void setTmeDes(String tmeDes) {
        this.tmeDes = tmeDes;
    }

    public String getTmeEst() {
        return tmeEst;
    }

    public void setTmeEst(String tmeEst) {
        this.tmeEst = tmeEst;
    }

    @XmlTransient
    public List<TblInstitucion> getTblInstitucionList() {
        return tblInstitucionList;
    }

    public void setTblInstitucionList(List<TblInstitucion> tblInstitucionList) {
        this.tblInstitucionList = tblInstitucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tmeCod != null ? tmeCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTipoMedio)) {
            return false;
        }
        TblTipoMedio other = (TblTipoMedio) object;
        if ((this.tmeCod == null && other.tmeCod != null) || (this.tmeCod != null && !this.tmeCod.equals(other.tmeCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.catalogos.TblTipoMedio[ tmeCod=" + tmeCod + " ]";
    }
    
}
