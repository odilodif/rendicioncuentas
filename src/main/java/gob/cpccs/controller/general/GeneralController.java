package gob.cpccs.controller.general;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;

import gob.cpccs.model.aplicacion.TblAplicacionesRegistradas;
import gob.cpccs.model.catalogos.TblInstitucion;
import gob.cpccs.model.dto.funcionarios.EditarperfilUsuariosDTO;
import gob.cpccs.model.usuario.TblAutoridad;
import gob.cpccs.model.usuario.TblResponables;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.service.AplicacionesUsuarioJPAServicio;
import gob.cpccs.service.autoridad.AutoridadServicio;
import gob.cpccs.service.usuario.DatosFuncionariosService;
import gob.cpccs.service.usuario.ResponsableServicio;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.service.catalogos.InstitucionServicio;
import gob.cpccs.utilidades.Constantes;
import gob.cpccs.utilidades.EncriptarContrasenia;


@Controller
public class GeneralController {



  @Autowired
  private AplicacionesUsuarioJPAServicio auis;  
  @Autowired
  private UsuarioServicio us;  
  @Autowired
  private ResponsableServicio UserResponsable;
  @Autowired
  private AutoridadServicio autoridad;
  @Autowired
  private DatosFuncionariosService DatosFuncionario;
  @Autowired
  private InstitucionServicio institucionServicio;
  

  
  
  @RequestMapping(value = "/view/general/misDatosI")
  public String misDatosI( Model model, Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
//	  Date date = new Date();
//		DateFormat formatter = new SimpleDateFormat("yyyy");
//		String anio = formatter.format(date);

		TblUsuario identificadorlogin=us.buscarUsuarioXEmail(authentication.getName(),Constantes.periodo());
     //Cambio menu carlos 
		List<Object[]> listaAplicaciones = auis.AplicacionXusuario(identificadorlogin.getIdentificador(), identificadorlogin.getEmail());
   
    model.addAttribute("aplicaciones", listaAplicaciones);
    model.addAttribute("nombreUsuario", identificadorlogin.getNombre());
    return "general/misDatosI";
  }
  
  @RequestMapping(value = "/view/general/misDatosE")
  public String misDatosE( Model model, Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
	//  Date date = new Date();
	//	DateFormat formatter = new SimpleDateFormat("yyyy");
	//	String anio = formatter.format(date);
		TblUsuario identificadorlogin=us.buscarUsuarioXEmail(authentication.getName(),Constantes.periodo());
		//cambio menu Carlos
    List<Object[]> listaAplicaciones = auis.AplicacionXusuario(identificadorlogin.getIdentificador(), identificadorlogin.getEmail());
   
    model.addAttribute("aplicaciones", listaAplicaciones);
    model.addAttribute("nombreUsuario", identificadorlogin.getNombre());
    return "general/misDatosE";
    
  }
  
  @RequestMapping(value = "/view/general/linkIntereses")
  public String linkIntereses( Model model, Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
    
   
       
    return "general/linkIntereses";
    
  }
  
// Inicio metodos de Edidicon Carlos Morocho Cel:1721556338
  
