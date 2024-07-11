package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblCumplimientoMedios;



public interface CumplimientoMediosService {
	List<TblCumplimientoMedios> obtenerRegistroCumplimientoMedio(int infCod,String cmTipo);
	void guardarCumplimientoMedio(TblCumplimientoMedios TblRegistro);
}
