package gob.cpccs.model.dto.catalogos;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CatastroDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer inst_cod;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date fecha;	
	private int contador;
	private String accion;
	private String archivo;
	private String ruc;
	private String provincia;
	private String nombre;
	private String estado;
	private String funcion;

}
