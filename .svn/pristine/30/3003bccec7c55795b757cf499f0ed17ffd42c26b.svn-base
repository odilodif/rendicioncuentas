package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblPorcentajePresupuesto;

@Repository
@Transactional
public interface PorcentajePresupuestoRepository  extends JpaRepository<TblPorcentajePresupuesto, String> {
	
	@Query("SELECT t.presCod,t.infPresparticipativo,t.infTotalpres,t.infPorprespar,t.infLinkpres, t.infPriorizanecpp, t.infTieneprespar FROM TblPorcentajePresupuesto t WHERE t.infCod =:infCod")
	List<Object[]>buscarPorcentajes(@Param("infCod") TblInforme tblInforme);
	

}
