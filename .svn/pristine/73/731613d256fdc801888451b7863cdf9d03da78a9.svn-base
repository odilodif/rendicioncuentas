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
public class valoracionInformeMedioController {
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
		
		@RequestMapping(value = "valoracionInformeMedio", method = RequestMethod.POST)
		public String valoracionInformeMedio(Model model, Authentication authentication,
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
			
			return "rendicion/valoracion/valoracionInformeMedio";
		}
		
//Metodo Guardar pregunta 1	  
		
	  @SuppressWarnings("finally")
	  @RequestMapping(value = "GuardarFrmMediosP1",method = RequestMethod.POST)
	  public @ResponseBody String GuardarFrmMediosP1(
			  @RequestParam("identificadorResponsable") String identificadorResponsable,
			  @RequestParam("infcod") Integer infcod,
			  @RequestParam("cmbpregunta1") String cmbpregunta1,
			  @RequestParam("periodoInforme") String periodoInforme,
			  @RequestParam("pre1") Integer codigo
			  ){
		   JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try {
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodMedios(infcod,
						Integer.parseInt(periodoInforme));
			    //List<Object[]> registrosInformesValorados = ivs.obtenerRegistrosInformesValorados();
				//List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
				   
				TblInformeCalificado tblInformeCalificado = new TblInformeCalificado();
				if(codigo==null) {	
					
					tblInformeCalificado.setInfCod(infcod);
					tblInformeCalificado.setMatriz("ESTADO INFORME");
					tblInformeCalificado.setPregunta(
							"¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO "
									+ Integer.parseInt(periodoInforme) + "?");
					tblInformeCalificado.setRespuesta(cmbpregunta1);
					if (cmbpregunta1.equals("SI")) {
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado.setNota((float) 11.11);
								nota = (float) 11.11;
								tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
								break;
							case "CABLE":
								tblInformeCalificado.setNota((float) 11.11);
								nota = (float) 11.11;
								tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado.setNota((float) 12.50);
								nota = (float) 12.50;
								tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
								break;
							case "RADIO":
								tblInformeCalificado.setNota((float) 12.50);
								nota = (float) 12.50;
								tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
								break;
							case "PERIÓDICO":
								tblInformeCalificado.setNota((float) 14.29);
								nota = (float) 14.29;
								tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
								break;
							case "REVISTA":
								tblInformeCalificado.setNota((float) 14.29);
								nota = (float) 14.29;
								tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
								break;
							}

						} else {

							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado.setNota((float) 10.00);
								nota = (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado.setNota((float) 10.00);
								nota = (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado.setNota((float) 11.11);
								nota = (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado.setNota((float) 11.11);
								nota = (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado.setNota((float) 12.50);
								nota = (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado.setNota((float) 12.50);
								nota = (float) 12.50;
								break;
							}

						}

					} else {
						tblInformeCalificado.setNota((float) 0.00);
						nota = (float) 0.00;
					}
					tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
					tblInformeCalificado.setPeriodo(Integer.parseInt(periodoInforme) );
					tblInformeCalificado.setEvidencia("N/A");
					ics.guardarInformeCalificacion(tblInformeCalificado);
					
				}else {				
					tblInformeCalificado= ics.ObtenerRegistroXidInfCal(codigo); 
					tblInformeCalificado.setInfCod(infcod);
					tblInformeCalificado.setMatriz("ESTADO INFORME");
					tblInformeCalificado.setPregunta(
							"¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO "
									+ Integer.parseInt(periodoInforme) + "?");
					tblInformeCalificado.setRespuesta(cmbpregunta1);
					if (cmbpregunta1.equals("SI")) {
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado.setNota((float) 11.11);
								nota = (float) 11.11;
								tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
								break;
							case "CABLE":
								tblInformeCalificado.setNota((float) 11.11);
								nota = (float) 11.11;
								tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado.setNota((float) 12.50);
								nota = (float) 12.50;
								tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
								break;
							case "RADIO":
								tblInformeCalificado.setNota((float) 12.50);
								nota = (float) 12.50;
								tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
								break;
							case "PERIÓDICO":
								tblInformeCalificado.setNota((float) 14.29);
								nota = (float) 14.29;
								tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
								break;
							case "REVISTA":
								tblInformeCalificado.setNota((float) 14.29);
								nota = (float) 14.29;
								tblInformeCalificado.setRespuestaInstitucion(Constantes.FE_P1_RESPUESTA1);
								break;
							}

						} else {

							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado.setNota((float) 10.00);
								nota = (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado.setNota((float) 10.00);
								nota = (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado.setNota((float) 11.11);
								nota = (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado.setNota((float) 11.11);
								nota = (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado.setNota((float) 12.50);
								nota = (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado.setNota((float) 12.50);
								nota = (float) 12.50;
								break;
							}

						}

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
				
			}catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}
			
		  
	  }
	  
//Metodo Guardar pregunta 2
	    
	  @SuppressWarnings("finally")
	  @RequestMapping(value = "GuardarFrmMediosP2",method = RequestMethod.POST)
	  public @ResponseBody String GuardarFrmMediosP2(
			  @RequestParam("identificadorResponsable") String identificadorResponsable,
			  @RequestParam("infcod") Integer infcod,
			  @RequestParam("cmbPregunta2") String cmbPregunta2,
				@RequestParam("rutaArchivo1") String rutaArchivo1,
			  @RequestParam("periodoInforme") Integer periodoInforme,
			  @RequestParam("pre2") Integer codigo
			  ){
		   JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try {
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodMedios(infcod,
						(periodoInforme));
			    //List<Object[]> registrosInformesValorados = ivs.obtenerRegistrosInformesValorados();
				//List<Object[]> datosInformeValorado = ivs.obtenerRegistroInformeValoradoXInfocod(infcod);
				   
				TblInformeCalificado tblInformeCalificado2 = new TblInformeCalificado();
				if(codigo==null) {
					tblInformeCalificado2.setInfCod(infcod);
					tblInformeCalificado2.setMatriz("PROCESOS DE CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS");
					tblInformeCalificado2.setPregunta("¿EL MEDIO SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?");
					tblInformeCalificado2.setRespuesta(cmbPregunta2);
					switch (cmbPregunta2) {
					case "1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;

								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA1);
						break;
					case "2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA2);
						break;
					case "3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA3);
						break;
					case "4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA)":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}

						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA4);

						break;
					case "5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA5);

						break;

					case "6. PRIVADO Y COMUNITARIO: INFORME DE EJECUCIÓN DE CONTRATACIONES PÚBLICAS APROBADO POR AUTORIDAD COMPETENTE":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA5);

						break;
					case "7. NO ABRE EL LINK":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA6);

						break;
					case "8. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA7);

						break;
					case "9. RESPONDE EN 0":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA8);

						break;
					case "10. OTROS, NO CUMPLE":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA9);

						break;
					case "11. VACÍO":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA10);
						break;
					}
					tblInformeCalificado2.setPeriodo(periodoInforme);
					if(rutaArchivo1!="") {
						tblInformeCalificado2.setEvidencia(rutaArchivo1);
					}else {
						tblInformeCalificado2.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado2);
					
				

					
				}else {				
					tblInformeCalificado2= ics.ObtenerRegistroXidInfCal(codigo); 
					tblInformeCalificado2.setInfCod(infcod);
					tblInformeCalificado2.setMatriz("PROCESOS DE CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS");
					tblInformeCalificado2.setPregunta("¿EL MEDIO SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?");
					tblInformeCalificado2.setRespuesta(cmbPregunta2);
					switch (cmbPregunta2) {
					case "1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;

								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA1);
						break;
					case "2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA2);
						break;
					case "3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA3);
						break;
					case "4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA)":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}

						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA4);

						break;
					case "5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA5);

						break;

					case "6. PRIVADO Y COMUNITARIO: INFORME DE EJECUCIÓN DE CONTRATACIONES PÚBLICAS APROBADO POR AUTORIDAD COMPETENTE":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado2.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado2.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado2.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA5);

						break;
					case "7. NO ABRE EL LINK":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA6);

						break;
					case "8. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA7);

						break;
					case "9. RESPONDE EN 0":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA8);

						break;
					case "10. OTROS, NO CUMPLE":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA9);

						break;
					case "11. VACÍO":
						tblInformeCalificado2.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado2.setRespuestaInstitucion(Constantes.FE_P2_RESPUESTA10);
						break;
					}
					tblInformeCalificado2.setPeriodo(periodoInforme);
					if(rutaArchivo1!="") {
						tblInformeCalificado2.setEvidencia(rutaArchivo1);
					}else {
						tblInformeCalificado2.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado2);
					
					
				}
				
				mensaje.put("estado", "exito");
				mensaje.put("codigo", tblInformeCalificado2.getIdInfCal());
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
				
			}catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}
			
		  
	  }

