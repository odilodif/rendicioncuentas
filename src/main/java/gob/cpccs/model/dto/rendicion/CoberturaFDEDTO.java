package gob.cpccs.model.dto.rendicion;
import java.io.Serializable;
import java.math.BigDecimal;

import gob.cpccs.utilidades.Constantes;
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
public class CoberturaFDEDTO implements Serializable {
private static final long serialVersionUID = 1L;
	
	private Integer cn_cod;
	private int contador;
	private String cobertura;
	private Integer unidades;
	private String descripcion;
	//Cobertura Geografica
	
	private Integer cg_cod;
	private String nivel;
    private Integer  numeroatencion ;
    private Integer  numerousuarios;
    private Integer  hombre;
    private Integer  mujer;
    private Integer  glbti;
    private Integer  montubios;
    private Integer  cholos;
    private Integer  indigenas;
    private Integer  mestizos;
    private Integer  afroecuatorianos;
	private String  link;

}