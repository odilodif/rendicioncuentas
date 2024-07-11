package gob.cpccs.repository.rendicion;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblImplementacionPresupuesto;
import gob.cpccs.model.rendicion.TblInforme;

@Repository
@Transactional
public interface TblImplementacionPresupuestoRepository extends JpaRepository<TblImplementacionPresupuesto, String>{

	List<TblImplementacionPresupuesto> findByInfoCod(@Param("tblInforme") TblInforme tblInforme);
	
	@Query("SELECT t.impleCod,t.impleOpc,t.implePorce,t.impleGrupo,t.implePorcengrupo,t.impleEstado FROM TblImplementacionPresupuesto t WHERE t.infoCod =:infoCod order by t.impleCod asc")
	List<Object[]>buscarImplePresuesto(@Param("infoCod") TblInforme tblInforme);
	
	@Modifying(clearAutomatically = true)
	@Query("update TblImplementacionPresupuesto t set t.implePorce=:implePorce WHERE t.infoCod=:infoCod")
	void actualizarImplePresupuesto(@Param("implePorce") String implePorce,@Param("infoCod") TblInforme tblInforme);
	@Query("select COUNT(t) from TblImplementacionPresupuesto t where  t.infoCod=:infoCod and t.impleGrupo=:impleGrupo")
	Integer coutIP(@Param("infoCod") TblInforme tblInforme,@Param("impleGrupo") String impleGrupo);
	@Query("select t from TblImplementacionPresupuesto t where  t.infoCod=:infoCod and t.impleGrupo=:impleGrupo")
	TblImplementacionPresupuesto buscarIPLPresu(@Param("infoCod") TblInforme tblInforme,@Param("impleGrupo") String impleGrupo);

	}
