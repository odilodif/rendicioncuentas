package gob.cpccs.repository.gestion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.gestion.TblAmecanismosPcFin;
@Transactional
@Repository
public interface MecanicmosPCFinGestionRepository extends JpaRepository<TblAmecanismosPcFin, Integer>{
	@Query("select t from TblAmecanismosPcFin t where   t.infAutCod.infAutCod=:infAutCod order by t.ameCod asc")
	List<TblAmecanismosPcFin> findByAmeCod(@Param("infAutCod") int infAutCod);
	@Query("select t from TblAmecanismosPcFin t where   t.infAutCod.infAutCod=:infAutCod and t.ameTipo=:ameTipo order by t.ameCod asc")
	TblAmecanismosPcFin findByAmeCodAndNombre(@Param("infAutCod") int infAutCod,@Param("ameTipo") String ameTipo);
	@Query("select COUNT(t) from TblAmecanismosPcFin t where  t.infAutCod.infAutCod=:infAutCod and t.ameTipo=:ameTipo")
	Integer coutMeCSPAF(@Param("infAutCod") int infCod,@Param("ameTipo") String ameTipo);
}
