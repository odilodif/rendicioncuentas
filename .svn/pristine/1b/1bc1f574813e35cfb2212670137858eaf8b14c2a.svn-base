package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblPorcentajePresupuesto;
import gob.cpccs.model.rendicion.TblPresupuestoInstitucional;
import gob.cpccs.repository.rendicion.PorcentajePresupuestoRepository;

@Service
public class PorcentajePresupuestoServiceImpl implements PorcentajePresupuestoService{
	@Autowired
	PorcentajePresupuestoRepository PorcentajePresupuestoRepository;
	@Override
	public void guardarPorcentajePresupuestoImpl(TblPorcentajePresupuesto tblPorcentajePresupuesto) {
		PorcentajePresupuestoRepository.save(tblPorcentajePresupuesto);		
	}
	
	@Override
	public List<Object[]> obtenerPorcentajePresupuestoImpl(TblInforme tblInforme) {
		return PorcentajePresupuestoRepository.buscarPorcentajes(tblInforme);
	}
	
}
