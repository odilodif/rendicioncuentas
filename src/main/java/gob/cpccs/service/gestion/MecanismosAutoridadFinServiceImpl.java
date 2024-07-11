package gob.cpccs.service.gestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.gestion.TblAmecanismosPcFin;
import gob.cpccs.repository.gestion.MecanicmosPCFinGestionRepository;



@Service
public class MecanismosAutoridadFinServiceImpl implements MecanismosAutoridadFinService {
	@Autowired 
	private MecanicmosPCFinGestionRepository MecanismosAutoridadesFinRepository;
	@Override
	public List<TblAmecanismosPcFin> obtenerRegistrosMecanismosAutoridadesFin(int infAutCod) {
		return MecanismosAutoridadesFinRepository.findByAmeCod(infAutCod);
	}
	@Override
	public void guardarMecanismosAutoridadesFin(TblAmecanismosPcFin tblAmecanismosPc) {
		MecanismosAutoridadesFinRepository.save(tblAmecanismosPc);
		
	}
	@Override
	public TblAmecanismosPcFin obternerMecanismosAutoridadesFin(int infAutCod ,String tipo) {
		return MecanismosAutoridadesFinRepository.findByAmeCodAndNombre(infAutCod, tipo);
		
	}
	@Override
	public Integer CountMPAF(int infAutCod ,String tipo) {
		return MecanismosAutoridadesFinRepository.coutMeCSPAF(infAutCod, tipo);
		
	}
}
