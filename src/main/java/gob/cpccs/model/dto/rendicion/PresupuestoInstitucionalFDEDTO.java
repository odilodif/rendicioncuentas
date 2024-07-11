package gob.cpccs.model.dto.rendicion;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
@ToString
@Builder

public class PresupuestoInstitucionalFDEDTO implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer eprCod;
	private int bandera;
	private int contador;
	private String objetivo;	
	private String tipoCompetencia;
	private String descripcionCompetencian;
	private BigInteger numeroMeta;
	private String meta;
	private String indicadorMeta;
	private String tP;
	private String tC;
	private BigDecimal porcentajeGestion;
	private String descripcionGestion;
	private String aporte;
	
	
	
}