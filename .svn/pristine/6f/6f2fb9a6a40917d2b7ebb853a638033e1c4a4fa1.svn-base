package gob.cpccs.repository.rendicion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblParticipacionCiudadana;
import gob.cpccs.model.rendicion.TblPlanTrabajoGad;

@Repository
@Transactional
public interface TblParticipacionCiudadanaRepository extends JpaRepository<TblParticipacionCiudadana, String>{
@Query("select t from TblParticipacionCiudadana t where  t.infCod.infCod=:infCod order by t.pcCod asc")
List<TblParticipacionCiudadana> findByinfCod(@Param("infCod") int infCod);

TblParticipacionCiudadana findByPcCod (@Param("pcCod") Integer pcCod);
@Query("select COUNT(t) from TblParticipacionCiudadana t where  t.infCod.infCod=:infCod and t.pcSistema=:pcSistema")
Integer coutPc(@Param("infCod") int infCod,@Param("pcSistema") String pcSistema);
@Query("select t from TblParticipacionCiudadana t where  t.infCod.infCod=:infCod and t.pcSistema=:pcSistema order by t.pcCod asc")
TblParticipacionCiudadana findByinfCodmecanismo(@Param("infCod") int infCod,@Param("pcSistema") String pcSistema);
}
