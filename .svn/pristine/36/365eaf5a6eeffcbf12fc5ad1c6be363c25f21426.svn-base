package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblMecanismoParticipacionCiudadana;

@Repository
@Transactional
public interface MecanismoParticipacionRepository extends JpaRepository<TblMecanismoParticipacionCiudadana, String>{
	@Query("select t from TblMecanismoParticipacionCiudadana t where  t.infCod.infCod=:infCod order by t.mecaCod asc")
	List<TblMecanismoParticipacionCiudadana> findByinfCod(@Param("infCod") int infCod);
	@Query("select t from TblMecanismoParticipacionCiudadana t where  t.infCod.infCod=:infCod  and mecaNombre=:mecaNombre order by t.mecaCod asc")
	TblMecanismoParticipacionCiudadana findByinfCodTipo(@Param("infCod") int infCod, @Param("mecaNombre") String mecaNombre );
	@Query("select COUNT(t) from TblMecanismoParticipacionCiudadana t where  t.infCod.infCod=:infCod and t.mecaNombre=:mecaNombre")
	Integer coutMPC(@Param("infCod") int infCod,@Param("mecaNombre") String mecaNombre);
}
