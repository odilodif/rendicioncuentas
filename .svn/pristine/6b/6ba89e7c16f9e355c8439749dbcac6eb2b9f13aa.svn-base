package gob.cpccs.repository.rendicion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblFuncionesObjetivos;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblObjetivosPlanDesarrollo;

@Repository
@Transactional
public interface ObjetivosPlanDesarrolloRepository extends JpaRepository<TblObjetivosPlanDesarrollo, String>{

	List<TblObjetivosPlanDesarrollo> findByInfCod(@Param("tblInforme") TblInforme tblInforme);
	
	/* esta se colgaba por tarer mas de un registro en las consultas anidadas
	 * @Query("SELECT t.objCod,t.objNombre,t.objTipo,t.objEstado,(select p.pdCod FROM TblPlanDesarrollo p WHERE p.objCod=t.objCod), (select ep.eprCod FROM TblEjecucionProgramatica ep WHERE ep.objCod=t.objCod) FROM TblObjetivosPlanDesarrollo t WHERE t.infCod =:infCod order by t.objCod asc "
	 * ) List<Object[]>buscarObjetivoPlan(@Param("infCod") TblInforme tblInforme);
	 */
	
	@Query("SELECT t.objCod,t.objNombre,t.objTipo,t.objEstado,(select DISTINCT p.objCod FROM TblPlanDesarrollo p WHERE p.objCod=t.objCod), (select DISTINCT ep.objCod FROM TblEjecucionProgramatica ep WHERE ep.objCod=t.objCod) FROM TblObjetivosPlanDesarrollo t WHERE t.infCod =:infCod order by t.objCod asc ")
	List<Object[]>buscarObjetivoPlan(@Param("infCod") TblInforme tblInforme);
	
	
	public TblObjetivosPlanDesarrollo findByObjCod(@Param("objCod")int objCod);
}
