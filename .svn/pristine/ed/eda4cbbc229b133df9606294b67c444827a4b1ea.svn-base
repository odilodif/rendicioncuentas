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
@Table(name = "tbl_cumplimiento_medios", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCumplimientoMedios.findAll", query = "SELECT t FROM TblCumplimientoMedios t")
    , @NamedQuery(name = "TblCumplimientoMedios.findByCmCod", query = "SELECT t FROM TblCumplimientoMedios t WHERE t.cmCod = :cmCod")
    , @NamedQuery(name = "TblCumplimientoMedios.findByCmValidaProyecto", query = "SELECT t FROM TblCumplimientoMedios t WHERE t.cmValidaProyecto = :cmValidaProyecto")
    , @NamedQuery(name = "TblCumplimientoMedios.findByCmDescParametro", query = "SELECT t FROM TblCumplimientoMedios t WHERE t.cmDescParametro = :cmDescParametro")
    , @NamedQuery(name = "TblCumplimientoMedios.findByCmOpciones", query = "SELECT t FROM TblCumplimientoMedios t WHERE t.cmOpciones = :cmOpciones")
    , @NamedQuery(name = "TblCumplimientoMedios.findByCmNomPrograma", query = "SELECT t FROM TblCumplimientoMedios t WHERE t.cmNomPrograma = :cmNomPrograma")
    , @NamedQuery(name = "TblCumplimientoMedios.findByCmFrecuencia", query = "SELECT t FROM TblCumplimientoMedios t WHERE t.cmFrecuencia = :cmFrecuencia")
    , @NamedQuery(name = "TblCumplimientoMedios.findByCmDescProgramacion", query = "SELECT t FROM TblCumplimientoMedios t WHERE t.cmDescProgramacion = :cmDescProgramacion")
    , @NamedQuery(name = "TblCumplimientoMedios.findByCmPorcDifusion", query = "SELECT t FROM TblCumplimientoMedios t WHERE t.cmPorcDifusion = :cmPorcDifusion")
    , @NamedQuery(name = "TblCumplimientoMedios.findByCmLink", query = "SELECT t FROM TblCumplimientoMedios t WHERE t.cmLink = :cmLink")
    , @NamedQuery(name = "TblCumplimientoMedios.findByCmTipo", query = "SELECT t FROM TblCumplimientoMedios t WHERE t.cmTipo = :cmTipo")})
public class TblCumplimientoMedios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cm_cod", nullable = false)
    private Integer cmCod;
    @Column(name = "cm_valida_proyecto", length = 2)
    private String cmValidaProyecto;
    @Column(name = "cm_desc_parametro", length = 5000)
    private String cmDescParametro;
    @Column(name = "cm_opciones", length = 100)
    private String cmOpciones;
    @Column(name = "cm_nom_programa", length = 500)
    private String cmNomPrograma;
    @Column(name = "cm_frecuencia", length = 50)
    private String cmFrecuencia;
    @Column(name = "cm_desc_programacion", length = 2147483647)
    private String cmDescProgramacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cm_porc_difusion", precision = 18, scale = 2)
    private BigDecimal cmPorcDifusion;
    @Column(name = "cm_link", length = 2147483647)
    private String cmLink;
    @Column(name = "cm_tipo", length = 50)
    private String cmTipo;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblCumplimientoMedios() {
    }

    public TblCumplimientoMedios(Integer cmCod) {
        this.cmCod = cmCod;
    }

    public Integer getCmCod() {
        return cmCod;
    }

    public void setCmCod(Integer cmCod) {
        this.cmCod = cmCod;
    }

    public String getCmValidaProyecto() {
        return cmValidaProyecto;
    }

    public void setCmValidaProyecto(String cmValidaProyecto) {
        this.cmValidaProyecto = cmValidaProyecto;
    }

    public String getCmDescParametro() {
        return cmDescParametro;
    }

    public void setCmDescParametro(String cmDescParametro) {
        this.cmDescParametro = cmDescParametro;
    }

    public String getCmOpciones() {
        return cmOpciones;
    }

    public void setCmOpciones(String cmOpciones) {
        this.cmOpciones = cmOpciones;
    }

    public String getCmNomPrograma() {
        return cmNomPrograma;
    }

    public void setCmNomPrograma(String cmNomPrograma) {
        this.cmNomPrograma = cmNomPrograma;
    }

    public String getCmFrecuencia() {
        return cmFrecuencia;
    }

    public void setCmFrecuencia(String cmFrecuencia) {
        this.cmFrecuencia = cmFrecuencia;
    }

    public String getCmDescProgramacion() {
        return cmDescProgramacion;
    }

    public void setCmDescProgramacion(String cmDescProgramacion) {
        this.cmDescProgramacion = cmDescProgramacion;
    }

    public BigDecimal getCmPorcDifusion() {
        return cmPorcDifusion;
    }

    public void setCmPorcDifusion(BigDecimal cmPorcDifusion) {
        this.cmPorcDifusion = cmPorcDifusion;
    }

    public String getCmLink() {
        return cmLink;
    }

    public void setCmLink(String cmLink) {
        this.cmLink = cmLink;
    }

    public String getCmTipo() {
        return cmTipo;
    }

    public void setCmTipo(String cmTipo) {
        this.cmTipo = cmTipo;
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
        hash += (cmCod != null ? cmCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCumplimientoMedios)) {
            return false;
        }
        TblCumplimientoMedios other = (TblCumplimientoMedios) object;
        if ((this.cmCod == null && other.cmCod != null) || (this.cmCod != null && !this.cmCod.equals(other.cmCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblCumplimientoMedios[ cmCod=" + cmCod + " ]";
    }
    
}
