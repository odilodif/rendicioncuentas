package gob.cpccs.model.retroalimentacion;

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
@Table(name = "tbl_asignacion_autoridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAsignacionAutoridades.findAll", query = "SELECT t FROM TblAsignacionAutoridades t"),
    @NamedQuery(name = "TblAsignacionAutoridades.findByIdAutAsignacion", query = "SELECT t FROM TblAsignacionAutoridades t WHERE t.idAutAsignacion = :idAutAsignacion"),
    @NamedQuery(name = "TblAsignacionAutoridades.findByInfAutCod", query = "SELECT t FROM TblAsignacionAutoridades t WHERE t.infAutCod = :infAutCod"),
    @NamedQuery(name = "TblAsignacionAutoridades.findByInstAutCod", query = "SELECT t FROM TblAsignacionAutoridades t WHERE t.instAutCod = :instAutCod"),
    @NamedQuery(name = "TblAsignacionAutoridades.findByPeriodoAsig", query = "SELECT t FROM TblAsignacionAutoridades t WHERE t.periodoAsig = :periodoAsig"),
    @NamedQuery(name = "TblAsignacionAutoridades.findByFechaAsig", query = "SELECT t FROM TblAsignacionAutoridades t WHERE t.fechaAsig = :fechaAsig"),
    @NamedQuery(name = "TblAsignacionAutoridades.findByComentarioAsig", query = "SELECT t FROM TblAsignacionAutoridades t WHERE t.comentarioAsig = :comentarioAsig"),
    @NamedQuery(name = "TblAsignacionAutoridades.findByIdentificadorTecnico", query = "SELECT t FROM TblAsignacionAutoridades t WHERE t.identificadorTecnico = :identificadorTecnico"),
    @NamedQuery(name = "TblAsignacionAutoridades.findByAsignador", query = "SELECT t FROM TblAsignacionAutoridades t WHERE t.asignador = :asignador"),
    @NamedQuery(name = "TblAsignacionAutoridades.findByEstadoAsig", query = "SELECT t FROM TblAsignacionAutoridades t WHERE t.estadoAsig = :estadoAsig"),
    @NamedQuery(name = "TblAsignacionAutoridades.findByArchivoRespaldo", query = "SELECT t FROM TblAsignacionAutoridades t WHERE t.archivoRespaldo = :archivoRespaldo"),
    @NamedQuery(name = "TblAsignacionAutoridades.findByComentario", query = "SELECT t FROM TblAsignacionAutoridades t WHERE t.comentario = :comentario")})

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TblAsignacionAutoridades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aut_asignacion")
    @EqualsAndHashCode.Include
    private Integer idAutAsignacion;
    @Column(name = "inf_aut_cod")
    private Integer infAutCod;
    @Column(name = "inst_aut_cod")
    private Integer instAutCod;
    @Column(name = "periodo_asig")
    private Integer periodoAsig;
    @Column(name = "fecha_asig")
    @Temporal(TemporalType.DATE)
    private Date fechaAsig;
    @Size(max = 255)
    @Column(name = "comentario_asig")
    private String comentarioAsig;
    @Size(max = 255)
    @Column(name = "identificador_tecnico")
    private String identificadorTecnico;
    @Size(max = 255)
    @Column(name = "asignador")
    private String asignador;
    @Size(max = 255)
    @Column(name = "estado_asig")
    private String estadoAsig;
    @Size(max = 255)
    @Column(name = "archivo_respaldo")
    private String archivoRespaldo;
    @Size(max = 500)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "id_aut_valoracion", referencedColumnName = "id_aut_valoracion")
    @ManyToOne
    private TblValoracionAutoridades idAutValoracion;

}
