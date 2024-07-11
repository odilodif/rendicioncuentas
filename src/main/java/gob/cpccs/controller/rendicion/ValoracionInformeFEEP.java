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
import gob.cpccs.service.GraficaService;
import gob.cpccs.service.rendicion.InformeServicio;
import gob.cpccs.service.retroalimentacion.AsignacionServicio;
import gob.cpccs.service.retroalimentacion.InformeCalificacionService;
import gob.cpccs.service.retroalimentacion.InformeValoradoService;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;

@Controller
@RequestMapping("/view/rendicion/valoracion")
public class ValoracionInformeFEEP {
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
	int i = 0;
	@RequestMapping(value = "valoracionInformeFEEP", method = RequestMethod.POST)
	public String valoracionInformeFEEP(Model model, Authentication authentication,
			@RequestParam("id") String infcodPeriodo) {
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
		i=1;
		ics.ObtenerListaPregunstasXorden(infcod).forEach(

				detalleInforme -> {
					switch (detalleInforme.getOrden()) 
					{
					case 1:
					model.addAttribute("detalle1",detalleInforme);
					break;
					case 2:
						model.addAttribute("detalle2",detalleInforme);
						break;
				    case 3:
					model.addAttribute("detalle3",detalleInforme);
					break;
				    case 4:
						model.addAttribute("detalle4",detalleInforme);
						break;
				    case 5:
						model.addAttribute("detalle5",detalleInforme);
						break;
				    case 6:
						model.addAttribute("detalle6",detalleInforme);
						break;
				    case 7:
						model.addAttribute("detalle7",detalleInforme);
						break;
						case 8:
							model.addAttribute("detalle8",detalleInforme);
							break;
					    case 9:
						model.addAttribute("detalle9",detalleInforme);
						break;
					    case 10:
							model.addAttribute("detalle10",detalleInforme);
							break;
					    case 11:
							model.addAttribute("detalle11",detalleInforme);
							break;
					    case 12:
							model.addAttribute("detalle12",detalleInforme);
							break;
					    case 13:
							model.addAttribute("detalle13",detalleInforme);
							break;
					    case 14:
							model.addAttribute("detalle14",detalleInforme);
							break;
					    case 15:
							model.addAttribute("detalle15",detalleInforme);
							break;
					    case 16:
							model.addAttribute("detalle16",detalleInforme);
							break;
				}	
				});
		return "rendicion/valoracion/valoracionInformeFEEP";
	}
	private TblInformeCalificado getInformeCalificado(Integer infcod, Integer idInforme) {
		
		if(idInforme != null) {
			return ics.ObtenerListaPregunstas(infcod)
				.stream()
				//.peek(System.out::println)
				.filter(informe -> informe.getIdInfCal().equals(idInforme))
				//.peek(System.out::println)
				.collect(Collectors.toList()).get(0);
		} else {
			return null;
		}
	}
	private static void informeCalificado1(TblInformeCalificado informeCalificado, Integer infcod, String cmbpregunta1,Integer periodo) {
		 float nota = (float) 00.00;
		informeCalificado.setInfCod(infcod);
		informeCalificado.setMatriz("ESTADO INFORME");
		informeCalificado.setOrden(1);
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
		
		//ics.guardarInformeCalificacion(tblInformeCalificado);
	}
	
	private static void informeCalificado2(TblInformeCalificado informeCalificado2, Integer infcod, String cmbPregunta2, String rutaArchivo1,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado2.setInfCod(infcod);
		 informeCalificado2.setMatriz("CUMPLIMIENTO DE LA EJECUCIÓN PRESUPUESTARIA");
		 informeCalificado2.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?");
		 informeCalificado2.setOrden(2);
		 informeCalificado2.setRespuesta(cmbPregunta2);
			switch (cmbPregunta2) {
			case "1. CÉDULA PRESUPUESTARIA DEL MINISTERIO DE FINANZAS":
				informeCalificado2.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA1);
				break;
			case "2. INFORME DE GESTIÓN FINANCIERA APROBADO POR AUTORIDAD COMPETENTE":
				informeCalificado2.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA2);

