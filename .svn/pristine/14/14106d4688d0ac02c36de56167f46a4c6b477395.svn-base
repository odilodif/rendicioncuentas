package gob.cpccs.controller.registro;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gob.cpccs.model.aplicacion.TblAplicaciones;
import gob.cpccs.model.aplicacion.TblAplicacionesRegistradas;
import gob.cpccs.model.catalogos.TblLocalizacion;
import gob.cpccs.model.usuario.TblAutoridad;
import gob.cpccs.model.usuario.TblPerfil;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.model.usuario.TblUsuarioRol;
import gob.cpccs.service.aplicacion.AplicacionesServicio;
import gob.cpccs.service.autoridad.AutoridadServicio;
import gob.cpccs.service.catalogos.CatalogosServicio;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;
import gob.cpccs.utilidades.EncriptarContrasenia;
import gob.cpccs.utilidades.VerificarRecaptcha;
import gob.cpccs.utilidades.ValidaEmail;
import gob.cpccs.utilidades.GenerarPassword;
import gob.cpccs.service.mail.EmailService;

@Controller
public class RegistroUsuarioController {
	

	@Autowired
	private UsuarioServicio Usu_registro;
	
	@Autowired
	private AutoridadServicio Aut_registro;
	
	@Autowired
	private AplicacionesServicio Apli;
    @Autowired
    private EmailService ms;
    
    @Autowired
    private CatalogosServicio gcs;

	

	     @RequestMapping(value = "/registroAutoridad")
	     public String registroUsaurioExterno(TblUsuario tblUsuario, Model model,HttpServletRequest request, HttpServletResponse response) {
	          
    	 
	    	 CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
	          response.setHeader("X-CSRF-TOKEN", token.getToken());
	          /*  System.out.print(token);
	        List<TblGenero> listadoGenero = gcs.obtenerGenerosActivos("activo");
	          model.addAttribute("listadoGenero", listadoGenero);*/

	          Date date = new Date();
	          DateFormat formatter = new SimpleDateFormat("yyyy");
	          String anio = formatter.format(date);
	          model.addAttribute("anio", anio);
	          
	          List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacion(1, "activo");
              model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
    
              List<TblLocalizacion> listadoLocalizacionCanton = gcs.obtenerLocalizacion(2, "activo");
              model.addAttribute("listadoLocalizacionCanton", listadoLocalizacionCanton);
    
              List<TblLocalizacion> listadoLocalizacionParroquia = gcs.obtenerLocalizacion(4, "activo");
              model.addAttribute("listadoLocalizacionParroquia", listadoLocalizacionParroquia);

	          return "registroUsuario/registroAutoridad";
	     }
	     
