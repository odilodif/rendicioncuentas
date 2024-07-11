package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblIncoporacionRecomendaciones;
import gob.cpccs.repository.rendicion.IncoporacionRecomendacionesRepository;
@Service
public class IncoporacionRecomendacionesServiceImpl implements IncoporacionRecomendacionesService{
    @Autowired
    private IncoporacionRecomendacionesRepository IncorporacionRecomendaciones;
	@Override
	public List<TblIncoporacionRecomendaciones> obtenerRegistroIncorporacionRecomendaciones(Integer infCod) {
	
		return IncorporacionRecomendaciones.findByinfCod(infCod);
	}

	@Override
	public void guardarControlSocial(TblIncoporacionRecomendaciones tblIncoporacionRecomendaciones) {
		IncorporacionRecomendaciones.save(tblIncoporacionRecomendaciones);
		
	}

	@Override
	public TblIncoporacionRecomendaciones ObtenerRegistroIncorpocionRecomendaciones(Integer ireCod) {
		return IncorporacionRecomendaciones.findByIreCod(ireCod);
	}

}
