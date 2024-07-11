package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblMecanismoParticipacionCiudadana;
import gob.cpccs.repository.rendicion.MecanismoParticipacionRepository;

@Service
public class MecanismoParticipacionServicioImpl implements MecanismoParticipacionServicio {
	
	@Autowired 
	private MecanismoParticipacionRepository mecanismoParticipacion;
	
	@Override
	public void guardarMecanismos(TblMecanismoParticipacionCiudadana tbltabla) {
		mecanismoParticipacion.save(tbltabla);		
	}

	@Override
	public List<TblMecanismoParticipacionCiudadana> obtenerRegistroMecanismosPaticipacion(int instCod) {
		return mecanismoParticipacion.findByinfCod(instCod);
	}
	
	@Override
	public TblMecanismoParticipacionCiudadana obtenerRegistroMecanismosPaticipacionNombre(int infocog, String nombre) {
		return mecanismoParticipacion.findByinfCodTipo(infocog, nombre);
	}
   
	@Override
	public Integer ContarMPC(int infocog, String nombre) {
		return mecanismoParticipacion.coutMPC(infocog, nombre);
	}

}
