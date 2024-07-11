/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.rendicion;

import java.io.Serializable;
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
@Table(name = "tbl_mecanismo_rendicion_cuentas", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMecanismoRendicionCuentas.findAll", query = "SELECT t FROM TblMecanismoRendicionCuentas t")
    , @NamedQuery(name = "TblMecanismoRendicionCuentas.findByMecanismoCod", query = "SELECT t FROM TblMecanismoRendicionCuentas t WHERE t.mecanismoCod = :mecanismoCod")
    , @NamedQuery(name = "TblMecanismoRendicionCuentas.findByMecanismoFase", query = "SELECT t FROM TblMecanismoRendicionCuentas t WHERE t.mecanismoFase = :mecanismoFase")
    , @NamedQuery(name = "TblMecanismoRendicionCuentas.findByMecanismoNombre", query = "SELECT t FROM TblMecanismoRendicionCuentas t WHERE t.mecanismoNombre = :mecanismoNombre")
    , @NamedQuery(name = "TblMecanismoRendicionCuentas.findByMecanismoImplementado", query = "SELECT t FROM TblMecanismoRendicionCuentas t WHERE t.mecanismoImplementado = :mecanismoImplementado")
    , @NamedQuery(name = "TblMecanismoRendicionCuentas.findByMecanismoEjecucion", query = "SELECT t FROM TblMecanismoRendicionCuentas t WHERE t.mecanismoEjecucion = :mecanismoEjecucion")
    , @NamedQuery(name = "TblMecanismoRendicionCuentas.findByMecanismoMedioverifica", query = "SELECT t FROM TblMecanismoRendicionCuentas t WHERE t.mecanismoMedioverifica = :mecanismoMedioverifica")
    , @NamedQuery(name = "TblMecanismoRendicionCuentas.findByMecanismoTipo", query = "SELECT t FROM TblMecanismoRendicionCuentas t WHERE t.mecanismoTipo = :mecanismoTipo")
    , @NamedQuery(name = "TblMecanismoRendicionCuentas.findByMecanismoEstado", query = "SELECT t FROM TblMecanismoRendicionCuentas t WHERE t.mecanismoEstado = :mecanismoEstado")
    , @NamedQuery(name = "TblMecanismoRendicionCuentas.findByMecanismoObservacion", query = "SELECT t FROM TblMecanismoRendicionCuentas t WHERE t.mecanismoObservacion = :mecanismoObservacion")})
public class TblMecanismoRendicionCuentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mecanismo_cod", nullable = false)
    private Integer mecanismoCod;
    @Column(name = "mecanismo_fase", length = 200)
    private String mecanismoFase;
    @Column(name = "mecanismo_nombre", length = 2147483647)
    private String mecanismoNombre;
    @Column(name = "mecanismo_implementado", length = 2)
    private String mecanismoImplementado;
    @Column(name = "mecanismo_ejecucion", length = 2147483647)
    private String mecanismoEjecucion;
    @Column(name = "mecanismo_medioverifica", length = 2147483647)
    private String mecanismoMedioverifica;
    @Column(name = "mecanismo_tipo", length = 200)
    private String mecanismoTipo;
    @Column(name = "mecanismo_estado", length = 200)
    private String mecanismoEstado;
    @Column(name = "mecanismo_observacion", length = 2147483647)
    private String mecanismoObservacion;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblMecanismoRendicionCuentas() {
    }

    public TblMecanismoRendicionCuentas(Integer mecanismoCod) {
        this.mecanismoCod = mecanismoCod;
    }

    public Integer getMecanismoCod() {
        return mecanismoCod;
    }

    public void setMecanismoCod(Integer mecanismoCod) {
        this.mecanismoCod = mecanismoCod;
    }

    public String getMecanismoFase() {
        return mecanismoFase;
    }

    public void setMecanismoFase(String mecanismoFase) {
        this.mecanismoFase = mecanismoFase;
    }

    public String getMecanismoNombre() {
        return mecanismoNombre;
    }

    public void setMecanismoNombre(String mecanismoNombre) {
        this.mecanismoNombre = mecanismoNombre;
    }

    public String getMecanismoImplementado() {
        return mecanismoImplementado;
    }

    public void setMecanismoImplementado(String mecanismoImplementado) {
        this.mecanismoImplementado = mecanismoImplementado;
    }

    public String getMecanismoEjecucion() {
        return mecanismoEjecucion;
    }

    public void setMecanismoEjecucion(String mecanismoEjecucion) {
        this.mecanismoEjecucion = mecanismoEjecucion;
    }

    public String getMecanismoMedioverifica() {
        return mecanismoMedioverifica;
    }

    public void setMecanismoMedioverifica(String mecanismoMedioverifica) {
        this.mecanismoMedioverifica = mecanismoMedioverifica;
    }

    public String getMecanismoTipo() {
        return mecanismoTipo;
    }

    public void setMecanismoTipo(String mecanismoTipo) {
        this.mecanismoTipo = mecanismoTipo;
    }

    public String getMecanismoEstado() {
        return mecanismoEstado;
    }

    public void setMecanismoEstado(String mecanismoEstado) {
        this.mecanismoEstado = mecanismoEstado;
    }

    public String getMecanismoObservacion() {
        return mecanismoObservacion;
    }

    public void setMecanismoObservacion(String mecanismoObservacion) {
        this.mecanismoObservacion = mecanismoObservacion;
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
        hash += (mecanismoCod != null ? mecanismoCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMecanismoRendicionCuentas)) {
            return false;
        }
        TblMecanismoRendicionCuentas other = (TblMecanismoRendicionCuentas) object;
        if ((this.mecanismoCod == null && other.mecanismoCod != null) || (this.mecanismoCod != null && !this.mecanismoCod.equals(other.mecanismoCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblMecanismoRendicionCuentas[ mecanismoCod=" + mecanismoCod + " ]";
    }
    
}
