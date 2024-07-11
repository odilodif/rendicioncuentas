package gob.cpccs.controller.rendicion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.sun.corba.se.impl.orbutil.closure.Constant;

import gob.cpccs.model.catalogos.TblInstitucion;
import gob.cpccs.model.catalogos.TblLocalizacion;
import gob.cpccs.model.rendicion.TblFuncionesObjetivos;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblInformeAutoridad;
import gob.cpccs.model.rendicion.TblNegarAutoridad;
import gob.cpccs.model.rendicion.TblObservacionesNegar;
import gob.cpccs.model.usuario.TblAutoridad;
import gob.cpccs.model.usuario.TblResponables;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.service.autoridad.AutoridadServicio;
import gob.cpccs.service.catalogos.CatalogosServicio;
import gob.cpccs.service.catalogos.InstitucionServicio;
import gob.cpccs.service.mail.EmailService;
import gob.cpccs.service.rendicion.InformeServicio;
import gob.cpccs.service.rendicion.ServicioObservacion;
import gob.cpccs.service.usuario.ResponsableServicio;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;

@Controller
public class RendicionCuentasController {

	@Autowired
	private InstitucionServicio servicioinstitucion;
	@Autowired
	private CatalogosServicio gcs;
	@Autowired
	private InformeServicio is;
	@Autowired
	private EmailService ms;
	@Autowired
	private ResponsableServicio resp;
	@Autowired
	private UsuarioServicio Usu_registro;
	@Autowired
	private ServicioObservacion observacioInstitucion;
	@Autowired
	private AutoridadServicio autori;
	@Autowired
	private UsuarioServicio us;
	@Autowired
	private InformeServicio infor;

