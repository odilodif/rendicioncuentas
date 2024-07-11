package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblProyectoComunicacional;
import gob.cpccs.repository.rendicion.ProyectoComunicacionalRepository;

@Service
public class ProyectoComunicacionalServiceImpl  implements ProyectoComunicacionalService{

	@Autowired
	private ProyectoComunicacionalRepository proyecto;
	
	@Override
	public List<TblProyectoComunicacional> obtenerRegistrosproyectos(int infCod) {
		return proyecto.findByinfCod(infCod);
	}
	@Override
	public TblProyectoComunicacional obtenerRegistrosproyectosC(int infCod) {
		return proyecto.Buscar(infCod);
	}
	
	
	@Override
	public void guardarRegistrosProyectos(TblProyectoComunicacional TblSugerencia){
		proyecto.save(TblSugerencia);
	}
}
