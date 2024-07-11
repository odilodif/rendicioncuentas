package gob.cpccs.repository.rendicion;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblEjecucionProgramatica;
import gob.cpccs.model.rendicion.TblFuncionesObjetivos;
import gob.cpccs.model.rendicion.TblImplementacionPresupuesto;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblObjetivosPlanDesarrollo;
import gob.cpccs.model.rendicion.TblObservacionesNegar;

@Repository
@Transactional
public interface EjecucionProgramticaRepository extends JpaRepository<TblEjecucionProgramatica, String> {

	@Query("SELECT t FROM TblEjecucionProgramatica t WHERE t.infCod =:infCod order by t.eprCod asc ")
    public List<Object[]> BuscarInstitucionXInfCod(@Param("infCod") int infCod);
    List<TblEjecucionProgramatica> findByInfCod(@Param("infCod") int infCod);
    
    @Query(value="select distinct  t.epr_cod ,fo.obj_nombre , t.epr_tipo_competencia, t.epr_competencia_concurr, t.epr_numero,t.epr_meta, t.epr_indicador, t.epr_presultadopl, t.epr_presultadocm, t.epr_total, t.epr_gestion, t.epr_aporte_result, mt.dep_descripcion from (select epr_cod,obj_cod,epr_meta,epr_tipo_competencia,epr_competencia_concurr,epr_numero,epr_indicador,epr_presultadopl,epr_presultadocm,epr_total,epr_gestion,epr_aporte_result from esq_rendicioncuentas.tbl_ejecucion_programatica  where inf_cod=:infCod )t INNER JOIN (SELECT obj_cod obj_cod1,obj_nombre from esq_rendicioncuentas.tbl_objetivos_plan_desarrollo ) fo on fo.obj_cod1 = t.obj_cod\r\n"
    		+ "left JOIN (SELECT dep_descripcion from esq_rendicioncuentas.tbl_detalle_ejecucionp ) mt on  t.epr_meta =mt.dep_descripcion",nativeQuery = true)
    public List<Object[]> findByInfCodSQL(@Param("infCod") int infCod);
    
    @Modifying(clearAutomatically = true)
	@Query("update TblEjecucionProgramatica t set t.eprSuma=:eprSuma WHERE t.infCod=:infCod")
	void actualizarTotalEP(@Param("eprSuma") BigDecimal eprSuma,@Param("infCod") int infCod);
    public TblEjecucionProgramatica findByFoCod(@Param("foCod")int foCod);

    
    
}
