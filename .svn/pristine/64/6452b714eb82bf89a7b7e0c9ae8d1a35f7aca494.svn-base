package gob.cpccs.model.retroalimentacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
@Table(name = "tbl_valoracion_autoridades")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "TblValoracionAutoridades.findAll", query = "SELECT t FROM TblValoracionAutoridades t"),
		@NamedQuery(name = "TblValoracionAutoridades.findByIdAutValoracion", query = "SELECT t FROM TblValoracionAutoridades t WHERE t.idAutValoracion = :idAutValoracion"),
		@NamedQuery(name = "TblValoracionAutoridades.findByInstiCod", query = "SELECT t FROM TblValoracionAutoridades t WHERE t.instiCod = :instiCod"),
		@NamedQuery(name = "TblValoracionAutoridades.findByPeriodo", query = "SELECT t FROM TblValoracionAutoridades t WHERE t.periodo = :periodo"),
		@NamedQuery(name = "TblValoracionAutoridades.findByInfAutCod", query = "SELECT t FROM TblValoracionAutoridades t WHERE t.infAutCod = :infAutCod"),
		@NamedQuery(name = "TblValoracionAutoridades.findByNota", query = "SELECT t FROM TblValoracionAutoridades t WHERE t.nota = :nota"),
		@NamedQuery(name = "TblValoracionAutoridades.findByIdentificador", query = "SELECT t FROM TblValoracionAutoridades t WHERE t.identificador = :identificador"),
		@NamedQuery(name = "TblValoracionAutoridades.findByTipoValoracion", query = "SELECT t FROM TblValoracionAutoridades t WHERE t.tipoValoracion = :tipoValoracion"),
		@NamedQuery(name = "TblValoracionAutoridades.findByFechaValoracion", query = "SELECT t FROM TblValoracionAutoridades t WHERE t.fechaValoracion = :fechaValoracion"),
		@NamedQuery(name = "TblValoracionAutoridades.findByComentario", query = "SELECT t FROM TblValoracionAutoridades t WHERE t.comentario = :comentario"),
		@NamedQuery(name = "TblValoracionAutoridades.findByVerificador", query = "SELECT t FROM TblValoracionAutoridades t WHERE t.verificador = :verificador") })

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TblValoracionAutoridades implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_aut_valoracion")
	@EqualsAndHashCode.Include
	private Integer idAutValoracion;
	@Column(name = "insti_cod")
	private Integer instiCod;
	@Column(name = "periodo")
	private Integer periodo;
	@Column(name = "inf_aut_cod")
	private Integer infAutCod;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "nota")
	private Float nota;
	@Size(max = 10)
	@Column(name = "identificador")
	private String identificador;
	@Size(max = 50)
	@Column(name = "tipo_valoracion")
	private String tipoValoracion;
	@Column(name = "fecha_valoracion")
	@Temporal(TemporalType.DATE)
	private Date fechaValoracion;
	@Size(max = 500)
	@Column(name = "comentario")
	private String comentario;
	@Size(max = 15)
	@Column(name = "verificador")
	private String verificador;
	@OneToMany(mappedBy = "idAutValoracion")
	@XmlTransient
	@Builder.Default
	private List<TblAsignacionAutoridades> tblAsignacionAutoridadesList = new ArrayList<>();

}
