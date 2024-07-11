package gob.cpccs.repository.rendicion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import gob.cpccs.model.rendicion.TblSeguroGeneral;

@Repository
@Transactional
public interface SeguroGeneralRepository extends JpaRepository<TblSeguroGeneral,String>{
	@Query("select t from TblSeguroGeneral t where  t.infCod.infCod=:infCod order by t.sgCod asc")
	List<TblSeguroGeneral> findByinfCod(@Param("infCod") Integer infCod);
}
