package gob.cpccs.service.retroalimentacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.retroalimentacion.TblValoracion;
import gob.cpccs.repository.retroalimentacion.*;
import gob.cpccs.repository.*;

@Service
public class InformeValoradoServiceImpl implements  InformeValoradoService{
	@Autowired
	 private  InformeValoradoRepository InformeValoradoRepository;

	@Autowired
	 private QuerysNativosRepository QuerysNativosRepository;
	 
	@Override
	public void guardarInformeValorado(TblValoracion tblValoracion) {
		InformeValoradoRepository.save(tblValoracion);		
	}

	@Override
	public List<Object[]> obtenerRegistroInformeValoradoXInfocod(Integer infcod ) {
		return QuerysNativosRepository.qryObtenerRegistrosInformesValoradosXInfocodAndPeriodo(infcod);
	}

	@Override
	public List<Object[]> obtenerRegistrosInformesValorados() {
		return QuerysNativosRepository.qryObtenerRegistrosInformesValorados();
	}
	
	
}
