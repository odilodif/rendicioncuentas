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
@Table(name = "tbl_tipo_informe", catalog = "rendiciondb", schema = "esq_catalogos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTipoInforme.findAll", query = "SELECT t FROM TblTipoInforme t")
    , @NamedQuery(name = "TblTipoInforme.findByTfCod", query = "SELECT t FROM TblTipoInforme t WHERE t.tfCod = :tfCod")
    , @NamedQuery(name = "TblTipoInforme.findByTfNom", query = "SELECT t FROM TblTipoInforme t WHERE t.tfNom = :tfNom")
    , @NamedQuery(name = "TblTipoInforme.findByTfDes", query = "SELECT t FROM TblTipoInforme t WHERE t.tfDes = :tfDes")})
public class TblTipoInforme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tf_cod", nullable = false)
    private Integer tfCod;
    @Basic(optional = false)
    @Column(name = "tf_nom", nullable = false, length = 100)
    private String tfNom;
    @Column(name = "tf_des", length = 100)
    private String tfDes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instTfCod")
    private List<TblInstitucion> tblInstitucionList;

    public TblTipoInforme() {
    }

    public TblTipoInforme(Integer tfCod) {
        this.tfCod = tfCod;
    }

    public TblTipoInforme(Integer tfCod, String tfNom) {
        this.tfCod = tfCod;
        this.tfNom = tfNom;
    }

    public Integer getTfCod() {
        return tfCod;
    }

    public void setTfCod(Integer tfCod) {
        this.tfCod = tfCod;
    }

    public String getTfNom() {
        return tfNom;
    }

    public void setTfNom(String tfNom) {
        this.tfNom = tfNom;
    }

    public String getTfDes() {
        return tfDes;
    }

    public void setTfDes(String tfDes) {
        this.tfDes = tfDes;
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
        hash += (tfCod != null ? tfCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTipoInforme)) {
            return false;
        }
        TblTipoInforme other = (TblTipoInforme) object;
        if ((this.tfCod == null && other.tfCod != null) || (this.tfCod != null && !this.tfCod.equals(other.tfCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.catalogos.TblTipoInforme[ tfCod=" + tfCod + " ]";
    }
    
}
