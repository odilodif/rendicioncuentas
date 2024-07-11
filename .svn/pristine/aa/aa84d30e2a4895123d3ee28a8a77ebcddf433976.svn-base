package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblCumplimientoObligaciones;
import gob.cpccs.repository.rendicion.CumplimientoObligacionesRepository;

@Service
public class CumplimientoObligacionesServicioImpl implements CumplimientoObligacionesServicio {

	@Autowired
    private CumplimientoObligacionesRepository cumplimientoObligaciones;
	
	@Override
	public List<TblCumplimientoObligaciones> obtenerRegistroCumplimientoObligaciones(int infCod) {
		return cumplimientoObligaciones.findByinfCod(infCod);
	}
	
	@Override
	public void guardarCumplimientoObligaciones(TblCumplimientoObligaciones TblSugerencia){
		cumplimientoObligaciones.save(TblSugerencia);
	}

}
