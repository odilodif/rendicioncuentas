package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblImplementacionPresupuesto;
import gob.cpccs.model.rendicion.TblInforme;

public interface IgualdadPresupuestoGadService {
	  //Implementacion Politicas para la igualdad presupuesto//
		List<TblImplementacionPresupuesto> OntenerRegistrosImplPresuXcod(TblInforme tblInforme);
		List<Object[]> obtenerRegistroImplementacionPresupuestoXcod(TblInforme tblInforme);
		void guardarImplementPresupuesto(TblImplementacionPresupuesto tblImplementacionPresupuesto);
	    void ActualizarImplementaPrePorcen(String implePorce,TblInforme tblInforme);
		TblImplementacionPresupuesto OntenerRegistrosImplPresuXcodXNombre(TblInforme tblInforme, String grupo);
		Integer countIPRE(TblInforme tblInforme, String grupo);	

}