//Metodo Guardar pregunta 3
	    
	  @SuppressWarnings("finally")
	  @RequestMapping(value = "GuardarFrmMediosP3",method = RequestMethod.POST)
	  public @ResponseBody String GuardarFrmMediosP3(
			  @RequestParam("identificadorResponsable") String identificadorResponsable,
			  @RequestParam("infcod") Integer infcod,
			  @RequestParam("cmbPregunta3") String cmbPregunta3,
			  @RequestParam("rutaArchivo2") String rutaArchivo2,
			  @RequestParam("cmbPregunta4") String cmbPregunta4,
			  @RequestParam("rutaArchivo2_1") String rutaArchivo2_1,
			  @RequestParam("periodoInforme") Integer periodoInforme,
			  @RequestParam("pre3") Integer codigo,
			  @RequestParam("pre3_1") Integer codigo1
			  ) {
		  JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try 
			{
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodMedios(infcod,
						(periodoInforme));
				TblInformeCalificado tblInformeCalificado3 = new TblInformeCalificado();
			 	TblInformeCalificado tblInformeCalificado4 = new TblInformeCalificado();
				
				if(codigo==null && codigo1==null) {   
				 
					tblInformeCalificado3.setInfCod(infcod);
					tblInformeCalificado3.setMatriz("CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS Y LABORALES");
					tblInformeCalificado3
							.setPregunta("¿EL MEDIO JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES TRIBUTARIAS?");
					tblInformeCalificado3.setRespuesta(cmbPregunta3);
					switch (cmbPregunta3) {
					case "1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL SRI":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado3.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado3.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado3.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado3.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado3.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado3.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado3.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado3.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado3.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado3.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado3.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado3.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA1);
						break;
					case "2. NO ABRE EL LINK":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA8);

						break;
					case "3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA9);

						break;
					case "4. NO APLICA":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA10);

						break;
					case "5. OTROS, NO CUMPLE":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA11);

						break;
					case "6. VACÍO":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA12);

						break;
					}

					tblInformeCalificado3.setPeriodo(periodoInforme);
					if(rutaArchivo2!="") {
						tblInformeCalificado3.setEvidencia(rutaArchivo2);
					}else {
						tblInformeCalificado3.setEvidencia("N/A");
					}
				
					ics.guardarInformeCalificacion(tblInformeCalificado3);
					
					// inicio pregunta 4 
					
					
					tblInformeCalificado4.setInfCod(infcod);
					tblInformeCalificado4.setMatriz("CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS Y LABORALES");
					tblInformeCalificado4.setPregunta("¿EL MEDIO JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES LABORALES?");
					tblInformeCalificado4.setRespuesta(cmbPregunta4);
					switch (cmbPregunta4) {
					case "1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL IESS":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado4.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado4.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado4.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado4.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado4.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado4.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado4.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado4.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado4.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado4.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado4.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado4.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA1);
						break;
					case "2. NO ABRE EL LINK":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA8);

						break;
					case "3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA9);

						break;
					case "4. NO APLICA":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA10);

						break;
					case "5. OTROS, NO CUMPLE":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA11);

						break;
					case "6. VACÍO":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA12);

						break;
					}

					tblInformeCalificado4.setPeriodo(periodoInforme);
					if(rutaArchivo2_1!="") {
						tblInformeCalificado4.setEvidencia(rutaArchivo2_1);
					}else {
						tblInformeCalificado4.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado4);
									
				}
				 else {
					tblInformeCalificado3= ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado3.setInfCod(infcod);
					tblInformeCalificado3.setMatriz("CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS Y LABORALES");
					tblInformeCalificado3
							.setPregunta("¿EL MEDIO JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES TRIBUTARIAS?");
					tblInformeCalificado3.setRespuesta(cmbPregunta3);
					switch (cmbPregunta3) {
					case "1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL SRI":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado3.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado3.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado3.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado3.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado3.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado3.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado3.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado3.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado3.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado3.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado3.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado3.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA1);
						break;
					case "2. NO ABRE EL LINK":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA8);

						break;
					case "3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA9);

						break;
					case "4. NO APLICA":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA10);

						break;
					case "5. OTROS, NO CUMPLE":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA11);

						break;
					case "6. VACÍO":
						tblInformeCalificado3.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado3.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA12);

						break;
					}

					tblInformeCalificado3.setPeriodo(periodoInforme);
					if(rutaArchivo2!="") {
						tblInformeCalificado3.setEvidencia(rutaArchivo2);
					}else {
						tblInformeCalificado3.setEvidencia("N/A");
					}
				
					ics.guardarInformeCalificacion(tblInformeCalificado3);
					
					// inicio pregunta 4 
					
					tblInformeCalificado4= ics.ObtenerRegistroXidInfCal(codigo1);
					tblInformeCalificado4.setInfCod(infcod);
					tblInformeCalificado4.setMatriz("CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS Y LABORALES");
					tblInformeCalificado4.setPregunta("¿EL MEDIO JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES LABORALES?");
					tblInformeCalificado4.setRespuesta(cmbPregunta4);
					switch (cmbPregunta4) {
					case "1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL IESS":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado4.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado4.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado4.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado4.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado4.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado4.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado4.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado4.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado4.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado4.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado4.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado4.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA1);
						break;
					case "2. NO ABRE EL LINK":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA8);

						break;
					case "3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA9);

						break;
					case "4. NO APLICA":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA10);

						break;
					case "5. OTROS, NO CUMPLE":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA11);

						break;
					case "6. VACÍO":
						tblInformeCalificado4.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado4.setRespuestaInstitucion(Constantes.FE_P3_RESPUESTA12);

						break;
					}

					tblInformeCalificado4.setPeriodo(periodoInforme);
					if(rutaArchivo2_1!="") {
						tblInformeCalificado4.setEvidencia(rutaArchivo2_1);
					}else {
						tblInformeCalificado4.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado4);
					
					
					
					
				}
			
				
				mensaje.put("estado", "exito");
				mensaje.put("codigo", tblInformeCalificado3.getIdInfCal());
				mensaje.put("codigo1", tblInformeCalificado4.getIdInfCal());
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
				
			}catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}
	  }