  @RequestMapping(value = "/view/uath/datosUsuario")
  public String datosUsuario(Authentication authentication, Model model) {
	 
		TblUsuario identificadorlogin=us.buscarUsuarioXEmail(authentication.getName(),Constantes.periodo());
		TblUsuario datosUsuario=us.buscarUsuarioXid(identificadorlogin.getIdUser());
       model.addAttribute("identificador", datosUsuario.getIdentificador());
       model.addAttribute("nombreUsuario", datosUsuario.getNombre());
       model.addAttribute("codigoIntitucionAutorida", datosUsuario.getCodigoIntitucionAutorida());
       model.addAttribute("tipoUser", datosUsuario.getTipoUser());
       return "uath/datosUsuario";

  }
  @PostMapping(value = "/obtenerListaResponsables")
  @ResponseBody
  public String obtenerListaResponsables(Authentication authentication, @RequestParam("codigoIntitucionAutorida") Integer codigoIntitucionAutorida,@RequestParam("tipoUser") String tipoUser) {

	  ObjectMapper mapper =new ObjectMapper();	  
	  String json="";
	  List<EditarperfilUsuariosDTO> ListaDTO= new ArrayList<>();
	  EditarperfilUsuariosDTO instiDTO= new EditarperfilUsuariosDTO();
	 
	  try {	
		  
		  if(tipoUser.equals("institucion")){
			  List<TblResponables> ListaResponsables= UserResponsable.buscarResponsableXcodigoInstitucion(codigoIntitucionAutorida, Constantes.periodo().toString());
			  TblInstitucion institucion=institucionServicio.ObtenerInstitucionesXIdcodigo(codigoIntitucionAutorida);
				ListaDTO= ListaResponsables.stream().filter(obj-> !obj.getResponTipo().equals("RESPONSABLE REGISTRO"))						
				        .map(obj->
				         EditarperfilUsuariosDTO.builder()
						.codigo(obj.getResponCodigo())
						.nombre(obj.getResponNombre())
						.tipo(obj.getResponTipo())
						.categoria(tipoUser)
						.build()
						).collect(Collectors.toList());
				//Institucion
				
				instiDTO.setCodigo(institucion.getInstCod());
				instiDTO.setNombre(institucion.getInstNom());
				instiDTO.setTipo("INSTITUCIÓN");
				instiDTO.setEmail(institucion.getInstEma());
				instiDTO.setTelefono(institucion.getInstTel());
				instiDTO.setCategoria("empresa");
				ListaDTO.add(instiDTO);
				 
			 }else if(tipoUser.equals("autoridad")) {
				 
				 List<TblAutoridad> ListaAutoridad= autoridad.ListaAutoridadXAucodigo(codigoIntitucionAutorida);
				 
				 ListaDTO= ListaAutoridad.stream().map(
						 obj-> EditarperfilUsuariosDTO.builder()
						 .codigo(obj.getAutCodigo())
						 .nombre(obj.getNombre())
						 .tipo(obj.getDignidad())
						 .categoria(tipoUser)						 
						 .build())
						 .collect(Collectors.toList());
			
			 }/*
			 else if(tipoUser.equals("tecnico")) {
				 
				 List<TblDatosFuncionarios> ListaDatosFuncionario= DatosFuncionario.ListaFuncionariosXCodigo(codigoIntitucionAutorida);
				 ListaDTO=ListaDatosFuncionario.stream().map(
						 obj-> EditarperfilUsuariosDTO.builder()
						 .codigo(obj.getIdDatoFuncionario())
						 .nombre(obj.getNombre())
						 .tipo(obj.getCargo())
						 .categoria(tipoUser)	
						 .build())
						 .collect(Collectors.toList());
				
			 }*/
			 else{
				 json = Constantes.MESSAGE_EMPTY_JSON;
				 
			 }
		  
		  
		  json = (!ListaDTO.isEmpty())
					? Constantes.MESSAGE_OK_JSON + mapper.writeValueAsString(ListaDTO) + "}"
					: Constantes.MESSAGE_EMPTY_JSON;
			
	} catch (Exception e) {
		json =Constantes.MESSAGE_ERROR_JSON + e.getMessage() + "}";
	}
	  return json;
  }
  
