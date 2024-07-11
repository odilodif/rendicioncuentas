package gob.cpccs.model.dto.rendicion;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
@Getter
@Setter
@Builder
@ToString

public class PresupuestoParticipativoGADDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int contador;
	private Integer presCod;
	private String infTotalpres;
	private String  infPresparticipativo;
	private String  infPorprespar;
	private String infLinkpres;
	
	//FASES DEL PRESUPUESTO
	private Integer faseCod;
	private String faseOpcion;
	private String faseNombre;
	private String faseActor;
	private String faseGrupo;
	private String faseLink;
	
	//ANTEPROYECTO
	//Tabla 1 y Tabla 3
	private Integer anteCod;
	private String anteNom;
	private String anteOpc;
	private String anteDescrip;
	
	//Tabla2
	private String anteFecha;
	
	//DETALLE DEL PRESUPUESTO
	private Integer proyCod;
	private String proyDescripcion;
	private String proyMontoplan;
	private String proyMontoejec;
	private String proyPorcAvance;
	private String proyObs;
	private String proyLinks;
	
	
	
	
	
	
	

}
