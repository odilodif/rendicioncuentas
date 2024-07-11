package gob.cpccs.controller.rendicion;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import gob.cpccs.model.retroalimentacion.TblAsignacion;
import gob.cpccs.model.retroalimentacion.TblInformeCalificado;
import gob.cpccs.model.retroalimentacion.TblValoracion;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.service.rendicion.InformeServicio;
import gob.cpccs.service.retroalimentacion.AsignacionServicio;
import gob.cpccs.service.retroalimentacion.InformeCalificacionService;
import gob.cpccs.service.retroalimentacion.InformeValoradoService;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;

@Controller
@RequestMapping("/view/rendicion/valoracion")
public class ValoracionInformeGADEPController {
	
	@Autowired
	private AsignacionServicio as;
	@Autowired
	private InformeServicio is;
	@Autowired
	private UsuarioServicio us;
	@Autowired
	private InformeValoradoService ivs;
	@Autowired
	private InformeCalificacionService ics;
	
	int i = 0;
	
	@RequestMapping(value = "valoracionInformeGADEP", method = RequestMethod.POST)
	public String valoracionInformeGADEP(Model model, Authentication authentication,
			@RequestParam("id") String infcodPeriodo) {
		// separamos id y periodo
		String[] parts = infcodPeriodo.split("-");
		Integer infcod = Integer.parseInt(parts[0]); // id del informe
		Integer periodo = Integer.parseInt(parts[1]); // periodo
		model.addAttribute("email", authentication.getName());
		List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
		TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
		model.addAttribute("periodoInforme", periodo);
		model.addAttribute("identificadorResponsable", datosUsuarioInterno.getIdentificador());
		model.addAttribute("infcod", datosInstitucion.get(0)[0].toString());
		model.addAttribute("nombreInstitución", datosInstitucion.get(0)[1].toString());
		model.addAttribute("identificadorInstitucion", datosInstitucion.get(0)[2].toString());
		model.addAttribute("representanteLegal", datosInstitucion.get(0)[3].toString());
		model.addAttribute("funcionInstitucion", datosInstitucion.get(0)[4].toString());
		model.addAttribute("descripcionInstitucion", datosInstitucion.get(0)[5].toString());
		model.addAttribute("sectorInstitucion", datosInstitucion.get(0)[6].toString());
		model.addAttribute("tipoFormulario", datosInstitucion.get(0)[7].toString());
		model.addAttribute("fecha", datosInstitucion.get(0)[8].toString());
		model.addAttribute("estado", datosInstitucion.get(0)[9].toString());

		i = 1;

			ics.ObtenerListaPregunstas(infcod).forEach(
					detalleInforme -> {
						model.addAttribute("detalle" + i, detalleInforme);
						i++;
					});
		
		return "rendicion/valoracion/valoracionInformeGADEP";
	}
	
	private TblInformeCalificado getInformeCalificado(Integer infcod, Integer idInforme) {
		
		if(idInforme != null) {
			return ics.ObtenerListaPregunstas(infcod)
				.stream()
				.filter(informe -> informe.getIdInfCal().equals(idInforme))
				.collect(Collectors.toList()).get(0);
		} else {
			return null;
		}
	}
	
	private static void informeCalificado1(TblInformeCalificado informeCalificado, Integer infcod, String cmbpregunta1, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("ESTADO INFORME");
		informeCalificado.setPregunta(
				"¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO "
						+ periodo + "?");
		informeCalificado.setRespuesta(cmbpregunta1);
		if (cmbpregunta1.equals("SI")) {
			informeCalificado.setNota((float) 11.11);
			nota = (float) nota;//(float) 11.11;
		} else {
			informeCalificado.setNota((float) 0.00);
			nota = (float) 0.00;
		}
		informeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
		informeCalificado.setPeriodo(periodo);
		informeCalificado.setEvidencia("N/A");
		//ics.guardarInformeCalificacion(tblInformeCalificado);
	}
	
	private static void informeCalificado2(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta2, String rutaArchivo1, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("CUMPLIMIENTO DE LA EJECUCIÓN PRESUPUESTARIA");
		informeCalificado.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?");
		informeCalificado.setRespuesta(cmbPregunta2);
		switch (cmbPregunta2) {
		case "1. CÉDULA PRESUPUESTARIA DEL MINISTERIO DE FINANZAS":
			informeCalificado.setNota((float) 11.11);
			nota = nota + (float) 11.11;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA1);
			break;
		case "2. INFORME DE GESTIÓN FINANCIERA APROBADO POR AUTORIDAD COMPETENTE":
			informeCalificado.setNota((float) 11.11);
			nota = nota + (float) 11.11;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA2);

