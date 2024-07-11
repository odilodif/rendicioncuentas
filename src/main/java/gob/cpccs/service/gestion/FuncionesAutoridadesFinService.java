package gob.cpccs.service.gestion;

import java.util.List;

import gob.cpccs.model.gestion.TblFuncionesAutoridadesFin;

public interface FuncionesAutoridadesFinService {

	void guardarFuncionesAutoridadesFin(TblFuncionesAutoridadesFin tblFuncionesAutoridades);

	List<TblFuncionesAutoridadesFin> obtenerRegistrosFuncionesAutoridadesFin(int infAutCod);

}
