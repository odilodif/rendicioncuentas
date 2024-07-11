package gob.cpccs.repository.rendicion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblIncoporacionRecomendaciones;


@Repository
@Transactional
public interface IncoporacionRecomendacionesRepository extends JpaRepository<TblIncoporacionRecomendaciones, String>{

	@Query("select t from TblIncoporacionRecomendaciones t where  t.infCod.infCod=:infCod order by t.ireCod asc")
	List<TblIncoporacionRecomendaciones> findByinfCod(@Param("infCod") int infCod);
	TblIncoporacionRecomendaciones findByIreCod (@Param("ireCod") int ireCod); 
}
