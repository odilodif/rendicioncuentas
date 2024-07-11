package gob.cpccs.service.gestion;

import java.util.List;

import gob.cpccs.model.gestion.TblAmecanismosPcFin;

public interface MecanismosAutoridadFinService {

	List<TblAmecanismosPcFin> obtenerRegistrosMecanismosAutoridadesFin(int infAutCod);

	void guardarMecanismosAutoridadesFin(TblAmecanismosPcFin tblAmecanismosPc);

	TblAmecanismosPcFin obternerMecanismosAutoridadesFin(int infAutCod, String tipo);

	Integer CountMPAF(int infAutCod, String tipo);

}
