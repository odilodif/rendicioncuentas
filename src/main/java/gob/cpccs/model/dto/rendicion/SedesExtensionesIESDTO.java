package gob.cpccs.model.dto.rendicion;

import java.io.Serializable;

import gob.cpccs.utilidades.Constantes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
@Getter
@Setter
public class SedesExtensionesIESDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer se_cod;
	private int contador;
	private String nombreSede;
	private String nroSedes;
	private String cobertura;
	private String estudiantes;
	private String hombre;
	private String mujer;
	private String glbti;
	private String montubio;
	private String mestizo;
	private String cholo;
	private String indigena;
	private String afro;
	private String extranjero;
	private String discapacitado;
	private String link ;
	private String provincia;
	private String canton;
	private String parroquia;
	private String direccion;
	private String paginaWeb;
	private String ruc;
	
	//SedeDetalle
	
	private String nombreSed;
	private String representanteLegal;
	private String cargo;
	private String fecha;
	private String correo;
	private String telefono;
	
}
