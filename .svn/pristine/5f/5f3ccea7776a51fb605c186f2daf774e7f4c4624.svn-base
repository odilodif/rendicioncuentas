package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblPropuestas;
@Repository
@Transactional
public interface PropuestasAutoridadesRepository extends JpaRepository<TblPropuestas, String> {
	@Query("select t from TblPropuestas t where   t.infAutCod.infAutCod=:infAutCod order by t.proId asc")
	List<TblPropuestas> findByProId(@Param("infAutCod") int infAutCod);
}
