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
 * @date 09:38:01
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TblSeguroCampesinoDTO implements Serializable{
	 private static final long serialVersionUID = 1L;

	    private Integer scCod;
	    private String scPresins;
	    private String scConjf;
	    private String scConpat;
	    private String scConest;
	    private String scConsp;
	    private String scPresc;
	    private String scPrese;
	    private String scContraba;
	    private TblInforme infCod;

}
