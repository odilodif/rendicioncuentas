/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.retroalimentacion;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "tbl_valoracion", catalog = "rendiciondb", schema = "esq_retroalimentacion")
@NamedQueries({
    @NamedQuery(name = "TblValoracion.findAll", query = "SELECT t FROM TblValoracion t"),
    @NamedQuery(name = "TblValoracion.findByIdValoracion", query = "SELECT t FROM TblValoracion t WHERE t.idValoracion = :idValoracion"),
    @NamedQuery(name = "TblValoracion.findByInstiCod", query = "SELECT t FROM TblValoracion t WHERE t.instiCod = :instiCod"),
    @NamedQuery(name = "TblValoracion.findByPeriodo", query = "SELECT t FROM TblValoracion t WHERE t.periodo = :periodo"),
    @NamedQuery(name = "TblValoracion.findByInfCod", query = "SELECT t FROM TblValoracion t WHERE t.infCod = :infCod"),
    @NamedQuery(name = "TblValoracion.findByNota", query = "SELECT t FROM TblValoracion t WHERE t.nota = :nota"),
    @NamedQuery(name = "TblValoracion.findByIdentificador", query = "SELECT t FROM TblValoracion t WHERE t.identificador = :identificador"),
    @NamedQuery(name = "TblValoracion.findByTipoValoracion", query = "SELECT t FROM TblValoracion t WHERE t.tipoValoracion = :tipoValoracion"),
    @NamedQuery(name = "TblValoracion.findByFechaValoracion", query = "SELECT t FROM TblValoracion t WHERE t.fechaValoracion = :fechaValoracion"),
    @NamedQuery(name = "TblValoracion.findByComentario", query = "SELECT t FROM TblValoracion t WHERE t.comentario = :comentario")})
public class TblValoracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_valoracion", nullable = false)
    private Integer idValoracion;
    @Column(name = "insti_cod")
    private Integer instiCod;
    @Column(name = "periodo")
    private Integer periodo;
    @Column(name = "inf_cod")
    private Integer infCod;
    @Column(name = "nota", precision = 8, scale = 8)
    private Float nota;
    @Column(name = "identificador", length = 10)
    private String identificador;
    @Column(name = "tipo_valoracion", length = 50)
    private String tipoValoracion;
    @Column(name = "fecha_valoracion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaValoracion;
    @Column(name = "comentario", length = 1000)
    private String comentario;
    @Column(name = "verificador", length = 15)
    private String verificador;

    public TblValoracion() {
    }

    public TblValoracion(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    public Integer getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    public Integer getInstiCod() {
        return instiCod;
    }

    public void setInstiCod(Integer instiCod) {
        this.instiCod = instiCod;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Integer getInfCod() {
        return infCod;
    }

    public void setInfCod(Integer infCod) {
        this.infCod = infCod;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTipoValoracion() {
        return tipoValoracion;
    }

    public void setTipoValoracion(String tipoValoracion) {
        this.tipoValoracion = tipoValoracion;
    }

    public Date getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(Date fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public String getVerificador() {
        return verificador;
    }

    public void setVerificador(String verificador) {
        this.verificador = verificador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValoracion != null ? idValoracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblValoracion)) {
            return false;
        }
        TblValoracion other = (TblValoracion) object;
        if ((this.idValoracion == null && other.idValoracion != null) || (this.idValoracion != null && !this.idValoracion.equals(other.idValoracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.cpccs.model.retroalimentacion.TblValoracion[ idValoracion=" + idValoracion + " ]";
    }
    
}
