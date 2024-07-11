package gob.cpccs.model.dto.rendicion;
import java.io.Serializable;
import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
public class ReporteAvanceGADDTO implements Serializable {
	
	
	private Integer pdCod;
	private int contador;
	private String objCod;	
	private String pdPorcAvanceAcum;
	private String pdRazon;
	
	
}
