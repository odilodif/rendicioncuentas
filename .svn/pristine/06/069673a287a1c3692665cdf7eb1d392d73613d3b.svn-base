/**
 * 
 */
package gob.cpccs.model.dto.catalogos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import gob.cpccs.model.catalogos.TblFuncion;
import gob.cpccs.model.catalogos.TblSector;
import gob.cpccs.model.catalogos.TblTipoIes;
import gob.cpccs.model.catalogos.TblTipoInforme;
import gob.cpccs.model.catalogos.TblTipoMedio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Mauricio Rivera
 * @mail mauriciorivera68@hotmail.com
 * @date 12:50:53
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class IntitucionDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
    private Integer instCod;
    private String instRuc;
    private String instNom;
    private Integer provCod;
    private Integer cantCod;
    private Integer parroCod;
    private String instDir;
    private String instTel;
    private String instEma;
    private String instPag;
    private String instTipDes;
    private String instDesUdaf;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date instFechaCreacion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date instFechaRegistro;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date instFechaActivar;
    private String instVerificador;
    private String instEstado;
    private int instPeriodo;
    private String instRucDoc;
    private TblFuncion instFunCod;
    private TblSector instSecCod;
    private TblTipoInforme instTfCod;
    private TblTipoMedio instTmeCod;
    private TblTipoIes tiesCod;
    
    private Integer id_user;
    private Integer contador;
    private String intitucion;
    private String nombres;
    private String email;
    private String cedula;
    private String pregunta1;
    private String pregunta2;
    private String nomInsti;
    //para listar los informes que tiene una isntitucion en su retroalimentacion
    private int codigo;
    private String periodo;
		
    
    public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
}
