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
import org.springframework.web.bind.annotation.ControllerAdvice;
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
@ControllerAdvice
@RequestMapping("/view/rendicion/valoracion")
public class ValoracionInformeFEController {
	
	@Autowired
	private InformeServicio is;
	@Autowired
	private UsuarioServicio us;
	@Autowired
	private AsignacionServicio as;
	@Autowired
	private InformeValoradoService ivs;
	@Autowired
	private InformeCalificacionService ics;
	

	int i = 0;
	static Integer periodo=0; 
	
	public TblInformeCalificado getInformeCalificado(Integer infCod, Integer idInforme) {
		
		if(idInforme != null) {
			return ics.ObtenerListaPregunstas(infCod)
				.stream()
				.filter(informe -> informe.getIdInfCal().equals(idInforme))
				//.peek(System.out::println)
				.collect(Collectors.toList()).get(0);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "valoracionInformeFE", method = RequestMethod.POST)
	public String valoracionInformeFE(Model model, Authentication authentication,
			@RequestParam("id") String infcodPeriodo 
			) {
		// separamos id y periodo
		String[] parts = infcodPeriodo.split("-");
		
		Integer infcod = Integer.parseInt(parts[0]); // id del informe
		Integer periodo = Integer.parseInt(parts[1]); // periodo
		model.addAttribute("email", authentication.getName());
		List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, periodo);
		TblUsuario datosUsuarioInterno = us.BuscarUsuarioEmailXperido(authentication.getName(),  Constantes.periodo());
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
		model.addAttribute("periodoSeleccionado",periodo);
		
		i = 1;

		ics.ObtenerListaPregunstas(infcod).forEach(detalleInforme -> {
			model.addAttribute("detalle" + i, detalleInforme);
			i++;
		});
		
		return "rendicion/valoracion/valoracionInformeFE";
	}
	
	/*@GetMapping("guardarEvaluacion")
	public String accesoNoAutorizadoguardarEvaluacion(TblInformeCalificado tblInformeCalificado) {
		return "redirect:../../index";
	}*/

	private static void informeCalificado1(TblInformeCalificado informeCalificado, Integer infcod, String cmbpregunta1) {
		 float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("ESTADO INFORME");
		informeCalificado.setPregunta(
				"¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO "
						+ periodo + "?");
		informeCalificado.setRespuesta(cmbpregunta1);
		if (cmbpregunta1.equals("SI")) {
			informeCalificado.setNota((float) 16.67);
			nota = (float) 16.67;
		} else {
			informeCalificado.setNota((float) 0.00);
			nota = (float) nota;//(float) 0.00;
		}
		informeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
		informeCalificado.setPeriodo(periodo);
		informeCalificado.setEvidencia("N/A");
		
		//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado2(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta2, String rutaArchivo1) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("CUMPLIMIENTO DE LA EJECUCIÓN PRESUPUESTARIA");
		 informeCalificado.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?");
		 informeCalificado.setRespuesta(cmbPregunta2);
			switch (cmbPregunta2) {
			case "1. CÉDULA PRESUPUESTARIA DEL MINISTERIO DE FINANZAS":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA1);
				break;
			case "2. INFORME DE GESTIÓN FINANCIERA APROBADO POR AUTORIDAD COMPETENTE":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA2);

