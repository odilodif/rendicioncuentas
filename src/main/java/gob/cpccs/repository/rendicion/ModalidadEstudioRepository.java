package gob.cpccs.repository.rendicion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblModalidadEstudios;
import gob.cpccs.model.rendicion.TblObjetivosPlanDesarrollo;

@Repository
@Transactional
public interface ModalidadEstudioRepository extends JpaRepository<TblModalidadEstudios, String> {
	
	@Query("SELECT t.mosCod,t.mosTipo FROM TblModalidadEstudios t WHERE t.infCod =:infCod order by t.mosCod asc ")
	List<Object[]>buscarModalidadEstudios(@Param("infCod") TblInforme tblInforme);
	
	
	List<TblModalidadEstudios> findByInfCod(@Param("tblInforme") TblInforme tblInforme);


}
