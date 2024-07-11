package gob.cpccs.repository.gestion;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.gestion.TblInformeAutoridadFin;

@Repository
@Transactional
public interface TblInformeAutoridadFinRepository extends JpaRepository<TblInformeAutoridadFin, Integer> {

	@Query("SELECT t FROM TblInformeAutoridadFin t WHERE t.infAutCod =:infAutCod and t.infAutEstado=:infAutEstado")
	public TblInformeAutoridadFin findByinfoAndinfAutEstado(@Param("infAutCod") int infAutCod, @Param("infAutEstado") String infAutEstado);
	@Query("SELECT t FROM TblInformeAutoridadFin t WHERE t.identificador =:identificador and t.infAutEstado=:infAutEstado")
	public TblInformeAutoridadFin findByIdentificadorAndinfAutEstado(@Param("identificador") String identificador, @Param("infAutEstado") String infAutEstado);
	@Query("SELECT t FROM TblInformeAutoridadFin t WHERE t.infAutCod =:infAutCod and t.infAutEstado=:infAutEstado")
	public List<TblInformeAutoridadFin> findByInfoAutCodAndinfAutEstado(@Param("infAutCod") int infAutCod, @Param("infAutEstado") String infAutEstado);
    @Modifying(clearAutomatically = true)
	@Query("update TblInformeAutoridadFin t set t.numeroAsistentes=:numeroAsistentes, t.fechaRendicion=:fechaRendicion, t.lugar=:lugar WHERE t.infAutCod=:infAutCod")
	void actualizarInformeAutoridadFinxId( @Param("fechaRendicion") Date fechaRendicion, @Param("lugar") String lugar, @Param("numeroAsistentes") Integer numeroAsistentes, @Param("infAutCod") int infAutCod);
    @Modifying(clearAutomatically = true)
	  	@Query("update TblInformeAutoridadFin t set t.inaAportesCiu=:inaAportesCiu WHERE t.infAutCod=:infAutCod")
	  	void actualizarInformeAportesxId( @Param("inaAportesCiu") String inaAportesCiu, @Param("infAutCod") int infAutCod);
	@Query("SELECT t FROM TblInformeAutoridadFin t WHERE t.infAutCod =:infAutCod and t.infAutEstado=:infAutEstado")
	public  List<TblInformeAutoridadFin> findByinfoAndinfAutEstadoAportes(@Param("infAutCod") int infAutCod, @Param("infAutEstado") String infAutEstado);
	  @Modifying(clearAutomatically = true)
	  	@Query("update TblInformeAutoridadFin t set t.inaProcesoRc=:inaProcesoRc WHERE t.infAutCod=:infAutCod")
	  	void actualizarInformeRendicionxId( @Param("inaProcesoRc") String inaProcesoRc, @Param("infAutCod") int infAutCod);
	  @Modifying(clearAutomatically = true)
	  	@Query("update TblInformeAutoridadFin t set t.infAutTributo=:infAutTributo, t.infAutMedioTributario=:infAutMedioTributario WHERE t.infAutCod=:infAutCod")
	  	void actualizarInformeCumplimientoxIdFin( @Param("infAutTributo") String infAutTributo, @Param("infAutMedioTributario") String infAutMedioTributario, @Param("infAutCod") int infAutCod);
	  @Query(value="SELECT esq_gestion.verificarinformefingestion(:infAutCod,:infAutPeriodo);", nativeQuery = true)
	    String listaProcedure(@Param("infAutCod")  int infAutCod, @Param("infAutPeriodo") String infAutPeriodo);
	  @Modifying(clearAutomatically = true)
	  	@Query("update TblInformeAutoridadFin t set t.infAutEstado=:infAutEstado,  t.infAutFechafin=:infAutFechafin, t.infAutVerificador=:infAutVerificador   WHERE t.infAutCod=:infAutCod")
	  	void finalizar(@Param("infAutCod")  int infAutCod, @Param("infAutEstado") String infAutEstado, @Param("infAutFechafin") Date infAutFechafin,  @Param("infAutVerificador") String infAutVerificador  );
}
