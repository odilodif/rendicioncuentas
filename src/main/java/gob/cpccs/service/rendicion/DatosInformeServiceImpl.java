package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblDatosInforme;
import gob.cpccs.repository.rendicion.DatosInformeRemository;
@Service
public class DatosInformeServiceImpl implements DatosInformeService {

	@Autowired 
	private DatosInformeRemository DatosRepository;

	@Override
	public List<TblDatosInforme> obtenerRegistroDatosDeliberacion(int infCod) {
		return DatosRepository.findByinfCod(infCod);
	}
	
	@Override
	public  void guardarDatosInforme(TblDatosInforme tbldatosInforme) {
		DatosRepository.save(tbldatosInforme);
		
	}
}
