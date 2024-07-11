package gob.cpccs.service.rendicion;

import gob.cpccs.model.rendicion.TblNegarAutoridad;
import gob.cpccs.model.rendicion.TblObservacionesNegar;

public interface ServicioObservacion {
	void guardarObservacioNegar(TblObservacionesNegar tblObservacinegar);
	void guardarObservacioNegarAutoridad(TblNegarAutoridad tblNegarAuto);
}
