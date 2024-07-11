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
@Table(name = "tbl_plan_desarrollo", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPlanDesarrollo.findAll", query = "SELECT t FROM TblPlanDesarrollo t")
    , @NamedQuery(name = "TblPlanDesarrollo.findByPdCod", query = "SELECT t FROM TblPlanDesarrollo t WHERE t.pdCod = :pdCod")
    , @NamedQuery(name = "TblPlanDesarrollo.findByPdObjetivo", query = "SELECT t FROM TblPlanDesarrollo t WHERE t.pdObjetivo = :pdObjetivo")
    , @NamedQuery(name = "TblPlanDesarrollo.findByPdPorcAvanceAcum", query = "SELECT t FROM TblPlanDesarrollo t WHERE t.pdPorcAvanceAcum = :pdPorcAvanceAcum")
    , @NamedQuery(name = "TblPlanDesarrollo.findByPdRazon", query = "SELECT t FROM TblPlanDesarrollo t WHERE t.pdRazon = :pdRazon")
    , @NamedQuery(name = "TblPlanDesarrollo.findByObjCod", query = "SELECT t FROM TblPlanDesarrollo t WHERE t.objCod = :objCod")})
public class TblPlanDesarrollo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pd_cod", nullable = false)
    private Integer pdCod;
    @Column(name = "pd_objetivo", length = 2147483647)
    private String pdObjetivo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pd_porc_avance_acum", precision = 18, scale = 2)
    private BigDecimal pdPorcAvanceAcum;
    @Column(name = "pd_razon", length = 2147483647)
    private String pdRazon;
    @Column(name = "obj_cod")
    private Integer objCod;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;
    @Column(name = "pd_estado", length = 15)
    private String pdEstado;

    public TblPlanDesarrollo() {
    }

    public TblPlanDesarrollo(Integer pdCod) {
        this.pdCod = pdCod;
    }

    public Integer getPdCod() {
        return pdCod;
    }

    public void setPdCod(Integer pdCod) {
        this.pdCod = pdCod;
    }

    public String getPdObjetivo() {
        return pdObjetivo;
    }

    public void setPdObjetivo(String pdObjetivo) {
        this.pdObjetivo = pdObjetivo;
    }

    public BigDecimal getPdPorcAvanceAcum() {
        return pdPorcAvanceAcum;
    }

    public void setPdPorcAvanceAcum(BigDecimal pdPorcAvanceAcum) {
        this.pdPorcAvanceAcum = pdPorcAvanceAcum;
    }

    public String getPdRazon() {
        return pdRazon;
    }

    public void setPdRazon(String pdRazon) {
        this.pdRazon = pdRazon;
    }

    public Integer getObjCod() {
        return objCod;
    }

    public void setObjCod(Integer objCod) {
        this.objCod = objCod;
    }

    public TblInforme getInfCod() {
        return infCod;
    }

    public void setInfCod(TblInforme infCod) {
        this.infCod = infCod;
    }

    public String getPdEstado() {
        return pdEstado;
    }

    public void setPdEstado(String pdEstado) {
        this.pdEstado = pdEstado;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pdCod != null ? pdCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPlanDesarrollo)) {
            return false;
        }
        TblPlanDesarrollo other = (TblPlanDesarrollo) object;
        if ((this.pdCod == null && other.pdCod != null) || (this.pdCod != null && !this.pdCod.equals(other.pdCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblPlanDesarrollo[ pdCod=" + pdCod + " ]";
    }
    
}
