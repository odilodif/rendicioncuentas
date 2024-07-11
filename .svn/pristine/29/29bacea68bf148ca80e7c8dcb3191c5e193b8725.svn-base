package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblMecanismosTranparenciaAccInf;
import gob.cpccs.repository.rendicion.TrasparenciaInformacionRepository;

@Service
public class TrasparenciaInformacionServiceImpl implements TrasparenciaInformacionService{

	@Autowired
	private TrasparenciaInformacionRepository TrasparenciaRepository;
	
	@Override
	public List<TblMecanismosTranparenciaAccInf> obtenerRegistroTrasparenciaInformacion(int infCod) {
		return TrasparenciaRepository.findByinfCod(infCod);
	}
	
	@Override
	public void guardarTrasparenciaInformacion(TblMecanismosTranparenciaAccInf TblSugerencia){
		TrasparenciaRepository.save(TblSugerencia);
	}
	@Override
	public TblMecanismosTranparenciaAccInf obtenerMecanismosXnombreXinforme(int infCod,String nombre){
		return TrasparenciaRepository.MecanismoAccesoIformacion(infCod, nombre);
	}
	@Override
	public Integer CountMecanismosXnombreXinforme(int infCod,String nombre){
		return TrasparenciaRepository.coutMTA(infCod, nombre);
	}
}
