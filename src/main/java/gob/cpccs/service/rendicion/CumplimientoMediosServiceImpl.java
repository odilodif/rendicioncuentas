package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblCumplimientoMedios;
import gob.cpccs.repository.rendicion.CumplimientoMedioRepository;

@Service
public class CumplimientoMediosServiceImpl implements CumplimientoMediosService {
	@Autowired
    private CumplimientoMedioRepository cumplimientoMedios;
	
	@Override
	public List<TblCumplimientoMedios> obtenerRegistroCumplimientoMedio(int infCod,String cmTipo) {
		return cumplimientoMedios.findByinfCod(infCod,cmTipo);
	}
	
	@Override
	public void guardarCumplimientoMedio(TblCumplimientoMedios TblSugerencia){
		cumplimientoMedios.save(TblSugerencia);
	}
}
