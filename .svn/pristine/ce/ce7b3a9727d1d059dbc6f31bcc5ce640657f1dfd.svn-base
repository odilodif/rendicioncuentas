package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblPlanDesarrollo;

@Repository
@Transactional
public interface PlanDesarrolloRepository extends JpaRepository<TblPlanDesarrollo, String> {
	
	@Query("SELECT t.pdCod,t.objCod,t.pdPorcAvanceAcum,t.pdRazon,t.pdEstado FROM TblPlanDesarrollo t WHERE t.infCod =:infCod")
	List<Object[]>buscarAvances(@Param("infCod") TblInforme tblInforme);

	 
	
}
