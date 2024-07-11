package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblInformacionFinanciera;
import gob.cpccs.repository.rendicion.InformacionFinancieraRepository;

@Service
public class InformacionFinancieraServiceImpl implements InformacionFinancieraService {
	@Autowired 
	private InformacionFinancieraRepository InformacionRepository;
	
	@Override
	public void guardarInformacionFinanciera(TblInformacionFinanciera Tabla) {
		InformacionRepository.save(Tabla);
		
	}
	@Override
	public List<TblInformacionFinanciera> obtenerRegistroInfromacionFinanciera(int infCod) {
		return InformacionRepository.findByinfCod(infCod);
	}

}
