package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblImplementacionPresupuesto;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.repository.rendicion.TblImplementacionPresupuestoRepository;

@Service
public class IgualdadPresupuestoGadServiceImpl implements IgualdadPresupuestoGadService  {
	@Autowired
	private TblImplementacionPresupuestoRepository ImplePresuRepository;
	
	@Override
	public void guardarImplementPresupuesto(TblImplementacionPresupuesto tblImplementacionPresupuesto) {
		ImplePresuRepository.save(tblImplementacionPresupuesto);
		
	}

	@Override
	public List<TblImplementacionPresupuesto> OntenerRegistrosImplPresuXcod(TblInforme tblInforme) {
		return ImplePresuRepository.findByInfoCod(tblInforme);
	}

	@Override
	public List<Object[]> obtenerRegistroImplementacionPresupuestoXcod(TblInforme tblInforme) {
		return ImplePresuRepository.buscarImplePresuesto(tblInforme);
	}

	@Override
	public void ActualizarImplementaPrePorcen(String implePorce, TblInforme tblInforme) {
		ImplePresuRepository.actualizarImplePresupuesto(implePorce, tblInforme);
		
	}
	@Override
	public TblImplementacionPresupuesto OntenerRegistrosImplPresuXcodXNombre(TblInforme tblInforme,String grupo) {
		return ImplePresuRepository.buscarIPLPresu(tblInforme, grupo);
	}
	@Override
	public Integer countIPRE(TblInforme tblInforme,String grupo) {
		return ImplePresuRepository.coutIP(tblInforme, grupo);
	}
}