//Metodo Guardar pregunta 4
	  
	  @SuppressWarnings("finally")
	  @RequestMapping(value = "GuardarFrmMediosP4",method = RequestMethod.POST)
	  public @ResponseBody String GuardarFrmMediosP4(
			  @RequestParam("identificadorResponsable") String identificadorResponsable,
			  @RequestParam("infcod") Integer infcod,
			  @RequestParam("cmbPregunta5") String cmbPregunta5,
			  @RequestParam("rutaArchivo3") String rutaArchivo3,
			  @RequestParam("periodoInforme") Integer periodoInforme,
			  @RequestParam("pre4") Integer codigo
			  ) {
		  JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try 
			{List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodMedios(infcod,
					(periodoInforme));
		 	TblInformeCalificado tblInformeCalificado5 = new TblInformeCalificado();
		 	
			if(codigo==null) {   
				
				tblInformeCalificado5.setInfCod(infcod);
				tblInformeCalificado5.setMatriz("MECANISMOS DE PARTICIPACIÓN CIUDADANA");
				tblInformeCalificado5
						.setPregunta("¿EL MEDIO SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?");
				tblInformeCalificado5.setRespuesta(cmbPregunta5);
				switch (cmbPregunta5) {
				case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
					if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
							|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "TELEVISIÓN":
							tblInformeCalificado5.setNota((float) 11.11);
							nota = nota + (float) 11.11;
							break;
						case "CABLE":
							tblInformeCalificado5.setNota((float) 11.11);
							nota = nota + (float) 11.11;
							break;
						case "PORTALES INFORMÁTICOS":
							tblInformeCalificado5.setNota((float) 12.50);
							nota = nota + (float) 12.50;
							break;
						case "RADIO":
							tblInformeCalificado5.setNota((float) 12.50);
							nota = nota + (float) 12.50;
							break;
						case "PERIÓDICO":
							tblInformeCalificado5.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "REVISTA":
							tblInformeCalificado5.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						}
					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "TELEVISIÓN":
							tblInformeCalificado5.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						case "CABLE":
							tblInformeCalificado5.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						case "PORTALES INFORMÁTICOS":
							tblInformeCalificado5.setNota((float) 11.11);
							nota = nota + (float) 11.11;
							break;
						case "RADIO":
							tblInformeCalificado5.setNota((float) 11.11);
							nota = nota + (float) 11.11;
							break;
						case "PERIÓDICO":
							tblInformeCalificado5.setNota((float) 12.50);
							nota = nota + (float) 12.50;
							break;
						case "REVISTA":
							tblInformeCalificado5.setNota((float) 12.50);
							nota = nota + (float) 12.50;
							break;
						}
					}
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA1);
					break;
				case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE ASISTENCIAS":
					if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
							|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "TELEVISIÓN":
							tblInformeCalificado5.setNota((float) 11.11);
							nota = nota + (float) 11.11;
							break;
						case "CABLE":
							tblInformeCalificado5.setNota((float) 11.11);
							nota = nota + (float) 11.11;
							break;
						case "PORTALES INFORMÁTICOS":
							tblInformeCalificado5.setNota((float) 12.50);
							nota = nota + (float) 12.50;
							break;
						case "RADIO":
							tblInformeCalificado5.setNota((float) 12.50);
							nota = nota + (float) 12.50;
							break;
						case "PERIÓDICO":
							tblInformeCalificado5.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						case "REVISTA":
							tblInformeCalificado5.setNota((float) 14.29);
							nota = nota + (float) 14.29;
							break;
						}
					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "TELEVISIÓN":
							tblInformeCalificado5.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						case "CABLE":
							tblInformeCalificado5.setNota((float) 10.00);
							nota = nota + (float) 10.00;
							break;
						case "PORTALES INFORMÁTICOS":
							tblInformeCalificado5.setNota((float) 11.11);
							nota = nota + (float) 11.11;
							break;
						case "RADIO":
							tblInformeCalificado5.setNota((float) 11.11);
							nota = nota + (float) 11.11;
							break;
						case "PERIÓDICO":
							tblInformeCalificado5.setNota((float) 12.50);
							nota = nota + (float) 12.50;
							break;
						case "REVISTA":
							tblInformeCalificado5.setNota((float) 12.50);
							nota = nota + (float) 12.50;
							break;
						}
					}
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA2);
					break;
				case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
					if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
							|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "TELEVISIÓN":
							tblInformeCalificado5.setNota((float) 5.55);
							nota = nota + (float) 5.55;
							break;
						case "CABLE":
							tblInformeCalificado5.setNota((float) 5.55);
							nota = nota + (float) 5.55;
							break;
						case "PORTALES INFORMÁTICOS":
							tblInformeCalificado5.setNota((float) 6.25);
							nota = nota + (float) 6.25;
							break;
						case "RADIO":
							tblInformeCalificado5.setNota((float) 6.25);
							nota = nota + (float) 6.25;
							break;
						case "PERIÓDICO":
							tblInformeCalificado5.setNota((float) 7.14);
							nota = nota + (float) 7.14;
							break;
						case "REVISTA":
							tblInformeCalificado5.setNota((float) 7.14);
							nota = nota + (float) 7.14;
							break;
						}
					} else {
						switch (datosInstitucion.get(0)[6].toString()) {
						case "TELEVISIÓN":
							tblInformeCalificado5.setNota((float) 5.00);
							nota = nota + (float) 5.00;
							break;
						case "CABLE":
							tblInformeCalificado5.setNota((float) 5.00);
							nota = nota + (float) 5.00;
							break;
						case "PORTALES INFORMÁTICOS":
							tblInformeCalificado5.setNota((float) 5.56);
							nota = nota + (float) 5.56;
							break;
						case "RADIO":
							tblInformeCalificado5.setNota((float) 5.56);
							nota = nota + (float) 5.56;
							break;
						case "PERIÓDICO":
							tblInformeCalificado5.setNota((float) 6.25);
							nota = nota + (float) 6.25;
							break;
						case "REVISTA":
							tblInformeCalificado5.setNota((float) 6.25);
							nota = nota + (float) 6.25;
							break;
						}
					}
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA3);
					break;
				case "4. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA":
					tblInformeCalificado5.setNota((float) 16.67);
					nota = nota + (float) 16.67;
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA4);
					break;
				case "5. NO ABRE EL LINK":
					tblInformeCalificado5.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA5);
					break;
				case "6. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
					tblInformeCalificado5.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA6);
					break;
				case "7. NO APLICA":
					tblInformeCalificado5.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA7);
					break;
				case "8. OTROS, NO CUMPLE":
					tblInformeCalificado5.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA8);
					break;
				case "9. VACÍO":
					tblInformeCalificado5.setNota((float) 0.00);
					nota = nota + (float) 0.00;
					tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA9);
					break;
				}

				tblInformeCalificado5.setPeriodo(periodoInforme);
				if(rutaArchivo3!="") {
					tblInformeCalificado5.setEvidencia(rutaArchivo3);
				}else {
					tblInformeCalificado5.setEvidencia("N/A");
				}
				ics.guardarInformeCalificacion(tblInformeCalificado5);
				
			}else{
		
			tblInformeCalificado5= ics.ObtenerRegistroXidInfCal(codigo);
		    tblInformeCalificado5.setInfCod(infcod);
			tblInformeCalificado5.setMatriz("MECANISMOS DE PARTICIPACIÓN CIUDADANA");
			tblInformeCalificado5
					.setPregunta("¿EL MEDIO SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?");
			tblInformeCalificado5.setRespuesta(cmbPregunta5);
			switch (cmbPregunta5) {
			case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
				if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
						|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
					switch (datosInstitucion.get(0)[6].toString()) {
					case "TELEVISIÓN":
						tblInformeCalificado5.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						break;
					case "CABLE":
						tblInformeCalificado5.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						break;
					case "PORTALES INFORMÁTICOS":
						tblInformeCalificado5.setNota((float) 12.50);
						nota = nota + (float) 12.50;
						break;
					case "RADIO":
						tblInformeCalificado5.setNota((float) 12.50);
						nota = nota + (float) 12.50;
						break;
					case "PERIÓDICO":
						tblInformeCalificado5.setNota((float) 14.29);
						nota = nota + (float) 14.29;
						break;
					case "REVISTA":
						tblInformeCalificado5.setNota((float) 14.29);
						nota = nota + (float) 14.29;
						break;
					}
				} else {
					switch (datosInstitucion.get(0)[6].toString()) {
					case "TELEVISIÓN":
						tblInformeCalificado5.setNota((float) 10.00);
						nota = nota + (float) 10.00;
						break;
					case "CABLE":
						tblInformeCalificado5.setNota((float) 10.00);
						nota = nota + (float) 10.00;
						break;
					case "PORTALES INFORMÁTICOS":
						tblInformeCalificado5.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						break;
					case "RADIO":
						tblInformeCalificado5.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						break;
					case "PERIÓDICO":
						tblInformeCalificado5.setNota((float) 12.50);
						nota = nota + (float) 12.50;
						break;
					case "REVISTA":
						tblInformeCalificado5.setNota((float) 12.50);
						nota = nota + (float) 12.50;
						break;
					}
				}
				tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA1);
				break;
			case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE ASISTENCIAS":
				if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
						|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
					switch (datosInstitucion.get(0)[6].toString()) {
					case "TELEVISIÓN":
						tblInformeCalificado5.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						break;
					case "CABLE":
						tblInformeCalificado5.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						break;
					case "PORTALES INFORMÁTICOS":
						tblInformeCalificado5.setNota((float) 12.50);
						nota = nota + (float) 12.50;
						break;
					case "RADIO":
						tblInformeCalificado5.setNota((float) 12.50);
						nota = nota + (float) 12.50;
						break;
					case "PERIÓDICO":
						tblInformeCalificado5.setNota((float) 14.29);
						nota = nota + (float) 14.29;
						break;
					case "REVISTA":
						tblInformeCalificado5.setNota((float) 14.29);
						nota = nota + (float) 14.29;
						break;
					}
				} else {
					switch (datosInstitucion.get(0)[6].toString()) {
					case "TELEVISIÓN":
						tblInformeCalificado5.setNota((float) 10.00);
						nota = nota + (float) 10.00;
						break;
					case "CABLE":
						tblInformeCalificado5.setNota((float) 10.00);
						nota = nota + (float) 10.00;
						break;
					case "PORTALES INFORMÁTICOS":
						tblInformeCalificado5.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						break;
					case "RADIO":
						tblInformeCalificado5.setNota((float) 11.11);
						nota = nota + (float) 11.11;
						break;
					case "PERIÓDICO":
						tblInformeCalificado5.setNota((float) 12.50);
						nota = nota + (float) 12.50;
						break;
					case "REVISTA":
						tblInformeCalificado5.setNota((float) 12.50);
						nota = nota + (float) 12.50;
						break;
					}
				}
				tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA2);
				break;
			case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
				if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
						|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
					switch (datosInstitucion.get(0)[6].toString()) {
					case "TELEVISIÓN":
						tblInformeCalificado5.setNota((float) 5.55);
						nota = nota + (float) 5.55;
						break;
					case "CABLE":
						tblInformeCalificado5.setNota((float) 5.55);
						nota = nota + (float) 5.55;
						break;
					case "PORTALES INFORMÁTICOS":
						tblInformeCalificado5.setNota((float) 6.25);
						nota = nota + (float) 6.25;
						break;
					case "RADIO":
						tblInformeCalificado5.setNota((float) 6.25);
						nota = nota + (float) 6.25;
						break;
					case "PERIÓDICO":
						tblInformeCalificado5.setNota((float) 7.14);
						nota = nota + (float) 7.14;
						break;
					case "REVISTA":
						tblInformeCalificado5.setNota((float) 7.14);
						nota = nota + (float) 7.14;
						break;
					}
				} else {
					switch (datosInstitucion.get(0)[6].toString()) {
					case "TELEVISIÓN":
						tblInformeCalificado5.setNota((float) 5.00);
						nota = nota + (float) 5.00;
						break;
					case "CABLE":
						tblInformeCalificado5.setNota((float) 5.00);
						nota = nota + (float) 5.00;
						break;
					case "PORTALES INFORMÁTICOS":
						tblInformeCalificado5.setNota((float) 5.56);
						nota = nota + (float) 5.56;
						break;
					case "RADIO":
						tblInformeCalificado5.setNota((float) 5.56);
						nota = nota + (float) 5.56;
						break;
					case "PERIÓDICO":
						tblInformeCalificado5.setNota((float) 6.25);
						nota = nota + (float) 6.25;
						break;
					case "REVISTA":
						tblInformeCalificado5.setNota((float) 6.25);
						nota = nota + (float) 6.25;
						break;
					}
				}
				tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA3);
				break;
			case "4. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA":
				tblInformeCalificado5.setNota((float) 16.67);
				nota = nota + (float) 16.67;
				tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA4);
				break;
			case "5. NO ABRE EL LINK":
				tblInformeCalificado5.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA5);
				break;
			case "6. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
				tblInformeCalificado5.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA6);
				break;
			case "7. NO APLICA":
				tblInformeCalificado5.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA7);
				break;
			case "8. OTROS, NO CUMPLE":
				tblInformeCalificado5.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA8);
				break;
			case "9. VACÍO":
				tblInformeCalificado5.setNota((float) 0.00);
				nota = nota + (float) 0.00;
				tblInformeCalificado5.setRespuestaInstitucion(Constantes.FE_P4_RESPUESTA9);
				break;
			}

			tblInformeCalificado5.setPeriodo(periodoInforme);
			if(rutaArchivo3!="") {
				tblInformeCalificado5.setEvidencia(rutaArchivo3);
			}else {
				tblInformeCalificado5.setEvidencia("N/A");
			}
			ics.guardarInformeCalificacion(tblInformeCalificado5);	
			}
			

			mensaje.put("estado", "exito");
			mensaje.put("codigo", tblInformeCalificado5.getIdInfCal());				
			mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

			}catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			}
			finally {
				return mensaje.toString();
			}
	  }
	  
