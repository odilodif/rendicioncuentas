package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gob.cpccs.repository.rendicion.CoberturaNacionalRepository;
import gob.cpccs.model.rendicion.TblCoberturaNacional;
import gob.cpccs.model.rendicion.TblInforme;

@Service
public class CoberturaNacionalServiceImpl implements CoberturaNacionalService{

	@Autowired 
	private CoberturaNacionalRepository CoberturaNacionalRepository;
	
	@Override
	public void guardarCoberturaNacional(TblCoberturaNacional tblCoberturaNacional) {
		CoberturaNacionalRepository.save(tblCoberturaNacional);		
	}

	@Override
	public List<TblCoberturaNacional> obtenerRegistroCoberturaNacional(int instCod) {
		return CoberturaNacionalRepository.findByinfCod(instCod);
	}
	
	@Override
	public List<Object[]> OntenerRegistrosImplCoberturaNacionalXcod(TblInforme tblInforme) {
		return CoberturaNacionalRepository.buscarImpleCobertura(tblInforme);
	}

	@Override
	public List<TblCoberturaNacional> obtenerRegistroCoberturaNacionalXInfCodAndTipo(Integer infCod, String cnTipo) {
		return CoberturaNacionalRepository.findByinfCodAndCnTipo(infCod, cnTipo);
	}
	
}
