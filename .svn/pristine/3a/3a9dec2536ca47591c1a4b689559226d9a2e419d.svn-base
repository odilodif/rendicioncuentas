package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblCompromisosInformeant;
import gob.cpccs.repository.rendicion.TblCompromisosInformeantRepository;

@Service
public class CompromisosInformeAntioresServiceImpl implements CompromisosInformeAntioresService {
 
	@Autowired
	private TblCompromisosInformeantRepository CompromisosAnterios;
	
	@Override
	public void guardarCoberturaGeografica(TblCompromisosInformeant tblCompromisosInformeant) {
		CompromisosAnterios.save(tblCompromisosInformeant);
	}

	@Override
	public List<TblCompromisosInformeant> ObtenerRegistrosCompromisosAnterioresXInfCod(Integer infCod) {
		return CompromisosAnterios.findByinfCod(infCod);
	}

}
