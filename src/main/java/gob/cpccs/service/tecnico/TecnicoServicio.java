package gob.cpccs.service.tecnico;

import java.util.List;

import gob.cpccs.model.funcionarios.TblDatosFuncionarios;
import gob.cpccs.model.usuario.TblUsuarioLocalizacion;

public interface TecnicoServicio {
	List<TblUsuarioLocalizacion> obtenerLocalizacionXtecnico(String identificador, int periodo, int rolCod);

	TblUsuarioLocalizacion obtenerLocalizacionXtecnicoProvincial(String identificador, int periodo, int rolCod);

	List<TblDatosFuncionarios> obtenerTecnicos(String estado, String Cargo);

	void guardarUsuarioLocalizacion(TblUsuarioLocalizacion tblUsuarioLocalizacion);
	
	void DeleteEstadoTblLocalizacionXidentificador(String identificador,Integer periodo);
	
	List<TblDatosFuncionarios> obtenerTecnicosPorPeriodo(String estado, String Cargo,Integer periodo);
}
