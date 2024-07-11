package gob.cpccs.repository.autoridad;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.usuario.TblAutoridad;

@Repository
@Transactional
public interface AutoridadJPARepository extends JpaRepository<TblAutoridad, String> {

	TblAutoridad findByIdentificador(@Param("rolDescripcion") String rolDescripcion);
	
	List<TblAutoridad> findByProvinciaAndEstadoAndPeriodo(@Param("provincia") Integer provincia, @Param("estado") String estado,@Param("periodo") Integer periodo);
	
	List<TblAutoridad> findByIdentificadorAndEstadoAndPeriodo(@Param("identificador") String identificador, @Param("estado") String estado,@Param("periodo") Integer periodo);

	
	TblAutoridad findByAutCodigoAndPeriodo(@Param("autCodigo") Integer autCodigo, @Param("periodo") Integer periodo);

	
	@Query("SELECT a.autCodigo,	a.nombre, a.identificador, a.dignidad, (SELECT l.nombre FROM TblLocalizacion l  WHERE l.idLocalizacion=a.provincia) AS provincia,  a.estado, a.fechaRegistro FROM TblAutoridad a WHERE a.estado=:estado AND a.periodo=:periodo")
	List<Object[]> findByEstadoAndPeriodo(@Param("estado") String estado, @Param("periodo") Integer periodo);	
	
	@Query("SELECT a.autCodigo,	a.nombre, a.identificador, a.dignidad, (SELECT l.nombre FROM TblLocalizacion l  WHERE l.idLocalizacion=a.provincia) AS provincia,  a.estado, a.fechaRegistro, a.email, a.celular FROM TblAutoridad a WHERE a.estado=:estado AND a.periodo=:periodo  and a.autVerificador is NULL ")
	List<Object[]> findByEstadoAndPeriodoDatos(@Param("estado") String estado, @Param("periodo") Integer periodo);	
	
	TblAutoridad findByEmailAndPeriodo(@Param("email") String identificador,
			@Param("periodo") Integer periodo);	
	TblAutoridad findByAutCodigo(@Param("autCodigo") Integer autCodigo);
	
	@Modifying(clearAutomatically = true)
	@Query("update TblAutoridad t set t.nombre=:nombre,t.identificador=:identificador,t.email=:email,t.password=:password, t.dignidad=:dignidad where t.autCodigo=:autCodigo")
	void actualizarAutoridasXCodigo(@Param("nombre") String nombre, @Param("identificador") String identificador, @Param("email") String email, @Param("password") String password,
			@Param("dignidad") String dignidad,@Param("autCodigo") Integer autCodigo);
	
	@Modifying(clearAutomatically = true)
	@Query("delete from TblAutoridad t where t.autCodigo=:autCodigo")
	void BorrarAutoridasXCodigo(@Param("autCodigo") Integer autCodigo);
	
	
	@Modifying(clearAutomatically = true)
	@Query("update TblAutoridad t set t.autVerificador=:autVerificador where t.autCodigo=:autCodigo and t.periodo=:periodo ")
	void actualizarVerificadorAutoridasXCodigo(@Param("autCodigo") Integer autCodigo, @Param("periodo") Integer periodo, @Param("autVerificador") String autVerificador);

	
	@Query("SELECT COUNT(*)  from TblAutoridad WHERE estado=:estado and periodo=:periodo and autVerificador IS NULL ")
	Integer contarAutoridades(@Param("periodo") int periodo, @Param("estado")String estado);
	
	@Query("SELECT COUNT(*)  from TblAutoridad WHERE autVerificador=:autVerificador and periodo=:periodo")
	Integer contarEstadoProcesoAutoridades(@Param("periodo") int periodo, @Param("autVerificador")String autVerificador);
	
	@Query("SELECT COUNT(*)  from TblInformeAutoridad WHERE infAutVerificador=:infAutVerificador and infAutPeriodo=:infAutPeriodo")
	Integer contarEstadoProcesoInformesAutoridades(@Param("infAutPeriodo") int infAutPeriodo, @Param("infAutVerificador")String infAutVerificador);
	
	@Query("SELECT COUNT(*)  from TblAutoridad where periodo=:periodo and estado <> 'eliminado'")
	Integer contarCatastroAutoridades(@Param("periodo") int periodo);
	
	@Query("SELECT COUNT(*)  from TblAutoridad WHERE estado=:estado and periodo=:periodo and autVerificador IS NULL and provincia=:provincia")
	Integer contarAutoridadesxProvincia(@Param("periodo") int periodo, @Param("estado")String estado, @Param("provincia") int provincia);
	
	@Query("SELECT COUNT(*)  from TblAutoridad where periodo=:periodo and provincia=:provincia and estado<>:estado ")
	Integer contarCatastroAutoridadesxProvincia(@Param("periodo") int periodo, @Param("estado")String estado, @Param("provincia") int provincia);
	
	@Query("SELECT a.autCodigo,	a.nombre, a.identificador, a.dignidad, (SELECT l.nombre FROM TblLocalizacion l  WHERE l.idLocalizacion=a.provincia) AS provincia,  a.estado, a.fechaRegistro, a.email, a.celular FROM TblAutoridad a WHERE a.estado=:estado AND a.periodo=:periodo and a.provincia=:provincia and a.autVerificador is NULL")
	List<Object[]> findByEstadoAndPeriodoDatosXprovincia(@Param("estado") String estado, @Param("periodo") Integer periodo, @Param("provincia") Integer provincia);	
	
	List<TblAutoridad> findByAutCodigoOrderByAutCodigo(@Param("autCodigo") Integer autCodigo);
}
