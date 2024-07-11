package gob.cpccs.service.rendicion;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblSede;
import gob.cpccs.repository.rendicion.SedeRepository;

@Service
public class SedeServiceImpl implements SedeService {
	@Autowired
	private SedeRepository SedeRepository;
	
	@Override 
	public void guardarSede(TblSede tblSede) {
		 SedeRepository.save(tblSede);
		
	}

	@Override
	public List<TblSede> obtenerSedes(TblInforme tblInforme) {
		return SedeRepository.findByInfCod(tblInforme);
	}

	@Override
	public List<Object[]> obtenerSedesXcod(TblInforme tblInforme) {
		return SedeRepository.buscarSedes(tblInforme);
	}

	@Override
	public TblSede obtenerSedesXcodigo(int seCod) {
		return SedeRepository.findBySeCod(seCod);		
	}

	@Override
	public void actualizarDatosSede(Integer seCod, String seNombre, Integer seProvincia, Integer seParroquia,
			Integer seCanton, String seDireccion, String seMail, String seWeb, String seRuc) {
		SedeRepository.actualizarRegistro( seCod,  seNombre,  seProvincia,  seParroquia,
				 seCanton,  seDireccion,  seMail,  seWeb,  seRuc);
		
	}
	
	@Override
	public void actualizarDatosSedeDetalle(Integer seCod, String seRepresentante, String seCargo, String seMailrep, Date seDesignacion, String seTelrep) {
		SedeRepository.actualizarRegistroDetalle( seCod,  seRepresentante,  seCargo,  seMailrep,
				seDesignacion,  seTelrep);
		
	}

	@Override
	public void actualizarDatosSedeDetalle2(Integer seCod, Integer seUnidades, String seCobertura,
			Integer seEstudiantes, Integer seHombre, Integer seMujeres, Integer seGlbti, Integer seMontubios,
			Integer seMestizos, Integer seCholos, Integer seIndigenas, Integer seAfroecuatorianos,
			Integer seExtranjeros, Integer seDiscapacitados, String seLink) {
			SedeRepository.actualizarRegistroDetalle2( seCod,  seUnidades,  seCobertura,
					 seEstudiantes,  seHombre,  seMujeres,  seGlbti,  seMontubios,
					 seMestizos,  seCholos,  seIndigenas,  seAfroecuatorianos,
					 seExtranjeros,  seDiscapacitados,  seLink); 
		
	}

}
