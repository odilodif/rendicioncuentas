package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblPlanTrabajo;
import gob.cpccs.repository.rendicion.PlanTrabajoAutoridadRepository;

@Service
public class PlanTrabajoAutoridadServiceImpl implements PlanTrabajoAutoridadService{
	
	@Autowired 
	private PlanTrabajoAutoridadRepository  PlanTrabajoAutoridadRepository;
	
	@Override
	public void guardarPlanTrabajo(TblPlanTrabajo tblPlanTrabajo) {
		PlanTrabajoAutoridadRepository.save(tblPlanTrabajo);
		
	}

	@Override
	public List<TblPlanTrabajo> obtenerRegistrosPlanTrabajoAutoridad(int infAutCod) {
		return PlanTrabajoAutoridadRepository.buscarPlanTrabajoPorinfAutCod(infAutCod);
	}

}
