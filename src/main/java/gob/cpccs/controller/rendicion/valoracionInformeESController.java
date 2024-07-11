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

@Controller
@RequestMapping("/view/rendicion/valoracion")
public class valoracionInformeESController {
	@Autowired
	private UsuarioServicio us;

	@Autowired
	private AsignacionServicio as;

	@Autowired
	private InformeServicio is;

	@Autowired
	private InformeCalificacionService ics;

	@Autowired
	private InformeValoradoService ivs;

// Metodos para retroalimentacion de medios //

	@RequestMapping(value = "valoracionInformeES", method = RequestMethod.POST)
	public String valoracionInformeES(Model model, Authentication authentication,
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
		return "rendicion/valoracion/valoracionInformeES";
		

	}
	
//Metodo Guardar pregunta 1	  

	@SuppressWarnings("finally")
	@RequestMapping(value = "GuardarFrmEducacionP1", method = RequestMethod.POST)
	public @ResponseBody String GuardarFrmEducacionP1(
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, @RequestParam("cmbpregunta1") String cmbpregunta1,
			@RequestParam("periodoInforme") String periodoInforme, @RequestParam("pre1") Integer codigo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {
			List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
					Integer.parseInt(periodoInforme));
			TblInformeCalificado tblInformeCalificado = new TblInformeCalificado();
			if (codigo == null) {
				tblInformeCalificado.setInfCod(infcod);
				tblInformeCalificado.setMatriz("ESTADO INFORME");
				tblInformeCalificado.setPregunta(
						"¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO "
								+ Integer.parseInt(periodoInforme) + "?");
				tblInformeCalificado.setRespuesta(cmbpregunta1);
				if (cmbpregunta1.equals("SI")) {
					//Se refiere al Tipo de formulario
					if (datosInstitucion.get(0)[11].toString()!="5"){
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado.setNota((float) 50.00);
							nota = (float) 50.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado.setNota((float) 16.67);
							nota = (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado.setNota((float) 16.67);
							nota = (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado.setNota((float) 16.67);
							nota = (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado.setNota((float) 16.67);
							nota = (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado.setNota((float) 20.00);
							nota = (float) 20.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado.setNota((float) 33.33);
							nota = (float) 33.33;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado.setNota((float) 14.29);
							nota = (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado.setNota((float) 14.29);
							nota = (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado.setNota((float) 14.29);
							nota = (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado.setNota((float) 14.29);
							nota = (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado.setNota((float) 16.67);
							nota = (float) 16.67;
							break;
						}
					}
					tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);

				} else {
					tblInformeCalificado.setNota((float) 0.00);
					nota = (float) 0.00;
					tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);

				}
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
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado.setNota((float) 50.00);
							nota = (float) 50.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado.setNota((float) 16.67);
							nota = (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado.setNota((float) 16.67);
							nota = (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado.setNota((float) 16.67);
							nota = (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado.setNota((float) 16.67);
							nota = (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado.setNota((float) 20.00);
							nota = (float) 20.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado.setNota((float) 33.33);
							nota = (float) 33.33;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado.setNota((float) 14.29);
							nota = (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado.setNota((float) 14.29);
							nota = (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado.setNota((float) 14.29);
							nota = (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado.setNota((float) 14.29);
							nota = (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado.setNota((float) 16.67);
							nota = (float) 16.67;
							break;
						}
					}
					tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);

				} else {
					tblInformeCalificado.setNota((float) 0.00);
					nota = (float) 0.00;
					tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);

				}
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
	@RequestMapping(value = "GuardarFrmEducacionP2", method = RequestMethod.POST)
	public @ResponseBody String GuardarFrmEducacionP2(
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, 
			@RequestParam("cmbPregunta3") String cmbPregunta3,
			@RequestParam("rutaArchivo2") String rutaArchivo2, 
			@RequestParam("periodoInforme") String periodoInforme,
			@RequestParam("pre2") Integer codigo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {
			List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
					Integer.parseInt(periodoInforme));
	
			TblInformeCalificado tblInformeCalificado2 = new TblInformeCalificado();
			if (codigo == null) {
				tblInformeCalificado2.setInfCod(infcod);
				tblInformeCalificado2.setMatriz("PROCESOS DE CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS");
				tblInformeCalificado2.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?");
				tblInformeCalificado2.setRespuesta(cmbPregunta3);
				switch (cmbPregunta3) {
				case "1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}
					}
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA1);
					break;
				case "2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}
					}
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA1);
					break;
				case "3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}
					}
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA1);
					break;
				case "4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA)":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}
					}
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA1);
					break;
				case "5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}
					}
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA1);
					break;
				case "6. EOD: PRESENTA UN INFORME OFICIAL DE CONTRATACIONES PÚBLICAS, QUE CONTENGA EL DETALLE DE LOS PROCESOS DEL AÑO":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}
					}
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA1);
					break;
				case "7. PRIVADO: INFORME DE EJECUCIÓN DE CONTRATACIONES PÚBLICAS APROBADO POR AUTORIDAD COMPETENTE":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}
					}
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA1);
					break;
				case "8. NO ABRE EL LINK":
					tblInformeCalificado2.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA2);

					break;
				case "9. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
					tblInformeCalificado2.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA3);

					break;
				case "10. RESPONDE EN 0":
					tblInformeCalificado2.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA4);

					break;
				case "11. OTROS, NO CUMPLE":
					tblInformeCalificado2.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA5);

					break;
				case "12. VACÍO":
					tblInformeCalificado2.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA6);

					break;
				}

				tblInformeCalificado2.setPeriodo(Integer.parseInt(periodoInforme));
				if(rutaArchivo2!="") {
					tblInformeCalificado2.setEvidencia(rutaArchivo2);
				}else {
					tblInformeCalificado2.setEvidencia("N/A");
				}
				ics.guardarInformeCalificacion(tblInformeCalificado2);
			
			} else {
				tblInformeCalificado2= ics.ObtenerRegistroXidInfCal(codigo);
				tblInformeCalificado2.setInfCod(infcod);
				tblInformeCalificado2.setMatriz("PROCESOS DE CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS");
				tblInformeCalificado2.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?");
				tblInformeCalificado2.setRespuesta(cmbPregunta3);
				switch (cmbPregunta3) {
				case "1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}
					}
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA1);
					break;
				case "2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}
					}
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA1);
					break;
				case "3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}
					}
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA1);
					break;
				case "4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA)":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}
					}
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA1);
					break;
				case "5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}
					}
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA1);
					break;
				case "6. EOD: PRESENTA UN INFORME OFICIAL DE CONTRATACIONES PÚBLICAS, QUE CONTENGA EL DETALLE DE LOS PROCESOS DEL AÑO":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}
					}
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA1);
					break;
				case "7. PRIVADO: INFORME DE EJECUCIÓN DE CONTRATACIONES PÚBLICAS APROBADO POR AUTORIDAD COMPETENTE":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado2.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado2.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}
					}
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA1);
					break;
				case "8. NO ABRE EL LINK":
					tblInformeCalificado2.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA2);

					break;
				case "9. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
					tblInformeCalificado2.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA3);

					break;
				case "10. RESPONDE EN 0":
					tblInformeCalificado2.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA4);

					break;
				case "11. OTROS, NO CUMPLE":
					tblInformeCalificado2.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA5);

					break;
				case "12. VACÍO":
					tblInformeCalificado2.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P3_RESPUESTA6);

					break;
				}

				tblInformeCalificado2.setPeriodo(Integer.parseInt(periodoInforme));
				if(rutaArchivo2!="") {
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
	@RequestMapping(value = "GuardarFrmEducacionP3", method = RequestMethod.POST)
	public @ResponseBody String GuardarFrmEducacionP3(
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, 
			@RequestParam("cmbPregunta4") String cmbPregunta4,
			@RequestParam("rutaArchivo3") String rutaArchivo3, 
			@RequestParam("cmbPregunta5") String cmbPregunta5,
			@RequestParam("rutaArchivo3_1") String rutaArchivo3_1,
			@RequestParam("periodoInforme") String periodoInforme, 
			@RequestParam("pre3") Integer codigo,
			@RequestParam("pre3_1") Integer codigo1) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {
			List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
					Integer.parseInt(periodoInforme));
			TblInformeCalificado tblInformeCalificado4 = new TblInformeCalificado();
			TblInformeCalificado tblInformeCalificado5 = new TblInformeCalificado();

			if (codigo == null && codigo1 == null) {
			
				tblInformeCalificado4.setInfCod(infcod);
				tblInformeCalificado4.setMatriz("CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS Y LABORALES");
				tblInformeCalificado4
						.setPregunta("¿LA ENTIDAD JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES TRIBUTARIAS?");
				tblInformeCalificado4.setRespuesta(cmbPregunta4);
				switch (cmbPregunta4) {
				case "1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL SRI":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado4.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado4.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EOD":
							tblInformeCalificado4.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "UDAF":
							tblInformeCalificado4.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado4.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "PRIVADO":
							tblInformeCalificado4.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado4.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado4.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado4.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "UDAF":
							tblInformeCalificado4.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EOD":
							tblInformeCalificado4.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "PRIVADO":
							tblInformeCalificado4.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						}
					}
					tblInformeCalificado4.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA1);
					break;
				case "2. NO ABRE EL LINK":
					tblInformeCalificado4.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado4.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA8);

					break;
				case "3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
					tblInformeCalificado4.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado4.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA9);

					break;
				case "4. NO APLICA":
					tblInformeCalificado4.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado4.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA10);

					break;
				case "5. OTROS, NO CUMPLE":
					tblInformeCalificado4.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado4.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA11);

					break;
				case "6. VACÍO":
					tblInformeCalificado4.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado4.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA12);

					break;
				}

				tblInformeCalificado4.setPeriodo(Integer.parseInt(periodoInforme));
				if(rutaArchivo3!="") {
					tblInformeCalificado4.setEvidencia(rutaArchivo3);
				}else {
					tblInformeCalificado4.setEvidencia("N/A");
				}
				
				ics.guardarInformeCalificacion(tblInformeCalificado4);
				//Pregunta 5
				
				tblInformeCalificado5.setInfCod(infcod);
				tblInformeCalificado5.setMatriz("CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS Y LABORALES");
				tblInformeCalificado5
						.setPregunta("¿LA ENTIDAD JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES LABORALES?");
				tblInformeCalificado5.setRespuesta(cmbPregunta5);
				switch (cmbPregunta5) {
				case "1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL IESS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado5.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado5.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EOD":
							tblInformeCalificado5.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "UDAF":
							tblInformeCalificado5.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado5.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "PRIVADO":
							tblInformeCalificado5.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado5.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado5.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado5.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "UDAF":
							tblInformeCalificado5.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EOD":
							tblInformeCalificado5.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "PRIVADO":
							tblInformeCalificado5.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						}
					}
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA1);
					break;
				case "2. NO ABRE EL LINK":
					tblInformeCalificado5.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA8);

					break;
				case "3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
					tblInformeCalificado5.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA9);

					break;
				case "4. NO APLICA":
					tblInformeCalificado5.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA10);

					break;
				case "5. OTROS, NO CUMPLE":
					tblInformeCalificado5.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA11);

					break;
				case "6. VACÍO":
					tblInformeCalificado5.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA12);

					break;
				}
				tblInformeCalificado5.setPeriodo(Integer.parseInt(periodoInforme));
				if(rutaArchivo3!="") {
					tblInformeCalificado5.setEvidencia(rutaArchivo3);
				}else {
					tblInformeCalificado5.setEvidencia("N/A");
				}
				ics.guardarInformeCalificacion(tblInformeCalificado5);

			} else {
				tblInformeCalificado4 = ics.ObtenerRegistroXidInfCal(codigo);
				tblInformeCalificado4.setInfCod(infcod);
				tblInformeCalificado4.setMatriz("CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS Y LABORALES");
				tblInformeCalificado4
						.setPregunta("¿LA ENTIDAD JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES TRIBUTARIAS?");
				tblInformeCalificado4.setRespuesta(cmbPregunta4);
				switch (cmbPregunta4) {
				case "1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL SRI":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado4.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado4.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EOD":
							tblInformeCalificado4.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "UDAF":
							tblInformeCalificado4.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado4.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "PRIVADO":
							tblInformeCalificado4.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado4.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado4.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado4.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "UDAF":
							tblInformeCalificado4.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EOD":
							tblInformeCalificado4.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "PRIVADO":
							tblInformeCalificado4.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						}
					}
					tblInformeCalificado4.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA1);
					break;
				case "2. NO ABRE EL LINK":
					tblInformeCalificado4.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado4.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA8);

					break;
				case "3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
					tblInformeCalificado4.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado4.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA9);

					break;
				case "4. NO APLICA":
					tblInformeCalificado4.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado4.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA10);

					break;
				case "5. OTROS, NO CUMPLE":
					tblInformeCalificado4.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado4.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA11);

					break;
				case "6. VACÍO":
					tblInformeCalificado4.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado4.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA12);

					break;
				}

				tblInformeCalificado4.setPeriodo(Integer.parseInt(periodoInforme));
				if(rutaArchivo3!="") {
					tblInformeCalificado4.setEvidencia(rutaArchivo3);
				}else {
					tblInformeCalificado4.setEvidencia("N/A");
				}
				ics.guardarInformeCalificacion(tblInformeCalificado4);
				//Pregunta 5
				tblInformeCalificado5 = ics.ObtenerRegistroXidInfCal(codigo1);
				tblInformeCalificado5.setInfCod(infcod);
				tblInformeCalificado5.setMatriz("CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS Y LABORALES");
				tblInformeCalificado5
						.setPregunta("¿LA ENTIDAD JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES LABORALES?");
				tblInformeCalificado5.setRespuesta(cmbPregunta5);
				switch (cmbPregunta5) {
				case "1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL IESS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado5.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado5.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EOD":
							tblInformeCalificado5.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "UDAF":
							tblInformeCalificado5.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado5.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "PRIVADO":
							tblInformeCalificado5.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado5.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado5.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado5.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "UDAF":
							tblInformeCalificado5.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EOD":
							tblInformeCalificado5.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "PRIVADO":
							tblInformeCalificado5.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						}
					}
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA1);
					break;
				case "2. NO ABRE EL LINK":
					tblInformeCalificado5.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA8);

					break;
				case "3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
					tblInformeCalificado5.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA9);

					break;
				case "4. NO APLICA":
					tblInformeCalificado5.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA10);

					break;
				case "5. OTROS, NO CUMPLE":
					tblInformeCalificado5.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA11);

					break;
				case "6. VACÍO":
					tblInformeCalificado5.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FEEP_P4_RESPUESTA12);

					break;
				}

				tblInformeCalificado5.setPeriodo(Integer.parseInt(periodoInforme));				
				if(rutaArchivo3!="") {
					tblInformeCalificado5.setEvidencia(rutaArchivo3);
				}else {
					tblInformeCalificado5.setEvidencia("N/A");
				}
				ics.guardarInformeCalificacion(tblInformeCalificado5);
				
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

