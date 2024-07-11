package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblAmecanismosPc;
import gob.cpccs.repository.rendicion.MecanismosAutoridadesRepository;

@Service
public class MecanismosAutoridadesServiceImpl implements MecanismosAutoridadesService{

	@Autowired 
	private MecanismosAutoridadesRepository MecanismosAutoridadesRepository;
	
	@Override
	public void guardarMecanismosAutoridades(TblAmecanismosPc tblAmecanismosPc) {
		MecanismosAutoridadesRepository.save(tblAmecanismosPc);
		
	}

	@Override
	public List<TblAmecanismosPc> obtenerRegistrosMecanismosAutoridades(int infAutCod) {
		return MecanismosAutoridadesRepository.findByAmeCod(infAutCod);
	}
	

}
