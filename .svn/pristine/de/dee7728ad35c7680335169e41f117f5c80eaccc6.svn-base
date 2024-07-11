package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblDetalleComunicagestion;
import gob.cpccs.repository.rendicion.DetalleComunicacionGetionMediosRepository;

@Service
public class DetalleComunicacionServicioImpl implements DetalleComunicacionServicio {
	
	@Autowired
	private DetalleComunicacionGetionMediosRepository repositorio;
	
	@Override
	public List<TblDetalleComunicagestion> obtenerRegistroMedios(int cgCod){
		return repositorio.findByinfCod(cgCod);
	}
	@Override
	public void guardarMediosComunicacionDetalle(TblDetalleComunicagestion Tbltabla) {
		repositorio.save(Tbltabla);
	}
}
