/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.rendicion;

import java.io.Serializable;
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
@Table(name = "tbl_cumplimiento_obligaciones", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCumplimientoObligaciones.findAll", query = "SELECT t FROM TblCumplimientoObligaciones t")
    , @NamedQuery(name = "TblCumplimientoObligaciones.findByCumOblCod", query = "SELECT t FROM TblCumplimientoObligaciones t WHERE t.cumOblCod = :cumOblCod")
    , @NamedQuery(name = "TblCumplimientoObligaciones.findByInfLaborales", query = "SELECT t FROM TblCumplimientoObligaciones t WHERE t.infLaborales = :infLaborales")
    , @NamedQuery(name = "TblCumplimientoObligaciones.findByInfTributarias", query = "SELECT t FROM TblCumplimientoObligaciones t WHERE t.infTributarias = :infTributarias")
    , @NamedQuery(name = "TblCumplimientoObligaciones.findByInfLinkcumplimiento", query = "SELECT t FROM TblCumplimientoObligaciones t WHERE t.infLinkcumplimiento = :infLinkcumplimiento")})
public class TblCumplimientoObligaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cum_obl_cod", nullable = false)
    private Integer cumOblCod;
    @Column(name = "inf_laborales", length = 2)
    private String infLaborales;
    @Column(name = "inf_tributarias", length = 2)
    private String infTributarias;
    @Column(name = "inf_linkcumplimiento", length = 250)
    private String infLinkcumplimiento;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblCumplimientoObligaciones() {
    }

    public TblCumplimientoObligaciones(Integer cumOblCod) {
        this.cumOblCod = cumOblCod;
    }

    public Integer getCumOblCod() {
        return cumOblCod;
    }

    public void setCumOblCod(Integer cumOblCod) {
        this.cumOblCod = cumOblCod;
    }

    public String getInfLaborales() {
        return infLaborales;
    }

    public void setInfLaborales(String infLaborales) {
        this.infLaborales = infLaborales;
    }

    public String getInfTributarias() {
        return infTributarias;
    }

    public void setInfTributarias(String infTributarias) {
        this.infTributarias = infTributarias;
    }

    public String getInfLinkcumplimiento() {
        return infLinkcumplimiento;
    }

    public void setInfLinkcumplimiento(String infLinkcumplimiento) {
        this.infLinkcumplimiento = infLinkcumplimiento;
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
        hash += (cumOblCod != null ? cumOblCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCumplimientoObligaciones)) {
            return false;
        }
        TblCumplimientoObligaciones other = (TblCumplimientoObligaciones) object;
        if ((this.cumOblCod == null && other.cumOblCod != null) || (this.cumOblCod != null && !this.cumOblCod.equals(other.cumOblCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblCumplimientoObligaciones[ cumOblCod=" + cumOblCod + " ]";
    }
    
}
