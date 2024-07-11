package gob.cpccs.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gob.cpccs.model.aplicacion.TblAplicaciones;
import gob.cpccs.model.aplicacion.TblAplicacionesRegistradas;
import gob.cpccs.model.catalogos.TblInstitucion;
import gob.cpccs.model.rendicion.TblInformeAutoridad;
import gob.cpccs.model.usuario.TblAutoridad;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.service.AplicacionesUsuarioJPAServicio;
import gob.cpccs.service.aplicacion.AplicacionesServicio;
import gob.cpccs.service.autoridad.AutoridadServicio;
import gob.cpccs.service.catalogos.InstitucionServicio;
import gob.cpccs.service.rendicion.InformeServicio;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;

@Controller
public class HomeController {

	@Autowired
	private AplicacionesUsuarioJPAServicio auis;
	@Autowired
	private UsuarioServicio us;
	@Autowired
	private InstitucionServicio insti;
	@Autowired
    private AplicacionesServicio as;
	@Autowired
	private AutoridadServicio autori;
	 
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarLogin(Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {	
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy");
		String anio = formatter.format(date);
		model.addAttribute("anio", anio);		
		TblAplicaciones listaAplicaciones = as.obtenerRegistrosAplicacionesPorid(11);
		String version = listaAplicaciones.getVersionApp();
		model.addAttribute("version", version);
		return "login";

	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model, Authentication authentication, HttpServletRequest request,
			HttpServletResponse response) {
		// HttpSession webSession = request.getSession(false);
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		
		response.setHeader("X-CSRF-TOKEN", token.getToken());	
		TblUsuario identificadorlogin=us.buscarUsuarioXEmail(authentication.getName(),Constantes.periodo());
		//Carlos modificacion Menu
		List<Object[]> listaAplicaciones = auis.AplicacionXusuario(identificadorlogin.getIdentificador(), identificadorlogin.getEmail());
		if (identificadorlogin.getTipoUser().equals(Constantes.TIPO_REGISTRO_AUTORIDAD)) {
			
			  List<Object[]> listaAplicaciones1 =
			  as.obtenerRegistrosAplicacionesObjeto(14,"activo");
			  listaAplicaciones.addAll(listaAplicaciones1);
			 
		}
		TblUsuario identificador = new TblUsuario();
		identificador.setIdentificador(identificadorlogin.getIdentificador());

		model.addAttribute("aplicaciones", listaAplicaciones);
		model.addAttribute("nombreUsuario", identificadorlogin.getNombre());
		
		

		return "index";

	}

	@RequestMapping("/urlMenuAplicacion")
	public String obtenerMenu(Model model, @RequestParam("idAplicacion") int idAplicacion,
			@RequestParam("app") String nombreApp, Authentication authentication) throws ParseException {
	
		TblUsuario identificadorlogin=us.buscarUsuarioXEmail(authentication.getName(),Constantes.periodo());
		List<Object[]> listaMenu = null;
		/*
		 * if (idAplicacion == 11) { listaMenu = auis.MenuXaplicacionSinEmail(
		 * idAplicacion); }else {
		 */
			 listaMenu = auis.MenuXaplicacion(identificadorlogin.getEmail(), idAplicacion);

				/* } */
		
		
		Object[] listaMenu2 = listaMenu.get(0);
		Date hoy = new Date();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		if (identificadorlogin.getTipoUser().equals(Constantes.TIPO_REGISTRO_INSTITUCION)) {
			TblInstitucion tblInstitucion=insti.ObtenerInstitucionesXIdcodigo(identificadorlogin.getCodigoIntitucionAutorida());
			if (tblInstitucion !=null) {				
				
				if(tblInstitucion.getInstTfCod().getTfCod().equals(3)||tblInstitucion.getInstTfCod().getTfCod().equals(5)||tblInstitucion.getInstTfCod().getTfCod().equals(6)||tblInstitucion.getInstTfCod().getTfCod().equals(7)||tblInstitucion.getInstTfCod().getTfCod().equals(8)) {
		    		Date fechaInicioBloqueo = format.parse(Constantes.FECHA_CIERRE_INFORME_FUNCIONES_ESTADO);
					Date fechaFinBloqueo = format.parse(Constantes.FECHA_BLOQUEO_SISTEMA_FUNCIONES);
					if(hoy.after(fechaInicioBloqueo)&&hoy.before(fechaFinBloqueo)) {
						model.addAttribute("estadoInforme", Constantes.ESTADO_PROCESO_CONCLUIDO);
			 			model.addAttribute("periodo", tblInstitucion.getInstPeriodo());
			 			listaMenu.clear();
			 			listaMenu.add(listaMenu2);	
					}else {
						
						if (!tblInstitucion.getInstTipDes().equals("UDAF") && tblInstitucion.getInstTfCod().getTfCod().equals(6)) {
							listaMenu.remove(listaMenu.get(2));
							//System.out.println("Aqui funciona");
							} 	
					}
			}else {
				Date fechaInicioBloqueo = format.parse(Constantes.FECHA_CIERRE_INFORME_GAD);
				Date fechaFinBloqueo = format.parse(Constantes.FECHA_BLOQUEO_SISTEMA_GADS);
				if(hoy.after(fechaInicioBloqueo)&&hoy.before(fechaFinBloqueo)) {
					model.addAttribute("estadoInforme", Constantes.ESTADO_PROCESO_CONCLUIDO);
		 			model.addAttribute("periodo", tblInstitucion.getInstPeriodo());
		 			listaMenu.clear();
		 			listaMenu.add(listaMenu2);	
				}else {
					
					if (!tblInstitucion.getInstTipDes().equals("UDAF") && tblInstitucion.getInstTfCod().getTfCod().equals(6)) {
						listaMenu.remove(listaMenu.get(2));
						//System.out.println("Aqui funciona");
						} 	
				}
				
				
			}
		}
		}else {
			
			if (identificadorlogin.getTipoUser().equals(Constantes.TIPO_REGISTRO_AUTORIDAD)) {
				String identificador = identificadorlogin.getEmail();
				TblAutoridad datosAutoridad = autori.buscarAutoridadXidentificadorPeriodo(identificador, Constantes.periodo());	
				
				if(datosAutoridad.getDignidad().equals("ASAMBLEÍSTA NACIONAL")||datosAutoridad.getDignidad().equals("ASAMBLEÍSTA PROVINCIAL")||datosAutoridad.getDignidad().equals("ASAMBLEÍSTA POR CIRCUNSCRIPCIÓN TERRITORIAL")||datosAutoridad.getDignidad().equals("ASAMBLEÍSTA REPRESENTANTE EXTRANJERO")||datosAutoridad.getDignidad().equals("PARLAMENTARIA / PARLAMENTARIO ANDINO")||datosAutoridad.getDignidad().equals("CONSEJERA/ CONSEJERO DEL CPCCS")||datosAutoridad.getDignidad().equals("PRESIDENTE DE LA REPÚBLICA")||datosAutoridad.getDignidad().equals("VICEPRESIDENTE DE LA REPÚBLICA")) {
                 
					Date fechaInicioBloqueo = format.parse(Constantes.FECHA_CIERRE_INFORME_AUTORIDAD_ASAMBLEISTA);
					Date fechaFinBloqueo = format.parse(Constantes.FECHA_BLOQUEO_SISTEMA_AUTORIDAD_ASAMBLEISTA);
					
					if(hoy.after(fechaInicioBloqueo)&&hoy.before(fechaFinBloqueo)) {
						listaMenu.clear();
			 			listaMenu.add(listaMenu2);		
					
					}else{					
							
						}
				}else {
					
					Date fechaInicioBloqueo = format.parse(Constantes.FECHA_CIERRE_INFORME_AUTORIDAD);
					Date fechaFinBloqueo = format.parse(Constantes.FECHA_BLOQUEO_SISTEMA_AUTORIDAD);
					
					if(hoy.after(fechaInicioBloqueo)&&hoy.before(fechaFinBloqueo)) {
						listaMenu.clear();
			 			listaMenu.add(listaMenu2);		
					
					}else{					
							
						}
				}
				
			}else {
				
				
			}
			
			
			
			
		
		}
		model.addAttribute("menuAplicacion", listaMenu);
		model.addAttribute("nombreApp", nombreApp);

		return "plantillasIndex/ventanaAplicacion";
	}

	@RequestMapping("/urlAplicaciones")
	public String obtenerAplicaciones(Model model, Authentication authentication) {
		TblUsuario identificadorlogin=us.buscarUsuarioXEmail(authentication.getName(),Constantes.periodo());
		//Carlos modificacion Menu
		List<Object[]> listaAplicaciones = auis.AplicacionXusuario(identificadorlogin.getIdentificador(), identificadorlogin.getEmail());
		TblUsuario identificador = new TblUsuario();
		identificador.setIdentificador(identificadorlogin.getIdentificador());
		if (identificadorlogin.getTipoUser().equals(Constantes.TIPO_REGISTRO_AUTORIDAD)) {
			
			  List<Object[]> listaAplicaciones1 =
			  as.obtenerRegistrosAplicacionesObjeto(14,"activo");
			  listaAplicaciones.addAll(listaAplicaciones1);
			 
			}
		model.addAttribute("aplicaciones", listaAplicaciones);
		return "plantillasIndex/aplicaciones";
	}
	public List<Object[]> obtenerAcciones(Integer  name,int idMenu){
	     
		List<Object[]> listaAcciones = auis.AccionesXmenu(name, idMenu);
		
		return listaAcciones;
	}
}
