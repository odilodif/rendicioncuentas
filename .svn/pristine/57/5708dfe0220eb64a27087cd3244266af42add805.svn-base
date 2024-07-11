package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblDerechosAutor;

@Repository
@Transactional
public interface DerechosAutoresRepository extends JpaRepository<TblDerechosAutor, String> {
	@Query("select t from TblDerechosAutor t where  t.infCod.infCod=:infCod order by t.daCod asc")
	List<TblDerechosAutor> findByinfCod(@Param("infCod") int infCod);
}
