package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblPropuestas;
import gob.cpccs.repository.rendicion.PropuestasAutoridadesRepository;

@Service
public class PropuestasAutoridadesServiceImpl implements PropuestasAutoridadesService {

	@Autowired 
	private  PropuestasAutoridadesRepository PropuestasAutoridadesRepository;
	
	@Override
	public void guardarPropuestasAutoridades(TblPropuestas tblPropuestas) {
		PropuestasAutoridadesRepository.save(tblPropuestas);		
	}

	@Override
	public List<TblPropuestas> obtenerRegistrosPropuestasAutoridades(int infAutCod) {
		return PropuestasAutoridadesRepository.findByProId(infAutCod);
	}

}
