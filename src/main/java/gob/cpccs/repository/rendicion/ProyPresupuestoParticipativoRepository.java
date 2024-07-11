package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblProyPresupuestoParticipativo;

@Repository
@Transactional
public interface ProyPresupuestoParticipativoRepository extends JpaRepository<TblProyPresupuestoParticipativo, String> {

	@Query("SELECT t.proyCod,t.proyDescripcion,t.proyMontoplan,t.proyMontoejec,t.proyObs, t.proyPorcAvance, t.proyLinks FROM TblProyPresupuestoParticipativo t WHERE t.infCod =:infCod")
	List<Object[]>buscarDetalles(@Param("infCod") TblInforme infCod);
}
