package gob.cpccs.controller.registro;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/*
import com.sistema.model.aplicacion.TblAplicaciones;
import com.sistema.model.aplicacion.TblAplicacionesRegistradas;
import com.sistema.model.usuario.TblPerfil;
import com.sistema.model.usuario.TblUsuarioRol;
import com.sistema.utilidades.EncriptarContrasenia;
import com.sistema.utilidades.VerificarRecaptcha;*/

import gob.cpccs.model.aplicacion.TblAplicaciones;
import gob.cpccs.model.aplicacion.TblAplicacionesRegistradas;
import gob.cpccs.model.catalogos.TblFuncion;
import gob.cpccs.model.catalogos.TblInstitucion;
import gob.cpccs.model.catalogos.TblLocalizacion;
import gob.cpccs.model.catalogos.TblSector;
import gob.cpccs.model.catalogos.TblTipoIes;
import gob.cpccs.model.catalogos.TblTipoMedio;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.usuario.TblPerfil;
import gob.cpccs.model.usuario.TblResponables;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.model.usuario.TblUsuarioRol;
import gob.cpccs.service.aplicacion.AplicacionesServicio;
import gob.cpccs.service.catalogos.CatalogosServicio;
import gob.cpccs.service.catalogos.InstitucionServicio;
import gob.cpccs.service.mail.EmailService;
import gob.cpccs.service.rendicion.InformeServicio;
import gob.cpccs.service.usuario.ResponsableServicio;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;
import gob.cpccs.utilidades.EncriptarContrasenia;
import gob.cpccs.utilidades.GenerarPassword;
import gob.cpccs.utilidades.ValidaEmail;
import gob.cpccs.utilidades.VerificarRecaptcha;

@Controller
public class RegistroInstitucionController {
	

	@Autowired
	private CatalogosServicio gcs;
	@Autowired
	private UsuarioServicio Usu_registro;
	@Autowired
	private ResponsableServicio resp;
	@Autowired
	private AplicacionesServicio Apli;
    @Autowired
    private EmailService ms;
    @Autowired
	private UsuarioServicio usu;
    @Autowired
	private InformeServicio infor;
	@Autowired
	private InstitucionServicio servicioinstitucion;
	
	   @RequestMapping(value = "/RegistroInstitucion")
	     public String registroUsaurioExterno(TblUsuario tblUsuario, Model model,HttpServletRequest request, HttpServletResponse response) {
	          
		   		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
	          response.setHeader("X-CSRF-TOKEN", token.getToken());
	          
	         /*List<TblGenero> listadoGenero = gcs.obtenerGenerosActivos("activo");
	          model.addAttribute("listadoGenero", listadoGenero);*/
	          List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacion(1, "activo");
	          model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);

	          List<TblLocalizacion> listadoLocalizacionCanton = gcs.obtenerLocalizacion(2, "activo");
	          model.addAttribute("listadoLocalizacionCanton", listadoLocalizacionCanton);

	          List<TblLocalizacion> listadoLocalizacionParroquia = gcs.obtenerLocalizacion(4, "activo");
	          model.addAttribute("listadoLocalizacionParroquia", listadoLocalizacionParroquia);

	          Date date = new Date();
	          DateFormat formatter = new SimpleDateFormat("yyyy");
	          String anio = formatter.format(date);
	          model.addAttribute("anio", anio);
	  		
	     

