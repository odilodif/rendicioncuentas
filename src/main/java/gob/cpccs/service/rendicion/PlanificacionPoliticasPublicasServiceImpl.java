package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblArticulacionPp;
import gob.cpccs.repository.rendicion.TblArticulacionPpRepository;

@Service
public class PlanificacionPoliticasPublicasServiceImpl implements PlanificacionPoliticasPublicasService{
    @Autowired
    private TblArticulacionPpRepository PlanifPolitica;
	
    @Override
	public void guardarPlanificacionPoliticas(TblArticulacionPp tblArticulacionPp) {
		PlanifPolitica.save(tblArticulacionPp);
		
	}

	@Override
	public List<TblArticulacionPp> obtenerRegistrosPlanificacionPoliticasPublicasXinfoCod(Integer infCod) {
		return PlanifPolitica.findByinfCod(infCod);
	}
	@Override
	public TblArticulacionPp PlanificacionPoliticasPublicasXinfoCodNombre(Integer infCod,String nombre) {
		return PlanifPolitica.findByinfCodAndDescricion(infCod, nombre);
	}
	@Override
	public Integer CountarPoliticaP(Integer infCod,String nombre) {
		return PlanifPolitica.coutAPp(infCod, nombre);
	}

}
