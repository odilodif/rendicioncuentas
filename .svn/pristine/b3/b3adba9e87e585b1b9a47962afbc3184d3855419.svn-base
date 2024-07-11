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
@Table(name = "tbl_sugerencia_ciudadana", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSugerenciaCiudadana.findAll", query = "SELECT t FROM TblSugerenciaCiudadana t")
    , @NamedQuery(name = "TblSugerenciaCiudadana.findBySecCode", query = "SELECT t FROM TblSugerenciaCiudadana t WHERE t.secCode = :secCode")
    , @NamedQuery(name = "TblSugerenciaCiudadana.findBySecDemandas", query = "SELECT t FROM TblSugerenciaCiudadana t WHERE t.secDemandas = :secDemandas")
    , @NamedQuery(name = "TblSugerenciaCiudadana.findBySecValida", query = "SELECT t FROM TblSugerenciaCiudadana t WHERE t.secValida = :secValida")
    , @NamedQuery(name = "TblSugerenciaCiudadana.findBySecMedioVerificacione", query = "SELECT t FROM TblSugerenciaCiudadana t WHERE t.secMedioVerificacione = :secMedioVerificacione")})
public class TblSugerenciaCiudadana implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sec_code", nullable = false)
    private Integer secCode;
    @Column(name = "sec_demandas", length = 2147483647)
    private String secDemandas;
    @Column(name = "sec_valida", length = 2)
    private String secValida;
    @Column(name = "sec_medio_verificacione", length = 2147483647)
    private String secMedioVerificacione;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod")
    @ManyToOne
    private TblInforme infCod;

    public TblSugerenciaCiudadana() {
    }

    public TblSugerenciaCiudadana(Integer secCode) {
        this.secCode = secCode;
    }

    public Integer getSecCode() {
        return secCode;
    }

    public void setSecCode(Integer secCode) {
        this.secCode = secCode;
    }

    public String getSecDemandas() {
        return secDemandas;
    }

    public void setSecDemandas(String secDemandas) {
        this.secDemandas = secDemandas;
    }

    public String getSecValida() {
        return secValida;
    }

    public void setSecValida(String secValida) {
        this.secValida = secValida;
    }

    public String getSecMedioVerificacione() {
        return secMedioVerificacione;
    }

    public void setSecMedioVerificacione(String secMedioVerificacione) {
        this.secMedioVerificacione = secMedioVerificacione;
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
        hash += (secCode != null ? secCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSugerenciaCiudadana)) {
            return false;
        }
        TblSugerenciaCiudadana other = (TblSugerenciaCiudadana) object;
        if ((this.secCode == null && other.secCode != null) || (this.secCode != null && !this.secCode.equals(other.secCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblSugerenciaCiudadana[ secCode=" + secCode + " ]";
    }
    
}
