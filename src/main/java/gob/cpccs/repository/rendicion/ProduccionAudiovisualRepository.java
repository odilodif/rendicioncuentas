package gob.cpccs.repository.rendicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblProduccionAudiovisual;
@Repository
@Transactional
public interface ProduccionAudiovisualRepository extends JpaRepository<TblProduccionAudiovisual, String> {
	@Query("select t from TblProduccionAudiovisual t where  t.infCod.infCod=:infCod and t.paTipo=:paTipo order by t.paCod asc")
	List<TblProduccionAudiovisual> findByinfCod(@Param("infCod") int infCod,@Param("paTipo")String paTipo);
	@Query("select COUNT(t) from TblProduccionAudiovisual t where  t.infCod.infCod=:infCod and t.paTipo=:paTipo and paContenido=:paContenido")
	Integer coutPAu(@Param("infCod") int infCod,@Param("paTipo") String paTipo,@Param("paContenido") String paContenido);
	@Query("select t from TblProduccionAudiovisual t where  t.infCod.infCod=:infCod and t.paTipo=:paTipo and paContenido=:paContenido")
	TblProduccionAudiovisual FindProduccionNombreTipo(@Param("infCod") int infCod,@Param("paTipo") String paTipo,@Param("paContenido") String paContenido);
}