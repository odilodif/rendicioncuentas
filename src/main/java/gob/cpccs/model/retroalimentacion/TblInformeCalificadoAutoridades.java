package gob.cpccs.model.retroalimentacion;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Paul Tapia
 */
@Entity
@Table(name = "tbl_informe_calificado_autoridades")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "TblInformeCalificadoAutoridades.findAll", query = "SELECT t FROM TblInformeCalificadoAutoridades t"),
		@NamedQuery(name = "TblInformeCalificadoAutoridades.findByIdInfAutCal", query = "SELECT t FROM TblInformeCalificadoAutoridades t WHERE t.idInfAutCal = :idInfAutCal"),
		@NamedQuery(name = "TblInformeCalificadoAutoridades.findByInfAutCod", query = "SELECT t FROM TblInformeCalificadoAutoridades t WHERE t.infAutCod = :infAutCod"),
		@NamedQuery(name = "TblInformeCalificadoAutoridades.findByPeriodo", query = "SELECT t FROM TblInformeCalificadoAutoridades t WHERE t.periodo = :periodo"),
		@NamedQuery(name = "TblInformeCalificadoAutoridades.findByPregunta", query = "SELECT t FROM TblInformeCalificadoAutoridades t WHERE t.pregunta = :pregunta"),
		@NamedQuery(name = "TblInformeCalificadoAutoridades.findByRespuesta", query = "SELECT t FROM TblInformeCalificadoAutoridades t WHERE t.respuesta = :respuesta"),
		@NamedQuery(name = "TblInformeCalificadoAutoridades.findByRespuestaInstitucion", query = "SELECT t FROM TblInformeCalificadoAutoridades t WHERE t.respuestaInstitucion = :respuestaInstitucion"),
		@NamedQuery(name = "TblInformeCalificadoAutoridades.findByNota", query = "SELECT t FROM TblInformeCalificadoAutoridades t WHERE t.nota = :nota"),
		@NamedQuery(name = "TblInformeCalificadoAutoridades.findByEvidencia", query = "SELECT t FROM TblInformeCalificadoAutoridades t WHERE t.evidencia = :evidencia") })

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TblInformeCalificadoAutoridades implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inf_aut_cal")
    @EqualsAndHashCode.Include
    private Integer idInfAutCal;
    @Column(name = "inf_aut_cod")
    private Integer infAutCod;
    @Column(name = "periodo")
    private Integer periodo;
    @Size(max = 255)
    @Column(name = "pregunta")
    private String pregunta;
    @Size(max = 255)
    @Column(name = "respuesta")
    private String respuesta;
    @Size(max = 255)
    @Column(name = "respuesta_institucion")
    private String respuestaInstitucion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota")
    private Float nota;
    @Size(max = 255)
    @Column(name = "evidencia")
    private String evidencia;
    @JoinColumn(name = "id_matriz", referencedColumnName = "id_matriz")
    @ManyToOne
    private TblMatriz idMatriz;

}
