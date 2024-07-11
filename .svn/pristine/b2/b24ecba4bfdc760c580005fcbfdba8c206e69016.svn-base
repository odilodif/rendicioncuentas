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
@Table(name = "tbl_mecanismos_contol_social", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMecanismosContolSocial.findAll", query = "SELECT t FROM TblMecanismosContolSocial t")
    , @NamedQuery(name = "TblMecanismosContolSocial.findByMecCod", query = "SELECT t FROM TblMecanismosContolSocial t WHERE t.mecCod = :mecCod")
    , @NamedQuery(name = "TblMecanismosContolSocial.findByMecNombre", query = "SELECT t FROM TblMecanismosContolSocial t WHERE t.mecNombre = :mecNombre")
    , @NamedQuery(name = "TblMecanismosContolSocial.findByMecImplementado", query = "SELECT t FROM TblMecanismosContolSocial t WHERE t.mecImplementado = :mecImplementado")
    , @NamedQuery(name = "TblMecanismosContolSocial.findByMecNumero", query = "SELECT t FROM TblMecanismosContolSocial t WHERE t.mecNumero = :mecNumero")
    , @NamedQuery(name = "TblMecanismosContolSocial.findByMecMedioverifica", query = "SELECT t FROM TblMecanismosContolSocial t WHERE t.mecMedioverifica = :mecMedioverifica")
    , @NamedQuery(name = "TblMecanismosContolSocial.findByMecTi", query = "SELECT t FROM TblMecanismosContolSocial t WHERE t.mecTi = :mecTi")})
public class TblMecanismosContolSocial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mec_cod", nullable = false)
    private Integer mecCod;
    @Column(name = "mec_nombre", length = 100)
    private String mecNombre;
    @Column(name = "mec_implementado", length = 2)
    private String mecImplementado;
    @Column(name = "mec_numero")
    private Integer mecNumero;
    @Column(name = "mec_medioverifica", length = 2147483647)
    private String mecMedioverifica;
    @Column(name = "mec_ti", length = 200)
    private String mecTi;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblMecanismosContolSocial() {
    }

    public TblMecanismosContolSocial(Integer mecCod) {
        this.mecCod = mecCod;
    }

    public Integer getMecCod() {
        return mecCod;
    }

    public void setMecCod(Integer mecCod) {
        this.mecCod = mecCod;
    }

    public String getMecNombre() {
        return mecNombre;
    }

    public void setMecNombre(String mecNombre) {
        this.mecNombre = mecNombre;
    }

    public String getMecImplementado() {
        return mecImplementado;
    }

    public void setMecImplementado(String mecImplementado) {
        this.mecImplementado = mecImplementado;
    }

    public Integer getMecNumero() {
        return mecNumero;
    }

    public void setMecNumero(Integer mecNumero) {
        this.mecNumero = mecNumero;
    }

    public String getMecMedioverifica() {
        return mecMedioverifica;
    }

    public void setMecMedioverifica(String mecMedioverifica) {
        this.mecMedioverifica = mecMedioverifica;
    }

    public String getMecTi() {
        return mecTi;
    }

    public void setMecTi(String mecTi) {
        this.mecTi = mecTi;
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
        hash += (mecCod != null ? mecCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMecanismosContolSocial)) {
            return false;
        }
        TblMecanismosContolSocial other = (TblMecanismosContolSocial) object;
        if ((this.mecCod == null && other.mecCod != null) || (this.mecCod != null && !this.mecCod.equals(other.mecCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblMecanismosContolSocial[ mecCod=" + mecCod + " ]";
    }
    
}
