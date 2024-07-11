package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblPlanificacionParticipativa;
import gob.cpccs.repository.rendicion.TblPlanificacionParticipativaRepository;

@Service
public class PlanificacionParticipativaServiceImpl implements PlanificacionParticipativaService{
    @Autowired
    private TblPlanificacionParticipativaRepository PlanifParti;
	@Override
	public void GuardarPlanificacionParticipativa(TblPlanificacionParticipativa tblPlanificacionParticipativa) {
		PlanifParti.save(tblPlanificacionParticipativa);
		
	}

	@Override
	public List<TblPlanificacionParticipativa> ObtenerRegistrosPlanificacionPartipativaXinfCod(Integer infCod) {
		return PlanifParti.findByinfCod(infCod);
	}
	@Override
	public TblPlanificacionParticipativa ObtenerRegistrosPlanificacionPartipativaXinfCodNombre(Integer infCod,String nombre) {
		return PlanifParti.BuscarNombreinfoCod(infCod, nombre);
	}
	@Override
	public Integer ObtenerRegistrosCount(Integer infCod,String nombre) {
		return PlanifParti.coutPP(infCod, nombre);
	}
	
}
