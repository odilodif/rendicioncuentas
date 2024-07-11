package gob.cpccs.repository.rendicion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblPlanificacionParticipativa;

@Repository
@Transactional
public interface TblPlanificacionParticipativaRepository extends JpaRepository<TblPlanificacionParticipativa, String> {
	@Query("select t from TblPlanificacionParticipativa t where  t.infCod.infCod=:infCod order by t.plaCod asc")
	List<TblPlanificacionParticipativa> findByinfCod(@Param("infCod") Integer infCod);
	@Query("select COUNT(t) from TblPlanificacionParticipativa t where  t.infCod.infCod=:infCod and t.plaDescripcion=:plaDescripcion")
	Integer coutPP(@Param("infCod") int infCod,@Param("plaDescripcion") String plaDescripcion);
	@Query("select t from TblPlanificacionParticipativa t where  t.infCod.infCod=:infCod and t.plaDescripcion=:plaDescripcion")
	TblPlanificacionParticipativa BuscarNombreinfoCod(@Param("infCod") int infCod,@Param("plaDescripcion") String plaDescripcion);
}
