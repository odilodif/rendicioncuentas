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
@Table(name = "tbl_proy_presupuesto_participativo", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProyPresupuestoParticipativo.findAll", query = "SELECT t FROM TblProyPresupuestoParticipativo t")
    , @NamedQuery(name = "TblProyPresupuestoParticipativo.findByProyCod", query = "SELECT t FROM TblProyPresupuestoParticipativo t WHERE t.proyCod = :proyCod")
    , @NamedQuery(name = "TblProyPresupuestoParticipativo.findByProyDescripcion", query = "SELECT t FROM TblProyPresupuestoParticipativo t WHERE t.proyDescripcion = :proyDescripcion")
    , @NamedQuery(name = "TblProyPresupuestoParticipativo.findByProyMontoplan", query = "SELECT t FROM TblProyPresupuestoParticipativo t WHERE t.proyMontoplan = :proyMontoplan")
    , @NamedQuery(name = "TblProyPresupuestoParticipativo.findByProyMontoejec", query = "SELECT t FROM TblProyPresupuestoParticipativo t WHERE t.proyMontoejec = :proyMontoejec")
    , @NamedQuery(name = "TblProyPresupuestoParticipativo.findByProyObs", query = "SELECT t FROM TblProyPresupuestoParticipativo t WHERE t.proyObs = :proyObs")
    , @NamedQuery(name = "TblProyPresupuestoParticipativo.findByProyPorcAvance", query = "SELECT t FROM TblProyPresupuestoParticipativo t WHERE t.proyPorcAvance = :proyPorcAvance")
    , @NamedQuery(name = "TblProyPresupuestoParticipativo.findByProyLinks", query = "SELECT t FROM TblProyPresupuestoParticipativo t WHERE t.proyLinks = :proyLinks")})
public class TblProyPresupuestoParticipativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proy_cod", nullable = false)
    private Integer proyCod;
    @Column(name = "proy_descripcion", length = 2147483647)
    private String proyDescripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "proy_montoplan", precision = 18, scale = 2)
    private BigDecimal proyMontoplan;
    @Column(name = "proy_montoejec", precision = 18, scale = 2)
    private BigDecimal proyMontoejec;
    @Column(name = "proy_obs", length = 2147483647)
    private String proyObs;
    @Column(name = "proy_porc_avance", length = 15)
    private String proyPorcAvance;
    @Column(name = "proy_links", length = 500)
    private String proyLinks;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod")
    @ManyToOne
    private TblInforme infCod;

    public TblProyPresupuestoParticipativo() {
    }

    public TblProyPresupuestoParticipativo(Integer proyCod) {
        this.proyCod = proyCod;
    }

    public Integer getProyCod() {
        return proyCod;
    }

    public void setProyCod(Integer proyCod) {
        this.proyCod = proyCod;
    }

    public String getProyDescripcion() {
        return proyDescripcion;
    }

    public void setProyDescripcion(String proyDescripcion) {
        this.proyDescripcion = proyDescripcion;
    }

    public BigDecimal getProyMontoplan() {
        return proyMontoplan;
    }

    public void setProyMontoplan(BigDecimal proyMontoplan) {
        this.proyMontoplan = proyMontoplan;
    }

    public BigDecimal getProyMontoejec() {
        return proyMontoejec;
    }

    public void setProyMontoejec(BigDecimal proyMontoejec) {
        this.proyMontoejec = proyMontoejec;
    }

    public String getProyObs() {
        return proyObs;
    }

    public void setProyObs(String proyObs) {
        this.proyObs = proyObs;
    }

    public String getProyPorcAvance() {
        return proyPorcAvance;
    }

    public void setProyPorcAvance(String proyPorcAvance) {
        this.proyPorcAvance = proyPorcAvance;
    }

    public String getProyLinks() {
        return proyLinks;
    }

    public void setProyLinks(String proyLinks) {
        this.proyLinks = proyLinks;
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
        hash += (proyCod != null ? proyCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProyPresupuestoParticipativo)) {
            return false;
        }
        TblProyPresupuestoParticipativo other = (TblProyPresupuestoParticipativo) object;
        if ((this.proyCod == null && other.proyCod != null) || (this.proyCod != null && !this.proyCod.equals(other.proyCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblProyPresupuestoParticipativo[ proyCod=" + proyCod + " ]";
    }
    
}
