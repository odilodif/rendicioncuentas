package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblEnajenacionBienes;
import gob.cpccs.repository.rendicion.EnagenacionRepository;

@Service
public class EnajenacionServiceImpl implements EnajenacionService {

	@Autowired 
	private EnagenacionRepository enagenacionRepository;
	
	@Override
	public void guardarenagenacion(TblEnajenacionBienes Tabla) {
		enagenacionRepository.save(Tabla);
		
	}
	@Override
	public List<TblEnajenacionBienes> obtenerRegistroEnagenacion(int infCod) {
		return enagenacionRepository.findByinfCod(infCod);
	}
	
}
