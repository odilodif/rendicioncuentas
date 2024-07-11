package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblReclamosMedios;
import gob.cpccs.repository.rendicion.ReclamosMedioRepository;

@Service
public class ReclamosMediosServiceImpl implements ReclamosMediosService{
	@Autowired
	private ReclamosMedioRepository reclamomedios;
	
	@Override
	public List<TblReclamosMedios> obtenerRegistrosReclamos(int infCod) {
		return reclamomedios.findByinfCod(infCod);
	}
	
	
	@Override
	public void guardarRegistrosReclamos(TblReclamosMedios TblSugerencia){
		reclamomedios.save(TblSugerencia);
	}
}
