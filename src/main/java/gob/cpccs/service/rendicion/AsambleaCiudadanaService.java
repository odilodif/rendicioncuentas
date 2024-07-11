package gob.cpccs.service.rendicion;

import java.util.List;

import gob.cpccs.model.rendicion.TblAsambleaCiudadana;
import gob.cpccs.model.rendicion.TblInforme;

public interface AsambleaCiudadanaService {

 void guardarAnteproyectoPresupuestoServiceImpl(TblAsambleaCiudadana tblAsambleaCiudadana);
	 
	 List<Object[]> BuscarAsambleaCiudadanaImpl(TblInforme tblInforme);
	 
	 TblAsambleaCiudadana ObtenerAsambleaCiudadana(Integer acCod);
	
}
