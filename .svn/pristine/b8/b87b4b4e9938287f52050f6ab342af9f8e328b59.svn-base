package gob.cpccs.service.usuario;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import gob.cpccs.model.usuario.TblResponables;
import gob.cpccs.repository.usuario.ResponsableRepository;

@Service
public class ResponsableServicioImpl implements ResponsableServicio{
	@Autowired
	private ResponsableRepository ResponsableRepository;

	@Override
	public void GuardarResponsables(TblResponables tblResponables) {
		ResponsableRepository.save(tblResponables);
		
	}

	@Override
	public TblResponables buscarResponXemailTipoPeriodo(String responEmail, String responTipo, String responPeriodo) {
		
		return ResponsableRepository.findByResponEmailAndResponTipoAndResponPeriodo(responEmail, responTipo, responPeriodo);
	}

	@Override
	public TblResponables buscarResponxCodintituciotipoPeriodo(Integer responCodRefe, String responTipo,	String responPeriodo) {
	
		return ResponsableRepository.findByResponCodRefeAndResponTipoAndResponPeriodo(responCodRefe, responTipo, responPeriodo);
	}

	
	@Override
	public List<TblResponables>buscarResponsableXcodigoInstitucion( int codigo,String periodo) {
		return ResponsableRepository.findByResponCodRefeAndResponPeriodo( codigo, periodo);
	}
	@Override
	public void actualizarResponsableXcod(String responNombre, String responEmail,String responCargo, Integer responCodigo, Date fechaDesignacion, String celular) {
		ResponsableRepository.actualizarResponsableXcod(responNombre, responEmail,responCargo, responCodigo,fechaDesignacion,celular);
		
	}
	@Override
	public void borrarResponsableXcodyperiodo(int responCodigo, String periodo) {
		ResponsableRepository.BorrarResponsableXcodYperiodo(responCodigo, periodo);
		
	}

	@Override
	public TblResponables obtenerResponsableResponCodigo(Integer responCodigo) {
		return ResponsableRepository.findByResponCodigo(responCodigo);
	}

}
