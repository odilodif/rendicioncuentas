package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gob.cpccs.repository.rendicion.PresupuestariosEducacionRepository;

import gob.cpccs.model.rendicion.TblPresupuestoEducacion;
@Service
public class PresupuestoEducacionServiceImpl implements PresupuestoEducacionService{

	@Autowired
    private PresupuestariosEducacionRepository PresupuestariosEducacionRepository;
	
	@Override
	public List<TblPresupuestoEducacion> obtenerPresupuestoEducacion(int infCod) {
		return PresupuestariosEducacionRepository.findByinfCod(infCod);
	}

	@Override
	public void guardarPresupuestoEducacion(TblPresupuestoEducacion tblPresupuestoEducacion) {
		PresupuestariosEducacionRepository.save(tblPresupuestoEducacion);
	}

}
