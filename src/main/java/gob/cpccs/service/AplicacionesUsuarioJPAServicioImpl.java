package gob.cpccs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import gob.cpccs.model.aplicacion.TblAplicaciones;
import gob.cpccs.repository.AplicacionesUsuarioRepository;

@Service
public class AplicacionesUsuarioJPAServicioImpl implements AplicacionesUsuarioJPAServicio {

	@Autowired
	@Qualifier("aurDAO")
	private AplicacionesUsuarioRepository au;

	@Override
	public List<Object[]> AplicacionXusuario(String identificacionUsuario, String emailIdentificador) {
		return au.AplicacionXusuario(identificacionUsuario, emailIdentificador);
	}

	@Override
	public List<Object[]> MenuXaplicacion(String identificacionUsuario, int idAplicacion) {
		return au.MenuXaplicacion(identificacionUsuario, idAplicacion);
	}
	
	@Override
	public List<Object[]> MenuXaplicacionSinEmail( int idAplicacion) {
		return au.MenuXaplicacionSinEmail( idAplicacion);
	}

	@Override
	public List<TblAplicaciones> findAll() {
		return au.buscarEstadosVeeduriaPorEstado();
	}
	
	@Override 
	public  boolean eliminarTablaCampo(int codigo, String tabla, String campo) {
		// TODO Auto-generated method stub
       return au.borrarDatosTabla(codigo, tabla, campo);
	}
	@Override 
	public  boolean eliminarTablaCampoandvalor(int codigo, String tabla, String campo,String tipo,String valor) {
		// TODO Auto-generated method stub
       return au.borrarDatosTablaValor(codigo, tabla, campo, tipo, valor);
	}
	@Override 
	public  boolean ActualizarTablaCampo(String tabla, String[] columnas,String[] valores ,String condicion,String valorCondicion) {
		// TODO Auto-generated method stub
       return au.ActualizarDatosTabla(tabla, columnas,valores, condicion,valorCondicion);
	}
	
	@Override
	public List<Object[]> AccionesXmenu(Integer identificacionUsuario, int idMenu) {
		return au.AccionesXmenu(identificacionUsuario,idMenu);
	}

}