//Metodo Guardar pregunta 4

	@SuppressWarnings("finally")
	@RequestMapping(value = "GuardarFrmEducacionP4", method = RequestMethod.POST)
	public @ResponseBody String GuardarFrmEducacionP4(
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, 
			@RequestParam("cmbPregunta6") String cmbPregunta6,
			@RequestParam("rutaArchivo4") String rutaArchivo4, 
			@RequestParam("periodoInforme") String periodoInforme,
			@RequestParam("pre4") Integer codigo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {
			List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
					Integer.parseInt(periodoInforme));
			TblInformeCalificado tblInformeCalificado6 = new TblInformeCalificado();

			if (codigo == null) {
				tblInformeCalificado6.setInfCod(infcod);
				tblInformeCalificado6.setMatriz("MECANISMOS DE PARTICIPACIÓN CIUDADANA");
				tblInformeCalificado6
						.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?");
				tblInformeCalificado6.setRespuesta(cmbPregunta6);
				switch (cmbPregunta6) {
				case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "EOD":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UDAF":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "PRIVADO":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado6.setNota((float) 33.33);
							nota = nota + (float) 33.33;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado6.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado6.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado6.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado6.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado6.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						}
					}
					tblInformeCalificado6.setRespuestaInstitucion(Constantes.FEEP_P7_RESPUESTA1);
					break;
				case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE ASISTENCIAS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "EOD":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UDAF":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "PRIVADO":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado6.setNota((float) 33.33);
							nota = nota + (float) 33.33;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado6.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado6.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado6.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado6.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado6.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						}
					}
					tblInformeCalificado6.setRespuestaInstitucion(Constantes.FEEP_P7_RESPUESTA2);
					break;
				case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "EOD":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UDAF":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "PRIVADO":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado6.setNota((float) 16.65);
							nota = nota + (float) 16.67;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado6.setNota((float) 7.14);
							nota = nota + (float) 7.14;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado6.setNota((float) 7.14);
							nota = nota + (float) 7.14;
							break;
						case "UDAF":
							tblInformeCalificado6.setNota((float) 7.14);
							nota = nota + (float) 7.14;
							break;
						case "EOD":
							tblInformeCalificado6.setNota((float) 7.14);
							nota = nota + (float) 7.14;
							break;
						case "PRIVADO":
							tblInformeCalificado6.setNota((float) 8.33);
							nota = nota + (float) 8.33;
							break;
						}
					}
					tblInformeCalificado6.setRespuestaInstitucion(Constantes.FEEP_P7_RESPUESTA3);
					break;
				case "4. NO ABRE EL LINK":
					tblInformeCalificado6.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado6.setRespuestaInstitucion(Constantes.FEEP_P7_RESPUESTA4);
					break;
				case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
					tblInformeCalificado6.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado6.setRespuestaInstitucion(Constantes.FEEP_P7_RESPUESTA5);
					break;
				case "6. NO APLICA":
					tblInformeCalificado6.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado6.setRespuestaInstitucion(Constantes.FEEP_P7_RESPUESTA6);
					break;
				case "7. OTROS, NO CUMPLE":
					tblInformeCalificado6.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado6.setRespuestaInstitucion(Constantes.FEEP_P7_RESPUESTA7);
					break;
				case "8. VACÍO":
					tblInformeCalificado6.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado6.setRespuestaInstitucion(Constantes.FEEP_P7_RESPUESTA8);
					break;
				}

				tblInformeCalificado6.setPeriodo(Integer.parseInt(periodoInforme));
				if(rutaArchivo4!="") {
					tblInformeCalificado6.setEvidencia(rutaArchivo4);
				}else {
					tblInformeCalificado6.setEvidencia("N/A");
				}
				ics.guardarInformeCalificacion(tblInformeCalificado6);

			} else {

				tblInformeCalificado6 = ics.ObtenerRegistroXidInfCal(codigo);
				tblInformeCalificado6.setInfCod(infcod);
				tblInformeCalificado6.setMatriz("MECANISMOS DE PARTICIPACIÓN CIUDADANA");
				tblInformeCalificado6
						.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?");
				tblInformeCalificado6.setRespuesta(cmbPregunta6);
				switch (cmbPregunta6) {
				case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "EOD":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UDAF":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "PRIVADO":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado6.setNota((float) 33.33);
							nota = nota + (float) 33.33;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado6.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado6.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado6.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado6.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado6.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						}
					}
					tblInformeCalificado6.setRespuestaInstitucion(Constantes.FEEP_P7_RESPUESTA1);
					break;
				case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE ASISTENCIAS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "EOD":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UDAF":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "PRIVADO":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado6.setNota((float) 33.33);
							nota = nota + (float) 33.33;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado6.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado6.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado6.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado6.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado6.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						}
					}
					tblInformeCalificado6.setRespuestaInstitucion(Constantes.FEEP_P7_RESPUESTA2);
					break;
				case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "EOD":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UDAF":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "PRIVADO":
							tblInformeCalificado6.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado6.setNota((float) 16.65);
							nota = nota + (float) 16.67;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado6.setNota((float) 7.14);
							nota = nota + (float) 7.14;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado6.setNota((float) 7.14);
							nota = nota + (float) 7.14;
							break;
						case "UDAF":
							tblInformeCalificado6.setNota((float) 7.14);
							nota = nota + (float) 7.14;
							break;
						case "EOD":
							tblInformeCalificado6.setNota((float) 7.14);
							nota = nota + (float) 7.14;
							break;
						case "PRIVADO":
							tblInformeCalificado6.setNota((float) 8.33);
							nota = nota + (float) 8.33;
							break;
						}
					}
					tblInformeCalificado6.setRespuestaInstitucion(Constantes.FEEP_P7_RESPUESTA3);
					break;
				case "4. NO ABRE EL LINK":
					tblInformeCalificado6.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado6.setRespuestaInstitucion(Constantes.FEEP_P7_RESPUESTA4);
					break;
				case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
					tblInformeCalificado6.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado6.setRespuestaInstitucion(Constantes.FEEP_P7_RESPUESTA5);
					break;
				case "6. NO APLICA":
					tblInformeCalificado6.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado6.setRespuestaInstitucion(Constantes.FEEP_P7_RESPUESTA6);
					break;
				case "7. OTROS, NO CUMPLE":
					tblInformeCalificado6.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado6.setRespuestaInstitucion(Constantes.FEEP_P7_RESPUESTA7);
					break;
				case "8. VACÍO":
					tblInformeCalificado6.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado6.setRespuestaInstitucion(Constantes.FEEP_P7_RESPUESTA8);
					break;
				}

				tblInformeCalificado6.setPeriodo(Integer.parseInt(periodoInforme));
				if(rutaArchivo4!="") {
					tblInformeCalificado6.setEvidencia(rutaArchivo4);
				}else {
					tblInformeCalificado6.setEvidencia("N/A");
				}
				ics.guardarInformeCalificacion(tblInformeCalificado6);

			}

			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado6.getIdInfCal());
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

