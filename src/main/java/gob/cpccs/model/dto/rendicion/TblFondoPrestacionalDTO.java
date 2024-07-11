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
 * @date 08:55:06
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TblFondoPrestacionalDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
    private Integer fpCod;
    private String fpDesc;
    private String fpPresins;
    private String fpGastcp;
    private String fpGastce;
    private String fpGastip;
    private String fpGastie;
    private TblInforme infCod;
}
