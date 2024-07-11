package gob.cpccs.repository.rendicion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblObligacionesEducacion;
@Repository
@Transactional
public interface ObligacionesEducacionRepository extends JpaRepository<TblObligacionesEducacion, String> {

	@Query("select t from TblObligacionesEducacion t where  t.infCod.infCod=:infCod order by t.oeCod asc")
	List<TblObligacionesEducacion> findByinfCod(@Param("infCod") Integer infCod);
}
