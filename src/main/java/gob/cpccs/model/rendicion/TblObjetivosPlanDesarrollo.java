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

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_objetivos_plan_desarrollo", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblObjetivosPlanDesarrollo.findAll", query = "SELECT t FROM TblObjetivosPlanDesarrollo t")
    , @NamedQuery(name = "TblObjetivosPlanDesarrollo.findByObjCod", query = "SELECT t FROM TblObjetivosPlanDesarrollo t WHERE t.objCod = :objCod")
    , @NamedQuery(name = "TblObjetivosPlanDesarrollo.findByObjNombre", query = "SELECT t FROM TblObjetivosPlanDesarrollo t WHERE t.objNombre = :objNombre")
    , @NamedQuery(name = "TblObjetivosPlanDesarrollo.findByObjTipo", query = "SELECT t FROM TblObjetivosPlanDesarrollo t WHERE t.objTipo = :objTipo")})
public class TblObjetivosPlanDesarrollo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "obj_cod", nullable = false)
    private Integer objCod;
    @Column(name = "obj_nombre", length = 2147483647)
    private String objNombre;
    @Column(name = "obj_tipo", length = 50)
    private String objTipo;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;
    @Column(name = "obj_estado", length = 15)
    private String objEstado;
    

    public TblObjetivosPlanDesarrollo() {
    }

    public TblObjetivosPlanDesarrollo(Integer objCod) {
        this.objCod = objCod;
    }

    public Integer getObjCod() {
        return objCod;
    }

    public void setObjCod(Integer objCod) {
        this.objCod = objCod;
    }

    public String getObjNombre() {
        return objNombre;
    }

    public void setObjNombre(String objNombre) {
        this.objNombre = objNombre;
    }

    public String getObjEstado() {
        return objEstado;
    }

    public void setObjEstado(String objEstado) {
        this.objEstado = objEstado;
    }

    public TblInforme getInfCod() {
        return infCod;
    }

    public void setInfCod(TblInforme infCod) {
        this.infCod = infCod;
    }

    public String getObjTipo() {
        return objTipo;
    }

    public void setObjTipo(String objTipo) {
        this.objTipo = objTipo;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (objCod != null ? objCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblObjetivosPlanDesarrollo)) {
            return false;
        }
        TblObjetivosPlanDesarrollo other = (TblObjetivosPlanDesarrollo) object;
        if ((this.objCod == null && other.objCod != null) || (this.objCod != null && !this.objCod.equals(other.objCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblObjetivosPlanDesarrollo[ objCod=" + objCod + " ]";
    }
    
}
