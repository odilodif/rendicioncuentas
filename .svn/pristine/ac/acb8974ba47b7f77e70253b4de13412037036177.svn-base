package gob.cpccs.service.gestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.gestion.TblPropuestasFin;
import gob.cpccs.repository.gestion.PropuestasFinRepository;


@Service
public class PropuestaFinAutoridadServiceImpl implements PropuestaFinAutoridadService{
	@Autowired 
	private  PropuestasFinRepository PropuestasFinRepository;
	@Override
	public void guardarPropuestasAutoridadesFin(TblPropuestasFin tblPropuestas) {
		PropuestasFinRepository.save(tblPropuestas);		
	}

	@Override
	public List<TblPropuestasFin> obtenerRegistrosPropuestasAutoridadesFin(int infAutCod) {
		return PropuestasFinRepository.findByProId(infAutCod);
	}
}
