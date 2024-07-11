package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblMecanismoRendicionCuentas;
import gob.cpccs.repository.rendicion.TblMecanismoRendicionCuentasRepository;

@Service
public class RendicionCuentasGadServiceImpl implements RendicionCuentasGadService {

	@Autowired
	private TblMecanismoRendicionCuentasRepository RendicionCuentas;

	@Override
	public List<TblMecanismoRendicionCuentas> obtenerRegistroRendicionCuentas(Integer infCod) {
		return RendicionCuentas.findByinfCod(infCod);
	}

	@Override
	public TblMecanismoRendicionCuentas ObtenerRegistroendicionCuentas(Integer mecanismoCod) {
		return RendicionCuentas.findByMecanismoCod(mecanismoCod);
	}

	@Override
	public void guadarRendicioncuentas(TblMecanismoRendicionCuentas tblMecanismoRendicionCuentas) {
		RendicionCuentas.save(tblMecanismoRendicionCuentas);
	}
	@Override
	public List<TblMecanismoRendicionCuentas> ObtenerRegistrosXInfoCodFase(Integer infCod, String mecanismoFase) {
		return RendicionCuentas.findByInfCodAndMecanismoFase(infCod, mecanismoFase);
	}
	
	@Override
	public List<TblMecanismoRendicionCuentas> ObtenerRegistrosXInfoCod(Integer infCod) {
		return RendicionCuentas.findByinfCod(infCod);
	}
	@Override
	public TblMecanismoRendicionCuentas ObtenerRegistrosXInfoCodNombre(Integer infCod, String mecanismoNombre) {
		return RendicionCuentas.findByInfCodAndMecanismoNombre(infCod, mecanismoNombre);
	}
	
	@Override
	public Integer CountMRC(Integer infCod, String mecanismoNombre) {
		return RendicionCuentas.coutMRC(infCod, mecanismoNombre);
	}
}
