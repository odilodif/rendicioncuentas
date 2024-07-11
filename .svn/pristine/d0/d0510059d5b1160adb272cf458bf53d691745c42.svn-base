package gob.cpccs.controller.rendicion;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import java.util.Date;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import gob.cpccs.controller.HomeController;
import gob.cpccs.model.rendicion.TblImplementacionPresupuesto;

import gob.cpccs.model.rendicion.TblAnteproyectoPresupuesto;
import gob.cpccs.model.rendicion.TblAsambleaCiudadana;

import gob.cpccs.model.rendicion.TblIncoporacionRecomendaciones;
import gob.cpccs.model.rendicion.TblCoberturaInstitucional;
import gob.cpccs.model.rendicion.TblCoberturaNacional;
import gob.cpccs.model.rendicion.TblComunicacionGestion;
import gob.cpccs.model.rendicion.TblCumplimientoSugerenciaCiudadana;
import gob.cpccs.model.rendicion.TblDatosInforme;
import gob.cpccs.model.rendicion.TblDetalleComunicagestion;
import gob.cpccs.model.rendicion.TblDetalleEjecucionp;
import gob.cpccs.model.rendicion.TblEjecucionProgramatica;
import gob.cpccs.model.rendicion.TblEnajenacionBienes;
import gob.cpccs.model.rendicion.TblFasePresupuestoParticipativo;
import gob.cpccs.model.rendicion.TblFuncionesObjetivos;
import gob.cpccs.model.rendicion.TblImplementacionIgualdad;
import gob.cpccs.model.catalogos.TblInstitucion;
import gob.cpccs.model.dto.rendicion.CoberturaGADDTO;
import gob.cpccs.model.dto.rendicion.ContratacionGADDTO;
import gob.cpccs.model.dto.rendicion.DifusionComunicacionGADDTO;
import gob.cpccs.model.dto.rendicion.EjecutivoIncorporacionGADDTO;
import gob.cpccs.model.dto.rendicion.EnajenacionBienesGADDTO;
import gob.cpccs.model.dto.rendicion.MecanismosGADDTO;
import gob.cpccs.model.dto.rendicion.ObjetivosGADDTO;
import gob.cpccs.model.dto.rendicion.PlanTrabajoGADDTO;
import gob.cpccs.model.dto.rendicion.PlanificacionEjecucionGADDTO;
import gob.cpccs.model.dto.rendicion.PoliticasIgualdadGADDTO;
import gob.cpccs.model.dto.rendicion.PresupuestoInstitucionalGADDTO;
import gob.cpccs.model.dto.rendicion.PresupuestoParticipativoGADDTO;
import gob.cpccs.model.dto.rendicion.ProcesoRendicionCuentasGADDTO;
import gob.cpccs.model.dto.rendicion.ReporteAvanceGADDTO;
import gob.cpccs.model.dto.rendicion.TblDetalleComunicagestionDTO;
import gob.cpccs.model.dto.rendicion.TransparenciaAccesoGADDTO;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblMecanismoParticipacionCiudadana;
import gob.cpccs.model.rendicion.TblMecanismoRendicionCuentas;
import gob.cpccs.model.rendicion.TblMecanismosContolSocial;
import gob.cpccs.model.rendicion.TblMecanismosTranparenciaAccInf;
import gob.cpccs.model.rendicion.TblParticipacionCiudadana;
import gob.cpccs.model.rendicion.TblObjetivosPlanDesarrollo;
import gob.cpccs.model.rendicion.TblObrasAnteriores;
import gob.cpccs.model.rendicion.TblPlanDesarrollo;
import gob.cpccs.model.usuario.TblResponables;
import gob.cpccs.model.rendicion.TblPlanTrabajoGad;
import gob.cpccs.model.rendicion.TblSugerenciaCiudadana;
import gob.cpccs.model.rendicion.TblPorcentajePresupuesto;
import gob.cpccs.model.rendicion.TblPresupuestoInstitucional;
import gob.cpccs.model.rendicion.TblProcesosContratacion;
import gob.cpccs.model.rendicion.TblProyPresupuestoParticipativo;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.service.AplicacionesUsuarioJPAServicio;
import gob.cpccs.service.catalogos.CatalogosServicio;
import gob.cpccs.service.catalogos.InstitucionServicio;
import gob.cpccs.service.mail.EmailService;
import gob.cpccs.service.rendicion.ActualizarDetallePoaService;
import gob.cpccs.service.rendicion.AnteproyectoPresupuestoService;
import gob.cpccs.service.rendicion.AsambleaCiudadanaService;
import gob.cpccs.service.rendicion.CoberturaNacionalService;
import gob.cpccs.service.rendicion.CoberturaTerritorialService;
import gob.cpccs.service.rendicion.CumplimientoSugerenciaServicio;
import gob.cpccs.service.rendicion.DatosInformeService;
import gob.cpccs.service.rendicion.DetalleComunicacionServicio;
import gob.cpccs.service.rendicion.DetalleMediosService;
import gob.cpccs.service.rendicion.DetallePresupuestoParticipativoService;
import gob.cpccs.service.rendicion.FasePresupuestoParticipativoService;
import gob.cpccs.service.rendicion.IgualdadPresupuestoGadService;
import gob.cpccs.service.rendicion.IncoporacionRecomendacionesService;
import gob.cpccs.service.rendicion.InformeServicio;
import gob.cpccs.service.rendicion.MecanismoControlSocialService;
import gob.cpccs.service.rendicion.MecanismoParticipacionServicio;
import gob.cpccs.service.rendicion.ParticipacionCiudadanaGadService;
import gob.cpccs.service.rendicion.PlanTrabajoService;
import gob.cpccs.service.rendicion.PoliticasIgualdadService;
import gob.cpccs.service.rendicion.PorcentajePresupuestoService;
import gob.cpccs.service.rendicion.RendicionCuentasGadService;
import gob.cpccs.service.rendicion.EnajenacionService;
import gob.cpccs.service.rendicion.EstadoObrasService;
import gob.cpccs.service.rendicion.SugerenciaCiudadanaService;
import gob.cpccs.service.rendicion.TrasparenciaInformacionService;
import gob.cpccs.service.rendicion.PresupuestoInstitucionService;
import gob.cpccs.service.rendicion.ProcesoContratacionService;
import gob.cpccs.service.usuario.ResponsableServicio;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;

@Controller
public class InformeGadController {
	 
	@Autowired
    private HomeController hc;
	@Autowired
	private UsuarioServicio usu;
	@Autowired
	private InformeServicio infor;
	@Autowired
	private PlanTrabajoService PlanServicio;
	@Autowired
	private CoberturaNacionalService CoberturaNacionalService;
	@Autowired
	private CoberturaTerritorialService CoberturaTerritorialService;
	@Autowired
	private AplicacionesUsuarioJPAServicio auis;
    @Autowired
    private DatosInformeService datoInfo;
    @Autowired
    private IgualdadPresupuestoGadService IgualPresu;
    @Autowired
    private PoliticasIgualdadService PoliIg;
    @Autowired
    private ParticipacionCiudadanaGadService PartCiudad;
    @Autowired
    private MecanismoControlSocialService ControlSol;
    @Autowired
    private RendicionCuentasGadService RendiCuent;
	@Autowired
	private  IncoporacionRecomendacionesService IncorpRecom;
	@Autowired
	private InformeServicio is;
	@Autowired
	private SugerenciaCiudadanaService sugurenciaservicio;
	@Autowired 
	private CumplimientoSugerenciaServicio CumplimientoSugerencia;
	@Autowired
	private TrasparenciaInformacionService Trasparencia;
	@Autowired
	private MecanismoParticipacionServicio Meparticipacion;
    @Autowired
	private ActualizarDetallePoaService adps;
    @Autowired
	private PresupuestoInstitucionService pis;
    @Autowired
   	private PorcentajePresupuestoService pps;
    @Autowired
   	private FasePresupuestoParticipativoService fppis;
    @Autowired
   	private AnteproyectoPresupuestoService aps;
    @Autowired
   	private AsambleaCiudadanaService acs; 
    @Autowired
   	private DetallePresupuestoParticipativoService dpps;
    @Autowired
    private EnajenacionService enagenacion;
    @Autowired
    private ProcesoContratacionService procesocontratacion;
    @Autowired
    private EstadoObrasService obraservicion;
    @Autowired
    private DetalleMediosService medioservicio;
    @Autowired
    private DetalleComunicacionServicio mediocomunicacionservicio;
    @Autowired
	private CatalogosServicio gcs;
	@Autowired
    private EmailService ms;
	@Autowired
	private ResponsableServicio respon;
	@Autowired
	private InstitucionServicio servicioinstitucion;
	
    //Inicio Implementacion Politicas para la igualdad presupuesto//
	@RequestMapping(value = {"/obtenerImpletPresu"}, method = RequestMethod.POST)
	@ResponseBody 
	public String obtenerImpletPresu(Authentication authentication,@Param(value = "infCod") Integer infCod) {
		String json;
		ObjectMapper mapper = new ObjectMapper(); 
    	List<PoliticasIgualdadGADDTO> lista = new ArrayList<>();
		
		try {
			
			//StringBuilder resultado =new StringBuilder();
			TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
			List<Object[]> listaImplePresu=IgualPresu.obtenerRegistroImplementacionPresupuestoXcod(tblInforme);
					
			if (listaImplePresu.size()> 0) {	
				
				lista = listaImplePresu.stream()
						.map(obj ->PoliticasIgualdadGADDTO.builder()
							.imple_cod((Integer) obj[0])
							.contador(listaImplePresu.indexOf(obj) + 1)
							.seleccion(obj[1].toString())
							.grupo(obj[3].toString())
							.totalPorcentaje(obj[2].toString())
							.porcentajeGrupo(obj[4].toString())
							.build()
						)
						.collect(Collectors.toList());
	
				
				json = (!lista.isEmpty())
						? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
						: Constantes.MESSAGE_EMPTY_JSON;
			}else{
                json = "{\"data\": []}";
           }
			
			
			
		} catch (Exception e) {
			  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
		}
		 return json;
	}
	
	
	
