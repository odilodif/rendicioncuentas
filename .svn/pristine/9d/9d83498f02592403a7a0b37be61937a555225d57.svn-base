package gob.cpccs.repository.usuario;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.usuario.TblResponables;

@Repository
@Transactional
public interface ResponsableRepository extends JpaRepository<TblResponables, String> {
	TblResponables findByResponEmailAndResponTipoAndResponPeriodo(@Param("responEmail") String responEmail,
			@Param("responTipo") String responTipo, @Param("responPeriodo") String responPeriodo);

	TblResponables findByResponCodRefeAndResponTipoAndResponPeriodo(@Param("responCodRefe") Integer responCodRefe,
			@Param("responTipo") String responTipo, @Param("responPeriodo") String responPeriodo);

	List<TblResponables> findByResponCodRefeAndResponPeriodo(@Param("responCodRefe") Integer responCodRefe,
			 @Param("responPeriodo") String responPeriodo);

	@Modifying(clearAutomatically = true)
	@Query("update TblResponables t set t.responNombre=:responNombre,t.responEmail=:responEmail ,t.responCargo=:responCargo, t.responFechaDesignacion=:responFechaDesignacion, t.responCelular=:responCelular where t.responCodigo=:responCodigo")
	void actualizarResponsableXcod(@Param("responNombre") String responNombre, @Param("responEmail") String responEmail, @Param("responCargo") String responCargo, 
			@Param("responCodigo") Integer responCodigo,@Param("responFechaDesignacion")  Date responFechaDesignacion,@Param("responCelular") String responCelular );
	
	@Modifying(clearAutomatically = true)
	@Query("delete from TblResponables t where t.responCodRefe=:responCodRefe and t.responPeriodo=:responPeriodo ")
	void BorrarResponsableXcodYperiodo(@Param("responCodRefe") Integer responCodRefe,@Param("responPeriodo") String responPeriodo);
	
	TblResponables findByResponCodigo(@Param("responCodigo") Integer responCodigo);
	

}
