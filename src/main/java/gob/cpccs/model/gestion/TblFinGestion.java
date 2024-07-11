package gob.cpccs.model.gestion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_fin_gestion", catalog = "rendiciondb", schema = "esq_gestion")
@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TblFinGestion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gestion", nullable = false)
	private Integer idGestion;
	@Column(name = "fecha_inicio")
	@Temporal(TemporalType.TIMESTAMP)
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date FechaInicio;
	@Column(name = "fecha_fin")
	@Temporal(TemporalType.TIMESTAMP)
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date FechaFin;
	@Column(name = "estado", length = 15)
	private String estado;
	@Column(name = "identificador", length = 15)
	private String Identificador;
	 @JoinColumn(name = "inf_aut_cod", referencedColumnName = "inf_aut_cod")
	    @ManyToOne
	    private TblInformeAutoridadFin infAutCod;
}