  @RequestMapping(value = "/view/uath/EditarDatosUsuario")
  public String EditarDatosUsuario(Authentication authentication, Model model,@RequestParam("id") String id) {
	 
	  String[]cadena=id.split(":");	
	  model.addAttribute("categoria", cadena[1]);
	  if(cadena[1].equals("institucion")){
		   TblResponables tblResponables = new TblResponables();
		   tblResponables= UserResponsable.obtenerResponsableResponCodigo(Integer.parseInt(cadena[0]));
		   model.addAttribute("codigo", tblResponables.getResponCodigo());
		   model.addAttribute("nombre", tblResponables.getResponNombre());
		   model.addAttribute("cargo", tblResponables.getResponCargo());
		   model.addAttribute("tipo", tblResponables.getResponTipo());
		   model.addAttribute("correo", tblResponables.getResponEmail());
		   model.addAttribute("fecha", new SimpleDateFormat("dd/MM/yyyy").format(tblResponables.getResponFechaDesignacion()) );
		   model.addAttribute("telf", tblResponables.getResponTelefono());
		   model.addAttribute("celular", tblResponables.getResponCelular());
			 
		 }else if(cadena[1].equals("autoridad")) {
			 
			TblAutoridad tblAutoridad =new TblAutoridad();
			tblAutoridad= autoridad.buscarAutordadCodAut(Integer.parseInt(cadena[0]));
			  model.addAttribute("codigo", tblAutoridad.getAutCodigo());
			   model.addAttribute("nombre", tblAutoridad.getNombre());
			   model.addAttribute("cargo", tblAutoridad.getDignidad());
			   model.addAttribute("tipo", cadena[1]);
			   model.addAttribute("correo", tblAutoridad.getEmail());
			   model.addAttribute("fecha", tblAutoridad.getMesNacimiento().substring(0,tblAutoridad.getMesNacimiento().length()-6));
			   model.addAttribute("telf", tblAutoridad.getTelefono());
			   model.addAttribute("celular", tblAutoridad.getCelular());
			
			
		
		 }else if (cadena[1].equals("empresa")){
			 TblInstitucion institucion=institucionServicio.ObtenerInstitucionesXIdcodigo(Integer.parseInt(cadena[0]));
			 model.addAttribute("codigo", institucion.getInstCod());
			 model.addAttribute("nombre", institucion.getInstNom());
			 model.addAttribute("telf", institucion.getInstTel());
			 model.addAttribute("tipo", cadena[1]);
			 model.addAttribute("correo", institucion.getInstEma());
			 model.addAttribute("pagina", institucion.getInstPag());
			 
		 }/*
		 else if(cadena[1].equals("tecnico")) {
			 
			// List<TblDatosFuncionarios> ListaDatosFuncionario= DatosFuncionario.ListaFuncionariosXCodigo(codigoIntitucionAutorida);
			 System.out.println("datos>> "+ cadena[1]);
			
		 }*/
		
	  
       return "uath/EditarDatosUsuario";

  }
  //EditarPerfilUser
  @SuppressWarnings("finally")
  @RequestMapping(value = "/view/uath/EditarPerfilUser")
  @ResponseBody
  public String EditarPerfilUser(@RequestParam("categoria") String categoria,
		  @RequestParam("codigo") Integer codigo,
		  @RequestParam("nombre") String nombre,
		  @RequestParam(value = "cargo",required = false) String cargo,
		  @RequestParam("correo") String correo,
		  @RequestParam(value="fecha",required = false) String fecha,
		  @RequestParam("telf") String telf,
		  @RequestParam(value="celular",required = false) String celular,
		  @RequestParam(value="paginaWeb",required = false) String paginaWeb
		  ) {
	  JSONObject mensaje = new JSONObject();
      mensaje.put("estado", "error");
      mensaje.put("mensaje", "Ha ocurrido un error!");
      try{
    	  
    	      if(categoria.equals("institucion")){
    		   TblResponables tblResponables = new TblResponables();
    		   tblResponables= UserResponsable.obtenerResponsableResponCodigo(codigo);
    		   tblResponables.setResponNombre(nombre.toUpperCase());
    		   tblResponables.setResponCargo( cargo!=null? cargo.toUpperCase():"");
    		   tblResponables.setResponEmail(correo.toLowerCase().trim());
    		   Date fechas=new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
    		   tblResponables.setResponFechaDesignacion(fechas);
    		   tblResponables.setResponTelefono(telf);
    		   tblResponables.setResponCelular(celular);    		   
    		   UserResponsable.GuardarResponsables(tblResponables);
    		 
    			 
    		 }else if(categoria.equals("autoridad")) {
    			 
    			TblAutoridad tblAutoridad =new TblAutoridad();
    			TblUsuario tblUsuario = new TblUsuario();
    			
    			tblAutoridad= autoridad.buscarAutordadCodAut(codigo);
    			
    			tblUsuario=us.BuscarUsuarioEmailXperido(tblAutoridad.getEmail(),tblAutoridad.getPeriodo());
    			
    			List<TblAplicacionesRegistradas> datosApliRegis = us
						.buscarAplicacionesRegistradasPorEmaeilIdentifiadorPerioEstado(
								tblUsuario.getEmail(), Constantes.periodo().toString(),
								Constantes.ESTADO_ACTIVO_USUARIOS);
    			// Para la tabla autoridad
    		   tblAutoridad.setNombre(nombre.toUpperCase());    		
    		   tblAutoridad.setEmail(correo.toLowerCase().trim());    
     		   tblAutoridad.setMesNacimiento(fecha+" "+"00:00");
     		   tblAutoridad.setTelefono(telf);
     		   tblAutoridad.setCelular(celular);
     		   //para el tabla usuario
     		   tblUsuario.setNombre(nombre.toUpperCase());
     		   tblUsuario.setEmail(correo.toLowerCase());
     		   
     		   us.guardarUsuario(tblUsuario);
     		   //Para las aplicaciones registradas 
     		   for (TblAplicacionesRegistradas AplicacionesRegis : datosApliRegis) {     			   
     			   AplicacionesRegis.setEmailIdentificador(correo.toLowerCase().trim());
					us.GuardarApliRegistradas(AplicacionesRegis);
			      }
    			
    			autoridad.guardarAutoridad(tblAutoridad);
    			
    			
    		 }else if(categoria.equals("empresa")) {
    			 TblInstitucion institucion=institucionServicio.ObtenerInstitucionesXIdcodigo(codigo);
    			 institucion.setInstNom(nombre.toUpperCase());
    			 institucion.setInstPag(paginaWeb);
    			 institucion.setInstTel(telf);
    			 institucion.setInstEma(correo);
    			 institucionServicio.guardarInstitucion(institucion);
    		 }

    	  mensaje.put("estado", "exito");
    	  mensaje.put("mensaje", "Los datos se han guardado correctamente.!");

      } catch (Exception e){
           mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
      } finally{
           return mensaje.toString();
      } 
  }
  
//Fin metodos Editar ususrios //
  @SuppressWarnings("finally")
  @RequestMapping(value = "/view/uath/guardarDatosUsuario")
  public @ResponseBody String guardarDatosUsuario(
       @RequestParam(value = "identificador") String identificador,
       @RequestParam(value = "nombreUsuario") String nombreUsuario,
       @RequestParam(value = "claveActual") String claveActual,
       @RequestParam(value = "claveNueva") String claveNueva,
       @RequestParam(value = "confirmacionClaveNueva") String confirmacionClaveNueva) {

       JSONObject mensaje = new JSONObject();
       mensaje.put("estado", "error");
       mensaje.put("mensaje", "Ha ocurrido un error!");
       try{

            TblUsuario datosUsuario = us.buscarUsuarioXidentificadorPeriodoEstado(identificador,Constantes.periodo(),Constantes.ESTADO_ACTIVO_USUARIOS);
          
            Boolean cambioContrasenia = false;
            String contraseniaNuevaEncriptada = null;
            if (claveNueva.equals(confirmacionClaveNueva)){
                 if (datosUsuario.getPassword() == null){
                      claveNueva = claveActual;
                 } else{
                      EncriptarContrasenia encriptarContrasenia = new EncriptarContrasenia();
                      if (claveNueva == ""){
                           mensaje.put("mensaje", "Ingrese una clave nueva");
                      } else{
                           if (encriptarContrasenia.passwordEncoder().matches(claveActual, datosUsuario.getPassword())){
                                cambioContrasenia = true;
                                contraseniaNuevaEncriptada = encriptarContrasenia.passwordEncoder().encode(claveNueva);
                                mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
                           } else{
                                mensaje.put("mensaje", "La contraseña ingresada no es válida");
                           }
                      }
                 }
            } else{
                 mensaje.put("mensaje", "las claves nuevas no coinciden");
            }

            if (cambioContrasenia){
                 mensaje.put("estado", "exito");
                // String ip = InetAddress.getLocalHost().getHostAddress();
                 us.actualizarClaveAndUsuariointerno(nombreUsuario, contraseniaNuevaEncriptada, claveNueva, identificador);
            }

       } catch (Exception e){
            mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
       } finally{
            return mensaje.toString();
       }
  }
  
  

}
