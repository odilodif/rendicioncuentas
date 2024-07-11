/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.cpccs.model.retroalimentacion;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.ToString;

/**
 *
 * @author Wilmer
 */
@Entity
@Table(name = "tbl_informe_calificado", catalog = "rendiciondb", schema = "esq_retroalimentacion")
@XmlRootElement
/*@NamedQueries({
    @NamedQuery(name = "TblInformeCalificado.findAll", query = "SELECT t FROM TblInformeCalificado t"),
    @NamedQuery(name = "TblInformeCalificado.findByIdInfCal", query = "SELECT t FROM TblInformeCalificado t WHERE t.idInfCal = :idInfCal"),
    @NamedQuery(name = "TblInformeCalificado.findByInfCod", query = "SELECT t FROM TblInformeCalificado t WHERE t.infCod = :infCod"),
    @NamedQuery(name = "TblInformeCalificado.findByPeriodo", query = "SELECT t FROM TblInformeCalificado t WHERE t.periodo = :periodo"),
    @NamedQuery(name = "TblInformeCalificado.findByMatriz", query = "SELECT t FROM TblInformeCalificado t WHERE t.matriz = :matriz"),
    @NamedQuery(name = "TblInformeCalificado.findByPregunta", query = "SELECT t FROM TblInformeCalificado t WHERE t.pregunta = :pregunta"),
    @NamedQuery(name = "TblInformeCalificado.findByRespuesta", query = "SELECT t FROM TblInformeCalificado t WHERE t.respuesta = :respuesta"),
    @NamedQuery(name = "TblInformeCalificado.findByRespuestaInstitucion", query = "SELECT t FROM TblInformeCalificado t WHERE t.respuestaInstitucion = :respuestaInstitucion"),
    @NamedQuery(name = "TblInformeCalificado.findByNota", query = "SELECT t FROM TblInformeCalificado t WHERE t.nota = :nota")})
*/

@ToString
public class TblInformeCalificado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inf_Cal", nullable = false)
    private Integer idInfCal;
    @Column(name = "inf_cod")
    private Integer infCod;
    @Column(name = "periodo")
    private Integer periodo;
    @Column(name = "matriz", length = 255)
    private String matriz;
    @Column(name = "pregunta", length = 500)
    private String pregunta;
    @Column(name = "respuesta", length = 500)
    private String respuesta;
    @Column(name = "respuesta_institucion", length = 255)
    private String respuestaInstitucion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota", precision = 8, scale = 8)
    private Float nota;
    @Column(name = "evidencia", length = 500)
    private String evidencia;
    @Column(name = "orden")
    private Integer orden;
    public TblInformeCalificado() {
    }

    public TblInformeCalificado(Integer idInfCal) {
        this.idInfCal = idInfCal;
    }

    public Integer getIdInfCal() {
        return idInfCal;
    }

    public void setIdInfCal(Integer idInfCal) {
        this.idInfCal = idInfCal;
    }

    public Integer getInfCod() {
        return infCod;
    }

    public void setInfCod(Integer infCod) {
        this.infCod = infCod;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public String getMatriz() {
        return matriz;
    }

    public void setMatriz(String matriz) {
        this.matriz = matriz;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuestaInstitucion() {
        return respuestaInstitucion;
    }

    public void setRespuestaInstitucion(String respuestaInstitucion) {
        this.respuestaInstitucion = respuestaInstitucion;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }
    
    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInfCal != null ? idInfCal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblInformeCalificado)) {
            return false;
        }
        TblInformeCalificado other = (TblInformeCalificado) object;
        if ((this.idInfCal == null && other.idInfCal != null) || (this.idInfCal != null && !this.idInfCal.equals(other.idInfCal))) {
            return false;
        }
        return true;
    }

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

   /* @Override
    public String toString() {
        return "gob.cpccs.model.retroalimentacion.TblInformeCalificado[ idInfCal=" + idInfCal + " ]";
    }
    */
    
}
