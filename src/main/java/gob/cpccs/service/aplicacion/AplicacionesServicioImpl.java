package gob.cpccs.service.aplicacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.aplicacion.TblAplicaciones;

import gob.cpccs.repository.aplicacion.AplicacionesRepository;

@Service
public class AplicacionesServicioImpl implements AplicacionesServicio {

	 @Autowired
     private AplicacionesRepository aplicacionesRepository;

     @Override
     public List<TblAplicaciones> buscarAplicacionesPorListaCodigoAplicacion(String estadoAplicacion, List<String> codificacionAplicacion) {
          return aplicacionesRepository.findByEstadoAplicacionAndCodificacionAplicacionIn(estadoAplicacion, codificacionAplicacion);
     }

     @Override
     public TblAplicaciones obtenerRegistrosAplicacionesPorid(Integer idAplicacion) {
          
          return aplicacionesRepository.findByIdAplicacion(idAplicacion);
     }
     @Override
     public List<Object[]> obtenerRegistrosAplicacionesObjeto(Integer idAplicacion,String estado) {
          
          return aplicacionesRepository.findByIdAplicacionObjeto(idAplicacion, estado);
     }
     @Override
     public void ActualizarVisitasAplicacionXid(Integer idAplicacion, Integer visitas) {
      aplicacionesRepository.ActualizarVisitasAplicacionXid(idAplicacion, visitas);
          
     }
     
   
}
