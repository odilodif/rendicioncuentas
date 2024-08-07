package gob.cpccs.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import gob.cpccs.model.funcionarios.TblDatosFuncionarios;

@Repository
public interface QuerysNativosRepository {

	List<Object[]> ObtenerInformeXIdentificador(String estado, Integer periodo, String identificador);

	 List contarEstadoProcesoInformesXprovincia(int infPeriodo, String infVerificador, int prov_cod);
	 	 
	 List contarEstadosProcesoInformesAutoridadesxProvincia(int infAutPeriodo, String infAutVerificador, int provincia);
	 
	 List<Object[]> ObtenerAutoridadesCumplimineto(String autVerificador, Integer periodo);
	 
	 List<Object[]> ObtenerAutoridadesCumpliminetoProvincia(String autVerificador, Integer periodo,  Integer provincia);
	
	 List<Object[]> ObtenerAutoridadesInCumplimineto(String autVerificador, Integer periodo);

	 List<Object[]> ObtenerAutoridadesInCumpliminetoProvincia(String autVerificador, Integer periodo, Integer provincia);

	 List<Object[]> qryBuscarInformesNativo(String provincia, String periodo , String funcion , String descripcion);

	 List<Object[]> qryContarInformesNativo(String provincia, String periodo , String funcion , String descripcion);

	 List<Object[]> qryContarInformesNativoTodosFuncion(String provincia, String periodo , String funciones , String descripcion);
	 
	 List<Object[]> qryBuscarInformesNativoTodosFuncion(String provincia, String periodo , String funciones , String descripcion);

	 List<Object[]> qryBuscarInformesNativoSinDescripcion(String provincia, String periodo , String funcion );

	 List<Object[]> qryContarInformesNativoSinDescripcion(String provincia, String periodo , String funcion );

	 List<Object[]> qryBuscarInformesNativoTodos(String provincia, String periodo );
	 
	 List<Object[]> qryContarInformesNativoTodos(String provincia, String periodo );

	 List numeroInstitucionesActivas(int instPeriodo, String instEstado);
	 
	 List<Object[]> qryBuscarInformesAsigandosxtecnicoNativo(String tecnico, String periodo, String estadoAsig );
	 
	 List<Object[]> qryBuscarInformesValoradosSubCoord(String periodo, String estadoAsig );

	 List<Object[]> ObtenerInstitucionxInforme(int infcod ,int periodo);
	 
	 List<Object[]> ObtenerInstitucionxInformeMedio(int infcod ,int periodo);

	 List<Object[]> ObtenerInstitucionxInformeES(int infcod ,int periodo);

	 List<Object[]> qryObtenerRegistrosInformesValoradosXInfocodAndPeriodo(Integer infCod);
	 
	 List<Object[]> qryObtenerRegistrosInformesValorados();
	 
	 List<Object[]> qryBuscarCalificacionesInformeUltimo(Integer infcod);
	 List<Object[]> qryBuscarCalificacionesInformeOrden(Integer infcod);

	List<Object[]> qryBuscarInformesAsigandosxSubcoordinadorNativo(String periodo, String estadoAsig);

	List<Object[]> qryBuscarInformesValoradosxSubcoordinadorNativo(String periodo, String estadoAsig);
}
