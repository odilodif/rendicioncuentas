package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblComunicacionGestion;
import gob.cpccs.model.rendicion.TblImplementacionIgualdad;
import gob.cpccs.model.rendicion.TblInforme;

@Repository
@Transactional
public interface DetalleMediosRepository  extends JpaRepository<TblComunicacionGestion, String>{
	@Query("select t from TblComunicacionGestion t where  t.infCod.infCod=:infCod order by t.cgCod asc")
	List<TblComunicacionGestion> findByinfCod(@Param("infCod") int infCod);
	TblComunicacionGestion findByCgCod(@Param("cgCod") int cgCod);
	@Query("select COUNT(t) from TblComunicacionGestion t where  t.infCod.infCod=:infCod and t.cgNombre=:cgNombre")
	Integer coutCG(@Param("infCod") int infCod,@Param("cgNombre") String cgNombre);
	TblComunicacionGestion findByInfCodAndCgNombre(@Param("tblInforme") TblInforme tblInforme, @Param("CgNombre") String CgNombre);
}
