package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblCoberturaInstitucional;
import gob.cpccs.model.rendicion.TblCoberturaNacional;
import gob.cpccs.model.rendicion.TblInforme;


@Repository
@Transactional
public interface CoberturaTerritorialRepository  extends JpaRepository<TblCoberturaInstitucional,String> {
	
	@Query("select t from TblCoberturaInstitucional t where  t.infCod.infCod=:infCod order by t.ciCod asc")
	List<TblCoberturaInstitucional> findByinfCod(@Param("infCod") int infCod);
	
	
	@Query("SELECT t.ciCod,t.ciNombre,t.ciDetalle,t.instCod,t.ciestado FROM TblCoberturaInstitucional t WHERE t.infCod =:infCod")
	List<Object[]> buscarImpleCoberturaTerritorial(@Param("infCod") TblInforme tblInforme);
}
