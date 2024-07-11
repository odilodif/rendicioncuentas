package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblProduccionAudiovisual;
import gob.cpccs.repository.rendicion.ProduccionAudiovisualRepository;



@Service
public class ProduccionAudiovisualServiceImpl implements ProduccionAudiovisualService{
	@Autowired
	private ProduccionAudiovisualRepository proyecto;
	
	@Override
	public List<TblProduccionAudiovisual> obtenerRegistrosAudiovisual(int infCod,String paTipo) {
		return proyecto.findByinfCod(infCod,paTipo);
	}
	
	@Override
	public void guardarRegistrosAudiovisual(TblProduccionAudiovisual TblSugerencia){
		proyecto.save(TblSugerencia);
	}
	@Override
	public TblProduccionAudiovisual obtenerPAudiovisualNombre(int infCod,String paTipo,String contenido) {
		return proyecto.FindProduccionNombreTipo(infCod, paTipo, contenido);
	}
	@Override
	public Integer CountProduccion(int infCod,String paTipo,String contenido) {
		return proyecto.coutPAu(infCod, paTipo, contenido);
	}
}
