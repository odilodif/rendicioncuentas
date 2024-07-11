package gob.cpccs.service.rendicion;

import java.math.BigDecimal;
import java.util.List;

import gob.cpccs.model.rendicion.TblDetalleEjecucionp;
import gob.cpccs.model.rendicion.TblEjecucionProgramatica;
import gob.cpccs.model.rendicion.TblInforme;

public interface ActualizarDetallePoaService {

	List<TblDetalleEjecucionp> registrosDetalleEP( TblInforme infCod);
	
	List<TblDetalleEjecucionp> obtenerregistro(Integer infCod);
	
	List<TblDetalleEjecucionp> obtenerregistroDetalle(Integer infCod, String depDescripcion );
	
	void guardarDetalleEP(TblDetalleEjecucionp tblDetalleEjecucionp);
	
    void ActualizarTotalDetallePoa(BigDecimal depTotal, int depCod);
    
    void ActualizarTotalDetallePoaTodos(BigDecimal depTotal, int infCod);



	
	
}
