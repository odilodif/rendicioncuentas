package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblProyectoComunicacional;
@Repository
@Transactional
public interface ProyectoComunicacionalRepository extends JpaRepository<TblProyectoComunicacional, String> {
	
	@Query("select t from TblProyectoComunicacional t where  t.infCod.infCod=:infCod order by t.proCodigo asc")
	List<TblProyectoComunicacional> findByinfCod(@Param("infCod") int infCod);
	
	@Query("select t from TblProyectoComunicacional t where  t.infCod.infCod=:infCod order by t.proCodigo asc")
	TblProyectoComunicacional Buscar(@Param("infCod") int infCod);
}