//Metodo Guardar pregunta 5
	  
	  @SuppressWarnings("finally")
	  @RequestMapping(value = "GuardarFrmMediosP5",method = RequestMethod.POST)
	  public @ResponseBody String GuardarFrmMediosP5(
			  @RequestParam("identificadorResponsable") String identificadorResponsable,
			  @RequestParam("infcod") Integer infcod,
			  @RequestParam("cmbPregunta6") String cmbPregunta6,
			  @RequestParam("rutaArchivo4") String rutaArchivo4,
			  @RequestParam("cmbPregunta7") String cmbPregunta7,
			  @RequestParam("rutaArchivo4_1") String rutaArchivo4_1,
			  @RequestParam("periodoInforme") Integer periodoInforme,
			  @RequestParam("pre5") Integer codigo,
			  @RequestParam("pre5_1") Integer codigo1
			  ) {
		  JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try 
			{
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodMedios(infcod,
						(periodoInforme));
				TblInformeCalificado tblInformeCalificado6 = new TblInformeCalificado();
				TblInformeCalificado tblInformeCalificado7 = new TblInformeCalificado();		
				if(codigo==null && codigo1==null) { 
					
					tblInformeCalificado6.setInfCod(infcod);
					tblInformeCalificado6.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado6.setPregunta("¿EL MEDIO SUSTENTA LA EJECUCIÓN DEL ESPACIO DELIBERATIVO?");
					tblInformeCalificado6.setRespuesta(cmbPregunta6);
					switch (cmbPregunta6) {
					case "1. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA SI PARTICIPÓ":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado6.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado6.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado6.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado6.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado6.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado6.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado6.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado6.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado6.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado6.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado6.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado6.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}

						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA1);
						break;
					case "2. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO Y LOS APORTES CIUDADANOS":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado6.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado6.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado6.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado6.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado6.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado6.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado6.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado6.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado6.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado6.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado6.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado6.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA2);
						break;
					case "3. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA NO PARTICIPÓ":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA3);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA5);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA6);
						break;
					case "6. NO APLICA":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA7);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA8);
						break;
					case "8. VACÍO":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA9);
						break;
					}

					tblInformeCalificado6.setPeriodo(periodoInforme);
					if(rutaArchivo4!="") {
						tblInformeCalificado6.setEvidencia(rutaArchivo4);
					}else {
						tblInformeCalificado6.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado6);
					
					// inicio pregunta 7
				
					tblInformeCalificado7.setInfCod(infcod);
					tblInformeCalificado7.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado7
							.setPregunta("¿EL MEDIO SUSTENTA LA GENERACIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?");
					tblInformeCalificado7.setRespuesta(cmbPregunta7);
					switch (cmbPregunta7) {
					case "1. ACTA DE REALIZACIÓN DEL EVENTO QUE CONTENGA LOS APORTES CIUDADANOS QUE SE GENERARON EN ESE ESPACIO":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado7.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado7.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado7.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado7.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado7.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado7.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado7.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado7.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado7.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado7.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado7.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado7.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
						break;
					case "2. ACTA DE REALIZACIÓN DEL EVENTO QUE RECONOCE QUE NO HUBIERON APORTES/ACUERDOS":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado7.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado7.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado7.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado7.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado7.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado7.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado7.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado7.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado7.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado7.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado7.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado7.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA2);
						break;
					case "3. NO ABRE EL LINK":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
						break;
					case "4. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
						break;
					case "5. NO APLICA":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
						break;
					case "6. OTROS, NO CUMPLE":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
						break;
					case "7. VACÍO":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					}

					tblInformeCalificado7.setPeriodo(periodoInforme);
					if(rutaArchivo4_1!="") {
						tblInformeCalificado7.setEvidencia(rutaArchivo4);
					}else {
						tblInformeCalificado7.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado7);
					
				}
				else {
					tblInformeCalificado6= ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado6.setInfCod(infcod);
					tblInformeCalificado6.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado6.setPregunta("¿EL MEDIO SUSTENTA LA EJECUCIÓN DEL ESPACIO DELIBERATIVO?");
					tblInformeCalificado6.setRespuesta(cmbPregunta6);
					switch (cmbPregunta6) {
					case "1. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA SI PARTICIPÓ":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado6.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado6.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado6.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado6.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado6.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado6.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado6.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado6.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado6.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado6.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado6.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado6.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}

						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA1);
						break;
					case "2. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO Y LOS APORTES CIUDADANOS":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado6.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado6.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado6.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado6.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado6.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado6.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado6.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado6.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado6.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado6.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado6.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado6.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA2);
						break;
					case "3. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA NO PARTICIPÓ":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA3);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA5);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA6);
						break;
					case "6. NO APLICA":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA7);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA8);
						break;
					case "8. VACÍO":
						tblInformeCalificado6.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado6.setRespuestaInstitucion(Constantes.FE_P5_RESPUESTA9);
						break;
					}

					tblInformeCalificado6.setPeriodo(periodoInforme);
					if(rutaArchivo4!="") {
						tblInformeCalificado6.setEvidencia(rutaArchivo4);
					}else {
						tblInformeCalificado6.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado6);
					
					// inicio pregunta 7
					tblInformeCalificado7= ics.ObtenerRegistroXidInfCal(codigo1);
					tblInformeCalificado7.setInfCod(infcod);
					tblInformeCalificado7.setMatriz("PROCESO DE RENDICIÓN DE CUENTAS");
					tblInformeCalificado7
							.setPregunta("¿EL MEDIO SUSTENTA LA GENERACIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?");
					tblInformeCalificado7.setRespuesta(cmbPregunta7);
					switch (cmbPregunta7) {
					case "1. ACTA DE REALIZACIÓN DEL EVENTO QUE CONTENGA LOS APORTES CIUDADANOS QUE SE GENERARON EN ESE ESPACIO":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado7.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado7.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado7.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado7.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado7.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado7.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado7.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado7.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado7.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado7.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado7.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado7.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA1);
						break;
					case "2. ACTA DE REALIZACIÓN DEL EVENTO QUE RECONOCE QUE NO HUBIERON APORTES/ACUERDOS":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado7.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado7.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado7.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado7.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado7.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado7.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado7.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado7.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado7.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado7.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado7.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado7.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA2);
						break;
					case "3. NO ABRE EL LINK":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA3);
						break;
					case "4. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA4);
						break;
					case "5. NO APLICA":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA5);
						break;
					case "6. OTROS, NO CUMPLE":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA6);
						break;
					case "7. VACÍO":
						tblInformeCalificado7.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado7.setRespuestaInstitucion(Constantes.FE_P6_RESPUESTA7);
						break;
					}

					tblInformeCalificado7.setPeriodo(periodoInforme);
					if(rutaArchivo4!="") {
						tblInformeCalificado7.setEvidencia(rutaArchivo4);
					}else {
						tblInformeCalificado7.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado7);
				
				}
				mensaje.put("estado", "exito");
				mensaje.put("codigo", tblInformeCalificado6.getIdInfCal());
				mensaje.put("codigo1", tblInformeCalificado7.getIdInfCal());
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
				
				
			}catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			}
			finally {
				return mensaje.toString();
				}
	  
			}
				 
