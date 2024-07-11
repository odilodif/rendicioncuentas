package gob.cpccs.controller.tecnico;

import java.net.InetAddress;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import gob.cpccs.controller.HomeController;
import gob.cpccs.model.aplicacion.TblAplicaciones;
import gob.cpccs.model.aplicacion.TblAplicacionesRegistradas;
import gob.cpccs.model.catalogos.TblFuncion;
import gob.cpccs.model.catalogos.TblInstitucion;

import gob.cpccs.model.catalogos.TblLocalizacion;
import gob.cpccs.model.catalogos.TblSector;
import gob.cpccs.model.catalogos.TblTipoIes;
import gob.cpccs.model.catalogos.TblTipoInforme;
import gob.cpccs.model.catalogos.TblTipoMedio;
import gob.cpccs.model.dto.catalogos.CatastroDTO;
import gob.cpccs.model.dto.catalogos.IntitucionDTO;
import gob.cpccs.model.dto.catalogos.SeguimientoInstitucionDTO;
import gob.cpccs.model.dto.rendicion.CatastroTecnicoDTO;
import gob.cpccs.model.dto.rendicion.MecanismosGADDTO;
import gob.cpccs.model.dto.rendicion.ModalidadEstudiosIESDTO;
import gob.cpccs.model.funcionarios.TblDatosFuncionarios;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblInformeAutoridad;
import gob.cpccs.model.seguridad.TblHistoricoInstituciones;
import gob.cpccs.model.usuario.TblAutoridad;
import gob.cpccs.model.usuario.TblPerfil;
import gob.cpccs.model.usuario.TblResponables;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.model.usuario.TblUsuarioLocalizacion;
import gob.cpccs.model.usuario.TblUsuarioRol;
import gob.cpccs.service.aplicacion.AplicacionesServicio;
import gob.cpccs.service.autoridad.AutoridadServicio;
import gob.cpccs.service.catalogos.CatalogosServicio;
import gob.cpccs.service.catalogos.InstitucionServicio;
import gob.cpccs.service.mail.EmailService;
import gob.cpccs.service.rendicion.InformeServicio;
import gob.cpccs.service.seguridad.HistoricoInstitucionService;
import gob.cpccs.service.tecnico.TecnicoServicio;
import gob.cpccs.service.usuario.DatosFuncionariosService;
import gob.cpccs.service.usuario.ResponsableServicio;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;
import gob.cpccs.utilidades.EncriptarContrasenia;
import gob.cpccs.utilidades.DateUtil;

@Controller
public class TecnicoController {
	@Autowired
	private UsuarioServicio us;

	@Autowired
	private CatalogosServicio gcs;
	@Autowired
	private TecnicoServicio tecsv;
	@Autowired
	private ResponsableServicio respon;
	@Autowired
	private AutoridadServicio autori;
	@Autowired
	private EmailService ms;
	@Autowired
	private HomeController hc;
	@Autowired
	private AplicacionesServicio Apli;
	@Autowired
	private DatosFuncionariosService UsuInterno;
	@Autowired
	private InformeServicio infor;
	@Autowired
	private InstitucionServicio institucion;
	@Autowired
	private HistoricoInstitucionService his;

	@RequestMapping("/view/tecnicoNacional/ListaInstituciones")
	public String ListaInstituciones(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {

		List<Integer> list = new ArrayList<Integer>();
		TblUsuario identificadorlogin = us.buscarUsuarioXEmail(authentication.getName(), Constantes.periodo());
		if (hasRole("ROLE_NACIONAL")) {
			model.addAttribute("rol", "Nacional");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_NACIONAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");

			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		} else if (hasRole("ROLE_PROVINCIAL")) {
			model.addAttribute("rol", "Provincial");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_PROVINCIAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}
			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Administrador");
			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_ADMINISTRADOR);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");

			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		}

