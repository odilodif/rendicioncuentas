package gob.cpccs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gob.cpccs.repository.*;

@Service
public class AsginacionInformesServiceImpl implements AsginacionInformesService{

	@Autowired
	private QuerysNativosRepository QuerysNativosRepository;
	
	public List<Object[]> qryBuscarInformes(String provincia, String periodo ,  String funcion , String descripcion){
		return QuerysNativosRepository.qryBuscarInformesNativo(provincia, periodo,  funcion, descripcion);
	}

	
	public List qryContarInformes(String provincia, String periodo ,  String funcion , String descripcion){
		return QuerysNativosRepository.qryContarInformesNativo(provincia, periodo,  funcion, descripcion);
	}
	
	
	public List qryContarInformesTodosFuncion(String provincia, String periodo , String funciones , String descripcion){
		return QuerysNativosRepository.qryContarInformesNativoTodosFuncion(provincia, periodo,  funciones, descripcion);
	}
	
	public List qryBuscarInformesTodosFuncion(String provincia, String periodo , String funciones , String descripcion){
		return QuerysNativosRepository.qryBuscarInformesNativoTodosFuncion(provincia, periodo,  funciones, descripcion);
	}

	
	@Override
	public List<Object[]> qryBuscarInformesSinDescripcion(String provincia, String periodo, String funcion) {
		return QuerysNativosRepository.qryBuscarInformesNativoSinDescripcion(provincia, periodo,  funcion);
	}
	
	@Override
	public List qryContarInformesSinDescripcion(String provincia, String periodo, String funcion) {
		return QuerysNativosRepository.qryContarInformesNativoSinDescripcion(provincia, periodo,  funcion);
	}
	
	@Override
	public List<Object[]> qryBuscarInformesTodos(String provincia, String periodo) {
		return QuerysNativosRepository.qryBuscarInformesNativoTodos(provincia, periodo);
	}
	
	
	@Override
	public List qryContarInformesTodos(String provincia, String periodo) {
		return QuerysNativosRepository.qryContarInformesNativoTodos(provincia, periodo);
	}


	@Override
	public List<Object[]> qryBuscarInformesAsignadosxtecnico(String tecnico, String periodo, String estadoAsig) {
		
		return QuerysNativosRepository.qryBuscarInformesAsigandosxtecnicoNativo(tecnico, periodo, estadoAsig);
	}
	
	@Override
	public List<Object[]> qryBuscarInformesValoradosSubcoordinador( String periodo, String estadoAsig) {
		
		return QuerysNativosRepository.qryBuscarInformesValoradosSubCoord(periodo, estadoAsig);
	}


	@Override
	public List<Object[]> qryBuscarInformesAsignadosxSubcoordinador(String periodo, String estadoAsig) {
		return QuerysNativosRepository.qryBuscarInformesAsigandosxSubcoordinadorNativo( periodo, estadoAsig);
	}
	
	@Override
	public List<Object[]> qryBuscarInformesValoradosxSubcoordinadorNativo(String periodo, String estadoAsig) {
		return QuerysNativosRepository.qryBuscarInformesValoradosxSubcoordinadorNativo( periodo, estadoAsig);
	}
	}
