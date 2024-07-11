/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.rendicion;

import java.io.Serializable;
import java.util.regex.Pattern;

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
import org.springframework.web.util.HtmlUtils;

import gob.cpccs.utilidades.Constantes;



/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_plan_trabajo", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPlanTrabajo.findAll", query = "SELECT t FROM TblPlanTrabajo t")
    , @NamedQuery(name = "TblPlanTrabajo.findByPltCod", query = "SELECT t FROM TblPlanTrabajo t WHERE t.pltCod = :pltCod")
    , @NamedQuery(name = "TblPlanTrabajo.findByPltPlan", query = "SELECT t FROM TblPlanTrabajo t WHERE t.pltPlan = :pltPlan")
    , @NamedQuery(name = "TblPlanTrabajo.findByPtlAcciones", query = "SELECT t FROM TblPlanTrabajo t WHERE t.ptlAcciones = :ptlAcciones")
    , @NamedQuery(name = "TblPlanTrabajo.findByPtlResultados", query = "SELECT t FROM TblPlanTrabajo t WHERE t.ptlResultados = :ptlResultados")
    , @NamedQuery(name = "TblPlanTrabajo.findByPtlObs", query = "SELECT t FROM TblPlanTrabajo t WHERE t.ptlObs = :ptlObs")})
public class TblPlanTrabajo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "plt_cod", nullable = false)
    private Integer pltCod;
    @Column(name = "plt_plan", length = 2147483647)
    private String pltPlan;
    @Column(name = "ptl_acciones", length = 2147483647)
    private String ptlAcciones;
    @Column(name = "ptl_resultados", length = 2147483647)
    private String ptlResultados;
    @Column(name = "ptl_obs", length = 2147483647)
    private String ptlObs;
    @JoinColumn(name = "inf_aut_cod", referencedColumnName = "inf_aut_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInformeAutoridad infAutCod;

    public TblPlanTrabajo() {
    }

    public TblPlanTrabajo(Integer pltCod) {
        this.pltCod = pltCod;
    }

    public Integer getPltCod() {
        return pltCod;
    }

    public void setPltCod(Integer pltCod) {
        this.pltCod = pltCod;
    }

    public String getPltPlan() {
        return pltPlan;
    }

    public void setPltPlan(String pltPlan) {
        this.pltPlan = pltPlan;
    }

	public String getPtlAcciones() {
        return ptlAcciones;
    }

    public void setPtlAcciones(String ptlAcciones) {
        this.ptlAcciones = ptlAcciones;
    }

    public String getPtlResultados() {
        return ptlResultados;
    }

    public void setPtlResultados(String ptlResultados) {
        this.ptlResultados = ptlResultados;
    }

    public String getPtlObs() {
        return ptlObs;
    }

    public void setPtlObs(String ptlObs) {
        this.ptlObs = ptlObs;
    }

    public TblInformeAutoridad getInfAutCod() {
        return infAutCod;
    }

    public void setInfAutCod(TblInformeAutoridad infAutCod) {
        this.infAutCod = infAutCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pltCod != null ? pltCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPlanTrabajo)) {
            return false;
        }
        TblPlanTrabajo other = (TblPlanTrabajo) object;
        if ((this.pltCod == null && other.pltCod != null) || (this.pltCod != null && !this.pltCod.equals(other.pltCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblPlanTrabajo[ pltCod=" + pltCod + " ]";
    }
    
}
