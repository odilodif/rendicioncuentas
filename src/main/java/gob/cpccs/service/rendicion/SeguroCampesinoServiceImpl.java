package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblSeguroCampesino;
import gob.cpccs.repository.rendicion.SeguroCampesinoRepository;
@Service
public class SeguroCampesinoServiceImpl implements SeguroCampesinoService{
    
	@Autowired
	private SeguroCampesinoRepository SegurCamp;
	
	@Override
	public void guardarSeguroCampesino(TblSeguroCampesino tblSeguroCampesino) {
		SegurCamp.save(tblSeguroCampesino);
		
	}

	@Override
	public List<TblSeguroCampesino> obteberRegistrosSeguroCampesinoXinfCod(Integer infCod) {
		return SegurCamp.findByinfCod(infCod);
	}

}
