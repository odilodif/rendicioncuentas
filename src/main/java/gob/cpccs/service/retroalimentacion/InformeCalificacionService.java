package gob.cpccs.service.retroalimentacion;

import java.util.List;

import gob.cpccs.model.retroalimentacion.TblInformeCalificado;

public interface InformeCalificacionService {
	void guardarInformeCalificacion(TblInformeCalificado tblInformeCalificado);
	List<Object[]> qryBuscarCalifiaccionesInforme(Integer infcod);
	
	List<TblInformeCalificado> ObtenerListaPregunstas(Integer infCod);
	
	TblInformeCalificado ObtenerRegistroXidInfCal(Integer idInfCal);
	
	TblInformeCalificado ObtenerRegistroInfCodPregunta(Integer infCod, String pregunta );
	List<TblInformeCalificado> ObtenerListaPregunstasorden(Integer infCod);
	List<Object[]> qryBuscarCalifiaccionesInformeOrden(Integer infcod);
	List<TblInformeCalificado> ObtenerListaPregunstasXorden(Integer infCod);
}
