package gob.cpccs.repository.gestion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.gestion.TblPlanTrabajoFin;
@Repository
@Transactional
public interface PlanTrabajoFinRepository extends JpaRepository<TblPlanTrabajoFin, Integer>{
	@Query("select t from TblPlanTrabajoFin t where t.infAutCod.infAutCod=:infAutCod order by t.pltCod asc")
	List<TblPlanTrabajoFin> buscarPlanTrabajoPorinfAutCod(@Param("infAutCod") int infAutCod);
}
