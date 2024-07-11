package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblObrasAnteriores;


public interface EstadoObrasService {
	void guardarEstadoObras(TblObrasAnteriores tbltabla);
	List<TblObrasAnteriores> obtenerRegistroEstadoObras(int infCod);
}
