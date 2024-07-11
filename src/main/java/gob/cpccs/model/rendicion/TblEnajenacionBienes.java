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
@Table(name = "tbl_enajenacion_bienes", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEnajenacionBienes.findAll", query = "SELECT t FROM TblEnajenacionBienes t")
    , @NamedQuery(name = "TblEnajenacionBienes.findByEnbCod", query = "SELECT t FROM TblEnajenacionBienes t WHERE t.enbCod = :enbCod")
    , @NamedQuery(name = "TblEnajenacionBienes.findByEnbTipo", query = "SELECT t FROM TblEnajenacionBienes t WHERE t.enbTipo = :enbTipo")
    , @NamedQuery(name = "TblEnajenacionBienes.findByEnbDescripcion", query = "SELECT t FROM TblEnajenacionBienes t WHERE t.enbDescripcion = :enbDescripcion")
    , @NamedQuery(name = "TblEnajenacionBienes.findByEnbValor", query = "SELECT t FROM TblEnajenacionBienes t WHERE t.enbValor = :enbValor")
    , @NamedQuery(name = "TblEnajenacionBienes.findByEnbLink", query = "SELECT t FROM TblEnajenacionBienes t WHERE t.enbLink = :enbLink")})
public class TblEnajenacionBienes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "enb_cod", nullable = false)
    private Integer enbCod;
    @Column(name = "enb_tipo", length = 100)
    private String enbTipo;
    @Column(name = "enb_descripcion", length = 2147483647)
    private String enbDescripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "enb_valor", precision = 18, scale = 2)
    private BigDecimal enbValor;
    @Column(name = "enb_link", length = 2147483647)
    private String enbLink;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod")
    @ManyToOne
    private TblInforme infCod;

    public TblEnajenacionBienes() {
    }

    public TblEnajenacionBienes(Integer enbCod) {
        this.enbCod = enbCod;
    }

    public Integer getEnbCod() {
        return enbCod;
    }

    public void setEnbCod(Integer enbCod) {
        this.enbCod = enbCod;
    }

    public String getEnbTipo() {
        return enbTipo;
    }

    public void setEnbTipo(String enbTipo) {
        this.enbTipo = enbTipo;
    }

    public String getEnbDescripcion() {
        return enbDescripcion;
    }

    public void setEnbDescripcion(String enbDescripcion) {
        this.enbDescripcion = enbDescripcion;
    }

    public BigDecimal getEnbValor() {
        return enbValor;
    }

    public void setEnbValor(BigDecimal enbValor) {
        this.enbValor = enbValor;
    }

    public String getEnbLink() {
        return enbLink;
    }

    public void setEnbLink(String enbLink) {
        this.enbLink = enbLink;
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
        hash += (enbCod != null ? enbCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEnajenacionBienes)) {
            return false;
        }
        TblEnajenacionBienes other = (TblEnajenacionBienes) object;
        if ((this.enbCod == null && other.enbCod != null) || (this.enbCod != null && !this.enbCod.equals(other.enbCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblEnajenacionBienes[ enbCod=" + enbCod + " ]";
    }
    
}
