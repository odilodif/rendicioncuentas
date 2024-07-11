/**
 * 
 */
package gob.cpccs.controller.rendicion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.fasterxml.jackson.databind.ObjectMapper;

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

/**
 * @author Mauricio Rivera
 * @mail mauriciorivera68@hotmail.com
 * @date 16:40:26
 */

@Controller
@RequestMapping("/view/rendicion/valoracion")
public class ValoracionInformeGAD {

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

	@SuppressWarnings("finally")
	@RequestMapping(value = "/GuardarFrmGADP")
	public @ResponseBody String GuardarFrmGADP(HttpServletRequest request,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, @RequestParam("cmbpregunta1") String cmbpregunta1,
			@RequestParam("periodoInforme") String periodoInforme, @RequestParam("pre1") Integer codigo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {

			// List<Object[]> datosInstitucion =
			// is.obtenerRegistroInformeInstitucionXInfcod(infcod,Integer.parseInt(periodoInforme));
			// List<Object[]> registrosInformesValorados =
			// ivs.obtenerRegistrosInformesValorados();
			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
			TblInformeCalificado tblInformeCalificado = new TblInformeCalificado();

			if (codigo == null) {
				if (datosInformeValorado.size() == 0) {

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}
			} else {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado = ics.ObtenerRegistroXidInfCal(codigo);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}

			}
			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado.getIdInfCal());
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	@RequestMapping(value = "valoracionInformeGAD", method = RequestMethod.POST)
	public String valoracionInformeGAD(Model model, Authentication authentication,
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
		model.addAttribute("pregunta1", ics.ObtenerRegistroInfCodPregunta(infcod,
				"¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO "
						+ periodo + "?"));

		return "rendicion/valoracion/valoracionInformeGAD";
	}

	@RequestMapping(value = "/ObtenerPreguntas", method = RequestMethod.POST)
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

	/**** Matriz 1 ***/
	@SuppressWarnings("finally")
	@RequestMapping(value = "/GuardarFrmGADP1")
	public @ResponseBody String GuardarFrmGADP1(HttpServletRequest request,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, @RequestParam("cmbpregunta1") String cmbpregunta1,
			@RequestParam("periodoInforme") Integer periodoInforme, @RequestParam("pre1") Integer codigo) {

		System.out.println("Odilo Hello...1");
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {

			// List<Object[]> datosInstitucion =
			// is.obtenerRegistroInformeInstitucionXInfcod(infcod,Integer.parseInt(periodoInforme));
			// List<Object[]> registrosInformesValorados =
			// ivs.obtenerRegistrosInformesValorados();
			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
			TblInformeCalificado tblInformeCalificado = new TblInformeCalificado();

			if (codigo == null) {
				if (datosInformeValorado.size() == 0) {

					tblInformeCalificado.setInfCod(infcod);
					tblInformeCalificado.setMatriz("ESTADO INFORME");
					tblInformeCalificado.setPregunta(
							"¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO "
									+ periodoInforme + "?");
					tblInformeCalificado.setRespuesta(cmbpregunta1);
					if (cmbpregunta1.equals("SI")) {
						tblInformeCalificado.setNota((float) 24.00);
						nota = (float) 24.00;
					} else {
						tblInformeCalificado.setNota((float) 0.00);
						nota = (float) 0.00;
					}
					tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
					tblInformeCalificado.setPeriodo(periodoInforme);
					tblInformeCalificado.setEvidencia("N/A");

					ics.guardarInformeCalificacion(tblInformeCalificado);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}
			} else {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado.setInfCod(infcod);
					tblInformeCalificado.setMatriz("ESTADO INFORME");
					tblInformeCalificado.setPregunta(
							"¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO "
									+ periodoInforme + "?");
					tblInformeCalificado.setRespuesta(cmbpregunta1);
					if (cmbpregunta1.equals("SI")) {
						tblInformeCalificado.setNota((float) 11.11);
						nota = (float) 24.00;
					} else {
						tblInformeCalificado.setNota((float) 0.00);
						nota = (float) 0.00;
					}
					System.out.println("Odilo Hello...2..get Orden: " + tblInformeCalificado.getOrden());
					tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
					tblInformeCalificado.setPeriodo(periodoInforme);
					tblInformeCalificado.setEvidencia("N/A");
					tblInformeCalificado.setOrden(1);
					System.out.println("Odilo Hello...2..get Orden: " + tblInformeCalificado.getOrden());
					ics.guardarInformeCalificacion(tblInformeCalificado);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}

			}
			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado.getIdInfCal());
			mensaje.put("mensaje", "Los datos se han guardado correctamente.!!! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	/**** Matriz 2 ***/
	@SuppressWarnings("finally")
	@RequestMapping(value = "/GuardarFrmGADP2")
	public @ResponseBody String GuardarFrmGADP2(HttpServletRequest request,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, @RequestParam("cmbPregunta2") String cmbPregunta2,
			@RequestParam("periodoInforme") Integer periodoInforme, @RequestParam("pre2") Integer codigo,
			@RequestParam("rutaArchivo1") String rutaArchivo1) {

		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {

			// List<Object[]> datosInstitucion =
			// is.obtenerRegistroInformeInstitucionXInfcod(infcod,Integer.parseInt(periodoInforme));
			// List<Object[]> registrosInformesValorados =
			// ivs.obtenerRegistrosInformesValorados();
			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
			TblInformeCalificado tblInformeCalificado2 = new TblInformeCalificado();
			if (codigo == null) {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado2.setInfCod(infcod);
					tblInformeCalificado2.setMatriz("CUMPLIMIENTO DE LA EJECUCIÓN PRESUPUESTARIA");
					tblInformeCalificado2.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?");
					tblInformeCalificado2.setRespuesta(cmbPregunta2);
					switch (cmbPregunta2) {
					case "1. CÉDULA PRESUPUESTARIA DEL MINISTERIO DE FINANZAS":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA1);
						break;
					case " 2. INFORME DE GESTIÓN PESUPUESTARIA APROBADO POR AUTORIDAD COMPETENTE":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA2);

						break;
					case "3. INFORME DE GESTIÓN FINANCIERA APROBADO POR AUTORIDAD COMPETENTE":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA3);

						break;
					case "4. DOCUMENTO OFICIAL DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO Y SU EJECUCIÓN":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA4);

						break;
					case "5. MATRIZ DE LOTAIP QUE SÍ DIRECCIONA A LA CÉDULA PRESUPUESTARIA":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA5);

