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
 * @date 09:24:39
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TblSeguroGeneralDTO implements Serializable {
	private static final long serialVersionUID = 1L;
    private Integer sgCod;
    private String sgPresin;
    private String sgAposr;
    private String sgApopp;
    private String sgIngfr;
    private String sgUtilinv;
    private String sgJubil;
    private String sgPcod;
    private String sgPejec;
    private TblInforme infCod;

}
