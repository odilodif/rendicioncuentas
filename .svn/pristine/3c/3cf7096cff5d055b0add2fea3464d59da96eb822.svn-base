package gob.cpccs.repository.catalogos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gob.cpccs.model.catalogos.TblLocalizacion;

public interface LocalizacionCatalogoRepository extends JpaRepository<TblLocalizacion, String> {

	List<TblLocalizacion> findByCategoriaAndEstadoOrderByNombreAsc(@Param("categoria") int categoria,
			@Param("estado") String estado);

	TblLocalizacion findByCategoriaAndIdLocalizacionAndEstado(@Param("categoria") Integer categoria,
			@Param("idLocalizacion") Integer idLocalizacion, @Param("estado") String estado);

	TblLocalizacion findByIdLocalizacionAndEstado(@Param("idLocalizacion") Integer idLocalizacion,
			@Param("estado") String estado);

	@Query("select t from TblLocalizacion t where t.categoria=:categoria and t.idLocalizacion  IN(:idLocalizacion) and t.estado=:estado  ORDER BY t.nombre Asc ")
	public List<TblLocalizacion> obtenerprovinciastecnico(@Param("categoria") int categoria,
			@Param("idLocalizacion") List<Integer> idLocalizacion, @Param("estado") String estado);

}
