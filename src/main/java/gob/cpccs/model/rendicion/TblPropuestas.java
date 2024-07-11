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
@Table(name = "tbl_propuestas", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPropuestas.findAll", query = "SELECT t FROM TblPropuestas t")
    , @NamedQuery(name = "TblPropuestas.findByProId", query = "SELECT t FROM TblPropuestas t WHERE t.proId = :proId")
    , @NamedQuery(name = "TblPropuestas.findByProDescripcion", query = "SELECT t FROM TblPropuestas t WHERE t.proDescripcion = :proDescripcion")
    , @NamedQuery(name = "TblPropuestas.findByProResultados", query = "SELECT t FROM TblPropuestas t WHERE t.proResultados = :proResultados")})
public class TblPropuestas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id", nullable = false)
    private Integer proId;
    @Column(name = "pro_descripcion", length = 2147483647)
    private String proDescripcion;
    @Column(name = "pro_resultados", length = 2147483647)
    private String proResultados;
    @JoinColumn(name = "inf_aut_cod", referencedColumnName = "inf_aut_cod")
    @ManyToOne
    private TblInformeAutoridad infAutCod;

    public TblPropuestas() {
    }

    public TblPropuestas(Integer proId) {
        this.proId = proId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProDescripcion() {
        return proDescripcion;
    }

    public void setProDescripcion(String proDescripcion) {
        this.proDescripcion = proDescripcion;
    }

    public String getProResultados() {
        return proResultados;
    }

    public void setProResultados(String proResultados) {
        this.proResultados = proResultados;
    }

    public TblInformeAutoridad getInfAutCod() {
        return infAutCod;
    }

    public void setInfAutCod(TblInformeAutoridad infAutCod) {
        this.infAutCod = infAutCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPropuestas)) {
            return false;
        }
        TblPropuestas other = (TblPropuestas) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblPropuestas[ proId=" + proId + " ]";
    }
    
}
