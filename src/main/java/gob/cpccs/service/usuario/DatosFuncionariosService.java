package gob.cpccs.service.usuario;

import java.util.List;

import gob.cpccs.model.funcionarios.TblDatosFuncionarios;

public interface DatosFuncionariosService {

	void guardarDatasFuncionarios(TblDatosFuncionarios tblDatosFuncionarios);

	List<TblDatosFuncionarios> obtenerFuncionarioXCargo(String estadoEmpleado, String cargo);

	TblDatosFuncionarios obtenerSubcoordinadorXEstadoXCargo(String estadoEmpleado, String cargo);

	List<TblDatosFuncionarios> obtenerFuncionarios(String estadoEmpleado);

	TblDatosFuncionarios ObtenerDatodFuncionarioXCod(Integer idDatoFuncionario);

	TblDatosFuncionarios ObtenerDatodFuncionarioXidentificador(String identificador);
	
	List<TblDatosFuncionarios> ListaFuncionariosXCodigo(Integer idDatoFuncionario);

}
