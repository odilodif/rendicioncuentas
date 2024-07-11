package gob.cpccs.service.catalogos;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.cpccs.model.catalogos.TblFuncion;
import gob.cpccs.model.catalogos.TblInstitucion;
import gob.cpccs.model.catalogos.TblLocalizacion;
import gob.cpccs.model.catalogos.TblSector;
import gob.cpccs.model.catalogos.TblTipoIes;
import gob.cpccs.model.catalogos.TblTipoInforme;
import gob.cpccs.model.catalogos.TblTipoMedio;
import gob.cpccs.model.dto.catalogos.SeguimientoInstitucionDTO;
import gob.cpccs.model.seguridad.TblHistoricoInstituciones;
import gob.cpccs.model.usuario.TblAutoridad;
import gob.cpccs.repository.autoridad.AutoridadJPARepository;
import gob.cpccs.repository.catalogos.FuncionRepository;
import gob.cpccs.repository.catalogos.InstitucionRepository;
import gob.cpccs.repository.catalogos.InstitucionesServicioRepository;
import gob.cpccs.repository.catalogos.LocalizacionCatalogoRepository;
import gob.cpccs.repository.catalogos.SectorRepository;
import gob.cpccs.repository.catalogos.TblTipoIesRepository;
import gob.cpccs.repository.catalogos.TipoInformeRepository;
import gob.cpccs.repository.catalogos.TipoMedioRepository;
import gob.cpccs.repository.seguridad.HistoricoInstitucionRepository;

@Service
public class CatalogosServicioImpl implements CatalogosServicio {


     @Autowired
     private LocalizacionCatalogoRepository localizacionCatalogoRepository;
     @Autowired
     private InstitucionRepository InstitucionesRepository;
     @Autowired
     private AutoridadJPARepository AutoridadRepository;
     @Autowired
     private FuncionRepository FuncionRepository;
     @Autowired 
     private SectorRepository SectoresRepository;
     @Autowired
     private TipoMedioRepository tipoMedioRepository;
     @Autowired
     private InstitucionesServicioRepository InstiServicoREpository;
     @Autowired
     private TipoInformeRepository TipoInforme;
     @Autowired
     private HistoricoInstitucionRepository HistoricoInstitucion;
     @Autowired
     private TblTipoIesRepository TipoIes;

     @Override
     public List<TblLocalizacion> obtenerLocalizacion(int categoria, String estado) {
          return localizacionCatalogoRepository.findByCategoriaAndEstadoOrderByNombreAsc(categoria, estado);
     }
     @Override
     public List<TblLocalizacion> obtenerLocalizacionfuncionarios(int categoria,List<Integer> provincia, String estado) {
          return localizacionCatalogoRepository.obtenerprovinciastecnico(categoria,provincia, estado);
     }
     @Override
     public TblLocalizacion obtenerNombreLocalizacion(Integer categoria, Integer idLocalozacion, String estado) {
          return localizacionCatalogoRepository.findByCategoriaAndIdLocalizacionAndEstado(categoria, idLocalozacion, estado);
     }

	
	@Override
	public List<TblInstitucion> ObtenerInstitucionesXRucEstado(String instRuc, String instEstado, Integer instPeriodo) {
		return InstitucionesRepository.findByInstRucAndInstEstadoAndInstPeriodo(instRuc, instEstado, instPeriodo);
	}
	@Override
	public List<TblInstitucion> ObtenerInstitucionesXprovinciaEstado(Integer provincia, String instEstado, Integer instPeriodo) {
		return InstitucionesRepository.findByProvCodAndInstEstadoAndInstPeriodo(provincia, instEstado, instPeriodo);
	}
	@Override
	public List<TblAutoridad> ObtenerAutoridadXprovinciaEstado(Integer provincia, String instEstado, Integer instPeriodo) {
		return AutoridadRepository.findByProvinciaAndEstadoAndPeriodo(provincia, instEstado, instPeriodo);
	}
	
	
	@Override
	public List<TblAutoridad> ObtenerAutoridadXidentificadorEstado(String identificador, String instEstado, Integer instPeriodo) {
		return AutoridadRepository.findByIdentificadorAndEstadoAndPeriodo (identificador, instEstado, instPeriodo);
	}
	
	
	@Override
	public TblInstitucion ObtenerInstitucionesXidEstado(Integer instCod, String instEstado, Integer instPeriodo) {
		return InstitucionesRepository.findByinstCodAndInstEstadoAndInstPeriodo(instCod, instEstado, instPeriodo);
	}

