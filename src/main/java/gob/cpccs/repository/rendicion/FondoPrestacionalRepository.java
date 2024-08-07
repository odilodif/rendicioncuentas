package gob.cpccs.repository.rendicion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblFondoPrestacional;

@Repository
@Transactional
public interface FondoPrestacionalRepository extends JpaRepository<TblFondoPrestacional, String>{

	@Query("select t from TblFondoPrestacional t where  t.infCod.infCod=:infCod order by t.fpCod asc")
	List<TblFondoPrestacional> findByinfCod(@Param("infCod") Integer infCod);
}
