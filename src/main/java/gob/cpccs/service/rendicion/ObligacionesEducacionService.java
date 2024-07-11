package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblObligacionesEducacion;

public interface ObligacionesEducacionService {

	void guardarObligacionesEducacion(TblObligacionesEducacion tblObligacionesEducacion);
    List<TblObligacionesEducacion> ObtenerObligacionesEducacionxInforme(Integer infCod);
	
}
