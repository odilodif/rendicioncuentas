package gob.cpccs.repository.catalogos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.catalogos.TblTipoInforme;

@Repository
public interface TipoInformeRepository extends JpaRepository<TblTipoInforme, String> {
	
	List<TblTipoInforme> findByTfDesOrderByTfCodAsc(@Param("tfDes") String tfDes);

	TblTipoInforme findByTfCod(@Param("tfCod") Integer tfCod);


}
