package gob.cpccs.service.rendicion;




import java.util.Date;
import java.util.List;

import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblSede;

public interface SedeService {
	void guardarSede(TblSede tblSede);
	List<TblSede> obtenerSedes(TblInforme tblInforme);
	 List<Object[]> obtenerSedesXcod (TblInforme tblInforme);
	 TblSede obtenerSedesXcodigo (int seCod);
	  void actualizarDatosSede(Integer seCod, String seNombre, Integer seProvincia, Integer seParroquia, Integer seCanton,String seDireccion, String seMail, String seWeb,String seRuc );
	  void actualizarDatosSedeDetalle(Integer seCod, String seRepresentante, String seCargo, String seMailrep, Date fechaDesignacion,String seTelrep);
	  void actualizarDatosSedeDetalle2(Integer seCod, Integer seUnidades, String seCobertura, Integer seEstudiantes, Integer seHombre, Integer seMujeres,
			  Integer seGlbti, Integer seMontubios, Integer seMestizos, Integer seCholos, Integer seIndigenas, Integer seAfroecuatorianos, Integer seExtranjeros, Integer seDiscapacitados, String seLink);

	  
}