//Metodo Guardar pregunta 5

	@SuppressWarnings("finally")
	@RequestMapping(value = "GuardarFrmEducacionP5", method = RequestMethod.POST)
	public @ResponseBody String GuardarFrmEducacionP5(
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, 
			@RequestParam("cmbPregunta7") String cmbPregunta7,
			@RequestParam("rutaArchivo5") String rutaArchivo5, 
			@RequestParam("cmbPregunta8") String cmbPregunta8,
			@RequestParam("rutaArchivo5_1") String rutaArchivo5_1,
			@RequestParam("periodoInforme") String periodoInforme, 
			@RequestParam("pre5") Integer codigo,
			@RequestParam("pre5_1") Integer codigo1) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {
			List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
					Integer.parseInt(periodoInforme));
			TblInformeCalificado tblInformeCalificado7 = new TblInformeCalificado();
			TblInformeCalificado tblInformeCalificado8 = new TblInformeCalificado();
			if (codigo == null && codigo1 == null) {
				
				tblInformeCalificado7.setInfCod(infcod);
				tblInformeCalificado7.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
				tblInformeCalificado7.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DEL ESPACIO DELIBERATIVO?");
				tblInformeCalificado7.setRespuesta(cmbPregunta7);
				switch (cmbPregunta7) {
				case "1. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA SI PARTICIPÓ":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado7.setNota((float) 25.00);
							nota = nota + (float) 25.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EOD":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "UDAF":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "PRIVADO":
							tblInformeCalificado7.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado7.setNota((float) 16.70);
							nota = nota + (float) 16.70;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado7.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado7.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "UDAF":
							tblInformeCalificado7.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EOD":
							tblInformeCalificado7.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "PRIVADO":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						}
					}
					tblInformeCalificado7.setRespuestaInstitucion(Constantes.FEEP_P8_RESPUESTA1);
					break;
				case "2. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO Y LOS APORTES CIUDADANOS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado7.setNota((float) 25.00);
							nota = nota + (float) 25.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EOD":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "UDAF":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "PRIVADO":
							tblInformeCalificado7.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado7.setNota((float) 16.70);
							nota = nota + (float) 16.70;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado7.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado7.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "UDAF":
							tblInformeCalificado7.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EOD":
							tblInformeCalificado7.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "PRIVADO":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						}
					}
					tblInformeCalificado7.setRespuestaInstitucion(Constantes.FEEP_P8_RESPUESTA2);
					break;
				case "3. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA NO PARTICIPÓ":
					tblInformeCalificado7.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado7.setRespuestaInstitucion(Constantes.FEEP_P8_RESPUESTA3);
					break;
				case "4. NO ABRE EL LINK":
					tblInformeCalificado7.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado7.setRespuestaInstitucion(Constantes.FEEP_P8_RESPUESTA4);
					break;
				case "5. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
					tblInformeCalificado7.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado7.setRespuestaInstitucion(Constantes.FEEP_P8_RESPUESTA5);
					break;
				case "6. NO APLICA":
					tblInformeCalificado7.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado7.setRespuestaInstitucion(Constantes.FEEP_P8_RESPUESTA6);
					break;
				case "7. OTROS, NO CUMPLE":
					tblInformeCalificado7.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado7.setRespuestaInstitucion(Constantes.FEEP_P8_RESPUESTA7);
					break;
				case "8. VACÍO":
					tblInformeCalificado7.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado7.setRespuestaInstitucion(Constantes.FEEP_P8_RESPUESTA8);
					break;
				}

				tblInformeCalificado7.setPeriodo(Integer.parseInt(periodoInforme));
				if(rutaArchivo5!="") {
					tblInformeCalificado7.setEvidencia(rutaArchivo5);
				}else {
					tblInformeCalificado7.setEvidencia("N/A");
				}
				ics.guardarInformeCalificacion(tblInformeCalificado7);
