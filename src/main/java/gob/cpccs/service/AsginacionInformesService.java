package gob.cpccs.service;

import java.util.List;

public interface AsginacionInformesService {

	List<Object[]> qryBuscarInformes(String provincia, String periodo, String funcion , String descripcion);
	 
	 List qryContarInformes(String provincia, String periodo, String funcion , String descripcion);

	 List qryContarInformesTodosFuncion(String provincia, String periodo, String funciones , String descripcion);

	 List qryBuscarInformesTodosFuncion(String provincia, String periodo, String funciones , String descripcion);
	 
	 List<Object[]> qryBuscarInformesSinDescripcion(String provincia, String periodo ,  String funcion);
	 
	 List qryContarInformesSinDescripcion(String provincia, String periodo ,  String funcion);

	 List<Object[]> qryBuscarInformesTodos(String provincia, String periodo);

	 List qryContarInformesTodos(String provincia, String periodo);
	 
	 
	 List<Object[]> qryBuscarInformesAsignadosxtecnico(String tecnico, String periodo, String estadoAsig);
	 
	 List<Object[]> qryBuscarInformesValoradosSubcoordinador(String periodo, String estadoAsig);

	List<Object[]> qryBuscarInformesAsignadosxSubcoordinador(String periodo, String estado);
	
	List<Object[]> qryBuscarInformesValoradosxSubcoordinadorNativo(String periodo, String estadoAsig);

}
