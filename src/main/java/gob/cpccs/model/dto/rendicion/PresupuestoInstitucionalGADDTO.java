package gob.cpccs.model.dto.rendicion;
import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
public class PresupuestoInstitucionalGADDTO implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer depCodigo;
	private int contador;
	private String depTipo;	
	private String depDescripcion;
	private String depPresplan;
	private String depPresejec;
	private String depCumple;
	private String depLink;
	
	//PRESUPUESTO INSTITUCIONAL
	
	private Integer preInsti;
	private String infPresupuesto;
	private String infGastplan;
	private String infGastejec;
	private String infGastinvplan;
	private String inf_gastinvejec;
	private String infPorcetejecpres;
	

}
