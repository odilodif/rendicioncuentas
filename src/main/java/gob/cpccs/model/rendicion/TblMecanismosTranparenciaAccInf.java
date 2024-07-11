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
@Table(name = "tbl_mecanismos_tranparencia_acc_inf", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMecanismosTranparenciaAccInf.findAll", query = "SELECT t FROM TblMecanismosTranparenciaAccInf t")
    , @NamedQuery(name = "TblMecanismosTranparenciaAccInf.findByMecaniCod", query = "SELECT t FROM TblMecanismosTranparenciaAccInf t WHERE t.mecaniCod = :mecaniCod")
    , @NamedQuery(name = "TblMecanismosTranparenciaAccInf.findByMecaniNombre", query = "SELECT t FROM TblMecanismosTranparenciaAccInf t WHERE t.mecaniNombre = :mecaniNombre")
    , @NamedQuery(name = "TblMecanismosTranparenciaAccInf.findByMecaniImplementado", query = "SELECT t FROM TblMecanismosTranparenciaAccInf t WHERE t.mecaniImplementado = :mecaniImplementado")
    , @NamedQuery(name = "TblMecanismosTranparenciaAccInf.findByMecaniMedioverifica", query = "SELECT t FROM TblMecanismosTranparenciaAccInf t WHERE t.mecaniMedioverifica = :mecaniMedioverifica")
    , @NamedQuery(name = "TblMecanismosTranparenciaAccInf.findByMecaniTipo", query = "SELECT t FROM TblMecanismosTranparenciaAccInf t WHERE t.mecaniTipo = :mecaniTipo")
    , @NamedQuery(name = "TblMecanismosTranparenciaAccInf.findByMecaniEstado", query = "SELECT t FROM TblMecanismosTranparenciaAccInf t WHERE t.mecaniEstado = :mecaniEstado")})
public class TblMecanismosTranparenciaAccInf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mecani_cod", nullable = false)
    private Integer mecaniCod;
    @Column(name = "mecani_nombre", length = 200)
    private String mecaniNombre;
    @Column(name = "mecani_implementado", length = 2)
    private String mecaniImplementado;
    @Column(name = "mecani_medioverifica", length = 2147483647)
    private String mecaniMedioverifica;
    @Column(name = "mecani_tipo", length = 200)
    private String mecaniTipo;
    @Column(name = "mecani_estado", length = 200)
    private String mecaniEstado;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod")
    @ManyToOne
    private TblInforme infCod;

    public TblMecanismosTranparenciaAccInf() {
    }

    public TblMecanismosTranparenciaAccInf(Integer mecaniCod) {
        this.mecaniCod = mecaniCod;
    }

    public Integer getMecaniCod() {
        return mecaniCod;
    }

    public void setMecaniCod(Integer mecaniCod) {
        this.mecaniCod = mecaniCod;
    }

    public String getMecaniNombre() {
        return mecaniNombre;
    }

    public void setMecaniNombre(String mecaniNombre) {
        this.mecaniNombre = mecaniNombre;
    }

    public String getMecaniImplementado() {
        return mecaniImplementado;
    }

    public void setMecaniImplementado(String mecaniImplementado) {
        this.mecaniImplementado = mecaniImplementado;
    }

    public String getMecaniMedioverifica() {
        return mecaniMedioverifica;
    }

    public void setMecaniMedioverifica(String mecaniMedioverifica) {
        this.mecaniMedioverifica = mecaniMedioverifica;
    }

    public String getMecaniTipo() {
        return mecaniTipo;
    }

    public void setMecaniTipo(String mecaniTipo) {
        this.mecaniTipo = mecaniTipo;
    }

    public String getMecaniEstado() {
        return mecaniEstado;
    }

    public void setMecaniEstado(String mecaniEstado) {
        this.mecaniEstado = mecaniEstado;
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
        hash += (mecaniCod != null ? mecaniCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMecanismosTranparenciaAccInf)) {
            return false;
        }
        TblMecanismosTranparenciaAccInf other = (TblMecanismosTranparenciaAccInf) object;
        if ((this.mecaniCod == null && other.mecaniCod != null) || (this.mecaniCod != null && !this.mecaniCod.equals(other.mecaniCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblMecanismosTranparenciaAccInf[ mecaniCod=" + mecaniCod + " ]";
    }
    
}
