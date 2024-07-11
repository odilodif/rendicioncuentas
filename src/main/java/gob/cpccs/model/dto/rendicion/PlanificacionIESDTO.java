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
public class PlanificacionIESDTO implements Serializable {
private static final long serialVersionUID = 1L;
	
	private Integer app_cod;
	private int contador;
	private String nombre;
	private String valida;
	private String link;
	

}
