package gob.cpccs.repository.retroalimentacion;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.rendicion.TblInformeAutoridad;

/**
*
* @author Paul Tapia
*/

@Repository
public interface InformeCalificadoAutoridadesRepository extends PagingAndSortingRepository<TblInformeAutoridad, Integer> {

}