						break;
					case "6. NO ABRE EL LINK":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA6);

						break;
					case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN ":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA7);

						break;
					case "8. NO IMPLEMENTA":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA8);

						break;
					case "9. OTROS, NO CUMPLE":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA9);

						break;
					case "10. VACÍO":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA10);

						break;
					}

					tblInformeCalificado2.setPeriodo(periodoInforme);
					tblInformeCalificado2.setEvidencia(rutaArchivo1);
					ics.guardarInformeCalificacion(tblInformeCalificado2);
				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}

			} else {
				System.out.println("Segunda matriz Actualizar !!");
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado2 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado2.setInfCod(infcod);
					tblInformeCalificado2.setMatriz("CUMPLIMIENTO DE LA EJECUCIÓN PRESUPUESTARIA");
					tblInformeCalificado2.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?");
					tblInformeCalificado2.setRespuesta(cmbPregunta2);
					switch (cmbPregunta2) {
					case "1. CÉDULA PRESUPUESTARIA DEL MINISTERIO DE FINANZAS":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA1);
						break;
					case " 2. INFORME DE GESTIÓN PESUPUESTARIA APROBADO POR AUTORIDAD COMPETENTE":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA2);

						break;
					case "3. INFORME DE GESTIÓN FINANCIERA APROBADO POR AUTORIDAD COMPETENTE":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA3);

						break;
					case "4. DOCUMENTO OFICIAL DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO Y SU EJECUCIÓN":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA4);

						break;
					case "5. MATRIZ DE LOTAIP QUE SÍ DIRECCIONA A LA CÉDULA PRESUPUESTARIA":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA5);

						break;
					case "6. NO ABRE EL LINK":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA6);

						break;
					case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN ":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA7);

						break;
					case "8. NO IMPLEMENTA":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA8);

						break;
					case "9. OTROS, NO CUMPLE":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA9);

						break;
					case "10. VACÍO":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA10);

						break;
					}

					tblInformeCalificado2.setPeriodo(periodoInforme);
					tblInformeCalificado2.setEvidencia(rutaArchivo1);
					tblInformeCalificado2.setOrden(2);
					ics.guardarInformeCalificacion(tblInformeCalificado2);
				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}

			}
			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado2.getIdInfCal());
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	/**** Matriz 3 ***/
	@SuppressWarnings("finally")
	@RequestMapping(value = "/GuardarFrmGADP3")
	public @ResponseBody String GuardarFrmGADP3(HttpServletRequest request,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, @RequestParam("cmbPregunta3") String cmbPregunta3,
			@RequestParam("periodoInforme") Integer periodoInforme, @RequestParam("pre3") Integer codigo,
			@RequestParam("rutaArchivo2") String rutaArchivo2) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {

			// List<Object[]> datosInstitucion =
			// is.obtenerRegistroInformeInstitucionXInfcod(infcod,Integer.parseInt(periodoInforme));
			// List<Object[]> registrosInformesValorados =
			// ivs.obtenerRegistrosInformesValorados();
			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
			TblInformeCalificado tblInformeCalificado3 = new TblInformeCalificado();
			if (codigo == null) {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado3.setInfCod(infcod);
					tblInformeCalificado3
							.setMatriz("PROCESOS DE CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS");
					tblInformeCalificado3
							.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?");
					tblInformeCalificado3.setRespuesta(cmbPregunta3);
					switch (cmbPregunta3) {
					case "1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA1);
						break;
					case "2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA2);

						break;
					case "3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA3);

						break;
					case "4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA))":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA4);

						break;
					case "5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA5);

						break;
					case "6. NO ABRE EL LINK":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA8);

						break;
					case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA9);

						break;
					case "8. RESPONDE EN 0":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA10);

						break;
					case "9. OTROS, NO CUMPLE":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA11);

						break;
					case "10. VACÍO":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA12);

						break;
					}

					tblInformeCalificado3.setPeriodo(periodoInforme);
					if (rutaArchivo2 != "") {
						tblInformeCalificado3.setEvidencia(rutaArchivo2);
					} else {
						tblInformeCalificado3.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado3);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}
			} else {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado3 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado3.setInfCod(infcod);
					tblInformeCalificado3
							.setMatriz("PROCESOS DE CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS");
					tblInformeCalificado3
							.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?");
					tblInformeCalificado3.setRespuesta(cmbPregunta3);
					switch (cmbPregunta3) {
					case "1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA1);
						break;
					case "2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA2);

						break;
					case "3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA3);

						break;
					case "4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA))":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA4);

						break;
					case "5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA5);

						break;
					case "6. NO ABRE EL LINK":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA8);

						break;
					case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA9);

						break;
					case "8. RESPONDE EN 0":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA10);

						break;
					case "9. OTROS, NO CUMPLE":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA11);

						break;
					case "10. VACÍO":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA12);

						break;
					}

					tblInformeCalificado3.setPeriodo(periodoInforme);
					if (rutaArchivo2 != "") {
						tblInformeCalificado3.setEvidencia(rutaArchivo2);
					} else {
						tblInformeCalificado3.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado3);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}
			}
			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado3.getIdInfCal());
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	/**** Matriz 4 ***/
	@SuppressWarnings("finally")
	@RequestMapping(value = "/GuardarFrmGADP4")
	public @ResponseBody String GuardarFrmGADP4(HttpServletRequest request,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, @RequestParam("cmbPregunta4") String cmbPregunta4,
			@RequestParam("cmbPregunta5") String cmbPregunta5, @RequestParam("pre4") Integer codigo,
			@RequestParam("periodoInforme") Integer periodoInforme, @RequestParam("pre4_1") Integer codigo1,
			@RequestParam("rutaArchivo3") String rutaArchivo3, @RequestParam("rutaArchivo3_1") String rutaArchivo3_1) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {

			// List<Object[]> datosInstitucion =
			// is.obtenerRegistroInformeInstitucionXInfcod(infcod,Integer.parseInt(periodoInforme));
			// List<Object[]> registrosInformesValorados =
			// ivs.obtenerRegistrosInformesValorados();
			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
			TblInformeCalificado tblInformeCalificado5 = new TblInformeCalificado();
			TblInformeCalificado tblInformeCalificado4 = new TblInformeCalificado();
			if (codigo == null) {
				if (datosInformeValorado.size() == 0) {

					//////////////////////// cmbPregunta4///////////////////////////////////////
					tblInformeCalificado4.setInfCod(infcod);
					tblInformeCalificado4.setMatriz("MECANISMOS DE PARTICIPACIÓN CIUDADANA");
					tblInformeCalificado4.setPregunta("¿EL GAD SUSTENTA LA CONFORMACIÓN DEL CONSEJO DE PLANIFICACIÓN?");
					tblInformeCalificado4.setRespuesta(cmbPregunta4);
					switch (cmbPregunta4) {
					case "1.  ACTA CONSTITUTIVA DEL CONSEJO DE PLANIFICACIÓN Y REGISTROS DE ASISTENCIA":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA1);
						break;
					case "2. ACTA/ MEMORIAS DE REUNIONES CON LA FIRMA DE LOS DELEGADOS DE LA ASAMBLEA CIUDADANA / CIUDADANOS Y REGISTROS DE ASISTENCIA":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA2);
						break;
					case "3. SISTEMATIZACIÓN DE PROCESOS DE PARTICIPACIÓN":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA3);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA5);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA6);
						break;
					case "6. NO IMPLEMENTA":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA7);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA8);
						break;
					case "8. VACÍO":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA9);
						break;
					}

					tblInformeCalificado4.setPeriodo(periodoInforme);
					if (rutaArchivo3 != "") {
						tblInformeCalificado4.setEvidencia(rutaArchivo3);
					} else {
						tblInformeCalificado4.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado4);

					/////////////// cmbPregunta5///////////////////
					tblInformeCalificado5.setInfCod(infcod);
					tblInformeCalificado5.setMatriz("MECANISMOS DE PARTICIPACIÓN CIUDADANA");
					tblInformeCalificado5
							.setPregunta("¿EL GAD SUSTENTA LA CONFORMACIÓN DE LA INSTANCIA DE PARTICIPACIÓN?");
					tblInformeCalificado5.setRespuesta(cmbPregunta5);
					switch (cmbPregunta5) {
					case "1.  ACTA CONSTITUTIVA DE LAS INSTANCIAS DE PARTICIPACIÓN Y REGISTROS DE ASISTENCIA":
						tblInformeCalificado5.setNota((float) 5.55);
						nota = nota + (float) 5.55;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA1);
						break;
					case "2. ACTA/ MEMORIAS DE REUNIONES CON LA FIRMA DE LOS DELEGADOS DE LA ASAMBLEA CIUDADANA / CIUDADANOS Y REGISTROS DE ASISTENCIA":
						tblInformeCalificado5.setNota((float) 5.55);
						nota = nota + (float) 5.55;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA2);
						break;
					case "3. SISTEMATIZACIÓN DE PROCESOS DE PARTICIPACIÓN":
						tblInformeCalificado5.setNota((float) 5.55);
						nota = nota + (float) 5.55;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA3);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA5);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA6);
						break;
					case "6. NO APLICA":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA7);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA8);
						break;
					case "8. VACÍO":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA9);
						break;
					}

					tblInformeCalificado5.setPeriodo(periodoInforme);
					if (rutaArchivo3_1 != "") {
						tblInformeCalificado5.setEvidencia(rutaArchivo3_1);
					} else {
						tblInformeCalificado5.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado5);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}
			} else {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado4 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado5 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado4.setInfCod(infcod);
					tblInformeCalificado4.setMatriz("MECANISMOS DE PARTICIPACIÓN CIUDADANA");
					tblInformeCalificado4.setPregunta("¿EL GAD SUSTENTA LA CONFORMACIÓN DEL CONSEJO DE PLANIFICACIÓN?");
					tblInformeCalificado4.setRespuesta(cmbPregunta4);
					switch (cmbPregunta4) {
					case "1. ACTA CONSTITUTIVA DE LAS INSTANCIAS DE PARTICIPACIÓN Y REGISTROS DE ASISTENCIA":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA1);
						break;
					case "2. ACTA/ MEMORIAS DE REUNIONES CON LA FIRMA DE LOS DELEGADOS DE LA ASAMBLEA CIUDADANA / CIUDADANOS Y REGISTROS DE ASISTENCIA":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA2);
						break;
					case "3. SISTEMATIZACIÓN DE PROCESOS DE PARTICIPACIÓN":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA3);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA5);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA6);
						break;
					case "6. NO APLICA":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA7);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA8);
						break;
					case "8. VACÍO":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA9);
						break;
					}

					tblInformeCalificado4.setPeriodo(periodoInforme);
					if (rutaArchivo3 != "") {
						tblInformeCalificado4.setEvidencia(rutaArchivo3);
					} else {
						tblInformeCalificado4.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado4);

					tblInformeCalificado5.setInfCod(infcod);
					tblInformeCalificado5.setMatriz("MECANISMOS DE PARTICIPACIÓN CIUDADANA");
					tblInformeCalificado5
							.setPregunta("¿EL GAD SUSTENTA LA CONFORMACIÓN DE LA INSTANCIA DE PARTICIPACIÓN?");
					tblInformeCalificado5.setRespuesta(cmbPregunta5);
					switch (cmbPregunta5) {
					case "1. ACTA CONSTITUTIVA DE LAS INSTANCIAS DE PARTICIPACIÓN Y REGISTROS DE ASISTENCIA":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA1);
						break;
					case "2. ACTA/ MEMORIAS DE REUNIONES CON LA FIRMA DE LOS DELEGADOS DE LA ASAMBLEA CIUDADANA / CIUDADANOS Y REGISTROS DE ASISTENCIA":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA2);
						break;
					case "3. SISTEMATIZACIÓN DE PROCESOS DE PARTICIPACIÓN":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA3);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA5);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA6);
						break;
					case "6. NO APLICA":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA7);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA8);
						break;
					case "8. VACÍO":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA9);
						break;
					}

					tblInformeCalificado5.setPeriodo(periodoInforme);
					if (rutaArchivo3_1 != "") {
						tblInformeCalificado5.setEvidencia(rutaArchivo3_1);
					} else {
						tblInformeCalificado5.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado5);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}

			}
			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado4.getIdInfCal());
			mensaje.put("codigo1", tblInformeCalificado5.getIdInfCal());
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	/**** Matriz 5 ***/
	@SuppressWarnings("finally")
	@RequestMapping(value = "/GuardarFrmGADP5")
	public @ResponseBody String GuardarFrmGADP5(HttpServletRequest request,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, 
			@RequestParam("cmbPregunta6") String cmbPregunta6,
			@RequestParam("rutaArchivo4") String rutaArchivo4, 
			@RequestParam("cmbPregunta7") String cmbPregunta7,
			@RequestParam("rutaArchivo4_1") String rutaArchivo4_1, 
			@RequestParam("cmbPregunta8") String cmbPregunta8,
			@RequestParam("rutaArchivo4_2") String rutaArchivo4_2, 
			@RequestParam("cmbPregunta9") String cmbPregunta9,
			@RequestParam("rutaArchivo4_3") String rutaArchivo4_3, 
			@RequestParam("cmbPregunta10") String cmbPregunta10,
			@RequestParam("rutaArchivo4_4") String rutaArchivo4_4, 
			@RequestParam("cmbPregunta11") String cmbPregunta11,
			@RequestParam("rutaArchivo4_5") String rutaArchivo4_5, 
			@RequestParam("cmbPregunta12") String cmbPregunta12,
			@RequestParam("rutaArchivo4_6") String rutaArchivo4_6,
			@RequestParam("cmbPregunta13") String cmbPregunta13,
			@RequestParam("rutaArchivo4_7") String rutaArchivo4_7,
			@RequestParam("periodoInforme") Integer periodoInforme, @RequestParam("pre5") Integer codigo,
			@RequestParam("pre5_1") Integer codigo1, @RequestParam("pre5_2") Integer codigo2,
			@RequestParam("pre5_3") Integer codigo3, @RequestParam("pre5_4") Integer codigo4) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {

			/** Recovery List datosInformeValorado ***/
			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
			/**** Create new Form 6,7,8,9,10,11,12,13 ***/
			TblInformeCalificado tblInformeCalificado6 = new TblInformeCalificado();// 1
			TblInformeCalificado tblInformeCalificado7 = new TblInformeCalificado();// 2
			TblInformeCalificado tblInformeCalificado8 = new TblInformeCalificado();// 3
			TblInformeCalificado tblInformeCalificado9 = new TblInformeCalificado();// 4
			TblInformeCalificado tblInformeCalificado10 = new TblInformeCalificado();// 5
			TblInformeCalificado tblInformeCalificado11 = new TblInformeCalificado();// 6
			TblInformeCalificado tblInformeCalificado12 = new TblInformeCalificado();// 7
			TblInformeCalificado tblInformeCalificado13 = new TblInformeCalificado();// 8

			/************** New File o Register ***********************************/
			if (codigo == null) {
				if (datosInformeValorado.size() == 0) {

					tblInformeCalificado6.setInfCod(infcod);
					tblInformeCalificado6.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado6.setPregunta(
							"¿EL GAD SUSTENTA LA RECEPCIÓN DEL LISTADO DE TEMAS SOBRE LOS CUALES LA CIUDADANÍA SOLICITA QUE SE RINDA CUENTAS?");
					tblInformeCalificado6.setRespuesta(cmbPregunta6);

					//////////////////////////////////// cmbPregunta6/////////////////////////////////////////////////
					switch (cmbPregunta6) {
					case "1. OFICIO O DOCUMENTO FIRMADO POR LOS CIUDADANOS (FÍSICO O DIGITAL), DEL LISTADO DE TEMAS SOBRE LOS CUALES SOLICITA A LA AUTORIDAD DEL GAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO":
						tblInformeCalificado6.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA1);
						break;
					case "2. ACTA DE REUNIÓN DONDE CONSTA EL LISTADO DE TEMAS SOBRE LOS CUALES SOLICITA A LA AUTORIDAD DEL GAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO":
						tblInformeCalificado6.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA2);
						break;
					case "3. CAPTURA DE PANTALLA DE LOS  TEMAS SOBRE LOS CUALES LA CIUDADANÍA SOLICITA POR CORREO Y/O MEDIOS VIRTUALES A LA AUTORIDAD DEL GAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO":
						tblInformeCalificado6.setNota((float) 4.75);
						nota = nota + (float) 4.75;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA3);
						break;

					case "4. NO ABRE EL LINK":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA5);
						break;
					case "6. NO IMPLEMENTÓ":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA8);
						break;
					}

					tblInformeCalificado6.setPeriodo(periodoInforme);
					if (rutaArchivo4 != "") {
						tblInformeCalificado6.setEvidencia(rutaArchivo4);
					} else {
						tblInformeCalificado6.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado6);

