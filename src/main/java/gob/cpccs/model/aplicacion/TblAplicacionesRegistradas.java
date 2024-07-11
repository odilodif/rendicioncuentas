/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.aplicacion;

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
 * @author Wilmer
 */
@Entity
@Table(name = "tbl_aplicaciones_registradas", catalog = "rendiciondb", schema = "esq_aplicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAplicacionesRegistradas.findAll", query = "SELECT t FROM TblAplicacionesRegistradas t"),
    @NamedQuery(name = "TblAplicacionesRegistradas.findByIdAplicacionRegistrada", query = "SELECT t FROM TblAplicacionesRegistradas t WHERE t.idAplicacionRegistrada = :idAplicacionRegistrada"),
    @NamedQuery(name = "TblAplicacionesRegistradas.findByIdentificador", query = "SELECT t FROM TblAplicacionesRegistradas t WHERE t.identificador = :identificador"),
    @NamedQuery(name = "TblAplicacionesRegistradas.findByCantidadNotificacion", query = "SELECT t FROM TblAplicacionesRegistradas t WHERE t.cantidadNotificacion = :cantidadNotificacion"),
    @NamedQuery(name = "TblAplicacionesRegistradas.findByMensajeNotificacion", query = "SELECT t FROM TblAplicacionesRegistradas t WHERE t.mensajeNotificacion = :mensajeNotificacion"),
    @NamedQuery(name = "TblAplicacionesRegistradas.findByEmailIdentificador", query = "SELECT t FROM TblAplicacionesRegistradas t WHERE t.emailIdentificador = :emailIdentificador"),
    @NamedQuery(name = "TblAplicacionesRegistradas.findByPeriodo", query = "SELECT t FROM TblAplicacionesRegistradas t WHERE t.periodo = :periodo"),
    @NamedQuery(name = "TblAplicacionesRegistradas.findByEstado", query = "SELECT t FROM TblAplicacionesRegistradas t WHERE t.estado = :estado")})
public class TblAplicacionesRegistradas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aplicacion_registrada", nullable = false)
    private Integer idAplicacionRegistrada;
    @Basic(optional = false)
    @Column(name = "identificador", nullable = false, length = 13)
    private String identificador;
    @Column(name = "cantidad_notificacion")
    private Integer cantidadNotificacion;
    @Column(name = "mensaje_notificacion", length = 256)
    private String mensajeNotificacion;
    @Column(name = "email_identificador", length = 200)
    private String emailIdentificador;
    @Column(name = "periodo", length = 6)
    private String periodo;
    @Column(name = "estado")
    private Integer estado;
    @JoinColumn(name = "id_aplicacion", referencedColumnName = "id_aplicacion", nullable = false)
    @ManyToOne(optional = false)
    private TblAplicaciones idAplicacion;

    public TblAplicacionesRegistradas() {
    }

    public TblAplicacionesRegistradas(Integer idAplicacionRegistrada) {
        this.idAplicacionRegistrada = idAplicacionRegistrada;
    }

    public TblAplicacionesRegistradas(Integer idAplicacionRegistrada, String identificador) {
        this.idAplicacionRegistrada = idAplicacionRegistrada;
        this.identificador = identificador;
    }

    public Integer getIdAplicacionRegistrada() {
        return idAplicacionRegistrada;
    }

    public void setIdAplicacionRegistrada(Integer idAplicacionRegistrada) {
        this.idAplicacionRegistrada = idAplicacionRegistrada;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Integer getCantidadNotificacion() {
        return cantidadNotificacion;
    }

    public void setCantidadNotificacion(Integer cantidadNotificacion) {
        this.cantidadNotificacion = cantidadNotificacion;
    }

    public String getMensajeNotificacion() {
        return mensajeNotificacion;
    }

    public void setMensajeNotificacion(String mensajeNotificacion) {
        this.mensajeNotificacion = mensajeNotificacion;
    }

    public String getEmailIdentificador() {
        return emailIdentificador;
    }

    public void setEmailIdentificador(String emailIdentificador) {
        this.emailIdentificador = emailIdentificador;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public TblAplicaciones getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(TblAplicaciones idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAplicacionRegistrada != null ? idAplicacionRegistrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAplicacionesRegistradas)) {
            return false;
        }
        TblAplicacionesRegistradas other = (TblAplicacionesRegistradas) object;
        if ((this.idAplicacionRegistrada == null && other.idAplicacionRegistrada != null) || (this.idAplicacionRegistrada != null && !this.idAplicacionRegistrada.equals(other.idAplicacionRegistrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.aplicacion.TblAplicacionesRegistradas[ idAplicacionRegistrada=" + idAplicacionRegistrada + " ]";
    }
    
}
