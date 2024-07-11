package gob.cpccs.service.rendicion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.rendicion.TblFasePresupuestoParticipativo;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblPresupuestoInstitucional;
import gob.cpccs.repository.rendicion.FasePresupuestoParticipativoRepository;

@Service
public class FasePresupuestoParticipativoServicesImpl implements FasePresupuestoParticipativoService{
	@Autowired 
	FasePresupuestoParticipativoRepository FasePresupuestoParticipativoRepository;
	
	@Override
	public void guardarFasePresupuestoParticipativoImpl(TblFasePresupuestoParticipativo tblFasePresupuestoParticipativo) {
		FasePresupuestoParticipativoRepository.save(tblFasePresupuestoParticipativo);		
	}
	
	@Override
	public List<Object[]> obtenerFasesPresupuestos(TblInforme infCod) {
		return FasePresupuestoParticipativoRepository.buscarFases(infCod);
	}
	@Override
	public Integer countFasePP(TblInforme infCod, String fase) {
		return FasePresupuestoParticipativoRepository.coutFPP(infCod, fase);
	}
	@Override
	public TblFasePresupuestoParticipativo obtenerFasesPresupuestosNombre(TblInforme infCod, String fase) {
		return FasePresupuestoParticipativoRepository.buscarFasesinfocod(infCod, fase);
	}
}
