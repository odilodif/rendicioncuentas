package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblAsambleaCiudadana;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.repository.rendicion.AsambleaCiudadanaRepository;

@Service
public class AsambleaCiudadanaServiceImpl implements AsambleaCiudadanaService {

	@Autowired
	AsambleaCiudadanaRepository AsambleaCiudadanaRepository;
	
	@Override
	public void guardarAnteproyectoPresupuestoServiceImpl(TblAsambleaCiudadana tblAsambleaCiudadana) {
		AsambleaCiudadanaRepository.save(tblAsambleaCiudadana);
	}

	@Override
	public List<Object[]> BuscarAsambleaCiudadanaImpl(TblInforme infCod) {
		return AsambleaCiudadanaRepository.buscarAnteproyectos(infCod);
	}

	@Override
	public TblAsambleaCiudadana ObtenerAsambleaCiudadana(Integer acCod) {
		return AsambleaCiudadanaRepository.findByAcCod(acCod);
	}
}
