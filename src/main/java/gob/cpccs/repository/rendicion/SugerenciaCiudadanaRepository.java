package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblSugerenciaCiudadana;
@Repository
@Transactional
public interface SugerenciaCiudadanaRepository  extends JpaRepository<TblSugerenciaCiudadana,String>{
	
	@Query("select t from TblSugerenciaCiudadana t where  t.infCod.infCod=:infCod order by t.secCode asc")
	List<TblSugerenciaCiudadana> findByinfCod(@Param("infCod") int infCod);
}
