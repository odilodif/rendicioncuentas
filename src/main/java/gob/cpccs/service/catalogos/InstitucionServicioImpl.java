package gob.cpccs.service.catalogos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.catalogos.TblInstitucion;
import gob.cpccs.model.usuario.TblAutoridad;
import gob.cpccs.repository.catalogos.InstitucionRepository;
import gob.cpccs.repository.QuerysNativosRepository;


@Service
public class InstitucionServicioImpl implements InstitucionServicio  {
	
    @Autowired
    private InstitucionRepository InstitucionesRepository;
    
    @Autowired
    private  QuerysNativosRepository QuerysNativosRepository;
    
	@Override
	public TblInstitucion ObtenerInstitucionesXIdcodigo(Integer idcodigo) {
		return InstitucionesRepository.findByInstCod(idcodigo);
	}
	@Override
	public void guardarInstitucion(TblInstitucion tblInstitucion) {
		InstitucionesRepository.save(tblInstitucion);
		
	}
	@Override
	public Integer conteoEstadosInstituciones(int instPeriodo, String instEstado) {
		return InstitucionesRepository.contarInstituciones(instPeriodo, instEstado);
	}
	
	@Override
	public Integer conteoEstadosProcesoInstituciones(int instPeriodo, String instVerificador) {
		return InstitucionesRepository.contarEstadoProcesoInstituciones(instPeriodo, instVerificador);
	}
	
	@Override
	public List conteoInstitucionesActivas(int instPeriodo, String instEstado) {
		return QuerysNativosRepository.numeroInstitucionesActivas(instPeriodo, instEstado);
	}
	
	
	
	
	@Override
	public Integer conteoEstadosProcesoInformes(int infPeriodo, String infVerificador) {
		return InstitucionesRepository.contarEstadoProcesoInformes(infPeriodo, infVerificador);
	}
	
	@Override
	public Integer conteoCatastro(int instPeriodo, String instEstado) {
		return InstitucionesRepository.contarCatastro(instPeriodo,  instEstado);
	}
	@Override
	public void actualizarInstVerificador(Integer instCod, int instPeriodo, String instVerificador) {
		InstitucionesRepository.ActualizarDatosInstVerificadorIntitucion(instCod, instPeriodo, instVerificador);
		
	}
	
	//provincia
	@Override
	public List conteoEstadosProcesoInformesXprovincia(int infPeriodo, String infVerificador, int provCod) {
		return QuerysNativosRepository.contarEstadoProcesoInformesXprovincia(infPeriodo, infVerificador, provCod);
	}
	
	@Override
	public Integer conteoEstadosInstitucionesxprovincia(int instPeriodo, String instEstado, int provCod) {
		return InstitucionesRepository.contarInstitucionesxprovincia(instPeriodo, instEstado,  provCod);
	}
	
	@Override
	public Integer conteoCatastroxprovincia(int instPeriodo, int provCod) {
		return InstitucionesRepository.contarCatastroxPeriodoxProvincia(instPeriodo,  provCod);
	}
	
}
