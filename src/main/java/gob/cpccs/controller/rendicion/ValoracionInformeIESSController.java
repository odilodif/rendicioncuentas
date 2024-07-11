/**
 * 
 */
package gob.cpccs.controller.rendicion;

import java.util.Date;
import java.util.List;

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

/**
 * @author Mauricio Rivera
 * @mail mauriciorivera68@hotmail.com
 * @date 10:18:01
 */
@Controller
@RequestMapping("/view/rendicion/valoracion")
public class ValoracionInformeIESSController {
	
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
	@RequestMapping(value = "valoracionInformeIESS", method = RequestMethod.POST)
	public String valoracionInformeIESS(Model model, Authentication authentication,
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
		model.addAttribute("pregunta1",ics.ObtenerRegistroInfCodPregunta(infcod, "¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO "
				+ periodo + "?") );		

		return "rendicion/valoracion/valoracionInformeIESS";
	}


	//Metodo Guardar pregunta 1	  

		@SuppressWarnings("finally")
		@RequestMapping(value = "GuardarFrmIessP1", method = RequestMethod.POST)
		public @ResponseBody String GuardarFrmIessP1(
				@RequestParam("identificadorResponsable") String identificadorResponsable,
				@RequestParam("infcod") Integer infcod, 
				@RequestParam("cmbpregunta1") String cmbpregunta1,
				@RequestParam("periodoInforme") String periodoInforme, 
				@RequestParam("pre1") Integer codigo) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try {
				//List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcod(infcod, Integer.parseInt(periodoInforme));
				TblInformeCalificado tblInformeCalificado = new TblInformeCalificado();
				if (codigo == null) {
					tblInformeCalificado.setInfCod(infcod);
					tblInformeCalificado.setMatriz("ESTADO INFORME");
					tblInformeCalificado.setPregunta(
							"¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO "
									+ Integer.parseInt(periodoInforme) + "?");
					tblInformeCalificado.setRespuesta(cmbpregunta1);
					if (cmbpregunta1.equals("SI")) {
						tblInformeCalificado.setNota((float) 16.67);
						nota = (float) 16.67;
					} else {
						tblInformeCalificado.setNota((float) 0.00);
						nota = (float) 0.00;
					}
					tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
					tblInformeCalificado.setPeriodo(Integer.parseInt(periodoInforme));
					tblInformeCalificado.setEvidencia("N/A");
					ics.guardarInformeCalificacion(tblInformeCalificado);

				} else {
					tblInformeCalificado = ics.ObtenerRegistroXidInfCal(codigo);	
					tblInformeCalificado.setInfCod(infcod);
					tblInformeCalificado.setMatriz("ESTADO INFORME");
					tblInformeCalificado.setPregunta(
							"¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO "
									+ Integer.parseInt(periodoInforme) + "?");
					tblInformeCalificado.setRespuesta(cmbpregunta1);
					if (cmbpregunta1.equals("SI")) {
						tblInformeCalificado.setNota((float) 16.67);
						nota = (float) 16.67;
					} else {
						tblInformeCalificado.setNota((float) 0.00);
						nota = (float) 0.00;
					}
					tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
					tblInformeCalificado.setPeriodo(Integer.parseInt(periodoInforme));
					tblInformeCalificado.setEvidencia("N/A");
					ics.guardarInformeCalificacion(tblInformeCalificado);

					
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

	//Metodo Guardar pregunta 2

		@SuppressWarnings("finally")
		@RequestMapping(value = "GuardarFrmIessP2", method = RequestMethod.POST)
		public @ResponseBody String GuardarFrmIessP2(
				@RequestParam("identificadorResponsable") String identificadorResponsable,
				@RequestParam("infcod") Integer infcod, 
				@RequestParam("cmbPregunta2") String cmbPregunta2,
				@RequestParam("rutaArchivo2") String rutaArchivo2, 
				@RequestParam("periodoInforme") String periodoInforme,
				@RequestParam("pre2") Integer codigo) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try {
				/*List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
						Integer.parseInt(periodoInforme));*/
		
				TblInformeCalificado tblInformeCalificado2 = new TblInformeCalificado();
				if (codigo == null) {
			
					tblInformeCalificado2.setInfCod(infcod);
					tblInformeCalificado2.setMatriz("CUMPLIMIENTO DE LA EJECUCIÓN PRESUPUESTARIA");
					tblInformeCalificado2.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?");
					tblInformeCalificado2.setRespuesta(cmbPregunta2);
					switch (cmbPregunta2) {
					case "1. CÉDULA PRESUPUESTARIA DEL MINISTERIO DE FINANZAS":
						tblInformeCalificado2.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA1);
						break;
					case "2. INFORME DE GESTIÓN FINANCIERA APROBADO POR AUTORIDAD COMPETENTE":
						tblInformeCalificado2.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA2);

						break;
					case "3. MATRIZ DE LOTAIP QUE SI DIRECCIONA A LA CÉDULA PRESUPUESTARIA":
						tblInformeCalificado2.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA3);

						break;
					case "4. EOD: INFORME OFICIAL DE EJECUCIÓN PRESUPUESTARIA QUE CONTENGA SU CÉDULA PRESUPUESTARIA/ DETALLE DE EJECUCIÓN PRESUPUESTARIA":
						tblInformeCalificado2.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA4);

						break;
					case "5. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD): NO APLICA":
						tblInformeCalificado2.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA5);

