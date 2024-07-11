package gob.cpccs.service.autoridad;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.usuario.TblAutoridad;
import gob.cpccs.repository.autoridad.AutoridadJPARepository;
import gob.cpccs.repository.QuerysNativosRepository;

@Service
public class AutoridadServicioImpl implements AutoridadServicio {

 @Autowired
 private AutoridadJPARepository autoridadRepository;
 
 @Autowired
 private QuerysNativosRepository QuerysNativosRepository;
 
@Override
public void guardarAutoridad(TblAutoridad tblAutoridad) {
	autoridadRepository.save(tblAutoridad);
	
}

@Override
public TblAutoridad buscarAutoridadXidentificadorPeriodo(String identificador, Integer periodo) {
	
	return autoridadRepository.findByEmailAndPeriodo(identificador, periodo);
}

@Override
public List<Object[]> buscarAutoridadXEstadoPeriodo(String estado, Integer periodo) {
	
	return autoridadRepository.findByEstadoAndPeriodo(estado, periodo);
}

@Override
public List<Object[]> buscarAutoridadDatosContactoXEstadoPeriodo(String estado, Integer periodo) {
	
	return autoridadRepository.findByEstadoAndPeriodoDatos(estado, periodo);
}

@Override
public List<Object[]> buscarAutoridadCumplimiento(String autVerificador, Integer periodo) {
	
	return QuerysNativosRepository.ObtenerAutoridadesCumplimineto(autVerificador, periodo);
}

@Override
public List<Object[]> buscarAutoridadCumplimientoProvincia(String autVerificador, Integer periodo,  Integer provincia) {
	
	return QuerysNativosRepository.ObtenerAutoridadesCumpliminetoProvincia(autVerificador, periodo,   provincia);
}

@Override
public List<Object[]> buscarAutoridadInCumplimiento(String autVerificador, Integer periodo) {
	
	return QuerysNativosRepository.ObtenerAutoridadesInCumplimineto(autVerificador, periodo);
}

@Override
public List<Object[]> buscarAutoridadInCumplimientoProvincia(String autVerificador, Integer periodo, Integer provincia) {
	
	return QuerysNativosRepository.ObtenerAutoridadesInCumpliminetoProvincia(autVerificador, periodo, provincia);
}


@Override
public TblAutoridad buscarAutordadCodAut(Integer autCodigo) {
	
	return autoridadRepository.findByAutCodigo(autCodigo);
}
@Override
public TblAutoridad buscarAutordadCodAutPeriodo(Integer autCodigo, Integer periodo) {
	
	return autoridadRepository.findByAutCodigoAndPeriodo(autCodigo, periodo);
}

@Override
public void actualizarAutoridadXid(String nombre, String identificador, String email, String password,String dignidad, Integer autCodigo) {
	autoridadRepository.actualizarAutoridasXCodigo(nombre, identificador, email, password,dignidad, autCodigo);
	
}

@Override
public void BorrarAutoridadXid(Integer autCodigo) {
	autoridadRepository.BorrarAutoridasXCodigo(autCodigo);
	
}

@Override
public void actualizarAutoridadVerificador(Integer autCodigo, Integer periodo , String autVerificador) {
	autoridadRepository.actualizarVerificadorAutoridasXCodigo(autCodigo, periodo, autVerificador);
	
}

@Override
public Integer conteoEstadosAutoridades(int periodo, String estado) {
	return autoridadRepository.contarAutoridades(periodo, estado);
}

@Override
public Integer conteoEstadosProcesoAutoridades(int periodo, String autVerificador) {
	
	return autoridadRepository.contarEstadoProcesoAutoridades(periodo, autVerificador);
}

@Override
public Integer conteoEstadosProcesoInformesAutoridades(int infAutPeriodo, String infAutVerificador) {
	
	return autoridadRepository.contarEstadoProcesoInformesAutoridades(infAutPeriodo, infAutVerificador);
}

@Override
public Integer conteoCatastroAutoridades(int periodo) {
	
	return autoridadRepository.contarCatastroAutoridades(periodo);
}

@Override
public List<Object[]> buscarAutoridadDatosContactoXIdentificadorPeriodo(String identificador, Integer periodo) {
	// TODO Auto-generated method stub
	 return autoridadRepository.findByEstadoAndPeriodoDatos(identificador, periodo);
}

//provincia
@Override
public List conteoEstadosProcesoInformesAutoridadesxProvincia(int infAutPeriodo, String infAutVerificador, int provincia) {
	
	return QuerysNativosRepository.contarEstadosProcesoInformesAutoridadesxProvincia(infAutPeriodo, infAutVerificador, provincia);
}

@Override
public Integer conteoEstadosAutoridadesxProvincia(int periodo, String estado, int provincia) {
	return autoridadRepository.contarAutoridadesxProvincia(periodo, estado, provincia);
}

@Override
public Integer conteoCatastroAutoridadesxProvincia(int periodo, String estado, int provincia) {
	
	return autoridadRepository.contarCatastroAutoridadesxProvincia( periodo,  estado,  provincia);
}

@Override
public List<Object[]> buscarAutoridadDatosContactoXEstadoPeriodo(String estado, Integer periodo, Integer provincia) {
	
	return autoridadRepository.findByEstadoAndPeriodoDatosXprovincia(estado, periodo,  provincia);
}

@Override
public List<TblAutoridad> ListaAutoridadXAucodigo(Integer autCodigo) {	
	return autoridadRepository.findByAutCodigoOrderByAutCodigo(autCodigo);
}

}
