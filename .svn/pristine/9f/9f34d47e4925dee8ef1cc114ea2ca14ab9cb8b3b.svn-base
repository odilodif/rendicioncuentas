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
@Table(name = "tbl_amecanismos_pc", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAmecanismosPc.findAll", query = "SELECT t FROM TblAmecanismosPc t")
    , @NamedQuery(name = "TblAmecanismosPc.findByAmeCod", query = "SELECT t FROM TblAmecanismosPc t WHERE t.ameCod = :ameCod")
    , @NamedQuery(name = "TblAmecanismosPc.findByAmeDesc", query = "SELECT t FROM TblAmecanismosPc t WHERE t.ameDesc = :ameDesc")
    , @NamedQuery(name = "TblAmecanismosPc.findByAmeMedio", query = "SELECT t FROM TblAmecanismosPc t WHERE t.ameMedio = :ameMedio")
    , @NamedQuery(name = "TblAmecanismosPc.findByAmeTipo", query = "SELECT t FROM TblAmecanismosPc t WHERE t.ameTipo = :ameTipo")})
public class TblAmecanismosPc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ame_cod", nullable = false)
    private Integer ameCod;
    @Basic(optional = false)
    @Column(name = "ame_desc", nullable = false, length = 4)
    private String ameDesc;
    @Basic(optional = false)
    @Column(name = "ame_medio", nullable = false, length = 2147483647)
    private String ameMedio;
    @Basic(optional = false)
    @Column(name = "ame_tipo", nullable = false, length = 50)
    private String ameTipo;
    @JoinColumn(name = "inf_aut_cod", referencedColumnName = "inf_aut_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInformeAutoridad infAutCod;

    public TblAmecanismosPc() {
    }

    public TblAmecanismosPc(Integer ameCod) {
        this.ameCod = ameCod;
    }

    public TblAmecanismosPc(Integer ameCod, String ameDesc, String ameMedio, String ameTipo) {
        this.ameCod = ameCod;
        this.ameDesc = ameDesc;
        this.ameMedio = ameMedio;
        this.ameTipo = ameTipo;
    }

    public Integer getAmeCod() {
        return ameCod;
    }

    public void setAmeCod(Integer ameCod) {
        this.ameCod = ameCod;
    }

    public String getAmeDesc() {
        return ameDesc;
    }

    public void setAmeDesc(String ameDesc) {
        this.ameDesc = ameDesc;
    }

    public String getAmeMedio() {
        return ameMedio;
    }

    public void setAmeMedio(String ameMedio) {
        this.ameMedio = ameMedio;
    }

    public String getAmeTipo() {
        return ameTipo;
    }

    public void setAmeTipo(String ameTipo) {
        this.ameTipo = ameTipo;
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
        hash += (ameCod != null ? ameCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAmecanismosPc)) {
            return false;
        }
        TblAmecanismosPc other = (TblAmecanismosPc) object;
        if ((this.ameCod == null && other.ameCod != null) || (this.ameCod != null && !this.ameCod.equals(other.ameCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblAmecanismosPc[ ameCod=" + ameCod + " ]";
    }
    
}
