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
 * @date 08:46:25
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TblAmecanismosPcDTO implements Serializable{
	
    private static final long serialVersionUID = 1L;
    private Integer ameCod;
    private String ameDesc;
    private String ameMedio;
    private String ameTipo;
    private TblInformeAutoridad infAutCod;

    
    private Integer ame_cod;
    private int contador;
    private String tipo;
    private String descripcion;
    private String medio;
}
