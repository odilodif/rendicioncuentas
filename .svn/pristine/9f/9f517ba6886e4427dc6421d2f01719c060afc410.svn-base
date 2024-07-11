package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblDatosMedio;

@Repository
@Transactional
public interface DatosMediosRepository extends JpaRepository<TblDatosMedio, String>{
	@Query("select t from TblDatosMedio t where  t.infCod.infCod=:infCod order by t.dmCod asc")
	List<TblDatosMedio> findByinfCod(@Param("infCod") int infCod);
}
