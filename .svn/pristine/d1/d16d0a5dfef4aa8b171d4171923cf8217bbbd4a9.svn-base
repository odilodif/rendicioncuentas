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
@Table(name = "tbl_incoporacion_recomendaciones", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblIncoporacionRecomendaciones.findAll", query = "SELECT t FROM TblIncoporacionRecomendaciones t")
    , @NamedQuery(name = "TblIncoporacionRecomendaciones.findByIreCod", query = "SELECT t FROM TblIncoporacionRecomendaciones t WHERE t.ireCod = :ireCod")
    , @NamedQuery(name = "TblIncoporacionRecomendaciones.findByIreEntidad", query = "SELECT t FROM TblIncoporacionRecomendaciones t WHERE t.ireEntidad = :ireEntidad")
    , @NamedQuery(name = "TblIncoporacionRecomendaciones.findByIreDescripcion", query = "SELECT t FROM TblIncoporacionRecomendaciones t WHERE t.ireDescripcion = :ireDescripcion")
    , @NamedQuery(name = "TblIncoporacionRecomendaciones.findByIreCumplimiento", query = "SELECT t FROM TblIncoporacionRecomendaciones t WHERE t.ireCumplimiento = :ireCumplimiento")
    , @NamedQuery(name = "TblIncoporacionRecomendaciones.findByIrePorcentaje", query = "SELECT t FROM TblIncoporacionRecomendaciones t WHERE t.irePorcentaje = :irePorcentaje")
    , @NamedQuery(name = "TblIncoporacionRecomendaciones.findByIreObs", query = "SELECT t FROM TblIncoporacionRecomendaciones t WHERE t.ireObs = :ireObs")
    , @NamedQuery(name = "TblIncoporacionRecomendaciones.findByIreLink", query = "SELECT t FROM TblIncoporacionRecomendaciones t WHERE t.ireLink = :ireLink")})
public class TblIncoporacionRecomendaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ire_cod", nullable = false)
    private Integer ireCod;
    @Column(name = "ire_entidad", length = 200)
    private String ireEntidad;
    @Column(name = "ire_descripcion", length = 2147483647)
    private String ireDescripcion;
    @Column(name = "ire_cumplimiento", length = 2147483647)
    private String ireCumplimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ire_porcentaje", precision = 18, scale = 2)
    private BigDecimal irePorcentaje;
    @Column(name = "ire_obs", length = 2147483647)
    private String ireObs;
    @Column(name = "ire_link", length = 500)
    private String ireLink;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblIncoporacionRecomendaciones() {
    }

    public TblIncoporacionRecomendaciones(Integer ireCod) {
        this.ireCod = ireCod;
    }

    public Integer getIreCod() {
        return ireCod;
    }

    public void setIreCod(Integer ireCod) {
        this.ireCod = ireCod;
    }

    public String getIreEntidad() {
        return ireEntidad;
    }

    public void setIreEntidad(String ireEntidad) {
        this.ireEntidad = ireEntidad;
    }

    public String getIreDescripcion() {
        return ireDescripcion;
    }

    public void setIreDescripcion(String ireDescripcion) {
        this.ireDescripcion = ireDescripcion;
    }

    public String getIreCumplimiento() {
        return ireCumplimiento;
    }

    public void setIreCumplimiento(String ireCumplimiento) {
        this.ireCumplimiento = ireCumplimiento;
    }

    public BigDecimal getIrePorcentaje() {
        return irePorcentaje;
    }

    public void setIrePorcentaje(BigDecimal irePorcentaje) {
        this.irePorcentaje = irePorcentaje;
    }

    public String getIreObs() {
        return ireObs;
    }

    public void setIreObs(String ireObs) {
        this.ireObs = ireObs;
    }

    public String getIreLink() {
        return ireLink;
    }

    public void setIreLink(String ireLink) {
        this.ireLink = ireLink;
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
        hash += (ireCod != null ? ireCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblIncoporacionRecomendaciones)) {
            return false;
        }
        TblIncoporacionRecomendaciones other = (TblIncoporacionRecomendaciones) object;
        if ((this.ireCod == null && other.ireCod != null) || (this.ireCod != null && !this.ireCod.equals(other.ireCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblIncoporacionRecomendaciones[ ireCod=" + ireCod + " ]";
    }
    
}
