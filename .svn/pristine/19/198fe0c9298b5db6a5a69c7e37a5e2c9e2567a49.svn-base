package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblAnteproyectoPresupuesto;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblMecanismosContolSocial;
@Repository
@Transactional
public interface AnteproyectoPresupuestoRepository extends JpaRepository<TblAnteproyectoPresupuesto, String> {

	@Query("SELECT t.anteCod,t.anteNom,t.anteOpc,t.anteFecha,t.anteDescrip, t.anteTipo, t.anteEstado FROM TblAnteproyectoPresupuesto t WHERE t.infCod =:infCod order by t.anteCod asc")
	List<Object[]>buscarAnteproyectos(@Param("infCod") TblInforme infCod);
	
	TblAnteproyectoPresupuesto findByAnteCod (@Param("anteCod") int anteCod); 
	
}
