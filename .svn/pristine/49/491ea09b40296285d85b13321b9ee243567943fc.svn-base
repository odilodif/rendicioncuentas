package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblProcesosContratacion;

@Repository
@Transactional
public interface ProcesoContratacionRepository extends JpaRepository<TblProcesosContratacion, String> {
	@Query("select t from TblProcesosContratacion t where  t.infCod.infCod=:infCod order by t.pcoCod asc")
	List<TblProcesosContratacion> findByinfCod(@Param("infCod") int infCod);
}
