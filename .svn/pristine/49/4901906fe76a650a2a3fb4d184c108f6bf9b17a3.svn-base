package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblObrasAnteriores;

@Repository
@Transactional
public interface EstadoObrasRepository extends JpaRepository<TblObrasAnteriores, String> {
	@Query("select t from TblObrasAnteriores t where  t.infCod.infCod=:infCod order by t.obaCod asc")
	List<TblObrasAnteriores> findByinfCod(@Param("infCod") int infCod);
}
