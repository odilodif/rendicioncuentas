package gob.cpccs.controller.ReporteVariableController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gob.cpccs.utilidades.Constantes;
import gob.cpccs.utilidades.reportes.JasperFiltroReporte;

@Controller
public class VariablesController {
	@RequestMapping("/view/tecnicoNacional/Frm_ReportePlanificacionParticipativa")
	public String Frm_ReportePlanificacionParticipativa(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReportePlanificacionParticipativa";
	}

	@RequestMapping("/view/tecnicoNacional/Frm_ReporteContratacionPublica")
	public String Frm_ReporteContratacionPublica(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteContratacionPublica";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReportePlanificacionParticipativa" }, method = RequestMethod.POST)
	public String ReportePlanificacionParticipativa(Model model, HttpServletRequest request,
			HttpServletResponse response, @RequestParam("periodo") int periodo) {

		JasperFiltroReporte jasper = new JasperFiltroReporte();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/PlanificacionParticipativa.jrxml");
		jasper.setRutaArchivoNuevo(Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "PlanificacionParticipativa_"
				+ historial + ".xlsx");
		jasper.setTituloArchivo("Planificacion Participativa");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReporteVariable(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_XLSX + "PlanificacionParticipativa_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	@RequestMapping("/view/tecnicoNacional/FrmParticipantesRendicion")
	public String FrmParticipantesRendicion(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/FrmParticipantesRendicion";
	}

	@RequestMapping("/view/tecnicoNacional/Fmr_ReportePresupuestoParticipativo")
	public String Fmr_ReportePresupuestoParticipativo(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Fmr_ReportePresupuestoParticipativo";
	}

	@RequestMapping("/view/tecnicoNacional/Frm_ReporteEjecucionPresupuestaria")
	public String Frm_ReporteEjecucionPresupuestaria(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteEjecucionPresupuestaria";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteEjecucionPresupuestaria" }, method = RequestMethod.POST)
	public String ReporteEjecucionPresupuestaria(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		JasperFiltroReporte jasper = new JasperFiltroReporte();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/EjecucionPresupuestaria.jrxml");
		jasper.setRutaArchivoNuevo(
				Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "EjecucionProgramatica_" + historial + ".xlsx");
		jasper.setTituloArchivo("Hoja1");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");
		jasper.generarReporteVariable(periodo);

		model.addAttribute("rutaPDF", Constantes.RUTA_ARCHIVOS_XLSX + "EjecucionProgramatica_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReportePresupuestoParticipativo" }, method = RequestMethod.POST)
	public String ReportePresupuestoParticipativo(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		JasperFiltroReporte jasper = new JasperFiltroReporte();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/PresupuestoParticipativo.jrxml");
		jasper.setRutaArchivoNuevo(
				Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "PresupuestoParticipativo_" + historial + ".xlsx");
		jasper.setTituloArchivo("Hoja1");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");
		jasper.generarReporteVariable(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_XLSX + "PresupuestoParticipativo_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteParticipantesRendicion" }, method = RequestMethod.POST)
	public String ReporteParticipantesRendicion(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		JasperFiltroReporte jasper = new JasperFiltroReporte();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/ParticipantesRendicionCuentas.jrxml");
		jasper.setRutaArchivoNuevo(
				Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "DatosRendicion_" + historial + ".xlsx");
		jasper.setTituloArchivo("Datos Rendicion");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReporteVariable(periodo);

		model.addAttribute("rutaPDF", Constantes.RUTA_ARCHIVOS_XLSX + "DatosRendicion_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteContratacionPublica" }, method = RequestMethod.POST)
	public String ReporteContratacionPublica(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		JasperFiltroReporte jasper = new JasperFiltroReporte();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/ContratacionPublica.jrxml");
		jasper.setRutaArchivoNuevo(
				Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "ContratacionPublica_" + historial + ".xlsx");
		jasper.setTituloArchivo("Contratacion Publica");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReporteVariable(periodo);

		model.addAttribute("rutaPDF", Constantes.RUTA_ARCHIVOS_XLSX + "ContratacionPublica_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/Reportemachote" }, method = RequestMethod.POST)
	public String Reportemachote(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		JasperFiltroReporte jasper = new JasperFiltroReporte();

		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/Machote.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "Machote.pdf");
		jasper.setTituloArchivo("Documento pdf Matricula");
		jasper.setTipoDocumentoExportar("PDF");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF", Constantes.RUTA_ARCHIVOS_XLSX + "Expediente.pdf");
		return "reportes/ReportVariable";
	}

	// Metodos para reporte de Politicas de igualdad //

	@RequestMapping("/view/tecnicoNacional/Frm_MecacismosParticipacion")
	public String Frm_MecacismosParticipacion(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_MecacismosParticipacion";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteMecanismosParticipacion" }, method = RequestMethod.POST)
	public String ReporteMecanismosParticipacion(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		JasperFiltroReporte jasper = new JasperFiltroReporte();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/MecanismosParticipacion.jrxml");
		jasper.setRutaArchivoNuevo(
				Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "MecanismosParticipacion_" + historial + ".xlsx");
		jasper.setTituloArchivo("Mecanismos Participacion");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReporteVariable(periodo);

		model.addAttribute("rutaPDF", Constantes.RUTA_ARCHIVOS_XLSX + "MecanismosParticipacion_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	@RequestMapping("/view/tecnicoNacional/Fmr_ReportePoliticasIgualdad")
	public String Fmr_ReportePoliticasIgualdad(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Fmr_ReportePoliticasIgualdad";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReportePoliticaIgualdad" }, method = RequestMethod.POST)
	public String ReportePoliticaIgualdad(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		JasperFiltroReporte jasper = new JasperFiltroReporte();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/PoliticasPublicasDeIgualdad.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "PoliticasPublicasDeIgualdad_"
				+ historial + ".xlsx");
		jasper.setTituloArchivo("Documento pdf Politica");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_XLSX + "PoliticasPublicasDeIgualdad_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}
	// fin Metodos para reporte de Politicas de igualdad //

	// Metodos para reporte de Mecanismo de control social //
	@RequestMapping("/view/tecnicoNacional/Fmr_ReporteMecanismosControlSocial")
	public String Fmr_ReporteMecanismosControlSocial(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Fmr_ReporteMecanismosControlSocial";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteMecanismo" }, method = RequestMethod.POST)
	public String ReporteMecanismo(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		JasperFiltroReporte jasper = new JasperFiltroReporte();
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/MecanismoControlSocial.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(
				Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "MecanismoControlSocial_" + historial + ".xlsx");
		jasper.setTituloArchivo("Documento pdf Mecanismos");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF", Constantes.RUTA_ARCHIVOS_XLSX + "MecanismoControlSocial_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// Fin Metodos para reporte de Mecanismo de control social //

	// Metodos para reporte de Sistema de Participacion Ciudadana Solo Gad //

	@RequestMapping("/view/tecnicoNacional/Frm_ReporteSistemaParticipacionCiudadana")
	public String Frm_ReporteSistemaParticipacionCiudadana(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteSistemaParticipacionCiudadana";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteParticipacion" }, method = RequestMethod.POST)
	public String ReporteParticipacion(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		JasperFiltroReporte jasper = new JasperFiltroReporte();
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/SistemasDeParticipacionCiudadana.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES
				+ "SistemasDeParticipacionCiudadana_" + historial + ".xlsx");
		jasper.setTituloArchivo("Documento pdf Participacion Ciudadana");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_XLSX + "SistemasDeParticipacionCiudadana_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}
	// Fin Metodos para reporte de Sistema de Participacion Ciudadana Solo Gad //

	// Metodos para reporte de Incorporacion de Recomendaciones//
	@RequestMapping("/view/tecnicoNacional/Frm_ReporteIncorporacionRecomendaciones")
	public String Frm_ReporteIncorporacionRecomendaciones(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteIncorporacionRecomendaciones";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteIncorporacion" }, method = RequestMethod.POST)
	public String ReporteIncorporacion(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		JasperFiltroReporte jasper = new JasperFiltroReporte();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/IncorporacionRecomendaciones.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "IncorporacionRecomendaciones_"
				+ historial + ".xlsx");
		jasper.setTituloArchivo("Documento pdf Incorporacion Recomendaciones");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_XLSX + "IncorporacionRecomendaciones_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// Fin Metodos para reporte de Incorporacion de Recomendaciones//

	// Metodos para reporte de Articulacion de Politics Publicas//

	@RequestMapping("/view/tecnicoNacional/Frm_ReporteArticulacionPoliticas")
	public String Frm_ReporteArticulacionPoliticas(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteArticulacionPoliticas";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteArticulacion" }, method = RequestMethod.POST)
	public String ReporteArticulacion(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		JasperFiltroReporte jasper = new JasperFiltroReporte();
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/ArticulacionPolitcas.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(
				Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "ArticulacionPolitcas_" + historial + ".xlsx");
		jasper.setTituloArchivo("Documento pdf Articulación Políticas");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF", Constantes.RUTA_ARCHIVOS_XLSX + "ArticulacionPolitcas_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	@RequestMapping("/view/tecnicoNacional/Frm_ReporteTrasparenciaInformacionMedios")
	public String Frm_ReporteTrasparenciaInformacionMedios(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteTrasparenciaInformacionMedios";
	}

	@RequestMapping(value = {
			"/view/tecnicoNacional/ReporteTrasparenciaInformacionMedios" }, method = RequestMethod.POST)
	public String ReporteTrasparenciaInformacionMedios(Model model, HttpServletRequest request,
			HttpServletResponse response, @RequestParam("periodo") int periodo) {

		JasperFiltroReporte jasper = new JasperFiltroReporte();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/TrasparenciaInformacion.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "TrasparenciaInformacionMedios_"
				+ historial + ".xlsx");
		jasper.setTituloArchivo("Documento pdf Mecanismos");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_XLSX + "TrasparenciaInformacionMedios_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// Fin Metodos para reporte de Articulacion de Politics Publicas//

	// Metodos para reporte de Incorporacion de Recomendaciones Años anteriores//
	@RequestMapping("/view/tecnicoNacional/Frm_ReporteIncorporacionRecomendacionActerior")
	public String Frm_ReporteIncorporacionRecomendacion(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteIncorporacionRecomendacionActerior";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteRecomendacion" }, method = RequestMethod.POST)
	public String ReporteRecomendacion(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		JasperFiltroReporte jasper = new JasperFiltroReporte();
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/IncorporacionRecomendacionesAnterior.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES
				+ "IncorporacionRecomendacionesAnterior_" + historial + ".xlsx");
		jasper.setTituloArchivo("Documento pdf Incorporacion");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_Pdf + "IncorporacionRecomendacionesAnterior_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// Fin Metodos para reporte de Incorporacion de Recomendaciones Años
	// anteriores//

	// Metodos para reporte de Nuemro de participantes años anteriores//

	@RequestMapping("/view/tecnicoNacional/Fmr_ReporteNumeroParticiantesRCAutoridad")
	public String Fmr_ReporteNumeroParticiantesRCAutoridad(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Fmr_ReporteNumeroParticiantesRCAutoridad";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteParticipantes" }, method = RequestMethod.POST)
	public String ReporteParticipantes(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		JasperFiltroReporte jasper = new JasperFiltroReporte();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/ParticipatesRendicionAutoridades.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES
				+ "ParticipatesRendicionAutoridades_" + historial + ".xlsx");
		jasper.setTituloArchivo("Documento pdf Incorporacion");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_Pdf + "ParticipatesRendicionAutoridades_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// Fin Metodos para reporte de Nuemro de participantes años anteriores//
	// JC

	@RequestMapping("/view/tecnicoNacional/Frm_ReporteAperturasInformes")
	public String Frm_ReporteAperturasInformes(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteAperturasInformes";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteAperturasInformes" }, method = RequestMethod.POST)
	public String ReporteAperturasInformes(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		JasperFiltroReporte jasper = new JasperFiltroReporte();
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/AperturasInformesInstituciones.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "AperturasInformesInstituciones_"
				+ historial + ".xlsx");
		jasper.setTituloArchivo("Informes Aperturados Instituciones");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_XLSX + "AperturasInformesInstituciones_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	@RequestMapping("/view/tecnicoNacional/Frm_ReporteCumplimientoInstituciones")
	public String Frm_ReporteCumplimientoInstituciones(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteCumplimientoInstituciones";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteCumplimientoInstituciones" }, method = RequestMethod.POST)
	public String ReporteCumplimientoInstituciones(Model model, HttpServletRequest request,
			HttpServletResponse response, @RequestParam("periodo") int periodo) {

		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		JasperFiltroReporte jasper = new JasperFiltroReporte();
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/CumplimientoInstituciones.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(
				Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "CumplimientoInstituciones_" + historial + ".xlsx");
		jasper.setTituloArchivo("Cumplimiento Instituciones");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_XLSX + "CumplimientoInstituciones_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// reaperturas informes autoridades

	@RequestMapping("/view/tecnicoNacional/Frm_ReporteAperturasAutoridades")
	public String Frm_ReporteAperturasAutoridades(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteAperturasAutoridades";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteAperturasAutoridades" }, method = RequestMethod.POST)
	public String ReporteAperturasAutoridades(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);

		JasperFiltroReporte jasper = new JasperFiltroReporte();
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/AperturasInformesAutoridades.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "AperturasInformesAutoridades_"
				+ historial + ".xlsx");
		jasper.setTituloArchivo("Informes Aperturados Autoridades");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_XLSX + "AperturasInformesAutoridades_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// cumplimiento informes autoridades
	@RequestMapping("/view/tecnicoNacional/Frm_ReporteCumplimientoAutoridades")
	public String Frm_ReporteCumplimientoAutoridades(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteCumplimientoAutoridades";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteCumplimientoAutoridades" }, method = RequestMethod.POST)
	public String ReporteCumplimientoAutoridades(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		JasperFiltroReporte jasper = new JasperFiltroReporte();
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/CumplimientoAutoridades.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(
				Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "CumplimientoAutoridades_" + historial + ".xlsx");
		jasper.setTituloArchivo("Cumplimiento Autoridades");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF", Constantes.RUTA_ARCHIVOS_XLSX + "CumplimientoAutoridades_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// Catastro Completo Instituciones
	@RequestMapping("/view/tecnicoNacional/Frm_ReporteCatastroTotalInstituciones")
	public String Frm_ReporteCatastroTotalInstituciones(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteCatastroTotalInstituciones";
	}

	// Catastro Completo Instituciones
	@RequestMapping("/view/tecnicoNacional/Frm_ReporteRetroalimentacion")
	public String Frm_ReporteRetroalimentacion(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteRetroalimentacion";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteCatastroTotalInstituciones" }, method = RequestMethod.POST)
	public String ReporteCatastroTotalInstituciones(Model model, HttpServletRequest request,
			HttpServletResponse response, @RequestParam("periodo") int periodo) {

		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		JasperFiltroReporte jasper = new JasperFiltroReporte();
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/CatastroCompletoInstituciones.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "CatastroCompletoInstituciones_"
				+ historial + ".xlsx");
		jasper.setTituloArchivo("Catastro Completo Instituciones");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_XLSX + "CatastroCompletoInstituciones_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// Catasro total retralimentacion
	@RequestMapping(value = {
			"/view/tecnicoNacional/ReporteCatastroTotalInstitucionesRetroalimentacion" }, method = RequestMethod.POST)
	public String ReporteCatastroTotalInstitucionesRetroalimentacion(Model model, HttpServletRequest request,
			HttpServletResponse response, @RequestParam("periodo") int periodo) {

		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		JasperFiltroReporte jasper = new JasperFiltroReporte();
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/CatastroCompletoInstitucionesRetroalimentacion.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES
				+ "CatastroCompletoInstitucionesRetroalimentacion_" + historial + ".xlsx");
		jasper.setTituloArchivo("Catastro Completo Instituciones Retroalimentacion");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF", Constantes.RUTA_ARCHIVOS_XLSX + "CatastroCompletoInstitucionesRetroalimentacion_"
				+ historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// Catastro Completo Instituciones
	@RequestMapping("/view/tecnicoNacional/Frm_ReporteCatastroTotalAutoridades")
	public String Frm_ReporteCatastroTotalAutoridades(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteCatastroTotalAutoridades";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteCatastroTotalAutoridades" }, method = RequestMethod.POST)
	public String ReporteCatastroTotalAutoridades(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		JasperFiltroReporte jasper = new JasperFiltroReporte();
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/CatastroCompletoAutoridades.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "CatastroCompletoAutoridades_"
				+ historial + ".xlsx");
		jasper.setTituloArchivo("Catastro Completo Autoridades");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_XLSX + "CatastroCompletoAutoridades_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// Gestion Catastro
	@RequestMapping("/view/tecnicoNacional/Frm_ReporteGestionCatastro")
	public String Frm_ReporteGestionCatastro(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteGestionCatastro";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteGestionCatastro" }, method = RequestMethod.POST)
	public String ReporteGestionCatastro(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		JasperFiltroReporte jasper = new JasperFiltroReporte();
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/GestionCatastro.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(
				Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "GestionCatastro_" + historial + ".xlsx");
		jasper.setTituloArchivo("Gestion Catastro");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF", Constantes.RUTA_ARCHIVOS_XLSX + "GestionCatastro_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// PresupuestoInstitucional.jrxml
	@RequestMapping("/view/tecnicoNacional/Frm_ReportePresupuestoInstitucional")
	public String Frm_ReportePresupuestoInstitucional(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReportePresupuestoInstitucional";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReportePresupuestoInstitucional" }, method = RequestMethod.POST)
	public String ReportePresupuestoInstitucional(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		JasperFiltroReporte jasper = new JasperFiltroReporte();
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/PresupuestoInstitucional.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(
				Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "PresupuestoInstitucional_" + historial + ".xlsx");
		jasper.setTituloArchivo("Presupuesto Institucional ");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_XLSX + "PresupuestoInstitucional_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// Metodos REporte Transparencia y acceso a la informacion//

	@RequestMapping("/view/tecnicoNacional/Frm_ReporteTransparenciaAccesoInformacion")
	public String Frm_ReporteTransparenciaAccesoInformacion(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteTransparenciaAccesoInformacion";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteTransparencia" }, method = RequestMethod.POST)
	public String ReporteTransparencia(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		JasperFiltroReporte jasper = new JasperFiltroReporte();
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/TransparenciaAccesoInformacion.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "TransparenciaAccesoInformacion_"
				+ historial + ".xlsx");
		jasper.setTituloArchivo("Documento pdf Transparencia");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_Pdf + "TransparenciaAccesoInformacion_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// Fin Metodos REporte Transparencia y acceso a la informacion//

	// Metodos Frm_ReporteSeguimientoInstitucionesGAD//

	@RequestMapping("/view/tecnicoNacional/Frm_ReporteSeguimientoInstitucionesGAD")
	public String Frm_ReporteSeguimientoInstitucionesGAD(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteSeguimientoInstitucionesGAD";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteSeguimientoInstitucionesGAD" }, method = RequestMethod.POST)
	public String ReporteSeguimientoInstitucionesGAD(Model model, HttpServletRequest request,
			HttpServletResponse response, @RequestParam("periodo") int periodo) {

		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		JasperFiltroReporte jasper = new JasperFiltroReporte();
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/SeguimientoInstitucionesGAD.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "SeguimientoInstitucionesGAD_"
				+ historial + ".xlsx");
		jasper.setTituloArchivo("Seguimiento Instituciones GAD ");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_XLSX + "SeguimientoInstitucionesGAD_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// FinFrm_ReporteSeguimientoInstitucionesGAD//

	// Metodos Frm_ReporteSeguimientoAutoridadesGAD//

	@RequestMapping("/view/tecnicoNacional/Frm_ReporteSeguimientoAutoridadesGAD")
	public String Frm_ReporteSeguimientoAutoridadesGAD(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteSeguimientoAutoridadesGAD";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteSeguimientoAutoridadesGAD" }, method = RequestMethod.POST)
	public String ReporteSeguimientoAutoridadesGAD(Model model, HttpServletRequest request,
			HttpServletResponse response, @RequestParam("periodo") int periodo) {

		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		JasperFiltroReporte jasper = new JasperFiltroReporte();
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/SeguimientoAutoridadesGAD.jrxml");
		// Map<String, Object> parameter = new HashMap<>();

		jasper.setRutaArchivoNuevo(
				Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "SeguimientoAutoridadesGAD_" + historial + ".xlsx");
		jasper.setTituloArchivo("Seguimiento Autoridades GAD ");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReportes(periodo);

		model.addAttribute("rutaPDF",
				Constantes.RUTA_ARCHIVOS_XLSX + "SeguimientoAutoridadesGAD_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// FinFrm_ReporteSeguimientoAutoridadesGAD//

	// ReporteProceoRCGADS//

	@RequestMapping("/view/tecnicoNacional/Frm_ReporteProceoRCGADS")
	public String Frm_ReporteProceoRCGADS(Model model, @RequestParam("opcion") int idMenu,
			Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteProceoRCGADS";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteProcesosRCGADS" }, method = RequestMethod.POST)
	public String ReporteProcesosRCGADS(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		JasperFiltroReporte jasper = new JasperFiltroReporte();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/ProcesosRendicionCuentasGADs.jrxml");
		jasper.setRutaArchivoNuevo(
				Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "ReporteProcesosRCGADS_" + historial + ".xlsx");
		jasper.setTituloArchivo("ReporteProcesosRCGADS");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReporteVariable(periodo);

		model.addAttribute("rutaPDF", Constantes.RUTA_ARCHIVOS_XLSX + "ReporteProcesosRCGADS_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}

	// ReporteProceoRCGADS//

	@RequestMapping("/view/tecnicoNacional/Frm_ReporteProceoRC")
	public String Frm_ReporteProceoRC(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {

		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);

		model.addAttribute("anioActual", anio);
		model.addAttribute("rol", "Nacional");
		model.addAttribute("anio", "2020");
		return "tecnicoNacional/Frm_ReporteProceoRC";
	}

	@RequestMapping(value = { "/view/tecnicoNacional/ReporteProcesosRC" }, method = RequestMethod.POST)
	public String ReporteProcesosRC(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("periodo") int periodo) {

		JasperFiltroReporte jasper = new JasperFiltroReporte();
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		String historial = hourdateFormat.format(date);
		jasper.setRequest(request);
		jasper.setReportFileName("/WEB-INF/view/reportes/ProcesosRendicionCuentasInsti.jrxml");
		jasper.setRutaArchivoNuevo(
				Constantes.RUTA_ARCHIVOS_MODULO_ADMISION_REPORTES + "ReporteProcesosRC_" + historial + ".xlsx");
		jasper.setTituloArchivo("ReporteProcesosRC");
		jasper.setTipoDocumentoExportar("XLSX");
		jasper.setLogoReporte("ninguno");

		jasper.generarReporteVariable(periodo);

		model.addAttribute("rutaPDF", Constantes.RUTA_ARCHIVOS_XLSX + "ReporteProcesosRC_" + historial + ".xlsx");
		return "reportes/ReportVariable";
	}
}
