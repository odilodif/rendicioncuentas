package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblAmecanismosPc;

@Repository
@Transactional
public interface MecanismosAutoridadesRepository  extends JpaRepository<TblAmecanismosPc, String>{
	
	@Query("select t from TblAmecanismosPc t where   t.infAutCod.infAutCod=:infAutCod order by t.ameCod asc")
	List<TblAmecanismosPc> findByAmeCod(@Param("infAutCod") int infAutCod);

}
