package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblReclamosMedios;

public interface ReclamosMediosService {
	List<TblReclamosMedios> obtenerRegistrosReclamos(int infCod);
	void guardarRegistrosReclamos(TblReclamosMedios TblSugerencia);
}
