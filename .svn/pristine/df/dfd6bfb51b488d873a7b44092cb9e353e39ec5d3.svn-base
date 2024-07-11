package gob.cpccs.repository.rendicion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gob.cpccs.model.rendicion.TblImplementacionIgualdad;
import gob.cpccs.model.rendicion.TblInforme;


@Repository
@Transactional
public interface TblImplementacionIgualdadRepository extends JpaRepository<TblImplementacionIgualdad, String>{

	List<TblImplementacionIgualdad> findByInfCod(@Param("tblInforme") TblInforme tblInforme);
	TblImplementacionIgualdad findByPiCod (@Param("piCod") Integer piCod);
	@Query("SELECT t.piCod,t.piNombre,t.piImplementado,t.piUsuarios,t.piPolitica,t.piDetalle,t.piResultado FROM TblImplementacionIgualdad t WHERE t.infCod =:infCod order by t.piCod asc")
	List<Object[]>buscarImpleIgualdad(@Param("infCod") TblInforme tblInforme);
	
	@Modifying(clearAutomatically = true)
	@Query("update TblImplementacionIgualdad t set t.piNombre=:piNombre,t.piImplementado=:piImplementado ,t.piPolitica=:piPolitica ,t.piDetalle=:piDetalle ,t.piResultado=:piResultado  WHERE t.piCod=:piCod")
	void actualizarImplePresupuesto(@Param("piCod") Integer piCod,@Param("piNombre") String piNombre,@Param("piImplementado") String piImplementado,@Param("piPolitica") String piPolitica,
			@Param("piDetalle")String piDetalle, @Param("piResultado")String piResultado);
	@Query("select COUNT(t) from TblImplementacionIgualdad t where  t.infCod.infCod=:infCod and t.piNombre=:piNombre")
	Integer coutPOIG(@Param("infCod") int infCod,@Param("piNombre") String piNombre);
	TblImplementacionIgualdad findByInfCodAndPiNombre(@Param("tblInforme") TblInforme tblInforme, @Param("PiNombre") String PiNombre);
	 
}
