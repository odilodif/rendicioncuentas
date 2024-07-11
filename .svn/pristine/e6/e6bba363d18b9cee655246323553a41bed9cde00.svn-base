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
@Table(name = "tbl_detalle_ejecucionp", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDetalleEjecucionp.findAll", query = "SELECT t FROM TblDetalleEjecucionp t")
    , @NamedQuery(name = "TblDetalleEjecucionp.findByDepCod", query = "SELECT t FROM TblDetalleEjecucionp t WHERE t.depCod = :depCod")
    , @NamedQuery(name = "TblDetalleEjecucionp.findByDepTipo", query = "SELECT t FROM TblDetalleEjecucionp t WHERE t.depTipo = :depTipo")
    , @NamedQuery(name = "TblDetalleEjecucionp.findByDepDescripcion", query = "SELECT t FROM TblDetalleEjecucionp t WHERE t.depDescripcion = :depDescripcion")
    , @NamedQuery(name = "TblDetalleEjecucionp.findByDepPresplan", query = "SELECT t FROM TblDetalleEjecucionp t WHERE t.depPresplan = :depPresplan")
    , @NamedQuery(name = "TblDetalleEjecucionp.findByDepPresejec", query = "SELECT t FROM TblDetalleEjecucionp t WHERE t.depPresejec = :depPresejec")
    , @NamedQuery(name = "TblDetalleEjecucionp.findByDepCumple", query = "SELECT t FROM TblDetalleEjecucionp t WHERE t.depCumple = :depCumple")
    , @NamedQuery(name = "TblDetalleEjecucionp.findByDepLink", query = "SELECT t FROM TblDetalleEjecucionp t WHERE t.depLink = :depLink")
    , @NamedQuery(name = "TblDetalleEjecucionp.findByDepTotal", query = "SELECT t FROM TblDetalleEjecucionp t WHERE t.depTotal = :depTotal")})
public class TblDetalleEjecucionp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dep_cod", nullable = false)
    private Integer depCod;
    @Column(name = "dep_tipo", length = 50)
    private String depTipo;
    @Column(name = "dep_descripcion", length = 2147483647)
    private String depDescripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dep_presplan", precision = 18, scale = 2)
    private BigDecimal depPresplan;
    @Column(name = "dep_presejec", precision = 18, scale = 2)
    private BigDecimal depPresejec;
    @Column(name = "dep_cumple", precision = 18, scale = 2)
    private BigDecimal depCumple;
    @Column(name = "dep_link", length = 500)
    private String depLink;
    @Column(name = "dep_total", precision = 18, scale = 2)
    private BigDecimal depTotal;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;
   
    public TblDetalleEjecucionp() {
    }

    public TblDetalleEjecucionp(Integer depCod) {
        this.depCod = depCod;
    }

    public Integer getDepCod() {
        return depCod;
    }

    public void setDepCod(Integer depCod) {
        this.depCod = depCod;
    }

    public String getDepTipo() {
        return depTipo;
    }

    public void setDepTipo(String depTipo) {
        this.depTipo = depTipo;
    }

    public String getDepDescripcion() {
        return depDescripcion;
    }

    public void setDepDescripcion(String depDescripcion) {
        this.depDescripcion = depDescripcion;
    }

    public BigDecimal getDepPresplan() {
        return depPresplan;
    }

    public void setDepPresplan(BigDecimal depPresplan) {
        this.depPresplan = depPresplan;
    }

    public BigDecimal getDepPresejec() {
        return depPresejec;
    }

    public void setDepPresejec(BigDecimal depPresejec) {
        this.depPresejec = depPresejec;
    }

    public BigDecimal getDepCumple() {
        return depCumple;
    }

    public void setDepCumple(BigDecimal depCumple) {
        this.depCumple = depCumple;
    }

    public String getDepLink() {
        return depLink;
    }

    public void setDepLink(String depLink) {
        this.depLink = depLink;
    }

    public BigDecimal getDepTotal() {
        return depTotal;
    }

    public void setDepTotal(BigDecimal depTotal) {
        this.depTotal = depTotal;
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
        hash += (depCod != null ? depCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleEjecucionp)) {
            return false;
        }
        TblDetalleEjecucionp other = (TblDetalleEjecucionp) object;
        if ((this.depCod == null && other.depCod != null) || (this.depCod != null && !this.depCod.equals(other.depCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblDetalleEjecucionp[ depCod=" + depCod + " ]";
    }
    
}
