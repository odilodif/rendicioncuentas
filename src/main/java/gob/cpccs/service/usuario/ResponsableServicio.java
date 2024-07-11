package gob.cpccs.service.usuario;

import java.util.Date;
import java.util.List;

import gob.cpccs.model.usuario.TblResponables;

public interface ResponsableServicio {

	void GuardarResponsables(TblResponables tblResponables);

	TblResponables buscarResponXemailTipoPeriodo(String responEmail, String responTipo, String responPeriodo);

	TblResponables buscarResponxCodintituciotipoPeriodo(Integer responCodRefe, String responTipo, String responPeriodo);

	List<TblResponables> buscarResponsableXcodigoInstitucion(int codigo, String periodo);

	void actualizarResponsableXcod(String responNombre, String responEmail, String responCargo, Integer responCodigo, Date fechaDesignacion, String celular);

	void borrarResponsableXcodyperiodo(int responCodigo, String periodo);
	
	TblResponables obtenerResponsableResponCodigo(Integer responCodigo);
}