//Metodo Guardar pregunta 6
	  
	  @SuppressWarnings("finally")
	  @RequestMapping(value = "GuardarFrmMediosP6",method = RequestMethod.POST)
	  public @ResponseBody String GuardarFrmMediosP6(
			  @RequestParam("identificadorResponsable") String identificadorResponsable,
			  @RequestParam("infcod") Integer infcod,
			  @RequestParam("cmbPregunta10") String cmbPregunta10,
			  @RequestParam("rutaArchivo6") String rutaArchivo6,
			  @RequestParam("cmbPregunta11") String cmbPregunta11,
			  @RequestParam("rutaArchivo6_1") String rutaArchivo6_1,
			  @RequestParam("periodoInforme") Integer periodoInforme,
			  @RequestParam("pre6") Integer codigo,
			  @RequestParam("pre6_1") Integer codigo1
			  ) {
		  JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try 
			{
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodMedios(infcod,
						(periodoInforme));
				TblInformeCalificado tblInformeCalificado10 = new TblInformeCalificado();
				TblInformeCalificado tblInformeCalificado11 = new TblInformeCalificado();		
				if(codigo==null && codigo1==null) {
					
					tblInformeCalificado10.setInfCod(infcod);
					tblInformeCalificado10.setMatriz("TIENE PROYECTO COMUNICACIONAL");
					tblInformeCalificado10.setPregunta("¿EL MEDIO ADMITE TENER PROYECTO COMUNICACIONAL?");
					tblInformeCalificado10.setRespuesta(cmbPregunta10);
					switch (cmbPregunta10) {
					case "SI":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado10.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado10.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado10.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado10.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado10.setNota((float) 7.14);
								nota = (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado10.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado10.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado10.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado10.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado10.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado10.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado10.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}

						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;

					case "NO":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					}

					tblInformeCalificado10.setPeriodo(periodoInforme);
					if(rutaArchivo6!="") {
						tblInformeCalificado10.setEvidencia(rutaArchivo6);
					}else {
						tblInformeCalificado10.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado10);
					
					// inicio pregunta 11
					
					tblInformeCalificado11.setInfCod(infcod);
					tblInformeCalificado11.setMatriz(
							"INFORMACIÓN FINANCIERA (LOCPCCS Art. 10, LEY DE EMPRESAS PÚBLICAS ART. 45 SISTEMAS DE INFORMACIÓN)");
					tblInformeCalificado11.setPregunta("¿EL MEDIO SUSTENTA SU PROGRAMACIÓN EN PROMOCIÓN DE DERECHOS?");
					tblInformeCalificado11.setRespuesta(cmbPregunta11);
					switch (cmbPregunta11) {
					case "1. EN PROMOCIÓN DE DERECHOS REPORTA SI EN DISCAPACIDADES E INTERCULTURAL":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado11.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado11.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado11.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado11.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}

						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. EN PROMOCIÓN DE DERECHOS REPORTA SI SÓLO EN DISCAPACIDADES O INTERCULTURAL":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado11.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado11.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado11.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado11.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}

						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;

					case "3. EN PROMOCIÓN DE DERECHOS REPORTA SI EN INTERGENERACIONAL, GENERO O MOVILIDAD HUMANA":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado11.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado11.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado11.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado11.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}

						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;

					case "4. REPORTA SI EN PARTICIPACIÓN O DIÁLOGO":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado11.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado11.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado11.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado11.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}

						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "5. NO ABRE EL LINK":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "6. VARIAS DE LAS OPCIONES ANTERIORES":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "8. NO APLICA":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "9. OTROS, NO CUMPLE":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "10. VACÍO":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado11.setPeriodo(periodoInforme);
					if(rutaArchivo6_1!="") {
						tblInformeCalificado11.setEvidencia(rutaArchivo6_1);
					}else {
						tblInformeCalificado11.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado11);
				
				
				}			
				else {
					tblInformeCalificado10= ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado10.setInfCod(infcod);
					tblInformeCalificado10.setMatriz("TIENE PROYECTO COMUNICACIONAL");
					tblInformeCalificado10.setPregunta("¿EL MEDIO ADMITE TENER PROYECTO COMUNICACIONAL?");
					tblInformeCalificado10.setRespuesta(cmbPregunta10);
					switch (cmbPregunta10) {
					case "SI":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado10.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado10.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado10.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado10.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado10.setNota((float) 7.14);
								nota = (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado10.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado10.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado10.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado10.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado10.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado10.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado10.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}

						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;

					case "NO":
						tblInformeCalificado10.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado10.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					}

					tblInformeCalificado10.setPeriodo(periodoInforme);
					if(rutaArchivo6!="") {
						tblInformeCalificado10.setEvidencia(rutaArchivo6);
					}else {
						tblInformeCalificado10.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado10);
					// inicio pregunta 11
					tblInformeCalificado11= ics.ObtenerRegistroXidInfCal(codigo1);
					tblInformeCalificado11.setInfCod(infcod);
					tblInformeCalificado11.setMatriz(
							"INFORMACIÓN FINANCIERA (LOCPCCS Art. 10, LEY DE EMPRESAS PÚBLICAS ART. 45 SISTEMAS DE INFORMACIÓN)");
					tblInformeCalificado11.setPregunta("¿EL MEDIO SUSTENTA SU PROGRAMACIÓN EN PROMOCIÓN DE DERECHOS?");
					tblInformeCalificado11.setRespuesta(cmbPregunta11);
					switch (cmbPregunta11) {
					case "1. EN PROMOCIÓN DE DERECHOS REPORTA SI EN DISCAPACIDADES E INTERCULTURAL":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado11.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado11.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado11.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado11.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}

						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. EN PROMOCIÓN DE DERECHOS REPORTA SI SÓLO EN DISCAPACIDADES O INTERCULTURAL":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado11.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado11.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado11.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado11.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}

						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;

					case "3. EN PROMOCIÓN DE DERECHOS REPORTA SI EN INTERGENERACIONAL, GENERO O MOVILIDAD HUMANA":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado11.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado11.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado11.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado11.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}

						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;

					case "4. REPORTA SI EN PARTICIPACIÓN O DIÁLOGO":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado11.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado11.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado11.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado11.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado11.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado11.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}

						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "5. NO ABRE EL LINK":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "6. VARIAS DE LAS OPCIONES ANTERIORES":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "8. NO APLICA":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "9. OTROS, NO CUMPLE":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "10. VACÍO":
						tblInformeCalificado11.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado11.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado11.setPeriodo(periodoInforme);
					if(rutaArchivo6_1!="") {
						tblInformeCalificado11.setEvidencia(rutaArchivo6_1);
					}else {
						tblInformeCalificado11.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado11);
					
				}
				mensaje.put("estado", "exito");
				mensaje.put("codigo", tblInformeCalificado10.getIdInfCal());
				mensaje.put("codigo1", tblInformeCalificado11.getIdInfCal());
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");	
				
			}catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			}
			finally {
				return mensaje.toString();
			}
	  }
	
//Metodo Guardar pregunta 7
	  
	  @SuppressWarnings("finally")
	  @RequestMapping(value = "GuardarFrmMediosP7",method = RequestMethod.POST)
	  public @ResponseBody String GuardarFrmMediosP7(
			  @RequestParam("identificadorResponsable") String identificadorResponsable,
			  @RequestParam("infcod") Integer infcod,
			  @RequestParam("cmbPregunta12") String cmbPregunta12,
			  @RequestParam("rutaArchivo7") String rutaArchivo7,			  
			  @RequestParam("periodoInforme") Integer periodoInforme,
			  @RequestParam("pre7") Integer codigo
			  ) {
		  JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try 
			{
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodMedios(infcod,
						(periodoInforme));
				TblInformeCalificado tblInformeCalificado12 = new TblInformeCalificado();
				if(codigo==null) {
					tblInformeCalificado12.setInfCod(infcod);
					tblInformeCalificado12.setMatriz(
							"INFORMACIÓN FINANCIERA (LOCPCCS Art. 10, LEY DE EMPRESAS PÚBLICAS ART. 45 SISTEMAS DE INFORMACIÓN)");
					tblInformeCalificado12.setPregunta("¿EL MEDIO SUSTENTA LOS PAGOS DE LOS DERECHOS DE AUTOR?");
					tblInformeCalificado12.setRespuesta(cmbPregunta12);
					switch (cmbPregunta12) {
					case "1. COMPROBANTE DE DERECHOS DE AUTOR REGISTRADOS POR EL MEDIO EN SENADI COMO PRODUCCIÓN MUSICAL, PRODUCCIÓN PERIODÍSTICA Y CONTENIDO PUBLICITARIO":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado12.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado12.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado12.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado12.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						}

						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. REGISTRO DE PAGOS REALIZADOS A LOS GREMIOS DE AUTORES DE DERECHOS DE AUTOR (SAYCE, SOPROFON Y OTROS) POR EL USO DE LAS CREACIONES USADAS POR EL MEDIO":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado12.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado12.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado12.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado12.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						}

						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "3. VARIAS DE LAS OPCIONES ANTERIORES":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado12.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado12.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado12.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado12.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						}
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "6. NO APLICA":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado12.setPeriodo(periodoInforme);
					if(rutaArchivo7!="") {
						tblInformeCalificado12.setEvidencia(rutaArchivo7);
					}else {
						tblInformeCalificado12.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado12);
				}
				else {
				    tblInformeCalificado12= ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado12.setInfCod(infcod);
					tblInformeCalificado12.setMatriz(
							"INFORMACIÓN FINANCIERA (LOCPCCS Art. 10, LEY DE EMPRESAS PÚBLICAS ART. 45 SISTEMAS DE INFORMACIÓN)");
					tblInformeCalificado12.setPregunta("¿EL MEDIO SUSTENTA LOS PAGOS DE LOS DERECHOS DE AUTOR?");
					tblInformeCalificado12.setRespuesta(cmbPregunta12);
					switch (cmbPregunta12) {
					case "1. COMPROBANTE DE DERECHOS DE AUTOR REGISTRADOS POR EL MEDIO EN SENADI COMO PRODUCCIÓN MUSICAL, PRODUCCIÓN PERIODÍSTICA Y CONTENIDO PUBLICITARIO":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado12.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado12.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado12.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado12.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						}

						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. REGISTRO DE PAGOS REALIZADOS A LOS GREMIOS DE AUTORES DE DERECHOS DE AUTOR (SAYCE, SOPROFON Y OTROS) POR EL USO DE LAS CREACIONES USADAS POR EL MEDIO":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado12.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado12.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado12.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado12.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						}

						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "3. VARIAS DE LAS OPCIONES ANTERIORES":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado12.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado12.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado12.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado12.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado12.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado12.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						}
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "6. NO APLICA":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado12.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado12.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado12.setPeriodo(periodoInforme);
					if(rutaArchivo7!="") {
						tblInformeCalificado12.setEvidencia(rutaArchivo7);
					}else {
						tblInformeCalificado12.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado12);
				}
				mensaje.put("estado", "exito");
				mensaje.put("codigo", tblInformeCalificado12.getIdInfCal());				
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");	
			}
			catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			}
			finally {
				return mensaje.toString();
			}
	  }
	
