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
@Table(name = "tbl_sector", catalog = "rendiciondb", schema = "esq_catalogos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSector.findAll", query = "SELECT t FROM TblSector t")
    , @NamedQuery(name = "TblSector.findBySecCod", query = "SELECT t FROM TblSector t WHERE t.secCod = :secCod")
    , @NamedQuery(name = "TblSector.findBySecDes", query = "SELECT t FROM TblSector t WHERE t.secDes = :secDes")
    , @NamedQuery(name = "TblSector.findBySecEst", query = "SELECT t FROM TblSector t WHERE t.secEst = :secEst")})
public class TblSector implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sec_cod", nullable = false)
    private Integer secCod;
    @Column(name = "sec_des", length = 50)
    private String secDes;
    @Column(name = "sec_est", length = 8)
    private String secEst;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instSecCod")
    private List<TblInstitucion> tblInstitucionList;

    public TblSector() {
    }

    public TblSector(Integer secCod) {
        this.secCod = secCod;
    }

    public Integer getSecCod() {
        return secCod;
    }

    public void setSecCod(Integer secCod) {
        this.secCod = secCod;
    }

    public String getSecDes() {
        return secDes;
    }

    public void setSecDes(String secDes) {
        this.secDes = secDes;
    }

    public String getSecEst() {
        return secEst;
    }

    public void setSecEst(String secEst) {
        this.secEst = secEst;
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
        hash += (secCod != null ? secCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSector)) {
            return false;
        }
        TblSector other = (TblSector) object;
        if ((this.secCod == null && other.secCod != null) || (this.secCod != null && !this.secCod.equals(other.secCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.catalogos.TblSector[ secCod=" + secCod + " ]";
    }
    
}
