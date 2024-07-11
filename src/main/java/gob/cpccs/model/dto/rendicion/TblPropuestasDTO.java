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
 * @date 08:58:17
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TblPropuestasDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer proId;
    private String proDescripcion;
    private String proResultados;
    private TblInformeAutoridad infAutCod;
    
    private Integer pro_id;
    private int contador;
    private String descripcion;
    private String resultado;

}
