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
@Table(name = "tbl_compromisos_informeant", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCompromisosInformeant.findAll", query = "SELECT t FROM TblCompromisosInformeant t")
    , @NamedQuery(name = "TblCompromisosInformeant.findByCaCod", query = "SELECT t FROM TblCompromisosInformeant t WHERE t.caCod = :caCod")
    , @NamedQuery(name = "TblCompromisosInformeant.findByCaNombre", query = "SELECT t FROM TblCompromisosInformeant t WHERE t.caNombre = :caNombre")
    , @NamedQuery(name = "TblCompromisosInformeant.findByCaImplementado", query = "SELECT t FROM TblCompromisosInformeant t WHERE t.caImplementado = :caImplementado")
    , @NamedQuery(name = "TblCompromisosInformeant.findByCaAvance", query = "SELECT t FROM TblCompromisosInformeant t WHERE t.caAvance = :caAvance")
    , @NamedQuery(name = "TblCompromisosInformeant.findByCaMedioverif", query = "SELECT t FROM TblCompromisosInformeant t WHERE t.caMedioverif = :caMedioverif")
    , @NamedQuery(name = "TblCompromisosInformeant.findByCaDes", query = "SELECT t FROM TblCompromisosInformeant t WHERE t.caDes = :caDes")})
public class TblCompromisosInformeant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ca_cod", nullable = false)
    private Integer caCod;
    @Column(name = "ca_nombre", length = 2147483647)
    private String caNombre;
    @Column(name = "ca_implementado", length = 2)
    private String caImplementado;
    @Column(name = "ca_avance", length = 2147483647)
    private String caAvance;
    @Column(name = "ca_medioverif", length = 2147483647)
    private String caMedioverif;
    @Column(name = "ca_des", length = 2147483647)
    private String caDes;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblCompromisosInformeant() {
    }

    public TblCompromisosInformeant(Integer caCod) {
        this.caCod = caCod;
    }

    public Integer getCaCod() {
        return caCod;
    }

    public void setCaCod(Integer caCod) {
        this.caCod = caCod;
    }

    public String getCaNombre() {
        return caNombre;
    }

    public void setCaNombre(String caNombre) {
        this.caNombre = caNombre;
    }

    public String getCaImplementado() {
        return caImplementado;
    }

    public void setCaImplementado(String caImplementado) {
        this.caImplementado = caImplementado;
    }

    public String getCaAvance() {
        return caAvance;
    }

    public void setCaAvance(String caAvance) {
        this.caAvance = caAvance;
    }

    public String getCaMedioverif() {
        return caMedioverif;
    }

    public void setCaMedioverif(String caMedioverif) {
        this.caMedioverif = caMedioverif;
    }

    public String getCaDes() {
        return caDes;
    }

    public void setCaDes(String caDes) {
        this.caDes = caDes;
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
        hash += (caCod != null ? caCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCompromisosInformeant)) {
            return false;
        }
        TblCompromisosInformeant other = (TblCompromisosInformeant) object;
        if ((this.caCod == null && other.caCod != null) || (this.caCod != null && !this.caCod.equals(other.caCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblCompromisosInformeant[ caCod=" + caCod + " ]";
    }
    
}
