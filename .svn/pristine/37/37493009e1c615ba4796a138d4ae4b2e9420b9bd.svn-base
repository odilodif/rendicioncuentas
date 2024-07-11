package gob.cpccs.service.gestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.gestion.TblPlanTrabajoFin;
import gob.cpccs.repository.gestion.PlanTrabajoFinRepository;


@Service
public class PlanTrabajoFinServiceImpl implements PlanTrabajoFinService{
	@Autowired 
	private PlanTrabajoFinRepository  PlanTrabajoFinRepository;
	@Override
	public List<TblPlanTrabajoFin> obtenerRegistrosPlanTrabajoAutoridad(int infAutCod) {
		return PlanTrabajoFinRepository.buscarPlanTrabajoPorinfAutCod(infAutCod);
	}
	@Override
	public void GuardarPlanTrabajoFin(TblPlanTrabajoFin tabla) {
		 PlanTrabajoFinRepository.save(tabla);
	}
}
