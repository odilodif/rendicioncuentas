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
@Table(name = "tbl_planificacion_participativa", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPlanificacionParticipativa.findAll", query = "SELECT t FROM TblPlanificacionParticipativa t")
    , @NamedQuery(name = "TblPlanificacionParticipativa.findByPlaCod", query = "SELECT t FROM TblPlanificacionParticipativa t WHERE t.plaCod = :plaCod")
    , @NamedQuery(name = "TblPlanificacionParticipativa.findByPlaDescripcion", query = "SELECT t FROM TblPlanificacionParticipativa t WHERE t.plaDescripcion = :plaDescripcion")
    , @NamedQuery(name = "TblPlanificacionParticipativa.findByPlaCumple", query = "SELECT t FROM TblPlanificacionParticipativa t WHERE t.plaCumple = :plaCumple")
    , @NamedQuery(name = "TblPlanificacionParticipativa.findByPlaLink", query = "SELECT t FROM TblPlanificacionParticipativa t WHERE t.plaLink = :plaLink")})
public class TblPlanificacionParticipativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pla_cod", nullable = false)
    private Integer plaCod;
    @Column(name = "pla_descripcion", length = 2147483647)
    private String plaDescripcion;
    @Column(name = "pla_cumple", length = 2)
    private String plaCumple;
    @Column(name = "pla_link", length = 500)
    private String plaLink;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblPlanificacionParticipativa() {
    }

    public TblPlanificacionParticipativa(Integer plaCod) {
        this.plaCod = plaCod;
    }

    public Integer getPlaCod() {
        return plaCod;
    }

    public void setPlaCod(Integer plaCod) {
        this.plaCod = plaCod;
    }

    public String getPlaDescripcion() {
        return plaDescripcion;
    }

    public void setPlaDescripcion(String plaDescripcion) {
        this.plaDescripcion = plaDescripcion;
    }

    public String getPlaCumple() {
        return plaCumple;
    }

    public void setPlaCumple(String plaCumple) {
        this.plaCumple = plaCumple;
    }

    public String getPlaLink() {
        return plaLink;
    }

    public void setPlaLink(String plaLink) {
        this.plaLink = plaLink;
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
        hash += (plaCod != null ? plaCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPlanificacionParticipativa)) {
            return false;
        }
        TblPlanificacionParticipativa other = (TblPlanificacionParticipativa) object;
        if ((this.plaCod == null && other.plaCod != null) || (this.plaCod != null && !this.plaCod.equals(other.plaCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblPlanificacionParticipativa[ plaCod=" + plaCod + " ]";
    }
    
}
