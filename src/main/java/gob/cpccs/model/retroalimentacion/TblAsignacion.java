/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.retroalimentacion;

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

/**
 *
 * @author rata
 */
@Entity
@Table(name = "tbl_asignacion", catalog = "rendiciondb", schema = "esq_retroalimentacion")
@NamedQueries({
    @NamedQuery(name = "TblAsignacion.findAll", query = "SELECT t FROM TblAsignacion t"),
    @NamedQuery(name = "TblAsignacion.findByIdAsignacion", query = "SELECT t FROM TblAsignacion t WHERE t.idAsignacion = :idAsignacion"),
    @NamedQuery(name = "TblAsignacion.findByInfCod", query = "SELECT t FROM TblAsignacion t WHERE t.infCod = :infCod"),
    @NamedQuery(name = "TblAsignacion.findByInstCod", query = "SELECT t FROM TblAsignacion t WHERE t.instCod = :instCod"),
    @NamedQuery(name = "TblAsignacion.findByPeriodoAsig", query = "SELECT t FROM TblAsignacion t WHERE t.periodoAsig = :periodoAsig"),
    @NamedQuery(name = "TblAsignacion.findByFechaAsig", query = "SELECT t FROM TblAsignacion t WHERE t.fechaAsig = :fechaAsig"),
    @NamedQuery(name = "TblAsignacion.findByComentarioAsig", query = "SELECT t FROM TblAsignacion t WHERE t.comentarioAsig = :comentarioAsig"),
    @NamedQuery(name = "TblAsignacion.findByIdentificador", query = "SELECT t FROM TblAsignacion t WHERE t.identificador = :identificador"),
    @NamedQuery(name = "TblAsignacion.findByAsignador", query = "SELECT t FROM TblAsignacion t WHERE t.asignador = :asignador"),
    @NamedQuery(name = "TblAsignacion.findByEstadoAsig", query = "SELECT t FROM TblAsignacion t WHERE t.estadoAsig = :estadoAsig")})
public class TblAsignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asignacion", nullable = false)
    private Integer idAsignacion;
    @Basic(optional = false)
    @Column(name = "inf_cod", nullable = false)
    private int infCod;
    @Basic(optional = false)
    @Column(name = "inst_cod", nullable = false)
    private int instCod;
    @Basic(optional = false)
    @Column(name = "periodo_asig", nullable = false)
    private int periodoAsig;
    @Basic(optional = false)
    @Column(name = "fecha_asig", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsig;
    @Column(name = "comentario_asig", length = 300)
    private String comentarioAsig;
    @Basic(optional = false)
    @Column(name = "identificador", nullable = false, length = 13)
    private String identificador;
    @Column(name = "asignador", length = 10)
    private String asignador;
    @Column(name = "estado_asig", length = 10)
    private String estadoAsig;

    public TblAsignacion() {
    }

    public TblAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public TblAsignacion(Integer idAsignacion, int infCod, int instCod, int periodoAsig, Date fechaAsig, String identificador) {
        this.idAsignacion = idAsignacion;
        this.infCod = infCod;
        this.instCod = instCod;
        this.periodoAsig = periodoAsig;
        this.fechaAsig = fechaAsig;
        this.identificador = identificador;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public int getInfCod() {
        return infCod;
    }

    public void setInfCod(int infCod) {
        this.infCod = infCod;
    }

    public int getInstCod() {
        return instCod;
    }

    public void setInstCod(int instCod) {
        this.instCod = instCod;
    }

    public int getPeriodoAsig() {
        return periodoAsig;
    }

    public void setPeriodoAsig(int periodoAsig) {
        this.periodoAsig = periodoAsig;
    }

    public Date getFechaAsig() {
        return fechaAsig;
    }

    public void setFechaAsig(Date fechaAsig) {
        this.fechaAsig = fechaAsig;
    }

    public String getComentarioAsig() {
        return comentarioAsig;
    }

    public void setComentarioAsig(String comentarioAsig) {
        this.comentarioAsig = comentarioAsig;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getAsignador() {
        return asignador;
    }

    public void setAsignador(String asignador) {
        this.asignador = asignador;
    }

    public String getEstadoAsig() {
        return estadoAsig;
    }

    public void setEstadoAsig(String estadoAsig) {
        this.estadoAsig = estadoAsig;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacion != null ? idAsignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAsignacion)) {
            return false;
        }
        TblAsignacion other = (TblAsignacion) object;
        if ((this.idAsignacion == null && other.idAsignacion != null) || (this.idAsignacion != null && !this.idAsignacion.equals(other.idAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.retroalimentacion.TblAsignacion[ idAsignacion=" + idAsignacion + " ]";
    }
    
}
