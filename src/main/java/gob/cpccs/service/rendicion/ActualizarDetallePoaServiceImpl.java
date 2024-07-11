package gob.cpccs.service.rendicion;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblDetalleEjecucionp;
import gob.cpccs.model.rendicion.TblEjecucionProgramatica;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.repository.rendicion.ActualizarDetallePoaRepository;

@Service
public class ActualizarDetallePoaServiceImpl implements ActualizarDetallePoaService {
	
	@Autowired
	private ActualizarDetallePoaRepository ActualizarDetallePoaRepository;
	
	@Override
	public List<TblDetalleEjecucionp> registrosDetalleEP(TblInforme infCod) {
		return ActualizarDetallePoaRepository.BuscarRegistros(infCod);
	}

	@Override
	public void guardarDetalleEP(TblDetalleEjecucionp tblDetalleEjecucionp) {
		ActualizarDetallePoaRepository.save(tblDetalleEjecucionp);
		
	}
	@Override
	public void ActualizarTotalDetallePoaTodos(BigDecimal depTotal, int infCod) {
		ActualizarDetallePoaRepository.ActualizarTotalTodos(depTotal, infCod);  
	}
	
	@Override
	public void ActualizarTotalDetallePoa(BigDecimal depTotal, int depCod) {
		ActualizarDetallePoaRepository.ActualizarTotal(depTotal, depCod);  
	}
	@Override
	public List<TblDetalleEjecucionp> obtenerregistro(Integer infCod) {
		
		return ActualizarDetallePoaRepository.findByInfCod(infCod);
	}

	@Override
	public List<TblDetalleEjecucionp> obtenerregistroDetalle(Integer infCod, String depDescripcion) {
		return ActualizarDetallePoaRepository.findByInfCodAndDepDescripcion(infCod, depDescripcion);
	}
	
}
