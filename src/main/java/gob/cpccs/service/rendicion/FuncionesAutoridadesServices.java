package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblFuncionesAutoridades;

public interface FuncionesAutoridadesServices {
	void guardarFuncionesAutoridades(TblFuncionesAutoridades tblFuncionesAutoridades);
	List<TblFuncionesAutoridades> obtenerRegistrosFuncionesAutoridades(int infAutCod);
}
