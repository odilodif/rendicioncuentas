package gob.cpccs.repository.rendicion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.rendicion.TblNegarAutoridad;

@Repository
@Transactional
public interface TblNegarAutoridadRepository extends JpaRepository<TblNegarAutoridad ,String> {

}
