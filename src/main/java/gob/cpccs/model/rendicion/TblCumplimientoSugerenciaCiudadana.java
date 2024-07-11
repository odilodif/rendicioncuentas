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
@Table(name = "tbl_cumplimiento_sugerencia_ciudadana", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCumplimientoSugerenciaCiudadana.findAll", query = "SELECT t FROM TblCumplimientoSugerenciaCiudadana t")
    , @NamedQuery(name = "TblCumplimientoSugerenciaCiudadana.findByCscCod", query = "SELECT t FROM TblCumplimientoSugerenciaCiudadana t WHERE t.cscCod = :cscCod")
    , @NamedQuery(name = "TblCumplimientoSugerenciaCiudadana.findByCscSugerencias", query = "SELECT t FROM TblCumplimientoSugerenciaCiudadana t WHERE t.cscSugerencias = :cscSugerencias")
    , @NamedQuery(name = "TblCumplimientoSugerenciaCiudadana.findByCscResultados", query = "SELECT t FROM TblCumplimientoSugerenciaCiudadana t WHERE t.cscResultados = :cscResultados")
    , @NamedQuery(name = "TblCumplimientoSugerenciaCiudadana.findByCscPorcAvance", query = "SELECT t FROM TblCumplimientoSugerenciaCiudadana t WHERE t.cscPorcAvance = :cscPorcAvance")
    , @NamedQuery(name = "TblCumplimientoSugerenciaCiudadana.findByCscLink", query = "SELECT t FROM TblCumplimientoSugerenciaCiudadana t WHERE t.cscLink = :cscLink")})
public class TblCumplimientoSugerenciaCiudadana implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "csc_cod", nullable = false)
    private Integer cscCod;
    @Column(name = "csc_sugerencias", length = 2147483647)
    private String cscSugerencias;
    @Column(name = "csc_resultados", length = 2147483647)
    private String cscResultados;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "csc_porc_avance", precision = 18, scale = 2)
    private BigDecimal cscPorcAvance;
    @Column(name = "csc_link", length = 2147483647)
    private String cscLink;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblCumplimientoSugerenciaCiudadana() {
    }

    public TblCumplimientoSugerenciaCiudadana(Integer cscCod) {
        this.cscCod = cscCod;
    }

    public Integer getCscCod() {
        return cscCod;
    }

    public void setCscCod(Integer cscCod) {
        this.cscCod = cscCod;
    }

    public String getCscSugerencias() {
        return cscSugerencias;
    }

    public void setCscSugerencias(String cscSugerencias) {
        this.cscSugerencias = cscSugerencias;
    }

    public String getCscResultados() {
        return cscResultados;
    }

    public void setCscResultados(String cscResultados) {
        this.cscResultados = cscResultados;
    }

    public BigDecimal getCscPorcAvance() {
        return cscPorcAvance;
    }

    public void setCscPorcAvance(BigDecimal cscPorcAvance) {
        this.cscPorcAvance = cscPorcAvance;
    }

    public String getCscLink() {
        return cscLink;
    }

    public void setCscLink(String cscLink) {
        this.cscLink = cscLink;
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
        hash += (cscCod != null ? cscCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCumplimientoSugerenciaCiudadana)) {
            return false;
        }
        TblCumplimientoSugerenciaCiudadana other = (TblCumplimientoSugerenciaCiudadana) object;
        if ((this.cscCod == null && other.cscCod != null) || (this.cscCod != null && !this.cscCod.equals(other.cscCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblCumplimientoSugerenciaCiudadana[ cscCod=" + cscCod + " ]";
    }
    
}
