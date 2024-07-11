package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblComunicacionGestion;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.repository.rendicion.DetalleMediosRepository;

@Service
public class DetalleMediosServiceImpl implements DetalleMediosService{
	@Autowired
	private DetalleMediosRepository mediosRepository;
	
	@Override
	public List<TblComunicacionGestion> obtenerRegistroMedios(int infCod) {
		return mediosRepository.findByinfCod(infCod);
	}
	@Override
	public TblComunicacionGestion obtenerRegistro(int cgCod) {
		return mediosRepository.findByCgCod(cgCod);
	}
	@Override
	public void guardarMediosComunicacion(TblComunicacionGestion TblSugerencia){
		mediosRepository.save(TblSugerencia);
	}
	@Override
	public TblComunicacionGestion obtenerRegistroMediosNombre(TblInforme tblInforme, String nombre) {
		return mediosRepository.findByInfCodAndCgNombre(tblInforme, nombre);
	}
	@Override
	public Integer countmedios(Integer infCod, String nombre) {
		return mediosRepository.coutCG(infCod, nombre);
	}
}
