package gob.cpccs.repository.rendicion;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblSede;

@Repository
@Transactional
public interface SedeRepository extends JpaRepository<TblSede, String>{
	
	List<TblSede> findByInfCod(@Param("tblInforme") TblInforme tblInforme);

	@Query("SELECT t.seCod, t.seNombre, t.seProvincia, t.seCanton, t.seParroquia, t.seDireccion, t.seMail, t.seWeb, t.seRuc,"
			+ "t.seRepresentante, t.seCargo, t.seDesignacion, t.seMailrep, t.seTelrep, t.seUnidades, t.seCobertura,"
			+ "t.seEstudiantes, t.seHombre, t.seMujeres, t.seGlbti, t.seMontubios, t.seMestizos, t.seCholos,"
			+ "t.seAfroecuatorianos, t.seIndigenas, t.seExtranjeros, t.seDiscapacitados, t.seLink FROM TblSede t WHERE t.infCod =:infCod order by t.seCod asc ")
	List<Object[]>buscarSedes(@Param("infCod") TblInforme tblInforme);
	
	TblSede findBySeCod (@Param("seCod") Integer seCod);
	
	 @Modifying(clearAutomatically = true)
     @Query("update TblSede t set  t.seNombre=:seNombre, t.seProvincia=:seProvincia, t.seParroquia=:seParroquia, t.seCanton=:seCanton, t.seDireccion=:seDireccion, t.seMail=:seMail, t.seWeb=:seWeb, t.seRuc=:seRuc  WHERE t.seCod=:seCod")
     void actualizarRegistro(@Param("seCod") Integer seCod, @Param("seNombre") String seNombre, @Param("seProvincia") Integer seProvincia,  @Param("seParroquia") Integer seParroquia, @Param("seCanton") Integer seCanton, @Param("seDireccion") String seDireccion, @Param("seMail") String seMail, @Param("seWeb") String seWeb, @Param("seRuc") String seRuc);
	 
	 @Modifying(clearAutomatically = true)
     @Query("update TblSede t set  t.seRepresentante=:seRepresentante, t.seCargo=:seCargo, t.seMailrep=:seMailrep, t.seDesignacion=:seDesignacion, t.seTelrep=:seTelrep WHERE t.seCod=:seCod")
     void actualizarRegistroDetalle(@Param("seCod") Integer seCod, @Param("seRepresentante") String seRepresentante, @Param("seCargo") String seCargo,  @Param("seMailrep") String seMailrep, @Param("seDesignacion") Date seDesignacion, @Param("seTelrep") String seTelrep);
	 
	 @Modifying(clearAutomatically = true)
     @Query("update TblSede t set  t.seUnidades=:seUnidades, t.seCobertura=:seCobertura, t.seEstudiantes=:seEstudiantes, t.seHombre=:seHombre, t.seMujeres=:seMujeres,"
     		+ " t.seGlbti=:seGlbti, t.seMontubios=:seMontubios, t.seMestizos=:seMestizos, t.seCholos=:seCholos, t.seIndigenas=:seIndigenas, t.seAfroecuatorianos=:seAfroecuatorianos, "
     		+ "t.seExtranjeros=:seExtranjeros, t.seDiscapacitados=:seDiscapacitados, t.seLink=:seLink WHERE t.seCod=:seCod")
     void actualizarRegistroDetalle2(@Param("seCod") Integer seCod,@Param("seUnidades") Integer seUnidades,  @Param("seCobertura") String seCobertura, @Param("seEstudiantes") Integer seEstudiantes, @Param("seHombre") Integer seHombre,
    		 @Param("seMujeres") Integer seMujeres, @Param("seGlbti") Integer seGlbti, @Param("seMontubios") Integer seMontubios, @Param("seMestizos") Integer seMestizos, @Param("seCholos") Integer seCholos, @Param("seIndigenas") Integer seIndigenas, @Param("seAfroecuatorianos") Integer seAfroecuatorianos,
    		 @Param("seExtranjeros") Integer seExtranjeros, @Param("seDiscapacitados") Integer seDiscapacitados,  @Param("seLink") String seLink);
}
