package gob.cpccs.service;

import java.util.List;

import gob.cpccs.model.aplicacion.TblAplicaciones;


public interface AplicacionesUsuarioJPAServicio {
	
	 List<Object[]> AplicacionXusuario(String identificacionUsuario, String emailIdentificador);
	 List<Object[]> MenuXaplicacion(String identificacionUsuario, int idAplicacion);
	 List<Object[]> MenuXaplicacionSinEmail( int idAplicacion);

	 List<TblAplicaciones> findAll();  

	 boolean eliminarTablaCampo(int codigo, String tabla, String campo);
	 boolean eliminarTablaCampoandvalor(int codigo, String tabla, String campo,String tipo,String valor);
	 boolean ActualizarTablaCampo(String tabla, String[] columnas,String[] valores ,String condicion,String valorCondicion);
		 
	 List<Object[]> AccionesXmenu(Integer identificacionUsuario, int idMenu);

}
