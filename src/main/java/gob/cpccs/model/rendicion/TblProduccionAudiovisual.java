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
@Table(name = "tbl_produccion_audiovisual", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProduccionAudiovisual.findAll", query = "SELECT t FROM TblProduccionAudiovisual t")
    , @NamedQuery(name = "TblProduccionAudiovisual.findByPaCod", query = "SELECT t FROM TblProduccionAudiovisual t WHERE t.paCod = :paCod")
    , @NamedQuery(name = "TblProduccionAudiovisual.findByPaTipo", query = "SELECT t FROM TblProduccionAudiovisual t WHERE t.paTipo = :paTipo")
    , @NamedQuery(name = "TblProduccionAudiovisual.findByPaContenido", query = "SELECT t FROM TblProduccionAudiovisual t WHERE t.paContenido = :paContenido")
    , @NamedQuery(name = "TblProduccionAudiovisual.findByPaPorcentaje", query = "SELECT t FROM TblProduccionAudiovisual t WHERE t.paPorcentaje = :paPorcentaje")
    , @NamedQuery(name = "TblProduccionAudiovisual.findByPaPeriocidad", query = "SELECT t FROM TblProduccionAudiovisual t WHERE t.paPeriocidad = :paPeriocidad")
    , @NamedQuery(name = "TblProduccionAudiovisual.findByPaMedio", query = "SELECT t FROM TblProduccionAudiovisual t WHERE t.paMedio = :paMedio")
    , @NamedQuery(name = "TblProduccionAudiovisual.findByPaPorcProduccion", query = "SELECT t FROM TblProduccionAudiovisual t WHERE t.paPorcProduccion = :paPorcProduccion")
    , @NamedQuery(name = "TblProduccionAudiovisual.findByPaNomPrograma", query = "SELECT t FROM TblProduccionAudiovisual t WHERE t.paNomPrograma = :paNomPrograma")})
public class TblProduccionAudiovisual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pa_cod", nullable = false)
    private Integer paCod;
    @Column(name = "pa_tipo", length = 100)
    private String paTipo;
    @Column(name = "pa_contenido", length = 8000)
    private String paContenido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pa_porcentaje", precision = 18, scale = 2)
    private BigDecimal paPorcentaje;
    @Column(name = "pa_periocidad", length = 1000)
    private String paPeriocidad;
    @Column(name = "pa_medio", length = 5000)
    private String paMedio;
    @Column(name = "pa_porc_produccion", precision = 5, scale = 2)
    private BigDecimal paPorcProduccion;
    @Column(name = "pa_nom_programa", length = 500)
    private String paNomPrograma;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod")
    @ManyToOne
    private TblInforme infCod;

    public TblProduccionAudiovisual() {
    }

    public TblProduccionAudiovisual(Integer paCod) {
        this.paCod = paCod;
    }

    public Integer getPaCod() {
        return paCod;
    }

    public void setPaCod(Integer paCod) {
        this.paCod = paCod;
    }

    public String getPaTipo() {
        return paTipo;
    }

    public void setPaTipo(String paTipo) {
        this.paTipo = paTipo;
    }

    public String getPaContenido() {
        return paContenido;
    }

    public void setPaContenido(String paContenido) {
        this.paContenido = paContenido;
    }

    public BigDecimal getPaPorcentaje() {
        return paPorcentaje;
    }

    public void setPaPorcentaje(BigDecimal paPorcentaje) {
        this.paPorcentaje = paPorcentaje;
    }

    public String getPaPeriocidad() {
        return paPeriocidad;
    }

    public void setPaPeriocidad(String paPeriocidad) {
        this.paPeriocidad = paPeriocidad;
    }

    public String getPaMedio() {
        return paMedio;
    }

    public void setPaMedio(String paMedio) {
        this.paMedio = paMedio;
    }

    public BigDecimal getPaPorcProduccion() {
        return paPorcProduccion;
    }

    public void setPaPorcProduccion(BigDecimal paPorcProduccion) {
        this.paPorcProduccion = paPorcProduccion;
    }

    public String getPaNomPrograma() {
        return paNomPrograma;
    }

    public void setPaNomPrograma(String paNomPrograma) {
        this.paNomPrograma = paNomPrograma;
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
        hash += (paCod != null ? paCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProduccionAudiovisual)) {
            return false;
        }
        TblProduccionAudiovisual other = (TblProduccionAudiovisual) object;
        if ((this.paCod == null && other.paCod != null) || (this.paCod != null && !this.paCod.equals(other.paCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblProduccionAudiovisual[ paCod=" + paCod + " ]";
    }
    
}
