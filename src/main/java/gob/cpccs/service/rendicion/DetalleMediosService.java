package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblComunicacionGestion;
import gob.cpccs.model.rendicion.TblInforme;


public interface DetalleMediosService {
	List<TblComunicacionGestion> obtenerRegistroMedios(int infCod);
	TblComunicacionGestion obtenerRegistro(int cgCod);
	void guardarMediosComunicacion(TblComunicacionGestion Tbltabla);
	TblComunicacionGestion obtenerRegistroMediosNombre(TblInforme tblInforme, String nombre);
	Integer countmedios(Integer infCod, String nombre);
}
