package gob.cpccs.repository.catalogos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.catalogos.TblFuncion;

@Repository
public interface FuncionRepository extends JpaRepository<TblFuncion, String>{
	
    TblFuncion findByFunCod(@Param("funCod") Integer funCod);
    List<TblFuncion> findByFunEst(@Param("funEst") String funEst);
}
