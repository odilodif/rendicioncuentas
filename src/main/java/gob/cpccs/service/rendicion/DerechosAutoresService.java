package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblDerechosAutor;

public interface DerechosAutoresService {

	List<TblDerechosAutor> obtenerRegistroDerechosMedio(int infCod);
	void guardarCumplimientoDerechosMedio(TblDerechosAutor TblRegistro);
}
