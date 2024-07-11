package gob.cpccs.model.dto.catalogos;

import java.io.Serializable;
//import java.sql.Date;
//import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeguimientoInstitucionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int contador;
	private Integer inst_cod;
	private String inst_nom;
	private String inst_ruc;
	private String funcion;
	private String provincia;
	private String canton;
	private String inst_tip_des;
	private String inst_estado;
	private String inst_fecha_registro;
	private String inst_fecha_activar;
	private String inf_estado;
	private String inf_fechaini;
	private String inf_fechafin;
	private String inf_verificador;
	private String nombrerepresentante;
	private String emailrepresentante;
	private String celularrepresentante;
	private String nombreresponsable;
	private String emailresponsable;
	private String celularresponsable;
	private String nombreregistro;
	private String emailregistro;
	private String celularregistro;
	
	//campos seguimiento 
	private Integer inf_cod;
	private String fecha; 
	private String asigandor; 
	private String asignado;
	private String nota;
	private String informe;
	private String estado;
	private String fechaValo;
	
	
	
}