	     @PostMapping(value = "/guardarAutoridad")
	     public String guardarAutoridad(TblUsuario tblUSuario,	    		 
	    		  @RequestParam("identificador") String identificador,
	    		  @RequestParam("nombre") String nombre,
	    		  @RequestParam("rutaArchivo3") String pathModuloRegistro, 
	    		  @RequestParam("rutaArchivo2") String docIdentidad, 
	    		 // @RequestParam("pathModuloRegistro") String pathModuloRegistro, 
	    		  @RequestParam("institucion_dignidad") String institucion_dignidad,
	    		  @RequestParam("dignidad") String dignidad,
	    		  @RequestParam("ambito") String ambito,
		          @RequestParam("password") String password,
		          //@RequestParam("nombre_abuela") String nombre_abuela,
		          @RequestParam("fechaNacimiento") Date fechaNacimiento,
		          @RequestParam("telefono") String telefono,
		          @RequestParam("direccion") String direccion,
		          @RequestParam("celular") String celular,
		          @RequestParam("web") String web,
		          @RequestParam("provincia") Integer provincia,
		          @RequestParam("canton") Integer canton,
		          @RequestParam("parroquia") Integer parroquia,
		          @RequestParam("tipoAutoridad") String tipoAutoridad,

				@RequestParam("g-recaptcha-response") String gRecaptchaResponse, Model model, RedirectAttributes attributes, Errors errors) throws IOException {
		           boolean verificarRecaptcha = VerificarRecaptcha.verify(gRecaptchaResponse);   
		           TblUsuario validarRegistro= Usu_registro.BuscarUsuarioEmailXperido(tblUSuario.getEmail(),Constantes.periodo());
		           String clave = tblUSuario.getPassword();    
		           TblAutoridad tblAutoridad = new TblAutoridad();
		           
		           if(validarRegistro==null){
		               if (verificarRecaptcha){
		            	   SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		            	   SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
		            	   String fechaNacimiento1 = df.format(fechaNacimiento);
		            	   tblAutoridad.setNombre(nombre.toUpperCase());
		            	   tblAutoridad.setIdentificador(identificador);
		            	   tblAutoridad.setEmail(tblUSuario.getEmail().toLowerCase());
		            	   tblAutoridad.setTelefono(telefono);
		            	   tblAutoridad.setDireccion(direccion);
		            	   tblAutoridad.setPassword(clave);	            	
		            	   tblAutoridad.setCelular(celular);
		            	   tblAutoridad.setFechaRegistro( new Date());
		            	   tblAutoridad.setEstado(Constantes.ESTADO_REGISTRADO);
		            	   tblAutoridad.setRutaArchivoValidador(pathModuloRegistro); 
		            	   tblAutoridad.setPeriodo(Constantes.periodo());
		            	   tblAutoridad.setNombreAbuela("");
		            	   tblAutoridad.setWeb(web);
		            	   tblAutoridad.setAmbito(ambito);
		            	   tblAutoridad.setMesNacimiento(fechaNacimiento1);            
		            	   tblAutoridad.setInstitucionDignidad(institucion_dignidad.toUpperCase());
		            	   tblAutoridad.setDignidad(dignidad.toUpperCase());
		            	   tblAutoridad.setProvincia(provincia);
		            	   tblAutoridad.setCanton(canton);
		            	   tblAutoridad.setParroquia(parroquia);
		            	   tblAutoridad.setTipoAutoridad(tipoAutoridad);
		            	   tblAutoridad.setDocumentoCedula(docIdentidad);
		            	   
		            	  
		                   String fecha = df2.format(tblAutoridad.getFechaRegistro());
		                   String fechaNacimientoAutoridad = df2.format(tblUSuario.getFechaNacimiento());
		                   Aut_registro.guardarAutoridad(tblAutoridad);
		            	  
		            	   
		                   EncriptarContrasenia encriptarContrasenia = new EncriptarContrasenia();
		                   tblUSuario.setIdentificador(identificador);
		                   tblUSuario.setNombre(nombre.toUpperCase());
		                   tblUSuario.setEmail(tblUSuario.getEmail().toLowerCase());
		                   tblUSuario.setPassword(encriptarContrasenia.passwordEncoder().encode(tblAutoridad.getPassword()));
		                   tblUSuario.setFechaRegistro( new Date());
		                   tblUSuario.setEstado(Constantes.ESTADO_INACTIVO_USUARIOS);
		            	   tblUSuario.setPeriodo(Constantes.periodo());
		            	   tblUSuario.setFechaNacimiento(fechaNacimiento);
		            	   tblUSuario.setNombreAbuela("");
		            	   tblUSuario.setTipoUser(Constantes.TIPO_REGISTRO_AUTORIDAD);
		            	   tblUSuario.setCodigoIntitucionAutorida(tblAutoridad.getAutCodigo());
		            	   tblUSuario.setCodigoTemporal(clave);
		            	   Usu_registro.guardarUsuario(tblUSuario);
		            	   
		                    List<String> listaModulos = Arrays.asList("APLIC_RENCU_AUTOR");
		                    List<String> listaPerfiles = Arrays.asList("AUTORIDADES");
		                 
		                    List<TblAplicaciones> datosAplicaciones= Apli.buscarAplicacionesPorListaCodigoAplicacion(Constantes.ESTADO, listaModulos);
		                    
		                    if (datosAplicaciones.size() > 0){
		                         for (TblAplicaciones datosAp : datosAplicaciones) {
		                           
		                              TblAplicaciones tblAplicaciones = new TblAplicaciones();
		                              tblAplicaciones.setIdAplicacion(datosAp.getIdAplicacion());
		                                   List<TblAplicacionesRegistradas>  datosApliRegis=Usu_registro.buscarAplicacionesRegistradasPorIdentificadorAndIdAplicacion(tblAutoridad.getIdentificador(), tblAplicaciones,tblUSuario.getEmail().toLowerCase(), Constantes.periodo().toString(), Constantes.ESTADO_ACTIVO_USUARIOS);
		                                  
		                                   if(datosApliRegis.size()==0) {
		                                        TblAplicacionesRegistradas tblAplicacionesRegistradas = new TblAplicacionesRegistradas();
		                                        tblAplicacionesRegistradas.setIdAplicacion(tblAplicaciones);
		                                        tblAplicacionesRegistradas.setIdentificador(tblAutoridad.getIdentificador());
		                                        tblAplicacionesRegistradas.setEmailIdentificador(tblAutoridad.getEmail().toLowerCase());
		                                        tblAplicacionesRegistradas.setPeriodo(Constantes.periodo().toString());
		                                        tblAplicacionesRegistradas.setEstado(1);
		                                        Usu_registro.GuardarApliRegistradas(tblAplicacionesRegistradas);
		                                   }else {
		                                       
		                                   }
		                                   List<TblPerfil> datosPerfiles= Usu_registro.buscarPerfilesPorListaCodigoPerfil(Constantes.ESTADO,listaPerfiles);
		                                   
		                                   for (TblPerfil datospe : datosPerfiles) {
		                                        TblPerfil tblPerfil = new TblPerfil();
		                                        tblPerfil.setIdPerfil(datospe.getIdPerfil());
		                                        List<TblUsuarioRol> datosUsuaPerf=Usu_registro.buscarUsuariosPerfilesPorIdentificadorAndIdPerfil(tblUSuario, tblPerfil);
		                                        if(datosUsuaPerf.size()==0) {
		                                        	TblUsuarioRol tblUsuarioRol = new TblUsuarioRol();
		                 		                    tblUsuarioRol.setIdRol(Usu_registro.buscarIdRolxNombre("ROLE_USER"));	                    
		                 		                  tblUsuarioRol.setIdUser(tblUSuario);       
		                 		                    tblUsuarioRol.setUsurolEstado(Constantes.ESTADO_ACTIVO_USUARIOS);
		                 		                    tblUsuarioRol.setUsurolDescripcion(datosAp.getNombre());
		                 		                    tblUsuarioRol.setIdPerfil(tblPerfil);
		                 		                   Usu_registro.GuardarRolUsuaru(tblUsuarioRol);
		                                        }
		                                    }
		                                   
		                         }
		                    }
		            	   
		            	   
		                    if (tblAutoridad.getEmail() != null && !tblAutoridad.getEmail().equals("")){
								  ms.mailRegistroAutoridad(tblAutoridad.getEmail(), tblAutoridad.getNombre(), tblAutoridad.getIdentificador(),clave,tblAutoridad.getNombreAbuela(), fechaNacimientoAutoridad,tblAutoridad.getDignidad(), fecha , true); 
							   } 
		            	   
		                    attributes.addFlashAttribute("message", "Usuario fue registrado exitosamente!");
		               } else{
		                    attributes.addFlashAttribute("error", "ReCaptcha expirado, vuelva a intentar!");
		               }
		              }else { 
		            	  attributes.addFlashAttribute("error", "Ya se encuentra Registrado!");
		              }
		          return "redirect:/";
		     }	     
	     @InitBinder
	     public void initBinder(WebDataBinder webDataBinder) {
	          SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	          dateFormat.setLenient(false);
	          webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	     }
	     
