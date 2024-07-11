package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gob.cpccs.model.rendicion.TblSeguroCampesino;
public interface SeguroCampesinoRepository extends JpaRepository<TblSeguroCampesino, String> {
	@Query("select t from TblSeguroCampesino t where  t.infCod.infCod=:infCod order by t.scCod asc")
	List<TblSeguroCampesino> findByinfCod(@Param("infCod") Integer infCod);
}
