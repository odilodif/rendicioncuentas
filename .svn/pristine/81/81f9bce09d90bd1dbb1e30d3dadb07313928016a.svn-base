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
@Table(name = "tbl_obligaciones_educacion", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblObligacionesEducacion.findAll", query = "SELECT t FROM TblObligacionesEducacion t")
    , @NamedQuery(name = "TblObligacionesEducacion.findByOeCod", query = "SELECT t FROM TblObligacionesEducacion t WHERE t.oeCod = :oeCod")
    , @NamedQuery(name = "TblObligacionesEducacion.findByOeObligacion", query = "SELECT t FROM TblObligacionesEducacion t WHERE t.oeObligacion = :oeObligacion")
    , @NamedQuery(name = "TblObligacionesEducacion.findByOeCumple", query = "SELECT t FROM TblObligacionesEducacion t WHERE t.oeCumple = :oeCumple")
    , @NamedQuery(name = "TblObligacionesEducacion.findByOeAcciones", query = "SELECT t FROM TblObligacionesEducacion t WHERE t.oeAcciones = :oeAcciones")
    , @NamedQuery(name = "TblObligacionesEducacion.findByOeResultados", query = "SELECT t FROM TblObligacionesEducacion t WHERE t.oeResultados = :oeResultados")})
public class TblObligacionesEducacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oe_cod", nullable = false)
    private Integer oeCod;
    @Column(name = "oe_obligacion", length = 200)
    private String oeObligacion;
    @Column(name = "oe_cumple", length = 2)
    private String oeCumple;
    @Column(name = "oe_acciones", length = 2147483647)
    private String oeAcciones;
    @Column(name = "oe_resultados", length = 2147483647)
    private String oeResultados;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblObligacionesEducacion() {
    }

    public TblObligacionesEducacion(Integer oeCod) {
        this.oeCod = oeCod;
    }

    public Integer getOeCod() {
        return oeCod;
    }

    public void setOeCod(Integer oeCod) {
        this.oeCod = oeCod;
    }

    public String getOeObligacion() {
        return oeObligacion;
    }

    public void setOeObligacion(String oeObligacion) {
        this.oeObligacion = oeObligacion;
    }

    public String getOeCumple() {
        return oeCumple;
    }

    public void setOeCumple(String oeCumple) {
        this.oeCumple = oeCumple;
    }

    public String getOeAcciones() {
        return oeAcciones;
    }

    public void setOeAcciones(String oeAcciones) {
        this.oeAcciones = oeAcciones;
    }

    public String getOeResultados() {
        return oeResultados;
    }

    public void setOeResultados(String oeResultados) {
        this.oeResultados = oeResultados;
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
        hash += (oeCod != null ? oeCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblObligacionesEducacion)) {
            return false;
        }
        TblObligacionesEducacion other = (TblObligacionesEducacion) object;
        if ((this.oeCod == null && other.oeCod != null) || (this.oeCod != null && !this.oeCod.equals(other.oeCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblObligacionesEducacion[ oeCod=" + oeCod + " ]";
    }
    
}
