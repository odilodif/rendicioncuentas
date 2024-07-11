package gob.cpccs.controller.rendicion;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.convert.converters.StringToBigInteger;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gob.cpccs.model.aplicacion.TblAplicacionesRegistradas;
import gob.cpccs.model.catalogos.TblFuncion;
import gob.cpccs.model.catalogos.TblInstitucion;
import gob.cpccs.model.catalogos.TblLocalizacion;
import gob.cpccs.model.catalogos.TblTipoInforme;
import gob.cpccs.model.dto.catalogos.SeguimientoInstitucionDTO;
import gob.cpccs.model.funcionarios.TblDatosFuncionarios;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.retroalimentacion.TblAsignacion;
import gob.cpccs.model.retroalimentacion.TblInformeCalificado;
import gob.cpccs.model.retroalimentacion.TblValoracion;
import gob.cpccs.model.dto.catalogos.IntitucionDTO;
import gob.cpccs.model.seguridad.TblHistoricoInstituciones;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.repository.catalogos.InstitucionesServicioRepository;
import gob.cpccs.service.AsginacionInformesService;
import gob.cpccs.service.GraficaService;
import gob.cpccs.service.catalogos.CatalogosServicio;
import gob.cpccs.service.rendicion.InformeServicio;
import gob.cpccs.service.retroalimentacion.AsignacionServicio;
import gob.cpccs.service.retroalimentacion.InformeCalificacionService;
import gob.cpccs.service.retroalimentacion.InformeValoradoService;
import gob.cpccs.service.tecnico.TecnicoServicio;
import gob.cpccs.service.usuario.DatosFuncionariosService;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;
import gob.cpccs.utilidades.EncriptarContrasenia;

@Controller
@ControllerAdvice
public class RetroalimentacionController {

	@Autowired
	private CatalogosServicio gcs;

	@Autowired
	private AsginacionInformesService ais;

	@Autowired
	private TecnicoServicio ts;

	@Autowired
	private UsuarioServicio us;

	@Autowired
	private AsignacionServicio as;

	@Autowired
	private GraficaService grafica;

	@Autowired
	private InformeServicio is;

	@Autowired
	private InformeCalificacionService ics;

	@Autowired
	private InformeValoradoService ivs;
	@Autowired
	private DatosFuncionariosService UsuInterno;
	@Autowired
	private InstitucionesServicioRepository instserv;

	int i = 0;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// @ModelAttribute
	@GetMapping("/checkInformeCalificado")
	public @ResponseBody TblInformeCalificado checkInformeCalificado(@RequestParam("infCod") Integer infCod,
			@RequestParam(value = "idInforme", required = false) Integer idInforme) {
		if (idInforme != null) {
			return ics.ObtenerListaPregunstas(infCod).stream()
					.filter(informe -> informe.getIdInfCal().equals(idInforme))
					// .peek(System.out::println)
					.collect(Collectors.toList()).get(0);
		} else {
			return new TblInformeCalificado();
		}
	}

	@GetMapping("checkInformeCalificado1")
	public @ResponseBody TblInformeCalificado checkInformeCalificado1(Integer infCod, Integer idInforme) {
		if (idInforme != null) {
			return ics.ObtenerListaPregunstas(infCod).stream()
					.filter(informe -> informe.getIdInfCal().equals(idInforme))
					// .peek(System.out::println)
					.collect(Collectors.toList()).get(0);
		} else {
			return null;
		}
	}

	@GetMapping("ObtenerPreguntas")
	@ResponseBody
	public String ObtenerPreguntas(@RequestParam("infCod") Integer infCod) {
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<TblInformeCalificado> calificacionesInforme = ics.ObtenerListaPregunstas(infCod);
			json = (!calificacionesInforme.isEmpty())
					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(calificacionesInforme) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";

		}

