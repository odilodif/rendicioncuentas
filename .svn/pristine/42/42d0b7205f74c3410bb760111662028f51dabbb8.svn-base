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
@Table(name = "tbl_seguro_general", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSeguroGeneral.findAll", query = "SELECT t FROM TblSeguroGeneral t")
    , @NamedQuery(name = "TblSeguroGeneral.findBySgCod", query = "SELECT t FROM TblSeguroGeneral t WHERE t.sgCod = :sgCod")
    , @NamedQuery(name = "TblSeguroGeneral.findBySgPresin", query = "SELECT t FROM TblSeguroGeneral t WHERE t.sgPresin = :sgPresin")
    , @NamedQuery(name = "TblSeguroGeneral.findBySgAposr", query = "SELECT t FROM TblSeguroGeneral t WHERE t.sgAposr = :sgAposr")
    , @NamedQuery(name = "TblSeguroGeneral.findBySgApopp", query = "SELECT t FROM TblSeguroGeneral t WHERE t.sgApopp = :sgApopp")
    , @NamedQuery(name = "TblSeguroGeneral.findBySgIngfr", query = "SELECT t FROM TblSeguroGeneral t WHERE t.sgIngfr = :sgIngfr")
    , @NamedQuery(name = "TblSeguroGeneral.findBySgUtilinv", query = "SELECT t FROM TblSeguroGeneral t WHERE t.sgUtilinv = :sgUtilinv")
    , @NamedQuery(name = "TblSeguroGeneral.findBySgJubil", query = "SELECT t FROM TblSeguroGeneral t WHERE t.sgJubil = :sgJubil")
    , @NamedQuery(name = "TblSeguroGeneral.findBySgPcod", query = "SELECT t FROM TblSeguroGeneral t WHERE t.sgPcod = :sgPcod")
    , @NamedQuery(name = "TblSeguroGeneral.findBySgPejec", query = "SELECT t FROM TblSeguroGeneral t WHERE t.sgPejec = :sgPejec")})
public class TblSeguroGeneral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sg_cod", nullable = false)
    private Integer sgCod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sg_presin", precision = 18, scale = 2)
    private BigDecimal sgPresin;
    @Column(name = "sg_aposr", precision = 18, scale = 2)
    private BigDecimal sgAposr;
    @Column(name = "sg_apopp", precision = 18, scale = 2)
    private BigDecimal sgApopp;
    @Column(name = "sg_ingfr", precision = 18, scale = 2)
    private BigDecimal sgIngfr;
    @Column(name = "sg_utilinv", precision = 18, scale = 2)
    private BigDecimal sgUtilinv;
    @Column(name = "sg_jubil", precision = 18, scale = 2)
    private BigDecimal sgJubil;
    @Column(name = "sg_pcod", precision = 18, scale = 2)
    private BigDecimal sgPcod;
    @Column(name = "sg_pejec", precision = 18, scale = 2)
    private BigDecimal sgPejec;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod")
    @ManyToOne
    private TblInforme infCod;

    public TblSeguroGeneral() {
    }

    public TblSeguroGeneral(Integer sgCod) {
        this.sgCod = sgCod;
    }

    public Integer getSgCod() {
        return sgCod;
    }

    public void setSgCod(Integer sgCod) {
        this.sgCod = sgCod;
    }

    public BigDecimal getSgPresin() {
        return sgPresin;
    }

    public void setSgPresin(BigDecimal sgPresin) {
        this.sgPresin = sgPresin;
    }

    public BigDecimal getSgAposr() {
        return sgAposr;
    }

    public void setSgAposr(BigDecimal sgAposr) {
        this.sgAposr = sgAposr;
    }

    public BigDecimal getSgApopp() {
        return sgApopp;
    }

    public void setSgApopp(BigDecimal sgApopp) {
        this.sgApopp = sgApopp;
    }

    public BigDecimal getSgIngfr() {
        return sgIngfr;
    }

    public void setSgIngfr(BigDecimal sgIngfr) {
        this.sgIngfr = sgIngfr;
    }

    public BigDecimal getSgUtilinv() {
        return sgUtilinv;
    }

    public void setSgUtilinv(BigDecimal sgUtilinv) {
        this.sgUtilinv = sgUtilinv;
    }

    public BigDecimal getSgJubil() {
        return sgJubil;
    }

    public void setSgJubil(BigDecimal sgJubil) {
        this.sgJubil = sgJubil;
    }

    public BigDecimal getSgPcod() {
        return sgPcod;
    }

    public void setSgPcod(BigDecimal sgPcod) {
        this.sgPcod = sgPcod;
    }

    public BigDecimal getSgPejec() {
        return sgPejec;
    }

    public void setSgPejec(BigDecimal sgPejec) {
        this.sgPejec = sgPejec;
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
        hash += (sgCod != null ? sgCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSeguroGeneral)) {
            return false;
        }
        TblSeguroGeneral other = (TblSeguroGeneral) object;
        if ((this.sgCod == null && other.sgCod != null) || (this.sgCod != null && !this.sgCod.equals(other.sgCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblSeguroGeneral[ sgCod=" + sgCod + " ]";
    }
    
}
