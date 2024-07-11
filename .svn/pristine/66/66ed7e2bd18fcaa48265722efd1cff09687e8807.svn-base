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
@Table(name = "tbl_informacion_financiera", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblInformacionFinanciera.findAll", query = "SELECT t FROM TblInformacionFinanciera t")
    , @NamedQuery(name = "TblInformacionFinanciera.findByCodFinan", query = "SELECT t FROM TblInformacionFinanciera t WHERE t.codFinan = :codFinan")
    , @NamedQuery(name = "TblInformacionFinanciera.findByInfActivos", query = "SELECT t FROM TblInformacionFinanciera t WHERE t.infActivos = :infActivos")
    , @NamedQuery(name = "TblInformacionFinanciera.findByInfPasivos", query = "SELECT t FROM TblInformacionFinanciera t WHERE t.infPasivos = :infPasivos")
    , @NamedQuery(name = "TblInformacionFinanciera.findByInfPatrimonio", query = "SELECT t FROM TblInformacionFinanciera t WHERE t.infPatrimonio = :infPatrimonio")
    , @NamedQuery(name = "TblInformacionFinanciera.findByInfLinkbalance", query = "SELECT t FROM TblInformacionFinanciera t WHERE t.infLinkbalance = :infLinkbalance")})
public class TblInformacionFinanciera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_finan", nullable = false)
    private Integer codFinan;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inf_activos", precision = 18, scale = 2)
    private BigDecimal infActivos;
    @Column(name = "inf_pasivos", precision = 18, scale = 2)
    private BigDecimal infPasivos;
    @Column(name = "inf_patrimonio", precision = 18, scale = 2)
    private BigDecimal infPatrimonio;
    @Column(name = "inf_linkbalance", length = 200)
    private String infLinkbalance;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod")
    @ManyToOne
    private TblInforme infCod;

    public TblInformacionFinanciera() {
    }

    public TblInformacionFinanciera(Integer codFinan) {
        this.codFinan = codFinan;
    }

    public Integer getCodFinan() {
        return codFinan;
    }

    public void setCodFinan(Integer codFinan) {
        this.codFinan = codFinan;
    }

    public BigDecimal getInfActivos() {
        return infActivos;
    }

    public void setInfActivos(BigDecimal infActivos) {
        this.infActivos = infActivos;
    }

    public BigDecimal getInfPasivos() {
        return infPasivos;
    }

    public void setInfPasivos(BigDecimal infPasivos) {
        this.infPasivos = infPasivos;
    }

    public BigDecimal getInfPatrimonio() {
        return infPatrimonio;
    }

    public void setInfPatrimonio(BigDecimal infPatrimonio) {
        this.infPatrimonio = infPatrimonio;
    }

    public String getInfLinkbalance() {
        return infLinkbalance;
    }

    public void setInfLinkbalance(String infLinkbalance) {
        this.infLinkbalance = infLinkbalance;
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
        hash += (codFinan != null ? codFinan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblInformacionFinanciera)) {
            return false;
        }
        TblInformacionFinanciera other = (TblInformacionFinanciera) object;
        if ((this.codFinan == null && other.codFinan != null) || (this.codFinan != null && !this.codFinan.equals(other.codFinan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblInformacionFinanciera[ codFinan=" + codFinan + " ]";
    }
    
}
