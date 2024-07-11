package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblFasePresupuestoParticipativo;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblProyPresupuestoParticipativo;
import gob.cpccs.repository.rendicion.ProyPresupuestoParticipativoRepository;
@Service
public class DetallePresupuestoParticipativoServiceImpl implements DetallePresupuestoParticipativoService{
	@Autowired
	ProyPresupuestoParticipativoRepository ProyPresupuestoParticipativoRepository;
	

	
	@Override
	public List<Object[]> ProyPresupuestoParticipativoImpl(TblInforme infCod) {
		return ProyPresupuestoParticipativoRepository.buscarDetalles(infCod);
	}

	@Override
	public void guardarProyPresupuestoParticipativoImpl(TblProyPresupuestoParticipativo tblProyPresupuestoParticipativo) {
		ProyPresupuestoParticipativoRepository.save(tblProyPresupuestoParticipativo);		
	}
}
