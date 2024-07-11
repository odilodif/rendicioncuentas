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
 * @date 12:25:29
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TblProduccionAudiovisualDTO implements Serializable {
	private static final long serialVersionUID = 1L;
    private Integer paCod;
    private String paTipo;
    private String paContenido;
    private BigDecimal paPorcentaje;
    private String paPeriocidad;
    private String paMedio;
    private BigDecimal paPorcProduccion;
    private String paNomPrograma;
    private TblInforme infCod;
}