		return "tecnicoNacional/ListaInstituciones";
	}

	@RequestMapping("/view/tecnicoNacional/ListaAutoridades")
	public String ListaAutoridades(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {

		List<Integer> list = new ArrayList<Integer>();
		TblUsuario identificadorlogin = us.buscarUsuarioXEmail(authentication.getName(), Constantes.periodo());
		if (hasRole("ROLE_NACIONAL")) {
			model.addAttribute("rol", "Nacional");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_NACIONAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");

			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		} else if (hasRole("ROLE_PROVINCIAL")) {
			model.addAttribute("rol", "Provincial");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_PROVINCIAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}
			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Adminnistrador");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_ADMINISTRADOR);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");

			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		}

		return "tecnicoNacional/ListaAutoridades";
	}

	@RequestMapping("/view/tecnicoNacional/ListaTablaInstituciones")
	public String ListaTablaInstituciones(Model model, Authentication authentication,
			@RequestParam(value = "provincia", required = false) int provincia) {

		model.addAttribute("provincia", provincia);

		return "tecnicoNacional/ListaTablaInstituciones";
	}

	@RequestMapping("/view/tecnicoNacional/ListaTablaAutoridades")
	public String ListaTablaAutoridades(Model model, Authentication authentication,
			@RequestParam(value = "provincia", required = false) int provincia) {

		model.addAttribute("provincia", provincia);

		return "tecnicoNacional/ListaTablaAutoridades";
	}

	@RequestMapping(value = { "/obtenerRegistrosInstituciones" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerRegistrosInstituciones(Authentication authentication,
			@RequestParam("provincia") Integer provincia) {
		String json;
		try {
			String provincianombre;
			StringBuilder resultado = new StringBuilder();
			List<TblInstitucion> listaRegistros = gcs.ObtenerInstitucionesXprovinciaEstado(provincia,
					Constantes.ESTADO_REGISTRADO, Constantes.periodo());

			if (listaRegistros.size() > 0) {
				for (TblInstitucion datos : listaRegistros) {
					String fechaSolicitud = "";
					if (datos.getProvCod() != null) {
						TblLocalizacion provincias = gcs.obtenerNombreLocalizacion(1, datos.getProvCod(), "activo");
						provincianombre = provincias.getNombre();
					} else {
						provincianombre = " ";
					}
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					fechaSolicitud = df.format(datos.getInstFechaRegistro());

					int diasTrascurridos = 0;
					if (datos.getInstFechaRegistro() != null) {
						DateUtil dateUtil = new DateUtil();
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
						String fechaActual = formatter.format(new Date());
						String fechaIND = formatter.format(datos.getInstFechaRegistro());
						Date dateStart = formatter.parse(fechaIND);
						Date dateEnd = formatter.parse(fechaActual);
						diasTrascurridos = dateUtil.obtenerDiasLaborables(dateStart, dateEnd);
					}

					resultado.append("{\"inst_cod\":\"" + datos.getInstCod() + "\",\"" + "contador\":\""
							+ (listaRegistros.indexOf(datos) + 1) + "\",\"" + "dias_transcurridos\":\""
							+ diasTrascurridos + "\",\"" + "fecha\":\"" + fechaSolicitud + "\",\"" + "ruc\":\""
							+ (datos.getInstRuc() == null ? "" : datos.getInstRuc()) + "\",\"" + "provincia\":\""
							+ provincianombre + "\",\"" + "nombre\":\""
							+ datos.getInstNom().toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
							+ "\",\"" + "estado\":\"" + datos.getInstEstado().toUpperCase() + "\",\"" + "funcion\":\""
							+ datos.getInstFunCod().getFunDes() + "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}

	@RequestMapping(value = { "/obtenerRegistrosAutoridades" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerRegistrosAutoridades(Authentication authentication,
			@RequestParam("provincia") Integer provincia) {
		String json;
		try {
			String provincianombre;
			StringBuilder resultado = new StringBuilder();
			List<TblAutoridad> listaRegistros = gcs.ObtenerAutoridadXprovinciaEstado(provincia,
					Constantes.ESTADO_REGISTRADO, Constantes.periodo());

			if (listaRegistros.size() > 0) {
				for (TblAutoridad datos : listaRegistros) {
					String fechaSolicitud = "";
					if (datos.getProvincia() != null) {
						TblLocalizacion provincias = gcs.obtenerNombreLocalizacion(1, datos.getProvincia(), "activo");
						provincianombre = provincias.getNombre();
					} else {
						provincianombre = " ";
					}
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					fechaSolicitud = df.format(datos.getFechaRegistro());

					int diasTrascurridos = 0;
					if (datos.getFechaRegistro() != null) {
						DateUtil dateUtil = new DateUtil();
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
						String fechaActual = formatter.format(new Date());
						String fechaIND = formatter.format(datos.getFechaRegistro());
						Date dateStart = formatter.parse(fechaIND);
						Date dateEnd = formatter.parse(fechaActual);
						diasTrascurridos = dateUtil.obtenerDiasLaborables(dateStart, dateEnd);
					}

					resultado.append("{\"aut_codigo\":\"" + datos.getAutCodigo() + "\",\"" + "contador\":\""
							+ (listaRegistros.indexOf(datos) + 1) + "\",\"" + "dias_transcurridos\":\""
							+ diasTrascurridos + "\",\"" + "fecha\":\"" + fechaSolicitud + "\",\"" + "ruc\":\""
							+ (datos.getIdentificador() == null ? "" : datos.getIdentificador()) + "\",\""
							+ "provincia\":\"" + provincianombre + "\",\"" + "nombre\":\""
							+ datos.getNombre().toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
							+ "\",\"" + "estado\":\"" + datos.getEstado().toUpperCase() + "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}

	private boolean hasRole(String role) {

		SecurityContext context = SecurityContextHolder.getContext();

		if (context == null) {
			return false;
		}

		Authentication auth = context.getAuthentication();

		if (auth == null) {
			return false;
		}

		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

		return authorities.contains(new SimpleGrantedAuthority(role));

	}

	/* carga la vista principal de un menu llamado de BD */
	@RequestMapping("/view/tecnicoNacional/ListaEditarUsuInstitucion")
	public String ListaEditarUsuInstitucion(Model model, Authentication authentication) {
		List<Integer> list = new ArrayList<Integer>();
		TblUsuario identificadorlogin = us.buscarUsuarioXEmail(authentication.getName(), Constantes.periodo());
		if (hasRole("ROLE_NACIONAL")) {
			model.addAttribute("rol", "Nacional");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_NACIONAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");

			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		} else if (hasRole("ROLE_PROVINCIAL")) {
			model.addAttribute("rol", "Provincial");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_PROVINCIAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}
			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Administrador");
			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_ADMINISTRADOR);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}
			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		}

		return "tecnicoNacional/ListaEditarUsuInstitucion";
	}

	/* carga la vista principal de un menu llamado de BD */
	@RequestMapping("/view/tecnicoNacional/ListaEditarUsuAutoridades")
	public String ListaEditarUsuAutoridades(Model model, Authentication authentication) {
		List<Integer> list = new ArrayList<Integer>();
		TblUsuario identificadorlogin = us.buscarUsuarioXEmail(authentication.getName(), Constantes.periodo());
		if (hasRole("ROLE_NACIONAL")) {
			model.addAttribute("rol", "Nacional");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_NACIONAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");

			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		} else if (hasRole("ROLE_PROVINCIAL")) {
			model.addAttribute("rol", "Provincial");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_PROVINCIAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}
			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Administrador");
			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_ADMINISTRADOR);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");

			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);

		}

		return "tecnicoNacional/ListaEditarUsuAutoridades";
	}

	@RequestMapping("/view/tecnicoNacional/TablaPerilAutoridad")
	public String TablaPerilAutoridad(Model model, @Param(value = "provincia") Integer provincia) {
		model.addAttribute("provincia", provincia);
		return "tecnicoNacional/TablaPerilAutoridad";
	}

	@RequestMapping("/view/tecnicoNacional/TablaPerilInstitucion")
	public String TablaPerilInstitucion(Model model, @Param(value = "provincia") Integer provincia) {
		model.addAttribute("provincia", provincia);
		return "tecnicoNacional/TablaPerilInstitucion";
	}

	@RequestMapping(value = { "/obtenerUsuPerfilAutoridad" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerUsuPerfilAutoridad(Authentication authentication,
			@Param(value = "provincia") Integer provincia) {
		String json;
		try {

			StringBuilder resultado = new StringBuilder();

			List<Object[]> listaRegistoPerfilAuto = us.buscarUsuarioProvinciaEstadoPeriodo(provincia,
					Constantes.ESTADO_ACTIVO_USUARIOS, Constantes.periodo(), Constantes.TIPO_REGISTRO_AUTORIDAD);

			if (listaRegistoPerfilAuto.size() > 0) {

				for (Object[] item : listaRegistoPerfilAuto) {

					resultado
							.append("{\"id_user\":\"" + item[0] + "\",\"" + "contador\":\""
									+ (listaRegistoPerfilAuto.indexOf(item) + 1) + "\",\"" + "nombres\":\"" + item[4]
									+ "\",\"" + "email\":\"" + item[5] + "\",\"" + "cedula\":\"" + item[6] + "\",\""
									+ "pregunta1\":\"" + item[7] + "\",\"" + "pregunta2\":\"" + item[8] + "\"}")
							.append(",");

				}
				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";

			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
		}
		return json;
	}

	@RequestMapping(value = { "/obtenerUsuPerfilIntitucion" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerUsuPerfilIntitucion(Authentication authentication,
			@Param(value = "provincia") Integer provincia) {
		String json;
		ObjectMapper mapper = new ObjectMapper(); 
		try {

			StringBuilder resultado = new StringBuilder();

			List<Object[]> listaRegistoPerfil = us.buscarUsuarioProvinciaEstadoPeriodo(provincia,
					Constantes.ESTADO_ACTIVO_USUARIOS, Constantes.periodo(), Constantes.TIPO_REGISTRO_INSTITUCION);
			
			List<IntitucionDTO> lisIntitucionDTO = new ArrayList<>();
			
			if (listaRegistoPerfil.size() > 0) {
				
				lisIntitucionDTO = listaRegistoPerfil.stream().map(obj->IntitucionDTO.builder()
						.id_user ((Integer)obj[0])
						.contador(listaRegistoPerfil.indexOf(obj)+1)
						.intitucion(obj[1].toString())
						.nombres(obj[4].toString())
						.email(obj[5].toString())
						.cedula(obj[6].toString())
						//.pregunta1(obj[7].toString())
						.pregunta2(obj[8].toString())
						.nomInsti(obj[2].toString())
						.build())
						.collect(Collectors.toList());
				json = (!lisIntitucionDTO.isEmpty())
						? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lisIntitucionDTO) + "}"
						: Constantes.MESSAGE_EMPTY_JSON;

				/*for (Object[] item : listaRegistoPerfil) {
					resultado.append("{\"id_user\":\"" + item[0] + "\",\"" + "contador\":\""
							+ (listaRegistoPerfil.indexOf(item) + 1) + "\",\"" + "intitucion\":\"" + item[1] + "\",\""
							+ "nombres\":\"" + item[4] + "\",\"" + "email\":\"" + item[5] + "\",\"" + "cedula\":\""
							+ item[6] + "\",\"" + "pregunta1\":\"" + item[7] + "\",\"" + "pregunta2\":\"" + item[8] + "\",\""
							+ "nomInsti\":\"" + item[2]		
							+ "\"}").append(",");
				}
				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";*/

			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
		}
		return json;
	}

	@RequestMapping(value = { "/view/tecnicoNacional/EditarPerfilInstitucion" }, method = RequestMethod.POST)
	public String EditarPerfilInstitucion(Model model, @RequestParam("id") Integer id) throws ParseException {
		String pass = "Consejo" + (Constantes.periodo() + 1) + "*";
		TblUsuario tblUsuario = us.buscarUsuarioXid(id);
		String fechas = new SimpleDateFormat("dd/MM/yyyy").format(tblUsuario.getFechaNacimiento());
		model.addAttribute("usuarioC", tblUsuario.getTipoUser());

		if (tblUsuario.getTipoUser().equals("institucion")) {
			TblResponables tblResponables = respon.buscarResponxCodintituciotipoPeriodo(
					tblUsuario.getCodigoIntitucionAutorida(), Constantes.RESPONSABLE_REGISTRO,
					Integer.toString(Constantes.periodo()));
			model.addAttribute("tipo", tblUsuario.getTipoUser());
			model.addAttribute("nombres", tblUsuario.getNombre());
			model.addAttribute("cargo", tblResponables.getResponCargo());
			model.addAttribute("correo", tblUsuario.getEmail());
			model.addAttribute("cedula", tblUsuario.getIdentificador());
			model.addAttribute("nombreAbuela", tblUsuario.getNombreAbuela());
			model.addAttribute("fechaNaciomiento", fechas);
			model.addAttribute("celular", tblResponables.getResponCelular());
			model.addAttribute("fechaDesignacion",new SimpleDateFormat("dd/MM/yyyy").format(tblResponables.getResponFechaDesignacion()==null?"01/01/0001":tblResponables.getResponFechaDesignacion()));
			if (tblUsuario.getCodigoTemporal() != null) {
				model.addAttribute("passwordResponRegis", tblUsuario.getCodigoTemporal());

			} else {
				model.addAttribute("passwordResponRegis", pass);
			}

			model.addAttribute("codigoUser", tblUsuario.getIdUser());
			model.addAttribute("codigotipo", tblResponables.getResponCodigo());
			model.addAttribute("tipo", tblUsuario.getTipoUser());
		} else if (tblUsuario.getTipoUser().equals("autoridad")) {
			TblAutoridad tblAutoridad = autori.buscarAutordadCodAutPeriodo(tblUsuario.getCodigoIntitucionAutorida(),
					Constantes.periodo());
	        List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacion(1, "activo");
            model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);   
            List<TblLocalizacion> listadoLocalizacionCanton = gcs.obtenerLocalizacion(2, "activo");
            model.addAttribute("listadoLocalizacionCanton", listadoLocalizacionCanton);    
            List<TblLocalizacion> listadoLocalizacionParroquia = gcs.obtenerLocalizacion(4, "activo");
            model.addAttribute("listadoLocalizacionParroquia", listadoLocalizacionParroquia);	        
			model.addAttribute("tipo", tblUsuario.getTipoUser());
			model.addAttribute("nombres", tblUsuario.getNombre());
			model.addAttribute("cargo", tblAutoridad.getDignidad());
			model.addAttribute("correo", tblUsuario.getEmail());
			model.addAttribute("cedula", tblUsuario.getIdentificador());
			model.addAttribute("nombreAbuela", tblUsuario.getNombreAbuela());
			model.addAttribute("fechaNaciomiento", fechas);
			model.addAttribute("celular", tblAutoridad.getCelular());
			if (tblUsuario.getCodigoTemporal() != null) {
				model.addAttribute("passwordResponRegis", tblUsuario.getCodigoTemporal());

			} else {
				model.addAttribute("passwordResponRegis", pass);
			}
			model.addAttribute("codigoUser", tblUsuario.getIdUser());
			model.addAttribute("codigotipo", tblAutoridad.getAutCodigo());
			model.addAttribute("tipo", tblUsuario.getTipoUser());
			model.addAttribute("tblAutoridad", tblAutoridad);
		}

		return "tecnicoNacional/EditarPerfilInstitucion";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/tecnicoNacional/ActualizarDatosPerfil")
	public @ResponseBody String ActualizarDatosPerfil(@RequestParam("NombreResponRegis") String NombreResponRegis,
			@RequestParam("CorreoResponRegis") String CorreoResponRegis,
			@RequestParam("CedulaResponRegis") String CedulaResponRegis,
			@RequestParam("passwordResponRegis") String passwordResponRegis,
			@RequestParam("codigoUser") Integer codigoUser, 
			@RequestParam("codigotipo") Integer codigotipo,
			@RequestParam("tipo") String tipo, 
			@RequestParam("fechaNacimiento") String fechaNacimiento,
			@RequestParam("emailIdentificador") String emailIdentificador,
			/*@RequestParam("NombreAbuelaResponRegistro") String NombreAbuelaResponRegistro,*/
			@RequestParam(value = "fechaDesignacion", required = false) String fechaDesignacion,
			@RequestParam(value = "celularp", required = false) String celularp,
			@RequestParam(value = "CargoResponRegis", required = false) String CargoResponRegis,
			@RequestParam(value = "provincia2",required = false) Integer provincia,
			@RequestParam(value = "canton",required = false) Integer canton,
			@RequestParam(value="parroquia",required = false) Integer parroquia,
			@RequestParam(value="direccion",required = false) String direccion, 
			@RequestParam(value="web",required = false) String web, 
			@RequestParam(value="telefono", required = false) String telefono, 
			@RequestParam(value="institucion_dignidad",required = false) String institucionDignidad, 
			@RequestParam(value="ambito",required = false) String ambito, 
			@RequestParam(value="tipoAutoridad",required = false) String tipoAutoridad 
			) throws ParseException {

		// System.out.print("ingresa");
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		Date fechas = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);

		try {
			
			EncriptarContrasenia encriptarContrasenia = new EncriptarContrasenia();
			String Nuevopass = encriptarContrasenia.passwordEncoder().encode(passwordResponRegis);
			List<TblAplicacionesRegistradas> listaAplicaciones = us
					.buscarAplicacionesRegistradasPorEmaeilidentifiador(emailIdentificador);

			if (tipo.equals(Constantes.TIPO_REGISTRO_INSTITUCION)) {
				Date fechaD = new SimpleDateFormat("dd/MM/yyyy").parse(fechaDesignacion);
				for (TblAplicacionesRegistradas lista : listaAplicaciones) {
					us.actualizarAplicacionesRegistro(lista.getIdAplicacionRegistrada(), CedulaResponRegis,
							CorreoResponRegis.toLowerCase());

				}

				respon.actualizarResponsableXcod(NombreResponRegis.toUpperCase(), CorreoResponRegis.toLowerCase(),
						CargoResponRegis.toUpperCase(), codigotipo,fechaD,celularp );
				us.actualizarPerfil(NombreResponRegis.toUpperCase(), CorreoResponRegis.toLowerCase(), CedulaResponRegis,
						Nuevopass, codigoUser, fechas,"", passwordResponRegis);

				if (CorreoResponRegis != null && !CorreoResponRegis.equals("")) {
					ms.mailReseteoclavePerfil(CorreoResponRegis.toLowerCase(), NombreResponRegis, passwordResponRegis,
							true);

				}
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos Usuario institucion se han guardado correctamente.! ");

			} else if (tipo.equals(Constantes.TIPO_REGISTRO_AUTORIDAD)) {
				for (TblAplicacionesRegistradas lista : listaAplicaciones) {
					us.actualizarAplicacionesRegistro(lista.getIdAplicacionRegistrada(), CedulaResponRegis,
							CorreoResponRegis.toLowerCase());

				}
				TblAutoridad tblAutoridad = autori.buscarAutordadCodAut(codigotipo);
				tblAutoridad.setProvincia(provincia);
				tblAutoridad.setParroquia(parroquia);
				tblAutoridad.setCanton(canton);
				tblAutoridad.setDireccion(direccion);
				tblAutoridad.setWeb(web);
				tblAutoridad.setDignidad(CargoResponRegis);
				tblAutoridad.setEmail(CorreoResponRegis.toLowerCase());
				tblAutoridad.setTelefono(telefono);
				tblAutoridad.setInstitucionDignidad(institucionDignidad);
				tblAutoridad.setCelular(celularp);
				tblAutoridad.setAmbito(ambito);
				tblAutoridad.setTipoAutoridad(tipoAutoridad);
				autori.guardarAutoridad(tblAutoridad);

			/*	autori.actualizarAutoridadXid(NombreResponRegis.toUpperCase(), CedulaResponRegis,
						CorreoResponRegis.toLowerCase(), passwordResponRegis, CargoResponRegis, codigotipo);*/
				TblUsuario usuario = us.buscarUsuarioXid(codigoUser);
				usuario.setProvincia(provincia);
				us.guardarUsuario(usuario);
				
				us.actualizarPerfil(NombreResponRegis.toUpperCase(), CorreoResponRegis.toLowerCase(), CedulaResponRegis,
						Nuevopass, codigoUser, fechas, "", passwordResponRegis);
				if (CorreoResponRegis != null && !CorreoResponRegis.equals("")) {
					ms.mailReseteoclavePerfil(CorreoResponRegis.toLowerCase(), NombreResponRegis, passwordResponRegis,
							true);

				}
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos Usuario autoridad se han guardado correctamente.! ");

			} else {

				mensaje.put("estado", "error");
				mensaje.put("mensaje", "Datos no modificados, tipo usuario no encontrado.! ");

			}

		}

		catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();

		}
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/ValidarUsuarioPerfil", method = RequestMethod.POST)
	public @ResponseBody String ValidarUsuario(Model model, @RequestParam("correo") String CorreoResponRegis,
			@RequestParam("codigo") Integer codigoUser) {
		JSONObject mensaje = new JSONObject();
		try {
			if (CorreoResponRegis != "") {

				TblUsuario validarRegistro = us.BuscarEmailXperiodoIdUser(CorreoResponRegis, Constantes.periodo(),
						codigoUser);

				if (validarRegistro == null) {

					mensaje.put("valida", "nuevo");

				} else {
					mensaje.put("valida", "existe");
				}
			} else {
				mensaje.put("valida", "vacio");
			}
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	// Metodos para la creacion de prefiles//

	@RequestMapping(value = "/view/tecnicoNacional/Crear_Perfiles", method = RequestMethod.POST)
	public String Crear_Perfiles(Model model, Authentication authentication,@RequestParam("id") String id) {
		
		List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacion(1, "activo");
		model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		String pass = "Consejo" + (Constantes.periodo() + 1) + "*";
		model.addAttribute("password", pass);
		model.addAttribute("Verificador", "acceso");
		if (id.equals("_nuevo")) {
			
			model.addAttribute("TblUsuario", new TblUsuario());
		}else {
			model.addAttribute("DatosUsuario", us.obternerDatosUsuarioDatosFuncionarioUsuRol(Integer.parseInt(id)));
		}

		return "tecnicoNacional/Crear_Perfiles";
	}

	@RequestMapping("/view/tecnicoNacional/ListaFuncionarios")
	public String ListaFuncionarios(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {

		if (hasRole("ROLE_ADMIN")) {
			TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			model.addAttribute("rol", "Administrador");
			model.addAttribute("Verificador", "acceso");
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
			model.addAttribute("acciones", listaAcciones);

		} else {
			model.addAttribute("Verificador", "denegado");
		}
		return "tecnicoNacional/ListaFuncionarios";
	}

	@RequestMapping(value = { "/obtenerListaFuncionarios" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerListaFuncionarios(Authentication authentication) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();

			List<Object[]> listaTecnico = us.obteneUsuarioXtipo(Constantes.TIPO_REGISTRO_TECNICO,Constantes.periodo());

			if (listaTecnico.size() > 0) {

				for (Object[] item : listaTecnico) {

					resultado.append("{\"id_user\":\"" + item[0] + "\",\"" + "contador\":\""
							+ (listaTecnico.indexOf(item) + 1) + "\",\"" + "nombres\":\"" + item[1] + "\",\""
							+ "cedula\":\"" + item[2] + "\",\"" + "email\":\"" + item[3] + "\",\"" + "provincia\":\""
							+ (item[4] == null ? "" : item[4]) + "\",\"" + "estado\":\"" + item[5] + "\",\""
							+ "rol\":\"" + item[6] + "\"}").append(",");
				}
				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";

			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
		}
		return json;
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/tecnicoNacional/GuardarCrearPerfil")
	public @ResponseBody String GuardarCrearPerfil(@RequestParam("idUser") Integer idUser, @RequestParam("nombre") String nombre,
			@RequestParam("cedula") String cedula, @RequestParam("nacionalidad") String nacionalidad,
			@RequestParam("genero") String genero, @RequestParam("fechaNacimiento") String fechaNacimiento,
			@RequestParam("provincia") Integer provincia, @RequestParam("CorreoResponRegis") String CorreoResponRegis,
			@RequestParam("rol") Integer rol, @RequestParam("abuela") String abuela,
			@RequestParam("correopersonal") String correopersonal, @RequestParam("telefono") String telefono,
			@RequestParam("celular") String celular, @RequestParam("Cargo") String Cargo,
			@RequestParam("password") String password) throws ParseException {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");

		try {

			Date fechas = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);
			String rolnombre = "";
			Integer Perfil = 0;
			TblUsuario validarRegistro = us.BuscarUsuarioEmailXperido(CorreoResponRegis.toLowerCase(),
					Constantes.periodo());
			Boolean puedeAcceder = false;
			List<String> listaModulos = Arrays.asList("APLIC_RENCU_TECXX");
			ArrayList<Integer> listaPerfiles = new ArrayList<Integer>();

			switch (rol) {
			case 2:
				puedeAcceder = true;
				listaPerfiles.add(10);
				rolnombre = "ROLE_NACIONAL";
				Perfil = 10;

				break;
			case 3:
				puedeAcceder = true;
				listaPerfiles.add(11);
				rolnombre = "ROLE_PROVINCIAL";
				Perfil = 11;

				break;
			case 4:
				puedeAcceder = true;
				listaPerfiles.add(12);
				rolnombre = "ROLE_ADMIN";
				Perfil = 12;

				break;

			default:
				puedeAcceder = false;
			}
			  EncriptarContrasenia encriptarContrasenia = new EncriptarContrasenia();
			  TblDatosFuncionarios tblDatosFuncionarios = new TblDatosFuncionarios();
			  TblUsuario tblUsuario = new TblUsuario();

			if (validarRegistro == null) {
			

				if (puedeAcceder) {	
				  
					String pass = encriptarContrasenia.passwordEncoder().encode(password);
					
					TblDatosFuncionarios validarDatosFuncionario = UsuInterno.ObtenerDatodFuncionarioXidentificador(cedula);
					if (validarDatosFuncionario == null ) {
					// tbl_datos_funcionario					
						tblDatosFuncionarios.setIdentificador(cedula);
						tblDatosFuncionarios.setNombre(nombre.toUpperCase());
						tblDatosFuncionarios.setTipoDocumento("CEDULA");
						tblDatosFuncionarios.setNacionalidad(nacionalidad.toUpperCase());
						tblDatosFuncionarios.setGenero(genero);
						tblDatosFuncionarios.setFechaNacimiento(fechas);
						tblDatosFuncionarios.setFechaModificacion(new Date());
						tblDatosFuncionarios.setConvencional(telefono);
						tblDatosFuncionarios.setCelular(celular);
						tblDatosFuncionarios.setMailPersonal(correopersonal.toLowerCase());
						tblDatosFuncionarios.setEstadoEmpleado(Constantes.ESTADO_ACTIVO_USUARIOS.toString());
						tblDatosFuncionarios.setIdProvincia(provincia);
						tblDatosFuncionarios.setMailInstitucional(CorreoResponRegis.toLowerCase());
						tblDatosFuncionarios.setTipoEmpleado("interno");
						tblDatosFuncionarios.setPeriodo(Constantes.periodo());
						tblDatosFuncionarios.setCargo(Cargo);
						UsuInterno.guardarDatasFuncionarios(tblDatosFuncionarios);
					}
					// tbl_usuario					
					tblUsuario.setNombre(nombre.toUpperCase());
					tblUsuario.setIdentificador(cedula);
					tblUsuario.setEmail(CorreoResponRegis.toLowerCase());
					tblUsuario.setPassword(pass);
					tblUsuario.setFechaRegistro(new Date());
					tblUsuario.setEstado(Constantes.ESTADO_ACTIVO_USUARIOS);
					tblUsuario.setFechaNacimiento(fechas);
					tblUsuario.setNombreAbuela(abuela.toUpperCase());
					tblUsuario.setPeriodo(Constantes.periodo());
					tblUsuario.setCodigoTemporal(password);
					tblUsuario.setProvincia(provincia);
					tblUsuario.setCodigoIntitucionAutorida(tblDatosFuncionarios.getIdDatoFuncionario());
					tblUsuario.setTipoUser(Constantes.TIPO_REGISTRO_TECNICO);
					us.guardarUsuario(tblUsuario);

					List<TblAplicaciones> datosAplicaciones = Apli
							.buscarAplicacionesPorListaCodigoAplicacion(Constantes.ESTADO, listaModulos);

					if (datosAplicaciones.size() > 0) {
						for (TblAplicaciones datosAp : datosAplicaciones) {

							TblAplicaciones tblAplicaciones = new TblAplicaciones();
							tblAplicaciones.setIdAplicacion(datosAp.getIdAplicacion());
							List<TblAplicacionesRegistradas> datosApliRegis = us
									.buscarAplicacionesRegistradasPorIdentificadorAndIdAplicacion(
											tblUsuario.getIdentificador(), tblAplicaciones,
											CorreoResponRegis.toLowerCase(), Constantes.periodo().toString(),
											Constantes.ESTADO_ACTIVO_USUARIOS);

							if (datosApliRegis.size() == 0) {
								TblAplicacionesRegistradas tblAplicacionesRegistradas = new TblAplicacionesRegistradas();
								tblAplicacionesRegistradas.setIdAplicacion(tblAplicaciones);
								tblAplicacionesRegistradas.setIdentificador(tblUsuario.getIdentificador());
								tblAplicacionesRegistradas.setEmailIdentificador(tblUsuario.getEmail());
								tblAplicacionesRegistradas.setPeriodo(Constantes.periodo().toString());
								tblAplicacionesRegistradas.setEstado(Constantes.ESTADO_ACTIVO_USUARIOS);
								// tblAplicacionesRegistradas.setMensajeNotificacion("notificaciones");
								us.GuardarApliRegistradas(tblAplicacionesRegistradas);
							} else {

							}
							
							List<TblPerfil> datosPerfiles = us
									.buscarPerfilesEstadoPorListaCodigoPerfil(Constantes.ESTADO, listaPerfiles);

							for (TblPerfil datospe : datosPerfiles) {
								TblPerfil tblPerfil = new TblPerfil();
								tblPerfil.setIdPerfil(datospe.getIdPerfil());
								List<TblUsuarioRol> datosUsuaPerf = us
										.buscarUsuariosPerfilesPorIdentificadorAndIdPerfil(tblUsuario, tblPerfil);
								if (datosUsuaPerf.size() == 0) {
									
									TblUsuarioRol tblUsuarioRol = new TblUsuarioRol();
									tblUsuarioRol.setIdRol(us.buscarIdRolxNombre(rolnombre));
									tblUsuarioRol.setIdUser(tblUsuario);
									tblUsuarioRol.setUsurolEstado(Constantes.ESTADO_ACTIVO_USUARIOS);
									tblUsuarioRol.setUsurolDescripcion(datospe.getDescripcion());
									tblUsuarioRol.setIdPerfil(tblPerfil);
									us.GuardarRolUsuaru(tblUsuarioRol);
								}
							}

						}
					}

					if (rolnombre.equals("ROLE_NACIONAL") || rolnombre.equals("ROLE_ADMIN")) {						
						List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacion(1, "activo");

						for (TblLocalizacion tblLocalizacion : listadoLocalizacionProvincia) {
							TblUsuarioLocalizacion tblUsuarioLocalizacion = new TblUsuarioLocalizacion();
							tblUsuarioLocalizacion.setIdentificador(cedula);
							tblUsuarioLocalizacion.setRolCod(Perfil);
							tblUsuarioLocalizacion.setProvCod(tblLocalizacion.getIdLocalizacion());
							tblUsuarioLocalizacion.setPeriodo(Constantes.periodo());
							tecsv.guardarUsuarioLocalizacion(tblUsuarioLocalizacion);
						}

					} else if (rolnombre.equals("ROLE_PROVINCIAL")) {					
						TblUsuarioLocalizacion tblUsuarioLocalizacion = new TblUsuarioLocalizacion();
						tblUsuarioLocalizacion.setIdentificador(cedula);
						tblUsuarioLocalizacion.setRolCod(Perfil);
						tblUsuarioLocalizacion.setProvCod(provincia);
						tblUsuarioLocalizacion.setPeriodo(Constantes.periodo());
						tecsv.guardarUsuarioLocalizacion(tblUsuarioLocalizacion);

					}

					if (CorreoResponRegis != null && !CorreoResponRegis.equals("")) {
						ms.mailCreacionPerfil(CorreoResponRegis, nombre.toUpperCase(), password, true);

					}
					

					mensaje.put("estado", "exito");
					mensaje.put("mensaje", "Los datos del Usuario se han guardado correctamente.! ");

				
				} else {

					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Datos no modificados, No tiene permisos para realizar está tarea.! ");

				}

			} else {
//Metodo para editar los perfiles del tecnico68.
				if (puedeAcceder) {
						String pass = encriptarContrasenia.passwordEncoder().encode(password);
						// tbl_datos_funcionario						
						tblDatosFuncionarios=UsuInterno.ObtenerDatodFuncionarioXidentificador(cedula);
						tblDatosFuncionarios.setIdentificador(cedula);
						tblDatosFuncionarios.setNombre(nombre.toUpperCase());
						tblDatosFuncionarios.setTipoDocumento("CEDULA");
						tblDatosFuncionarios.setNacionalidad(nacionalidad.toUpperCase());
						tblDatosFuncionarios.setGenero(genero);
						tblDatosFuncionarios.setFechaNacimiento(fechas);
						tblDatosFuncionarios.setFechaModificacion(new Date());
						tblDatosFuncionarios.setConvencional(telefono);
						tblDatosFuncionarios.setCelular(celular);
						tblDatosFuncionarios.setMailPersonal(correopersonal.toLowerCase());
						tblDatosFuncionarios.setEstadoEmpleado(Constantes.ESTADO_ACTIVO_USUARIOS.toString());
						tblDatosFuncionarios.setIdProvincia(provincia);
						tblDatosFuncionarios.setMailInstitucional(CorreoResponRegis.toLowerCase());
						tblDatosFuncionarios.setTipoEmpleado("interno");
						tblDatosFuncionarios.setPeriodo(Constantes.periodo());
						tblDatosFuncionarios.setCargo(Cargo);
						UsuInterno.guardarDatasFuncionarios(tblDatosFuncionarios);

						// tbl_usuario	
						tblUsuario=us.buscarUsuarioXid(idUser);
						tblUsuario.setNombre(nombre.toUpperCase());
						tblUsuario.setIdentificador(cedula);
						tblUsuario.setEmail(CorreoResponRegis.toLowerCase());
						tblUsuario.setPassword(pass);
						tblUsuario.setFechaRegistro(new Date());
						tblUsuario.setEstado(Constantes.ESTADO_ACTIVO_USUARIOS);
						tblUsuario.setFechaNacimiento(fechas);
						tblUsuario.setNombreAbuela(abuela.toUpperCase());
						tblUsuario.setPeriodo(Constantes.periodo());
						tblUsuario.setCodigoTemporal(password);
						tblUsuario.setProvincia(provincia);
						tblUsuario.setCodigoIntitucionAutorida(tblDatosFuncionarios.getIdDatoFuncionario());
						tblUsuario.setTipoUser(Constantes.TIPO_REGISTRO_TECNICO);
						us.guardarUsuario(tblUsuario);

						List<TblAplicaciones> datosAplicaciones = Apli
								.buscarAplicacionesPorListaCodigoAplicacion(Constantes.ESTADO, listaModulos);

						if (datosAplicaciones.size() > 0) {
							for (TblAplicaciones datosAp : datosAplicaciones) {

								TblAplicaciones tblAplicaciones = new TblAplicaciones();
								tblAplicaciones.setIdAplicacion(datosAp.getIdAplicacion());
								List<TblAplicacionesRegistradas> datosApliRegis = us
										.buscarAplicacionesRegistradasPorIdentificadorAndIdAplicacion(
												tblUsuario.getIdentificador(), tblAplicaciones,
												CorreoResponRegis.toLowerCase(), Constantes.periodo().toString(),
												Constantes.ESTADO_ACTIVO_USUARIOS);

								if (datosApliRegis.size() == 0) {
									TblAplicacionesRegistradas tblAplicacionesRegistradas = new TblAplicacionesRegistradas();
									tblAplicacionesRegistradas.setIdAplicacion(tblAplicaciones);
									tblAplicacionesRegistradas.setIdentificador(tblUsuario.getIdentificador());
									tblAplicacionesRegistradas.setEmailIdentificador(tblUsuario.getEmail());
									// tblAplicacionesRegistradas.setMensajeNotificacion("notificaciones");
									us.GuardarApliRegistradas(tblAplicacionesRegistradas);
								} else {
									for (TblAplicacionesRegistradas tblAplicacionesRegistradas : datosApliRegis){
										//tblAplicacionesRegistradas.setIdAplicacionRegistrada(tblAplicacionesRegistradas.getIdAplicacionRegistrada());
										tblAplicacionesRegistradas.setIdAplicacion(tblAplicaciones);
										tblAplicacionesRegistradas.setIdentificador(tblUsuario.getIdentificador());
										tblAplicacionesRegistradas.setEmailIdentificador(tblUsuario.getEmail());
										tblAplicacionesRegistradas.setPeriodo(Constantes.periodo().toString());
										tblAplicacionesRegistradas.setEstado(Constantes.ESTADO_ACTIVO_USUARIOS);
										// tblAplicacionesRegistradas.setMensajeNotificacion("notificaciones");
										us.GuardarApliRegistradas(tblAplicacionesRegistradas);
									}

								}
								List<TblPerfil> datosPerfiles = us
										.buscarPerfilesEstadoPorListaCodigoPerfil(Constantes.ESTADO, listaPerfiles);

								for (TblPerfil datospe : datosPerfiles) {
									TblPerfil tblPerfil = new TblPerfil();
									tblPerfil.setIdPerfil(datospe.getIdPerfil());
									List<TblUsuarioRol> datosUsuaPerf = us.obtenerListUsuarioRolXid(tblUsuario.getIdUser());
									if (datosUsuaPerf.size() == 0) {
										
										TblUsuarioRol tblUsuarioRol = new TblUsuarioRol();
										tblUsuarioRol.setIdRol(us.buscarIdRolxNombre(rolnombre));
										tblUsuarioRol.setIdUser(tblUsuario);
										tblUsuarioRol.setUsurolEstado(Constantes.ESTADO_ACTIVO_USUARIOS);
										tblUsuarioRol.setUsurolDescripcion(datospe.getDescripcion());
										tblUsuarioRol.setIdPerfil(tblPerfil);
										us.GuardarRolUsuaru(tblUsuarioRol);
									}else {
										for (TblUsuarioRol rolXusu : datosUsuaPerf) {
											rolXusu.setIdRol(us.buscarIdRolxNombre(rolnombre));
											rolXusu.setIdUser(tblUsuario);
											rolXusu.setUsurolEstado(Constantes.ESTADO_ACTIVO_USUARIOS);
											rolXusu.setUsurolDescripcion(datospe.getDescripcion());
											rolXusu.setIdPerfil(tblPerfil);
											us.GuardarRolUsuaru(rolXusu);
											
											
										}
									}
								}

							}
						}

						if (rolnombre.equals("ROLE_NACIONAL") || rolnombre.equals("ROLE_ADMIN")) {
							
							tecsv.DeleteEstadoTblLocalizacionXidentificador(cedula,Constantes.periodo());
							List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacion(1, "activo");

							for (TblLocalizacion tblLocalizacion : listadoLocalizacionProvincia) {
								TblUsuarioLocalizacion tblUsuarioLocalizacion = new TblUsuarioLocalizacion();
								tblUsuarioLocalizacion.setIdentificador(cedula);
								tblUsuarioLocalizacion.setRolCod(Perfil);
								tblUsuarioLocalizacion.setProvCod(tblLocalizacion.getIdLocalizacion());
								tblUsuarioLocalizacion.setPeriodo(Constantes.periodo());
								tecsv.guardarUsuarioLocalizacion(tblUsuarioLocalizacion);
							}

						} else if (rolnombre.equals("ROLE_PROVINCIAL")) {
							tecsv.DeleteEstadoTblLocalizacionXidentificador(cedula,Constantes.periodo());
							TblUsuarioLocalizacion tblUsuarioLocalizacion = new TblUsuarioLocalizacion();
							tblUsuarioLocalizacion.setIdentificador(cedula);
							tblUsuarioLocalizacion.setRolCod(Perfil);
							tblUsuarioLocalizacion.setProvCod(provincia);
							tblUsuarioLocalizacion.setPeriodo(Constantes.periodo());
							tecsv.guardarUsuarioLocalizacion(tblUsuarioLocalizacion);

						}
						if (CorreoResponRegis != null && !CorreoResponRegis.equals("")) {
							ms.mailCreacionPerfil(CorreoResponRegis, nombre.toUpperCase(), password, true);

						}

						mensaje.put("estado", "exito");
						mensaje.put("mensaje", "Los datos del Usuario se han guardado correctamente.! ");

					

					
				} else {

					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Datos no modificados, No tiene permisos para realizar está tarea.! ");

				}

			}

		}

		catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();

		}
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/DesactivarPerfil", method = RequestMethod.POST)
	public @ResponseBody String DesactivarPerfil(Model model, @RequestParam("codigo") String id) {
		JSONObject mensaje = new JSONObject();
		try {
			if (id != "") {

				TblUsuario tblUsuario = us.buscarUsuarioXid(Integer.parseInt(id));
				tblUsuario.setEstado(Constantes.ESTADO_INACTIVO_USUARIOS);
				us.guardarUsuario(tblUsuario);
				TblUsuarioRol tblUsuarioRol = us.obtenerUsuarioRolXid(Integer.parseInt(id));
				tblUsuarioRol.setUsurolEstado(Constantes.ESTADO_INACTIVO_USUARIOS);
				us.GuardarRolUsuaru(tblUsuarioRol);
				List<TblAplicacionesRegistradas>  tblAplicacionesRegistradas=us.buscarAplicacionesRegistradasPorEmaeilIdentifiadorPerioEstado(tblUsuario.getEmail(),Constantes.periodo().toString(),Constantes.ESTADO_ACTIVO_USUARIOS);
				 for (TblAplicacionesRegistradas datos : tblAplicacionesRegistradas) {
					datos.setEstado(Constantes.ESTADO_INACTIVO_USUARIOS);
					us.GuardarApliRegistradas(datos);
				}	
						
				//TblDatosFuncionarios tblDatosFuncionarios = UsuInterno.ObtenerDatodFuncionarioXCod(tblUsuario.getCodigoIntitucionAutorida());
				 TblDatosFuncionarios tblDatosFuncionarios = UsuInterno.ObtenerDatodFuncionarioXidentificador(tblUsuario.getIdentificador());
				 tblDatosFuncionarios.setEstadoEmpleado(Constantes.ESTADO_INACTIVO_USUARIOS.toString());
				UsuInterno.guardarDatasFuncionarios(tblDatosFuncionarios);
				mensaje.put("valida", "deshabilitado");

			} else {
				mensaje.put("valida", "vacio");
			}
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/ActivarPerfil", method = RequestMethod.POST)
	public @ResponseBody String ActivarPerfil(Model model, @RequestParam("codigo") String id) {
		JSONObject mensaje = new JSONObject();
		try {
			if (id != "") {

				TblUsuario tblUsuario = us.buscarUsuarioXid(Integer.parseInt(id));
				tblUsuario.setEstado(Constantes.ESTADO_ACTIVO_USUARIOS);
				us.guardarUsuario(tblUsuario);
				TblUsuarioRol tblUsuarioRol = us.obtenerUsuarioRolXid(Integer.parseInt(id));
				tblUsuarioRol.setUsurolEstado(Constantes.ESTADO_ACTIVO_USUARIOS);
				us.GuardarRolUsuaru(tblUsuarioRol);
				List<TblAplicacionesRegistradas>  tblAplicacionesRegistradas=us.buscarAplicacionesRegistradasPorEmaeilIdentifiadorPerioEstado(tblUsuario.getEmail(),Constantes.periodo().toString(),Constantes.ESTADO_INACTIVO_USUARIOS);
				 for (TblAplicacionesRegistradas datos : tblAplicacionesRegistradas) {
					datos.setEstado(Constantes.ESTADO_ACTIVO_USUARIOS);
					us.GuardarApliRegistradas(datos);
				}			
					
				//TblDatosFuncionarios tblDatosFuncionarios = UsuInterno.ObtenerDatodFuncionarioXCod(tblUsuario.getCodigoIntitucionAutorida());
				TblDatosFuncionarios tblDatosFuncionarios = UsuInterno.ObtenerDatodFuncionarioXidentificador(tblUsuario.getIdentificador());
				tblDatosFuncionarios.setEstadoEmpleado(Constantes.ESTADO_ACTIVO_USUARIOS.toString());
				UsuInterno.guardarDatasFuncionarios(tblDatosFuncionarios);
				mensaje.put("valida", "PerfilActivo");

			} else {
				mensaje.put("valida", "vacio");
			}
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}
	// Fin metodos Creacion de Perfiles//

	// metodos para ver lista de instituciones activas//
	@RequestMapping("/view/tecnicoNacional/ListaInstitucionesActivas")
	public String ListaInstitucionesActivas(Model model, Authentication authentication) {
		TblUsuario identificadorlogin = us.buscarUsuarioXEmail(authentication.getName(), Constantes.periodo());
		if (hasRole("ROLE_NACIONAL")) {
			model.addAttribute("rol", "Nacional");

		} else if (hasRole("ROLE_PROVINCIAL")) {
			model.addAttribute("rol", "Provincial");
			TblUsuarioLocalizacion provincias = tecsv.obtenerLocalizacionXtecnicoProvincial(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_PROVINCIAL);
			model.addAttribute("provincia", provincias.getProvCod());
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Administrador");

		}
		return "tecnicoNacional/ListaInstitucionesActivas";
	}

	@RequestMapping("/view/tecnicoNacional/ListaIntitucionesInactivas")
	public String ListaIntitucionesInactivas(Model model, Authentication authentication) {
		TblUsuario identificadorlogin = us.buscarUsuarioXEmail(authentication.getName(), Constantes.periodo());
		if (hasRole("ROLE_NACIONAL")) {
			model.addAttribute("rol", "Nacional");

		} else if (hasRole("ROLE_PROVINCIAL")) {
			model.addAttribute("rol", "Provincial");
			TblUsuarioLocalizacion provincias = tecsv.obtenerLocalizacionXtecnicoProvincial(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_PROVINCIAL);
			model.addAttribute("provincia", provincias.getProvCod());
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Administrador");

		}
		return "tecnicoNacional/ListaIntitucionesInactivas";
	}

	@RequestMapping(value = { "/obtenerIntitucionesActivasTecNacional" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerIntitucionesActivasTecNacional(Authentication authentication,
			@RequestParam("estado") String estado) {
		String json;
		
		ObjectMapper mapper = new ObjectMapper(); 
		 List<CatastroTecnicoDTO> lista = new ArrayList<>();
		try {
			StringBuilder resultado = new StringBuilder();
			List<Object[]> listaRegistros = gcs.ObtenerInstitucionesXPeriodoEstado(estado, Constantes.periodo());
			
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date fechaSolicitud;
			if (listaRegistros.size() > 0) {

				for (Object[] datos : listaRegistros) {
					
					CatastroTecnicoDTO tabla1= new CatastroTecnicoDTO();
					tabla1.setInst_cod((Integer)datos[0]);
					tabla1.setContador(listaRegistros.indexOf(datos)+1);
					if(datos[5] == null) {tabla1.setFecha("");}else{tabla1.setFecha(df.format(datos[5]).toString());};
					tabla1.setRuc(datos[2] == null ? "" : datos[2].toString());
					tabla1.setProvincia(datos[3].toString());
					tabla1.setNombre(datos[1].toString());
					tabla1.setEstado(datos[6].toString());
					tabla1.setFuncion(datos[4].toString());
					lista.add(tabla1);
					
					/*String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[5] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[5]);
					}

					resultado.append("{\"inst_cod\":\"" + datos[0] + "\",\"" + "contador\":\""
							+ (listaRegistros.indexOf(datos) + 1) + "\",\"" + "fecha\":\"" + fechaSolicitud + "\",\""
							+ "ruc\":\"" + (datos[2] == null ? "" : datos[2]) + "\",\"" + "provincia\":\"" + datos[3]
							+ "\",\"" + "nombre\":\""
							+ datos[1].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
							+ "\",\"" + "estado\":\"" + datos[6].toString().toUpperCase() + "\",\"" + "funcion\":\""
							+ datos[4] + "\"}").append(",");*/

				}
				json = (!lista.isEmpty())
						? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(lista) + "}"
						: Constantes.MESSAGE_EMPTY_JSON;

				//json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}

	@RequestMapping(value = { "/obtenerIntitucionesActivasTecProvincial" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerIntitucionesActivasTecProvincial(Authentication authentication,
			@RequestParam("provincia") Integer provincia, @RequestParam("estado") String estado) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
			List<Object[]> listaRegistros = gcs.ObtenerInstitucionesXprovinciaEstadoPeriodo(provincia, estado,
					Constantes.periodo());

			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[5] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[5]);
					}

					resultado.append("{\"inst_cod\":\"" + datos[0] + "\",\"" + "contador\":\""
							+ (listaRegistros.indexOf(datos) + 1) + "\",\"" + "fecha\":\"" + fechaSolicitud + "\",\""
							+ "ruc\":\"" + (datos[2] == null ? "" : datos[2]) + "\",\"" + "provincia\":\"" + datos[3]
							+ "\",\"" + "nombre\":\""
							+ datos[1].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
							+ "\",\"" + "estado\":\"" + datos[6].toString().toUpperCase() + "\",\"" + "funcion\":\""
							+ datos[4] + "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}
	// FIn metodos para ver lista de instituciones activas//

	// Metodos PAra gestion de Catastro//

	/* carga la vista principal de un menu llamado de BD */
	@RequestMapping("/view/tecnicoNacional/ListadoCatastro")
	public String ListadoCatastro(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {
		
		model.addAttribute("anios", getPeriodos(2020));
		model.addAttribute("Periodo", Constantes.periodo());
		if (hasRole("ROLE_ADMIN")) {
			TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			model.addAttribute("rol", "Administrador");
			model.addAttribute("Verificador", "acceso");
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
			model.addAttribute("acciones", listaAcciones);

			List<TblDatosFuncionarios> listadoFuncionarioSubcordinador = UsuInterno
					.obtenerFuncionarioXCargo(Constantes.ESTADO_ACTIVO_USUARIOS.toString(), "SUBCOORDINADOR");
			model.addAttribute("listadoFuncionarioSubcordinador", listadoFuncionarioSubcordinador);

			List<TblDatosFuncionarios> listadoFuncionariosRc = UsuInterno
					.obtenerFuncionarios(Constantes.ESTADO_ACTIVO_USUARIOS.toString());
			model.addAttribute("listadoFuncionariosRc", listadoFuncionariosRc);

		} else if (hasRole("ROLE_NACIONAL")) {
			TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			model.addAttribute("rol", "Nacional");
			model.addAttribute("Verificador", "acceso");
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
			model.addAttribute("acciones", listaAcciones);

			List<TblDatosFuncionarios> listadoFuncionarioSubcordinador = UsuInterno
					.obtenerFuncionarioXCargo(Constantes.ESTADO_ACTIVO_USUARIOS.toString(), "SUBCOORDINADOR");
			model.addAttribute("listadoFuncionarioSubcordinador", listadoFuncionarioSubcordinador);

			List<TblDatosFuncionarios> listadoFuncionariosRc = UsuInterno
					.obtenerFuncionarios(Constantes.ESTADO_ACTIVO_USUARIOS.toString());
			model.addAttribute("listadoFuncionariosRc", listadoFuncionariosRc);

		}

		else {
			model.addAttribute("Verificador", "denegado");
		}
		return "tecnicoNacional/ListadoCatastro";
	}

	@RequestMapping(value = { "/obtenerRegistrosCatastro" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerRegistrosCatastro(@RequestParam("periodo") Integer periodo) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
			ObjectMapper mapper=new ObjectMapper();
			
			List<Object[]> listaRegistros = gcs.ObtenerInstitucionesXPeriodo(periodo);
			 List<CatastroDTO> ListaDTO=new ArrayList<>();

			if (listaRegistros.size() > 0) {
				 
				ListaDTO= listaRegistros.stream().map(obj ->
				CatastroDTO.builder()
				.inst_cod((Integer)obj[0])
				.fecha((Date)obj[5])
				.accion(obj[7] == null ? "SN" : obj[7].toString())
				.archivo(obj[8] == null ? "SN" : obj[8].toString())
				.nombre(obj[1].toString())
				.ruc(obj[2] == null ? "" : obj[2].toString())
				.provincia(obj[3].toString())
				.estado(obj[6].toString().toUpperCase())
				.funcion(obj[4].toString())
				.build()
				).collect(Collectors.toList());
				
				json=(!ListaDTO.isEmpty())?
						Constantes.MESSAGE_OK_JSON+mapper.writeValueAsString(ListaDTO)+"}":
						Constantes.MESSAGE_EMPTY_JSON;
				
				
/*
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[5] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[5]);
					}

					resultado.append("{\"inst_cod\":\"" + datos[0] + "\",\"" + "contador\":\""
							+ (listaRegistros.indexOf(datos) + 1) + "\",\"" + "fecha\":\"" + fechaSolicitud + "\",\""
							+ "accion\":\"" + (datos[7] == null ? "SN" : datos[7]) + "\",\"" + "archivo\":\""
							+ (datos[8] == null ? "SN" : datos[8]) + "\",\"" + "ruc\":\""
							+ (datos[2] == null ? "" : datos[2]) + "\",\"" + "provincia\":\"" + datos[3] + "\",\""
							+ "nombre\":\""
							+ datos[1].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
							+ "\",\"" + "estado\":\"" + datos[6].toString().toUpperCase() + "\",\"" + "funcion\":\""
							+ datos[4] + "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";*/
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}

	@RequestMapping(value = "/view/tecnicoNacional/NuevoCatastro", method = RequestMethod.POST)
	public String vistaNuevoRegistroCatastro(Model model) {

		List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacion(1, "activo");
		model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);

		List<TblLocalizacion> listadoLocalizacionCanton = gcs.obtenerLocalizacion(2, "activo");
		model.addAttribute("listadoLocalizacionCanton", listadoLocalizacionCanton);

		List<TblLocalizacion> listadoLocalizacionParroquia = gcs.obtenerLocalizacion(4, "activo");
		model.addAttribute("listadoLocalizacionParroquia", listadoLocalizacionParroquia);

		List<TblFuncion> listadoFuncion = gcs.obtenerFuncionInstitucion(Constantes.ESTADO);
		model.addAttribute("listadoFuncion", listadoFuncion);

		List<TblTipoInforme> listadoTipoInforme = gcs.obtenerTipoInforme(Constantes.ESTADO);
		model.addAttribute("listadoTipoInforme", listadoTipoInforme);

		List<TblTipoMedio> listadoTipoMedio = gcs.obtenerTipoMedio(Constantes.ESTADO);
		model.addAttribute("listadoTipoMedio", listadoTipoMedio);
		
		List<TblTipoIes> ListaTipoIes= gcs.ListaTipoIesPorEstado(Constantes.ESTADO);
		model.addAttribute("ListaTipoIes", ListaTipoIes);

		List<TblSector> listadoTipoSector = gcs.obtenerTipoSector(Constantes.ESTADO);
		model.addAttribute("listadoTipoSector", listadoTipoSector);

		List<TblDatosFuncionarios> listadoFuncionario = UsuInterno
				.obtenerFuncionarioXCargo(Constantes.ESTADO_ACTIVO_USUARIOS.toString(), "SUBCOORDINADOR");
		model.addAttribute("listadoFuncionario", listadoFuncionario);
		

		List<TblDatosFuncionarios> listadoFuncionariosRc = UsuInterno
				.obtenerFuncionarios(Constantes.ESTADO_ACTIVO_USUARIOS.toString());
		model.addAttribute("listadoFuncionariosRc", listadoFuncionariosRc);

		return "tecnicoNacional/NuevoCatastro";
	}

	@RequestMapping(value = { "/obtenerRegistrosRuc" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerRegistrosRuc(@RequestParam("codigo") String ruc) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
			
			List<Object[]> listaRegistros = gcs.ObtenerInstitucionesXRuc(ruc, Constantes.periodo());

			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					if (datos[5] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[5]);
					}

					resultado.append("{\"inst_cod\":\"" + datos[0] + "\",\"" + "contador\":\""
							+ (listaRegistros.indexOf(datos) + 1) + "\",\"" + "fecha\":\"" + fechaSolicitud + "\",\""
							+ "accion\":\"" + (datos[7] == null ? "SN" : datos[7]) + "\",\"" + "archivo\":\""
							+ (datos[8] == null ? "SN" : datos[8]) + "\",\"" + "ruc\":\""
							+ (datos[2] == null ? "" : datos[2]) + "\",\"" + "provincia\":\"" + datos[3] + "\",\""
							+ "nombre\":\""
							+ datos[1].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
							+ "\",\"" + "estado\":\"" + datos[6].toString().toUpperCase() + "\",\"" + "funcion\":\""
							+ datos[4] + "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}

	/* Metodo Guardar */
	@GetMapping("/view/tecnicoNacional/GuardarNuevoCatastro")
	public String accesoNoAutorizadoGuardarCatastro(TblInstitucion tblInstitucion) {
		return "redirect:../../index";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/tecnicoNacional/GuardarNuevoCatastro")
	public @ResponseBody String GuardarNuevoCatastro(HttpServletRequest request, Authentication authentication,
			@RequestParam("instNom") String instNom, 
			@RequestParam("instRuc") String instRuc,
			@RequestParam("provCod") Integer provCod,
			@RequestParam(value = "cantCod", required = false) Integer cantCod,
			@RequestParam(value = "parroCod", required = false) Integer parroCod,
			@RequestParam("instFunCod") Integer instFunCod, 
			@RequestParam("instTipDes") String instTipDes,
			@RequestParam("instTfCod") Integer instTfCod, 
			@RequestParam(value ="instTmeCod", required = false) Integer instTmeCod,
			@RequestParam("instSecCod") Integer instSecCod,
			@RequestParam(value = "instDesUdaf", required = false) String instDesUdaf,
			@RequestParam("aprobado") Integer aprobado,
			// @RequestParam("solicitado") Integer solicitado,
			@RequestParam("pathModuloVerifica") String pathModuloVerifica,
			@RequestParam(value ="tiesCod", required = false) Integer tiesCod) {
		// System.out.print("ingresa");
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			String DatoNuevo = null;
			TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblFuncion tblFuncion = gcs.ObtenerFuncionXid(instFunCod);
			TblTipoInforme tblTipoInforme = gcs.ObtenerTipoInformeXCod(instTfCod);
			if (instTmeCod == null) {
				instTmeCod = 0;
			}
			TblTipoMedio tblTipoMedio = gcs.ObtenerTipoMedioXid(instTmeCod);
			TblSector tblSector = gcs.ObtenerSectorXid(instSecCod);
			
			TblTipoIes tblIes=gcs.TipoIesPorTiesCod(tiesCod);

			TblDatosFuncionarios Subcoordinador = UsuInterno.ObtenerDatodFuncionarioXCod(aprobado);
			// TblDatosFuncionarios Solicitado =
			// UsuInterno.ObtenerDatodFuncionarioXCod(solicitado);
			TblAplicacionesRegistradas listaAplicaciones = us.buscarAplicacionRegistradaPorEmaeilidentifiador(
					datosUsuario.getEmail(), Constantes.periodo().toString(), Constantes.ESTADO_ACTIVO_USUARIOS);

			TblInstitucion tblInstitucion = new TblInstitucion();

			tblInstitucion.setInstRuc(instRuc);
			tblInstitucion.setInstNom(instNom.toUpperCase());
			tblInstitucion.setProvCod(provCod);
			tblInstitucion.setCantCod(cantCod);
			tblInstitucion.setParroCod(parroCod);
			tblInstitucion.setInstTfCod(tblTipoInforme);
			tblInstitucion.setInstTmeCod(tblTipoMedio);
			tblInstitucion.setInstSecCod(tblSector);
			tblInstitucion.setInstFunCod(tblFuncion);
			tblInstitucion.setInstTipDes(instTipDes);
			tblInstitucion.setInstDesUdaf(instDesUdaf.toUpperCase());
			tblInstitucion.setInstFechaCreacion(new Date());
			tblInstitucion.setTiesCod(tblIes);
			tblInstitucion.setInstEstado(Constantes.ESTADO_INACTIVO);
			tblInstitucion.setInstPeriodo(Constantes.periodo());
			gcs.GuardarNuevoCatastros(tblInstitucion);

			InetAddress direccionIp = InetAddress.getLocalHost();
			String hostname = direccionIp.getHostName();// nombre host
			String ipHostname = direccionIp.getHostAddress();// ip como String

			DatoNuevo = tblInstitucion.getInstCod() + ", " + tblInstitucion.getInstRuc() + ", "
					+ tblInstitucion.getInstNom() + ", " + tblInstitucion.getProvCod() + ", "
					+ tblInstitucion.getInstTfCod() + ", " + tblInstitucion.getInstTmeCod() + ", "
					+ tblInstitucion.getInstSecCod() + ", " + tblInstitucion.getInstFunCod() + ", "
					+ tblInstitucion.getInstTipDes() + ", " + tblInstitucion.getInstDesUdaf() + ", "
					+ tblInstitucion.getInstFechaCreacion() + ", " + tblInstitucion.getInstEstado() + ", "
					+ tblInstitucion.getInstPeriodo();

			String version = listaAplicaciones.getIdAplicacion().getVersionApp();
			TblHistoricoInstituciones tblHistoricoInstituciones = new TblHistoricoInstituciones();
			tblHistoricoInstituciones.setIdTecnico(datosUsuario.getIdUser());
			tblHistoricoInstituciones.setIdNombreTecnico(datosUsuario.getNombre());
			tblHistoricoInstituciones.setDatoActual(DatoNuevo);
			tblHistoricoInstituciones
					.setAprobadoPor(Subcoordinador.getIdDatoFuncionario() + ", " + Subcoordinador.getIdentificador()
							+ ", " + Subcoordinador.getNombre() + ", " + Subcoordinador.getCargo());
			tblHistoricoInstituciones.setVersionSistema(version);
			tblHistoricoInstituciones.setIpAdress(Constantes.getClientIpAddr(request));
			tblHistoricoInstituciones.setHostName(hostname + ", " + ipHostname);
			// tblHistoricoInstituciones.setSolicitadoPor(Solicitado.getIdDatoFuncionario()
			// + ", "+ Solicitado.getIdentificador() + ", " + Solicitado.getNombre() + ", "
			// + Solicitado.getCargo());
			tblHistoricoInstituciones.setAcccion(Constantes.ACCION_INSERT);
			tblHistoricoInstituciones.setFechaAccion(new Date());
			tblHistoricoInstituciones.setDescripcion(Constantes.DESCRIPCION_INCLUCION_CATASTRO);
			tblHistoricoInstituciones.setRutaAnexo(pathModuloVerifica);
			tblHistoricoInstituciones.setCodReferencial(tblInstitucion.getInstCod());
			tblHistoricoInstituciones.setTipoHistorico(Constantes.TIPO_REGISTRO_INSTITUCION);
			gcs.GuardarHistoricoInstitucion(tblHistoricoInstituciones);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		}

		catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/tecnicoNacional/ActivarInstitucion")
	public @ResponseBody String ActivarInstitucion(HttpServletRequest request,
			@RequestParam("identificadorResponsableAct") String identificadorResponsable,
			// @RequestParam("descripcionAct") String descripcion,
			@RequestParam("aprobadoAct") Integer aprobado,
			// @RequestParam("solicitadoAct") Integer solicitado,
			@RequestParam("pathModuloRegistro1") String pathModuloRegistro1,
			@RequestParam("identificadorInstitucionAct") Integer identificadorInstitucion) {
		// System.out.print("ingresa");
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			String DatoHistorico = null;
			String DatoNuevo = null;
			TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(identificadorResponsable, Constantes.periodo());

			TblDatosFuncionarios Subcoordinador = UsuInterno.ObtenerDatodFuncionarioXCod(aprobado);
			// TblDatosFuncionarios Solicitado =
			// UsuInterno.ObtenerDatodFuncionarioXCod(solicitado);
			TblAplicacionesRegistradas listaAplicaciones = us.buscarAplicacionRegistradaPorEmaeilidentifiador(
					datosUsuario.getEmail(), Constantes.periodo().toString(), Constantes.ESTADO_ACTIVO_USUARIOS);

			TblInstitucion tblInstitucion = institucion.ObtenerInstitucionesXIdcodigo(identificadorInstitucion);
			DatoHistorico = tblInstitucion.getInstCod() + ", " + tblInstitucion.getInstRuc() + ", "
					+ tblInstitucion.getInstNom() + ", " + tblInstitucion.getProvCod() + ", "
					+ tblInstitucion.getInstTfCod() + ", " + tblInstitucion.getInstTmeCod() + ", "
					+ tblInstitucion.getInstSecCod() + ", " + tblInstitucion.getInstFunCod() + ", "
					+ tblInstitucion.getInstTipDes() + ", " + tblInstitucion.getInstDesUdaf() + ", "
					+ tblInstitucion.getInstFechaCreacion() + ", " + tblInstitucion.getInstEstado() + ", "
					+ tblInstitucion.getInstPeriodo();

			tblInstitucion.setInstEstado(Constantes.ESTADO_INACTIVO);
			gcs.GuardarNuevoCatastros(tblInstitucion);
			
			TblUsuario usuarioInst = us.buscarCodigoAutoridaXperidoXestado(identificadorInstitucion, Constantes.ESTADO_ACTIVO_USUARIOS, Constantes.periodo(), Constantes.TIPO_REGISTRO_INSTITUCION);		
			if(usuarioInst!=null) {
			if (usuarioInst.getTipoUser() == Constantes.TIPO_REGISTRO_INSTITUCION) {
				usuarioInst.setEstado(Constantes.ESTADO_ACTIVO_USUARIOS);
				us.guardarUsuario(usuarioInst);
			}}

			InetAddress direccionIp = InetAddress.getLocalHost();
			String hostname = direccionIp.getHostName();// nombre host
			String ipHostname = direccionIp.getHostAddress();// ip como String

			DatoNuevo = tblInstitucion.getInstCod() + ", " + tblInstitucion.getInstRuc() + ", "
					+ tblInstitucion.getInstNom() + ", " + tblInstitucion.getProvCod() + ", "
					+ tblInstitucion.getInstTfCod() + ", " + tblInstitucion.getInstTmeCod() + ", "
					+ tblInstitucion.getInstSecCod() + ", " + tblInstitucion.getInstFunCod() + ", "
					+ tblInstitucion.getInstTipDes() + ", " + tblInstitucion.getInstDesUdaf() + ", "
					+ tblInstitucion.getInstFechaCreacion() + ", " + tblInstitucion.getInstEstado() + ", "
					+ tblInstitucion.getInstPeriodo();
			String version = listaAplicaciones.getIdAplicacion().getVersionApp();
			TblHistoricoInstituciones tblHistoricoInstituciones = new TblHistoricoInstituciones();
			tblHistoricoInstituciones.setIdTecnico(datosUsuario.getIdUser());
			tblHistoricoInstituciones.setIdNombreTecnico(datosUsuario.getNombre());
			tblHistoricoInstituciones.setDatoHistorico(DatoHistorico);
			tblHistoricoInstituciones.setDatoActual(DatoNuevo);
			tblHistoricoInstituciones
					.setAprobadoPor(Subcoordinador.getIdDatoFuncionario() + ", " + Subcoordinador.getIdentificador()
							+ ", " + Subcoordinador.getNombre() + ", " + Subcoordinador.getCargo());
			tblHistoricoInstituciones.setVersionSistema(version);
			tblHistoricoInstituciones.setIpAdress(Constantes.getClientIpAddr(request));
			tblHistoricoInstituciones.setHostName(hostname + ", " + ipHostname);
			// tblHistoricoInstituciones.setSolicitadoPor(Solicitado.getIdDatoFuncionario()
			// + ", " + Solicitado.getIdentificador() + ", " + Solicitado.getNombre() + ", "
			// + Solicitado.getCargo());
			tblHistoricoInstituciones.setAcccion(Constantes.ACCION_UPDATE);
			tblHistoricoInstituciones.setFechaAccion(new Date());
			tblHistoricoInstituciones.setDescripcion(Constantes.DESCRIPCION_ACTIVACION_CATASTRO);
			tblHistoricoInstituciones.setRutaAnexo(pathModuloRegistro1);
			tblHistoricoInstituciones.setCodReferencial(tblInstitucion.getInstCod());
			tblHistoricoInstituciones.setTipoHistorico(Constantes.TIPO_REGISTRO_INSTITUCION);
			gcs.GuardarHistoricoInstitucion(tblHistoricoInstituciones);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		}

		catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/tecnicoNacional/EliminacionInstitucion")
	public @ResponseBody String EliminacionInstitucion(HttpServletRequest request,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			// @RequestParam("descripcion") String descripcion,
			@RequestParam("aprobado") Integer aprobado,
			// @RequestParam("solicitado") Integer solicitado,
			@RequestParam("pathModuloRegistro") String pathModuloRegistro,
			@RequestParam("identificadorInstitucion") Integer identificadorInstitucion) {
		// System.out.print("ingresa");
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			String DatoHistorico = null;
			String DatoNuevo = null;
			TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(identificadorResponsable, Constantes.periodo());

			TblDatosFuncionarios Subcoordinador = UsuInterno.ObtenerDatodFuncionarioXCod(aprobado);
			// TblDatosFuncionarios Solicitado =
			// UsuInterno.ObtenerDatodFuncionarioXCod(solicitado);
			TblAplicacionesRegistradas listaAplicaciones = us.buscarAplicacionRegistradaPorEmaeilidentifiador(
					datosUsuario.getEmail(), Constantes.periodo().toString(), Constantes.ESTADO_ACTIVO_USUARIOS);

			TblInstitucion tblInstitucion = institucion.ObtenerInstitucionesXIdcodigo(identificadorInstitucion);
			DatoHistorico = tblInstitucion.getInstCod() + ", " + tblInstitucion.getInstRuc() + ", "
					+ tblInstitucion.getInstNom() + ", " + tblInstitucion.getProvCod() + ", "
					+ tblInstitucion.getInstTfCod() + ", " + tblInstitucion.getInstTmeCod() + ", "
					+ tblInstitucion.getInstSecCod() + ", " + tblInstitucion.getInstFunCod() + ", "
					+ tblInstitucion.getInstTipDes() + ", " + tblInstitucion.getInstDesUdaf() + ", "
					+ tblInstitucion.getInstFechaCreacion() + ", " + tblInstitucion.getInstEstado() + ", "
					+ tblInstitucion.getInstPeriodo();

			tblInstitucion.setInstEstado(Constantes.ESTADO_ELIMINADO);
			gcs.GuardarNuevoCatastros(tblInstitucion);
			
			TblUsuario usuarioInst = us.buscarCodigoAutoridaXperidoXestado(identificadorInstitucion, Constantes.ESTADO_ACTIVO_USUARIOS, Constantes.periodo(), Constantes.TIPO_REGISTRO_INSTITUCION);		
			if(usuarioInst!=null) {
			if (usuarioInst.getTipoUser() == Constantes.TIPO_REGISTRO_INSTITUCION) {
				usuarioInst.setEstado(Constantes.ESTADO_INACTIVO_USUARIOS);
				us.guardarUsuario(usuarioInst);
			}
			}
			InetAddress direccionIp = InetAddress.getLocalHost();
			String hostname = direccionIp.getHostName();// nombre host
			String ipHostname = direccionIp.getHostAddress();// ip como String

			DatoNuevo = tblInstitucion.getInstCod() + ", " + tblInstitucion.getInstRuc() + ", "
					+ tblInstitucion.getInstNom() + ", " + tblInstitucion.getProvCod() + ", "
					+ tblInstitucion.getInstTfCod() + ", " + tblInstitucion.getInstTmeCod() + ", "
					+ tblInstitucion.getInstSecCod() + ", " + tblInstitucion.getInstFunCod() + ", "
					+ tblInstitucion.getInstTipDes() + ", " + tblInstitucion.getInstDesUdaf() + ", "
					+ tblInstitucion.getInstFechaCreacion() + ", " + tblInstitucion.getInstEstado() + ", "
					+ tblInstitucion.getInstPeriodo();
			String version = listaAplicaciones.getIdAplicacion().getVersionApp();
			TblHistoricoInstituciones tblHistoricoInstituciones = new TblHistoricoInstituciones();
			tblHistoricoInstituciones.setIdTecnico(datosUsuario.getIdUser());
			tblHistoricoInstituciones.setIdNombreTecnico(datosUsuario.getNombre());
			tblHistoricoInstituciones.setDatoHistorico(DatoHistorico);
			tblHistoricoInstituciones.setDatoActual(DatoNuevo);
			tblHistoricoInstituciones
					.setAprobadoPor(Subcoordinador.getIdDatoFuncionario() + ", " + Subcoordinador.getIdentificador()
							+ ", " + Subcoordinador.getNombre() + ", " + Subcoordinador.getCargo());
			tblHistoricoInstituciones.setVersionSistema(version);
			tblHistoricoInstituciones.setIpAdress(Constantes.getClientIpAddr(request));
			tblHistoricoInstituciones.setHostName(hostname + ", " + ipHostname);
			// tblHistoricoInstituciones.setSolicitadoPor(Solicitado.getIdDatoFuncionario()
			// + ", "+ Solicitado.getIdentificador() + ", " + Solicitado.getNombre() + ", "
			// + Solicitado.getCargo());
			tblHistoricoInstituciones.setAcccion(Constantes.ACCION_UPDATE);
			tblHistoricoInstituciones.setFechaAccion(new Date());
			tblHistoricoInstituciones.setDescripcion(Constantes.DESCRIPCION_ILIMINACION_CATASTRO);
			tblHistoricoInstituciones.setRutaAnexo(pathModuloRegistro);
			tblHistoricoInstituciones.setCodReferencial(tblInstitucion.getInstCod());
			tblHistoricoInstituciones.setTipoHistorico(Constantes.TIPO_REGISTRO_INSTITUCION);
			gcs.GuardarHistoricoInstitucion(tblHistoricoInstituciones);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		}

		catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@RequestMapping(value = "/view/tecnicoNacional/ActualizarCatastro", method = RequestMethod.POST)
	public String ActualizarCatastro(Model model, @RequestParam("id") Integer InstCond) {

		// TblInstitucion tblInstitucion = new TblInstitucion();
		TblInstitucion tblInstitucion = institucion.ObtenerInstitucionesXIdcodigo(InstCond);

		model.addAttribute("instCond", tblInstitucion.getInstCod());
		model.addAttribute("instNom", tblInstitucion.getInstNom());
		model.addAttribute("instRuc", tblInstitucion.getInstRuc());
		model.addAttribute("provCod", tblInstitucion.getProvCod());
		model.addAttribute("cantCod", tblInstitucion.getCantCod());
		model.addAttribute("parroCod", tblInstitucion.getParroCod());
		model.addAttribute("instFunCod", tblInstitucion.getInstFunCod().getFunCod());
		model.addAttribute("instTipDes", tblInstitucion.getInstTipDes());
		model.addAttribute("instTfCod", tblInstitucion.getInstTfCod().getTfCod());
		model.addAttribute("estado", tblInstitucion.getInstEstado());
		model.addAttribute("instSecCod", tblInstitucion.getInstSecCod().getSecCod());
		model.addAttribute("instDesUdaf", tblInstitucion.getInstDesUdaf());
		if(tblInstitucion.getInstFunCod().getFunCod() == 7) {
			model.addAttribute("tipoIes", tblInstitucion.getTiesCod().getTiesCod());
		}else {		
			model.addAttribute("instTmeCod", tblInstitucion.getInstTmeCod().getTmeCod());
		}
		
		List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacion(1, "activo");
		model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);

		List<TblLocalizacion> listadoLocalizacionCanton = gcs.obtenerLocalizacion(2, "activo");
		model.addAttribute("listadoLocalizacionCanton", listadoLocalizacionCanton);

		List<TblLocalizacion> listadoLocalizacionParroquia = gcs.obtenerLocalizacion(4, "activo");
		model.addAttribute("listadoLocalizacionParroquia", listadoLocalizacionParroquia);

		List<TblFuncion> listadoFuncion = gcs.obtenerFuncionInstitucion(Constantes.ESTADO);
		model.addAttribute("listadoFuncion", listadoFuncion);

		List<TblTipoInforme> listadoTipoInforme = gcs.obtenerTipoInforme(Constantes.ESTADO);
		model.addAttribute("listadoTipoInforme", listadoTipoInforme);

		List<TblTipoMedio> listadoTipoMedio = gcs.obtenerTipoMedio(Constantes.ESTADO);
		model.addAttribute("listadoTipoMedio", listadoTipoMedio);
		
		List<TblTipoIes> ListaTipoIes= gcs.ListaTipoIesPorEstado(Constantes.ESTADO);
		model.addAttribute("ListaTipoIes", ListaTipoIes);

		List<TblSector> listadoTipoSector = gcs.obtenerTipoSector(Constantes.ESTADO);
		model.addAttribute("listadoTipoSector", listadoTipoSector);

		List<TblDatosFuncionarios> listadoFuncionario = UsuInterno
				.obtenerFuncionarioXCargo(Constantes.ESTADO_ACTIVO_USUARIOS.toString(), "SUBCOORDINADOR");
		model.addAttribute("listadoFuncionario", listadoFuncionario);

		List<TblDatosFuncionarios> listadoFuncionariosRc = UsuInterno
				.obtenerFuncionarios(Constantes.ESTADO_ACTIVO_USUARIOS.toString());
		model.addAttribute("listadoFuncionariosRc", listadoFuncionariosRc);

		return "tecnicoNacional/ActualizarCatastro";
	}

	/* Metodo Guardar */
	@GetMapping("/view/tecnicoNacional/GuardarActualiarCatastro")
	public String accesoNoAutorizadoGuardarActualiarCatastro(TblInstitucion tblInstitucion) {
		return "redirect:../../index";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/tecnicoNacional/GuardarActualiarCatastro")
	public @ResponseBody String GuardarActualiarCatastro(HttpServletRequest request,
			@RequestParam("identificadorEjecuto") String identificadorEjecuto, 
			@RequestParam("instNom") String instNom,
			@RequestParam("instRuc") String instRuc, 
			@RequestParam("provCod") Integer provCod,
			@RequestParam(value = "cantCod", required = false) Integer cantCod,
			@RequestParam(value = "parroCod", required = false) Integer parroCod,
			@RequestParam("instFunCod") Integer instFunCod,  
			@RequestParam("instTipDes") String instTipDes,
			@RequestParam("instTfCod") Integer instTfCod, 
			@RequestParam(value = "instTmeCod", required = false) Integer instTmeCod,
			@RequestParam("instSecCod") Integer instSecCod,
			@RequestParam(value = "instDesUdaf", required = false) String instDesUdaf,
			//@RequestParam(value = "checks[]", required = false) String[] checks,
			@RequestParam("aprobado") Integer aprobado,
			// @RequestParam("solicitado") Integer solicitado,
			@RequestParam("pathModuloVerifica") String pathModuloVerifica,
			@RequestParam("instCond") Integer instCond,
			@RequestParam("descripcion") String descripcion,
			@RequestParam(value = "tiesCod", required = false) Integer tiesCod) {
		// System.out.print("ingresa");
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			String DatoHistorico = null;
			String DatoNuevo = null, funcionTipo = null;
			TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(identificadorEjecuto, Constantes.periodo());

			TblDatosFuncionarios Subcoordinador = UsuInterno.ObtenerDatodFuncionarioXCod(aprobado);
			// TblDatosFuncionarios Solicitado =
			// UsuInterno.ObtenerDatodFuncionarioXCod(solicitado);
			TblAplicacionesRegistradas listaAplicaciones = us.buscarAplicacionRegistradaPorEmaeilidentifiador(
					datosUsuario.getEmail(), Constantes.periodo().toString(), Constantes.ESTADO_ACTIVO_USUARIOS);
			TblFuncion tblFuncion = gcs.ObtenerFuncionXid(instFunCod);
			TblTipoInforme tblTipoInforme = gcs.ObtenerTipoInformeXCod(instTfCod);
			TblSector tblSector = gcs.ObtenerSectorXid(instSecCod);
			TblInstitucion tblInstitucion = institucion.ObtenerInstitucionesXIdcodigo(instCond);
			if (tiesCod == null) {
				TblTipoMedio tblTipoMedio = gcs.ObtenerTipoMedioXid(instTmeCod);
				tblInstitucion.setInstTmeCod(tblTipoMedio);
				funcionTipo = tblInstitucion.getInstTmeCod().getTmeDes() ;
			}else {
				TblTipoIes tblIes=gcs.TipoIesPorTiesCod(tiesCod);
				tblInstitucion.setTiesCod(tblIes);
				funcionTipo = tblInstitucion.getTiesCod().getTiesDes() ;
			}
			

			DatoHistorico = tblInstitucion.getInstCod() + ", " + tblInstitucion.getInstRuc() + ", "
					+ tblInstitucion.getInstNom() + ", " + tblInstitucion.getProvCod() + ", "
					+ tblInstitucion.getInstTfCod().getTfNom() + ", " + ", "
					+ tblInstitucion.getInstSecCod().getSecDes() + ", " + tblInstitucion.getInstFunCod().getFunDes() + ", "
					+ tblInstitucion.getInstTipDes() + ", " + tblInstitucion.getInstDesUdaf() + ", "
					+ tblInstitucion.getInstFechaCreacion() + ", " + tblInstitucion.getInstEstado() + ", "
					+ tblInstitucion.getInstPeriodo()+","+ funcionTipo;

			tblInstitucion.setInstRuc(instRuc);
			tblInstitucion.setInstNom(instNom.toUpperCase());
			tblInstitucion.setProvCod(provCod);
			tblInstitucion.setCantCod(cantCod);
			tblInstitucion.setParroCod(parroCod);
			tblInstitucion.setInstTfCod(tblTipoInforme);
			tblInstitucion.setInstSecCod(tblSector);
			tblInstitucion.setInstFunCod(tblFuncion);
			tblInstitucion.setInstTipDes(instTipDes);
			tblInstitucion.setInstDesUdaf(instDesUdaf.toUpperCase());
			tblInstitucion.setInstFechaCreacion(new Date());

			//tblInstitucion.setInstEstado(Constantes.ESTADO_INACTIVO);
			//tblInstitucion.setInstPeriodo(Constantes.periodo());
			

			InetAddress direccionIp = InetAddress.getLocalHost();
			String hostname = direccionIp.getHostName();// nombre host
			String ipHostname = direccionIp.getHostAddress();// ip como String

			DatoNuevo = tblInstitucion.getInstCod() + ", " + tblInstitucion.getInstRuc() + ", "
					+ tblInstitucion.getInstNom() + ", " + tblInstitucion.getProvCod() + ", "
					+ tblInstitucion.getInstTfCod() + ", " + tblInstitucion.getInstTmeCod() + ", "
					+ tblInstitucion.getInstSecCod() + ", " + tblInstitucion.getInstFunCod() + ", "
					+ tblInstitucion.getInstTipDes() + ", " + tblInstitucion.getInstDesUdaf() + ", "
					+ tblInstitucion.getInstFechaCreacion() + ", " + tblInstitucion.getInstEstado() + ", "
					+ tblInstitucion.getInstPeriodo();
			String version = listaAplicaciones.getIdAplicacion().getVersionApp();
			TblHistoricoInstituciones tblHistoricoInstituciones = new TblHistoricoInstituciones();
			tblHistoricoInstituciones.setIdTecnico(datosUsuario.getIdUser());
			tblHistoricoInstituciones.setIdNombreTecnico(datosUsuario.getNombre());
			tblHistoricoInstituciones.setDatoHistorico(DatoHistorico);
			tblHistoricoInstituciones.setDatoActual(DatoNuevo);
			tblHistoricoInstituciones
					.setAprobadoPor(Subcoordinador.getIdDatoFuncionario() + ", " + Subcoordinador.getIdentificador()
							+ ", " + Subcoordinador.getNombre() + ", " + Subcoordinador.getCargo());
			tblHistoricoInstituciones.setVersionSistema(version);
			tblHistoricoInstituciones.setIpAdress(Constantes.getClientIpAddr(request));
			tblHistoricoInstituciones.setHostName(hostname + ", " + ipHostname);
			// tblHistoricoInstituciones.setSolicitadoPor(Solicitado.getIdDatoFuncionario()
			// + ", " + Solicitado.getIdentificador() + ", " + Solicitado.getNombre() + ", "
			// + Solicitado.getCargo());
			tblHistoricoInstituciones.setAcccion(Constantes.ACCION_UPDATE);
			tblHistoricoInstituciones.setFechaAccion(new Date());
			tblHistoricoInstituciones
					.setDescripcion(Constantes.DESCRIPCION_ACTUALIZACION_CATASTRO + "<br>" + descripcion);
			tblHistoricoInstituciones.setRutaAnexo(pathModuloVerifica);
			tblHistoricoInstituciones.setCodReferencial(tblInstitucion.getInstCod());
			tblHistoricoInstituciones.setTipoHistorico(Constantes.TIPO_REGISTRO_INSTITUCION);
			gcs.GuardarHistoricoInstitucion(tblHistoricoInstituciones);
			gcs.GuardarNuevoCatastros(tblInstitucion);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		}

		catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	// Fin Gestion de Catastro//

	// metodos para ver lista de autoridades activas//
	@RequestMapping("/view/tecnicoNacional/ListaAutoridadesActivas")
	public String ListaAutoridadesActivas(Model model, Authentication authentication) {
		TblUsuario identificadorlogin = us.buscarUsuarioXEmail(authentication.getName(), Constantes.periodo());
		if (hasRole("ROLE_NACIONAL")) {
			model.addAttribute("rol", "Nacional");

		} else if (hasRole("ROLE_PROVINCIAL")) {
			model.addAttribute("rol", "Provincial");
			TblUsuarioLocalizacion provincias = tecsv.obtenerLocalizacionXtecnicoProvincial(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_PROVINCIAL);
			model.addAttribute("provincia", provincias.getProvCod());
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Administrador");

		}
		return "tecnicoNacional/ListaAutoridadesActivas";
	}

	// metodos para ver lista de autoridades activas//
	@RequestMapping("/view/tecnicoNacional/ListaAutoridadesRegistradas")
	public String ListaAutoridadesRegistradas(Model model, Authentication authentication) {
		TblUsuario identificadorlogin = us.buscarUsuarioXEmail(authentication.getName(), Constantes.periodo());
		if (hasRole("ROLE_NACIONAL")) {
			model.addAttribute("rol", "Nacional");

		} else if (hasRole("ROLE_PROVINCIAL")) {
			model.addAttribute("rol", "Provincial");
			TblUsuarioLocalizacion provincias = tecsv.obtenerLocalizacionXtecnicoProvincial(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_PROVINCIAL);
			model.addAttribute("provincia", provincias.getProvCod());
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Administrador");

		}
		return "tecnicoNacional/ListaAutoridadesRegistradas";
	}

	@RequestMapping(value = { "/obtenerAutoridadesActivasTecNacional" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerAutoridadesActivasTecNacional(Authentication authentication,
			@RequestParam("estado") String estado) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
			List<Object[]> listaRegistros = autori.buscarAutoridadXEstadoPeriodo(estado, Constantes.periodo());

			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[6] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[6]);
					}

					resultado
							.append("{\"aut_codigo\":\"" + datos[0] + "\",\"" + "contador\":\""
									+ (listaRegistros.indexOf(datos) + 1) + "\",\"" + "nombre\":\""
									+ datos[1].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
											.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
											.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
									+ "\",\"" + "ruc\":\"" + (datos[2] == null ? "" : datos[2]) + "\",\""
									+ "provincia\":\"" + datos[4] + "\",\"" + "funcion\":\""
									+ datos[3].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
											.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
											.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
									+ "\",\"" + "fecha\":\"" + fechaSolicitud + "\",\"" + "estado\":\"" + datos[5]
									+ "\"}")
							.append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}

	@RequestMapping(value = { "/obtenerAutoridadesActivasTecRovincial" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerAutoridadesActivasTecRovincial(Authentication authentication,
			@RequestParam("provincia") Integer provincia, @RequestParam("estado") String estado) {
		String json = null;
		try {
			StringBuilder resultado = new StringBuilder();
			List<Object[]> listaRegistros = autori.buscarAutoridadXEstadoPeriodo(estado, Constantes.periodo());

			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[6] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[6]);
					}

					resultado
							.append("{\"aut_codigo\":\"" + datos[0] + "\",\"" + "contador\":\""
									+ (listaRegistros.indexOf(datos) + 1) + "\",\"" + "nombre\":\""
									+ datos[1].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
											.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
											.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
									+ "\",\"" + "ruc\":\"" + (datos[2] == null ? "" : datos[2]) + "\",\""
									+ "provincia\":\"" + datos[4] + "\",\"" + "funcion\":\""
									+ datos[3].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
											.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
											.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
									+ "\",\"" + "fecha\":\"" + fechaSolicitud + "\",\"" + "estado\":\"" + datos[5]
									+ "\"}")
							.append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}

	@RequestMapping("/view/tecnicoNacional/ActivarInformeInstitucion")
	public String ActivarInformeInstitucion(Model model, Authentication authentication) {
		List<Integer> list = new ArrayList<Integer>();
		TblUsuario identificadorlogin = us.buscarUsuarioXEmail(authentication.getName(), Constantes.periodo());
		if (hasRole("ROLE_NACIONAL")) {
			model.addAttribute("rol", "Nacional");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_NACIONAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");

			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		} else if (hasRole("ROLE_PROVINCIAL")) {
			model.addAttribute("rol", "Provincial");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_PROVINCIAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}
			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Administrador");
			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_ADMINISTRADOR);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}
			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		}

		return "tecnicoNacional/ActivarInformeInstitucion";
	}

	@RequestMapping(value = { "/obtenerIntitucionesConInformeFinalizado" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerIntitucionesConInformeFinalizado(Authentication authentication,
			@RequestParam("ruc") String ruc) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
			List<Object[]> listaRegistros = gcs.ObtenerInstitucionesXPeriodoEstadoXRucXEstadoInforme(Constantes.ESTADO,
					Constantes.periodo(), ruc, Constantes.ESTADO_INFORME_FINALIZADO);

			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					/*
					 * String fechaSolicitud = ""; SimpleDateFormat df = new
					 * SimpleDateFormat("dd/MM/yyyy"); if (datos[5]==null){ fechaSolicitud=""; }
					 * else { fechaSolicitud = df.format(datos[5]); }
					 */

					resultado.append("{\"inf_cod\":\"" + datos[0] + "\",\"" + "contador\":\""
							+ (listaRegistros.indexOf(datos) + 1) + "\",\"" + "ruc\":\""
							+ (datos[1] == null ? "" : datos[1]) + "\",\"" + "nombre\":\""
							+ datos[2].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
							+ "\",\"" + "funcion\":\"" + datos[3].toString().toUpperCase() + "\",\"" + "provincia\":\""
							+ datos[4].toString().toUpperCase() + "\",\"" + "fechaRegistro\":\"" + datos[5] + "\",\""
							+ "fechaActivacion\":\"" + datos[6] + "\",\"" + "fechaFin\":\"" + datos[7] + "\",\""
							+ "estado\":\"" + datos[8].toString().toUpperCase() + "\",\"" + "reaperturas\":\""
							+ datos[9] + "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}

	@RequestMapping(value = { "/view/tecnicoNacional/DatosActivarInformeInstitucion" }, method = RequestMethod.POST)
	public String DatosActivarInformeInstitucion(Model model, Authentication authentication,
			@RequestParam("id") Integer infCod) throws ParseException {
		TblInforme datosInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
		TblInstitucion datosInstitucion = gcs.ObtenerInstitucionesXidEstado(datosInforme.getInstCod(),
				Constantes.ESTADO, Constantes.periodo());
		TblDatosFuncionarios datosFuncionario = UsuInterno.obtenerSubcoordinadorXEstadoXCargo("1", "SUBCOORDINADOR");
		model.addAttribute("infCod", infCod);
		model.addAttribute("instCod", datosInforme.getInstCod());
		model.addAttribute("rucInstitucion", datosInstitucion.getInstRuc());
		model.addAttribute("nombreInstitucion", datosInstitucion.getInstNom());
		model.addAttribute("subcoordinador", datosFuncionario.getNombre());

		if (datosInforme.getInfEstado().equals(Constantes.ESTADO_INFORME_FINALIZADO)
				&& datosInforme.getInfContadorApertura() > 0) {

			model.addAttribute("aperturaPrevia", "aperturaPrevia");
			List<TblHistoricoInstituciones> tblHistoricoInstituciones = his.obtenerRegistros(datosInforme.getInfCod());

			for (TblHistoricoInstituciones datos : tblHistoricoInstituciones) {
				model.addAttribute("tecnicoAnterior", datos.getIdNombreTecnico());
				model.addAttribute("rutaAnexo", datos.getRutaAnexo());
				model.addAttribute("fechaReapertura", datos.getFechaAccion());

			}
		}
		return "tecnicoNacional/DatosActivarInformeInstitucion";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/tecnicoNacional/GuardarActivarInforme")
	public @ResponseBody String GuardarActivarInforme(HttpServletRequest request, Authentication authentication,
			@RequestParam("instCod") Integer instCod, @RequestParam("infCod") Integer infCod,
			@RequestParam("rutaAnexo") String rutaAnexo,
			@RequestParam("nombreSubcoordinador") String nombreSubcoordinador,
			@RequestParam("razonApertura") String razonApertura) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblAplicacionesRegistradas listaAplicaciones = us.buscarAplicacionRegistradaPorEmaeilidentifiador(
					datosUsuario.getEmail(), Constantes.periodo().toString(), Constantes.ESTADO_ACTIVO_USUARIOS);
			String version = listaAplicaciones.getIdAplicacion().getVersionApp();
			InetAddress direccionIp = InetAddress.getLocalHost();
			String hostname = direccionIp.getHostName();// nombre host
			String ipHostname = direccionIp.getHostAddress();// ip como String
			TblInforme datosInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
			TblInstitucion datosInstitucion = gcs.ObtenerInstitucionesXidEstado(datosInforme.getInstCod(),
					Constantes.ESTADO, Constantes.periodo());
			TblHistoricoInstituciones tblHistoricoInstituciones = new TblHistoricoInstituciones();
			tblHistoricoInstituciones.setIdTecnico(datosUsuario.getIdUser());
			tblHistoricoInstituciones.setIdNombreTecnico(datosUsuario.getNombre());
			String datoHistorico = "";
			datoHistorico = infCod + "," + datosInforme.getInfFechaini() + "," + datosInforme.getInfFechafin() + ","
					+ datosInforme.getInfPeriodo() + "," + datosInforme.getInfEstado() + ","
					+ datosInforme.getInfVerificador() + "," + datosInforme.getInfContadorApertura() + ","
					+ datosInstitucion.getInstNom() + "," + datosInstitucion.getInstRuc();
			tblHistoricoInstituciones.setDatoHistorico(datoHistorico);
			tblHistoricoInstituciones.setVersionSistema(version);
			tblHistoricoInstituciones.setIpAdress(Constantes.getClientIpAddr(request));
			tblHistoricoInstituciones.setHostName(hostname + ", " + ipHostname);
			tblHistoricoInstituciones.setSolicitadoPor(nombreSubcoordinador);
			tblHistoricoInstituciones.setAprobadoPor(nombreSubcoordinador);
			tblHistoricoInstituciones.setAcccion(Constantes.ACCION_UPDATE);
			tblHistoricoInstituciones.setFechaAccion(new Date());
			tblHistoricoInstituciones.setDescripcion("Apertura de Informe");
			tblHistoricoInstituciones.setRutaAnexo(rutaAnexo);
			tblHistoricoInstituciones.setCodReferencial(infCod);
			tblHistoricoInstituciones.setTipoHistorico("informeInstitucion");
			String datoActual = "";
			datoActual = infCod + "," + datosInforme.getInfFechaini() + "," + datosInforme.getInfFechafin() + ","
					+ datosInforme.getInfPeriodo() + "," + "activo" + "," + "" + ","
					+ datosInforme.getInfContadorApertura() + 1 + "," + datosInstitucion.getInstNom() + ","
					+ datosInstitucion.getInstRuc();
			tblHistoricoInstituciones.setDatoActual(datoActual);
			gcs.GuardarHistoricoInstitucion(tblHistoricoInstituciones);

			Integer infContadorApertura = datosInforme.getInfContadorApertura() + 1;
			infor.AperturaInforme("activo", infCod, "", infContadorApertura);

			TblInforme datosInformeValidacionCambio = infor.obtenerRegistroInformeXcodPeriodo(infCod,
					Constantes.periodo());
			if (datosInformeValidacionCambio.getInfEstado().equals("activo")) {
				String periodo = String.valueOf(Constantes.periodo());
				List<TblResponables> datosResponsables = respon.buscarResponsableXcodigoInstitucion(instCod, periodo);

				for (TblResponables datos : datosResponsables) {
					if (datos.getResponEmail() != null && !datos.getResponEmail().equals("")) {
						ms.mailAperturaInformeInstitucion(datos.getResponEmail().toLowerCase(), datos.getResponNombre(),
								datos.getResponCargo(), datosInstitucion.getInstNom(), datosInstitucion.getInstRuc(),
								tblHistoricoInstituciones.getFechaAccion(), true);
					}

				}
				ms.mailNotificacionTecnico(datosUsuario.getEmail(), datosUsuario.getNombre(),
						datosInstitucion.getInstNom(), datosInstitucion.getInstRuc(),
						tblHistoricoInstituciones.getFechaAccion(), true);
				List<TblDatosFuncionarios> listadoFuncionarioSubcordinador = UsuInterno
						.obtenerFuncionarioXCargo(Constantes.ESTADO_ACTIVO_USUARIOS.toString(), "SUBCOORDINADOR");
				ms.mailNotificacionTecnico(listadoFuncionarioSubcordinador.get(0).getMailInstitucional(),
						listadoFuncionarioSubcordinador.get(0).getNombre(), datosInstitucion.getInstNom(),
						datosInstitucion.getInstRuc(), tblHistoricoInstituciones.getFechaAccion(), true);

			} else {

				// eliminar registro tblhistoricoinstituciones
			}

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		}

		catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@RequestMapping("/view/tecnicoNacional/ActivarInformeAutoridad")
	public String ActivarInformeAutoridad(Model model, Authentication authentication) {
		List<Integer> list = new ArrayList<Integer>();
		TblUsuario identificadorlogin = us.buscarUsuarioXEmail(authentication.getName(), Constantes.periodo());
		if (hasRole("ROLE_NACIONAL")) {
			model.addAttribute("rol", "Nacional");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_NACIONAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");

			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		} else if (hasRole("ROLE_PROVINCIAL")) {
			model.addAttribute("rol", "Provincial");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_PROVINCIAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}
			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Administrador");
			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_ADMINISTRADOR);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}
			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		}

		return "tecnicoNacional/ActivarInformeAutoridad";
	}

	@RequestMapping(value = { "/obtenerAutoridadConInformeFinalizado" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerAutoridadConInformeFinalizado(Authentication authentication,
			@RequestParam("ruc") String identificador) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();

			// TblUsuario datosUsuario = us.BuscarIdentificadorXperiodoTipo(identificador,
			// Constantes.periodo(), Constantes.TIPO_REGISTRO_AUTORIDAD);

			List<Object[]> listaRegistros = infor.obtenerInformeAutoridadxIdentificador(
					Constantes.ESTADO_INFORME_FINALIZADO, Constantes.periodo(), identificador);

			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					/*
					 * String fechaSolicitud = ""; SimpleDateFormat df = new
					 * SimpleDateFormat("dd/MM/yyyy"); if (datos[5]==null){ fechaSolicitud=""; }
					 * else { fechaSolicitud = df.format(datos[5]); }
					 */

					resultado.append("{\"inf_aut_cod\":\"" + datos[0] + "\",\"" + "contador\":\""
							+ (listaRegistros.indexOf(datos) + 1) + "\",\"" + "ruc\":\""
							+ (datos[1] == null ? "" : datos[1]) + "\",\"" + "nombre\":\""
							+ datos[2].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
							+ "\",\"" + "funcion\":\"" + datos[3].toString().toUpperCase() + "\",\"" + "provincia\":\""
							+ datos[4].toString().toUpperCase() + "\",\"" + "fechaRegistro\":\"" + datos[5] + "\",\""
							+ "fechaActivacion\":\"" + datos[6] + "\",\"" + "codigoInforme\":\"" + datos[7] + "\",\""
							+ "fechaFin\":\"" + datos[8] + "\",\""

							+ "estado\":\"" + datos[9].toString().toUpperCase() + "\",\"" + "reaperturas\":\""
							+ datos[10] + "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}

	@RequestMapping(value = { "/view/tecnicoNacional/DatosActivarInformeAutoridad" }, method = RequestMethod.POST)
	public String DatosActivarInformeAutoridad(Model model, Authentication authentication,
			@RequestParam("id") Integer identificador) throws ParseException {
		TblInformeAutoridad datosInforme = infor.obtenerRegistroInforme(identificador, Constantes.periodo());
		TblUsuario datosUsuario = us.buscarUsuarioXCodigoInstitucion(datosInforme.getIdentificador(),
				Constantes.TIPO_REGISTRO_AUTORIDAD, Constantes.periodo());
		TblAutoridad datosAutoridad = autori.buscarAutoridadXidentificadorPeriodo(datosUsuario.getEmail(),
				Constantes.periodo());
		TblDatosFuncionarios datosFuncionario = UsuInterno.obtenerSubcoordinadorXEstadoXCargo("1", "SUBCOORDINADOR");
		model.addAttribute("infCod", identificador);
		model.addAttribute("instCod", datosAutoridad.getAutCodigo());
		model.addAttribute("rucInstitucion", datosAutoridad.getIdentificador());
		model.addAttribute("nombreInstitucion", datosAutoridad.getNombre());
		model.addAttribute("subcoordinador", datosFuncionario.getNombre());

		if (datosInforme.getInfAutEstado().equals(Constantes.ESTADO_INFORME_FINALIZADO)
				&& datosInforme.getInfContadorApertura() > 0) {

			model.addAttribute("aperturaPrevia", "aperturaPrevia");
			List<TblHistoricoInstituciones> tblHistoricoInstituciones = his
					.obtenerRegistros(datosInforme.getInfAutCod());

			for (TblHistoricoInstituciones datos : tblHistoricoInstituciones) {
				model.addAttribute("tecnicoAnterior", datos.getIdNombreTecnico());
				model.addAttribute("rutaAnexo", datos.getRutaAnexo());
				model.addAttribute("fechaReapertura", datos.getFechaAccion());

			}
		}
		return "tecnicoNacional/DatosActivarInformeAutoridad";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/tecnicoNacional/GuardarActivarInformeAutoridad")
	public @ResponseBody String GuardarActivarInformeAutoridad(HttpServletRequest request,
			Authentication authentication, @RequestParam("instCod") Integer identificador,
			@RequestParam("rutaAnexo") String rutaAnexo,
			@RequestParam("nombreSubcoordinador") String nombreSubcoordinador,
			@RequestParam("razonApertura") String razonApertura) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			TblUsuario datosTecnico = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblAplicacionesRegistradas listaAplicaciones = us.buscarAplicacionRegistradaPorEmaeilidentifiador(
					datosTecnico.getEmail(), Constantes.periodo().toString(), Constantes.ESTADO_ACTIVO_USUARIOS);
			String version = listaAplicaciones.getIdAplicacion().getVersionApp();
			InetAddress direccionIp = InetAddress.getLocalHost();
			String hostname = direccionIp.getHostName();// nombre host
			String ipHostname = direccionIp.getHostAddress();// ip como String
			TblInformeAutoridad datosInforme = infor.obtenerRegistroInforme(identificador, Constantes.periodo());
			TblUsuario datosUsuarioAutoridad = us.buscarUsuarioXCodigoInstitucion(datosInforme.getIdentificador(),
					Constantes.TIPO_REGISTRO_AUTORIDAD, Constantes.periodo());
			TblAutoridad datosAutoridad = autori.buscarAutoridadXidentificadorPeriodo(datosUsuarioAutoridad.getEmail(),
					Constantes.periodo());
			TblHistoricoInstituciones tblHistoricoInstituciones = new TblHistoricoInstituciones();
			tblHistoricoInstituciones.setIdTecnico(datosTecnico.getIdUser());
			tblHistoricoInstituciones.setIdNombreTecnico(datosTecnico.getNombre());
			String datoHistorico = "";
			datoHistorico = datosInforme.getInfAutCod() + "," + datosInforme.getInfAutFechain() + ","
					+ datosInforme.getInfAutFechafin() + "," + datosInforme.getInfAutPeriodo() + ","
					+ datosInforme.getInfAutEstado() + "," + datosInforme.getInfAutVerificador() + ","
					+ datosInforme.getInfContadorApertura() + "," + datosAutoridad.getNombre() + ","
					+ datosAutoridad.getIdentificador();
			tblHistoricoInstituciones.setDatoHistorico(datoHistorico);
			tblHistoricoInstituciones.setVersionSistema(version);
			tblHistoricoInstituciones.setIpAdress(Constantes.getClientIpAddr(request));
			tblHistoricoInstituciones.setHostName(hostname + ", " + ipHostname);
			tblHistoricoInstituciones.setSolicitadoPor(nombreSubcoordinador);
			tblHistoricoInstituciones.setAprobadoPor(nombreSubcoordinador);
			tblHistoricoInstituciones.setAcccion(Constantes.ACCION_UPDATE);
			tblHistoricoInstituciones.setFechaAccion(new Date());
			tblHistoricoInstituciones.setDescripcion("Apertura de Informe");
			tblHistoricoInstituciones.setRutaAnexo(rutaAnexo);
			tblHistoricoInstituciones.setCodReferencial(datosInforme.getInfAutCod());
			tblHistoricoInstituciones.setTipoHistorico("informeAutoridad");
			String datoActual = "";
			datoActual = datosInforme.getInfAutCod() + "," + datosInforme.getInfAutFechain() + ","
					+ datosInforme.getInfAutFechafin() + "," + datosInforme.getInfAutPeriodo() + "," + "activo" + ","
					+ "" + "," + datosInforme.getInfContadorApertura() + 1 + "," + datosAutoridad.getNombre() + ","
					+ datosAutoridad.getIdentificador();
			tblHistoricoInstituciones.setDatoActual(datoActual);
			gcs.GuardarHistoricoInstitucion(tblHistoricoInstituciones);

			Integer infContadorApertura = datosInforme.getInfContadorApertura() + 1;
			infor.AperturaInformeAutoridad("activo", datosInforme.getInfAutCod(), "", infContadorApertura);

			TblInformeAutoridad datosInformeValidacionCambio = infor
					.obtenerRegistroInformeAutCod(datosInforme.getInfAutCod(), Constantes.periodo());
			if (datosInformeValidacionCambio.getInfAutEstado().equals("activo")) {
				ms.mailAperturaInformeAutoridad(datosAutoridad.getEmail().toLowerCase(), datosAutoridad.getNombre(), "",
						datosAutoridad.getDignidad(), datosAutoridad.getIdentificador(),
						tblHistoricoInstituciones.getFechaAccion(), true);
				ms.mailNotificacionTecnico(datosTecnico.getEmail(), datosTecnico.getNombre(),
						datosAutoridad.getNombre(), datosAutoridad.getIdentificador(),
						tblHistoricoInstituciones.getFechaAccion(), true);
				List<TblDatosFuncionarios> listadoFuncionarioSubcordinador = UsuInterno
						.obtenerFuncionarioXCargo(Constantes.ESTADO_ACTIVO_USUARIOS.toString(), "SUBCOORDINADOR");
				ms.mailNotificacionTecnico(listadoFuncionarioSubcordinador.get(0).getMailInstitucional(),
						listadoFuncionarioSubcordinador.get(0).getNombre(), datosAutoridad.getNombre(),
						datosAutoridad.getIdentificador(), tblHistoricoInstituciones.getFechaAccion(), true);

			} else {

				// eliminar registro tblhistoricoinstituciones
			}

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		}

		catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	// Gestión catastro Autoridades

	@RequestMapping("/view/tecnicoNacional/ListadoCatastroAutoridades")
	public String ListadoCatastroAutoridades(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
		if (hasRole("ROLE_ADMIN")) {
			TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			model.addAttribute("rol", "Administrador");
			model.addAttribute("Verificador", "acceso");
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
			model.addAttribute("acciones", listaAcciones);

			List<TblDatosFuncionarios> listadoFuncionarioSubcordinador = UsuInterno
					.obtenerFuncionarioXCargo(Constantes.ESTADO_ACTIVO_USUARIOS.toString(), "SUBCOORDINADOR");
			model.addAttribute("listadoFuncionarioSubcordinador", listadoFuncionarioSubcordinador);

			List<TblDatosFuncionarios> listadoFuncionariosRc = UsuInterno
					.obtenerFuncionarios(Constantes.ESTADO_ACTIVO_USUARIOS.toString());
			model.addAttribute("listadoFuncionariosRc", listadoFuncionariosRc);

		} else if (hasRole("ROLE_NACIONAL")) {
			TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			model.addAttribute("rol", "Nacional");
			model.addAttribute("Verificador", "acceso");
			List<Object[]> listaAcciones = hc.obtenerAcciones(datosUsuario.getIdUser(), idMenu);
			model.addAttribute("acciones", listaAcciones);

			List<TblDatosFuncionarios> listadoFuncionarioSubcordinador = UsuInterno
					.obtenerFuncionarioXCargo(Constantes.ESTADO_ACTIVO_USUARIOS.toString(), "SUBCOORDINADOR");
			model.addAttribute("listadoFuncionarioSubcordinador", listadoFuncionarioSubcordinador);

			List<TblDatosFuncionarios> listadoFuncionariosRc = UsuInterno
					.obtenerFuncionarios(Constantes.ESTADO_ACTIVO_USUARIOS.toString());
			model.addAttribute("listadoFuncionariosRc", listadoFuncionariosRc);

		}

		else {
			model.addAttribute("Verificador", "denegado");
		}
		return "tecnicoNacional/ListadoCatastroAutoridades";
	}

	@RequestMapping(value = { "/obtenerRegistrosCatastroAutoridades" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerRegistrosCatastroAutoridades() {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
			List<Object[]> listaRegistros = gcs.ObtenerAutoridadesXPeriodo(Constantes.periodo());

			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[5] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[5]);
					}

					resultado.append("{\"inst_cod\":\"" + datos[0] + "\",\"" + "contador\":\""
							+ (listaRegistros.indexOf(datos) + 1) + "\",\"" + "fecha\":\"" + fechaSolicitud + "\",\""
							+ "accion\":\"" + (datos[7] == null ? "SN" : datos[7]) + "\",\"" + "archivo\":\""
							+ (datos[8] == null ? "SN" : datos[8]) + "\",\"" + "ruc\":\""
							+ (datos[2] == null ? "" : datos[2]) + "\",\"" + "provincia\":\"" + datos[3] + "\",\""
							+ "nombre\":\""
							+ datos[1].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
							+ "\",\"" + "estado\":\"" + datos[6].toString().toUpperCase() + "\",\"" + "funcion\":\""
							+ datos[4] + "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}

	@RequestMapping(value = "/view/tecnicoNacional/ActualizarCatastroAutoridad", method = RequestMethod.POST)
	public String ActualizarCatastroAutoridad(Model model, @RequestParam("id") Integer autCodigo) {

		TblAutoridad datosAutoridad = autori.buscarAutordadCodAutPeriodo(autCodigo, Constantes.periodo());

		model.addAttribute("instCond", datosAutoridad.getAutCodigo());
		model.addAttribute("instNom", datosAutoridad.getNombre());
		model.addAttribute("instRuc", datosAutoridad.getIdentificador());
		model.addAttribute("provCod", datosAutoridad.getProvincia());
		model.addAttribute("cantCod", datosAutoridad.getCanton());
		model.addAttribute("parroCod", datosAutoridad.getParroquia());
		model.addAttribute("instFunCod", datosAutoridad.getDignidad());
		model.addAttribute("instTipDes", datosAutoridad.getAmbito());
		model.addAttribute("InstitucionDignidad", datosAutoridad.getInstitucionDignidad());
		model.addAttribute("instTfCod", 9);
		model.addAttribute("estado", datosAutoridad.getEstado());

		List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacion(1, "activo");
		model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);

		List<TblLocalizacion> listadoLocalizacionCanton = gcs.obtenerLocalizacion(2, "activo");
		model.addAttribute("listadoLocalizacionCanton", listadoLocalizacionCanton);

		List<TblLocalizacion> listadoLocalizacionParroquia = gcs.obtenerLocalizacion(4, "activo");
		model.addAttribute("listadoLocalizacionParroquia", listadoLocalizacionParroquia);

		List<TblTipoInforme> listadoTipoInforme = gcs.obtenerTipoInforme(Constantes.ESTADO);
		model.addAttribute("listadoTipoInforme", listadoTipoInforme);

		List<TblDatosFuncionarios> listadoFuncionario = UsuInterno
				.obtenerFuncionarioXCargo(Constantes.ESTADO_ACTIVO_USUARIOS.toString(), "SUBCOORDINADOR");
		model.addAttribute("listadoFuncionario", listadoFuncionario);

		List<TblDatosFuncionarios> listadoFuncionariosRc = UsuInterno
				.obtenerFuncionarios(Constantes.ESTADO_ACTIVO_USUARIOS.toString());
		model.addAttribute("listadoFuncionariosRc", listadoFuncionariosRc);

		return "tecnicoNacional/ActualizarCatastroAutoridad";
	}

	@GetMapping("/view/tecnicoNacional/GuardarActualiarCatastroAutoridad")
	public String GuardarActualiarCatastroAutoridad(TblInstitucion tblInstitucion) {
		return "redirect:../../index";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/tecnicoNacional/GuardarActualiarCatastroAutoridad")
	public @ResponseBody String GuardarActualiarCatastroAutoridad(HttpServletRequest request,
			@RequestParam("identificadorEjecuto") String emailTecnico, @RequestParam("instNom") String nombreAutoridad,
			@RequestParam("instRuc") String cedula, @RequestParam("provCod") Integer provCod,
			@RequestParam(value = "cantCod", required = false) Integer cantCod,
			@RequestParam(value = "parroCod", required = false) Integer parroCod,
			@RequestParam("instFunCod") String dignidad, @RequestParam("instTipDes") String ambito,
			@RequestParam("instTfCod") Integer instTfCod,
			@RequestParam(value = "instDesUdaf", required = false) String institucionDignidad,
			@RequestParam("aprobado") Integer aprobado, @RequestParam("pathModuloVerifica") String pathModuloVerifica,
			@RequestParam("instCond") Integer autCodigo, @RequestParam("descripcion") String descripcion) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			String DatoHistorico = null;
			String DatoNuevo = null;
			TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(emailTecnico, Constantes.periodo());

			TblDatosFuncionarios Subcoordinador = UsuInterno.ObtenerDatodFuncionarioXCod(aprobado);
			TblAplicacionesRegistradas listaAplicaciones = us.buscarAplicacionRegistradaPorEmaeilidentifiador(
					datosUsuario.getEmail(), Constantes.periodo().toString(), Constantes.ESTADO_ACTIVO_USUARIOS);

			TblAutoridad tblAutoridad = autori.buscarAutordadCodAutPeriodo(autCodigo, Constantes.periodo());
			DatoHistorico = tblAutoridad.getAutCodigo() + ", " + tblAutoridad.getIdentificador() + ", "
					+ tblAutoridad.getNombre() + ", " + tblAutoridad.getProvincia() + ", " + ", "
					+ tblAutoridad.getDignidad() + ", " + tblAutoridad.getAmbito() + ", "
					+ tblAutoridad.getInstitucionDignidad() + ", " + tblAutoridad.getFechaRegistro() + ", "
					+ tblAutoridad.getFechaActivar() + ", " + tblAutoridad.getEstado() + ", "
					+ tblAutoridad.getPeriodo();

			tblAutoridad.setIdentificador(cedula);
			;
			tblAutoridad.setNombre(nombreAutoridad.toUpperCase());
			tblAutoridad.setProvincia(provCod);
			tblAutoridad.setCanton(cantCod);
			tblAutoridad.setParroquia(parroCod);
			tblAutoridad.setDignidad(dignidad);
			tblAutoridad.setAmbito(ambito);
			tblAutoridad.setInstitucionDignidad(institucionDignidad);
			autori.guardarAutoridad(tblAutoridad);

			InetAddress direccionIp = InetAddress.getLocalHost();
			String hostname = direccionIp.getHostName();// nombre host
			String ipHostname = direccionIp.getHostAddress();// ip como String

			DatoNuevo = tblAutoridad.getAutCodigo() + ", " + tblAutoridad.getIdentificador() + ", "
					+ tblAutoridad.getNombre() + ", " + tblAutoridad.getProvincia() + ", " + ", "
					+ tblAutoridad.getDignidad() + ", " + tblAutoridad.getAmbito() + ", "
					+ tblAutoridad.getInstitucionDignidad() + ", " + tblAutoridad.getFechaRegistro() + ", "
					+ tblAutoridad.getFechaActivar() + ", " + tblAutoridad.getEstado() + ", "
					+ tblAutoridad.getPeriodo();

			String version = listaAplicaciones.getIdAplicacion().getVersionApp();
			TblHistoricoInstituciones tblHistoricoInstituciones = new TblHistoricoInstituciones();
			tblHistoricoInstituciones.setIdTecnico(datosUsuario.getIdUser());
			tblHistoricoInstituciones.setIdNombreTecnico(datosUsuario.getNombre());
			tblHistoricoInstituciones.setDatoHistorico(DatoHistorico);
			tblHistoricoInstituciones.setDatoActual(DatoNuevo);
			tblHistoricoInstituciones
					.setAprobadoPor(Subcoordinador.getIdDatoFuncionario() + ", " + Subcoordinador.getIdentificador()
							+ ", " + Subcoordinador.getNombre() + ", " + Subcoordinador.getCargo());
			tblHistoricoInstituciones.setVersionSistema(version);
			tblHistoricoInstituciones.setIpAdress(Constantes.getClientIpAddr(request));
			tblHistoricoInstituciones.setHostName(hostname + ", " + ipHostname);
			tblHistoricoInstituciones.setAcccion(Constantes.ACCION_UPDATE);
			tblHistoricoInstituciones.setFechaAccion(new Date());
			tblHistoricoInstituciones
					.setDescripcion(Constantes.DESCRIPCION_ACTUALIZACION_CATASTRO + "<br>" + descripcion);
			tblHistoricoInstituciones.setRutaAnexo(pathModuloVerifica);
			tblHistoricoInstituciones.setCodReferencial(tblAutoridad.getAutCodigo());
			tblHistoricoInstituciones.setTipoHistorico(Constantes.TIPO_REGISTRO_AUTORIDAD);
			gcs.GuardarHistoricoInstitucion(tblHistoricoInstituciones);

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		}

		catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/tecnicoNacional/EliminacionAutoridad")
	public @ResponseBody String EliminacionAutoridad(HttpServletRequest request,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("aprobado") Integer aprobado, @RequestParam("pathModuloRegistro") String pathModuloRegistro,
			@RequestParam("identificador") Integer identificador) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			String DatoHistorico = null;
			String DatoNuevo = null;
			TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(identificadorResponsable, Constantes.periodo());

			TblDatosFuncionarios Subcoordinador = UsuInterno.ObtenerDatodFuncionarioXCod(aprobado);
			TblAplicacionesRegistradas listaAplicaciones = us.buscarAplicacionRegistradaPorEmaeilidentifiador(
					datosUsuario.getEmail(), Constantes.periodo().toString(), Constantes.ESTADO_ACTIVO_USUARIOS);

			TblAutoridad tblAutoridad = autori.buscarAutordadCodAutPeriodo(identificador, Constantes.periodo());
			DatoHistorico = tblAutoridad.getAutCodigo() + ", " + tblAutoridad.getIdentificador() + ", "
					+ tblAutoridad.getNombre() + ", " + tblAutoridad.getProvincia() + ", " + ", "
					+ tblAutoridad.getDignidad() + ", " + tblAutoridad.getAmbito() + ", "
					+ tblAutoridad.getInstitucionDignidad() + ", " + tblAutoridad.getFechaRegistro() + ", "
					+ tblAutoridad.getFechaActivar() + ", " + tblAutoridad.getEstado() + ", "
					+ tblAutoridad.getPeriodo();

			tblAutoridad.setEstado(Constantes.ESTADO_ELIMINADO);
			autori.guardarAutoridad(tblAutoridad);
			
			TblUsuario usuarioInst = us.buscarCodigoAutoridaXperidoXestado(identificador, Constantes.ESTADO_ACTIVO_USUARIOS, Constantes.periodo(), Constantes.TIPO_REGISTRO_AUTORIDAD);		
			if (usuarioInst.getTipoUser() == Constantes.TIPO_REGISTRO_AUTORIDAD) {
				usuarioInst.setEstado(Constantes.ESTADO_INACTIVO_USUARIOS);
				us.guardarUsuario(usuarioInst);
			}

			InetAddress direccionIp = InetAddress.getLocalHost();
			String hostname = direccionIp.getHostName();// nombre host
			String ipHostname = direccionIp.getHostAddress();// ip como String

			DatoNuevo = tblAutoridad.getAutCodigo() + ", " + tblAutoridad.getIdentificador() + ", "
					+ tblAutoridad.getNombre() + ", " + tblAutoridad.getProvincia() + ", " + ", "
					+ tblAutoridad.getDignidad() + ", " + tblAutoridad.getAmbito() + ", "
					+ tblAutoridad.getInstitucionDignidad() + ", " + tblAutoridad.getFechaRegistro() + ", "
					+ tblAutoridad.getFechaActivar() + ", " + tblAutoridad.getEstado() + ", "
					+ tblAutoridad.getPeriodo();

			String version = listaAplicaciones.getIdAplicacion().getVersionApp();
			TblHistoricoInstituciones tblHistoricoInstituciones = new TblHistoricoInstituciones();
			tblHistoricoInstituciones.setIdTecnico(datosUsuario.getIdUser());
			tblHistoricoInstituciones.setIdNombreTecnico(datosUsuario.getNombre());
			tblHistoricoInstituciones.setDatoHistorico(DatoHistorico);
			tblHistoricoInstituciones.setDatoActual(DatoNuevo);
			tblHistoricoInstituciones
					.setAprobadoPor(Subcoordinador.getIdDatoFuncionario() + ", " + Subcoordinador.getIdentificador()
							+ ", " + Subcoordinador.getNombre() + ", " + Subcoordinador.getCargo());
			tblHistoricoInstituciones.setVersionSistema(version);
			tblHistoricoInstituciones.setIpAdress(Constantes.getClientIpAddr(request));
			tblHistoricoInstituciones.setHostName(hostname + ", " + ipHostname);
			// tblHistoricoInstituciones.setSolicitadoPor(Solicitado.getIdDatoFuncionario()
			// + ", "+ Solicitado.getIdentificador() + ", " + Solicitado.getNombre() + ", "
			// + Solicitado.getCargo());
			tblHistoricoInstituciones.setAcccion(Constantes.ACCION_UPDATE);
			tblHistoricoInstituciones.setFechaAccion(new Date());
			tblHistoricoInstituciones.setDescripcion(Constantes.DESCRIPCION_ILIMINACION_CATASTRO);
			tblHistoricoInstituciones.setRutaAnexo(pathModuloRegistro);
			tblHistoricoInstituciones.setCodReferencial(tblAutoridad.getAutCodigo());
			tblHistoricoInstituciones.setTipoHistorico(Constantes.TIPO_REGISTRO_AUTORIDAD);
			gcs.GuardarHistoricoInstitucion(tblHistoricoInstituciones);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		}

		catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/tecnicoNacional/ActivarAutoridad")
	public @ResponseBody String ActivarAutoridad(HttpServletRequest request,
			@RequestParam("identificadorResponsableAct") String identificadorResponsable,
			@RequestParam("aprobadoAct") Integer aprobado,
			@RequestParam("pathModuloRegistro1") String pathModuloRegistro1,
			@RequestParam("identificadorAct") Integer identificador) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			String DatoHistorico = null;
			String DatoNuevo = null;
			TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(identificadorResponsable, Constantes.periodo());

			TblDatosFuncionarios Subcoordinador = UsuInterno.ObtenerDatodFuncionarioXCod(aprobado);
			TblAplicacionesRegistradas listaAplicaciones = us.buscarAplicacionRegistradaPorEmaeilidentifiador(
					datosUsuario.getEmail(), Constantes.periodo().toString(), Constantes.ESTADO_ACTIVO_USUARIOS);

			TblAutoridad tblAutoridad = autori.buscarAutordadCodAutPeriodo(identificador, Constantes.periodo());
			DatoHistorico = tblAutoridad.getAutCodigo() + ", " + tblAutoridad.getIdentificador() + ", "
					+ tblAutoridad.getNombre() + ", " + tblAutoridad.getProvincia() + ", " + ", "
					+ tblAutoridad.getDignidad() + ", " + tblAutoridad.getAmbito() + ", "
					+ tblAutoridad.getInstitucionDignidad() + ", " + tblAutoridad.getFechaRegistro() + ", "
					+ tblAutoridad.getFechaActivar() + ", " + tblAutoridad.getEstado() + ", "
					+ tblAutoridad.getPeriodo();

			tblAutoridad.setEstado(Constantes.ESTADO_REGISTRADO);
			autori.guardarAutoridad(tblAutoridad);
			
			TblUsuario usuarioInst = us.buscarCodigoAutoridaXperidoXestado(identificador, Constantes.ESTADO_ACTIVO_USUARIOS, Constantes.periodo(), Constantes.TIPO_REGISTRO_AUTORIDAD);		
			if (usuarioInst.getTipoUser() == Constantes.TIPO_REGISTRO_AUTORIDAD) {
				usuarioInst.setEstado(Constantes.ESTADO_ACTIVO_USUARIOS);
				us.guardarUsuario(usuarioInst);
			}

			InetAddress direccionIp = InetAddress.getLocalHost();
			String hostname = direccionIp.getHostName();// nombre host
			String ipHostname = direccionIp.getHostAddress();// ip como String

			DatoNuevo = tblAutoridad.getAutCodigo() + ", " + tblAutoridad.getIdentificador() + ", "
					+ tblAutoridad.getNombre() + ", " + tblAutoridad.getProvincia() + ", " + ", "
					+ tblAutoridad.getDignidad() + ", " + tblAutoridad.getAmbito() + ", "
					+ tblAutoridad.getInstitucionDignidad() + ", " + tblAutoridad.getFechaRegistro() + ", "
					+ tblAutoridad.getFechaActivar() + ", " + tblAutoridad.getEstado() + ", "
					+ tblAutoridad.getPeriodo();
			String version = listaAplicaciones.getIdAplicacion().getVersionApp();
			TblHistoricoInstituciones tblHistoricoInstituciones = new TblHistoricoInstituciones();
			tblHistoricoInstituciones.setIdTecnico(datosUsuario.getIdUser());
			tblHistoricoInstituciones.setIdNombreTecnico(datosUsuario.getNombre());
			tblHistoricoInstituciones.setDatoHistorico(DatoHistorico);
			tblHistoricoInstituciones.setDatoActual(DatoNuevo);
			tblHistoricoInstituciones
					.setAprobadoPor(Subcoordinador.getIdDatoFuncionario() + ", " + Subcoordinador.getIdentificador()
							+ ", " + Subcoordinador.getNombre() + ", " + Subcoordinador.getCargo());
			tblHistoricoInstituciones.setVersionSistema(version);
			tblHistoricoInstituciones.setIpAdress(Constantes.getClientIpAddr(request));
			tblHistoricoInstituciones.setHostName(hostname + ", " + ipHostname);
			// tblHistoricoInstituciones.setSolicitadoPor(Solicitado.getIdDatoFuncionario()
			// + ", " + Solicitado.getIdentificador() + ", " + Solicitado.getNombre() + ", "
			// + Solicitado.getCargo());
			tblHistoricoInstituciones.setAcccion(Constantes.ACCION_UPDATE);
			tblHistoricoInstituciones.setFechaAccion(new Date());
			tblHistoricoInstituciones.setDescripcion(Constantes.DESCRIPCION_ACTIVACION_CATASTRO);
			tblHistoricoInstituciones.setRutaAnexo(pathModuloRegistro1);
			tblHistoricoInstituciones.setCodReferencial(tblAutoridad.getAutCodigo());
			tblHistoricoInstituciones.setTipoHistorico(Constantes.TIPO_REGISTRO_AUTORIDAD);
			gcs.GuardarHistoricoInstitucion(tblHistoricoInstituciones);
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		}

		catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	// CAMM Seguimineto instituciones
	@RequestMapping("/view/tecnicoNacional/ListarSeguiminetoInstituciones")
	public String ListarSeguiminetoInstituciones(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
		if (hasRole("ROLE_NACIONAL")) {
			model.addAttribute("rol", "Nacional");
		} else if (hasRole("ROLE_PROVINCIAL")) {
			model.addAttribute("rol", "Provincial");
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Adminnistrador");
		}
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("anio", Constantes.PERIODP_INICIO_SISTEMA);
		return "tecnicoNacional/ListarSeguiminetoInstituciones";
	}
	

	@RequestMapping(value = { "/obtenerSeguiminetoInstituciones" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerSeguiminetoInstituciones(Authentication authentication, @RequestParam("periodo") int periodo) {
		String json;
		ObjectMapper mapper = new ObjectMapper();
		List<SeguimientoInstitucionDTO> ListaRegistroSeguimiento = null;
		try {
			ListaRegistroSeguimiento = gcs.seguimineto(periodo);
			if (ListaRegistroSeguimiento.size() > 0) {
				json = "{\"data\": " + mapper.writeValueAsString(ListaRegistroSeguimiento) + "}";

			} else {

				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";
		}
		return json;

	}
	//metodo para generar un secuencia de años 
	private List<Integer> getPeriodos(Integer periodo){
		return IntStream.range(periodo, Calendar.getInstance().get(Calendar.YEAR))
				.boxed()
				.collect(Collectors.toList());
	}
	
	

}