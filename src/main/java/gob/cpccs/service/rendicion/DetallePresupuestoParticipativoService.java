package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblProyPresupuestoParticipativo;

public interface DetallePresupuestoParticipativoService {

	void guardarProyPresupuestoParticipativoImpl(TblProyPresupuestoParticipativo tblProyPresupuestoParticipativo);
	List<Object[]> ProyPresupuestoParticipativoImpl(TblInforme tblInforme);
}
