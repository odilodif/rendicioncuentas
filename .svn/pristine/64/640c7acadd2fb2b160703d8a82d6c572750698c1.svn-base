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
@Table(name = "tbl_participacion_ciudadana", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblParticipacionCiudadana.findAll", query = "SELECT t FROM TblParticipacionCiudadana t")
    , @NamedQuery(name = "TblParticipacionCiudadana.findByPcCod", query = "SELECT t FROM TblParticipacionCiudadana t WHERE t.pcCod = :pcCod")
    , @NamedQuery(name = "TblParticipacionCiudadana.findByPcSistema", query = "SELECT t FROM TblParticipacionCiudadana t WHERE t.pcSistema = :pcSistema")
    , @NamedQuery(name = "TblParticipacionCiudadana.findByPcValida", query = "SELECT t FROM TblParticipacionCiudadana t WHERE t.pcValida = :pcValida")
    , @NamedQuery(name = "TblParticipacionCiudadana.findByPcLink", query = "SELECT t FROM TblParticipacionCiudadana t WHERE t.pcLink = :pcLink")
    , @NamedQuery(name = "TblParticipacionCiudadana.findByPcDescriba", query = "SELECT t FROM TblParticipacionCiudadana t WHERE t.pcDescriba = :pcDescriba")})
public class TblParticipacionCiudadana implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pc_cod", nullable = false)
    private Integer pcCod;
    @Column(name = "pc_sistema", length = 500)
    private String pcSistema;
    @Column(name = "pc_valida", length = 2)
    private String pcValida;
    @Column(name = "pc_link", length = 2147483647)
    private String pcLink;
    @Column(name = "pc_describa", length = 2147483647)
    private String pcDescriba;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblParticipacionCiudadana() {
    }

    public TblParticipacionCiudadana(Integer pcCod) {
        this.pcCod = pcCod;
    }

    public Integer getPcCod() {
        return pcCod;
    }

    public void setPcCod(Integer pcCod) {
        this.pcCod = pcCod;
    }

    public String getPcSistema() {
        return pcSistema;
    }

    public void setPcSistema(String pcSistema) {
        this.pcSistema = pcSistema;
    }

    public String getPcValida() {
        return pcValida;
    }

    public void setPcValida(String pcValida) {
        this.pcValida = pcValida;
    }

    public String getPcLink() {
        return pcLink;
    }

    public void setPcLink(String pcLink) {
        this.pcLink = pcLink;
    }

    public String getPcDescriba() {
        return pcDescriba;
    }

    public void setPcDescriba(String pcDescriba) {
        this.pcDescriba = pcDescriba;
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
        hash += (pcCod != null ? pcCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblParticipacionCiudadana)) {
            return false;
        }
        TblParticipacionCiudadana other = (TblParticipacionCiudadana) object;
        if ((this.pcCod == null && other.pcCod != null) || (this.pcCod != null && !this.pcCod.equals(other.pcCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblParticipacionCiudadana[ pcCod=" + pcCod + " ]";
    }
    
}
