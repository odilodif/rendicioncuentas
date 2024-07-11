package gob.cpccs.model.dto.rendicion;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
@Getter
@Setter
public class PoliticasIgualdadIESDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer pi_cod;
	private int contador;
	private String politica;
	private String seleccion;
	private String descripcion;
	private String detalle;
	private String explique;
	
	
}
