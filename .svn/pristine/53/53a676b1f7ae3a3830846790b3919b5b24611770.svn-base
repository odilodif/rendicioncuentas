package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblDerechosAutor;
import gob.cpccs.repository.rendicion.DerechosAutoresRepository;

@Service
public class DerechosAutoresServiceImpl implements DerechosAutoresService {

	@Autowired
    private DerechosAutoresRepository derechoMedios;
	
	@Override
	public List<TblDerechosAutor> obtenerRegistroDerechosMedio(int infCod) {
		return derechoMedios.findByinfCod(infCod);
	}
	
	@Override
	public void guardarCumplimientoDerechosMedio(TblDerechosAutor TblSugerencia){
		derechoMedios.save(TblSugerencia);
	}
}