						break;
					case "6. NO ABRE EL LINK":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA6);

						break;
					case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA7);

						break;
					//case "8. RESPONDE EN 0":
					case "8. NO APLICA":
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

					tblInformeCalificado2.setPeriodo(Integer.parseInt(periodoInforme));
					if (rutaArchivo2!="") {
						tblInformeCalificado2.setEvidencia(rutaArchivo2);
					}else {
						tblInformeCalificado2.setEvidencia("N/A");
					}
					
					ics.guardarInformeCalificacion(tblInformeCalificado2);
				
				} else {
					tblInformeCalificado2= ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado2.setInfCod(infcod);
					tblInformeCalificado2.setMatriz("CUMPLIMIENTO DE LA EJECUCIÓN PRESUPUESTARIA");
					tblInformeCalificado2.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?");
					tblInformeCalificado2.setRespuesta(cmbPregunta2);
					switch (cmbPregunta2) {
					case "1. CÉDULA PRESUPUESTARIA DEL MINISTERIO DE FINANZAS":
						tblInformeCalificado2.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA1);
						break;
					case "2. INFORME DE GESTIÓN FINANCIERA APROBADO POR AUTORIDAD COMPETENTE":
						tblInformeCalificado2.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA2);

						break;
					case "3. MATRIZ DE LOTAIP QUE SI DIRECCIONA A LA CÉDULA PRESUPUESTARIA":
						tblInformeCalificado2.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA3);

						break;
					case "4. EOD: INFORME OFICIAL DE EJECUCIÓN PRESUPUESTARIA QUE CONTENGA SU CÉDULA PRESUPUESTARIA/ DETALLE DE EJECUCIÓN PRESUPUESTARIA":
						tblInformeCalificado2.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA4);

						break;
					case "5. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD): NO APLICA":
						tblInformeCalificado2.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA5);

						break;
					case "6. NO ABRE EL LINK":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA6);

						break;
					case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA7);

						break;
					//case "8. RESPONDE EN 0":
					case "8. NO APLICA":
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

					tblInformeCalificado2.setPeriodo(Integer.parseInt(periodoInforme));
					if (rutaArchivo2!="") {
						tblInformeCalificado2.setEvidencia(rutaArchivo2);
					}else {
						tblInformeCalificado2.setEvidencia("N/A");
					}
					
					ics.guardarInformeCalificacion(tblInformeCalificado2);
				
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

	//Metodo Guardar pregunta 3

		@SuppressWarnings("finally")
		@RequestMapping(value = "GuardarFrmIessP3", method = RequestMethod.POST)
		public @ResponseBody String GuardarFrmIessP3(
				@RequestParam("identificadorResponsable") String identificadorResponsable,
				@RequestParam("infcod") Integer infcod, 
				@RequestParam("cmbPregunta3") String cmbPregunta3,
				@RequestParam("rutaArchivo3") String rutaArchivo3, 			
				@RequestParam("periodoInforme") String periodoInforme, 
				@RequestParam("pre3") Integer codigo) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try {
				/*List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
						Integer.parseInt(periodoInforme));*/
				TblInformeCalificado tblInformeCalificado3 = new TblInformeCalificado();

				if (codigo == null ) {		
					tblInformeCalificado3.setInfCod(infcod);
					tblInformeCalificado3.setMatriz("PROCESOS DE CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS");
					tblInformeCalificado3.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?");
					tblInformeCalificado3.setRespuesta(cmbPregunta3);
					switch (cmbPregunta3) {
					case "1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP":
						tblInformeCalificado3.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA1);
						break;
					case "2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS":
						tblInformeCalificado3.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA2);

						break;
					case "3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN":
						tblInformeCalificado3.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA3);

						break;
					case "4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA)":
						tblInformeCalificado3.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA4);

						break;
					case "5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA":
						tblInformeCalificado3.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA5);

						break;
					case "6. EOD: PRESENTA UN INFORME OFICIAL DE CONTRATACIONES PÚBLICAS, QUE CONTENGA EL DETALLE DE LOS PROCESOS DEL AÑO":
						tblInformeCalificado3.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA6);

						break;
					case "7. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA":
						tblInformeCalificado3.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA7);

						break;
					case "8. NO ABRE EL LINK":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA8);

						break;
					case "9. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA9);

						break;
					case "10. RESPONDE EN 0":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA10);

						break;
					case "11. OTROS, NO CUMPLE":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA11);

						break;
					case "12. VACÍO":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA12);

						break;
					}

					tblInformeCalificado3.setPeriodo(Integer.parseInt(periodoInforme));
					if (rutaArchivo3!="") {
						tblInformeCalificado3.setEvidencia(rutaArchivo3);
					}else {
						tblInformeCalificado3.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado3);

				} else {
					tblInformeCalificado3 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado3.setInfCod(infcod);
					tblInformeCalificado3.setMatriz("PROCESOS DE CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS");
					tblInformeCalificado3.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?");
					tblInformeCalificado3.setRespuesta(cmbPregunta3);
					switch (cmbPregunta3) {
					case "1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP":
						tblInformeCalificado3.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA1);
						break;
					case "2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS":
						tblInformeCalificado3.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA2);

						break;
					case "3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN":
						tblInformeCalificado3.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA3);

						break;
					case "4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA)":
						tblInformeCalificado3.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA4);

						break;
					case "5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA":
						tblInformeCalificado3.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA5);

						break;
					case "6. EOD: PRESENTA UN INFORME OFICIAL DE CONTRATACIONES PÚBLICAS, QUE CONTENGA EL DETALLE DE LOS PROCESOS DEL AÑO":
						tblInformeCalificado3.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA6);

						break;
					case "7. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA":
						tblInformeCalificado3.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA7);

						break;
					case "8. NO ABRE EL LINK":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA8);

						break;
					case "9. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA9);

						break;
					case "10. RESPONDE EN 0":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA10);

						break;
					case "11. OTROS, NO CUMPLE":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA11);

						break;
					case "12. VACÍO":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA12);

						break;
					}

					tblInformeCalificado3.setPeriodo(Integer.parseInt(periodoInforme));
					if (rutaArchivo3!="") {
						tblInformeCalificado3.setEvidencia(rutaArchivo3);
					}else {
						tblInformeCalificado3.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado3);
	
					
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

	//Metodo Guardar pregunta 4

		@SuppressWarnings("finally")
		@RequestMapping(value = "GuardarFrmIessP4", method = RequestMethod.POST)
		public @ResponseBody String GuardarFrmIessP4(
				@RequestParam("identificadorResponsable") String identificadorResponsable,
				@RequestParam("infcod") Integer infcod, 
				@RequestParam("cmbPregunta4") String cmbPregunta4,
				@RequestParam("rutaArchivo4") String rutaArchivo4, 
				@RequestParam("periodoInforme") String periodoInforme,
				@RequestParam("pre4") Integer codigo) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try {
				/*List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
						Integer.parseInt(periodoInforme));*/
				TblInformeCalificado tblInformeCalificado4 = new TblInformeCalificado();

				if (codigo == null) {	
					
					tblInformeCalificado4.setInfCod(infcod);
					tblInformeCalificado4.setMatriz("MECANISMOS DE PARTICIPACIÓN CIUDADANA");
					tblInformeCalificado4
							.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?");
					tblInformeCalificado4.setRespuesta(cmbPregunta4);
					switch (cmbPregunta4) {
					case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
						tblInformeCalificado4.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA1);
						break;
					case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE ASISTENCIAS":
						tblInformeCalificado4.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA2);
						break;
					case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
						tblInformeCalificado4.setNota((float) 8.34);
						nota = nota + (float) 8.34;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA3);
						break;
					case "4. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA":
						tblInformeCalificado4.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA4);
						break;
					case "5. NO ABRE EL LINK":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA5);
						break;
					case "6. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA6);
						break;
					case "7. NO APLICA":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA7);
						break;
					case "8. OTROS, NO CUMPLE":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA8);
						break;
					case "9. VACÍO":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA9);
						break;
					}

					tblInformeCalificado4.setPeriodo(Integer.parseInt(periodoInforme));
					if(rutaArchivo4!="") {
						tblInformeCalificado4.setEvidencia(rutaArchivo4);
					}else {
						tblInformeCalificado4.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado4);

				} else {				
					tblInformeCalificado4 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado4.setInfCod(infcod);
					tblInformeCalificado4.setMatriz("MECANISMOS DE PARTICIPACIÓN CIUDADANA");
					tblInformeCalificado4
							.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?");
					tblInformeCalificado4.setRespuesta(cmbPregunta4);
					switch (cmbPregunta4) {
					case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
						tblInformeCalificado4.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA1);
						break;
					case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE ASISTENCIAS":
						tblInformeCalificado4.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA2);
						break;
					case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
						tblInformeCalificado4.setNota((float) 8.34);
						nota = nota + (float) 8.34;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA3);
						break;
					case "4. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA":
						tblInformeCalificado4.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA4);
						break;
					case "5. NO ABRE EL LINK":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA5);
						break;
					case "6. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA6);
						break;
					case "7. NO APLICA":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA7);
						break;
					case "8. OTROS, NO CUMPLE":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA8);
						break;
					case "9. VACÍO":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA9);
						break;
					}

					tblInformeCalificado4.setPeriodo(Integer.parseInt(periodoInforme));
					if(rutaArchivo4!="") {
						tblInformeCalificado4.setEvidencia(rutaArchivo4);
					}else {
						tblInformeCalificado4.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado4);
					
				}

				mensaje.put("estado", "exito");
				mensaje.put("codigo", tblInformeCalificado4.getIdInfCal());
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}
		}

	//Metodo Guardar pregunta 5

		@SuppressWarnings("finally")
		@RequestMapping(value = "GuardarFrmIessP5", method = RequestMethod.POST)
		public @ResponseBody String GuardarFrmIessP5(
				@RequestParam("identificadorResponsable") String identificadorResponsable,
				@RequestParam("infcod") Integer infcod, 
				@RequestParam("cmbPregunta5") String cmbPregunta5,
				@RequestParam("rutaArchivo5") String rutaArchivo5, 
				@RequestParam("cmbPregunta6") String cmbPregunta6,
				@RequestParam("rutaArchivo5_1") String rutaArchivo5_1,
				@RequestParam("periodoInforme") String periodoInforme, 
				@RequestParam("pre5") Integer codigo,
				@RequestParam("pre5_1") Integer codigo1) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try {
			/*	List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
						Integer.parseInt(periodoInforme));*/
				TblInformeCalificado tblInformeCalificado5 = new TblInformeCalificado();
				TblInformeCalificado tblInformeCalificado6 = new TblInformeCalificado();
				if (codigo == null && codigo1 == null) {
	
					tblInformeCalificado5.setInfCod(infcod);
					tblInformeCalificado5.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado5.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DEL ESPACIO DELIBERATIVO?");
					tblInformeCalificado5.setRespuesta(cmbPregunta5);
					switch (cmbPregunta5) {
					case "1. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA SI PARTICIPÓ":
						tblInformeCalificado5.setNota((float) 8.33);
						nota = nota + (float) 8.33;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA1);
						break;
					case "2. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO Y LOS APORTES CIUDADANOS":
						tblInformeCalificado5.setNota((float) 8.33);
						nota = nota + (float) 8.33;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA2);
						break;
					case "3. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA":
						tblInformeCalificado5.setNota((float) 8.33);
						nota = nota + (float) 8.33;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA3);
						break;
					case "4. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA NO PARTICIPÓ":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA4);
						break;
					case "5. NO ABRE EL LINK":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA5);
						break;
					case "6. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA6);
						break;
					case "7. NO APLICA":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA7);
						break;
					case "8. OTROS, NO CUMPLE":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA8);
						break;
					case "9. VACÍO":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA9);
						break;
					}

					tblInformeCalificado5.setPeriodo(Integer.parseInt(periodoInforme));
					if(rutaArchivo5!="") {
						tblInformeCalificado5.setEvidencia(rutaArchivo5);
					}else {
						tblInformeCalificado5.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado5);


					tblInformeCalificado6.setInfCod(infcod);
					tblInformeCalificado6.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado6
							.setPregunta("¿LA ENTIDAD SUSTENTA LA GENERACIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?");
					tblInformeCalificado6.setRespuesta(cmbPregunta6);
					switch (cmbPregunta6) {
					case "1. ACTA DE REALIZACIÓN DEL	EVENTO QUE CONTENGA LOS APORTES CIUDADANOS QUE SE GENERARON EN ESE ESPACIO":
						tblInformeCalificado6.setNota((float) 8.33);
						nota = nota + (float) 8.33;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
						break;
					case "2. ACTA DE REALIZACIÓN DEL	EVENTO QUE RECONOCE QUE NO HUBIERON APORTES/ACUERDOS":
						tblInformeCalificado6.setNota((float) 8.33);
						nota = nota + (float) 8.33;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA2);
						break;
					case "3. NO ABRE EL LINK":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
						break;
					case "4. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
						break;
					case "5. NO APLICA":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
						break;
					case "6. OTROS, NO CUMPLE":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
						break;
					case "7. VACÍO":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					}

					tblInformeCalificado6.setPeriodo(Integer.parseInt(periodoInforme));
					if(rutaArchivo5_1!="") {
						tblInformeCalificado6.setEvidencia(rutaArchivo5_1);
					}else {
						tblInformeCalificado6.setEvidencia("N/A");
					}
					
					ics.guardarInformeCalificacion(tblInformeCalificado6);

				} else {
					tblInformeCalificado5 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado5.setInfCod(infcod);
					tblInformeCalificado5.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado5.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DEL ESPACIO DELIBERATIVO?");
					tblInformeCalificado5.setRespuesta(cmbPregunta5);
					switch (cmbPregunta5) {
					case "1. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA SI PARTICIPÓ":
						tblInformeCalificado5.setNota((float) 8.33);
						nota = nota + (float) 8.33;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA1);
						break;
					case "2. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO Y LOS APORTES CIUDADANOS":
						tblInformeCalificado5.setNota((float) 8.33);
						nota = nota + (float) 8.33;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA2);
						break;
					case "3. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA":
						tblInformeCalificado5.setNota((float) 8.33);
						nota = nota + (float) 8.33;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA3);
						break;
					case "4. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA NO PARTICIPÓ":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA4);
						break;
					case "5. NO ABRE EL LINK":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA5);
						break;
					case "6. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA6);
						break;
					case "7. NO APLICA":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA7);
						break;
					case "8. OTROS, NO CUMPLE":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA8);
						break;
					case "9. VACÍO":
						tblInformeCalificado5.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA9);
						break;
					}

					tblInformeCalificado5.setPeriodo(Integer.parseInt(periodoInforme));
					if(rutaArchivo5!="") {
						tblInformeCalificado5.setEvidencia(rutaArchivo5);
					}else {
						tblInformeCalificado5.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado5);

					tblInformeCalificado6 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado6.setInfCod(infcod);
					tblInformeCalificado6.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado6
							.setPregunta("¿LA ENTIDAD SUSTENTA LA GENERACIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?");
					tblInformeCalificado6.setRespuesta(cmbPregunta6);
					switch (cmbPregunta6) {
					case "1. ACTA DE REALIZACIÓN DEL	EVENTO QUE CONTENGA LOS APORTES CIUDADANOS QUE SE GENERARON EN ESE ESPACIO":
						tblInformeCalificado6.setNota((float) 8.33);
						nota = nota + (float) 8.33;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
						break;
					case "2. ACTA DE REALIZACIÓN DEL	EVENTO QUE RECONOCE QUE NO HUBIERON APORTES/ACUERDOS":
						tblInformeCalificado6.setNota((float) 8.33);
						nota = nota + (float) 8.33;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA2);
						break;
					case "3. NO ABRE EL LINK":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
						break;
					case "4. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
						break;
					case "5. NO APLICA":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
						break;
					case "6. OTROS, NO CUMPLE":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
						break;
					case "7. VACÍO":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					}

					tblInformeCalificado6.setPeriodo(Integer.parseInt(periodoInforme));
					if(rutaArchivo5_1!="") {
						tblInformeCalificado6.setEvidencia(rutaArchivo5_1);
					}else {
						tblInformeCalificado6.setEvidencia("N/A");
					}
					
					ics.guardarInformeCalificacion(tblInformeCalificado6);

				}
				mensaje.put("estado", "exito");
				mensaje.put("codigo", tblInformeCalificado5.getIdInfCal());
				mensaje.put("codigo1", tblInformeCalificado6.getIdInfCal());
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}

		}

	//Metodo Guardar pregunta 6

		@SuppressWarnings("finally")
		@RequestMapping(value = "GuardarFrmIessP6", method = RequestMethod.POST)
		public @ResponseBody String GuardarFrmIessP6(
				@RequestParam("identificadorResponsable") String identificadorResponsable,
				@RequestParam("infcod") Integer infcod, 
				@RequestParam("cmbPregunta7") String cmbPregunta7,
				@RequestParam("rutaArchivo6") String rutaArchivo6,
				@RequestParam("periodoInforme") String periodoInforme, 
				@RequestParam("pre6") Integer codigo) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try {
			/*	List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
						Integer.parseInt(periodoInforme));*/
				TblInformeCalificado tblInformeCalificado7 = new TblInformeCalificado();
				
				if (codigo == null) {
					
					tblInformeCalificado7.setInfCod(infcod);
					tblInformeCalificado7.setMatriz(
							"INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO	ANTERIOR");
					tblInformeCalificado7.setPregunta(
							"¿LA ENTIDAD SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?");
					tblInformeCalificado7.setRespuesta(cmbPregunta7);
					switch (cmbPregunta7) {
					case "1. ACTA, INFORME O DOCUMENTO OFICIAL QUE DEMUESTRA LA IMPLEMENTACIÓN":
						tblInformeCalificado7.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. NO APLICA, PORQUE SE CREA EN EL AÑO DE RENDICIÓN DE CUENTAS":
						tblInformeCalificado7.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA2);
						break;
					case "3. NO APLICA, PORQUE EL PROCESO ANTERIOR NO RECIBIÓ APORTES":
						tblInformeCalificado7.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA3);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "6. NO APLICA":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado7.setPeriodo(Integer.parseInt(periodoInforme));
					if(rutaArchivo6!="") {
						tblInformeCalificado7.setEvidencia(rutaArchivo6);
					}else {
						tblInformeCalificado7.setEvidencia("N/A");
					}
					
					ics.guardarInformeCalificacion(tblInformeCalificado7);
				} else {
					tblInformeCalificado7 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado7.setInfCod(infcod);
					tblInformeCalificado7.setMatriz(
							"INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO	ANTERIOR");
					tblInformeCalificado7.setPregunta(
							"¿LA ENTIDAD SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?");
					tblInformeCalificado7.setRespuesta(cmbPregunta7);
					switch (cmbPregunta7) {
					case "1. ACTA, INFORME O DOCUMENTO OFICIAL QUE DEMUESTRA LA IMPLEMENTACIÓN":
						tblInformeCalificado7.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. NO APLICA, PORQUE SE CREA EN EL AÑO DE RENDICIÓN DE CUENTAS":
						tblInformeCalificado7.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA2);
						break;
					case "3. NO APLICA, PORQUE EL PROCESO ANTERIOR NO RECIBIÓ APORTES":
						tblInformeCalificado7.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA3);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "6. NO APLICA":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado7.setPeriodo(Integer.parseInt(periodoInforme));
					if(rutaArchivo6!="") {
						tblInformeCalificado7.setEvidencia(rutaArchivo6);
					}else {
						tblInformeCalificado7.setEvidencia("N/A");
					}
					
					ics.guardarInformeCalificacion(tblInformeCalificado7);

				}
				mensaje.put("estado", "exito");
				mensaje.put("codigo", tblInformeCalificado7.getIdInfCal());
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}
		}

	//Metodo Guardar pregunta 7

		@SuppressWarnings("finally")
		@RequestMapping(value = "GuardarFrmIessP7", method = RequestMethod.POST)
		public @ResponseBody String GuardarFrmIessP7(
				@RequestParam("identificadorResponsable") String identificadorResponsable,
				@RequestParam("infcod") Integer infcod, 
				@RequestParam("cmbPregunta8") String cmbPregunta8,
				//@RequestParam("rutaArchivo7") String rutaArchivo7, 
				@RequestParam("periodoInforme") String periodoInforme,
				@RequestParam("pre7") Integer codigo) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try {
				/*List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
						Integer.parseInt(periodoInforme));*/
				TblInformeCalificado tblInformeCalificado8 = new TblInformeCalificado();
				if (codigo == null) {

					tblInformeCalificado8.setInfCod(infcod);
					tblInformeCalificado8.setMatriz("MECANISMOS DE CONTROL SOCIAL");
					tblInformeCalificado8
							.setPregunta("¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?");
					tblInformeCalificado8.setRespuesta(cmbPregunta8);
					switch (cmbPregunta8) {
					case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
						tblInformeCalificado8.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA1);
						break;
					case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE	ASISTENCIAS":
						tblInformeCalificado8.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA2);
						break;
					case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
						tblInformeCalificado8.setNota((float) 8.34);
						nota = nota + (float) 8.34;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA3);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA5);
						break;
					case "6. NO APLICA":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA8);
						break;
					}

					tblInformeCalificado8.setPeriodo(Integer.parseInt(periodoInforme));
					/*
					 * if(rutaArchivo6!="") { tblInformeCalificado8.setEvidencia(rutaArchivo6);
					 * }else { tblInformeCalificado8.setEvidencia("N/A"); }
					 */
					ics.guardarInformeCalificacion(tblInformeCalificado8);
				
				} else {
					tblInformeCalificado8 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado8.setInfCod(infcod);
					tblInformeCalificado8.setMatriz("MECANISMOS DE CONTROL SOCIAL");
					tblInformeCalificado8
							.setPregunta("¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?");
					tblInformeCalificado8.setRespuesta(cmbPregunta8);
					switch (cmbPregunta8) {
					case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
						tblInformeCalificado8.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA1);
						break;
					case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE	ASISTENCIAS":
						tblInformeCalificado8.setNota((float) 16.67);
						nota = nota + (float) 16.67;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA2);
						break;
					case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
						tblInformeCalificado8.setNota((float) 8.34);
						nota = nota + (float) 8.34;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA3);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA5);
						break;
					case "6. NO APLICA":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado8.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado8.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA8);
						break;
					}

					tblInformeCalificado8.setPeriodo(Integer.parseInt(periodoInforme));
					/*
					 * if(rutaArchivo6!="") { tblInformeCalificado8.setEvidencia(rutaArchivo6);
					 * }else { tblInformeCalificado8.setEvidencia("N/A"); }
					 */
					ics.guardarInformeCalificacion(tblInformeCalificado8);
				}
				mensaje.put("estado", "exito");
				mensaje.put("codigo", tblInformeCalificado8.getIdInfCal());
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}
		}

	//Metodo Guardar pregunta 8

		@SuppressWarnings("finally")
		@RequestMapping(value = "GuardarFrmIessP8", method = RequestMethod.POST)
		public @ResponseBody String GuardarFrmIessP8(
				@RequestParam("identificadorResponsable") String identificadorResponsable,
				@RequestParam("infcod") Integer infcod, 
				@RequestParam("cmbPregunta9") String cmbPregunta9,
				@RequestParam("cmbPregunta10") String cmbPregunta10,
				@RequestParam("cmbPregunta11") String cmbPregunta11,
				@RequestParam("cmbPregunta12") String cmbPregunta12,
				@RequestParam("cmbPregunta13") String cmbPregunta13,
				@RequestParam("periodoInforme") String periodoInforme,
				@RequestParam("pre8") String codigo) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try {		
				/*List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
						Integer.parseInt(periodoInforme));*/
				TblInformeCalificado tblInformeCalificado9 = new TblInformeCalificado();
				TblInformeCalificado tblInformeCalificado10 = new TblInformeCalificado();
				TblInformeCalificado tblInformeCalificado11 = new TblInformeCalificado();
				TblInformeCalificado tblInformeCalificado12 = new TblInformeCalificado();
				TblInformeCalificado tblInformeCalificado13 = new TblInformeCalificado();
				if (codigo == null || codigo=="" || codigo.equals("")) {
		
					tblInformeCalificado9.setInfCod(infcod);
					tblInformeCalificado9.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado9
							.setPregunta("¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?");
					tblInformeCalificado9.setRespuesta(cmbPregunta9);
					switch (cmbPregunta9) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado9.setNota((float) 3.33);
						nota = nota + (float) 3.33;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado9.setPeriodo(Integer.parseInt(periodoInforme));
				
					tblInformeCalificado10.setInfCod(infcod);
					tblInformeCalificado10.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado10
							.setPregunta("¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?");
					tblInformeCalificado10.setRespuesta(cmbPregunta10);
					switch (cmbPregunta10) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado10.setNota((float) 3.33);
						nota = nota + (float) 3.33;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado10.setPeriodo(Integer.parseInt(periodoInforme));
			
					tblInformeCalificado11.setInfCod(infcod);
					tblInformeCalificado11.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado11.setPregunta(
							"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?");
					tblInformeCalificado11.setRespuesta(cmbPregunta11);
					switch (cmbPregunta11) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado11.setNota((float) 3.33);
						nota = nota + (float) 3.33;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado11.setPeriodo(Integer.parseInt(periodoInforme));
			
					tblInformeCalificado12.setInfCod(infcod);
					tblInformeCalificado12.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado12.setPregunta(
							"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?");
					tblInformeCalificado12.setRespuesta(cmbPregunta12);
					switch (cmbPregunta12) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado12.setNota((float) 3.33);
						nota = nota + (float) 3.33;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado12.setPeriodo(Integer.parseInt(periodoInforme));
					
					tblInformeCalificado13.setInfCod(infcod);
					tblInformeCalificado13.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado13.setPregunta(
							"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?");
					tblInformeCalificado13.setRespuesta(cmbPregunta13);
					switch (cmbPregunta13) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado13.setNota((float) 3.33);
						nota = nota + (float) 3.33;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado13.setPeriodo(Integer.parseInt(periodoInforme));
					/*
					 * if(rutaArchivo7!="") { tblInformeCalificado13.setEvidencia(rutaArchivo7);
					 * }else { tblInformeCalificado13.setEvidencia("N/A"); }
					 */
					ics.guardarInformeCalificacion(tblInformeCalificado9);
					ics.guardarInformeCalificacion(tblInformeCalificado10);
					ics.guardarInformeCalificacion(tblInformeCalificado11);
					ics.guardarInformeCalificacion(tblInformeCalificado12);
					ics.guardarInformeCalificacion(tblInformeCalificado13);
				
				}else {
					String[] pregunta=codigo.split(":");
					tblInformeCalificado9 = ics.ObtenerRegistroXidInfCal(Integer.parseInt(pregunta[0]));
					tblInformeCalificado9.setInfCod(infcod);
					tblInformeCalificado9.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado9
							.setPregunta("¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?");
					tblInformeCalificado9.setRespuesta(cmbPregunta9);
					switch (cmbPregunta9) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado9.setNota((float) 3.33);
						nota = nota + (float) 3.33;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado9.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado9.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado9.setPeriodo(Integer.parseInt(periodoInforme));
					
					tblInformeCalificado10 = ics.ObtenerRegistroXidInfCal(Integer.parseInt(pregunta[1]));	
					tblInformeCalificado10.setInfCod(infcod);
					tblInformeCalificado10.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado10
							.setPregunta("¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?");
					tblInformeCalificado10.setRespuesta(cmbPregunta10);
					switch (cmbPregunta10) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado10.setNota((float) 3.33);
						nota = nota + (float) 3.33;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado10.setPeriodo(Integer.parseInt(periodoInforme));

					tblInformeCalificado11 = ics.ObtenerRegistroXidInfCal(Integer.parseInt(pregunta[2]));	
					tblInformeCalificado11.setInfCod(infcod);
					tblInformeCalificado11.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado11.setPregunta(
							"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?");
					tblInformeCalificado11.setRespuesta(cmbPregunta11);
					switch (cmbPregunta11) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado11.setNota((float) 3.33);
						nota = nota + (float) 3.33;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado11.setPeriodo(Integer.parseInt(periodoInforme));

					tblInformeCalificado12 = ics.ObtenerRegistroXidInfCal(Integer.parseInt(pregunta[3]));	
					tblInformeCalificado12.setInfCod(infcod);
					tblInformeCalificado12.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado12.setPregunta(
							"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?");
					tblInformeCalificado12.setRespuesta(cmbPregunta12);
					switch (cmbPregunta12) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado12.setNota((float) 3.33);
						nota = nota + (float) 3.33;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado12.setPeriodo(Integer.parseInt(periodoInforme));

					tblInformeCalificado13 = ics.ObtenerRegistroXidInfCal(Integer.parseInt(pregunta[4]));
					tblInformeCalificado13.setInfCod(infcod);
					tblInformeCalificado13.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
					tblInformeCalificado13.setPregunta(
							"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?");
					tblInformeCalificado13.setRespuesta(cmbPregunta13);
					switch (cmbPregunta13) {
					case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado13.setNota((float) 3.33);
						nota = nota + (float) 3.33;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA1);
						break;
					case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA2);
						break;
					case "3. REPORTA NO":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA3);
						break;
					case "4. VACÍO":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P9_RESPUESTA4);
						break;
					}
					tblInformeCalificado13.setPeriodo(Integer.parseInt(periodoInforme));
					/*
					 * if(rutaArchivo7!="") { tblInformeCalificado13.setEvidencia(rutaArchivo7);
					 * }else { tblInformeCalificado13.setEvidencia("N/A"); }
					 */
					ics.guardarInformeCalificacion(tblInformeCalificado9);
					ics.guardarInformeCalificacion(tblInformeCalificado10);
					ics.guardarInformeCalificacion(tblInformeCalificado11);
					ics.guardarInformeCalificacion(tblInformeCalificado12);
					ics.guardarInformeCalificacion(tblInformeCalificado13);
					
				}

				mensaje.put("estado", "exito");
				mensaje.put("codigo", tblInformeCalificado9.getIdInfCal() +":"
				                      +tblInformeCalificado10.getIdInfCal()+":"
				                      +tblInformeCalificado11.getIdInfCal()+":"
				                      +tblInformeCalificado12.getIdInfCal()+":"
				                      +tblInformeCalificado13.getIdInfCal()+":");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}
		}


	//Metodo Guardar pregunta 11

		@SuppressWarnings("finally")
		@RequestMapping(value = "GuardarFrmIessP9", method = RequestMethod.POST)
		public @ResponseBody String GuardarFrmIessP9(
				@RequestParam("identificadorResponsable") String identificadorResponsable,
				@RequestParam("infcod") Integer infcod, @RequestParam("periodoInforme") String periodoInforme,
				@RequestParam("observacion") String observacion) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try {
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
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

	//cargar metodo

	}

