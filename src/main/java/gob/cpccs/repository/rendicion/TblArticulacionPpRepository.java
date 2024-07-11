package gob.cpccs.repository.rendicion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblArticulacionPp;


@Repository
@Transactional
public interface TblArticulacionPpRepository  extends JpaRepository<TblArticulacionPp, String>{
	
	@Query("select t from TblArticulacionPp t where  t.infCod.infCod=:infCod order by t.appCod asc")
	List<TblArticulacionPp> findByinfCod(@Param("infCod") Integer infCod);
	@Query("select COUNT(t) from TblArticulacionPp t where  t.infCod.infCod=:infCod and t.appDescripcion=:appDescripcion")
	Integer coutAPp(@Param("infCod") int infCod,@Param("appDescripcion") String appDescripcion);
	@Query("select t from TblArticulacionPp t where  t.infCod.infCod=:infCod and t.appDescripcion=:appDescripcion")
	TblArticulacionPp findByinfCodAndDescricion(@Param("infCod") Integer infCod,@Param("appDescripcion") String appDescripcion);
}