				break;
			case "3. MATRIZ DE LOTAIP QUE SI DIRECCIONA A LA CÉDULA PRESUPUESTARIA":
				informeCalificado2.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA3);

				break;
			case "4. EOD: INFORME OFICIAL DE EJECUCIÓN PRESUPUESTARIA QUE CONTENGA SU CÉDULA PRESUPUESTARIA/ DETALLE DE EJECUCIÓN PRESUPUESTARIA":
				informeCalificado2.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA4);

				break;
			case "5. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD): NO APLICA":
				informeCalificado2.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA5);

				break;
			case "6. NO ABRE EL LINK":
				informeCalificado2.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA6);

				break;
			case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
				informeCalificado2.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA7);

				break;
			//case "8. RESPONDE EN 0":
			case "8. NO APLICA":
				informeCalificado2.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA8);

				break;
			case "9. OTROS, NO CUMPLE":
				informeCalificado2.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA9);

				break;
			case "10. VACÍO":
				informeCalificado2.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA10);

				break;
			}

			informeCalificado2.setPeriodo(periodo);
			if (rutaArchivo1!="") {
				informeCalificado2.setEvidencia(rutaArchivo1);
			}else {
				informeCalificado2.setEvidencia("N/A");
			}
			
			//ics.guardarInformeCalificacion(tblInformeCalificado2); 
	}
	private static void informeBalance(TblInformeCalificado informeBalance, Integer infcod, String cmbPregunta3, String rutaArchivo2,Integer periodo) {
		 float nota = (float) 00.00;
		 informeBalance.setInfCod(infcod);
		 informeBalance.setMatriz("BALANCE GENERAL");
		 informeBalance.setPregunta("¿LA EMPRESA PÚBLICA PRESENTA SU BALANCE GENERAL?");
		 informeBalance.setRespuesta(cmbPregunta3);
		 informeBalance.setOrden(3);
			switch (cmbPregunta3) {
			case "1. BALANCE GENERAL":
				informeBalance.setNota((float) 12.50);
				nota = nota + (float) 12.50;
				informeBalance.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA1);
				break;

			case "2. NO ABRE EL LINK":
				informeBalance.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeBalance.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA2);

				break;
			case "3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
				informeBalance.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeBalance.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA3);

				break;
			case "4. RESPONDE EN 0":
				informeBalance.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeBalance.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA4);

				break;
			case "5. OTROS, NO CUMPLE":
				informeBalance.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeBalance.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA5);

				break;
			case "6. VACÍO":
				informeBalance.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeBalance.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA6);

				break;
			}

			informeBalance.setPeriodo(periodo);
			if(rutaArchivo2!="") {
				informeBalance.setEvidencia(rutaArchivo2);
			}else {
				informeBalance.setEvidencia("N/A");
			}
			//ics.guardarInformeCalificacion(tblInformeCalificado2); 
	}
	private static void informeCalificado3(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta3, String rutaArchivo2,Integer periodo ) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("PROCESOS DE CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS");
		 informeCalificado.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?");
		 informeCalificado.setRespuesta(cmbPregunta3);
		 informeCalificado.setOrden(4);
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
			if (rutaArchivo2!="") {
				informeCalificado.setEvidencia(rutaArchivo2);
			}else {
				informeCalificado.setEvidencia("N/A");
			}
			//ics.guardarInformeCalificacion(tblInformeCalificado3);
	}
	 private static void informeCumplimientoObligacionesIESS(TblInformeCalificado tblInformeCalificadoobligacioiess, Integer infcod, String cmbPregunta, String rutaArchivo,Integer periodo ) {
		 float nota = (float) 00.00;
		 tblInformeCalificadoobligacioiess.setInfCod(infcod);
		 tblInformeCalificadoobligacioiess.setMatriz("CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS Y LABORALES");
		 tblInformeCalificadoobligacioiess.setPregunta(
					"¿LA EMPRESA PÚBLICA PRESENTA INFORMACIÓN DE CUMPLIMIENTO DE OBLIGACIONES LABORALES?");
		 tblInformeCalificadoobligacioiess.setRespuesta(cmbPregunta);
		 tblInformeCalificadoobligacioiess.setOrden(6);
			switch (cmbPregunta) {
			case "1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL IESS":
				tblInformeCalificadoobligacioiess.setNota((float) 6.25);
				nota = nota + (float) 6.25;
				tblInformeCalificadoobligacioiess.setRespuestaInstitucion(Constantes.FEEP_P6_RESPUESTA1);
				break;
			case "2. NO ABRE EL LINK":
				tblInformeCalificadoobligacioiess.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				tblInformeCalificadoobligacioiess.setRespuestaInstitucion(Constantes.FEEP_P6_RESPUESTA3);
				break;
			case "3. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
				tblInformeCalificadoobligacioiess.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				tblInformeCalificadoobligacioiess.setRespuestaInstitucion(Constantes.FEEP_P6_RESPUESTA3);
				break;
			case "4. NO APLICA":
				tblInformeCalificadoobligacioiess.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				tblInformeCalificadoobligacioiess.setRespuestaInstitucion(Constantes.FEEP_P6_RESPUESTA4);
				break;
			case "5. OTROS, NO CUMPLE":
				tblInformeCalificadoobligacioiess.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				tblInformeCalificadoobligacioiess.setRespuestaInstitucion(Constantes.FEEP_P6_RESPUESTA5);
				break;
			case "6. VACÍO":
				tblInformeCalificadoobligacioiess.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				tblInformeCalificadoobligacioiess.setRespuestaInstitucion(Constantes.FEEP_P6_RESPUESTA6);
				break;
			}

			tblInformeCalificadoobligacioiess.setPeriodo(periodo);
			if(rutaArchivo!="") {
				tblInformeCalificadoobligacioiess.setEvidencia(rutaArchivo);
			}else {
				tblInformeCalificadoobligacioiess.setEvidencia("N/A");
			}
	 }
	 private static void informeCumplimientoObligacionesSRI(TblInformeCalificado tblInformeCalificadoobligaciones, Integer infcod, String cmbPregunta, String rutaArchivo,Integer periodo ) {
		 float nota = (float) 00.00;
		 tblInformeCalificadoobligaciones.setInfCod(infcod);
		 tblInformeCalificadoobligaciones.setMatriz("CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS Y LABORALES");
		 tblInformeCalificadoobligaciones.setPregunta("¿LA EMPRESA PÚBLICA PRESENTA INFORMACIÓN DE CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS?");
		 tblInformeCalificadoobligaciones.setRespuesta(cmbPregunta);
		 tblInformeCalificadoobligaciones.setOrden(5);
		 switch (cmbPregunta) {
			case "1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL SRI":
				tblInformeCalificadoobligaciones.setNota((float) 6.25);
				nota = nota + (float) 6.25;
				tblInformeCalificadoobligaciones.setRespuestaInstitucion(Constantes.FEEP_P5_RESPUESTA1);
				break;
			case "2. CERTIFICADO EMITIDO POR SRI Y SENAE":
				tblInformeCalificadoobligaciones.setNota((float) 6.25);
				nota = nota + (float) 6.25;
				tblInformeCalificadoobligaciones.setRespuestaInstitucion(Constantes.FEEP_P5_RESPUESTA2);
				break;
			case "3. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA NO PARTICIPÓ":
				tblInformeCalificadoobligaciones.setNota((float) 6.25);
				nota = nota + (float) 6.25;
				tblInformeCalificadoobligaciones.setRespuestaInstitucion(Constantes.FEEP_P5_RESPUESTA3);
				break;
			case "4. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
				tblInformeCalificadoobligaciones.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				tblInformeCalificadoobligaciones.setRespuestaInstitucion(Constantes.FEEP_P5_RESPUESTA4);
				break;
			case "5. NO APLICA":
				tblInformeCalificadoobligaciones.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				tblInformeCalificadoobligaciones.setRespuestaInstitucion(Constantes.FEEP_P5_RESPUESTA5);
				break;
			case "6. OTROS, NO CUMPLE":
				tblInformeCalificadoobligaciones.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				tblInformeCalificadoobligaciones.setRespuestaInstitucion(Constantes.FEEP_P5_RESPUESTA6);
				break;
			case "7. VACÍO":
				tblInformeCalificadoobligaciones.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				tblInformeCalificadoobligaciones.setRespuestaInstitucion(Constantes.FEEP_P5_RESPUESTA7);
				break;
			}

			tblInformeCalificadoobligaciones.setPeriodo(periodo);
			if(rutaArchivo!="") {
				tblInformeCalificadoobligaciones.setEvidencia(rutaArchivo);
			}else {
				tblInformeCalificadoobligaciones.setEvidencia("N/A");
			}
	 }
	private static void informeCalificadoMParticipacion(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta, String rutaArchivo,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("MECANISMOS DE PARTICIPACIÓN CIUDADANA");
		 informeCalificado
					.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?");
		 informeCalificado.setRespuesta(cmbPregunta);
		 informeCalificado.setOrden(7);
			switch (cmbPregunta) {
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
			if(rutaArchivo!="") {
				informeCalificado.setEvidencia(rutaArchivo);
			}else {
				informeCalificado.setEvidencia("N/A");
			}
	}
	
	private static void informeCalificado5(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta5, String rutaArchivo,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
		 informeCalificado.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DEL ESPACIO DELIBERATIVO?");
		 informeCalificado.setRespuesta(cmbPregunta5);
		 informeCalificado.setOrden(8);
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
			if(rutaArchivo!="") {
				informeCalificado.setEvidencia(rutaArchivo);
			}else {
				informeCalificado.setEvidencia("N/A");
			}
			//ics.guardarInformeCalificacion(tblInformeCalificado5);
	}
	
	private static void informeCalificado6(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta6, String rutaArchivo4,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
		 informeCalificado
					.setPregunta("¿LA ENTIDAD SUSTENTA LA GENERACIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?");
		 informeCalificado.setRespuesta(cmbPregunta6);
		 informeCalificado.setOrden(9);
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
			if(rutaArchivo4!="") {
				informeCalificado.setEvidencia(rutaArchivo4);
			}else {
				informeCalificado.setEvidencia("N/A");
			}
			
			//ics.guardarInformeCalificacion(tblInformeCalificado6);
	}
	
	private static void informeCalificado7(TblInformeCalificado informeCalificadoic, Integer infcod, String cmbPregunta7, String rutaArchivo,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificadoic.setInfCod(infcod);
		 informeCalificadoic.setMatriz("INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO	ANTERIOR");
		 informeCalificadoic.setPregunta(
					"¿LA ENTIDAD SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?");
		 informeCalificadoic.setRespuesta(cmbPregunta7);
		 informeCalificadoic.setOrden(10);
			switch (cmbPregunta7) {
			case "1. ACTA, INFORME O DOCUMENTO OFICIAL QUE DEMUESTRA LA IMPLEMENTACIÓN":
				informeCalificadoic.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificadoic.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
				break;
			case "2. NO APLICA, PORQUE SE CREA EN EL AÑO DE RENDICIÓN DE CUENTAS":
				informeCalificadoic.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificadoic.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA2);
				break;
			case "3. NO APLICA, PORQUE EL PROCESO ANTERIOR NO RECIBIÓ APORTES":
				informeCalificadoic.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificadoic.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA3);
				break;
			case "4. NO ABRE EL LINK":
				informeCalificadoic.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificadoic.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
				break;
			case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
				informeCalificadoic.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificadoic.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
				break;
			case "6. NO APLICA":
				informeCalificadoic.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificadoic.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
				break;
			case "7. OTROS, NO CUMPLE":
				informeCalificadoic.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificadoic.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
				break;
			case "8. VACÍO":
				informeCalificadoic.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificadoic.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
				break;
			}

			informeCalificadoic.setPeriodo(periodo);
			if(rutaArchivo!="") {
				informeCalificadoic.setEvidencia(rutaArchivo);
			}else {
				informeCalificadoic.setEvidencia("N/A");
			}
			
			//ics.guardarInformeCalificacion(tblInformeCalificado7);
	}
	
	private static void informeCalificado8(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta8,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("MECANISMOS DE CONTROL SOCIAL");
		 informeCalificado
					.setPregunta("¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?");
			informeCalificado.setRespuesta(cmbPregunta8);
			informeCalificado.setOrden(11);
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
			informeCalificado.setEvidencia("N/A");
	}
	
	private static void informeCalificadoPIGenero(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta9,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
		 informeCalificado
					.setPregunta("¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?");
		 informeCalificado.setRespuesta(cmbPregunta9);
		 informeCalificado.setOrden(15);
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
			informeCalificado.setEvidencia("N/A");
			//ics.guardarInformeCalificacion(tblInformeCalificado9);
	}
	
	private static void informeCalificadoPIGeneracional(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta,Integer periodo)
	{
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
		 informeCalificado.setPregunta("¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?");
		 informeCalificado.setRespuesta(cmbPregunta);
		 informeCalificado.setOrden(13);
		 
			switch (cmbPregunta) {
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
			informeCalificado.setEvidencia("N/A");
		    informeCalificado.setPeriodo(periodo);
	}
	private static void informeCalificadoPIDiscapacidades(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
		 informeCalificado.setPregunta("¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?");
		 informeCalificado.setRespuesta(cmbPregunta);
		 informeCalificado.setOrden(14);
			switch (cmbPregunta) {
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
			informeCalificado.setEvidencia("N/A");
	}
	
	private static void informeCalificadoPIIntercultural(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta12,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
		 informeCalificado.setPregunta(
					"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?");
		 informeCalificado.setRespuesta(cmbPregunta12);
		 informeCalificado.setOrden(12);
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
			informeCalificado.setEvidencia("N/A");
			//ics.guardarInformeCalificacion(tblInformeCalificado12);
	}
	
	private static void informeCalificadoPIMHumana(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta13,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
		 informeCalificado.setPregunta("¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?");
		 informeCalificado.setOrden(16);
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
			informeCalificado.setEvidencia("N/A");
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "guardarEvaluacionFEEP")
	public @ResponseBody String guardarEvaluacionFEEP(HttpServletRequest request,
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
			@RequestParam(value = "matriz", required = false) Integer matriz,
			Model model,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, @RequestParam(value ="cmbpregunta1", required = false) String cmbpregunta1,
			@RequestParam(value ="cmbPregunta2", required = false) String cmbPregunta2, @RequestParam(value ="rutaArchivo1", required = false) String rutaArchivo1,
			@RequestParam(value ="cmbPregunta3", required = false) String cmbPregunta3, @RequestParam(value ="rutaArchivo2", required = false) String rutaArchivo2,
			@RequestParam(value ="cmbPregunta4", required = false) String cmbPregunta4, @RequestParam(value ="rutaArchivo3", required = false) String rutaArchivo3,
			@RequestParam(value ="cmbPregunta5", required = false) String cmbPregunta5, @RequestParam(value ="cmbPregunta6", required = false) String cmbPregunta6,
			@RequestParam(value ="rutaArchivo4", required = false) String rutaArchivo4, @RequestParam(value ="cmbPregunta7", required = false) String cmbPregunta7,
			@RequestParam(value ="rutaArchivo5", required = false) String rutaArchivo5, @RequestParam(value ="cmbPregunta8", required = false)String cmbPregunta8,
		    @RequestParam(value ="cmbPregunta9", required = false) String cmbPregunta9,
			@RequestParam(value ="cmbPregunta10", required = false) String cmbPregunta10, @RequestParam(value ="cmbPregunta11", required = false) String cmbPregunta11,
			@RequestParam(value ="cmbPregunta12", required = false) String cmbPregunta12, @RequestParam(value ="cmbPregunta13", required = false) String cmbPregunta13,
			@RequestParam(value ="cmbPregunta14", required = false) String cmbPregunta14,@RequestParam(value ="cmbPregunta15", required = false) String cmbPregunta15,
			@RequestParam(value ="cmbPregunta16", required = false) String cmbPregunta16,
			@RequestParam(value ="observacion", required = false)String observacion,@RequestParam("periodoInforme") String periodoInforme
			,@RequestParam(value ="rutaArchivo6", required = false) String rutaArchivo6,@RequestParam(value ="rutaArchivo7", required = false) String rutaArchivo7,@RequestParam(value ="rutaArchivo8", required = false)String rutaArchivo8
			,@RequestParam(value ="rutaArchivo9", required = false) String rutaArchivo9) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {
			

			List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, Integer.parseInt(periodoInforme));
			//List<Object[]> registrosInformesValorados = ivs.obtenerRegistrosInformesValorados();
			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);

			if (datosInformeValorado.size() == 0) {
				
		  switch (matriz) { 
		    case 1:
             TblInformeCalificado tblInformeCalificado = getInformeCalificado(infcod,id_informe_1);
				
				if(tblInformeCalificado != null) {				
					informeCalificado1(tblInformeCalificado, infcod, cmbpregunta1,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado);
				}else {				
					tblInformeCalificado = new TblInformeCalificado();
					informeCalificado1(tblInformeCalificado, infcod, cmbpregunta1,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado);
				}
		        break;
		    case 2:
	TblInformeCalificado tblInformeCalificado2 = getInformeCalificado(infcod, id_informe_2);
				
				if(tblInformeCalificado2 != null) {			
					informeCalificado2(tblInformeCalificado2, infcod, cmbPregunta2, rutaArchivo1,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado2); 
				} else {
					tblInformeCalificado2 = new TblInformeCalificado();
					informeCalificado2(tblInformeCalificado2, infcod, cmbPregunta2, rutaArchivo1,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado2); 
				}
		    	break;
		    case 3:
		TblInformeCalificado tblInformeCalificadoBalance = getInformeCalificado(infcod, id_informe_3);
				
				if(tblInformeCalificadoBalance != null) {
	
					informeBalance(tblInformeCalificadoBalance, infcod, cmbPregunta3, rutaArchivo2,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadoBalance);
				}else {
					tblInformeCalificadoBalance = new TblInformeCalificado();
					informeBalance(tblInformeCalificadoBalance, infcod, cmbPregunta3, rutaArchivo2,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadoBalance);
				}
		    	break;
		    	
		    case 4:
		    	  TblInformeCalificado tblInformeCalificado3 = getInformeCalificado(infcod, id_informe_4);
					
					if(tblInformeCalificado3 != null) {				
						informeCalificado3(tblInformeCalificado3, infcod, cmbPregunta4, rutaArchivo3,Integer.parseInt(periodoInforme));
						ics.guardarInformeCalificacion(tblInformeCalificado3);
					}else {
						tblInformeCalificado3 = new TblInformeCalificado();
						informeCalificado3(tblInformeCalificado3, infcod, cmbPregunta4, rutaArchivo3,Integer.parseInt(periodoInforme));
						ics.guardarInformeCalificacion(tblInformeCalificado3);
					}
		    	break;
		    case 5:
	
		    	TblInformeCalificado tblInformeCalificadosri= getInformeCalificado(infcod, id_informe_5);
				if(tblInformeCalificadosri != null) {
		

					informeCumplimientoObligacionesSRI(tblInformeCalificadosri, infcod, cmbPregunta5, rutaArchivo4, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadosri);
				}else {
		
					tblInformeCalificadosri = new TblInformeCalificado();
					informeCumplimientoObligacionesSRI(tblInformeCalificadosri, infcod, cmbPregunta5, rutaArchivo4, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadosri);
				}
	            TblInformeCalificado tblInformeCalificadoiess = getInformeCalificado(infcod, id_informe_6);
				
				if(tblInformeCalificadoiess != null) {
	

					informeCumplimientoObligacionesIESS(tblInformeCalificadoiess, infcod, cmbPregunta6, rutaArchivo5, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadoiess);
				}else {
				
					tblInformeCalificadoiess = new TblInformeCalificado();
					informeCumplimientoObligacionesIESS(tblInformeCalificadoiess, infcod, cmbPregunta6, rutaArchivo5, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadoiess);
				}
		    	break;
		    case 6:
TblInformeCalificado tblInformeCalificado5 = getInformeCalificado(infcod, id_informe_7);
				
				if(tblInformeCalificado5 != null) {
				
					informeCalificadoMParticipacion(tblInformeCalificado5, infcod, cmbPregunta7,rutaArchivo6, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado5);
				} else {
		
					tblInformeCalificado5 = new TblInformeCalificado();
					informeCalificadoMParticipacion(tblInformeCalificado5, infcod, cmbPregunta7,rutaArchivo6, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado5);
				}
		    	break;
		    case 7:
                TblInformeCalificado tblInformeCalificado6 = getInformeCalificado(infcod, id_informe_8);
				
				if(tblInformeCalificado6 != null) {
	

					informeCalificado5(tblInformeCalificado6, infcod, cmbPregunta8, rutaArchivo7,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado6);
				} else {			
					tblInformeCalificado6 = new TblInformeCalificado();
					informeCalificado5(tblInformeCalificado6, infcod, cmbPregunta8, rutaArchivo7,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado6);
				}
			    TblInformeCalificado tblInformeCalificado7 = getInformeCalificado(infcod, id_informe_9);
				
							if(tblInformeCalificado7 != null) {								
								informeCalificado6(tblInformeCalificado7, infcod, cmbPregunta9, rutaArchivo8,Integer.parseInt(periodoInforme));
								ics.guardarInformeCalificacion(tblInformeCalificado7);
							} else {
						
								tblInformeCalificado7 = new TblInformeCalificado();
								informeCalificado6(tblInformeCalificado7, infcod, cmbPregunta9, rutaArchivo8,Integer.parseInt(periodoInforme));
								ics.guardarInformeCalificacion(tblInformeCalificado7);
							}
		    	break;
		    case 8:
	TblInformeCalificado tblInformeCalificadoincorporacion = getInformeCalificado(infcod, id_informe_10);
				
				if(tblInformeCalificadoincorporacion != null) {
				
					informeCalificado7(tblInformeCalificadoincorporacion, infcod, cmbPregunta10, rutaArchivo9,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadoincorporacion);
				} else {
				
					tblInformeCalificadoincorporacion = new TblInformeCalificado();
					informeCalificado7(tblInformeCalificadoincorporacion, infcod, cmbPregunta10, rutaArchivo9,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadoincorporacion);
				}
				
		    	break;
		    case 9:
TblInformeCalificado tblInformeCalificado8 = getInformeCalificado(infcod, id_informe_11);
				
				if(tblInformeCalificado8 != null) {
					
					informeCalificado8(tblInformeCalificado8, infcod, cmbPregunta11,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado8);
				} else {
				
					tblInformeCalificado8 = new TblInformeCalificado();
					informeCalificado8(tblInformeCalificado8, infcod, cmbPregunta11,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado8);
				}
		    	break;
		    case 10:
                 TblInformeCalificado tblInformeCalificado10 = getInformeCalificado(infcod, id_informe_12);	
				if(tblInformeCalificado10 != null) {	
					informeCalificadoPIIntercultural(tblInformeCalificado10, infcod, cmbPregunta12,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado10);
				} else {				
					tblInformeCalificado10 = new TblInformeCalificado();
					informeCalificadoPIIntercultural(tblInformeCalificado10, infcod, cmbPregunta12,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado10);
				}
		        TblInformeCalificado tblInformeCalificado11 = getInformeCalificado(infcod, id_informe_13);
				
				if(tblInformeCalificado11 != null) {					
					informeCalificadoPIGeneracional(tblInformeCalificado11, infcod, cmbPregunta13,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado11);
				} else {				
					tblInformeCalificado11 = new TblInformeCalificado();
					informeCalificadoPIGeneracional(tblInformeCalificado11, infcod, cmbPregunta13,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado11);
				}
				
				TblInformeCalificado tblInformeCalificado12 = getInformeCalificado(infcod, id_informe_14);
				
				if(tblInformeCalificado12 != null) {
					informeCalificadoPIDiscapacidades(tblInformeCalificado12, infcod, cmbPregunta14,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado12);
				} else {
					tblInformeCalificado12 = new TblInformeCalificado();
					informeCalificadoPIDiscapacidades(tblInformeCalificado12, infcod, cmbPregunta14,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado12);
				}
				
				TblInformeCalificado tblInformeCalificado13 = getInformeCalificado(infcod, id_informe_15);
				
				if(tblInformeCalificado13 != null) {
					informeCalificadoPIGenero(tblInformeCalificado13, infcod, cmbPregunta15,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado13);
				} else {
					tblInformeCalificado13 = new TblInformeCalificado();
					informeCalificadoPIGenero(tblInformeCalificado13, infcod, cmbPregunta15,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado13);
				}
                TblInformeCalificado tblInformeCalificado14 = getInformeCalificado(infcod, id_informe_16);
				
				if(tblInformeCalificado14 != null) {
					informeCalificadoPIMHumana(tblInformeCalificado14, infcod, cmbPregunta16,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado14);
				} else {
					tblInformeCalificado14 = new TblInformeCalificado();
					informeCalificadoPIMHumana(tblInformeCalificado14, infcod, cmbPregunta16,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado14);
				}
				
		    	break;
		    	
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
	@SuppressWarnings("finally")
	  @RequestMapping(value = "FinalizarValoracionFEEP",method = RequestMethod.POST)
	  public @ResponseBody String FinalizarValoracionFEEP(
			  @RequestParam("identificadorResponsable") String identificadorResponsable,
			  @RequestParam("infcod") Integer infcod,	  
			  @RequestParam("periodoInforme") String periodoInforme,
			  @RequestParam("observacion") String observacion			  
			  ) {
		  JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try 
			{
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, Integer.parseInt(periodoInforme));
				List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);

				if (datosInformeValorado.size() == 0) {
				TblValoracion informeValorado = new TblValoracion();
				 List<TblInformeCalificado> calificacionesInforme = ics.ObtenerListaPregunstas(infcod); 
				 
				 for (TblInformeCalificado objects : calificacionesInforme) {
					 nota +=objects.getNota()==null?0:objects.getNota();
				}
						
					informeValorado.setInstiCod(Integer.parseInt(datosInstitucion.get(0)[10].toString()));
					informeValorado.setInfCod(infcod);
					informeValorado.setFechaValoracion(new Date());
					informeValorado.setPeriodo(Integer.parseInt(periodoInforme));
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

					mensaje.put("estado", "exito");
					mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
				} else {

					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");

				}
				
				}catch (Exception e) {
					mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
				}
			finally {
				return mensaje.toString();
			}
	  }
}