//Pregunta 8
	
				tblInformeCalificado8.setInfCod(infcod);
				tblInformeCalificado8.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
				tblInformeCalificado8
						.setPregunta("¿LA ENTIDAD SUSTENTA LA GENERACIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?");
				tblInformeCalificado8.setRespuesta(cmbPregunta8);
				switch (cmbPregunta8) {
				case "1. ACTA DE REALIZACIÓN DEL EVENTO QUE CONTENGA LOS APORTES CIUDADANOS QUE SE GENERARON EN ESE ESPACIO":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado8.setNota((float) 25.00);
							nota = nota + (float) 25.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EOD":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "UDAF":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "PRIVADO":
							tblInformeCalificado8.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado8.setNota((float) 16.70);
							nota = nota + (float) 16.70;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado8.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado8.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "UDAF":
							tblInformeCalificado8.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EOD":
							tblInformeCalificado8.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "PRIVADO":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						}
					}
					tblInformeCalificado8.setRespuestaInstitucion(Constantes.FEEP_P9_RESPUESTA1);
					break;
				case "2. ACTA DE REALIZACIÓN DEL EVENTO QUE RECONOCE QUE NO HUBIERON APORTES/ACUERDOS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado8.setNota((float) 25.00);
							nota = nota + (float) 25.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EOD":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "UDAF":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "PRIVADO":
							tblInformeCalificado8.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado8.setNota((float) 16.70);
							nota = nota + (float) 16.70;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado8.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado8.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "UDAF":
							tblInformeCalificado8.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EOD":
							tblInformeCalificado8.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "PRIVADO":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						}
					}
					tblInformeCalificado8.setRespuestaInstitucion(Constantes.FEEP_P9_RESPUESTA2);
					break;
				case "3. NO ABRE EL LINK":
					tblInformeCalificado8.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado8.setRespuestaInstitucion(Constantes.FEEP_P9_RESPUESTA3);
					break;
				case "4. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
					tblInformeCalificado8.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado8.setRespuestaInstitucion(Constantes.FEEP_P9_RESPUESTA4);
					break;
				case "5. NO APLICA":
					tblInformeCalificado8.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado8.setRespuestaInstitucion(Constantes.FEEP_P9_RESPUESTA5);
					break;
				case "6. OTROS, NO CUMPLE":
					tblInformeCalificado8.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado8.setRespuestaInstitucion(Constantes.FEEP_P9_RESPUESTA6);
					break;
				case "7. VACÍO":
					tblInformeCalificado8.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado8.setRespuestaInstitucion(Constantes.FEEP_P9_RESPUESTA7);
					break;
				}

				tblInformeCalificado8.setPeriodo(Integer.parseInt(periodoInforme));
				if(rutaArchivo5_1!="") {
					tblInformeCalificado8.setEvidencia(rutaArchivo5_1);
				}else {
					tblInformeCalificado8.setEvidencia("N/A");
				}
				ics.guardarInformeCalificacion(tblInformeCalificado8);


			} else {
				tblInformeCalificado7 = ics.ObtenerRegistroXidInfCal(codigo);
				tblInformeCalificado7.setInfCod(infcod);
				tblInformeCalificado7.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
				tblInformeCalificado7.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DEL ESPACIO DELIBERATIVO?");
				tblInformeCalificado7.setRespuesta(cmbPregunta7);
				switch (cmbPregunta7) {
				case "1. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA SI PARTICIPÓ":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado7.setNota((float) 25.00);
							nota = nota + (float) 25.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EOD":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "UDAF":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "PRIVADO":
							tblInformeCalificado7.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado7.setNota((float) 16.70);
							nota = nota + (float) 16.70;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado7.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado7.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "UDAF":
							tblInformeCalificado7.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EOD":
							tblInformeCalificado7.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "PRIVADO":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						}
					}
					tblInformeCalificado7.setRespuestaInstitucion(Constantes.FEEP_P8_RESPUESTA1);
					break;
				case "2. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO Y LOS APORTES CIUDADANOS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado7.setNota((float) 25.00);
							nota = nota + (float) 25.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EOD":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "UDAF":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "PRIVADO":
							tblInformeCalificado7.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado7.setNota((float) 16.70);
							nota = nota + (float) 16.70;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado7.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado7.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "UDAF":
							tblInformeCalificado7.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EOD":
							tblInformeCalificado7.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "PRIVADO":
							tblInformeCalificado7.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						}
					}
					tblInformeCalificado7.setRespuestaInstitucion(Constantes.FEEP_P8_RESPUESTA2);
					break;
				case "3. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA NO PARTICIPÓ":
					tblInformeCalificado7.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado7.setRespuestaInstitucion(Constantes.FEEP_P8_RESPUESTA3);
					break;
				case "4. NO ABRE EL LINK":
					tblInformeCalificado7.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado7.setRespuestaInstitucion(Constantes.FEEP_P8_RESPUESTA4);
					break;
				case "5. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
					tblInformeCalificado7.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado7.setRespuestaInstitucion(Constantes.FEEP_P8_RESPUESTA5);
					break;
				case "6. NO APLICA":
					tblInformeCalificado7.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado7.setRespuestaInstitucion(Constantes.FEEP_P8_RESPUESTA6);
					break;
				case "7. OTROS, NO CUMPLE":
					tblInformeCalificado7.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado7.setRespuestaInstitucion(Constantes.FEEP_P8_RESPUESTA7);
					break;
				case "8. VACÍO":
					tblInformeCalificado7.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado7.setRespuestaInstitucion(Constantes.FEEP_P8_RESPUESTA8);
					break;
				}

				tblInformeCalificado7.setPeriodo(Integer.parseInt(periodoInforme));
				if(rutaArchivo5!="") {
					tblInformeCalificado7.setEvidencia(rutaArchivo5);
				}else {
					tblInformeCalificado7.setEvidencia("N/A");
				}
				ics.guardarInformeCalificacion(tblInformeCalificado7);
//Pregunta 8
				tblInformeCalificado8 = ics.ObtenerRegistroXidInfCal(codigo1);
				tblInformeCalificado8.setInfCod(infcod);
				tblInformeCalificado8.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
				tblInformeCalificado8
						.setPregunta("¿LA ENTIDAD SUSTENTA LA GENERACIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?");
				tblInformeCalificado8.setRespuesta(cmbPregunta8);
				switch (cmbPregunta8) {
				case "1. ACTA DE REALIZACIÓN DEL EVENTO QUE CONTENGA LOS APORTES CIUDADANOS QUE SE GENERARON EN ESE ESPACIO":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado8.setNota((float) 25.00);
							nota = nota + (float) 25.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EOD":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "UDAF":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "PRIVADO":
							tblInformeCalificado8.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado8.setNota((float) 16.70);
							nota = nota + (float) 16.70;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado8.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado8.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "UDAF":
							tblInformeCalificado8.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EOD":
							tblInformeCalificado8.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "PRIVADO":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						}
					}
					tblInformeCalificado8.setRespuestaInstitucion(Constantes.FEEP_P9_RESPUESTA1);
					break;
				case "2. ACTA DE REALIZACIÓN DEL EVENTO QUE RECONOCE QUE NO HUBIERON APORTES/ACUERDOS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado8.setNota((float) 25.00);
							nota = nota + (float) 25.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EOD":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "UDAF":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "PRIVADO":
							tblInformeCalificado8.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado8.setNota((float) 16.70);
							nota = nota + (float) 16.70;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado8.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado8.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "UDAF":
							tblInformeCalificado8.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EOD":
							tblInformeCalificado8.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "PRIVADO":
							tblInformeCalificado8.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						}
					}
					tblInformeCalificado8.setRespuestaInstitucion(Constantes.FEEP_P9_RESPUESTA2);
					break;
				case "3. NO ABRE EL LINK":
					tblInformeCalificado8.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado8.setRespuestaInstitucion(Constantes.FEEP_P9_RESPUESTA3);
					break;
				case "4. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
					tblInformeCalificado8.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado8.setRespuestaInstitucion(Constantes.FEEP_P9_RESPUESTA4);
					break;
				case "5. NO APLICA":
					tblInformeCalificado8.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado8.setRespuestaInstitucion(Constantes.FEEP_P9_RESPUESTA5);
					break;
				case "6. OTROS, NO CUMPLE":
					tblInformeCalificado8.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado8.setRespuestaInstitucion(Constantes.FEEP_P9_RESPUESTA6);
					break;
				case "7. VACÍO":
					tblInformeCalificado8.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado8.setRespuestaInstitucion(Constantes.FEEP_P9_RESPUESTA7);
					break;
				}

				tblInformeCalificado8.setPeriodo(Integer.parseInt(periodoInforme));
				if(rutaArchivo5_1!="") {
					tblInformeCalificado8.setEvidencia(rutaArchivo5_1);
				}else {
					tblInformeCalificado8.setEvidencia("N/A");
				}
				ics.guardarInformeCalificacion(tblInformeCalificado8);

			}
			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado7.getIdInfCal());
			mensaje.put("codigo1", tblInformeCalificado8.getIdInfCal());
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}

	}

