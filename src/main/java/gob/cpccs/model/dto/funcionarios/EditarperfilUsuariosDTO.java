package gob.cpccs.model.dto.funcionarios;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditarperfilUsuariosDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String nombre;
	private String tipo;
	private String categoria;
	//Intitucion
	private String email;
	private String telefono;
	private String paginaWeb;

}
