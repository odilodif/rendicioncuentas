package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblPropuestas;

public interface PropuestasAutoridadesService {
	void guardarPropuestasAutoridades(TblPropuestas tblPropuestas);
	List<TblPropuestas> obtenerRegistrosPropuestasAutoridades(int infAutCod);
}
