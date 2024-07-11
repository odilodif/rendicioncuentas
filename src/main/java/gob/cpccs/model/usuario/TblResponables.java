/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.usuario;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wilmer Guamán
 */
@Entity
@Table(name = "tbl_responables", catalog = "rendiciondb", schema = "esq_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblResponables.findAll", query = "SELECT t FROM TblResponables t")
    , @NamedQuery(name = "TblResponables.findByResponCodigo", query = "SELECT t FROM TblResponables t WHERE t.responCodigo = :responCodigo")
    , @NamedQuery(name = "TblResponables.findByResponNombre", query = "SELECT t FROM TblResponables t WHERE t.responNombre = :responNombre")
    , @NamedQuery(name = "TblResponables.findByResponCargo", query = "SELECT t FROM TblResponables t WHERE t.responCargo = :responCargo")
    , @NamedQuery(name = "TblResponables.findByResponEmail", query = "SELECT t FROM TblResponables t WHERE t.responEmail = :responEmail")
    , @NamedQuery(name = "TblResponables.findByResponTelefono", query = "SELECT t FROM TblResponables t WHERE t.responTelefono = :responTelefono")
    , @NamedQuery(name = "TblResponables.findByResponCelular", query = "SELECT t FROM TblResponables t WHERE t.responCelular = :responCelular")
    , @NamedQuery(name = "TblResponables.findByResponFechaDesignacion", query = "SELECT t FROM TblResponables t WHERE t.responFechaDesignacion = :responFechaDesignacion")
    , @NamedQuery(name = "TblResponables.findByResponTipo", query = "SELECT t FROM TblResponables t WHERE t.responTipo = :responTipo")
    , @NamedQuery(name = "TblResponables.findByResponPeriodo", query = "SELECT t FROM TblResponables t WHERE t.responPeriodo = :responPeriodo")  
    , @NamedQuery(name = "TblResponables.findByResponCodRefe", query = "SELECT t FROM TblResponables t WHERE t.responCodRefe = :responCodRefe")})
public class TblResponables implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "respon_codigo", nullable = false)
    private Integer responCodigo;
    @Column(name = "respon_nombre", length = 100)
    private String responNombre;
    @Column(name = "respon_cargo", length = 100)
    private String responCargo;
    @Column(name = "respon_email", length = 200)
    private String responEmail;
    @Column(name = "respon_telefono", length = 15)
    private String responTelefono;
    @Column(name = "respon_celular", length = 15)
    private String responCelular;
    @Column(name = "respon_fecha_designacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date responFechaDesignacion;
    @Column(name = "respon_tipo", length = 25)
    private String responTipo;
    @Column(name = "respon_periodo", length = 20)
    private String responPeriodo;
    @Column(name = "respon_cod_refe")
    private Integer responCodRefe;

    public TblResponables() {
    }

    public TblResponables(Integer responCodigo) {
        this.responCodigo = responCodigo;
    }

    public Integer getResponCodigo() {
        return responCodigo;
    }

    public void setResponCodigo(Integer responCodigo) {
        this.responCodigo = responCodigo;
    }

    public String getResponNombre() {
        return responNombre;
    }

    public void setResponNombre(String responNombre) {
        this.responNombre = responNombre;
    }

    public String getResponCargo() {
        return responCargo;
    }

    public void setResponCargo(String responCargo) {
        this.responCargo = responCargo;
    }

    public String getResponEmail() {
        return responEmail;
    }

    public void setResponEmail(String responEmail) {
        this.responEmail = responEmail;
    }

    public String getResponTelefono() {
        return responTelefono;
    }

    public void setResponTelefono(String responTelefono) {
        this.responTelefono = responTelefono;
    }

    public String getResponCelular() {
        return responCelular;
    }

    public void setResponCelular(String responCelular) {
        this.responCelular = responCelular;
    }

    public Date getResponFechaDesignacion() {
        return responFechaDesignacion;
    }

    public void setResponFechaDesignacion(Date responFechaDesignacion) {
        this.responFechaDesignacion = responFechaDesignacion;
    }

    public String getResponTipo() {
        return responTipo;
    }

    public void setResponTipo(String responTipo) {
        this.responTipo = responTipo;
    }

    public String getResponPeriodo() {
        return responPeriodo;
    }

    public void setResponPeriodo(String responPeriodo) {
        this.responPeriodo = responPeriodo;
    }


    public Integer getResponCodRefe() {
        return responCodRefe;
    }

    public void setResponCodRefe(Integer responCodRefe) {
        this.responCodRefe = responCodRefe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (responCodigo != null ? responCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblResponables)) {
            return false;
        }
        TblResponables other = (TblResponables) object;
        if ((this.responCodigo == null && other.responCodigo != null) || (this.responCodigo != null && !this.responCodigo.equals(other.responCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.usuario.TblResponables[ responCodigo=" + responCodigo + " ]";
    }
    
}
