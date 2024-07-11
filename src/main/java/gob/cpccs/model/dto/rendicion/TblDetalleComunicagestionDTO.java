/**
 * 
 */
package gob.cpccs.model.dto.rendicion;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import gob.cpccs.model.rendicion.TblComunicacionGestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Mauricio Rivera
 * @mail mauriciorivera68@hotmail.com
 * @date 11:46:10
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TblDetalleComunicagestionDTO implements Serializable {
	
    private static final long serialVersionUID = 1L;   
    private int contador;
    private Integer cgCod2;
    private String dcNombre;
    private String radios;
    private String minutos;
    private BigDecimal dcMonto;
    private String valor;
    private String dcMinutos;
    private TblComunicacionGestion cgCod;

}
