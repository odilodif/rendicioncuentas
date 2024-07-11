package gob.cpccs.repository.retroalimentacion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.retroalimentacion.TblInformeCalificado;

@Repository
@Transactional
public interface InformeCalificacionRepository extends JpaRepository<TblInformeCalificado, Integer> {

	TblInformeCalificado findByIdInfCal(@Param("idInfCal") Integer idInfCal);
	
	TblInformeCalificado findByInfCodAndPregunta(@Param("infCod") Integer infCod,@Param("pregunta") String pregunta);
	
	List<TblInformeCalificado> findByInfCod(@Param("infCod") Integer infCod);
	@Query("SELECT i FROM TblInformeCalificado i WHERE i.infCod =:infCod ORDER BY i.idInfCal ASC")
	List<TblInformeCalificado> findByInfCodOrder(@Param("infCod") Integer infCod);
	
	@Query("SELECT i FROM TblInformeCalificado i WHERE i.infCod =:infCod ORDER BY i.orden ASC")
	List<TblInformeCalificado> findByInfCodOrder1(@Param("infCod") Integer infCod);
}
