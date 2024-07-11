package gob.cpccs.repository.rendicion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblFinanciamiento;

@Repository
@Transactional
public interface FinanciamientoRepository extends JpaRepository<TblFinanciamiento, String>{
	@Query("select t from TblFinanciamiento t where  t.infCod.infCod=:infCod order by t.finCod asc")
	List<TblFinanciamiento> findByinfCod(@Param("infCod") Integer infCod);
}
