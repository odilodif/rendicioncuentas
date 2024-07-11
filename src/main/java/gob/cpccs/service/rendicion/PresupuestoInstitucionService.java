package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblParticipacionCiudadana;
import gob.cpccs.model.rendicion.TblPresupuestoInstitucional;

public interface PresupuestoInstitucionService {
	
	void guardarPresupuestoInstitucionalImpl(TblPresupuestoInstitucional tblPresupuestoInstitucional);
	List<TblPresupuestoInstitucional> obtenerPresupuestoInstitucional(Integer infCod);
}
