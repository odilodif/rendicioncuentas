package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblFinanciamiento;
import gob.cpccs.repository.rendicion.FinanciamientoRepository;

@Service
public class FinanciamientoServiceImpl implements FinanciamientoService{
	@Autowired 
	private FinanciamientoRepository estadoObrasRepository;
	
	@Override
	public void guardarFinanciamiento(TblFinanciamiento Tabla) {
		estadoObrasRepository.save(Tabla);
		
	}
	@Override
	public List<TblFinanciamiento> obtenerRegistroFinanciamiento(int infCod) {
		return estadoObrasRepository.findByinfCod(infCod);
	}
}
