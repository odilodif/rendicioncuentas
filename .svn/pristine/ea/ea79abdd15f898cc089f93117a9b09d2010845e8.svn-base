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
@Table(name = "tbl_obras_anteriores", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblObrasAnteriores.findAll", query = "SELECT t FROM TblObrasAnteriores t")
    , @NamedQuery(name = "TblObrasAnteriores.findByObaCod", query = "SELECT t FROM TblObrasAnteriores t WHERE t.obaCod = :obaCod")
    , @NamedQuery(name = "TblObrasAnteriores.findByObaObra", query = "SELECT t FROM TblObrasAnteriores t WHERE t.obaObra = :obaObra")
    , @NamedQuery(name = "TblObrasAnteriores.findByObaValor", query = "SELECT t FROM TblObrasAnteriores t WHERE t.obaValor = :obaValor")
    , @NamedQuery(name = "TblObrasAnteriores.findByObaContinua", query = "SELECT t FROM TblObrasAnteriores t WHERE t.obaContinua = :obaContinua")
    , @NamedQuery(name = "TblObrasAnteriores.findByObaMotivo", query = "SELECT t FROM TblObrasAnteriores t WHERE t.obaMotivo = :obaMotivo")
    , @NamedQuery(name = "TblObrasAnteriores.findByObaObs", query = "SELECT t FROM TblObrasAnteriores t WHERE t.obaObs = :obaObs")
    , @NamedQuery(name = "TblObrasAnteriores.findByObaEstado", query = "SELECT t FROM TblObrasAnteriores t WHERE t.obaEstado = :obaEstado")
    , @NamedQuery(name = "TblObrasAnteriores.findByObaLink", query = "SELECT t FROM TblObrasAnteriores t WHERE t.obaLink = :obaLink")})
public class TblObrasAnteriores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oba_cod", nullable = false)
    private Integer obaCod;
    @Column(name = "oba_obra", length = 2147483647)
    private String obaObra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "oba_valor", precision = 18, scale = 2)
    private BigDecimal obaValor;
    @Column(name = "oba_continua", length = 500)
    private String obaContinua;
    @Column(name = "oba_motivo", length = 500)
    private String obaMotivo;
    @Column(name = "oba_obs", length = 500)
    private String obaObs;
    @Column(name = "oba_estado", length = 500)
    private String obaEstado;
    @Column(name = "oba_link", length = 500)
    private String obaLink;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblObrasAnteriores() {
    }

    public TblObrasAnteriores(Integer obaCod) {
        this.obaCod = obaCod;
    }

    public Integer getObaCod() {
        return obaCod;
    }

    public void setObaCod(Integer obaCod) {
        this.obaCod = obaCod;
    }

    public String getObaObra() {
        return obaObra;
    }

    public void setObaObra(String obaObra) {
        this.obaObra = obaObra;
    }

    public BigDecimal getObaValor() {
        return obaValor;
    }

    public void setObaValor(BigDecimal obaValor) {
        this.obaValor = obaValor;
    }

    public String getObaContinua() {
        return obaContinua;
    }

    public void setObaContinua(String obaContinua) {
        this.obaContinua = obaContinua;
    }

    public String getObaMotivo() {
        return obaMotivo;
    }

    public void setObaMotivo(String obaMotivo) {
        this.obaMotivo = obaMotivo;
    }

    public String getObaObs() {
        return obaObs;
    }

    public void setObaObs(String obaObs) {
        this.obaObs = obaObs;
    }

    public String getObaEstado() {
        return obaEstado;
    }

    public void setObaEstado(String obaEstado) {
        this.obaEstado = obaEstado;
    }

    public String getObaLink() {
        return obaLink;
    }

    public void setObaLink(String obaLink) {
        this.obaLink = obaLink;
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
        hash += (obaCod != null ? obaCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblObrasAnteriores)) {
            return false;
        }
        TblObrasAnteriores other = (TblObrasAnteriores) object;
        if ((this.obaCod == null && other.obaCod != null) || (this.obaCod != null && !this.obaCod.equals(other.obaCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblObrasAnteriores[ obaCod=" + obaCod + " ]";
    }
    
}
