package gob.cpccs.model.dto.rendicion;
import java.io.Serializable;

import gob.cpccs.model.rendicion.TblInforme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString
@Getter
@Setter

public class CoberturaGADDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private Integer impleCod;
	private Integer contador;
	private Integer unidades;
	private String cobertura;
	private String nombre;	
	private String provincia;	
	private String funcion;
	private String descripcion;	
	private String estado;
	
}
