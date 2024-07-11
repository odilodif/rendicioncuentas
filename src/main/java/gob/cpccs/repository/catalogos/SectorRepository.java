package gob.cpccs.repository.catalogos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.catalogos.TblSector;

@Repository
public interface SectorRepository extends JpaRepository<TblSector, String> {
	
	TblSector findBySecCod(@Param("secCod") Integer secCod);
	
	List<TblSector> findBySecEstOrderBySecCodAsc(@Param("secEst") String secEst); 

}
