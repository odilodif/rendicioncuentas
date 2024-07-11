package gob.cpccs.model.dto.rendicion;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TblFinGestionDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gestion", nullable = false)
	private Integer idGestion;
	@Column(name = "inf_aut_cod")
	private Integer infAutCod;
	@Column(name = "fecha_inicio")
	private String FechaInicio;
	@Column(name = "fecha_fin")
	private String FechaFin;
	@Column(name = "estado", length = 15)
	private String estado;
	@Column(name = "identificador", length = 15)
	private String Identificador;
	private String cedula;
	private String nombre;
	private String dignidad;
}
