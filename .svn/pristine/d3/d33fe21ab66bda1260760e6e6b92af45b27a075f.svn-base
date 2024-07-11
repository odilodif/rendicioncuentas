package gob.cpccs.repository.rendicion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblCoberturaGeografica;
@Repository
@Transactional
public interface CoberturaGeograficaRepository extends JpaRepository<TblCoberturaGeografica, String> {

	@Query("select t from TblCoberturaGeografica t where  t.infCod.infCod=:infCod order by t.cgCod asc")
	List<TblCoberturaGeografica> findByinfCod(@Param("infCod") Integer infCod);
	
}