	@Override
	public TblFuncion ObtenerFuncionXid(Integer funCod) {	
		return FuncionRepository.findByFunCod(funCod);
	}

	@Override
	public TblSector ObtenerSectorXid(Integer secCod) {	
		return SectoresRepository.findBySecCod(secCod);
	}

	@Override
	public TblTipoMedio ObtenerTipoMedioXid(Integer tmeCod) {
		return tipoMedioRepository.findByTmeCod(tmeCod) ;
	}

	@Override
	public void ActualizarDatosIntitucionRegistro(Integer provCod, Integer cantCod, Integer parroCod, String instDir,
			String instTel, String instEma, String instPag, Date instFechaRegistro, Integer instCod, String instRucDoc,String instEstado) {
		 InstitucionesRepository.ActualizarDatosIntitucion(provCod, cantCod, parroCod, instDir, instTel, instEma, instPag, instFechaRegistro, instCod, instRucDoc,instEstado);
		
	}
	@Override
	public TblLocalizacion obtenerNombreLocalizacionIdXExtado(Integer idLocalizacion, String estado) {
		return localizacionCatalogoRepository.findByIdLocalizacionAndEstado(idLocalizacion, estado);
	}
	@Override
	public List<TblInstitucion> ObtenerInstitucionesXEstadoPeriodo(String instEstado, Integer instPeriodo) {
		return InstitucionesRepository.findByInstEstadoInactivoYInstPeriodo(instEstado, instPeriodo);
	}
	@Override
	public List<Object[]> ObtenerInstitucionesXPeriodoEstado(String instEstado, Integer instPeriodo) {
		return InstiServicoREpository.ObtenerInstitucionesXestadoPeriodo(instEstado, instPeriodo);
	}
	
	@Override
	public List<Object[]> obtenerIntitucionesDatosResponsables(String instEstado, Integer instPeriodo, String campoFecha) {
		return InstiServicoREpository.ObtenerInstitucionesDatosResponsablesXestadoPeriodo(instEstado, instPeriodo,  campoFecha);
	}
	
	@Override
	public List<Object[]> obtenerIntitucionesActivasDatosResponsables(String instEstado, Integer instPeriodo, String campoFecha) {
		return InstiServicoREpository.ObtenerInstitucionesActivasPeriodo(instEstado, instPeriodo,  campoFecha);
	}
	
	
	@Override
	public List<Object[]> obtenerIntitucionesDatosResponsablesxP(String instEstado, Integer instPeriodo, String campoFecha, Integer provincia) {
		return InstiServicoREpository.ObtenerInstitucionesDatosResponsablesXestadoPeriodoxP(instEstado, instPeriodo,  campoFecha, provincia);
	}
	

	@Override
	public List<Object[]> obtenerIntitucionesxCumplimiento(String infVerificador, Integer instPeriodo) {
		return InstiServicoREpository.ObtenerInstitucionesxCumplimiento(infVerificador, instPeriodo);
	}
	
	@Override
	public List<Object[]> obtenerIntitucionesxCumplimientoProvincia(String infVerificador, Integer instPeriodo, Integer provincia){
		return InstiServicoREpository.ObtenerInstitucionesxCumplimientoProvincia(infVerificador, instPeriodo, provincia);
	}
	
	
	@Override
	public List<Object[]> obtenerIntitucionesIncumplidas(String infVerificador, Integer instPeriodo) {
		return InstiServicoREpository.ObtenerInstitucionesxIncumplimiento(infVerificador, instPeriodo);
	}
	
	@Override
	public List<Object[]> obtenerIntitucionesIncumplidasProvincia(String infVerificador, Integer instPeriodo, Integer provincia ) {
		return InstiServicoREpository.ObtenerInstitucionesxIncumplimientoProvincia(infVerificador, instPeriodo,  provincia );
	}
	
	@Override
	public List<Object[]> ObtenerInstitucionesXprovinciaEstadoPeriodo(Integer provincia, String instEstado,
			Integer instPeriodo) {
		return InstiServicoREpository.ObtenerInstitucionesXProvinciaEstadoPeriodo(provincia, instEstado, instPeriodo);
	}
	@Override
	public List<Object[]> ObtenerInstitucionesXPeriodo(Integer instPeriodo) {
		return InstiServicoREpository.ObtenerInstitucionesXPeriodo(instPeriodo);
	}
	
