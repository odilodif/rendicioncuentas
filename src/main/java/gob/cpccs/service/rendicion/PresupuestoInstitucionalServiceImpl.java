package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gob.cpccs.repository.rendicion.PresupuestoInstitucionalRepository;
import gob.cpccs.model.rendicion.TblParticipacionCiudadana;
import gob.cpccs.model.rendicion.TblPresupuestoInstitucional;

@Service
public class PresupuestoInstitucionalServiceImpl implements PresupuestoInstitucionService {

	@Autowired 
	PresupuestoInstitucionalRepository PresupuestoInstitucionalRepository;
	@Override
	public void guardarPresupuestoInstitucionalImpl(TblPresupuestoInstitucional tblPresupuestoInstitucional) {
		PresupuestoInstitucionalRepository.save(tblPresupuestoInstitucional);		
	}
	@Override
	public List<TblPresupuestoInstitucional> obtenerPresupuestoInstitucional(Integer infCod) {
		return PresupuestoInstitucionalRepository.findByinfCod(infCod);
	}
	
	
}
