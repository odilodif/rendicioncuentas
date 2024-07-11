package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblCumplimientoSugerenciaCiudadana;



public interface CumplimientoSugerenciaServicio {
	List<TblCumplimientoSugerenciaCiudadana> obtenerRegistroCumplimientoSugerencia(int infCod);
	void guardarCumplimientoSugerencia(TblCumplimientoSugerenciaCiudadana TblSugerencia);
}
