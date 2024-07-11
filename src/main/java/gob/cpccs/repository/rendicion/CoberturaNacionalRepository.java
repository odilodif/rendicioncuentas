package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblCoberturaNacional;
import gob.cpccs.model.rendicion.TblInforme;

@Repository
@Transactional
public interface CoberturaNacionalRepository extends JpaRepository<TblCoberturaNacional,String> {

	@Query("select t from TblCoberturaNacional t where  t.infCod.infCod=:infCod order by t.cnCod asc")
	List<TblCoberturaNacional> findByinfCod(@Param("infCod") int infCod);
	
	@Query("select t from TblCoberturaNacional t where  t.infCod.infCod=:infCod and t.cnTipo=:cnTipo order by t.cnCod asc")
	List<TblCoberturaNacional> findByinfCodAndCnTipo(@Param("infCod") int infCod, @Param("cnTipo") String cnTipo);
	
	@Query("SELECT t.cnCod,t.cnCobertura,t.cnUnidades,t.cnTipo,t.cnDescripcion,t.cnestado FROM TblCoberturaNacional t WHERE t.infCod =:infCod")
	List<Object[]>buscarImpleCobertura(@Param("infCod") TblInforme tblInforme);
	
}
