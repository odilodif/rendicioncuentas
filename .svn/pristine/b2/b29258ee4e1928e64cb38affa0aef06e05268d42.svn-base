package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblCumplimientoMedios;

@Repository
@Transactional
public interface CumplimientoMedioRepository extends JpaRepository<TblCumplimientoMedios, String> {
	@Query("select t from TblCumplimientoMedios t where  t.infCod.infCod=:infCod and t.cmTipo=:cmTipo order by t.cmCod asc")
	List<TblCumplimientoMedios> findByinfCod(@Param("infCod") int infCod,@Param("cmTipo") String cmTipo);
}
