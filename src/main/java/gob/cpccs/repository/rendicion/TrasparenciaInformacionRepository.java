package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblMecanismosTranparenciaAccInf;
@Repository
@Transactional
public interface TrasparenciaInformacionRepository extends JpaRepository<TblMecanismosTranparenciaAccInf,String> {
	@Query("select t from TblMecanismosTranparenciaAccInf t where  t.infCod.infCod=:infCod order by t.mecaniCod asc")
	List<TblMecanismosTranparenciaAccInf> findByinfCod(@Param("infCod") int infCod);
	@Query("select COUNT(t) from TblMecanismosTranparenciaAccInf t where  t.infCod.infCod=:infCod and t.mecaniNombre=:mecaniNombre")
	Integer coutMTA(@Param("infCod") int infCod,@Param("mecaniNombre") String mecaniNombre);
	@Query("select t from TblMecanismosTranparenciaAccInf t where  t.infCod.infCod=:infCod and t.mecaniNombre=:mecaniNombre")
	TblMecanismosTranparenciaAccInf MecanismoAccesoIformacion(@Param("infCod") int infCod,@Param("mecaniNombre") String mecaniNombre);
}
