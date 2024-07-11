package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblAsambleaCiudadana;
import gob.cpccs.model.rendicion.TblInforme;

@Repository
@Transactional
public interface AsambleaCiudadanaRepository  extends JpaRepository<TblAsambleaCiudadana, String>{
	
	@Query("SELECT t.acCod,t.acEspaciosParticipa,t.acExiste,t.acValidaGestTerritorio,t.acDescrPlanficacion, t.acDescLogros, t.acNomRespon, t.acMeilRespon, t.acTelfRespon, t.acRepreTerri FROM TblAsambleaCiudadana t WHERE t.infCod =:infCod")
	List<Object[]>buscarAnteproyectos(@Param("infCod") TblInforme infCod);
	
	TblAsambleaCiudadana findByAcCod (@Param("acCod") int acCod); 

}
