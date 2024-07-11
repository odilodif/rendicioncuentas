package gob.cpccs.model.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.repository.rendicion.ObligacionesEducacionRepository;
import gob.cpccs.service.rendicion.ObligacionesEducacionService;
@Service
public class ObligacionesEducacionServiceImpl implements ObligacionesEducacionService   {

	
	@Autowired
	private ObligacionesEducacionRepository ObligacionesEducacionRepository;
	@Override 
	public void guardarObligacionesEducacion(TblObligacionesEducacion tblObligacionesEducacion) {
		ObligacionesEducacionRepository.save(tblObligacionesEducacion);
		
	}

	@Override
	public List<TblObligacionesEducacion> ObtenerObligacionesEducacionxInforme(Integer infCod) {
		return ObligacionesEducacionRepository.findByinfCod(infCod);
	}

}
