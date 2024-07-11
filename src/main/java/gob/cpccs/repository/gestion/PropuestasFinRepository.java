package gob.cpccs.repository.gestion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.gestion.TblPropuestasFin;

@Transactional
@Repository
public interface PropuestasFinRepository extends JpaRepository<TblPropuestasFin,Integer>{
	@Query("select t from TblPropuestasFin t where   t.infAutCod.infAutCod=:infAutCod order by t.proId asc")
	List<TblPropuestasFin> findByProId(@Param("infAutCod") int infAutCod);
}
