package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblPlanTrabajoGad;
@Repository
@Transactional
public interface PlanTrabajoRepository extends JpaRepository<TblPlanTrabajoGad,String>{
	 @Query("select t from TblPlanTrabajoGad t where  t.infCod.infCod=:infCod order by t.ptgCod asc")
	List<TblPlanTrabajoGad> findByinfCod(@Param("infCod") int infCod);

}
