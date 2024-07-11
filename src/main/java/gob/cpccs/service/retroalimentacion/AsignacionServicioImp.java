package gob.cpccs.service.retroalimentacion;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.retroalimentacion.TblAsignacion;
import gob.cpccs.repository.retroalimentacion.*;
@Service
public class AsignacionServicioImp implements AsignacionServicio{
	@Autowired
	 private AsignacionRepository AsignacionRepository;
	

	@Override
	public void guardarAsignacion(TblAsignacion tblAsignacion) {
		 AsignacionRepository.save(tblAsignacion);
		
	}
	
	@Override
	public TblAsignacion buscarInformeAsignado(int infcod) {
		return AsignacionRepository.findFirstByInfCod(infcod);
		
	}

	@Override
	public void actualizarEstadoInformeAsignado(int idAsignacion, String estadoAsig) {
		 AsignacionRepository.actualizarEstado(idAsignacion, estadoAsig);
		
	}

	@Override
	public void ElimnarAsignacion(String identificador, String estadoAsig) {
		AsignacionRepository.DeleteTblAsignacionXIdentificadorAnd(identificador, estadoAsig);
		
	}
	
	@Override
	public void ElimnarAsignacionPorPerido(String identificador, String estadoAsig, int periodoAsig) {
		AsignacionRepository.DeleteTblAsignacionXIdentificadorAndPeriodo(identificador, estadoAsig, periodoAsig);
		
	}

}
