package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblFinanciamiento;

public interface FinanciamientoService {
	void guardarFinanciamiento(TblFinanciamiento tbltabla);
	List<TblFinanciamiento> obtenerRegistroFinanciamiento(int infCod);
}
