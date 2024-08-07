package gob.cpccs.service.usuario;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gob.cpccs.model.aplicacion.TblAplicaciones;
import gob.cpccs.model.aplicacion.TblAplicacionesRegistradas;
import gob.cpccs.model.dto.funcionarios.FuncionariosDTO;
import gob.cpccs.model.usuario.TblPerfil;
import gob.cpccs.model.usuario.TblRol;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.model.usuario.TblUsuarioRol;
import gob.cpccs.repository.usuario.AplicacionesRegistradasRepository;
import gob.cpccs.repository.usuario.PerfilRepository;
import gob.cpccs.repository.usuario.RolRepository;
import gob.cpccs.repository.usuario.UsuarioJPARepository;
import gob.cpccs.repository.usuario.UsuarioRolRepository;


@Service
public class UsuarioServicioImpl implements UsuarioServicio {	
 @Autowired
 private UsuarioJPARepository usuarioRepository;
 @Autowired
 private AplicacionesRegistradasRepository ApliRegisradasRepository;
 @Autowired
 private UsuarioRolRepository UsuariorolRepository;
 @Autowired
 private RolRepository rolRepository;
 @Autowired
 private PerfilRepository perfilRepository;
 @Override
 public TblUsuario buscarUsuarioXidentificador(String cedula) {
      return usuarioRepository.findByIdentificador(cedula);
 }
 
 @Override
 public TblUsuario buscarCodigoAutoridaXperidoXestado (Integer codigo,Integer estado, Integer periodo, String tipoUser) {
	 return usuarioRepository.findByCodigoIntitucionAutoridaAndEstadoAndPeriodoAndTipoUser(codigo, estado, periodo, tipoUser);
 }
 @Override
 public TblUsuario buscarUsuarioXidentificadorPeriodoEstado(String cedula,int periodo,int estado) {
      return usuarioRepository.findByIdentificadorAndPeriodoAndEstado(cedula,periodo,estado);
 }
 @Override
 public TblUsuario buscarUsuarioXCodigoInstitucion(Integer codigo, String tipoUser, Integer periodo) {
      return usuarioRepository.findByCodigoIntitucionAutoridaAndTipoUserAndPeriodo(codigo, tipoUser, periodo);
 }
 
