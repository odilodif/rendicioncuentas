package gob.cpccs.repository.rendicion;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblDetalleEjecucionp;
import gob.cpccs.model.rendicion.TblEjecucionProgramatica;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblPlanDesarrollo;

@Repository
@Transactional
public interface ActualizarDetallePoaRepository extends JpaRepository<TblDetalleEjecucionp, String>{

	@Query("SELECT t.depCod,t.depTipo,t.depDescripcion,t.depPresplan, t.depPresejec, t.depCumple, t.depLink, t.depTotal FROM TblDetalleEjecucionp t WHERE t.infCod =:infCod order by t.depCod asc ")
    List<TblDetalleEjecucionp> BuscarRegistros(@Param("infCod")  TblInforme infCod);
	
	@Query("SELECT t FROM TblDetalleEjecucionp t WHERE t.infCod.infCod =:infCod order by t.depCod asc ")
	 List<TblDetalleEjecucionp> findByInfCod(@Param("infCod") Integer infCod);
	
	@Query("SELECT distinct t FROM TblDetalleEjecucionp t WHERE t.infCod.infCod =:infCod and  t.depDescripcion=:depDescripcion order by t.depCod asc ")
	 List<TblDetalleEjecucionp> findByInfCodAndDepDescripcion(@Param("infCod") Integer infCod, @Param("depDescripcion") String depDescripcion);

	
	@Modifying(clearAutomatically = true)
		@Query("update TblDetalleEjecucionp t set t.depTotal=:depTotal WHERE t.depCod=:depCod")
		void ActualizarTotal(@Param("depTotal") BigDecimal depTotal,@Param("depCod") int depCod);
	 
        @Modifying(clearAutomatically = true)
		@Query("update TblDetalleEjecucionp t set t.depTotal=:depTotal WHERE t.infCod.infCod=:infCod")
		void ActualizarTotalTodos(@Param("depTotal") BigDecimal depTotal, @Param("infCod") int infCod);
	    public TblDetalleEjecucionp findByDepCod(@Param("depCod")int depCod);
	  
}
