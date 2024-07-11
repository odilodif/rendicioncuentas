/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.rendicion;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringEscapeUtils;

import gob.cpccs.utilidades.Constantes;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_observaciones_negar", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblObservacionesNegar.findAll", query = "SELECT t FROM TblObservacionesNegar t")
    , @NamedQuery(name = "TblObservacionesNegar.findByObsCod", query = "SELECT t FROM TblObservacionesNegar t WHERE t.obsCod = :obsCod")
    , @NamedQuery(name = "TblObservacionesNegar.findByInstCod", query = "SELECT t FROM TblObservacionesNegar t WHERE t.instCod = :instCod")
    , @NamedQuery(name = "TblObservacionesNegar.findByObsComentario", query = "SELECT t FROM TblObservacionesNegar t WHERE t.obsComentario = :obsComentario")
    , @NamedQuery(name = "TblObservacionesNegar.findByObsFecha", query = "SELECT t FROM TblObservacionesNegar t WHERE t.obsFecha = :obsFecha")
    , @NamedQuery(name = "TblObservacionesNegar.findByObsTipo", query = "SELECT t FROM TblObservacionesNegar t WHERE t.obsTipo = :obsTipo")})
public class TblObservacionesNegar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "obs_cod", nullable = false)
    private Integer obsCod;
    @Basic(optional = false)
    @Column(name = "inst_cod", nullable = false)
    private int instCod;
    @Column(name = "obs_comentario", length = 2147483647)
    private String obsComentario;
    @Column(name = "obs_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date obsFecha;
    @Column(name = "obs_tipo", length = 25)
    private String obsTipo;
    @Column(name = "tecnicoidentificador", length = 15)
    private String tecnicoidentificador;
    
    public String getTecnicoidentificador() {
		return tecnicoidentificador;
	}

	public void setTecnicoidentificador(String tecnicoidentificador) {
		this.tecnicoidentificador = tecnicoidentificador;
	}

	public TblObservacionesNegar() {
    }

    public TblObservacionesNegar(Integer obsCod) {
        this.obsCod = obsCod;
    }

    public TblObservacionesNegar(Integer obsCod, int instCod) {
        this.obsCod = obsCod;
        this.instCod = instCod;
    }

    public Integer getObsCod() {
        return obsCod;
    }

    public void setObsCod(Integer obsCod) {
        this.obsCod = obsCod;
    }

    public int getInstCod() {
        return instCod;
    }

    public void setInstCod(int instCod) {
        this.instCod = instCod;
    }

    public String getObsComentario() {
        return obsComentario;
    }

    public void setObsComentario(String obsComentario) {
        this.obsComentario = obsComentario;
    }

    public Date getObsFecha() {
        return obsFecha;
    }

    public void setObsFecha(Date obsFecha) {
        this.obsFecha = obsFecha;
    }

    public String getObsTipo() {
        return obsTipo;
    }

    public void setObsTipo(String obsTipo) {
        this.obsTipo = obsTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (obsCod != null ? obsCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblObservacionesNegar)) {
            return false;
        }
        TblObservacionesNegar other = (TblObservacionesNegar) object;
        if ((this.obsCod == null && other.obsCod != null) || (this.obsCod != null && !this.obsCod.equals(other.obsCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblObservacionesNegar[ obsCod=" + obsCod + " ]";
    }
    
}
