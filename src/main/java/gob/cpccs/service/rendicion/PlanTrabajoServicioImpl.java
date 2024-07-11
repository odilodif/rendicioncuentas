package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblPlanTrabajoGad;
import gob.cpccs.repository.rendicion.PlanTrabajoRepository;

@Service
public class PlanTrabajoServicioImpl implements PlanTrabajoService {
	@Autowired 
	private PlanTrabajoRepository PlanTrabajoRepository;
	
	@Override
	public void guardarPlanTrabajo(TblPlanTrabajoGad TblPlanTrabajoGad) {
		PlanTrabajoRepository.save(TblPlanTrabajoGad);
		
	}
	@Override
	public List<TblPlanTrabajoGad> obtenerRegistroPlanTrabajo(int instCod) {
		return PlanTrabajoRepository.findByinfCod(instCod);
	}
}
