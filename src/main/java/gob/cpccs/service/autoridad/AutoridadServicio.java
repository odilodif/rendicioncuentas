package gob.cpccs.service.autoridad;

import java.util.List;

import gob.cpccs.model.usuario.TblAutoridad;

public interface AutoridadServicio {

	void guardarAutoridad(TblAutoridad tblAutoridad);

	TblAutoridad buscarAutoridadXidentificadorPeriodo(String identificador, Integer periodo);
	
	List<Object[]> buscarAutoridadXEstadoPeriodo(String estado, Integer periodo);
	
	List<Object[]> buscarAutoridadDatosContactoXEstadoPeriodo(String estado, Integer periodo);
	
	List<Object[]> buscarAutoridadDatosContactoXIdentificadorPeriodo(String identificador, Integer periodo);
	
	List<Object[]> buscarAutoridadCumplimiento(String autVerificador, Integer periodo); 
	
	List<Object[]> buscarAutoridadCumplimientoProvincia(String autVerificador, Integer periodo, Integer provincia); 

	List<Object[]> buscarAutoridadInCumplimiento(String autVerificador, Integer periodo); 

	List<Object[]> buscarAutoridadInCumplimientoProvincia(String autVerificador, Integer periodo, Integer provincia); 

	TblAutoridad buscarAutordadCodAutPeriodo(Integer autCodigo,Integer periodo);
	
	TblAutoridad buscarAutordadCodAut(Integer autCodigo);
	void actualizarAutoridadXid(String nombre, String identificador, String email, String password ,String dignidad, Integer autCodigo);
	void BorrarAutoridadXid(Integer autCodigo);
	void actualizarAutoridadVerificador(Integer autCodigo, Integer periodo, String autVerificador);
	
	Integer conteoEstadosAutoridades(int periodo, String estado);
	Integer conteoEstadosProcesoAutoridades(int periodo, String autVerificador);
	Integer conteoEstadosProcesoInformesAutoridades(int infAutPeriodo, String infAutVerificador);
	Integer conteoCatastroAutoridades(int periodo);
	
	List conteoEstadosProcesoInformesAutoridadesxProvincia(int infAutPeriodo, String infAutVerificador, int provincia);
	Integer conteoEstadosAutoridadesxProvincia(int periodo, String estado, int provincia);
	Integer conteoCatastroAutoridadesxProvincia(int periodo, String estado, int provincia);
	List<Object[]> buscarAutoridadDatosContactoXEstadoPeriodo(String estado, Integer periodo, Integer provincia );
	
	//Metodo Realizado por Carlos Morocho consultas Cel: 0995491200
	
	List<TblAutoridad> ListaAutoridadXAucodigo(Integer autCodigo);
	
	
}
