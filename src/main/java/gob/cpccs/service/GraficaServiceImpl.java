package gob.cpccs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import gob.cpccs.repository.GraficaRepository;

@Service
public class GraficaServiceImpl implements GraficaService {
	@Autowired
    private GraficaRepository graficaRepository;
	

	 @Override
     public  List<Object[]> ReporteGraficaprueba(String fecha ){
          
          return  graficaRepository.findBycountGraficaprueba(fecha);
     }
     
     
     @Override
     public  List<Object[]> ReporteGraficaInformeFinalizado(String fecha ){
          
          return  graficaRepository.findBycountGraficaFinalizarInformeXCumplimiento( fecha);
     }
     
     @Override
     public  List<Object[]> ReporteGraficaInformesAsinados(String periodo ){
          
          return  graficaRepository.findBycountGraficaAsignarInforme(periodo);
     }
     
     
     @Override
     public  List<Object[]> ReporteGraficaInformeFinalizadoAutoridad(String fecha ){
          
          return  graficaRepository.findBycountGraficaFinalizarInformeAutoridadXCumplimiento( fecha);
     }
     
     
     
     @Override
     public  List<Object[]> ReporteGraficaAutoridadRegistroActivacion(String fecha ){
          
          return  graficaRepository.findBycountGraficaAutoridad(fecha);
     }
}
