package gob.cpccs.service.gestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.gestion.TblFuncionesAutoridadesFin;
import gob.cpccs.repository.gestion.FuncionesAutoridadesFinRepository;



@Service
public class FuncionesAutoridadesFinServiceImpl implements FuncionesAutoridadesFinService{
	@Autowired 
	private FuncionesAutoridadesFinRepository FuncionesAutoridadesFinRepository;
	@Override
	public void guardarFuncionesAutoridadesFin(TblFuncionesAutoridadesFin tblFuncionesAutoridades) {
		FuncionesAutoridadesFinRepository.save(tblFuncionesAutoridades);		
	}

	@Override
	public List<TblFuncionesAutoridadesFin> obtenerRegistrosFuncionesAutoridadesFin(int infAutCod) {
		return FuncionesAutoridadesFinRepository.findByFaCod(infAutCod);
	}
}
