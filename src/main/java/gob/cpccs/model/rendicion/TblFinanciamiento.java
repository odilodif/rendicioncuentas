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
@Table(name = "tbl_financiamiento", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFinanciamiento.findAll", query = "SELECT t FROM TblFinanciamiento t")
    , @NamedQuery(name = "TblFinanciamiento.findByFinCod", query = "SELECT t FROM TblFinanciamiento t WHERE t.finCod = :finCod")
    , @NamedQuery(name = "TblFinanciamiento.findByFinAsignacion", query = "SELECT t FROM TblFinanciamiento t WHERE t.finAsignacion = :finAsignacion")
    , @NamedQuery(name = "TblFinanciamiento.findByFinIngresoventa", query = "SELECT t FROM TblFinanciamiento t WHERE t.finIngresoventa = :finIngresoventa")
    , @NamedQuery(name = "TblFinanciamiento.findByFinIngresoproducto", query = "SELECT t FROM TblFinanciamiento t WHERE t.finIngresoproducto = :finIngresoproducto")
    , @NamedQuery(name = "TblFinanciamiento.findByFinFondos", query = "SELECT t FROM TblFinanciamiento t WHERE t.finFondos = :finFondos")
    , @NamedQuery(name = "TblFinanciamiento.findByFinTotal", query = "SELECT t FROM TblFinanciamiento t WHERE t.finTotal = :finTotal")})
public class TblFinanciamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fin_cod", nullable = false)
    private Integer finCod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fin_asignacion", precision = 18, scale = 2)
    private BigDecimal finAsignacion;
    @Column(name = "fin_ingresoventa", precision = 18, scale = 2)
    private BigDecimal finIngresoventa;
    @Column(name = "fin_ingresoproducto", precision = 18, scale = 2)
    private BigDecimal finIngresoproducto;
    @Column(name = "fin_fondos", precision = 18, scale = 2)
    private BigDecimal finFondos;
    @Column(name = "fin_total", precision = 18, scale = 2)
    private BigDecimal finTotal;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod")
    @ManyToOne
    private TblInforme infCod;

    public TblFinanciamiento() {
    }

    public TblFinanciamiento(Integer finCod) {
        this.finCod = finCod;
    }

    public Integer getFinCod() {
        return finCod;
    }

    public void setFinCod(Integer finCod) {
        this.finCod = finCod;
    }

    public BigDecimal getFinAsignacion() {
        return finAsignacion;
    }

    public void setFinAsignacion(BigDecimal finAsignacion) {
        this.finAsignacion = finAsignacion;
    }

    public BigDecimal getFinIngresoventa() {
        return finIngresoventa;
    }

    public void setFinIngresoventa(BigDecimal finIngresoventa) {
        this.finIngresoventa = finIngresoventa;
    }

    public BigDecimal getFinIngresoproducto() {
        return finIngresoproducto;
    }

    public void setFinIngresoproducto(BigDecimal finIngresoproducto) {
        this.finIngresoproducto = finIngresoproducto;
    }

    public BigDecimal getFinFondos() {
        return finFondos;
    }

    public void setFinFondos(BigDecimal finFondos) {
        this.finFondos = finFondos;
    }

    public BigDecimal getFinTotal() {
        return finTotal;
    }

    public void setFinTotal(BigDecimal finTotal) {
        this.finTotal = finTotal;
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
        hash += (finCod != null ? finCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFinanciamiento)) {
            return false;
        }
        TblFinanciamiento other = (TblFinanciamiento) object;
        if ((this.finCod == null && other.finCod != null) || (this.finCod != null && !this.finCod.equals(other.finCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblFinanciamiento[ finCod=" + finCod + " ]";
    }
    
}