	@Override
	public List<Object[]> ObtenerAutoridadesXPeriodo(Integer instPeriodo) {
		return InstiServicoREpository.ObtenerAutoridadesXPeriodo(instPeriodo);
	}
	
	@Override
	public List<TblFuncion> obtenerFuncionInstitucion(String estado) {
		return FuncionRepository.findByFunEst(estado);
	}
	@Override
	public List<TblTipoInforme> obtenerTipoInforme(String estado) {
		return TipoInforme.findByTfDesOrderByTfCodAsc(estado);
	}
	@Override
	public List<TblTipoMedio> obtenerTipoMedio(String estado) {
		return tipoMedioRepository.findByTmeEstOrderByTmeCodAsc(estado);
	}
	@Override
	public List<TblSector> obtenerTipoSector(String estado) {
		return SectoresRepository.findBySecEstOrderBySecCodAsc(estado);
	}
	@Override
	public TblTipoInforme ObtenerTipoInformeXCod(Integer instTfCod) {
		return TipoInforme.findByTfCod(instTfCod);
	}
	@Override
	public void GuardarNuevoCatastros(TblInstitucion tblInstitucion) {
		InstitucionesRepository.save(tblInstitucion);
		
	}
	@Override
	public void GuardarHistoricoInstitucion(TblHistoricoInstituciones tblHistoricoInstituciones) {
		HistoricoInstitucion.save(tblHistoricoInstituciones);
		
	}
	@Override
	public List<Object[]> ObtenerInstitucionesXRuc(String instRuc, Integer instPeriodo) {
		return InstiServicoREpository.ObtenerInstitucionesXRuc(instRuc, instPeriodo);
	}
    
	@Override
	public List<Object[]> ObtenerInstitucionesXPeriodoEstadoXRucXEstadoInforme(String instEstado, Integer instPeriodo, String ruc, String infEstado) {
		return InstiServicoREpository.ObtenerInstitucionesXruc(instEstado, instPeriodo, ruc, infEstado);
	}
	@Override
	public TblInstitucion ObtenerInstitucionesXInstCod(Integer instCod) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TblInstitucion ObtenerInstitucionesXInstCodandPeriodo(Integer instCod,Integer instPeriodo ) {
		// TODO Auto-generated method stub
		return InstitucionesRepository.findByinstCodAndInstPeriodo(instCod, instPeriodo);
	}
	@Override
	public List<Object[]> ObtenerSeguimientoInstitucion(Integer instPeriodo) {
		
		return InstiServicoREpository.ObtenerSeguimientoInstitucion(instPeriodo) ;
	}
	@Override
	public List<SeguimientoInstitucionDTO> seguimineto(Integer periodo) {
		List<Object[]> listaSeguimineto = InstitucionesRepository.findSeguiminetoAutoridad(periodo);
		return listaSeguimineto.stream().map(obj -> {			
			SeguimientoInstitucionDTO dto = SeguimientoInstitucionDTO.builder()
					                            .contador(listaSeguimineto.indexOf(obj) + 1)
												.inst_cod((Integer) obj[0])
												.inst_nom((String) obj[1])
												.inst_ruc((String) obj[2])
												.funcion((String) obj[3])
												.provincia((String) obj[4])
												.canton((String) obj[5])
												.inst_tip_des((String) obj[6])
												.inst_estado((String) obj[7])
												.inst_fecha_registro((String) obj[8])
												.inst_fecha_activar((String) obj[9])
												.inf_estado((String) obj[10])
												.inf_fechaini((String) obj[11])
												.inf_fechafin((String) obj[12])
												.inf_verificador((String) obj[13])
												.nombrerepresentante((String) obj[14])
												.emailrepresentante((String) obj[15])
												.celularrepresentante((String) obj[16])
												.nombreresponsable((String) obj[17])
												.emailresponsable((String) obj[18])
												.celularresponsable((String) obj[19])
												.nombreregistro((String) obj[20])
												.emailregistro((String) obj[21])
												.celularregistro((String) obj[22])
												.build();
			
			return dto;
		}).collect(Collectors.toList());
	
	
	}
	@Override
	public List<TblTipoIes> ListaTipoIesPorEstado(String tiesEst) {
		return TipoIes.findByTiesEst(tiesEst);
	}
	
	@Override
	public TblTipoIes TipoIesPorTiesCod(Integer tiesCod) {
		return TipoIes.findByTiesCod(tiesCod);
	}
}
