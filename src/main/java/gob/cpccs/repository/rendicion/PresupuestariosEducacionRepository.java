package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gob.cpccs.model.rendicion.TblPresupuestoEducacion;

public interface PresupuestariosEducacionRepository extends JpaRepository<TblPresupuestoEducacion, String> {
	@Query("select t from TblPresupuestoEducacion t where  t.infCod.infCod=:infCod order by t.peCod asc")
	List<TblPresupuestoEducacion> findByinfCod(@Param("infCod") int infCod);

}
