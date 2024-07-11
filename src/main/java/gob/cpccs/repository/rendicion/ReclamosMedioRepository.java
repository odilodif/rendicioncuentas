package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblReclamosMedios;
@Repository
@Transactional
public interface ReclamosMedioRepository extends JpaRepository<TblReclamosMedios, String> {
	@Query("select t from TblReclamosMedios t where  t.infCod.infCod=:infCod order by t.rmCod asc")
	List<TblReclamosMedios> findByinfCod(@Param("infCod") int infCod);
}
