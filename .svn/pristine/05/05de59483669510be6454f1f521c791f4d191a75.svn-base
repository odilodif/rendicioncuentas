package gob.cpccs.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblInformeAutoridad;

@Repository
@Transactional
public interface InformeRepository extends JpaRepository<TblInformeAutoridad, String> {
	
		@Query("SELECT t FROM TblInformeAutoridad t WHERE t.identificador =:identificador and t.infAutPeriodo=:infAutPeriodo")
		public TblInformeAutoridad findByInfAutCodAndInfAutPeriodo(@Param("identificador") int identificador, @Param("infAutPeriodo") Integer infAutPeriodo);

		@Query("SELECT t FROM TblInformeAutoridad t WHERE t.infAutCod =:infAutCod and t.infAutPeriodo=:infAutPeriodo")
		public TblInformeAutoridad findByInfAutCodAndInfAutPeriodo2(@Param("infAutCod") int identificador, @Param("infAutPeriodo") Integer infAutPeriodo);

		
		@Query("SELECT t FROM TblInformeAutoridad t WHERE t.identificador =:codigoIntitucionAutorida and t.infAutPeriodo=:infAutPeriodo")
		public List<Object[]> listaInformes(@Param("codigoIntitucionAutorida") int codigoIntitucionAutorida, @Param("infAutPeriodo") Integer infAutPeriodo);
	    
		@Query("SELECT t FROM TblInformeAutoridad t WHERE t.identificador =:identificador and t.infAutPeriodo=:infAutPeriodo")
		public TblInformeAutoridad findByIdentificadorAndInfAutPeriodo(@Param("identificador") int identificador, @Param("infAutPeriodo") Integer infAutPeriodo);
		
		@Modifying(clearAutomatically = true)
		@Query("update TblInformeAutoridad t set t.infAutEstado=:infAutEstado, t.infAutVerificador=:infAutVerificador, t.infContadorApertura=:infContadorApertura WHERE t.infAutCod=:infAutCod")
		void aperturaInforme(@Param("infAutEstado") String infAutEstado,@Param("infAutCod") int infAutCod, @Param("infAutVerificador") String infAutVerificador,@Param("infContadorApertura") Integer infContadorApertura);
		
		
	    @Modifying(clearAutomatically = true)
		@Query("update TblInformeAutoridad t set t.numeroAsistentes=:numeroAsistentes, t.fechaRendicion=:fechaRendicion, t.lugar=:lugar WHERE t.infAutCod=:infAutCod")
		void actualizarInformeAutoridadxId( @Param("fechaRendicion") Date fechaRendicion, @Param("lugar") String lugar, @Param("numeroAsistentes") Integer numeroAsistentes, @Param("infAutCod") int infAutCod);
	    public TblInformeAutoridad findByInfAutCod(@Param("infAutCod")int infAutCod);
	    
	    @Modifying(clearAutomatically = true)
	  	@Query("update TblInformeAutoridad t set t.infAutTributo=:infAutTributo, t.infAutMedioTributario=:infAutMedioTributario WHERE t.infAutCod=:infAutCod")
	  	void actualizarInformeCumplimientoxId( @Param("infAutTributo") String infAutTributo, @Param("infAutMedioTributario") String infAutMedioTributario, @Param("infAutCod") int infAutCod);
	    
	    @Modifying(clearAutomatically = true)
	  	@Query("update TblInformeAutoridad t set t.inaProcesoRc=:inaProcesoRc WHERE t.infAutCod=:infAutCod")
	  	void actualizarInformeRendicionxId( @Param("inaProcesoRc") String inaProcesoRc, @Param("infAutCod") int infAutCod);

	    @Modifying(clearAutomatically = true)
	  	@Query("update TblInformeAutoridad t set t.inaAportesCiu=:inaAportesCiu WHERE t.infAutCod=:infAutCod")
	  	void actualizarInformeAportesxId( @Param("inaAportesCiu") String inaAportesCiu, @Param("infAutCod") int infAutCod);
	    
    
	    @Query(value="SELECT esq_rendicioncuentas.verificarInformeAutoridad(:infAutCod,:infAutPeriodo);", nativeQuery = true)
	    String listaProcedure(@Param("infAutCod")  int infAutCod, @Param("infAutPeriodo") int infAutPeriodo);
	    
	    @Modifying(clearAutomatically = true)
	  	@Query("update TblInformeAutoridad t set t.infAutEstado=:infAutEstado,  t.infAutFechafin=:infAutFechafin, t.infAutVerificador=:infAutVerificador   WHERE t.infAutCod=:infAutCod")
	  	void finalizar(@Param("infAutCod")  int infAutCod, @Param("infAutEstado") String infAutEstado, @Param("infAutFechafin") Date infAutFechafin,  @Param("infAutVerificador") String infAutVerificador  );
	    
	    
}
