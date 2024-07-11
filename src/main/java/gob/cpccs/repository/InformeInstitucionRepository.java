package gob.cpccs.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblEjecucionProgramatica;
import gob.cpccs.model.rendicion.TblInforme;

@Repository
@Transactional
public interface InformeInstitucionRepository extends JpaRepository<TblInforme, Integer>{
	
	 @Query("SELECT t FROM TblInforme t WHERE t.instCod =:instCod")
	    public List<Object[]> BuscarInstitucionXInstCod(@Param("instCod") int instCod);
	    TblInforme findByInstCodAndInfPeriodo(@Param("instCod") int instCod,@Param("infPeriodo") int infPeriodo);
	    TblInforme findByinfCodAndInfPeriodo(@Param("infCod") int infCod,@Param("infPeriodo") int infPeriodo);
	    @Modifying(clearAutomatically = true)
		@Query("update TblInforme t set t.infGprEducacion=:infGprEducacion WHERE t.infCod=:infCod")
		void actualizarInformeGrupoEducacion(@Param("infGprEducacion") String infGprEducacion,@Param("infCod") int infCod);
	    public TblInforme findByInfCod(@Param("infCod")int infCod);
	    
	    @Modifying(clearAutomatically = true)
		@Query("update TblInforme t set t.infEstado=:infEstado, t.infVerificador=:infVerificador, t.infContadorApertura=:infContadorApertura WHERE t.infCod=:infCod")
		void aperturaInforme(@Param("infEstado") String infEstado,@Param("infCod") int infCod, @Param("infVerificador") String infVerificador,@Param("infContadorApertura") Integer infContadorApertura);
	   
	    @Query(value="SELECT esq_rendicioncuentas.verificarinformegad(:infCod,:infAutPeriodo);", nativeQuery = true)
	    String listaProcedure(@Param("infCod")  int infCod, @Param("infAutPeriodo") int infAutPeriodo);
	    
	    @Query(value="SELECT esq_rendicioncuentas.verificarinformevinculadagad(:infCod,:infAutPeriodo);", nativeQuery = true)
	    String listaProcedureVinculadas(@Param("infCod")  int infCod, @Param("infAutPeriodo") int infAutPeriodo);
	    
	    @Query(value="SELECT esq_rendicioncuentas.verificarinformees(:infCod,:infAutPeriodo);", nativeQuery = true)
	    String listaProcedureES(@Param("infCod")  int infCod, @Param("infAutPeriodo") int infAutPeriodo);
	    
	    @Query(value="SELECT esq_rendicioncuentas.verificarinformeepgad(:infCod,:infAutPeriodo);", nativeQuery = true)
	    String listaProcedureGADEP(@Param("infCod")  int infCod, @Param("infAutPeriodo") int infAutPeriodo);
	    
	    @Query(value="SELECT esq_rendicioncuentas.verificarinformeFe(:infCod,:infAutPeriodo);", nativeQuery = true)
	    String listaProcedureFE(@Param("infCod")  int infCod, @Param("infAutPeriodo") int infAutPeriodo);
	    
	    @Query(value="SELECT esq_rendicioncuentas.verificarinformeepfe(:infCod,:infAutPeriodo);", nativeQuery = true)
	    String listaProcedureFEEP(@Param("infCod")  int infCod, @Param("infAutPeriodo") int infAutPeriodo);
	    
	    @Query(value="SELECT esq_rendicioncuentas.verificarinformemedio(:infCod,:infAutPeriodo);", nativeQuery = true)
	    String listaProcedureMedios(@Param("infCod")  int infCod, @Param("infAutPeriodo") int infAutPeriodo);
	    
	    @Query(value="SELECT esq_rendicioncuentas.verificarinformeiess(:infCod,:infAutPeriodo);", nativeQuery = true)
	    String listaProcedureIESS(@Param("infCod")  int infCod, @Param("infAutPeriodo") int infAutPeriodo);
	    
	    @Modifying(clearAutomatically = true)
	  	@Query("update TblInforme t set t.infEstado=:infEstado,  t.infFechafin=:infFechafin, t.infVerificador=:infVerificador   WHERE t.instCod=:instCod")
	  	void finalizar(@Param("instCod")  int infAutCod, @Param("infEstado") String infEstado, @Param("infFechafin") Date infFechafin,  @Param("infVerificador") String infVerificador  );
	    
	    @Modifying(clearAutomatically = true)
	  	@Query("update TblInforme t set t.infEstado=:infEstado   WHERE t.instCod=:instCod")
	  	void finalizarPlazo(@Param("instCod")  int infAutCod, @Param("infEstado") String infEstado);
	    
	    public TblInforme findByInstCod(@Param("instCod")int instCod);
}
