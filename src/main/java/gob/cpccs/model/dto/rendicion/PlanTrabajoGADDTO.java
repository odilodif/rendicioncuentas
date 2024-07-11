package gob.cpccs.model.dto.rendicion;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import gob.cpccs.model.rendicion.TblInforme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
public class PlanTrabajoGADDTO implements Serializable {
	
	private Integer PtgCod;
	private int contador;
	private String Objetivo;	
	private String Programa;
	private BigDecimal PorcAvance;
	private String Resultados;
	
}
