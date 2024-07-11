/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.rendicion;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringEscapeUtils;

import gob.cpccs.utilidades.Constantes;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_datos_medio", catalog = "rendiciondb", schema = "esq_rendicioncuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDatosMedio.findAll", query = "SELECT t FROM TblDatosMedio t")
    , @NamedQuery(name = "TblDatosMedio.findByDmCod", query = "SELECT t FROM TblDatosMedio t WHERE t.dmCod = :dmCod")
    , @NamedQuery(name = "TblDatosMedio.findByDmFrecuencia", query = "SELECT t FROM TblDatosMedio t WHERE t.dmFrecuencia = :dmFrecuencia")
    , @NamedQuery(name = "TblDatosMedio.findByDmNumrepetidoras", query = "SELECT t FROM TblDatosMedio t WHERE t.dmNumrepetidoras = :dmNumrepetidoras")
    , @NamedQuery(name = "TblDatosMedio.findByDmUbicrepetidoras", query = "SELECT t FROM TblDatosMedio t WHERE t.dmUbicrepetidoras = :dmUbicrepetidoras")
    , @NamedQuery(name = "TblDatosMedio.findByDmFechinicioconcesion", query = "SELECT t FROM TblDatosMedio t WHERE t.dmFechinicioconcesion = :dmFechinicioconcesion")
    , @NamedQuery(name = "TblDatosMedio.findByDmFechfinconcesion", query = "SELECT t FROM TblDatosMedio t WHERE t.dmFechfinconcesion = :dmFechfinconcesion")
    , @NamedQuery(name = "TblDatosMedio.findByDmNumscursales", query = "SELECT t FROM TblDatosMedio t WHERE t.dmNumscursales = :dmNumscursales")
    , @NamedQuery(name = "TblDatosMedio.findByDmUbicsucursales", query = "SELECT t FROM TblDatosMedio t WHERE t.dmUbicsucursales = :dmUbicsucursales")
    , @NamedQuery(name = "TblDatosMedio.findByDmProductos", query = "SELECT t FROM TblDatosMedio t WHERE t.dmProductos = :dmProductos")})
public class TblDatosMedio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dm_cod", nullable = false)
    private Integer dmCod;
    @Column(name = "dm_frecuencia", length = 8000)
    private String dmFrecuencia;
    @Column(name = "dm_numrepetidoras", length = 2147483647)
    private String dmNumrepetidoras;
    @Column(name = "dm_ubicrepetidoras", length = 8000)
    private String dmUbicrepetidoras;
    @Column(name = "dm_fechinicioconcesion")
    @Temporal(TemporalType.DATE)
    private Date dmFechinicioconcesion;
    @Column(name = "dm_fechfinconcesion")
    @Temporal(TemporalType.DATE)
    private Date dmFechfinconcesion;
    @Column(name = "dm_numscursales")
    private Integer dmNumscursales;
    @Column(name = "dm_ubicsucursales", length = 8000)
    private String dmUbicsucursales;
    @Column(name = "dm_productos", length = 8000)
    private String dmProductos;
    @JoinColumn(name = "inf_cod", referencedColumnName = "inf_cod", nullable = false)
    @ManyToOne(optional = false)
    private TblInforme infCod;

    public TblDatosMedio() {
    }

    public TblDatosMedio(Integer dmCod) {
        this.dmCod = dmCod;
    }

    public Integer getDmCod() {
        return dmCod;
    }

    public void setDmCod(Integer dmCod) {
        this.dmCod = dmCod;
    }

    public String getDmFrecuencia() {
        return dmFrecuencia;
    }

    public void setDmFrecuencia(String dmFrecuencia) {
        this.dmFrecuencia = dmFrecuencia;
    }

    public String getDmNumrepetidoras() {
        return dmNumrepetidoras;
    }

    public void setDmNumrepetidoras(String dmNumrepetidoras) {
        this.dmNumrepetidoras = dmNumrepetidoras;
    }

    public String getDmUbicrepetidoras() {
        return dmUbicrepetidoras;
    }

    public void setDmUbicrepetidoras(String dmUbicrepetidoras) {
        this.dmUbicrepetidoras = dmUbicrepetidoras;
    }

    public Date getDmFechinicioconcesion() {
        return dmFechinicioconcesion;
    }

    public void setDmFechinicioconcesion(Date dmFechinicioconcesion) {
        this.dmFechinicioconcesion = dmFechinicioconcesion;
    }

    public Date getDmFechfinconcesion() {
        return dmFechfinconcesion;
    }

    public void setDmFechfinconcesion(Date dmFechfinconcesion) {
        this.dmFechfinconcesion = dmFechfinconcesion;
    }

    public Integer getDmNumscursales() {
        return dmNumscursales;
    }

    public void setDmNumscursales(Integer dmNumscursales) {
        this.dmNumscursales = dmNumscursales;
    }

    public String getDmUbicsucursales() {
        return dmUbicsucursales;
    }

    public void setDmUbicsucursales(String dmUbicsucursales) {
        this.dmUbicsucursales = dmUbicsucursales;
    }

    public String getDmProductos() {
        return dmProductos;
    }

    public void setDmProductos(String dmProductos) {
        this.dmProductos = dmProductos;
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
        hash += (dmCod != null ? dmCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDatosMedio)) {
            return false;
        }
        TblDatosMedio other = (TblDatosMedio) object;
        if ((this.dmCod == null && other.dmCod != null) || (this.dmCod != null && !this.dmCod.equals(other.dmCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.rendicion.TblDatosMedio[ dmCod=" + dmCod + " ]";
    }
    
}
