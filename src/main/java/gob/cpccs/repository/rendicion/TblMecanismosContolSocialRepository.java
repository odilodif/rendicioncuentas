package gob.cpccs.repository.rendicion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblMecanismosContolSocial;

@Repository
@Transactional
public interface TblMecanismosContolSocialRepository extends JpaRepository<TblMecanismosContolSocial, String> {

	@Query("select t from TblMecanismosContolSocial t where  t.infCod.infCod=:infCod order by t.mecCod asc")
	List<TblMecanismosContolSocial> findByinfCod(@Param("infCod") int infCod);
	TblMecanismosContolSocial findByMecCod (@Param("mecCod") int mecCod); 
	@Query("select COUNT(t) from TblMecanismosContolSocial t where  t.infCod.infCod=:infCod and t.mecNombre=:mecNombre")
	Integer coutMeCS(@Param("infCod") int infCod,@Param("mecNombre") String mecNombre);
	
	@Query("select t from TblMecanismosContolSocial t where  t.infCod.infCod=:infCod and t.mecNombre=:mecNombre")
	TblMecanismosContolSocial obtenerMecanismo(@Param("infCod") int infCod,@Param("mecNombre") String mecNombre);
}
