package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblDetalleComunicagestion;

@Repository
@Transactional
public interface DetalleComunicacionGetionMediosRepository extends JpaRepository<TblDetalleComunicagestion, String> {
	@Query("select t from TblDetalleComunicagestion t where  t.cgCod.cgCod=:cgCod order by t.cgCod2 asc")
	List<TblDetalleComunicagestion> findByinfCod(@Param("cgCod") int cgCod);
}
