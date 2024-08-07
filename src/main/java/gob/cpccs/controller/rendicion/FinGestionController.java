package gob.cpccs.controller.rendicion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gob.cpccs.controller.HomeController;
import gob.cpccs.model.dto.gestion.InfoRendicionDTO;
import gob.cpccs.model.dto.gestion.TributarioFinDTO;
import gob.cpccs.model.dto.rendicion.RendicionDignidadDTO;
import gob.cpccs.model.dto.rendicion.TblAmecanismosPcDTO;
import gob.cpccs.model.dto.rendicion.TblAportesCiudadanosDTO;
import gob.cpccs.model.dto.rendicion.TblFinGestionDTO;
import gob.cpccs.model.dto.rendicion.TblFuncionesAutoridadesDTO;
import gob.cpccs.model.dto.rendicion.TblPlanTrabajoDTO;
import gob.cpccs.model.dto.rendicion.TblPropuestasDTO;
import gob.cpccs.model.gestion.TblAmecanismosPcFin;
import gob.cpccs.model.gestion.TblFinGestion;
import gob.cpccs.model.gestion.TblFuncionesAutoridadesFin;
import gob.cpccs.model.gestion.TblInformeAutoridadFin;
import gob.cpccs.model.gestion.TblPlanTrabajoFin;
import gob.cpccs.model.gestion.TblPropuestasFin;
import gob.cpccs.utilidades.Constantes;
import gob.cpccs.model.usuario.TblAutoridad;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.service.AplicacionesUsuarioJPAServicio;
import gob.cpccs.service.autoridad.AutoridadServicio;
import gob.cpccs.service.gestion.FuncionesAutoridadesFinService;
import gob.cpccs.service.gestion.MecanismosAutoridadFinService;
import gob.cpccs.service.gestion.PlanTrabajoFinService;
import gob.cpccs.service.gestion.PropuestaFinAutoridadService;
import gob.cpccs.service.gestion.TblFinGestionServicio;
import gob.cpccs.service.gestion.TblInformeAutoridadFinService;
import gob.cpccs.service.mail.EmailService;
import gob.cpccs.service.usuario.UsuarioServicio;

@Controller
@RequestMapping("/view/gestion/")
public class FinGestionController {
	@Autowired
	private HomeController hc;
	@Autowired
	private AplicacionesUsuarioJPAServicio auis;
	@Autowired
	private UsuarioServicio usu;
	@Autowired
	private TblFinGestionServicio gestion;
	@Autowired
	private TblInformeAutoridadFinService InfoFinG;
	@Autowired
	private AutoridadServicio autori;
	@Autowired
	private PlanTrabajoFinService PlanService;
	@Autowired
	private MecanismosAutoridadFinService MPCF;
	@Autowired
	private FuncionesAutoridadesFinService fas;
	@Autowired
	private PropuestaFinAutoridadService pas;
	@Autowired
    private EmailService ms;

	@RequestMapping(value = "/FrmFinGestion", method = RequestMethod.POST)
	public String FrmFinGestion(Model model, Authentication authentication, @RequestParam("id") String id) {
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("identificador", datosUsuario.getIdentificador());
		if (id.equals("_nuevo")) {
			model.addAttribute("infotipo", "Nuevo");
			model.addAttribute("infcod", null);
		} else {
			TblAutoridad datosAutoridad = autori.buscarAutordadCodAutPeriodo(datosUsuario.getCodigoIntitucionAutorida(),datosUsuario.getPeriodo());
			TblFinGestion informe = gestion.FinGestioInfoCod(Integer.parseInt(id));
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			model.addAttribute("infcod", informe.getInfAutCod().getInfAutCod());
			model.addAttribute("infotipo", "Editar");
			model.addAttribute("numeroInforme", informe.getInfAutCod().getInfAutCod());
			model.addAttribute("nombreAutoridad", datosAutoridad.getNombre());
			model.addAttribute("identificadorAutoridad", datosAutoridad.getIdentificador());
			model.addAttribute("institucionDignidad", datosAutoridad.getInstitucionDignidad());
			model.addAttribute("dignidad", datosAutoridad.getDignidad());
			model.addAttribute("ambito", datosAutoridad.getAmbito());
			model.addAttribute("periodo", datosAutoridad.getPeriodo());
			model.addAttribute("fechaInicio", df.format(informe.getInfAutCod().getInfAutDesde()));
			model.addAttribute("fechaFin", df.format(informe.getInfAutCod().getInfAutHasta()));
			model.addAttribute("infestadoinforme", informe.getEstado());
		}

		return "gestion/FrmFinGestion";

	}

