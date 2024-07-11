package gob.cpccs.service.gestion;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.gestion.TblInformeAutoridadFin;
import gob.cpccs.repository.gestion.TblInformeAutoridadFinRepository;

@Service
public class TblInformeAutoridadFinServiceImpl implements TblInformeAutoridadFinService {
	@Autowired
	private TblInformeAutoridadFinRepository finrepo;

	@Override
	public void GuardarInformeFin(TblInformeAutoridadFin tabla) {
		finrepo.save(tabla);
	}

	@Override
	public TblInformeAutoridadFin obtenerRegistroInformexIdentificadorEstado(String infAutCod, String estado) {
		return finrepo.findByIdentificadorAndinfAutEstado(infAutCod, estado);
	}
	@Override
	public TblInformeAutoridadFin obtenerRegistroInformexInfocodEstado(int infAutCod, String estado) {
		return finrepo.findByinfoAndinfAutEstado(infAutCod, estado);
	}
	@Override
	public List<TblInformeAutoridadFin> obtenerRegistroInformexAutoCodEstado(int infAutCod, String estado) {
		return finrepo.findByInfoAutCodAndinfAutEstado(infAutCod, estado);
	}
	@Override
	public void ActualizarInformeAutoridadFin(Date fechaRendicion, String lugar, Integer numeroAsistentes, int infAutCod) {
		finrepo.actualizarInformeAutoridadFinxId( fechaRendicion, lugar,  numeroAsistentes,  infAutCod);
		
	}
	@Override
	public void ActualizarInformeAportes(String inaAportesCiu, int infCod ) {
		finrepo.actualizarInformeAportesxId(inaAportesCiu, infCod);
		
	}
	@Override
	public List<TblInformeAutoridadFin> obtenerRegistroInformexAportes(int infAutCod, String estado) {
		return finrepo.findByinfoAndinfAutEstadoAportes(infAutCod, estado);
	}
	@Override
	public void ActualizarInformeRendicionFin(String inaProcesoRc,  int infAutCod) {
		
		finrepo.actualizarInformeRendicionxId(inaProcesoRc, infAutCod);
		
	}
	@Override
	public void ActualizarInformeObligacionesFin(String infAutTributo, String infAutMedioTributario,  int infAutCod) {
		finrepo.actualizarInformeCumplimientoxIdFin( infAutTributo,  infAutMedioTributario,  infAutCod);
		
	}
	@Override
	public  String listar(int infAutCod, String infAutPeriodo) {
		// TODO Auto-generated method stub
		return finrepo.listaProcedure( infAutCod,  infAutPeriodo);
	}
	@Override
	public void finalizarInforme( int infAutCod, String infAutEstado, Date infAutFechafin, String infAutVerificador) {
		
		finrepo.finalizar( infAutCod,  infAutEstado,  infAutFechafin,  infAutVerificador);
	}
}
