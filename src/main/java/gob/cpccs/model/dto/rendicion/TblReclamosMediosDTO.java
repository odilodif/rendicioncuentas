/**
 * 
 */
package gob.cpccs.model.dto.rendicion;

import java.io.Serializable;

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
 * @date 12:07:52
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TblReclamosMediosDTO implements Serializable{
	private static final long serialVersionUID = 1L;
    private Integer rmCod;
    private String rmPresentado;
    private Integer rmNreclamos;
    private Integer rmNproceso;
    private String rmLink;
    private Integer rmNreclamofavorable;
    private Integer rmNreclamodesfavorable;
    private String rmTipoReclamo;
    private TblInforme infCod;

}
