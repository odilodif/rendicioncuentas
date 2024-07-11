package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblImplementacionIgualdad;
import gob.cpccs.model.rendicion.TblInforme;

public interface PoliticasIgualdadService {
	
	// Implementacion Politicas para la igualdad//
    TblImplementacionIgualdad OntenerRegistroImplIgualdadXcod(Integer piCod);
    List<TblImplementacionIgualdad> OntenerRegistrosImplIgualdadXcod(TblInforme tblInforme);
    void guardarImplementacionIgualdad(TblImplementacionIgualdad tblImplementacionIgualdad);
    List<Object[]> obtenerRegistroImplementacionIgualdadXcod(TblInforme tblInforme);
    void actulizarPoliticasIgualdadXcod(Integer PiCod,String piNombre,String piImplementado,String piPolitica, String piDetalle,String piResultado );
	TblImplementacionIgualdad OntenerRegistrosImplIgualdadXcodXNombre(TblInforme tblInforme, String piNombre);
	Integer OntenerCount(Integer info_cod, String piNombre);

}
