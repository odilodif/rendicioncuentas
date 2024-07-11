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
@Table(name = "tbl_fase_presupuesto_participativo", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFasePresupuestoParticipativo.findAll", query = "SELECT t FROM TblFasePresupuestoParticipativo t")
    , @NamedQuery(name = "TblFasePresupuestoParticipativo.findByFaseCod", query = "SELECT t FROM TblFasePresupuestoParticipativo t WHERE t.faseCod = :faseCod")
    , @NamedQuery(name = "TblFasePresupuestoParticipativo.findByFaseNombre", query = "SELECT t FROM TblFasePresupuestoParticipativo t WHERE t.faseNombre = :faseNombre")
    , @NamedQuery(name = "TblFasePresupuestoParticipativo.findByFaseOpcion", query = "SELECT t FROM TblFasePresupuestoParticipativo t WHERE t.faseOpcion = :faseOpcion")
    , @NamedQuery(name = "TblFasePresupuestoParticipativo.findByFaseActor", query = "SELECT t FROM TblFasePresupuestoParticipativo t WHERE t.faseActor = :faseActor")
    , @NamedQuery(name = "TblFasePresupuestoParticipativo.findByFaseGrupo", query = "SELECT t FROM TblFasePresupuestoParticipativo t WHERE t.faseGrupo = :faseGrupo")
    , @NamedQuery(name = "TblFasePresupuestoParticipativo.findByFaseLink", query = "SELECT t FROM TblFasePresupuestoParticipativo t WHERE t.faseLink = :faseLink")})
public class TblFasePresupuestoParticipativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fase_cod", nullable = false)
    private Integer faseCod;
    @Column(name = "fase_nombre", length = 200)
    private String faseNombre;
    @Column(name = "fase_opcion", length = 2)
    private String faseOpcion;
    @Column(name = "fase_actor", length = 500)
    private String faseActor;
    @Column(name = "fase_grupo", length = 2147483647)
    private String faseGrupo;
    @Column(name = "fase_link", length = 2147483647)
    private String faseLink;
    @JoinColumn(name = "info_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infoCod;
   
    public TblFasePresupuestoParticipativo() {
    }

    public TblFasePresupuestoParticipativo(Integer faseCod) {
        this.faseCod = faseCod;
    }

    public Integer getFaseCod() {
        return faseCod;
    }

    public void setFaseCod(Integer faseCod) {
        this.faseCod = faseCod;
    }

    public String getFaseNombre() {
        return faseNombre;
    }

    public void setFaseNombre(String faseNombre) {
        this.faseNombre = faseNombre;
    }

    public String getFaseOpcion() {
        return faseOpcion;
    }

    public void setFaseOpcion(String faseOpcion) {
        this.faseOpcion = faseOpcion;
    }

    public String getFaseActor() {
        return faseActor;
    }

    public void setFaseActor(String faseActor) {
        this.faseActor = faseActor;
    }

    public String getFaseGrupo() {
        return faseGrupo;
    }

    public void setFaseGrupo(String faseGrupo) {
        this.faseGrupo = faseGrupo;
    }

    public String getFaseLink() {
        return faseLink;
    }

    public void setFaseLink(String faseLink) {
        this.faseLink = faseLink;
    }

    public TblInforme getInfoCod() {
        return infoCod;
    }

    public void setInfoCod(TblInforme infoCod) {
        this.infoCod = infoCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faseCod != null ? faseCod.hashCode() : 0);
        return hash;
    }

      
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFasePresupuestoParticipativo)) {
            return false;
        }
        TblFasePresupuestoParticipativo other = (TblFasePresupuestoParticipativo) object;
        if ((this.faseCod == null && other.faseCod != null) || (this.faseCod != null && !this.faseCod.equals(other.faseCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblFasePresupuestoParticipativo[ faseCod=" + faseCod + " ]";
    }
    
}
