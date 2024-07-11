package gob.cpccs.repository.retroalimentacion;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.retroalimentacion.TblAsignacionAutoridades;

/**
*
* @author Paul Tapia
*/

@Repository
public interface AsignacionAutoridadRepository extends PagingAndSortingRepository<TblAsignacionAutoridades, Integer> {

}
