/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.rendicion;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tbl_fondo_prestacional", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFondoPrestacional.findAll", query = "SELECT t FROM TblFondoPrestacional t")
    , @NamedQuery(name = "TblFondoPrestacional.findByFpCod", query = "SELECT t FROM TblFondoPrestacional t WHERE t.fpCod = :fpCod")
    , @NamedQuery(name = "TblFondoPrestacional.findByFpDesc", query = "SELECT t FROM TblFondoPrestacional t WHERE t.fpDesc = :fpDesc")
    , @NamedQuery(name = "TblFondoPrestacional.findByFpPresins", query = "SELECT t FROM TblFondoPrestacional t WHERE t.fpPresins = :fpPresins")
    , @NamedQuery(name = "TblFondoPrestacional.findByFpGastcp", query = "SELECT t FROM TblFondoPrestacional t WHERE t.fpGastcp = :fpGastcp")
    , @NamedQuery(name = "TblFondoPrestacional.findByFpGastce", query = "SELECT t FROM TblFondoPrestacional t WHERE t.fpGastce = :fpGastce")
    , @NamedQuery(name = "TblFondoPrestacional.findByFpGastip", query = "SELECT t FROM TblFondoPrestacional t WHERE t.fpGastip = :fpGastip")
    , @NamedQuery(name = "TblFondoPrestacional.findByFpGastie", query = "SELECT t FROM TblFondoPrestacional t WHERE t.fpGastie = :fpGastie")})
public class TblFondoPrestacional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fp_cod", nullable = false)
    private Integer fpCod;
    @Column(name = "fp_desc", length = 200)
    private String fpDesc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fp_presins", precision = 18, scale = 2)
    private BigDecimal fpPresins;
    @Column(name = "fp_gastcp", precision = 18, scale = 2)
    private BigDecimal fpGastcp;
    @Column(name = "fp_gastce", precision = 18, scale = 2)
    private BigDecimal fpGastce;
    @Column(name = "fp_gastip", precision = 18, scale = 2)
    private BigDecimal fpGastip;
    @Column(name = "fp_gastie", precision = 18, scale = 2)
    private BigDecimal fpGastie;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblFondoPrestacional() {
    }

    public TblFondoPrestacional(Integer fpCod) {
        this.fpCod = fpCod;
    }

    public Integer getFpCod() {
        return fpCod;
    }

    public void setFpCod(Integer fpCod) {
        this.fpCod = fpCod;
    }

    public String getFpDesc() {
        return fpDesc;
    }

    public void setFpDesc(String fpDesc) {
        this.fpDesc = fpDesc;
    }

    public BigDecimal getFpPresins() {
        return fpPresins;
    }

    public void setFpPresins(BigDecimal fpPresins) {
        this.fpPresins = fpPresins;
    }

    public BigDecimal getFpGastcp() {
        return fpGastcp;
    }

    public void setFpGastcp(BigDecimal fpGastcp) {
        this.fpGastcp = fpGastcp;
    }

    public BigDecimal getFpGastce() {
        return fpGastce;
    }

    public void setFpGastce(BigDecimal fpGastce) {
        this.fpGastce = fpGastce;
    }

    public BigDecimal getFpGastip() {
        return fpGastip;
    }

    public void setFpGastip(BigDecimal fpGastip) {
        this.fpGastip = fpGastip;
    }

    public BigDecimal getFpGastie() {
        return fpGastie;
    }

    public void setFpGastie(BigDecimal fpGastie) {
        this.fpGastie = fpGastie;
    }

    public TblInforme getInfCod() {
        return infCod;
    }

    public void setInfCod(TblInforme infCod) {
        this.infCod = infCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fpCod != null ? fpCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFondoPrestacional)) {
            return false;
        }
        TblFondoPrestacional other = (TblFondoPrestacional) object;
        if ((this.fpCod == null && other.fpCod != null) || (this.fpCod != null && !this.fpCod.equals(other.fpCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblFondoPrestacional[ fpCod=" + fpCod + " ]";
    }
    
}
