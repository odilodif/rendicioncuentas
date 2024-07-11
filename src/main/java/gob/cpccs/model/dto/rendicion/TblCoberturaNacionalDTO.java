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
 * @date 10:49:17
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TblCoberturaNacionalDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private Integer cnCod;
    private String cnCobertura;
    private Integer cnUnidades;
    private String cnTipo;
    private String cnDescripcion;
    private TblInforme infCod;
    private String cnestado;
}
