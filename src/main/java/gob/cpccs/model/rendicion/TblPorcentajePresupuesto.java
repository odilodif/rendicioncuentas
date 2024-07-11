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
@Table(name = "tbl_porcentaje_presupuesto", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPorcentajePresupuesto.findAll", query = "SELECT t FROM TblPorcentajePresupuesto t")
    , @NamedQuery(name = "TblPorcentajePresupuesto.findByPresCod", query = "SELECT t FROM TblPorcentajePresupuesto t WHERE t.presCod = :presCod")
    , @NamedQuery(name = "TblPorcentajePresupuesto.findByInfPresparticipativo", query = "SELECT t FROM TblPorcentajePresupuesto t WHERE t.infPresparticipativo = :infPresparticipativo")
    , @NamedQuery(name = "TblPorcentajePresupuesto.findByInfTotalpres", query = "SELECT t FROM TblPorcentajePresupuesto t WHERE t.infTotalpres = :infTotalpres")
    , @NamedQuery(name = "TblPorcentajePresupuesto.findByInfPorprespar", query = "SELECT t FROM TblPorcentajePresupuesto t WHERE t.infPorprespar = :infPorprespar")
    , @NamedQuery(name = "TblPorcentajePresupuesto.findByInfLinkpres", query = "SELECT t FROM TblPorcentajePresupuesto t WHERE t.infLinkpres = :infLinkpres")
    , @NamedQuery(name = "TblPorcentajePresupuesto.findByInfPriorizanecpp", query = "SELECT t FROM TblPorcentajePresupuesto t WHERE t.infPriorizanecpp = :infPriorizanecpp")
    , @NamedQuery(name = "TblPorcentajePresupuesto.findByInfTieneprespar", query = "SELECT t FROM TblPorcentajePresupuesto t WHERE t.infTieneprespar = :infTieneprespar")})
public class TblPorcentajePresupuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pres_cod", nullable = false)
    private Integer presCod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inf_presparticipativo", precision = 18, scale = 2)
    private BigDecimal infPresparticipativo;
    @Column(name = "inf_total_pres", precision = 18, scale = 2)
    private BigDecimal infTotalpres;
    @Column(name = "inf_porprespar", precision = 18, scale = 2)
    private BigDecimal infPorprespar;
    @Column(name = "inf_linkpres", length = 255)
    private String infLinkpres;
    @Column(name = "inf_priorizanecpp", length = 2147483647)
    private String infPriorizanecpp;
    @Column(name = "inf_tieneprespar", length = 2)
    private String infTieneprespar;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblPorcentajePresupuesto() {
    }

    public TblPorcentajePresupuesto(Integer presCod) {
        this.presCod = presCod;
    }

    public Integer getPresCod() {
        return presCod;
    }

    public void setPresCod(Integer presCod) {
        this.presCod = presCod;
    }

    public BigDecimal getInfPresparticipativo() {
        return infPresparticipativo;
    }

    public void setInfPresparticipativo(BigDecimal infPresparticipativo) {
        this.infPresparticipativo = infPresparticipativo;
    }

    public BigDecimal getInfTotalpres() {
        return infTotalpres;
    }

    public void setInfTotalpres(BigDecimal infTotalpres) {
        this.infTotalpres = infTotalpres;
    }

    public BigDecimal getInfPorprespar() {
        return infPorprespar;
    }

    public void setInfPorprespar(BigDecimal infPorprespar) {
        this.infPorprespar = infPorprespar;
    }

    public String getInfLinkpres() {
        return infLinkpres;
    }

    public void setInfLinkpres(String infLinkpres) {
        this.infLinkpres = infLinkpres;
    }

    public String getInfPriorizanecpp() {
        return infPriorizanecpp;
    }

    public void setInfPriorizanecpp(String infPriorizanecpp) {
        this.infPriorizanecpp = infPriorizanecpp;
    }

    public String getInfTieneprespar() {
        return infTieneprespar;
    }

    public void setInfTieneprespar(String infTieneprespar) {
        this.infTieneprespar = infTieneprespar;
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
        hash += (presCod != null ? presCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPorcentajePresupuesto)) {
            return false;
        }
        TblPorcentajePresupuesto other = (TblPorcentajePresupuesto) object;
        if ((this.presCod == null && other.presCod != null) || (this.presCod != null && !this.presCod.equals(other.presCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblPorcentajePresupuesto[ presCod=" + presCod + " ]";
    }
    
}
