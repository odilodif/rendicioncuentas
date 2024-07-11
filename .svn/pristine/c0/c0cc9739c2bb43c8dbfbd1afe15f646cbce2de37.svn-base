package gob.cpccs.repository.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.aplicacion.TblAplicaciones;
import gob.cpccs.model.aplicacion.TblAplicacionesRegistradas;

@Repository
@Transactional
public interface AplicacionesRegistradasRepository extends JpaRepository<TblAplicacionesRegistradas, String> {

	public List<TblAplicacionesRegistradas> findByIdentificadorAndIdAplicacionAndEmailIdentificadorAndPeriodoAndEstado(
			@Param("identificador") String identificador, @Param("idAplicacion") TblAplicaciones idAplicacion,
			@Param("emailIdentificador") String emailIdentificador, @Param("periodo") String periodo, @Param("estado") Integer estado);

	@Modifying(clearAutomatically = true)
	@Query("update TblAplicacionesRegistradas p  set p.identificador=:identificador, p.emailIdentificador=:emailIdentificador WHERE p.idAplicacionRegistrada=:idAplicacionRegistrada")
	void ActualizarAplicacionResponsable(@Param("idAplicacionRegistrada") Integer idAplicacionRegistrada,@Param("identificador") String identificador,
			@Param("emailIdentificador") String emailIdentificador);

	public List<TblAplicacionesRegistradas> findByEmailIdentificador(
			@Param("emailIdentificador") String emailIdentificador);

	TblAplicacionesRegistradas findTopByEmailIdentificadorInAndPeriodoAndEstado(@Param("emailIdentificador") String emailIdentificador, @Param("periodo") String periodo, @Param("estado") Integer estado);

	@Modifying(clearAutomatically = true)
	@Query("delete from TblAplicacionesRegistradas t  where t.identificador=:identificador and t.emailIdentificador=:emailIdentificador ")
	void borrarUsuarioaplicacion(@Param("identificador") String identificador,
			@Param("emailIdentificador") String emailIdentificador);
	List<TblAplicacionesRegistradas> findByEmailIdentificadorAndPeriodoAndEstadoOrderByIdAplicacionRegistradaAsc(
			@Param("emailIdentificador") String emailIdentificador,@Param("periodo") String periodo,@Param("estado") Integer estado);

}
