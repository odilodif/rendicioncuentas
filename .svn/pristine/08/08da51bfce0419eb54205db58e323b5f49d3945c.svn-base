package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblDatosInforme;
@Repository
@Transactional
public interface DatosInformeRemository extends JpaRepository<TblDatosInforme,String> {
	
	@Query("select t from TblDatosInforme t where  t.infCod.infCod=:infCod order by t.idDatos asc")
	List<TblDatosInforme> findByinfCod(@Param("infCod") int infCod);
}
