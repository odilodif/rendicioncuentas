package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblModalidadEstudios;
import gob.cpccs.model.rendicion.TblObjetivosPlanDesarrollo;
import gob.cpccs.repository.rendicion.ModalidadEstudioRepository;

@Service
public class  ModalidadEstudioServiceImpl implements ModalidadEstudioService{
	
	@Autowired
	private ModalidadEstudioRepository ModalidadEstudioRepository;
	
	@Override
	public void guardarModalidadEstudios(TblModalidadEstudios tblModalidadEstudios) {
		ModalidadEstudioRepository.save(tblModalidadEstudios);
	}
	
	@Override
	public List<Object[]> obtenerRegistroModalidadEstudiosXcod(TblInforme tblInforme) {
		return ModalidadEstudioRepository.buscarModalidadEstudios(tblInforme);
	}
	
	@Override
	public List<TblModalidadEstudios> OntenerModalidadEstudiosXcod(TblInforme tblInforme) {
		return ModalidadEstudioRepository.findByInfCod(tblInforme);
	}
	
}
