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
@Table(name = "tbl_presupuesto_educacion", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPresupuestoEducacion.findAll", query = "SELECT t FROM TblPresupuestoEducacion t")
    , @NamedQuery(name = "TblPresupuestoEducacion.findByPeCod", query = "SELECT t FROM TblPresupuestoEducacion t WHERE t.peCod = :peCod")
    , @NamedQuery(name = "TblPresupuestoEducacion.findByPeAspecto", query = "SELECT t FROM TblPresupuestoEducacion t WHERE t.peAspecto = :peAspecto")
    , @NamedQuery(name = "TblPresupuestoEducacion.findByPePlanificado", query = "SELECT t FROM TblPresupuestoEducacion t WHERE t.pePlanificado = :pePlanificado")
    , @NamedQuery(name = "TblPresupuestoEducacion.findByPeEjecutado", query = "SELECT t FROM TblPresupuestoEducacion t WHERE t.peEjecutado = :peEjecutado")
    , @NamedQuery(name = "TblPresupuestoEducacion.findByPeCumplimiento", query = "SELECT t FROM TblPresupuestoEducacion t WHERE t.peCumplimiento = :peCumplimiento")
    , @NamedQuery(name = "TblPresupuestoEducacion.findByPeTotal", query = "SELECT t FROM TblPresupuestoEducacion t WHERE t.peTotal = :peTotal")})
public class TblPresupuestoEducacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pe_cod", nullable = false)
    private Integer peCod;
    @Column(name = "pe_aspecto", length = 200)
    private String peAspecto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pe_planificado", precision = 18, scale = 2)
    private BigDecimal pePlanificado;
    @Column(name = "pe_ejecutado", precision = 18, scale = 2)
    private BigDecimal peEjecutado;
    @Column(name = "pe_cumplimiento", precision = 18, scale = 2)
    private BigDecimal peCumplimiento;
    @Column(name = "pe_total", precision = 18, scale = 2)
    private BigDecimal peTotal;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblPresupuestoEducacion() {
    }

    public TblPresupuestoEducacion(Integer peCod) {
        this.peCod = peCod;
    }

    public Integer getPeCod() {
        return peCod;
    }

    public void setPeCod(Integer peCod) {
        this.peCod = peCod;
    }

    public String getPeAspecto() {
        return peAspecto;
    }

    public void setPeAspecto(String peAspecto) {
        this.peAspecto = peAspecto;
    }

    public BigDecimal getPePlanificado() {
        return pePlanificado;
    }

    public void setPePlanificado(BigDecimal pePlanificado) {
        this.pePlanificado = pePlanificado;
    }

    public BigDecimal getPeEjecutado() {
        return peEjecutado;
    }

    public void setPeEjecutado(BigDecimal peEjecutado) {
        this.peEjecutado = peEjecutado;
    }

    public BigDecimal getPeCumplimiento() {
        return peCumplimiento;
    }

    public void setPeCumplimiento(BigDecimal peCumplimiento) {
        this.peCumplimiento = peCumplimiento;
    }

    public BigDecimal getPeTotal() {
        return peTotal;
    }

    public void setPeTotal(BigDecimal peTotal) {
        this.peTotal = peTotal;
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
        hash += (peCod != null ? peCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPresupuestoEducacion)) {
            return false;
        }
        TblPresupuestoEducacion other = (TblPresupuestoEducacion) object;
        if ((this.peCod == null && other.peCod != null) || (this.peCod != null && !this.peCod.equals(other.peCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblPresupuestoEducacion[ peCod=" + peCod + " ]";
    }
    
}
