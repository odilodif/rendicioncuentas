package gob.cpccs.service.gestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.gestion.TblFinGestion;
import gob.cpccs.repository.gestion.TblFinGestionRepository;

@Service
public class TblFinGestionServicioImpl implements TblFinGestionServicio {
	@Autowired
	private TblFinGestionRepository repoFinGestion;

	@Override
	public List<TblFinGestion> ListaFinGestio() {
		return repoFinGestion.findAll();
	}

	@Override
	public TblFinGestion ListaFinGestioEstado(String estado) {
		return repoFinGestion.findgestionestado(estado);
	}

	@Override
	public TblFinGestion ListaFinGestioEstadoIdentificador(String estado, String identificador) {
		return repoFinGestion.findgestionestadoXidentificador(estado, identificador);
	}

	@Override
	public TblFinGestion FinGestioInfoCod(Integer infocod) {
		return repoFinGestion.findgestionInfoCod(infocod);
	}
	@Override
	public List<TblFinGestion> ListaFinGestioXcedula(String identificador) {
		return repoFinGestion.findgestionXidentificador(identificador);
	}
	@Override
	public  void  GuardarFinGestio(TblFinGestion tablaFin) {
		repoFinGestion.save(tablaFin);
	}
}
