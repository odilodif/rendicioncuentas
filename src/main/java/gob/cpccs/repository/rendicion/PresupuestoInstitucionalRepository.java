package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblCoberturaInstitucional;
import gob.cpccs.model.rendicion.TblDetalleEjecucionp;
import gob.cpccs.model.rendicion.TblPresupuestoInstitucional;

@Repository
@Transactional
public interface PresupuestoInstitucionalRepository extends JpaRepository<TblPresupuestoInstitucional,String> {

	@Query("select t from TblPresupuestoInstitucional t where  t.infCod.infCod=:infCod order by t.preInsti asc")
	List<TblPresupuestoInstitucional> findByinfCod(@Param("infCod") int infCod);

}