				break;
			case "3. MATRIZ DE LOTAIP QUE SI DIRECCIONA A LA CÉDULA PRESUPUESTARIA":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA3);

				break;
			case "4. EOD: INFORME OFICIAL DE EJECUCIÓN PRESUPUESTARIA QUE CONTENGA SU CÉDULA PRESUPUESTARIA/ DETALLE DE EJECUCIÓN PRESUPUESTARIA":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA4);

				break;
			case "5. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD): NO APLICA":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
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
			//case "8. RESPONDE EN 0":
			case "8. NO APLICA":
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
			if (!rutaArchivo1.isEmpty()) {
				informeCalificado.setEvidencia(rutaArchivo1);
			}else {
				if("10. VACÍO".equals(cmbPregunta2) || "8. NO APLICA".equals(cmbPregunta2)) {
					informeCalificado.setEvidencia("N/A");
				} else {
					informeCalificado.setEvidencia(null);
				}
				
			}
			
			//ics.guardarInformeCalificacion(informeCalificado); 
	}
	
	private static void informeCalificado3(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta3, String rutaArchivo2 ) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("PROCESOS DE CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS");
		 informeCalificado.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?");
		 informeCalificado.setRespuesta(cmbPregunta3);
			switch (cmbPregunta3) {
			case "1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA1);
				break;
			case "2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA2);

				break;
			case "3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA3);

				break;
			case "4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA)":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA4);

				break;
			case "5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA5);

				break;
			case "6. EOD: PRESENTA UN INFORME OFICIAL DE CONTRATACIONES PÚBLICAS, QUE CONTENGA EL DETALLE DE LOS PROCESOS DEL AÑO":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA6);

				break;
			case "7. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA7);

				break;
			case "8. NO ABRE EL LINK":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA8);

				break;
			case "9. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA9);

				break;
			case "10. RESPONDE EN 0":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA10);

				break;
			case "11. OTROS, NO CUMPLE":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA11);

				break;
			case "12. VACÍO":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA12);

				break;
			}

			informeCalificado.setPeriodo(periodo);
			if (!rutaArchivo2.isEmpty()) {
				informeCalificado.setEvidencia(rutaArchivo2);
			}else {
				if("10. VACÍO".equals(cmbPregunta3) || "8. NO APLICA".equals(cmbPregunta3)) {
					informeCalificado.setEvidencia("N/A");
				} else {
					informeCalificado.setEvidencia(null);
				}
			}
		
			//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado4(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta4, String rutaArchivo3) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("MECANISMOS DE PARTICIPACIÓN CIUDADANA");
		 informeCalificado
					.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?");
		 informeCalificado.setRespuesta(cmbPregunta4);
			switch (cmbPregunta4) {
			case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA1);
				break;
			case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE ASISTENCIAS":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA2);
				break;
			case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
				informeCalificado.setNota((float) 8.34);
				nota = nota + (float) 8.34;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA3);
				break;
			case "4. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA4);
				break;
			case "5. NO ABRE EL LINK":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA5);
				break;
			case "6. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA6);
				break;
			case "7. NO APLICA":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA7);
				break;
			case "8. OTROS, NO CUMPLE":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA8);
				break;
			case "9. VACÍO":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA9);
				break;
			}

			informeCalificado.setPeriodo(periodo);
			if(!rutaArchivo3.isEmpty()) {
				informeCalificado.setEvidencia(rutaArchivo3);
			}else {
				if("10. VACÍO".equals(cmbPregunta4) || "8. NO APLICA".equals(cmbPregunta4)) {
					informeCalificado.setEvidencia("N/A");
				} else {
					informeCalificado.setEvidencia(null);
				}
			}
			//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado5(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta5, String rutaArchivo4) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
		 informeCalificado.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DEL ESPACIO DELIBERATIVO?");
		 informeCalificado.setRespuesta(cmbPregunta5);
			switch (cmbPregunta5) {
			case "1. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA SI PARTICIPÓ":
				informeCalificado.setNota((float) 8.33);
				nota = nota + (float) 8.33;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA1);
				break;
			case "2. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO Y LOS APORTES CIUDADANOS":
				informeCalificado.setNota((float) 8.33);
				nota = nota + (float) 8.33;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA2);
				break;
			case "3. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA":
				informeCalificado.setNota((float) 8.33);
				nota = nota + (float) 8.33;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA3);
				break;
			case "4. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA NO PARTICIPÓ":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA4);
				break;
			case "5. NO ABRE EL LINK":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA5);
				break;
			case "6. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA6);
				break;
			case "7. NO APLICA":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA7);
				break;
			case "8. OTROS, NO CUMPLE":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA8);
				break;
			case "9. VACÍO":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA9);
				break;
			}

			informeCalificado.setPeriodo(periodo);
			if(!rutaArchivo4.isEmpty()) {
				informeCalificado.setEvidencia(rutaArchivo4);
			}else {
				if("9. VACÍO".equals(cmbPregunta5) || "7. NO APLICA".equals(cmbPregunta5)) {
					informeCalificado.setEvidencia("N/A");
				} else {
					informeCalificado.setEvidencia(null);
				}
			}
			//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado6(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta6, String rutaArchivo5) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
		 informeCalificado
					.setPregunta("¿LA ENTIDAD SUSTENTA LA GENERACIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?");
		 informeCalificado.setRespuesta(cmbPregunta6);
			switch (cmbPregunta6) {
			case "1. ACTA DE REALIZACIÓN DEL	EVENTO QUE CONTENGA LOS APORTES CIUDADANOS QUE SE GENERARON EN ESE ESPACIO":
				informeCalificado.setNota((float) 8.33);
				nota = nota + (float) 8.33;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
				break;
			case "2. ACTA DE REALIZACIÓN DEL	EVENTO QUE RECONOCE QUE NO HUBIERON APORTES/ACUERDOS":
				informeCalificado.setNota((float) 8.33);
				nota = nota + (float) 8.33;
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
			if(!rutaArchivo5.equals("")) {
				informeCalificado.setEvidencia(rutaArchivo5);
			}else {
				if("7. VACÍO".equals(cmbPregunta6) || "5. NO APLICA".equals(cmbPregunta6)) {
					informeCalificado.setEvidencia("N/A");
				} else {
					informeCalificado.setEvidencia(null);
				}
			}
			
			//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado7(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta7, String rutaArchivo6){
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz(
					"INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO	ANTERIOR");
		 informeCalificado.setPregunta(
					"¿LA ENTIDAD SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?");
		 informeCalificado.setRespuesta(cmbPregunta7);
			switch (cmbPregunta7) {
			case "1. ACTA, INFORME O DOCUMENTO OFICIAL QUE DEMUESTRA LA IMPLEMENTACIÓN":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
				break;
			case "2. NO APLICA, PORQUE SE CREA EN EL AÑO DE RENDICIÓN DE CUENTAS":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA2);
				break;
			case "3. NO APLICA, PORQUE EL PROCESO ANTERIOR NO RECIBIÓ APORTES":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA3);
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
			case "6. NO APLICA":
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
			if(!rutaArchivo6.isEmpty()) {
				informeCalificado.setEvidencia(rutaArchivo6);
			}else {
				if("10. VACÍO".equals(cmbPregunta7) || "8. NO APLICA".equals(cmbPregunta7)) {
					informeCalificado.setEvidencia("N/A");
				} else {
					informeCalificado.setEvidencia(null);
				}
			}
			
			//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado8(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta8) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("MECANISMOS DE CONTROL SOCIAL");
		 informeCalificado
					.setPregunta("¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?");
			informeCalificado.setRespuesta(cmbPregunta8);
			switch (cmbPregunta8) {
			case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA1);
				break;
			case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE	ASISTENCIAS":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA2);
				break;
			case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
				informeCalificado.setNota((float) 8.34);
				nota = nota + (float) 8.34;
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
			//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado9(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta9) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
		 informeCalificado
					.setPregunta("¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?");
		 informeCalificado.setRespuesta(cmbPregunta9);
			switch (cmbPregunta9) {
			case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
				informeCalificado.setNota((float) 3.33);
				nota = nota + (float) 3.33;
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
			//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado10(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta10) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
			informeCalificado
					.setPregunta("¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?");
			informeCalificado.setRespuesta(cmbPregunta10);
			switch (cmbPregunta10) {
			case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
				informeCalificado.setNota((float) 3.33);
				nota = nota + (float) 3.33;
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
			//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado11(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta11) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
		 informeCalificado.setPregunta(
					"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?");
		 informeCalificado.setRespuesta(cmbPregunta11);
			switch (cmbPregunta11) {
			case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
				informeCalificado.setNota((float) 3.33);
				nota = nota + (float) 3.33;
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
			//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado12(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta12) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
		 informeCalificado.setPregunta(
					"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?");
		 informeCalificado.setRespuesta(cmbPregunta12);
			switch (cmbPregunta12) {
			case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
				informeCalificado.setNota((float) 3.33);
				nota = nota + (float) 3.33;
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
			//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	private static void informeCalificado13(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta13) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
		 informeCalificado.setPregunta(
					"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?");
		 informeCalificado.setRespuesta(cmbPregunta13);
			switch (cmbPregunta13) {
			case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
				informeCalificado.setNota((float) 3.33);
				nota = nota + (float) 3.33;
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
			//ics.guardarInformeCalificacion(informeCalificado);
	}
	
	

	@SuppressWarnings("finally")
	@RequestMapping(value = "/guardarEvaluacion")
	public @ResponseBody String guardarEvaluacion(HttpServletRequest request,
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
			@RequestParam(value = "finInforme", required = false) String finInforme,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, 
			@RequestParam("cmbpregunta1") String cmbpregunta1,
			@RequestParam("cmbPregunta2") String cmbPregunta2, 
			@RequestParam("rutaArchivo1") String rutaArchivo1,
			@RequestParam("cmbPregunta3") String cmbPregunta3, 
			@RequestParam("rutaArchivo2") String rutaArchivo2,
			@RequestParam("cmbPregunta4") String cmbPregunta4, 
			@RequestParam("rutaArchivo3") String rutaArchivo3,
			@RequestParam("cmbPregunta5") String cmbPregunta5, 
			@RequestParam("cmbPregunta6") String cmbPregunta6,
			@RequestParam("rutaArchivo4") String rutaArchivo4, 
			@RequestParam("cmbPregunta7") String cmbPregunta7,
			@RequestParam("rutaArchivo5") String rutaArchivo5, 
			@RequestParam("cmbPregunta8") String cmbPregunta8,
			@RequestParam("rutaArchivo6") String rutaArchivo6, 
		    @RequestParam("cmbPregunta9") String cmbPregunta9,
			@RequestParam("cmbPregunta10") String cmbPregunta10, 
			@RequestParam("cmbPregunta11") String cmbPregunta11,
			@RequestParam("cmbPregunta12") String cmbPregunta12, 
			@RequestParam("cmbPregunta13") String cmbPregunta13,
			@RequestParam("observacion") String observacion,
			@RequestParam("periodoInforme") String periodoInforme) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		
		try {
			periodo=Integer.parseInt(periodoInforme);
			
			List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, Integer.parseInt(periodoInforme));
			//List<Object[]> registrosInformesValorados = ivs.obtenerRegistrosInformesValorados();
			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);

			if (datosInformeValorado.size() == 0) {
				
				TblInformeCalificado tblInformeCalificado = getInformeCalificado(infcod,id_informe_1);
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

				if (tblInformeCalificado == null && tblInformeCalificado2 == null && tblInformeCalificado3 == null
						&& tblInformeCalificado4 == null && tblInformeCalificado5 == null
						&& tblInformeCalificado6 == null && tblInformeCalificado7 == null
						&& tblInformeCalificado8 == null && tblInformeCalificado9 == null
						&& tblInformeCalificado10 == null && tblInformeCalificado11 == null
						&& tblInformeCalificado12 == null && tblInformeCalificado13 == null) {

					tblInformeCalificado = new TblInformeCalificado();
					informeCalificado1(tblInformeCalificado, infcod, cmbpregunta1);

					tblInformeCalificado2 = new TblInformeCalificado();
					informeCalificado2(tblInformeCalificado2, infcod, cmbPregunta2, rutaArchivo1);

					tblInformeCalificado3 = new TblInformeCalificado();
					informeCalificado3(tblInformeCalificado3, infcod, cmbPregunta3, rutaArchivo2);

					tblInformeCalificado4 = new TblInformeCalificado();
					informeCalificado4(tblInformeCalificado4, infcod, cmbPregunta4, rutaArchivo3);

					tblInformeCalificado5 = new TblInformeCalificado();
					informeCalificado5(tblInformeCalificado5, infcod, cmbPregunta5, rutaArchivo4);

					tblInformeCalificado6 = new TblInformeCalificado();
					informeCalificado6(tblInformeCalificado6, infcod, cmbPregunta6, rutaArchivo5);

					tblInformeCalificado7 = new TblInformeCalificado();
					informeCalificado7(tblInformeCalificado7, infcod, cmbPregunta7, rutaArchivo6);

					tblInformeCalificado8 = new TblInformeCalificado();
					informeCalificado8(tblInformeCalificado8, infcod, cmbPregunta8);

					tblInformeCalificado9 = new TblInformeCalificado();
					informeCalificado9(tblInformeCalificado9, infcod, cmbPregunta9);

					tblInformeCalificado10 = new TblInformeCalificado();
					informeCalificado10(tblInformeCalificado10, infcod, cmbPregunta10);

					tblInformeCalificado11 = new TblInformeCalificado();
					informeCalificado11(tblInformeCalificado11, infcod, cmbPregunta11);

					tblInformeCalificado12 = new TblInformeCalificado();
					informeCalificado12(tblInformeCalificado12, infcod, cmbPregunta12);

					tblInformeCalificado13 = new TblInformeCalificado();
					informeCalificado13(tblInformeCalificado13, infcod, cmbPregunta13);

				} else {
					if (tblInformeCalificado.getIdInfCal().equals(id_informe_1)) {
						informeCalificado1(tblInformeCalificado, infcod, cmbpregunta1);
					}
					if (tblInformeCalificado2.getIdInfCal().equals(id_informe_2)) {
						informeCalificado2(tblInformeCalificado2, infcod, cmbPregunta2, rutaArchivo1);
					}
					if (tblInformeCalificado3.getIdInfCal().equals(id_informe_3)) {
						informeCalificado3(tblInformeCalificado3, infcod, cmbPregunta3, rutaArchivo2);
					}
					if (tblInformeCalificado4.getIdInfCal().equals(id_informe_4)) {
						informeCalificado4(tblInformeCalificado4, infcod, cmbPregunta4, rutaArchivo3);
					}
					if (tblInformeCalificado5.getIdInfCal().equals(id_informe_5)) {
						informeCalificado5(tblInformeCalificado5, infcod, cmbPregunta5, rutaArchivo4);
					}
					if (tblInformeCalificado6.getIdInfCal().equals(id_informe_6)) {
						informeCalificado6(tblInformeCalificado6, infcod, cmbPregunta6, rutaArchivo5);
					}
					if (tblInformeCalificado7.getIdInfCal().equals(id_informe_7)) {
						informeCalificado7(tblInformeCalificado7, infcod, cmbPregunta7, rutaArchivo6);
					}
					if (tblInformeCalificado8.getIdInfCal().equals(id_informe_8)) {
						informeCalificado8(tblInformeCalificado8, infcod, cmbPregunta8);
					}
					if (tblInformeCalificado9.getIdInfCal().equals(id_informe_9)) {
						informeCalificado9(tblInformeCalificado9, infcod, cmbPregunta9);
					}
					if (tblInformeCalificado10.getIdInfCal().equals(id_informe_10)) {
						informeCalificado10(tblInformeCalificado10, infcod, cmbPregunta10);
					}
					if (tblInformeCalificado11.getIdInfCal().equals(id_informe_11)) {
						informeCalificado11(tblInformeCalificado11, infcod, cmbPregunta11);
					}
					if (tblInformeCalificado12.getIdInfCal().equals(id_informe_12)) {
						informeCalificado12(tblInformeCalificado12, infcod, cmbPregunta12);
					}
					if (tblInformeCalificado13.getIdInfCal().equals(id_informe_13)) {
						informeCalificado13(tblInformeCalificado13, infcod, cmbPregunta13);
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

				if(finInforme == "FINALIZAR" || finInforme.equals("FINALIZAR") ) {
				
					TblValoracion informeValorado = new TblValoracion();
					float nota = (float) 00.00;
					informeValorado.setInstiCod(Integer.parseInt(datosInstitucion.get(0)[10].toString()));
					informeValorado.setInfCod(infcod);
					informeValorado.setFechaValoracion(new Date());
					informeValorado.setPeriodo(periodo);
					informeValorado.setTipoValoracion(Constantes.ESTADO_CALIFICADO);
					informeValorado.setIdentificador(identificadorResponsable);
					if(observacion!="") {
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