////////////////////////////////////////////cmbPregunta7///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                  

					tblInformeCalificado7.setInfCod(infcod);
					tblInformeCalificado7.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado7.setPregunta(
							"¿EL GAD SUSTENTA LA CONFORMACIÓN DEL EQUIPO TÉCNICO MIXTO PARA ORGANIZAR Y FACILITAR EL PROCESO DE RENDICIÓN DE CUENTAS?");
					tblInformeCalificado7.setRespuesta(cmbPregunta7);
					switch (cmbPregunta7) {
					case "1. ACTA DE CONFORMACIÓN DEL EQUIPO TÉCNICO MIXTO, DONDE SUSCRIBE EL GAD Y LOS REPRESENTANTES DE LA ACL/CIUDADANÍA":
						tblInformeCalificado7.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
						break;
					case "2. OFICIO DE LA ACL QUE INDICA AL GAD SUS DELEGADOS AL EQUIPO TÉCNICO MIXTO":
						tblInformeCalificado7.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA2);
						break;
					case "3. ACTA DE APROBACIÓN DE LA HOJA DE RUTA PARA LA RENDICIÓN DE CUENTAS, DONDE SUSCRIBE EL GAD Y LOS REPRESENTANTES DE LA ACL/CIUDADANÍA":
						tblInformeCalificado7.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
						break;
					case "4. ACTAS DE REUNIONES DE ELABORACIÓN DEL INFORME, DONDE TAMBIÉN SUSCRIBEN LOS REPRESENTANTES DE LA ACL/CIUDADANÍA":
						tblInformeCalificado7.setNota((float) 4.75);
						nota = nota + (float) 4.75;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
						break;
					case "5. ACTAS DE REUNIONES DE PLANIFICACIÓN DEL EVENTO DELIBERATIVO, DONDE TAMBIÉN SUSCRIBEN LOS REPRESENTANTES DE LA ACL/CIUDADANÍA":
						tblInformeCalificado7.setNota((float) 4.75);
						nota = nota + (float) 4.75;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
						break;
					case "6. NO ABRE EL LINK":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
						break;
					case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "8. NO IMPLEMENTÓ":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "9. OTROS, NO CUMPLE":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "10. VACÍO":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					}

					tblInformeCalificado7.setPeriodo(periodoInforme);
					if (rutaArchivo4_1 != "") {
						tblInformeCalificado7.setEvidencia(rutaArchivo4_1);
					} else {
						tblInformeCalificado7.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado7);

////////////////////////////////////////////cmbPregunta8///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                  

					tblInformeCalificado8.setInfCod(infcod);
					tblInformeCalificado8.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado8.setPregunta(
							"¿EL GAD SUSTENTA LA ENTREGA DEL INFORME PRELIMINAR Y FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL CON 15 DÍAS DE ANTELACIÓN?");
					tblInformeCalificado8.setRespuesta(cmbPregunta8);
					switch (cmbPregunta8) {
					case "1. DOCUMENTO DEL GAD EN EL QUE LA ACL/CIUDADANÍA AFIRMA HABER RECIBIDO EL INFORME & FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, CON 15 DÍAS DE ANTELACIÓN.":

						tblInformeCalificado8.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
						break;
					case "2. ENVÍO VIRTUAL DEL INFORME & FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, POR PARTE DEL GAD A LA ACL /CIUDADANÍA, Y CONFIRMACIÓN CIUDADANA DE RECIBIDO, CON 15 DÍAS DE ANTELACIÓN.":
						tblInformeCalificado8.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA2);
						break;
					case "3. NO ABRE EL LINK":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
						break;
					case "4. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
						break;
					case "5. NO IMPLEMENTÓ":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
						break;
					case "6. OTROS, NO CUMPLE":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
						break;
					case "7. VACÍO":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					}

					tblInformeCalificado8.setPeriodo(periodoInforme);
					if (rutaArchivo4_2 != "") {
						tblInformeCalificado8.setEvidencia(rutaArchivo4_2);
					} else {
						tblInformeCalificado8.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado8);

