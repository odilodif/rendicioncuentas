/**
 * 
 */
package gob.cpccs.model.dto.rendicion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import gob.cpccs.model.rendicion.TblInforme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mauricio Rivera
 * @mail mauriciorivera68@hotmail.com
 * @date 16:45:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TblProyectoComunicacionalDTO implements Serializable {
	private static final long serialVersionUID = 1L;
    private Integer proCodigo;
    private String proNombre;
    private String proOpcion;
    private String proEstado;
    private TblInforme infCod;

}
