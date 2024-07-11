package gob.cpccs.repository.usuario;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.dto.funcionarios.FuncionariosDTO;
import gob.cpccs.model.usuario.TblUsuario;

@Repository
@Transactional
public interface UsuarioJPARepository extends JpaRepository<TblUsuario, String> {

	TblUsuario findByCodigoIntitucionAutoridaAndTipoUserAndPeriodo(@Param("codigoIntitucionAutorida") Integer codigoIntitucionAutorida,@Param("tipoUser") String tipoUser, @Param("periodo") Integer periodo  );
	TblUsuario findByCodigoIntitucionAutoridaAndEstadoAndPeriodoAndTipoUser (@Param("codigoIntitucionAutorida") Integer codigoIntitucionAutorida,@Param("estado") Integer estado, @Param("periodo") Integer periodo, @Param ("tipoUser") String tipoUser);
	TblUsuario findByIdentificador(@Param("identificador") String identificador);
	TblUsuario findByIdentificadorAndPeriodoAndEstado(@Param("identificador") String identificador,@Param("periodo") Integer periodo,@Param("estado") Integer estado);
	TblUsuario findByEmailAndPeriodo(@Param("email") String email, @Param("periodo") Integer periodo);

	TblUsuario findByIdentificadorAndPeriodoAndTipoUser(@Param("identificador") String identificador,
			@Param("periodo") Integer periodo, @Param("tipoUser") String tipoUser);

	@Query("SELECT t from TblUsuario t WHERE t.tipoUser=:tipoUser and t.estado=:estado order by t.idUser asc")
	List<TblUsuario> findByTipoUserAndEstado(@Param("estado") Integer estado, @Param("tipoUser") String tipoUser);

	@Query("SELECT t.idUser, t.nombre," + "t.identificador," + "t.email,"
			+ " (select p.nombre from TblLocalizacion p where p.idLocalizacion=t.provincia ) as provincia, "
			+ " t.estado," + "(select r.usurolDescripcion from TblUsuarioRol r where r.idUser=t.idUser) as rol"
			+ " from " + "TblUsuario t " + "WHERE t.tipoUser=:tipoUser and t.periodo=:periodo order by t.idUser asc")
	List<Object[]> findByTipoUser(@Param("tipoUser") String tipoUser, @Param("periodo") Integer periodo);

	@Query("SELECT  t.idUser,(select inst.instRuc from TblInstitucion inst WHERE inst.instCod=t.codigoIntitucionAutorida), (select inst.instNom from TblInstitucion inst WHERE inst.instCod=t.codigoIntitucionAutorida), t.provincia,t.nombre,t.email,t.identificador,t.nombreAbuela,t.fechaNacimiento,t.estado FROM TblUsuario t WHERE t.provincia=:provincia and t.estado=:estado and t.periodo=:periodo and t.tipoUser=:tipoUser")
	List<Object[]> buscarUsuaritoProEstado(@Param("provincia") Integer provincia, @Param("estado") Integer estado,
			@Param("periodo") Integer periodo, @Param("tipoUser") String tipoUser);

	
	@Query("SELECT t FROM TblUsuario t WHERE t.email=:email and t.periodo=:periodo")
	public TblUsuario BuscarusuarioEmailXperido(@Param("email") String email, @Param("periodo") Integer periodo);

	@Query("SELECT t FROM TblUsuario t WHERE t.email=:email and t.periodo=:periodo and t.idUser<>:idUser")
	public TblUsuario BuscarusuarioEmailXperidoIduser(@Param("email") String email, @Param("periodo") Integer periodo,
			@Param("idUser") Integer idUser);

	@Modifying(clearAutomatically = true)
	@Query("update TblUsuario t set t.email=:email,t.password=:password WHERE t.identificador=:cedula")
	void actualizarClaveAndUsuarioReseteada(@Param("email") String email, @Param("password") String password,
			@Param("cedula") String cedula);

	@Modifying(clearAutomatically = true)
	@Query("update TblUsuario t set t.password=:password ,t.codigoTemporal=:codigoTemporal WHERE t.identificador=:identificador")
	void actualizarClaveReseteoUsu(@Param("password") String password, @Param("identificador") String identificador,@Param("codigoTemporal") String codigoTemporal);

	@Modifying(clearAutomatically = true)
	@Query("update TblUsuario t set t.nombre=:nombre,t.password=:password,t.codigoTemporal=:codigoTemporal WHERE t.identificador=:identificador")
	void actualizarClaveAndUsuarioReseteada1(@Param("nombre") String nombre, @Param("password") String password,
			@Param("codigoTemporal") String codigoTemporal, @Param("identificador") String identificador);

	TblUsuario findByIdUser(@Param("idUser") Integer idUser);

	@Modifying(clearAutomatically = true)
	@Query("update TblUsuario t set t.nombre=:nombre,t.email=:email,t.identificador=:identificador,t.password=:password, t.fechaNacimiento=:fechaNacimiento,t.nombreAbuela=:nombreAbuela,t.codigoTemporal=:codigoTemporal WHERE t.idUser=:idUser")
	void actualizarPerfilUsuario(@Param("nombre") String nombre, @Param("email") String email,
			@Param("identificador") String identificador, @Param("password") String password,
			@Param("idUser") Integer idUser, @Param("fechaNacimiento") Date fechaNacimiento,
			@Param("nombreAbuela") String nombreAbuela,@Param("codigoTemporal") String codigoTemporal);

	@Modifying(clearAutomatically = true)
	@Query("delete from TblUsuario t  where t.idUser=:idUser  ")
	void borrarUsuario(@Param("idUser") Integer idUser);
	
	@Query(value = "SELECT usu.nombre,usu.identificador,fun.nacionalidad,fun.genero,fun.fecha_nacimiento fechanacimiento,fun.id_provincia provincia,usu.email,usuRol.id_rol rol, usu.nombre_abuela abuela,fun.mail_personal email2,fun.convencional,fun.celular,fun.cargo,usu.id_user,usu.codigo_temporal  FROM esq_usuario.tbl_usuario  usu \r\n"
			+ "			LEFT JOIN esq_usuarios_internos.tbl_datos_funcionarios fun on usu.identificador=fun.identificador \r\n"
			+ "			LEFT JOIN esq_usuario.tbl_usuario_rol usuRol on usu.id_user=usuRol.id_user \r\n"
			+ "			WHERE usu.id_user=:idUser", nativeQuery = true)
     Object findByUsuarioDatosFunUsuRol(@Param("idUser")Integer idUser);

}
