package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblPlanificacionParticipativa;

public interface PlanificacionParticipativaService {

	void GuardarPlanificacionParticipativa(TblPlanificacionParticipativa tblPlanificacionParticipativa);
	
	List<TblPlanificacionParticipativa> ObtenerRegistrosPlanificacionPartipativaXinfCod(Integer infCod);

	TblPlanificacionParticipativa ObtenerRegistrosPlanificacionPartipativaXinfCodNombre(Integer infCod, String nombre);

	Integer ObtenerRegistrosCount(Integer infCod, String nombre);
}
