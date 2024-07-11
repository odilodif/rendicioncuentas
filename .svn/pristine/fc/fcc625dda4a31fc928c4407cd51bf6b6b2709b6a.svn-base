package gob.cpccs.repository.seguridad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.seguridad.TblHistoricoInstituciones;

@Repository
public interface HistoricoInstitucionRepository extends JpaRepository<TblHistoricoInstituciones, String> {
	
	@Query("select d from TblHistoricoInstituciones d  where d.codReferencial=:infCod order by d.idHistorial asc")
	List<TblHistoricoInstituciones> buscarRegistrosXinfcod (@Param("infCod") Integer infCod);

}
