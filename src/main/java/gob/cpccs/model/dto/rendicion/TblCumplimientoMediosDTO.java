/**
 * 
 */
package gob.cpccs.model.dto.rendicion;

import java.io.Serializable;
import java.math.BigDecimal;


import gob.cpccs.model.rendicion.TblInforme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Mauricio Rivera
 * @mail mauriciorivera68@hotmail.com
 * @date 11:06:43
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TblCumplimientoMediosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	   	private Integer cmCod;
	    private String cmValidaProyecto;
	    private String cmDescParametro;
	    private String cmOpciones;
	    private String cmNomPrograma;
	    private String cmFrecuencia;
	    private String cmDescProgramacion;
	    private BigDecimal cmPorcDifusion;
	    private String cmLink;
	    private String cmTipo;
	    private TblInforme infCod;
}