	          return "registroUsuario/RegistroInstitucion";
	     }
	   
	     @RequestMapping(value = "/consultaRuc", method = RequestMethod.POST)
	     public @ResponseBody String consultaRuc(Model model, @RequestParam("ruc") String ruc) {
	    	  	    	 
	          String resultado ="";

	    	 List<TblInstitucion> ListaInstiticuiones=gcs.ObtenerInstitucionesXRucEstado(ruc, Constantes.ESTADO_INACTIVO,Constantes.periodo() );
	          if (ListaInstiticuiones.size() > 0){	    
	               for (TblInstitucion item : ListaInstiticuiones){
	                    resultado += "<option value=" + item.getInstCod() + ">" + item.getInstNom() + "</option>";
	               }	          
	          }else {	        	  
	        	  resultado ="vacio";	        	  
	          }
	    	 
	          return resultado;
	     }     
	     
	 
		
			@SuppressWarnings("finally")
			@RequestMapping(value = "/cargardatosRuc", method = RequestMethod.POST)
			public @ResponseBody String cargardatosRuc(Model model, @RequestParam("codigo") String codigo) {
				JSONObject mensaje = new JSONObject();
		          try{
		        	  if(codigo!="") {
		        		
		        	Integer cod= Integer.parseInt(codigo);	  
				

					TblInstitucion ListaInstiticuiones = gcs.ObtenerInstitucionesXidEstado(cod,	Constantes.ESTADO_INACTIVO, Constantes.periodo());
					TblInstitucion tblInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(cod);
					if (ListaInstiticuiones != null) {

						TblFuncion tblFuncion = gcs.ObtenerFuncionXid(ListaInstiticuiones.getInstFunCod().getFunCod());

						TblSector tblSector=gcs.ObtenerSectorXid(ListaInstiticuiones.getInstSecCod().getSecCod());	
						TblTipoMedio tblTipoMedio=gcs.ObtenerTipoMedioXid(ListaInstiticuiones.getInstTmeCod().getTmeCod());
						if(ListaInstiticuiones.getInstFunCod().getFunCod() == 7) {
							mensaje.put("tipoMI", tblInstitucion.getTiesCod().getTiesDes());
						}else {	

							mensaje.put("tipoMI", tblTipoMedio.getTmeDes());
						}
						  mensaje.put("funcion", tblFuncion.getFunDes());
						  mensaje.put("sector", tblSector.getSecDes());
						  
						  mensaje.put("nivel", ListaInstiticuiones.getInstTipDes());
						  
					}
					else {
						 mensaje.put("valida", "vacio");
					}
					}else {
						 mensaje.put("valida", "vacio");
					}
			  }
            catch (Exception e){
                 mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
            } finally{
               return mensaje.toString();
            }
				
			}
			
			@SuppressWarnings("finally")
			@RequestMapping(value = "/ValidarUsuario", method = RequestMethod.POST)
			public @ResponseBody String ValidarUsuario(Model model, @RequestParam("codigo") String CorreoResponRegis) {
				JSONObject mensaje = new JSONObject();
		          try{
		        	  if(CorreoResponRegis!="") {
		        		
		        	  
		        	 TblUsuario validarRegistro= Usu_registro.BuscarUsuarioEmailXperido(CorreoResponRegis,Constantes.periodo());
									
					if (validarRegistro == null) {

						 mensaje.put("valida", "nuevo");
						  
					}
					else {
						 mensaje.put("valida", "existe");
					}
					}else {
						 mensaje.put("valida", "vacio");
					}
			  }
            catch (Exception e){
                 mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
            } finally{
               return mensaje.toString();
            }
				
			}	
			
			
			 @PostMapping(value = "/guardarUsuarioIntitucion")
		     public String guardarUsuarioIntitucion(TblUsuario tblUsuario,
		    		 //intitucion
		    		 @RequestParam("institucion") Integer Codinstitucion,
			          @RequestParam("provincia") Integer provincia,
			          @RequestParam("canton") Integer canton,	        
			          @RequestParam("parroquia") Integer parroquia,	       	         
			          @RequestParam("direccion") String direccion,
			          @RequestParam("correoElectronico") String correoElectronico,
			          @RequestParam("telefono") String telefono,
			          @RequestParam("PaginaWeb") String PaginaWeb,
			          @RequestParam("pathModuloRegistro") String pathModuloRegistro,
			          //datos representante legal
			          
			          @RequestParam("NombreRepreLegal") String NombreRepreLegal,
			          @RequestParam("CargoRepreLegal") String CargoRepreLegal,
			          @RequestParam("CorreoRepreLegal") String CorreoRepreLegal,
			          @RequestParam("FechaRepreLegal") String FechaRepreLegal,
			          @RequestParam("TelfRepreLegal") String TelfRepreLegal,
			          @RequestParam("celularRepreLegal") String celularRepreLegal,
			          //datos Responsable del proceso
			          
			          @RequestParam("NombreResponPro") String NombreResponPro,
			          @RequestParam("CargoResponPro") String CargoResponPro,
			          @RequestParam("CorreoResponPro") String CorreoResponPro,
			          @RequestParam("FechaResponPro") String FechaResponPro,
			          @RequestParam("TelfResponPro") String TelfResponPro,
			          @RequestParam("celularResponPro") String celularResponPro,
			          //datos Responsable del registro del informe
			          
			          @RequestParam("NombreResponRegis") String NombreResponRegis,
			          @RequestParam("CargoResponRegis") String CargoResponRegis,
			          @RequestParam("FechaResponRegis") String FechaResponRegis,
			          @RequestParam("TelfResponRegis") String TelfResponRegis,
			          @RequestParam("celularResponRegis") String celularResponRegis,
			          @RequestParam("CedulaResponRegis") String CedulaResponRegis,
			          @RequestParam("CorreoResponRegis") String CorreoResponRegis,
						/*
						  @RequestParam("NombreAbuelaResponRegistro") String
						  NombreAbuelaResponRegistro,
						 */		          
			          @RequestParam("fechaNacimiento") String fechaNacimiento,
			          @RequestParam("passwordResponRegis") String passwordResponRegis,
			          
			          @RequestParam("g-recaptcha-response") String gRecaptchaResponse, Model model, RedirectAttributes attributes, Errors errors) throws IOException, ParseException {
			        
		                  	    	 
			       //    boolean verificarRecaptcha = VerificarRecaptcha.verify(gRecaptchaResponse);
			      
				 //se retira consulta de verificación recaptcha debido a la cantidad de información que se ingresa	
				 boolean verificarRecaptcha = true;
			           
			          TblUsuario validarRegistro= Usu_registro.BuscarUsuarioEmailXperido(CorreoResponRegis.toLowerCase(),Constantes.periodo());
			       	   TblInstitucion validarRegistroInst= servicioinstitucion.ObtenerInstitucionesXIdcodigo(Codinstitucion);
			       
			           if(validarRegistroInst.getInstEstado().equals("inactivo") && validarRegistro==null){
			               if (verificarRecaptcha){			            	   
			            	  
			            	     TblInstitucion ListaInstiticuiones = gcs.ObtenerInstitucionesXidEstado(Codinstitucion,	Constantes.ESTADO_INACTIVO, Constantes.periodo());
				                    Boolean puedeAcceder = false;
				 	                ArrayList<String> listaModulos=new ArrayList<String>();
				 	               ArrayList<Integer> listaPerfiles=new ArrayList<Integer>();
				 	              
				 	            
				                    switch (ListaInstiticuiones.getInstTfCod().getTfCod()) {
				                    case 1:	
				                    	  puedeAcceder = true;
				                    	  listaModulos.add("APLIC-INFOR-GADX");
						                  listaPerfiles.add (ListaInstiticuiones.getInstTfCod().getTfCod());
						                  
				                    break;
				                    case 2:
				                    	 puedeAcceder = true;
				                    	  listaModulos.add("APLIC-INFOR-EGCM");
				                    	  listaPerfiles.add (ListaInstiticuiones.getInstTfCod().getTfCod());
				                    	  //Agregamos el nuevo módulo de retroalimentacion
				                    	  listaModulos.add("APLIC-RETR-EGCM");
						                  listaPerfiles.add (ListaInstiticuiones.getInstTfCod().getTfCod());
				                    break;
				                    case 3:
				                    	  puedeAcceder = true;
				                    	  listaModulos.add("APLIC-INFOR-EEJB");
						                  listaPerfiles.add (ListaInstiticuiones.getInstTfCod().getTfCod());
				                    break;
				                    case 4:
				                    	  puedeAcceder = true;
				                    	  listaModulos.add("APLIC-INFOR-RCCA");
						                  listaPerfiles.add (ListaInstiticuiones.getInstTfCod().getTfCod());
				                    break;
				                    case 5:
				                    	  puedeAcceder = true;
				                    	  listaModulos.add("APLIC-INFOR-IESX");
				                    	//Agregamos el nuevo módulo de retroalimentacion para instituciones educ sup
				                    	  listaModulos.add("APLIC-RETR-IESX");
						                  listaPerfiles.add (ListaInstiticuiones.getInstTfCod().getTfCod());
						                
				                    break;
				                    case 6:
				                    	  puedeAcceder = true;
				                    	  listaModulos.add("APLIC-INFOR-FEXX");
						                  listaPerfiles.add (ListaInstiticuiones.getInstTfCod().getTfCod());
				                    break;
				                    case 7:
				                    	  puedeAcceder = true;
				                    	  listaModulos.add("APLIC-INFOR-MDXX");
						                  listaPerfiles.add (ListaInstiticuiones.getInstTfCod().getTfCod());
				                    break;
				                    case 8:
				                    	  puedeAcceder = true;
				                    	  listaModulos.add("APLIC-INFOR-IESS");
						                  listaPerfiles.add (ListaInstiticuiones.getInstTfCod().getTfCod());
				                    break;
				                  
				                    default:
				                         puedeAcceder = false;
				               }
				                  
				                 if (puedeAcceder) {
									
							   
				               CrearResponsables(NombreRepreLegal.toUpperCase(), CargoRepreLegal.toUpperCase(), CorreoRepreLegal.toLowerCase(), TelfRepreLegal, celularRepreLegal, FechaRepreLegal, Constantes.REPRESENTANTE_LEGAL, Integer.toString(Constantes.periodo()), Codinstitucion);
				               CrearResponsables(NombreResponPro.toUpperCase(), CargoResponPro.toUpperCase(), CorreoResponPro.toLowerCase(), TelfResponPro, celularResponPro, FechaResponPro, Constantes.RESPONSABLE_RENDICION, Integer.toString(Constantes.periodo()), Codinstitucion);
				               CrearResponsables(NombreResponRegis.toUpperCase(), CargoResponRegis.toUpperCase(), CorreoResponRegis.toLowerCase(), TelfResponRegis, celularResponRegis, FechaResponRegis, Constantes.RESPONSABLE_REGISTRO, Integer.toString(Constantes.periodo()), Codinstitucion);
				            	  				                    
			                   tblUsuario.setNombre(NombreResponRegis.toUpperCase());
			            	   tblUsuario.setIdentificador(CedulaResponRegis);
			            	   tblUsuario.setEmail(CorreoResponRegis.toLowerCase());
			            	   EncriptarContrasenia encriptarContrasenia = new EncriptarContrasenia();
			            	   tblUsuario.setPassword(encriptarContrasenia.passwordEncoder().encode(passwordResponRegis));	
			            	   tblUsuario.setFechaRegistro(new Date());
			            	   tblUsuario.setEstado(Constantes.ESTADO_INACTIVO_USUARIOS);			            	  
			            	   Date fechas=new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);
			            	   tblUsuario.setFechaNacimiento(fechas);
			            	   //tblUsuario.setNombreAbuela(NombreAbuelaResponRegistro.toUpperCase());
			            	   tblUsuario.setPeriodo(Constantes.periodo());
			            	   tblUsuario.setProvincia(provincia);
			            	   tblUsuario.setCodigoIntitucionAutorida(Codinstitucion);
			            	   tblUsuario.setTipoUser(Constantes.TIPO_REGISTRO_INSTITUCION);
			            	   tblUsuario.setCodigoTemporal(passwordResponRegis);
			                    Usu_registro.guardarUsuario(tblUsuario);
			                    
			                   
			                   // Usu_registro.guardarRolesUsuario(tblRolesUsuarios);
			               
			                 
			                    List<TblAplicaciones> datosAplicaciones= Apli.buscarAplicacionesPorListaCodigoAplicacion(Constantes.ESTADO, listaModulos);
			                    
			                    if (datosAplicaciones.size() > 0){
			                         for (TblAplicaciones datosAp : datosAplicaciones) {
			                           
			                              TblAplicaciones tblAplicaciones = new TblAplicaciones();
			                              tblAplicaciones.setIdAplicacion(datosAp.getIdAplicacion());
			                                   List<TblAplicacionesRegistradas>  datosApliRegis=Usu_registro.buscarAplicacionesRegistradasPorIdentificadorAndIdAplicacion(tblUsuario.getIdentificador(), tblAplicaciones,CorreoResponRegis.toLowerCase(), Constantes.periodo().toString(), Constantes.ESTADO_ACTIVO_USUARIOS);
			                                  
			                                   if(datosApliRegis.size()==0) {
			                                        TblAplicacionesRegistradas tblAplicacionesRegistradas = new TblAplicacionesRegistradas();
			                                        tblAplicacionesRegistradas.setIdAplicacion(tblAplicaciones);
			                                        tblAplicacionesRegistradas.setIdentificador(tblUsuario.getIdentificador());
			                                        tblAplicacionesRegistradas.setEmailIdentificador(tblUsuario.getEmail());
			                                        tblAplicacionesRegistradas.setPeriodo(Constantes.periodo().toString());
			                                        tblAplicacionesRegistradas.setEstado(1);
			                                        Usu_registro.GuardarApliRegistradas(tblAplicacionesRegistradas);
			                                   }else {
			                                       
			                                   }
			                                   List<TblPerfil> datosPerfiles= Usu_registro.buscarPerfilesEstadoPorListaCodigoPerfil(Constantes.ESTADO,listaPerfiles);
			                                   
			                                   for (TblPerfil datospe : datosPerfiles) {
			                                        TblPerfil tblPerfil = new TblPerfil();
			                                        tblPerfil.setIdPerfil(datospe.getIdPerfil());
			                                        List<TblUsuarioRol> datosUsuaPerf=Usu_registro.buscarUsuariosPerfilesPorIdentificadorAndIdPerfil(tblUsuario, tblPerfil);
			                                        if(datosUsuaPerf.size()==0) {
			                                        	TblUsuarioRol tblUsuarioRol = new TblUsuarioRol();
			                 		                    tblUsuarioRol.setIdRol(Usu_registro.buscarIdRolxNombre("ROLE_USER"));	                    
			                 		                    tblUsuarioRol.setIdUser(tblUsuario);       
			                 		                    tblUsuarioRol.setUsurolEstado(Constantes.ESTADO_ACTIVO_USUARIOS);
			                 		                    tblUsuarioRol.setUsurolDescripcion(datosAp.getNombre());
			                 		                    tblUsuarioRol.setIdPerfil(tblPerfil);
			                 		                    
			                 		                    Usu_registro.GuardarRolUsuaru(tblUsuarioRol);
			                                        }
			                                    }
			                                   
			                         }
			                    }
			                    
			                    gcs.ActualizarDatosIntitucionRegistro(provincia, canton, parroquia, direccion.toUpperCase(), telefono, correoElectronico, PaginaWeb, new Date(), Codinstitucion,pathModuloRegistro, Constantes.ESTADO_REGISTRADO);
			                    attributes.addFlashAttribute("message", "Usuario fue registrado exitosamente!");
			                   
			                    if (CorreoResponRegis != null && !CorreoResponRegis.equals("") && CorreoRepreLegal != null && !CorreoRepreLegal.equals("") && CorreoResponPro != null && !CorreoResponPro.equals("")){
		                    	
			                        ms.mailRegistroIntitucionResponRegis(CorreoResponRegis.toLowerCase(), NombreResponRegis.toUpperCase(),ListaInstiticuiones.getInstNom(), ListaInstiticuiones.getInstRuc(), passwordResponRegis , fechas, true);
			                        ms.mailRegistroIntitucionResponbles(CorreoRepreLegal.toLowerCase(), NombreRepreLegal.toUpperCase(),ListaInstiticuiones.getInstNom(), true);
			                        ms.mailRegistroIntitucionResponbles(CorreoResponPro.toLowerCase(), NombreResponPro.toUpperCase(),ListaInstiticuiones.getInstNom(), true);
			                        
			                   
			                    }

			               }
				            }
				                 else{
			                    attributes.addFlashAttribute("error", "ReCaptcha expirado, vuelva a intentar!");
			               }
			              }else { 
			            	  attributes.addFlashAttribute("error", "Ya se encuentra en estado "+validarRegistroInst.getInstEstado() +"!");
			              }
			            

			          return "redirect:/";
			     }	     
			 
			 
			 @SuppressWarnings("finally")
			public String CrearResponsables(String nombre, String cargo,String correo,String telefono,String celular,String fechadesignacion,String tipo,String periodo,Integer insticod ) {
				 JSONObject mensaje = new JSONObject();
			 try{
			   TblResponables tblResponables= new TblResponables();
          	   tblResponables.setResponNombre(nombre.toUpperCase());
          	   tblResponables.setResponCargo(cargo.toUpperCase());
          	   tblResponables.setResponEmail(correo);
          	   tblResponables.setResponTelefono(telefono);
          	   tblResponables.setResponCelular(celular);
          	    Date fechas=new SimpleDateFormat("dd/MM/yyyy").parse(fechadesignacion);
          	   tblResponables.setResponFechaDesignacion(fechas);
          	   tblResponables.setResponTipo(tipo);
          	   tblResponables.setResponPeriodo(periodo);
          	   tblResponables.setResponCodRefe(insticod);
          	   resp.GuardarResponsables(tblResponables);
               mensaje.put("estado", "exito");
               mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
			 }
          	  catch (Exception e){
	               mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
	          } finally{
	               return mensaje.toString();
	              
	          }
				
			}

		}
