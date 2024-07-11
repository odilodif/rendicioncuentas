package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblSeguroGeneral;
import gob.cpccs.repository.rendicion.SeguroGeneralRepository;
@Service
public class SeguroGeneralServiceImpl implements SeguroGeneralService {

	@Autowired
	private SeguroGeneralRepository SegurGen;
	
	@Override
	public void guardarSEguroGeneral(TblSeguroGeneral tblSeguroGeneral) {
		SegurGen.save(tblSeguroGeneral);
		
	}

	@Override
	public List<TblSeguroGeneral> obtenerRegistrosSEguroGeneralXinfCod(Integer infCod) {
		return SegurGen.findByinfCod(infCod);
	}

}
