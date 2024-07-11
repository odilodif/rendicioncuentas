package gob.cpccs.repository.retroalimentacion;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.retroalimentacion.TblAsignacion;

@Repository
@Transactional
public interface AsignacionRepository extends JpaRepository<TblAsignacion, String> {

	
	TblAsignacion findFirstByInfCod (@Param("infCod") int infCod);
	
	@Modifying(clearAutomatically = true)
	@Query("update TblAsignacion t set t.estadoAsig=:estadoAsig WHERE t.idAsignacion=:idAsignacion")
	void actualizarEstado(@Param("idAsignacion") int idAsignacion,@Param("estadoAsig")  String estadoAsig);
	@Modifying(clearAutomatically = true)
	@Query("DELETE FROM TblAsignacion t WHERE t.identificador=:identificador AND t.estadoAsig<>:estadoAsig")
	void DeleteTblAsignacionXIdentificadorAnd(@Param("identificador") String identificador,@Param("estadoAsig") String estadoAsig); 
	
	@Modifying(clearAutomatically = true)
	@Query("DELETE FROM TblAsignacion t WHERE t.identificador=:identificador AND t.estadoAsig<>:estadoAsig AND t.periodoAsig=:periodoAsig")
	void DeleteTblAsignacionXIdentificadorAndPeriodo(@Param("identificador") String identificador,@Param("estadoAsig") String estadoAsig, @Param("periodoAsig")int periodoAsig); 
}
