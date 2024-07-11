package gob.cpccs.repository.catalogos;

import java.util.List;

import org.springframework.stereotype.Repository;

import gob.cpccs.model.catalogos.TblInstitucion;



@Repository
public interface InstitucionesServicioRepository {
	List<Object[]> ObtenerInstitucionesXestadoPeriodo(String instEstado, Integer instPeriodo);
	
	List<Object[]> ObtenerInstitucionesDatosResponsablesXestadoPeriodo(String instEstado, Integer instPeriodo, String campoFecha);
	
	List<Object[]> ObtenerInstitucionesActivasPeriodo(String instEstado, Integer instPeriodo, String campoFecha );


	List<Object[]> ObtenerInstitucionesDatosResponsablesXestadoPeriodoxP(String instEstado, Integer instPeriodo, String campoFecha, Integer provincia );

	List<Object[]> ObtenerInstitucionesxCumplimiento(String infVerificador, Integer instPeriodo);
	
	List<Object[]> ObtenerInstitucionesxCumplimientoProvincia(String infVerificador, Integer instPeriodo, Integer provincia);

	
	List<Object[]> ObtenerInstitucionesxIncumplimiento(String infVerificador, Integer instPeriodo);
	
	List<Object[]> ObtenerInstitucionesxIncumplimientoProvincia(String infVerificador, Integer instPeriodo, Integer provincia );

	
	List<Object[]> ObtenerInstitucionesXProvinciaEstadoPeriodo(Integer provincia,String instEstado, Integer instPeriodo);
	List<Object[]> ObtenerInstitucionesXPeriodo(Integer instPeriodo);
	List<Object[]> ObtenerAutoridadesXPeriodo(Integer instPeriodo);

	List<Object[]> ObtenerInstitucionesXRuc(String instRuc, Integer instPeriodo);
	List<Object[]> ObtenerInstitucionesXruc(String instEstado, Integer instPeriodo, String ruc, String infEstado);

	List<Object[]> ObtenerSeguimientoInstitucion(Integer instPeriodo);
	
	//instanciamos el metodo Imp para obtener los años en los que se tiene informe de la institucion
	List<TblInstitucion> findByRucAndVerificadorNotNull(String ruc);
	
	List<TblInstitucion> findByRucAndVerificadorNotNullMedios (String ruc, Integer provincia, Integer canton);
	
}


