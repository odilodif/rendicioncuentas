/**
 * 
 */
package gob.cpccs.model.dto.rendicion;

import java.io.Serializable;

import gob.cpccs.model.rendicion.TblInformeAutoridad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Mauricio Rivera
 * @mail mauriciorivera68@hotmail.com
 * @date 15:51:47
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TblPlanTrabajoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private Integer pltCod;
    private int contador;
    private String pltPlan;
    private String ptlAcciones;
    private String ptlResultados;
    private String ptlObs;
    private TblInformeAutoridad infAutCod;
}
