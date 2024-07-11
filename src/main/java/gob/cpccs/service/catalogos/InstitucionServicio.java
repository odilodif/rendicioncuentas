package gob.cpccs.service.catalogos;


import java.util.List;

import gob.cpccs.model.catalogos.TblInstitucion;

public interface InstitucionServicio {
	TblInstitucion ObtenerInstitucionesXIdcodigo(Integer idcodigo);
	void guardarInstitucion(TblInstitucion tblInstitucion);
	
	void actualizarInstVerificador(Integer instCod, int instPeriodo, String instVerificador); 
	
	Integer conteoEstadosInstituciones(int instPeriodo, String instEstado);
	Integer conteoEstadosProcesoInstituciones(int instPeriodo, String instVerificador);
	Integer conteoEstadosProcesoInformes(int infPeriodo, String infVerificador);
	Integer conteoCatastro(int instPeriodo, String instEstado);
	List conteoInstitucionesActivas(int instPeriodo, String instEstado);
	//provincia
	List conteoEstadosProcesoInformesXprovincia(int infPeriodo, String infVerificador, int provCod);
	Integer conteoEstadosInstitucionesxprovincia(int instPeriodo, String instEstado, int provCod);
	Integer conteoCatastroxprovincia(int instPeriodo, int provCod);
	
}
