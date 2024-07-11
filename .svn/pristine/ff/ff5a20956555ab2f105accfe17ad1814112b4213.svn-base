package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblFondoPrestacional;
import gob.cpccs.repository.rendicion.FondoPrestacionalRepository;
@Service
public class FondoPrestacionalServiceImpl implements FondoPrestacionalService {
  
	@Autowired
	private FondoPrestacionalRepository FondoPrestacional;
	
    @Override
	public void guardarFondoPrestacional(TblFondoPrestacional tblFondoPrestacional) {
		FondoPrestacional.save(tblFondoPrestacional);
	}

	@Override
	public List<TblFondoPrestacional> obtenerRegistrosFondoPrestacionalXInfCod(Integer infCod) {
		return FondoPrestacional.findByinfCod(infCod);
	}

}
