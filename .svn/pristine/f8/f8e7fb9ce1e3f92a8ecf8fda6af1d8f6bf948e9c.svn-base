package gob.cpccs.repository.tecnico;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.usuario.TblUsuarioLocalizacion;

@Repository
@Transactional
public interface UsuarioLocalizacionRepository extends JpaRepository<TblUsuarioLocalizacion, String> {

	List<TblUsuarioLocalizacion> findByIdentificadorAndPeriodoAndRolCod(@Param("identificador") String identificador,
			@Param("periodo") int periodo, @Param("rolCod") int rolCod);

	TblUsuarioLocalizacion findByIdentificadorAndPeriodoAndRolCodIn(@Param("identificador") String identificador,
			@Param("periodo") int periodo, @Param("rolCod") int rolCod);
	@Modifying(clearAutomatically = true)
	@Query("DELETE FROM TblUsuarioLocalizacion t WHERE t.identificador=:identificador AND t.periodo=:periodo")
	void DeleteTblLocalizacionXidentificador(@Param("identificador") String identificador,@Param("periodo") Integer periodo); 
}