	@RequestMapping("/view/rendicion/registroPeriodo")
	public String registroPeriodo(Model model, @RequestParam("opcion") int idMenu, Authentication authentication)
			throws ParseException {
		JSONObject mensaje = new JSONObject();
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		TblAutoridad datosAutoridad = autori.buscarAutordadCodAutPeriodo(datosUsuario.getCodigoIntitucionAutorida(),
				datosUsuario.getPeriodo());
		Date hoy = new Date();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		if (datosAutoridad.getDignidad().equals("ASAMBLEÍSTA NACIONAL")
				|| datosAutoridad.getDignidad().equals("ASAMBLEÍSTA PROVINCIAL")
				|| datosAutoridad.getDignidad().equals("ASAMBLEÍSTA POR CIRCUNSCRIPCIÓN TERRITORIAL")
				|| datosAutoridad.getDignidad().equals("ASAMBLEÍSTA REPRESENTANTE EXTRANJERO")
				|| datosAutoridad.getDignidad().equals("CONSEJERA/ CONSEJERO DEL CPCCS")
				|| datosAutoridad.getDignidad().equals("PRESIDENTE DE LA REPÚBLICA")
				|| datosAutoridad.getDignidad().equals("VICEPRESIDENTE DE LA REPÚBLICA")) {

			Date fechaInicioBloqueo = format.parse(Constantes.FECHA_CIERRE_INFORME_AUTORIDAD_ASAMBLEISTA);
			Date fechaFinBloqueo = format.parse(Constantes.FECHA_BLOQUEO_SISTEMA_AUTORIDAD_ASAMBLEISTA);
			if (hoy.after(fechaInicioBloqueo) && hoy.before(fechaFinBloqueo)) {
				mensaje.put("estado", "error");
				mensaje.put("mensaje", "El tiempo para rendir cuentas ha terminado!");
				model.addAttribute("infAutEstado", Constantes.ESTADO_PROCESO_CONCLUIDO);
				model.addAttribute("periodo", datosAutoridad.getPeriodo());
				model.addAttribute("fechaApertura", "15 de mayo");
				model.addAttribute("anio", datosAutoridad.getPeriodo() + 1);

			} else {

				model.addAttribute("identificador", datosUsuario.getCodigoIntitucionAutorida());
				model.addAttribute("tipo", datosUsuario.getTipoUser());
				TblInformeAutoridad verificarInforme = is.obtenerRegistroInformexIdentificador(
						datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
				if (verificarInforme == null) {
					model.addAttribute("infAutEstado", "vacio");
				} else {
					model.addAttribute("infAutEstado", verificarInforme.getInfAutEstado());
					model.addAttribute("numeroInforme", verificarInforme.getInfAutCod());
					model.addAttribute("nombreAutoridad", datosAutoridad.getNombre());
					model.addAttribute("identificadorAutoridad", datosAutoridad.getIdentificador());
					model.addAttribute("institucionDignidad", datosAutoridad.getInstitucionDignidad());
					model.addAttribute("dignidad", datosAutoridad.getDignidad());
					model.addAttribute("ambito", datosAutoridad.getAmbito());
					model.addAttribute("periodo", datosAutoridad.getPeriodo());

				}

			}
		} else {

			Date fechaInicioBloqueo = format.parse(Constantes.FECHA_CIERRE_INFORME_AUTORIDAD);
			Date fechaFinBloqueo = format.parse(Constantes.FECHA_BLOQUEO_SISTEMA_AUTORIDAD);
			if (hoy.after(fechaInicioBloqueo) && hoy.before(fechaFinBloqueo)) {
				mensaje.put("estado", "error");
				mensaje.put("mensaje", "El tiempo para rendir cuentas ha terminado!");
				model.addAttribute("infAutEstado", Constantes.ESTADO_PROCESO_CONCLUIDO);
				model.addAttribute("periodo", datosAutoridad.getPeriodo());
				model.addAttribute("fechaApertura", "15 de junio");
				model.addAttribute("anio", datosAutoridad.getPeriodo() + 1);

			} else {

				model.addAttribute("identificador", datosUsuario.getCodigoIntitucionAutorida());
				model.addAttribute("tipo", datosUsuario.getTipoUser());
				TblInformeAutoridad verificarInforme = is.obtenerRegistroInformexIdentificador(
						datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
				if (verificarInforme == null) {
					model.addAttribute("infAutEstado", "vacio");
				} else {
					model.addAttribute("infAutEstado", verificarInforme.getInfAutEstado());
					model.addAttribute("numeroInforme", verificarInforme.getInfAutCod());
					model.addAttribute("nombreAutoridad", datosAutoridad.getNombre());
					model.addAttribute("identificadorAutoridad", datosAutoridad.getIdentificador());
					model.addAttribute("institucionDignidad", datosAutoridad.getInstitucionDignidad());
					model.addAttribute("dignidad", datosAutoridad.getDignidad());
					model.addAttribute("ambito", datosAutoridad.getAmbito());
					model.addAttribute("periodo", datosAutoridad.getPeriodo());
				}

			}

		}
		return "rendicion/registroPeriodo";
	}

	/* Metodo Buscar instituciones */
	@SuppressWarnings("finally")
	@RequestMapping(value = "/BuscarInstitucionId")
	public @ResponseBody String BuscarInstitucionId(@RequestParam("identificador") int id,
			@Param("maxResults") Integer maxResults) {

		JSONObject mensaje = new JSONObject();
		try {
			List<TblFuncionesObjetivos> ListadoFuncionesObjetivo = is
					.obtenerRegistroInformeInstitucionFuncionesObjetivos(id);
			for (TblFuncionesObjetivos obj : ListadoFuncionesObjetivo) {
				JSONObject mensaje1 = new JSONObject();
				mensaje1.put("value", obj.getFoCod());
				mensaje1.put("label", obj.getFoNom());
				mensaje1.put("label", obj.getFoTip());
				mensaje.put(obj.getFoNom(), mensaje1);
			}

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	@RequestMapping("/view/rendicion/registroPeriodoInstitucion")
	public String registroPeriodoInstitucion(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) throws ParseException {
		model.addAttribute("email", authentication.getName());
		TblUsuario datosUsuario = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		TblInstitucion datosInstitucion = servicioinstitucion
				.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());

		if (datosInstitucion.getInstEstado().equals("eliminado")) {
			model.addAttribute("estadoInforme", Constantes.ESTADO_ELIMINADO);

		} else {

			Date hoy = new Date();
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			model.addAttribute("identificador", datosUsuario.getCodigoIntitucionAutorida());
			model.addAttribute("tipo", datosUsuario.getTipoUser());
			TblInforme verificarInforme = is.obtenerRegistroInformeInstitucion(
					datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());
			if (datosInstitucion.getInstTfCod().getTfCod().equals(3)
					|| datosInstitucion.getInstTfCod().getTfCod().equals(5)
					|| datosInstitucion.getInstTfCod().getTfCod().equals(6)
					|| datosInstitucion.getInstTfCod().getTfCod().equals(7)
					|| datosInstitucion.getInstTfCod().getTfCod().equals(8)) {
				Date fechaInicioBloqueo = format.parse(Constantes.FECHA_CIERRE_INFORME_FUNCIONES_ESTADO);
				Date fechaFinBloqueo = format.parse(Constantes.FECHA_BLOQUEO_SISTEMA_FUNCIONES);
				if (hoy.after(fechaInicioBloqueo) && hoy.before(fechaFinBloqueo)) {
					model.addAttribute("estadoInforme", Constantes.ESTADO_PROCESO_CONCLUIDO);
					model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
					model.addAttribute("fechaApertura", "15 de mayo");
					model.addAttribute("anio", datosInstitucion.getInstPeriodo() + 1);

					/*
					 * aquí paso algo. no se que queria hacer if (verificarInforme==null){
					 * 
					 * }else {
					 * //infor.finalizarTiempoInformeInstitucion(verificarInforme.getInstCod(),
					 * Constantes.ESTADO_INFORME_FINALIZADO);
					 * //servicioinstitucion.actualizarInstVerificador(verificarInforme.getInstCod()
					 * , Constantes.periodo(), Constantes.ESTADO_PROCESO_INCUMPLIDO); }
					 */
				} else {

					/*
					 * if (verificarInforme==null){
					 * 
					 * }else { if(verificarInforme.getInfVerificador()==null) {
					 * //infor.finalizarTiempoInformeInstitucion(verificarInforme.getInstCod(),
					 * Constantes.ESTADO); }
					 * 
					 * }
					 */
					List<TblResponables> correos = resp.buscarResponsableXcodigoInstitucion(
							datosInstitucion.getInstCod(), Constantes.periodo().toString());
					List<TblFuncionesObjetivos> verificarFuncionesObjetivos = is
							.obtenerRegistroInformeInstitucionFuncionesObjetivos(
									datosUsuario.getCodigoIntitucionAutorida());
					String perdiodoRC = Constantes.periodo().toString();
					List<Object[]> listaFuncionesObjetivos = is.BuscarFuncionesObjetivosInstCod(
							datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC, Constantes.ESTADO);
					String tipo = "COMPETENCIAS EXCLUSIVAS";
					List<Object[]> listaCompetenciasExclusivas = is.BuscarFuncionesObjetivosInstCodTipo(
							datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC, Constantes.ESTADO_INACTIVO, tipo);
					if (verificarInforme == null) {
						model.addAttribute("estadoInforme", "vacio");
						model.addAttribute("funcionObjetivo", "vacio");
						model.addAttribute("gad", "vacio");
					} else {

						if (listaFuncionesObjetivos.size() == 0) {

							if ((listaCompetenciasExclusivas.size() == 0)
									&& (!datosInstitucion.getInstTipDes().trim().equals("INSTITUCIONES VINCULADAS"))) {
								if (datosInstitucion.getInstFunCod().getFunCod().equals(2)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(3)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(4)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(5)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(6)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(7)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(1)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(12)) {

									model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
									model.addAttribute("funcionObjetivo", "vacio");
									model.addAttribute("numeroInforme", verificarInforme.getInfCod());
									model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
									model.addAttribute("tipoInstitucion", "ejecutivo");
								} else {

									if (datosInstitucion.getInstFunCod().getFunCod().equals(11)
											|| datosInstitucion.getInstFunCod().getFunCod().equals(8) 
											|| datosInstitucion.getInstFunCod().getFunCod().equals(13)) {

										model.addAttribute("gad", "institucionesVinculadas");
										model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
										model.addAttribute("funcionObjetivo", "vacio");
										model.addAttribute("numeroInforme", verificarInforme.getInfCod());
										model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
										model.addAttribute("listaCompetenciasExclusivas", listaCompetenciasExclusivas);
										model.addAttribute("tipoInstitucion", "vinculada");
									} else {
										model.addAttribute("gad", "gad");
										model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
										model.addAttribute("funcionObjetivo", "vacio");
										model.addAttribute("numeroInforme", verificarInforme.getInfCod());
										model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
										model.addAttribute("listaCompetenciasExclusivas", listaCompetenciasExclusivas);
									}

								}
							} else {

								if (datosInstitucion.getInstTipDes().trim().equals("GAD")
										|| datosInstitucion.getInstTipDes().trim().equals("EMPRESAS PÚBLICAS")
										|| datosInstitucion.getInstTipDes().trim().equals("VINCULADAS AL GAD")) {
									model.addAttribute("gad", "gad");
									model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
									model.addAttribute("funcionObjetivo", "vacio");
									model.addAttribute("numeroInforme", verificarInforme.getInfCod());
									model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
									model.addAttribute("listaCompetenciasExclusivas", listaCompetenciasExclusivas);

								} else {

									if (datosInstitucion.getInstTipDes().trim().equals("INSTITUCIONES VINCULADAS")
											|| datosInstitucion.getInstTipDes().trim()
													.equals("MANCOMUNIDADES Y CONSORCIOS/ COMPETENCIAS A GAD")
											|| datosInstitucion.getInstTipDes().trim()
													.equals("MANCOMUNIDADES Y CONSORCIOS/ COMPETENCIAS DE GAD")) {
										if (datosInstitucion.getInstFunCod().getFunCod().equals(5)) {
											model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
											model.addAttribute("funcionObjetivo", "vacio");
											model.addAttribute("numeroInforme", verificarInforme.getInfCod());
											model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
											model.addAttribute("tipoInstitucion", "ejecutivo");
										} else {
											model.addAttribute("gad", "institucionesVinculadas");
											model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
											model.addAttribute("funcionObjetivo", "vacio");
											model.addAttribute("numeroInforme", verificarInforme.getInfCod());
											model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
											model.addAttribute("listaCompetenciasExclusivas",
													listaCompetenciasExclusivas);
											model.addAttribute("tipoInstitucion", "vinculada");

										}

									}
								}
							}
						} else {

							///// listo
							if (datosInstitucion.getInstTipDes().trim().equals("GAD")) {
								if (datosInstitucion.getInstFunCod().getFunCod().equals(8)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(9)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(10)) {
									model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
									model.addAttribute("funcionObjetivo", "activo");
									model.addAttribute("numeroInforme", verificarInforme.getInfCod());
									model.addAttribute("nombreInstitución", datosInstitucion.getInstNom());
									model.addAttribute("identificadorInstitucion", datosInstitucion.getInstRuc());
									model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
									for (TblResponables datos : correos) {
										if (datos.getResponTipo().equals(Constantes.REPRESENTANTE_LEGAL)) {
											model.addAttribute("representanteLegal", datos.getResponNombre());
										}
									}
									model.addAttribute("funcion", datosInstitucion.getInstFunCod().getFunDes());
									model.addAttribute("tipo", datosInstitucion.getInstTipDes());
									model.addAttribute("pertenece", datosInstitucion.getInstDesUdaf());
									model.addAttribute("tipoInstitucion", "gad");
									List<Object[]> listaCompetenciasExclusivasActualizar = is
											.BuscarFuncionesObjetivosInstCodTipo(
													datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
													Constantes.ESTADO, "COMPETENCIAS EXCLUSIVAS");
									model.addAttribute("listaCompetenciasExclusivasActualizar",
											listaCompetenciasExclusivasActualizar);
									List<Object[]> listaCompetenciasConcurrentesActualizar = is
											.BuscarFuncionesObjetivosInstCodTipo(
													datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
													Constantes.ESTADO, "COMPETENCIAS CONCURRENTES");
									model.addAttribute("listaCompetenciasConcurrentesActualizar",
											listaCompetenciasConcurrentesActualizar);
								} else {
									model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
									model.addAttribute("funcionObjetivo", "activo");
									model.addAttribute("numeroInforme", verificarInforme.getInfCod());
									model.addAttribute("nombreInstitución", datosInstitucion.getInstNom());
									model.addAttribute("identificadorInstitucion", datosInstitucion.getInstRuc());
									model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
									for (TblResponables datos : correos) {
										if (datos.getResponTipo().equals(Constantes.REPRESENTANTE_LEGAL)) {
											model.addAttribute("representanteLegal", datos.getResponNombre());
										}
									}
									model.addAttribute("funcion", datosInstitucion.getInstFunCod().getFunDes());
									model.addAttribute("tipo", datosInstitucion.getInstTipDes());
									model.addAttribute("pertenece", datosInstitucion.getInstDesUdaf());
									model.addAttribute("tipoInstitucion", "ejecutivo");
									List<Object[]> listaCompetenciasConcurrentesActualizar = is
											.BuscarFuncionesObjetivosInstCodSinTipo(
													datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
													Constantes.ESTADO);
									model.addAttribute("listaCompetenciasConcurrentesActualizar",
											listaCompetenciasConcurrentesActualizar);
								}
							} else {

								if (datosInstitucion.getInstTipDes().trim().equals("INSTITUCIONES VINCULADAS")
										|| datosInstitucion.getInstTipDes().trim()
												.equals("MANCOMUNIDADES Y CONSORCIOS/ COMPETENCIAS A GAD")
										|| datosInstitucion.getInstTipDes().trim()
												.equals("MANCOMUNIDADES Y CONSORCIOS/ COMPETENCIAS DE GAD")
										|| datosInstitucion.getInstTipDes().trim().equals("EMPRESAS PÚBLICAS")) {
									if (datosInstitucion.getInstFunCod().getFunCod().equals(8)
											|| datosInstitucion.getInstFunCod().getFunCod().equals(9)
											|| datosInstitucion.getInstFunCod().getFunCod().equals(10)
											|| datosInstitucion.getInstFunCod().getFunCod().equals(11)
											|| datosInstitucion.getInstFunCod().getFunCod().equals(13)) {
										model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
										model.addAttribute("funcionObjetivo", "activo");
										model.addAttribute("numeroInforme", verificarInforme.getInfCod());
										model.addAttribute("nombreInstitución", datosInstitucion.getInstNom());
										model.addAttribute("identificadorInstitucion", datosInstitucion.getInstRuc());
										model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
										for (TblResponables datos : correos) {
											if (datos.getResponTipo().equals(Constantes.REPRESENTANTE_LEGAL)) {
												model.addAttribute("representanteLegal", datos.getResponNombre());
											}
										}
										model.addAttribute("funcion", datosInstitucion.getInstFunCod().getFunDes());
										model.addAttribute("tipo", datosInstitucion.getInstTipDes());
										model.addAttribute("pertenece", datosInstitucion.getInstDesUdaf());
										model.addAttribute("tipoInstitucion", "vinculada");
										List<Object[]> listaCompetenciasExclusivasActualizar = is
												.BuscarFuncionesObjetivosInstCodTipo(
														datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
														Constantes.ESTADO, "COMPETENCIAS EXCLUSIVAS");
										model.addAttribute("listaCompetenciasExclusivasActualizar",
												listaCompetenciasExclusivasActualizar);
										List<Object[]> listaCompetenciasConcurrentesActualizar = is
												.BuscarFuncionesObjetivosInstCodTipo(
														datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
														Constantes.ESTADO, "COMPETENCIAS CONCURRENTES");
										model.addAttribute("listaCompetenciasConcurrentesActualizar",
												listaCompetenciasConcurrentesActualizar);
									} else {
										model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
										model.addAttribute("funcionObjetivo", "activo");
										model.addAttribute("numeroInforme", verificarInforme.getInfCod());
										model.addAttribute("nombreInstitución", datosInstitucion.getInstNom());
										model.addAttribute("identificadorInstitucion", datosInstitucion.getInstRuc());
										model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
										for (TblResponables datos : correos) {
											if (datos.getResponTipo().equals(Constantes.REPRESENTANTE_LEGAL)) {
												model.addAttribute("representanteLegal", datos.getResponNombre());
											}
										}
										model.addAttribute("funcion", datosInstitucion.getInstFunCod().getFunDes());
										model.addAttribute("tipo", datosInstitucion.getInstTipDes());
										model.addAttribute("pertenece", datosInstitucion.getInstDesUdaf());
										model.addAttribute("tipoInstitucion", "ejecutivo");
										List<Object[]> listaCompetenciasConcurrentesActualizar = is
												.BuscarFuncionesObjetivosInstCodSinTipo(
														datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
														Constantes.ESTADO);
										model.addAttribute("listaCompetenciasConcurrentesActualizar",
												listaCompetenciasConcurrentesActualizar);

									}
								} else {
									if (!datosInstitucion.getInstFunCod().getFunCod().equals(8)
											|| !datosInstitucion.getInstFunCod().getFunCod().equals(9)
											|| !datosInstitucion.getInstFunCod().getFunCod().equals(10)
											|| !datosInstitucion.getInstFunCod().getFunCod().equals(11)
											|| !datosInstitucion.getInstFunCod().getFunCod().equals(13)) {
										model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
										model.addAttribute("funcionObjetivo", "activo");
										model.addAttribute("numeroInforme", verificarInforme.getInfCod());
										model.addAttribute("nombreInstitución", datosInstitucion.getInstNom());
										model.addAttribute("identificadorInstitucion", datosInstitucion.getInstRuc());
										model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
										for (TblResponables datos : correos) {
											if (datos.getResponTipo().equals(Constantes.REPRESENTANTE_LEGAL)) {
												model.addAttribute("representanteLegal", datos.getResponNombre());
											}
										}
										model.addAttribute("funcion", datosInstitucion.getInstFunCod().getFunDes());
										model.addAttribute("tipo", datosInstitucion.getInstTipDes());
										model.addAttribute("pertenece", datosInstitucion.getInstDesUdaf());
										model.addAttribute("tipoInstitucion", "ejecutivo");
										List<Object[]> listaCompetenciasConcurrentesActualizar = is
												.BuscarFuncionesObjetivosInstCodSinTipo(
														datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
														Constantes.ESTADO);
										model.addAttribute("listaCompetenciasConcurrentesActualizar",
												listaCompetenciasConcurrentesActualizar);
									} else {

										model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
										model.addAttribute("funcionObjetivo", "activo");
										model.addAttribute("numeroInforme", verificarInforme.getInfCod());
										model.addAttribute("nombreInstitución", datosInstitucion.getInstNom());
										model.addAttribute("identificadorInstitucion", datosInstitucion.getInstRuc());
										model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
										for (TblResponables datos : correos) {
											if (datos.getResponTipo().equals(Constantes.REPRESENTANTE_LEGAL)) {
												model.addAttribute("representanteLegal", datos.getResponNombre());
											}
										}
										model.addAttribute("funcion", datosInstitucion.getInstFunCod().getFunDes());
										model.addAttribute("tipo", datosInstitucion.getInstTipDes());
										model.addAttribute("pertenece", datosInstitucion.getInstDesUdaf());
										model.addAttribute("tipoInstitucion", "ejecutivo");
										List<Object[]> listaCompetenciasConcurrentesActualizar = is
												.BuscarFuncionesObjetivosInstCodSinTipo(
														datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
														Constantes.ESTADO);
										model.addAttribute("listaCompetenciasConcurrentesActualizar",
												listaCompetenciasConcurrentesActualizar);

									}

								}

							}

						}

						// model.addAttribute("listadoFuncionesObjetivos", listaFuncionesObjetivos);
					}

				}

			} else {

				Date fechaInicioBloqueo = format.parse(Constantes.FECHA_CIERRE_INFORME_GAD);
				Date fechaFinBloqueo = format.parse(Constantes.FECHA_BLOQUEO_SISTEMA_GADS);
				if (hoy.after(fechaInicioBloqueo) && hoy.before(fechaFinBloqueo)) {
					model.addAttribute("estadoInforme", Constantes.ESTADO_PROCESO_CONCLUIDO);
					model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
					model.addAttribute("fechaApertura", "15 de junio");
					model.addAttribute("anio", datosInstitucion.getInstPeriodo() + 1);

					if (verificarInforme == null) {

					} else {
						// infor.finalizarTiempoInformeInstitucion(verificarInforme.getInstCod(),
						// Constantes.ESTADO_INFORME_FINALIZADO);
						// servicioinstitucion.actualizarInstVerificador(verificarInforme.getInstCod(),
						// Constantes.periodo(), Constantes.ESTADO_PROCESO_INCUMPLIDO);
					}
				} else {
					if (verificarInforme == null) {

					} else {
						if (verificarInforme.getInfVerificador() == null) {
							// infor.finalizarTiempoInformeInstitucion(verificarInforme.getInstCod(),
							// Constantes.ESTADO);
						}

					}
					List<TblResponables> correos = resp.buscarResponsableXcodigoInstitucion(
							datosInstitucion.getInstCod(), Constantes.periodo().toString());
					List<TblFuncionesObjetivos> verificarFuncionesObjetivos = is
							.obtenerRegistroInformeInstitucionFuncionesObjetivos(
									datosUsuario.getCodigoIntitucionAutorida());
					String perdiodoRC = Constantes.periodo().toString();
					List<Object[]> listaFuncionesObjetivos = is.BuscarFuncionesObjetivosInstCod(
							datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC, Constantes.ESTADO);
					String tipo = "COMPETENCIAS EXCLUSIVAS";
					List<Object[]> listaCompetenciasExclusivas = is.BuscarFuncionesObjetivosInstCodTipo(
							datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC, Constantes.ESTADO_INACTIVO, tipo);
					if (verificarInforme == null) {
						model.addAttribute("estadoInforme", "vacio");
						model.addAttribute("funcionObjetivo", "vacio");
						model.addAttribute("gad", "vacio");
					} else {

						if (listaFuncionesObjetivos.size() == 0) {

							if ((listaCompetenciasExclusivas.size() == 0)
									&& (!datosInstitucion.getInstTipDes().trim().equals("INSTITUCIONES VINCULADAS"))) {
								if (datosInstitucion.getInstFunCod().getFunCod().equals(2)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(3)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(4)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(5)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(6)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(7)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(1)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(12)) {

									model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
									model.addAttribute("funcionObjetivo", "vacio");
									model.addAttribute("numeroInforme", verificarInforme.getInfCod());
									model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
									model.addAttribute("tipoInstitucion", "ejecutivo");
								} else {

									if (datosInstitucion.getInstFunCod().getFunCod().equals(11)
											|| datosInstitucion.getInstFunCod().getFunCod().equals(8)
											|| datosInstitucion.getInstFunCod().getFunCod().equals(13)
											|| datosInstitucion.getInstTipDes().trim().equals("EMPRESAS PÚBLICAS")) {

										model.addAttribute("gad", "institucionesVinculadas");
										model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
										model.addAttribute("funcionObjetivo", "vacio");
										model.addAttribute("numeroInforme", verificarInforme.getInfCod());
										model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
										model.addAttribute("listaCompetenciasExclusivas", listaCompetenciasExclusivas);
										model.addAttribute("tipoInstitucion", "vinculada");
									} else {
										model.addAttribute("gad", "gad");
										model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
										model.addAttribute("funcionObjetivo", "vacio");
										model.addAttribute("numeroInforme", verificarInforme.getInfCod());
										model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
										model.addAttribute("listaCompetenciasExclusivas", listaCompetenciasExclusivas);
									}

								}
							} else {

								if (datosInstitucion.getInstTipDes().trim().equals("GAD")
										|| datosInstitucion.getInstTipDes().trim().equals("EMPRESAS PÚBLICAS")) {
									model.addAttribute("gad", "gad");
									model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
									model.addAttribute("funcionObjetivo", "vacio");
									model.addAttribute("numeroInforme", verificarInforme.getInfCod());
									model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
									model.addAttribute("listaCompetenciasExclusivas", listaCompetenciasExclusivas);

								} else {

									if (datosInstitucion.getInstTipDes().trim().equals("INSTITUCIONES VINCULADAS")
											|| datosInstitucion.getInstTipDes().trim()
													.equals("MANCOMUNIDADES Y CONSORCIOS/ COMPETENCIAS A GAD")
											|| datosInstitucion.getInstTipDes().trim()
													.equals("MANCOMUNIDADES Y CONSORCIOS/ COMPETENCIAS DE GAD")) {
										if (datosInstitucion.getInstFunCod().getFunCod().equals(5)) {
											model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
											model.addAttribute("funcionObjetivo", "vacio");
											model.addAttribute("numeroInforme", verificarInforme.getInfCod());
											model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
											model.addAttribute("tipoInstitucion", "ejecutivo");
										} else {
											model.addAttribute("gad", "institucionesVinculadas");
											model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
											model.addAttribute("funcionObjetivo", "vacio");
											model.addAttribute("numeroInforme", verificarInforme.getInfCod());
											model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
											model.addAttribute("listaCompetenciasExclusivas",
													listaCompetenciasExclusivas);
											model.addAttribute("tipoInstitucion", "vinculada");

										}

									}
								}
							}
						} else {

							///// listo
							if (datosInstitucion.getInstTipDes().trim().equals("GAD")) {
								if (datosInstitucion.getInstFunCod().getFunCod().equals(8)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(9)
										|| datosInstitucion.getInstFunCod().getFunCod().equals(10)) {
									model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
									model.addAttribute("funcionObjetivo", "activo");
									model.addAttribute("numeroInforme", verificarInforme.getInfCod());
									model.addAttribute("nombreInstitución", datosInstitucion.getInstNom());
									model.addAttribute("identificadorInstitucion", datosInstitucion.getInstRuc());
									model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
									for (TblResponables datos : correos) {
										if (datos.getResponTipo().equals(Constantes.REPRESENTANTE_LEGAL)) {
											model.addAttribute("representanteLegal", datos.getResponNombre());
										}
									}
									model.addAttribute("funcion", datosInstitucion.getInstFunCod().getFunDes());
									model.addAttribute("tipo", datosInstitucion.getInstTipDes());
									model.addAttribute("pertenece", datosInstitucion.getInstDesUdaf());
									model.addAttribute("tipoInstitucion", "gad");
									List<Object[]> listaCompetenciasExclusivasActualizar = is
											.BuscarFuncionesObjetivosInstCodTipo(
													datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
													Constantes.ESTADO, "COMPETENCIAS EXCLUSIVAS");
									model.addAttribute("listaCompetenciasExclusivasActualizar",
											listaCompetenciasExclusivasActualizar);
									// List<Object[]> listaCompetenciasConcurrentesActualizar =
									// is.BuscarFuncionesObjetivosInstCodTipoConcurrentes(datosUsuario.getCodigoIntitucionAutorida(),perdiodoRC,
									// Constantes.ESTADO, "CCOMPETENCIAS / FUNCIONES");
									List<Object[]> listaCompetenciasConcurrentesActualizar = is
											.BuscarFuncionesObjetivosInstCodTipo(
													datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
													Constantes.ESTADO, "COMPETENCIAS / FUNCIONES");
									model.addAttribute("listaCompetenciasConcurrentesActualizar",
											listaCompetenciasConcurrentesActualizar);
								} else {
									model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
									model.addAttribute("funcionObjetivo", "activo");
									model.addAttribute("numeroInforme", verificarInforme.getInfCod());
									model.addAttribute("nombreInstitución", datosInstitucion.getInstNom());
									model.addAttribute("identificadorInstitucion", datosInstitucion.getInstRuc());
									model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
									for (TblResponables datos : correos) {
										if (datos.getResponTipo().equals(Constantes.REPRESENTANTE_LEGAL)) {
											model.addAttribute("representanteLegal", datos.getResponNombre());
										}
									}
									model.addAttribute("funcion", datosInstitucion.getInstFunCod().getFunDes());
									model.addAttribute("tipo", datosInstitucion.getInstTipDes());
									model.addAttribute("pertenece", datosInstitucion.getInstDesUdaf());
									model.addAttribute("tipoInstitucion", "ejecutivo");
									List<Object[]> listaCompetenciasConcurrentesActualizar = is
											.BuscarFuncionesObjetivosInstCodSinTipo(
													datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
													Constantes.ESTADO);
									model.addAttribute("listaCompetenciasConcurrentesActualizar",
											listaCompetenciasConcurrentesActualizar);
								}
							} else {

								if (datosInstitucion.getInstTipDes().trim().equals("INSTITUCIONES VINCULADAS")
										|| datosInstitucion.getInstTipDes().trim()
												.equals("MANCOMUNIDADES Y CONSORCIOS/ COMPETENCIAS A GAD")
										|| datosInstitucion.getInstTipDes().trim().equals("VINCULADAS AL GAD")
										|| datosInstitucion.getInstTipDes().trim()
												.equals("MANCOMUNIDADES Y CONSORCIOS/ COMPETENCIAS DE GAD")
										|| datosInstitucion.getInstTipDes().trim().equals("EMPRESAS PÚBLICAS")) {

									if (datosInstitucion.getInstFunCod().getFunCod().equals(8)
											|| datosInstitucion.getInstFunCod().getFunCod().equals(9)
											|| datosInstitucion.getInstFunCod().getFunCod().equals(10)
											|| datosInstitucion.getInstFunCod().getFunCod().equals(11)
											|| datosInstitucion.getInstFunCod().getFunCod().equals(13)) {
										model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
										model.addAttribute("funcionObjetivo", "activo");
										model.addAttribute("numeroInforme", verificarInforme.getInfCod());
										model.addAttribute("nombreInstitución", datosInstitucion.getInstNom());
										model.addAttribute("identificadorInstitucion", datosInstitucion.getInstRuc());
										model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
										for (TblResponables datos : correos) {
											if (datos.getResponTipo().equals(Constantes.REPRESENTANTE_LEGAL)) {
												model.addAttribute("representanteLegal", datos.getResponNombre());
											}
										}
										model.addAttribute("funcion", datosInstitucion.getInstFunCod().getFunDes());
										model.addAttribute("tipo", datosInstitucion.getInstTipDes());
										model.addAttribute("pertenece", datosInstitucion.getInstDesUdaf());
										model.addAttribute("tipoInstitucion", "vinculada");
										List<Object[]> listaCompetenciasExclusivasActualizar = is
												.BuscarFuncionesObjetivosInstCodTipo(
														datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
														Constantes.ESTADO, "COMPETENCIAS EXCLUSIVAS");
										model.addAttribute("listaCompetenciasExclusivasActualizar",
												listaCompetenciasExclusivasActualizar);
										List<Object[]> listaCompetenciasConcurrentesActualizar = is
												.BuscarFuncionesObjetivosInstCodTipo(
														datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
														Constantes.ESTADO, "COMPETENCIAS CONCURRENTES");
										// listaCompetenciasConcurrentesActualizar.addAll(is.BuscarFuncionesObjetivosInstCodTipoConcurrentes(datosUsuario.getCodigoIntitucionAutorida(),perdiodoRC,
										// Constantes.ESTADO, "COMPETENCIAS / FUNCIONES"));
										listaCompetenciasConcurrentesActualizar
												.addAll(is.BuscarFuncionesObjetivosInstCodTipo(
														datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
														Constantes.ESTADO, "COMPETENCIAS / FUNCIONES"));
										model.addAttribute("listaCompetenciasConcurrentesActualizar",
												listaCompetenciasConcurrentesActualizar);
									} else {
										model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
										model.addAttribute("funcionObjetivo", "activo");
										model.addAttribute("numeroInforme", verificarInforme.getInfCod());
										model.addAttribute("nombreInstitución", datosInstitucion.getInstNom());
										model.addAttribute("identificadorInstitucion", datosInstitucion.getInstRuc());
										model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
										for (TblResponables datos : correos) {
											if (datos.getResponTipo().equals(Constantes.REPRESENTANTE_LEGAL)) {
												model.addAttribute("representanteLegal", datos.getResponNombre());
											}
										}
										model.addAttribute("funcion", datosInstitucion.getInstFunCod().getFunDes());
										model.addAttribute("tipo", datosInstitucion.getInstTipDes());
										model.addAttribute("pertenece", datosInstitucion.getInstDesUdaf());
										model.addAttribute("tipoInstitucion", "ejecutivo");
										List<Object[]> listaCompetenciasConcurrentesActualizar = is
												.BuscarFuncionesObjetivosInstCodSinTipo(
														datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
														Constantes.ESTADO);
										model.addAttribute("listaCompetenciasConcurrentesActualizar",
												listaCompetenciasConcurrentesActualizar);

									}
								} else {
									if (!datosInstitucion.getInstFunCod().getFunCod().equals(8)
											|| !datosInstitucion.getInstFunCod().getFunCod().equals(9)
											|| !datosInstitucion.getInstFunCod().getFunCod().equals(10)
											|| !datosInstitucion.getInstFunCod().getFunCod().equals(11)
											|| !datosInstitucion.getInstFunCod().getFunCod().equals(13)) {
										model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
										model.addAttribute("funcionObjetivo", "activo");
										model.addAttribute("numeroInforme", verificarInforme.getInfCod());
										model.addAttribute("nombreInstitución", datosInstitucion.getInstNom());
										model.addAttribute("identificadorInstitucion", datosInstitucion.getInstRuc());
										model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
										for (TblResponables datos : correos) {
											if (datos.getResponTipo().equals(Constantes.REPRESENTANTE_LEGAL)) {
												model.addAttribute("representanteLegal", datos.getResponNombre());
											}
										}
										model.addAttribute("funcion", datosInstitucion.getInstFunCod().getFunDes());
										model.addAttribute("tipo", datosInstitucion.getInstTipDes());
										model.addAttribute("pertenece", datosInstitucion.getInstDesUdaf());
										model.addAttribute("tipoInstitucion", "ejecutivo");
										List<Object[]> listaCompetenciasConcurrentesActualizar = is
												.BuscarFuncionesObjetivosInstCodSinTipo(
														datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
														Constantes.ESTADO);
										model.addAttribute("listaCompetenciasConcurrentesActualizar",
												listaCompetenciasConcurrentesActualizar);
									} else {

										model.addAttribute("estadoInforme", verificarInforme.getInfEstado());
										model.addAttribute("funcionObjetivo", "activo");
										model.addAttribute("numeroInforme", verificarInforme.getInfCod());
										model.addAttribute("nombreInstitución", datosInstitucion.getInstNom());
										model.addAttribute("identificadorInstitucion", datosInstitucion.getInstRuc());
										model.addAttribute("periodo", datosInstitucion.getInstPeriodo());
										for (TblResponables datos : correos) {
											if (datos.getResponTipo().equals(Constantes.REPRESENTANTE_LEGAL)) {
												model.addAttribute("representanteLegal", datos.getResponNombre());
											}
										}
										model.addAttribute("funcion", datosInstitucion.getInstFunCod().getFunDes());
										model.addAttribute("tipo", datosInstitucion.getInstTipDes());
										model.addAttribute("pertenece", datosInstitucion.getInstDesUdaf());
										model.addAttribute("tipoInstitucion", "ejecutivo");
										List<Object[]> listaCompetenciasConcurrentesActualizar = is
												.BuscarFuncionesObjetivosInstCodSinTipo(
														datosUsuario.getCodigoIntitucionAutorida(), perdiodoRC,
														Constantes.ESTADO);
										model.addAttribute("listaCompetenciasConcurrentesActualizar",
												listaCompetenciasConcurrentesActualizar);

									}

								}

							}

						}

						// model.addAttribute("listadoFuncionesObjetivos", listaFuncionesObjetivos);
					}

				}

			}

		}

		return "rendicion/registroPeriodoInstitucion";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/rendicion/eliminarFuncioneObjetivo", method = RequestMethod.POST)
	public @ResponseBody String eliminarFuncioneObjetivo(Model model, @RequestParam("codigo") int codigo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			String perdiodoRC = Constantes.periodo().toString();
			TblFuncionesObjetivos funcionObjetivo = is.obtenerRegistroFuncionObjetivo(codigo, perdiodoRC);
			funcionObjetivo.setFoestado(Constantes.ESTADO_INACTIVO);
			is.guardarFuncionesObjetivos(funcionObjetivo);

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@GetMapping("/view/rendicion/guardarRegistroPeriodo")
	public String accesoNoAutorizadoguardarRegistroPeriodo(TblAutoridad tblAutoridad) {
		return "redirect:../../index";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/rendicion/guardarRegistroPeriodo")
	public @ResponseBody String guardarRegistroPeriodo(HttpServletRequest request, TblAutoridad tblAutoridad,
			@RequestParam("identificador") int id,
			@RequestParam(value = "fechaInicioGestion") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaInicioGestion,
			@RequestParam(value = "fechaFinGestion") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaFinGestion,
			@RequestParam(value = "fechaRendicion") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaRendicion,
			@RequestParam("lugar") String lugar, @RequestParam("numeroAsistentes") int numeroAsistentes

	) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			TblInformeAutoridad tblInformeAutoridad = new TblInformeAutoridad();
			// TblInformeAutoridad verificarInforme =
			// is.obtenerRegistroInforme(id,Constantes.periodo());
			TblInformeAutoridad verificarInforme = is.obtenerRegistroInformexIdentificador(id, Constantes.periodo());

			if (verificarInforme == null && id != 0) {
				tblInformeAutoridad.setIdentificador(id);
				tblInformeAutoridad.setInfAutPeriodo(Constantes.periodo());
				tblInformeAutoridad.setInfAutEstado(Constantes.ESTADO);
				tblInformeAutoridad.setInfAutDesde(fechaFinGestion);
				tblInformeAutoridad.setInfAutHasta(fechaFinGestion);
				tblInformeAutoridad.setInfAutFechain(new Date());
				tblInformeAutoridad.setFechaRendicion(fechaRendicion);
				tblInformeAutoridad.setLugar(lugar.toUpperCase());
				if (numeroAsistentes > 0) {// controlamos que solo se guarde si ingresa mas de cero assitentes
					tblInformeAutoridad.setNumeroAsistentes(numeroAsistentes);
					// System.out.println("SI ingreso asistentes");
				}
				tblInformeAutoridad.setInfAutTributo("VACIO");
				tblInformeAutoridad.setInaProcesoRc("VACIO");
				tblInformeAutoridad.setInaAportesCiu("VACIO");
				tblInformeAutoridad.setInfContadorApertura(0);
				is.guardarInformeAutoridad(tblInformeAutoridad);
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

	@GetMapping("/view/rendicion/guardarRegistroPeriodoInstitucion")
	public String accesoNoAutorizadoguardarRegistroPeriodoInstitucion(TblAutoridad tblAutoridad) {
		return "redirect:../../index";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/rendicion/guardarRegistroPeriodoInstitucion")
	public @ResponseBody String guardarRegistroPeriodoInstitucion(HttpServletRequest request, TblAutoridad tblAutoridad,
			@RequestParam("identificador") int id,
			@RequestParam(value = "fechaInicioGestion") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaInicioGestion,
			@RequestParam(value = "fechaFinGestion") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaFinGestion

	) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			TblInforme tblInforme = new TblInforme();
			TblInforme verificarInformeInstitucion = is.obtenerRegistroInformeInstitucion(id, Constantes.periodo());

			if (verificarInformeInstitucion == null && id != 0) {
				tblInforme.setInstCod(id);
				tblInforme.setInfPeriodo(Constantes.periodo());
				tblInforme.setInfDesde(fechaInicioGestion);
				tblInforme.setInfHasta(fechaFinGestion);
				tblInforme.setInfFechaini(new Date());
				tblInforme.setInfEstado(Constantes.ESTADO);
				tblInforme.setInfContadorApertura(0);
				is.guardarInforme(tblInforme);
				TblInstitucion ListaInstiticuiones = gcs.ObtenerInstitucionesXidEstado(id, Constantes.ESTADO,
						Constantes.periodo());

				if ((ListaInstiticuiones.getInstTipDes().equals("GAD")
				/* || ListaInstiticuiones.getInstTipDes().equals("EMPRESAS PÚBLICAS") */)
						&& (ListaInstiticuiones.getInstTfCod().getTfCod()
								.equals(1) /* ||ListaInstiticuiones.getInstTfCod().getTfCod().equals(2) */)) {

					if (ListaInstiticuiones.getInstFunCod().getFunCod().toString().equals("8")) {
						for (int i = 0; i < Constantes.ListaCompetenciasExclusivasGadMunicipal().length; i++) {

							TblFuncionesObjetivos tblFuncionesObjetivos = new TblFuncionesObjetivos();
							tblFuncionesObjetivos.setInstCod(id);
							tblFuncionesObjetivos.setFoNom(Constantes.ListaCompetenciasExclusivasGadMunicipal()[i]);
							tblFuncionesObjetivos.setFoTip("COMPETENCIAS EXCLUSIVAS");
							tblFuncionesObjetivos.setFoPeriodo(Constantes.periodo().toString());
							tblFuncionesObjetivos.setFoestado(Constantes.ESTADO_INACTIVO);
							is.guardarFuncionesObjetivos(tblFuncionesObjetivos);
						}

					} else {

						if (ListaInstiticuiones.getInstFunCod().getFunCod().toString().equals("9")) {
							for (int i = 0; i < Constantes.ListaCompetenciasExclusivasGadProvincial().length; i++) {

								TblFuncionesObjetivos tblFuncionesObjetivos = new TblFuncionesObjetivos();
								tblFuncionesObjetivos.setInstCod(id);
								tblFuncionesObjetivos
										.setFoNom(Constantes.ListaCompetenciasExclusivasGadProvincial()[i]);
								tblFuncionesObjetivos.setFoTip("COMPETENCIAS EXCLUSIVAS");
								tblFuncionesObjetivos.setFoPeriodo(Constantes.periodo().toString());
								tblFuncionesObjetivos.setFoestado(Constantes.ESTADO_INACTIVO);
								is.guardarFuncionesObjetivos(tblFuncionesObjetivos);
							}
						} else {

							if (ListaInstiticuiones.getInstFunCod().getFunCod().toString().equals("10")) {
								for (int i = 0; i < Constantes.ListaCompetenciasExclusivasGadParroquial().length; i++) {

									TblFuncionesObjetivos tblFuncionesObjetivos = new TblFuncionesObjetivos();
									tblFuncionesObjetivos.setInstCod(id);
									tblFuncionesObjetivos
											.setFoNom(Constantes.ListaCompetenciasExclusivasGadParroquial()[i]);
									tblFuncionesObjetivos.setFoTip("COMPETENCIAS EXCLUSIVAS");
									tblFuncionesObjetivos.setFoPeriodo(Constantes.periodo().toString());
									tblFuncionesObjetivos.setFoestado(Constantes.ESTADO_INACTIVO);
									is.guardarFuncionesObjetivos(tblFuncionesObjetivos);
								}
							}
						}
					}
				}

				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			} else {
				mensaje.put("mensaje",
						"Usted ya cuenta con un informe " + verificarInformeInstitucion.getInfEstado() + "! ");
			}
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@GetMapping("/view/rendicion/guardarObjetivosFunciones")
	public String accesoNoAutorizadoguardarObjetivosFunciones(TblAutoridad tblAutoridad) {
		return "redirect:../../index";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/rendicion/guardarObjetivosFunciones")
	public @ResponseBody String guardarFuncionesObjetivos(HttpServletRequest request,
			@RequestParam("identificador") int id,
			@RequestParam(value = "aFuncionObjetivo[]", required = false) String aFuncionObjetivo,
			@RequestParam(value = "bFuncionObjetivo[]", required = false) String[] nFuncionObjetivo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			String perdiodoRC = Constantes.periodo().toString();

			// List<TblFuncionesObjetivos> verificarFuncionesObjetivos =
			// is.obtenerRegistroInformeInstitucionFuncionesObjetivos(id);
			List<Object[]> listaFuncionesObjetivos = is.BuscarFuncionesObjetivosInstCod(id, perdiodoRC,
					Constantes.ESTADO);
			if (listaFuncionesObjetivos.size() == 0 && id != 0) {
				for (int i = 0; i < nFuncionObjetivo.length; i++) {

					TblFuncionesObjetivos tblFuncionesObjetivos = new TblFuncionesObjetivos();
					tblFuncionesObjetivos.setInstCod(id);
					tblFuncionesObjetivos.setFoNom(aFuncionObjetivo);
					tblFuncionesObjetivos.setFoTip(nFuncionObjetivo[i]);
					tblFuncionesObjetivos.setFoPeriodo(Constantes.periodo().toString());
					tblFuncionesObjetivos.setFoestado(Constantes.ESTADO);
					is.guardarFuncionesObjetivos(tblFuncionesObjetivos);
				}

				TblInstitucion ListaInstiticuiones = gcs.ObtenerInstitucionesXidEstado(id, Constantes.ESTADO,
						Constantes.periodo());
				int codigo = 0;

				if ((ListaInstiticuiones.getInstTipDes().equals("GAD")
						|| ListaInstiticuiones.getInstTipDes().equals("EMPRESAS PÚBLICAS"))
						&& (ListaInstiticuiones.getInstTfCod().getTfCod().equals(1)
								|| ListaInstiticuiones.getInstTfCod().getTfCod().equals(2))) {

					listaFuncionesObjetivos = is.BuscarFuncionesObjetivosInstCod(id, perdiodoRC,
							Constantes.ESTADO_INACTIVO);

					for (int i = 0; i < listaFuncionesObjetivos.size(); i++) {

						codigo = (int) listaFuncionesObjetivos.get(i)[0];

						TblFuncionesObjetivos tblFuncionesObjetivos = is.obtenerRegistroFuncionObjetivo(codigo,
								perdiodoRC);

						tblFuncionesObjetivos.setFoestado(Constantes.ESTADO);
						is.guardarFuncionesObjetivos(tblFuncionesObjetivos);

					}

				}
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			} else {
				mensaje.put("mensaje", "Su institución ya cuenta con Funciones / Objetivos! ");
			}
		} catch (Exception e) {
			mensaje.put("mensaje", "Agregue una función u objetivo " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@GetMapping("/view/rendicion/guardarObjetivosFuncionesCE")
	public String accesoNoAutorizadoguardarObjetivosFuncionesCE(TblAutoridad tblAutoridad) {
		return "redirect:../../index";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/rendicion/guardarObjetivosFuncionesCE")
	public @ResponseBody String guardarObjetivosFuncionesCE(HttpServletRequest request,
			@RequestParam("identificador") int id,
			@RequestParam(value = "aFuncionObjetivo[]", required = false) String aFuncionObjetivo,
			@RequestParam(value = "bFuncionObjetivo[]", required = false) String[] nFuncionObjetivo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			String perdiodoRC = Constantes.periodo().toString();

			// List<TblFuncionesObjetivos> verificarFuncionesObjetivos =
			// is.obtenerRegistroInformeInstitucionFuncionesObjetivos(id);
			List<Object[]> listaFuncionesObjetivos = is.BuscarFuncionesObjetivosInstCod(id, perdiodoRC,
					Constantes.ESTADO);
			if (listaFuncionesObjetivos.size() == 0 && id != 0) {

				if (aFuncionObjetivo == null) {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "No guardo ninguna compentencia concurrente!");

				} else {
					for (int i = 0; i < nFuncionObjetivo.length; i++) {

						TblFuncionesObjetivos tblFuncionesObjetivos = new TblFuncionesObjetivos();
						tblFuncionesObjetivos.setInstCod(id);
						tblFuncionesObjetivos.setFoNom(aFuncionObjetivo);
						tblFuncionesObjetivos.setFoTip(nFuncionObjetivo[i]);
						tblFuncionesObjetivos.setFoPeriodo(Constantes.periodo().toString());
						tblFuncionesObjetivos.setFoestado(Constantes.ESTADO);
						is.guardarFuncionesObjetivos(tblFuncionesObjetivos);
					}
				}

				TblInstitucion ListaInstiticuiones = gcs.ObtenerInstitucionesXidEstado(id, Constantes.ESTADO,
						Constantes.periodo());
				int codigo = 0;

				if ((ListaInstiticuiones.getInstTipDes().equals("GAD")
						|| ListaInstiticuiones.getInstTipDes().equals("EMPRESAS PÚBLICAS"))
						&& (ListaInstiticuiones.getInstTfCod().getTfCod().equals(1)
								|| ListaInstiticuiones.getInstTfCod().getTfCod().equals(2))) {

					listaFuncionesObjetivos = is.BuscarFuncionesObjetivosInstCod(id, perdiodoRC,
							Constantes.ESTADO_INACTIVO);

					for (int i = 0; i < listaFuncionesObjetivos.size(); i++) {

						codigo = (int) listaFuncionesObjetivos.get(i)[0];

						TblFuncionesObjetivos tblFuncionesObjetivos = is.obtenerRegistroFuncionObjetivo(codigo,
								perdiodoRC);

						tblFuncionesObjetivos.setFoestado(Constantes.ESTADO);
						is.guardarFuncionesObjetivos(tblFuncionesObjetivos);

					}

				}
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			} else {
				mensaje.put("mensaje", "Su institución ya cuenta con Funciones / Objetivos! ");
			}
		} catch (Exception e) {
			mensaje.put("mensaje", "Agregue una función u objetivo " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@GetMapping("/view/rendicion/guardarCompetenciasVinculadas")
	public String accesoNoAutorizadoguardarCompetenciasVinculadas(TblAutoridad tblAutoridad) {
		return "redirect:../../index";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/rendicion/guardarCompetenciasVinculadas")
	public @ResponseBody String guardarCompetenciasVinculadas(HttpServletRequest request,
			@RequestParam("identificador") int id,
			@RequestParam(value = "aCompentenciaVinculada[]", required = false) String aFuncionObjetivo,
			@RequestParam(value = "bCompentenciaVinculada[]", required = false) String[] nFuncionObjetivo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			String perdiodoRC = Constantes.periodo().toString();

			// List<TblFuncionesObjetivos> verificarFuncionesObjetivos =
			// is.obtenerRegistroInformeInstitucionFuncionesObjetivos(id);
			List<Object[]> listaFuncionesObjetivos = is.BuscarFuncionesObjetivosInstCod(id, perdiodoRC,
					Constantes.ESTADO);
			if (listaFuncionesObjetivos.size() == 0 && id != 0) {
				for (int i = 0; i < nFuncionObjetivo.length; i++) {

					TblFuncionesObjetivos tblFuncionesObjetivos = new TblFuncionesObjetivos();
					tblFuncionesObjetivos.setInstCod(id);
					tblFuncionesObjetivos.setFoNom(aFuncionObjetivo);
					tblFuncionesObjetivos.setFoTip(nFuncionObjetivo[i]);
					tblFuncionesObjetivos.setFoPeriodo(Constantes.periodo().toString());
					tblFuncionesObjetivos.setFoestado(Constantes.ESTADO);
					is.guardarFuncionesObjetivos(tblFuncionesObjetivos);
				}

				TblInstitucion ListaInstiticuiones = gcs.ObtenerInstitucionesXidEstado(id, Constantes.ESTADO,
						Constantes.periodo());
				int codigo = 0;

				if (ListaInstiticuiones.getInstTipDes().equals("GAD")
						&& ListaInstiticuiones.getInstTfCod().getTfCod().equals(1)) {

					listaFuncionesObjetivos = is.BuscarFuncionesObjetivosInstCod(id, perdiodoRC,
							Constantes.ESTADO_INACTIVO);

					for (int i = 0; i < listaFuncionesObjetivos.size(); i++) {

						codigo = (int) listaFuncionesObjetivos.get(i)[0];

						TblFuncionesObjetivos tblFuncionesObjetivos = is.obtenerRegistroFuncionObjetivo(codigo,
								perdiodoRC);

						tblFuncionesObjetivos.setFoestado(Constantes.ESTADO);
						is.guardarFuncionesObjetivos(tblFuncionesObjetivos);

					}

				}
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			} else {
				mensaje.put("mensaje", "Su institución ya cuenta con Funciones / Objetivos! ");
			}
		} catch (Exception e) {
			mensaje.put("mensaje", "Error no se agrego ninguna compentencia " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@GetMapping("/view/rendicion/guardarObjetivosFuncionesEjecutivo")
	public String accesoNoAutorizadoguardarObjetivosFuncionesEjecutivo(TblAutoridad tblAutoridad) {
		return "redirect:../../index";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/rendicion/guardarObjetivosFuncionesEjecutivo")
	public @ResponseBody String guardarObjetivosFuncionesEjecutivo(HttpServletRequest request,
			@RequestParam("identificador") int id,
			@RequestParam(value = "aFuncionObjetivoEjecutivo[]", required = false) String aFuncionObjetivo,
			@RequestParam(value = "bFuncionObjetivoEjecutivo[]", required = false) String[] nFuncionObjetivo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {

			String perdiodoRC = Constantes.periodo().toString();

			// List<TblFuncionesObjetivos> verificarFuncionesObjetivos =
			// is.obtenerRegistroInformeInstitucionFuncionesObjetivos(id);
			List<Object[]> listaFuncionesObjetivos = is.BuscarFuncionesObjetivosInstCod(id, perdiodoRC,
					Constantes.ESTADO);
			if (listaFuncionesObjetivos.size() == 0 && id != 0) {
				for (int i = 0; i < nFuncionObjetivo.length; i++) {

					TblFuncionesObjetivos tblFuncionesObjetivos = new TblFuncionesObjetivos();
					tblFuncionesObjetivos.setInstCod(id);
					tblFuncionesObjetivos.setFoNom(aFuncionObjetivo);
					tblFuncionesObjetivos.setFoTip(nFuncionObjetivo[i]);
					tblFuncionesObjetivos.setFoPeriodo(Constantes.periodo().toString());
					tblFuncionesObjetivos.setFoestado(Constantes.ESTADO);
					is.guardarFuncionesObjetivos(tblFuncionesObjetivos);
				}

				TblInstitucion ListaInstiticuiones = gcs.ObtenerInstitucionesXidEstado(id, Constantes.ESTADO,
						Constantes.periodo());
				int codigo = 0;

				if (ListaInstiticuiones.getInstTipDes().equals("GAD")
						&& ListaInstiticuiones.getInstTfCod().getTfCod().equals(1)) {

					listaFuncionesObjetivos = is.BuscarFuncionesObjetivosInstCod(id, perdiodoRC,
							Constantes.ESTADO_INACTIVO);

					for (int i = 0; i < listaFuncionesObjetivos.size(); i++) {

						codigo = (int) listaFuncionesObjetivos.get(i)[0];

						TblFuncionesObjetivos tblFuncionesObjetivos = is.obtenerRegistroFuncionObjetivo(codigo,
								perdiodoRC);

						tblFuncionesObjetivos.setFoestado(Constantes.ESTADO);
						is.guardarFuncionesObjetivos(tblFuncionesObjetivos);

					}

				}
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			} else {
				mensaje.put("mensaje", "Su institución ya cuenta con Funciones / Objetivos! ");
			}
		} catch (Exception e) {
			mensaje.put("mensaje", "Agregue una función u objetivo " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@GetMapping("/view/rendicion/guardarObjetivosFuncionesActualizar")
	public String accesoNoAutorizadoguardarObjetivosFuncionesActualizar(TblAutoridad tblAutoridad) {
		return "redirect:../../index";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/rendicion/guardarObjetivosFuncionesActualizar")
	public @ResponseBody String guardarFuncionesObjetivosActualizar(HttpServletRequest request,
			@RequestParam("identificador") int id,
			@RequestParam(value = "aFuncionObjetivoActualizar[]", required = false) String aFuncionObjetivo,
			@RequestParam(value = "bFuncionObjetivoActualizar[]", required = false) String[] nFuncionObjetivo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			for (int i = 0; i < nFuncionObjetivo.length; i++) {

				TblFuncionesObjetivos tblFuncionesObjetivos = new TblFuncionesObjetivos();
				tblFuncionesObjetivos.setInstCod(id);
				tblFuncionesObjetivos.setFoNom(aFuncionObjetivo);
				tblFuncionesObjetivos.setFoTip(nFuncionObjetivo[i]);
				tblFuncionesObjetivos.setFoPeriodo(Constantes.periodo().toString());
				tblFuncionesObjetivos.setFoestado(Constantes.ESTADO);
				is.guardarFuncionesObjetivos(tblFuncionesObjetivos);
			}

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "Agregue por lo menos un registro ");
		} finally {
			return mensaje.toString();
		}
	}

	@GetMapping("/view/rendicion/guardarObjetivosFuncionesActualizarA")
	public String accesoNoAutorizadoguardarObjetivosFuncionesActualizarA(TblAutoridad tblAutoridad) {
		return "redirect:../../index";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/rendicion/guardarObjetivosFuncionesActualizarA")
	public @ResponseBody String guardarObjetivosFuncionesActualizarA(HttpServletRequest request,
			@RequestParam("identificador") int id,
			@RequestParam(value = "aCompentenciaVinculadaA[]", required = false) String aFuncionObjetivo,
			@RequestParam(value = "bCompentenciaVinculadaA[]", required = false) String[] nFuncionObjetivo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			for (int i = 0; i < nFuncionObjetivo.length; i++) {

				TblFuncionesObjetivos tblFuncionesObjetivos = new TblFuncionesObjetivos();
				tblFuncionesObjetivos.setInstCod(id);
				tblFuncionesObjetivos.setFoNom(aFuncionObjetivo);
				tblFuncionesObjetivos.setFoTip(nFuncionObjetivo[i]);
				tblFuncionesObjetivos.setFoPeriodo(Constantes.periodo().toString());
				tblFuncionesObjetivos.setFoestado(Constantes.ESTADO);
				is.guardarFuncionesObjetivos(tblFuncionesObjetivos);
			}

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "Agregue por lo menos un registro ");
		} finally {
			return mensaje.toString();
		}
	}

	@GetMapping("/view/rendicion/guardarObjetivosFuncionesActualizarEjecutivo")
	public String accesoNoAutorizadoguardarObjetivosFuncionesActualizarEjecutivo(TblAutoridad tblAutoridad) {
		return "redirect:../../index";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/rendicion/guardarObjetivosFuncionesActualizarEjecutivo")
	public @ResponseBody String guardarObjetivosFuncionesActualizarEjecutivo(HttpServletRequest request,
			@RequestParam("identificador") int id,
			@RequestParam(value = "aFuncionObjetivoActualizarE[]", required = false) String[] aFuncionObjetivo,
			@RequestParam(value = "bFuncionObjetivoActualizarE[]", required = false) String[] nFuncionObjetivo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		try {
			for (int i = 0; i < nFuncionObjetivo.length; i++) {

				TblFuncionesObjetivos tblFuncionesObjetivos = new TblFuncionesObjetivos();
				tblFuncionesObjetivos.setInstCod(id);
				tblFuncionesObjetivos.setFoNom(aFuncionObjetivo[i]);
				tblFuncionesObjetivos.setFoTip(nFuncionObjetivo[i]);
				tblFuncionesObjetivos.setFoPeriodo(Constantes.periodo().toString());
				tblFuncionesObjetivos.setFoestado(Constantes.ESTADO);
				is.guardarFuncionesObjetivos(tblFuncionesObjetivos);
			}

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "Agregue por lo menos un registro ");
		} finally {
			return mensaje.toString();
		}
	}

	@RequestMapping(value = "/view/rendicion/ActivarInstitucion", method = RequestMethod.POST)
	public String ActivarInstitucion(Model model, @RequestParam("id") Integer id) {
		String provincianombre;
		String cantonnombre;
		String parroquianombre;
		TblInstitucion listaRegistros = servicioinstitucion.ObtenerInstitucionesXIdcodigo(id);
		if (listaRegistros.getProvCod() != null) {
			TblLocalizacion provincias = gcs.obtenerNombreLocalizacion(1, listaRegistros.getProvCod(), "activo");
			provincianombre = provincias.getNombre();
		} else {
			provincianombre = " ";
		}
		if (listaRegistros.getCantCod() != null) {
			TblLocalizacion canton = gcs.obtenerNombreLocalizacion(2, listaRegistros.getCantCod(), "activo");
			cantonnombre = canton.getNombre();
		} else {
			cantonnombre = " ";
		}
		if (listaRegistros.getParroCod() != null) {
			TblLocalizacion parroquia = gcs.obtenerNombreLocalizacion(4, listaRegistros.getParroCod(), "activo");
			parroquianombre = parroquia.getNombre();
		} else {
			parroquianombre = " ";
		}
		model.addAttribute("id", id);
		model.addAttribute("ruc", listaRegistros.getInstRuc());
		model.addAttribute("institucion",
				listaRegistros.getInstNom().toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
						.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
						.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
						.replaceAll(Constantes.CADENA4, Constantes.REMPLAZO4));
		model.addAttribute("nombreProvincia", provincianombre);
		String tipo = Constantes.getTypeFile(listaRegistros.getInstRucDoc());
		model.addAttribute("instInfo", listaRegistros);
		model.addAttribute("tipo", tipo);
		model.addAttribute("archivoRespaldo", listaRegistros.getInstRucDoc());
		model.addAttribute("canton", cantonnombre);
		model.addAttribute("parroquia", parroquianombre);
		TblResponables responables = resp.buscarResponxCodintituciotipoPeriodo(listaRegistros.getInstCod(),
				Constantes.REPRESENTANTE_LEGAL, Integer.toString(listaRegistros.getInstPeriodo()));
		model.addAttribute("representante", responables.getResponNombre());
		return "rendicion/ActivarInstitucion";
	}

	@RequestMapping(value = "/view/rendicion/ActivarAutoridad", method = RequestMethod.POST)
	public String ActivarAutoridad(Model model, @RequestParam("id") Integer id) {
		String provincianombre;
		String cantonnombre;
		String parroquianombre;
		TblAutoridad listaRegistros = autori.buscarAutordadCodAut(id);
		if (listaRegistros.getProvincia() != null) {
			TblLocalizacion provincias = gcs.obtenerNombreLocalizacion(1, listaRegistros.getProvincia(), "activo");
			provincianombre = provincias.getNombre();
		} else {
			provincianombre = " ";
		}
		if (listaRegistros.getCanton() != null) {
			TblLocalizacion canton = gcs.obtenerNombreLocalizacion(2, listaRegistros.getCanton(), "activo");
			cantonnombre = canton.getNombre();
		} else {
			cantonnombre = " ";
		}
		if (listaRegistros.getParroquia() != null) {
			TblLocalizacion parroquia = gcs.obtenerNombreLocalizacion(4, listaRegistros.getParroquia(), "activo");
			parroquianombre = parroquia.getNombre();
		} else {
			parroquianombre = " ";
		}
		model.addAttribute("id", id);
		model.addAttribute("ruc", listaRegistros.getIdentificador());

		model.addAttribute("institucion",
				listaRegistros.getNombre().toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
						.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
						.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
						.replaceAll(Constantes.CADENA4, Constantes.REMPLAZO4));
		model.addAttribute("nombreProvincia", provincianombre);
		String tipo = Constantes.getTypeFile(listaRegistros.getRutaArchivoValidador());
		model.addAttribute("tipo", tipo);
		model.addAttribute("archivoRespaldo", listaRegistros.getRutaArchivoValidador());
		String tipo1 = Constantes.getTypeFile(listaRegistros.getDocumentoCedula());
		model.addAttribute("tipo1", tipo1);
		model.addAttribute("archivoRespaldoCedula", listaRegistros.getDocumentoCedula());
		model.addAttribute("dignidad", listaRegistros.getDignidad());
		model.addAttribute("tipoAutoridad", listaRegistros.getTipoAutoridad());
		model.addAttribute("canton", cantonnombre);
		model.addAttribute("parroquia", parroquianombre);

		List<TblAutoridad> otrasAutoridades = gcs.ObtenerAutoridadXidentificadorEstado(
				listaRegistros.getIdentificador(), Constantes.ESTADO, Constantes.periodo());

		if (otrasAutoridades.size() == 0) {

			model.addAttribute("otros", "no");
		} else {

			model.addAttribute("otros", "si");
		}

		return "rendicion/ActivarAutoridad";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/rendicion/guardarActivacion")
	public @ResponseBody String guardarActivacion(TblInstitucion tblinstitucion, @RequestParam("instCod") int instCod,
			@RequestParam("identificadorResponsable") String identificadorResponsable) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");

		try {
			// TblUsuario identificadortecnico =
			// us.buscarUsuarioXEmail(identificadorResponsable, Constantes.periodo());
			TblUsuario identificadorinstitucion = us.buscarUsuarioXCodigoInstitucion(instCod,
					Constantes.TIPO_REGISTRO_INSTITUCION, Constantes.periodo());
			List<TblResponables> correos = resp.buscarResponsableXcodigoInstitucion(instCod,
					Constantes.periodo().toString());
			TblInstitucion actualizarinstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(instCod);
			actualizarinstitucion.setInstEstado(Constantes.ESTADO);
			actualizarinstitucion.setInstFechaActivar(new Date());
			servicioinstitucion.guardarInstitucion(actualizarinstitucion);
			identificadorinstitucion.setEstado(Constantes.ESTADO_ACTIVO_USUARIOS);
			us.guardarUsuario(identificadorinstitucion);
			for (TblResponables datos : correos) {
				if (datos.getResponTipo().equals(Constantes.REPRESENTANTE_LEGAL)) {

				} else {
					ms.mailActivacionIntitucion(datos.getResponEmail(), datos.getResponNombre(),
							actualizarinstitucion.getInstNom(), actualizarinstitucion.getInstRuc(), "activada", "",
							true);
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
	@RequestMapping(value = "/view/rendicion/guardarActivacionAutoridad")
	public @ResponseBody String guardarActivacionAutoridad(TblAutoridad tblinstitucion,
			@RequestParam("instCod") int instCod,
			@RequestParam("identificadorResponsable") String identificadorResponsable) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");

		try {
			// TblUsuario identificadortecnico =
			// us.buscarUsuarioXEmail(identificadorResponsable, Constantes.periodo());
			TblUsuario identificadorinstitucion = us.buscarUsuarioXCodigoInstitucion(instCod,
					Constantes.TIPO_REGISTRO_AUTORIDAD, Constantes.periodo());
			TblAutoridad actualizarinstitucion = autori.buscarAutordadCodAut(instCod);
			actualizarinstitucion.setEstado(Constantes.ESTADO);
			actualizarinstitucion.setFechaActivar(new Date());
			autori.guardarAutoridad(actualizarinstitucion);
			identificadorinstitucion.setEstado(Constantes.ESTADO_ACTIVO_USUARIOS);
			us.guardarUsuario(identificadorinstitucion);
			ms.mailActivacionAutoridad(actualizarinstitucion.getEmail(), actualizarinstitucion.getNombre(),
					actualizarinstitucion.getIdentificador(), "activada", "", true);

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/view/rendicion/GuardarNegacion")
	public @ResponseBody String GuardarNegacion(TblInstitucion tblinstitucion, @RequestParam("codinst") int codinst,
			@RequestParam("descripcionAsunto") String descripcionAsunto, Authentication authentication) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");

		try {
			TblUsuario identificadortecnico = us.buscarUsuarioXEmail(authentication.getName(), Constantes.periodo());
			TblUsuario identificadorinstitucion = us.buscarUsuarioXCodigoInstitucion(codinst,
					Constantes.TIPO_REGISTRO_INSTITUCION, Constantes.periodo());
			List<TblResponables> correos = resp.buscarResponsableXcodigoInstitucion(codinst,
					Constantes.periodo().toString());
			TblInstitucion actualizarinstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(codinst);
			actualizarinstitucion.setInstEstado(Constantes.ESTADO_INACTIVO);
			actualizarinstitucion.setInstFechaActivar(null);
			actualizarinstitucion.setInstFechaRegistro(null);
			actualizarinstitucion.setCantCod(null);
			actualizarinstitucion.setParroCod(null);
			actualizarinstitucion.setInstDir(null);
			actualizarinstitucion.setInstEma(null);
			actualizarinstitucion.setInstRucDoc(null);
			actualizarinstitucion.setInstPag(null);
			actualizarinstitucion.setInstTel(null);
			servicioinstitucion.guardarInstitucion(actualizarinstitucion);
			Usu_registro.borraraplicacionusuario(identificadorinstitucion.getIdentificador(),
					identificadorinstitucion.getEmail());
			resp.borrarResponsableXcodyperiodo(codinst, Constantes.periodo().toString());
			Usu_registro.BorrarUsuarioroXco(identificadorinstitucion.getIdUser());
			Usu_registro.BorrarUsuario(identificadorinstitucion.getIdUser());
			TblObservacionesNegar observacionNegar = new TblObservacionesNegar();
			observacionNegar.setInstCod(actualizarinstitucion.getInstCod());
			observacionNegar.setObsComentario(descripcionAsunto);
			observacionNegar.setObsFecha(new Date());
			observacionNegar.setObsTipo("Negar Institución");
			observacionNegar.setTecnicoidentificador(identificadortecnico.getIdentificador());
			observacioInstitucion.guardarObservacioNegar(observacionNegar);
			for (TblResponables datos : correos) {
				if (datos.getResponTipo().equals("REPRESENTANTE LEGAL")) {

				} else {
					ms.mailActivacionIntitucion(datos.getResponEmail(), datos.getResponNombre(),
							actualizarinstitucion.getInstNom(), actualizarinstitucion.getInstRuc(), "negada",
							descripcionAsunto, true);
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
	@RequestMapping(value = "/view/rendicion/GuardarNegacionAutoridad")
	public @ResponseBody String GuardarNegacionAutoridad(TblAutoridad tblinstitucion,
			@RequestParam("codinst") int codinst, @RequestParam("descripcionAsunto") String descripcionAsunto,
			Authentication authentication) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");

		try {
			TblUsuario identificadortecnico = us.buscarUsuarioXEmail(authentication.getName(), Constantes.periodo());
			TblUsuario identificadorinstitucion = us.buscarUsuarioXCodigoInstitucion(codinst,
					Constantes.TIPO_REGISTRO_AUTORIDAD, Constantes.periodo());
			autori.BorrarAutoridadXid(identificadorinstitucion.getCodigoIntitucionAutorida());
			Usu_registro.borraraplicacionusuario(identificadorinstitucion.getIdentificador(),
					identificadorinstitucion.getEmail());
			Usu_registro.BorrarUsuarioroXco(identificadorinstitucion.getIdUser());
			Usu_registro.BorrarUsuario(identificadorinstitucion.getIdUser());
			TblNegarAutoridad observacionNegar = new TblNegarAutoridad();
			observacionNegar.setAutCed(identificadorinstitucion.getIdentificador());
			observacionNegar.setNegaObs(descripcionAsunto);
			observacionNegar.setNegaFec(new Date());
			observacionNegar.setIdentificadortecnico(identificadortecnico.getIdentificador());
			observacionNegar.setNegaTipo("Negar Autoridad");
			observacioInstitucion.guardarObservacioNegarAutoridad(observacionNegar);

			ms.mailActivacionAutoridad(identificadorinstitucion.getEmail(), identificadorinstitucion.getNombre(),
					identificadorinstitucion.getIdentificador(), "negada", descripcionAsunto, true);

			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}
}
