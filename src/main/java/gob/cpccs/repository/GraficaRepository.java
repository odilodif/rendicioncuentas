package gob.cpccs.repository;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface GraficaRepository {
	
	    public List<Object[]> findBycountGraficaprueba(String fecha);
	    
	    public List<Object[]> findBycountGraficaAutoridad(String fecha);
	    
	    public List<Object[]> findBycountGraficaFinalizarInformeXCumplimiento(String fecha );
	    
	    public List<Object[]> findBycountGraficaFinalizarInformeAutoridadXCumplimiento(String fecha );
	     public List<Object[]> findBycountGraficaAsignarInforme(String periodo);
	    
}
