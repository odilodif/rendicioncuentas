package gob.cpccs.service.usuario;

import java.util.Date;
import java.util.List;

import gob.cpccs.model.aplicacion.TblAplicacionesRegistradas;
import gob.cpccs.model.dto.funcionarios.FuncionariosDTO;
import gob.cpccs.model.usuario.TblPerfil;
import gob.cpccs.model.usuario.TblRol;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.model.usuario.TblUsuarioRol;
import gob.cpccs.model.aplicacion.TblAplicaciones;

public interface UsuarioServicio {

	TblUsuario buscarUsuarioXidentificador(String cedula);

	TblUsuario buscarUsuarioXidentificadorPeriodoEstado(String cedula, int periodo, int estado);

	TblUsuario buscarUsuarioXCodigoInstitucion(Integer codigo, String Tipo, Integer periodo);

	void actualizarClaveAndUsuario(String nombreUsuario, String clave, String identificador);

	void guardarUsuario(TblUsuario tblUsuario);

	void GuardarRolUsuaru(TblUsuarioRol tblUsuarioRol);

	void GuardarApliRegistradas(TblAplicacionesRegistradas tblAplicacionesRegistradas);

	void ActualizarClavesUsuarios(String password, String identificador,String contrasena);

	TblRol buscarIdRolxNombre(String rolDescripcion);

	List<TblPerfil> buscarPerfilesPorListaCodigoPerfil(String estado, List<String> descripcion);

	List<TblPerfil> buscarPerfilesEstadoPorListaCodigoPerfil(String estado, List<Integer> idPerfil);

	List<TblPerfil> buscarPerfilesPorListaCodigoPerfil1(Integer idPerfil);

	List<TblAplicacionesRegistradas> buscarAplicacionesRegistradasPorIdentificadorAndIdAplicacion(String identificador,
			TblAplicaciones idAplicacion, String emailIdentificador, String periodo, Integer estado);

	List<TblUsuarioRol> buscarUsuariosPerfilesPorIdentificadorAndIdPerfil(TblUsuario idUser, TblPerfil idPerfil);

	TblUsuario buscarUsuarioXEmail(String email, Integer periodo);

	TblUsuario BuscarUsuarioEmailXperido(String email, Integer periodo);

	TblUsuario BuscarEmailXperiodoIdUser(String email, Integer periodo, Integer idUser);

	TblUsuario BuscarIdentificadorXperiodoTipo(String identificador, Integer periodo, String tipoUser);

	List<Object[]> buscarUsuarioProvinciaEstadoPeriodo(Integer provincia, Integer estado, Integer periodo,
			String tipoUser);

	void actualizarClaveAndUsuariointerno(String nombre, String password, String codigoTemporal, String identificador);

	TblUsuario buscarUsuarioXid(Integer idUser);

	TblUsuarioRol obtenerUsuarioRolXid(Integer idUser);

	List<TblUsuarioRol> obtenerListUsuarioRolXid(Integer idUser);

	List<TblUsuario> obtenerUsuarioXEstadotipo(Integer estado, String tipoUser);

	List<Object[]> obteneUsuarioXtipo(String tipoUser, Integer periodo);

	void actualizarPerfil(String nombre, String email, String identificador, String password, Integer idUser,
			Date fechaNacimiento, String nombreAbuela, String codigoTemporal);

	void actualizarAplicacionesRegistro(Integer idAplicacionRegistrada, String identificador,
			String emailIdentificadorNuevo);

	List<TblAplicacionesRegistradas> buscarAplicacionesRegistradasPorEmaeilidentifiador(String emailIdentificador);

	List<TblAplicacionesRegistradas> buscarAplicacionesRegistradasPorEmaeilIdentifiadorPerioEstado(
			String emailIdentificador, String periodo, Integer estado);

	TblAplicacionesRegistradas buscarAplicacionRegistradaPorEmaeilidentifiador(String emailIdentificador,
			String periodo, Integer estado);

	void BorrarUsuarioroXco(int responCodigo);

	void BorrarUsuario(int responCodigo);

	void borraraplicacionusuario(String identificador, String email);

	FuncionariosDTO obternerDatosUsuarioDatosFuncionarioUsuRol(Integer idUser);

	TblUsuario buscarCodigoAutoridaXperidoXestado(Integer codigo, Integer estado, Integer periodo, String tipoUser);
}
