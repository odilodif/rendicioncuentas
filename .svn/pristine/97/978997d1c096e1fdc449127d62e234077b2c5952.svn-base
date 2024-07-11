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

import org.apache.commons.lang.StringEscapeUtils;

import gob.cpccs.utilidades.Constantes;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_plan_trabajo_gad", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPlanTrabajoGad.findAll", query = "SELECT t FROM TblPlanTrabajoGad t")
    , @NamedQuery(name = "TblPlanTrabajoGad.findByPtgCod", query = "SELECT t FROM TblPlanTrabajoGad t WHERE t.ptgCod = :ptgCod")
    , @NamedQuery(name = "TblPlanTrabajoGad.findByPtgObjetivo", query = "SELECT t FROM TblPlanTrabajoGad t WHERE t.ptgObjetivo = :ptgObjetivo")
    , @NamedQuery(name = "TblPlanTrabajoGad.findByPtgDescPrograma", query = "SELECT t FROM TblPlanTrabajoGad t WHERE t.ptgDescPrograma = :ptgDescPrograma")
    , @NamedQuery(name = "TblPlanTrabajoGad.findByPtgPorcAvance", query = "SELECT t FROM TblPlanTrabajoGad t WHERE t.ptgPorcAvance = :ptgPorcAvance")
    , @NamedQuery(name = "TblPlanTrabajoGad.findByPtgDescResultados", query = "SELECT t FROM TblPlanTrabajoGad t WHERE t.ptgDescResultados = :ptgDescResultados")})
public class TblPlanTrabajoGad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ptg_cod", nullable = false)
    private Integer ptgCod;
    @Column(name = "ptg_objetivo", length = 2147483647)
    private String ptgObjetivo;
    @Column(name = "ptg_desc_programa", length = 2147483647)
    private String ptgDescPrograma;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ptg_porc_avance", precision = 18, scale = 2)
    private BigDecimal ptgPorcAvance;
    @Column(name = "ptg_desc_resultados", length = 2147483647)
    private String ptgDescResultados;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblPlanTrabajoGad() {
    }

    public TblPlanTrabajoGad(Integer ptgCod) {
        this.ptgCod = ptgCod;
    }

    public Integer getPtgCod() {
        return ptgCod;
    }

    public void setPtgCod(Integer ptgCod) {
        this.ptgCod = ptgCod;
    }

    public String getPtgObjetivo() {
        return ptgObjetivo;
    }

    public void setPtgObjetivo(String ptgObjetivo) {
        this.ptgObjetivo = ptgObjetivo;
    }

    public String getPtgDescPrograma() {
        return ptgDescPrograma;
    }

    public void setPtgDescPrograma(String ptgDescPrograma) {
        this.ptgDescPrograma = ptgDescPrograma;
    }

    public BigDecimal getPtgPorcAvance() {
        return ptgPorcAvance;
    }

    public void setPtgPorcAvance(BigDecimal ptgPorcAvance) {
        this.ptgPorcAvance = ptgPorcAvance;
    }

    public String getPtgDescResultados() {
        return ptgDescResultados;
    }

    public void setPtgDescResultados(String ptgDescResultados) {
        this.ptgDescResultados = ptgDescResultados;
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
        hash += (ptgCod != null ? ptgCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPlanTrabajoGad)) {
            return false;
        }
        TblPlanTrabajoGad other = (TblPlanTrabajoGad) object;
        if ((this.ptgCod == null && other.ptgCod != null) || (this.ptgCod != null && !this.ptgCod.equals(other.ptgCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblPlanTrabajoGad[ ptgCod=" + ptgCod + " ]";
    }
    
}
