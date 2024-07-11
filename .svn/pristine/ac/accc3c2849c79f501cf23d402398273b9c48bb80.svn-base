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
@Table(name = "tbl_funcion", catalog = "rendiciondb", schema = "esq_catalogos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFuncion.findAll", query = "SELECT t FROM TblFuncion t")
    , @NamedQuery(name = "TblFuncion.findByFunCod", query = "SELECT t FROM TblFuncion t WHERE t.funCod = :funCod")
    , @NamedQuery(name = "TblFuncion.findByFunDes", query = "SELECT t FROM TblFuncion t WHERE t.funDes = :funDes")
    , @NamedQuery(name = "TblFuncion.findByFunEst", query = "SELECT t FROM TblFuncion t WHERE t.funEst = :funEst")})
public class TblFuncion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fun_cod", nullable = false)
    private Integer funCod;
    @Basic(optional = false)
    @Column(name = "fun_des", nullable = false, length = 60)
    private String funDes;
    @Basic(optional = false)
    @Column(name = "fun_est", nullable = false, length = 8)
    private String funEst;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instFunCod")
    private List<TblInstitucion> tblInstitucionList;

    public TblFuncion() {
    }

    public TblFuncion(Integer funCod) {
        this.funCod = funCod;
    }

    public TblFuncion(Integer funCod, String funDes, String funEst) {
        this.funCod = funCod;
        this.funDes = funDes;
        this.funEst = funEst;
    }

    public Integer getFunCod() {
        return funCod;
    }

    public void setFunCod(Integer funCod) {
        this.funCod = funCod;
    }

    public String getFunDes() {
        return funDes;
    }

    public void setFunDes(String funDes) {
        this.funDes = funDes;
    }

    public String getFunEst() {
        return funEst;
    }

    public void setFunEst(String funEst) {
        this.funEst = funEst;
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
        hash += (funCod != null ? funCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFuncion)) {
            return false;
        }
        TblFuncion other = (TblFuncion) object;
        if ((this.funCod == null && other.funCod != null) || (this.funCod != null && !this.funCod.equals(other.funCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.catalogos.TblFuncion[ funCod=" + funCod + " ]";
    }
    
}
