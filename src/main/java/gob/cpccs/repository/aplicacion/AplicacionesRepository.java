package gob.cpccs.repository.aplicacion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.aplicacion.TblAplicaciones;

@Repository
public interface AplicacionesRepository extends JpaRepository<TblAplicaciones, String>{
	
	 @Query("SELECT t FROM TblAplicaciones t WHERE t.estadoAplicacion = :estadoAplicacion and t.codificacionAplicacion IN(:codificacionAplicacion)")
     public List<TblAplicaciones> findByEstadoAplicacionAndCodificacionAplicacionIn(@Param("estadoAplicacion") String estadoAplicacion,@Param("codificacionAplicacion") List<String> codificacionAplicacion);
     
     public TblAplicaciones findByIdAplicacion(@Param("idAplicacion") Integer idAplicacion);
     @Query("SELECT t.idAplicacion,t.nombre,t.ruta,t.descripcion,t.color,t.imagen FROM TblAplicaciones t WHERE t.estadoAplicacion = :estadoAplicacion and t.idAplicacion=:idAplicacion")
     public List<Object[]> findByIdAplicacionObjeto(@Param("idAplicacion") Integer idAplicacion,@Param("estadoAplicacion") String estadoAplicacion);
     @Modifying(clearAutomatically = true)
     @Query("UPDATE TblAplicaciones p  set p.visitas=:visitas WHERE p.idAplicacion=:idAplicacion")
     void ActualizarVisitasAplicacionXid(@Param("idAplicacion") Integer idAplicacion, @Param("visitas") Integer visitas);
     
     

}
