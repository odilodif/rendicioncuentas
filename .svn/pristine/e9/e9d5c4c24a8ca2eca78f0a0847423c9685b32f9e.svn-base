package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblFasePresupuestoParticipativo;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblPresupuestoInstitucional;

@Repository
@Transactional
public interface FasePresupuestoParticipativoRepository extends JpaRepository<TblFasePresupuestoParticipativo, String>{

	
	@Query("SELECT t.faseCod,t.faseNombre,t.faseOpcion,t.faseActor,t.faseGrupo, t.faseLink FROM TblFasePresupuestoParticipativo t WHERE t.infoCod =:infCod")
	List<Object[]>buscarFases(@Param("infCod") TblInforme infCod);
	@Query("select COUNT(t) from TblFasePresupuestoParticipativo t where  t.infoCod=:infCod and t.faseNombre=:faseNombre")
	Integer coutFPP(@Param("infCod") TblInforme infCod,@Param("faseNombre") String faseNombre);
	@Query("SELECT t FROM TblFasePresupuestoParticipativo t WHERE t.infoCod=:infCod and t.faseNombre=:faseNombre")
	TblFasePresupuestoParticipativo buscarFasesinfocod(@Param("infCod") TblInforme infCod,@Param("faseNombre") String faseNombre);
	

}
