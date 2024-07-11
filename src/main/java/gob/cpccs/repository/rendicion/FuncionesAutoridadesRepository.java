package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblFuncionesAutoridades;
import gob.cpccs.model.rendicion.TblPlanTrabajo;
@Repository
@Transactional
public interface FuncionesAutoridadesRepository extends JpaRepository<TblFuncionesAutoridades, String> {
	@Query("select t from TblFuncionesAutoridades t where   t.infAutCod.infAutCod=:infAutCod order by t.faCod asc")
	List<TblFuncionesAutoridades> findByFaCod(@Param("infAutCod") int infAutCod);
}
