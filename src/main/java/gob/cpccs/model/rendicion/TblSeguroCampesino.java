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
@Table(name = "tbl_seguro_campesino", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSeguroCampesino.findAll", query = "SELECT t FROM TblSeguroCampesino t")
    , @NamedQuery(name = "TblSeguroCampesino.findByScCod", query = "SELECT t FROM TblSeguroCampesino t WHERE t.scCod = :scCod")
    , @NamedQuery(name = "TblSeguroCampesino.findByScPresins", query = "SELECT t FROM TblSeguroCampesino t WHERE t.scPresins = :scPresins")
    , @NamedQuery(name = "TblSeguroCampesino.findByScConjf", query = "SELECT t FROM TblSeguroCampesino t WHERE t.scConjf = :scConjf")
    , @NamedQuery(name = "TblSeguroCampesino.findByScConpat", query = "SELECT t FROM TblSeguroCampesino t WHERE t.scConpat = :scConpat")
    , @NamedQuery(name = "TblSeguroCampesino.findByScConest", query = "SELECT t FROM TblSeguroCampesino t WHERE t.scConest = :scConest")
    , @NamedQuery(name = "TblSeguroCampesino.findByScConsp", query = "SELECT t FROM TblSeguroCampesino t WHERE t.scConsp = :scConsp")
    , @NamedQuery(name = "TblSeguroCampesino.findByScPresc", query = "SELECT t FROM TblSeguroCampesino t WHERE t.scPresc = :scPresc")
    , @NamedQuery(name = "TblSeguroCampesino.findByScPrese", query = "SELECT t FROM TblSeguroCampesino t WHERE t.scPrese = :scPrese")
    , @NamedQuery(name = "TblSeguroCampesino.findByScContraba", query = "SELECT t FROM TblSeguroCampesino t WHERE t.scContraba = :scContraba")})
public class TblSeguroCampesino implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sc_cod", nullable = false)
    private Integer scCod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sc_presins", precision = 18, scale = 2)
    private BigDecimal scPresins;
    @Column(name = "sc_conjf", precision = 18, scale = 2)
    private BigDecimal scConjf;
    @Column(name = "sc_conpat", precision = 18, scale = 2)
    private BigDecimal scConpat;
    @Column(name = "sc_conest", precision = 18, scale = 2)
    private BigDecimal scConest;
    @Column(name = "sc_consp", precision = 18, scale = 2)
    private BigDecimal scConsp;
    @Column(name = "sc_presc", precision = 18, scale = 2)
    private BigDecimal scPresc;
    @Column(name = "sc_prese", precision = 18, scale = 2)
    private BigDecimal scPrese;
    @Column(name = "sc_contraba", precision = 20, scale = 2)
    private BigDecimal scContraba;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod")
    @ManyToOne
    private TblInforme infCod;

    public TblSeguroCampesino() {
    }

    public TblSeguroCampesino(Integer scCod) {
        this.scCod = scCod;
    }

    public Integer getScCod() {
        return scCod;
    }

    public void setScCod(Integer scCod) {
        this.scCod = scCod;
    }

    public BigDecimal getScPresins() {
        return scPresins;
    }

    public void setScPresins(BigDecimal scPresins) {
        this.scPresins = scPresins;
    }

    public BigDecimal getScConjf() {
        return scConjf;
    }

    public void setScConjf(BigDecimal scConjf) {
        this.scConjf = scConjf;
    }

    public BigDecimal getScConpat() {
        return scConpat;
    }

    public void setScConpat(BigDecimal scConpat) {
        this.scConpat = scConpat;
    }

    public BigDecimal getScConest() {
        return scConest;
    }

    public void setScConest(BigDecimal scConest) {
        this.scConest = scConest;
    }

    public BigDecimal getScConsp() {
        return scConsp;
    }

    public void setScConsp(BigDecimal scConsp) {
        this.scConsp = scConsp;
    }

    public BigDecimal getScPresc() {
        return scPresc;
    }

    public void setScPresc(BigDecimal scPresc) {
        this.scPresc = scPresc;
    }

    public BigDecimal getScPrese() {
        return scPrese;
    }

    public void setScPrese(BigDecimal scPrese) {
        this.scPrese = scPrese;
    }

    public BigDecimal getScContraba() {
        return scContraba;
    }

    public void setScContraba(BigDecimal scContraba) {
        this.scContraba = scContraba;
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
        hash += (scCod != null ? scCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSeguroCampesino)) {
            return false;
        }
        TblSeguroCampesino other = (TblSeguroCampesino) object;
        if ((this.scCod == null && other.scCod != null) || (this.scCod != null && !this.scCod.equals(other.scCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblSeguroCampesino[ scCod=" + scCod + " ]";
    }
    
}
