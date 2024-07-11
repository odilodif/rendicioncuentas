package gob.cpccs.repository.gestion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.gestion.TblFuncionesAutoridadesFin;

@Transactional
@Repository
public interface FuncionesAutoridadesFinRepository extends JpaRepository<TblFuncionesAutoridadesFin,Integer>{
	@Query("select t from TblFuncionesAutoridadesFin t where   t.infAutCod.infAutCod=:infAutCod order by t.faCod asc")
	List<TblFuncionesAutoridadesFin> findByFaCod(@Param("infAutCod") int infAutCod);
}
