package gob.cpccs.service;

import java.util.List;

public interface GraficaService {
	
	 List<Object[]> ReporteGraficaprueba(String fecha );
	 
	 public  List<Object[]> ReporteGraficaInformeFinalizado(String fecha);
	 
	 public  List<Object[]> ReporteGraficaInformesAsinados(String periodo);
	 
	 List<Object[]> ReporteGraficaAutoridadRegistroActivacion(String fecha );
	 
	 public  List<Object[]> ReporteGraficaInformeFinalizadoAutoridad(String fecha);

}