//Metodo Guardar pregunta 6

	@SuppressWarnings("finally")
	@RequestMapping(value = "GuardarFrmEducacionP6", method = RequestMethod.POST)
	public @ResponseBody String GuardarFrmEducacionP6(
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, 
			@RequestParam("cmbPregunta9") String cmbPregunta9,
			@RequestParam("rutaArchivo6") String rutaArchivo6,
			@RequestParam("periodoInforme") String periodoInforme, 
			@RequestParam("pre6") Integer codigo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {
			List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
					Integer.parseInt(periodoInforme));
			TblInformeCalificado tblInformeCalificado9 = new TblInformeCalificado();
			
			if (codigo == null) {
				
				tblInformeCalificado9.setInfCod(infcod);
				tblInformeCalificado9.setMatriz(
						"INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO	ANTERIOR");
				tblInformeCalificado9.setPregunta(
						"¿LA ENTIDAD SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?");
				tblInformeCalificado9.setRespuesta(cmbPregunta9);
				switch (cmbPregunta9) {
				case "1. ACTA, INFORME O DOCUMENTO OFICIAL QUE DEMUESTRA LA IMPLEMENTACIÓN":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado9.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado9.setNota((float) 20.00);
							nota = nota + (float) 20.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado9.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						}
					}
					tblInformeCalificado9.setRespuestaInstitucion(Constantes.FEEP_P10_RESPUESTA1);
					break;
				case "2. NO APLICA, PORQUE SE CREA EN EL AÑO DE RENDICIÓN DE CUENTAS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado9.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado9.setNota((float) 20.00);
							nota = nota + (float) 20.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado9.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						}
					}
					tblInformeCalificado9.setRespuestaInstitucion(Constantes.FEEP_P10_RESPUESTA2);
					break;
				case "3. NO APLICA, PORQUE EL PROCESO ANTERIOR NO RECIBIÓ APORTES":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado9.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado9.setNota((float) 20.00);
							nota = nota + (float) 20.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado9.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						}
					}
					tblInformeCalificado9.setRespuestaInstitucion(Constantes.FEEP_P10_RESPUESTA3);
					break;
				case "4. NO ABRE EL LINK":
					tblInformeCalificado9.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado9.setRespuestaInstitucion(Constantes.FEEP_P10_RESPUESTA4);
					break;
				case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
					tblInformeCalificado9.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado9.setRespuestaInstitucion(Constantes.FEEP_P10_RESPUESTA5);
					break;
				case "6. NO APLICA":
					tblInformeCalificado9.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado9.setRespuestaInstitucion(Constantes.FEEP_P10_RESPUESTA6);
					break;
				case "7. OTROS, NO CUMPLE":
					tblInformeCalificado9.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado9.setRespuestaInstitucion(Constantes.FEEP_P10_RESPUESTA7);
					break;
				case "8. VACÍO":
					tblInformeCalificado9.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado9.setRespuestaInstitucion(Constantes.FEEP_P10_RESPUESTA8);
					break;
				}

				tblInformeCalificado9.setPeriodo(Integer.parseInt(periodoInforme));
				if (rutaArchivo6!="") {
					tblInformeCalificado9.setEvidencia(rutaArchivo6);
				}else {
					tblInformeCalificado9.setEvidencia("N/A");
				}
				ics.guardarInformeCalificacion(tblInformeCalificado9);
			} else {
				tblInformeCalificado9 = ics.ObtenerRegistroXidInfCal(codigo);
				tblInformeCalificado9.setInfCod(infcod);
				tblInformeCalificado9.setMatriz(
						"INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO	ANTERIOR");
				tblInformeCalificado9.setPregunta(
						"¿LA ENTIDAD SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?");
				tblInformeCalificado9.setRespuesta(cmbPregunta9);
				switch (cmbPregunta9) {
				case "1. ACTA, INFORME O DOCUMENTO OFICIAL QUE DEMUESTRA LA IMPLEMENTACIÓN":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado9.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado9.setNota((float) 20.00);
							nota = nota + (float) 20.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado9.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						}
					}
					tblInformeCalificado9.setRespuestaInstitucion(Constantes.FEEP_P10_RESPUESTA1);
					break;
				case "2. NO APLICA, PORQUE SE CREA EN EL AÑO DE RENDICIÓN DE CUENTAS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado9.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado9.setNota((float) 20.00);
							nota = nota + (float) 20.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado9.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						}
					}
					tblInformeCalificado9.setRespuestaInstitucion(Constantes.FEEP_P10_RESPUESTA2);
					break;
				case "3. NO APLICA, PORQUE EL PROCESO ANTERIOR NO RECIBIÓ APORTES":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado9.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado9.setNota((float) 20.00);
							nota = nota + (float) 20.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado9.setNota((float) 0.00);
							nota = nota + (float) 0.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado9.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado9.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						}
					}
					tblInformeCalificado9.setRespuestaInstitucion(Constantes.FEEP_P10_RESPUESTA3);
					break;
				case "4. NO ABRE EL LINK":
					tblInformeCalificado9.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado9.setRespuestaInstitucion(Constantes.FEEP_P10_RESPUESTA4);
					break;
				case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
					tblInformeCalificado9.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado9.setRespuestaInstitucion(Constantes.FEEP_P10_RESPUESTA5);
					break;
				case "6. NO APLICA":
					tblInformeCalificado9.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado9.setRespuestaInstitucion(Constantes.FEEP_P10_RESPUESTA6);
					break;
				case "7. OTROS, NO CUMPLE":
					tblInformeCalificado9.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado9.setRespuestaInstitucion(Constantes.FEEP_P10_RESPUESTA7);
					break;
				case "8. VACÍO":
					tblInformeCalificado9.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado9.setRespuestaInstitucion(Constantes.FEEP_P10_RESPUESTA8);
					break;
				}

				tblInformeCalificado9.setPeriodo(Integer.parseInt(periodoInforme));
				if (rutaArchivo6!="") {
					tblInformeCalificado9.setEvidencia(rutaArchivo6);
				}else {
					tblInformeCalificado9.setEvidencia("N/A");
				}
				ics.guardarInformeCalificacion(tblInformeCalificado9);
				

			}
			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado9.getIdInfCal());
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

//Metodo Guardar pregunta 7

	@SuppressWarnings("finally")
	@RequestMapping(value = "GuardarFrmEducacionP7", method = RequestMethod.POST)
	public @ResponseBody String GuardarFrmEducacionP7(
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, 
			@RequestParam("cmbPregunta10") String cmbPregunta10,
			@RequestParam("rutaArchivo7") String rutaArchivo7, 
			@RequestParam("periodoInforme") String periodoInforme,
			@RequestParam("pre7") Integer codigo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {
			List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
					Integer.parseInt(periodoInforme));
			TblInformeCalificado tblInformeCalificado10 = new TblInformeCalificado();
			if (codigo == null) {
				tblInformeCalificado10.setInfCod(infcod);
				tblInformeCalificado10.setMatriz("MECANISMOS DE CONTROL SOCIAL");
				tblInformeCalificado10
						.setPregunta("¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?");
				tblInformeCalificado10.setRespuesta(cmbPregunta10);
				switch (cmbPregunta10) {
				case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado10.setNota((float) 50.00);
							nota = nota + (float) 50.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado10.setNota((float) 25.00);
							nota = nota + (float) 25.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado10.setNota((float) 33.60);
							nota = nota + (float) 33.60;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado10.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado10.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado10.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado10.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						}
					}
					tblInformeCalificado10.setRespuestaInstitucion(Constantes.FEEP_P11_RESPUESTA1);
					break;
				case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE	ASISTENCIAS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado10.setNota((float) 50.00);
							nota = nota + (float) 50.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado10.setNota((float) 25.00);
							nota = nota + (float) 25.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado10.setNota((float) 33.60);
							nota = nota + (float) 33.60;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado10.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado10.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado10.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado10.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						}
					}
					tblInformeCalificado10.setRespuestaInstitucion(Constantes.FEEP_P11_RESPUESTA2);
					break;
				case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado10.setNota((float) 25.00);
							nota = nota + (float) 25.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado10.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EOD":
							tblInformeCalificado10.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "UDAF":
							tblInformeCalificado10.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado10.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "PRIVADO":
							tblInformeCalificado10.setNota((float) 12.50);
							nota = nota + (float) 12.50;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado10.setNota((float) 16.80);
							nota = nota + (float) 16.80;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado10.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado10.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "UDAF":
							tblInformeCalificado10.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EOD":
							tblInformeCalificado10.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "PRIVADO":
							tblInformeCalificado10.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						}
					}
					tblInformeCalificado10.setRespuestaInstitucion(Constantes.FEEP_P11_RESPUESTA3);
					break;
				case "4. NO ABRE EL LINK":
					tblInformeCalificado10.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado10.setRespuestaInstitucion(Constantes.FEEP_P11_RESPUESTA4);
					break;
				case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
					tblInformeCalificado10.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado10.setRespuestaInstitucion(Constantes.FEEP_P11_RESPUESTA5);
					break;
				case "6. NO APLICA":
					tblInformeCalificado10.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado10.setRespuestaInstitucion(Constantes.FEEP_P11_RESPUESTA6);
					break;
				case "7. OTROS, NO CUMPLE":
					tblInformeCalificado10.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado10.setRespuestaInstitucion(Constantes.FEEP_P11_RESPUESTA7);
					break;
				case "8. VACÍO":
					tblInformeCalificado10.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado10.setRespuestaInstitucion(Constantes.FEEP_P11_RESPUESTA8);
					break;
				}

				tblInformeCalificado10.setPeriodo(Integer.parseInt(periodoInforme));
				
				  if (rutaArchivo7!="") { tblInformeCalificado10.setEvidencia(rutaArchivo7);
				  }
				  else { tblInformeCalificado10.setEvidencia("N/A"); }
				 
				ics.guardarInformeCalificacion(tblInformeCalificado10);

			} else {
				tblInformeCalificado10 = ics.ObtenerRegistroXidInfCal(codigo);
				tblInformeCalificado10.setInfCod(infcod);
				tblInformeCalificado10.setMatriz("MECANISMOS DE CONTROL SOCIAL");
				tblInformeCalificado10
						.setPregunta("¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?");
				tblInformeCalificado10.setRespuesta(cmbPregunta10);
				switch (cmbPregunta10) {
				case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado10.setNota((float) 50.00);
							nota = nota + (float) 50.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado10.setNota((float) 25.00);
							nota = nota + (float) 25.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado10.setNota((float) 33.60);
							nota = nota + (float) 33.60;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado10.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado10.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado10.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado10.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						}
					}
					tblInformeCalificado10.setRespuestaInstitucion(Constantes.FEEP_P11_RESPUESTA1);
					break;
				case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE	ASISTENCIAS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado10.setNota((float) 50.00);
							nota = nota + (float) 50.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EOD":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "UDAF":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						case "PRIVADO":
							tblInformeCalificado10.setNota((float) 25.00);
							nota = nota + (float) 25.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado10.setNota((float) 33.60);
							nota = nota + (float) 33.60;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado10.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado10.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "UDAF":
							tblInformeCalificado10.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "EOD":
							tblInformeCalificado10.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "PRIVADO":
							tblInformeCalificado10.setNota((float) 16.67);
							nota = nota + (float) 16.67;
							break;
						}
					}
					tblInformeCalificado10.setRespuestaInstitucion(Constantes.FEEP_P11_RESPUESTA2);
					break;
				case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado10.setNota((float) 25.00);
							nota = nota + (float) 25.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado10.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EOD":
							tblInformeCalificado10.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "UDAF":
							tblInformeCalificado10.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado10.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						case "PRIVADO":
							tblInformeCalificado10.setNota((float) 12.50);
							nota = nota + (float) 12.50;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado10.setNota((float) 16.80);
							nota = nota + (float) 16.80;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado10.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado10.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "UDAF":
							tblInformeCalificado10.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "EOD":
							tblInformeCalificado10.setNota((float) 7.15);
							nota = nota + (float) 7.15;
							break;
						case "PRIVADO":
							tblInformeCalificado10.setNota((float) 8.34);
							nota = nota + (float) 8.34;
							break;
						}
					}
					tblInformeCalificado10.setRespuestaInstitucion(Constantes.FEEP_P11_RESPUESTA3);
					break;
				case "4. NO ABRE EL LINK":
					tblInformeCalificado10.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado10.setRespuestaInstitucion(Constantes.FEEP_P11_RESPUESTA4);
					break;
				case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
					tblInformeCalificado10.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado10.setRespuestaInstitucion(Constantes.FEEP_P11_RESPUESTA5);
					break;
				case "6. NO APLICA":
					tblInformeCalificado10.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado10.setRespuestaInstitucion(Constantes.FEEP_P11_RESPUESTA6);
					break;
				case "7. OTROS, NO CUMPLE":
					tblInformeCalificado10.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado10.setRespuestaInstitucion(Constantes.FEEP_P11_RESPUESTA7);
					break;
				case "8. VACÍO":
					tblInformeCalificado10.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado10.setRespuestaInstitucion(Constantes.FEEP_P11_RESPUESTA8);
					break;
				}

				tblInformeCalificado10.setPeriodo(Integer.parseInt(periodoInforme));
				
				  if (rutaArchivo7!="") { tblInformeCalificado10.setEvidencia(rutaArchivo7);
				  }
				  else { tblInformeCalificado10.setEvidencia("N/A"); }
				 
				ics.guardarInformeCalificacion(tblInformeCalificado10);

			}
			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado10.getIdInfCal());
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}

