package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblSugerenciaCiudadana;
import gob.cpccs.repository.rendicion.SugerenciaCiudadanaRepository;

@Service
public class SugerenciaCiudadanaServiceImpl implements SugerenciaCiudadanaService {
 
	@Autowired
	private SugerenciaCiudadanaRepository sugerenciaRepository;
	
	@Override
	public List<TblSugerenciaCiudadana> obtenerRegistroDatosSugerencia(int infCod) {
		return sugerenciaRepository.findByinfCod(infCod);
	}
	
	@Override
	public void guardarSugerencia(TblSugerenciaCiudadana TblSugerencia){
		sugerenciaRepository.save(TblSugerencia);
	}
}
