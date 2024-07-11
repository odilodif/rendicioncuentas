package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblDatosMedio;
import gob.cpccs.repository.rendicion.DatosMediosRepository;



@Service
public class DatosMediosServiceImpl implements DatosMediosService {
	
	@Autowired 
	 private DatosMediosRepository datosmedio;
	
	@Override
	public void guardarDatosMedios(TblDatosMedio Tabla) {
		datosmedio.save(Tabla);
		
	}
	@Override
	public List<TblDatosMedio> obtenerRegistroDatosmedios(int infCod) {
		return datosmedio.findByinfCod(infCod);
	}
}
