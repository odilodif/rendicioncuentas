package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblIncoporacionRecomendaciones;

public interface IncoporacionRecomendacionesService {
	
	 // Incorporacion de recomendacionesl//  
    List<TblIncoporacionRecomendaciones> obtenerRegistroIncorporacionRecomendaciones(Integer infCod);
    void guardarControlSocial(TblIncoporacionRecomendaciones tblIncoporacionRecomendaciones);
    TblIncoporacionRecomendaciones ObtenerRegistroIncorpocionRecomendaciones(Integer ireCod);

}
