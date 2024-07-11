package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblParticipacionCiudadana;
import gob.cpccs.repository.rendicion.TblParticipacionCiudadanaRepository;
@Service
public class ParticipacionCiudadanaGadServiceImpl implements ParticipacionCiudadanaGadService{
	@Autowired
	private TblParticipacionCiudadanaRepository ParticipaCiudadanaRepository;
	//Inicio Participacion Ciudadana//	

	@Override
	public void guardarPartCiudadana(TblParticipacionCiudadana tblParticipacionCiudadana) {
		ParticipaCiudadanaRepository.save(tblParticipacionCiudadana);
		
	}

	@Override
	public List<TblParticipacionCiudadana> obtenerRegistrosPartCiudadana(Integer infCod) {
	
		return ParticipaCiudadanaRepository.findByinfCod(infCod);
	}
	@Override
	public TblParticipacionCiudadana ObtenerRegistroPartCiudadana(Integer pcCod) {
		
		return ParticipaCiudadanaRepository.findByPcCod(pcCod);
	}
	@Override
	public Integer contarvalor(Integer pcCod, String pcSistema) {
		
		return ParticipaCiudadanaRepository.coutPc(pcCod, pcSistema);
	}
	@Override
	public TblParticipacionCiudadana obtenerRegistrosPartCiudadanaCodigoTipo(Integer infCod, String pcSistema) {
	
		return ParticipaCiudadanaRepository.findByinfCodmecanismo(infCod, pcSistema);
	}
}