		return json;

	}

	@GetMapping("ObtenerPreguntasOrden")
	@ResponseBody
	public String ObtenerPreguntasOrden(@RequestParam("infCod") Integer infCod) {
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<TblInformeCalificado> calificacionesInforme = ics.ObtenerListaPregunstasorden(infCod);
			json = (!calificacionesInforme.isEmpty())
					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(calificacionesInforme) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";

		}
		return json;

	}

	@RequestMapping("/view/rendicion/AsignacionInformes")
	public String AsignacionInformes(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);
		model.addAttribute("asignador", datosUsuario.getIdentificador());
		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacion(1, "activo");
		model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);

		/*
		 * List<TblFuncion> listaFuncion = gcs.obtenerFuncionInstitucion("activo");
		 * model.addAttribute("listadoFunciones", listaFuncion);
		 */
		List<TblDatosFuncionarios> listaTecnicos = ts.obtenerTecnicos(Constantes.ESTADO_ACTIVO_USUARIOS.toString(),
				"SUBCOORDINADOR");
		model.addAttribute("listaTecnicos", listaTecnicos);

		return "rendicion/AsignacionInformes";
	}

	@RequestMapping(value = "/view/rendicion/postJSONBuscar", method = RequestMethod.POST)
	public @ResponseBody String postJSONBuscar(Model model, @RequestParam("provincia") String provincia,
			@RequestParam("periodo") String periodo, @RequestParam("funcion") String funcion,
			@RequestParam("descripcion") String descripcion) {
		String funciones = "";
		String datos = "0";
		if (funcion.equals("TODOS")) {
			datos = ais.qryContarInformesTodos(provincia, periodo).get(0).toString();
		} else {
			if (descripcion.equals("TODOS")) {
				switch (funcion) {
				/*
				 * case "TODAS FUNCIONES Y OTRA INSTITUCIONALIDAD": funciones =
				 * ("1,2,3,4,5,12"); datos = ais.qryContarInformesSinDescripcion(provincia,
				 * periodo, funciones).get(0).toString(); break;
				 */
				case "TODAS FUNCIONES":
					funciones = ("1,2,3,4,5");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "TODOS GAD":
					funciones = ("8,9,10");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "TODOS LOS GAD PARROQUIALES":
					funciones = ("10");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "TODOS LOS GAD MUNICIPALES":
					funciones = ("8");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "TODOS LOS GAD PROVINCIALES":
					funciones = ("9");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "TODAS LAS ASOCIACIONES GAD":
					funciones = ("11");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "TODAS LAS INSTITUCIONES DE EDUCACIÓN SUPERIOR":
					funciones = ("7");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "TODOS LOS MEDIOS DE COMUNICACIÓN":
					funciones = ("6");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "FUNCIÓN JUDICIAL":
					funciones = ("1");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "FUNCIÓN ELECTORAL":
					funciones = ("2");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "FUNCIÓN LEGISLATIVA":
					funciones = ("3");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "FUNCIÓN DE TRANSPARENCIA":
					funciones = ("4");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "FUNCIÓN EJECUTIVA":
					funciones = ("5");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "MEDIOS DE COMUNICACIÓN":
					funciones = ("6");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "INSTITUCIONES DE EDUCACIÓN SUPERIOR":
					funciones = ("7");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "GAD MUNICIPAL":
					funciones = ("8");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "GAD PROVINCIAL":
					funciones = ("9");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "GAD PARROQUIAL":
					funciones = ("10");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "ASOCIACIONES GADS":
					funciones = ("11");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				case "OTRAS INSTITUCIONES DEL ESTADO":
					funciones = ("12");
					datos = ais.qryContarInformesSinDescripcion(provincia, periodo, funciones).get(0).toString();
					break;
				}
			} else {
				switch (funcion) {
				case "TODAS FUNCIONES":
					funciones = ("1,2,3,4,5");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "TODOS GAD":
					funciones = ("8,9,10");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "TODOS LOS GAD PARROQUIALES":
					funciones = ("10");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "TODOS LOS GAD MUNICIPALES":
					funciones = ("8");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "TODOS LOS GAD PROVINCIALES":
					funciones = ("9");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "TODAS LAS ASOCIACIONES GAD":
					funciones = ("11");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "TODAS LAS INSTITUCIONES DE EDUCACIÓN SUPERIOR":
					funciones = ("7");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "TODOS LOS MEDIOS DE COMUNICACIÓN":
					funciones = ("6");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "FUNCIÓN JUDICIAL":
					funciones = ("1");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "FUNCIÓN ELECTORAL":
					funciones = ("2");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "FUNCIÓN LEGISLATIVA":
					funciones = ("3");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "FUNCIÓN DE TRANSPARENCIA":
					funciones = ("4");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "FUNCIÓN EJECUTIVA":
					funciones = ("5");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "MEDIOS DE COMUNICACIÓN":
					funciones = ("6");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "INSTITUCIONES DE EDUCACIÓN SUPERIOR":
					funciones = ("7");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "GAD MUNICIPAL":
					funciones = ("8");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "GAD PROVINCIAL":
					funciones = ("9");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "GAD PARROQUIAL":
					funciones = ("10");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "ASOCIACIONES GADS":
					funciones = ("11");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				case "OTRAS INSTITUCIONES DEL ESTADO":
					funciones = ("12");
					datos = ais.qryContarInformesTodosFuncion(provincia, periodo, funciones, descripcion).get(0)
							.toString();
					break;
				}
			}
		}
		return datos;
	}

	@RequestMapping(value = "/view/rendicion/postJSONAsignacion", method = RequestMethod.POST)
	public @ResponseBody List postJSONAsignacion(Model model, @RequestParam("provincia") String provincia,
			@RequestParam("periodo") String periodo, @RequestParam("funcion") String funcion,
			@RequestParam("descripcion") String descripcion, @RequestParam("tecnico") String tecnico,
			@RequestParam("asignador") String asignador) {
		List<Object[]> datos = null;
		String funciones = "";

		if (funcion.equals("TODOS")) {
			datos = ais.qryBuscarInformesTodos(provincia, periodo); // ticket 1552, se agrega clausula a los querys para
																	// no contar ni buscar si ya estan calificados

		} else {

			if (descripcion.equals("TODOS")) {
				switch (funcion) {
				/*
				 * case "TODAS FUNCIONES Y OTRA INSTITUCIONALIDAD": funciones =
				 * ("1,2,3,4,5,12"); datos = ais.qryBuscarInformesSinDescripcion(provincia,
				 * periodo, funciones);
				 * 
				 * break;
				 */
				case "TODAS FUNCIONES":
					funciones = ("1,2,3,4,5");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);

					break;
				case "TODOS GAD":
					funciones = ("8,9,10");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "TODOS LOS GAD PARROQUIALES":
					funciones = ("10");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "TODOS LOS GAD MUNICIPALES":
					funciones = ("8");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "TODOS LOS GAD PROVINCIALES":
					funciones = ("9");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "TODAS LAS ASOCIACIONES GAD":
					funciones = ("11");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "TODAS LAS INSTITUCIONES DE EDUCACIÓN SUPERIOR":
					funciones = ("7");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "TODOS LOS MEDIOS DE COMUNICACIÓN":
					funciones = ("6");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "FUNCIÓN JUDICIAL":
					funciones = ("1");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "FUNCIÓN ELECTORAL":
					funciones = ("2");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "FUNCIÓN LEGISLATIVA":
					funciones = ("3");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "FUNCIÓN DE TRANSPARENCIA":
					funciones = ("4");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "FUNCIÓN EJECUTIVA":
					funciones = ("5");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "MEDIOS DE COMUNICACIÓN":
					funciones = ("6");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "INSTITUCIONES DE EDUCACIÓN SUPERIOR":
					funciones = ("7");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "GAD MUNICIPAL":
					funciones = ("8");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "GAD PROVINCIAL":
					funciones = ("9");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "GAD PARROQUIAL":
					funciones = ("10");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "ASOCIACIONES GADS":
					funciones = ("11");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				case "OTRAS INSTITUCIONES DEL ESTADO":
					funciones = ("12");
					datos = ais.qryBuscarInformesSinDescripcion(provincia, periodo, funciones);
					break;
				}
			} else {

				switch (funcion) {
				/*
				 * case "TODAS FUNCIONES Y OTRA INSTITUCIONALIDAD": funciones =
				 * ("1,2,3,4,5,12"); datos = ais.qryBuscarInformesTodosFuncion(provincia,
				 * periodo, funciones, descripcion); break;
				 */
				case "TODAS FUNCIONES":
					funciones = ("1,2,3,4,5");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "TODOS GAD":
					funciones = ("8,9,10");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "TODOS LOS GAD PARROQUIALES":
					funciones = ("10");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "TODOS LOS GAD MUNICIPALES":
					funciones = ("8");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "TODOS LOS GAD PROVINCIALES":
					funciones = ("9");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "TODAS LAS ASOCIACIONES GAD":
					funciones = ("11");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "TODAS LAS INSTITUCIONES DE EDUCACIÓN SUPERIOR":
					funciones = ("7");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "TODOS LOS MEDIOS DE COMUNICACIÓN":
					funciones = ("6");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "FUNCIÓN JUDICIAL":
					funciones = ("1");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "FUNCIÓN ELECTORAL":
					funciones = ("2");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "FUNCIÓN LEGISLATIVA":
					funciones = ("3");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "FUNCIÓN DE TRANSPARENCIA":
					funciones = ("4");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "FUNCIÓN EJECUTIVA":
					funciones = ("5");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "MEDIOS DE COMUNICACIÓN":
					funciones = ("6");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "INSTITUCIONES DE EDUCACIÓN SUPERIOR":
					funciones = ("7");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "GAD MUNICIPAL":
					funciones = ("8");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "GAD PROVINCIAL":
					funciones = ("9");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "GAD PARROQUIAL":
					funciones = ("10");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "ASOCIACIONES GADS":
					funciones = ("11");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				case "OTRAS INSTITUCIONES DEL ESTADO":
					funciones = ("12");
					datos = ais.qryBuscarInformesTodosFuncion(provincia, periodo, funciones, descripcion);
					break;
				}

			}
		}

		if (datos.size() == 0) {

		} else {

			for (int i = 0; i < datos.size(); i++) {
				TblAsignacion tblAsignacion = new TblAsignacion();
				tblAsignacion.setInfCod(Integer.parseInt(datos.get(i)[2].toString()));
				tblAsignacion.setInstCod(Integer.parseInt(datos.get(i)[0].toString()));
				tblAsignacion.setPeriodoAsig(Integer.parseInt(periodo));
				tblAsignacion.setFechaAsig(new Date());
				tblAsignacion.setComentarioAsig("Para su revisión");
				tblAsignacion.setIdentificador(tecnico);
				tblAsignacion.setAsignador(asignador);
				tblAsignacion.setEstadoAsig(Constantes.ESTADO_ASIGNADO);
				as.guardarAsignacion(tblAsignacion);
			}
		}

		return datos;
	}

	/*
	 * @RequestMapping(value = { "/GraficaAsignacionInformeTecnico" }, method =
	 * RequestMethod.POST)
	 * 
	 * @ResponseBody public String GraficaAsignacionInformeTecnico(Authentication
	 * authentication) { String json; try { StringBuilder resultado = new
	 * StringBuilder(); List<Object[]> listaRegistros =
	 * grafica.ReporteGraficaInformesAsinados("2021"); if (listaRegistros.size() >
	 * 0) { for (Object[] datos : listaRegistros) { resultado.append("{\"fecha\":\""
	 * + datos[0] + "\",\"" + "cumplido\":\"" + datos[1] + "\",\"" +
	 * "incumplido\":\"" + datos[2] + "\"}").append(","); } json = "[" +
	 * resultado.toString().substring(0, resultado.toString().length() - 1) + "]";
	 * 
	 * } else { json = "[0, 0, 0]";
	 * 
	 * } } catch (Exception e) { json = "{\"error\" : \"true\", \"message\": " +
	 * "ERROR:--> " + e.getMessage() + "}"; } return json; }
	 */
	@RequestMapping(value = { "/GraficaAsignacionInformeTecnico" }, method = RequestMethod.POST)
	@ResponseBody
	public String GraficaAsignacionInformeTecnico(@RequestParam("year") String year, Authentication authentication) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
			List<Object[]> listaRegistros = grafica.ReporteGraficaInformesAsinados(year);// por año de seleccion, ticket
																							// 1552
			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					resultado.append("{\"fecha\":\"" + datos[0] + "\",\"" + "cumplido\":\"" + datos[1] + "\",\""
							+ "incumplido\":\"" + datos[2] + "\"}").append(",");
				}
				json = "[" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]";
			} else {
				json = "[0, 0, 0]";
			}
		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
		}
		return json;
	}

	/*
	 * @RequestMapping(value = "/view/rendicion/valoracionInformeFE", method =
	 * RequestMethod.POST) public String valoracionInformeFE(Model model,
	 * Authentication authentication,
	 * 
	 * @RequestParam("id") String infcodPeriodo) { // separamos id y periodo
	 * String[] parts = infcodPeriodo.split("-");
	 * 
	 * System.out.println(Arrays.toString(parts) );
	 * 
	 * Integer infcod = Integer.parseInt(parts[0]); // id del informe Integer
	 * periodo = Integer.parseInt(parts[1]); // periodo model.addAttribute("email",
	 * authentication.getName()); List<Object[]> datosInstitucion =
	 * is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo); TblUsuario
	 * datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(),
	 * Constantes.periodo()); model.addAttribute("periodoInforme", periodo);
	 * model.addAttribute("identificadorResponsable",
	 * datosUsuarioInterno.getIdentificador()); model.addAttribute("infcod",
	 * datosInstitucion.get(0)[0].toString());
	 * model.addAttribute("nombreInstitución",
	 * datosInstitucion.get(0)[1].toString());
	 * model.addAttribute("identificadorInstitucion",
	 * datosInstitucion.get(0)[2].toString());
	 * model.addAttribute("representanteLegal",
	 * datosInstitucion.get(0)[3].toString());
	 * model.addAttribute("funcionInstitucion",
	 * datosInstitucion.get(0)[4].toString());
	 * model.addAttribute("descripcionInstitucion",
	 * datosInstitucion.get(0)[5].toString());
	 * model.addAttribute("sectorInstitucion",
	 * datosInstitucion.get(0)[6].toString()); model.addAttribute("tipoFormulario",
	 * datosInstitucion.get(0)[7].toString()); model.addAttribute("fecha",
	 * datosInstitucion.get(0)[8].toString()); model.addAttribute("estado",
	 * datosInstitucion.get(0)[9].toString());
	 * model.addAttribute("periodoSeleccionado",periodo); return
	 * "rendicion/valoracionInformeFE"; }
	 */

	/*
	 * @RequestMapping(value = "/view/rendicion/valoracionInformeGAD", method =
	 * RequestMethod.POST) public String valoracionInformeGAD(Model model,
	 * Authentication authentication,
	 * 
	 * @RequestParam("id") String infcodPeriodo) { // separamos id y periodo
	 * String[] parts = infcodPeriodo.split("-"); Integer infcod =
	 * Integer.parseInt(parts[0]); // id del informe Integer periodo =
	 * Integer.parseInt(parts[1]); // periodo model.addAttribute("email",
	 * authentication.getName()); List<Object[]> datosInstitucion =
	 * is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo); TblUsuario
	 * datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(),
	 * Constantes.periodo()); model.addAttribute("periodoInforme", periodo);
	 * model.addAttribute("identificadorResponsable",
	 * datosUsuarioInterno.getIdentificador()); model.addAttribute("infcod",
	 * datosInstitucion.get(0)[0].toString());
	 * model.addAttribute("nombreInstitución",
	 * datosInstitucion.get(0)[1].toString());
	 * model.addAttribute("identificadorInstitucion",
	 * datosInstitucion.get(0)[2].toString());
	 * model.addAttribute("representanteLegal",
	 * datosInstitucion.get(0)[3].toString());
	 * model.addAttribute("funcionInstitucion",
	 * datosInstitucion.get(0)[4].toString());
	 * model.addAttribute("descripcionInstitucion",
	 * datosInstitucion.get(0)[5].toString());
	 * model.addAttribute("sectorInstitucion",
	 * datosInstitucion.get(0)[6].toString()); model.addAttribute("tipoFormulario",
	 * datosInstitucion.get(0)[7].toString()); model.addAttribute("fecha",
	 * datosInstitucion.get(0)[8].toString()); model.addAttribute("estado",
	 * datosInstitucion.get(0)[9].toString()); return
	 * "rendicion/valoracionInformeGAD"; }
	 */

	@RequestMapping(value = "/view/rendicion/valoracion/InformeFEEPValorado", method = RequestMethod.POST)
	public String InformeFEEPValorado(Model model, Authentication authentication,
			@RequestParam("id") String infcodPeriodo) {
		// separamos id y periodo
		String[] parts = infcodPeriodo.split("-");
		Integer infcod = Integer.parseInt(parts[0]); // id del informe
		Integer periodo = Integer.parseInt(parts[1]), orden; // periodo
		model.addAttribute("email", authentication.getName());

		List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
		TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("identificadorResponsable", datosUsuarioInterno.getIdentificador());
		model.addAttribute("infcod", datosInstitucion.get(0)[0].toString());
		model.addAttribute("nombreInstitución", datosInstitucion.get(0)[1].toString());
		model.addAttribute("identificadorInstitucion", datosInstitucion.get(0)[2].toString());
		model.addAttribute("representanteLegal", datosInstitucion.get(0)[3].toString());
		model.addAttribute("funcionInstitucion", datosInstitucion.get(0)[4].toString());
		model.addAttribute("descripcionInstitucion", datosInstitucion.get(0)[5].toString());
		model.addAttribute("sectorInstitucion", datosInstitucion.get(0)[6].toString());
		model.addAttribute("tipoFormulario", datosInstitucion.get(0)[7].toString());
		model.addAttribute("fecha", dateFormat.format(datosInstitucion.get(0)[8]));
		model.addAttribute("estado", datosInstitucion.get(0)[9]);

		List<Object[]> calificacionesInforme = ics.qryBuscarCalifiaccionesInformeOrden(infcod);
		for (Object[] objects : calificacionesInforme) {
			orden = (Integer) objects[6];
			switch (orden) {
			case 1:
				model.addAttribute("respuesta1", objects[4] == null ? "" : objects[4].toString());
				break;
			case 2:
				model.addAttribute("respuesta2", objects[4].toString());
				model.addAttribute("archivoRespaldo1", objects[5] == null ? "" : objects[5].toString());
				break;
			case 3:
				model.addAttribute("respuesta3", objects[4].toString());
				model.addAttribute("archivoRespaldo2", objects[5] == null ? "" : objects[5].toString());
				break;
			case 4:
				model.addAttribute("respuesta4", objects[4].toString());
				model.addAttribute("archivoRespaldo3", objects[5] == null ? "" : objects[5].toString());
				break;
			case 5:
				model.addAttribute("respuesta5", objects[4].toString());
				model.addAttribute("archivoRespaldo4", objects[5] == null ? "" : objects[5].toString());
				break;
			case 6:
				model.addAttribute("respuesta6", objects[4].toString());
				model.addAttribute("archivoRespaldo5", objects[5] == null ? "" : objects[5].toString());
				break;
			case 7:
				model.addAttribute("respuesta7", objects[4].toString());
				model.addAttribute("archivoRespaldo6", objects[5] == null ? "" : objects[5].toString());
				break;
			case 8:
				model.addAttribute("respuesta8", objects[4].toString());
				model.addAttribute("archivoRespaldo7", objects[5] == null ? "" : objects[5].toString());
				break;
			case 9:
				model.addAttribute("respuesta9", objects[4].toString());
				model.addAttribute("archivoRespaldo8", objects[5] == null ? "" : objects[5].toString());
				break;
			case 10:
				model.addAttribute("respuesta10", objects[4].toString());
				model.addAttribute("archivoRespaldo9", objects[5] == null ? "" : objects[5].toString());
				break;
			case 11:
				model.addAttribute("respuesta11", objects[4].toString());
				break;
			case 12:
				model.addAttribute("respuesta12", objects[4].toString());
				break;
			case 13:
				model.addAttribute("respuesta13", objects[4].toString());
				break;
			case 14:
				model.addAttribute("respuesta14", objects[4].toString());
				break;
			case 15:
				model.addAttribute("respuesta15", objects[4].toString());
				break;
			case 16:
				model.addAttribute("respuesta16", objects[4].toString());
				break;
			}
		}

		List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
		model.addAttribute("comentario",
				(datosInformeValorado.get(0)[4] != null ? datosInformeValorado.get(0)[4].toString() : ""));
		model.addAttribute("fechaValoracion", dateFormat.format(datosInformeValorado.get(0)[1]));

		return "rendicion/InformeFEEPValorado";
	}

	@RequestMapping("/view/rendicion/listaInformesAsigandos")
	public String listaInformesAsigandos(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);
		model.addAttribute("anioActual", anio);
		model.addAttribute("email", authentication.getName());
		model.addAttribute("anio", "2020");
		return "rendicion/listaInformesAsigandos";
	}

	@RequestMapping(value = { "/obtenerRegistrosInformesAsignados" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerRegistrosInformesAsignados(Authentication authentication,
			@RequestParam("estado") String estado, @RequestParam("periodo") String periodo) {
		String json;
		// List<Object[]> listaRegistros = new ArrayList<>();
		List<SeguimientoInstitucionDTO> listaDto = new ArrayList<>();

		try {
			ObjectMapper mapper = new ObjectMapper();
			TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			List<Object[]> listaRegistros = (Constantes.hasRole("ROLE_SUBCOORDINADOR")
					|| Constantes.hasRole("ROLE_ADMIN"))
							? ais.qryBuscarInformesAsignadosxSubcoordinador(periodo, estado)
							: ais.qryBuscarInformesAsignadosxtecnico(datosUsuario.getIdentificador(), periodo, estado);
			// Integer contador=0;
			if (listaRegistros.size() > 0) {
				listaDto = listaRegistros.stream()
						.map(obj -> SeguimientoInstitucionDTO.builder().inf_cod((Integer) obj[0])
								.contador(listaRegistros.indexOf(obj) + 1).inst_nom(obj[1].toString())
								.inst_ruc(obj[2].toString()).fecha(obj[3].toString()).asigandor(obj[4].toString())
								.asignado(obj[7].toString()).estado(obj[5].toString()).nota(obj[7].toString())
								.informe(obj[6].toString())
								// .inf_fechafin(obj[8] == null ? "NO VALORADO" : obj[8].toString()) //cambio
								// por ticket 1551
								.inf_fechafin(obj.length > 8 && obj[8] != null ? obj[8].toString() : "NO VALORADO")
								.build())
						.collect(Collectors.toList());
				json = (!listaDto.isEmpty()) ? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(listaDto) + "}"
						: Constantes.MESSAGE_EMPTY_JSON;
			} else {
				json = "{\"data\": []}";
			}

			/*
			 * if (listaRegistros.size() > 0) { for (Object[] datos : listaRegistros) {
			 * resultado .append("{\"inf_cod\":\"" + datos[0] + "\",\"" + "contador\":\"" +
			 * (listaRegistros.indexOf(datos) + 1) + "\",\"" + "numero_informe\":\"" +
			 * datos[0] + "\",\"" + "nombre\":\"" +
			 * (datos[1].toString().replaceAll(Constantes.CADENA1,
			 * Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2,
			 * Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)) +
			 * "\",\"" + "ruc\":\"" + (datos[2]) + "\",\"" + "fecha\":\"" + datos[3] +
			 * "\",\"" + "asigandor\":\"" + datos[4] + "\",\"" + "asignado\":\"" + datos[7]
			 * + "\",\"" + "estado\":\"" + datos[5] + "\",\"" + "informe\":\"" + datos[6] +
			 * "\"}") .append(","); } json = "{\"data\": [" +
			 * resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			 * } else { json = "{\"data\": []}"; }
			 */
		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}
		return json;
	}

	@RequestMapping("/view/rendicion/listaInformesValorados")
	public String listaInformesValorados(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);
		model.addAttribute("anioActual", anio);
		model.addAttribute("email", authentication.getName());
		model.addAttribute("anio", "2020");
		return "rendicion/listaInformesValorados";
	}

	@RequestMapping(value = "/view/rendicion/valoracion/InformeGADEPValorado", method = RequestMethod.POST)
	public String InformeGADEPValorado(Model model, Authentication authentication,
			@RequestParam("id") String infcodPeriodo) {
		// separamos id y periodo
		String[] parts = infcodPeriodo.split("-");
		Integer infcod = Integer.parseInt(parts[0]); // id del informe
		Integer periodo = Integer.parseInt(parts[1]); // periodo
		model.addAttribute("email", authentication.getName());
		List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
		TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("identificadorResponsable", datosUsuarioInterno.getIdentificador());
		model.addAttribute("infcod", datosInstitucion.get(0)[0].toString());
		model.addAttribute("nombreInstitución", datosInstitucion.get(0)[1].toString());
		model.addAttribute("identificadorInstitucion", datosInstitucion.get(0)[2].toString());
		model.addAttribute("representanteLegal", datosInstitucion.get(0)[3].toString());
		model.addAttribute("funcionInstitucion", datosInstitucion.get(0)[4].toString());
		model.addAttribute("descripcionInstitucion", datosInstitucion.get(0)[5].toString());
		model.addAttribute("sectorInstitucion", datosInstitucion.get(0)[6].toString());
		model.addAttribute("tipoFormulario", datosInstitucion.get(0)[7].toString());
		model.addAttribute("fecha", dateFormat.format(datosInstitucion.get(0)[8]));
		model.addAttribute("estado", datosInstitucion.get(0)[9].toString());
		model.addAttribute("periodoInforme", periodo);

		List<Object[]> calificacionesInforme = ics.qryBuscarCalifiaccionesInforme(infcod);

		model.addAttribute("respuesta1", calificacionesInforme.get(0)[2].toString());
		model.addAttribute("respuesta2", calificacionesInforme.get(1)[2].toString());
		model.addAttribute("archivoRespaldo1",
				calificacionesInforme.get(1)[3] == null ? "" : calificacionesInforme.get(1)[3].toString());
		model.addAttribute("respuesta3", calificacionesInforme.get(2)[2].toString());
		model.addAttribute("archivoRespaldo2",
				calificacionesInforme.get(2)[3] == null ? "" : calificacionesInforme.get(2)[3].toString());
		model.addAttribute("respuesta4", calificacionesInforme.get(3)[2].toString());
		model.addAttribute("archivoRespaldo3",
				calificacionesInforme.get(3)[3] == null ? "" : calificacionesInforme.get(3)[3].toString());
		model.addAttribute("respuesta5", calificacionesInforme.get(4)[2].toString());
		model.addAttribute("respuesta6", calificacionesInforme.get(5)[2].toString());
		model.addAttribute("archivoRespaldo4",
				calificacionesInforme.get(5)[3] == null ? "" : calificacionesInforme.get(5)[3].toString());
		model.addAttribute("respuesta7", calificacionesInforme.get(6)[2].toString());
		model.addAttribute("archivoRespaldo5",
				calificacionesInforme.get(6)[3] == null ? "" : calificacionesInforme.get(6)[3].toString());

		model.addAttribute("respuesta8", calificacionesInforme.get(7)[2].toString());
		model.addAttribute("respuesta9", calificacionesInforme.get(8)[2].toString());
		model.addAttribute("respuesta10", calificacionesInforme.get(9)[2].toString());
		model.addAttribute("respuesta11", calificacionesInforme.get(10)[2].toString());
		model.addAttribute("respuesta12", calificacionesInforme.get(11)[2].toString());
		model.addAttribute("archivoRespaldo6",
				calificacionesInforme.get(11)[3].toString() == null ? "" : calificacionesInforme.get(11)[3].toString());

		model.addAttribute("respuesta13", calificacionesInforme.get(12)[2].toString());
		model.addAttribute("archivoRespaldo7",
				calificacionesInforme.get(12)[3] == null ? "" : calificacionesInforme.get(12)[3].toString());

		model.addAttribute("respuesta14", calificacionesInforme.get(13)[2].toString());
		model.addAttribute("archivoRespaldo8",
				calificacionesInforme.get(13)[3] == null ? "" : calificacionesInforme.get(13)[3].toString());

		model.addAttribute("respuesta15", calificacionesInforme.get(14)[2].toString());
		model.addAttribute("respuesta16", calificacionesInforme.get(15)[2].toString());
		model.addAttribute("respuesta17", calificacionesInforme.get(16)[2].toString());
		model.addAttribute("respuesta18", calificacionesInforme.get(17)[2].toString());
		model.addAttribute("respuesta19", calificacionesInforme.get(18)[2].toString());
		model.addAttribute("archivoRespaldo9",
				calificacionesInforme.get(18)[3] == null ? "" : calificacionesInforme.get(18)[3].toString());

		List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
		model.addAttribute("comentario",
				datosInformeValorado.get(0)[4] == null ? null : datosInformeValorado.get(0)[4].toString());
		model.addAttribute("fechaValoracion", dateFormat.format(datosInformeValorado.get(0)[1]));

		return "rendicion/InformeGADEPValorado";
	}

	@RequestMapping(value = "/view/rendicion/valoracion/InformeGADValorado", method = RequestMethod.POST)
	public String InformeGADValorado(Model model, Authentication authentication,
			@RequestParam("id") String infcodPeriodo) {
		// separamos id y periodo
		String[] parts = infcodPeriodo.split("-");
		Integer infcod = Integer.parseInt(parts[0]); // id del informe
		Integer periodo = Integer.parseInt(parts[1]); // periodo
		model.addAttribute("email", authentication.getName());
		List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
		TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("identificadorResponsable", datosUsuarioInterno.getIdentificador());
		model.addAttribute("infcod", datosInstitucion.get(0)[0].toString());
		model.addAttribute("nombreInstitución", datosInstitucion.get(0)[1].toString());
		model.addAttribute("identificadorInstitucion", datosInstitucion.get(0)[2].toString());
		model.addAttribute("representanteLegal", datosInstitucion.get(0)[3].toString());
		model.addAttribute("funcionInstitucion", datosInstitucion.get(0)[4].toString());
		model.addAttribute("descripcionInstitucion", datosInstitucion.get(0)[5].toString());
		model.addAttribute("sectorInstitucion", datosInstitucion.get(0)[6].toString());
		model.addAttribute("tipoFormulario", datosInstitucion.get(0)[7].toString());
		model.addAttribute("fecha", dateFormat.format(datosInstitucion.get(0)[8]));
		model.addAttribute("estado", datosInstitucion.get(0)[9].toString());
		model.addAttribute("periodoInforme", periodo);

		List<Object[]> calificacionesInforme = ics.qryBuscarCalifiaccionesInforme(infcod);

		model.addAttribute("respuesta1", calificacionesInforme.get(0)[2].toString());
		model.addAttribute("respuesta2", calificacionesInforme.get(1)[2].toString());
		model.addAttribute("archivoRespaldo1",
				calificacionesInforme.get(1)[3] == null ? "" : calificacionesInforme.get(1)[3].toString());
		model.addAttribute("respuesta3", calificacionesInforme.get(2)[2].toString());
		model.addAttribute("archivoRespaldo2",
				calificacionesInforme.get(2)[3] == null ? "" : calificacionesInforme.get(2)[3].toString());
		model.addAttribute("respuesta4", calificacionesInforme.get(3)[2].toString());
		model.addAttribute("respuesta5", calificacionesInforme.get(4)[2].toString());
		model.addAttribute("archivoRespaldo3",
				calificacionesInforme.get(4)[3] == null ? "" : calificacionesInforme.get(4)[3].toString());
		model.addAttribute("respuesta6", calificacionesInforme.get(5)[2].toString());
		model.addAttribute("respuesta7", calificacionesInforme.get(6)[2].toString());
		model.addAttribute("respuesta8", calificacionesInforme.get(7)[2].toString());
		model.addAttribute("respuesta9", calificacionesInforme.get(8)[2].toString());
		model.addAttribute("respuesta10", calificacionesInforme.get(9)[2].toString());
		model.addAttribute("archivoRespaldo4",
				calificacionesInforme.get(9)[3] == null ? "" : calificacionesInforme.get(9)[3].toString());
		model.addAttribute("respuesta11", calificacionesInforme.get(10)[2].toString());
		model.addAttribute("archivoRespaldo5",
				calificacionesInforme.get(10)[3] == null ? "" : calificacionesInforme.get(10)[3].toString());
		model.addAttribute("respuesta12", calificacionesInforme.get(11)[2].toString());
		model.addAttribute("respuesta13", calificacionesInforme.get(12)[2].toString());
		model.addAttribute("archivoRespaldo6",
				calificacionesInforme.get(12)[3] == null ? "" : calificacionesInforme.get(12)[3].toString());
		model.addAttribute("respuesta14", calificacionesInforme.get(13)[2].toString());
		model.addAttribute("archivoRespaldo7",
				calificacionesInforme.get(13)[3] == null ? "" : calificacionesInforme.get(13)[3].toString());
		model.addAttribute("respuesta15", calificacionesInforme.get(14)[2].toString());
		model.addAttribute("archivoRespaldo8",
				calificacionesInforme.get(14)[3] == null ? "" : calificacionesInforme.get(14)[3].toString());
		model.addAttribute("respuesta16", calificacionesInforme.get(15)[2].toString());
		model.addAttribute("archivoRespaldo9",
				calificacionesInforme.get(15)[3] == null ? "" : calificacionesInforme.get(15)[3].toString());
		model.addAttribute("respuesta17", calificacionesInforme.get(16)[2].toString());
		model.addAttribute("respuesta18", calificacionesInforme.get(17)[2].toString());
		model.addAttribute("respuesta19", calificacionesInforme.get(18)[2].toString());
		model.addAttribute("respuesta20", calificacionesInforme.get(19)[2].toString());
		model.addAttribute("respuesta21", calificacionesInforme.get(20)[2].toString());
		model.addAttribute("archivoRespaldo10",
				calificacionesInforme.get(20)[3] == null ? "" : calificacionesInforme.get(20)[3].toString());

		List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
		model.addAttribute("comentario",
				datosInformeValorado.get(0)[4] == null ? null : datosInformeValorado.get(0)[4].toString());
		model.addAttribute("fechaValoracion", dateFormat.format(datosInformeValorado.get(0)[1]));

		return "rendicion/InformeGADValorado";
	}

	@RequestMapping(value = "/view/rendicion/valoracion/InformeGADVinculadoValorado", method = RequestMethod.POST)
	public String InformeGADVinculadoValorado(Model model, Authentication authentication,
			@RequestParam("id") String infcodPeriodo) {
		// separamos id y periodo
		String[] parts = infcodPeriodo.split("-");
		Integer infcod = Integer.parseInt(parts[0]); // id del informe
		Integer periodo = Integer.parseInt(parts[1]), orden; // periodo
		model.addAttribute("email", authentication.getName());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
		TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("identificadorResponsable", datosUsuarioInterno.getIdentificador());
		model.addAttribute("infcod", datosInstitucion.get(0)[0].toString());
		model.addAttribute("nombreInstitución", datosInstitucion.get(0)[1].toString());
		model.addAttribute("identificadorInstitucion", datosInstitucion.get(0)[2].toString());
		model.addAttribute("representanteLegal", datosInstitucion.get(0)[3].toString());
		model.addAttribute("funcionInstitucion", datosInstitucion.get(0)[4].toString());
		model.addAttribute("descripcionInstitucion", datosInstitucion.get(0)[5].toString());
		model.addAttribute("sectorInstitucion", datosInstitucion.get(0)[6].toString());
		model.addAttribute("tipoFormulario", datosInstitucion.get(0)[7].toString());
		model.addAttribute("fecha", dateFormat.format(datosInstitucion.get(0)[8]));
		model.addAttribute("estado", datosInstitucion.get(0)[9].toString());

		List<Object[]> calificacionesInforme = ics.qryBuscarCalifiaccionesInformeOrden(infcod);
		for (Object[] objects : calificacionesInforme) {

			orden = (Integer) objects[6];
			switch (orden) {
			case 1:
				model.addAttribute("respuesta1", objects[4].toString());
				break;
			case 2:
				model.addAttribute("respuesta2", objects[4].toString());
				model.addAttribute("archivoRespaldo1", objects[5] == null ? "" : objects[5].toString());
				break;
			case 3:
				model.addAttribute("respuesta3", objects[4].toString());
				model.addAttribute("archivoRespaldo2", objects[5] == null ? "" : objects[5].toString());
				break;
			case 4:
				model.addAttribute("respuesta4", objects[4].toString());
				model.addAttribute("archivoRespaldo3", objects[5] == null ? "" : objects[5].toString());
				break;
			case 5:
				model.addAttribute("respuesta5", objects[4].toString());
				model.addAttribute("archivoRespaldo4", objects[5] == null ? "" : objects[5].toString());
				break;
			case 6:
				model.addAttribute("respuesta6", objects[4].toString());
				model.addAttribute("archivoRespaldo5", objects[5] == null ? "" : objects[5].toString());
				break;
			case 7:
				model.addAttribute("respuesta7", objects[4].toString());
				model.addAttribute("archivoRespaldo6", objects[5] == null ? "" : objects[5].toString());
				break;
			case 8:
				model.addAttribute("respuesta8", objects[4].toString());
				model.addAttribute("archivoRespaldo7", objects[5] == null ? "" : objects[5].toString());
				break;
			case 9:
				model.addAttribute("respuesta9", objects[4].toString());
				model.addAttribute("archivoRespaldo8", objects[5] == null ? "" : objects[5].toString());
				break;
			case 10:
				model.addAttribute("respuesta10", objects[4].toString());
				model.addAttribute("archivoRespaldo9", objects[5] == null ? "" : objects[5].toString());
				break;
			case 11:
				model.addAttribute("respuesta11", objects[4].toString());
				model.addAttribute("archivoRespaldo10", objects[5] == null ? "" : objects[5].toString());
				break;
			case 12:
				model.addAttribute("respuesta12", objects[4].toString());
				break;
			case 13:
				model.addAttribute("respuesta13", objects[4].toString());
				break;
			case 14:
				model.addAttribute("respuesta14", objects[4].toString());
				break;
			case 15:
				model.addAttribute("respuesta15", objects[4].toString());
				break;
			case 16:
				model.addAttribute("respuesta16", objects[4].toString());
				break;
			}

		}

		List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
		model.addAttribute("comentario", datosInformeValorado.get(0)[4].toString());
		String fecha = dateFormat.format(datosInformeValorado.get(0)[1]);
		model.addAttribute("fechaValoracion", fecha);

		return "rendicion/InformeGADVinculadoValorado";
	}

	@RequestMapping("/view/rendicion/listaInformesValoradosSubcoordinador")
	public String listaInformesValoradosSubcoordinador(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);
		model.addAttribute("anioActual", anio);
		model.addAttribute("email", authentication.getName());
		model.addAttribute("anio", "2020");
		return "rendicion/listaInformesValoradosSubcoordinador";
	}

	@RequestMapping(value = { "/obtenerRegistrosValorados" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerRegistrosValorados(Authentication authentication, @RequestParam("estado") String estado,
			@RequestParam("periodo") String periodo) {
		String json;
		// TblUsuario datosUsuario =
		// us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		ObjectMapper mapper = new ObjectMapper();
		List<SeguimientoInstitucionDTO> listaDto = new ArrayList<>();
		try {
			List<Object[]> listaRegistros = ais.qryBuscarInformesValoradosSubcoordinador(periodo, estado);

			listaDto = listaRegistros.stream()
					.map(obj -> SeguimientoInstitucionDTO.builder().inf_cod((Integer) obj[0])
							.contador(listaRegistros.indexOf(obj) + 1).inst_nom(obj[1].toString())
							.inst_ruc(obj[2].toString()).fecha(obj[3].toString()).asigandor(obj[4].toString())
							.asignado(obj[5].toString()).estado(obj[6].toString()).nota(obj[7].toString())
							.informe(obj[8].toString()).build())
					.collect(Collectors.toList());
			json = (!listaDto.isEmpty()) ? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(listaDto) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";

		}
		return json;
	}

	// MEdios valorado

	@RequestMapping(value = "/view/rendicion/valoracion/InformeMedioValorado", method = RequestMethod.POST)
	public String InformeMedioValorado(Model model, Authentication authentication,
			@RequestParam("id") String infcodPeriodo) {
		// separamos id y periodo
		String[] parts = infcodPeriodo.split("-");
		Integer infcod = Integer.parseInt(parts[0]); // id del informe
		Integer periodo = Integer.parseInt(parts[1]); // periodo
		model.addAttribute("email", authentication.getName());
		List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
		TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("identificadorResponsable", datosUsuarioInterno.getIdentificador());
		model.addAttribute("infcod", datosInstitucion.get(0)[0].toString());
		model.addAttribute("nombreInstitución", datosInstitucion.get(0)[1].toString());
		model.addAttribute("identificadorInstitucion", datosInstitucion.get(0)[2].toString());
		model.addAttribute("representanteLegal", datosInstitucion.get(0)[3].toString());
		model.addAttribute("funcionInstitucion", datosInstitucion.get(0)[4].toString());
		model.addAttribute("descripcionInstitucion", datosInstitucion.get(0)[5].toString());
		model.addAttribute("sectorInstitucion", datosInstitucion.get(0)[6].toString());
		model.addAttribute("tipoFormulario", datosInstitucion.get(0)[7].toString());
		model.addAttribute("fecha", dateFormat.format(datosInstitucion.get(0)[8]));
		model.addAttribute("estado", datosInstitucion.get(0)[9].toString());
		model.addAttribute("periodoInforme", periodo);

		List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
		model.addAttribute("comentario",
				datosInformeValorado.get(0)[4] == null ? null : datosInformeValorado.get(0)[4].toString());
		model.addAttribute("fechaValoracion", dateFormat.format(datosInformeValorado.get(0)[1]));
		// model.addAttribute("pregunta1",pregunta)

		return "rendicion/InformeMedioValorado";
	}

	// Escuela de educacion superior

	@RequestMapping(value = "/view/rendicion/valoracion/InformeESValorado", method = RequestMethod.POST)
	public String InformeESValorado(Model model, Authentication authentication,
			@RequestParam("id") String infcodPeriodo) {
		// separamos id y periodo
		String[] parts = infcodPeriodo.split("-");
		Integer infcod = Integer.parseInt(parts[0]); // id del informe
		Integer periodo = Integer.parseInt(parts[1]); // periodo
		model.addAttribute("email", authentication.getName());
		List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
		TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("identificadorResponsable", datosUsuarioInterno.getIdentificador());
		model.addAttribute("infcod", datosInstitucion.get(0)[0].toString());
		model.addAttribute("nombreInstitución", datosInstitucion.get(0)[1].toString());
		model.addAttribute("identificadorInstitucion", datosInstitucion.get(0)[2].toString());
		model.addAttribute("representanteLegal", datosInstitucion.get(0)[3].toString());
		model.addAttribute("funcionInstitucion", datosInstitucion.get(0)[4].toString());
		model.addAttribute("descripcionInstitucion", datosInstitucion.get(0)[5].toString());
		model.addAttribute("sectorInstitucion", datosInstitucion.get(0)[6].toString());
		model.addAttribute("tipoFormulario", datosInstitucion.get(0)[7].toString());
		model.addAttribute("fecha", dateFormat.format(datosInstitucion.get(0)[8]));
		model.addAttribute("estado", datosInstitucion.get(0)[9].toString());
		model.addAttribute("periodoInforme", periodo);
		List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
		model.addAttribute("comentario",
				datosInformeValorado.get(0)[4] == null ? null : datosInformeValorado.get(0)[4].toString());
		model.addAttribute("fechaValoracion", dateFormat.format(datosInformeValorado.get(0)[1]));

		return "rendicion/InformeESValorado";
	}

	// IESS y OTROS FUnciones del estado
	@RequestMapping(value = "/view/rendicion/valoracion/InformeFEValorado", method = RequestMethod.POST)
	public String InformeFEValorado(Model model, Authentication authentication,
			@RequestParam("id") String infcodPeriodo) {
		// separamos id y periodo
		String[] parts = infcodPeriodo.split("-");
		Integer infcod = Integer.parseInt(parts[0]); // id del informe
		Integer periodo = Integer.parseInt(parts[1]); // periodo
		model.addAttribute("email", authentication.getName());
		List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
		TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("identificadorResponsable", datosUsuarioInterno.getIdentificador());
		model.addAttribute("infcod", datosInstitucion.get(0)[0].toString());
		model.addAttribute("nombreInstitución", datosInstitucion.get(0)[1].toString());
		model.addAttribute("identificadorInstitucion", datosInstitucion.get(0)[2].toString());
		model.addAttribute("representanteLegal", datosInstitucion.get(0)[3].toString());
		model.addAttribute("funcionInstitucion", datosInstitucion.get(0)[4].toString());
		model.addAttribute("descripcionInstitucion", datosInstitucion.get(0)[5].toString());
		model.addAttribute("sectorInstitucion", datosInstitucion.get(0)[6].toString());
		model.addAttribute("tipoFormulario", datosInstitucion.get(0)[7].toString());
		model.addAttribute("fecha", dateFormat.format(datosInstitucion.get(0)[8]));
		model.addAttribute("estado", datosInstitucion.get(0)[9].toString());
		model.addAttribute("estado", datosInstitucion.get(0)[9].toString());
		model.addAttribute("periodoInforme", periodo);

		List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
		model.addAttribute("comentario",
				datosInformeValorado.get(0)[4] == null ? null : datosInformeValorado.get(0)[4].toString());
		model.addAttribute("fechaValoracion", dateFormat.format(datosInformeValorado.get(0)[1]));

		return "rendicion/InformeFEValorado";
	}
	// Metodos para recuperar informes asignados

	@RequestMapping("/view/rendicion/RecuperacionInformes")
	public String RecuperacionInformes(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {
		model.addAttribute("email", authentication.getName());
		// ticket 1551
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);
		model.addAttribute("anioActual", anio);
		model.addAttribute("anio", "2020");

		TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("datosUsuario", datosUsuario);

		List<TblDatosFuncionarios> listaTecnicos = ts.obtenerTecnicos(Constantes.ESTADO_ACTIVO_USUARIOS.toString(),
				"SUBCOORDINADOR");
		model.addAttribute("listaTecnicos", listaTecnicos);

		return "rendicion/RecuperacionInformes";
	}

	@RequestMapping(value = "/getTecnicosPorPeriodo", method = RequestMethod.GET)
	@ResponseBody
	public List<TblDatosFuncionarios> getTecnicosPorPeriodo(@RequestParam("periodo") String periodo) {
		// Obtenemos una lista de tecnicos con informes sin calificar "asignado" por
		// periodo de asignacion.
		// ticket 1551
		return ts.obtenerTecnicosPorPeriodo(Constantes.ESTADO_ACTIVO_USUARIOS.toString(), "SUBCOORDINADOR",
				Integer.parseInt(periodo));
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/rendicion/EliminacionAsignacion", method = RequestMethod.POST)
	public @ResponseBody String EliminacionAutoridad(HttpServletRequest request,
			@RequestParam("cmbTecnicos") String cmbTecnicos, Authentication authentication,
			@RequestParam("cmbPeriodo") String cmbPeriodo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			String DatoNuevo = null;
			TblUsuario subcoordinador = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblDatosFuncionarios funcionarios = UsuInterno.ObtenerDatodFuncionarioXidentificador(cmbTecnicos);
			TblAplicacionesRegistradas listaAplicaciones = us.buscarAplicacionRegistradaPorEmaeilidentifiador(
					subcoordinador.getEmail(), Constantes.periodo().toString(), Constantes.ESTADO_ACTIVO_USUARIOS);
			InetAddress direccionIp = InetAddress.getLocalHost();
			String hostname = direccionIp.getHostName();// nombre host
			String ipHostname = direccionIp.getHostAddress();// ip como String
			String version = listaAplicaciones.getIdAplicacion().getVersionApp();

			// as.ElimnarAsignacion(funcionarios.getIdentificador(), "calificado"); ticket
			// 1151
			as.ElimnarAsignacionPorPerido(funcionarios.getIdentificador(), "calificado", Integer.parseInt(cmbPeriodo));
			TblHistoricoInstituciones tblHistoricoInstituciones = new TblHistoricoInstituciones();
			tblHistoricoInstituciones.setIdTecnico(subcoordinador.getIdUser());
			tblHistoricoInstituciones.setIdNombreTecnico(subcoordinador.getNombre());
			tblHistoricoInstituciones
					.setDatoHistorico("Eliminado Fisico de La tabla tbl_asignacion para el funcuinario: "
							+ funcionarios.getNombre() + " " + "de cudula: " + funcionarios.getIdentificador());
			tblHistoricoInstituciones.setDatoActual(DatoNuevo);
			tblHistoricoInstituciones
					.setAprobadoPor(subcoordinador.getIdUser() + ", " + subcoordinador.getIdentificador() + ", "
							+ subcoordinador.getNombre() + ", " + subcoordinador.getCodigoIntitucionAutorida());
			tblHistoricoInstituciones.setVersionSistema(version);
			tblHistoricoInstituciones.setIpAdress(Constantes.getClientIpAddr(request));
			tblHistoricoInstituciones.setHostName(hostname + ", " + ipHostname);
			// tblHistoricoInstituciones.setSolicitadoPor(Solicitado.getIdDatoFuncionario()
			// + ", "+ Solicitado.getIdentificador() + ", " + Solicitado.getNombre() + ", "
			// + Solicitado.getCargo());
			tblHistoricoInstituciones.setAcccion(Constantes.ACCION_DELETE);
			tblHistoricoInstituciones.setFechaAccion(new Date());
			tblHistoricoInstituciones.setDescripcion("Eliminación de Asignación de informes de retroalimentación");
			tblHistoricoInstituciones.setRutaAnexo("S/N");
			// tblHistoricoInstituciones.setCodReferencial(tblAutoridad.getAutCodigo());
			tblHistoricoInstituciones.setTipoHistorico("ELiminacionAsignacion");
			gcs.GuardarHistoricoInstitucion(tblHistoricoInstituciones);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.!");
		}

		catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/envioMasivoMailInsituciones", method = RequestMethod.POST)
	public @ResponseBody String guardarNuevaContraseña(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") String periodo, @RequestParam("estado") String estado) {
		JSONObject mensaje = new JSONObject();
		List<Object[]> listaRegistros = ais.qryBuscarInformesAsignadosxSubcoordinador(periodo, estado);
		try {
			if (listaRegistros != null) {

				System.out.println(listaRegistros);

				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			} else {

				mensaje.put("estado", "vacio");
			}

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	// Metodos retroalimentacion para instituciones, visualizacion informe
	// calificado
	// metodos para enlistar los años en los que se tiene registro de informes
	// calificados
	// Segun resolucin CPCCS-PLE-SG-018-O-2024-0145 del 01-05-2024
	// Se habilita la revision y emision de certificados para GADS y Instituciones
	// de Educacion Superior

	@RequestMapping(value = "/view/rendicion/listaInformesCalificados", method = RequestMethod.POST)
	public String listaInformesCalificados(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) throws JsonProcessingException {
		System.out.println("Dentro del metodo !!!!!");
		TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		// Para consultar el ruc de la institucion, mandamos el
		// codigo_institucion_autorida del usuario, estado y periodo
		Integer codInst = datosUsuario.getCodigoIntitucionAutorida();
		TblInstitucion datosInstitucion = gcs.ObtenerInstitucionesXidEstado(codInst, Constantes.ESTADO,
				Constantes.periodo());
		String rucInst = datosInstitucion.getInstRuc();
		String provCod = datosInstitucion.getProvCod().toString();
		String cantCod = datosInstitucion.getCantCod().toString();
		TblTipoInforme codInformeInstitucion = datosInstitucion.getInstTfCod();
		String codInstInf = codInformeInstitucion.getTfCod().toString();
		List<TblInstitucion> listaInstituciones = null;
		//si tenemos una institucion medio de comunicacion usamos otro query para que no nos salganinformes de los gad a los que pertenece dado que son del mismo informe pero cambia en otro campo el tipo
		//el para diferenciar busca misma que la provincia y canton sean iguales al del usuario que representa esa institucion
		//replantear en un futuro, dado que solo se diferencia por tipo y eso no es igual en el paso de los años
		if(codInstInf.equals("7")) {
			listaInstituciones = instserv.findByRucAndVerificadorNotNullMedios(rucInst, Integer.parseInt(provCod), Integer.parseInt(cantCod));
		}else{
		// Obtener la lista de instituciones directamente
		listaInstituciones = instserv.findByRucAndVerificadorNotNull(rucInst);
		}
		// Convertir la lista a JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String listaInstitucionesJson = objectMapper.writeValueAsString(listaInstituciones);
		// Ahora, agregamos los resultados al modelo para enviarlos a la vista
		System.out.println("el Json: " + listaInstitucionesJson);
		model.addAttribute("listaInstituciones", listaInstitucionesJson);
		// consultamos tambien la funcion de la institucion
		
		System.out.println("el Num de Funcion de la Institucion: " + codInstInf);
		model.addAttribute("codigoTipoInforme", codInstInf);

		return "rendicion/retroalimentacion/listaInformesCalificados";
	}

	//funcionando ok
	@RequestMapping(value = "/view/rendicion/RetroalimentacionInformeGADEPValorado", method = RequestMethod.POST)
	public String RetroalimentacionInformeGADEPValorado(Model model, Authentication authentication,
			@RequestParam("elementos") String infcodPeriodo) {
		// separamos id y periodo
		System.out.println("Dentro deRetroalimentacionInformeGADEPValorado");
		System.out.println("infcodPeriodo: " + infcodPeriodo);
		String[] parts = infcodPeriodo.split("-");
		Integer instcod = Integer.parseInt(parts[0]); // id de la institucion en ese periodo
		Integer periodo = Integer.parseInt(parts[1]); // periodo
		TblInforme datosInforme = is.obtenerDatosInformePorInstitucionCodigo(instcod);
		Integer infcod = datosInforme.getInfCod(); // id del informe
		model.addAttribute("email", authentication.getName());
		List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
		TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("identificadorResponsable", datosUsuarioInterno.getIdentificador());
		model.addAttribute("infcod", infcod.toString());
		model.addAttribute("nombreInstitución", datosInstitucion.get(0)[1].toString());
		model.addAttribute("identificadorInstitucion", datosInstitucion.get(0)[2].toString());
		model.addAttribute("representanteLegal", datosInstitucion.get(0)[3].toString());
		model.addAttribute("funcionInstitucion", datosInstitucion.get(0)[4].toString());
		model.addAttribute("descripcionInstitucion", datosInstitucion.get(0)[5].toString());
		model.addAttribute("sectorInstitucion", datosInstitucion.get(0)[6].toString());
		model.addAttribute("tipoFormulario", datosInstitucion.get(0)[7].toString());
		model.addAttribute("fecha", dateFormat.format(datosInstitucion.get(0)[8]));
		model.addAttribute("estado", datosInstitucion.get(0)[9].toString());
		model.addAttribute("periodoInforme", periodo);
		List<Object[]> calificacionesInforme = ics.qryBuscarCalifiaccionesInforme(infcod);
		// si no se ha calificado aun el informe de la institucion se envia false y se
		// oculta en el formulario los datos de calificacion.
		if (calificacionesInforme.isEmpty() == true || calificacionesInforme.size() < 19) {
			model.addAttribute("estadoInforme", false);
			System.out.println("Dentro de False");
		} else {
			model.addAttribute("estadoInforme", true);
			double porcentajeTotal = 0;// variable para sumar las calificaciones % de info correctamente entregada
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(0)[6] == null ? "0.0" : calificacionesInforme.get(0)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(1)[6] == null ? "0.0" : calificacionesInforme.get(1)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(2)[6] == null ? "0.0" : calificacionesInforme.get(2)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(3)[6] == null ? "0.0" : calificacionesInforme.get(3)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(4)[6] == null ? "0.0" : calificacionesInforme.get(4)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(5)[6] == null ? "0.0" : calificacionesInforme.get(5)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(6)[6] == null ? "0.0" : calificacionesInforme.get(6)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(7)[6] == null ? "0.0" : calificacionesInforme.get(7)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(8)[6] == null ? "0.0" : calificacionesInforme.get(8)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(9)[6] == null ? "0.0" : calificacionesInforme.get(9)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(10)[6] == null ? "0.0" : calificacionesInforme.get(10)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(11)[6] == null ? "0.0" : calificacionesInforme.get(11)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(12)[6] == null ? "0.0" : calificacionesInforme.get(12)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(13)[6] == null ? "0.0" : calificacionesInforme.get(13)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(14)[6] == null ? "0.0" : calificacionesInforme.get(14)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(15)[6] == null ? "0.0" : calificacionesInforme.get(15)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(16)[6] == null ? "0.0" : calificacionesInforme.get(16)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(17)[6] == null ? "0.0" : calificacionesInforme.get(17)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(18)[6] == null ? "0.0" : calificacionesInforme.get(18)[6].toString());
			if (porcentajeTotal>99.99) {
				porcentajeTotal=100.00;
			}
			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
			// Descomentar esto si se quiere visualizar el comentario del técnico
			// model.addAttribute("comentario", datosInformeValorado.get(0)[4] == null ?
			// null : datosInformeValorado.get(0)[4].toString());
			model.addAttribute("fechaValoracion", dateFormat.format(datosInformeValorado.get(0)[1]));
			model.addAttribute("porcentajeTotal", porcentajeTotal);
			model.addAttribute("infPeriodo",periodo.toString());
		}
		return "rendicion/retroalimentacion/RetroInformeGADEPValorado";

	}

	//funcionando ok
	@RequestMapping(value = "/view/rendicion/RetroalimentacionInformeGADValorado", method = RequestMethod.POST)
	public String RetroalimentacionInformeGADValorado(Model model, Authentication authentication,
			@RequestParam("elementos") String infcodPeriodo) {
		// separamos id y periodo
		String[] parts = infcodPeriodo.split("-");
		Integer instcod = Integer.parseInt(parts[0]); // id de la institucion en ese periodo
		Integer periodo = Integer.parseInt(parts[1]); // periodo
		TblInforme datosInforme = is.obtenerDatosInformePorInstitucionCodigo(instcod);
		Integer infcod = datosInforme.getInfCod(); // id del informe
		model.addAttribute("email", authentication.getName());
		List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
		TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("identificadorResponsable", datosUsuarioInterno.getIdentificador());
		model.addAttribute("infcod", datosInstitucion.get(0)[0].toString());
		model.addAttribute("nombreInstitución", datosInstitucion.get(0)[1].toString());
		model.addAttribute("identificadorInstitucion", datosInstitucion.get(0)[2].toString());
		model.addAttribute("representanteLegal", datosInstitucion.get(0)[3].toString());
		model.addAttribute("funcionInstitucion", datosInstitucion.get(0)[4].toString());
		model.addAttribute("descripcionInstitucion", datosInstitucion.get(0)[5].toString());
		model.addAttribute("sectorInstitucion", datosInstitucion.get(0)[6].toString());
		model.addAttribute("tipoFormulario", datosInstitucion.get(0)[7].toString());
		model.addAttribute("fecha", dateFormat.format(datosInstitucion.get(0)[8]));
		model.addAttribute("estado", datosInstitucion.get(0)[9].toString());
		model.addAttribute("periodoInforme", periodo);

		List<Object[]> calificacionesInforme = ics.qryBuscarCalifiaccionesInforme(infcod);
		if (calificacionesInforme.isEmpty() == true || calificacionesInforme.size() < 21) {
			model.addAttribute("estadoInforme", false);
		} else {
			model.addAttribute("estadoInforme", true);
			double porcentajeTotal = 0;// variable para sumar las calificaciones % de info correctamente entregada
			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
			// model.addAttribute("comentario", datosInformeValorado.get(0)[4] == null ?
			// null : datosInformeValorado.get(0)[4].toString());
			model.addAttribute("fechaValoracion", dateFormat.format(datosInformeValorado.get(0)[1]));
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(0)[6] == null ? "0.0" : calificacionesInforme.get(0)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(1)[6] == null ? "0.0" : calificacionesInforme.get(1)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(2)[6] == null ? "0.0" : calificacionesInforme.get(2)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(3)[6] == null ? "0.0" : calificacionesInforme.get(3)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(4)[6] == null ? "0.0" : calificacionesInforme.get(4)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(5)[6] == null ? "0.0" : calificacionesInforme.get(5)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(6)[6] == null ? "0.0" : calificacionesInforme.get(6)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(7)[6] == null ? "0.0" : calificacionesInforme.get(7)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(8)[6] == null ? "0.0" : calificacionesInforme.get(8)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(9)[6] == null ? "0.0" : calificacionesInforme.get(9)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(10)[6] == null ? "0.0" : calificacionesInforme.get(10)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(11)[6] == null ? "0.0" : calificacionesInforme.get(11)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(12)[6] == null ? "0.0" : calificacionesInforme.get(12)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(13)[6] == null ? "0.0" : calificacionesInforme.get(13)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(14)[6] == null ? "0.0" : calificacionesInforme.get(14)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(15)[6] == null ? "0.0" : calificacionesInforme.get(15)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(16)[6] == null ? "0.0" : calificacionesInforme.get(16)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(17)[6] == null ? "0.0" : calificacionesInforme.get(17)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(18)[6] == null ? "0.0" : calificacionesInforme.get(18)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(19)[6] == null ? "0.0" : calificacionesInforme.get(19)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(20)[6] == null ? "0.0" : calificacionesInforme.get(20)[6].toString());
			if (porcentajeTotal>99.99) {
				porcentajeTotal=100.00;
			}
			model.addAttribute("porcentajeTotal", porcentajeTotal);
			model.addAttribute("infPeriodo",periodo.toString());
		}
		return "rendicion/retroalimentacion/RetroInformeGADValorado";

	}
	
	//OK funcionando
	@RequestMapping(value = "/view/rendicion/RetroalimentacionInformeGADVinculadoValorado", method = RequestMethod.POST)
	public String RetroalimentacionInformeGADVinculadoValorado(Model model, Authentication authentication,
			@RequestParam("elementos") String infcodPeriodo) {
		// separamos id y periodo
				String[] parts = infcodPeriodo.split("-");
				Integer instcod = Integer.parseInt(parts[0]); // id de la institucion en ese periodo
				Integer periodo = Integer.parseInt(parts[1]); // periodo
				TblInforme datosInforme = is.obtenerDatosInformePorInstitucionCodigo(instcod);
				Integer infcod = datosInforme.getInfCod(); // id del informe
				model.addAttribute("email", authentication.getName());
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
				TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
				model.addAttribute("identificadorResponsable", datosUsuarioInterno.getIdentificador());
				model.addAttribute("infcod", datosInstitucion.get(0)[0].toString());
				model.addAttribute("nombreInstitución", datosInstitucion.get(0)[1].toString());
				model.addAttribute("identificadorInstitucion", datosInstitucion.get(0)[2].toString());
				model.addAttribute("representanteLegal", datosInstitucion.get(0)[3].toString());
				model.addAttribute("funcionInstitucion", datosInstitucion.get(0)[4].toString());
				model.addAttribute("descripcionInstitucion", datosInstitucion.get(0)[5].toString());
				model.addAttribute("sectorInstitucion", datosInstitucion.get(0)[6].toString());
				model.addAttribute("tipoFormulario", datosInstitucion.get(0)[7].toString());
				model.addAttribute("fecha", dateFormat.format(datosInstitucion.get(0)[8]));
				model.addAttribute("estado", datosInstitucion.get(0)[9].toString());
				model.addAttribute("periodoInforme", periodo);

				List<Object[]> calificacionesInforme = ics.qryBuscarCalifiaccionesInforme(infcod);
				if (calificacionesInforme.isEmpty() == true || calificacionesInforme.size() < 16) {
					model.addAttribute("estadoInforme", false);
				} else {
					model.addAttribute("estadoInforme", true);
					double porcentajeTotal = 0;// variable para sumar las calificaciones % de info correctamente entregada
					List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
					// model.addAttribute("comentario", datosInformeValorado.get(0)[4] == null ?
					// null : datosInformeValorado.get(0)[4].toString());
					model.addAttribute("fechaValoracion", dateFormat.format(datosInformeValorado.get(0)[1]));
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(0)[6] == null ? "0.0" : calificacionesInforme.get(0)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(1)[6] == null ? "0.0" : calificacionesInforme.get(1)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(2)[6] == null ? "0.0" : calificacionesInforme.get(2)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(3)[6] == null ? "0.0" : calificacionesInforme.get(3)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(4)[6] == null ? "0.0" : calificacionesInforme.get(4)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(5)[6] == null ? "0.0" : calificacionesInforme.get(5)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(6)[6] == null ? "0.0" : calificacionesInforme.get(6)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(7)[6] == null ? "0.0" : calificacionesInforme.get(7)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(8)[6] == null ? "0.0" : calificacionesInforme.get(8)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(9)[6] == null ? "0.0" : calificacionesInforme.get(9)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(10)[6] == null ? "0.0" : calificacionesInforme.get(10)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(11)[6] == null ? "0.0" : calificacionesInforme.get(11)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(12)[6] == null ? "0.0" : calificacionesInforme.get(12)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(13)[6] == null ? "0.0" : calificacionesInforme.get(13)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(14)[6] == null ? "0.0" : calificacionesInforme.get(14)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(15)[6] == null ? "0.0" : calificacionesInforme.get(15)[6].toString());
					if (porcentajeTotal>99.99) {
						porcentajeTotal=100.00;
					}
					model.addAttribute("porcentajeTotal", porcentajeTotal);
					model.addAttribute("infPeriodo",periodo.toString());
				}
		return "rendicion/retroalimentacion/RetroInformeGADVinculadoValorado";

	}

	//funcionando ok
	@RequestMapping(value = "/view/rendicion/RetroalimentacionInformeESValorado", method = RequestMethod.POST)
	public String RetroalimentacionInformeESValorado(Model model, Authentication authentication,
			@RequestParam("elementos") String infcodPeriodo) {
		String[] parts = infcodPeriodo.split("-");
		Integer instcod = Integer.parseInt(parts[0]); // id de la institucion en ese periodo
		Integer periodo = Integer.parseInt(parts[1]); // periodo
		TblInforme datosInforme = is.obtenerDatosInformePorInstitucionCodigo(instcod);
		Integer infcod = datosInforme.getInfCod(); // id del informe

		model.addAttribute("email", authentication.getName());
		List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
		TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("identificadorResponsable", datosUsuarioInterno.getIdentificador());
		model.addAttribute("infcod", datosInstitucion.get(0)[0].toString());
		model.addAttribute("nombreInstitución", datosInstitucion.get(0)[1].toString());
		model.addAttribute("identificadorInstitucion", datosInstitucion.get(0)[2].toString());
		model.addAttribute("representanteLegal", datosInstitucion.get(0)[3].toString());
		model.addAttribute("funcionInstitucion", datosInstitucion.get(0)[4].toString());
		model.addAttribute("descripcionInstitucion", datosInstitucion.get(0)[5].toString());
		model.addAttribute("sectorInstitucion", datosInstitucion.get(0)[6].toString());
		model.addAttribute("tipoFormulario", datosInstitucion.get(0)[7].toString());
		model.addAttribute("fecha", dateFormat.format(datosInstitucion.get(0)[8]));
		model.addAttribute("estado", datosInstitucion.get(0)[9].toString());
		model.addAttribute("periodoInforme", periodo);
		List<Object[]> calificacionesInforme = ics.qryBuscarCalifiaccionesInforme(infcod);
		// si no se ha calificado aun el informe de la institucion se envia false y se
		// oculta en el formulario los datos de calificacion.
		if (calificacionesInforme.isEmpty() == true || calificacionesInforme.size() < 15) {
			model.addAttribute("estadoInforme", false);
		} else {
			model.addAttribute("estadoInforme", true);
			double porcentajeTotal = 0;// variable para sumar las calificaciones % de info correctamente entregada
			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
			// model.addAttribute("comentario", datosInformeValorado.get(0)[4] == null ?
			// null : datosInformeValorado.get(0)[4].toString());
			model.addAttribute("fechaValoracion", dateFormat.format(datosInformeValorado.get(0)[1]));
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(0)[6] == null ? "0.0" : calificacionesInforme.get(0)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(1)[6] == null ? "0.0" : calificacionesInforme.get(1)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(2)[6] == null ? "0.0" : calificacionesInforme.get(2)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(3)[6] == null ? "0.0" : calificacionesInforme.get(3)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(4)[6] == null ? "0.0" : calificacionesInforme.get(4)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(5)[6] == null ? "0.0" : calificacionesInforme.get(5)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(6)[6] == null ? "0.0" : calificacionesInforme.get(6)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(7)[6] == null ? "0.0" : calificacionesInforme.get(7)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(8)[6] == null ? "0.0" : calificacionesInforme.get(8)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(9)[6] == null ? "0.0" : calificacionesInforme.get(9)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(10)[6] == null ? "0.0" : calificacionesInforme.get(10)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(11)[6] == null ? "0.0" : calificacionesInforme.get(11)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(12)[6] == null ? "0.0" : calificacionesInforme.get(12)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(13)[6] == null ? "0.0" : calificacionesInforme.get(13)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(14)[6] == null ? "0.0" : calificacionesInforme.get(14)[6].toString());
			if (porcentajeTotal>99.99) {
				porcentajeTotal=100.00;
			}
			model.addAttribute("porcentajeTotal", porcentajeTotal);
			// model.addAttribute("comentario", datosInformeValorado.get(0)[4] == null ?
			// null : datosInformeValorado.get(0)[4].toString());
			model.addAttribute("fechaValoracion", dateFormat.format(datosInformeValorado.get(0)[1]));
			model.addAttribute("infPeriodo",periodo.toString());
		}
		return "rendicion/retroalimentacion/RetroInformeESValorado";

	}

	//ok ya esta
	@RequestMapping(value = "/view/rendicion/RetroalimentacionInformeIESSValorado", method = RequestMethod.POST)
	public String RetroalimentacionInformeIESSValorado(Model model, Authentication authentication,
			@RequestParam("elementos") String infcodPeriodo) {
		// separamos id y periodo
				String[] parts = infcodPeriodo.split("-");
				Integer instcod = Integer.parseInt(parts[0]); // id de la institucion en ese periodo
				Integer periodo = Integer.parseInt(parts[1]); // periodo
				TblInforme datosInforme = is.obtenerDatosInformePorInstitucionCodigo(instcod);
				Integer infcod = datosInforme.getInfCod(); // id del informe
				model.addAttribute("email", authentication.getName());
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
				TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
				model.addAttribute("identificadorResponsable", datosUsuarioInterno.getIdentificador());
				model.addAttribute("infcod", datosInstitucion.get(0)[0].toString());
				model.addAttribute("nombreInstitución", datosInstitucion.get(0)[1].toString());
				model.addAttribute("identificadorInstitucion", datosInstitucion.get(0)[2].toString());
				model.addAttribute("representanteLegal", datosInstitucion.get(0)[3].toString());
				model.addAttribute("funcionInstitucion", datosInstitucion.get(0)[4].toString());
				model.addAttribute("descripcionInstitucion", datosInstitucion.get(0)[5].toString());
				model.addAttribute("sectorInstitucion", datosInstitucion.get(0)[6].toString());
				model.addAttribute("tipoFormulario", datosInstitucion.get(0)[7].toString());
				model.addAttribute("fecha", dateFormat.format(datosInstitucion.get(0)[8]));
				model.addAttribute("estado", datosInstitucion.get(0)[9].toString());
				model.addAttribute("periodoInforme", periodo);

				List<Object[]> calificacionesInforme = ics.qryBuscarCalifiaccionesInforme(infcod);
				if (calificacionesInforme.isEmpty() == true || calificacionesInforme.size() < 13) {
					model.addAttribute("estadoInforme", false);
				} else {
					model.addAttribute("estadoInforme", true);
					double porcentajeTotal = 0;// variable para sumar las calificaciones % de info correctamente entregada
					List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
					// model.addAttribute("comentario", datosInformeValorado.get(0)[4] == null ?
					// null : datosInformeValorado.get(0)[4].toString());
					model.addAttribute("fechaValoracion", dateFormat.format(datosInformeValorado.get(0)[1]));
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(0)[6] == null ? "0.0" : calificacionesInforme.get(0)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(1)[6] == null ? "0.0" : calificacionesInforme.get(1)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(2)[6] == null ? "0.0" : calificacionesInforme.get(2)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(3)[6] == null ? "0.0" : calificacionesInforme.get(3)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(4)[6] == null ? "0.0" : calificacionesInforme.get(4)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(5)[6] == null ? "0.0" : calificacionesInforme.get(5)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(6)[6] == null ? "0.0" : calificacionesInforme.get(6)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(7)[6] == null ? "0.0" : calificacionesInforme.get(7)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(8)[6] == null ? "0.0" : calificacionesInforme.get(8)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(9)[6] == null ? "0.0" : calificacionesInforme.get(9)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(10)[6] == null ? "0.0" : calificacionesInforme.get(10)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(11)[6] == null ? "0.0" : calificacionesInforme.get(11)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(12)[6] == null ? "0.0" : calificacionesInforme.get(12)[6].toString());
					if (porcentajeTotal>99.99) {
						porcentajeTotal=100.00;
					}
					model.addAttribute("porcentajeTotal", porcentajeTotal);
					model.addAttribute("infPeriodo",periodo.toString());
				}
		return "rendicion/retroalimentacion/RetroInformeIESSValorado";

	}

	//Ok funcionando
	@RequestMapping(value = "/view/rendicion/RetroalimentacionInformeMedioValorado", method = RequestMethod.POST)
	public String RetroalimentacionInformeMedioValorado(Model model, Authentication authentication,
			@RequestParam("elementos") String infcodPeriodo) {
		// separamos id y periodo
				String[] parts = infcodPeriodo.split("-");
				Integer instcod = Integer.parseInt(parts[0]); // id de la institucion en ese periodo
				Integer periodo = Integer.parseInt(parts[1]); // periodo
				TblInforme datosInforme = is.obtenerDatosInformePorInstitucionCodigo(instcod);
				Integer infcod = datosInforme.getInfCod(); // id del informe
				model.addAttribute("email", authentication.getName());
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
				TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
				model.addAttribute("identificadorResponsable", datosUsuarioInterno.getIdentificador());
				model.addAttribute("infcod", datosInstitucion.get(0)[0].toString());
				model.addAttribute("nombreInstitución", datosInstitucion.get(0)[1].toString());
				model.addAttribute("identificadorInstitucion", datosInstitucion.get(0)[2].toString());
				model.addAttribute("representanteLegal", datosInstitucion.get(0)[3].toString());
				model.addAttribute("funcionInstitucion", datosInstitucion.get(0)[4].toString());
				model.addAttribute("descripcionInstitucion", datosInstitucion.get(0)[5].toString());
				model.addAttribute("sectorInstitucion", datosInstitucion.get(0)[6].toString());
				model.addAttribute("tipoFormulario", datosInstitucion.get(0)[7].toString());
				model.addAttribute("fecha", dateFormat.format(datosInstitucion.get(0)[8]));
				model.addAttribute("estado", datosInstitucion.get(0)[9].toString());
				model.addAttribute("periodoInforme", periodo);

				List<Object[]> calificacionesInforme = ics.qryBuscarCalifiaccionesInforme(infcod);
				if (calificacionesInforme.isEmpty() == true || calificacionesInforme.size() < 15) {
					model.addAttribute("estadoInforme", false);
				} else {
					model.addAttribute("estadoInforme", true);
					double porcentajeTotal = 0;// variable para sumar las calificaciones % de info correctamente entregada
					List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
					// model.addAttribute("comentario", datosInformeValorado.get(0)[4] == null ?
					// null : datosInformeValorado.get(0)[4].toString());
					model.addAttribute("fechaValoracion", dateFormat.format(datosInformeValorado.get(0)[1]));
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(0)[6] == null ? "0.0" : calificacionesInforme.get(0)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(1)[6] == null ? "0.0" : calificacionesInforme.get(1)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(2)[6] == null ? "0.0" : calificacionesInforme.get(2)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(3)[6] == null ? "0.0" : calificacionesInforme.get(3)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(4)[6] == null ? "0.0" : calificacionesInforme.get(4)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(5)[6] == null ? "0.0" : calificacionesInforme.get(5)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(6)[6] == null ? "0.0" : calificacionesInforme.get(6)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(7)[6] == null ? "0.0" : calificacionesInforme.get(7)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(8)[6] == null ? "0.0" : calificacionesInforme.get(8)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(9)[6] == null ? "0.0" : calificacionesInforme.get(9)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(10)[6] == null ? "0.0" : calificacionesInforme.get(10)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(11)[6] == null ? "0.0" : calificacionesInforme.get(11)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(12)[6] == null ? "0.0" : calificacionesInforme.get(12)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(13)[6] == null ? "0.0" : calificacionesInforme.get(13)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(14)[6] == null ? "0.0" : calificacionesInforme.get(14)[6].toString());
					if (porcentajeTotal>99.99) {
						porcentajeTotal=100.00;
					}
					model.addAttribute("porcentajeTotal", porcentajeTotal);
					model.addAttribute("infPeriodo",periodo.toString());
				}
		return "rendicion/retroalimentacion/RetroInformeMedioValorado";

	}

	//funcionando ok
	@RequestMapping(value = "/view/rendicion/RetroalimentacionInformeFEValorado", method = RequestMethod.POST)
	public String RetroalimentacionInformeFEValorado(Model model, Authentication authentication,
			@RequestParam("elementos") String infcodPeriodo) {
		// separamos id y periodo
		String[] parts = infcodPeriodo.split("-");
		Integer instcod = Integer.parseInt(parts[0]); // id de la institucion en ese periodo
		Integer periodo = Integer.parseInt(parts[1]); // periodo
		TblInforme datosInforme = is.obtenerDatosInformePorInstitucionCodigo(instcod);
		Integer infcod = datosInforme.getInfCod(); // id del informe

		model.addAttribute("email", authentication.getName());
		List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
		TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("identificadorResponsable", datosUsuarioInterno.getIdentificador());
		model.addAttribute("infcod", datosInstitucion.get(0)[0].toString());
		model.addAttribute("nombreInstitución", datosInstitucion.get(0)[1].toString());
		model.addAttribute("identificadorInstitucion", datosInstitucion.get(0)[2].toString());
		model.addAttribute("representanteLegal", datosInstitucion.get(0)[3].toString());
		model.addAttribute("funcionInstitucion", datosInstitucion.get(0)[4].toString());
		model.addAttribute("descripcionInstitucion", datosInstitucion.get(0)[5].toString());
		model.addAttribute("sectorInstitucion", datosInstitucion.get(0)[6].toString());
		model.addAttribute("tipoFormulario", datosInstitucion.get(0)[7].toString());
		model.addAttribute("fecha", dateFormat.format(datosInstitucion.get(0)[8]));
		model.addAttribute("estado", datosInstitucion.get(0)[9].toString());
		model.addAttribute("periodoInforme", periodo);

		List<Object[]> calificacionesInforme = ics.qryBuscarCalifiaccionesInforme(infcod);
		// si no se ha calificado aun el informe de la institucion se envia false y se
		// oculta en el formulario los datos de calificacion.

		if (calificacionesInforme.isEmpty() == true || calificacionesInforme.size() < 13) {
			model.addAttribute("estadoInforme", false);
		} else {
			model.addAttribute("estadoInforme", true);
			double porcentajeTotal = 0;// variable para sumar las calificaciones % de info correctamente entregada
			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
			// model.addAttribute("comentario",datosInformeValorado.get(0)[4] == null ? null
			// : datosInformeValorado.get(0)[4].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(0)[6] == null ? "0.0" : calificacionesInforme.get(0)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(1)[6] == null ? "0.0" : calificacionesInforme.get(1)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(2)[6] == null ? "0.0" : calificacionesInforme.get(2)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(3)[6] == null ? "0.0" : calificacionesInforme.get(3)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(4)[6] == null ? "0.0" : calificacionesInforme.get(4)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(5)[6] == null ? "0.0" : calificacionesInforme.get(5)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(6)[6] == null ? "0.0" : calificacionesInforme.get(6)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(7)[6] == null ? "0.0" : calificacionesInforme.get(7)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(8)[6] == null ? "0.0" : calificacionesInforme.get(8)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(9)[6] == null ? "0.0" : calificacionesInforme.get(9)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(10)[6] == null ? "0.0" : calificacionesInforme.get(10)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(11)[6] == null ? "0.0" : calificacionesInforme.get(11)[6].toString());
			porcentajeTotal += Double.parseDouble(
					calificacionesInforme.get(12)[6] == null ? "0.0" : calificacionesInforme.get(12)[6].toString());
			if (porcentajeTotal>99.99) {
				porcentajeTotal=100.00;
			}
			model.addAttribute("porcentajeTotal", porcentajeTotal);
			model.addAttribute("fechaValoracion", dateFormat.format(datosInformeValorado.get(0)[1]));
			model.addAttribute("infPeriodo",periodo.toString());
		}

		return "rendicion/retroalimentacion/RetroInformeFEValorado";

	}

	//ok ya esta
	@RequestMapping(value = "/view/rendicion/RetroalimentacionInformeFEEPValorado", method = RequestMethod.POST)
	public String RetroalimentacionInformeFEEPValorado(Model model, Authentication authentication,
			@RequestParam("elementos") String infcodPeriodo) {
		// separamos id y periodo
				String[] parts = infcodPeriodo.split("-");
				Integer instcod = Integer.parseInt(parts[0]); // id de la institucion en ese periodo
				Integer periodo = Integer.parseInt(parts[1]); // periodo
				TblInforme datosInforme = is.obtenerDatosInformePorInstitucionCodigo(instcod);
				Integer infcod = datosInforme.getInfCod(); // id del informe
				model.addAttribute("email", authentication.getName());
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
				TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
				model.addAttribute("identificadorResponsable", datosUsuarioInterno.getIdentificador());
				model.addAttribute("infcod", datosInstitucion.get(0)[0].toString());
				model.addAttribute("nombreInstitución", datosInstitucion.get(0)[1].toString());
				model.addAttribute("identificadorInstitucion", datosInstitucion.get(0)[2].toString());
				model.addAttribute("representanteLegal", datosInstitucion.get(0)[3].toString());
				model.addAttribute("funcionInstitucion", datosInstitucion.get(0)[4].toString());
				model.addAttribute("descripcionInstitucion", datosInstitucion.get(0)[5].toString());
				model.addAttribute("sectorInstitucion", datosInstitucion.get(0)[6].toString());
				model.addAttribute("tipoFormulario", datosInstitucion.get(0)[7].toString());
				model.addAttribute("fecha", dateFormat.format(datosInstitucion.get(0)[8]));
				model.addAttribute("estado", datosInstitucion.get(0)[9].toString());
				model.addAttribute("periodoInforme", periodo);

				List<Object[]> calificacionesInforme = ics.qryBuscarCalifiaccionesInforme(infcod);
				if (calificacionesInforme.isEmpty() == true || calificacionesInforme.size() < 16) {
					model.addAttribute("estadoInforme", false);
				} else {
					model.addAttribute("estadoInforme", true);
					double porcentajeTotal = 0;// variable para sumar las calificaciones % de info correctamente entregada
					List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
					// model.addAttribute("comentario", datosInformeValorado.get(0)[4] == null ?
					// null : datosInformeValorado.get(0)[4].toString());
					model.addAttribute("fechaValoracion", dateFormat.format(datosInformeValorado.get(0)[1]));
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(0)[6] == null ? "0.0" : calificacionesInforme.get(0)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(1)[6] == null ? "0.0" : calificacionesInforme.get(1)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(2)[6] == null ? "0.0" : calificacionesInforme.get(2)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(3)[6] == null ? "0.0" : calificacionesInforme.get(3)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(4)[6] == null ? "0.0" : calificacionesInforme.get(4)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(5)[6] == null ? "0.0" : calificacionesInforme.get(5)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(6)[6] == null ? "0.0" : calificacionesInforme.get(6)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(7)[6] == null ? "0.0" : calificacionesInforme.get(7)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(8)[6] == null ? "0.0" : calificacionesInforme.get(8)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(9)[6] == null ? "0.0" : calificacionesInforme.get(9)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(10)[6] == null ? "0.0" : calificacionesInforme.get(10)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(11)[6] == null ? "0.0" : calificacionesInforme.get(11)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(12)[6] == null ? "0.0" : calificacionesInforme.get(12)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(13)[6] == null ? "0.0" : calificacionesInforme.get(13)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(14)[6] == null ? "0.0" : calificacionesInforme.get(14)[6].toString());
					porcentajeTotal += Double.parseDouble(
							calificacionesInforme.get(15)[6] == null ? "0.0" : calificacionesInforme.get(15)[6].toString());
					if (porcentajeTotal>99.99) {
						porcentajeTotal=100.00;
					}
					model.addAttribute("porcentajeTotal", porcentajeTotal);
					model.addAttribute("infPeriodo",periodo.toString());
				}
		return "rendicion/retroalimentacion/RetroInformeFEEPValorado";

	}
	
	@RequestMapping(value = { "/obtenerRegistrosInformesValorados" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerRegistrosInformesValorados(Authentication authentication,
			@RequestParam("estado") String estado, @RequestParam("periodo") String periodo) {
		String json;
		// List<Object[]> listaRegistros = new ArrayList<>();
		List<SeguimientoInstitucionDTO> listaDto = new ArrayList<>();

		try {
			ObjectMapper mapper = new ObjectMapper();
			TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			List<Object[]> listaRegistros = (Constantes.hasRole("ROLE_SUBCOORDINADOR")
					|| Constantes.hasRole("ROLE_ADMIN"))
							? ais.qryBuscarInformesValoradosxSubcoordinadorNativo(periodo, estado)
							: ais.qryBuscarInformesAsignadosxtecnico(datosUsuario.getIdentificador(), periodo, estado);
			// Integer contador=0;
			if (listaRegistros.size() > 0) {
				listaDto = listaRegistros.stream()
						.map(obj -> SeguimientoInstitucionDTO.builder().inf_cod((Integer) obj[0])
								.contador(listaRegistros.indexOf(obj) + 1)
								.inst_nom(obj[1].toString())
								.inst_ruc(obj[2].toString())
								.fecha(obj[3].toString())
								.asigandor(obj[4].toString())
								.asignado(obj[7].toString())
								.estado(obj[5].toString())
								.nota(obj[7].toString())
								.informe(obj[6].toString())
								.fechaValo(obj.length > 8 && obj[8] != null ? obj[8].toString() : "NO VALORADO")
								.build())
						.collect(Collectors.toList());
				json = (!listaDto.isEmpty()) ? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(listaDto) + "}"
						: Constantes.MESSAGE_EMPTY_JSON;
			} else {
				json = "{\"data\": []}";
			}
		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}
		return json;
	}

}