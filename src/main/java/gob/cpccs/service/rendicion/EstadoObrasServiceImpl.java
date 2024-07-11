package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblObrasAnteriores;
import gob.cpccs.repository.rendicion.EstadoObrasRepository;


@Service
public class EstadoObrasServiceImpl implements EstadoObrasService {
	@Autowired 
	private EstadoObrasRepository estadoObrasRepository;
	
	@Override
	public void guardarEstadoObras(TblObrasAnteriores Tabla) {
		estadoObrasRepository.save(Tabla);
		
	}
	@Override
	public List<TblObrasAnteriores> obtenerRegistroEstadoObras(int infCod) {
		return estadoObrasRepository.findByinfCod(infCod);
	}

}
