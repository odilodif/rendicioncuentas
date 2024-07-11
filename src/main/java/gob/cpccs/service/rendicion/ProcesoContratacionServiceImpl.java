package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblProcesosContratacion;
import gob.cpccs.repository.rendicion.ProcesoContratacionRepository;


@Service
public class ProcesoContratacionServiceImpl implements ProcesoContratacionService {
	@Autowired 
	private ProcesoContratacionRepository ProcesoRepository;
	
	@Override
	public void guardarContratacion(TblProcesosContratacion Tabla) {
		ProcesoRepository.save(Tabla);
		
	}
	@Override
	public List<TblProcesosContratacion> obtenerRegistroContratacion(int infCod) {
		return ProcesoRepository.findByinfCod(infCod);
	}
}