//Metodo Guardar pregunta 8

	@SuppressWarnings("finally")
	@RequestMapping(value = "GuardarFrmEducacionP8", method = RequestMethod.POST)
	public @ResponseBody String GuardarFrmEducacionP8(
			@RequestParam("identificadorResponsable") String identificadorResponsable,
			@RequestParam("infcod") Integer infcod, 
			@RequestParam("cmbPregunta11") String cmbPregunta11,
			@RequestParam("cmbPregunta12") String cmbPregunta12,
			@RequestParam("cmbPregunta13") String cmbPregunta13,
			@RequestParam("cmbPregunta14") String cmbPregunta14,
			@RequestParam("cmbPregunta15") String cmbPregunta15,
			@RequestParam("periodoInforme") String periodoInforme,
			@RequestParam("pre8") String codigo) {
		JSONObject mensaje = new JSONObject();
		mensaje.put("estado", "error");
		mensaje.put("mensaje", "Ha ocurrido un error!");
		float nota = (float) 00.00;
		try {		
			List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
					Integer.parseInt(periodoInforme));
			TblInformeCalificado tblInformeCalificado11 = new TblInformeCalificado();
			TblInformeCalificado tblInformeCalificado12 = new TblInformeCalificado();
			TblInformeCalificado tblInformeCalificado13 = new TblInformeCalificado();
			TblInformeCalificado tblInformeCalificado14 = new TblInformeCalificado();
			TblInformeCalificado tblInformeCalificado15 = new TblInformeCalificado();
			if (codigo == null || codigo=="" || codigo.equals("")) {

				tblInformeCalificado11.setInfCod(infcod);
				tblInformeCalificado11.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
				tblInformeCalificado11
						.setPregunta("¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?");
				tblInformeCalificado11.setRespuesta(cmbPregunta11);
				switch (cmbPregunta11) {
				case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado11.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado11.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EOD":
							tblInformeCalificado11.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "UDAF":
							tblInformeCalificado11.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado11.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "PRIVADO":
							tblInformeCalificado11.setNota((float) 5.00);
							nota = nota + (float) 5.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado11.setNota((float) 6.72);
							nota = nota + (float) 6.72;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado11.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado11.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "UDAF":
							tblInformeCalificado11.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EOD":
							tblInformeCalificado11.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "PRIVADO":
							tblInformeCalificado11.setNota((float) 8.33);
							nota = nota + (float) 8.33;
							break;
						}
					}
					tblInformeCalificado11.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA1);
					break;
				case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					tblInformeCalificado11.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado11.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA2);
					break;
				case "3. REPORTA NO":
					tblInformeCalificado11.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado11.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA3);
					break;
				case "4. VACÍO":
					tblInformeCalificado11.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado11.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA4);
					break;
				}
				tblInformeCalificado11.setPeriodo(Integer.parseInt(periodoInforme));
				tblInformeCalificado11.setEvidencia("N/A");
//pregunta 12
				
				tblInformeCalificado12.setInfCod(infcod);
				tblInformeCalificado12.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
				tblInformeCalificado12
						.setPregunta("¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?");
				tblInformeCalificado12.setRespuesta(cmbPregunta12);
				switch (cmbPregunta12) {
				case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado12.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado12.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EOD":
							tblInformeCalificado12.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "UDAF":
							tblInformeCalificado12.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado12.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "PRIVADO":
							tblInformeCalificado12.setNota((float) 5.00);
							nota = nota + (float) 5.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado12.setNota((float) 6.72);
							nota = nota + (float) 6.72;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado12.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado12.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "UDAF":
							tblInformeCalificado12.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EOD":
							tblInformeCalificado12.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "PRIVADO":
							tblInformeCalificado12.setNota((float) 8.33);
							nota = nota + (float) 8.33;
							break;
						}
					}
					tblInformeCalificado12.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA1);
					break;
				case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					tblInformeCalificado12.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado12.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA2);
					break;
				case "3. REPORTA NO":
					tblInformeCalificado12.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado12.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA3);
					break;
				case "4. VACÍO":
					tblInformeCalificado12.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado12.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA4);
					break;
				}
				tblInformeCalificado12.setPeriodo(Integer.parseInt(periodoInforme));
				tblInformeCalificado12.setEvidencia("N/A");

//pregunta 13
				
				tblInformeCalificado13.setInfCod(infcod);
				tblInformeCalificado13.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
				tblInformeCalificado13.setPregunta(
						"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?");
				tblInformeCalificado13.setRespuesta(cmbPregunta13);
				switch (cmbPregunta13) {
				case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado13.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado13.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EOD":
							tblInformeCalificado13.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "UDAF":
							tblInformeCalificado13.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado13.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "PRIVADO":
							tblInformeCalificado13.setNota((float) 5.00);
							nota = nota + (float) 5.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado13.setNota((float) 6.72);
							nota = nota + (float) 6.72;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado13.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado13.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "UDAF":
							tblInformeCalificado13.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EOD":
							tblInformeCalificado13.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "PRIVADO":
							tblInformeCalificado13.setNota((float) 8.33);
							nota = nota + (float) 8.33;
							break;
						}
					}
					tblInformeCalificado13.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA1);
					break;
				case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					tblInformeCalificado13.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado13.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA2);
					break;
				case "3. REPORTA NO":
					tblInformeCalificado13.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado13.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA3);
					break;
				case "4. VACÍO":
					tblInformeCalificado13.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado13.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA4);
					break;
				}
				tblInformeCalificado13.setPeriodo(Integer.parseInt(periodoInforme));
				tblInformeCalificado13.setEvidencia("N/A");

