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
@Table(name = "tbl_derechos_autor", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDerechosAutor.findAll", query = "SELECT t FROM TblDerechosAutor t")
    , @NamedQuery(name = "TblDerechosAutor.findByDaCod", query = "SELECT t FROM TblDerechosAutor t WHERE t.daCod = :daCod")
    , @NamedQuery(name = "TblDerechosAutor.findByDaTipo", query = "SELECT t FROM TblDerechosAutor t WHERE t.daTipo = :daTipo")
    , @NamedQuery(name = "TblDerechosAutor.findByDaNumero", query = "SELECT t FROM TblDerechosAutor t WHERE t.daNumero = :daNumero")
    , @NamedQuery(name = "TblDerechosAutor.findByDaNumeropagado", query = "SELECT t FROM TblDerechosAutor t WHERE t.daNumeropagado = :daNumeropagado")
    , @NamedQuery(name = "TblDerechosAutor.findByDalink", query = "SELECT t FROM TblDerechosAutor t WHERE t.dalink = :dalink")})
public class TblDerechosAutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "da_cod", nullable = false)
    private Integer daCod;
    @Column(name = "da_tipo", length = 200)
    private String daTipo;
    @Column(name = "da_numero")
    private Integer daNumero;
    @Column(name = "da_numeropagado")
    private Integer daNumeropagado;
    @Column(name = "dalink", length = 200)
    private String dalink;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod")
    @ManyToOne
    private TblInforme infCod;

    public TblDerechosAutor() {
    }

    public TblDerechosAutor(Integer daCod) {
        this.daCod = daCod;
    }

    public Integer getDaCod() {
        return daCod;
    }

    public void setDaCod(Integer daCod) {
        this.daCod = daCod;
    }

    public String getDaTipo() {
        return daTipo;
    }

    public void setDaTipo(String daTipo) {
        this.daTipo = daTipo;
    }

    public Integer getDaNumero() {
        return daNumero;
    }

    public void setDaNumero(Integer daNumero) {
        this.daNumero = daNumero;
    }

    public Integer getDaNumeropagado() {
        return daNumeropagado;
    }

    public void setDaNumeropagado(Integer daNumeropagado) {
        this.daNumeropagado = daNumeropagado;
    }

    public String getDalink() {
        return dalink;
    }

    public void setDalink(String dalink) {
        this.dalink = dalink;
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
        hash += (daCod != null ? daCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDerechosAutor)) {
            return false;
        }
        TblDerechosAutor other = (TblDerechosAutor) object;
        if ((this.daCod == null && other.daCod != null) || (this.daCod != null && !this.daCod.equals(other.daCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblDerechosAutor[ daCod=" + daCod + " ]";
    }
    
}
