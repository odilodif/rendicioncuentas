package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblInformacionFinanciera;

public interface InformacionFinancieraService {
	List<TblInformacionFinanciera>	obtenerRegistroInfromacionFinanciera(int infCod);
	void guardarInformacionFinanciera(TblInformacionFinanciera tblInformeAutoridad);
}
