package gob.cpccs.service.retroalimentacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.retroalimentacion.TblInformeCalificado;
import gob.cpccs.repository.QuerysNativosRepository;
import gob.cpccs.repository.retroalimentacion.*;
@Service
public class InformeCalificacionServiceImpl implements InformeCalificacionService {

	@Autowired
	 private InformeCalificacionRepository InformeCalificacionRepository;
	@Autowired
	 private QuerysNativosRepository QuerysNativosRepository;
	@Override
	public void guardarInformeCalificacion(TblInformeCalificado tblInformeCalificado) {
		InformeCalificacionRepository.save(tblInformeCalificado);
		
	}



	@Override
	public List<Object[]> qryBuscarCalifiaccionesInforme(Integer infcod) {
		return QuerysNativosRepository.qryBuscarCalificacionesInformeUltimo(infcod);
	}

	@Override
	public List<Object[]> qryBuscarCalifiaccionesInformeOrden(Integer infcod) {
		return QuerysNativosRepository.qryBuscarCalificacionesInformeOrden(infcod);
	}


	@Override
	public TblInformeCalificado ObtenerRegistroXidInfCal(Integer idInfCal) {		
		return InformeCalificacionRepository.findByIdInfCal(idInfCal);
	}



	@Override
	public TblInformeCalificado ObtenerRegistroInfCodPregunta(Integer infCod, String pregunta) {	
		return InformeCalificacionRepository.findByInfCodAndPregunta(infCod, pregunta);
	}



	@Override
	public List<TblInformeCalificado> ObtenerListaPregunstas(Integer infCod) {
		return InformeCalificacionRepository.findByInfCodOrder(infCod);
		//return InformeCalificacionRepository.findByInfCod(infCod);
	}

	@Override
	public List<TblInformeCalificado> ObtenerListaPregunstasorden(Integer infCod) {
		
		return InformeCalificacionRepository.findByInfCodOrder(infCod);
	}
	@Override
	public List<TblInformeCalificado> ObtenerListaPregunstasXorden(Integer infCod) {
		
		return InformeCalificacionRepository.findByInfCodOrder1(infCod);
	}
	
}
