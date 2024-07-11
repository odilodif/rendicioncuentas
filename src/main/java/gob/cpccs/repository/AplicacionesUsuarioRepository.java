package gob.cpccs.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import gob.cpccs.model.aplicacion.TblAplicaciones;

@Repository
public interface AplicacionesUsuarioRepository {

	/**
	 * Finds persons by using the last name as a search criteria.
	 * 
	 * @param lastName
	 * @return A list of persons which last name is an exact match with the given
	 *         last name. If no persons is found, this method returns an empty list.
	 */

	List<Object[]> AplicacionXusuario(String identificacionUsuario, String emailIdentificador);

	List<Object[]> MenuXaplicacion(String identificacionUsuario, int idAplicacion);
	List<Object[]> MenuXaplicacionSinEmail(int idAplicacion);

	public List<TblAplicaciones> buscarEstadosVeeduriaPorEstado();

	boolean borrarDatosTabla(int codigo, String tabla, String campo);
	boolean borrarDatosTablaValor(int codigo, String tabla, String campo,String tipo,String valor);
	boolean ActualizarDatosTabla(String tabla, String[] columnas,String[] valores ,String condicion,String valorCondicion);
	List<Object[]> AccionesXmenu(Integer identificacionUsuario, int idAplicacion);

}