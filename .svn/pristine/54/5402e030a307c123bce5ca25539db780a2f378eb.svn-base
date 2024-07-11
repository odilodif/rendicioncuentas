package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblMecanismosContolSocial;
import gob.cpccs.repository.rendicion.TblMecanismosContolSocialRepository;
@Service
public class MecanismoControlSocialServiceImpl implements MecanismoControlSocialService{
	@Autowired
	private TblMecanismosContolSocialRepository ControlSocialRepository;
	//Inicio Mecanismos de Costrol Social//

	@Override
	public List<TblMecanismosContolSocial> obtenerRegistroControlSocial(Integer infCod) {
		return ControlSocialRepository.findByinfCod(infCod);
	}
	@Override
	public void guardarControlSocial(TblMecanismosContolSocial tblMecanismosContolSocial) {
		ControlSocialRepository.save(tblMecanismosContolSocial);
		
	}
	@Override
	public TblMecanismosContolSocial ObtenerRegistroContrSocial(Integer mecCod) {
		return ControlSocialRepository.findByMecCod(mecCod);
	}
	@Override
	public Integer ContadorMCS(Integer info_cod,String nombre) {
		return ControlSocialRepository.coutMeCS(info_cod, nombre);
	}
	
	@Override
	public TblMecanismosContolSocial ObtenerRegistroContrSocialNombre(Integer info_cod,String nombre) {
		return ControlSocialRepository.obtenerMecanismo(info_cod, nombre);
	}
	
}
