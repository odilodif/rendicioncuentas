package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblAnteproyectoPresupuesto;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblMecanismosContolSocial;
import gob.cpccs.model.rendicion.TblProyPresupuestoParticipativo;
import gob.cpccs.repository.rendicion.AnteproyectoPresupuestoRepository;

@Service
public class AnteproyectoPresupuestoServiceImpl implements AnteproyectoPresupuestoService{
	@Autowired
	AnteproyectoPresupuestoRepository AnteproyectoPresupuestoRepository;
	
	@Override
	public void guardarAnteproyectoPresupuestoServiceImpl(TblAnteproyectoPresupuesto tblAnteproyectoPresupuesto) {
		AnteproyectoPresupuestoRepository.save(tblAnteproyectoPresupuesto);		
	}
	
	 @Override
		public List<Object[]> BuscarAnteproyectoPresupuestoServiceImpl(TblInforme infCod) {
			return AnteproyectoPresupuestoRepository.buscarAnteproyectos(infCod);
		}
		
		@Override
		public TblAnteproyectoPresupuesto ObtenerRegistrosAnteproyectos(Integer anteCod) {
			return AnteproyectoPresupuestoRepository.findByAnteCod(anteCod);
		}
}