//Pregunta 14
				
				tblInformeCalificado14.setInfCod(infcod);
				tblInformeCalificado14.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
				tblInformeCalificado14.setPregunta(
						"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?");
				tblInformeCalificado14.setRespuesta(cmbPregunta14);
				switch (cmbPregunta14) {
				case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado14.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado14.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EOD":
							tblInformeCalificado14.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "UDAF":
							tblInformeCalificado14.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado14.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "PRIVADO":
							tblInformeCalificado14.setNota((float) 5.00);
							nota = nota + (float) 5.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado14.setNota((float) 6.72);
							nota = nota + (float) 6.72;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado14.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado14.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "UDAF":
							tblInformeCalificado14.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EOD":
							tblInformeCalificado14.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "PRIVADO":
							tblInformeCalificado14.setNota((float) 8.33);
							nota = nota + (float) 8.33;
							break;
						}
					}
					tblInformeCalificado14.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA1);
					break;
				case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					tblInformeCalificado14.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado14.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA2);
					break;
				case "3. REPORTA NO":
					tblInformeCalificado14.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado14.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA3);
					break;
				case "4. VACÍO":
					tblInformeCalificado14.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado14.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA4);
					break;
				}
				tblInformeCalificado14.setPeriodo(Integer.parseInt(periodoInforme));
				tblInformeCalificado14.setEvidencia("N/A");

//Pregunta 15
				tblInformeCalificado15.setInfCod(infcod);
				tblInformeCalificado15.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
				tblInformeCalificado15.setPregunta(
						"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?");
				tblInformeCalificado15.setRespuesta(cmbPregunta15);
				switch (cmbPregunta15) {
				case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado15.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado15.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EOD":
							tblInformeCalificado15.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "UDAF":
							tblInformeCalificado15.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado15.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "PRIVADO":
							tblInformeCalificado15.setNota((float) 5.00);
							nota = nota + (float) 5.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado15.setNota((float) 6.72);
							nota = nota + (float) 6.72;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado15.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado15.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "UDAF":
							tblInformeCalificado15.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EOD":
							tblInformeCalificado15.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "PRIVADO":
							tblInformeCalificado15.setNota((float) 8.33);
							nota = nota + (float) 8.33;
							break;
						}
					}
					tblInformeCalificado15.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA1);
					break;
				case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					tblInformeCalificado15.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado15.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA2);
					break;
				case "3. REPORTA NO":
					tblInformeCalificado15.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado15.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA3);
					break;
				case "4. VACÍO":
					tblInformeCalificado15.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado15.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA1);
					break;
				}
				tblInformeCalificado15.setPeriodo(Integer.parseInt(periodoInforme));
				
				ics.guardarInformeCalificacion(tblInformeCalificado11);
				ics.guardarInformeCalificacion(tblInformeCalificado12);
				ics.guardarInformeCalificacion(tblInformeCalificado13);
				ics.guardarInformeCalificacion(tblInformeCalificado14);
				ics.guardarInformeCalificacion(tblInformeCalificado15);

			} else {
			  
				String[] pregunta=codigo.split(":");
				tblInformeCalificado11 = ics.ObtenerRegistroXidInfCal(Integer.parseInt(pregunta[0]));	
				tblInformeCalificado11.setInfCod(infcod);
				tblInformeCalificado11.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
				tblInformeCalificado11
						.setPregunta("¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?");
				tblInformeCalificado11.setRespuesta(cmbPregunta11);
				switch (cmbPregunta11) {
				case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado11.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado11.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EOD":
							tblInformeCalificado11.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "UDAF":
							tblInformeCalificado11.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado11.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "PRIVADO":
							tblInformeCalificado11.setNota((float) 5.00);
							nota = nota + (float) 5.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado11.setNota((float) 6.72);
							nota = nota + (float) 6.72;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado11.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado11.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "UDAF":
							tblInformeCalificado11.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EOD":
							tblInformeCalificado11.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "PRIVADO":
							tblInformeCalificado11.setNota((float) 8.33);
							nota = nota + (float) 8.33;
							break;
						}
					}
					tblInformeCalificado11.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA1);
					break;
				case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					tblInformeCalificado11.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado11.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA2);
					break;
				case "3. REPORTA NO":
					tblInformeCalificado11.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado11.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA3);
					break;
				case "4. VACÍO":
					tblInformeCalificado11.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado11.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA4);
					break;
				}
				tblInformeCalificado11.setPeriodo(Integer.parseInt(periodoInforme));
				tblInformeCalificado11.setEvidencia("N/A");
				
//pregunta 12
				tblInformeCalificado12 = ics.ObtenerRegistroXidInfCal(Integer.parseInt(pregunta[1]));
				tblInformeCalificado12.setInfCod(infcod);
				tblInformeCalificado12.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");				
				tblInformeCalificado12
						.setPregunta("¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?");
				tblInformeCalificado12.setRespuesta(cmbPregunta12);
				switch (cmbPregunta12) {
				case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado12.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado12.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EOD":
							tblInformeCalificado12.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "UDAF":
							tblInformeCalificado12.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado12.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "PRIVADO":
							tblInformeCalificado12.setNota((float) 5.00);
							nota = nota + (float) 5.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado12.setNota((float) 6.72);
							nota = nota + (float) 6.72;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado12.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado12.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "UDAF":
							tblInformeCalificado12.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EOD":
							tblInformeCalificado12.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "PRIVADO":
							tblInformeCalificado12.setNota((float) 8.33);
							nota = nota + (float) 8.33;
							break;
						}
					}
					tblInformeCalificado12.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA1);
					break;
				case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					tblInformeCalificado12.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado12.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA2);
					break;
				case "3. REPORTA NO":
					tblInformeCalificado12.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado12.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA3);
					break;
				case "4. VACÍO":
					tblInformeCalificado12.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado12.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA4);
					break;
				}
				tblInformeCalificado12.setPeriodo(Integer.parseInt(periodoInforme));
				tblInformeCalificado12.setEvidencia("N/A");
				
//pregunta 13
				tblInformeCalificado13 = ics.ObtenerRegistroXidInfCal(Integer.parseInt(pregunta[2]));
				tblInformeCalificado13.setInfCod(infcod);
				tblInformeCalificado13.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
				tblInformeCalificado13.setPregunta(
						"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?");
				tblInformeCalificado13.setRespuesta(cmbPregunta13);
				switch (cmbPregunta13) {
				case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado13.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado13.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EOD":
							tblInformeCalificado13.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "UDAF":
							tblInformeCalificado13.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado13.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "PRIVADO":
							tblInformeCalificado13.setNota((float) 5.00);
							nota = nota + (float) 5.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado13.setNota((float) 6.72);
							nota = nota + (float) 6.72;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado13.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado13.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "UDAF":
							tblInformeCalificado13.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EOD":
							tblInformeCalificado13.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "PRIVADO":
							tblInformeCalificado13.setNota((float) 8.33);
							nota = nota + (float) 8.33;
							break;
						}
					}
					tblInformeCalificado13.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA1);
					break;
				case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					tblInformeCalificado13.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado13.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA2);
					break;
				case "3. REPORTA NO":
					tblInformeCalificado13.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado13.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA3);
					break;
				case "4. VACÍO":
					tblInformeCalificado13.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado13.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA4);
					break;
				}
				tblInformeCalificado13.setPeriodo(Integer.parseInt(periodoInforme));
				tblInformeCalificado13.setEvidencia("N/A");
				
//Pregunta 14
				tblInformeCalificado14 = ics.ObtenerRegistroXidInfCal(Integer.parseInt(pregunta[3]));
				tblInformeCalificado14.setInfCod(infcod);
				tblInformeCalificado14.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
				tblInformeCalificado14.setPregunta(
						"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?");
				tblInformeCalificado14.setRespuesta(cmbPregunta14);
				switch (cmbPregunta14) {
				case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado14.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado14.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EOD":
							tblInformeCalificado14.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "UDAF":
							tblInformeCalificado14.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado14.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "PRIVADO":
							tblInformeCalificado14.setNota((float) 5.00);
							nota = nota + (float) 5.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado14.setNota((float) 6.72);
							nota = nota + (float) 6.72;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado14.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado14.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "UDAF":
							tblInformeCalificado14.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EOD":
							tblInformeCalificado14.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "PRIVADO":
							tblInformeCalificado14.setNota((float) 8.33);
							nota = nota + (float) 8.33;
							break;
						}
					}
					tblInformeCalificado14.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA1);
					break;
				case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					tblInformeCalificado14.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado14.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA2);
					break;
				case "3. REPORTA NO":
					tblInformeCalificado14.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado14.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA3);
					break;
				case "4. VACÍO":
					tblInformeCalificado14.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado14.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA4);
					break;
				}
				tblInformeCalificado14.setPeriodo(Integer.parseInt(periodoInforme));
				tblInformeCalificado14.setEvidencia("N/A");
				
