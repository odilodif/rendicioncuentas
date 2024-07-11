/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.rendicion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tbl_ejecucion_programatica", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEjecucionProgramatica.findAll", query = "SELECT t FROM TblEjecucionProgramatica t")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByEprCod", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.eprCod = :eprCod")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByFoCod", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.foCod = :foCod")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByInfCod", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.infCod = :infCod")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByEprNumero", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.eprNumero = :eprNumero")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByEprMeta", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.eprMeta = :eprMeta")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByEprIndicador", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.eprIndicador = :eprIndicador")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByEprPresultadopl", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.eprPresultadopl = :eprPresultadopl")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByEprPresultadocm", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.eprPresultadocm = :eprPresultadocm")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByEprPcumple", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.eprPcumple = :eprPcumple")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByEprGestion", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.eprGestion = :eprGestion")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByEprTotal", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.eprTotal = :eprTotal")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByEprSuma", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.eprSuma = :eprSuma")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByEprDescObjetivos", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.eprDescObjetivos = :eprDescObjetivos")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByEprTipoCompetencia", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.eprTipoCompetencia = :eprTipoCompetencia")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByEprCompetenciaConcurr", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.eprCompetenciaConcurr = :eprCompetenciaConcurr")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByEprAporteResult", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.eprAporteResult = :eprAporteResult")
    , @NamedQuery(name = "TblEjecucionProgramatica.findByObjCod", query = "SELECT t FROM TblEjecucionProgramatica t WHERE t.objCod = :objCod")})
public class TblEjecucionProgramatica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "epr_cod", nullable = false)
    private Integer eprCod;
    @Column(name = "fo_cod")
    private Integer foCod;
    @Basic(optional = false)
    @Column(name = "inf_cod", nullable = false)
    private int infCod;
    @Column(name = "epr_numero")
    private BigInteger eprNumero;
    @Column(name = "epr_meta", length = 2147483647)
    private String eprMeta;
    @Column(name = "epr_indicador", length = 2147483647)
    private String eprIndicador;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "epr_presultadopl", precision = 18, scale = 2)
    private BigDecimal eprPresultadopl;
    @Column(name = "epr_presultadocm", precision = 18, scale = 2)
    private BigDecimal eprPresultadocm;
    @Column(name = "epr_pcumple", precision = 18, scale = 2)
    private BigDecimal eprPcumple;
    @Column(name = "epr_gestion", length = 2147483647)
    private String eprGestion;
    @Column(name = "epr_total", precision = 18, scale = 2)
    private BigDecimal eprTotal;
    @Column(name = "epr_suma", precision = 18, scale = 2)
    private BigDecimal eprSuma;
    @Column(name = "epr_desc_objetivos", length = 2147483647)
    private String eprDescObjetivos;
    @Column(name = "epr_tipo_competencia", length = 2147483647)
    private String eprTipoCompetencia;
    @Column(name = "epr_competencia_concurr", length = 2147483647)
    private String eprCompetenciaConcurr;
    @Column(name = "epr_aporte_result", length = 2147483647)
    private String eprAporteResult;
    @Column(name = "obj_cod")
    private Integer objCod;
    @Column(name = "epr_estado", length = 15)
    private String eprEstado;
    

    public TblEjecucionProgramatica() {
    }

    public TblEjecucionProgramatica(Integer eprCod) {
        this.eprCod = eprCod;
    }

    public TblEjecucionProgramatica(Integer eprCod, int infCod) {
        this.eprCod = eprCod;
        this.infCod = infCod;
    }

    public Integer getEprCod() {
        return eprCod;
    }

    public void setEprCod(Integer eprCod) {
        this.eprCod = eprCod;
    }

    public Integer getFoCod() {
        return foCod;
    }

    public void setFoCod(Integer foCod) {
        this.foCod = foCod;
    }

    public int getInfCod() {
        return infCod;
    }

    public void setInfCod(int infCod) {
        this.infCod = infCod;
    }

    public BigInteger getEprNumero() {
        return eprNumero;
    }

    public void setEprNumero(BigInteger eprNumero) {
        this.eprNumero = eprNumero;
    }

    public String getEprMeta() {
        return eprMeta;
    }

    public void setEprMeta(String eprMeta) {
        this.eprMeta = eprMeta;
    }

    public String getEprIndicador() {
        return eprIndicador;
    }

    public void setEprIndicador(String eprIndicador) {
        this.eprIndicador = eprIndicador;
    }

    public BigDecimal getEprPresultadopl() {
        return eprPresultadopl;
    }

    public void setEprPresultadopl(BigDecimal eprPresultadopl) {
        this.eprPresultadopl = eprPresultadopl;
    }

    public BigDecimal getEprPresultadocm() {
        return eprPresultadocm;
    }

    public void setEprPresultadocm(BigDecimal eprPresultadocm) {
        this.eprPresultadocm = eprPresultadocm;
    }

    public BigDecimal getEprPcumple() {
        return eprPcumple;
    }

    public void setEprPcumple(BigDecimal eprPcumple) {
        this.eprPcumple = eprPcumple;
    }

    public String getEprGestion() {
        return eprGestion;
    }

    public void setEprGestion(String eprGestion) {
        this.eprGestion = eprGestion;
    }

    public BigDecimal getEprTotal() {
        return eprTotal;
    }

    public void setEprTotal(BigDecimal eprTotal) {
        this.eprTotal = eprTotal;
    }

    public BigDecimal getEprSuma() {
        return eprSuma;
    }

    public void setEprSuma(BigDecimal eprSuma) {
        this.eprSuma = eprSuma;
    }

    public String getEprDescObjetivos() {
        return eprDescObjetivos;
    }

    public void setEprDescObjetivos(String eprDescObjetivos) {
        this.eprDescObjetivos = eprDescObjetivos;
    }

    public String getEprTipoCompetencia() {
        return eprTipoCompetencia;
    }

    public void setEprTipoCompetencia(String eprTipoCompetencia) {
        this.eprTipoCompetencia = eprTipoCompetencia;
    }

    public String getEprCompetenciaConcurr() {
        return eprCompetenciaConcurr;
    }

    public void setEprCompetenciaConcurr(String eprCompetenciaConcurr) {
        this.eprCompetenciaConcurr = eprCompetenciaConcurr;
    }

    public String getEprAporteResult() {
        return eprAporteResult;
    }

    public void setEprAporteResult(String eprAporteResult) {
        this.eprAporteResult = eprAporteResult;
    }

    public Integer getObjCod() {
        return objCod;
    }

    public void setObjCod(Integer objCod) {
        this.objCod = objCod;
    }

    public String getEprEstado() {
        return eprEstado;
    }

    public void setEprEstado(String eprEstado) {
        this.eprEstado = eprEstado;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eprCod != null ? eprCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEjecucionProgramatica)) {
            return false;
        }
        TblEjecucionProgramatica other = (TblEjecucionProgramatica) object;
        if ((this.eprCod == null && other.eprCod != null) || (this.eprCod != null && !this.eprCod.equals(other.eprCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblEjecucionProgramatica[ eprCod=" + eprCod + " ]";
    }
    
}