//////////////////////////////////////////////////////cmbPregunta9/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                  

					tblInformeCalificado9.setInfCod(infcod);
					tblInformeCalificado9.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado9.setPregunta(
							"¿EL GAD PERMITIÓ LA INTERVENCIÓN DE LA ACL/ CIUDADANÍA, COMO PARTE DE LA AGENDA DE LA DELIBERACIÓN PÚBLICA?");
					tblInformeCalificado9.setRespuesta(cmbPregunta9);
					switch (cmbPregunta9) {
					case "1. VIDEO EN EL QUE EL GAD DEMUESTRA QUE LA ACL/CIUDADANÍA SI TUVO UN TIEMPO PARA EVALUAR A LA ENTIDAD EN LA DELIBERACIÓN PÚBLICA":
						tblInformeCalificado9.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
						break;
					case "2. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO, DONDE SE EVIDENCIA QUE LA  ACL/CIUDADANÍA SI TUVO UN TIEMPO PARA EVALUAR A LA ENTIDAD":
						tblInformeCalificado9.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA2);
						break;
					case "3. VIDEO EN EL QUE EL GAD REALIZÓ LA DELIBERACIÓN PÚBLICA, PERO LA ASAMBLEA CIUDADANA /CIUDADANÍA NO TUVO UN TIEMPO PARA EVALUAR LA ENTIDAD EN LA DELIBERACIÓN PÚBLICA, NI SE ELABORARON SUGERENCIAS/RECOMENDACIONES AL GAD":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
						break;
					case "4. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO, DONDE SE EVIDENCIA QUE LA  ACL/CIUDADANÍA NO TUVO UN TIEMPO PARA EVALUAR A LA ENTIDAD, NI SE ELABORARON SUGERENCIAS/RECOMENDACIONES AL GAD":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
						break;
					case "5. NO ABRE EL LINK":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
						break;
					case "6. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
						break;
					case "7. NO IMPLEMENTÓ":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "8. OTROS, NO CUMPLE":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "9. VACÍO":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					}

					tblInformeCalificado9.setPeriodo(periodoInforme);
					if (rutaArchivo4_3 != "") {
						tblInformeCalificado9.setEvidencia(rutaArchivo4_3);
					} else {
						tblInformeCalificado9.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado9);

/////////////////////////////////////////cmbPregunta10//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                  

					tblInformeCalificado10.setInfCod(infcod);
					tblInformeCalificado10.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado10.setPregunta(
							"¿EL GAD SUSTENTA LA REALIZACIÓN DE LA DELIBERACIÓN PÚBLICA CON LA INTERVENCIÓN DE LA CIUDADANÍA?");
					tblInformeCalificado10.setRespuesta(cmbPregunta10);
					switch (cmbPregunta10) {
					case "1. VIDEO EN EL QUE EL GAD DEMUESTRA QUE LA ACL/CIUDADANÍA SI PARTICIPÓ DE LAS MESAS DE TRABAJO Y SI SE ELABORARON RECOMENDACIONES AL GAD":
						tblInformeCalificado10.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
						break;
					case "2. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO, DONDE SE EVIDENCIA QUE LA  ACL/CIUDADANÍA SI PARTICIPÓ DE LAS MESAS DE TRABAJO Y SI SE ELABORARON SUGERENCIAS/RECOMENDACIONES AL GAD":
						tblInformeCalificado10.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
						break;
					case "3. VIDEO EN EL QUE EL GAD DEMUESTRA QUE LA ACL/CIUDADANÍA SI PARTICIPÓ DE LAS MESAS DE TRABAJO PERO NO SE ELABORARON SUGERENCIAS/RECOMENDACIONES AL GAD":
						tblInformeCalificado10.setNota((float) 4.75);
						nota = nota + (float) 4.75;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
						break;
					case "4. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO, DONDE SE EVIDENCIA QUE LA  ACL/CIUDADANÍA SI PARTICIPÓ DE LAS MESAS DE TRABAJO PERO NO SE ELABORARON SUGERENCIAS/RECOMENDACIONES AL GAD":
						tblInformeCalificado10.setNota((float) 4.75);
						nota = nota + (float) 4.75;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
						break;
					case "5. VIDEO EN EL QUE EL GAD DEMUESTRA QUE NO DESARROLLÓ MESAS TEMÁTICAS EN SU DELIBERACIÓN PÚBLICA, PERO LA ACL/CIUDADANÍA SI PARTICIPÓ DE LAS MESAS DE TRABAJO":
						tblInformeCalificado10.setNota((float) 4.75);
						nota = nota + (float) 4.75;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
						break;
					case "6. NO ABRE EL LINK":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "8. NO IMPLEMENTÓ":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "9. OTROS, NO CUMPLE":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "10. VACÍO":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					}

					tblInformeCalificado10.setPeriodo(periodoInforme);
					if (rutaArchivo4_4 != "") {
						tblInformeCalificado10.setEvidencia(rutaArchivo4_4);
					} else {
						tblInformeCalificado10.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado10);

//////////////////////////////////////////cmbPregunta11////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                  

					tblInformeCalificado11.setInfCod(infcod);
					tblInformeCalificado11.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado11.setPregunta(
							"¿EL GAD ELABORÓ SU PLAN DE TRABAJO INCORPORANDO LAS SUGERENCIAS CIUDADANAS A SU GESTIÓN?");
					tblInformeCalificado11.setRespuesta(cmbPregunta11);
					switch (cmbPregunta11) {
					case "1. PLAN DE TRABAJO DEL GAD ELABORADO A PARTIR DE TODAS LAS SUGERENCIAS/RECOMENDACIONES DEL ACTA DE LA DELIBERACIÓN PÚBLICA":
						tblInformeCalificado11.setNota((float) 2.23);
						nota = nota + (float) 2.23;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
						break;
					case "2. PLAN DE TRABAJO DEL GAD ELABORADO A PARTIR DE ALGUNAS SUGERENCIAS/RECOMENDACIONES DEL ACTA DE LA DELIBERACIÓN PÚBLICA":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
						break;
					case "3. PLAN DE TRABAJO DEL GAD, PERO NO SE PUDO CONTRASTAR CON EL  ACTA DE LA DELIBERACIÓN PÚBLICA":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
						break;
					case "6. NO IMPLEMENTÓ":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					}

					tblInformeCalificado11.setPeriodo(periodoInforme);
					if (rutaArchivo4_5 != "") {
						tblInformeCalificado11.setEvidencia(rutaArchivo4_5);
					} else {
						tblInformeCalificado11.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado11);

//////////////////////////////////////////cmbPregunta12////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                  

					tblInformeCalificado12.setInfCod(infcod);
					tblInformeCalificado12.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado12.setPregunta(
							"¿EL GAD SUSTENTA LA ENTREGA DEL PLAN DE TRABAJO A LA ASAMBLEA CIUDADANA CON SU RESPECTIVO RECIBIDO?");
					tblInformeCalificado12.setRespuesta(cmbPregunta12);
					switch (cmbPregunta12) {
					case "1. DOCUMENTOS (DIGITAL O FÍSICO) CON EL RECIBIDO DE: LA ACL/ CIUDADANÍA Y/O DEL CONSEJO DE PARTICIPACIÓN E INSTANCIA DE PARTICIPACIÓN DEL GAD, DE CONSTANCIA DE ENTREGA DEL PLAN DE TRABAJO.":
						tblInformeCalificado12.setNota((float) 2.23);
						nota = nota + (float) 2.23;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
						break;
					case "2. NO ABRE EL LINK":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
						break;
					case "3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
						break;
					case "4. NO IMPLEMENTÓ":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
						break;
					case "5. OTROS, NO CUMPLE":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
						break;
					case "6. VACÍO":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;

					}

					tblInformeCalificado12.setPeriodo(periodoInforme);
					if (rutaArchivo4_6 != "") {
						tblInformeCalificado12.setEvidencia(rutaArchivo4_6);
					} else {
						tblInformeCalificado12.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado12);