//Metodo Guardar pregunta 8
	  
	  @SuppressWarnings("finally")
	  @RequestMapping(value = "GuardarFrmMediosP8",method = RequestMethod.POST)
	  public @ResponseBody String GuardarFrmMediosP8(
			  @RequestParam("identificadorResponsable") String identificadorResponsable,
			  @RequestParam("infcod") Integer infcod,
			  @RequestParam("cmbPregunta13") String cmbPregunta13,
			  @RequestParam("rutaArchivo8") String rutaArchivo8,			  
			  @RequestParam("periodoInforme") Integer periodoInforme,
			  @RequestParam("pre8") Integer codigo
			  ) {
		  JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try 
			{
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodMedios(infcod,
						(periodoInforme));
				TblInformeCalificado tblInformeCalificado13 = new TblInformeCalificado();
				if(codigo==null) {
					tblInformeCalificado13.setInfCod(infcod);
					tblInformeCalificado13.setMatriz("ESPACIOS PRODUCCIÓN AUDIOVISUAL NACIONAL Y NACIONAL INDEPENDIENTE");
					tblInformeCalificado13
							.setPregunta("¿EL MEDIO SUSTENTA LOS ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL REPORTADOS?");
					tblInformeCalificado13.setRespuesta(cmbPregunta13);
					switch (cmbPregunta13) {
					case "1. DOCUMENTO OFICIAL QUE PERMITE VERIFICAR SI EL PRODUCTO ES PRODUCCIÓN NACIONAL":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado13.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado13.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado13.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado13.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						}

						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					
					case "2. DOCUMENTO OFICIAL QUE PERMITE VERIFICAR LA EXISTENCIA DEL PRODUCTO":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado13.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado13.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado13.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado13.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						}
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					/*
					 * case "3. TEXTO ¿CUÁL?":
					 * 
					 * if (datosInstitucion.get(0)[5].toString().equals("PRIVADO") ||
					 * datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) { switch
					 * (datosInstitucion.get(0)[6].toString()) { case "TELEVISIÓN":
					 * tblInformeCalificado13.setNota((float) 0.00); nota = nota + (float) 0.00;
					 * break; case "CABLE": tblInformeCalificado13.setNota((float) 0.00); nota =
					 * nota + (float) 0.00; break; case "PORTALES INFORMÁTICOS":
					 * tblInformeCalificado13.setNota((float) 0.00); nota = nota + (float) 0.00;
					 * break; case "RADIO": tblInformeCalificado13.setNota((float) 0.00); nota =
					 * nota + (float) 0.00; break; case "PERIÓDICO":
					 * tblInformeCalificado13.setNota((float) 0.00); nota = nota + (float) 0.00;
					 * break; case "REVISTA": tblInformeCalificado13.setNota((float) 0.00); nota =
					 * nota + (float) 0.00; break; } } else { switch
					 * (datosInstitucion.get(0)[6].toString()) { case "TELEVISIÓN":
					 * tblInformeCalificado13.setNota((float) 0.00); nota = nota + (float) 0.00;
					 * break; case "CABLE": tblInformeCalificado13.setNota((float) 0.00); nota =
					 * nota + (float) 0.00; break; case "PORTALES INFORMÁTICOS":
					 * tblInformeCalificado13.setNota((float) 0.00); nota = nota + (float) 0.00;
					 * break; case "RADIO": tblInformeCalificado13.setNota((float) 0.00); nota =
					 * nota + (float) 0.00; break; case "PERIÓDICO":
					 * tblInformeCalificado13.setNota((float) 0.00); nota = nota + (float) 0.00;
					 * break; case "REVISTA": tblInformeCalificado13.setNota((float) 0.00); nota =
					 * nota + (float) 0.00; break; } }
					 * 
					 * tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
					 * break;
					 */
					case "3. NO ABRE EL LINK":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "4. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "5. NO APLICA":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "6. OTROS, NO CUMPLE":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "7. VACÍO":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado13.setPeriodo(periodoInforme);
					if(rutaArchivo8!="") {
						tblInformeCalificado13.setEvidencia(rutaArchivo8);
					}else {
						tblInformeCalificado13.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado13);
					
				}
				else {
					tblInformeCalificado13= ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado13.setInfCod(infcod);
					tblInformeCalificado13.setMatriz("ESPACIOS PRODUCCIÓN AUDIOVISUAL NACIONAL Y NACIONAL INDEPENDIENTE");
					tblInformeCalificado13
							.setPregunta("¿EL MEDIO SUSTENTA LOS ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL REPORTADOS?");
					tblInformeCalificado13.setRespuesta(cmbPregunta13);
					switch (cmbPregunta13) {
					case "1. DOCUMENTO OFICIAL QUE PERMITE VERIFICAR SI EL PRODUCTO ES PRODUCCIÓN NACIONAL":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado13.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado13.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado13.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado13.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						}

						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					
					case "2. DOCUMENTO OFICIAL QUE PERMITE VERIFICAR LA EXISTENCIA DEL PRODUCTO":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado13.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado13.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado13.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado13.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado13.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						}
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					/*
					 * case "3. TEXTO ¿CUÁL?":
					 * 
					 * if (datosInstitucion.get(0)[5].toString().equals("PRIVADO") ||
					 * datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) { switch
					 * (datosInstitucion.get(0)[6].toString()) { case "TELEVISIÓN":
					 * tblInformeCalificado13.setNota((float) 0.00); nota = nota + (float) 0.00;
					 * break; case "CABLE": tblInformeCalificado13.setNota((float) 0.00); nota =
					 * nota + (float) 0.00; break; case "PORTALES INFORMÁTICOS":
					 * tblInformeCalificado13.setNota((float) 0.00); nota = nota + (float) 0.00;
					 * break; case "RADIO": tblInformeCalificado13.setNota((float) 0.00); nota =
					 * nota + (float) 0.00; break; case "PERIÓDICO":
					 * tblInformeCalificado13.setNota((float) 0.00); nota = nota + (float) 0.00;
					 * break; case "REVISTA": tblInformeCalificado13.setNota((float) 0.00); nota =
					 * nota + (float) 0.00; break; } } else { switch
					 * (datosInstitucion.get(0)[6].toString()) { case "TELEVISIÓN":
					 * tblInformeCalificado13.setNota((float) 0.00); nota = nota + (float) 0.00;
					 * break; case "CABLE": tblInformeCalificado13.setNota((float) 0.00); nota =
					 * nota + (float) 0.00; break; case "PORTALES INFORMÁTICOS":
					 * tblInformeCalificado13.setNota((float) 0.00); nota = nota + (float) 0.00;
					 * break; case "RADIO": tblInformeCalificado13.setNota((float) 0.00); nota =
					 * nota + (float) 0.00; break; case "PERIÓDICO":
					 * tblInformeCalificado13.setNota((float) 0.00); nota = nota + (float) 0.00;
					 * break; case "REVISTA": tblInformeCalificado13.setNota((float) 0.00); nota =
					 * nota + (float) 0.00; break; } }
					 * 
					 * tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
					 * break;
					 */
					case "3. NO ABRE EL LINK":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "4. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "5. NO APLICA":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "6. OTROS, NO CUMPLE":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "7. VACÍO":
						tblInformeCalificado13.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado13.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado13.setPeriodo(periodoInforme);
					if(rutaArchivo8!="") {
						tblInformeCalificado13.setEvidencia(rutaArchivo8);
					}else {
						tblInformeCalificado13.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado13);
					
					
					}
				
				mensaje.put("estado", "exito");
				mensaje.put("codigo", tblInformeCalificado13.getIdInfCal());
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
				}
			catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			}
			finally {
				return mensaje.toString();
			}
	  }
	  
