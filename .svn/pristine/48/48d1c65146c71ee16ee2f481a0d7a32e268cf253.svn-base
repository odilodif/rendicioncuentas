package gob.cpccs.service.rendicion;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblNegarAutoridad;
import gob.cpccs.model.rendicion.TblObservacionesNegar;
import gob.cpccs.repository.rendicion.ObservacionesRepository;
import gob.cpccs.repository.rendicion.TblNegarAutoridadRepository;


@Service
public class ServicioObsevacionImpl implements ServicioObservacion{
	 @Autowired
	 ObservacionesRepository observacion;
	 @Autowired
	 TblNegarAutoridadRepository observacionAutoridad;
	@Override
	public void guardarObservacioNegar(TblObservacionesNegar tblObservaciones) {
		observacion.save(tblObservaciones);
		
	}
	@Override
	public void guardarObservacioNegarAutoridad(TblNegarAutoridad tblNegarAuto) {
		observacionAutoridad.save(tblNegarAuto);
		
	}
	
}
