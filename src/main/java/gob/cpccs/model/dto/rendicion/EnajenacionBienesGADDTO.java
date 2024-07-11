package gob.cpccs.model.dto.rendicion;
import java.io.Serializable;
import java.math.BigDecimal;

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
public class EnajenacionBienesGADDTO implements Serializable{
	
private static final long serialVersionUID = 1L;

	
	private int contador;
	private Integer enbCod;
	private String tipo;
	private String descripcion;
	private String valor;
	private String link;
	

}
