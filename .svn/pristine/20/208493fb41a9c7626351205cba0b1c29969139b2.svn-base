package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblCumplimientoObligaciones;

@Repository
@Transactional
public interface CumplimientoObligacionesRepository extends JpaRepository<TblCumplimientoObligaciones, String>{
	@Query("select t from TblCumplimientoObligaciones t where  t.infCod.infCod=:infCod order by t.cumOblCod asc")
	List<TblCumplimientoObligaciones> findByinfCod(@Param("infCod") int infCod);

}
