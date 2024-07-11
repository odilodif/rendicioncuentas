package gob.cpccs.repository.rendicion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblCompromisosInformeant;

@Repository
@Transactional
public interface TblCompromisosInformeantRepository extends JpaRepository<TblCompromisosInformeant, String>{
	@Query("select t from TblCompromisosInformeant t where  t.infCod.infCod=:infCod order by t.caCod asc")
	List<TblCompromisosInformeant> findByinfCod(@Param("infCod") Integer infCod);
}
