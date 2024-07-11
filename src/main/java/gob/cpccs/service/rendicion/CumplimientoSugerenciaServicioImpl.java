package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblCumplimientoSugerenciaCiudadana;
import gob.cpccs.repository.rendicion.CumplimientoSugerenciaRepository;


@Service
public class CumplimientoSugerenciaServicioImpl implements CumplimientoSugerenciaServicio {

	@Autowired
	private CumplimientoSugerenciaRepository sugerenciaRepository;
	
	@Override
	public List<TblCumplimientoSugerenciaCiudadana> obtenerRegistroCumplimientoSugerencia(int infCod) {
		return sugerenciaRepository.findByinfCod(infCod);
	}
	
	@Override
	public void guardarCumplimientoSugerencia(TblCumplimientoSugerenciaCiudadana TblSugerencia){
		sugerenciaRepository.save(TblSugerencia);
	}
}
