package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblCoberturaGeografica;
import gob.cpccs.repository.rendicion.CoberturaGeograficaRepository;

@Service
public class CoberturaGeograficaServiceImpl implements CoberturaGeograficaService{
    @Autowired
    private CoberturaGeograficaRepository CoberGeog;
	@Override
	public void guardarCoberturaGeografica(TblCoberturaGeografica tblCoberturaGeografica) {
		CoberGeog.save(tblCoberturaGeografica);		
	}

	@Override
	public List<TblCoberturaGeografica> ObtenerRegistrosCoberturaGeograficaXInfCod(Integer infCod) {
		return CoberGeog.findByinfCod(infCod);
	}

}
