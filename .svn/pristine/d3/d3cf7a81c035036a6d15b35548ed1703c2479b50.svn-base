package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblCoberturaInstitucional;
import gob.cpccs.model.rendicion.TblCoberturaNacional;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.repository.rendicion.CoberturaTerritorialRepository;

@Service
public class CoberturaTerritorialServicesImpl implements CoberturaTerritorialService{
	@Autowired 
	private CoberturaTerritorialRepository  CoberturaTerritorialRepository;
	
	@Override
	public void guardarCoberturaNacional(TblCoberturaInstitucional tblCoberturaInstitucional) {
		CoberturaTerritorialRepository.save(tblCoberturaInstitucional);		
	}

	@Override
	public List<TblCoberturaInstitucional> obtenerRegistroCoberturaTerritorial(int instCod) {
		return CoberturaTerritorialRepository.findByinfCod(instCod);
	}
	
	@Override
	public List<Object[]> OntenerRegistrosImplCoberturaTerritorialXcod(TblInforme tblInforme) {
		return CoberturaTerritorialRepository.buscarImpleCoberturaTerritorial(tblInforme);
	}
	
}
