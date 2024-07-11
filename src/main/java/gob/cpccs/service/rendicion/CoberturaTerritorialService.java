package gob.cpccs.service.rendicion;

import java.util.List;


import gob.cpccs.model.rendicion.TblCoberturaInstitucional;
import gob.cpccs.model.rendicion.TblCoberturaNacional;
import gob.cpccs.model.rendicion.TblInforme;

public interface CoberturaTerritorialService {

	
	void guardarCoberturaNacional(TblCoberturaInstitucional tblCoberturaInstitucional);
	List<TblCoberturaInstitucional> obtenerRegistroCoberturaTerritorial(int instCod);
	List<Object[]> OntenerRegistrosImplCoberturaTerritorialXcod(TblInforme tblInforme);
	
	
}
