package gob.cpccs.service.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.seguridad.TblHistoricoInstituciones;
import gob.cpccs.repository.seguridad.HistoricoInstitucionRepository;

@Service
public class HistoricoInstitucionServiceImpl implements HistoricoInstitucionService  {

	@Autowired
	HistoricoInstitucionRepository HistoricoInstitucionRepository;
	
	@Override
	public List<TblHistoricoInstituciones> obtenerRegistros(Integer infCod) {
		return HistoricoInstitucionRepository.buscarRegistrosXinfcod(infCod);
	}

}
