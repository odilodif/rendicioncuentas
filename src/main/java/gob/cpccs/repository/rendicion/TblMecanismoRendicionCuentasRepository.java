package gob.cpccs.repository.rendicion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblMecanismoRendicionCuentas;
@Repository
@Transactional
public interface TblMecanismoRendicionCuentasRepository  extends JpaRepository<TblMecanismoRendicionCuentas, String>{
	@Query("select t from TblMecanismoRendicionCuentas t where  t.infCod.infCod=:infCod order by t.mecanismoCod asc")
	List<TblMecanismoRendicionCuentas> findByinfCod(@Param("infCod") int infCod);
	
	@Query("select t from TblMecanismoRendicionCuentas t where  t.infCod.infCod=:infCod and t.mecanismoFase=:mecanismoFase order by t.mecanismoCod asc")
	List<TblMecanismoRendicionCuentas> findByInfCodAndMecanismoFase (@Param("infCod") int infCod,@Param("mecanismoFase") String mecanismoFase);
	
	/*@Query("select t from TblMecanismoRendicionCuentas t where  t.infCod.infCod=:infCod order by t.mecanismoCod asc")
	List<TblMecanismoRendicionCuentas> findByInfCod (@Param("infCod") int infCod);*/
	
	TblMecanismoRendicionCuentas findByMecanismoCod (@Param("mecanismoCod") int mecanismoCod); 
	@Query("select COUNT(t) from TblMecanismoRendicionCuentas t where  t.infCod.infCod=:infCod and t.mecanismoNombre=:mecanismoNombre")
	Integer coutMRC(@Param("infCod") int infCod,@Param("mecanismoNombre") String mecanismoNombre);
	@Query("select t from TblMecanismoRendicionCuentas t where  t.infCod.infCod=:infCod and t.mecanismoNombre=:mecanismoNombre order by t.mecanismoCod asc")
	TblMecanismoRendicionCuentas findByInfCodAndMecanismoNombre (@Param("infCod") int infCod,@Param("mecanismoNombre") String mecanismoNombre);
	
}