	     @RequestMapping(value = "/recuperarClave")
	     public String recuperarClave(TblUsuario tblUsuario, Model model) {

	          Date date = new Date();
	          DateFormat formatter = new SimpleDateFormat("yyyy");
	          String anio = formatter.format(date);
	          model.addAttribute("anio", anio);

	          return "registroUsuario/recuperarContrasenia";
	     }


	     @PostMapping(value = "/generarClave")
	     public String generarClave(@RequestParam("identificador") String identificador,
	          @RequestParam("fechaNacimiento") Date fechaNacimiento,
	          @RequestParam("g-recaptcha-response") String gRecaptchaResponse, Model model, RedirectAttributes attributes) throws IOException {

	          boolean verificarRecaptcha = VerificarRecaptcha.verify(gRecaptchaResponse);
	          
	        //  boolean existeUsuario = false;
	          String mensaje = null;
	          String mail = null;
	          String fechaNacimientoUsuario = null;
	          Date fechaResteo = new Date();
	        		 
	          if (verificarRecaptcha){

	               TblUsuario dastosUsuario = Usu_registro.buscarUsuarioXidentificadorPeriodoEstado(identificador,Constantes.periodo(),Constantes.ESTADO_ACTIVO_USUARIOS);
	             
	               if (dastosUsuario != null){
	                
	                    
	            	   SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	            	   String fechaResteo1 = df.format(fechaResteo);
	                    mail = dastosUsuario.getEmail();
	                    fechaNacimientoUsuario = dastosUsuario.getFechaNacimiento().toString();
	                    String nombre = dastosUsuario.getNombre();
	                    if (dastosUsuario.getEstado().equals(1)){
	                         DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	                         String fechaNacimientoFormateada = formatter.format(fechaNacimiento);
	                         if (fechaNacimientoUsuario.equals(fechaNacimientoFormateada)){
	                              if (mail != null){
	                                   ValidaEmail validarMail = new ValidaEmail();
	                                   if (validarMail.emailValida(mail)){
	                                       // String ip= InetAddress.getLocalHost().getHostAddress();
	                                        String contraseniaNueva = GenerarPassword.restablecerContrasenia();
	                                        EncriptarContrasenia encriptarContrasenia = new EncriptarContrasenia();
	                                        
	                                        String contraseniaNuevaEncriptada = encriptarContrasenia.passwordEncoder().encode(contraseniaNueva);
	                                 
	                                        String subject = "Restablecimiento de contraseña en el "+Constantes.NOMBRE_MODULO_MINUSCULA+"";
	                                        String text = "<!DOCTYPE HTML>\r\n" + 
	                                        	     "<html>\r\n" + 
	                                                 "  <style>\r\n" + 
	                                                 "  .familiaLetra{\r\n" + 
	                                                 "  font-family:'Text Me One', 'Segoe UI', 'Tahoma', 'Helvetica', 'freesans', 'sans-serif';\r\n" + 
	                                                 "  }\r\n" + 
	                                                 "  .anchoTabla{\r\n" + 
	                                                 "    width: 660px;\r\n" + 
	                                                 "  }\r\n" + 
	                                                 "  .tituloMail{\r\n" + 
	                                                 "  font-size: 28px;\r\n" + 
	                                                 "    font-weight: bold;\r\n" + 
	                                                 "    text-align: center;\r\n" + 
	                                                 "  }\r\n" + 
	                                                 "  .subTituloMail{\r\n" + 
	                                                 "    font-size: 22px;\r\n" + 
	                                                 "    font-weight: bold;\r\n" + 
	                                                 "    text-align: center;\r\n" + 
	                                                 "    padding-top: 15px;\r\n" + 
	                                                 "  }\r\n" + 
	                                                 "  .cuerpoDestinatarioMail{\r\n" + 
	                                                 "   padding-top:40px;\r\n" + 
	                                                 "   padding-bottom:10px;\r\n" + 
	                                                 "   font-size:14px;\r\n" + 
	                                                 "  }\r\n" + 
	                                                 "  .cuerpoMail{\r\n" + 
	                                                 "   padding-top:20px;\r\n" + 
	                                                 "   font-size:14px;\r\n" + 
	                                                 "   text-align:justify;\r\n" + 
	                                                 "    \r\n" + 
	                                                 "  }\r\n" + 
	                                                 "  .cuerpoDatosColUnaMail{\r\n" + 
	                                                 "   width:35%;\r\n" + 
	                                                 "   padding-top:10px;\r\n" + 
	                                                 "   font-size:14px;\r\n" + 
	                                                 "   font-weight: bold;\r\n" + 
	                                                 "  }\r\n" + 
	                                                 "  .cuerpoDatosColDosMail{\r\n" + 
	                                                 "   width:65%;\r\n" + 
	                                                 "   padding-top:10px;\r\n" + 
	                                                 "   font-size:14px;\r\n" + 
	                                                 "   font-weight: bold;\r\n" + 
	                                                 "  }\r\n" + 
	                                                 "  .cuerpoPieMail{\r\n" + 
	                                                 "   padding-top:25px;\r\n" + 
	                                                 "   font-size:14px;\r\n" + 
	                                                 "   }\r\n" + 
	                                                 "  .pieMail{\r\n" + 
	                                                 "   padding-top:32px;\r\n" + 
	                                                 "   font-size:14px;\r\n" + 
	                                                 "    }\r\n" + 
	                                                 "  </style>\r\n" + 
	                                                 "  <head>\r\n" + 
	                                                 "  <title>"+Constantes.NOMBRE_INSTITUCION_MAYUSCULA+" informa:</title>\r\n" + 
	                                                 "  </head>\r\n" + 
	                                                 "  <body>\r\n" + 
	                                                 "    <table class='anchoTabla'>\r\n" + 
	                                                 "      <tr><td colspan=\"2\" class='tituloMail familiaLetra'>"+Constantes.NOMBRE_INSTITUCION_MINUSCULA+"</td></tr>\r\n" + 
	                                                 "      <tr><td colspan=\"2\" class='subTituloMail familiaLetra'>"+Constantes.NOMBRE_MODULO_MINUSCULA+"</td></tr>\r\n" + 
	                                                 "      <tr><td colspan=\"2\" class='cuerpoDestinatarioMail familiaLetra'><b>Estimado(a): "+nombre+"</b>,</td></tr>\r\n" +
	                                                 "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Usted ha solicitado el restablecimiento de contraseña a través del "+Constantes.NOMBRE_MODULO_MINUSCULA+".</td></tr>\r\n" +
	                                                 "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Usuario:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+mail+"</td></tr>\r\n" +
	                                                 "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Contraseña:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+contraseniaNueva+"</td></tr>\r\n" +
	                                                 "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Fecha de reseto de contraseña:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+fechaResteo1+"</td></tr>\r\n" +
	                                                 "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Recuerde que cada usuario es responsable del manejo de sus credenciales de acceso del Sistema.</td></tr>\r\n" + 
	                                                 "      <tr><td colspan=\"2\" class='cuerpoPieMail familiaLetra'>Saludos cordiales,<br>"+Constantes.NOMBRE_INSTITUCION_SIGLAS+"</td></tr>\r\n" + 
	                                                 "      <tr><td colspan=\"2\" class='pieMail familiaLetra'><b>Nota:</b>"+ Constantes.NOTA_CORREOS_SISTEMA +"<b> "+Constantes.URL_DIRECTORIO_ASITENCIAS_TECNICAS+"</b>\r\n" + 
	                                                 "      </td></tr>\r\n" + 
	                                                 "    </table>\r\n" + 
	                                                 "  </body>\r\n" + 
	                                                 "</html>";
	                                        Usu_registro.ActualizarClavesUsuarios(contraseniaNuevaEncriptada, identificador,contraseniaNueva);
	                                        ms.prepareAndSend(mail, subject, text, true);
	                                        attributes.addFlashAttribute("message", "La nueva contraseña fue enviada a su correo: " + mail);
	                                   } else{
	                                        attributes.addFlashAttribute("error", "Correo electrónico registrado inválido, comuniquese al correo: "+Constantes.EMAIL_NOTIFICACION);
	                                   }

	                              } else{

	                                   attributes.addFlashAttribute("error", "No se ha registrado ningín correo electr�nico!");
	                              }

	                         } else{
	                              attributes.addFlashAttribute("error", "La fecha de nacimiento ingresa no corresponde al registro en el sistema!");
	                         }
	                    } else if (dastosUsuario.getEstado().equals(0)){
	                         attributes.addFlashAttribute("error", "Su cuenta se encuentra desactivada.!");

	                    } else{
	                         attributes.addFlashAttribute("error", "Su cuenta se encuentra desactivada..!");
	                    }


	               } else{
	                    attributes.addFlashAttribute("error", mensaje);
	               }
	            
	          } else{
	               attributes.addFlashAttribute("error", "ReCaptcha expirado vuelva a intentar!");
	          }

	        

	          return "redirect:/";

	     }

}