//Metodo Guardar pregunta 9
	  
	  @SuppressWarnings("finally")
	  @RequestMapping(value = "GuardarFrmMediosP9",method = RequestMethod.POST)
	  public @ResponseBody String GuardarFrmMediosP9(
			  @RequestParam("identificadorResponsable") String identificadorResponsable,
			  @RequestParam("infcod") Integer infcod,
			  @RequestParam("cmbPregunta14") String cmbPregunta14,
			  @RequestParam("rutaArchivo9") String rutaArchivo9,			  
			  @RequestParam("periodoInforme") Integer periodoInforme,
			  @RequestParam("pre9") Integer codigo
			  ) {
		  JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try 
			{
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodMedios(infcod,
						(periodoInforme));
				TblInformeCalificado tblInformeCalificado14 = new TblInformeCalificado();
				if(codigo==null) {
					tblInformeCalificado14.setInfCod(infcod);
					tblInformeCalificado14.setMatriz("ESPACIOS PRODUCCIÓN AUDIOVISUAL NACIONAL Y NACIONAL INDEPENDIENTE");
					tblInformeCalificado14
							.setPregunta("¿EL MEDIO CUBRE EL PORCENTAJE DE ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL?");
					tblInformeCalificado14.setRespuesta(cmbPregunta14);
					switch (cmbPregunta14) {
					case "1. LA PRODUCCIÓN NACIONAL INDEPENDIENTE SUMA UN TOTAL DE 10% O MÁS":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado14.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado14.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado14.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado14.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						}

						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. ENTRE AMBOS TOTALES SUMAN 60% O MÁS":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado14.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado14.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado14.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado14.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						}

						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "3. LA PRODUCCIÓN NACIONAL SUMA UN TOTAL DE 60% O MÁS":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado14.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado14.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado14.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado14.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						}
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
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
					case "6. NO APLICA":
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
					if(rutaArchivo9!="") {
						tblInformeCalificado14.setEvidencia(rutaArchivo9);
					}else {
						tblInformeCalificado14.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado14);
				}
				else {
					tblInformeCalificado14= ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado14.setInfCod(infcod);
					tblInformeCalificado14.setMatriz("ESPACIOS PRODUCCIÓN AUDIOVISUAL NACIONAL Y NACIONAL INDEPENDIENTE");
					tblInformeCalificado14
							.setPregunta("¿EL MEDIO CUBRE EL PORCENTAJE DE ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL?");
					tblInformeCalificado14.setRespuesta(cmbPregunta14);
					switch (cmbPregunta14) {
					case "1. LA PRODUCCIÓN NACIONAL INDEPENDIENTE SUMA UN TOTAL DE 10% O MÁS":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado14.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado14.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado14.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado14.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						}

						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. ENTRE AMBOS TOTALES SUMAN 60% O MÁS":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado14.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado14.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado14.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado14.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						}

						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "3. LA PRODUCCIÓN NACIONAL SUMA UN TOTAL DE 60% O MÁS":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado14.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado14.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado14.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado14.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "RADIO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							case "REVISTA":
								tblInformeCalificado14.setNota((float) 0.00);
								nota = nota + (float) 0.00;
								break;
							}
						}
						tblInformeCalificado14.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
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
					case "6. NO APLICA":
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
					if(rutaArchivo9!="") {
						tblInformeCalificado14.setEvidencia(rutaArchivo9);
					}else {
						tblInformeCalificado14.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado14);					
				}
				mensaje.put("estado", "exito");
				mensaje.put("codigo", tblInformeCalificado14.getIdInfCal());
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");

			}catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			}
			finally {
				return mensaje.toString();
			}
	  }
	  
//Metodo Guardar pregunta 10
	  
	  @SuppressWarnings("finally")
	  @RequestMapping(value = "GuardarFrmMediosP10",method = RequestMethod.POST)
	  public @ResponseBody String GuardarFrmMediosP10(
			  @RequestParam("identificadorResponsable") String identificadorResponsable,
			  @RequestParam("infcod") Integer infcod,
			  @RequestParam("cmbPregunta15") String cmbPregunta15,		  
			  @RequestParam("periodoInforme") Integer periodoInforme,
			  @RequestParam("pre10") Integer codigo
			  ) {
		  JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try 
			{
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodMedios(infcod,
						(periodoInforme));
				TblInformeCalificado tblInformeCalificado15 = new TblInformeCalificado();
				if(codigo==null) {
					tblInformeCalificado15.setInfCod(infcod);
					tblInformeCalificado15.setMatriz("MECANISMOS DE CONTROL SOCIAL");
					tblInformeCalificado15.setPregunta("¿EL MEDIO SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?");
					tblInformeCalificado15.setRespuesta(cmbPregunta15);
					switch (cmbPregunta15) {
					case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado15.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado15.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado15.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "REVISTA":
								tblInformeCalificado15.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "CABLE":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado15.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "RADIO":
								tblInformeCalificado15.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA1);
						break;
					case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE	ASISTENCIAS":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado15.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado15.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado15.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "REVISTA":
								tblInformeCalificado15.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "CABLE":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado15.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "RADIO":
								tblInformeCalificado15.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA2);
						break;
					case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado15.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado15.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado15.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado15.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado15.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado15.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado15.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado15.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado15.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado15.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado15.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado15.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA3);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA5);
						break;
					case "6. NO APLICA":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA8);
						break;
					}

					tblInformeCalificado15.setPeriodo(periodoInforme);
					/*
					 * if(rutaArchivo11!="") { tblInformeCalificado15.setEvidencia(rutaArchivo11);
					 * }else { tblInformeCalificado15.setEvidencia("N/A"); }
					 */
					ics.guardarInformeCalificacion(tblInformeCalificado15);
				
				}else {
					tblInformeCalificado15= ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado15.setInfCod(infcod);
					tblInformeCalificado15.setMatriz("MECANISMOS DE CONTROL SOCIAL");
					tblInformeCalificado15
							.setPregunta("¿EL MEDIO SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?");
					tblInformeCalificado15.setRespuesta(cmbPregunta15);
					switch (cmbPregunta15) {
					case "1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado15.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado15.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado15.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "REVISTA":
								tblInformeCalificado15.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "CABLE":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado15.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "RADIO":
								tblInformeCalificado15.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA1);
						break;
					case "2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE	ASISTENCIAS":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado15.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado15.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado15.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "REVISTA":
								tblInformeCalificado15.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "CABLE":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado15.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "RADIO":
								tblInformeCalificado15.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado15.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA2);
						break;
					case "3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado15.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "CABLE":
								tblInformeCalificado15.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado15.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "RADIO":
								tblInformeCalificado15.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "PERIÓDICO":
								tblInformeCalificado15.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							case "REVISTA":
								tblInformeCalificado15.setNota((float) 7.14);
								nota = nota + (float) 7.14;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado15.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "CABLE":
								tblInformeCalificado15.setNota((float) 5.00);
								nota = nota + (float) 5.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado15.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "RADIO":
								tblInformeCalificado15.setNota((float) 5.56);
								nota = nota + (float) 5.56;
								break;
							case "PERIÓDICO":
								tblInformeCalificado15.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							case "REVISTA":
								tblInformeCalificado15.setNota((float) 6.25);
								nota = nota + (float) 6.25;
								break;
							}
						}
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA3);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA5);
						break;
					case "6. NO APLICA":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado15.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado15.setRespuestaInstitucion(Constantes.FE_P8_RESPUESTA8);
						break;
					}

					tblInformeCalificado15.setPeriodo(periodoInforme);
					/*
					 * if(rutaArchivo11!="") { tblInformeCalificado15.setEvidencia(rutaArchivo11);
					 * }else { tblInformeCalificado15.setEvidencia("N/A"); }
					 */
					ics.guardarInformeCalificacion(tblInformeCalificado15);
				
				}
				mensaje.put("estado", "exito");
				mensaje.put("codigo", tblInformeCalificado15.getIdInfCal());
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			}
			catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			}
			finally {
				return mensaje.toString();
			}
	  }