	@RequestMapping("/view/rendicion/Frm_ImplementacionGads")
	public String Frm_ImplementacionGads(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
		 String ImplePresValida="";
		 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
			model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);
			} 
		else{
			List<TblImplementacionPresupuesto> verificarImplPresu=IgualPresu.OntenerRegistrosImplPresuXcod(verificarInforme);

			if(verificarImplPresu.size() ==0) {
				model.addAttribute("inf_estado", verificarInforme.getInfEstado());
				model.addAttribute("inf_Cod", verificarInforme.getInfCod());
			}
			else {
				model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				for (TblImplementacionPresupuesto dato : verificarImplPresu) {
					
						  ImplePresValida=dato.getImpleOpc();
				}
					if (ImplePresValida.equals("SI")) {
						List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
				         model.addAttribute("acciones", listaAcciones);
						model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_MATRIZ);
						model.addAttribute("inf_Cod", verificarInforme.getInfCod());
						
					}	
					else {
						
						model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_MATRIZ);
						model.addAttribute("inf_Cod", verificarInforme.getInfCod());
					}
				
			}		
			
		}
		return "rendicion/Frm_ImplementacionGads";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarImplementacionPre")
	public @ResponseBody String guardarImplementacionPre(TblImplementacionPresupuesto tblImplementacionPresupuesto,
			HttpServletRequest request, @RequestParam(value = "seleccion") String seleccion , @RequestParam(value = "infCod") Integer inf_Cod,
			@RequestParam(value = "porcentajeTotal", required = false) String porcentajeTotal,
			@RequestParam(value = "cbox1", required = false) String cbox1,
			@RequestParam(value = "porcentaje1", required = false) String porcentaje1,
			@RequestParam(value = "cbox2", required = false) String cbox2,
			@RequestParam(value = "porcentaje2", required = false) String porcentaje2,
			@RequestParam(value = "cbox3", required = false) String cbox3,
			@RequestParam(value = "porcentaje3", required = false) String porcentaje3,
			@RequestParam(value = "cbox4", required = false) String cbox4,
			@RequestParam(value = "porcentaje4", required = false) String porcentaje4,
			@RequestParam(value = "cbox5", required = false) String cbox5,
			@RequestParam(value = "porcentaje5", required = false) String porcentaje5,
			@RequestParam(value = "cbox6", required = false) String cbox6,
			@RequestParam(value = "porcentaje6", required = false) String porcentaje6,
			@RequestParam(value = "cbox7", required = false) String cbox7,
			@RequestParam(value = "porcentaje7", required = false) String porcentaje7,
			@RequestParam(value = "cbox8", required = false) String cbox8,
			@RequestParam(value = "porcentaje8", required = false) String porcentaje8,
			/*
			  @RequestParam(value = "cbox9", required = false) String cbox9,			  
			 @RequestParam(value = "porcentaje9", required = false) String porcentaje9,
			 */
			@RequestParam(value = "cbox10", required = false) String cbox10,
			@RequestParam(value = "porcentaje10", required = false) String porcentaje10,
			@RequestParam(value = "cbox11", required = false) String cbox11,
			@RequestParam(value = "porcentaje11", required = false) String porcentaje11,
			@RequestParam(value = "cbox12", required = false) String cbox12,
			@RequestParam(value = "porcentaje12", required = false) String porcentaje12,
			@RequestParam(value = "cbox13", required = false) String cbox13,
			@RequestParam(value = "porcentaje13", required = false) String porcentaje13) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			/*Double total = (double) 0;
			Double porcen1 = Double.valueOf(porcentaje1== null ? "0" : porcentaje1.isEmpty() ? "0" : porcentaje1.toString());
			Double porcen2 = Double.valueOf(porcentaje2== null ? "0" : porcentaje2.isEmpty() ? "0" : porcentaje2.toString());
			Double porcen3 = Double.valueOf(porcentaje3== null ? "0" : porcentaje3.isEmpty() ? "0" : porcentaje3.toString());
			Double porcen4 = Double.valueOf(porcentaje4== null ? "0" : porcentaje4.isEmpty() ? "0" : porcentaje4.toString());
			Double porcen5 = Double.valueOf(porcentaje5== null ? "0" : porcentaje5.isEmpty() ? "0" : porcentaje5.toString());
			Double porcen6 = Double.valueOf(porcentaje6== null ? "0" : porcentaje6.isEmpty() ? "0" : porcentaje6.toString());
			Double porcen7 = Double.valueOf(porcentaje7== null ? "0" : porcentaje7.isEmpty() ? "0" : porcentaje7.toString());
			Double porcen8 = Double.valueOf(porcentaje8== null ? "0" : porcentaje8.isEmpty() ? "0" : porcentaje8.toString());
			Double porcen9 = Double.valueOf(porcentaje9== null ? "0" : porcentaje9.isEmpty() ? "0" : porcentaje9.toString());
			Double porcen10 = Double.valueOf(porcentaje10== null ? "0" : porcentaje10.isEmpty() ? "0" : porcentaje10.toString());
			Double porcen11 = Double.valueOf(porcentaje11== null ? "0" : porcentaje11.isEmpty() ? "0" : porcentaje11.toString());
			Double porcen12 = Double.valueOf(porcentaje12== null ? "0" : porcentaje12.isEmpty() ? "0" : porcentaje12.toString());
			Double porcen13 = Double.valueOf(porcentaje13== null ? "0" : porcentaje13.isEmpty() ? "0" : porcentaje13.toString());
			
			
			total = Math.round((porcen1 + porcen2 + porcen3 + porcen4 + porcen5 + porcen6 + porcen7 + porcen8 + porcen9 + porcen10
					+ porcen11 + porcen12 + porcen13)*100.0)/100.0;*/
			TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());

			List<TblImplementacionPresupuesto> lista_implementa = new ArrayList<TblImplementacionPresupuesto>();
			if (seleccion.equals("SI")) {
				if (cbox1 != null ) {
					tblImplementacionPresupuesto = new TblImplementacionPresupuesto();
					tblImplementacionPresupuesto.setImpleOpc(seleccion);
					tblImplementacionPresupuesto.setImplePorce(porcentajeTotal);
					tblImplementacionPresupuesto.setImpleGrupo(cbox1);
					tblImplementacionPresupuesto.setImplePorcengrupo(porcentaje1);
					tblImplementacionPresupuesto.setImpleEstado(Constantes.ESTADO);
					tblImplementacionPresupuesto.setInfoCod(tblInforme);
					lista_implementa.add(tblImplementacionPresupuesto);
				}
				if (cbox2 != null ) {
					tblImplementacionPresupuesto = new TblImplementacionPresupuesto();
					tblImplementacionPresupuesto.setImpleOpc(seleccion);
					tblImplementacionPresupuesto.setImplePorce(porcentajeTotal);
					tblImplementacionPresupuesto.setImpleGrupo(cbox2);
					tblImplementacionPresupuesto.setImplePorcengrupo(porcentaje2);
					tblImplementacionPresupuesto.setImpleEstado(Constantes.ESTADO);
					tblImplementacionPresupuesto.setInfoCod(tblInforme);
					lista_implementa.add(tblImplementacionPresupuesto);
				}
				if (cbox3 != null) {
					tblImplementacionPresupuesto = new TblImplementacionPresupuesto();
					tblImplementacionPresupuesto.setImpleOpc(seleccion);
					tblImplementacionPresupuesto.setImplePorce(porcentajeTotal);
					tblImplementacionPresupuesto.setImpleGrupo(cbox3);
					tblImplementacionPresupuesto.setImplePorcengrupo(porcentaje3);
					tblImplementacionPresupuesto.setImpleEstado(Constantes.ESTADO);
					tblImplementacionPresupuesto.setInfoCod(tblInforme);
					lista_implementa.add(tblImplementacionPresupuesto);
				}
				if (cbox4 != null) {
					tblImplementacionPresupuesto = new TblImplementacionPresupuesto();
					tblImplementacionPresupuesto.setImpleOpc(seleccion);
					tblImplementacionPresupuesto.setImplePorce(porcentajeTotal);
					tblImplementacionPresupuesto.setImpleGrupo(cbox4);
					tblImplementacionPresupuesto.setImplePorcengrupo(porcentaje4);
					tblImplementacionPresupuesto.setImpleEstado(Constantes.ESTADO);
					tblImplementacionPresupuesto.setInfoCod(tblInforme);
					lista_implementa.add(tblImplementacionPresupuesto);
				}
				if (cbox5 != null) {
					tblImplementacionPresupuesto = new TblImplementacionPresupuesto();
					tblImplementacionPresupuesto.setImpleOpc(seleccion);
					tblImplementacionPresupuesto.setImplePorce(porcentajeTotal);
					tblImplementacionPresupuesto.setImpleGrupo(cbox5);
					tblImplementacionPresupuesto.setImplePorcengrupo(porcentaje5);
					tblImplementacionPresupuesto.setImpleEstado(Constantes.ESTADO);
					tblImplementacionPresupuesto.setInfoCod(tblInforme);
					lista_implementa.add(tblImplementacionPresupuesto);
				}
				if (cbox6 != null) {
					tblImplementacionPresupuesto = new TblImplementacionPresupuesto();
					tblImplementacionPresupuesto.setImpleOpc(seleccion);
					tblImplementacionPresupuesto.setImplePorce(porcentajeTotal);
					tblImplementacionPresupuesto.setImpleGrupo(cbox6);
					tblImplementacionPresupuesto.setImplePorcengrupo(porcentaje6);
					tblImplementacionPresupuesto.setImpleEstado(Constantes.ESTADO);
					tblImplementacionPresupuesto.setInfoCod(tblInforme);
					lista_implementa.add(tblImplementacionPresupuesto);
				}
				if (cbox7 != null) {
					tblImplementacionPresupuesto = new TblImplementacionPresupuesto();
					tblImplementacionPresupuesto.setImpleOpc(seleccion);
					tblImplementacionPresupuesto.setImplePorce(porcentajeTotal);
					tblImplementacionPresupuesto.setImpleGrupo(cbox7);
					tblImplementacionPresupuesto.setImplePorcengrupo(porcentaje7);
					tblImplementacionPresupuesto.setImpleEstado(Constantes.ESTADO);
					tblImplementacionPresupuesto.setInfoCod(tblInforme);
					lista_implementa.add(tblImplementacionPresupuesto);
				}
				if (cbox8 != null) {
					mensaje.put("estado", "datos");tblImplementacionPresupuesto = new TblImplementacionPresupuesto();
					tblImplementacionPresupuesto.setImpleOpc(seleccion);
					tblImplementacionPresupuesto.setImplePorce(porcentajeTotal);
					tblImplementacionPresupuesto.setImpleGrupo(cbox8);
					tblImplementacionPresupuesto.setImplePorcengrupo(porcentaje8);
					tblImplementacionPresupuesto.setImpleEstado(Constantes.ESTADO);
					tblImplementacionPresupuesto.setInfoCod(tblInforme);
					lista_implementa.add(tblImplementacionPresupuesto);
				}
				/*
				if (cbox9 != null) {
					tblImplementacionPresupuesto = new TblImplementacionPresupuesto();
					tblImplementacionPresupuesto.setImpleOpc(seleccion);
					tblImplementacionPresupuesto.setImplePorce(porcentajeTotal);
					tblImplementacionPresupuesto.setImpleGrupo(cbox9);
					tblImplementacionPresupuesto.setImplePorcengrupo(porcentaje9);
					tblImplementacionPresupuesto.setImpleEstado(Constantes.ESTADO);
					tblImplementacionPresupuesto.setInfoCod(tblInforme);
					lista_implementa.add(tblImplementacionPresupuesto);
				}*/
				if (cbox10 != null) {
					tblImplementacionPresupuesto = new TblImplementacionPresupuesto();
					tblImplementacionPresupuesto.setImpleOpc(seleccion);
					tblImplementacionPresupuesto.setImplePorce(porcentajeTotal);
					tblImplementacionPresupuesto.setImpleGrupo(cbox10);
					tblImplementacionPresupuesto.setImplePorcengrupo(porcentaje10);
					tblImplementacionPresupuesto.setImpleEstado(Constantes.ESTADO);
					tblImplementacionPresupuesto.setInfoCod(tblInforme);
					lista_implementa.add(tblImplementacionPresupuesto);
				}
				if (cbox11 != null) {
					tblImplementacionPresupuesto = new TblImplementacionPresupuesto();
					tblImplementacionPresupuesto.setImpleOpc(seleccion);
					tblImplementacionPresupuesto.setImplePorce(porcentajeTotal);
					tblImplementacionPresupuesto.setImpleGrupo(cbox11);
					tblImplementacionPresupuesto.setImplePorcengrupo(porcentaje11);
					tblImplementacionPresupuesto.setImpleEstado(Constantes.ESTADO);
					tblImplementacionPresupuesto.setInfoCod(tblInforme);
					lista_implementa.add(tblImplementacionPresupuesto);
				}
				if (cbox12 != null) {
					tblImplementacionPresupuesto = new TblImplementacionPresupuesto();
					tblImplementacionPresupuesto.setImpleOpc(seleccion);
					tblImplementacionPresupuesto.setImplePorce(porcentajeTotal);
					tblImplementacionPresupuesto.setImpleGrupo(cbox12);
					tblImplementacionPresupuesto.setImplePorcengrupo(porcentaje12);
					tblImplementacionPresupuesto.setImpleEstado(Constantes.ESTADO);
					tblImplementacionPresupuesto.setInfoCod(tblInforme);
					lista_implementa.add(tblImplementacionPresupuesto);
				}
				if (cbox13 != null) {
					tblImplementacionPresupuesto = new TblImplementacionPresupuesto();
					tblImplementacionPresupuesto.setImpleOpc(seleccion);
					tblImplementacionPresupuesto.setImplePorce(porcentajeTotal);
					tblImplementacionPresupuesto.setImpleGrupo(cbox13);
					tblImplementacionPresupuesto.setImplePorcengrupo(porcentaje13);
					tblImplementacionPresupuesto.setImpleEstado(Constantes.ESTADO);
					tblImplementacionPresupuesto.setInfoCod(tblInforme);
					lista_implementa.add(tblImplementacionPresupuesto);
				}

			} else {
				tblImplementacionPresupuesto = new TblImplementacionPresupuesto();
				tblImplementacionPresupuesto.setImpleOpc(seleccion);
				tblImplementacionPresupuesto.setImplePorce(porcentajeTotal);
				tblImplementacionPresupuesto.setImpleGrupo("S/N");
				tblImplementacionPresupuesto.setImplePorcengrupo("0");
				tblImplementacionPresupuesto.setImplePorce("0");
				tblImplementacionPresupuesto.setImpleEstado(Constantes.ESTADO);
				tblImplementacionPresupuesto.setInfoCod(tblInforme);
				lista_implementa.add(tblImplementacionPresupuesto);

			}
			for (TblImplementacionPresupuesto item : lista_implementa) {
				Integer valor=IgualPresu.countIPRE(tblInforme, item.getImpleGrupo());
				if(valor==0){
					tblImplementacionPresupuesto = new TblImplementacionPresupuesto();
					tblImplementacionPresupuesto.setImpleOpc(item.getImpleOpc());
					tblImplementacionPresupuesto.setImplePorce(item.getImplePorce());
					tblImplementacionPresupuesto.setImpleGrupo(item.getImpleGrupo());
					tblImplementacionPresupuesto.setImplePorcengrupo(item.getImplePorcengrupo());
					tblImplementacionPresupuesto.setImpleEstado(item.getImpleEstado());
					tblImplementacionPresupuesto.setInfoCod(item.getInfoCod());
					IgualPresu.guardarImplementPresupuesto(tblImplementacionPresupuesto);
				}else {
					tblImplementacionPresupuesto = IgualPresu.OntenerRegistrosImplPresuXcodXNombre(tblInforme, item.getImpleGrupo());
					tblImplementacionPresupuesto.setImpleOpc(item.getImpleOpc());
					tblImplementacionPresupuesto.setImplePorce(item.getImplePorce());
					tblImplementacionPresupuesto.setImpleGrupo(item.getImpleGrupo());
					tblImplementacionPresupuesto.setImplePorcengrupo(item.getImplePorcengrupo());
					tblImplementacionPresupuesto.setImpleEstado(item.getImpleEstado());
					tblImplementacionPresupuesto.setInfoCod(item.getInfoCod());
					IgualPresu.guardarImplementPresupuesto(tblImplementacionPresupuesto);
				}
				
				
			}

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarImplementacionPreActu")
	public @ResponseBody String guardarImplementacionPreActu(TblImplementacionPresupuesto tblImplementacionPresupuesto,
			HttpServletRequest request, @RequestParam(value = "seleccion") String seleccion , @RequestParam(value = "infCod") Integer inf_Cod,
			@RequestParam(value = "listaopciones") String listaopciones,@RequestParam(value = "porcentaje1") String porcentaje1) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			Double total = (double) 0;
			Double Subtotal = (double) 0;
			Double porcen1 = Double.valueOf(porcentaje1== null ? "0" : porcentaje1.isEmpty() ? "0" : porcentaje1.toString());
		
			TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());
			List<TblImplementacionPresupuesto> impleporcentajetotal=IgualPresu.OntenerRegistrosImplPresuXcod(tblInforme);
			if (seleccion.equals("SI")) {
				for (TblImplementacionPresupuesto porcentaje : impleporcentajetotal) {
					  
					Subtotal+=Double.parseDouble(porcentaje.getImplePorcengrupo());
				}
				 total=Math.round((Subtotal+ porcen1)*100.0)/100.0;
				
					tblImplementacionPresupuesto = new TblImplementacionPresupuesto();
					tblImplementacionPresupuesto.setImpleOpc(seleccion);
					tblImplementacionPresupuesto.setImplePorce(total.toString());
					tblImplementacionPresupuesto.setImpleGrupo(listaopciones);
					tblImplementacionPresupuesto.setImplePorcengrupo(porcentaje1);
					tblImplementacionPresupuesto.setImpleEstado(Constantes.ESTADO);
					tblImplementacionPresupuesto.setInfoCod(tblInforme);
					IgualPresu.guardarImplementPresupuesto(tblImplementacionPresupuesto);
					IgualPresu.ActualizarImplementaPrePorcen(total.toString(), tblInforme);
				
				
			}

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	@RequestMapping(value = "/view/rendicion/Frm_ImplementacionGadsActul",method = RequestMethod.POST)
	public String Frm_ImplementacionGadsActul(Model model,Authentication authentication) {
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
		List<TblImplementacionPresupuesto> verificarImplPresu=IgualPresu.OntenerRegistrosImplPresuXcod(verificarInforme);
		ArrayList<String> listaopciones=new ArrayList<String>();
		listaopciones.add("Personas adultas Mayores");
		listaopciones.add("Niñas, niños y adolecentes");
		listaopciones.add("Jóvenes");
		listaopciones.add("Mujeres Embarazadas");
		listaopciones.add("Personas con Discapacidad");
		listaopciones.add("Movilidad Humana");
		listaopciones.add("Personas Privadas de Libertad");
		listaopciones.add("Personas con Enfermedades Catastróficas");
		listaopciones.add("Personas Usuarias y Consumidoras");
		listaopciones.add("Personas en Situación de Riesgos");
		listaopciones.add("Víctima de violencia Doméstica y Sexual");
		listaopciones.add("Maltrato Infantil");
		listaopciones.add("Desastres Naturales o Antropogénicos");		
			if(verificarImplPresu.size() > 0) {
				for (TblImplementacionPresupuesto dato : verificarImplPresu) {
					if (dato.getImpleOpc().equals("SI")) {
						 listaopciones.remove(dato.getImpleGrupo());
					}
					
					
				}
				
				model.addAttribute("listaopciones", listaopciones);
				model.addAttribute("inf_Cod", verificarInforme.getInfCod());
			}
			
			
		
		return "rendicion/Frm_ImplementacionGadsActul";
	}
	
	// Fin Implementacion Politicas para la igualdad presupuesto//
	
	// Inicio Implementacion Politicas para la igualdad//
	 private List<TblImplementacionIgualdad> lista_implementaIgualdad = new ArrayList<TblImplementacionIgualdad>();
	
	 @RequestMapping(value = {"/obtenerImpletIgualdad"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerImpletIgualdad(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
	    	List<PoliticasIgualdadGADDTO> lista = new ArrayList<>();
			try {
				
				TblInforme tblInforme = infor.obtenerRegistroInforme(infCod);
				List<Object[]> listaImpleIgualdad=PoliIg.obtenerRegistroImplementacionIgualdadXcod(tblInforme);
						
				if (listaImpleIgualdad.size()>0) {	
				
					
					for (Object[]item :listaImpleIgualdad) {
						PoliticasIgualdadGADDTO tabla1 = new PoliticasIgualdadGADDTO();
						
						if(item[4]==null) { tabla1.setDescripcion("S/N");}else {tabla1.setDescripcion(item[4].toString());}
						if(item[5]==null) { tabla1.setDetalle("S/N");}else {tabla1.setDetalle(item[5].toString());}
						if(item[6]==null) { tabla1.setExplique("S/N");}else {tabla1.setExplique(item[6].toString());}
						tabla1.setPi_cod((Integer)item[0]);
						tabla1.setContador(listaImpleIgualdad.indexOf(item)+1);
						tabla1.setPolitica(item[1].toString());
						tabla1.setSeleccion(item[2].toString());
						lista.add(tabla1);
						
					}				
					json = (!lista.isEmpty())
							? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
							: Constantes.MESSAGE_EMPTY_JSON;
				}else{
	                json = "{\"data\": []}";
	           }
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
		
	 
	 
	@RequestMapping("/view/rendicion/Frm_ImplemetacionPoliticas")
	public String Frm_ImplemetacionPoliticas(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
	   model.addAttribute("email", authentication.getName());

		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
		TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
			model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);
			} 
		else{
			
			List<TblImplementacionIgualdad> listaImplIgual=PoliIg.OntenerRegistrosImplIgualdadXcod(verificarInforme);

			if(listaImplIgual.size() ==0) {
				model.addAttribute("inf_estado", verificarInforme.getInfEstado());
				model.addAttribute("inf_Cod", verificarInforme.getInfCod());
			}
			else {
						model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_MATRIZ);
						model.addAttribute("inf_Cod", verificarInforme.getInfCod());
						model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				
			}		
			
		}
		return "rendicion/Frm_ImplemetacionPoliticas";
	}
	
	private void GuardarImpleIgualdad(TblInforme tblInforme,String politica, String seleccion, Integer Nusuario, String descripcion,String detalle, String explicacion) {
		TblImplementacionIgualdad tblImplementacionIgualdad= new TblImplementacionIgualdad();
		
		
		tblImplementacionIgualdad.setInfCod(tblInforme);
		tblImplementacionIgualdad.setPiNombre(politica);
		tblImplementacionIgualdad.setPiImplementado(seleccion);
		tblImplementacionIgualdad.setPiUsuarios(Nusuario);
		tblImplementacionIgualdad.setPiPolitica(descripcion== null ? "S/N" : descripcion.isEmpty() ? "S/N" : descripcion.toString());
		tblImplementacionIgualdad.setPiDetalle( detalle== null ? "S/N" : detalle.isEmpty() ? "S/N" : detalle.toString());
		tblImplementacionIgualdad.setPiResultado( explicacion== null ? "S/N" : explicacion.isEmpty() ? "S/N" : explicacion.toString());
		lista_implementaIgualdad.add(tblImplementacionIgualdad);
		
	}
	
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarImplementacionPolitIgualdad")
	public @ResponseBody String guardarImplementacionPolitIgualdad(HttpServletRequest request,@RequestParam(value = "infCod") Integer inf_Cod,	
			@RequestParam(value = "polit1") String polit1,
			@RequestParam(value = "seleccion1") String seleccion1,
			@RequestParam(value = "descripcion1", required = false) String descripcion1,
			@RequestParam(value = "detalle1", required = false) String detalle1,
			@RequestParam(value = "explicacion1", required = false) String explicacion1,
			@RequestParam(value = "polit2") String polit2,
			@RequestParam(value = "seleccion2") String seleccion2,
			@RequestParam(value = "descripcion2", required = false) String descripcion2,
			@RequestParam(value = "detalle2", required = false) String detalle2,
			@RequestParam(value = "explicacion2", required = false) String explicacion2,
			@RequestParam(value = "polit3") String polit3,
			@RequestParam(value = "seleccion3") String seleccion3,
			@RequestParam(value = "descripcion3", required = false) String descripcion3,
			@RequestParam(value = "detalle3", required = false) String detalle3,
			@RequestParam(value = "explicacion3", required = false) String explicacion3,
			@RequestParam(value = "polit4") String polit4,
			@RequestParam(value = "seleccion4") String seleccion4,
			@RequestParam(value = "descripcion4", required = false) String descripcion4,
			@RequestParam(value = "detalle4", required = false) String detalle4,
			@RequestParam(value = "explicacion4", required = false) String explicacion4,
			@RequestParam(value = "polit5") String polit5,
			@RequestParam(value = "seleccion5") String seleccion5,
			@RequestParam(value = "descripcion5", required = false) String descripcion5,
			@RequestParam(value = "detalle5", required = false) String detalle5,
			@RequestParam(value = "explicacion5", required = false) String explicacion5) {
            
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {	
			TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());	
			Integer Nusuario=0;		
			lista_implementaIgualdad.clear();
			GuardarImpleIgualdad(tblInforme, polit1, seleccion1, Nusuario, descripcion1, detalle1, explicacion1);
			GuardarImpleIgualdad(tblInforme, polit2, seleccion2, Nusuario, descripcion2, detalle2, explicacion2);
			GuardarImpleIgualdad(tblInforme, polit3, seleccion3, Nusuario, descripcion3, detalle3, explicacion3);
			GuardarImpleIgualdad(tblInforme, polit4, seleccion4, Nusuario, descripcion4, detalle4, explicacion4);
			GuardarImpleIgualdad(tblInforme, polit5, seleccion5, Nusuario, descripcion5, detalle5, explicacion5);
			if (lista_implementaIgualdad.size()==5) {	
			for (TblImplementacionIgualdad item : lista_implementaIgualdad) {	
				Integer valor =PoliIg.OntenerCount(inf_Cod, item.getPiNombre());
				if(valor==0) {
					TblImplementacionIgualdad tblImplementacionIgualdad= new TblImplementacionIgualdad();
					tblImplementacionIgualdad.setInfCod(item.getInfCod());
					tblImplementacionIgualdad.setPiNombre(item.getPiNombre());
					tblImplementacionIgualdad.setPiImplementado(item.getPiImplementado());
					tblImplementacionIgualdad.setPiUsuarios(item.getPiUsuarios());
					tblImplementacionIgualdad.setPiPolitica(item.getPiPolitica().toUpperCase());
					tblImplementacionIgualdad.setPiDetalle(item.getPiDetalle().toUpperCase());
					tblImplementacionIgualdad.setPiResultado(item.getPiResultado().toUpperCase());
					PoliIg.guardarImplementacionIgualdad(tblImplementacionIgualdad);
				}else {
					TblImplementacionIgualdad tblImplementacionIgualdad= PoliIg.OntenerRegistrosImplIgualdadXcodXNombre(tblInforme, item.getPiNombre());
					tblImplementacionIgualdad.setInfCod(item.getInfCod());
					tblImplementacionIgualdad.setPiNombre(item.getPiNombre());
					tblImplementacionIgualdad.setPiImplementado(item.getPiImplementado());
					tblImplementacionIgualdad.setPiUsuarios(item.getPiUsuarios());
					tblImplementacionIgualdad.setPiPolitica(item.getPiPolitica().toUpperCase());
					tblImplementacionIgualdad.setPiDetalle(item.getPiDetalle().toUpperCase());
					tblImplementacionIgualdad.setPiResultado(item.getPiResultado().toUpperCase());
					PoliIg.guardarImplementacionIgualdad(tblImplementacionIgualdad);
				}
			
			}
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			
			}else {
				mensaje.put("estado", "ERROR");
				mensaje.put("mensaje", "Las Políticas no han sido ingresadas correctamente. Por favor revise.! ");
			}

			
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	@RequestMapping(value = "/view/rendicion/Frm_ImplemetacionPoliticasActul",method = RequestMethod.POST)
	public String Frm_ImplemetacionPoliticasActul(Model model,Authentication authentication, @RequestParam("id") Integer id) {	
		TblImplementacionIgualdad verificarImpleIgualdad=PoliIg.OntenerRegistroImplIgualdadXcod(id);

			if(verificarImpleIgualdad !=null) {
			 	
				model.addAttribute("polit", verificarImpleIgualdad.getPiNombre());
				model.addAttribute("seleccion", verificarImpleIgualdad.getPiImplementado());
				model.addAttribute("descripcion", verificarImpleIgualdad.getPiPolitica());
				model.addAttribute("detalle", verificarImpleIgualdad.getPiDetalle());
				model.addAttribute("explicacion", verificarImpleIgualdad.getPiResultado());
				model.addAttribute("PiCod", verificarImpleIgualdad.getPiCod());
			
					
				}
		
		return "rendicion/Frm_ImplemetacionPoliticasActul";
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarImplementacionIgualdadActu")
	public @ResponseBody String guardarImplementacionIgualdadActu(TblImplementacionIgualdad tblImplementacionIgualdad,@RequestParam(value = "PiCod") Integer PiCod,
			HttpServletRequest request,
			@RequestParam(value = "polit") String polit,
			@RequestParam(value = "seleccion") String seleccion,
			@RequestParam(value = "descripcion", required = false) String descripcion,
			@RequestParam(value = "detalle", required = false) String detalle,
			@RequestParam(value = "explicacion", required = false) String explicacion) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			
			PoliIg.actulizarPoliticasIgualdadXcod(PiCod, polit, seleccion, descripcion, detalle, explicacion);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	// Fin Implementacion Politicas para la igualdad//
	
	// Inicio Participacion Ciudadana//
	private List<TblParticipacionCiudadana> lista_PartCiudadana= new ArrayList<TblParticipacionCiudadana>();
	
	 @RequestMapping(value = {"/obtenerPartCiudadana"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerPartCiudadana(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
			 List<MecanismosGADDTO> lista = new ArrayList<>();
			try {
						
				List<TblParticipacionCiudadana> listaPartCiudadana=PartCiudad.obtenerRegistrosPartCiudadana(infCod);
				
				if (listaPartCiudadana.size()>0) {	
					
					for (TblParticipacionCiudadana item : listaPartCiudadana) {
						MecanismosGADDTO tabla1 = new MecanismosGADDTO();
						if (item.getPcSistema().equals("DESCRIBA LOS RESULTADOS ALCANZADOS POR EL SISTEMA DE PARTICIPACIÓN")) {
							    tabla1.setLink(item.getPcDescriba().toString()); }
						   else {tabla1.setLink(item.getPcLink().toString());}
						tabla1.setPc_cod(item.getPcCod());
						tabla1.setContador(listaPartCiudadana.indexOf(item)+1);
						tabla1.setSistema(item.getPcSistema());
						tabla1.setSeleccion(item.getPcValida());
						lista.add(tabla1);
					}
					
					json = (!lista.isEmpty())
							? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
							: Constantes.MESSAGE_EMPTY_JSON;
				}else{
	                json = "{\"data\": []}";
	           }
				
				
				
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
	
	 
	@RequestMapping("/view/rendicion/Frm_ParticipacionCiudadanaGad")
	public String Frm_ParticipacionCiudadanaGad(Model model, @RequestParam("opcion") int idMenu,
		Authentication authentication) {
	   model.addAttribute("email", authentication.getName());

		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
		
		TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
			model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);
			} 
		else{
			
			List<TblParticipacionCiudadana> listaParticiCiudadana=PartCiudad.obtenerRegistrosPartCiudadana(verificarInforme.getInfCod());

		   if(listaParticiCiudadana.size() ==0) {
				model.addAttribute("inf_estado", verificarInforme.getInfEstado());
				model.addAttribute("inf_Cod", verificarInforme.getInfCod());
			}
			else {
				
						model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_MATRIZ);
						model.addAttribute("inf_Cod", verificarInforme.getInfCod());
						model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			}		
			
		}
		return "rendicion/Frm_ParticipacionCiudadanaGad";
	}
	
		private void GuardarPartCiud(TblInforme tblInforme,String part, String seleccion, String link,String descripcion) {
		TblParticipacionCiudadana tblParticipacionCiudadana= new TblParticipacionCiudadana();
		tblParticipacionCiudadana.setInfCod(tblInforme);
		tblParticipacionCiudadana.setPcSistema(part);			
		tblParticipacionCiudadana.setPcValida(seleccion);
		tblParticipacionCiudadana.setPcLink(link);	
        tblParticipacionCiudadana.setPcDescriba(descripcion);
		lista_PartCiudadana.add(tblParticipacionCiudadana);
		
	}
	     
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarParticipacionCiudadana")
	public @ResponseBody String guardarParticipacionCiudadana(HttpServletRequest request,@RequestParam(value = "infCod") Integer inf_Cod,	
			@RequestParam(value = "part1") String part1,
			@RequestParam(value = "seleccion1") String seleccion1,
			@RequestParam(value = "link1", required = false) String link1,
			@RequestParam(value = "part2") String part2,
			@RequestParam(value = "seleccion2") String seleccion2,
			@RequestParam(value = "link2", required = false) String link2,
			@RequestParam(value = "part3") String part3,
			@RequestParam(value = "seleccion3") String seleccion3,
			@RequestParam(value = "link3", required = false) String link3,
			@RequestParam(value = "part4") String part4,
			@RequestParam(value = "seleccion4") String seleccion4,
			@RequestParam(value = "link4", required = false) String link4,
			@RequestParam(value = "part5") String part5,
			@RequestParam(value = "seleccion5") String seleccion5,
			@RequestParam(value = "link5", required = false) String link5,
			@RequestParam(value = "part6") String part6,
			@RequestParam(value = "seleccion6") String seleccion6,
			@RequestParam(value = "link6", required = false) String link6,
			@RequestParam(value = "part7") String part7,
			@RequestParam(value = "seleccion7") String seleccion7,
			@RequestParam(value = "link7", required = false) String link7,
			@RequestParam(value = "part8") String part8,
			@RequestParam(value = "descripcion8") String descripcion8) {
            
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {	
			TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());	
		    lista_PartCiudadana.clear();
			GuardarPartCiud(tblInforme, part1, seleccion1, link1, null);
			GuardarPartCiud(tblInforme, part2, seleccion2, link2, null);
			GuardarPartCiud(tblInforme, part3, seleccion3, link3, null);
			GuardarPartCiud(tblInforme, part4, seleccion4, link4, null);
			GuardarPartCiud(tblInforme, part5, seleccion5, link5, null);
			GuardarPartCiud(tblInforme, part6, seleccion6, link6, null);
			GuardarPartCiud(tblInforme, part7, seleccion7, link7, null);
			GuardarPartCiud(tblInforme, part8, null, null, descripcion8);
			
			if (lista_PartCiudadana.size()==8) {	
			for (TblParticipacionCiudadana item : lista_PartCiudadana) {	
				Integer valor=PartCiudad.contarvalor(inf_Cod, item.getPcSistema());
				if(valor==0){
					TblParticipacionCiudadana tblParticipacionCiudadana= new TblParticipacionCiudadana();
					tblParticipacionCiudadana.setInfCod(tblInforme);
					tblParticipacionCiudadana.setPcSistema(item.getPcSistema());			
					tblParticipacionCiudadana.setPcValida(item.getPcValida());
					tblParticipacionCiudadana.setPcLink(item.getPcLink()== null ? null :item.getPcLink().replaceAll(System.getProperty("line.separator"), " "));
					tblParticipacionCiudadana.setPcDescriba(item.getPcDescriba());	
				    PartCiudad.guardarPartCiudadana(tblParticipacionCiudadana);
				}else {
					TblParticipacionCiudadana tblParticipacionCiudadana=PartCiudad.obtenerRegistrosPartCiudadanaCodigoTipo(inf_Cod, item.getPcSistema().toString());
					tblParticipacionCiudadana.setInfCod(tblInforme);
					tblParticipacionCiudadana.setPcSistema(item.getPcSistema());			
					tblParticipacionCiudadana.setPcValida(item.getPcValida());
					tblParticipacionCiudadana.setPcLink(item.getPcLink()== null ? null :item.getPcLink().replaceAll(System.getProperty("line.separator"), " "));
					tblParticipacionCiudadana.setPcDescriba(item.getPcDescriba());	
				    PartCiudad.guardarPartCiudadana(tblParticipacionCiudadana);
				}	
			}
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			
			}else {
				mensaje.put("estado", "ERROR");
				mensaje.put("mensaje", "Las Participaciones Ciudadanas no han sido ingresadas correctamente. Por favor revise.! ");
			}

			
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	 @RequestMapping(value = "/view/rendicion/Frm_ParticipacionCiudadanaGadActul",method = RequestMethod.POST)
		public String Frm_ParticipacionCiudadanaGadActul(Model model,Authentication authentication, @RequestParam("id") Integer id) {	
			TblParticipacionCiudadana verificarPartCiudada=PartCiudad.ObtenerRegistroPartCiudadana(id);

				if(verificarPartCiudada !=null) {
				
					model.addAttribute("pc_sistema",verificarPartCiudada.getPcSistema());
					model.addAttribute("pc_valida", verificarPartCiudada.getPcValida());
					model.addAttribute("pc_link", verificarPartCiudada.getPcLink() == null ? null :verificarPartCiudada.getPcLink());
					model.addAttribute("pc_describa", verificarPartCiudada.getPcDescriba());					
					model.addAttribute("pc_cod", verificarPartCiudada.getPcCod());
				
						
					}
			
			return "rendicion/Frm_ParticipacionCiudadanaGadActul";
		}	
	
	// Fin Participacion Ciudadana//
	
	 
	 @RequestMapping("/view/rendicion/Fmr_ProcesoContratacion")
		public String Fmr_ProcesoContratacion(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
		   model.addAttribute("email", authentication.getName());

			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
			 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
				if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){	   	   	 	model.addAttribute("infestado", Constantes.TIPO_INFORME_ESTADO_VACIO);		

	   	 	}else {
	   	 	model.addAttribute("infestado", verificarInforme.getInfEstado());	
	   	    model.addAttribute("infCod", verificarInforme.getInfCod());	
	   	 	
			}
			return "rendicion/Fmr_ProcesoContratacion";
		}

		@RequestMapping("/view/rendicion/Fmr_EnajenacionBienes")
		public String Fmr_EnajenacionBienes(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
		   model.addAttribute("email", authentication.getName());

			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
			 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
				if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){	   	   	 	model.addAttribute("infestado", Constantes.TIPO_INFORME_ESTADO_VACIO);		

	   	 	}else {
	   	 	model.addAttribute("infestado", verificarInforme.getInfEstado());	
	   	    model.addAttribute("infCod", verificarInforme.getInfCod());	
	   	 	
			}
			return "rendicion/Fmr_EnajenacionBienes";
		}
		@SuppressWarnings("finally")
		@RequestMapping(value = "view/rendicion/guardarEnagenacion")
		public @ResponseBody String guardarEnagenacion(HttpServletRequest request,@RequestParam(value = "infCod") Integer inf_Cod,@RequestParam(value = "enbTipo") String enbTipo,@RequestParam(value = "enbDescripcion") String enbDescripcion,@RequestParam(value = "enbValor") String enbValor,@RequestParam(value = "enbLink") String enbLink) {
	            
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {	
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());	
				TblEnajenacionBienes tblenajenacion=new TblEnajenacionBienes();
				tblenajenacion.setEnbTipo(enbTipo);
				String valor=enbValor.toString().replace(",", "").trim();
				tblenajenacion.setEnbDescripcion(enbDescripcion== null ? null : enbDescripcion);
				//tblenajenacion.setEnbDescripcion(enbDescripcion.replaceAll(System.getProperty("line.separator"), ""));
				//tblParticipacionCiudadana.setPcLink(item.getPcLink()== null ? null :item.getPcLink().replaceAll(System.getProperty("line.separator"), " "));
				tblenajenacion.setEnbValor(new BigDecimal(valor));
				tblenajenacion.setEnbLink(enbLink);
				tblenajenacion.setInfCod(tblInforme);
				enagenacion.guardarenagenacion(tblenajenacion);
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
				

				
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}

		}
		@SuppressWarnings("finally")
		@RequestMapping(value = "view/rendicion/guardarProceso")
		public @ResponseBody String guardarProceso(HttpServletRequest request,@RequestParam(value = "infCod") Integer inf_Cod,@RequestParam(value = "pcoTipoContrat") String pcoTipoContrat,@RequestParam(value = "pcoNumeroAdj") String pcoNumeroAdj,@RequestParam(value = "pcoValorAdj") String pcoValorAdj,@RequestParam(value = "pcoNumeroFin") String pcoNumeroFin,@RequestParam(value = "pcoValorFin") String pcoValorFin,@RequestParam(value = "pcoLink") String pcoLink) {
	            
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {	
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());	
				TblProcesosContratacion tblcontratacion=new TblProcesosContratacion();
				tblcontratacion.setPcoTipoContrat(pcoTipoContrat);
				tblcontratacion.setPcoNumeroAdj(Integer.parseInt(pcoNumeroAdj));
				String valor=pcoValorAdj.toString().replace(",", "").trim();
				String valor1=pcoValorFin.toString().replace(",", "").trim();
				tblcontratacion.setPcoValorAdj(new BigDecimal(valor));
				tblcontratacion.setPcoNumeroFin(Integer.parseInt(pcoNumeroFin));
				tblcontratacion.setPcoValorFin(new BigDecimal(valor1));
				tblcontratacion.setPcoLink(pcoLink== null? null: pcoLink);
				//tblcontratacion.setPcoLink(pcoLink.replaceAll(System.getProperty("line.separator"), ""));
				tblcontratacion.setInfCod(tblInforme);
				procesocontratacion.guardarContratacion(tblcontratacion);
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
				

				
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}

		}
		 @RequestMapping(value = {"/obtenerRegistrosEnagenacion"}, method = RequestMethod.POST)
		    @ResponseBody
		    public String obtenerRegistrosEnagenacion(Authentication authentication,@RequestParam("infCod") Integer infCod) {
		         String json;
		         ObjectMapper mapper = new ObjectMapper(); 
		         List<EnajenacionBienesGADDTO> lista = new ArrayList<>();

		         try{
		              List<TblEnajenacionBienes> listaRegistros =enagenacion.obtenerRegistroEnagenacion(infCod);
		              DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
                      simbolo.setDecimalSeparator('.');
                       simbolo.setGroupingSeparator(',');
                      DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
		              if (listaRegistros.size() > 0){
		            	  
		            	  lista=listaRegistros.stream().map(obj->EnajenacionBienesGADDTO.builder()
		            			  .enbCod(obj.getEnbCod())
		            			  .contador(listaRegistros.indexOf(obj)+1)
		            			  .tipo(obj.getEnbTipo().toString())
		            			  .descripcion(obj.getEnbDescripcion().toString())
		            			  .valor(formateador.format(obj.getEnbValor()).toString())
		            			  .link(obj.getEnbLink().toString())
		            			  .build())
		            			  .collect(Collectors.toList());
		            	  json = (!lista.isEmpty())
		        					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
		        					: Constantes.MESSAGE_EMPTY_JSON;
		            	  } else{
		            	  json = "{\"Error\": []}";
		              }

		         } catch (Exception e){
		              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		         }

		         return json;
		    }
		 @RequestMapping(value = {"/obtenerRegistrosProcesoContratacion"}, method = RequestMethod.POST)
		    @ResponseBody
		    public String obtenerRegistrosProcesoContratacion(Authentication authentication,@RequestParam("infCod") Integer infCod) {
		         String json;
		         ObjectMapper mapper = new ObjectMapper(); 
		         List<ContratacionGADDTO> lista = new ArrayList<>();
		         try{
		              List<TblProcesosContratacion> listaRegistros =procesocontratacion.obtenerRegistroContratacion(infCod);            
		              DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
                      simbolo.setDecimalSeparator('.');
                       simbolo.setGroupingSeparator(',');
                      DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
		              if (listaRegistros.size() > 0){
		            	  
		            	  lista=listaRegistros.stream().map(obj->ContratacionGADDTO.builder()
		            			  .pcoCod(obj.getPcoCod())
		            			  .contador(listaRegistros.indexOf(obj)+1)
		            			  .tipo(obj.getPcoTipoContrat().toString())
		            			  .numeroAdj(obj.getPcoNumeroAdj())
		            			  .valorAdj(formateador.format(obj.getPcoValorAdj()).toString())
		            			  .valorFin(formateador.format(obj.getPcoValorFin()).toString())
		            			  .numeroFin(obj.getPcoNumeroFin())
		            			  .link(obj.getPcoLink().toString())
		            			  .build())
		            			  .collect(Collectors.toList());
		            	  json = (!lista.isEmpty())
		        					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
		        					: Constantes.MESSAGE_EMPTY_JSON;
		            	  } else{
		            	  json = "{\"Error\": []}";
		              }

		         } catch (Exception e){
		              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		         }

		         return json;
		    }

	 
	//Inicio Mecanismos de Control Social//
	 private List<TblMecanismosContolSocial> lista_ControlSocial= new ArrayList<TblMecanismosContolSocial>();
	
	 @RequestMapping(value = {"/obtenerControlSocial"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerControlSocial(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
			List<MecanismosGADDTO> lista = new ArrayList<>();
			try {
					
				List<TblMecanismosContolSocial> listaControlSocial=ControlSol.obtenerRegistroControlSocial(infCod);
				if (listaControlSocial.size()>0) {	
					
					lista=listaControlSocial.stream()
							.map(obj->MecanismosGADDTO.builder()
							.mec_cod(obj.getMecCod())
							.contador(listaControlSocial.indexOf(obj)+1)
							.sistema(obj.getMecNombre().toString())
							.seleccion(obj.getMecImplementado().toString())
							.numero(obj.getMecNumero())
							.link(obj.getMecMedioverifica().toString())
							.build())
							.collect(Collectors.toList()
							);
					json = (!lista.isEmpty())
        					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
        					: Constantes.MESSAGE_EMPTY_JSON;
					}else{
	                json = "{\"data\": []}";
	           }
				
				
				
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
	 
	@RequestMapping("/view/rendicion/Frm_MecanismosConstrolSocial")
	public String Frm_MecanismosConstrolSocial(Model model, @RequestParam("opcion") int idMenu,
		Authentication authentication) {
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
		TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
			model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);
			} 
		else{
			List<TblMecanismosContolSocial> listaControlSocial=ControlSol.obtenerRegistroControlSocial(verificarInforme.getInfCod());

		   if(listaControlSocial.size() ==0) {
				model.addAttribute("inf_estado", verificarInforme.getInfEstado());
				model.addAttribute("inf_Cod", verificarInforme.getInfCod());
			}
			else {
						model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_MATRIZ);
						model.addAttribute("inf_Cod", verificarInforme.getInfCod());
						model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			}		
			
		}
		return "rendicion/Frm_MecanismosConstrolSocial";
	}
	
	
	private void GuardarControlSocial(TblInforme tblInforme,String part, String seleccion,Integer numero, String link) {
		TblMecanismosContolSocial tblMecanismosContolSocial= new TblMecanismosContolSocial();
		tblMecanismosContolSocial.setInfCod(tblInforme);
		tblMecanismosContolSocial.setMecNombre(part);			
		tblMecanismosContolSocial.setMecImplementado(seleccion);
		tblMecanismosContolSocial.setMecNumero(numero);	
		tblMecanismosContolSocial.setMecMedioverifica(link == null ? null : link);
	//	tblMecanismosContolSocial.setMecMedioverifica(link.replaceAll(System.getProperty("line.separator"), ""));
		tblMecanismosContolSocial.setMecTi("MECANISMOS DE CONTROL SOCIAL");
        lista_ControlSocial.add(tblMecanismosContolSocial);
		
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarMecaContSocial")
	public @ResponseBody String guardarMecaContSocial(HttpServletRequest request,@RequestParam(value = "infCod") Integer inf_Cod,	
			@RequestParam(value = "part1") String part1,
			@RequestParam(value = "seleccion1") String seleccion1,			
			@RequestParam(value = "numero1", required = false) Integer numero1,
			@RequestParam(value = "link1", required = false) String link1,
			@RequestParam(value = "part2") String part2,
			@RequestParam(value = "seleccion2") String seleccion2,
			@RequestParam(value = "numero2", required = false) Integer numero2,
			@RequestParam(value = "link2", required = false) String link2,
			@RequestParam(value = "part3") String part3,
			@RequestParam(value = "seleccion3") String seleccion3,
			@RequestParam(value = "numero3", required = false) Integer numero3,
			@RequestParam(value = "link3", required = false) String link3,
			@RequestParam(value = "part4") String part4,
			@RequestParam(value = "seleccion4") String seleccion4,
			@RequestParam(value = "numero4", required = false) Integer numero4,
			@RequestParam(value = "link4", required = false) String link4,
			@RequestParam(value = "part5") String part5,
			@RequestParam(value = "seleccion5") String seleccion5,
			@RequestParam(value = "numero5", required = false) Integer numero5,
			@RequestParam(value = "link5", required = false) String link5) {
            
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {	
			TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());	
		    lista_ControlSocial.clear();
		    GuardarControlSocial(tblInforme, part1, seleccion1,numero1, link1);
		    GuardarControlSocial(tblInforme, part2, seleccion2,numero2, link2);
		    GuardarControlSocial(tblInforme, part3, seleccion3,numero3, link3);
		    GuardarControlSocial(tblInforme, part4, seleccion4,numero4, link4);
		    GuardarControlSocial(tblInforme, part5, seleccion5,numero5, link5);
			
			
			if (lista_ControlSocial.size()==5) {	
			for (TblMecanismosContolSocial item : lista_ControlSocial) {	
				Integer valor=ControlSol.ContadorMCS(inf_Cod, item.getMecNombre());
				if (valor==0) {
					TblMecanismosContolSocial tblMecanismosContolSocial= new TblMecanismosContolSocial();
					tblMecanismosContolSocial.setInfCod(item.getInfCod());
					tblMecanismosContolSocial.setMecNombre(item.getMecNombre());			
					tblMecanismosContolSocial.setMecImplementado(item.getMecImplementado());
					tblMecanismosContolSocial.setMecNumero(item.getMecNumero());	
					tblMecanismosContolSocial.setMecMedioverifica(item.getMecMedioverifica());
					tblMecanismosContolSocial.setMecTi(item.getMecTi());
					ControlSol.guardarControlSocial(tblMecanismosContolSocial);
				}else {
					TblMecanismosContolSocial tblMecanismosContolSocial= ControlSol.ObtenerRegistroContrSocialNombre(inf_Cod, item.getMecNombre());
					tblMecanismosContolSocial.setInfCod(item.getInfCod());
					tblMecanismosContolSocial.setMecNombre(item.getMecNombre());			
					tblMecanismosContolSocial.setMecImplementado(item.getMecImplementado());
					tblMecanismosContolSocial.setMecNumero(item.getMecNumero());	
					tblMecanismosContolSocial.setMecMedioverifica(item.getMecMedioverifica());
					tblMecanismosContolSocial.setMecTi(item.getMecTi());
					ControlSol.guardarControlSocial(tblMecanismosContolSocial);
				}
			
				
			}
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			
			}else {
				mensaje.put("estado", "ERROR");
				mensaje.put("mensaje", "Las Participaciones Ciudadanas no han sido ingresadas correctamente. Por favor revise.! ");
			}

			
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
		
	@RequestMapping(value = "/view/rendicion/Frm_MecanismosConstrolSocialActul",method = RequestMethod.POST)
	public String Frm_MecanismosConstrolSocialActul(Model model,Authentication authentication, @RequestParam("id") Integer id) {	
		TblMecanismosContolSocial verificarControlSocial=ControlSol.ObtenerRegistroContrSocial(id);

			if(verificarControlSocial !=null) {			
				model.addAttribute("mec_nombre",verificarControlSocial.getMecNombre());
				model.addAttribute("mec_implementado", verificarControlSocial.getMecImplementado());
				model.addAttribute("mec_numero", verificarControlSocial.getMecNumero());
				model.addAttribute("mec_medioverifica", verificarControlSocial.getMecMedioverifica());					
				model.addAttribute("mec_cod", verificarControlSocial.getMecCod());
			
				}
		
		return "rendicion/Frm_MecanismosConstrolSocialActul";
	}
	
	//fin Mecanismos de Control Social//
	 
	//Inicio Proceso Rendicion de Cuentas//
	
	 //Funcion General fases//
	 private List<TblMecanismoRendicionCuentas> lista_RendicionCuentas=new ArrayList<TblMecanismoRendicionCuentas>();
	 
	 private void GuardarRendicionCuentas(TblInforme tblInforme,String fase,String rc, String seleccion,String descripcion, String link,String observacion) {
			TblMecanismoRendicionCuentas tblMecanismoRendicionCuentas= new TblMecanismoRendicionCuentas();
			tblMecanismoRendicionCuentas.setInfCod(tblInforme);
			tblMecanismoRendicionCuentas.setMecanismoFase(fase);			
			tblMecanismoRendicionCuentas.setMecanismoNombre(rc);
			tblMecanismoRendicionCuentas.setMecanismoImplementado(seleccion);	
			tblMecanismoRendicionCuentas.setMecanismoEjecucion(descripcion == null ? null : descripcion);
			//tblMecanismoRendicionCuentas.setMecanismoEjecucion(descripcion.replaceAll(System.getProperty("line.separator"), " "));
			tblMecanismoRendicionCuentas.setMecanismoMedioverifica(link);
			//tblMecanismoRendicionCuentas.setMecanismoMedioverifica(link.replaceAll(System.getProperty("line.separator"), ""));
			if(observacion.equals(null) || observacion.equals("")) {
				tblMecanismoRendicionCuentas.setMecanismoObservacion("Ninguna");
			}else {
				tblMecanismoRendicionCuentas.setMecanismoObservacion(observacion);
			}
			
			tblMecanismoRendicionCuentas.setMecanismoTipo("RENDICION DE CUENTAS");
	        tblMecanismoRendicionCuentas.setMecanismoEstado(Constantes.ESTADO);
			lista_RendicionCuentas.add(tblMecanismoRendicionCuentas);
			
		}
	 
	 //Inicio Fase 1//	 
	 @RequestMapping(value = {"/obtenerRendicionFase1"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerRendicionFase1(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			 ObjectMapper mapper = new ObjectMapper(); 
			 List<ProcesoRendicionCuentasGADDTO> lista = new ArrayList<>();
			try {
		
				List<TblMecanismoRendicionCuentas> listaRendicionCuentas=RendiCuent.ObtenerRegistrosXInfoCodFase(infCod,Constantes.FASE1);
				if (listaRendicionCuentas.size()>0) {					
					lista = listaRendicionCuentas.stream()
        					.map(obj -> ProcesoRendicionCuentasGADDTO.builder()
        					.mecanismo_cod(obj.getMecanismoCod())
        					.contador(listaRendicionCuentas.indexOf(obj)+1)
        					.proceso(obj.getMecanismoNombre().toString())
        					.seleccion(obj.getMecanismoImplementado().toString())
        					.describa((obj.getMecanismoEjecucion().isEmpty()?"S/N":obj.getMecanismoEjecucion().toString()))
        					.link(obj.getMecanismoMedioverifica().toString())
        					.observaciones(obj.getMecanismoObservacion().toString())
        					.build())
        					.collect(Collectors.toList());
        			json = (!lista.isEmpty())
        					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
        					: Constantes.MESSAGE_EMPTY_JSON;
        			}else{
	                json = "{\"data\": []}";
	           }
				
				
				
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
	 
	 @RequestMapping("/view/rendicion/Frm_RendicionCuentasGadFase1")
		public String Frm_RendicionCuentasGadFase1(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
			TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
				model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);
				} 
			else{
				List<TblMecanismoRendicionCuentas> listaRendicionCuentas=RendiCuent.ObtenerRegistrosXInfoCodFase(verificarInforme.getInfCod(),Constantes.FASE1);

				if(listaRendicionCuentas.size() ==0) {
					model.addAttribute("inf_estado", verificarInforme.getInfEstado());
					model.addAttribute("inf_Cod", verificarInforme.getInfCod());
				}
				else {
							model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_MATRIZ);
							model.addAttribute("inf_Cod", verificarInforme.getInfCod());
							model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				}		
				
			}
			return "rendicion/Frm_RendicionCuentasGadFase1";
		}	 
		
		@SuppressWarnings("finally")
		@RequestMapping(value = "view/rendicion/guardarRendiconCuentasFase1")
		public @ResponseBody String guardarRendiconCuentasFase1(HttpServletRequest request,@RequestParam(value = "infCod") Integer inf_Cod,	
				@RequestParam(value = "fase1") String fase1,
				@RequestParam(value = "rc1") String rc1,
				@RequestParam(value = "seleccion1") String seleccion1,			
				@RequestParam(value = "descripcion1", required = false) String descripcion1,
				@RequestParam(value = "link1", required = false) String link1,
				@RequestParam(value = "observacion1", required = false) String observacion1,
				@RequestParam(value = "rc2") String rc2,
				@RequestParam(value = "seleccion2") String seleccion2,			
				@RequestParam(value = "descripcion2", required = false) String descripcion2,
				@RequestParam(value = "link2", required = false) String link2,
				@RequestParam(value = "observacion2", required = false) String observacion2,
				@RequestParam(value = "rc3") String rc3,
				@RequestParam(value = "seleccion3") String seleccion3,			
				@RequestParam(value = "descripcion3", required = false) String descripcion3,
				@RequestParam(value = "link3", required = false) String link3,
				@RequestParam(value = "observacion3", required = false) String observacion3) {
	            
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {	
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());	
			    lista_RendicionCuentas.clear();
			    GuardarRendicionCuentas(tblInforme, fase1, rc1, seleccion1, descripcion1, link1, observacion1);
			    GuardarRendicionCuentas(tblInforme, fase1, rc2, seleccion2, descripcion2, link2, observacion2);
				GuardarRendicionCuentas(tblInforme, fase1, rc3, seleccion3, descripcion3, link3, observacion3);
				
				if (lista_RendicionCuentas.size()==3) {	
				for (TblMecanismoRendicionCuentas item : lista_RendicionCuentas) {	
					Integer valor =RendiCuent.CountMRC(inf_Cod, item.getMecanismoNombre());
					if(valor==0) {
						TblMecanismoRendicionCuentas tblMecanismoRendicionCuentas= new TblMecanismoRendicionCuentas();
						tblMecanismoRendicionCuentas.setInfCod(tblInforme);
						tblMecanismoRendicionCuentas.setMecanismoFase(item.getMecanismoFase());			
						tblMecanismoRendicionCuentas.setMecanismoNombre(item.getMecanismoNombre());
						tblMecanismoRendicionCuentas.setMecanismoImplementado(item.getMecanismoImplementado());	
						tblMecanismoRendicionCuentas.setMecanismoEjecucion(item.getMecanismoEjecucion() == null ? null :item.getMecanismoEjecucion());
						tblMecanismoRendicionCuentas.setMecanismoMedioverifica(item.getMecanismoMedioverifica() == null ? null : item.getMecanismoMedioverifica());
						tblMecanismoRendicionCuentas.setMecanismoObservacion(item.getMecanismoObservacion() == null ? null: item.getMecanismoObservacion());	
						tblMecanismoRendicionCuentas.setMecanismoTipo(item.getMecanismoTipo());
						tblMecanismoRendicionCuentas.setMecanismoEstado(item.getMecanismoEstado());
						RendiCuent.guadarRendicioncuentas(tblMecanismoRendicionCuentas);
					}else {
						TblMecanismoRendicionCuentas tblMecanismoRendicionCuentas= RendiCuent.ObtenerRegistrosXInfoCodNombre(inf_Cod, item.getMecanismoNombre());
						tblMecanismoRendicionCuentas.setInfCod(tblInforme);
						tblMecanismoRendicionCuentas.setMecanismoFase(item.getMecanismoFase());			
						tblMecanismoRendicionCuentas.setMecanismoNombre(item.getMecanismoNombre());
						tblMecanismoRendicionCuentas.setMecanismoImplementado(item.getMecanismoImplementado());	
						tblMecanismoRendicionCuentas.setMecanismoEjecucion(item.getMecanismoEjecucion() == null ? null :item.getMecanismoEjecucion());
						tblMecanismoRendicionCuentas.setMecanismoMedioverifica(item.getMecanismoMedioverifica() == null ? null : item.getMecanismoMedioverifica());
						tblMecanismoRendicionCuentas.setMecanismoObservacion(item.getMecanismoObservacion() == null ? null: item.getMecanismoObservacion());	
						tblMecanismoRendicionCuentas.setMecanismoTipo(item.getMecanismoTipo());
						tblMecanismoRendicionCuentas.setMecanismoEstado(item.getMecanismoEstado());
						RendiCuent.guadarRendicioncuentas(tblMecanismoRendicionCuentas);
					}
					
				}
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
				
				}else {
					mensaje.put("estado", "ERROR");
					mensaje.put("mensaje", "Las Participaciones Ciudadanas no han sido ingresadas correctamente. Por favor revise.! ");
				}

				
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}

		}
		//Fin Fase  1//	
		
		//Inicio Fase  2//
		 @RequestMapping(value = {"/obtenerRendicionFase2"}, method = RequestMethod.POST)
			@ResponseBody 
			public String obtenerRendicionFase2(Authentication authentication,@Param(value = "infCod") Integer infCod) {
				String json;
				ObjectMapper mapper = new ObjectMapper(); 
				List<ProcesoRendicionCuentasGADDTO> lista = new ArrayList<>();
				try {
							
					List<TblMecanismoRendicionCuentas> listaRendicionCuentas=RendiCuent.ObtenerRegistrosXInfoCodFase(infCod,Constantes.FASE2);
					if (listaRendicionCuentas.size()>0) {					
						lista = listaRendicionCuentas.stream()
	        					.map(obj -> ProcesoRendicionCuentasGADDTO.builder()
	        					.mecanismo_cod(obj.getMecanismoCod())
	        					.contador(listaRendicionCuentas.indexOf(obj)+1)
	        					.proceso(obj.getMecanismoNombre().toString())
	        					.seleccion(obj.getMecanismoImplementado().toString())
	        					.describa((obj.getMecanismoEjecucion().isEmpty()? "S/N":obj.getMecanismoEjecucion().toString()))
	        					.link(obj.getMecanismoMedioverifica().toString())
	        					.observaciones(obj.getMecanismoObservacion().toString())
	        					.build())
	        					.collect(Collectors.toList());
	        			json = (!lista.isEmpty())
	        					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
	        					: Constantes.MESSAGE_EMPTY_JSON;
					}else{
		                json = "{\"data\": []}";
		           }
					
					
					
				} catch (Exception e) {
					  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
				}
				 return json;
			}
		@RequestMapping("/view/rendicion/Frm_RendicionCuentasGadFase2")
		public String Frm_RendicionCuentasGadFase2(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
			TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
				model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);
				} 
			else{
				List<TblMecanismoRendicionCuentas> listaRendicionCuentas=RendiCuent.ObtenerRegistrosXInfoCodFase(verificarInforme.getInfCod(),Constantes.FASE2);

			   if(listaRendicionCuentas.size() ==0) {
					model.addAttribute("inf_estado", verificarInforme.getInfEstado());
					model.addAttribute("inf_Cod", verificarInforme.getInfCod());
				}
				else {
							model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_MATRIZ);
							model.addAttribute("inf_Cod", verificarInforme.getInfCod());
							model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				}		
				
			}
			return "rendicion/Frm_RendicionCuentasGadFase2";
		}	 
		
		@SuppressWarnings("finally")
		@RequestMapping(value = "view/rendicion/guardarRendiconCuentasFase2")
		public @ResponseBody String guardarRendiconCuentasFase2(HttpServletRequest request,@RequestParam(value = "infCod") Integer inf_Cod,	
				@RequestParam(value = "fase2") String fase2,
				@RequestParam(value = "rc1") String rc1,
				@RequestParam(value = "seleccion1") String seleccion1,			
				@RequestParam(value = "descripcion1", required = false) String descripcion1,
				@RequestParam(value = "link1", required = false) String link1,
				@RequestParam(value = "observacion1", required = false) String observacion1,
				@RequestParam(value = "rc2") String rc2,
				@RequestParam(value = "seleccion2") String seleccion2,			
				@RequestParam(value = "descripcion2", required = false) String descripcion2,
				@RequestParam(value = "link2", required = false) String link2,
				@RequestParam(value = "observacion2", required = false) String observacion2,
				@RequestParam(value = "rc3") String rc3,
				@RequestParam(value = "seleccion3") String seleccion3,			
				@RequestParam(value = "descripcion3", required = false) String descripcion3,
				@RequestParam(value = "link3", required = false) String link3,
				@RequestParam(value = "observacion3", required = false) String observacion3,
				@RequestParam(value = "rc4") String rc4,
				@RequestParam(value = "seleccion4") String seleccion4,			
				@RequestParam(value = "descripcion4", required = false) String descripcion4,
				@RequestParam(value = "link4", required = false) String link4,
				@RequestParam(value = "observacion4", required = false) String observacion4,
				@RequestParam(value = "rc5") String rc5,
				@RequestParam(value = "seleccion5") String seleccion5,			
				@RequestParam(value = "descripcion5", required = false) String descripcion5,
				@RequestParam(value = "link5", required = false) String link5,
				@RequestParam(value = "observacion5", required = false) String observacion5) {
	            
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {	
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());	
			    lista_RendicionCuentas.clear();
			    GuardarRendicionCuentas(tblInforme, fase2, rc1, seleccion1, descripcion1, link1, observacion1);
			    GuardarRendicionCuentas(tblInforme, fase2, rc2, seleccion2, descripcion2, link2, observacion2);
				GuardarRendicionCuentas(tblInforme, fase2, rc3, seleccion3, descripcion3, link3, observacion3);
				GuardarRendicionCuentas(tblInforme, fase2, rc4, seleccion4, descripcion4, link4, observacion4);
				GuardarRendicionCuentas(tblInforme, fase2, rc5, seleccion5, descripcion5, link5, observacion5);
				if (lista_RendicionCuentas.size()==5) {	
				for (TblMecanismoRendicionCuentas item : lista_RendicionCuentas) {	
					Integer valor =RendiCuent.CountMRC(inf_Cod, item.getMecanismoNombre());
					if(valor==0) {
					TblMecanismoRendicionCuentas tblMecanismoRendicionCuentas= new TblMecanismoRendicionCuentas();
					tblMecanismoRendicionCuentas.setInfCod(tblInforme);
					tblMecanismoRendicionCuentas.setMecanismoFase(item.getMecanismoFase());			
					tblMecanismoRendicionCuentas.setMecanismoNombre(item.getMecanismoNombre());
					tblMecanismoRendicionCuentas.setMecanismoImplementado(item.getMecanismoImplementado());	
					tblMecanismoRendicionCuentas.setMecanismoEjecucion(item.getMecanismoEjecucion() == null ? null : item.getMecanismoEjecucion());
					tblMecanismoRendicionCuentas.setMecanismoMedioverifica(item.getMecanismoMedioverifica() == null ? null : item.getMecanismoMedioverifica());
					tblMecanismoRendicionCuentas.setMecanismoObservacion(item.getMecanismoObservacion() == null ? null : item.getMecanismoObservacion());	
			        tblMecanismoRendicionCuentas.setMecanismoTipo(item.getMecanismoTipo());
					tblMecanismoRendicionCuentas.setMecanismoEstado(item.getMecanismoEstado());
					RendiCuent.guadarRendicioncuentas(tblMecanismoRendicionCuentas);
					}else {
						TblMecanismoRendicionCuentas tblMecanismoRendicionCuentas= RendiCuent.ObtenerRegistrosXInfoCodNombre(inf_Cod, item.getMecanismoNombre());
						tblMecanismoRendicionCuentas.setInfCod(tblInforme);
						tblMecanismoRendicionCuentas.setMecanismoFase(item.getMecanismoFase());			
						tblMecanismoRendicionCuentas.setMecanismoNombre(item.getMecanismoNombre());
						tblMecanismoRendicionCuentas.setMecanismoImplementado(item.getMecanismoImplementado());	
						tblMecanismoRendicionCuentas.setMecanismoEjecucion(item.getMecanismoEjecucion() == null ? null : item.getMecanismoEjecucion());
						tblMecanismoRendicionCuentas.setMecanismoMedioverifica(item.getMecanismoMedioverifica() == null ? null : item.getMecanismoMedioverifica());
						tblMecanismoRendicionCuentas.setMecanismoObservacion(item.getMecanismoObservacion() == null ? null : item.getMecanismoObservacion());	
				        tblMecanismoRendicionCuentas.setMecanismoTipo(item.getMecanismoTipo());
						tblMecanismoRendicionCuentas.setMecanismoEstado(item.getMecanismoEstado());
						RendiCuent.guadarRendicioncuentas(tblMecanismoRendicionCuentas);
					}
				}
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
				
				}else {
					mensaje.put("estado", "ERROR");
					mensaje.put("mensaje", "Las Participaciones Ciudadanas no han sido ingresadas correctamente. Por favor revise.! ");
				}

				
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}

		}
		
		//Fin Fase  2//	
		
		//Inicio Fase  3//
		 @RequestMapping(value = {"/obtenerRendicionFase3"}, method = RequestMethod.POST)
			@ResponseBody 
			public String obtenerRendicionFase3(Authentication authentication,@Param(value = "infCod") Integer infCod) {
				String json;
				ObjectMapper mapper = new ObjectMapper(); 
				List<ProcesoRendicionCuentasGADDTO> lista = new ArrayList<>();
				try {
							
					List<TblMecanismoRendicionCuentas> listaRendicionCuentas=RendiCuent.ObtenerRegistrosXInfoCodFase(infCod,Constantes.FASE3);
					if (listaRendicionCuentas.size()>0) {					
						lista = listaRendicionCuentas.stream()
	        					.map(obj -> ProcesoRendicionCuentasGADDTO.builder()
	        					.mecanismo_cod(obj.getMecanismoCod())
	        					.contador(listaRendicionCuentas.indexOf(obj)+1)
	        					.proceso(obj.getMecanismoNombre().toString())
	        					.seleccion(obj.getMecanismoImplementado().toString())
	        					.describa((obj.getMecanismoEjecucion().isEmpty()?"S/N":obj.getMecanismoEjecucion().toString()))
	        					.link(obj.getMecanismoMedioverifica().toString())
	        					.observaciones(obj.getMecanismoObservacion().toString())
	        					.build())
	        					.collect(Collectors.toList());
	        			json = (!lista.isEmpty())
	        					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
	        					: Constantes.MESSAGE_EMPTY_JSON;
					}else{
		                json = "{\"data\": []}";
		           }
					
					
					
				} catch (Exception e) {
					  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
				}
				 return json;
			}
		@RequestMapping("/view/rendicion/Frm_RendicionCuentasGadFase3")
		public String Frm_RendicionCuentasGadFase3(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
			TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
				model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);
				} 
			else{
				List<TblMecanismoRendicionCuentas> listaRendicionCuentas=RendiCuent.ObtenerRegistrosXInfoCodFase(verificarInforme.getInfCod(),Constantes.FASE3);

				if(listaRendicionCuentas.size() ==0) {
					model.addAttribute("inf_estado", verificarInforme.getInfEstado());
					model.addAttribute("inf_Cod", verificarInforme.getInfCod());
				}
				else {
							model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_MATRIZ);
							model.addAttribute("inf_Cod", verificarInforme.getInfCod());
							model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				}		
				
			}
			return "rendicion/Frm_RendicionCuentasGadFase3";
		}	 
		
		@SuppressWarnings("finally")
		@RequestMapping(value = "view/rendicion/guardarRendiconCuentasFase3")
		public @ResponseBody String guardarRendiconCuentasFase3(HttpServletRequest request,@RequestParam(value = "infCod") Integer inf_Cod,	
				@RequestParam(value = "fase3") String fase3,
				@RequestParam(value = "rc1") String rc1,
				@RequestParam(value = "seleccion1") String seleccion1,			
				@RequestParam(value = "descripcion1", required = false) String descripcion1,
				@RequestParam(value = "link1", required = false) String link1,
				@RequestParam(value = "observacion1", required = false) String observacion1,
				@RequestParam(value = "rc2") String rc2,
				@RequestParam(value = "seleccion2") String seleccion2,			
				@RequestParam(value = "descripcion2", required = false) String descripcion2,
				@RequestParam(value = "link2", required = false) String link2,
				@RequestParam(value = "observacion2", required = false) String observacion2,
				@RequestParam(value = "rc3") String rc3,
				@RequestParam(value = "seleccion3") String seleccion3,			
				@RequestParam(value = "descripcion3", required = false) String descripcion3,
				@RequestParam(value = "link3", required = false) String link3,
				@RequestParam(value = "observacion3", required = false) String observacion3,
				@RequestParam(value = "rc4") String rc4,
				@RequestParam(value = "seleccion4") String seleccion4,			
				@RequestParam(value = "descripcion4", required = false) String descripcion4,
				@RequestParam(value = "link4", required = false) String link4,
				@RequestParam(value = "observacion4", required = false) String observacion4,
				@RequestParam(value = "rc5") String rc5,
				@RequestParam(value = "seleccion5") String seleccion5,			
				@RequestParam(value = "descripcion5", required = false) String descripcion5,
				@RequestParam(value = "link5", required = false) String link5,
				@RequestParam(value = "observacion5", required = false) String observacion5,
				@RequestParam(value = "rc6") String rc6,
				@RequestParam(value = "seleccion6") String seleccion6,			
				@RequestParam(value = "descripcion6", required = false) String descripcion6,
				@RequestParam(value = "link6", required = false) String link6,
				@RequestParam(value = "observacion6", required = false) String observacion6,
				@RequestParam(value = "rc7") String rc7,
				@RequestParam(value = "seleccion7") String seleccion7,			
				@RequestParam(value = "descripcion7", required = false) String descripcion7,
				@RequestParam(value = "link5", required = false) String link7,
				@RequestParam(value = "observacion7", required = false) String observacion7,
				@RequestParam(value = "rc8") String rc8,
				@RequestParam(value = "seleccion8") String seleccion8,			
				@RequestParam(value = "descripcion8", required = false) String descripcion8,
				@RequestParam(value = "link8", required = false) String link8,
				@RequestParam(value = "observacion8", required = false) String observacion8,
				@RequestParam(value = "rc9") String rc9,
				@RequestParam(value = "seleccion9") String seleccion9,			
				@RequestParam(value = "descripcion9", required = false) String descripcion9,
				@RequestParam(value = "link9", required = false) String link9,
				@RequestParam(value = "observacion9", required = false) String observacion9) {
	            
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {	
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());	
			    lista_RendicionCuentas.clear();
			    GuardarRendicionCuentas(tblInforme, fase3, rc1, seleccion1, descripcion1, link1, observacion1);
			    GuardarRendicionCuentas(tblInforme, fase3, rc2, seleccion2, descripcion2, link2, observacion2);
				GuardarRendicionCuentas(tblInforme, fase3, rc3, seleccion3, descripcion3, link3, observacion3);
				GuardarRendicionCuentas(tblInforme, fase3, rc4, seleccion4, descripcion4, link4, observacion4);
				GuardarRendicionCuentas(tblInforme, fase3, rc5, seleccion5, descripcion5, link5, observacion5);
				GuardarRendicionCuentas(tblInforme, fase3, rc6, seleccion6, descripcion6, link5, observacion6);
				GuardarRendicionCuentas(tblInforme, fase3, rc7, seleccion7, descripcion7, link5, observacion7);
				GuardarRendicionCuentas(tblInforme, fase3, rc8, seleccion8, descripcion8, link5, observacion8);
				GuardarRendicionCuentas(tblInforme, fase3, rc9, seleccion9, descripcion9, link5, observacion9);
				if (lista_RendicionCuentas.size()==9) {	
				for (TblMecanismoRendicionCuentas item : lista_RendicionCuentas) {	
					Integer valor =RendiCuent.CountMRC(inf_Cod, item.getMecanismoNombre());
					if(valor==0) {
				    TblMecanismoRendicionCuentas tblMecanismoRendicionCuentas= new TblMecanismoRendicionCuentas();
					tblMecanismoRendicionCuentas.setInfCod(tblInforme);
					tblMecanismoRendicionCuentas.setMecanismoFase(item.getMecanismoFase());			
					tblMecanismoRendicionCuentas.setMecanismoNombre(item.getMecanismoNombre());
					tblMecanismoRendicionCuentas.setMecanismoImplementado(item.getMecanismoImplementado());	
					tblMecanismoRendicionCuentas.setMecanismoEjecucion(item.getMecanismoEjecucion() == null? null : item.getMecanismoEjecucion().replaceAll(System.getProperty("line.separator"), " "));
					tblMecanismoRendicionCuentas.setMecanismoMedioverifica(item.getMecanismoMedioverifica() == null ? null: item.getMecanismoMedioverifica());
					tblMecanismoRendicionCuentas.setMecanismoObservacion(item.getMecanismoObservacion() == null ? null: item.getMecanismoObservacion());		
					tblMecanismoRendicionCuentas.setMecanismoTipo(item.getMecanismoTipo());
					tblMecanismoRendicionCuentas.setMecanismoEstado(item.getMecanismoEstado());
					RendiCuent.guadarRendicioncuentas(tblMecanismoRendicionCuentas);
					}else {
					    TblMecanismoRendicionCuentas tblMecanismoRendicionCuentas= RendiCuent.ObtenerRegistrosXInfoCodNombre(inf_Cod, item.getMecanismoNombre());
						tblMecanismoRendicionCuentas.setInfCod(tblInforme);
						tblMecanismoRendicionCuentas.setMecanismoFase(item.getMecanismoFase());			
						tblMecanismoRendicionCuentas.setMecanismoNombre(item.getMecanismoNombre());
						tblMecanismoRendicionCuentas.setMecanismoImplementado(item.getMecanismoImplementado());	
						tblMecanismoRendicionCuentas.setMecanismoEjecucion(item.getMecanismoEjecucion() == null? null : item.getMecanismoEjecucion());
						tblMecanismoRendicionCuentas.setMecanismoMedioverifica(item.getMecanismoMedioverifica() == null ? null: item.getMecanismoMedioverifica());
						tblMecanismoRendicionCuentas.setMecanismoObservacion(item.getMecanismoObservacion() == null ? null: item.getMecanismoObservacion());		
						tblMecanismoRendicionCuentas.setMecanismoTipo(item.getMecanismoTipo());
						tblMecanismoRendicionCuentas.setMecanismoEstado(item.getMecanismoEstado());
						RendiCuent.guadarRendicioncuentas(tblMecanismoRendicionCuentas);
					}
				}
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
				
				}else {
					mensaje.put("estado", "ERROR");
					mensaje.put("mensaje", "Las Participaciones Ciudadanas no han sido ingresadas correctamente. Por favor revise.! ");
				}

				
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}

		}
		//Fin Fase  3//		
		
		
		// Inicio Fase 4//
		@RequestMapping(value = {"/obtenerRendicionFase4"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerRendicionFase4(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
			List<ProcesoRendicionCuentasGADDTO> lista = new ArrayList<>();
			try {
					
				List<TblMecanismoRendicionCuentas> listaRendicionCuentas=RendiCuent.ObtenerRegistrosXInfoCodFase(infCod,Constantes.FASE4);
				if (listaRendicionCuentas.size()>0) {
					
					lista = listaRendicionCuentas.stream()
        					.map(obj -> ProcesoRendicionCuentasGADDTO.builder()
        					.mecanismo_cod(obj.getMecanismoCod())
        					.contador(listaRendicionCuentas.indexOf(obj)+1)
        					.proceso(obj.getMecanismoNombre().toString())
        					.seleccion(obj.getMecanismoImplementado().toString())
        					.describa(obj.getMecanismoEjecucion().isEmpty()?"S/N":obj.getMecanismoEjecucion().toString())
        					.link(obj.getMecanismoMedioverifica().toString())
        					.observaciones(obj.getMecanismoObservacion().toString())
        					.build())
        					.collect(Collectors.toList());
        			json = (!lista.isEmpty())
        					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
        					: Constantes.MESSAGE_EMPTY_JSON;
        			}else{
	                json = "{\"data\": []}";
	           }
				
				
				
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
		@RequestMapping("/view/rendicion/Frm_RendicionCuentasGadFase4")
		public String Frm_RendicionCuentasGadFase4(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
			TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
				model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);
				} 
			else{
				List<TblMecanismoRendicionCuentas> listaRendicionCuentas=RendiCuent.ObtenerRegistrosXInfoCodFase(verificarInforme.getInfCod(),Constantes.FASE4);

			   if(listaRendicionCuentas.size() ==0) {
					model.addAttribute("inf_estado", verificarInforme.getInfEstado());
					model.addAttribute("inf_Cod", verificarInforme.getInfCod());
				}
				else {
							model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_MATRIZ);
							model.addAttribute("inf_Cod", verificarInforme.getInfCod());
							model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				}		
				
			}
			return "rendicion/Frm_RendicionCuentasGadFase4";
		}	
		
		
		@SuppressWarnings("finally")
		@RequestMapping(value = "view/rendicion/guardarRendiconCuentasFase4")
		public @ResponseBody String guardarRendiconCuentasFase4(HttpServletRequest request,@RequestParam(value = "infCod") Integer inf_Cod,	
				@RequestParam(value = "fase4") String fase4,
				@RequestParam(value = "rc1") String rc1,
				@RequestParam(value = "seleccion1") String seleccion1,			
				@RequestParam(value = "descripcion1", required = false) String descripcion1,
				@RequestParam(value = "link1", required = false) String link1,
				@RequestParam(value = "observacion1", required = false) String observacion1,
				@RequestParam(value = "rc2") String rc2,
				@RequestParam(value = "seleccion2") String seleccion2,			
				@RequestParam(value = "descripcion2", required = false) String descripcion2,
				@RequestParam(value = "link2", required = false) String link2,
				@RequestParam(value = "observacion2", required = false) String observacion2) {
	            
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {	
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());	
			    lista_RendicionCuentas.clear();
			    GuardarRendicionCuentas(tblInforme, fase4, rc1, seleccion1, descripcion1, link1, observacion1);
			    GuardarRendicionCuentas(tblInforme, fase4, rc2, seleccion2, descripcion2, link2, observacion2);
			
				if (lista_RendicionCuentas.size()==2) {	
				for (TblMecanismoRendicionCuentas item : lista_RendicionCuentas) {	
					Integer valor =RendiCuent.CountMRC(inf_Cod, item.getMecanismoNombre());
					if(valor==0) {
				    TblMecanismoRendicionCuentas tblMecanismoRendicionCuentas= new TblMecanismoRendicionCuentas();
					tblMecanismoRendicionCuentas.setInfCod(tblInforme);
					tblMecanismoRendicionCuentas.setMecanismoFase(item.getMecanismoFase());			
					tblMecanismoRendicionCuentas.setMecanismoNombre(item.getMecanismoNombre());
					tblMecanismoRendicionCuentas.setMecanismoImplementado(item.getMecanismoImplementado());	
					tblMecanismoRendicionCuentas.setMecanismoEjecucion(item.getMecanismoEjecucion() == null ? null :   item.getMecanismoEjecucion());
					tblMecanismoRendicionCuentas.setMecanismoMedioverifica(item.getMecanismoMedioverifica() == null ? null :  item.getMecanismoMedioverifica());
					tblMecanismoRendicionCuentas.setMecanismoObservacion(item.getMecanismoObservacion() == null ? null : item.getMecanismoObservacion());	
				    tblMecanismoRendicionCuentas.setMecanismoTipo(item.getMecanismoTipo());
					tblMecanismoRendicionCuentas.setMecanismoEstado(item.getMecanismoEstado());
					RendiCuent.guadarRendicioncuentas(tblMecanismoRendicionCuentas);
					}else {
						 TblMecanismoRendicionCuentas tblMecanismoRendicionCuentas=  RendiCuent.ObtenerRegistrosXInfoCodNombre(inf_Cod, item.getMecanismoNombre());
							tblMecanismoRendicionCuentas.setInfCod(tblInforme);
							tblMecanismoRendicionCuentas.setMecanismoFase(item.getMecanismoFase());			
							tblMecanismoRendicionCuentas.setMecanismoNombre(item.getMecanismoNombre());
							tblMecanismoRendicionCuentas.setMecanismoImplementado(item.getMecanismoImplementado());	
							tblMecanismoRendicionCuentas.setMecanismoEjecucion(item.getMecanismoEjecucion() == null ? null :   item.getMecanismoEjecucion());
							tblMecanismoRendicionCuentas.setMecanismoMedioverifica(item.getMecanismoMedioverifica() == null ? null :  item.getMecanismoMedioverifica());
							tblMecanismoRendicionCuentas.setMecanismoObservacion(item.getMecanismoObservacion() == null ? null : item.getMecanismoObservacion());	
						    tblMecanismoRendicionCuentas.setMecanismoTipo(item.getMecanismoTipo());
							tblMecanismoRendicionCuentas.setMecanismoEstado(item.getMecanismoEstado());
							RendiCuent.guadarRendicioncuentas(tblMecanismoRendicionCuentas);
					}
				}
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
				
				}else {
					mensaje.put("estado", "ERROR");
					mensaje.put("mensaje", "Las Participaciones Ciudadanas no han sido ingresadas correctamente. Por favor revise.! ");
				}

				
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}

		}
		
		
		// Fin Fase 4//
		
		//Actualizar Para todas las fases//
		@RequestMapping(value = "/view/rendicion/Frm_RendicionCuentasGadFasesActl",method = RequestMethod.POST)
		public String Frm_RendicionCuentasGadFasesActl(Model model,Authentication authentication, @RequestParam("id") Integer id) {	
			TblMecanismoRendicionCuentas verificarRendicionCuentas=RendiCuent.ObtenerRegistroendicionCuentas(id);

				if(verificarRendicionCuentas !=null) {	
					model.addAttribute("mecanismo_cod",verificarRendicionCuentas.getMecanismoCod());
					model.addAttribute("mecanismo_fase",verificarRendicionCuentas.getMecanismoFase());
					model.addAttribute("mecanismo_nombre", verificarRendicionCuentas.getMecanismoNombre());
					model.addAttribute("mecanismo_implementados", verificarRendicionCuentas.getMecanismoImplementado());
					model.addAttribute("mecanismo_ejecucion", verificarRendicionCuentas.getMecanismoEjecucion().toString().replaceAll(Constantes.CADENA1," ").replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3,Constantes.REMPLAZO3).replaceAll(Constantes.CADENA4,Constantes.REMPLAZO4));					
					model.addAttribute("mecanismo_medioverifica", verificarRendicionCuentas.getMecanismoMedioverifica().toString());
					model.addAttribute("mecanismo_observacion", verificarRendicionCuentas.getMecanismoObservacion().toString());
					
					}
			
			return "rendicion/Frm_RendicionCuentasGadFasesActl";
		}
		
		
		
	//fin Proceso Rendicion de Cuentas //
		
    //Inicio Incorporacion de Recomendaciones// 
		
		@RequestMapping(value = {"/obtenerIncorporacionRecom"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerIncorporacionRecom(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;			
			ObjectMapper mapper = new ObjectMapper();
			List<EjecutivoIncorporacionGADDTO> lista = new ArrayList<>();
			try {
				List<TblIncoporacionRecomendaciones> listaIncorporacionRecom= IncorpRecom.obtenerRegistroIncorporacionRecomendaciones(infCod);
				lista=listaIncorporacionRecom.stream().map(obj->EjecutivoIncorporacionGADDTO.builder()
						.ireCod(obj.getIreCod())
						.contador(listaIncorporacionRecom.indexOf(obj)+1)
						.entidad(obj.getIreEntidad())
						.informeRecom(obj.getIreDescripcion())
						.informeCumpl(obj.getIreCumplimiento())
						.porcentaje(obj.getIrePorcentaje())
						.observacion(obj.getIreObs())
						.link(obj.getIreLink())
						.build())
						.collect(Collectors.toList());
				
				json = (!lista.isEmpty())
						? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
						: Constantes.MESSAGE_EMPTY_JSON;
				
			} catch (Exception e) {
				 json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}			
			return json;
		}
		
		@RequestMapping("/view/rendicion/Frm_EjecutivoIncorporacion")
		public String Frm_EjecutivoIncorporacion(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
			TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
				model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);
				} 
			else{
				List<TblIncoporacionRecomendaciones> listaIncorporacionRecomendaciones=IncorpRecom.obtenerRegistroIncorporacionRecomendaciones(verificarInforme.getInfCod());

			   if(listaIncorporacionRecomendaciones.size() ==0) {
					model.addAttribute("inf_estado", verificarInforme.getInfEstado());
					model.addAttribute("inf_Cod", verificarInforme.getInfCod());
				}
				else {
					List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
			        model.addAttribute("acciones", listaAcciones);
					model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_MATRIZ);
					model.addAttribute("inf_Cod", verificarInforme.getInfCod());					
					model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				}		
				
			}
			return "rendicion/Frm_EjecutivoIncorporacion";
		}	 
		
		
		@SuppressWarnings("finally")
		@RequestMapping(value = "view/rendicion/guardarRecomenIncorp")
		public @ResponseBody String guardarRecomenIncorp(HttpServletRequest request,@RequestParam(value = "infCod") Integer inf_Cod,	
				@RequestParam(value = "seleccion") String seleccion,		
				@RequestParam(value = "informeRecom", required = false) String informeRecom,
				@RequestParam(value = "informeCumpli", required = false) String informeCumpli,
				@RequestParam(value = "porcentaje", required = false) Double porcentaje,
				@RequestParam(value = "observacion", required = false) String observacion,
				@RequestParam(value = "link", required = false) String link) {
	            
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {	
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(inf_Cod, Constantes.periodo());	
						
				 TblIncoporacionRecomendaciones tblIncoporacionRecomendaciones= new TblIncoporacionRecomendaciones();
					tblIncoporacionRecomendaciones.setInfCod(tblInforme);
				    tblIncoporacionRecomendaciones.setIreEntidad(seleccion);
				    tblIncoporacionRecomendaciones.setIreDescripcion(informeRecom);
				    tblIncoporacionRecomendaciones.setIreCumplimiento(informeCumpli);
				    tblIncoporacionRecomendaciones.setIrePorcentaje(BigDecimal.valueOf(porcentaje));
				    tblIncoporacionRecomendaciones.setIreObs(observacion == null ? null : observacion);
				    tblIncoporacionRecomendaciones.setIreLink(link  == null ? null : link);
				    IncorpRecom.guardarControlSocial(tblIncoporacionRecomendaciones);
				   
					mensaje.put("estado", "exito");
					mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
				
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}

		}
		
		
		
		@RequestMapping(value = "/view/rendicion/Frm_EjecutivoIncorporacionActul",method = RequestMethod.POST)
		public String Frm_EjecutivoIncorporacionActul(Model model,Authentication authentication) {
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
			
			model.addAttribute("inf_Cod", verificarInforme.getInfCod());
			
			return "rendicion/Frm_EjecutivoIncorporacionActul";
		}
		
		
		
		
    //Fin Incorporacion de Recomendaciones// 
		
	@RequestMapping("/view/rendicion/Frm_PlanTrabajo")
    public String Frm_PlanTrabajo(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("infestado", Constantes.TIPO_INFORME_ESTADO_VACIO);		

   	 	}else {
   	 	model.addAttribute("infestado", verificarInforme.getInfEstado());	
   	    model.addAttribute("codigo_informe", verificarInforme.getInfCod());	
   	 	}
         return "rendicion/Frm_PlanTrabajo";
    }
	
	@RequestMapping("/view/rendicion/Fmr_SugerenciasCiudadanas")
    public String Fmr_SugerenciasCiudadanas(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", "vacio");		

   	 	}else {
   	 	model.addAttribute("infestado", verificarInforme.getInfEstado());	
   	    model.addAttribute("codigo_informe", verificarInforme.getInfCod());	
   	 	}
         return "rendicion/Fmr_SugerenciasCiudadanas";
    }
	
	@RequestMapping("/view/rendicion/Fmr_PlanSugerencias")	
    public String Fmr_PlanSugerencias(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());	
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", "vacio");		

   	 	}else {
   	 	model.addAttribute("infestado", verificarInforme.getInfEstado());	
   	    model.addAttribute("codigo_informe", verificarInforme.getInfCod());	
   	 	}
         return "rendicion/Fmr_PlanSugerencias";
    } 
	
