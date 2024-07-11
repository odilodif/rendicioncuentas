package gob.cpccs.repository.gestion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.gestion.TblFinGestion;


@Repository
@Transactional
public interface TblFinGestionRepository extends JpaRepository<TblFinGestion,Integer>{
	@Query("select t from TblFinGestion t  order by t.idGestion asc")
	List<TblFinGestion> findgestion(@Param("infAutCod") Integer infAutCod);
	@Query("select t from TblFinGestion t where t.estado=:estado order by t.idGestion asc")
	TblFinGestion findgestionestado(@Param("estado") String estado);
	@Query("select t from TblFinGestion t where t.estado=:estado  and t.Identificador=:identificador order by t.idGestion asc")
	TblFinGestion findgestionestadoXidentificador(@Param("estado") String estado,@Param("identificador") String identificador);
	@Query("select t from TblFinGestion t where t.idGestion=:infAutCod  order by t.idGestion asc")
	TblFinGestion findgestionInfoCod(@Param("infAutCod") Integer infAutCod);
	@Query("select t from TblFinGestion t where t.Identificador=:identificador order by t.idGestion asc")
	List<TblFinGestion> findgestionXidentificador(@Param("identificador") String identificador);
	
	
	
}