			break;
		case "3. MATRIZ DE LOTAIP QUE SI DIRECCIONA A LA CÉDULA PRESUPUESTARIA":
			informeCalificado.setNota((float) 11.11);
			nota = nota + (float) 11.11;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA3);

			break;
		case "4. DOCUMENTO OFICIAL DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO Y SU EJECUCIÓN":
			informeCalificado.setNota((float) 11.11);
			nota = nota + (float) 11.11;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA4);

			break;
		case "5. MATRIZ DE LOTAIP QUE SÍ DIRECCIONA A LA CÉDULA PRESUPUESTARIA":
			informeCalificado.setNota((float) 11.11);
			nota = nota + (float) 11.11;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA5);

			break;
		case "6. NO ABRE EL LINK":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA6);

			break;
		case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA7);

			break;
		case "8. RESPONDE EN 0":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA8);

			break;
		case "9. OTROS, NO CUMPLE":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA9);

			break;
		case "10. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA10);

			break;
		}

		informeCalificado.setPeriodo(periodo);
		if(!rutaArchivo1.isEmpty()) {
			informeCalificado.setEvidencia(rutaArchivo1);
		}else {
			if("11. VACÍO".equals(cmbPregunta2)) {
				informeCalificado.setEvidencia("N/A");
			} else {
				informeCalificado.setEvidencia(null);
			}
		}
		//ics.guardarInformeCalificacion(informeCalificado);	
	}
	
	private static void informeCalificado3(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta3, String rutaArchivo2, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("BALANCE GENERAL");
		informeCalificado.setPregunta("¿LA EMPRESA PÚBLICA PRESENTA SU BALANCE GENERAL?");
		informeCalificado.setRespuesta(cmbPregunta3);
		switch (cmbPregunta3) {
		case "1. BALANCE GENERAL":
			informeCalificado.setNota((float) 12.50);
			nota = nota + (float) 12.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA1);
			break;
		case "2. NO ABRE EL LINK":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA8);

			break;
		case "3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA9);

			break;
		case "4. RESPONDE EN 0":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA10);

			break;
		case "5. OTROS, NO CUMPLE":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA11);

			break;
		case "4. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA12);

			break;
		}
		informeCalificado.setPeriodo(periodo);
		if(!rutaArchivo2.isEmpty()) {
			informeCalificado.setEvidencia(rutaArchivo2);
		}else {
			if("6. VACÍO".equals(cmbPregunta3)) {
				informeCalificado.setEvidencia("N/A");
			} else {
				informeCalificado.setEvidencia(null);
			}
		}
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado4(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta4, String rutaArchivo3, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("PROCESOS DE CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS");
		informeCalificado.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?");
		informeCalificado.setRespuesta(cmbPregunta4);
		switch (cmbPregunta4) {
		case "1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP":
			informeCalificado.setNota((float) 12.50);
			nota = nota + (float) 12.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA1);
			break;
		case "2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS":
			informeCalificado.setNota((float) 12.50);
			nota = nota + (float) 12.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA2);

			break;
		case "3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN":
			informeCalificado.setNota((float) 12.50);
			nota = nota + (float) 12.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA3);

			break;
		case "4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA))":
			informeCalificado.setNota((float) 12.50);
			nota = nota + (float) 12.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA4);

			break;
		case "5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA":
			informeCalificado.setNota((float) 12.50);
			nota = nota + (float) 12.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA5);

			break;
		case "6. NO ABRE EL LINK":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA8);

			break;
		case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA9);

			break;
		case "8. RESPONDE EN 0":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA10);

			break;
		case "9. OTROS, NO CUMPLE":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA11);

			break;
		case "10. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA12);

			break;
		}

		informeCalificado.setPeriodo(periodo);
		if(!rutaArchivo3.isEmpty()) {
			informeCalificado.setEvidencia(rutaArchivo3);
		}else {
			if("10. VACÍO".equals(cmbPregunta4)) {
				informeCalificado.setEvidencia("N/A");
			} else {
				informeCalificado.setEvidencia(null);
			}
		}
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado5(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta5, String rutaArchivo4, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("CUMPLIMIENTO DE OBLIGACIONES (LOCPCCS Art. 10 NUMERAL 7)");
		informeCalificado.setPregunta(
				"¿LA EMPRESA PÚBLICA PRESENTA INFORMACIÓN DE CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS?");
		informeCalificado.setRespuesta(cmbPregunta5);
		switch (cmbPregunta5) {
		case "1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL SRI":
			informeCalificado.setNota((float) 6.25);
			nota = nota + (float) 6.25;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA1);
			break;
		case "2. CERTIFICADO EMITIDO POR SRI Y SENAE":
			informeCalificado.setNota((float) 6.25);
			nota = nota + (float) 6.25;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA2);
			break;
		case "3. NO ABRE EL LINK":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA8);
			break;
		case "4. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA9);

			break;
		case "5. NO APLICA":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA10);

			break;
		case "6. OTROS, NO CUMPLE":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA11);

			break;
		case "7. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA12);

			break;
		}

		informeCalificado.setPeriodo(periodo);
		if(!rutaArchivo4.isEmpty()) {
			informeCalificado.setEvidencia(rutaArchivo4);
		}else {
			if("7. VACÍO".equals(cmbPregunta5) || "5. NO APLICA".equals(cmbPregunta5)) {
				informeCalificado.setEvidencia("N/A");
			} else {
				informeCalificado.setEvidencia(null);
			}
		}
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado6(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta6, String rutaArchivo5, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("CUMPLIMIENTO DE OBLIGACIONES (LOCPCCS Art. 10 NUMERAL 7)");
		informeCalificado.setPregunta("¿LA EMPRESA PÚBLICA PRESENTA INFORMACIÓN DE CUMPLIMIENTO DE OBLIGACIONES LABORALES?");
		informeCalificado.setRespuesta(cmbPregunta6);
		switch (cmbPregunta6) {
		case "1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL SRI":
			informeCalificado.setNota((float) 6.25);
			nota = nota + (float) 6.25;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA1);
			break;
		case "2. NO ABRE EL LINK":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA8);
			break;
		case "3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA9);

			break;
		case "4. NO APLICA":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA10);

			break;
		case "5. OTROS, NO CUMPLE":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA11);

			break;
		case "6. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA12);

			break;
		}

		informeCalificado.setPeriodo(periodo);
		if(!rutaArchivo5.isEmpty()) {
			informeCalificado.setEvidencia(rutaArchivo5);
		}else {
			if("6. VACÍO".equals(cmbPregunta6) || "4. NO APLICA".equals(cmbPregunta6)) {
				informeCalificado.setEvidencia("N/A");
			} else {
				informeCalificado.setEvidencia(null);
			}
		}
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado7(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta7, String rutaArchivo6, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("MECANISMOS DE PARTICIPACIÓN CIUDADANA");
		informeCalificado
				.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?");
		informeCalificado.setRespuesta(cmbPregunta7);
		switch (cmbPregunta7) {
		case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
			informeCalificado.setNota((float) 12.50);
			nota = nota + (float) 12.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA1);
			break;
		case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE ASISTENCIAS":
			informeCalificado.setNota((float) 12.50);
			nota = nota + (float) 12.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA2);
			break;
		case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
			informeCalificado.setNota((float) 6.25);
			nota = nota + (float) 6.25;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA3);
			break;
		case "4. NO ABRE EL LINK":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA5);
			break;
		case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA6);
			break;
		case "6. NO APLICA":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA7);
			break;
		case "7. OTROS, NO CUMPLE":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA8);
			break;
		case "8. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA9);
			break;
		}

		informeCalificado.setPeriodo(periodo);
		if(!rutaArchivo6.isEmpty()) {
			informeCalificado.setEvidencia(rutaArchivo6);
		}else {
			if("8. VACÍO".equals(cmbPregunta7) || "6. NO APLICA".equals(cmbPregunta7)) {
				informeCalificado.setEvidencia("N/A");
			} else {
				informeCalificado.setEvidencia(null);
			}
		}
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado8(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta8, String rutaArchivo7, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
		informeCalificado.setPregunta(
				"¿LA ENTIDAD SUSTENTA LA RECEPCIÓN DEL LISTADO DE TEMAS SOBRE LOS CUALES LA CIUDADANÍA SOLICITA SE RINDA CUENTAS?");
		informeCalificado.setRespuesta(cmbPregunta8);
		switch (cmbPregunta8) {
		case "1. OFICIO O DOCUMENTO FIRMADO POR LOS CIUDADANOS, DEL LISTADO DE TEMAS SOBRE LOS CUALES SOLICITA A LA AUTORIDAD DE LA E.P DEL GAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO":
			informeCalificado.setNota((float) 2.50);
			nota = nota + (float) 2.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA1);
			break;
		case "2. RESPALDO DE LOS TEMAS QUE LOS CIUDADANOS PRESENTARON, A TRAVÉS DE MECANISMOS DIGITALES, A LA AUTORIDAD DE LA E.P DEL GAD PARA QUE RINDA CUENTAS":
			informeCalificado.setNota((float) 2.50);
			nota = nota + (float) 2.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA1);
			break;
		case "3. NO ABRE EL LINK":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA5);
			break;
		case "4. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA6);
			break;
		case "5. NO APLICA":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA7);
			break;
		case "6. OTROS, NO CUMPLE":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA8);
			break;
		case "7. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA9);
			break;
		}

		informeCalificado.setPeriodo(periodo);
		if(!rutaArchivo7.isEmpty()) {
			informeCalificado.setEvidencia(rutaArchivo7);
		}else {
			if("7. VACÍO".equals(cmbPregunta8) || "5. NO APLICA".equals(cmbPregunta8)) {
				informeCalificado.setEvidencia("N/A");
			} else {
				informeCalificado.setEvidencia(null);
			}
		}
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado9(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta9, String rutaArchivo8, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
		informeCalificado.setPregunta(
				"¿LA ENTIDAD SUSTENTA LA ENTREGA DEL INFORME PRELIMINAR Y FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL CON 15 DÍAS DE ANTELACIÓN?");
		informeCalificado.setRespuesta(cmbPregunta9);
		switch (cmbPregunta9) {
		case "1. EL DOCUMENTO DE LA E.P DEL GAD EN EL QUE LA ASAMBLEA CIUDADANA /CIUDADANÍA AFIRMAN HABER RECIBIDO EL INFORME & FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, CON 15 DÍAS DE ANTELACIÓN":
			informeCalificado.setNota((float) 2.50);
			nota = nota + (float) 2.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
			break;
		case "2. ENVÍO VIRTUAL DEL INFORME Y FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, POR PARTE DE LA E.P DEL GAD A LA ASAMBLEA CIUDADANA /CIUDADANÍA, Y CONFIRMACIÓN CIUDADANA DE RECIBIDO, CON 15 DÍAS DE ANTELACIÓN":
			informeCalificado.setNota((float) 2.50);
			nota = nota + (float) 2.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA2);
			break;
		case "3. NO ABRE EL LINK":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
			break;
		case "4. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
			break;
		case "5. NO APLICA":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
			break;
		case "6. OTROS, NO CUMPLE":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
			break;
		case "7. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
			break;
		}

		informeCalificado.setPeriodo(periodo);
		if(!rutaArchivo8.isEmpty()) {
			informeCalificado.setEvidencia(rutaArchivo8);
		}else {
			if("7. VACÍO".equals(cmbPregunta9) || "5. NO APLICA".equals(cmbPregunta9)) {
				informeCalificado.setEvidencia("N/A");
			} else {
				informeCalificado.setEvidencia(null);
			}
		}
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado10(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta10, String rutaArchivo9, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
		informeCalificado.setPregunta(
				"¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DEL VIDEO DE LA DELIBERACIÓN PÚBLICA CON LA INTERVENCIÓN DE LA CIUDADANÍA?");
		informeCalificado.setRespuesta(cmbPregunta10);
		switch (cmbPregunta10) {
		case "1. LINK AL VIDEO EN EL QUE LA E.P DEL GAD DEMUESTRA QUE LA ASAMBLEA CIUDADANA  -CIUDADANÍA SI TUVO UN TIEMPO PARA EVALUAR LA ENTIDAD EN LA DELIBERACIÓN PÚBLICA":
			informeCalificado.setNota((float) 2.50);
			nota = nota + (float) 2.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
			break;
		case "2. LINK AL VIDEO EN EL QUE LA E.P DEL GAD REALIZÓ LA DELIBERACIÓN PÚBLICA, PERO LA ASAMBLEA CIUDADANA /CIUDADANÍA NO TUVO UN TIEMPO PARA EVALUAR LA ENTIDAD EN LA DELIBERACIÓN PÚBLICA":
			informeCalificado.setNota((float) 2.50);
			nota = nota + (float) 2.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA2);
			break;
		case "3. NO ABRE EL LINK":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
			break;
		case "4. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
			break;
		case "5. NO APLICA":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
			break;
		case "6. OTROS, NO CUMPLE":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
			break;
		case "7. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
			break;
		}

		informeCalificado.setPeriodo(periodo);
		if(!rutaArchivo9.isEmpty()) {
			informeCalificado.setEvidencia(rutaArchivo9);
		}else {
			if("7. VACÍO".equals(cmbPregunta10) || "5. NO APLICA".equals(cmbPregunta10)) {
				informeCalificado.setEvidencia("N/A");
			} else {
				informeCalificado.setEvidencia(null);
			}
		}
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado11(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta11, String rutaArchivo10,  Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
		informeCalificado.setPregunta(
				"¿LA ENTIDAD SUSTENTA PLAN DE TRABAJO QUE INCORPORA LAS SUGERENCIAS CIUDADANAS EN SU GESTIÓN?");
		informeCalificado.setRespuesta(cmbPregunta11);
		switch (cmbPregunta11) {
		case "1. DOCUMENTO DEL PLAN DE TRABAJO DE LA E.P DEL GAD ELABORADO A PARTIR DE LOS INSUMOS DE LA DELIBERACIÓN PÚBLICA DEL GAD":
			informeCalificado.setNota((float) 2.50);
			nota = nota + (float) 2.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
			break;
		case "2. NO ABRE EL LINK":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
			break;
		case "3. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
			break;
		case "4. NO APLICA":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
			break;
		case "5. OTROS, NO CUMPLE":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
			break;
		case "6. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
			break;
		}

		informeCalificado.setPeriodo(periodo);
		if(!rutaArchivo10.isEmpty()) {
			informeCalificado.setEvidencia(rutaArchivo10);
		}else {
			if("6. VACÍO".equals(cmbPregunta11) || "4. NO APLICA".equals(cmbPregunta11)) {
				informeCalificado.setEvidencia("N/A");
			} else {
				informeCalificado.setEvidencia(null);
			}
		}
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado12(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta12, String rutaArchivo11, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
		informeCalificado.setPregunta(
				"¿LA ENTIDAD SUSTENTA LA ENTREGA DEL PLAN DE TRABAJO A LA ASAMBLEA CIUDADANA CON SU RESPECTIVO RECIBIDO?");
		informeCalificado.setRespuesta(cmbPregunta12);
		switch (cmbPregunta12) {
		case "1. DOCUMENTOS (DIGITAL O FÍSICO) CON EL RECIBIDO DE: LA ASAMBLEA CIUDADANA - CIUDADANÍA, CONSEJO DE PARTICIPACIÓN E INSTANCIA DE PARTICIPACIÓN, DE CONSTANCIA DE ENTREGA DEL PLAN DE TRABAJO":
			informeCalificado.setNota((float) 2.50);
			nota = nota + (float) 2.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
			break;
		case "2. NO ABRE EL LINK":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
			break;
		case "3. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
			break;
		case "4. NO APLICA":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
			break;
		case "5. OTROS, NO CUMPLE":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
			break;
		case "6. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
			break;
		}

		informeCalificado.setPeriodo(periodo);
		if(!rutaArchivo11.isEmpty()) {
			informeCalificado.setEvidencia(rutaArchivo11);
		}else {
			if("6. VACÍO".equals(cmbPregunta12) || "4. NO APLICA".equals(cmbPregunta12)) {
				informeCalificado.setEvidencia("N/A");
			} else {
				informeCalificado.setEvidencia(null);
			}
		}
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado13(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta13, String rutaArchivo12, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz(
				"CUMPLIMIENTO DEL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR IMPLEMENTADAS EN LA GESTIÓN INSTITUCIONAL");
		informeCalificado.setPregunta(
				"¿LA ENTIDAD SUSTENTA HABER CUMPLIDO EL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR, EN SU GESTIÓN INSTITUCIONAL?");
		informeCalificado.setRespuesta(cmbPregunta13);
		switch (cmbPregunta13) {
		case "1. ACTA, INFORME O DOCUMENTO OFICIAL QUE DE CUENTA DE LA IMPLEMENTACIÓN":
			informeCalificado.setNota((float) 12.50);
			nota = nota + (float) 12.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
			break;
		case "2. NO APLICA, PORQUE SE CREA EN EL AÑO DE RENDICIÓN DE CUENTAS":
			informeCalificado.setNota((float) 12.50);
			nota = nota + (float) 12.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
			break;
		case "3. NO APLICA, PORQUE EL PROCESO ANTERIOR NO RECIBIÓ APORTES":
			informeCalificado.setNota((float) 12.50);
			nota = nota + (float) 12.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
			break;
		case "4. NO ABRE EL LINK":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
			break;
		case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
			break;
		case "6.  NO APLICA":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
			break;
		case "7. OTROS, NO CUMPLE":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
			break;
		case "8. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
			break;
		}

		informeCalificado.setPeriodo(periodo);
		if(!rutaArchivo12.isEmpty()) {
			informeCalificado.setEvidencia(rutaArchivo12);
		}else {
			if("8. VACÍO".equals(cmbPregunta13) || "6. NO APLICA".equals(cmbPregunta13)) {
				informeCalificado.setEvidencia("N/A");
			} else {
				informeCalificado.setEvidencia(null);
			}
		}
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado14(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta14, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("MECANISMOS DE CONTROL SOCIAL");
		informeCalificado
				.setPregunta("¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?");
		informeCalificado.setRespuesta(cmbPregunta14);
		switch (cmbPregunta14) {
		case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
			informeCalificado.setNota((float) 12.50);
			nota = nota + (float) 12.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA1);
			break;
		case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE	ASISTENCIAS":
			informeCalificado.setNota((float) 12.50);
			nota = nota + (float) 12.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA2);
			break;
		case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
			informeCalificado.setNota((float) 6.25);
			nota = nota + (float) 6.25;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA3);
			break;
		case "4. NO ABRE EL LINK":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA4);
			break;
		case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA5);
			break;
		case "6. NO APLICA":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA6);
			break;
		case "7. OTROS, NO CUMPLE":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA7);
			break;
		case "8. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA8);
			break;
		}

		informeCalificado.setPeriodo(periodo);
		/*
		 * if(rutaArchivo8!="") { tblInformeCalificado14.setEvidencia(rutaArchivo8);
		 * }else { tblInformeCalificado14.setEvidencia("N/A"); }
		 */
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado15(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta15, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
		informeCalificado
				.setPregunta("¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?");
		informeCalificado.setRespuesta(cmbPregunta15);
		switch (cmbPregunta15) {
		case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
			informeCalificado.setNota((float) 2.50);
			nota = nota + (float) 2.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
			break;
		case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
			break;
		case "3. REPORTA NO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
			break;
		case "4. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
			break;
		}
		informeCalificado.setPeriodo(periodo);
		informeCalificado.setEvidencia("N/A");
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado16(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta16, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
		informeCalificado
				.setPregunta("¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?");
		informeCalificado.setRespuesta(cmbPregunta16);
		switch (cmbPregunta16) {
		case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
			informeCalificado.setNota((float) 2.50);
			nota = nota + (float) 2.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
			break;
		case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
			break;
		case "3. REPORTA NO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
			break;
		case "4. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
			break;
		}
		informeCalificado.setPeriodo(periodo);
		informeCalificado.setEvidencia("N/A");
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado17(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta17, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
		informeCalificado.setPregunta(
				"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?");
		informeCalificado.setRespuesta(cmbPregunta17);
		switch (cmbPregunta17) {
		case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
			informeCalificado.setNota((float) 2.50);
			nota = nota + (float) 2.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
			break;
		case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
			break;
		case "3. REPORTA NO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
			break;
		case "4. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
			break;
		}
		informeCalificado.setPeriodo(periodo);
		informeCalificado.setEvidencia("N/A");
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado18(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta18, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
		informeCalificado.setPregunta(
				"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?");
		informeCalificado.setRespuesta(cmbPregunta18);
		switch (cmbPregunta18) {
		case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
			informeCalificado.setNota((float) 2.50);
			nota = nota + (float) 2.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
			break;
		case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
			break;
		case "3. REPORTA NO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
			break;
		case "4. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
			break;
		}
		informeCalificado.setPeriodo(periodo);
		informeCalificado.setEvidencia("N/A");
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado19(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta19, Integer periodo) {
		float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
		informeCalificado.setPregunta(
				"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?");
		informeCalificado.setRespuesta(cmbPregunta19);
		switch (cmbPregunta19) {
		case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
			informeCalificado.setNota((float) 2.50);
			nota = nota + (float) 2.50;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
			break;
		case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
			break;
		case "3. REPORTA NO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
			break;
		case "4. VACÍO":
			informeCalificado.setNota((float) 0.00);
			nota = nota + (float) 0.00;
			informeCalificado.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
			break;
		}
		informeCalificado.setPeriodo(periodo);
		/*
		 * if(rutaArchivo9!="") { tblInformeCalificado19.setEvidencia(rutaArchivo9);
		 * }else { tblInformeCalificado19.setEvidencia("N/A"); }
		 */
		//ics.guardarInformeCalificacion(tblInformeCalificado19);
	}
	
	
	/*@GetMapping("/view/rendicion/guardarEvaluacionGADEP")
	public String accesoNoAutorizadoguardarEvaluacionGADEP(TblInformeCalificado tblInformeCalificado) {
		return "redirect:../../index";
	}*/

	@SuppressWarnings("finally")
	@RequestMapping(value = "/guardarEvaluacionGADEP")
	public @ResponseBody String guardarEvaluacionGADEP(
			HttpServletRequest request,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, 
			@RequestParam(value = "id_informe_1", required = false) Integer id_informe_1,
			@RequestParam(value = "id_informe_2", required = false) Integer id_informe_2,
			@RequestParam(value = "id_informe_3", required = false) Integer id_informe_3,
			@RequestParam(value = "id_informe_4", required = false) Integer id_informe_4,
			@RequestParam(value = "id_informe_5", required = false) Integer id_informe_5,
			@RequestParam(value = "id_informe_6", required = false) Integer id_informe_6,
			@RequestParam(value = "id_informe_7", required = false) Integer id_informe_7,
			@RequestParam(value = "id_informe_8", required = false) Integer id_informe_8,
			@RequestParam(value = "id_informe_9", required = false) Integer id_informe_9,
			@RequestParam(value = "id_informe_10", required = false) Integer id_informe_10,
			@RequestParam(value = "id_informe_11", required = false) Integer id_informe_11,
			@RequestParam(value = "id_informe_12", required = false) Integer id_informe_12,
			@RequestParam(value = "id_informe_13", required = false) Integer id_informe_13,			
			@RequestParam(value = "id_informe_14", required = false) Integer id_informe_14,
			@RequestParam(value = "id_informe_15", required = false) Integer id_informe_15,
			@RequestParam(value = "id_informe_16", required = false) Integer id_informe_16,
			@RequestParam(value = "id_informe_17", required = false) Integer id_informe_17,
			@RequestParam(value = "id_informe_18", required = false) Integer id_informe_18,
			@RequestParam(value = "id_informe_19", required = false) Integer id_informe_19,
			@RequestParam(value = "finInforme", required = false) String finInforme,
			@RequestParam("cmbpregunta1") String cmbpregunta1,
			@RequestParam("cmbPregunta2") String cmbPregunta2, 
			@RequestParam("rutaArchivo1") String rutaArchivo1,
			@RequestParam("cmbPregunta3") String cmbPregunta3, 
			@RequestParam("rutaArchivo2") String rutaArchivo2,
			@RequestParam("cmbPregunta4") String cmbPregunta4,
			@RequestParam("rutaArchivo3") String rutaArchivo3, 
			@RequestParam("cmbPregunta5") String cmbPregunta5,
			@RequestParam("rutaArchivo4") String rutaArchivo4, 
			@RequestParam("cmbPregunta6") String cmbPregunta6,
			@RequestParam("rutaArchivo5") String rutaArchivo5,
			@RequestParam("cmbPregunta7") String cmbPregunta7,
			@RequestParam("rutaArchivo6") String rutaArchivo6, 
			@RequestParam("cmbPregunta8") String cmbPregunta8,
			@RequestParam("rutaArchivo7") String rutaArchivo7,
			@RequestParam("cmbPregunta9") String cmbPregunta9,
			@RequestParam("rutaArchivo8") String rutaArchivo8,
			@RequestParam("cmbPregunta10") String cmbPregunta10,
			@RequestParam("rutaArchivo9") String rutaArchivo9,
			@RequestParam("cmbPregunta11") String cmbPregunta11,
			@RequestParam("rutaArchivo10") String rutaArchivo10,
			@RequestParam("cmbPregunta12") String cmbPregunta12,
			@RequestParam("rutaArchivo11") String rutaArchivo11,
			@RequestParam("cmbPregunta13") String cmbPregunta13,
			@RequestParam("rutaArchivo12") String rutaArchivo12,
			@RequestParam("cmbPregunta14") String cmbPregunta14,
			@RequestParam("cmbPregunta15") String cmbPregunta15, 			
			@RequestParam("cmbPregunta16") String cmbPregunta16, 
			@RequestParam("cmbPregunta17") String cmbPregunta17,
			@RequestParam("cmbPregunta18") String cmbPregunta18, 
			@RequestParam("cmbPregunta19") String cmbPregunta19,
			@RequestParam("observacion") String observacion,
			@RequestParam("periodoInforme") String periodoInforme) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		
		try {

			List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, Integer.parseInt(periodoInforme));
			List<Object[]> registrosInformesValorados = ivs.obtenerRegistrosInformesValorados();
			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);

			if (datosInformeValorado.size() == 0) {

				
				TblInformeCalificado tblInformeCalificado = getInformeCalificado(infcod, id_informe_1);
				TblInformeCalificado tblInformeCalificado2 = getInformeCalificado(infcod, id_informe_2);
				TblInformeCalificado tblInformeCalificado3 = getInformeCalificado(infcod, id_informe_3);
				TblInformeCalificado tblInformeCalificado4 = getInformeCalificado(infcod, id_informe_4);
				TblInformeCalificado tblInformeCalificado5 = getInformeCalificado(infcod, id_informe_5);
				TblInformeCalificado tblInformeCalificado6 = getInformeCalificado(infcod, id_informe_6);
				TblInformeCalificado tblInformeCalificado7 = getInformeCalificado(infcod, id_informe_7);
				TblInformeCalificado tblInformeCalificado8 = getInformeCalificado(infcod, id_informe_8);
				TblInformeCalificado tblInformeCalificado9 = getInformeCalificado(infcod, id_informe_9);
				TblInformeCalificado tblInformeCalificado10 = getInformeCalificado(infcod, id_informe_10);
				TblInformeCalificado tblInformeCalificado11 = getInformeCalificado(infcod, id_informe_11);
				TblInformeCalificado tblInformeCalificado12 = getInformeCalificado(infcod, id_informe_12);
				TblInformeCalificado tblInformeCalificado13 = getInformeCalificado(infcod, id_informe_13);
				TblInformeCalificado tblInformeCalificado14 = getInformeCalificado(infcod, id_informe_14);
				TblInformeCalificado tblInformeCalificado15 = getInformeCalificado(infcod, id_informe_15);
				TblInformeCalificado tblInformeCalificado16 = getInformeCalificado(infcod, id_informe_16);
				TblInformeCalificado tblInformeCalificado17 = getInformeCalificado(infcod, id_informe_17);
				TblInformeCalificado tblInformeCalificado18 = getInformeCalificado(infcod, id_informe_18);
				TblInformeCalificado tblInformeCalificado19 = getInformeCalificado(infcod, id_informe_19);
				
				if (tblInformeCalificado == null && tblInformeCalificado2 == null && tblInformeCalificado3 == null
						&& tblInformeCalificado4 == null && tblInformeCalificado5 == null
						&& tblInformeCalificado6 == null && tblInformeCalificado7 == null
						&& tblInformeCalificado8 == null && tblInformeCalificado9 == null
						&& tblInformeCalificado10 == null && tblInformeCalificado11 == null
						&& tblInformeCalificado12 == null && tblInformeCalificado13 == null
						&& tblInformeCalificado14 == null && tblInformeCalificado15 == null
						&& tblInformeCalificado16 == null && tblInformeCalificado17 == null
						&& tblInformeCalificado18 == null && tblInformeCalificado19 == null) {
					
					tblInformeCalificado = new TblInformeCalificado();
					informeCalificado1(tblInformeCalificado, infcod, cmbpregunta1, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado2 = new TblInformeCalificado();
					informeCalificado2(tblInformeCalificado2, infcod, cmbPregunta2, rutaArchivo1, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado3 = new TblInformeCalificado();
					informeCalificado3(tblInformeCalificado3, infcod, cmbPregunta3, rutaArchivo2, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado4 = new TblInformeCalificado();
					informeCalificado4(tblInformeCalificado4, infcod, cmbPregunta4, rutaArchivo3, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado5 = new TblInformeCalificado();
					informeCalificado5(tblInformeCalificado5, infcod, cmbPregunta5, rutaArchivo4 , Integer.parseInt(periodoInforme));
					
					tblInformeCalificado6 = new TblInformeCalificado();
					informeCalificado6(tblInformeCalificado6, infcod, cmbPregunta6, rutaArchivo5, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado7 = new TblInformeCalificado();
					informeCalificado7(tblInformeCalificado7, infcod, cmbPregunta7, rutaArchivo6, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado8 = new TblInformeCalificado();
					informeCalificado8(tblInformeCalificado8, infcod, cmbPregunta8, rutaArchivo7, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado9 = new TblInformeCalificado();
					informeCalificado9(tblInformeCalificado9, infcod, cmbPregunta9, rutaArchivo8, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado10 = new TblInformeCalificado();
					informeCalificado10(tblInformeCalificado10, infcod, cmbPregunta10, rutaArchivo9, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado11 = new TblInformeCalificado();
					informeCalificado11(tblInformeCalificado11, infcod, cmbPregunta11, rutaArchivo10, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado12 = new TblInformeCalificado();
					informeCalificado12(tblInformeCalificado12, infcod, cmbPregunta12, rutaArchivo11, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado13 = new TblInformeCalificado();
					informeCalificado13(tblInformeCalificado13, infcod, cmbPregunta13, rutaArchivo12, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado14 = new TblInformeCalificado();
					informeCalificado14(tblInformeCalificado14, infcod, cmbPregunta14, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado15 = new TblInformeCalificado();
					informeCalificado15(tblInformeCalificado15, infcod, cmbPregunta15, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado16 = new TblInformeCalificado();
					informeCalificado16(tblInformeCalificado16, infcod, cmbPregunta16, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado17 = new TblInformeCalificado();
					informeCalificado17(tblInformeCalificado17, infcod, cmbPregunta17, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado18 = new TblInformeCalificado();
					informeCalificado18(tblInformeCalificado18, infcod, cmbPregunta18, Integer.parseInt(periodoInforme));
					
					tblInformeCalificado19 = new TblInformeCalificado();
					informeCalificado19(tblInformeCalificado19, infcod, cmbPregunta19, Integer.parseInt(periodoInforme));
					
				} else {
					if(tblInformeCalificado.getIdInfCal().equals(id_informe_1)) { 
						informeCalificado1(tblInformeCalificado, infcod, cmbpregunta1, Integer.parseInt(periodoInforme));	
					}
					if(tblInformeCalificado2.getIdInfCal().equals(id_informe_2)) { 
						informeCalificado2(tblInformeCalificado2, infcod, cmbPregunta2, rutaArchivo1, Integer.parseInt(periodoInforme));
					} 
					if(tblInformeCalificado3.getIdInfCal().equals(id_informe_3)) { 
						informeCalificado3(tblInformeCalificado3, infcod, cmbPregunta3, rutaArchivo2, Integer.parseInt(periodoInforme));
					} 
					if(tblInformeCalificado4.getIdInfCal().equals(id_informe_4)) { 
						informeCalificado4(tblInformeCalificado4, infcod, cmbPregunta4, rutaArchivo3, Integer.parseInt(periodoInforme));
					} 
					if(tblInformeCalificado5.getIdInfCal().equals(id_informe_5)) { 
						informeCalificado5(tblInformeCalificado5, infcod, cmbPregunta5, rutaArchivo4, Integer.parseInt(periodoInforme));
					} 
					if(tblInformeCalificado6.getIdInfCal().equals(id_informe_6)) { 
						informeCalificado6(tblInformeCalificado6, infcod, cmbPregunta6, rutaArchivo5, Integer.parseInt(periodoInforme));
					} 
					if(tblInformeCalificado7.getIdInfCal().equals(id_informe_7)) { 
						informeCalificado7(tblInformeCalificado7, infcod, cmbPregunta7, rutaArchivo6, Integer.parseInt(periodoInforme));
					} 
					if(tblInformeCalificado8.getIdInfCal().equals(id_informe_8)) { 
						informeCalificado8(tblInformeCalificado8, infcod, cmbPregunta8, rutaArchivo7, Integer.parseInt(periodoInforme));
					} 
					if(tblInformeCalificado9.getIdInfCal().equals(id_informe_9)) { 
						informeCalificado9(tblInformeCalificado9, infcod, cmbPregunta9, rutaArchivo8, Integer.parseInt(periodoInforme));
					} 
					if(tblInformeCalificado10.getIdInfCal().equals(id_informe_10)) { 
						informeCalificado10(tblInformeCalificado10, infcod, cmbPregunta10, rutaArchivo9, Integer.parseInt(periodoInforme));
					} 			
					if(tblInformeCalificado11.getIdInfCal().equals(id_informe_11)) { 
						informeCalificado11(tblInformeCalificado11, infcod, cmbPregunta11, rutaArchivo10, Integer.parseInt(periodoInforme));
					} 
					if(tblInformeCalificado12.getIdInfCal().equals(id_informe_12)) { 
						informeCalificado12(tblInformeCalificado12, infcod, cmbPregunta12, rutaArchivo11, Integer.parseInt(periodoInforme));
					} 
					if(tblInformeCalificado13.getIdInfCal().equals(id_informe_13)) { 
						informeCalificado13(tblInformeCalificado13, infcod, cmbPregunta13, rutaArchivo12, Integer.parseInt(periodoInforme));
					} 
					if(tblInformeCalificado14.getIdInfCal().equals(id_informe_14)) { 
						informeCalificado14(tblInformeCalificado14, infcod, cmbPregunta14, Integer.parseInt(periodoInforme));
					} 
					if(tblInformeCalificado15.getIdInfCal().equals(id_informe_15)) { 
						informeCalificado15(tblInformeCalificado15, infcod, cmbPregunta15, Integer.parseInt(periodoInforme));
					} 
					if(tblInformeCalificado16.getIdInfCal().equals(id_informe_16)) { 
						informeCalificado16(tblInformeCalificado16, infcod, cmbPregunta16, Integer.parseInt(periodoInforme));
					} 
					if(tblInformeCalificado17.getIdInfCal().equals(id_informe_17)) { 
						informeCalificado17(tblInformeCalificado17, infcod, cmbPregunta17, Integer.parseInt(periodoInforme));
					} 
					if(tblInformeCalificado18.getIdInfCal().equals(id_informe_18)) {
						informeCalificado18(tblInformeCalificado18, infcod, cmbPregunta18, Integer.parseInt(periodoInforme));
					} 			
					if(tblInformeCalificado19.getIdInfCal().equals(id_informe_19)) {
						informeCalificado19(tblInformeCalificado19, infcod, cmbPregunta19, Integer.parseInt(periodoInforme));
					} 
				}
				
				
				
				ics.guardarInformeCalificacion(tblInformeCalificado);
				ics.guardarInformeCalificacion(tblInformeCalificado2);
				ics.guardarInformeCalificacion(tblInformeCalificado3);
				ics.guardarInformeCalificacion(tblInformeCalificado4);
				ics.guardarInformeCalificacion(tblInformeCalificado5);
				ics.guardarInformeCalificacion(tblInformeCalificado6);
				ics.guardarInformeCalificacion(tblInformeCalificado7);
				ics.guardarInformeCalificacion(tblInformeCalificado8);
				ics.guardarInformeCalificacion(tblInformeCalificado9);
				ics.guardarInformeCalificacion(tblInformeCalificado10);
				ics.guardarInformeCalificacion(tblInformeCalificado11);
				ics.guardarInformeCalificacion(tblInformeCalificado12);
				ics.guardarInformeCalificacion(tblInformeCalificado13);
				ics.guardarInformeCalificacion(tblInformeCalificado14);
				ics.guardarInformeCalificacion(tblInformeCalificado15);
				ics.guardarInformeCalificacion(tblInformeCalificado16);
				ics.guardarInformeCalificacion(tblInformeCalificado17);
				ics.guardarInformeCalificacion(tblInformeCalificado18);
				ics.guardarInformeCalificacion(tblInformeCalificado19);
				
				if (finInforme == "FINALIZAR" || finInforme.equals("FINALIZAR")) {

					TblValoracion informeValorado = new TblValoracion();
					informeValorado.setInstiCod(Integer.parseInt(datosInstitucion.get(0)[10].toString()));
					informeValorado.setInfCod(infcod);
					informeValorado.setFechaValoracion(new Date());
					informeValorado.setPeriodo(Integer.parseInt( periodoInforme));
					informeValorado.setTipoValoracion(Constantes.ESTADO_CALIFICADO);
					informeValorado.setIdentificador(identificadorResponsable);
					if (observacion != "") {
						informeValorado.setComentario(observacion);
					}
					informeValorado.setNota((float) nota);
					informeValorado.setVerificador(Constantes.ESTADO);
					ivs.guardarInformeValorado(informeValorado);

					TblAsignacion informe = as.buscarInformeAsignado(infcod);

					as.actualizarEstadoInformeAsignado(informe.getIdAsignacion(), Constantes.ESTADO_CALIFICADO);

				}
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
				
			} else {

				mensaje.put("estado", "error");
				mensaje.put("mensaje", "Este informe ya fue calificado!");

			}

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

}
