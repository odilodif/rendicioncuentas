package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblMecanismoRendicionCuentas;

public interface RendicionCuentasGadService {
	// Mecanismos Rendicion de Cuentas//
	List<TblMecanismoRendicionCuentas> obtenerRegistroRendicionCuentas(Integer infCod);

	TblMecanismoRendicionCuentas ObtenerRegistroendicionCuentas(Integer mecanismoCod);

	void guadarRendicioncuentas(TblMecanismoRendicionCuentas tblMecanismoRendicionCuentas);

	List<TblMecanismoRendicionCuentas> ObtenerRegistrosXInfoCodFase(Integer infCod,String mecanismoFase);
	
	List<TblMecanismoRendicionCuentas> ObtenerRegistrosXInfoCod(Integer infCod);

	TblMecanismoRendicionCuentas ObtenerRegistrosXInfoCodNombre(Integer infCod, String mecanismoNombre);

	Integer CountMRC(Integer infCod, String mecanismoNombre);

}
