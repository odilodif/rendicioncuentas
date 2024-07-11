package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblFuncionesAutoridades;
import gob.cpccs.repository.rendicion.FuncionesAutoridadesRepository;

@Service
public class FuncionesAutoridadesServicesImpl  implements FuncionesAutoridadesServices {
	
	@Autowired 
	private FuncionesAutoridadesRepository FuncionesAutoridadesRepository;
	
	@Override
	public void guardarFuncionesAutoridades(TblFuncionesAutoridades tblFuncionesAutoridades) {
		FuncionesAutoridadesRepository.save(tblFuncionesAutoridades);		
	}

	@Override
	public List<TblFuncionesAutoridades> obtenerRegistrosFuncionesAutoridades(int infAutCod) {
		return FuncionesAutoridadesRepository.findByFaCod(infAutCod);
	}

}