//Metodo Guardar pregunta 11
	  
	  @SuppressWarnings("finally")
	  @RequestMapping(value = "GuardarFrmMediosP11",method = RequestMethod.POST)
	  public @ResponseBody String GuardarFrmMediosP11(
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
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodMedios(infcod,
						Integer.parseInt(periodoInforme));
				//List<Object[]> registrosInformesValorados = ivs.obtenerRegistrosInformesValorados();
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
	  
	  
//Metodo Guardar pregunta 12 INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO ANTERIOR
	  
	  @SuppressWarnings("finally")
	  @RequestMapping(value = "GuardarFrmMediosP12",method = RequestMethod.POST)
	  public @ResponseBody String GuardarFrmMediosP12(
			  @RequestParam("identificadorResponsable") String identificadorResponsable,
			  @RequestParam("infcod") Integer infcod,
			  @RequestParam("cmbPregunta16") String cmbPregunta16,		  
			  @RequestParam("periodoInforme") String periodoInforme,
			  @RequestParam("pre12") Integer codigo,
			  @RequestParam("rutaArchivo10") String rutaArchivo10
			  ) {
		  JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try 
			{
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodMedios(infcod,
						Integer.parseInt(periodoInforme));
				TblInformeCalificado tblInformeCalificado16 = new TblInformeCalificado();
				if(codigo==null) {
					
					tblInformeCalificado16.setInfCod(infcod);
					tblInformeCalificado16.setMatriz(
							"INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO	ANTERIOR");
					tblInformeCalificado16.setPregunta(
							"¿EL MEDIO SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?");
					tblInformeCalificado16.setRespuesta(cmbPregunta16);
					switch (cmbPregunta16) {
					case "1. ACTA, INFORME O DOCUMENTO OFICIAL QUE DEMUESTRA LA IMPLEMENTACIÓN":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado16.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "REVISTA":
								tblInformeCalificado16.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado16.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado16.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}

						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. NO APLICA, PORQUE SE CREA EN EL AÑO DE RENDICIÓN DE CUENTAS":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado16.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "REVISTA":
								tblInformeCalificado16.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado16.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado16.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA2);
						break;
					case "3. NO APLICA, PORQUE EL PROCESO ANTERIOR NO RECIBIÓ APORTES":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado16.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "REVISTA":
								tblInformeCalificado16.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado16.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado16.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA3);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "6. NO APLICA":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado16.setPeriodo(Integer.parseInt(periodoInforme));
					if(rutaArchivo10!="") {
						tblInformeCalificado16.setEvidencia(rutaArchivo10);
					}else {
						tblInformeCalificado16.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado16);
					
					
				}else {
					
					tblInformeCalificado16= ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado16.setInfCod(infcod);
					tblInformeCalificado16.setMatriz(
							"INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO	ANTERIOR");
					tblInformeCalificado16.setPregunta(
							"¿EL MEDIO SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?");
					tblInformeCalificado16.setRespuesta(cmbPregunta16);
					switch (cmbPregunta16) {
					case "1. ACTA, INFORME O DOCUMENTO OFICIAL QUE DEMUESTRA LA IMPLEMENTACIÓN":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado16.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "REVISTA":
								tblInformeCalificado16.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado16.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado16.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}

						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;
					case "2. NO APLICA, PORQUE SE CREA EN EL AÑO DE RENDICIÓN DE CUENTAS":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado16.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "REVISTA":
								tblInformeCalificado16.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado16.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado16.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA2);
						break;
					case "3. NO APLICA, PORQUE EL PROCESO ANTERIOR NO RECIBIÓ APORTES":
						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado16.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "REVISTA":
								tblInformeCalificado16.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado16.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "CABLE":
								tblInformeCalificado16.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "RADIO":
								tblInformeCalificado16.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PERIÓDICO":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado16.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA3);
						break;
					case "4. NO ABRE EL LINK":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "6. NO APLICA":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "7. OTROS, NO CUMPLE":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "8. VACÍO":
						tblInformeCalificado16.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado16.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado16.setPeriodo(Integer.parseInt(periodoInforme));
					if(rutaArchivo10!="") {
						tblInformeCalificado16.setEvidencia(rutaArchivo10);
					}else {
						tblInformeCalificado16.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado16);
					
				}
				mensaje.put("estado", "exito");
				mensaje.put("codigo", tblInformeCalificado16.getIdInfCal());
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			}
			catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			}
			finally {
				return mensaje.toString();
			}
	  }
	  
	  
//Metodo Guardar pregunta 13 INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO ANTERIOR
	  
	  @SuppressWarnings("finally")
	  @RequestMapping(value = "GuardarFrmMediosP13",method = RequestMethod.POST)
	  public @ResponseBody String GuardarFrmMediosP13(
			  @RequestParam("identificadorResponsable") String identificadorResponsable,
			  @RequestParam("infcod") Integer infcod,
			  @RequestParam("cmbPregunta17") String cmbPregunta17,		  
			  @RequestParam("periodoInforme") String periodoInforme,
			  @RequestParam("pre13") Integer codigo,
			  @RequestParam("rutaArchivo11") String rutaArchivo11
			  ) {
		  JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			float nota = (float) 00.00;
			try 
			{
				List<Object[]> datosInstitucion = is.obtenerRegistroInformeInstitucionXInfcodMedios(infcod,
						Integer.parseInt(periodoInforme));
				TblInformeCalificado tblInformeCalificado17 = new TblInformeCalificado();
				if(codigo==null) {
					
					tblInformeCalificado17.setInfCod(infcod);
					tblInformeCalificado17.setMatriz(
							"INFORMACIÓN FINANCIERA (LOCPCCS Art. 10, LEY DE EMPRESAS PÚBLICAS ART. 45 SISTEMAS DE INFORMACIÓN)");
					tblInformeCalificado17.setPregunta("¿EL MEDIO SUSTENTA SU BALANCE GENERAL?");
					tblInformeCalificado17.setRespuesta(cmbPregunta17);
					switch (cmbPregunta17) {
					case "1. BALANCE GENERAL DIGITALIZADO":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado17.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado17.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado17.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado17.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado17.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "REVISTA":
								tblInformeCalificado17.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado17.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "CABLE":
								tblInformeCalificado17.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado17.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "RADIO":
								tblInformeCalificado17.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado17.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado17.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}

						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;

					case "2. NO ABRE EL LINK":
						tblInformeCalificado17.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado17.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "4. RESPONDE EN 0":
						tblInformeCalificado17.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "5. OTROS, NO CUMPLE":
						tblInformeCalificado17.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "6. VACÍO":
						tblInformeCalificado17.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado17.setPeriodo(Integer.parseInt(periodoInforme));
					if(rutaArchivo11!="") {
						tblInformeCalificado17.setEvidencia(rutaArchivo11);
					}else {
						tblInformeCalificado17.setEvidencia("N/A"); 
					}
					ics.guardarInformeCalificacion(tblInformeCalificado17);
					
					
				}else {
					
					tblInformeCalificado17= ics.ObtenerRegistroXidInfCal(codigo);
					tblInformeCalificado17.setInfCod(infcod);
					tblInformeCalificado17.setMatriz(
							"INFORMACIÓN FINANCIERA (LOCPCCS Art. 10, LEY DE EMPRESAS PÚBLICAS ART. 45 SISTEMAS DE INFORMACIÓN)");
					tblInformeCalificado17.setPregunta("¿EL MEDIO SUSTENTA SU BALANCE GENERAL?");
					tblInformeCalificado17.setRespuesta(cmbPregunta17);
					switch (cmbPregunta17) {
					case "1. BALANCE GENERAL DIGITALIZADO":

						if (datosInstitucion.get(0)[5].toString().equals("PRIVADO")
								|| datosInstitucion.get(0)[5].toString().equals("COMUNITARIA")) {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado17.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "CABLE":
								tblInformeCalificado17.setNota((float) 11.11);
								nota = nota + (float) 11.11;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado17.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "RADIO":
								tblInformeCalificado17.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PERIÓDICO":
								tblInformeCalificado17.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							case "REVISTA":
								tblInformeCalificado17.setNota((float) 14.29);
								nota = nota + (float) 14.29;
								break;
							}
						} else {
							switch (datosInstitucion.get(0)[6].toString()) {
							case "TELEVISIÓN":
								tblInformeCalificado17.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "CABLE":
								tblInformeCalificado17.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "PORTALES INFORMÁTICOS":
								tblInformeCalificado17.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "RADIO":
								tblInformeCalificado17.setNota((float) 10.00);
								nota = nota + (float) 10.00;
								break;
							case "PERIÓDICO":
								tblInformeCalificado17.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							case "REVISTA":
								tblInformeCalificado17.setNota((float) 12.50);
								nota = nota + (float) 12.50;
								break;
							}
						}

						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA1);
						break;

					case "2. NO ABRE EL LINK":
						tblInformeCalificado17.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA4);
						break;
					case "3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN":
						tblInformeCalificado17.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA5);
						break;
					case "4. RESPONDE EN 0":
						tblInformeCalificado17.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA6);
						break;
					case "5. OTROS, NO CUMPLE":
						tblInformeCalificado17.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA7);
						break;
					case "6. VACÍO":
						tblInformeCalificado17.setNota((float) 0.00);
						nota = nota + (float) 0.00;
						tblInformeCalificado17.setRespuestaInstitucion(Constantes.FE_P7_RESPUESTA8);
						break;
					}

					tblInformeCalificado17.setPeriodo(Integer.parseInt(periodoInforme));
					if(rutaArchivo11!="") {
						tblInformeCalificado17.setEvidencia(rutaArchivo11);
					}else {
						tblInformeCalificado17.setEvidencia("N/A");
					}
					ics.guardarInformeCalificacion(tblInformeCalificado17);
					
					
				}
				mensaje.put("estado", "exito");
				mensaje.put("codigo", tblInformeCalificado17.getIdInfCal());
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			}
			catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			}
			finally {
				return mensaje.toString();
			}
	  }
	 
//cargar metodo
		

	

}
