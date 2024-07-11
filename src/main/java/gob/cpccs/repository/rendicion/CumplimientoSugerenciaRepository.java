package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblCumplimientoSugerenciaCiudadana;

@Repository
@Transactional
public interface CumplimientoSugerenciaRepository extends JpaRepository<TblCumplimientoSugerenciaCiudadana,String> {
	@Query("select t from TblCumplimientoSugerenciaCiudadana t where  t.infCod.infCod=:infCod order by t.cscCod asc")
	List<TblCumplimientoSugerenciaCiudadana> findByinfCod(@Param("infCod") int infCod);
}