 @Override
 public void actualizarClaveAndUsuario(String nombreUsuario, String clave, String identificador) {
      usuarioRepository.actualizarClaveAndUsuarioReseteada(nombreUsuario, clave, identificador);
 }
 
@Override
public void guardarUsuario(TblUsuario tblUsuario) {
	usuarioRepository.save(tblUsuario);
	
}
@Override
public void GuardarRolUsuaru(TblUsuarioRol tblUsuarioRol) {
	UsuariorolRepository.save(tblUsuarioRol);
	
	
}
@Override
public void GuardarApliRegistradas(TblAplicacionesRegistradas tblAplicacionesRegistradas) {
	ApliRegisradasRepository.save(tblAplicacionesRegistradas);
	
}
@Override
public TblRol buscarIdRolxNombre(String rolDescripcion) {
	
	return rolRepository.findByRolDescripcion(rolDescripcion);
}
@Override
public List<TblAplicacionesRegistradas> buscarAplicacionesRegistradasPorIdentificadorAndIdAplicacion(
		String identificador, TblAplicaciones idAplicacion, String emailIdentificador, String periodo, Integer estado) {
	 return ApliRegisradasRepository.findByIdentificadorAndIdAplicacionAndEmailIdentificadorAndPeriodoAndEstado(identificador, idAplicacion, emailIdentificador,  periodo,  estado);
}

@Override
public List<TblUsuarioRol> buscarUsuariosPerfilesPorIdentificadorAndIdPerfil(TblUsuario idUser, TblPerfil idPerfil) {

	return UsuariorolRepository.findByIdUserAndIdPerfil(idUser, idPerfil);
}
@Override
public List<TblPerfil> buscarPerfilesPorListaCodigoPerfil(String estado, List<String> descripcion) {

	return perfilRepository.findByEstadoAndDescripcionIn(estado,descripcion);

}
@Override
public List<TblPerfil> buscarPerfilesPorListaCodigoPerfil1(Integer idPerfil) {
	// TODO Auto-generated method stub
	return perfilRepository.findByIdPerfil(idPerfil);
}
@Override
public void ActualizarClavesUsuarios(String password, String identificador,String contrasena) {
	usuarioRepository.actualizarClaveReseteoUsu(password, identificador,contrasena);
	
}
@Override
public TblUsuario buscarUsuarioXEmail(String email, Integer periodo) {
	
	return usuarioRepository.findByEmailAndPeriodo(email, periodo);
}

@Override
public List<TblPerfil> buscarPerfilesEstadoPorListaCodigoPerfil(String estado, List<Integer> idPerfil) {
	
	return perfilRepository.findByEstadoAndIdPerfilIn(estado, idPerfil);
}

@Override
public TblUsuario BuscarUsuarioEmailXperido(String email, Integer periodo) {	
	return usuarioRepository.BuscarusuarioEmailXperido(email, periodo);
}

@Override
public void actualizarClaveAndUsuariointerno(String nombre, String password, String codigoTemporal, String identificador) {
     usuarioRepository.actualizarClaveAndUsuarioReseteada1(nombre, password, codigoTemporal, identificador);
}

@Override
public List<Object[]> buscarUsuarioProvinciaEstadoPeriodo(Integer provincia, Integer estado,Integer periodo, String tipoUser) {
	return usuarioRepository.buscarUsuaritoProEstado(provincia, estado,periodo,tipoUser);
}

@Override
public TblUsuario buscarUsuarioXid(Integer idUser) {

	return usuarioRepository.findByIdUser(idUser);
}

@Override
public void actualizarPerfil(String nombre, String email, String identificador, String password, Integer idUser, Date fechaNacimiento,String nombreAbuela,String codigoTemporal) {
	usuarioRepository.actualizarPerfilUsuario(nombre, email, identificador, password, idUser,fechaNacimiento,nombreAbuela,codigoTemporal);
	
}

@Override
public TblUsuario BuscarEmailXperiodoIdUser(String email, Integer periodo, Integer idUser) {

	return usuarioRepository.BuscarusuarioEmailXperidoIduser(email, periodo, idUser);
}

@Override
public void BorrarUsuarioroXco(int responCodigo) {
	UsuariorolRepository.BorrarUsuariorolXcod(responCodigo);
	
}
@Override
public void BorrarUsuario(int responCodigo) {
	usuarioRepository.borrarUsuario(responCodigo);
	
}
@Override
public void borraraplicacionusuario(String identificador, String emailIdentificador) {
	ApliRegisradasRepository.borrarUsuarioaplicacion(identificador, emailIdentificador);
	
}

@Override
public void actualizarAplicacionesRegistro(Integer idAplicacionRegistrada, String identificador, String emailIdentificador) {
ApliRegisradasRepository.ActualizarAplicacionResponsable(idAplicacionRegistrada,identificador, emailIdentificador);
	
}
@Override
public List<TblAplicacionesRegistradas> buscarAplicacionesRegistradasPorEmaeilidentifiador(String emailIdentificador) {
	return ApliRegisradasRepository.findByEmailIdentificador(emailIdentificador);
}
@Override
public TblUsuarioRol obtenerUsuarioRolXid(Integer idUser) {
	return UsuariorolRepository.findByidUser(idUser);
}
@Override
public List<TblUsuario> obtenerUsuarioXEstadotipo(Integer estado,String tipoUser) {
	return usuarioRepository.findByTipoUserAndEstado(estado,tipoUser);
}
@Override
public List<Object[]> obteneUsuarioXtipo(String tipoUser,Integer periodo) {
	return usuarioRepository.findByTipoUser(tipoUser,periodo);
}
@Override
public TblAplicacionesRegistradas buscarAplicacionRegistradaPorEmaeilidentifiador(String emailIdentificador, String periodo, Integer estado) {
	return ApliRegisradasRepository.findTopByEmailIdentificadorInAndPeriodoAndEstado(emailIdentificador, periodo, estado);
}
@Override
public TblUsuario BuscarIdentificadorXperiodoTipo(String identificador, Integer periodo, String tipoUser) {
	return usuarioRepository.findByIdentificadorAndPeriodoAndTipoUser(identificador, periodo, tipoUser);
}
@Override
public List<TblAplicacionesRegistradas> buscarAplicacionesRegistradasPorEmaeilIdentifiadorPerioEstado(
		String emailIdentificador,String periodo, Integer estado) {
	return ApliRegisradasRepository.findByEmailIdentificadorAndPeriodoAndEstadoOrderByIdAplicacionRegistradaAsc(emailIdentificador, periodo, estado);
}
@Override
public FuncionariosDTO obternerDatosUsuarioDatosFuncionarioUsuRol(Integer idUser) {
	//return(FuncionariosDTO) usuarioRepository.findByUsuarioDatosFunUsuRol(idUser);
	Object[] datos = (Object[]) usuarioRepository.findByUsuarioDatosFunUsuRol(idUser);
	 
	 FuncionariosDTO datosDTO = new FuncionariosDTO();
	    datosDTO.setNombre(datos[0].toString());
	    datosDTO.setIdentificador(datos[1].toString());
	    datosDTO.setNacionalidad(datos[2].toString());
	    datosDTO.setGenero(datos[3].toString());
	    datosDTO.setFechanacimiento(new SimpleDateFormat("dd/MM/yyyy").format(datos[4]));
	    datosDTO.setProvincia((Integer)datos[5]);
	    datosDTO.setEmail(datos[6].toString());
	    datosDTO.setRol((Integer)datos[7]);
	    datosDTO.setNombreAbuela(datos[8]==null?"":datos[8].toString());
	    datosDTO.setMailPersonal(datos[9]==null?"":datos[9].toString());
	    datosDTO.setConvencional(datos[10]==null?"":datos[10].toString());
	    datosDTO.setCelular(datos[11]==null?"":datos[11].toString());	
	    datosDTO.setCargo(datos[12]==null?"":datos[12].toString());
	    datosDTO.setIdUser((Integer)datos[13]);
	    datosDTO.setCodigoTemporal(datos[14]==null?"":datos[14].toString());
	    
	return datosDTO;
	

}
@Override
public List<TblUsuarioRol> obtenerListUsuarioRolXid(Integer idUser) {
	return UsuariorolRepository.findByidUserAnd(idUser) ;
}



}