@RequestMapping("/view/rendicion/Fmr_EstadoObras")	
    public String Fmr_EstadoObras(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("infestado", "vacio");		

   	 	}else {
   	 	model.addAttribute("infestado", verificarInforme.getInfEstado());	
   	    model.addAttribute("codigo_informe", verificarInforme.getInfCod());	
   	 	}
         return "rendicion/Fmr_EstadoObras";
    }
	
@SuppressWarnings("finally")
@RequestMapping(value = "/view/rendicion/guardarEstadoObras")
public @ResponseBody String guardarEstadoObras(HttpServletRequest request,@RequestParam("infCod") int infCod,
		@RequestParam("obaObra") String obaObra,@RequestParam("obaValor") String obaValor,@RequestParam("obaObs") String obaObs,@RequestParam("obaEstado") String obaEstado,
		@RequestParam("obaLink") String obaLink) {
     JSONObject mensaje = new JSONObject();
     mensaje.put("estado", "error");
     mensaje.put("mensaje", "Ha ocurrido un error!");	        
     try{
    	 
    	   
			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
	
				  TblObrasAnteriores tblObras = new TblObrasAnteriores();
			      tblObras.setObaObra(obaObra);
			      tblObras.setObaEstado(obaEstado);
			      tblObras.setObaLink(obaLink == null ? null : obaLink.replaceAll(System.getProperty("line.separator"), " "));
			  //    tblObras.setObaLink(obaLink.replaceAll(System.getProperty("line.separator"), " "));
			      tblObras.setObaObs(obaObs);
			      String valor=obaValor.replaceAll(",", "").trim();
			      tblObras.setObaValor(new BigDecimal(valor));
			      tblObras.setInfCod(tblInforme);
			    obraservicion.guardarEstadoObras(tblObras);
			  
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
			 
     } catch (Exception e){
          mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
     } finally{
          return mensaje.toString();
     }
}
@RequestMapping(value = {"/obtenerRegistrosObrasAnteriores"}, method = RequestMethod.POST)
@ResponseBody
public String obtenerRegistrosObrasAnteriores(Authentication authentication,@RequestParam("infCod") Integer infCod) {
     String json;
     ObjectMapper mapper = new ObjectMapper(); 
	 List<PlanificacionEjecucionGADDTO> lista = new ArrayList<>();
	 
	 
     try{
        
          List<TblObrasAnteriores> listaRegistros =obraservicion.obtenerRegistroEstadoObras(infCod);
          if (listaRegistros.size() > 0){
        	  DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
              simbolo.setDecimalSeparator('.');
               simbolo.setGroupingSeparator(',');
              DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
  			lista = listaRegistros.stream()
  					.map(obj -> PlanificacionEjecucionGADDTO.builder()
  							.obaCod(obj.getObaCod())
  							.contador(listaRegistros.indexOf(obj)+1)
  							.valor(formateador.format(obj.getObaValor()))
  							.estado(obj.getObaEstado())
  							.observacion(obj.getObaObs())
  							.obra(obj.getObaObra())
  							.Link(obj.getObaLink())
  							.build())
  					.collect(Collectors.toList());
  			json = (!lista.isEmpty())
  					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
  					: Constantes.MESSAGE_EMPTY_JSON;

              
         } else{
       	  json = "{\"Error\": []}";
         }
           

     } catch (Exception e){
          json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

     }

     return json;
}
	@RequestMapping("/view/rendicion/Frm_DeliberacionPublica")
    public String Frm_DeliberacionPublica(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		

   	 	}else {
      	     List<TblDatosInforme> verificarMatriz= datoInfo.obtenerRegistroDatosDeliberacion(verificarInforme.getInfCod());

   	 	if(verificarMatriz.size() ==0) {
      	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
    		model.addAttribute("infCod", verificarInforme.getInfCod());
   		}
   		else {
   			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
   	        model.addAttribute("acciones", listaAcciones);
   	     if (verificarInforme.getInfEstado().equals("finalizado")) {
   	    	model.addAttribute("infestado", verificarInforme.getInfEstado());
   	     }else {
   	    	model.addAttribute("infestado", "matriz");
   	     }
   			
   			model.addAttribute("infCod", verificarInforme.getInfCod());
   		}		
   	 	}
         return "rendicion/Frm_DeliberacionPublica";
    }
	@RequestMapping("/view/rendicion/Fmr_TrasparenciaInformacion")
    public String Fmr_TrasparenciaInformacion(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", "vacio");		

   	 	}else {
      	     List<TblMecanismosTranparenciaAccInf> verificarMatriz= Trasparencia.obtenerRegistroTrasparenciaInformacion(verificarInforme.getInfCod());

   	 	if(verificarMatriz.size() ==0) {
      	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
      	 	model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
    		model.addAttribute("infCod", verificarInforme.getInfCod());
   		}
   		else {
   			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
   	        model.addAttribute("acciones", listaAcciones);
   	     if (verificarInforme.getInfEstado().equals("finalizado"))
   	     {
    			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
   			}
   	     else {
   	    	model.addAttribute("infestado", "matriz");
   			}
   			model.addAttribute("infCod", verificarInforme.getInfCod());
   		}		
   	 	}
         return "rendicion/Fmr_TrasparenciaInformacion";
    }
	@RequestMapping("/view/rendicion/Fmr_MediosComunicacion")
    public String Fmr_MediosComunicacion(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", "vacio");		

   	 	}else {
      	     List<TblComunicacionGestion> verificarMatriz= medioservicio.obtenerRegistroMedios(verificarInforme.getInfCod());

   	 	if(verificarMatriz.size() ==0) {
      	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
    		model.addAttribute("infCod", verificarInforme.getInfCod());
   		}
   		else {
   			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
   			
   	        model.addAttribute("acciones", listaAcciones);
   	     if (verificarInforme.getInfEstado().equals("finalizado")) {
    	    	model.addAttribute("infestado", verificarInforme.getInfEstado());
    	     }else {
   			model.addAttribute("infestado", "matriz");}
   			model.addAttribute("infCod", verificarInforme.getInfCod());
   		}		
   	 	}
         return "rendicion/Fmr_MediosComunicacion";
    }
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarMediosComunicacion")
    public @ResponseBody String guardarMediosComunicacion(HttpServletRequest request,@RequestParam("infCod") int infCod,
    		@RequestParam("cgNombre[]") String[] cgNombre,@RequestParam("cgNumero[]") String[] cgNumero,@RequestParam("cgPorlocales[]") String[] cgPorlocales,@RequestParam("cgPornacionales[]") String[] cgPornacionales,
    		@RequestParam("cgPorinternacional[]") String[] cgPorinternacional,@RequestParam("cgMedioverif[]") String[] cgMedioverif
    		) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
        	   
 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
 			   for (int i = 0; i < cgNombre.length; i++){
 				   Integer valor=medioservicio.countmedios(infCod, cgNombre[i]);
 				   if(valor==0) {
 					  TblComunicacionGestion tbldatosMedio= new TblComunicacionGestion();
 		 			  String valorloca=cgPorlocales[i].replace(",", ".");
 		 			 String valornacional=cgPornacionales[i].replace(",", ".");
 		 			String valorinternacional=cgPorinternacional[i].replace(",", ".");
 		 			   tbldatosMedio.setCgNombre(cgNombre[i]);
 		 			   tbldatosMedio.setCgNumero(Integer.parseInt(cgNumero[i]));
 		 			  tbldatosMedio.setCgPorlocales(new BigDecimal(valorloca));
 		 			  tbldatosMedio.setCgPornacionales(new BigDecimal(valornacional));
 		 			  tbldatosMedio.setCgPorinternacional(new BigDecimal(valorinternacional));
 		 			 tbldatosMedio.setCgMedioverif(cgMedioverif[i]);
 		 			   tbldatosMedio.setInfCod(tblInforme);
 		 			  medioservicio.guardarMediosComunicacion(tbldatosMedio);
 				   }else {
 					  TblComunicacionGestion tbldatosMedio= medioservicio.obtenerRegistroMediosNombre(tblInforme,  cgNombre[i]);
 		 			  String valorloca=cgPorlocales[i].replace(",", ".");
 		 			 String valornacional=cgPornacionales[i].replace(",", ".");
 		 			String valorinternacional=cgPorinternacional[i].replace(",", ".");
 		 			   tbldatosMedio.setCgNombre(cgNombre[i]);
 		 			   tbldatosMedio.setCgNumero(Integer.parseInt(cgNumero[i]));
 		 			  tbldatosMedio.setCgPorlocales(new BigDecimal(valorloca));
 		 			  tbldatosMedio.setCgPornacionales(new BigDecimal(valornacional));
 		 			  tbldatosMedio.setCgPorinternacional(new BigDecimal(valorinternacional));
 		 			 tbldatosMedio.setCgMedioverif(cgMedioverif[i]);
 		 			   tbldatosMedio.setInfCod(tblInforme);
 		 			  medioservicio.guardarMediosComunicacion(tbldatosMedio);
 				   }
 			
 			  }
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
				 
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }
	
	@RequestMapping("/view/rendicion/Fmr_MecanismoParticipacion")
    public String Fmr_MecanismoParticipacion(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", "vacio");		

   	 	}else {
      	     List<TblMecanismoParticipacionCiudadana> verificarMatriz= Meparticipacion.obtenerRegistroMecanismosPaticipacion(verificarInforme.getInfCod());

   	 	if(verificarMatriz.size() ==0) {
      	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
    		model.addAttribute("infCod", verificarInforme.getInfCod());
    		 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
    		
   		}
   		else {
   			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
   	        model.addAttribute("acciones", listaAcciones);
   	        if (verificarInforme.getInfEstado().equals("finalizado")) {
   	        	model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			}else {
				model.addAttribute("infestado", "matriz");
			}
   			
   			model.addAttribute("infCod", verificarInforme.getInfCod());
   		 
   		}		
   	 	}
         return "rendicion/Fmr_MecanismoParticipacion";
    }
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarMecanismoParticipacion")
    public @ResponseBody String guardarMecanismoParticipacion(HttpServletRequest request,@RequestParam("infCod") int infCod,
    		@RequestParam("mecaNombre[]") String[] mecaNombre,@RequestParam("mecaImplementado[]") String[] mecaImplementado,@RequestParam("mecaNumero[]") String[] mecaNumero,@RequestParam("mecaDescLogros[]") String[] mecaDescLogros,
    		@RequestParam("mecaMedioverifica[]") String[] mecaMedioverifica,@RequestParam("mecaSec[]") String[] mecaSec
    		
    		) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
        	   
 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
 			   for (int i = 0; i < mecaNombre.length; i++){
 				   Integer valor =Meparticipacion.ContarMPC(infCod, mecaNombre[i]);
 				   if(valor==0) {
 					  TblMecanismoParticipacionCiudadana tbldatosInforme = new TblMecanismoParticipacionCiudadana();	  
 		 			    tbldatosInforme.setMecaNombre(mecaNombre[i]);
 		 			    tbldatosInforme.setMecaImplementado(mecaImplementado[i]);
 		 			    tbldatosInforme.setMecaMedioverifica(mecaMedioverifica[i] == null ? null : mecaMedioverifica[i]);
 		 			    tbldatosInforme.setMecaNumero(Integer.parseInt(mecaNumero[i]));
 		 			   tbldatosInforme.setMecaTi("MECANISMOS DE PARTICIPACION CIUDADANA");
 		 			    if(mecaSec[i]==null||mecaSec[i].equals("0")) {
 		 			    	tbldatosInforme.setMecaSec("");
 		 			    }else {
 		 			    	tbldatosInforme.setMecaSec(mecaSec[i]);
 		 			    } 			    
 		 			    tbldatosInforme.setMecaDescLogros(mecaDescLogros[i]);
 		 			    tbldatosInforme.setInfCod(tblInforme);
 		 			   Meparticipacion.guardarMecanismos(tbldatosInforme); 
 				   }else {
 					  TblMecanismoParticipacionCiudadana tbldatosInforme = Meparticipacion.obtenerRegistroMecanismosPaticipacionNombre(infCod, mecaNombre[i]);  
		 			    tbldatosInforme.setMecaNombre(mecaNombre[i]);
		 			    tbldatosInforme.setMecaImplementado(mecaImplementado[i]);
		 			    tbldatosInforme.setMecaMedioverifica(mecaMedioverifica[i] == null ? null : mecaMedioverifica[i]);
		 			    tbldatosInforme.setMecaNumero(Integer.parseInt(mecaNumero[i]));
		 			   tbldatosInforme.setMecaTi("MECANISMOS DE PARTICIPACION CIUDADANA");
		 			    if(mecaSec[i]==null||mecaSec[i].equals("0")) {
		 			    	tbldatosInforme.setMecaSec("");
		 			    }else {
		 			    	tbldatosInforme.setMecaSec(mecaSec[i]);
		 			    } 			    
		 			    tbldatosInforme.setMecaDescLogros(mecaDescLogros[i]);
		 			    tbldatosInforme.setInfCod(tblInforme);
		 			   Meparticipacion.guardarMecanismos(tbldatosInforme); 
 				   }
 				  
 			  }
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
				 
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }
	
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarDatosInforme")
    public @ResponseBody String guardarDatosInforme(HttpServletRequest request,@RequestParam("infCod") int infCod,
    		@RequestParam("inf_fecharc")  @DateTimeFormat(pattern = "dd/MM/yyyy") Date inf_fecharc,@RequestParam("inf_usuarios") String inf_usuarios,@RequestParam("inf_cholos") String inf_cholos,@RequestParam("inf_indigenas") String inf_indigenas,
    		@RequestParam("inf_hombre") String inf_hombre,@RequestParam("inf_mujeres") String inf_mujeres,@RequestParam("inf_glbti") String inf_glbti,@RequestParam("inf_montubios") String inf_montubios,
    		@RequestParam("inf_mestizos") String inf_mestizos,@RequestParam("inf_afroecuatorianos") String inf_afroecuatorianos
    		) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
        	    TblDatosInforme tbldatosInforme = new TblDatosInforme();
 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
 			    tbldatosInforme.setInfFecharc((inf_fecharc));
 			    tbldatosInforme.setInfUsuarios(Integer.parseInt((inf_usuarios == null? "0":inf_usuarios)));
 			    tbldatosInforme.setInfHombre(Integer.parseInt(inf_hombre== null? "0":inf_hombre));
 			    tbldatosInforme.setInfMujeres(Integer.parseInt(inf_mujeres== null? "0":inf_mujeres));
 			    tbldatosInforme.setInfGlbti(Integer.parseInt(inf_glbti== null? "0":inf_glbti));
 			    tbldatosInforme.setInfMontubios(Integer.parseInt(inf_montubios== null? "0":inf_montubios));
 			    tbldatosInforme.setInfCholos(Integer.parseInt(inf_cholos== null? "0":inf_cholos));
 			    tbldatosInforme.setInfIndigenas(Integer.parseInt(inf_indigenas== null? "0":inf_indigenas));
 			    tbldatosInforme.setInfMestizos(Integer.parseInt(inf_mestizos== null? "0":inf_mestizos));
 			    tbldatosInforme.setInfAfroecuatorianos(Integer.parseInt(inf_afroecuatorianos== null? "0":inf_afroecuatorianos));
 			    tbldatosInforme.setInfCod(tblInforme);
 			    datoInfo.guardarDatosInforme(tbldatosInforme);
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
				 
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarTrasparenciaInformacion")
    public @ResponseBody String guardarTrasparenciaInformacion(HttpServletRequest request,@RequestParam("infCod") int infCod,@RequestParam(value = "mecaniNombre[]") String[] mecaniNombre, 
    		@RequestParam(value = "mecaniImplementado[]") String[] mecaniImplementado,@RequestParam(value = "mecaniMedioverifica[]") String[] mecaniMedioverifica		) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
        	   
 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
 			   List<TblMecanismosTranparenciaAccInf> verificarMatriz= Trasparencia.obtenerRegistroTrasparenciaInformacion(tblInforme.getInfCod());
 			   if(verificarMatriz.size()==0) {
 			   for (int i = 0; i < mecaniNombre.length; i++){
 				   Integer valor =Trasparencia.CountMecanismosXnombreXinforme(infCod, mecaniNombre[i]);
 				   if(valor==0) {
 				  TblMecanismosTranparenciaAccInf tblMecanismosTrasparencia = new TblMecanismosTranparenciaAccInf();
 				  tblMecanismosTrasparencia.setMecaniTipo("TRANSPARENCIA Y ACCESO A LA INFORMACIÓN");
 				   tblMecanismosTrasparencia.setInfCod(tblInforme);
 				  tblMecanismosTrasparencia.setMecaniNombre(mecaniNombre[i]);
 				 tblMecanismosTrasparencia.setMecaniImplementado(mecaniImplementado[i]);
 				 tblMecanismosTrasparencia.setMecaniMedioverifica(mecaniMedioverifica[i] == null ? null : mecaniMedioverifica[i]);
 				 tblMecanismosTrasparencia.setMecaniEstado(Constantes.ESTADO);
 				  Trasparencia.guardarTrasparenciaInformacion(tblMecanismosTrasparencia);
 				   }
 				   else {
 					TblMecanismosTranparenciaAccInf tblMecanismosTrasparencia = Trasparencia.obtenerMecanismosXnombreXinforme(infCod, mecaniNombre[i]);
 	 				  tblMecanismosTrasparencia.setMecaniTipo("TRANSPARENCIA Y ACCESO A LA INFORMACIÓN");
 	 				   tblMecanismosTrasparencia.setInfCod(tblInforme);
 	 				  tblMecanismosTrasparencia.setMecaniNombre(mecaniNombre[i]);
 	 				 tblMecanismosTrasparencia.setMecaniImplementado(mecaniImplementado[i]);
 	 				 tblMecanismosTrasparencia.setMecaniMedioverifica(mecaniMedioverifica[i] == null ? null : mecaniMedioverifica[i]);
 	 				 tblMecanismosTrasparencia.setMecaniEstado(Constantes.ESTADO);
 	 				  Trasparencia.guardarTrasparenciaInformacion(tblMecanismosTrasparencia);
 				   }
 			   }    
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); }
 			   else {
 				  mensaje.put("estado", "ERROR");
					mensaje.put("mensaje", "Los datos ya se han guardado anteriormente.! "); 
 			   }
				 
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarSugerenciaCiudadana")
    public @ResponseBody String guardarSugerenciaCiudadana(HttpServletRequest request,@RequestParam("infCod") int infCod,
    		@RequestParam("secDemandas") String sec_demandas,@RequestParam("secValida") String sec_valida,@RequestParam("secMedioVerificacione") String sec_medio_verificacione) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
        	    TblSugerenciaCiudadana tbldatosSugerencia = new TblSugerenciaCiudadana();
 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
 			    tbldatosSugerencia.setSecDemandas(sec_demandas);
 			    tbldatosSugerencia.setSecValida(sec_valida);
 			    tbldatosSugerencia.setSecMedioVerificacione(sec_medio_verificacione == null ? null : sec_medio_verificacione );
 			  // tbldatosSugerencia.setSecMedioVerificacione(sec_medio_verificacione.replaceAll(System.getProperty("line.separator"), " "));
 			    tbldatosSugerencia.setInfCod(tblInforme);
 			   sugurenciaservicio.guardarSugerencia(tbldatosSugerencia);
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
				 
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarCumplimientoSugerencia")
    public @ResponseBody String guardarCumplimientoSugerencia(HttpServletRequest request,@RequestParam("infCod") int infCod,
    		@RequestParam("cscSugerencias") String cscSugerencias,@RequestParam("cscResultados") String cscResultados,@RequestParam("cscPorcAvance") String cscPorcAvance,@RequestParam("cscLink") String cscLink) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
        	    TblCumplimientoSugerenciaCiudadana tblcumplimientoSugerencia = new TblCumplimientoSugerenciaCiudadana();
 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
 			   tblcumplimientoSugerencia.setCscSugerencias(cscSugerencias);
 			   tblcumplimientoSugerencia.setCscResultados(cscResultados);
 			  tblcumplimientoSugerencia.setCscPorcAvance(new BigDecimal(cscPorcAvance));
 			  tblcumplimientoSugerencia.setCscLink(cscLink.toString() == null ? null : cscLink.toString().replaceAll(System.getProperty("line.separator"), " "));
 			 //tblcumplimientoSugerencia.setCscLink(cscLink.toString().replaceAll(System.getProperty("line.separator"), " "));
 			 tblcumplimientoSugerencia.setInfCod(tblInforme);
 			CumplimientoSugerencia.guardarCumplimientoSugerencia(tblcumplimientoSugerencia);
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
				 
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }
	 @RequestMapping(value = {"/obtenerRegistrosSugerencias"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerRegistrosSugerencias(Authentication authentication,@RequestParam("infCod") Integer infCod) {
	         String json;
	         ObjectMapper mapper = new ObjectMapper(); 
	         List<ProcesoRendicionCuentasGADDTO> lista = new ArrayList<>();
	         try{
	              List<TblSugerenciaCiudadana> listaRegistros =sugurenciaservicio.obtenerRegistroDatosSugerencia(infCod);
	               
	               
	              if (listaRegistros.size() > 0){
	                  lista= listaRegistros.stream().map(obj->ProcesoRendicionCuentasGADDTO.builder()
	                		  .secCode(obj.getSecCode())
	                		  .contador(listaRegistros.indexOf(obj)+1)
	                		  .demandas(obj.getSecDemandas().toString())
	                		  .valida(obj.getSecValida().toString())
	                		  .link(obj.getSecMedioVerificacione().toString())
	                		  .build())
	                		  .collect(Collectors.toList());
	                  
	                  json = (!lista.isEmpty())
	        					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
	        					: Constantes.MESSAGE_EMPTY_JSON;
	                  } else{
	            	  json = "{\"Error\": []}";
	              }

	         } catch (Exception e){
	              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

	         }

	         return json;
	    }
	 @RequestMapping(value = {"/obtenerRegistrosTrasparenciaAcceso"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerRegistrosTrasparenciaAcceso(Authentication authentication,@RequestParam("infCod") Integer infCod) {
	         String json;
	         ObjectMapper mapper = new ObjectMapper(); 
	         List<TransparenciaAccesoGADDTO> lista = new ArrayList<>();


	         try{
	              List<TblMecanismosTranparenciaAccInf> listaRegistros =Trasparencia.obtenerRegistroTrasparenciaInformacion(infCod);
	               
	               
	              if (listaRegistros.size() > 0){
	            	  
	            	  lista=listaRegistros.stream().map(obj->TransparenciaAccesoGADDTO.builder()
	            			  .mecaniCod(obj.getMecaniCod())
	            			  .contador(listaRegistros.indexOf(obj)+1)
	            			  .nombre(obj.getMecaniNombre().toString())
	            			  .valida(obj.getMecaniImplementado().toString())
	            			  .link(obj.getMecaniMedioverifica())
	            			  .build())
	            			  .collect(Collectors.toList());
	            	  json = (!lista.isEmpty())
	        					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
	        					: Constantes.MESSAGE_EMPTY_JSON;
	            	  } else{
	            	  json = "{\"Error\": []}";
	              }

	         } catch (Exception e){
	              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

	         }

	         return json;
	    }
	 @RequestMapping(value = {"/obtenerRegistrosCumplimientoSugerencias"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerRegistrosCumplimientoSugerencias(Authentication authentication,@RequestParam("infCod") Integer infCod) {
	         String json;
	         ObjectMapper mapper = new ObjectMapper(); 
	         List<ProcesoRendicionCuentasGADDTO> lista = new ArrayList<>();
	         try{
	              List<TblCumplimientoSugerenciaCiudadana> listaRegistros =CumplimientoSugerencia.obtenerRegistroCumplimientoSugerencia(infCod);
	               
	               
	              if (listaRegistros.size() > 0){
	            	  
	            	  lista=listaRegistros.stream().map(obj->ProcesoRendicionCuentasGADDTO.builder()
	            			  .cscCod(obj.getCscCod())
	            			  .contador(listaRegistros.indexOf(obj)+1)
	            			  .sugerencias(obj.getCscSugerencias().toString())
	            			  .resultados(obj.getCscResultados().toString())
	            			  .porcAvance(obj.getCscPorcAvance().toString().replace(".", ".").trim())
	            			  .link(obj.getCscLink().toString())
	            			  .build())
	            			  .collect(Collectors.toList());
	            	  
	            	  json = (!lista.isEmpty())
	        					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
	        					: Constantes.MESSAGE_EMPTY_JSON;} else{
	            	  json = "{\"data\": []}";
	              }

	         } catch (Exception e){
	              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

	         }

	         return json;
	    }
	 @RequestMapping(value = {"/obtenerRegistrosMecanismoParticipacion"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerRegistrosMecanismoParticipacion(Authentication authentication,@RequestParam("infCod") Integer infCod) {
	         String json;
	         ObjectMapper mapper = new ObjectMapper(); 
			 List<MecanismosGADDTO> lista = new ArrayList<>();
	         try{
	              List<TblMecanismoParticipacionCiudadana> listaRegistros =Meparticipacion.obtenerRegistroMecanismosPaticipacion(infCod);

	              if (listaRegistros.size() > 0){
	            	  lista = listaRegistros.stream()
	        					.map(obj -> MecanismosGADDTO.builder()
	        					.mecaCod(obj.getMecaCod())
	        					.contador(listaRegistros.indexOf(obj)+1)
	        					.nombre(obj.getMecaNombre().toString())
	        					.numero(obj.getMecaNumero())
	        					.implementado(obj.getMecaImplementado().toString())
	        					.actores(obj.getMecaSec().toString())
	        					.logros(obj.getMecaDescLogros().toString())
	        					.link(obj.getMecaMedioverifica().toString())
	        					.build())
	        					.collect(Collectors.toList());
	        			json = (!lista.isEmpty())
	        					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
	        					: Constantes.MESSAGE_EMPTY_JSON;
	                } else{
	            	  json = "{\"Error\": []}";
	              }

	         } catch (Exception e){
	              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

	         }

	         return json;
	    }
	 @RequestMapping(value = {"/obtenerRegistrosMediosComunicacion"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerRegistrosMediosComunicacion(Authentication authentication,@RequestParam("infCod") Integer infCod) {
	         String json;
	         ObjectMapper mapper = new ObjectMapper(); 
	         List<DifusionComunicacionGADDTO> lista = new ArrayList<>();

	         try{
	              List<TblComunicacionGestion> listaRegistros =medioservicio.obtenerRegistroMedios(infCod);
	               
	               
	              if (listaRegistros.size() > 0){
	            	  
	            	  lista=listaRegistros.stream().map(obj->DifusionComunicacionGADDTO.builder()
	            			  .cgCod(obj.getCgCod())
	            			  .contador(listaRegistros.indexOf(obj)+1)
	            			  .nombre(obj.getCgNombre().toString())
	            			  .numero(obj.getCgNumero())
	            			  .porclocal(obj.getCgPorlocales().toString().replace(".", ".").trim())
	            			  .porcnacional(obj.getCgPornacionales().toString().replace(".", ".").trim())
	            			  .porcinternacional(obj.getCgPorinternacional().toString().replace(".", ".").trim())
	            			  .Link(obj.getCgMedioverif())
	            			  .build())
	            			  .collect(Collectors.toList());
	            	  json = (!lista.isEmpty())
	        					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
	        					: Constantes.MESSAGE_EMPTY_JSON;} 
	              else{
	            	  json = "{\"Error\": []}";
	              }

	         } catch (Exception e){
	              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

	         }

	         return json;
	    }
	 @RequestMapping(value = {"/obtenerRegistrosDetalleMediosComunicacion"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerRegistrosDetalleMediosComunicacion(Authentication authentication,@RequestParam("codigo") Integer codigo) {
		 String json;
         ObjectMapper mapper = new ObjectMapper(); 
		List<TblDetalleComunicagestionDTO> lista = new ArrayList<>();
         try{
              List<TblDetalleComunicagestion> listaRegistros =mediocomunicacionservicio.obtenerRegistroMedios(codigo);
              DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		  		simbolo.setDecimalSeparator('.');
	          	simbolo.setGroupingSeparator(',');
	          	DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
	               
              if (listaRegistros.size() > 0){
            	  lista = listaRegistros.stream()
        					.map(obj -> TblDetalleComunicagestionDTO.builder()
        						.cgCod2(obj.getCgCod2())
        						.contador(listaRegistros.indexOf(obj)+1)
        						.radios(obj.getDcNombre())     
        						.minutos(obj.getDcMinutos())
        						.valor(formateador.format (obj.getDcMonto()))
        						.build())
    	        			.collect(Collectors.toList());
        			json = (!lista.isEmpty())
        					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
        					: Constantes.MESSAGE_EMPTY_JSON;
		         } else{
	            	  json = "{\"data\": []}";
	              }

	         } catch (Exception e){
	              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

	         }
            
	         return json;
	    }
	 @RequestMapping(value = {"/obtenerRegistrosDatosInforme"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerRegistrosDatosInforme(Authentication authentication,@RequestParam("infCod") Integer infCod) {
	         String json;
	         ObjectMapper mapper = new ObjectMapper(); 
			List<ProcesoRendicionCuentasGADDTO> lista = new ArrayList<>();
	         try{
	              List<TblDatosInforme> listaRegistros =datoInfo.obtenerRegistroDatosDeliberacion(infCod);
	               
	               
	              if (listaRegistros.size() > 0){
	            	  SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	            	  lista = listaRegistros.stream()
	        					.map(obj -> ProcesoRendicionCuentasGADDTO.builder()
	        					.idDatos(obj.getIdDatos())
	        					.contador(listaRegistros.indexOf(obj)+1)
	        					.fecha(df.format(obj.getInfFecharc()).toString())
	        					.usuarios(obj.getInfUsuarios())
	        					.hombre(obj.getInfHombre())
	        					.glbti(obj.getInfGlbti())
	        					.montubios(obj.getInfMontubios())
	        					.mestizos(obj.getInfMestizos())
	        					.cholos(obj.getInfCholos())
	        					.indigenas(obj.getInfIndigenas())
	        					.afroecuatorianos(obj.getInfAfroecuatorianos())
	        					.mujer(obj.getInfMujeres())
	        					.build())
	        					
	        					.collect(Collectors.toList());
	        			json = (!lista.isEmpty())
	        					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
	        					: Constantes.MESSAGE_EMPTY_JSON;
	             } else{
	            	  json = "{\"data\": []}";
	              }

	         } catch (Exception e){
	              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

	         }

	         return json;
	    }

	 @RequestMapping("/view/rendicion/Frm_CoberturaNacional")
	    public String Frm_CoberturaNacional(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
			model.addAttribute("email", authentication.getName());
			
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
	   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
	   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
	   	 	}else {
	   	 
	   		//List<TblCoberturaNacional> verificarMatrizCoberturaNacional= CoberturaNacionalService.obtenerRegistroCoberturaNacional(verificarInforme.getInfCod());    
	 
	   		TblInstitucion	tblInstitucion=gcs.ObtenerInstitucionesXidEstado(verificarInforme.getInstCod(), Constantes.ESTADO, Constantes.periodo());
	            String instTipDes="";
	           switch (tblInstitucion.getInstTfCod().getTfCod()) {
							case 1:
								instTipDes="GAD";
							break;
						    default:
						    	instTipDes="UDAF";
							break;
							}
	           
	           
	           
			List<TblCoberturaNacional> verificarMatrizCoberturaNacional = CoberturaNacionalService.obtenerRegistroCoberturaNacionalXInfCodAndTipo(verificarInforme.getInfCod(),instTipDes);
	   		if(verificarMatrizCoberturaNacional.size() ==0) {
	   	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
	 		model.addAttribute("infCod", verificarInforme.getInfCod()); 		
	 		model.addAttribute("inst_tip_des", tblInstitucion.getInstTipDes());
	 		model.addAttribute("Tipo_Formulario", tblInstitucion.getInstTfCod().getTfCod());
			}
			else {
				List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
		        model.addAttribute("acciones", listaAcciones);
				model.addAttribute("infestado", "matriz");
				 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				model.addAttribute("infCod", verificarInforme.getInfCod());
				model.addAttribute("inst_tip_des", tblInstitucion.getInstTipDes());
				model.addAttribute("Tipo_Formulario", tblInstitucion.getInstTfCod().getTfCod());
			}		
			}
	         return "rendicion/Frm_CoberturaNacional";
	    }
	

	
	
	@RequestMapping("/view/rendicion/Frm_CoberturaTerritorial")
    public String Frm_CoberturaTerritorial(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   			List<TblCoberturaInstitucional> verificarMatrizCoberturaTerritorial = CoberturaTerritorialService.obtenerRegistroCoberturaTerritorial(verificarInforme.getInfCod());

   	 	if(verificarMatrizCoberturaTerritorial.size() ==0) {
   	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
 		model.addAttribute("infCod", verificarInforme.getInfCod());
		}
		else {
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
	        model.addAttribute("acciones", listaAcciones);
			model.addAttribute("infestado", "matriz");
			 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());

			model.addAttribute("infCod", verificarInforme.getInfCod());
		}		
		}
         return "rendicion/Frm_CoberturaTerritorial";
    }
	
	
	@RequestMapping(value = "view/rendicion/Frm_CoberturaTerritorialNuevo",method = RequestMethod.POST)
    public String Frm_CoberturaTerritorialNuevo(Model model, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   			
   	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
 		model.addAttribute("infCod", verificarInforme.getInfCod());
			
		}
         return "rendicion/Frm_CoberturaTerritorial";
    }
	
	@RequestMapping("/view/rendicion/Frm_GAD_ObjetivoPlanDesarrollo")
    public String Frm_GAD_ObjetivoPlanDesarrollo(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   			List<TblObjetivosPlanDesarrollo> verificarMatrizObjetivosPlan = infor.OntenerRegistrosObjetivosXcod(verificarInforme);

   	 	if(verificarMatrizObjetivosPlan.isEmpty()) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("infCod", verificarInforme.getInfCod());
		}
		else {
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
	        model.addAttribute("acciones", listaAcciones);
			model.addAttribute("inf_estado", "matriz");
			model.addAttribute("infCod", verificarInforme.getInfCod());
			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			List<Object[]> listaAvances = infor.obtenerRegistroAvances(verificarInforme);	
			if(listaAvances.size()==0) {
				model.addAttribute("avancesObjetivo", "vacio");
			}else {
				
				model.addAttribute("avancesObjetivo", listaAvances);
			}
			
		}		
		}
		
         return "rendicion/Frm_GAD_ObjetivoPlanDesarrollo";
    }
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarObjetivosPlan")
	public @ResponseBody String guardarObjetivosPlan(HttpServletRequest request,  @RequestParam(value = "infCod") Integer infCod
			,  @RequestParam(value = "objNombre") String objNombre
						) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			
			 
			TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				if (objNombre != null ) {
					TblObjetivosPlanDesarrollo tblObjetivosPlanDesarrollo = new TblObjetivosPlanDesarrollo();
					tblObjetivosPlanDesarrollo.setInfCod(tblInforme);
					tblObjetivosPlanDesarrollo.setObjNombre(objNombre.toUpperCase());
					tblObjetivosPlanDesarrollo.setObjEstado(Constantes.ESTADO);
					tblObjetivosPlanDesarrollo.setObjTipo("PLAN DE DESARROLLO");
					infor.guardarPlanDesarrollo(tblObjetivosPlanDesarrollo);
				}
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	
	@RequestMapping(value = "view/rendicion/Frm_GAD_ObjetivoPlanDesarrolloNuevo",method = RequestMethod.POST)
    public String Frm_GAD_ObjetivoPlanDesarrolloNuevo(Model model, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   			List<TblObjetivosPlanDesarrollo> verificarMatrizObjetivosPlan = infor.OntenerRegistrosObjetivosXcod(verificarInforme);

   	 	if(verificarMatrizObjetivosPlan.size() ==0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("infCod", verificarInforme.getInfCod());
		}
		else {
			model.addAttribute("inf_estado", "activo");
			model.addAttribute("infCod", verificarInforme.getInfCod());
			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
		}		
		}
         return "rendicion/Frm_GAD_ObjetivoPlanDesarrolloNuevo";
    }
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "view/rendicion/guardarObjetivosPlanBK")
	public @ResponseBody String guardarObjetivosPlanBK(HttpServletRequest request,  @RequestParam(value = "infCod") Integer infCod,
			@RequestParam(value = "cbox1", required = false) String cbox1,
			@RequestParam(value = "cbox2", required = false) String cbox2,
			@RequestParam(value = "cbox3", required = false) String cbox3,
			@RequestParam(value = "cbox4", required = false) String cbox4,
			@RequestParam(value = "cbox5", required = false) String cbox5,
			@RequestParam(value = "cbox6", required = false) String cbox6,
			@RequestParam(value = "cbox7", required = false) String cbox7,
			@RequestParam(value = "cbox8", required = false) String cbox8,
			@RequestParam(value = "cbox9", required = false) String cbox9
			) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			
			 
			TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
			List<TblObjetivosPlanDesarrollo> listaObjetivosPlan = new ArrayList<TblObjetivosPlanDesarrollo>();
				if (cbox1 != null ) {
					TblObjetivosPlanDesarrollo tblObjetivosPlanDesarrollo = new TblObjetivosPlanDesarrollo();
					tblObjetivosPlanDesarrollo.setInfCod(tblInforme);
					tblObjetivosPlanDesarrollo.setObjNombre(cbox1);
					tblObjetivosPlanDesarrollo.setObjEstado(Constantes.ESTADO);
					tblObjetivosPlanDesarrollo.setObjTipo("PLAN DE DESARROLLO 2017-2021");
					listaObjetivosPlan.add(tblObjetivosPlanDesarrollo);
				}
				if (cbox2 != null ) {
					TblObjetivosPlanDesarrollo tblObjetivosPlanDesarrollo = new TblObjetivosPlanDesarrollo();
					tblObjetivosPlanDesarrollo.setInfCod(tblInforme);
					tblObjetivosPlanDesarrollo.setObjNombre(cbox2);
					tblObjetivosPlanDesarrollo.setObjEstado(Constantes.ESTADO);
					tblObjetivosPlanDesarrollo.setObjTipo("PLAN DE DESARROLLO 2017-2021");
					listaObjetivosPlan.add(tblObjetivosPlanDesarrollo);
				}
				if (cbox3 != null) {
					TblObjetivosPlanDesarrollo tblObjetivosPlanDesarrollo = new TblObjetivosPlanDesarrollo();
					tblObjetivosPlanDesarrollo.setInfCod(tblInforme);
					tblObjetivosPlanDesarrollo.setObjNombre(cbox3);
					tblObjetivosPlanDesarrollo.setObjEstado(Constantes.ESTADO);
					tblObjetivosPlanDesarrollo.setObjTipo("PLAN DE DESARROLLO 2017-2021");
					listaObjetivosPlan.add(tblObjetivosPlanDesarrollo);
				}
				if (cbox4 != null) {
					TblObjetivosPlanDesarrollo tblObjetivosPlanDesarrollo = new TblObjetivosPlanDesarrollo();
					tblObjetivosPlanDesarrollo.setInfCod(tblInforme);
					tblObjetivosPlanDesarrollo.setObjNombre(cbox4);
					tblObjetivosPlanDesarrollo.setObjEstado(Constantes.ESTADO);
					tblObjetivosPlanDesarrollo.setObjTipo("PLAN DE DESARROLLO 2017-2021");
					listaObjetivosPlan.add(tblObjetivosPlanDesarrollo);
				}
				if (cbox5 != null) {
					TblObjetivosPlanDesarrollo tblObjetivosPlanDesarrollo = new TblObjetivosPlanDesarrollo();
					tblObjetivosPlanDesarrollo.setInfCod(tblInforme);
					tblObjetivosPlanDesarrollo.setObjNombre(cbox5);
					tblObjetivosPlanDesarrollo.setObjEstado(Constantes.ESTADO);
					tblObjetivosPlanDesarrollo.setObjTipo("PLAN DE DESARROLLO 2017-2021");
					listaObjetivosPlan.add(tblObjetivosPlanDesarrollo);
				}
				if (cbox6 != null) {
					TblObjetivosPlanDesarrollo tblObjetivosPlanDesarrollo = new TblObjetivosPlanDesarrollo();
					tblObjetivosPlanDesarrollo.setInfCod(tblInforme);
					tblObjetivosPlanDesarrollo.setObjNombre(cbox6);
					tblObjetivosPlanDesarrollo.setObjEstado(Constantes.ESTADO);
					tblObjetivosPlanDesarrollo.setObjTipo("PLAN DE DESARROLLO 2017-2021");
					listaObjetivosPlan.add(tblObjetivosPlanDesarrollo);
				}
				if (cbox7 != null) {
					TblObjetivosPlanDesarrollo tblObjetivosPlanDesarrollo = new TblObjetivosPlanDesarrollo();
					tblObjetivosPlanDesarrollo.setInfCod(tblInforme);
					tblObjetivosPlanDesarrollo.setObjNombre(cbox7);
					tblObjetivosPlanDesarrollo.setObjEstado(Constantes.ESTADO);
					tblObjetivosPlanDesarrollo.setObjTipo("PLAN DE DESARROLLO 2017-2021");
					listaObjetivosPlan.add(tblObjetivosPlanDesarrollo);
				}
				if (cbox8 != null) {
					TblObjetivosPlanDesarrollo tblObjetivosPlanDesarrollo = new TblObjetivosPlanDesarrollo();
					tblObjetivosPlanDesarrollo.setInfCod(tblInforme);
					tblObjetivosPlanDesarrollo.setObjNombre(cbox8);
					tblObjetivosPlanDesarrollo.setObjEstado(Constantes.ESTADO);
					tblObjetivosPlanDesarrollo.setObjTipo("PLAN DE DESARROLLO 2017-2021");
					listaObjetivosPlan.add(tblObjetivosPlanDesarrollo);
				}
				if (cbox9 != null) {
					TblObjetivosPlanDesarrollo tblObjetivosPlanDesarrollo = new TblObjetivosPlanDesarrollo();
					tblObjetivosPlanDesarrollo.setInfCod(tblInforme);
					tblObjetivosPlanDesarrollo.setObjNombre(cbox9);
					tblObjetivosPlanDesarrollo.setObjEstado(Constantes.ESTADO);
					tblObjetivosPlanDesarrollo.setObjTipo("PLAN DE DESARROLLO 2017-2021");
					listaObjetivosPlan.add(tblObjetivosPlanDesarrollo);
				}
				

	
			for (TblObjetivosPlanDesarrollo item : listaObjetivosPlan) {
				TblObjetivosPlanDesarrollo tblObjetivosPlanDesarrollo = new TblObjetivosPlanDesarrollo();
				tblObjetivosPlanDesarrollo.setInfCod(item.getInfCod());
				tblObjetivosPlanDesarrollo.setObjNombre(item.getObjNombre());
				tblObjetivosPlanDesarrollo.setObjEstado(item.getObjEstado());
				tblObjetivosPlanDesarrollo.setObjTipo(item.getObjTipo());
				
				 infor.guardarPlanDesarrollo(tblObjetivosPlanDesarrollo);  
			}

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	
	@RequestMapping(value = "view/rendicion/Frm_GAD_ObjetivoPlanDesarrolloNuevoBK",method = RequestMethod.POST)
    public String Frm_GAD_ObjetivoPlanDesarrolloNuevoBK(Model model, Authentication authentication) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   			List<TblObjetivosPlanDesarrollo> verificarMatrizObjetivosPlan = infor.OntenerRegistrosObjetivosXcod(verificarInforme);

   	 	if(verificarMatrizObjetivosPlan.size() ==0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("infCod", verificarInforme.getInfCod());
		}
		else {
			model.addAttribute("inf_estado", "activo");
			model.addAttribute("infCod", verificarInforme.getInfCod());
			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
		}		
		}
         return "rendicion/Frm_GAD_ObjetivoPlanDesarrolloNuevo";
    }
	
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "view/rendicion/Frm_GAD_EjecucionProgramaticaNuevo",method = RequestMethod.POST)
	public String Frm_GAD_EjecucionProgramaticaNuevo(Model model, Authentication authentication ) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
		List<TblObjetivosPlanDesarrollo> verificarMatrizObjetivosPlan = infor.OntenerRegistrosObjetivosXcod(verificarInforme);
		model.addAttribute("listadoObjetivosPlan", verificarMatrizObjetivosPlan);
		 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if(datosInstitucion.getInstTfCod().getTfCod()==4&& datosInstitucion.getInstFunCod().getFunCod()==12) {
			String tipo = "OBJETIVOS ESTRATÉGICOS";
	   			List<TblFuncionesObjetivos> verificarFuncionesObjetivos = is.obtenerRegistroInformeInstitucionFuncionesObjetivosxTipo(datosUsuario.getCodigoIntitucionAutorida(), tipo);
	   			model.addAttribute("listadoFuncionesObjetivosEstategicos", verificarFuncionesObjetivos);
	   		    String tipof = "FUNCIONES";
	   			List<TblFuncionesObjetivos> verificarFuncionesObjetivosFunciones = is.obtenerRegistroInformeInstitucionFuncionesObjetivosxTipo(datosUsuario.getCodigoIntitucionAutorida(), tipof);
   			model.addAttribute("listadoFuncionesObjetivosFunciones", verificarFuncionesObjetivosFunciones);
   		 String tipofin = "FINES";
   			List<TblFuncionesObjetivos> verificarFuncionesObjetivosFines = is.obtenerRegistroInformeInstitucionFuncionesObjetivosxTipo(datosUsuario.getCodigoIntitucionAutorida(), tipofin);
   			model.addAttribute("listadoFuncionesObjetivosFines", verificarFuncionesObjetivosFines);
	   		    model.addAttribute("TipoFormulario", "Vinculadas");
			List<TblEjecucionProgramatica> registrosTotalEP = infor.obtenerTotalesEjecucionProgramatica(verificarInforme.getInfCod());

			
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	
				model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   	 	if(registrosTotalEP.size() ==0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("infCod", verificarInforme.getInfCod());
		}
		else {
			model.addAttribute("inf_estado", "activo");
			model.addAttribute("infCod", verificarInforme.getInfCod());
			model.addAttribute("registrosTotalEP", registrosTotalEP);
			
		}		
		}
		}
		else {
			 model.addAttribute("TipoFormulario", "Gad");
		String tipoCE = "COMPETENCIAS EXCLUSIVAS";
		List<TblFuncionesObjetivos> verificarFuncionesObjetivos = is.obtenerRegistroInformeInstitucionFuncionesObjetivosxTipo(datosUsuario.getCodigoIntitucionAutorida(), tipoCE);
		model.addAttribute("listadoFuncionesObjetivos", verificarFuncionesObjetivos);
		
		String tipoCC = "COMPETENCIAS / FUNCIONES";
			List<TblFuncionesObjetivos> verificarCompetenciasConcurrentes = is.obtenerRegistroInformeInstitucionFuncionesObjetivosxTipo(datosUsuario.getCodigoIntitucionAutorida(), tipoCC);
			model.addAttribute("listadoCompetenciasConcurrentes", verificarCompetenciasConcurrentes);
			
		
		List<TblEjecucionProgramatica> registrosTotalEP = infor.obtenerTotalesEjecucionProgramatica(verificarInforme.getInfCod());

		
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	
				model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   	 	if(registrosTotalEP.size() ==0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("infCod", verificarInforme.getInfCod());
		}
		else {
			model.addAttribute("inf_estado", "activo");
			model.addAttribute("infCod", verificarInforme.getInfCod());
			model.addAttribute("registrosTotalEP", registrosTotalEP);
			
		}		
		}
			}
			
         return "rendicion/Frm_GAD_EjecucionProgramaticaNuevo";
    }
	
	@SuppressWarnings("unused")
	@RequestMapping("/view/rendicion/Frm_GAD_EjecucionProgramatica")
    public String Frm_GAD_EjecucionProgramatica(Model model, @RequestParam("opcion") int idMenu, Authentication authentication ) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());

   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   	 		if(datosInstitucion.getInstTfCod().getTfCod()==4&& datosInstitucion.getInstFunCod().getFunCod()==12){
   	   			List<TblObjetivosPlanDesarrollo> verificarMatrizObjetivosPlan = infor.OntenerRegistrosObjetivosXcod(verificarInforme);
   	   			model.addAttribute("listadoObjetivosPlan", verificarMatrizObjetivosPlan);
   	   			String tipo = "OBJETIVOS ESTRATÉGICOS";
   	   			List<TblFuncionesObjetivos> verificarFuncionesObjetivos = is.obtenerRegistroInformeInstitucionFuncionesObjetivosxTipo(datosUsuario.getCodigoIntitucionAutorida(), tipo);
   	   			model.addAttribute("listadoFuncionesObjetivosEstategicos", verificarFuncionesObjetivos);
   	   		    String tipof = "FUNCIONES";
   	   			List<TblFuncionesObjetivos> verificarFuncionesObjetivosFunciones = is.obtenerRegistroInformeInstitucionFuncionesObjetivosxTipo(datosUsuario.getCodigoIntitucionAutorida(), tipof);
	   			model.addAttribute("listadoFuncionesObjetivosFunciones", verificarFuncionesObjetivosFunciones);
	   		 String tipofin = "FINES";
	   			List<TblFuncionesObjetivos> verificarFuncionesObjetivosFines = is.obtenerRegistroInformeInstitucionFuncionesObjetivosxTipo(datosUsuario.getCodigoIntitucionAutorida(), tipofin);
	   			model.addAttribute("listadoFuncionesObjetivosFines", verificarFuncionesObjetivosFines);
   	   		    model.addAttribute("TipoFormulario", "Vinculadas");
   	   			List<TblEjecucionProgramatica> registrosTotalEP = infor.obtenerTotalesEjecucionProgramatica(verificarInforme.getInfCod());	
	                if(registrosTotalEP.size() ==0) {
   				
   				           if (verificarMatrizObjetivosPlan.isEmpty() ) {
   	   				      model.addAttribute("inf_estado", "sinObjetivo");
   	   				      model.addAttribute("infCod", verificarInforme.getInfCod());

   	   			          }else {
   				         model.addAttribute("inf_estado", verificarInforme.getInfEstado());
   				            model.addAttribute("infCod", verificarInforme.getInfCod());

   	   			         }
		               }
		               else {
		                       	List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
	                         model.addAttribute("acciones", listaAcciones);
			            model.addAttribute("inf_estado", "matriz");
			            model.addAttribute("infCod", verificarInforme.getInfCod());
			           model.addAttribute("registrosTotalEP", registrosTotalEP);
			             model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			
		                  }
   	 		
   	 		}else {
   	 		 model.addAttribute("TipoFormulario", "Gad");
   			List<TblObjetivosPlanDesarrollo> verificarMatrizObjetivosPlan = infor.OntenerRegistrosObjetivosXcod(verificarInforme);
   			model.addAttribute("listadoObjetivosPlan", verificarMatrizObjetivosPlan);
   			String tipo = "COMPETENCIAS EXCLUSIVAS";
   			List<TblFuncionesObjetivos> verificarFuncionesObjetivos = is.obtenerRegistroInformeInstitucionFuncionesObjetivosxTipo(datosUsuario.getCodigoIntitucionAutorida(), tipo);
   			model.addAttribute("listadoFuncionesObjetivos", verificarFuncionesObjetivos);
   			List<TblEjecucionProgramatica> registrosTotalEP = infor.obtenerTotalesEjecucionProgramatica(verificarInforme.getInfCod());	
   			
   			
   			String tipoCC = "COMPETENCIAS / FUNCIONES";
   			List<TblFuncionesObjetivos> verificarCompetenciasConcurrentes = is.obtenerRegistroInformeInstitucionFuncionesObjetivosxTipo(datosUsuario.getCodigoIntitucionAutorida(), tipoCC);
   			model.addAttribute("listadoCompetenciasConcurrentes", verificarCompetenciasConcurrentes);
   			
   			if(registrosTotalEP.size() ==0) {
   				
   				if (verificarMatrizObjetivosPlan.isEmpty() ) {
   	   				model.addAttribute("inf_estado", "sinObjetivo");
   	   				model.addAttribute("infCod", verificarInforme.getInfCod());

   	   			}else {
   				model.addAttribute("inf_estado", verificarInforme.getInfEstado());
   				model.addAttribute("infCod", verificarInforme.getInfCod());

   	   			}
		}
		else {
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
	        model.addAttribute("acciones", listaAcciones);
			model.addAttribute("inf_estado", "matriz");
			model.addAttribute("infCod", verificarInforme.getInfCod());
			model.addAttribute("registrosTotalEP", registrosTotalEP);
			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			
		}		
		}
   	 		}
         return "rendicion/Frm_GAD_EjecucionProgramatica";
    }
	
	@RequestMapping("/view/rendicion/Frm_GAD_PlandeDesarrollo")
    public String Frm_GAD_PlandeDesarrollo(Model model, @RequestParam("opcion") int idMenu, Authentication authentication ) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
		
		
		if (verificarInforme ==null){
   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   	 		
   	 	List<TblObjetivosPlanDesarrollo> verificarMatrizObjetivosPlan = infor.OntenerRegistrosObjetivosXcod(verificarInforme);
		model.addAttribute("listadoObjetivosPlan", verificarMatrizObjetivosPlan);
		String tipo = "COMPETENCIAS EXCLUSIVAS";
		List<TblFuncionesObjetivos> verificarFuncionesObjetivos = is.obtenerRegistroInformeInstitucionFuncionesObjetivosxTipo(datosUsuario.getCodigoIntitucionAutorida(), tipo);
		model.addAttribute("listadoFuncionesObjetivos", verificarFuncionesObjetivos);
		List<TblEjecucionProgramatica> registrosTotalEP = infor.obtenerTotalesEjecucionProgramatica(verificarInforme.getInfCod());
		List<Object[]> listaAvances = infor.obtenerRegistroAvances(verificarInforme);		

   	 		
   	 	if(listaAvances.size() ==0) {
   	 	
   	 	if (verificarMatrizObjetivosPlan.isEmpty() ) {
  				model.addAttribute("inf_estado", "sinObjetivo");
  				model.addAttribute("infCod", verificarInforme.getInfCod());

  			}else {
   	 		
   	 		model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("infCod", verificarInforme.getInfCod());
  			}
		}
		else {
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
	        model.addAttribute("acciones", listaAcciones);
			model.addAttribute("inf_estado", "matriz");
			model.addAttribute("infCod", verificarInforme.getInfCod());
			model.addAttribute("registrosTotalEP", registrosTotalEP);
			model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			
			
			
		}		
		}
         return "rendicion/Frm_GAD_PlandeDesarrollo";
    }
	
	
	@RequestMapping(value = "view/rendicion/Frm_GAD_PlandeDesarrolloNuevo",method = RequestMethod.POST)
	public String Frm_GAD_PlandeDesarrolloNuevo(Model model, Authentication authentication ) {	
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
		List<TblObjetivosPlanDesarrollo> verificarMatrizObjetivosPlan = infor.OntenerRegistrosObjetivosXcod(verificarInforme);
		model.addAttribute("listadoObjetivosPlan", verificarMatrizObjetivosPlan);
		String tipo = "COMPETENCIAS EXCLUSIVAS";
		List<TblFuncionesObjetivos> verificarFuncionesObjetivos = is.obtenerRegistroInformeInstitucionFuncionesObjetivosxTipo(datosUsuario.getCodigoIntitucionAutorida(), tipo);
		model.addAttribute("listadoFuncionesObjetivos", verificarFuncionesObjetivos);
		List<TblEjecucionProgramatica> registrosTotalEP = infor.obtenerTotalesEjecucionProgramatica(verificarInforme.getInfCod());
		List<Object[]> listaAvances = infor.obtenerRegistroAvances(verificarInforme);		

		
		if (listaAvances==null){
   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   	 	if(listaAvances.size() ==0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("infCod", verificarInforme.getInfCod());
		}
		else {
			model.addAttribute("inf_estado", verificarInforme.getInfEstado());
			model.addAttribute("infCod", verificarInforme.getInfCod());
			model.addAttribute("registrosTotalEP", registrosTotalEP);
		}		
		}
         return "rendicion/Frm_GAD_PlandeDesarrolloNuevo";
    }
	
	    @SuppressWarnings("finally")
	    @RequestMapping(value = "/view/rendicion/guardarCobertura")
	    public @ResponseBody String guardarCobertura(HttpServletRequest request,@RequestParam("infCod") int infCod,
	    		@RequestParam("cnCobertura") String cnCobertura,
	    		@RequestParam("cnUnidades") int cnUnidades,
	    		@RequestParam("tipo") String tipo) {
	         JSONObject mensaje = new JSONObject();
	         mensaje.put("estado", "error");
	         mensaje.put("mensaje", "Ha ocurrido un error!");	        
	         try{
	        	 
	        	    TblCoberturaNacional tblCoberturaNacional = new TblCoberturaNacional();
	 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
	        	    tblCoberturaNacional.setCnCobertura(cnCobertura);
	        		tblCoberturaNacional.setCnUnidades(cnUnidades);
	        		tblCoberturaNacional.setCnTipo(tipo);
	        		tblCoberturaNacional.setCnestado(Constantes.ESTADO);
	        		tblCoberturaNacional.setInfCod(tblInforme);
	        		CoberturaNacionalService.guardarCoberturaNacional(tblCoberturaNacional);
					mensaje.put("estado", "exito");
					mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
			
					 
	         } catch (Exception e){
	              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
	         } finally{
	              return mensaje.toString();
	         }
	    }
		
	    @SuppressWarnings("finally")
	    @RequestMapping(value = "/view/rendicion/guardarCoberturaInstitucional")
	    public @ResponseBody String guardarCoberturaInstitucional(HttpServletRequest request,@RequestParam("infCod") int infCod,
	    		@RequestParam("ciNombre") String ciNombre,
	    		@RequestParam("ciDetalle") String ciDetalle
	    		) {
	         JSONObject mensaje = new JSONObject();
	         mensaje.put("estado", "error");
	         mensaje.put("mensaje", "Ha ocurrido un error!");	        
	         try{
	        	 
	        	   TblCoberturaInstitucional tblCoberturaInstitucional = new TblCoberturaInstitucional();
	 			   TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());

	 			   tblCoberturaInstitucional.setCiNombre(ciNombre.toUpperCase());
	 			   tblCoberturaInstitucional.setCiDetalle(ciDetalle.toUpperCase());
	 			   tblCoberturaInstitucional.setCiestado(Constantes.ESTADO);
	 			   tblCoberturaInstitucional.setInfCod(tblInforme);
	 			tblCoberturaInstitucional.setInstCod(tblInforme.getInstCod());
				CoberturaTerritorialService.guardarCoberturaNacional(tblCoberturaInstitucional);
	        		mensaje.put("estado", "exito");
					mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
					 
					 
	         } catch (Exception e){
	              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
	         } finally{
	              return mensaje.toString();
	         }
	    }
	
	
	 @SuppressWarnings("finally")
	    @RequestMapping(value = "/view/rendicion/guardarPlantrabajo")
	    public @ResponseBody String guardarPlantrabajo(HttpServletRequest request,@RequestParam("infCod") int infCod,@RequestParam("ptgObjetivo") String ptgObjetivo,@RequestParam("ptgDescPrograma") String ptgDescPrograma,@RequestParam("ptgPorcAvance") String ptgPorcAvance,@RequestParam("ptgDescResultados") String ptgDescResultados) {
	         JSONObject mensaje = new JSONObject();
	         mensaje.put("estado", "error");
	         mensaje.put("mensaje", "Ha ocurrido un error!");	        
	         try{
	        	 TblPlanTrabajoGad TblplanTrabajoGad = new TblPlanTrabajoGad();
	        	 TblInforme informecod=new TblInforme();
	        	 informecod.setInfCod(infCod);
	        	 TblplanTrabajoGad.setPtgObjetivo(ptgObjetivo == null ? null : ptgObjetivo);
	        	 TblplanTrabajoGad.setPtgDescPrograma(ptgDescPrograma == null ? null : ptgDescPrograma);
	        	 TblplanTrabajoGad.setPtgDescResultados(ptgDescResultados == null ? null : ptgDescResultados);
	        	 
	        	// TblplanTrabajoGad.setPtgObjetivo(ptgObjetivo.replaceAll(System.getProperty("line.separator"), " "));
	        //	 TblplanTrabajoGad.setPtgDescPrograma(ptgDescPrograma.replaceAll(System.getProperty("line.separator"), " "));
	        //	 TblplanTrabajoGad.setPtgDescResultados(ptgDescResultados.replaceAll(System.getProperty("line.separator"), " "));
	        	 TblplanTrabajoGad.setPtgPorcAvance(new BigDecimal(ptgPorcAvance.replace(",", ".").trim()));
	        	 TblplanTrabajoGad.setInfCod(informecod);
	        	       PlanServicio.guardarPlanTrabajo(TblplanTrabajoGad);
	            	   mensaje.put("estado", "exito");
	                   mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
	             
	         } catch (Exception e){
	              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
	         } finally{
	              return mensaje.toString();
	         }
	    }
	
	 @RequestMapping(value = {"/obtenerRegistrosPlan"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerRegistrosPlan(Authentication authentication,@RequestParam("infCod") Integer infCod) {
	         String json;
	         ObjectMapper mapper = new ObjectMapper(); 
	    	 List<PlanTrabajoGADDTO> lista = new ArrayList<>();
	         try{
	              List<TblPlanTrabajoGad> listaRegistros =PlanServicio.obtenerRegistroPlanTrabajo(infCod);
	               
	               
	              if (listaRegistros.size() > 0){
	        			lista = listaRegistros.stream()
	        					.map(obj -> PlanTrabajoGADDTO.builder()
	        					.contador(listaRegistros.indexOf(obj)+1)
	        					.PtgCod(obj.getPtgCod())
	        					.Objetivo(obj.getPtgObjetivo().toString())
	        					.Programa(obj.getPtgDescPrograma().toString())
	        					.PorcAvance(obj.getPtgPorcAvance())
	        					.Resultados(obj.getPtgDescResultados().toString())
	        					.build())
	        					.collect(Collectors.toList());
	        			json = (!lista.isEmpty())
	        					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
	        					: Constantes.MESSAGE_EMPTY_JSON;
	        			} else{
	            	  json = "{\"Error\": []}";
	              }

	         } catch (Exception e){
	              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

	         }

	         return json;
	    }
	 
	 
	 @RequestMapping(value = {"/obtenerEjecucionesProgramaticas"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerEjecucionesProgramaticas(Authentication authentication,@RequestParam("infCod") Integer infCod) {
	         String json;
	         ObjectMapper mapper = new ObjectMapper();
	         List<PlanificacionEjecucionGADDTO> lista = new ArrayList<>();
	         
	         
	         try{
	      		  List<Object[]> registrosTotalEP = infor.obtenerTotalesEjecucionProgramaticaNativa(infCod);
 

	              if (registrosTotalEP.size() > 0){
	            	  
	            	  DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
	            	  simbolo.setDecimalSeparator('.');
	            	  simbolo.setGroupingSeparator(',');
	            	  DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
	            	  
	            	  lista = registrosTotalEP.stream()
	  						.map(obj -> PlanificacionEjecucionGADDTO.builder()
	  								.eprCod((Integer)obj[0])
	  								.contador(registrosTotalEP.indexOf(obj)+1)
	  								.codigoObjetivo(obj[1].toString())
	  								.tipoCompetencia(obj[2].toString())
	  								.descripcionCompetencia(obj[3].toString())
	  								.numeroMeta((BigInteger)obj[4])
	  								.meta(obj[5].toString())
	  								.indicadorMeta(obj[6].toString())
	  								.tp(formateador.format(obj[7]))
	  								.tc(formateador.format(obj[8]))
	  								.porcentajeGestion((BigDecimal)obj[9])
	  								.aporte(obj[11].toString())
	  								.descripcionGestion(obj[10].toString())
	  								.build())
	  								.collect(Collectors.toList());
	  				json = (!lista.isEmpty())
	  						? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
	  						: Constantes.MESSAGE_EMPTY_JSON;

	             
	              } else{
	            	  json = "{\"data\": []}";
	              }

	         } catch (Exception e){
	              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

	         }	       
	         return json;
	    }
	 
	 @SuppressWarnings("finally")
     @RequestMapping(value = "/view/rendicion/eliminarDatos", method = RequestMethod.POST)
     public @ResponseBody String eliminarDatos(Model model, @RequestParam("codigo") int codigo,@RequestParam("tabla") String tabla,@RequestParam("campo") String campo) {
          JSONObject mensaje = new JSONObject();
          mensaje.put("estado", "error");
          mensaje.put("mensaje", "Ha ocurrido un error!");
          try{
            
        	  auis.eliminarTablaCampo(codigo, tabla, campo);
                
               mensaje.put("estado", "exito");
               mensaje.put("mensaje", "Los datos se han Eliminado correctamente.! ");
          } catch (Exception e){
               mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
          } finally{
               return mensaje.toString();
          }
     }
	 @SuppressWarnings("finally")
	    @RequestMapping(value = "/view/rendicion/ActualizarDatos", method = RequestMethod.POST)
	    public @ResponseBody String ActualizarDatos(HttpServletRequest request,@RequestParam("tabla") String tabla, @RequestParam(value = "condicion", required = false) String condicion ,@RequestParam(value = "values", required = false) String values , @RequestParam(value = "columns", required = false) String columns,@RequestParam("valorcondicion") String valorcondicion){
	         JSONObject mensaje = new JSONObject();
	         String[] arrayColumnas, arrayvalores;
	         mensaje.put("estado", "error");
	         mensaje.put("mensaje", "Ha ocurrido un error!");	 
	      
	         try{
	        	
	        	 arrayColumnas=  columns.split(",9") ;
	        	 arrayvalores=  values.split(",9") ;
	        	 auis.ActualizarTablaCampo(tabla,arrayColumnas,arrayvalores,condicion,valorcondicion);
	        	 
	            	   mensaje.put("estado", "exito");
	                   mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
	             
	         } catch (Exception e){
	              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
	         } finally{
	              return mensaje.toString();
	         }
	    }
	 
	 @RequestMapping(value = {"/obtenerCoberturasNacionales"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerCoberturasNacionales(Authentication authentication,@Param(value = "infCod") Integer infCod, @Param(value = "TipoFormulario") Integer TipoFormulario) {
			String json;
			ObjectMapper mapper = new ObjectMapper();
	         List<CoberturaGADDTO> lista = new ArrayList<>();
			
			try {
				String instTipDes = "";
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				switch (TipoFormulario) {
						case 1:
							instTipDes="GAD";
						break;
					    default:
					    	instTipDes="UDAF";
						break;
						
						}
				List<TblCoberturaNacional> listaCoberturaTerritorial = CoberturaNacionalService.obtenerRegistroCoberturaNacionalXInfCodAndTipo(tblInforme.getInfCod(),instTipDes);
			
				lista = listaCoberturaTerritorial.stream()
						.map(obj -> CoberturaGADDTO.builder().impleCod(obj.getCnCod())
								.contador(listaCoberturaTerritorial.indexOf(obj)+3)
								.cobertura(obj.getCnCobertura())
								.unidades(obj.getCnUnidades())
								.build())
						.collect(Collectors.toList());
				json = (!lista.isEmpty())
						? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
						: Constantes.MESSAGE_EMPTY_JSON;
				
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		} 
	 
	 @RequestMapping(value = {"/obtenerCoberturasTerritoriales"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerCoberturasTerritoriales(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
			List<CoberturaGADDTO> lista = new ArrayList<>();
			
			try {

				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				
				List<Object[]> listaCoberturaInstitucional =  CoberturaTerritorialService.OntenerRegistrosImplCoberturaTerritorialXcod(tblInforme);
				
			
				lista = listaCoberturaInstitucional.stream()
						.map(obj ->
							CoberturaGADDTO.builder()
							.impleCod((Integer) obj[0])
							.contador(listaCoberturaInstitucional.indexOf(obj)+1)
							.nombre(obj[1].toString())
							.cobertura(obj[2].toString())
							.build()
						)
						.collect(Collectors.toList());
				
				
				json = (!lista.isEmpty())
						? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
						: Constantes.MESSAGE_EMPTY_JSON;
				} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			return json;
		}
		
	 @RequestMapping(value = {"/obtenerObjetivosPlan"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerObjetivosPlan(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
			List<ObjetivosGADDTO> lista = new ArrayList<>();
			try {
				
				
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				List<Object[]> listaObjetivos = infor.obtenerRegistroObjetivosPlanXcod(tblInforme);
				
				lista = listaObjetivos.stream()
						.map(obj ->
							ObjetivosGADDTO.builder()
							.impleCod((Integer) obj[0])
							.contador(listaObjetivos.indexOf(obj)+1)
							.avances((obj[4]==null?"0":obj[4].toString()))
							.ejecucionesProgramaticas((obj[5]==null?"0":obj[5].toString()))
							.objetivo(obj[1].toString())
							.build()
						)
						.collect(Collectors.toList());
				
				json = (!lista.isEmpty())
						? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
						: Constantes.MESSAGE_EMPTY_JSON;
				
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			
			 return json;
		}
	 
	 @RequestMapping(value = {"/obtenerAvances"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerAvances(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
			List<ReporteAvanceGADDTO> lista = new ArrayList<>();
			try {
				
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				List<Object[]> listaAvances = infor.obtenerRegistroAvances(tblInforme);		
			
				lista = listaAvances.stream()
						.map(obj ->
						    ReporteAvanceGADDTO.builder()
						    .pdCod((Integer) obj[0])
						    .contador(listaAvances.indexOf(obj)+1)
						    .objCod(infor.obtenerIdObjetivoPlan(Integer.parseInt(obj[1].toString())).getObjNombre().toString())
						    .pdPorcAvanceAcum(obj[2].toString())
						    .pdRazon(obj[3].toString())
							.build()
						)
						.collect(Collectors.toList());
				
				json = (!lista.isEmpty())
						? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
						: Constantes.MESSAGE_EMPTY_JSON;
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
	
	 @SuppressWarnings("finally")
		@RequestMapping(value = "view/rendicion/guardarReporteAvances")
		public @ResponseBody String guardarReporteAvances(HttpServletRequest request,
				@RequestParam(value = "infCod") Integer infCod,  @RequestParam(value = "objCod") Integer  objCod,
				@RequestParam( value = "pdPorcAvanceAcum") String pdPorcAvanceAcum, @RequestParam(value = "pdRazon") String pdRazon) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {
				TblPlanDesarrollo	tblPlanDesarrollo = new TblPlanDesarrollo();
				tblPlanDesarrollo.setObjCod(objCod);
				tblPlanDesarrollo.setPdRazon(pdRazon.toUpperCase());
				tblPlanDesarrollo.setPdPorcAvanceAcum(new BigDecimal(pdPorcAvanceAcum, MathContext.DECIMAL64));
				tblPlanDesarrollo.setPdEstado(Constantes.ESTADO);
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				tblPlanDesarrollo.setInfCod(tblInforme);
				infor.guardarAvances(tblPlanDesarrollo);
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}
		}

	 @SuppressWarnings("finally")
		@RequestMapping(value = "view/rendicion/guardarEjecucionProgramatica")
		public @ResponseBody String guardarEjecucionProgramatica(HttpServletRequest request,
				@RequestParam(value = "infCod") Integer infCod,  @RequestParam(value = "objCod") Integer  objCod, @RequestParam(value = "eprNumero") BigInteger eprNumero,
				@RequestParam(value = "eprMeta") String eprMeta, @RequestParam(value = "eprIndicador") String eprIndicador,
				@RequestParam(value = "eprPresultadopl") String eprPresultadopl, @RequestParam(value = "eprPresultadocm") String eprPresultadocm, 
				@RequestParam(value = "eprAporteResult") String eprAporteResult, @RequestParam(value = "eprTipoCompetencia") String eprTipoCompetencia,
				@RequestParam(value = "listadoCompetenciasConcurrentes", required = false) String eprCompetenciaConcurr, 
				@RequestParam( value = "eprGestion") String eprGestion, @RequestParam(value = "foCodExclusivas", required = false) Integer foCodExclusivas,  @RequestParam(value = "foCodConcurrentes", required = false) Integer foCodConcurrentes
				,@RequestParam(value = "foCodFines", required = false) Integer foCodFines) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {
				Double eprTotal = (double) 0;
				Double eprsuma = (double) 0;
				Double eprsumaTotal = (double) 0;
				String perdiodoRC = Constantes.periodo().toString();
				String eprPresultadoplNumero=eprPresultadopl.toString().replace(",", "").trim();
				String eprPresultadocmtNumero=eprPresultadocm.toString().replace(",", "").trim();
				
				
				Double pl = Double.valueOf(eprPresultadoplNumero== null ? "0" : eprPresultadoplNumero.isEmpty() ? "0" : eprPresultadoplNumero.toString());
				Double cm = Double.valueOf(eprPresultadocmtNumero== null ? "0" : eprPresultadocmtNumero.isEmpty() ? "0" : eprPresultadocmtNumero.toString());
				
				if (pl==0) {
					
					eprTotal = (double) 0;
				}else {
				eprTotal= (cm*100)/pl;
				}
				TblEjecucionProgramatica tblEjecucionProgramatica = new TblEjecucionProgramatica(); 
				  tblEjecucionProgramatica.setObjCod(objCod);
				  if(foCodExclusivas==null) {	  
					  if(foCodConcurrentes==null) {
						  tblEjecucionProgramatica.setFoCod(foCodFines);
						  TblFuncionesObjetivos listaFuncionesObjetivos =	is.obtenerRegistroFuncionObjetivo(foCodFines, perdiodoRC);
						  tblEjecucionProgramatica.setEprCompetenciaConcurr(listaFuncionesObjetivos.getFoNom().toUpperCase());
					  }else {
						  tblEjecucionProgramatica.setFoCod(foCodConcurrentes);
						  TblFuncionesObjetivos listaFuncionesObjetivos =	is.obtenerRegistroFuncionObjetivo(foCodConcurrentes, perdiodoRC);
						  tblEjecucionProgramatica.setEprCompetenciaConcurr(listaFuncionesObjetivos.getFoNom().toUpperCase());
					  }
						 
				  }else {
				  tblEjecucionProgramatica.setFoCod(foCodExclusivas);
				  TblFuncionesObjetivos listaFuncionesObjetivos =	is.obtenerRegistroFuncionObjetivo(foCodExclusivas, perdiodoRC);
				  tblEjecucionProgramatica.setEprCompetenciaConcurr(listaFuncionesObjetivos.getFoNom().toUpperCase());

				  }
				  tblEjecucionProgramatica.setInfCod(infCod);
				  tblEjecucionProgramatica.setEprNumero(eprNumero);
				  tblEjecucionProgramatica.setEprMeta(eprMeta.toUpperCase());
				  tblEjecucionProgramatica.setEprIndicador(eprIndicador.toUpperCase());
				  tblEjecucionProgramatica.setEprPresultadopl(new BigDecimal(pl, MathContext.DECIMAL64));
				  tblEjecucionProgramatica.setEprPresultadocm(new BigDecimal(cm, MathContext.DECIMAL64));
				  tblEjecucionProgramatica.setEprGestion(eprGestion.toUpperCase());
				  tblEjecucionProgramatica.setEprEstado(Constantes.ESTADO);
				  tblEjecucionProgramatica.setEprTipoCompetencia(eprTipoCompetencia.toUpperCase());
				  tblEjecucionProgramatica.setEprAporteResult(eprAporteResult.toUpperCase());
				  tblEjecucionProgramatica.setEprTotal(new BigDecimal(eprTotal, MathContext.DECIMAL64));
				  infor.guardarEjecucionProgramtica(tblEjecucionProgramatica);
				  List<TblEjecucionProgramatica> registrosTotalEP = infor.obtenerTotalesEjecucionProgramatica(infCod);
				  if (registrosTotalEP.size()==1) {
					  
					  tblEjecucionProgramatica.setEprSuma(new BigDecimal(eprTotal, MathContext.DECIMAL64));
					  infor.ActualizarTotalEjecucionProgramatica(tblEjecucionProgramatica.getEprSuma(), infCod);
				  }else {
					      for (int i = 0; i < registrosTotalEP.size(); i++) {
						  
					    	  eprsuma+= registrosTotalEP.get(i).getEprTotal().doubleValue(); 
						  }
					      eprsumaTotal= eprsuma/registrosTotalEP.size();
						  tblEjecucionProgramatica.setEprSuma(new BigDecimal(eprsumaTotal, MathContext.DECIMAL64));
						  infor.ActualizarTotalEjecucionProgramatica(tblEjecucionProgramatica.getEprSuma(), infCod);
				  }
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}
		}
		
	 
	 
	 //Juan Carlos no borrar
	@SuppressWarnings("unused")
	@RequestMapping(value = "view/rendicion/Frm_ActualizarDetallePoaNuevo",method = RequestMethod.POST)
	    public String Frm_ActualizarDetallePoaNuevo(Model model, Authentication authentication ) {	
		 List<String> tipo = new  ArrayList<String>();	 
		 model.addAttribute("email", authentication.getName());
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
	   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
			
	   	 	
				
	   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){	   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
	   	 	}else {
	   	 		
	   	 	List<TblEjecucionProgramatica> registrosTotalEP = infor.obtenerTotalesEjecucionProgramatica(verificarInforme.getInfCod());
			model.addAttribute("listadoMetas", registrosTotalEP);
			List<TblDetalleEjecucionp> registrosDetalleEPMeta =  adps.obtenerregistro(verificarInforme.getInfCod());
			 
			 if(registrosDetalleEPMeta.size()!=0) {
				 String sCadena = registrosDetalleEPMeta.get(0).getDepTipo();
				 if (sCadena.equals("META") ) {
				 tipo.add("PROGRAMA Y/O PROYECTO");
				 tipo.add("META");
			 model.addAttribute("tipoMeta",tipo);	 
			 }else {
				 if (sCadena.equals("AREA")) {				 
					 tipo.add("PROGRAMA Y/O PROYECTO");
					 tipo.add("AREA"); 	 
					 model.addAttribute("tipoMeta",tipo);
					 }else {				 
						 for (TblDetalleEjecucionp tblDetalleEjecucionp : registrosDetalleEPMeta) {
							if(tblDetalleEjecucionp.getDepTipo().equals("AREA")) {
									tipo.clear();	
									 tipo.add("PROGRAMA Y/O PROYECTO");
									 tipo.add("AREA");
							}else if(tblDetalleEjecucionp.getDepTipo().equals("META")) {
								tipo.clear();
								 tipo.add("PROGRAMA Y/O PROYECTO");
								 tipo.add("META");
							}else {
								if(tipo.isEmpty()) {
								 tipo.add("PROGRAMA Y/O PROYECTO");
								 tipo.add("META");
								 tipo.add("AREA");
								}else {
								}
							}
						 }
						 model.addAttribute("tipoMeta",tipo);
					 }
			 }
			 }else {
				 
				 tipo.add("PROGRAMA Y/O PROYECTO");
				 tipo.add("META");
				 tipo.add("AREA"); 
				 model.addAttribute("tipoMeta",tipo);
				 
			 }
	   	 		
	   	 	if(registrosTotalEP.size() ==0) {
	   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
	 		model.addAttribute("infCod", verificarInforme.getInfCod());
			}
			else {
				
				
				
				model.addAttribute("inf_estado", "activo");
				model.addAttribute("infCod", verificarInforme.getInfCod());
				model.addAttribute("registrosTotalEP", registrosTotalEP);
			}		
			}
	         return "rendicion/Frm_ActualizarDetallePoaNuevo";
	    }
	 
	 
	 @SuppressWarnings("unused")
		@RequestMapping("/view/rendicion/Frm_ActualizarDetallePoa")
		    public String Frm_ActualizarDetallePoa(Model model, @RequestParam("opcion") int idMenu, Authentication authentication ) {	
			 List<String> tipo = new  ArrayList<String>();	 
			 model.addAttribute("email", authentication.getName());
				TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
				
					
		   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
				if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){		   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
		   	 	}else {
		   	 		
		   	 	List<TblEjecucionProgramatica> registrosTotalEP = infor.obtenerTotalesEjecucionProgramatica(verificarInforme.getInfCod());
				model.addAttribute("listadoMetas", registrosTotalEP);
				List<TblDetalleEjecucionp> registrosDetalleEPMeta =  adps.obtenerregistro(verificarInforme.getInfCod());
				 
				 if(registrosDetalleEPMeta.size()!=0) {
					 String sCadena = registrosDetalleEPMeta.get(0).getDepTipo();
					 if (sCadena.equals("META") ) {
					
					 tipo.add("PROGRAMA Y/O PROYECTO");
					 tipo.add("META");
				 model.addAttribute("tipoMeta",tipo);	 
				 }else {
					 if (sCadena.equals("AREA")) {				 
						 tipo.add("PROGRAMA Y/O PROYECTO");
						 tipo.add("AREA"); 	 
						 model.addAttribute("tipoMeta",tipo);
						 }else {				 
							 tipo.add("PROGRAMA Y/O PROYECTO");
							 tipo.add("META");
							 tipo.add("AREA"); 
							 model.addAttribute("tipoMeta",tipo);
						 }
				 }
				 }else {
					 
					 tipo.add("PROGRAMA Y/O PROYECTO");
					 tipo.add("META");
					 tipo.add("AREA"); 
					 model.addAttribute("tipoMeta",tipo);
					 
				 }
		   	 	if(registrosDetalleEPMeta.size() ==0) {
		   	 	
		   	 		if(registrosTotalEP.size()==0) {
		   	 		model.addAttribute("inf_estado", "sinEjecucionProgramatica");
		   	 		model.addAttribute("infCod", verificarInforme.getInfCod());
		   	 		}else {
		   	 		model.addAttribute("inf_estado", verificarInforme.getInfEstado());
		   	 		model.addAttribute("infCod", verificarInforme.getInfCod());
		   	 		}
		   	 		
				
		   	 	
		   	 	
		   	 	}
				else {
					List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
			        model.addAttribute("acciones", listaAcciones);
					model.addAttribute("inf_estado", "matriz");
					model.addAttribute("infCod", verificarInforme.getInfCod());
					model.addAttribute("registrosTotalEP", registrosTotalEP);
					model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				}		
				}
		         return "rendicion/Frm_ActualizarDetallePoa";
		    }
	 
	 @SuppressWarnings("finally")
		@RequestMapping(value = "view/rendicion/guardarActualizarDetallePoa")
		public @ResponseBody String guardarActualizarDetallePoa(HttpServletRequest request,
				@RequestParam(value = "infCod") Integer infCod, @RequestParam(value = "depTipo") String depTipo, @RequestParam(value = "depDescripcion", required = false) String depDescripcion
				, @RequestParam(value = "depPresplan") String depPresplan,  @RequestParam(value = "depPresejec") String depPresejec , @RequestParam(value = "epMeta", required = false) String epMeta 
				, @RequestParam( value = "depLink") String depLink
				) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {
				
				
				String depPresplanNumero=depPresplan.toString().replace(",", "").trim();
				String depPresejecNumero=depPresejec.toString().replace(",", "").trim();
				
				//total acumulado
				Double depTotal = (double) 0;
				//personajo
				Double depCumple = (double) 0;
				Double suma = (double) 0;
				Double pl = Double.valueOf(depPresplanNumero== null ? "0" : depPresplanNumero.isEmpty() ? "0" : depPresplanNumero.toString());
				Double cm = Double.valueOf(depPresejecNumero== null ? "0" : depPresejecNumero.isEmpty() ? "0" : depPresejecNumero.toString());
				
				if(pl==0) {
					depCumple = (double) 0;
				}else {
					depCumple= (cm*100)/pl;

				}
				
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				TblDetalleEjecucionp tblDetalleEjecucionp = new TblDetalleEjecucionp();
				tblDetalleEjecucionp.setInfCod(tblInforme);
				tblDetalleEjecucionp.setDepTipo(depTipo);
				tblDetalleEjecucionp.setDepPresplan(new BigDecimal(pl, MathContext.DECIMAL64));
				tblDetalleEjecucionp.setDepPresejec(new BigDecimal(cm, MathContext.DECIMAL64));
				tblDetalleEjecucionp.setDepCumple(new BigDecimal(depCumple, MathContext.DECIMAL64));
				tblDetalleEjecucionp.setDepLink(depLink);
				tblDetalleEjecucionp.setDepTotal(new BigDecimal(depCumple, MathContext.DECIMAL64));
				if (depDescripcion==null) {
					 tblDetalleEjecucionp.setDepDescripcion(epMeta);			 
				 }else{
					 tblDetalleEjecucionp.setDepDescripcion(depDescripcion); 
				 }
				
				adps.guardarDetalleEP(tblDetalleEjecucionp);
				List<TblDetalleEjecucionp> registrosDetalleEP =  adps.obtenerregistro(infCod);
				if (registrosDetalleEP.size()==1) {
						adps.ActualizarTotalDetallePoa(new BigDecimal(depCumple, MathContext.DECIMAL64), tblDetalleEjecucionp.getDepCod());
				  }else {
					    for (int i = 0; i < registrosDetalleEP.size(); i++) {
					    	  suma+= registrosDetalleEP.get(i).getDepCumple().doubleValue();
						  }
					      depTotal= suma/registrosDetalleEP.size();
					      tblDetalleEjecucionp.setDepTotal(new BigDecimal(depTotal, MathContext.DECIMAL64));
					      adps.ActualizarTotalDetallePoaTodos(tblDetalleEjecucionp.getDepTotal(), infCod);
				  }
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}
		}
	 
	 
	 
	 
	 @RequestMapping(value = {"/obtenerActualizarDetallePoa"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerActualizarDetallePoa(Authentication authentication,@RequestParam("infCod") Integer infCod) {
	         String json;
	         ObjectMapper mapper = new ObjectMapper(); 
	    	 List<PresupuestoInstitucionalGADDTO> lista = new ArrayList<>();
	         try{
	  			  List<TblDetalleEjecucionp> registrosDetalleEPMeta =  adps.obtenerregistro(infCod);
	  			
		  			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		  			simbolo.setDecimalSeparator('.');
	            	simbolo.setGroupingSeparator(',');
	            	DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);

	              if (registrosDetalleEPMeta.size() > 0){
	            	    lista = registrosDetalleEPMeta.stream()
	          					.map(obj -> PresupuestoInstitucionalGADDTO.builder()
	          					.contador(registrosDetalleEPMeta.indexOf(obj)+1)
	          					.depCodigo(obj.getDepCod())
	          					.depCumple(obj.getDepCumple().toString())
	          					.depDescripcion(obj.getDepDescripcion().toString())
	          					.depPresplan(formateador.format(obj.getDepPresplan()))
	          					.depPresejec(formateador.format(obj.getDepPresejec()))
	          					.depLink(obj.getDepLink().toString())
	          					.depTipo(obj.getDepTipo())
	          					.build())
	          					.collect(Collectors.toList());
	          			json = (!lista.isEmpty())
	          					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
	          					: Constantes.MESSAGE_EMPTY_JSON; 
	          			} else{
	            	  json = "{\"data\": []}";
	              }

	         } catch (Exception e){
	              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

	         }

	         return json;
	    }
	 
	 
	 @SuppressWarnings("unused")
		@RequestMapping("/view/rendicion/Frm_EjecutivoPresupuesto")
	    public String Frm_EjecutivoPresupuesto(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
			model.addAttribute("email", authentication.getName());
			
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
	   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
			 
	   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){	   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
	   	 	}else {
	   	 	List<TblPresupuestoInstitucional> verificarPresupuestoInstitucional =  pis.obtenerPresupuestoInstitucional(verificarInforme.getInfCod());
	   	 	if(verificarPresupuestoInstitucional.size() ==0) {
	   	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
	 		model.addAttribute("infCod", verificarInforme.getInfCod());
			}
			else {
				List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
		        model.addAttribute("acciones", listaAcciones);
				model.addAttribute("infestado", "matriz");
				model.addAttribute("infCod", verificarInforme.getInfCod());
				model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			}		
			}
	         return "rendicion/Frm_EjecutivoPresupuesto";
	    }
	 
	 @SuppressWarnings("finally")
	    @RequestMapping(value = "/view/rendicion/guardarPresupuestoInstitucional")
	    public @ResponseBody String guardarPresupuestoInstitucional(HttpServletRequest request,@RequestParam("infCod") int infCod,
	    		@RequestParam("infPresupuesto") String infPresupuesto, 
	    		@RequestParam("infGastplan") String infGastplan,
	    		@RequestParam("infGastejec") String infGastejec,
	    		@RequestParam("infGastinvplan") String infGastinvplan,
	    		@RequestParam("infGastinvejec") String infGastinvejec
	    		) {
	         JSONObject mensaje = new JSONObject();
	         mensaje.put("estado", "error");
	         mensaje.put("mensaje", "Ha ocurrido un error!");	        
	         try{
	        	 
	        	TblPresupuestoInstitucional tblPresupuestoInstitucional = new TblPresupuestoInstitucional();
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());

				String infPresupuestoNumero=infPresupuesto.toString().replace(",", "").trim();
				String infGastplantNumero=infGastplan.toString().replace(",", "").trim();
				String infGastejecNumero=infGastejec.toString().replace(",", "").trim();
				String infGastinvplanNumero=infGastinvplan.toString().replace(",", "").trim();
				String infGastinvejecNumero=infGastinvejec.toString().replace(",", "").trim();

				
	 			tblPresupuestoInstitucional.setInfPresupuesto(new BigDecimal(infPresupuestoNumero, MathContext.DECIMAL64));
	 			tblPresupuestoInstitucional.setInfGastplan(new BigDecimal(infGastplantNumero, MathContext.DECIMAL64));
	 			tblPresupuestoInstitucional.setInfGastinvplan(new BigDecimal(infGastinvplanNumero, MathContext.DECIMAL64));
	 			tblPresupuestoInstitucional.setInfGastejec(new BigDecimal(infGastejecNumero, MathContext.DECIMAL64));
	 			tblPresupuestoInstitucional.setInfGastinvejec(new BigDecimal(infGastinvejecNumero, MathContext.DECIMAL64));
	 			Double gcp = Double.valueOf(infGastejecNumero== null ? "0" : infGastejecNumero.isEmpty() ? "0" : infGastejecNumero.toString());
				Double gie = Double.valueOf(infGastinvejecNumero== null ? "0" : infGastinvejecNumero.isEmpty() ? "0" : infGastinvejecNumero.toString());
				Double suma= gcp+gie;
				Double pl=  Double.valueOf(infPresupuestoNumero== null ? "0" : infPresupuestoNumero.isEmpty() ? "0" : infPresupuestoNumero.toString());
				Double infPorcetejecpres = Double.valueOf(0);
				
				if (pl==0) {
				 infPorcetejecpres = Double.valueOf(0);
				}else {
					
					 infPorcetejecpres= (suma*100)/pl;

				}
				
				tblPresupuestoInstitucional.setInfPorcetejecpres(new BigDecimal(infPorcetejecpres, MathContext.DECIMAL64));
				tblPresupuestoInstitucional.setInfCod(tblInforme);
	 			pis.guardarPresupuestoInstitucionalImpl(tblPresupuestoInstitucional);
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
					 
					 
	         } catch (Exception e){
	              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
	         } finally{
	              return mensaje.toString();
	         }
	    }
	
	 @RequestMapping(value = {"/obtenerPresupuestoInstitucional"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerPresupuestoInstitucional(Authentication authentication,@RequestParam("infCod") Integer infCod) {
	         String json;
	         ObjectMapper mapper = new ObjectMapper(); 
	    	 List<PresupuestoInstitucionalGADDTO> lista = new ArrayList<>();
	         
	       
	         try{
	  			  List<TblPresupuestoInstitucional>	 registrosPresupuestoInstitucional = pis.obtenerPresupuestoInstitucional(infCod);

	              if (registrosPresupuestoInstitucional.size() > 0){
	            	DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
     					
              	   	simbolo.setDecimalSeparator('.');
	            	simbolo.setGroupingSeparator(',');
	            	DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
	            	
	            	
	            	lista = registrosPresupuestoInstitucional.stream()
          					.map(obj -> PresupuestoInstitucionalGADDTO.builder()
          					.contador(registrosPresupuestoInstitucional.indexOf(obj)+1)
          					.infPresupuesto(formateador.format(obj.getInfPresupuesto()))
          					.infGastplan(formateador.format(obj.getInfGastplan()))
          					.infGastejec(formateador.format(obj.getInfGastejec()))
          					.infGastinvplan(formateador.format(obj.getInfGastinvplan()))
          					.inf_gastinvejec(formateador.format(obj.getInfGastinvejec()))
          					.infPorcetejecpres(formateador.format(obj.getInfPorcetejecpres()))
          					.preInsti(obj.getPreInsti())
          					.build())
          					.collect(Collectors.toList());
          			json = (!lista.isEmpty())
          					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
          					: Constantes.MESSAGE_EMPTY_JSON; 
          			} else{
	            	  json = "{\"data\": []}";
	              }

	         } catch (Exception e){
	              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

	         }

	         return json;
	    }
	 	
	 
	 @RequestMapping("/view/rendicion/Frm_PresupuestoParticipativo")
	    public String Frm_PresupuestoParticipativo(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
			model.addAttribute("email", authentication.getName());
			
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
	   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
	   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){	   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
	   	 	}else {
				List<Object[]> verificarPorcentajePresupuesto =  pps.obtenerPorcentajePresupuestoImpl(verificarInforme); 

	   	 	if(verificarPorcentajePresupuesto.size() ==0) {
	   	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
	 		model.addAttribute("infCod", verificarInforme.getInfCod());
			}
			else {
				List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
		        model.addAttribute("acciones", listaAcciones);
				model.addAttribute("infestado", "matriz");
				model.addAttribute("infCod", verificarInforme.getInfCod());
				model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			}		
			}
	         return "rendicion/Frm_PresupuestoParticipativo";
	    }
	 
	 
	 
	 @SuppressWarnings("finally")
	    @RequestMapping(value = "/view/rendicion/guardarPorcentajePresupuesto")
	    public @ResponseBody String guardarPorcentajePresupuesto(HttpServletRequest request,@RequestParam("infCod") int infCod,
	    		@RequestParam(value ="infTieneprespar" , required = false) String infTieneprespar, 
	    		@RequestParam(value ="infTotalpres", required = false) String infTotalpres,
	    		@RequestParam(value ="infPresparticipativo" , required = false ) String infPresparticipativo,
	    		@RequestParam(value ="infLinkpres", required = false) String infLinkpres
	    		) {
	         JSONObject mensaje = new JSONObject();
	         mensaje.put("estado", "error");
	         mensaje.put("mensaje", "Ha ocurrido un error!");	        
	         try{
					String infTotalpresNumero = "";
					String infPresparticipativoNumero ="";

					
	        	TblPorcentajePresupuesto tblPorcentajePresupuesto = new TblPorcentajePresupuesto();
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				
				if (infTotalpres==null) {
					infTotalpresNumero = "";
					}else {
						 infTotalpresNumero=infTotalpres.toString().replace(",", "").trim();

					}
				if (infPresparticipativo==null) {
						infPresparticipativoNumero = "";
					}else {
						 infPresparticipativoNumero=infPresparticipativo.toString().replace(",", "").trim();

					}
				
				if(infTieneprespar.equals("SI")) {
	 				tblPorcentajePresupuesto.setInfCod(tblInforme);
	 				tblPorcentajePresupuesto.setInfTieneprespar(infTieneprespar);
	 				tblPorcentajePresupuesto.setInfTotalpres(new BigDecimal(infTotalpresNumero, MathContext.DECIMAL64));
	 				tblPorcentajePresupuesto.setInfPresparticipativo(new BigDecimal(infPresparticipativoNumero, MathContext.DECIMAL64));
	 				tblPorcentajePresupuesto.setInfLinkpres(infLinkpres == null ? null :infLinkpres);
	 				//tblPorcentajePresupuesto.setInfLinkpres(infLinkpres.replaceAll(System.getProperty("line.separator"), ""));
	 				Double p = Double.valueOf(infTotalpresNumero== null ? "0" : infTotalpresNumero.isEmpty() ? "0" : infTotalpresNumero.toString());
					Double c=  Double.valueOf(infPresparticipativoNumero== null ? "0" : infPresparticipativoNumero.isEmpty() ? "0" : infPresparticipativoNumero.toString());
					Double infPorcetejecpres= Double.valueOf(0);
					
					if (p==0) {
						 infPorcetejecpres= Double.valueOf(0);

						
					}else {
							
							 infPorcetejecpres= (c*100)/p;
						}
					
					
					
					
					tblPorcentajePresupuesto.setInfPorprespar(new BigDecimal(infPorcetejecpres, MathContext.DECIMAL64));
					pps.guardarPorcentajePresupuestoImpl(tblPorcentajePresupuesto); 
	 			}else {
	 				
	 				tblPorcentajePresupuesto.setInfCod(tblInforme);
	 				tblPorcentajePresupuesto.setInfTieneprespar(infTieneprespar);
	 				tblPorcentajePresupuesto.setInfTotalpres(new BigDecimal(0, MathContext.DECIMAL64));
	 				tblPorcentajePresupuesto.setInfPresparticipativo(new BigDecimal(0, MathContext.DECIMAL64));
	 				tblPorcentajePresupuesto.setInfLinkpres("NO APLICA");
	 			
					tblPorcentajePresupuesto.setInfPorprespar(new BigDecimal(0, MathContext.DECIMAL64));
					pps.guardarPorcentajePresupuestoImpl(tblPorcentajePresupuesto); 
	 			}
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
	         } catch (Exception e){
	              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
	         } finally{
	              return mensaje.toString();
	         }
	    }
	 
	 
	 @RequestMapping(value = {"/obtenerPorcentajePresupuesto"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerPorcentajePresupuesto(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
	    	List<PresupuestoParticipativoGADDTO> lista = new ArrayList<>();
	    	DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
			simbolo.setDecimalSeparator('.');
      	  	simbolo.setGroupingSeparator(',');
			DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
  
	      
			try {
				TblInforme tblInforme = infor.obtenerRegistroInforme(infCod);
				List<Object[]> verificarPorcentajePresupuesto =  pps.obtenerPorcentajePresupuestoImpl(tblInforme); 
				
				if (verificarPorcentajePresupuesto.size()> 0) {			
					  
					lista = verificarPorcentajePresupuesto.stream()
							.map(obj ->PresupuestoParticipativoGADDTO.builder()
								.presCod((Integer) obj[0])
								.contador(verificarPorcentajePresupuesto.indexOf(obj)+1)
								.infTotalpres(formateador.format(obj[2]))
								.infPresparticipativo(formateador.format(obj[1]))
								.infPorprespar(formateador.format(obj[3]))
								.infLinkpres(obj[4].toString())
								.build()
							)
							.collect(Collectors.toList());
		
					
					json = (!lista.isEmpty())
							? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
							: Constantes.MESSAGE_EMPTY_JSON;
					}else{
	                json = "{\"data\": []}";
	           }
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
		
	 @SuppressWarnings("unused")
	@RequestMapping("/view/rendicion/Frm_FasesPresupuesto")
	    public String Frm_FasesPresupuesto(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
			model.addAttribute("email", authentication.getName());
			
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
	   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
			
	   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){	   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
	   	 	}else {
				List<Object[]> verificarFasesPresupuesto = fppis.obtenerFasesPresupuestos(verificarInforme);

	   	 	if(verificarFasesPresupuesto.size() ==0) {
	   	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
	 		model.addAttribute("infCod", verificarInforme.getInfCod());
			}
			else {
				List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
		        model.addAttribute("acciones", listaAcciones);
				model.addAttribute("infestado", "matriz");
				model.addAttribute("infCod", verificarInforme.getInfCod());
				model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			}		
			}
	         return "rendicion/Frm_FasesPresupuesto";
	    }
	 
	 @SuppressWarnings("finally")
	    @RequestMapping(value = "/view/rendicion/guardarFasePresupuestoParticipativo")
	    public @ResponseBody String guardarFasePresupuestoParticipativo(HttpServletRequest request,@RequestParam("infCod") int infCod,
	    		@RequestParam("faseOpcion") String faseOpcion, 
	    		@RequestParam(value = "ante_descrip", required = false) String anteDescrip,
	    		@RequestParam(value = "faseGrupo", required = false) String faseGrupo,
	    		@RequestParam(value = "faseSubprogramas", required = false) String faseSubprogramas,
	    		@RequestParam(value = "faseLink", required = false) String faseLink
	    		) {
	         JSONObject mensaje = new JSONObject();
	         mensaje.put("estado", "error");
	         mensaje.put("mensaje", "Ha ocurrido un error!");	
	         TblFasePresupuestoParticipativo tblFasePresupuestoParticipativo;
	         TblFasePresupuestoParticipativo tblFasePresupuestoParticipativo2;
	         try{
	        	 
				 TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				 Integer valor =fppis.countFasePP(tblInforme, "SE REALIZÓ LA DEFINICIÓN PARTICIPATIVA DE PRIORIDADES DE INVERSIÓN DEL AÑO SIGUIENTE");
	        	if (valor==0) {
	        		 tblFasePresupuestoParticipativo = new TblFasePresupuestoParticipativo();
				}else {
				 tblFasePresupuestoParticipativo = fppis.obtenerFasesPresupuestosNombre(tblInforme, "SE REALIZÓ LA DEFINICIÓN PARTICIPATIVA DE PRIORIDADES DE INVERSIÓN DEL AÑO SIGUIENTE");
				}
	       	 Integer valor1 =fppis.countFasePP(tblInforme, "PARA LA ELABORACIÓN DE LOS PROGRAMAS SUBPROGRAMAS Y PROYECTOS SE INCORPORÓ LA PRIORIZACIÓN DE LA INVERSIÓN QUE REALIZÓ LA POBLACIÓN DEL TERRITORIO");
	        	if (valor1==0) {
	        		tblFasePresupuestoParticipativo2 = new TblFasePresupuestoParticipativo();
				}else {
					tblFasePresupuestoParticipativo2 = fppis.obtenerFasesPresupuestosNombre(tblInforme, "PARA LA ELABORACIÓN DE LOS PROGRAMAS SUBPROGRAMAS Y PROYECTOS SE INCORPORÓ LA PRIORIZACIÓN DE LA INVERSIÓN QUE REALIZÓ LA POBLACIÓN DEL TERRITORIO");
				}
	        	 if (faseOpcion.equals("SI")) {
		        	 tblFasePresupuestoParticipativo.setFaseNombre("SE REALIZÓ LA DEFINICIÓN PARTICIPATIVA DE PRIORIDADES DE INVERSIÓN DEL AÑO SIGUIENTE");
		        	 tblFasePresupuestoParticipativo.setFaseOpcion(faseOpcion);
		        	 tblFasePresupuestoParticipativo.setFaseActor(anteDescrip);
		        	 tblFasePresupuestoParticipativo.setFaseGrupo(faseGrupo.toUpperCase());
		        	 tblFasePresupuestoParticipativo.setFaseLink(faseLink == null ? null : faseLink);
		        	// tblFasePresupuestoParticipativo.setFaseLink(faseLink.replaceAll(System.getProperty("line.separator"), ""));
		        	 tblFasePresupuestoParticipativo.setInfoCod(tblInforme);
		        	 fppis.guardarFasePresupuestoParticipativoImpl(tblFasePresupuestoParticipativo);
	        	 }else {
	        		 tblFasePresupuestoParticipativo.setFaseNombre("SE REALIZÓ LA DEFINICIÓN PARTICIPATIVA DE PRIORIDADES DE INVERSIÓN DEL AÑO SIGUIENTE");
	        		 tblFasePresupuestoParticipativo.setFaseOpcion(faseOpcion);
		        	 tblFasePresupuestoParticipativo.setFaseActor("NO APLICA");
		        	 tblFasePresupuestoParticipativo.setFaseGrupo("NO APLICA");
		        	 tblFasePresupuestoParticipativo.setFaseLink("NO APLICA");
		        	 tblFasePresupuestoParticipativo.setInfoCod(tblInforme);
		        	 fppis.guardarFasePresupuestoParticipativoImpl(tblFasePresupuestoParticipativo);
	        	 }
	        	
	        	
				if (faseSubprogramas.equals("SI")) {
					tblFasePresupuestoParticipativo2.setFaseNombre("PARA LA ELABORACIÓN DE LOS PROGRAMAS SUBPROGRAMAS Y PROYECTOS SE INCORPORÓ LA PRIORIZACIÓN DE LA INVERSIÓN QUE REALIZÓ LA POBLACIÓN DEL TERRITORIO");
					tblFasePresupuestoParticipativo2.setFaseOpcion("SI");
					tblFasePresupuestoParticipativo2.setFaseActor(" ");
					tblFasePresupuestoParticipativo2.setFaseGrupo(" ");
					tblFasePresupuestoParticipativo2.setFaseLink(" ");
					tblFasePresupuestoParticipativo2.setInfoCod(tblInforme);
		        	 fppis.guardarFasePresupuestoParticipativoImpl(tblFasePresupuestoParticipativo2);

				}else {
					tblFasePresupuestoParticipativo2.setFaseNombre("PARA LA ELABORACIÓN DE LOS PROGRAMAS SUBPROGRAMAS Y PROYECTOS SE INCORPORÓ LA PRIORIZACIÓN DE LA INVERSIÓN QUE REALIZÓ LA POBLACIÓN DEL TERRITORIO");
					tblFasePresupuestoParticipativo2.setFaseOpcion("NO");
					tblFasePresupuestoParticipativo2.setFaseActor("NO APLICA");
					tblFasePresupuestoParticipativo2.setFaseGrupo("NO APLICA");
					tblFasePresupuestoParticipativo2.setFaseLink("NO APLICA");
					tblFasePresupuestoParticipativo2.setInfoCod(tblInforme);
		        	 fppis.guardarFasePresupuestoParticipativoImpl(tblFasePresupuestoParticipativo2);
				}
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
	         } catch (Exception e){
	              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
	         } finally{
	              return mensaje.toString();
	         }
	    }
	 
	 
	 @RequestMapping(value = {"/obtenerFasePresupuestoParticipativo"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerFasePresupuestoParticipativo(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
	    	List<PresupuestoParticipativoGADDTO> lista = new ArrayList<>();
			try {
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				List<Object[]> verificarFasesPresupuesto = fppis.obtenerFasesPresupuestos(tblInforme);
				if (verificarFasesPresupuesto.size()> 0) {			
					String mensaje = "PARA LA ELABORACIÓN DE LOS PROGRAMAS SUBPROGRAMAS Y PROYECTOS SE INCORPORÓ LA PRIORIZACIÓN DE LA INVERSIÓN QUE REALIZÓ LA POBLACIÓN DEL TERRITORIO";
					   
					lista = verificarFasesPresupuesto.stream()
							.map(obj ->PresupuestoParticipativoGADDTO.builder()
								.faseCod((Integer) obj[0])
								.contador(verificarFasesPresupuesto.indexOf(obj) + 1)
								.faseOpcion(obj[1].toString())
								.faseNombre(obj[2].toString())
								.faseActor(obj[3].toString())
								.faseGrupo(obj[4].toString())
								.faseLink((obj[1].toString().equals(mensaje)?obj[2].toString():obj[5].toString()))
	
								.build()
							)

							.collect(Collectors.toList());
		
					
					json = (!lista.isEmpty())
							? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
							: Constantes.MESSAGE_EMPTY_JSON;
					}else{
	                json = "{\"data\": []}";
	           }
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
	 
	 @RequestMapping("/view/rendicion/Frm_DetallePresupuesto")
		public String Frm_DetallePresupuesto(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
		   model.addAttribute("email", authentication.getName());

			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
			
			TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
				model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);
				} 
			else{
				List<Object[]> verificarDetallePresupuesto  =   dpps.ProyPresupuestoParticipativoImpl(verificarInforme);

			   if(verificarDetallePresupuesto.size() ==0) {
					model.addAttribute("inf_estado", verificarInforme.getInfEstado());
					model.addAttribute("infCod", verificarInforme.getInfCod());
				}
				else {
					List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
			        model.addAttribute("acciones", listaAcciones);
					model.addAttribute("inf_estado", "matriz");
					model.addAttribute("infCod", verificarInforme.getInfCod());
					model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
					
				}		
				
			}
			return "rendicion/Frm_DetallePresupuesto";
		}
	 
	 @SuppressWarnings("finally")
	    @RequestMapping(value = "/view/rendicion/guardarProyPresupuestoParticipativo")
	    public @ResponseBody String guardarProyPresupuestoParticipativo(HttpServletRequest request,@RequestParam("infCod") int infCod,
	    		@RequestParam(value = "proyDescripcion", required = false) String proyDescripcion, 
	    		@RequestParam(value = "proyMontoplan", required = false) String proyMontoplan,
	    		@RequestParam(value = "proyMontoejec", required = false) String proyMontoejec,
	    		@RequestParam(value = "proyObs", required = false) String proyObs,
	    		@RequestParam(value = "proyPorcAvance", required = false) String proyPorcAvance,
	    		@RequestParam(value = "proyLinks", required = false) String proyLinks
	    		) {
	         JSONObject mensaje = new JSONObject();
	         mensaje.put("estado", "error");
	         mensaje.put("mensaje", "Ha ocurrido un error!");	        
	         try{
	        	 
	        	 String proyMontoplanNumero=proyMontoplan.toString().replace(",", "").trim();
				String proyMontoejecNumero=proyMontoejec.toString().replace(",", "").trim();
	        	 
	        	 TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				 TblProyPresupuestoParticipativo tblProyPresupuestoParticipativo = new TblProyPresupuestoParticipativo();
				 tblProyPresupuestoParticipativo.setInfCod(tblInforme);
				 tblProyPresupuestoParticipativo.setProyDescripcion(proyDescripcion.toUpperCase());
				 tblProyPresupuestoParticipativo.setProyMontoplan(new BigDecimal(proyMontoplanNumero, MathContext.DECIMAL64));
				 tblProyPresupuestoParticipativo.setProyMontoejec(new BigDecimal(proyMontoejecNumero, MathContext.DECIMAL64));
				 tblProyPresupuestoParticipativo.setProyPorcAvance(proyPorcAvance);
				 tblProyPresupuestoParticipativo.setProyObs(proyObs.toUpperCase());
				 tblProyPresupuestoParticipativo.setProyLinks(proyLinks == null ? null : proyLinks);
				 //tblProyPresupuestoParticipativo.setProyLinks(proyLinks.replaceAll(System.getProperty("line.separator"), ""));
				 
				 dpps.guardarProyPresupuestoParticipativoImpl(tblProyPresupuestoParticipativo);
	        	
	        	
	        	
				
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
	         } catch (Exception e){
	              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
	         } finally{
	              return mensaje.toString();
	         }
	    }
	 
	 @RequestMapping(value = {"/obtenerProyPresupuestoParticipativo"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerProyPresupuestoParticipativo(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			
	        ObjectMapper mapper = new ObjectMapper(); 
	    	List<PresupuestoParticipativoGADDTO> lista = new ArrayList<>();
	         
			try {
				TblInforme tblInforme = infor.obtenerRegistroInforme(infCod);
				List<Object[]> verificarDetallePresupuesto  =   dpps.ProyPresupuestoParticipativoImpl(tblInforme);
				DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
	  			simbolo.setDecimalSeparator('.');
            	simbolo.setGroupingSeparator(',');
            	DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
				
				if (verificarDetallePresupuesto.size()> 0) {			
					
					
	            	lista = verificarDetallePresupuesto.stream()
          					.map(obj -> PresupuestoParticipativoGADDTO.builder()
          					.contador(verificarDetallePresupuesto.indexOf(obj)+1)
          					.proyCod((Integer) obj[0])
          					.proyDescripcion(obj[1].toString())
          					.proyMontoplan(formateador.format(obj[2]).toString())
          					.proyMontoejec(formateador.format(obj[3]).toString())
          					.proyPorcAvance(obj[5].toString())
          					.proyObs(obj[4].toString())
          					.proyLinks(obj[6].toString())
          					.build())
          					.collect(Collectors.toList());
          			json = (!lista.isEmpty())
          					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
          					: Constantes.MESSAGE_EMPTY_JSON; 
          			}else{
	                json = "{\"data\": []}";
	           }
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
	 
	 @RequestMapping(value = "view/rendicion/Frm_DetallePresupuestoNuevo",method = RequestMethod.POST)
		public String Frm_DetallePresupuestoNuevo(Model model, Authentication authentication) {
		   model.addAttribute("email", authentication.getName());

			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
			
			TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){
				model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);
				} 
			else{
				List<Object[]> verificarDetallePresupuesto  =   dpps.ProyPresupuestoParticipativoImpl(verificarInforme);

			   if(verificarDetallePresupuesto.size() ==0) {
					model.addAttribute("inf_estado", verificarInforme.getInfEstado());
					model.addAttribute("infCod", verificarInforme.getInfCod());
				}
				else {
					model.addAttribute("inf_estado", "activo");
					model.addAttribute("infCod", verificarInforme.getInfCod());
				}		
			}
			return "rendicion/Frm_DetallePresupuestoNuevo";
		}
	 
	 @SuppressWarnings("unused")
		@RequestMapping("/view/rendicion/Frm_Anteproyecto")
		    public String Frm_Anteproyecto(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
				model.addAttribute("email", authentication.getName());
				
				TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
		   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
				if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){		   	   	 	model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_VACIO);		
		   	 	}else {
					List<Object[]> verificarAnteproyectos = aps.BuscarAnteproyectoPresupuestoServiceImpl(verificarInforme);

		   	 	if(verificarAnteproyectos.size() ==0) {
		   	 	 model.addAttribute("infestado", verificarInforme.getInfEstado());
		 		model.addAttribute("infCod", verificarInforme.getInfCod());
				}
				else {
					List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
			        model.addAttribute("acciones", listaAcciones);
					model.addAttribute("infestado", "matriz");
					model.addAttribute("infCod", verificarInforme.getInfCod());
					model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				}		
				}
		         return "rendicion/Frm_Anteproyecto";
		    }
	 
	 
		@RequestMapping(value = "/view/rendicion/Frm_Anteproyecto1",method = RequestMethod.POST)
		    public String Frm_Anteproyecto1(Model model, Authentication authentication, @RequestParam("id") Integer id) {	
			TblAnteproyectoPresupuesto verificarAnteproyectos = aps.ObtenerRegistrosAnteproyectos(id);
			model.addAttribute("anteOpc",verificarAnteproyectos.getAnteOpc());
			model.addAttribute("anteCod",verificarAnteproyectos.getAnteCod());
			model.addAttribute("anteDescrip",verificarAnteproyectos.getAnteDescrip());
			model.addAttribute("infestado", "activo");
			return "rendicion/Frm_Anteproyecto1";
		    }
	 	 
		@RequestMapping(value = "/view/rendicion/Frm_Anteproyecto2",method = RequestMethod.POST)
		    public String Frm_Anteproyecto2(Model model, Authentication authentication, @RequestParam("id") Integer id) {	
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			TblAnteproyectoPresupuesto verificarAnteproyectos = aps.ObtenerRegistrosAnteproyectos(id);
			model.addAttribute("infestado", "activo");
			model.addAttribute("anteCod",verificarAnteproyectos.getAnteCod());
			model.addAttribute("anteFecha", df.format(verificarAnteproyectos.getAnteFecha()));
			return "rendicion/Frm_Anteproyecto2";
		    }

		@RequestMapping(value = "/view/rendicion/Frm_Anteproyecto3",method = RequestMethod.POST)
		    public String Frm_Anteproyecto3(Model model, Authentication authentication, @RequestParam("id") Integer id) {	
			TblAnteproyectoPresupuesto verificarAnteproyectos = aps.ObtenerRegistrosAnteproyectos(id);
			model.addAttribute("infestado", "activo");
			model.addAttribute("anteCod",verificarAnteproyectos.getAnteCod());
			model.addAttribute("anteOpc",verificarAnteproyectos.getAnteOpc());
			model.addAttribute("anteDescrip", verificarAnteproyectos.getAnteDescrip());
		         return "rendicion/Frm_Anteproyecto3";
		    }
	 @SuppressWarnings("finally")
	    @RequestMapping(value = "/view/rendicion/guardarAnteproyectoPresupuesto")
	    public @ResponseBody String guardarAnteproyectoPresupuesto(HttpServletRequest request,@RequestParam("infCod") int infCod,
	    		@RequestParam("anteOpc") String anteOpc, 
	    		@RequestParam(value = "ante_descrip", required = false) String ante_descrip,
	    		@RequestParam(value = "anteFecha", required = false)  Date anteFecha,
	    		@RequestParam(value = "anteOpc2", required = false) String anteOpc2,
	    		@RequestParam(value = "anteDescrip", required = false) String anteDescrip
	    		) {
	         JSONObject mensaje = new JSONObject();
	         mensaje.put("estado", "error");
	         mensaje.put("mensaje", "Ha ocurrido un error!");	        
	         try{
	        	 
				 TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				 TblAnteproyectoPresupuesto tblAnteproyectoPresupuesto = new TblAnteproyectoPresupuesto();
				 TblAnteproyectoPresupuesto tblAnteproyectoPresupuesto2 = new TblAnteproyectoPresupuesto();
				 TblAnteproyectoPresupuesto tblAnteproyectoPresupuesto3 = new TblAnteproyectoPresupuesto();

	        	
	        	 if (anteOpc.equals("SI")) {
	        		 tblAnteproyectoPresupuesto.setAnteNom("EL ANTEPROYECTO DEL PRESUPUESTO PARTICIPATIVO SE DIÓ A CONOCER A LA CIUDADANÍA DEL 20 AL 31 DE OCTUBRE");
	        		 tblAnteproyectoPresupuesto.setAnteOpc(anteOpc);
	        		 tblAnteproyectoPresupuesto.setAnteDescrip(ante_descrip);
	        		 tblAnteproyectoPresupuesto.setInfCod(tblInforme);
	        		 tblAnteproyectoPresupuesto.setAnteTipo("SE DIO A CONOCER");
	        		 tblAnteproyectoPresupuesto.setAnteEstado(Constantes.ESTADO);
	        		 aps.guardarAnteproyectoPresupuestoServiceImpl(tblAnteproyectoPresupuesto);
	        	 }else {
	        		 tblAnteproyectoPresupuesto.setAnteNom("NO APLICA");
	        		 tblAnteproyectoPresupuesto.setAnteOpc(anteOpc);
	        		 tblAnteproyectoPresupuesto.setAnteDescrip("NO APLICA");
	        		 tblAnteproyectoPresupuesto.setInfCod(tblInforme);
	        		 tblAnteproyectoPresupuesto.setAnteTipo("SE DIO A CONOCER");
	        		 tblAnteproyectoPresupuesto.setAnteEstado(Constantes.ESTADO);
	        		 aps.guardarAnteproyectoPresupuestoServiceImpl(tblAnteproyectoPresupuesto);
	        	 }
	        	
	        	 if (anteFecha.toString()!=null) {
	        		 tblAnteproyectoPresupuesto2.setAnteNom("EL ANTEPROYECTO DEL PRESUPUESTO PARTICIPATIVO SE PRESENTÓ ANTE EL LEGISLATIVO DEL GAD HASTA EL");
	        		 tblAnteproyectoPresupuesto2.setAnteFecha(anteFecha);
	        		 tblAnteproyectoPresupuesto2.setAnteTipo("FECHAS");
	        		 tblAnteproyectoPresupuesto2.setInfCod(tblInforme);
	        		 tblAnteproyectoPresupuesto.setAnteEstado(Constantes.ESTADO);
	        		 aps.guardarAnteproyectoPresupuestoServiceImpl(tblAnteproyectoPresupuesto2);

					}else {
						tblAnteproyectoPresupuesto2.setAnteNom("NO APLICA");
		        		 tblAnteproyectoPresupuesto2.setAnteTipo("FECHAS");
		        		 tblAnteproyectoPresupuesto2.setInfCod(tblInforme);
		        		 tblAnteproyectoPresupuesto.setAnteEstado(Constantes.ESTADO);
		        		 aps.guardarAnteproyectoPresupuestoServiceImpl(tblAnteproyectoPresupuesto2);
					}
	        	 
				if (anteOpc2.equals("SI")) {
	        		 tblAnteproyectoPresupuesto3.setAnteNom("UNA VEZ QUE EL LEGISLATIVO APROBÓ EL ANTEPROYECTO DEL PRESUPUESTO PARTICIPATIVO SE DIÓ A CONOCER A LA CIUDADANÍA");
	        		 tblAnteproyectoPresupuesto3.setAnteOpc(anteOpc2);
	        		 tblAnteproyectoPresupuesto3.setAnteDescrip(anteDescrip);
	        		 tblAnteproyectoPresupuesto3.setAnteTipo("DIFUNDIO");
	        		 tblAnteproyectoPresupuesto3.setAnteEstado(Constantes.ESTADO);
	        		 tblAnteproyectoPresupuesto3.setInfCod(tblInforme);
	        		 aps.guardarAnteproyectoPresupuestoServiceImpl(tblAnteproyectoPresupuesto3);

				}else {
					tblAnteproyectoPresupuesto3.setAnteNom("NO APLICA");
	        		 tblAnteproyectoPresupuesto3.setAnteOpc(anteOpc2);
	        		 tblAnteproyectoPresupuesto3.setAnteDescrip("NO APLICA");
	        		 tblAnteproyectoPresupuesto3.setAnteTipo("DIFUNDIO");
	        		 tblAnteproyectoPresupuesto3.setAnteEstado(Constantes.ESTADO);
	        		 tblAnteproyectoPresupuesto3.setInfCod(tblInforme);
	        		 aps.guardarAnteproyectoPresupuestoServiceImpl(tblAnteproyectoPresupuesto3);
				}
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
	         } catch (Exception e){
	              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
	         } finally{
	              return mensaje.toString();
	         }
	    }
	 
	 
	
	 @RequestMapping(value = {"/obtenerAnteproyectoPresupuesto1"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerAnteproyectoPresupuesto1(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
	    	List<PresupuestoParticipativoGADDTO> lista1=new ArrayList<>();
			
			try {
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				List<Object[]> verificarAnteproyectos = aps.BuscarAnteproyectoPresupuestoServiceImpl(tblInforme);
				if (verificarAnteproyectos.size()> 0) {			
					Object[] item = verificarAnteproyectos.get(0);
						PresupuestoParticipativoGADDTO tabla1 = new PresupuestoParticipativoGADDTO();
						tabla1.setAnteCod((Integer)item[0]);
						tabla1.setContador(verificarAnteproyectos.indexOf(item) + 1);
						tabla1.setAnteNom(item[1].toString());
						tabla1.setAnteOpc(item[2].toString());
						tabla1.setAnteDescrip(item[4].toString());
						lista1.add(tabla1);
							json=(!lista1.isEmpty())
							? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista1) + "}"
							: Constantes.MESSAGE_EMPTY_JSON;
							}else{
	                json = "{\"data\": []}";
	           }
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
	 
	 @RequestMapping(value = {"/obtenerAnteproyectoPresupuesto2"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerAnteproyectoPresupuesto2(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
	    	List<PresupuestoParticipativoGADDTO> lista1=new ArrayList<>();
			try {
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				List<Object[]> verificarAnteproyectos = aps.BuscarAnteproyectoPresupuestoServiceImpl(tblInforme);
				
				if (verificarAnteproyectos.size()> 0) {	
					Object[] item = verificarAnteproyectos.get(1);
					PresupuestoParticipativoGADDTO tabla1 = new PresupuestoParticipativoGADDTO();
					tabla1.setAnteCod((Integer)item[0]);
					tabla1.setContador(verificarAnteproyectos.indexOf(item) + 1);
					tabla1.setAnteNom(item[1].toString());
					tabla1.setAnteFecha(item[3].toString());
					lista1.add(tabla1);
						json=(!lista1.isEmpty())
						? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista1) + "}"
						: Constantes.MESSAGE_EMPTY_JSON;
						}else{
	                json = "{\"data\": []}";
	           }
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
	 
	 @RequestMapping(value = {"/obtenerAnteproyectoPresupuesto3"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerAnteproyectoPresupuesto3(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
	    	List<PresupuestoParticipativoGADDTO> lista1=new ArrayList<>();
			try {
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				List<Object[]> verificarAnteproyectos = aps.BuscarAnteproyectoPresupuestoServiceImpl(tblInforme);
				if (verificarAnteproyectos.size() >0) {	
					Object[] item = verificarAnteproyectos.get(2);
					PresupuestoParticipativoGADDTO tabla1 = new PresupuestoParticipativoGADDTO();
					tabla1.setAnteCod((Integer)item[0]);
					tabla1.setContador(verificarAnteproyectos.indexOf(item) + 1);
					tabla1.setAnteNom(item[1].toString());
					tabla1.setAnteOpc(item[2].toString());
					tabla1.setAnteDescrip(item[4].toString());
					lista1.add(tabla1);
						json=(!lista1.isEmpty())
						? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista1) + "}"
						: Constantes.MESSAGE_EMPTY_JSON;
						}else{
	                json = "{\"data\": []}";
	           }
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
	 
	 
	 @RequestMapping("/view/rendicion/Frm_GAD_Asamblea")
	    public String Frm_GAD_Asamblea(Model model, @RequestParam("opcion") int idMenu, Authentication authentication ) {	
			model.addAttribute("email", authentication.getName());
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
	   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
			
			
	   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){	   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
	   	 	}else {
	   	 		
	   	 	List<TblObjetivosPlanDesarrollo> verificarMatrizObjetivosPlan = infor.OntenerRegistrosObjetivosXcod(verificarInforme);
			model.addAttribute("listadoObjetivosPlan", verificarMatrizObjetivosPlan);
			String tipo = "COMPETENCIAS EXCLUSIVAS";
			List<TblFuncionesObjetivos> verificarFuncionesObjetivos = is.obtenerRegistroInformeInstitucionFuncionesObjetivosxTipo(datosUsuario.getCodigoIntitucionAutorida(), tipo);
			model.addAttribute("listadoFuncionesObjetivos", verificarFuncionesObjetivos);
			List<TblEjecucionProgramatica> registrosTotalEP = infor.obtenerTotalesEjecucionProgramatica(verificarInforme.getInfCod());
			List<Object[]> verificarAsambleas = acs.BuscarAsambleaCiudadanaImpl(verificarInforme);

	   	 	if(verificarAsambleas.size() ==0) {
	   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
	 		model.addAttribute("infCod", verificarInforme.getInfCod());
			}
			else {
				List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
		        model.addAttribute("acciones", listaAcciones);
				model.addAttribute("inf_estado", "matriz");
				model.addAttribute("infCod", verificarInforme.getInfCod());
				model.addAttribute("registrosTotalEP", registrosTotalEP);
				model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			}		
			}
	         return "rendicion/Frm_GAD_Asamblea";
	    }
		
	 @SuppressWarnings("finally")
	    @RequestMapping(value = "/view/rendicion/guardarAsambleaCiudadana")
	    public @ResponseBody String guardarAsambleaCiudadana(HttpServletRequest request,@RequestParam("infCod") int infCod,
	    		@RequestParam(value = "acExiste", required = false) String acExiste, 
	    		@RequestParam(value = "acNomRespon", required = false) String acNomRespon,
	    		@RequestParam(value = "acMeilRespon", required = false) String acMeilRespon,
	    		@RequestParam(value = "acTelfRespon", required = false) String acTelfRespon,
	    		@RequestParam(value = "acValidaGestTerritorio", required = false) String acValidaGestTerritorio,
	    		@RequestParam(value = "ante_descrip", required = false) String anteDescrip,
	    		@RequestParam(value = "acDescLogros", required = false) String acDescLogros,
	    		@RequestParam(value = "acDescrPlanficacion", required = false) String acDescrPlanficacion
	    		) {
	         JSONObject mensaje = new JSONObject();
	         mensaje.put("estado", "error");
	         mensaje.put("mensaje", "Ha ocurrido un error!");	        
	         try{
	        	 
				 TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				 TblAsambleaCiudadana tblAsambleaCiudadana = new TblAsambleaCiudadana();
				 
				 if(acExiste.equals("SI")) {
					 tblAsambleaCiudadana.setAcEspaciosParticipa("ASAMBLEA CIUDADANA LOCAL (DEFINICIÓN EXTRAIDA DE LA LOPC, ART. 65)");
					 tblAsambleaCiudadana.setAcExiste(acExiste);
					 tblAsambleaCiudadana.setAcValidaGestTerritorio(acValidaGestTerritorio);
					 tblAsambleaCiudadana.setAcDescrPlanficacion(acDescrPlanficacion.toUpperCase());
					 tblAsambleaCiudadana.setAcDescLogros(acDescLogros.toUpperCase());
					 tblAsambleaCiudadana.setAcNomRespon(acNomRespon.toUpperCase());
					 tblAsambleaCiudadana.setAcMeilRespon(acMeilRespon);
					 tblAsambleaCiudadana.setAcTelfRespon(acTelfRespon);
					 tblAsambleaCiudadana.setAcRepreTerri(anteDescrip);
					 tblAsambleaCiudadana.setInfCod(tblInforme);
					 acs.guardarAnteproyectoPresupuestoServiceImpl(tblAsambleaCiudadana);
					 }else {
						 tblAsambleaCiudadana.setAcEspaciosParticipa("NO APLICA");
						 tblAsambleaCiudadana.setAcExiste(acExiste);
						 tblAsambleaCiudadana.setAcValidaGestTerritorio("NO APLICA");
						 tblAsambleaCiudadana.setAcDescrPlanficacion("NO APLICA");
						 tblAsambleaCiudadana.setAcDescLogros("NO APLICA");
						 tblAsambleaCiudadana.setAcNomRespon("NO APLICA");
						 tblAsambleaCiudadana.setAcMeilRespon("NO APLICA");
						 tblAsambleaCiudadana.setAcTelfRespon("NO APLICA");
						 tblAsambleaCiudadana.setAcRepreTerri("NO APLICA");
						 tblAsambleaCiudadana.setAcDescLogros("NO APLICA");

						 tblAsambleaCiudadana.setInfCod(tblInforme);
						 acs.guardarAnteproyectoPresupuestoServiceImpl(tblAsambleaCiudadana);
					 }
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
	         } catch (Exception e){
	              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
	         } finally{
	              return mensaje.toString();
	         }
	    }
	 
	 
	 
	 @RequestMapping(value = {"/obtenerAsambleaCiudadana"}, method = RequestMethod.POST)
		@ResponseBody 
		public String obtenerAsambleaCiudadana(Authentication authentication,@Param(value = "infCod") Integer infCod) {
			String json;
			ObjectMapper mapper = new ObjectMapper(); 
			 List<MecanismosGADDTO> lista = new ArrayList<>();
			try {
				TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
				List<Object[]> verificarAsambleas = acs.BuscarAsambleaCiudadanaImpl(tblInforme);
				
				if (verificarAsambleas.size()> 0) {			
					lista = verificarAsambleas.stream()
							.map(obj ->
							MecanismosGADDTO.builder()
							.acCod((Integer) obj[0])
							.contador(verificarAsambleas.indexOf(obj)+1)
							.acEspaciosParticipa(obj[1].toString())
							.acExiste(obj[2].toString())
							.acValidaGestTerritorio(obj[3].toString())
							.acDescrPlanficacion(obj[4].toString())
							.acDescLogros(obj[5].toString())
							.acNomRespon(obj[6].toString()+"<br>"+obj[7].toString()+"<br>"+obj[8].toString())
							.acRepreTerri(obj[9].toString())
							.build()
							)
							.collect(Collectors.toList());
					
					
					json = (!lista.isEmpty())
							? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
							: Constantes.MESSAGE_EMPTY_JSON;
				}else{
	                json = "{\"data\": []}";
	           }
			} catch (Exception e) {
				  json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
			}
			 return json;
		}
	 
	 //Juan Carlos no borrar
	 
		@RequestMapping("/view/rendicion/Frm_DetalleMedios")
	    public String Frm_DetalleMedios(Model model, @RequestParam("id") int id, Authentication authentication) {	
		
			
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
	   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
			
				  TblComunicacionGestion tblregistro =medioservicio.obtenerRegistro(id);	  
				  
			  if(verificarInforme.getInfEstado().equals("finalizado")) 
				  
			  {
			 model.addAttribute("infestado", "finalizado"); 
			 }
			  else { 
				  
				  model.addAttribute("nombre", tblregistro.getCgNombre()); 
				  }
			  model.addAttribute("cgCod", id); 
			  model.addAttribute("infestado", verificarInforme.getInfEstado()); 
			   
			  
			 
	         return "rendicion/Frm_DetalleMedios";
	    }
		 @SuppressWarnings("finally")
		    @RequestMapping(value = "/view/rendicion/guardarTblDetalleComunicagestion")
		    public @ResponseBody String guardarTblDetalleComunicagestion(HttpServletRequest request,@RequestParam("cgCod") int cgCod,
		    		@RequestParam(value = "dcNombre", required = false) String dcNombre, 
		    		@RequestParam(value = "dcMonto", required = false) String dcMonto,@RequestParam(value = "dcMinutos", required = false) String dcMinutos
		    		) {
		         JSONObject mensaje = new JSONObject();
		         mensaje.put("estado", "error");
		         mensaje.put("mensaje", "Ha ocurrido un error!");	        
		         try{
		        	 String Monto=dcMonto.toString().replace(",", "").trim();
		        	 TblComunicacionGestion tblregistro =medioservicio.obtenerRegistro(cgCod);
		        	 TblDetalleComunicagestion tblGuardarRegistro = new TblDetalleComunicagestion();
		        	 tblGuardarRegistro.setDcNombre(dcNombre);
		        	 tblGuardarRegistro.setDcMonto(new BigDecimal(Monto));
		        	 tblGuardarRegistro.setDcMinutos(dcMinutos);
		        	 tblGuardarRegistro.setCgCod(tblregistro);
		        	 mediocomunicacionservicio.guardarMediosComunicacionDetalle(tblGuardarRegistro);
					
					mensaje.put("estado", "exito");
					mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
		         } catch (Exception e){
		              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		         } finally{
		              return mensaje.toString();
		         }
		    }
		   @RequestMapping(value = {"/view/rendicion/ImprimirFormulario"}, method = RequestMethod.POST)
		     public String ImprimirFormulario(Authentication authentication,Model model, HttpServletRequest request,HttpServletResponse response,@RequestParam("infocod") int infocod) {
				String formulario="";
			   TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
				TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
				 TblInstitucion ListaInstiticuiones = gcs.ObtenerInstitucionesXInstCodandPeriodo(verificarInforme.getInstCod(), Constantes.periodo());
				  switch (ListaInstiticuiones.getInstTfCod().getTfCod()) {
                  case 1:
                	  //Formulario Gad
                	  formulario="ReporteInformeGad";
                  break;
                  case 2:
                	//Formulario Empresas Gad
                	  formulario="EmpresasGad";
                  break;
                  case 3:
                	//Formulario Empresas Públicas
                	  formulario="EmpresasPublicas";
                  break;
                  case 4:
                	//Formulario Registradores de la Propiedad
                	  formulario="Registradores";
                  break;
                  case 5:
                	//Formulario Instituciones de Educación
                	  formulario="InstitutosdeEducacion";
                  break;
                  case 6:
                	//Formulario Funciones del estado
                	  formulario="Funciones";
                  break;
                  case 7:
                	//Formulario Medios de Comunicación
                	  formulario="MediosComunicacion";
                  break;
                  case 8:
                	//Formulario IESS
                	  formulario="IESS";
                  break;
                
                  default:
                	  formulario="";
             }
				model.addAttribute("rutaPDF",Constantes.URL_SERVIDOR_REPORTES+formulario+"&Codigo="+verificarInforme.getInfCod()+"&anio="+Constantes.periodo());
				return "rendicion/generarReportePDF";
			}
		   
		   
		   @RequestMapping("/view/rendicion/Frm_Finalizar_Informe_Gad")
		    public String Frm_Finalizar_Informe_Gad(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
				model.addAttribute("email", authentication.getName());
				TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
				TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
		   	  TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
				if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){	
					model.addAttribute("inf_estado",Constantes.ESTADO_SIN_INFORME);		
		   	 	}else {
		   	 	String periodo = String.valueOf(Constantes.periodo());
				List<TblResponables> datosResponsables = respon.buscarResponsableXcodigoInstitucion(verificarInforme.getInstCod(), periodo);

				for (TblResponables datos : datosResponsables) {
					if (datos.getResponEmail() != null && !datos.getResponEmail().equals("")) {
						
					}

				}
		   	 		Integer codigoInforme = verificarInforme.getInfCod();
		   	 	 	String verificador = verificarInformeGad(codigoInforme, Constantes.periodo());
			   	 	model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
					model.addAttribute("infAutCod", verificarInforme.getInstCod());
					model.addAttribute("infAutPeriodo", verificarInforme.getInfPeriodo());
		   	 	 	if(verificador.equals("completo") && !verificarInforme.getInfEstado().trim().equals("finalizado")) {
		   	 	 	model.addAttribute("inf_estado", "completo");	 		
		   	 	 	}else {
		   	 	 	model.addAttribute("inf_estado",verificarInforme.getInfEstado());
		   	 	 
		   	 	 	model.addAttribute("mensaje", verificador);
		   	 	 	
					
		   	 	 	}
		   	 	}
		         return "rendicion/Frm_Finalizar_Informe_Gad";
		    }
			
			@RequestMapping(value = "view/rendicion/verificarInformeGad")
			public @ResponseBody String verificarInformeGad(@RequestParam(value = "infAutCod") Integer infCod,  @RequestParam(value = "infAutPeriodo") Integer infAutPeriodo) {
				JSONObject mensaje = new JSONObject();
				mensaje.put("estado", "error");
				mensaje.put("mensaje", "Ha ocurrido un error!");
				String resultado="";
			
				try {
					String verificaInfAut = infor.listarInstitucion(infCod, infAutPeriodo);
					Integer contador = verificaInfAut.length();
					if (contador==89) {
						resultado ="completo";
					}else {
						resultado = verificaInfAut;
						String[] items = resultado.split("NO");
						for (String item: items) {
					
						}
					}
				} catch (Exception e) {
					mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
				}
				return resultado;
			} 
			
			
			@SuppressWarnings("finally")
			@RequestMapping(value = "view/rendicion/FinalizarInformeGad")
			public @ResponseBody String FinalizarInformeGad(Authentication authentication,@RequestParam(value = "infAutCod") Integer instCod,  @RequestParam(value = "infAutPeriodo") Integer infPeriodo
					) {

				JSONObject mensaje = new JSONObject();
				mensaje.put("estado", "error");
				mensaje.put("mensaje", "Ha ocurrido un error!");
				try {

					TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(instCod, infPeriodo);
					if (verificarInforme==null) {
						
						mensaje.put("estado", "error");
						mensaje.put("mensaje", "No hay informe!");
					}else {
						mensaje.put("estado", "exito");
						mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
						Date infAutFechafin = new Date();
						DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						Date fechaControl = format.parse(Constantes.FECHA_CIERRE_INFORME_GAD);
						if(infAutFechafin.before(fechaControl)) {
							infor.finalizarInformeInstitucion(instCod, Constantes.ESTADO_INFORME_FINALIZADO, infAutFechafin, Constantes.ESTADO_INFORME_A_TIEMPO);
							servicioinstitucion.actualizarInstVerificador(instCod, infPeriodo, Constantes.ESTADO_PROCESO_CUMPLIDO);
						}else
						{
							
							infor.finalizarInformeInstitucion(instCod, Constantes.ESTADO_INFORME_FINALIZADO, infAutFechafin, Constantes.ESTADO_INFORME_A_DESTIEMPO);
							servicioinstitucion.actualizarInstVerificador(instCod, infPeriodo, Constantes.ESTADO_PROCESO_INCUMPLIDO);
						}
						
						
						
					}
					TblInforme verificarInformeFinalizado = infor.obtenerRegistroInformeInstitucion(instCod, infPeriodo);
					
					if (verificarInformeFinalizado.getInfEstado().trim().equals(Constantes.ESTADO_INFORME_FINALIZADO)) {
						
						String periodo = String.valueOf(Constantes.periodo());
						List<TblResponables> datosResponsables = respon.buscarResponsableXcodigoInstitucion(verificarInforme.getInstCod(), periodo);
						TblInstitucion datosInstitucion = gcs.ObtenerInstitucionesXidEstado(instCod,Constantes.ESTADO, Constantes.periodo());
						for (TblResponables datos : datosResponsables) {
							if (datos.getResponEmail() != null && !datos.getResponEmail().equals("")) {
								
								ms.mailFinalziarInformeInstitucion(datos.getResponEmail(), datos.getResponNombre(), datosInstitucion.getInstRuc(),datosInstitucion.getInstNom() ,verificarInformeFinalizado.getInfFechafin(), verificarInformeFinalizado.getInfVerificador(), true);

							}

						}
						
						
					}else
					{
						mensaje.put("estado", "error");
						mensaje.put("mensaje", "no se finalilzo el informe vuelva a intetarlo!");
					}
					
					
					
					
				} catch (Exception e) {
					mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
				} finally {
					return mensaje.toString();
				}

			}
		   
}
