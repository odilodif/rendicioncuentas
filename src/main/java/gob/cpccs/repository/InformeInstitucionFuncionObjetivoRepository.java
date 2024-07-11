package gob.cpccs.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblEjecucionProgramatica;
import gob.cpccs.model.rendicion.TblFuncionesObjetivos;
import gob.cpccs.model.rendicion.TblInforme;

@Repository
@Transactional
public interface InformeInstitucionFuncionObjetivoRepository  extends JpaRepository<TblFuncionesObjetivos, String> {

	
	 @Query("SELECT t FROM TblFuncionesObjetivos t WHERE t.instCod =:instCod")
	    public List<Object[]> BuscarInstitucionXInstCod(@Param("instCod") int instCod);
	    List<TblFuncionesObjetivos> findByInstCod(@Param("instCod") int instCod);
	    
	    
	    @Query("SELECT t FROM TblFuncionesObjetivos t WHERE t.instCod =:instCod and t.foTip=:foTip order by t.foCod asc")
	    public List<Object[]> BuscarInstitucionXInstCodAndfoTip(@Param("instCod") int instCod, @Param("foTip") String foTip);
	    List<TblFuncionesObjetivos> findByInstCodAndFoTip(@Param("instCod") int instCod, @Param("foTip") String foTip);	    
	    

	@Query("SELECT  t.foCod , t.foNom, t.foTip, t.foestado FROM TblFuncionesObjetivos t WHERE t.instCod =:instCod AND t.foPeriodo=:foPeriodo AND t.foestado=:foestado")
	public List<Object[]> BuscarFuncionesObjetivosInstCod(@Param("instCod") int instCod, @Param("foPeriodo") String foPeriodo, @Param("foestado") String foestado);
	
	//Query original
	
	@Query("SELECT  t.foCod , t.foNom, t.foTip, t.foestado,   (select DISTINCT p.foCod FROM TblEjecucionProgramatica p WHERE p.foCod=t.foCod)  FROM TblFuncionesObjetivos t WHERE t.instCod =:instCod AND t.foPeriodo=:foPeriodo AND t.foestado=:foestado AND t.foTip=:foTip")
	public List<Object[]> BuscarFuncionesObjetivosInstCodTipo(@Param("instCod") int instCod, @Param("foPeriodo") String foPeriodo, @Param("foestado") String foestado,  @Param("foTip") String foTip);
	
	//Query solo para competencias concurrentes
	/*
	@Query("SELECT  t.foCod , t.foNom, t.foTip, t.foestado,   (select DISTINCT p.foCod FROM TblEjecucionProgramatica p WHERE p.foCod=t.foCod)  FROM TblFuncionesObjetivos t WHERE t.instCod =:instCod AND t.foPeriodo=:foPeriodo AND t.foestado=:foestado AND t.foTip=:foTip OR t.foTip= 'COMPETENCIAS CONCURRENTES / FUNCIONES'")
	public List<Object[]> BuscarFuncionesObjetivosInstCodTipoConcurrentes(@Param("instCod") int instCod, @Param("foPeriodo") String foPeriodo, @Param("foestado") String foestado,  @Param("foTip") String foTip);
	*/	 
	
	@Query("SELECT  t.foCod , t.foNom, t.foTip, t.foestado,   (select DISTINCT p.foCod FROM TblEjecucionProgramatica p WHERE p.foCod=t.foCod)  FROM TblFuncionesObjetivos t WHERE t.instCod =:instCod AND t.foPeriodo=:foPeriodo AND t.foestado=:foestado")
	public List<Object[]> BuscarFuncionesObjetivoSinTipoInstCodTipo(@Param("instCod") int instCod, @Param("foPeriodo") String foPeriodo, @Param("foestado") String foestado);
	
	
	@Query("SELECT t FROM TblFuncionesObjetivos t WHERE t.foCod =:foCod AND t.foPeriodo=:foPeriodo")
	    public List<Object[]> BuscarFuncionesObjetivosXFoCod(@Param("foCod") int foCod);
	    TblFuncionesObjetivos findByFoCodAndFoPeriodo(@Param("foCod") int foCod,@Param("foPeriodo") String foPeriodo);
	    
}
