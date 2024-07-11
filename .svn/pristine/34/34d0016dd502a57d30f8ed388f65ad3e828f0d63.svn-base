package gob.cpccs.repository.catalogos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.catalogos.TblTipoMedio;

@Repository
public interface TipoMedioRepository extends JpaRepository<TblTipoMedio, String>{
	
	TblTipoMedio findByTmeCod(@Param("tmeCod") Integer tmeCod);
	List<TblTipoMedio> findByTmeEstOrderByTmeCodAsc(@Param("tmeEst") String tmeEst);
	

}
