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
@Table(name = "tbl_presupuesto_institucional", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPresupuestoInstitucional.findAll", query = "SELECT t FROM TblPresupuestoInstitucional t")
    , @NamedQuery(name = "TblPresupuestoInstitucional.findByPreInsti", query = "SELECT t FROM TblPresupuestoInstitucional t WHERE t.preInsti = :preInsti")
    , @NamedQuery(name = "TblPresupuestoInstitucional.findByInfPresupuesto", query = "SELECT t FROM TblPresupuestoInstitucional t WHERE t.infPresupuesto = :infPresupuesto")
    , @NamedQuery(name = "TblPresupuestoInstitucional.findByInfGastplan", query = "SELECT t FROM TblPresupuestoInstitucional t WHERE t.infGastplan = :infGastplan")
    , @NamedQuery(name = "TblPresupuestoInstitucional.findByInfGastejec", query = "SELECT t FROM TblPresupuestoInstitucional t WHERE t.infGastejec = :infGastejec")
    , @NamedQuery(name = "TblPresupuestoInstitucional.findByInfGastinvplan", query = "SELECT t FROM TblPresupuestoInstitucional t WHERE t.infGastinvplan = :infGastinvplan")
    , @NamedQuery(name = "TblPresupuestoInstitucional.findByInfGastinvejec", query = "SELECT t FROM TblPresupuestoInstitucional t WHERE t.infGastinvejec = :infGastinvejec")
    , @NamedQuery(name = "TblPresupuestoInstitucional.findByInfPorcetejecpres", query = "SELECT t FROM TblPresupuestoInstitucional t WHERE t.infPorcetejecpres = :infPorcetejecpres")})
public class TblPresupuestoInstitucional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pre_insti", nullable = false)
    private Integer preInsti;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inf_presupuesto", precision = 18, scale = 2)
    private BigDecimal infPresupuesto;
    @Column(name = "inf_gastplan", precision = 18, scale = 2)
    private BigDecimal infGastplan;
    @Column(name = "inf_gastejec", precision = 18, scale = 2)
    private BigDecimal infGastejec;
    @Column(name = "inf_gastinvplan", precision = 18, scale = 2)
    private BigDecimal infGastinvplan;
    @Column(name = "inf_gastinvejec", precision = 18, scale = 2)
    private BigDecimal infGastinvejec;
    @Column(name = "inf_porcetejecpres", precision = 18, scale = 2)
    private BigDecimal infPorcetejecpres;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod")
    @ManyToOne
    private TblInforme infCod;

    public TblPresupuestoInstitucional() {
    }

    public TblPresupuestoInstitucional(Integer preInsti) {
        this.preInsti = preInsti;
    }

    public Integer getPreInsti() {
        return preInsti;
    }

    public void setPreInsti(Integer preInsti) {
        this.preInsti = preInsti;
    }

    public BigDecimal getInfPresupuesto() {
        return infPresupuesto;
    }

    public void setInfPresupuesto(BigDecimal infPresupuesto) {
        this.infPresupuesto = infPresupuesto;
    }

    public BigDecimal getInfGastplan() {
        return infGastplan;
    }

    public void setInfGastplan(BigDecimal infGastplan) {
        this.infGastplan = infGastplan;
    }

    public BigDecimal getInfGastejec() {
        return infGastejec;
    }

    public void setInfGastejec(BigDecimal infGastejec) {
        this.infGastejec = infGastejec;
    }

    public BigDecimal getInfGastinvplan() {
        return infGastinvplan;
    }

    public void setInfGastinvplan(BigDecimal infGastinvplan) {
        this.infGastinvplan = infGastinvplan;
    }

    public BigDecimal getInfGastinvejec() {
        return infGastinvejec;
    }

    public void setInfGastinvejec(BigDecimal infGastinvejec) {
        this.infGastinvejec = infGastinvejec;
    }

    public BigDecimal getInfPorcetejecpres() {
        return infPorcetejecpres;
    }

    public void setInfPorcetejecpres(BigDecimal infPorcetejecpres) {
        this.infPorcetejecpres = infPorcetejecpres;
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
        hash += (preInsti != null ? preInsti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPresupuestoInstitucional)) {
            return false;
        }
        TblPresupuestoInstitucional other = (TblPresupuestoInstitucional) object;
        if ((this.preInsti == null && other.preInsti != null) || (this.preInsti != null && !this.preInsti.equals(other.preInsti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblPresupuestoInstitucional[ preInsti=" + preInsti + " ]";
    }
    
}