//////////////////////////////////////////cmbPregunta13////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                  

					tblInformeCalificado13.setInfCod(infcod);
					tblInformeCalificado13.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado13.setPregunta(
							"¿EL GAD SUSTENTA LA ENTREGA DEL PLAN DE TRABAJO A LA ASAMBLEA CIUDADANA CON SU RESPECTIVO RECIBIDO?");
					tblInformeCalificado13.setRespuesta(cmbPregunta13);
					switch (cmbPregunta13) {
					case "1. DOCUMENTOS (DIGITAL O FÍSICO) CON EL RECIBIDO DE: LA ACL/ CIUDADANÍA Y/O DEL CONSEJO DE PARTICIPACIÓN E INSTANCIA DE PARTICIPACIÓN DEL GAD, DE CONSTANCIA DE ENTREGA DEL PLAN DE TRABAJO.":
						tblInformeCalificado13.setNota((float) 2.23);
						nota = nota + (float) 2.23;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
						break;
					case "2. NO ABRE EL LINK":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
						break;
					case "3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
						break;
					case "4. NO IMPLEMENTÓ":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
						break;
					case "5. OTROS, NO CUMPLE":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
						break;
					case "6. VACÍO":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;

					}

					tblInformeCalificado13.setPeriodo(periodoInforme);
					if (rutaArchivo4_7 != "") {
						tblInformeCalificado13.setEvidencia(rutaArchivo4_7);
					} else {
						tblInformeCalificado13.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado13);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}
				//////whether codigo != null then update
			} else {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado6 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado7 = ics.ObtenerRegistroXidInfCal(codigo1);
					tblInformeCalificado8 = ics.ObtenerRegistroXidInfCal(codigo2);
					tblInformeCalificado9 = ics.ObtenerRegistroXidInfCal(codigo3);
					tblInformeCalificado10 = ics.ObtenerRegistroXidInfCal(codigo4);
					
					
					tblInformeCalificado6.setInfCod(infcod);
					tblInformeCalificado6.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado6.setPregunta(
							"¿EL GAD SUSTENTA LA RECEPCIÓN DEL LISTADO DE TEMAS SOBRE LOS CUALES LA CIUDADANÍA SOLICITA QUE SE RINDA CUENTAS?");
					tblInformeCalificado6.setRespuesta(cmbPregunta6);
					switch (cmbPregunta6) {
					case "1. OFICIO O DOCUMENTO FIRMADO POR LOS CIUDADANOS (FÍSICO O DIGITAL), DEL LISTADO DE TEMAS SOBRE LOS CUALES SOLICITA A LA AUTORIDAD DEL GAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO":
						tblInformeCalificado6.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA1);
						break;
					case "2. ACTA DE REUNIÓN DONDE CONSTA EL LISTADO DE TEMAS SOBRE LOS CUALES SOLICITA A LA AUTORIDAD DEL GAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO":
						tblInformeCalificado6.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA2);
						break;
					case "3. CAPTURA DE PANTALLA DE LOS  TEMAS SOBRE LOS CUALES LA CIUDADANÍA SOLICITA POR CORREO Y/O MEDIOS VIRTUALES A LA AUTORIDAD DEL GAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO":
						tblInformeCalificado6.setNota((float) 4.75);
						nota = nota + (float) 4.75;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA3);
						break;

					case "4. NO ABRE EL LINK":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA5);
						break;
					case "6. NO IMPLEMENTÓ":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA8);
						break;
					}

					tblInformeCalificado6.setPeriodo(periodoInforme);
					if (rutaArchivo4 != "") {
						tblInformeCalificado6.setEvidencia(rutaArchivo4);
					} else {
						tblInformeCalificado6.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado6);

					////////////////////////////////////////////////////////////////////////////////////////////////////////

					tblInformeCalificado7.setInfCod(infcod);
					tblInformeCalificado7.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado7.setPregunta(
							"¿EL GAD SUSTENTA LA ENTREGA DEL INFORME PRELIMINAR Y FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL CON 15 DÍAS DE ANTELACIÓN?");
					tblInformeCalificado7.setRespuesta(cmbPregunta7);
					switch (cmbPregunta7) {
					case "1. ACTA DE CONFORMACIÓN DEL EQUIPO TÉCNICO MIXTO, DONDE SUSCRIBE EL GAD Y LOS REPRESENTANTES DE LA ACL/CIUDADANÍA":
						tblInformeCalificado7.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
						break;
					case "2. OFICIO DE LA ACL QUE INDICA AL GAD SUS DELEGADOS AL EQUIPO TÉCNICO MIXTO":
						tblInformeCalificado7.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA2);
						break;
					case "3. ACTA DE APROBACIÓN DE LA HOJA DE RUTA PARA LA RENDICIÓN DE CUENTAS, DONDE SUSCRIBE EL GAD Y LOS REPRESENTANTES DE LA ACL/CIUDADANÍA":
						tblInformeCalificado7.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
						break;
					case "4. ACTAS DE REUNIONES DE ELABORACIÓN DEL INFORME, DONDE TAMBIÉN SUSCRIBEN LOS REPRESENTANTES DE LA ACL/CIUDADANÍA":
						tblInformeCalificado7.setNota((float) 4.75);
						nota = nota + (float) 4.75;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
						break;
					case "5. ACTAS DE REUNIONES DE PLANIFICACIÓN DEL EVENTO DELIBERATIVO, DONDE TAMBIÉN SUSCRIBEN LOS REPRESENTANTES DE LA ACL/CIUDADANÍA":
						tblInformeCalificado7.setNota((float) 4.75);
						nota = nota + (float) 4.75;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
						break;
					case "6. NO ABRE EL LINK":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
						break;
					case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "8. NO IMPLEMENTÓ":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "9. OTROS, NO CUMPLE":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "10. VACÍO":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					}

					tblInformeCalificado7.setPeriodo(periodoInforme);
					if (rutaArchivo4_1 != "") {
						tblInformeCalificado7.setEvidencia(rutaArchivo4_1);
					} else {
						tblInformeCalificado7.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado7);
					
					//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

					tblInformeCalificado8.setInfCod(infcod);
					tblInformeCalificado8.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado8.setPregunta(
							"¿EL GAD SUSTENTA LA REALIZACIÓN DEL VIDEO DE LA DELIBERACIÓN PÚBLICA CON LA INTERVENCIÓN DE LA CIUDADANÍA?");
					tblInformeCalificado8.setRespuesta(cmbPregunta8);
					switch (cmbPregunta8) {
					case "1. DOCUMENTO DEL GAD EN EL QUE LA ACL/CIUDADANÍA AFIRMA HABER RECIBIDO EL INFORME & FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, CON 15 DÍAS DE ANTELACIÓN.":

						tblInformeCalificado8.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
						break;
					case "2. ENVÍO VIRTUAL DEL INFORME & FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, POR PARTE DEL GAD A LA ACL /CIUDADANÍA, Y CONFIRMACIÓN CIUDADANA DE RECIBIDO, CON 15 DÍAS DE ANTELACIÓN.":
						tblInformeCalificado8.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA2);
						break;
					case "3. NO ABRE EL LINK":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
						break;
					case "4. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
						break;
					case "5. NO IMPLEMENTÓ":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
						break;
					case "6. OTROS, NO CUMPLE":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
						break;
					case "7. VACÍO":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					}

					tblInformeCalificado8.setPeriodo(periodoInforme);
					if (rutaArchivo4_2 != "") {
						tblInformeCalificado8.setEvidencia(rutaArchivo4_2);
					} else {
						tblInformeCalificado8.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado8);
					/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

					tblInformeCalificado9.setInfCod(infcod);
					tblInformeCalificado9.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado9.setPregunta(
							"¿EL GAD SUSTENTA EL PLAN DE TRABAJO QUE INCORPORA LAS SUGERENCIAS CIUDADANAS EN SU GESTIÓN?");
					tblInformeCalificado9.setRespuesta(cmbPregunta9);
					switch (cmbPregunta9) {
					case "1. VIDEO EN EL QUE EL GAD DEMUESTRA QUE LA ACL/CIUDADANÍA SI TUVO UN TIEMPO PARA EVALUAR A LA ENTIDAD EN LA DELIBERACIÓN PÚBLICA":
						tblInformeCalificado9.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
						break;
					case "2. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO, DONDE SE EVIDENCIA QUE LA  ACL/CIUDADANÍA SI TUVO UN TIEMPO PARA EVALUAR A LA ENTIDAD":
						tblInformeCalificado9.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA2);
						break;
					case "3. VIDEO EN EL QUE EL GAD REALIZÓ LA DELIBERACIÓN PÚBLICA, PERO LA ASAMBLEA CIUDADANA /CIUDADANÍA NO TUVO UN TIEMPO PARA EVALUAR LA ENTIDAD EN LA DELIBERACIÓN PÚBLICA, NI SE ELABORARON SUGERENCIAS/RECOMENDACIONES AL GAD":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
						break;
					case "4. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO, DONDE SE EVIDENCIA QUE LA  ACL/CIUDADANÍA NO TUVO UN TIEMPO PARA EVALUAR A LA ENTIDAD, NI SE ELABORARON SUGERENCIAS/RECOMENDACIONES AL GAD":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
						break;
					case "5. NO ABRE EL LINK":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
						break;
					case "6. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
						break;
					case "7. NO IMPLEMENTÓ":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "8. OTROS, NO CUMPLE":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "9. VACÍO":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					}

					tblInformeCalificado9.setPeriodo(periodoInforme);
					if (rutaArchivo4_3 != "") {
						tblInformeCalificado9.setEvidencia(rutaArchivo4_3);
					} else {
						tblInformeCalificado9.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado9);
					//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

					tblInformeCalificado10.setInfCod(infcod);
					tblInformeCalificado10.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado10.setPregunta(
							"¿EL GAD SUSTENTA LA ENTREGA DEL PLAN DE TRABAJO A LA ASAMBLEA CIUDADANA CON SU RESPECTIVO RECIBIDO?");
					tblInformeCalificado10.setRespuesta(cmbPregunta10);
					switch (cmbPregunta10) {
					case "1. VIDEO EN EL QUE EL GAD DEMUESTRA QUE LA ACL/CIUDADANÍA SI PARTICIPÓ DE LAS MESAS DE TRABAJO Y SI SE ELABORARON RECOMENDACIONES AL GAD":
						tblInformeCalificado10.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
						break;
					case "2. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO, DONDE SE EVIDENCIA QUE LA  ACL/CIUDADANÍA SI PARTICIPÓ DE LAS MESAS DE TRABAJO Y SI SE ELABORARON SUGERENCIAS/RECOMENDACIONES AL GAD":
						tblInformeCalificado10.setNota((float) 9.50);
						nota = nota + (float) 9.50;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
						break;
					case "3. VIDEO EN EL QUE EL GAD DEMUESTRA QUE LA ACL/CIUDADANÍA SI PARTICIPÓ DE LAS MESAS DE TRABAJO PERO NO SE ELABORARON SUGERENCIAS/RECOMENDACIONES AL GAD":
						tblInformeCalificado10.setNota((float) 4.75);
						nota = nota + (float) 4.75;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
						break;
					case "4. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO, DONDE SE EVIDENCIA QUE LA  ACL/CIUDADANÍA SI PARTICIPÓ DE LAS MESAS DE TRABAJO PERO NO SE ELABORARON SUGERENCIAS/RECOMENDACIONES AL GAD":
						tblInformeCalificado10.setNota((float) 4.75);
						nota = nota + (float) 4.75;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
						break;
					case "5. VIDEO EN EL QUE EL GAD DEMUESTRA QUE NO DESARROLLÓ MESAS TEMÁTICAS EN SU DELIBERACIÓN PÚBLICA, PERO LA ACL/CIUDADANÍA SI PARTICIPÓ DE LAS MESAS DE TRABAJO":
						tblInformeCalificado10.setNota((float) 4.75);
						nota = nota + (float) 4.75;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
						break;
					case "6. NO ABRE EL LINK":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "8. NO IMPLEMENTÓ":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "9. OTROS, NO CUMPLE":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					case "10. VACÍO":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					}

					tblInformeCalificado10.setPeriodo(periodoInforme);
					if (rutaArchivo4_4 != "") {
						tblInformeCalificado10.setEvidencia(rutaArchivo4_4);
					} else {
						tblInformeCalificado10.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado10);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}

			}
			mensaje.put("estado", "exito");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			mensaje.put("codigo", tblInformeCalificado6.getIdInfCal());
			mensaje.put("codigo1", tblInformeCalificado7.getIdInfCal());
			mensaje.put("codigo2", tblInformeCalificado8.getIdInfCal());
			mensaje.put("codigo3", tblInformeCalificado9.getIdInfCal());
			mensaje.put("codigo4", tblInformeCalificado10.getIdInfCal());

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	
	/**** Matriz 6 ***/
	@SuppressWarnings("finally")
	@RequestMapping(value = "/GuardarFrmGADP6")
	public @ResponseBody String GuardarFrmGADP6(HttpServletRequest request,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, @RequestParam("cmbPregunta11") String cmbPregunta11,
			@RequestParam("rutaArchivo5") String rutaArchivo5, @RequestParam("periodoInforme") Integer periodoInforme,
			@RequestParam("pre6") Integer codigo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {

			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
			TblInformeCalificado tblInformeCalificado11 = new TblInformeCalificado();

			if (codigo == null) {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado11.setInfCod(infcod);
					tblInformeCalificado11.setMatriz(
							"CUMPLIMIENTO DEL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR IMPLEMENTADAS EN LA GESTIÓN INSTITUCIONAL");
					tblInformeCalificado11.setPregunta(
							"¿EL GAD SUSTENTA HABER CUMPLIDO EL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR, EN SU GESTIÓN INSTITUCIONAL?");
					tblInformeCalificado11.setRespuesta(cmbPregunta11);
					switch (cmbPregunta11) {
					case "1. ACTA, INFORME O DOCUMENTO OFICIAL QUE DEMUESTRA LA IMPLEMENTACIÓN":
						tblInformeCalificado11.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. NO APLICA, PORQUE SE CREA EN EL AÑO DE RENDICIÓN DE CUENTAS":
						tblInformeCalificado11.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "3. NO APLICA, PORQUE EL PROCESO ANTERIOR NO RECIBIÓ APORTES":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "6. NO APLICA":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado11.setPeriodo(periodoInforme);
					if (rutaArchivo5 != "") {
						tblInformeCalificado11.setEvidencia(rutaArchivo5);
					} else {
						tblInformeCalificado11.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado11);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}
			} else {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado11 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado11.setInfCod(infcod);
					tblInformeCalificado11.setMatriz(
							"CUMPLIMIENTO DEL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR IMPLEMENTADAS EN LA GESTIÓN INSTITUCIONAL");
					tblInformeCalificado11.setPregunta(
							"¿EL GAD SUSTENTA HABER CUMPLIDO EL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR, EN SU GESTIÓN INSTITUCIONAL?");
					tblInformeCalificado11.setRespuesta(cmbPregunta11);
					switch (cmbPregunta11) {
					case "1. ACTA, INFORME O DOCUMENTO OFICIAL QUE DEMUESTRA LA IMPLEMENTACIÓN":
						tblInformeCalificado11.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. NO APLICA, PORQUE SE CREA EN EL AÑO DE RENDICIÓN DE CUENTAS":
						tblInformeCalificado11.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "3. NO APLICA, PORQUE EL PROCESO ANTERIOR NO RECIBIÓ APORTES":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "6. NO APLICA":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado11.setPeriodo(periodoInforme);
					if (rutaArchivo5 != "") {
						tblInformeCalificado11.setEvidencia(rutaArchivo5);
					} else {
						tblInformeCalificado11.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado11);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}

			}
			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado11.getIdInfCal());
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	
	/**** Matriz 7 ***/
	@SuppressWarnings("finally")
	@RequestMapping(value = "/GuardarFrmGADP7")
	public @ResponseBody String GuardarFrmGADP7(HttpServletRequest request,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, @RequestParam("cmbPregunta12") String cmbPregunta12,
			@RequestParam("cmbPregunta13") String cmbPregunta13, @RequestParam("periodoInforme") Integer periodoInforme,
			@RequestParam("rutaArchivo6") String rutaArchivo6, @RequestParam("rutaArchivo6_1") String rutaArchivo6_1,
			@RequestParam("pre7") Integer codigo, @RequestParam("pre7_1") Integer codigo1) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {

			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
			TblInformeCalificado tblInformeCalificado12 = new TblInformeCalificado();
			TblInformeCalificado tblInformeCalificado13 = new TblInformeCalificado();

			if (codigo == null) {
				if (datosInformeValorado.size() == 0) {

					tblInformeCalificado12.setInfCod(infcod);
					tblInformeCalificado12.setMatriz("PRESUPUESTO PARTICIPATIVO");
					tblInformeCalificado12.setPregunta("¿EL GAD REALIZÓ EL PRESUPUESTO PARTICIPATIVO?");
					tblInformeCalificado12.setRespuesta(cmbPregunta12);
					switch (cmbPregunta12) {
					case "SI":
						tblInformeCalificado12.setNota((float) 5.55);
						nota = nota + (float) 5.55;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "NO":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					}

					tblInformeCalificado12.setPeriodo(periodoInforme);
					if (rutaArchivo6 != "") {
						tblInformeCalificado12.setEvidencia(rutaArchivo6);
					} else {
						tblInformeCalificado12.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado12);

					tblInformeCalificado13.setInfCod(infcod);
					tblInformeCalificado13.setMatriz("PRESUPUESTO PARTICIPATIVO");
					tblInformeCalificado13.setPregunta(
							"¿COINCIDEN LOS VALORES DEL PRESUPUESTO PARTICIPATIVO DEL FORMULARIO CON EL MEDIO DE VERIFICACIÓN?");
					tblInformeCalificado13.setRespuesta(cmbPregunta13);
					switch (cmbPregunta13) {
					case "1. SI, CÉDULA PRESUPUESTARIA del GAD, QUE DETALLA EL VALOR REPORTADO, DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO PARTICIPATIVO Y LA EJECUCIÓN DEL MISMO":
						tblInformeCalificado13.setNota((float) 5.55);
						nota = nota + (float) 5.55;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. SI, ADJUNTAN ACTA DE LA ASAMBLEA DEL GAD, QUE DETALLA EL VALOR REPORTADO, DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO PARTICIPATIVO Y LA EJECUCIÓN DEL MISMO":
						tblInformeCalificado13.setNota((float) 5.55);
						nota = nota + (float) 5.55;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "3. SI, ADJUNTAN UN DOCUMENTO OFICIAL DEL GAD, QUE DETALLA EL VALOR REPORTADO, DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO PARTICIPATIVO Y LA EJECUCIÓN DEL MISMO":
						tblInformeCalificado13.setNota((float) 5.55);
						nota = nota + (float) 5.55;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "6. NO APLICA":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado13.setPeriodo(periodoInforme);
					if (rutaArchivo6_1 != "") {
						tblInformeCalificado13.setEvidencia(rutaArchivo6_1);
					} else {
						tblInformeCalificado13.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado13);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}
			} else {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado12 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado13 = ics.ObtenerRegistroXidInfCal(codigo1);

					tblInformeCalificado12.setInfCod(infcod);
					tblInformeCalificado12.setMatriz("PRESUPUESTO PARTICIPATIVO");
					tblInformeCalificado12.setPregunta("¿EL GAD REALIZÓ EL PRESUPUESTO PARTICIPATIVO?");
					tblInformeCalificado12.setRespuesta(cmbPregunta12);
					switch (cmbPregunta12) {
					case "SI":
						tblInformeCalificado12.setNota((float) 5.55);
						nota = nota + (float) 5.55;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "NO":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					}

					tblInformeCalificado12.setPeriodo(periodoInforme);
					if (rutaArchivo6 != "") {
						tblInformeCalificado12.setEvidencia(rutaArchivo6);
					} else {
						tblInformeCalificado12.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado12);

					tblInformeCalificado13.setInfCod(infcod);
					tblInformeCalificado13.setMatriz("PRESUPUESTO PARTICIPATIVO");
					tblInformeCalificado13.setPregunta(
							"¿COINCIDEN LOS VALORES DEL PRESUPUESTO PARTICIPATIVO DEL FORMULARIO CON EL MEDIO DE VERIFICACIÓN?");
					tblInformeCalificado13.setRespuesta(cmbPregunta13);
					switch (cmbPregunta13) {
					case "1. SI, CÉDULA PRESUPUESTARIA del GAD, QUE DETALLA EL VALOR REPORTADO, DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO PARTICIPATIVO Y LA EJECUCIÓN DEL MISMO":
						tblInformeCalificado13.setNota((float) 5.55);
						nota = nota + (float) 5.55;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. SI, ADJUNTAN ACTA DE LA ASAMBLEA DEL GAD, QUE DETALLA EL VALOR REPORTADO, DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO PARTICIPATIVO Y LA EJECUCIÓN DEL MISMO":
						tblInformeCalificado13.setNota((float) 5.55);
						nota = nota + (float) 5.55;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "3. SI, ADJUNTAN UN DOCUMENTO OFICIAL DEL GAD, QUE DETALLA EL VALOR REPORTADO, DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO PARTICIPATIVO Y LA EJECUCIÓN DEL MISMO":
						tblInformeCalificado13.setNota((float) 5.55);
						nota = nota + (float) 5.55;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "6. NO APLICA":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado13.setPeriodo(periodoInforme);
					if (rutaArchivo6_1 != "") {
						tblInformeCalificado13.setEvidencia(rutaArchivo6_1);
					} else {
						tblInformeCalificado13.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado13);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}

			}
			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado12.getIdInfCal());
			mensaje.put("codigo1", tblInformeCalificado13.getIdInfCal());
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}


	/**** Matriz 8 ***/
	@SuppressWarnings("finally")
	@RequestMapping(value = "/GuardarFrmGADP8")
	
public @ResponseBody String GuardarFrmGADP8(HttpServletRequest request,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, @RequestParam("rutaArchivo7") String rutaArchivo7,
			@RequestParam("cmbPregunta14") String cmbPregunta14, @RequestParam("periodoInforme") Integer periodoInforme,
			@RequestParam("pre8") Integer codigo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {

			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
			TblInformeCalificado tblInformeCalificado14 = new TblInformeCalificado();

			if (codigo == null) {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado14.setInfCod(infcod);
					tblInformeCalificado14.setMatriz("DETALLE DEL PRESUPUESTO PARTICIPATIVO");
					tblInformeCalificado14
							.setPregunta("¿EL GAD SUSTENTA LOS VALORES EJECUTADOS DEL PRESUPUESTO PARTICIPATIVO?");
					tblInformeCalificado14.setRespuesta(cmbPregunta14);
					switch (cmbPregunta14) {
					case "1. ACTA":
						tblInformeCalificado14.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. INFORME DE CUMPLIMIENTO":
						tblInformeCalificado14.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "3. DOCUMENTO OFICIAL DEL GAD QUE EVIDENCIA LA EJECUCIÓN DEL COMPROMISO ASUMIDO, A PARTIR DE LO PROPUESTO POR LA CIUDADANÍA EN EL PRESUPUESTO PARTICIPATIVO, EN EL EJERCICIO FISCAL ANTERIOR":
						tblInformeCalificado14.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado14.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado14.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "6. RESPONDE EN 0":
						tblInformeCalificado14.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado14.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado14.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado14.setPeriodo(periodoInforme);
					if (rutaArchivo7 != "") {
						tblInformeCalificado14.setEvidencia(rutaArchivo7);
					} else {
						tblInformeCalificado14.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado14);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}
			} else {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado14 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado14.setInfCod(infcod);
					tblInformeCalificado14.setMatriz("DETALLE DEL PRESUPUESTO PARTICIPATIVO");
					tblInformeCalificado14
							.setPregunta("¿EL GAD SUSTENTA LOS VALORES EJECUTADOS DEL PRESUPUESTO PARTICIPATIVO?");
					tblInformeCalificado14.setRespuesta(cmbPregunta14);
					switch (cmbPregunta14) {
					case "1. ACTA":
						tblInformeCalificado14.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. INFORME DE CUMPLIMIENTO":
						tblInformeCalificado14.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "3. DOCUMENTO OFICIAL DEL GAD QUE EVIDENCIA LA EJECUCIÓN DEL COMPROMISO ASUMIDO, A PARTIR DE LO PROPUESTO POR LA CIUDADANÍA EN EL PRESUPUESTO PARTICIPATIVO, EN EL EJERCICIO FISCAL ANTERIOR":
						tblInformeCalificado14.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado14.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado14.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "6. RESPONDE EN 0":
						tblInformeCalificado14.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado14.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado14.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado14.setPeriodo(periodoInforme);
					if (rutaArchivo7 != "") {
						tblInformeCalificado14.setEvidencia(rutaArchivo7);
					} else {
						tblInformeCalificado14.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado14);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}

			}
			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado14.getIdInfCal());
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	
	/**** Matriz 9 ***/
	@SuppressWarnings("finally")
	@RequestMapping(value = "/GuardarFrmGADP9")
	public @ResponseBody String GuardarFrmGADP9(HttpServletRequest request,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, @RequestParam("cmbPregunta15") String cmbPregunta15,
			@RequestParam("rutaArchivo8") String rutaArchivo8, @RequestParam("periodoInforme") Integer periodoInforme,
			@RequestParam("pre9") Integer codigo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {

			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
			TblInformeCalificado tblInformeCalificado15 = new TblInformeCalificado();

			if (codigo == null) {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado15.setInfCod(infcod);
					tblInformeCalificado15.setMatriz("SISTEMA DE PARTICIPACIÓN CIUDADANA");
					tblInformeCalificado15
							.setPregunta("¿EL GAD SUSTENTA QUE MANTIENE ACTIVO EL SISTEMA DE PARTICIPACIÓN CIUDADANA?");
					tblInformeCalificado15.setRespuesta(cmbPregunta15);
					switch (cmbPregunta15) {
					case "1. ORDENANZA, EN EL CASO DEL GAD CANTONAL O PROVINCIAL":
						tblInformeCalificado15.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. RESOLUCIÓN, EN EL CASO DE LOS GAD PARROQUIALES":
						tblInformeCalificado15.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "3. NO ABRE EL LINK":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "4. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "5. NO APLICA":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "6. OTROS, NO CUMPLE":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "7. VACÍO":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado15.setPeriodo(periodoInforme);
					if (rutaArchivo8 != "") {
						tblInformeCalificado15.setEvidencia(rutaArchivo8);
					} else {
						tblInformeCalificado15.setEvidencia("N/A");
					}

					ics.guardarInformeCalificacion(tblInformeCalificado15);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}
			} else {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado15 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado15.setInfCod(infcod);
					tblInformeCalificado15.setMatriz("SISTEMA DE PARTICIPACIÓN CIUDADANA");
					tblInformeCalificado15
							.setPregunta("¿EL GAD SUSTENTA QUE MANTIENE ACTIVO EL SISTEMA DE PARTICIPACIÓN CIUDADANA?");
					tblInformeCalificado15.setRespuesta(cmbPregunta15);
					switch (cmbPregunta15) {
					case "1. ORDENANZA, EN EL CASO DEL GAD CANTONAL O PROVINCIAL":
						tblInformeCalificado15.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. RESOLUCIÓN, EN EL CASO DE LOS GAD PARROQUIALES":
						tblInformeCalificado15.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "3. NO ABRE EL LINK":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "4. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "5. NO APLICA":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "6. OTROS, NO CUMPLE":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "7. VACÍO":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado15.setPeriodo(periodoInforme);
					if (rutaArchivo8 != "") {
						tblInformeCalificado15.setEvidencia(rutaArchivo8);
					} else {
						tblInformeCalificado15.setEvidencia("N/A");
					}

					ics.guardarInformeCalificacion(tblInformeCalificado15);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}

			}
			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado15.getIdInfCal());
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	
	/**** Matriz 10 ***/
	@SuppressWarnings("finally")
	@RequestMapping(value = "/GuardarFrmGADP10")
	public @ResponseBody String GuardarFrmGADP10(HttpServletRequest request,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, @RequestParam("cmbPregunta16") String cmbPregunta16,
			@RequestParam("rutaArchivo9") String rutaArchivo9, @RequestParam("periodoInforme") Integer periodoInforme,
			@RequestParam("pre10") Integer codigo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {

			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
			TblInformeCalificado tblInformeCalificado16 = new TblInformeCalificado();

			if (codigo == null) {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado16.setInfCod(infcod);
					tblInformeCalificado16.setMatriz("MECANISMOS DE CONTROL SOCIAL");
					tblInformeCalificado16
							.setPregunta("¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?");
					tblInformeCalificado16.setRespuesta(cmbPregunta16);
					switch (cmbPregunta16) {
					case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
						tblInformeCalificado16.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA1);
						break;
					case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE	ASISTENCIAS":
						tblInformeCalificado16.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA2);
						break;
					case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
						tblInformeCalificado16.setNota((float) 5.56);
						nota = nota + (float) 5.56;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA3);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA5);
						break;
					case "6. NO APLICA":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA8);
						break;
					}

					tblInformeCalificado16.setPeriodo(periodoInforme);
					if (rutaArchivo9 != "") {
						tblInformeCalificado16.setEvidencia(rutaArchivo9);
					} else {
						tblInformeCalificado16.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado16);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}
			} else {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado16 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado16.setInfCod(infcod);
					tblInformeCalificado16.setMatriz("MECANISMOS DE CONTROL SOCIAL");
					tblInformeCalificado16
							.setPregunta("¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?");
					tblInformeCalificado16.setRespuesta(cmbPregunta16);
					switch (cmbPregunta16) {
					case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
						tblInformeCalificado16.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA1);
						break;
					case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE	ASISTENCIAS":
						tblInformeCalificado16.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA2);
						break;
					case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
						tblInformeCalificado16.setNota((float) 5.56);
						nota = nota + (float) 5.56;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA3);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA5);
						break;
					case "6. NO APLICA":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA8);
						break;
					}

					tblInformeCalificado16.setPeriodo(periodoInforme);
					if (rutaArchivo9 != "") {
						tblInformeCalificado16.setEvidencia(rutaArchivo9);
					} else {
						tblInformeCalificado16.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado16);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}

			}
			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado16.getIdInfCal());
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	
	/**** Matriz 11 ***/
	@SuppressWarnings("finally")
	@RequestMapping(value = "/GuardarFrmGADP11")
	public @ResponseBody String GuardarFrmGADP11(HttpServletRequest request,
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, @RequestParam("cmbPregunta17") String cmbPregunta17,
			@RequestParam("cmbPregunta18") String cmbPregunta18, @RequestParam("cmbPregunta19") String cmbPregunta19,
			@RequestParam("cmbPregunta20") String cmbPregunta20, @RequestParam("cmbPregunta21") String cmbPregunta21,
			@RequestParam("periodoInforme") Integer periodoInforme, @RequestParam("pre11") Integer codigo,
			@RequestParam(value = "pre11_1", required = false) Integer codigo1,
			@RequestParam(value = "pre11_2", required = false) Integer codigo2,
			@RequestParam(value = "pre11_3", required = false) Integer codigo3,
			@RequestParam(value = "pre11_4", required = false) Integer codigo4)

	{
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {

			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
			TblInformeCalificado tblInformeCalificado17 = new TblInformeCalificado();
			TblInformeCalificado tblInformeCalificado18 = new TblInformeCalificado();
			TblInformeCalificado tblInformeCalificado19 = new TblInformeCalificado();
			TblInformeCalificado tblInformeCalificado20 = new TblInformeCalificado();
			TblInformeCalificado tblInformeCalificado21 = new TblInformeCalificado();

			if (codigo == null) {
				if (datosInformeValorado.size() == 0) {

					tblInformeCalificado17.setInfCod(infcod);
					tblInformeCalificado17.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado17.setPregunta(
							"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?");
					tblInformeCalificado17.setRespuesta(cmbPregunta17);
					switch (cmbPregunta17) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado17.setNota((float) 2.22);
						nota = nota + (float) 2.22;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado17.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado17.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado17.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado17.setPeriodo(periodoInforme);
					tblInformeCalificado17.setEvidencia("N/A");
					ics.guardarInformeCalificacion(tblInformeCalificado17);

					tblInformeCalificado18.setInfCod(infcod);
					tblInformeCalificado18.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado18.setPregunta(
							"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?");
					tblInformeCalificado18.setRespuesta(cmbPregunta18);
					switch (cmbPregunta18) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado18.setNota((float) 2.22);
						nota = nota + (float) 2.22;
						tblInformeCalificado18.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado18.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado18.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado18.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado18.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado18.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado18.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado18.setPeriodo(periodoInforme);
					tblInformeCalificado18.setEvidencia("N/A");
					ics.guardarInformeCalificacion(tblInformeCalificado18);

					tblInformeCalificado19.setInfCod(infcod);
					tblInformeCalificado19.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado19.setPregunta(
							"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?");
					tblInformeCalificado19.setRespuesta(cmbPregunta19);
					switch (cmbPregunta19) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado19.setNota((float) 2.22);
						nota = nota + (float) 2.22;
						tblInformeCalificado19.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado19.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado19.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado19.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado19.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado19.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado19.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado19.setPeriodo(periodoInforme);
					tblInformeCalificado19.setEvidencia("N/A");
					ics.guardarInformeCalificacion(tblInformeCalificado19);

					tblInformeCalificado20.setInfCod(infcod);
					tblInformeCalificado20.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado20.setPregunta(
							"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?");
					tblInformeCalificado20.setRespuesta(cmbPregunta20);
					switch (cmbPregunta20) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado20.setNota((float) 2.22);
						nota = nota + (float) 2.22;
						tblInformeCalificado20.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado20.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado20.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado20.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado20.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado20.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado20.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado20.setPeriodo(periodoInforme);
					tblInformeCalificado20.setEvidencia("N/A");
					ics.guardarInformeCalificacion(tblInformeCalificado20);

					tblInformeCalificado21.setInfCod(infcod);
					tblInformeCalificado21.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado21.setPregunta(
							"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?");
					tblInformeCalificado21.setRespuesta(cmbPregunta21);
					switch (cmbPregunta21) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado21.setNota((float) 2.22);
						nota = nota + (float) 2.22;
						tblInformeCalificado21.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado21.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado21.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado21.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado21.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado21.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado21.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado21.setPeriodo(periodoInforme);

					ics.guardarInformeCalificacion(tblInformeCalificado21);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}
			} else {
				if (datosInformeValorado.size() == 0) {
					tblInformeCalificado17 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado18 = ics.ObtenerRegistroXidInfCal(codigo1);
					tblInformeCalificado19 = ics.ObtenerRegistroXidInfCal(codigo2);
					tblInformeCalificado20 = ics.ObtenerRegistroXidInfCal(codigo3);
					tblInformeCalificado21 = ics.ObtenerRegistroXidInfCal(codigo4);
					tblInformeCalificado17.setInfCod(infcod);
					tblInformeCalificado17.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado17.setPregunta(
							"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?");
					tblInformeCalificado17.setRespuesta(cmbPregunta17);
					switch (cmbPregunta17) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado17.setNota((float) 2.22);
						nota = nota + (float) 2.22;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado17.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado17.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado17.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado17.setPeriodo(periodoInforme);
					tblInformeCalificado17.setEvidencia("N/A");
					ics.guardarInformeCalificacion(tblInformeCalificado17);

					tblInformeCalificado18.setInfCod(infcod);
					tblInformeCalificado18.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado18.setPregunta(
							"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?");
					tblInformeCalificado18.setRespuesta(cmbPregunta18);
					switch (cmbPregunta18) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado18.setNota((float) 2.22);
						nota = nota + (float) 2.22;
						tblInformeCalificado18.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado18.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado18.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado18.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado18.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado18.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado18.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado18.setPeriodo(periodoInforme);
					tblInformeCalificado18.setEvidencia("N/A");
					ics.guardarInformeCalificacion(tblInformeCalificado18);

					tblInformeCalificado19.setInfCod(infcod);
					tblInformeCalificado19.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado19.setPregunta(
							"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?");
					tblInformeCalificado19.setRespuesta(cmbPregunta19);
					switch (cmbPregunta19) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado19.setNota((float) 2.22);
						nota = nota + (float) 2.22;
						tblInformeCalificado19.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado19.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado19.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado19.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado19.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado19.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado19.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado19.setPeriodo(periodoInforme);
					tblInformeCalificado19.setEvidencia("N/A");
					ics.guardarInformeCalificacion(tblInformeCalificado19);

					tblInformeCalificado20.setInfCod(infcod);
					tblInformeCalificado20.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado20.setPregunta(
							"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?");
					tblInformeCalificado20.setRespuesta(cmbPregunta20);
					switch (cmbPregunta20) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado20.setNota((float) 2.22);
						nota = nota + (float) 2.22;
						tblInformeCalificado20.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado20.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado20.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado20.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado20.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado20.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado20.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado20.setPeriodo(periodoInforme);
					tblInformeCalificado20.setEvidencia("N/A");
					ics.guardarInformeCalificacion(tblInformeCalificado20);

					tblInformeCalificado21.setInfCod(infcod);
					tblInformeCalificado21.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado21.setPregunta(
							"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?");
					tblInformeCalificado21.setRespuesta(cmbPregunta21);
					switch (cmbPregunta21) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado21.setNota((float) 2.22);
						nota = nota + (float) 2.22;
						tblInformeCalificado21.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado21.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado21.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado21.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado21.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado21.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado21.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado21.setPeriodo(periodoInforme);

					ics.guardarInformeCalificacion(tblInformeCalificado21);

				} else {
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "Este informe ya fue calificado!");
				}

			}
			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado17.getIdInfCal());
			mensaje.put("codigo1", tblInformeCalificado18.getIdInfCal());
			mensaje.put("codigo2", tblInformeCalificado19.getIdInfCal());
			mensaje.put("codigo3", tblInformeCalificado20.getIdInfCal());
			mensaje.put("codigo4", tblInformeCalificado21.getIdInfCal());
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "GuardarFrmGADP12", method = RequestMethod.POST)
	public @ResponseBody String GuardarFrmGADP12(
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, @RequestParam("periodoInforme") String periodoInforme,
			@RequestParam("observacion") String observacion) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {
			List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod,
					Integer.parseInt(periodoInforme));
			// List<Object[]> registrosInformesValorados =
			// ivs.obtenerRegistrosInformesValorados();
			List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);

			if (datosInformeValorado.size() == 0) {
				TblValoracion informeValorado = new TblValoracion();
				List<TblInformeCalificado> calificacionesInforme = ics.ObtenerListaPregunstas(infcod);

				for (TblInformeCalificado objects : calificacionesInforme) {
					nota += objects.getNota() == null ? 0 : objects.getNota();
				}

				informeValorado.setInstiCod(Integer.parseInt(datosInstitucion.get(0)[10].toString()));
				informeValorado.setInfCod(infcod);
				informeValorado.setFechaValoracion(new Date());
				informeValorado.setPeriodo(Integer.parseInt(periodoInforme));
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
