package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblImplementacionIgualdad;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.repository.rendicion.TblImplementacionIgualdadRepository;
@Service
public class PoliticasIgualdadServiceImpl  implements PoliticasIgualdadService{
	
	@Autowired
	private TblImplementacionIgualdadRepository ImpleIgualdadRepository;
	
	//Inicio Implementacion Politicas para la igualdad//

		@Override
		public List<TblImplementacionIgualdad> OntenerRegistrosImplIgualdadXcod(TblInforme tblInforme) {
			return ImpleIgualdadRepository.findByInfCod(tblInforme);
		}

		@Override
		public void guardarImplementacionIgualdad(TblImplementacionIgualdad tblImplementacionIgualdad) {
		 ImpleIgualdadRepository.save(tblImplementacionIgualdad);
			
		}

		@Override
		public List<Object[]> obtenerRegistroImplementacionIgualdadXcod(TblInforme tblInforme) {
		
			return ImpleIgualdadRepository.buscarImpleIgualdad(tblInforme);
		}
	
		@Override
		public TblImplementacionIgualdad OntenerRegistroImplIgualdadXcod(Integer piCod) {
			
			return ImpleIgualdadRepository.findByPiCod(piCod);
		}

		@Override
		public void actulizarPoliticasIgualdadXcod(Integer PiCod, String piNombre, String piImplementado, String piPolitica,
				String piDetalle, String piResultado) {
			ImpleIgualdadRepository.actualizarImplePresupuesto(PiCod, piNombre, piImplementado, piPolitica, piDetalle, piResultado);
			
		}
		
		@Override
		public TblImplementacionIgualdad OntenerRegistrosImplIgualdadXcodXNombre(TblInforme tblInforme,String piNombre) {
			return ImpleIgualdadRepository.findByInfCodAndPiNombre(tblInforme, piNombre);
		}
		@Override
		public Integer OntenerCount(Integer info_cod,String piNombre) {
			return ImpleIgualdadRepository.coutPOIG(info_cod, piNombre);
		}
}
