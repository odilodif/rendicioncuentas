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
public class ValoracionInformeGADVinculada {
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
	@RequestMapping(value = "valoracionInformeGADVinculada", method = RequestMethod.POST)
	public String valoracionInformeGADVinculada(Model model, Authentication authentication,
			@RequestParam("id") String infcodPeriodo) {
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
		return "rendicion/valoracion/valoracionInformeGADVinculada";
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
						+ Constantes.periodo() + "?");
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
			case "2. DOCUMENTO OFICIAL DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO Y SU EJECUCIÓN":
				informeCalificado2.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA2);

				break;
			case "3. INFORME DE GESTIÓN FINANCIERA APROBADO POR AUTORIDAD COMPETENTE":
				informeCalificado2.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA3);

				break;
			case "4. MATRIZ DE LOTAIP QUE SÍ DIRECCIONA A LA CÉDULA PRESUPUESTARIA":
				informeCalificado2.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA4);

				break;
			case "5. NO ABRE EL LINK":
				informeCalificado2.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA6);

				break;
			case "6. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
				informeCalificado2.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA7);

				break;
			case "7. RESPONDE EN 0":
				informeCalificado2.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA8);

				break;
			case "8. OTROS, NO CUMPLE":
				informeCalificado2.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA9);

				break;
			case "9. VACÍO":
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
	private static void informeCalificado3(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta3, String rutaArchivo2,Integer periodo ) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("PROCESOS DE CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS");
		 informeCalificado.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?");
		 informeCalificado.setRespuesta(cmbPregunta3);
		 informeCalificado.setOrden(3);
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
			case "5. MEMORANDO E INFORME OFICIAL DE CONTRATACIONES PÚBLICAS, QUE CONTENGA EL DETALLE DE LOS PROCESOS DEL AÑO":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA5);

				break;
			case "6. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA":
				informeCalificado.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA6);

				break;
			case "7. NO ABRE EL LINK":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA7);

				break;
			case "8. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA8);

				break;
			case "9. RESPONDE EN 0":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA9);

				break;
			case "10. OTROS, NO CUMPLE":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA10);

				break;
			case "11. VACÍO":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA11);

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
	private static void informeCalificadoMParticipacion(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta, String rutaArchivo,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("MECANISMOS DE PARTICIPACIÓN CIUDADANA");
		 informeCalificado
					.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?");
		 informeCalificado.setRespuesta(cmbPregunta);
		 informeCalificado.setOrden(4);
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
			case "4. NO ABRE EL LINK":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA4);
				break;
			case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA5);
				break;
			case "6. NO APLICA":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA6);
				break;
			case "7. OTROS, NO CUMPLE":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA7);
				break;
			case "8. VACÍO":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA8);
				break;
			}

			informeCalificado.setPeriodo(periodo);
			if(rutaArchivo!="") {
				informeCalificado.setEvidencia(rutaArchivo);
			}else {
				informeCalificado.setEvidencia("N/A");
			}
	}
	private static void informeCalificado4(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta5, String rutaArchivo,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
		 informeCalificado.setPregunta("¿LA ENTIDAD SUSTENTA LA RECEPCIÓN DEL LISTADO DE TEMAS SOBRE LOS CUALES LA CIUDADANÍA SOLICITA QUE SE RINDA CUENTAS?");
		 informeCalificado.setRespuesta(cmbPregunta5);
		 informeCalificado.setOrden(5);
			switch (cmbPregunta5) {
			case "1. OFICIO O DOCUMENTO FIRMADO POR LOS CIUDADANOS, DEL LISTADO DE TEMAS SOBRE LOS CUALES SOLICITA A LA AUTORIDAD DE LA ENTIDAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO":
				informeCalificado.setNota((float) 3.33);
				nota = nota + (float) 3.33;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA1);
				break;
			case "2. RESPALDO DE LOS TEMAS QUE LOS CIUDADANOS PRESENTARON, A TRAVÉS DE MECANISMOS DIGITALES, A LA AUTORIDAD DE LA ENTIDAD PARA QUE RINDA CUENTAS":
				informeCalificado.setNota((float) 3.33);
				nota = nota + (float) 3.33;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA2);
				break;
			case "3. NO ABRE EL LINK":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA3);
				break;
			case "4. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA4);
				break;
			case "5. RESPONDE NO APLICA":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA5);
				break;
			case "6. OTROS, NO CUMPLE":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA6);
				break;
			case "7. VACÍO":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA7);
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
	private static void informeCalificado5(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta, String rutaArchivo,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
		 informeCalificado.setPregunta("¿LA ENTIDAD SUSTENTA LA ENTREGA DEL INFORME PRELIMINAR Y FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL CON 15 DÍAS DE ANTELACIÓN?");
		 informeCalificado.setRespuesta(cmbPregunta);
		 informeCalificado.setOrden(6);
			switch (cmbPregunta) {
			case "1. DOCUMENTO DE LA ENTIDAD EN EL QUE LA ASAMBLEA CIUDADANA /CIUDADANÍA AFIRMAN HABER RECIBIDO EL INFORME - FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, CON 15 DÍAS DE ANTELACIÓN":
				informeCalificado.setNota((float) 3.33);
				nota = nota + (float) 3.23;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
				break;
			case "2. ENVÍO VIRTUAL DEL INFORME & FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, POR PARTE DE LA ENTIDAD A LA ASAMBLEA CIUDADANA / CIUDADANÍA, Y CONFIRMACIÓN CIUDADANA DE RECIBIDO, CON 15 DÍAS DE ANTELACIÓN":
				informeCalificado.setNota((float) 3.33);
				nota = nota + (float) 3.33;
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
			if(rutaArchivo!="") {
				informeCalificado.setEvidencia(rutaArchivo);
			}else {
				informeCalificado.setEvidencia("N/A");
			}
			//ics.guardarInformeCalificacion(tblInformeCalificado5);
	}
	private static void informeCalificado6(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta5, String rutaArchivo,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
		 informeCalificado.setPregunta("¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DEL VIDEO DE LA DELIBERACIÓN PÚBLICA CON LA INTERVENCIÓN DE LA CIUDADANÍA?");
		 informeCalificado.setRespuesta(cmbPregunta5);
		 informeCalificado.setOrden(7);
			switch (cmbPregunta5) {
			case "1. LINK AL VIDEO EN EL QUE LA ENTIDAD DEMUESTRA QUE LA ASAMBLEA CIUDADANA / CIUDADANÍA SI TUVO UN TIEMPO PARA EVALUAR LA ENTIDAD EN LA DELIBERACIÓN PÚBLICA":
				informeCalificado.setNota((float) 3.33);
				nota = nota + (float) 3.33;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
				break;
			case "2. LINK AL VIDEO EN EL QUE LA ENTIDAD REALIZÓ LA DELIBERACIÓN PÚBLICA, PERO LA ASAMBLEA CIUDADANA / CIUDADANÍA NO TUVO UN TIEMPO PARA EVALUAR LA ENTIDAD EN LA DELIBERACIÓN PÚBLICA":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
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
			if(rutaArchivo!="") {
				informeCalificado.setEvidencia(rutaArchivo);
			}else {
				informeCalificado.setEvidencia("N/A");
			}
			//ics.guardarInformeCalificacion(tblInformeCalificado5);
	}
	private static void informeCalificado7(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta5, String rutaArchivo,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
		 informeCalificado.setPregunta("¿LA ENTIDAD SUSTENTA EL PLAN DE TRABAJO QUE INCORPORA LAS SUGERENCIAS CIUDADANAS EN SU GESTIÓN?");
		 informeCalificado.setRespuesta(cmbPregunta5);
		 informeCalificado.setOrden(8);
			switch (cmbPregunta5) {
			case "1. DOCUMENTO DEL PLAN DE TRABAJO DEL GAD ELABORADO A PARTIR DE LOS INSUMOS DE LA DELIBERACIÓN PÚBLICA DEL GAD":
				informeCalificado.setNota((float) 3.33);
				nota = nota + (float) 3.33;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
				break;
			case "2. NO ABRE EL LINK":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA2);
				break;
			case "3. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
				break;
			case "4. NO APLICA":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
				break;
			case "5. OTROS, NO CUMPLE":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
				break;
			case "6. VACÍO":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
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
	private static void informeCalificado8(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta5, String rutaArchivo,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
		 informeCalificado.setPregunta("¿LA ENTIDAD SUSTENTA LA ENTREGA DEL PLAN DE TRABAJO A LA ASAMBLEA CIUDADANA CON SU RESPECTIVO RECIBIDO?");
		 informeCalificado.setRespuesta(cmbPregunta5);
		 informeCalificado.setOrden(9);
			switch (cmbPregunta5) {
			case "1. DOCUMENTOS (DIGITAL O FÍSICO) CON EL RECIBIDO DE: LA ASAMBLEA CIUDADANA/ CIUDADANÍA, CONSEJO DE PARTICIPACIÓN E INSTANCIA DE PARTICIPACIÓN, DE CONSTANCIA DE ENTREGA DEL PLAN DE TRABAJO":
				informeCalificado.setNota((float) 3.33);
				nota = nota + (float) 3.33;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
				break;
			case "2. NO ABRE EL LINK":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA2);
				break;
			case "3. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
				break;
			case "4. NO APLICA":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
				break;
			case "5. OTROS, NO CUMPLE":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
				break;
			case "6. VACÍO":
				informeCalificado.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				informeCalificado.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
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
	private static void informeCalificadoPlan(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta5, String rutaArchivo,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("CUMPLIMIENTO DEL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR IMPLEMENTADAS EN LA GESTIÓN INSTITUCIONAL");
		 informeCalificado.setPregunta("¿LA ENTIDAD SUSTENTA HABER CUMPLIDO EL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR, EN SU GESTIÓN INSTITUCIONAL?");
		 informeCalificado.setRespuesta(cmbPregunta5);
		 informeCalificado.setOrden(10);
			switch (cmbPregunta5) {
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
			if(rutaArchivo!="") {
				informeCalificado.setEvidencia(rutaArchivo);
			}else {
				informeCalificado.setEvidencia("N/A");
			}
			//ics.guardarInformeCalificacion(tblInformeCalificado5);
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
	
	private static void informeCalificadoMControl(TblInformeCalificado informeCalificado, Integer infcod, String cmbPregunta5,Integer periodo) {
		 float nota = (float) 00.00;
		 informeCalificado.setInfCod(infcod);
		 informeCalificado.setMatriz("MECANISMOS DE CONTROL SOCIAL");
		 informeCalificado.setPregunta("¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?");
		 informeCalificado.setRespuesta(cmbPregunta5);
		 informeCalificado.setOrden(11);
		 
			switch (cmbPregunta5) {
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
			//ics.guardarInformeCalificacion(tblInformeCalificado5);
	}
	@SuppressWarnings("finally")
	@RequestMapping(value = "guardarEvaluacionGADVinculadas")
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
		    	TblInformeCalificado tblInformeCalificado3 = getInformeCalificado(infcod, id_informe_3);
				
				if(tblInformeCalificado3 != null) {
					informeCalificado3(tblInformeCalificado3, infcod, cmbPregunta3, rutaArchivo2,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado3);
				}else {
					tblInformeCalificado3 = new TblInformeCalificado();
					informeCalificado3(tblInformeCalificado3, infcod, cmbPregunta3, rutaArchivo2,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado3);
				}
		    	break;
		    	
		    case 4:
		    	  TblInformeCalificado tblInformeCalificadoMeca = getInformeCalificado(infcod, id_informe_4);
					
					if(tblInformeCalificadoMeca != null) {
						informeCalificadoMParticipacion(tblInformeCalificadoMeca, infcod, cmbPregunta4, rutaArchivo3,Integer.parseInt(periodoInforme));
						ics.guardarInformeCalificacion(tblInformeCalificadoMeca);
					}else {
						tblInformeCalificadoMeca = new TblInformeCalificado();
						informeCalificadoMParticipacion(tblInformeCalificadoMeca, infcod, cmbPregunta4, rutaArchivo3,Integer.parseInt(periodoInforme));
						ics.guardarInformeCalificacion(tblInformeCalificadoMeca);
					}
		    	break;
		    case 5:
	
		    	TblInformeCalificado tblInformeCalificadosfr= getInformeCalificado(infcod, id_informe_5);
				if(tblInformeCalificadosfr != null) {
					informeCalificado4(tblInformeCalificadosfr, infcod, cmbPregunta5, rutaArchivo4, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadosfr);
				}else {
					tblInformeCalificadosfr = new TblInformeCalificado();
					informeCalificado4(tblInformeCalificadosfr, infcod, cmbPregunta5, rutaArchivo4, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadosfr);
				}
	            TblInformeCalificado tblInformeCalificadosfr1 = getInformeCalificado(infcod, id_informe_6);
	            if(tblInformeCalificadosfr1 != null) {
					informeCalificado5(tblInformeCalificadosfr1, infcod, cmbPregunta6, rutaArchivo5, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadosfr1);
				}else {
					tblInformeCalificadosfr1 = new TblInformeCalificado();
					informeCalificado5(tblInformeCalificadosfr1, infcod, cmbPregunta6, rutaArchivo5, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadosfr1);
				}
	            TblInformeCalificado tblInformeCalificadosfr2 = getInformeCalificado(infcod, id_informe_7);
	            if(tblInformeCalificadosfr2 != null) {
					informeCalificado6(tblInformeCalificadosfr2, infcod, cmbPregunta7, rutaArchivo6, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadosfr2);
				}else {
					tblInformeCalificadosfr2 = new TblInformeCalificado();
					informeCalificado6(tblInformeCalificadosfr2, infcod, cmbPregunta7, rutaArchivo6, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadosfr2);
				}
	            TblInformeCalificado tblInformeCalificadosfr3 = getInformeCalificado(infcod, id_informe_8);
	            if(tblInformeCalificadosfr3 != null) {
					informeCalificado7(tblInformeCalificadosfr3, infcod, cmbPregunta8, rutaArchivo7, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadosfr3);
				}else {
					tblInformeCalificadosfr3 = new TblInformeCalificado();
					informeCalificado7(tblInformeCalificadosfr3, infcod, cmbPregunta8, rutaArchivo7, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadosfr3);
				}
	            TblInformeCalificado tblInformeCalificadosfr4 = getInformeCalificado(infcod, id_informe_9);
	            if(tblInformeCalificadosfr4 != null) {
					informeCalificado8(tblInformeCalificadosfr4, infcod, cmbPregunta9, rutaArchivo8, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadosfr4);
				}else {
					tblInformeCalificadosfr4 = new TblInformeCalificado();
					informeCalificado8(tblInformeCalificadosfr4, infcod, cmbPregunta9, rutaArchivo8, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadosfr4);
				}
		    	break;
		    case 6:
              TblInformeCalificado tblInformeCalificado5 = getInformeCalificado(infcod, id_informe_10);
				
				if(tblInformeCalificado5 != null) {
					informeCalificadoPlan(tblInformeCalificado5, infcod, cmbPregunta10,rutaArchivo9, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado5);
				} else {
					tblInformeCalificado5 = new TblInformeCalificado();
					informeCalificadoPlan(tblInformeCalificado5, infcod, cmbPregunta10,rutaArchivo9, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado5);
				}
		    	break;
		    case 7:
                TblInformeCalificado tblInformeCalificado6 = getInformeCalificado(infcod, id_informe_11);
				
				if(tblInformeCalificado6 != null) {
					informeCalificadoMControl(tblInformeCalificado6, infcod, cmbPregunta11, Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado6);
				} else {
					tblInformeCalificado6 = new TblInformeCalificado();
					informeCalificadoMControl(tblInformeCalificado6, infcod, cmbPregunta11,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificado6);
				}
		    	break;
	
		    case 8:
                 TblInformeCalificado tblInformeCalificadocultural = getInformeCalificado(infcod, id_informe_12);	
				if(tblInformeCalificadocultural != null) {
					informeCalificadoPIIntercultural(tblInformeCalificadocultural, infcod, cmbPregunta12,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadocultural);
				} else {
					tblInformeCalificadocultural = new TblInformeCalificado();
					informeCalificadoPIIntercultural(tblInformeCalificadocultural, infcod, cmbPregunta12,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadocultural);
				}
		        TblInformeCalificado tblInformeCalificadogeneracional = getInformeCalificado(infcod, id_informe_13);
				
				if(tblInformeCalificadogeneracional != null) {
					informeCalificadoPIGeneracional(tblInformeCalificadogeneracional, infcod, cmbPregunta13,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadogeneracional);
				} else {
					tblInformeCalificadogeneracional = new TblInformeCalificado();
					informeCalificadoPIGeneracional(tblInformeCalificadogeneracional, infcod, cmbPregunta13,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadogeneracional);
				}
				
				TblInformeCalificado tblInformeCalificadodiscapacidad = getInformeCalificado(infcod, id_informe_14);
				
				if(tblInformeCalificadodiscapacidad != null) {
					informeCalificadoPIDiscapacidades(tblInformeCalificadodiscapacidad, infcod, cmbPregunta14,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadodiscapacidad);
				} else {
					tblInformeCalificadodiscapacidad = new TblInformeCalificado();
					informeCalificadoPIDiscapacidades(tblInformeCalificadodiscapacidad, infcod, cmbPregunta14,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadodiscapacidad);
				}
				
				TblInformeCalificado tblInformeCalificadogenero= getInformeCalificado(infcod, id_informe_15);
				
				if(tblInformeCalificadogenero != null) {
					informeCalificadoPIGenero(tblInformeCalificadogenero, infcod, cmbPregunta15,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadogenero);
				} else {
					tblInformeCalificadogenero = new TblInformeCalificado();
					informeCalificadoPIGenero(tblInformeCalificadogenero, infcod, cmbPregunta15,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadogenero);
				}
                TblInformeCalificado tblInformeCalificadomovilidada = getInformeCalificado(infcod, id_informe_16);
				
				if(tblInformeCalificadomovilidada != null) {
					informeCalificadoPIMHumana(tblInformeCalificadomovilidada, infcod, cmbPregunta16,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadomovilidada);
				} else {
					tblInformeCalificadomovilidada = new TblInformeCalificado();
					informeCalificadoPIMHumana(tblInformeCalificadomovilidada, infcod, cmbPregunta16,Integer.parseInt(periodoInforme));
					ics.guardarInformeCalificacion(tblInformeCalificadomovilidada);
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
	  @RequestMapping(value = "FinalizarValoracionVinculadas",method = RequestMethod.POST)
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
