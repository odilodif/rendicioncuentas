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
@Table(name = "tbl_reclamos_medios", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblReclamosMedios.findAll", query = "SELECT t FROM TblReclamosMedios t")
    , @NamedQuery(name = "TblReclamosMedios.findByRmCod", query = "SELECT t FROM TblReclamosMedios t WHERE t.rmCod = :rmCod")
    , @NamedQuery(name = "TblReclamosMedios.findByRmPresentado", query = "SELECT t FROM TblReclamosMedios t WHERE t.rmPresentado = :rmPresentado")
    , @NamedQuery(name = "TblReclamosMedios.findByRmNreclamos", query = "SELECT t FROM TblReclamosMedios t WHERE t.rmNreclamos = :rmNreclamos")
    , @NamedQuery(name = "TblReclamosMedios.findByRmNproceso", query = "SELECT t FROM TblReclamosMedios t WHERE t.rmNproceso = :rmNproceso")
    , @NamedQuery(name = "TblReclamosMedios.findByRmLink", query = "SELECT t FROM TblReclamosMedios t WHERE t.rmLink = :rmLink")
    , @NamedQuery(name = "TblReclamosMedios.findByRmNreclamofavorable", query = "SELECT t FROM TblReclamosMedios t WHERE t.rmNreclamofavorable = :rmNreclamofavorable")
    , @NamedQuery(name = "TblReclamosMedios.findByRmNreclamodesfavorable", query = "SELECT t FROM TblReclamosMedios t WHERE t.rmNreclamodesfavorable = :rmNreclamodesfavorable")
    , @NamedQuery(name = "TblReclamosMedios.findByRmTipoReclamo", query = "SELECT t FROM TblReclamosMedios t WHERE t.rmTipoReclamo = :rmTipoReclamo")})
public class TblReclamosMedios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rm_cod", nullable = false)
    private Integer rmCod;
    @Column(name = "rm_presentado", length = 100)
    private String rmPresentado;
    @Column(name = "rm_nreclamos")
    private Integer rmNreclamos;
    @Column(name = "rm_nproceso")
    private Integer rmNproceso;
    @Column(name = "rm_link", length = 200)
    private String rmLink;
    @Column(name = "rm_nreclamofavorable")
    private Integer rmNreclamofavorable;
    @Column(name = "rm_nreclamodesfavorable")
    private Integer rmNreclamodesfavorable;
    @Column(name = "rm_tipo_reclamo", length = 50)
    private String rmTipoReclamo;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod")
    @ManyToOne
    private TblInforme infCod;

    public TblReclamosMedios() {
    }

    public TblReclamosMedios(Integer rmCod) {
        this.rmCod = rmCod;
    }

    public Integer getRmCod() {
        return rmCod;
    }

    public void setRmCod(Integer rmCod) {
        this.rmCod = rmCod;
    }

    public String getRmPresentado() {
        return rmPresentado;
    }

    public void setRmPresentado(String rmPresentado) {
        this.rmPresentado = rmPresentado;
    }

    public Integer getRmNreclamos() {
        return rmNreclamos;
    }

    public void setRmNreclamos(Integer rmNreclamos) {
        this.rmNreclamos = rmNreclamos;
    }

    public Integer getRmNproceso() {
        return rmNproceso;
    }

    public void setRmNproceso(Integer rmNproceso) {
        this.rmNproceso = rmNproceso;
    }

    public String getRmLink() {
        return rmLink;
    }

    public void setRmLink(String rmLink) {
        this.rmLink = rmLink;
    }

    public Integer getRmNreclamofavorable() {
        return rmNreclamofavorable;
    }

    public void setRmNreclamofavorable(Integer rmNreclamofavorable) {
        this.rmNreclamofavorable = rmNreclamofavorable;
    }

    public Integer getRmNreclamodesfavorable() {
        return rmNreclamodesfavorable;
    }

    public void setRmNreclamodesfavorable(Integer rmNreclamodesfavorable) {
        this.rmNreclamodesfavorable = rmNreclamodesfavorable;
    }

    public String getRmTipoReclamo() {
        return rmTipoReclamo;
    }

    public void setRmTipoReclamo(String rmTipoReclamo) {
        this.rmTipoReclamo = rmTipoReclamo;
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
        hash += (rmCod != null ? rmCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblReclamosMedios)) {
            return false;
        }
        TblReclamosMedios other = (TblReclamosMedios) object;
        if ((this.rmCod == null && other.rmCod != null) || (this.rmCod != null && !this.rmCod.equals(other.rmCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblReclamosMedios[ rmCod=" + rmCod + " ]";
    }
    
}