	@RequestMapping(value = "/listaFinGestion", method = RequestMethod.POST)
	public String listaFinGestion(Model model, Authentication authentication, @RequestParam("opcion") int idMenu) {
		int accion = 0;
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);

		TblFinGestion lista = gestion.ListaFinGestioEstadoIdentificador("activo", datosUsuario.getIdentificador());
		if (lista != null) {
			accion = 1;
		} else {
			accion = 0;
		}
		model.addAttribute("accion", accion);
		model.addAttribute("acciones", listaAcciones);
		return "gestion/listaFinGestion";
	}

	@PostMapping("/obtenerFinGestion")
	public @ResponseBody String obtenerFinGestion(Model model, Authentication authentication)
			throws JsonProcessingException {
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		TblAutoridad datosAutoridad = autori.buscarAutordadCodAutPeriodo(datosUsuario.getCodigoIntitucionAutorida(),datosUsuario.getPeriodo());
		List<TblFinGestion> lista = gestion.ListaFinGestioXcedula(datosUsuario.getIdentificador());
		List<TblFinGestionDTO> listaDTO = new ArrayList<>();
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			listaDTO = lista.stream()
					.map(dato -> TblFinGestionDTO.builder().idGestion(dato.getIdGestion())
							.infAutCod(dato.getInfAutCod().getInfAutCod())
							.FechaInicio(df.format(dato.getInfAutCod().getInfAutDesde()).toString())
							.FechaFin((dato.getInfAutCod().getInfAutHasta()!=null?df.format(dato.getInfAutCod().getInfAutHasta()).toString():""))
							.estado(dato.getEstado())
							.cedula(datosAutoridad.getIdentificador())
							.nombre(datosAutoridad.getNombre())
							.dignidad(datosAutoridad.getDignidad())
							.build())
					.collect(Collectors.toList());
			json = (!listaDTO.isEmpty()) ? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(listaDTO) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";
		}

		return json;
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/guardarRegistroFinGestion")
	public @ResponseBody String guardarRegistroFinGestion(HttpServletRequest request, TblAutoridad tblAutoridad,
			@RequestParam("identificador") String id,
			@RequestParam(value = "fechaInicioGestion") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaInicioGestion,
			@RequestParam(value = "fechaFinGestion") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaFinGestion,
			@RequestParam(value = "fechaRendicion") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaRendicion,
			@RequestParam("lugar") String lugar, @RequestParam("numeroAsistentes") int numeroAsistentes

	) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			TblInformeAutoridadFin tblInformeAutoridad = new TblInformeAutoridadFin();
			// TblInformeAutoridad verificarInforme =
			// is.obtenerRegistroInforme(id,Constantes.periodo());
			TblInformeAutoridadFin verificarInforme = InfoFinG.obtenerRegistroInformexIdentificadorEstado(id,Constantes.ESTADO);

			if (verificarInforme == null ) {
				tblInformeAutoridad.setIdentificador(id);
				tblInformeAutoridad.setInfAutPeriodo(Constantes.periodo());
				tblInformeAutoridad.setInfAutEstado(Constantes.ESTADO);
				tblInformeAutoridad.setInfAutDesde(fechaInicioGestion);
				tblInformeAutoridad.setInfAutHasta(fechaFinGestion);
				tblInformeAutoridad.setInfAutFechain(new Date());
				tblInformeAutoridad.setFechaRendicion(fechaRendicion);
				tblInformeAutoridad.setLugar(lugar.toUpperCase());
				tblInformeAutoridad.setNumeroAsistentes(numeroAsistentes);
				tblInformeAutoridad.setInfAutTributo("VACIO");
				tblInformeAutoridad.setInaProcesoRc("VACIO");
				tblInformeAutoridad.setInaAportesCiu("VACIO");
				tblInformeAutoridad.setInfContadorApertura(0);
				InfoFinG.GuardarInformeFin(tblInformeAutoridad);
                TblFinGestion finGestion = new TblFinGestion();
                finGestion.setEstado(Constantes.ESTADO);
                finGestion.setFechaInicio(new Date());
                finGestion.setIdentificador(String.valueOf(id));
                finGestion.setInfAutCod(tblInformeAutoridad);
                gestion.GuardarFinGestio(finGestion);
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			} else {
				mensaje.put("mensaje", "Usted ya cuenta con un informe " + verificarInforme.getInfAutEstado() + "! ");
			}
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@PostMapping("/obtenerIfoRC")
	public @ResponseBody String obtenerIfoRC(Model model, Authentication authentication,
			@RequestParam("infCod") int infCod) throws JsonProcessingException {
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		List<TblInformeAutoridadFin> verificarInforme = InfoFinG.obtenerRegistroInformexAutoCodEstado(infCod,
				Constantes.ESTADO);
		List<InfoRendicionDTO> listaDTO = new ArrayList<>();
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			listaDTO = verificarInforme.stream()
					.map(dato -> InfoRendicionDTO.builder()
							.infAutCod(dato.getInfAutCod())
							.FechaRendicion(df.format(dato.getFechaRendicion()).toString())
							.Lugar(dato.getLugar())
							.numero(dato.getNumeroAsistentes())
							.estado(dato.getInfAutEstado()).build())
					.collect(Collectors.toList());

			json = (listaDTO != null) ? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(listaDTO) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";
		}

		return json;
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "actualizarInformeAutoridadFin")
	public @ResponseBody String guardarActualizarSedeDetalle(HttpServletRequest request,
			@RequestParam("infAutCod") int infAutCod) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			TblInformeAutoridadFin tblInformeAutoridad = new TblInformeAutoridadFin();
			Date fechaRendicion2 = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fechaRendicion"));
			tblInformeAutoridad.setFechaRendicion(fechaRendicion2);
			tblInformeAutoridad.setLugar(request.getParameter("lugar").toUpperCase());
			tblInformeAutoridad.setNumeroAsistentes(Integer.parseInt(request.getParameter("numeroAsistentes")));
			InfoFinG.ActualizarInformeAutoridadFin(tblInformeAutoridad.getFechaRendicion(),
					tblInformeAutoridad.getLugar(), tblInformeAutoridad.getNumeroAsistentes(), infAutCod);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	@RequestMapping(value = { "/obtenerPlanTrabajoFin" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerPlanTrabajoFin(Authentication authentication, @Param(value = "infCod") Integer infCod) {
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		List<TblPlanTrabajoDTO> listaTblPlanTrabajoDTO = new ArrayList<>();
		try {
			List<TblPlanTrabajoFin> RegistrosPlanTrabajo = PlanService.obtenerRegistrosPlanTrabajoAutoridad(infCod);

			listaTblPlanTrabajoDTO = RegistrosPlanTrabajo.stream()
					.map(obj -> TblPlanTrabajoDTO.builder().pltCod(obj.getPltCod())
							.contador(RegistrosPlanTrabajo.indexOf(obj) + 1).pltPlan(obj.getPltPlan())
							.ptlAcciones(obj.getPtlAcciones()).ptlResultados(obj.getPtlResultados())
							.ptlObs(obj.getPtlObs()).build())
					.collect(Collectors.toList());

			json = (!listaTblPlanTrabajoDTO.isEmpty())
					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(listaTblPlanTrabajoDTO) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";
		}
		return json;
	}

	@RequestMapping(value = "/Frm_Plan_trabajo_Autoridad_Fin")
	public String Frm_Plan_trabajo_Autoridad_Fin(Model model, Authentication authentication,
			@RequestParam("elementos") int elementos, @RequestParam("nombreOpcion") String nombreOpcion) {
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("infAutCod", elementos);

		return "gestion/Frm_Plan_trabajo_Autoridad_Fin";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "guardarPlanTrabajoFin")
	public @ResponseBody String guardarPlanTrabajoFin(HttpServletRequest request,
			@RequestParam(value = "infAutCod") Integer infAutCod) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			TblPlanTrabajoFin tblPlanTrabajo = new TblPlanTrabajoFin();
			TblInformeAutoridadFin tblInformeAutoridad = InfoFinG.obtenerRegistroInformexInfocodEstado(infAutCod,
					Constantes.ESTADO);
			tblPlanTrabajo.setInfAutCod(tblInformeAutoridad);
			tblPlanTrabajo.setPltPlan(request.getParameter("pltPlan").toUpperCase()
					.replaceAll(System.getProperty("line.separator"), " "));
			tblPlanTrabajo.setPtlAcciones(request.getParameter("ptlAcciones").toUpperCase()
					.replaceAll(System.getProperty("line.separator"), " "));
			tblPlanTrabajo.setPtlResultados(request.getParameter("ptlResultados").toUpperCase()
					.replaceAll(System.getProperty("line.separator"), " "));
			tblPlanTrabajo.setPtlObs(
					request.getParameter("ptlObs").toUpperCase().replaceAll(System.getProperty("line.separator"), " "));
			PlanService.GuardarPlanTrabajoFin(tblPlanTrabajo);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/actualizarInformeAutoridadAporteFin")
	public @ResponseBody String guardarActualizarAportesCiudadanosAutoridadFin(HttpServletRequest request,
			@RequestParam("infAutCod") int infAutCod) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			TblInformeAutoridadFin tblInformeAutoridad = new TblInformeAutoridadFin();
			tblInformeAutoridad.setInaAportesCiu(request.getParameter("inaAportesCiu").toUpperCase());
			InfoFinG.ActualizarInformeAportes(tblInformeAutoridad.getInaAportesCiu(), infAutCod);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	@RequestMapping(value = "/FrmAportesCiudadanosAutoridadFin")
	public String FrmAportesCiudadanosAutoridadFin(Model model, Authentication authentication,
			@RequestParam("elementos") int elementos, @RequestParam("nombreOpcion") String nombreOpcion) {
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("infAutCod", elementos);

		return "gestion/FrmAportesCiudadanosAutoridadFin";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/eliminarDatos")
	public @ResponseBody String eliminarDatos(Model model, @RequestParam("codigo") int codigo,
			@RequestParam("tabla") String tabla, @RequestParam("campo") String campo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			auis.eliminarTablaCampo(codigo, tabla, campo);

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han Eliminado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/ActualizarDatos", method = RequestMethod.POST)
	public @ResponseBody String ActualizarDatos(HttpServletRequest request, @RequestParam("tabla") String tabla,
			@RequestParam(value = "condicion", required = false) String condicion,
			@RequestParam(value = "values", required = false) String values,
			@RequestParam(value = "columns", required = false) String columns,
			@RequestParam("valorcondicion") String valorcondicion) {
		JSONObject mensaje = new JSONObject();
		String[] arrayColumnas, arrayvalores;
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");

		try {

			arrayColumnas = columns.split(",9");
			arrayvalores = values.split(",9");
			auis.ActualizarTablaCampo(tabla, arrayColumnas, arrayvalores, condicion, valorcondicion);

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@RequestMapping(value = { "/obtenerAportes" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerAportes(Authentication authentication, @Param(value = "infCod") Integer infCod) {
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<TblAportesCiudadanosDTO> listaTblPlanTrabajoDTO = new ArrayList<>();
			List<TblInformeAutoridadFin> registroAportes = InfoFinG.obtenerRegistroInformexAportes(infCod,
					Constantes.ESTADO);
			listaTblPlanTrabajoDTO = registroAportes.stream().map(obj -> TblAportesCiudadanosDTO.builder()
					.infAutCod(obj.getInfAutCod()).aportes(obj.getInaAportesCiu()).build())
					.collect(Collectors.toList());

			json = (!listaTblPlanTrabajoDTO.isEmpty())
					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(listaTblPlanTrabajoDTO) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";
		}
		return json;
	}

	@RequestMapping(value = { "/obtenerRendicion" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerRendicion(Authentication authentication, @Param(value = "infCod") Integer infCod) {
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<RendicionDignidadDTO> listaTblPlanTrabajoDTO = new ArrayList<>();
			List<TblInformeAutoridadFin> registroAportes = InfoFinG.obtenerRegistroInformexAportes(infCod,
					Constantes.ESTADO);
			listaTblPlanTrabajoDTO = registroAportes.stream().map(obj -> RendicionDignidadDTO.builder()
					.infAutCod(obj.getInfAutCod()).proceso(obj.getInaProcesoRc()).build()).collect(Collectors.toList());

			json = (!listaTblPlanTrabajoDTO.isEmpty())
					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(listaTblPlanTrabajoDTO) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";
		}
		return json;
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/actualizarInformeAutoridadRCFin")
	public @ResponseBody String guardarActualizarRendicionAutoridadFin(HttpServletRequest request,
			@RequestParam("infAutCod") int infAutCod) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			TblInformeAutoridadFin tblInformeAutoridad = new TblInformeAutoridadFin();
			tblInformeAutoridad.setInaProcesoRc(request.getParameter("inaProcesoRc").toUpperCase());
			InfoFinG.ActualizarInformeRendicionFin(tblInformeAutoridad.getInaProcesoRc(), infAutCod);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	@RequestMapping(value = { "/obtenerTablaAmecanismosPcFin" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerTablaAmecanismosPcFin(Authentication authentication, @Param(value = "infCod") Integer infCod) {
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		List<TblAmecanismosPcDTO> listaTblAmecanismosPcDTO = new ArrayList<>();
		try {
			List<TblAmecanismosPcFin> RegistrosMecanismosAutoridades = MPCF
					.obtenerRegistrosMecanismosAutoridadesFin(infCod);

			listaTblAmecanismosPcDTO = RegistrosMecanismosAutoridades.stream()
					.map(obj -> TblAmecanismosPcDTO.builder().ame_cod(obj.getAmeCod())
							.contador(RegistrosMecanismosAutoridades.indexOf(obj) + 1).tipo(obj.getAmeTipo())
							.descripcion(obj.getAmeDesc()).medio(obj.getAmeMedio()).build())
					.collect(Collectors.toList());

			json = (!listaTblAmecanismosPcDTO.isEmpty())
					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(listaTblAmecanismosPcDTO) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";
		}
		return json;
	}
	 private List<TblAmecanismosPcFin> lista_ControlSocial= new ArrayList<TblAmecanismosPcFin>();
	@SuppressWarnings("finally")
	@RequestMapping(value = "/guardarAmecanismosPcFin")
	public @ResponseBody String guardarAmecanismosPcFin(HttpServletRequest request,
			@RequestParam(value = "infAutCod") int infAutCod) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			TblInformeAutoridadFin tblInformeAutoridad = InfoFinG.obtenerRegistroInformexInfocodEstado(infAutCod,Constantes.ESTADO);
			  lista_ControlSocial.clear();
			GuardarMecanismoAutoridad(tblInformeAutoridad, "ASAMBLEA LOCAL",request.getParameter("ameDesc1").replaceAll(System.getProperty("line.separator"), " "),request.getParameter("ameMedio1").replaceAll(System.getProperty("line.separator"), " "));
			GuardarMecanismoAutoridad(tblInformeAutoridad, "AUDIENCIA PÚBLICA",request.getParameter("ameDesc2").replaceAll(System.getProperty("line.separator"), " "),request.getParameter("ameMedio2").replaceAll(System.getProperty("line.separator"), " "));
			GuardarMecanismoAutoridad(tblInformeAutoridad, "CABILDO POPULAR",request.getParameter("ameDesc3").replaceAll(System.getProperty("line.separator"), " "),request.getParameter("ameMedio3").replaceAll(System.getProperty("line.separator"), " "));
			GuardarMecanismoAutoridad(tblInformeAutoridad, "CONSEJO DE PLANIFICACIÓN LOCAL",request.getParameter("ameDesc4").replaceAll(System.getProperty("line.separator"), " "),request.getParameter("ameMedio4").replaceAll(System.getProperty("line.separator"), " "));
			GuardarMecanismoAutoridad(tblInformeAutoridad, "OTROS",request.getParameter("ameDesc5").replaceAll(System.getProperty("line.separator"), " "),request.getParameter("ameMedio5").replaceAll(System.getProperty("line.separator"), " "));
			if (lista_ControlSocial.size()==5) {	
				for (TblAmecanismosPcFin item : lista_ControlSocial) {	
					Integer valor=MPCF.CountMPAF(infAutCod, item.getAmeTipo());
					if (valor==0) {
						TblAmecanismosPcFin tblMecanismosContolSocial= new TblAmecanismosPcFin();
						tblMecanismosContolSocial.setInfAutCod(tblInformeAutoridad);
						tblMecanismosContolSocial.setAmeDesc(item.getAmeDesc());			
						tblMecanismosContolSocial.setAmeMedio(item.getAmeMedio());
						tblMecanismosContolSocial.setAmeTipo(item.getAmeTipo());
						MPCF.guardarMecanismosAutoridadesFin(tblMecanismosContolSocial);
					}else {
						TblAmecanismosPcFin tblMecanismosContolSocial= MPCF.obternerMecanismosAutoridadesFin(infAutCod,item.getAmeTipo());
						tblMecanismosContolSocial.setAmeDesc(item.getAmeDesc());			
						tblMecanismosContolSocial.setAmeMedio(item.getAmeMedio());
						tblMecanismosContolSocial.setAmeTipo(item.getAmeTipo());
						MPCF.guardarMecanismosAutoridadesFin(tblMecanismosContolSocial);
					}
				
					
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
	private void GuardarMecanismoAutoridad(TblInformeAutoridadFin tblInforme,String tipo, String seleccion, String link) {
		TblAmecanismosPcFin tblAmecanismosPc = new TblAmecanismosPcFin();
            tblAmecanismosPc.setInfAutCod(tblInforme);
			tblAmecanismosPc.setAmeDesc(seleccion);
			tblAmecanismosPc.setAmeMedio(link);
			tblAmecanismosPc.setAmeTipo(tipo);
        lista_ControlSocial.add(tblAmecanismosPc);
		
	}
	@RequestMapping(value = { "/obtenerTributarioFin" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerTributarioFin(Authentication authentication, @Param(value = "infCod") Integer infCod) {
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<TributarioFinDTO> listaTblPlanTrabajoDTO = new ArrayList<>();
			List<TblInformeAutoridadFin> registroAportes = InfoFinG.obtenerRegistroInformexAportes(infCod,
					Constantes.ESTADO);
			listaTblPlanTrabajoDTO = registroAportes.stream()
					.map(obj -> TributarioFinDTO.builder().infAutCod(obj.getInfAutCod()).tipo("TRIBUTARIAS")
							.opcion(obj.getInfAutTributo()).link(obj.getInfAutMedioTributario()).build())
					.collect(Collectors.toList());

			json = (!listaTblPlanTrabajoDTO.isEmpty())
					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(listaTblPlanTrabajoDTO) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";
		}
		return json;
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/guardarObligacionesAutoridadFin")
	public @ResponseBody String guardarObligacionesAutoridadFin(HttpServletRequest request,
			@RequestParam("infAutCod") int infAutCod) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			TblInformeAutoridadFin tblInformeAutoridad = new TblInformeAutoridadFin();
			tblInformeAutoridad.setInfAutTributo(request.getParameter("infAutTributo"));
			if (tblInformeAutoridad.getInfAutTributo().equals("SI")) {
				tblInformeAutoridad.setInfAutMedioTributario(request.getParameter("infAutMedioTributario"));
			} else {

				tblInformeAutoridad.setInfAutMedioTributario("S/N");
			}

			InfoFinG.ActualizarInformeObligacionesFin(tblInformeAutoridad.getInfAutTributo(),
					tblInformeAutoridad.getInfAutMedioTributario(), infAutCod);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/guardarFuncionesAutoridadesFin")
	public @ResponseBody String guardarFuncionesAutoridadesFin(HttpServletRequest request,
			@RequestParam(value = "infAutCod") Integer infAutCod) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			TblFuncionesAutoridadesFin tblFuncionesAutoridades = new TblFuncionesAutoridadesFin();
			TblInformeAutoridadFin tblInformeAutoridad = InfoFinG.obtenerRegistroInformexInfocodEstado(infAutCod,
					Constantes.ESTADO);
			tblFuncionesAutoridades.setInfAutCod(tblInformeAutoridad);
			tblFuncionesAutoridades.setFaFuncion(request.getParameter("faFuncion").toUpperCase());
			tblFuncionesAutoridades.setFaAcciones(request.getParameter("faAcciones").toUpperCase());
			tblFuncionesAutoridades.setFaResultado(request.getParameter("faResultado").toUpperCase());
			tblFuncionesAutoridades.setFaObs(request.getParameter("faObs").toUpperCase());
			fas.guardarFuncionesAutoridadesFin(tblFuncionesAutoridades);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	@RequestMapping(value = { "/obtenerFuncionesAutoridadesFin" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerFuncionesAutoridades(Authentication authentication, @Param(value = "infCod") Integer infCod) {
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		List<TblFuncionesAutoridadesDTO> listaTblFuncionesAutoridadesDTO = new ArrayList<>();
		try {
			List<TblFuncionesAutoridadesFin> RegistrosFuncionesAutoridades = fas
					.obtenerRegistrosFuncionesAutoridadesFin(infCod);

			listaTblFuncionesAutoridadesDTO = RegistrosFuncionesAutoridades.stream()
					.map(obj -> TblFuncionesAutoridadesDTO.builder().fa_cod(obj.getFaCod())
							.contador(RegistrosFuncionesAutoridades.indexOf(obj) + 1).funcion(obj.getFaFuncion())
							.accion(obj.getFaAcciones()).resultado(obj.getFaResultado())
							.observacion(obj.getFaObs()).build())
					.collect(Collectors.toList());

			json = (!listaTblFuncionesAutoridadesDTO.isEmpty())
					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(listaTblFuncionesAutoridadesDTO) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";
		}
		return json;
	}

	@RequestMapping(value = "/Frm_CumplimientoFunciones_AutoridadFin")
	public String Frm_CumplimientoFunciones_AutoridadFin(Model model, Authentication authentication,
			@RequestParam("elementos") int elementos, @RequestParam("nombreOpcion") String nombreOpcion) {
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("infAutCod", elementos);

		return "gestion/Frm_CumplimientoFunciones_AutoridadFin";
	}

	@RequestMapping(value = "/Frm_Propuestas_AutoridadFin")
	public String Frm_Propuestas_AutoridadFin(Model model, Authentication authentication,
			@RequestParam("elementos") int elementos, @RequestParam("nombreOpcion") String nombreOpcion) {
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("infAutCod", elementos);

		return "gestion/Frm_Propuestas_AutoridadFin";
	}

	@RequestMapping(value = { "/obtenerPropuestasAutoridadFin" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerPropuestasAutoridadFin(Authentication authentication,
			@Param(value = "infCod") Integer infCod) {
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		List<TblPropuestasDTO> listaTblPropuestasDTO = new ArrayList<>();
		try {
			List<TblPropuestasFin> RegistrosPropuestasAutoridad = pas.obtenerRegistrosPropuestasAutoridadesFin(infCod);

			listaTblPropuestasDTO = RegistrosPropuestasAutoridad.stream()
					.map(obj -> TblPropuestasDTO.builder().pro_id(obj.getProId())
							.contador(RegistrosPropuestasAutoridad.lastIndexOf(obj) + 1)
							.descripcion(obj.getProDescripcion()).resultado(obj.getProResultados()).build())
					.collect(Collectors.toList());

			json = (!listaTblPropuestasDTO.isEmpty())
					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(listaTblPropuestasDTO) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";
		}
		return json;
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/guardarPropuestasAutoridadFin")
	public @ResponseBody String guardarPropuestasAutoridadFin(HttpServletRequest request,
			@RequestParam(value = "infAutCod") Integer infAutCod) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			TblPropuestasFin tblPropuestas = new TblPropuestasFin();
			TblInformeAutoridadFin tblInformeAutoridad = InfoFinG.obtenerRegistroInformexInfocodEstado(infAutCod,
					Constantes.ESTADO);
			tblPropuestas.setInfAutCod(tblInformeAutoridad);
			tblPropuestas.setProDescripcion(request.getParameter("proDescripcion").toUpperCase());
			tblPropuestas.setProResultados(request.getParameter("proResultados").toUpperCase());
			pas.guardarPropuestasAutoridadesFin(tblPropuestas);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	@RequestMapping("/FinalizarFinGestion")
	public String FinalizarFinGestion(Model model, Authentication authentication,
			@Param(value = "infCod") Integer infCod) {
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		TblInformeAutoridadFin verificarInforme = InfoFinG.obtenerRegistroInformexInfocodEstado(infCod,
				Constantes.ESTADO);
		if (verificarInforme == null) {
			model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);
		} else {
			TblAutoridad datosAutoridad = autori.buscarAutordadCodAutPeriodo(datosUsuario.getCodigoIntitucionAutorida(),
					datosUsuario.getPeriodo());
			Integer codigoInforme = verificarInforme.getInfAutCod();
			String verificador = verificarFinGestionAutoridad(codigoInforme, Constantes.ESTADO);
			model.addAttribute("infestadoinforme", verificarInforme.getInfAutEstado());
			model.addAttribute("infAutCod", verificarInforme.getInfAutCod());
			model.addAttribute("infAutPeriodo", verificarInforme.getInfAutPeriodo());
			model.addAttribute("infAutEstado", verificarInforme.getInfAutEstado());
			model.addAttribute("nombreAutoridad", datosAutoridad.getNombre());
			model.addAttribute("identificadorAutoridad", datosAutoridad.getIdentificador());
			model.addAttribute("institucionDignidad", datosAutoridad.getInstitucionDignidad());
			model.addAttribute("dignidad", datosAutoridad.getDignidad());
			model.addAttribute("ambito", datosAutoridad.getAmbito());
			model.addAttribute("periodo", datosAutoridad.getPeriodo());
			if (verificador.equals("completo") && !verificarInforme.getInfAutEstado().trim().equals("finalizado")) {
				model.addAttribute("inf_estado", "completo");
			} else {
				model.addAttribute("inf_estado", verificarInforme.getInfAutEstado());

				model.addAttribute("mensaje", verificador);

			}
		}
		return "rendicion/Frm_Finalizar_Informe_Autoridad";
	}
	@RequestMapping(value = "/verificarFinGestionAutoridad")
	public @ResponseBody String verificarFinGestionAutoridad(@RequestParam(value = "infCod") Integer infCod,  @RequestParam(value = "estado") String estado) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		String resultado="";
	
		try {
			String verificaInfAut = InfoFinG.listar(infCod, estado);
			Integer contador = verificaInfAut.length();
			if (contador==20) {
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
	@RequestMapping(value = "/FinalizarInformeAutoridadFin")
	public @ResponseBody String FinalizarInformeAutoridadFin(Authentication authentication,@RequestParam(value = "infAutCod") Integer infAutCod
			) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			TblInformeAutoridadFin verificarInforme = InfoFinG.obtenerRegistroInformexInfocodEstado(infAutCod,
					Constantes.ESTADO);
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblAutoridad datosAutoridad = autori.buscarAutordadCodAutPeriodo(datosUsuario.getCodigoIntitucionAutorida(), datosUsuario.getPeriodo());
			String tipo = "AutoridadFinGestionRC";
			if (verificarInforme==null) {
				
				mensaje.put("estado", "error");
				mensaje.put("mensaje", "No hay informe!");
			}else {
				
				Date infAutFechafin = new Date();
				DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				
				InfoFinG.finalizarInforme(infAutCod, Constantes.ESTADO_INFORME_FINALIZADO, infAutFechafin, Constantes.ESTADO_INFORME_A_TIEMPO);
				TblFinGestion informeFin = gestion.FinGestioInfoCod(infAutCod);
				informeFin.setEstado(Constantes.ESTADO_INFORME_FINALIZADO);
				informeFin.setFechaFin(infAutFechafin);
				gestion.GuardarFinGestio(informeFin);
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");	
				
			}
			TblInformeAutoridadFin verificarInformeFinalizado = InfoFinG.obtenerRegistroInformexInfocodEstado(infAutCod,Constantes.ESTADO_INFORME_FINALIZADO);

			if (verificarInformeFinalizado.getInfAutEstado().trim().equals(Constantes.ESTADO_INFORME_FINALIZADO)) {
				
				ms.mailFinalziarInforme(datosUsuario.getEmail(), datosUsuario.getNombre(), datosUsuario.getIdentificador(), verificarInformeFinalizado.getInfAutFechafin(), verificarInformeFinalizado.getInfAutVerificador(), tipo, true);
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
