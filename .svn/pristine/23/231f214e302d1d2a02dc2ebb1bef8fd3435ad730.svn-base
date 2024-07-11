package gob.cpccs.service.gestion;

import java.util.Date;
import java.util.List;

import gob.cpccs.model.gestion.TblInformeAutoridadFin;

public interface TblInformeAutoridadFinService {

	void GuardarInformeFin(TblInformeAutoridadFin tabla);

	TblInformeAutoridadFin obtenerRegistroInformexIdentificadorEstado(String infAutCod, String estado);

	List<TblInformeAutoridadFin> obtenerRegistroInformexAutoCodEstado(int infAutCod, String estado);

	void ActualizarInformeAutoridadFin(Date fechaRendicion, String lugar, Integer numeroAsistentes, int infAutCod);

	TblInformeAutoridadFin obtenerRegistroInformexInfocodEstado(int infAutCod, String estado);

	void ActualizarInformeAportes(String inaAportesCiu, int infCod);

	List<TblInformeAutoridadFin> obtenerRegistroInformexAportes(int infAutCod, String estado);

	void ActualizarInformeRendicionFin(String inaProcesoRc, int infAutCod);

	void ActualizarInformeObligacionesFin(String infAutTributo, String infAutMedioTributario, int infAutCod);

	String listar(int infAutCod, String infAutPeriodo);

	void finalizarInforme(int infAutCod, String infAutEstado, Date infAutFechafin, String infAutVerificador);

}
