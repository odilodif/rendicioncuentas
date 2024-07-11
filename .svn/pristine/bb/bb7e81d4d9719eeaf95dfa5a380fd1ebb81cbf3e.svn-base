package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblEnajenacionBienes;

@Repository
@Transactional
public interface EnagenacionRepository extends JpaRepository<TblEnajenacionBienes,String> {
	
	@Query("select t from TblEnajenacionBienes t where  t.infCod.infCod=:infCod order by t.enbCod asc")
	List<TblEnajenacionBienes> findByinfCod(@Param("infCod") int infCod);
	
}
