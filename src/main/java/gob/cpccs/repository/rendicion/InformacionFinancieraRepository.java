package gob.cpccs.repository.rendicion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblInformacionFinanciera;

@Repository
@Transactional
public interface InformacionFinancieraRepository extends JpaRepository<TblInformacionFinanciera, String> {
	@Query("select t from TblInformacionFinanciera t where  t.infCod.infCod=:infCod order by t.codFinan asc")
	List<TblInformacionFinanciera> findByinfCod(@Param("infCod") int infCod);
}