//Pregunta 15
				tblInformeCalificado15 = ics.ObtenerRegistroXidInfCal(Integer.parseInt(pregunta[4]));
				tblInformeCalificado15.setInfCod(infcod);
				tblInformeCalificado15.setMatriz("IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD");
				tblInformeCalificado15.setPregunta(
						"¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?");
				tblInformeCalificado15.setRespuesta(cmbPregunta15);
				switch (cmbPregunta15) {
				case "1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					if (datosInstitucion.get(0)[11].toString()!="5") {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado15.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado15.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EOD":
							tblInformeCalificado15.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "UDAF":
							tblInformeCalificado15.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado15.setNota((float) 3.33);
							nota = nota + (float) 3.33;
							break;
						case "PRIVADO":
							tblInformeCalificado15.setNota((float) 5.00);
							nota = nota + (float) 5.00;
							break;
						}

					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "INSTITUTO PÚBLICO":
							tblInformeCalificado15.setNota((float) 6.72);
							nota = nota + (float) 6.72;
							break;
						case "UNIVERSIDAD PÚBLICA":
							tblInformeCalificado15.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EMPRESAS PÚBLICAS":
							tblInformeCalificado15.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "UDAF":
							tblInformeCalificado15.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "EOD":
							tblInformeCalificado15.setNota((float) 2.86);
							nota = nota + (float) 2.86;
							break;
						case "PRIVADO":
							tblInformeCalificado15.setNota((float) 8.33);
							nota = nota + (float) 8.33;
							break;
						}
					}
					tblInformeCalificado15.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA1);
					break;
				case "2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS":
					tblInformeCalificado15.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado15.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA2);
					break;
				case "3. REPORTA NO":
					tblInformeCalificado15.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado15.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA3);
					break;
				case "4. VACÍO":
					tblInformeCalificado15.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado15.setRespuestaInstitucion(Constantes.FEEP_P12_RESPUESTA1);
					break;
				}
				tblInformeCalificado15.setPeriodo(Integer.parseInt(periodoInforme));
				
				ics.guardarInformeCalificacion(tblInformeCalificado11);
				ics.guardarInformeCalificacion(tblInformeCalificado12);
				ics.guardarInformeCalificacion(tblInformeCalificado13);
				ics.guardarInformeCalificacion(tblInformeCalificado14);
				ics.guardarInformeCalificacion(tblInformeCalificado15);

			}

			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado11.getIdInfCal() +":"
			                      +tblInformeCalificado12.getIdInfCal()+":"
			                      +tblInformeCalificado13.getIdInfCal()+":"
			                      +tblInformeCalificado14.getIdInfCal()+":"
			                      +tblInformeCalificado15.getIdInfCal()+":");
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
		} catch (Exception e) {
			mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
		} finally {
			return mensaje.toString();
		}
	}


//Metodo Guardar pregunta 11

	@SuppressWarnings("finally")
	@RequestMapping(value = "GuardarFrmEducacionP9", method = RequestMethod.POST)
	public @ResponseBody String GuardarFrmEducacionP9(
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
	
	
	//Metodo Guardar pregunta 7

		@SuppressWarnings("finally")
		@RequestMapping(value = "GuardarFrmEducacionP10", method = RequestMethod.POST)
		public @ResponseBody String GuardarFrmEducacionP10(
				@RequestParam("identificadorResponsable") String identificadorResponsable,
				@RequestParam("infcod") Integer infcod, 
				@RequestParam("cmbPregunta16") String cmbPregunta16,
				@RequestParam("rutaArchivo9") String rutaArchivo9, 
				@RequestParam("periodoInforme") String periodoInforme,
				@RequestParam("pre10") Integer codigo) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try {
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodES(infcod,
						Integer.parseInt(periodoInforme));
				TblInformeCalificado tblInformeCalificado2 = new TblInformeCalificado();
				boolean valor = false;
				if (codigo == null) {
					tblInformeCalificado2.setInfCod(infcod);
					tblInformeCalificado2.setMatriz("CUMPLIMIENTO DE LA EJECUCIÓN PRESUPUESTARIA");
					tblInformeCalificado2.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?");
					tblInformeCalificado2.setRespuesta(cmbPregunta16);
					switch (cmbPregunta16) {
					case "1. CÉDULA PRESUPUESTARIA DEL MINISTERIO DE FINANZAS":
						if (valor) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 20.00);
								nota = nota + (float) 20.00;
								break;
							}

						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA3);
						break;
					case "2. FORMULARIO DE PAGO DEL IMPUESTO A LA RENTA PRESENTADO AL SRI (DETALLA SI HAY PÉRDIDAS O GANANCIAS)":
						if (valor) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 20.00);
								nota = nota + (float) 20.00;
								break;
							}

						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA3);

						break;
					case "3. MATRIZ DE LOTAIP QUE SI DIRECCIONA A LA CÉDULA PRESUPUESTARIA":
						if (valor) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 20.00);
								nota = nota + (float) 20.00;
								break;
							}

						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA3);

						break;
					case "4. PRIVADO: INFORME DE EJECUCIÓN PRESUPUESTARIA APROBADO POR AUTORIDAD COMPETENTE":
						if (valor) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 20.00);
								nota = nota + (float) 20.00;
								break;
							}

						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA4);

						break;
					case "5. EOD: INFORME OFICIAL DE EJECUCIÓN PRESUPUESTARIA QUE CONTENGA SU CÉDULA PRESUPUESTARIA/ DETALLE DE EJECUCIÓN PRESUPUESTARIA":
						if (valor) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 20.00);
								nota = nota + (float) 20.00;
								break;
							}

						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P5_RESPUESTA5);

						break;

					case "6. NO ABRE EL LINK":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA8);

						break;
					case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA9);

						break;
					case "8. RESPONDE EN 0":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA10);

						break;
					case "9. OTROS, NO CUMPLE":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA11);

						break;
					case "10. VACÍO":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA12);

						break;
					}

					tblInformeCalificado2.setPeriodo(Integer.parseInt(periodoInforme));
					if(rutaArchivo9!="") {
						tblInformeCalificado2.setEvidencia(rutaArchivo9);
					}else {
						tblInformeCalificado2.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado2);
					
				} else {
					
					tblInformeCalificado2 = ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado2.setInfCod(infcod);
					tblInformeCalificado2.setMatriz("CUMPLIMIENTO DE LA EJECUCIÓN PRESUPUESTARIA");
					tblInformeCalificado2.setPregunta("¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?");
					tblInformeCalificado2.setRespuesta(cmbPregunta16);
					switch (cmbPregunta16) {
					case "1. CÉDULA PRESUPUESTARIA DEL MINISTERIO DE FINANZAS":
						if (valor) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 20.00);
								nota = nota + (float) 20.00;
								break;
							}

						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA3);
						break;
					case "2. FORMULARIO DE PAGO DEL IMPUESTO A LA RENTA PRESENTADO AL SRI (DETALLA SI HAY PÉRDIDAS O GANANCIAS)":
						if (valor) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 20.00);
								nota = nota + (float) 20.00;
								break;
							}

						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA3);

						break;
					case "3. MATRIZ DE LOTAIP QUE SI DIRECCIONA A LA CÉDULA PRESUPUESTARIA":
						if (valor) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 20.00);
								nota = nota + (float) 20.00;
								break;
							}

						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA3);

						break;
					case "4. PRIVADO: INFORME DE EJECUCIÓN PRESUPUESTARIA APROBADO POR AUTORIDAD COMPETENTE":
						if (valor) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 20.00);
								nota = nota + (float) 20.00;
								break;
							}

						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA4);

						break;
					case "5. EOD: INFORME OFICIAL DE EJECUCIÓN PRESUPUESTARIA QUE CONTENGA SU CÉDULA PRESUPUESTARIA/ DETALLE DE EJECUCIÓN PRESUPUESTARIA":
						if (valor) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 20.00);
								nota = nota + (float) 20.00;
								break;
							}

						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "INSTITUTO PÚBLICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "UNIVERSIDAD PÚBLICA":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EMPRESAS PÚBLICAS":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "UDAF":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "EOD":
								tblInformeCalificado2.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "PRIVADO":
								tblInformeCalificado2.setNota((float) 16.67);
								nota = nota + (float) 16.67;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P5_RESPUESTA5);

						break;

					case "6. NO ABRE EL LINK":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA8);

						break;
					case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA9);

						break;
					case "8. RESPONDE EN 0":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA10);

						break;
					case "9. OTROS, NO CUMPLE":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA11);

						break;
					case "10. VACÍO":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FEEP_P2_RESPUESTA12);

						break;
					}

					tblInformeCalificado2.setPeriodo(Integer.parseInt(periodoInforme));
					if(rutaArchivo9!="") {
						tblInformeCalificado2.setEvidencia(rutaArchivo9);
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

//cargar metodo

}
