package gob.cpccs.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import gob.cpccs.model.aplicacion.TblAplicaciones;
import gob.cpccs.utilidades.Constantes;

@Component("aurDAO")
public class AplicacionesUsuarioRepositoryImpl extends FuncionesSqlRepository<TblAplicaciones>
		implements AplicacionesUsuarioRepository {

	public AplicacionesUsuarioRepositoryImpl() {
		super(TblAplicaciones.class);
	}

	@PersistenceUnit
	private EntityManagerFactory emf;

	/**
	 * sirve umet Lista las applicaciones por usuario logeado
	 * 
	 * @param identificacionUsuario
	 * @return Una lista de aplicaciones registradas para el usuario loguedao.
	 * 
	 */
	@SuppressWarnings({ "unchecked", "finally" })
	@Override
	public List<Object[]> AplicacionXusuario(String identificacionUsuario, String emailIdentificador) {
		EntityManager em = emf.createEntityManager();
		List<Object[]> lista = null;
		try {
			String sql = "select a.id_aplicacion,\r\n" + "			   a.nombre,\r\n" + "				 a.ruta,\r\n"
					+ "				 a.descripcion,\r\n" + "				 a.color,\r\n"
					+ "				 a.imagen\r\n" + "			from \r\n"
					+ "				esq_aplicacion.tbl_aplicaciones a,\r\n"
					+ "				 esq_aplicacion.tbl_aplicaciones_registradas ar\r\n" + "			where \r\n"
					+ "					ar.id_aplicacion = a.id_aplicacion and\r\n"
					+ "					a.estado_aplicacion = 'activo' and\r\n"
					+ "					ar.identificador = '" + identificacionUsuario + "' and\r\n"
					+ "					ar.periodo = '" + Constantes.periodo() + "' and\r\n"
					+ "					ar.estado = '1' and\r\n" + "                  ar.email_identificador='"
					+ emailIdentificador + "'\r\n" + "			order by 2;";
			Query query = em.createNativeQuery(sql);
			lista = query.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.clear();
			em.close();
			return lista;
		}
	}

	/**
	 * Lista el menu por aplicación
	 * 
	 * @param identificacionUsuario, idAplicacion
	 * @return Una lista con el menu de opciones para la aplicación seleccionada.
	 * 
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	/**
	 * Lista el menu por aplicación
	 * 
	 * @param identificacionUsuario, idAplicacion
	 * @return Una lista con el menu de opciones para la aplicación seleccionada.
	 * 
	 */
	@Override
	public List<Object[]> MenuXaplicacion(String identificacionUsuario, int idAplicacion) {
		EntityManager em = emf.createEntityManager();
		List<Object[]> lista = null;
		try {
			String sql = "select distinct o.id_menu,\r\n" + "			   o.nombre,\r\n"
					+ "			   o.estilo_imagen,\r\n" + "				 o.pagina,\r\n"
					+ "				 o.orden,\r\n" + "         o.id_padre\r\n"
					+ "			from esq_aplicacion.tbl_menus o,\r\n"
					+ "				 esq_aplicacion.tbl_acciones a,\r\n"
					+ "				 esq_seguridad.tbl_acciones_perfiles ap,\r\n"
					+ "				  esq_usuario.tbl_usuario_rol up,\r\n"
					+ "				  esq_usuario.tbl_usuario usu ," + "         esq_usuario.tbl_perfil p\r\n"
					+ "			where o.id_aplicacion = '" + idAplicacion + "' and\r\n" + "				 usu.email = '"
					+ identificacionUsuario + "' and\r\n"
					+ "         p.id_perfil = up.id_perfil and ap.id_perfil = up.id_perfil and\r\n"
					+ "         p.estado = 'activo' and\r\n" + "				 ap.id_accion = a.id_accion and \r\n"
					+ "				 a.id_menu = o.id_menu and\r\n" + "				 o.estado_menu = 'activo'\r\n"
					+ "			order by  o.orden asc ;";
			Query query = em.createNativeQuery(sql);
			lista = query.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
			return lista;
		}
	}

	@SuppressWarnings({ "finally", "unchecked" })
	@Override
	public List<Object[]> MenuXaplicacionSinEmail(int idAplicacion) {
		EntityManager em = emf.createEntityManager();
		List<Object[]> lista = null;
		try {
			String sql = "select distinct o.id_menu,\r\n" + "			   o.nombre,\r\n"
					+ "			   o.estilo_imagen,\r\n" + "				 o.pagina,\r\n"
					+ "				 o.orden,\r\n" + "         o.id_padre\r\n"
					+ "			from esq_aplicacion.tbl_menus o,\r\n"
					+ "				 esq_aplicacion.tbl_acciones a,\r\n"
					+ "				 esq_seguridad.tbl_acciones_perfiles ap,\r\n"
					+ "				  esq_usuario.tbl_usuario_rol up,\r\n"
					+ "				  esq_usuario.tbl_usuario usu ," + "         esq_usuario.tbl_perfil p\r\n"
					+ "			where o.id_aplicacion = '" + idAplicacion + "' and\r\n"
					+ "				 up.id_user = usu.id_user and\r\n"
					+ "         p.id_perfil = up.id_perfil and ap.id_perfil = up.id_perfil and\r\n"
					+ "         p.estado = 'activo' and\r\n" + "				 ap.id_accion = a.id_accion and \r\n"
					+ "				 a.id_menu = o.id_menu and\r\n" + "				 o.estado_menu = 'activo'\r\n"
					+ "			order by  o.orden asc ;";
			Query query = em.createNativeQuery(sql);
			lista = query.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.clear();
			em.close();
			return lista;
		}
	}

	/**
	 * Para probar la funcioalidad de listado name Query
	 */

	@Override
	public List<TblAplicaciones> buscarEstadosVeeduriaPorEstado() {

		List<TblAplicaciones> lista;
		try {
			TypedQuery<TblAplicaciones> query = namedSqlQuery("TblAplicacion.findAll");
			lista = query.getResultList();
		} catch (Exception ex) {
			throw ex;
		} finally {
			cerrarEntityManager();
		}
		return lista;

	}

	@SuppressWarnings("finally")
	@Override
	public boolean borrarDatosTabla(int codigo, String tabla, String campo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			Query query = em.createNativeQuery("delete from " + tabla + " WHERE " + campo + " =:codigo");
			query.setParameter("codigo", codigo);
			query.executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.clear();
			em.close();
			return true;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean borrarDatosTablaValor(int codigo, String tabla, String campo, String tipo, String valor) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			Query query = em.createNativeQuery(
					"delete from " + tabla + " WHERE " + campo + " =:codigo and " + tipo + " =:valor");
			query.setParameter("codigo", codigo);
			query.setParameter("valor", valor);
			query.executeUpdate();
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.clear();
			em.close();
			return true;
		}
	}

	@SuppressWarnings({ "rawtypes", "finally" })
	@Override
	public boolean ActualizarDatosTabla(String tabla, String[] columnas, String[] valores, String condicion,
			String valorCondicion) {
		HashMap<String, String> datos = new HashMap<>();
		String campos = "";
		StringBuilder resultado = new StringBuilder();
		EntityManager em = emf.createEntityManager();
		try {
			for (int i = 0; i < columnas.length; i++) {
				if (columnas[i].equals("_csrf")) {

				} else {

					datos.put(columnas[i], valores[i].replace("'", "\"").replace("{", "").replace("}", "")
							.replace("[", "").replace("]", ""));
				}
			}
			for (Map.Entry entry : datos.entrySet()) {
				resultado.append(entry.getKey() + "= " + "'" + entry.getValue() + "'").append(",");

			}
			campos = resultado.toString().substring(0, resultado.toString().length() - 1)
					.replaceAll(System.getProperty("line.separator"), " ");

			em.getTransaction().begin();
			String sql = "UPDATE " + tabla + " set " + campos + " where " + condicion + "=" + "'" + valorCondicion
					+ "'";
			Query query = em.createNativeQuery(sql);
			query.executeUpdate();
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.clear();
			em.close();
			return true;
		}
	}

	@SuppressWarnings({ "unchecked", "finally" })
	@Override
	public List<Object[]> AccionesXmenu(Integer identificacionUsuario, int idMenu) {
		EntityManager em = emf.createEntityManager();
		List<Object[]> lista = null;
		try {
			String sql = "select a.id_accion,\r\n" + "          a.pagina,\r\n"
					+ "					a.estilo_imagen,\r\n" + "					a.descripcion,\r\n"
					+ "					apl.ruta,\r\n" + "					a.estilo_color\r\n"
					+ "			from esq_aplicacion.tbl_acciones a,\r\n"
					+ "					esq_seguridad.tbl_acciones_perfiles ap,\r\n"
					+ "					esq_usuario.tbl_usuario_rol up,\r\n"
					+ "					esq_aplicacion.tbl_aplicaciones apl\r\n" + "			where up.id_user = '"
					+ identificacionUsuario + "' and\r\n" + "					up.id_perfil = ap.id_perfil and\r\n"
					+ "					ap.id_accion = a.id_accion and \r\n"
					+ "					a.id_aplicacion = apl.id_aplicacion and\r\n"
					+ "					a.id_menu = '" + idMenu + "'\r\n" + "					order by a.orden;";
			Query query = em.createNativeQuery(sql);
			lista = query.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.clear();
			em.close();
			return lista;
		}
	}

}
