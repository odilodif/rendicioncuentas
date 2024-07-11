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
public class PlanificacionParticipativaIESDTO implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private Integer pla_cod;
	private int contador;
	private String planificacion;
	private String seleccion;
	private String link;
	
}
