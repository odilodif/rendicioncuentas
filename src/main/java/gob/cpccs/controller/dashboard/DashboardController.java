package gob.cpccs.controller.dashboard;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import gob.cpccs.model.catalogos.TblLocalizacion;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.model.usuario.TblUsuarioLocalizacion;
import gob.cpccs.service.GraficaService;

import gob.cpccs.service.autoridad.AutoridadServicio;
import gob.cpccs.service.catalogos.CatalogosServicio;
import gob.cpccs.service.catalogos.InstitucionServicio;
import gob.cpccs.service.tecnico.TecnicoServicio;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;
import gob.cpccs.utilidades.DateUtil;




@Controller
public class DashboardController {
	@Autowired
	private InstitucionServicio servicioinstitucion;
	@Autowired
	private GraficaService grafica;
	@Autowired
	private TecnicoServicio tecsv;
	@Autowired
	private AutoridadServicio autori;
	@Autowired
	private CatalogosServicio gcs;
	@Autowired
	private UsuarioServicio us;

	@RequestMapping("/view/tecnicoNacional/DashboardInstituciones")
    public String DashboardInstituciones(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		
		
		List<Integer> list = new ArrayList<Integer>();
		TblUsuario identificadorlogin = us.buscarUsuarioXEmail(authentication.getName(), Constantes.periodo());
		if (hasRole("ROLE_NACIONAL")) {
			model.addAttribute("rol", "Nacional");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_NACIONAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
			
			Integer cumplidasAtiempo = servicioinstitucion.conteoEstadosProcesoInformes(Constantes.periodo(), Constantes.ESTADO_INFORME_A_TIEMPO);
			model.addAttribute("cumplidasAtiempo", cumplidasAtiempo);
			Integer cumplidasAdestiempo = servicioinstitucion.conteoEstadosProcesoInformes(Constantes.periodo(), Constantes.ESTADO_INFORME_A_DESTIEMPO);
			model.addAttribute("cumplidasAdestiempo", cumplidasAdestiempo);
			Integer incumplidas = servicioinstitucion.conteoEstadosProcesoInstituciones(Constantes.periodo(), Constantes.ESTADO_PROCESO_INCUMPLIDO);
			model.addAttribute("incumplidas", incumplidas);
			
			Integer finalizadas = cumplidasAtiempo+cumplidasAdestiempo;
			model.addAttribute("finalizadas", finalizadas);
			String sactivas = servicioinstitucion.conteoInstitucionesActivas(Constantes.periodo(), Constantes.ESTADO).get(0).toString();
			
			String sactivastoInt = sactivas.toString();
			Integer activas = Integer.parseInt(sactivastoInt);
			model.addAttribute("activas", activas);
			
			Integer registradas = servicioinstitucion.conteoEstadosInstituciones(Constantes.periodo(), Constantes.ESTADO_REGISTRADO);
			model.addAttribute("registradas", registradas);
			Integer incactivas = servicioinstitucion.conteoEstadosInstituciones(Constantes.periodo(), Constantes. ESTADO_INACTIVO);
			model.addAttribute("incactivas", incactivas);
			Integer catastradas = servicioinstitucion.conteoCatastro(Constantes.periodo(),Constantes.ESTADO_ELIMINADO );
			model.addAttribute("catastro", catastradas);
			
			
			if(catastradas==0) {
				model.addAttribute("porcentajeAtiempo", "0");
				model.addAttribute("porcentajeAdestiempo", "0");
				model.addAttribute("porcentajeIncumplidas", "0");
				model.addAttribute("porcentajeFinalizadas", "0");
				model.addAttribute("porcentajeActivas", "0");
				model.addAttribute("porcentajeIncactivas", "0");
				model.addAttribute("porcentajeRegistradas", "0");
				Integer totalIncumplidas= incumplidas + incactivas + 0 +activas;
				model.addAttribute("totalIncumplidas", totalIncumplidas);
			}else {
				Integer porcentajeAtiempo =  (cumplidasAtiempo*100)/catastradas;
				model.addAttribute("porcentajeAtiempo", porcentajeAtiempo);
				Integer porcentajeAdestiempo =  (cumplidasAdestiempo*100)/catastradas;
				model.addAttribute("porcentajeAdestiempo", porcentajeAdestiempo);
				Integer porcentajeIncumplidas =  (incumplidas*100)/catastradas;
				model.addAttribute("porcentajeIncumplidas", porcentajeIncumplidas);
				Integer porcentajeFinalizadas =  (finalizadas*100)/catastradas;
				model.addAttribute("porcentajeFinalizadas", porcentajeFinalizadas);
				Integer porcentajeActivas =  (activas*100)/catastradas;
				model.addAttribute("porcentajeActivas", porcentajeActivas);
				Integer porcentajeIncactivas =  (incactivas*100)/catastradas;
				model.addAttribute("porcentajeIncactivas", porcentajeIncactivas);
				Integer porcentajeRegistradas =  (registradas*100)/catastradas;
				model.addAttribute("porcentajeRegistradas", porcentajeRegistradas);
				Integer totalIncumplidas= incumplidas + incactivas + porcentajeRegistradas+activas;
				model.addAttribute("totalIncumplidas", totalIncumplidas);
			}
			
			
			
		
			
			
		} else if (hasRole("ROLE_PROVINCIAL")) {
			model.addAttribute("rol", "Provincial");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_PROVINCIAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}
			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
			
			
			
			
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Administrador");
			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_ADMINISTRADOR);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");

			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
			Integer cumplidasAtiempo = servicioinstitucion.conteoEstadosProcesoInformes(Constantes.periodo(), Constantes.ESTADO_INFORME_A_TIEMPO);
			model.addAttribute("cumplidasAtiempo", cumplidasAtiempo);
			Integer cumplidasAdestiempo = servicioinstitucion.conteoEstadosProcesoInformes(Constantes.periodo(), Constantes.ESTADO_INFORME_A_DESTIEMPO);
			model.addAttribute("cumplidasAdestiempo", cumplidasAdestiempo);
			Integer incumplidas = servicioinstitucion.conteoEstadosProcesoInstituciones(Constantes.periodo(), Constantes.ESTADO_PROCESO_INCUMPLIDO);
			model.addAttribute("incumplidas", incumplidas);
			
			Integer finalizadas = cumplidasAtiempo+cumplidasAdestiempo;
			model.addAttribute("finalizadas", finalizadas);
			Integer activas = servicioinstitucion.conteoEstadosInstituciones(Constantes.periodo(), Constantes.ESTADO);
			model.addAttribute("activas", activas);
			Integer registradas = servicioinstitucion.conteoEstadosInstituciones(Constantes.periodo(), Constantes.ESTADO_REGISTRADO);
			model.addAttribute("registradas", registradas);
			Integer incactivas = servicioinstitucion.conteoEstadosInstituciones(Constantes.periodo(), Constantes. ESTADO_INACTIVO);
			model.addAttribute("incactivas", incactivas);
			Integer catastradas = servicioinstitucion.conteoCatastro(Constantes.periodo(),Constantes.ESTADO_ELIMINADO);
			
			if (catastradas==0) {
				
				model.addAttribute("porcentajeAtiempo", "0");
				model.addAttribute("porcentajeAdestiempo", "0");
				model.addAttribute("porcentajeIncumplidas", "0");
				model.addAttribute("porcentajeFinalizadas", "0");
				model.addAttribute("porcentajeActivas", "0");
				model.addAttribute("porcentajeIncactivas", "0");
				model.addAttribute("porcentajeRegistradas", "0");
				
			}else {
				
				Integer porcentajeAtiempo =  (cumplidasAtiempo*100)/catastradas;
			model.addAttribute("porcentajeAtiempo", porcentajeAtiempo);
			Integer porcentajeAdestiempo =  (cumplidasAdestiempo*100)/catastradas;
			model.addAttribute("porcentajeAdestiempo", porcentajeAdestiempo);
			Integer porcentajeIncumplidas =  (incumplidas*100)/catastradas;
			model.addAttribute("porcentajeIncumplidas", porcentajeIncumplidas);
			Integer porcentajeFinalizadas =  (finalizadas*100)/catastradas;
			model.addAttribute("porcentajeFinalizadas", porcentajeFinalizadas);
			Integer porcentajeActivas =  (activas*100)/catastradas;
			model.addAttribute("porcentajeActivas", porcentajeActivas);
			Integer porcentajeIncactivas =  (incactivas*100)/catastradas;
			model.addAttribute("porcentajeIncactivas", porcentajeIncactivas);
			Integer porcentajeRegistradas =  (registradas*100)/catastradas;
			model.addAttribute("porcentajeRegistradas", porcentajeRegistradas);}
			
			
		}

         return "tecnicoNacional/DashboardInstituciones";
    }

	@RequestMapping("/view/rendicion/DashboardInstitucionesS")
    public String DashboardInstitucionesS(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		
		
		List<Integer> list = new ArrayList<Integer>();
		TblUsuario identificadorlogin = us.buscarUsuarioXEmail(authentication.getName(), Constantes.periodo());
		if (hasRole("ROLE_NACIONAL")) {
			model.addAttribute("rol", "Nacional");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_NACIONAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
			
			Integer cumplidasAtiempo = servicioinstitucion.conteoEstadosProcesoInformes(Constantes.periodo(), Constantes.ESTADO_INFORME_A_TIEMPO);
			model.addAttribute("cumplidasAtiempo", cumplidasAtiempo);
			Integer cumplidasAdestiempo = servicioinstitucion.conteoEstadosProcesoInformes(Constantes.periodo(), Constantes.ESTADO_INFORME_A_DESTIEMPO);
			model.addAttribute("cumplidasAdestiempo", cumplidasAdestiempo);
			Integer incumplidas = servicioinstitucion.conteoEstadosProcesoInstituciones(Constantes.periodo(), Constantes.ESTADO_PROCESO_INCUMPLIDO);
			model.addAttribute("incumplidas", incumplidas);
			Integer finalizadas = cumplidasAtiempo+cumplidasAdestiempo;
			model.addAttribute("finalizadas", finalizadas);
			String sactivas = servicioinstitucion.conteoInstitucionesActivas(Constantes.periodo(), Constantes.ESTADO).get(0).toString();
			
			String sactivastoInt = sactivas.toString();
			Integer activas = Integer.parseInt(sactivastoInt);
			model.addAttribute("activas", activas);
			
			Integer registradas = servicioinstitucion.conteoEstadosInstituciones(Constantes.periodo(), Constantes.ESTADO_REGISTRADO);
			model.addAttribute("registradas", registradas);
			Integer incactivas = servicioinstitucion.conteoEstadosInstituciones(Constantes.periodo(), Constantes. ESTADO_INACTIVO);
			model.addAttribute("incactivas", incactivas);
			Integer catastradas = servicioinstitucion.conteoCatastro(Constantes.periodo(),Constantes.ESTADO_ELIMINADO );
			model.addAttribute("catastro", catastradas);
			
			
			if(catastradas==0) {
				model.addAttribute("porcentajeAtiempo", "0");
				model.addAttribute("porcentajeAdestiempo", "0");
				model.addAttribute("porcentajeIncumplidas", "0");
				model.addAttribute("porcentajeFinalizadas", "0");
				model.addAttribute("porcentajeActivas", "0");
				model.addAttribute("porcentajeIncactivas", "0");
				model.addAttribute("porcentajeRegistradas", "0");
				Integer totalIncumplidas= incumplidas + incactivas + 0 +activas;
				model.addAttribute("totalIncumplidas", totalIncumplidas);
			}else {
				Integer porcentajeAtiempo =  (cumplidasAtiempo*100)/catastradas;
				model.addAttribute("porcentajeAtiempo", porcentajeAtiempo);
				Integer porcentajeAdestiempo =  (cumplidasAdestiempo*100)/catastradas;
				model.addAttribute("porcentajeAdestiempo", porcentajeAdestiempo);
				Integer porcentajeIncumplidas =  (incumplidas*100)/catastradas;
				model.addAttribute("porcentajeIncumplidas", porcentajeIncumplidas);
				Integer porcentajeFinalizadas =  (finalizadas*100)/catastradas;
				model.addAttribute("porcentajeFinalizadas", porcentajeFinalizadas);
				Integer porcentajeActivas =  (activas*100)/catastradas;
				model.addAttribute("porcentajeActivas", porcentajeActivas);
				Integer porcentajeIncactivas =  (incactivas*100)/catastradas;
				model.addAttribute("porcentajeIncactivas", porcentajeIncactivas);
				Integer porcentajeRegistradas =  (registradas*100)/catastradas;
				model.addAttribute("porcentajeRegistradas", porcentajeRegistradas);
				Integer totalIncumplidas= incumplidas + incactivas + porcentajeRegistradas+activas;
				model.addAttribute("totalIncumplidas", totalIncumplidas);
			}
			
			
			
		
			
			
		} else if (hasRole("ROLE_PROVINCIAL")) {
			model.addAttribute("rol", "Provincial");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_PROVINCIAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}
			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
			
			
			
			
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Administrador");
			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_ADMINISTRADOR);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");

			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
			Integer cumplidasAtiempo = servicioinstitucion.conteoEstadosProcesoInformes(Constantes.periodo(), Constantes.ESTADO_INFORME_A_TIEMPO);
			model.addAttribute("cumplidasAtiempo", cumplidasAtiempo);
			Integer cumplidasAdestiempo = servicioinstitucion.conteoEstadosProcesoInformes(Constantes.periodo(), Constantes.ESTADO_INFORME_A_DESTIEMPO);
			model.addAttribute("cumplidasAdestiempo", cumplidasAdestiempo);
			Integer incumplidas = servicioinstitucion.conteoEstadosProcesoInstituciones(Constantes.periodo(), Constantes.ESTADO_PROCESO_INCUMPLIDO);
			model.addAttribute("incumplidas", incumplidas);
			
			Integer finalizadas = cumplidasAtiempo+cumplidasAdestiempo;
			model.addAttribute("finalizadas", finalizadas);
			Integer activas = servicioinstitucion.conteoEstadosInstituciones(Constantes.periodo(), Constantes.ESTADO);
			model.addAttribute("activas", activas);
			Integer registradas = servicioinstitucion.conteoEstadosInstituciones(Constantes.periodo(), Constantes.ESTADO_REGISTRADO);
			model.addAttribute("registradas", registradas);
			Integer incactivas = servicioinstitucion.conteoEstadosInstituciones(Constantes.periodo(), Constantes. ESTADO_INACTIVO);
			model.addAttribute("incactivas", incactivas);
			Integer catastradas = servicioinstitucion.conteoCatastro(Constantes.periodo(),Constantes.ESTADO_ELIMINADO);
			
			if (catastradas==0) {
				
				model.addAttribute("porcentajeAtiempo", "0");
				model.addAttribute("porcentajeAdestiempo", "0");
				model.addAttribute("porcentajeIncumplidas", "0");
				model.addAttribute("porcentajeFinalizadas", "0");
				model.addAttribute("porcentajeActivas", "0");
				model.addAttribute("porcentajeIncactivas", "0");
				model.addAttribute("porcentajeRegistradas", "0");
				
			}else {
				
				Integer porcentajeAtiempo =  (cumplidasAtiempo*100)/catastradas;
			model.addAttribute("porcentajeAtiempo", porcentajeAtiempo);
			Integer porcentajeAdestiempo =  (cumplidasAdestiempo*100)/catastradas;
			model.addAttribute("porcentajeAdestiempo", porcentajeAdestiempo);
			Integer porcentajeIncumplidas =  (incumplidas*100)/catastradas;
			model.addAttribute("porcentajeIncumplidas", porcentajeIncumplidas);
			Integer porcentajeFinalizadas =  (finalizadas*100)/catastradas;
			model.addAttribute("porcentajeFinalizadas", porcentajeFinalizadas);
			Integer porcentajeActivas =  (activas*100)/catastradas;
			model.addAttribute("porcentajeActivas", porcentajeActivas);
			Integer porcentajeIncactivas =  (incactivas*100)/catastradas;
			model.addAttribute("porcentajeIncactivas", porcentajeIncactivas);
			Integer porcentajeRegistradas =  (registradas*100)/catastradas;
			model.addAttribute("porcentajeRegistradas", porcentajeRegistradas);}
			
			
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Administrador");
			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_ADMINISTRADOR);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");

			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
			Integer cumplidasAtiempo = servicioinstitucion.conteoEstadosProcesoInformes(Constantes.periodo(), Constantes.ESTADO_INFORME_A_TIEMPO);
			model.addAttribute("cumplidasAtiempo", cumplidasAtiempo);
			Integer cumplidasAdestiempo = servicioinstitucion.conteoEstadosProcesoInformes(Constantes.periodo(), Constantes.ESTADO_INFORME_A_DESTIEMPO);
			model.addAttribute("cumplidasAdestiempo", cumplidasAdestiempo);
			Integer incumplidas = servicioinstitucion.conteoEstadosProcesoInstituciones(Constantes.periodo(), Constantes.ESTADO_PROCESO_INCUMPLIDO);
			model.addAttribute("incumplidas", incumplidas);
			
			Integer finalizadas = cumplidasAtiempo+cumplidasAdestiempo;
			model.addAttribute("finalizadas", finalizadas);
			Integer activas = servicioinstitucion.conteoEstadosInstituciones(Constantes.periodo(), Constantes.ESTADO);
			model.addAttribute("activas", activas);
			Integer registradas = servicioinstitucion.conteoEstadosInstituciones(Constantes.periodo(), Constantes.ESTADO_REGISTRADO);
			model.addAttribute("registradas", registradas);
			Integer incactivas = servicioinstitucion.conteoEstadosInstituciones(Constantes.periodo(), Constantes. ESTADO_INACTIVO);
			model.addAttribute("incactivas", incactivas);
			Integer catastradas = servicioinstitucion.conteoCatastro(Constantes.periodo(),Constantes.ESTADO_ELIMINADO);
			
			if (catastradas==0) {
				
				model.addAttribute("porcentajeAtiempo", "0");
				model.addAttribute("porcentajeAdestiempo", "0");
				model.addAttribute("porcentajeIncumplidas", "0");
				model.addAttribute("porcentajeFinalizadas", "0");
				model.addAttribute("porcentajeActivas", "0");
				model.addAttribute("porcentajeIncactivas", "0");
				model.addAttribute("porcentajeRegistradas", "0");
				
			}else {
				
				Integer porcentajeAtiempo =  (cumplidasAtiempo*100)/catastradas;
			model.addAttribute("porcentajeAtiempo", porcentajeAtiempo);
			Integer porcentajeAdestiempo =  (cumplidasAdestiempo*100)/catastradas;
			model.addAttribute("porcentajeAdestiempo", porcentajeAdestiempo);
			Integer porcentajeIncumplidas =  (incumplidas*100)/catastradas;
			model.addAttribute("porcentajeIncumplidas", porcentajeIncumplidas);
			Integer porcentajeFinalizadas =  (finalizadas*100)/catastradas;
			model.addAttribute("porcentajeFinalizadas", porcentajeFinalizadas);
			Integer porcentajeActivas =  (activas*100)/catastradas;
			model.addAttribute("porcentajeActivas", porcentajeActivas);
			Integer porcentajeIncactivas =  (incactivas*100)/catastradas;
			model.addAttribute("porcentajeIncactivas", porcentajeIncactivas);
			Integer porcentajeRegistradas =  (registradas*100)/catastradas;
			model.addAttribute("porcentajeRegistradas", porcentajeRegistradas);}
			
			
		}

         return "rendicion/DashboardInstitucionesS";
    }
	@RequestMapping("/view/tecnicoNacional/DashboardInstitucionesProvincia")
    public String DashboardInstitucionesProvincia(Model model, Authentication authentication, @Param(value = "provincia") Integer provincia) {	
		
		
		
			String cumplidasAtiempo = servicioinstitucion.conteoEstadosProcesoInformesXprovincia(Constantes.periodo(), Constantes.ESTADO_INFORME_A_TIEMPO, provincia).get(0).toString();
			model.addAttribute("cumplidasAtiempo", cumplidasAtiempo);
			
			String cumplidasAdestiempo = servicioinstitucion.conteoEstadosProcesoInformesXprovincia(Constantes.periodo(), Constantes.ESTADO_INFORME_A_DESTIEMPO, provincia).get(0).toString();
			model.addAttribute("cumplidasAdestiempo", cumplidasAdestiempo);
			
			String incumplidas = servicioinstitucion.conteoEstadosProcesoInformesXprovincia(Constantes.periodo(), Constantes.ESTADO_PROCESO_INCUMPLIDO, provincia).get(0).toString();
			model.addAttribute("incumplidas", incumplidas);
			
		
			String ScumplidasAtiempo = cumplidasAtiempo.toString();
			Integer scat = Integer.parseInt(ScumplidasAtiempo);
			String ScumplidasAdestiempo = cumplidasAdestiempo.toString();
			Integer scad = Integer.parseInt(ScumplidasAdestiempo);
			String sincumplidas = incumplidas.toString();
			Integer sin = Integer.parseInt(sincumplidas);
			
			Integer finalizadas = scat  + scad;
			model.addAttribute("finalizadas", finalizadas);
			Integer activas = servicioinstitucion.conteoEstadosInstitucionesxprovincia(Constantes.periodo(), Constantes.ESTADO, provincia);
			model.addAttribute("activas", activas);
			Integer registradas = servicioinstitucion.conteoEstadosInstitucionesxprovincia(Constantes.periodo(), Constantes.ESTADO_REGISTRADO, provincia);
			model.addAttribute("registradas", registradas);
			Integer incactivas = servicioinstitucion.conteoEstadosInstitucionesxprovincia(Constantes.periodo(), Constantes. ESTADO_INACTIVO, provincia);
			model.addAttribute("incactivas", incactivas);
			Integer catastradas = servicioinstitucion.conteoCatastroxprovincia(Constantes.periodo(), provincia);
			model.addAttribute("catastro", catastradas);
			
			Integer porcentajeAtiempo =  (scat*100)/catastradas;
			model.addAttribute("porcentajeAtiempo", porcentajeAtiempo);
			Integer porcentajeAdestiempo =  (scad)*100/catastradas;
			model.addAttribute("porcentajeAdestiempo", porcentajeAdestiempo);
			Integer porcentajeIncumplidas =  (sin*100)/catastradas;
			model.addAttribute("porcentajeIncumplidas", porcentajeIncumplidas);
			Integer porcentajeFinalizadas =  (finalizadas*100)/catastradas;
			model.addAttribute("porcentajeFinalizadas", porcentajeFinalizadas);
			Integer porcentajeActivas =  (activas*100)/catastradas;
			model.addAttribute("porcentajeActivas", porcentajeActivas);
			Integer porcentajeIncactivas =  (incactivas*100)/catastradas;
			model.addAttribute("porcentajeIncactivas", porcentajeIncactivas);
			Integer porcentajeRegistradas =  (registradas*100)/catastradas;
			model.addAttribute("porcentajeRegistradas", porcentajeRegistradas);
			model.addAttribute("provincia", provincia);
			
         return "tecnicoNacional/DashboardInstitucionesProvincia";
    }
	
	private boolean hasRole(String role) {

		SecurityContext context = SecurityContextHolder.getContext();

		if (context == null) {
			return false;
		}

		Authentication auth = context.getAuthentication();

		if (auth == null) {
			return false;
		}

		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

		return authorities.contains(new SimpleGrantedAuthority(role));

	}
	
	@RequestMapping(value = {"/GraficaPrueba"}, method = RequestMethod.POST)
    @ResponseBody
    public String Graficaorientacionjuridica(Authentication authentication) {
         String json;
         try{
        	 int diasTrascurridos = 0;
              StringBuilder resultado = new StringBuilder();
              DateUtil dateUtil = new DateUtil();
              SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
              String fechaActual = formatter.format(new Date());
              String fechaIND = Constantes.FECHA_INICIO_PROCESO;
              Date dateStart = formatter.parse(fechaIND);
              Date dateEnd = formatter.parse(fechaActual);
              diasTrascurridos = dateUtil.obtenerDiasConFinSemana(dateStart, dateEnd);
              for (int i = 0; i <=diasTrascurridos; i++) {
            	  String fecha=dateUtil.sumarRestarDiasFecha(fechaIND,i);
            	    List<Object[]> listaRegistros = grafica.ReporteGraficaprueba(fecha);
            	    if (listaRegistros.size() > 0){
            	    for (Object[] datos : listaRegistros){
                        
                        resultado.append("{\"fecha\":\"" +fecha+ "\",\""
                   + "registrado\":\"" + datos[0] + "\",\""
                        + "activo\":\"" +datos[1] 
                             + "\"}").append(",");

                   } 
            	    }else {}
            	   
			}
              
                   json = "[" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]";
            
         } catch (Exception e){
              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

         }
         return json; 
    }

	
	@RequestMapping(value = {"/GraficaInformeFinalizadoInstitucionXEstado"}, method = RequestMethod.POST)
    @ResponseBody
    public String GraficaInformeFinalizadoInstitucionXEstado(Authentication authentication) {
         String json;
         try{
        	 int diasTrascurridos = 0;
              StringBuilder resultado = new StringBuilder();
              DateUtil dateUtil = new DateUtil();
              SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
              String fechaActual = formatter.format(new Date());
              //String fechaIND = "2021/05/17";
              String fechaIND = Constantes.FECHA_INICIO_PROCESO;
              Date dateStart = formatter.parse(fechaIND);
              Date dateEnd = formatter.parse(fechaActual);
              diasTrascurridos = dateUtil.obtenerDiasConFinSemana(dateStart, dateEnd);
              for (int i = 0; i <=diasTrascurridos; i++) {
            	  String fecha=dateUtil.sumarRestarDiasFecha(fechaIND,i);
            	    List<Object[]> listaRegistros = grafica.ReporteGraficaInformeFinalizado(fecha);
            	    if (listaRegistros.size() > 0){
            	    for (Object[] datos : listaRegistros){
                        
                        resultado.append("{\"fecha\":\"" +fecha+ "\",\""
                   + "cumplido\":\"" + datos[0] + "\",\""
                        + "incumplido\":\"" +datos[1] 
                             + "\"}").append(",");

                   } 
            	    }else {}
            	   
			}
              
                   json = "[" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]";
            
         } catch (Exception e){
              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

         }
         return json; 
    }

	
	@RequestMapping(value = {"/GraficaInformeFinalizadoAutoridadXEstado"}, method = RequestMethod.POST)
    @ResponseBody
    public String GraficaInformeFinalizadoAutoridadXEstado(Authentication authentication) {
         String json;
         try{
        	 int diasTrascurridos = 0;
              StringBuilder resultado = new StringBuilder();
              DateUtil dateUtil = new DateUtil();
              SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
              String fechaActual = formatter.format(new Date());
              //String fechaIND = "2021/05/17";
              String fechaIND = Constantes.FECHA_INICIO_PROCESO;
              Date dateStart = formatter.parse(fechaIND);
              Date dateEnd = formatter.parse(fechaActual);
              diasTrascurridos = dateUtil.obtenerDiasConFinSemana(dateStart, dateEnd);
              for (int i = 0; i <=diasTrascurridos; i++) {
            	  String fecha=dateUtil.sumarRestarDiasFecha(fechaIND,i);
            	    List<Object[]> listaRegistros = grafica.ReporteGraficaInformeFinalizadoAutoridad(fecha);
            	    if (listaRegistros.size() > 0){
            	    for (Object[] datos : listaRegistros){
                        
                        resultado.append("{\"fecha\":\"" +fecha+ "\",\""
                   + "cumplido\":\"" + datos[0] + "\",\""
                        + "incumplido\":\"" +datos[1] 
                             + "\"}").append(",");

                   } 
            	    }else {}
            	   
			}
              
                   json = "[" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]";
            
         } catch (Exception e){
              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

         }
         return json; 
    }
	
	@RequestMapping(value = {"/GraficaAutoridadRegistroActivacion"}, method = RequestMethod.POST)
    @ResponseBody
    public String GraficaAutoridadRegistroActivacion(Authentication authentication) {
         String json;
         try{
        	 int diasTrascurridos = 0;
              StringBuilder resultado = new StringBuilder();
              DateUtil dateUtil = new DateUtil();
              SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
              String fechaActual = formatter.format(new Date());
              String fechaIND = Constantes.FECHA_INICIO_PROCESO;
              Date dateStart = formatter.parse(fechaIND);
              Date dateEnd = formatter.parse(fechaActual);
              diasTrascurridos = dateUtil.obtenerDiasConFinSemana(dateStart, dateEnd);
              for (int i = 0; i <=diasTrascurridos; i++) {
            	  String fecha=dateUtil.sumarRestarDiasFecha(fechaIND,i);
            	    List<Object[]> listaRegistros = grafica.ReporteGraficaAutoridadRegistroActivacion(fecha);
            	    if (listaRegistros.size() > 0){
            	    for (Object[] datos : listaRegistros){
                        
                        resultado.append("{\"fecha\":\"" +fecha+ "\",\""
                   + "registrado\":\"" + datos[0] + "\",\""
                        + "activo\":\"" +datos[1] 
                             + "\"}").append(",");

                   } 
            	    }else {}
            	   
			}
              
                   json = "[" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]";
            
         } catch (Exception e){
              json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

         }
         return json; 
    }
	
	@RequestMapping(value = { "/obtenerIntitucionesDatosResponsables" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerIntitucionesDatosResponsables(Authentication authentication,
			@RequestParam("estado") String estado) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
			String campoFecha ="";
			if(estado.equals("registrado")) {
				campoFecha= "ins.inst_fecha_registro";
			}else if(estado.equals("activo")){
				campoFecha= "ins.inst_fecha_activar";
			}
			List<Object[]> listaRegistros = gcs.obtenerIntitucionesDatosResponsables(estado, Constantes.periodo(),campoFecha);


			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[5] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[5]);
					}

					resultado.append("{\"inst_cod\":\"" + datos[0] + "\",\"" 
					+ "contador\":\"" + (listaRegistros.indexOf(datos) + 1) + "\",\"" 
					+ "ruc\":\"" + (datos[2] == null ? "" : datos[2]) + "\",\"" 
					+ "provincia\":\"" + datos[3]
					+ "\",\"" + "nombre\":\"" + datos[1].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3) + "\",\"" 
					+ "estado\":\"" + datos[6].toString().toUpperCase() + "\",\"" 
					+ "funcion\":\"" + datos[4]	+ "\",\"" 
							+ "fecha\":\"" + fechaSolicitud + "\",\""
									+ "NombreRepresentante\":\"" + datos[7].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "EmailRepresentante\":\""		+ datos[8].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "TelenofnoRepresentante\":\""+ datos[9].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "NombreResponsable\":\""+ datos[10].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "EmailResponsable\":\""+ datos[11].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "TelenofnoResponsable\":\""+ datos[12].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "NombreRegistro\":\""+ datos[13].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "EmailRegistro\":\""+ datos[14].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "TelenofnoRegistro\":\""+ datos[15].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
							
							+ "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}
	
	
	@RequestMapping(value = { "/obtenerIntitucionesActivasDatosResponsables" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerIntitucionesActivasDatosResponsables(Authentication authentication,
			@RequestParam("estado") String estado) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
			String campoFecha ="";
			if(estado.equals("registrado")) {
				campoFecha= "ins.inst_fecha_registro";
			}else if(estado.equals("activo")){
				campoFecha= "ins.inst_fecha_activar";
			}
			List<Object[]> listaRegistros = gcs.obtenerIntitucionesActivasDatosResponsables(estado, Constantes.periodo(),campoFecha);


			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[5] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[5]);
					}

					resultado.append("{\"inst_cod\":\"" + datos[0] + "\",\"" 
					+ "contador\":\"" + (listaRegistros.indexOf(datos) + 1) + "\",\"" 
					+ "ruc\":\"" + (datos[2] == null ? "" : datos[2]) + "\",\"" 
					+ "provincia\":\"" + datos[3]
					+ "\",\"" + "nombre\":\"" + datos[1].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3) + "\",\"" 
					+ "estado\":\"" + datos[6].toString().toUpperCase() + "\",\"" 
					+ "funcion\":\"" + datos[4]	+ "\",\"" 
							+ "fecha\":\"" + fechaSolicitud + "\",\""
									+ "NombreRepresentante\":\"" + datos[7].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "EmailRepresentante\":\""		+ datos[8].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "TelenofnoRepresentante\":\""+ datos[9].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "NombreResponsable\":\""+ datos[10].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "EmailResponsable\":\""+ datos[11].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "TelenofnoResponsable\":\""+ datos[12].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "NombreRegistro\":\""+ datos[13].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "EmailRegistro\":\""+ datos[14].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "TelenofnoRegistro\":\""+ datos[15].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
							
							+ "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}
	
	
	@RequestMapping(value = { "/obtenerIntitucionesxCumplimiento" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerIntitucionesxCumplimiento(Authentication authentication,
			@RequestParam("estado") String infVerificador) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
		
			List<Object[]> listaRegistros = gcs.obtenerIntitucionesxCumplimiento( infVerificador, Constantes.periodo() );


			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[8] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[8]);
					}

					resultado.append("{\"inst_cod\":\"" + datos[0] + "\",\"" 
					+ "contador\":\"" + (listaRegistros.indexOf(datos) + 1) + "\",\"" 
					+ "ruc\":\"" + (datos[1] == null ? "" : datos[1]) + "\",\"" 
					+ "nombre\":\"" + datos[2].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3) + "\",\""
					+ "funcion\":\"" + datos[3]+ "\",\""
					+ "descripcion\":\"" + datos[4]+ "\",\""
					+ "provincia\":\"" + datos[5]+ "\",\"" 
					+ "numeroInforme\":\"" + datos[6]+ "\",\""
					+ "formulario\":\"" + datos[7]+ "\",\""
					+ "fecha\":\"" + fechaSolicitud + "\",\""
					+  "cumplimiento\":\"" + datos[9]	+ "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}
	
	
	@RequestMapping(value = { "/obtenerIntitucionesxCumplimientoProvincia" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerIntitucionesxCumplimientoProvincia(Authentication authentication,
			@RequestParam("estado") String infVerificador , @Param(value = "provincia") Integer provincia) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
		
			List<Object[]> listaRegistros = gcs.obtenerIntitucionesxCumplimientoProvincia( infVerificador, Constantes.periodo(), provincia );


			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[8] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[8]);
					}

					resultado.append("{\"inst_cod\":\"" + datos[0] + "\",\"" 
					+ "contador\":\"" + (listaRegistros.indexOf(datos) + 1) + "\",\"" 
					+ "ruc\":\"" + (datos[1] == null ? "" : datos[1]) + "\",\"" 
					+ "nombre\":\"" + datos[2].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3) + "\",\""
					+ "funcion\":\"" + datos[3]+ "\",\""
					+ "descripcion\":\"" + datos[4]+ "\",\""
					+ "provincia\":\"" + datos[5]+ "\",\"" 
					+ "numeroInforme\":\"" + datos[6]+ "\",\""
					+ "formulario\":\"" + datos[7]+ "\",\""
					+ "fecha\":\"" + fechaSolicitud + "\",\""
					+  "cumplimiento\":\"" + datos[9]	+ "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}
	
	@RequestMapping(value = { "/obtenerIntitucionesxIncumplidasProvincia" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerIntitucionesxIncumplidasProvincia(Authentication authentication,
			@RequestParam("estado") String infVerificador , @Param(value = "provincia") Integer provincia) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
		
			List<Object[]> listaRegistros = gcs.obtenerIntitucionesIncumplidasProvincia( infVerificador, Constantes.periodo(), provincia );


			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[8] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[8]);
					}

					resultado.append("{\"inst_cod\":\"" + datos[0] + "\",\"" 
					+ "contador\":\"" + (listaRegistros.indexOf(datos) + 1) + "\",\"" 
					+ "ruc\":\"" + (datos[1] == null ? "" : datos[1]) + "\",\"" 
					+ "nombre\":\"" + datos[2].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3) + "\",\""
					+ "funcion\":\"" + datos[3]+ "\",\""
					+ "descripcion\":\"" + datos[4]+ "\",\""
					+ "provincia\":\"" + datos[5]+ "\",\"" 
					+ "numeroInforme\":\"" + datos[6]+ "\",\""
					+ "formulario\":\"" + datos[7]+ "\",\""
					+ "fecha\":\"" + fechaSolicitud + "\",\""
					+  "cumplimiento\":\"" + datos[9]	+ "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}
	
	
	@RequestMapping(value = { "/obtenerIntitucionesxIncumplidas" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerIntitucionesxIncumplidas(Authentication authentication,
			@RequestParam("estado") String infVerificador) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
		
			List<Object[]> listaRegistros = gcs.obtenerIntitucionesIncumplidas( infVerificador, Constantes.periodo() );


			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[8] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[8]);
					}

					resultado.append("{\"inst_cod\":\"" + datos[0] + "\",\"" 
					+ "contador\":\"" + (listaRegistros.indexOf(datos) + 1) + "\",\"" 
					+ "ruc\":\"" + (datos[1] == null ? "" : datos[1]) + "\",\"" 
					+ "nombre\":\"" + datos[2].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3) + "\",\""
					+ "funcion\":\"" + datos[3]+ "\",\""
					+ "descripcion\":\"" + datos[4]+ "\",\""
					+ "provincia\":\"" + datos[5]+ "\",\"" 
					+ "numeroInforme\":\"" + datos[6]+ "\",\""
					+ "formulario\":\"" + datos[7]+ "\",\""
					+ "fecha\":\"" + fechaSolicitud + "\",\""
					+  "cumplimiento\":\"" + datos[9]	+ "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}
	
	
	@RequestMapping(value = { "/obtenerIntitucionesDatosResponsablesxprovincia" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerIntitucionesDatosResponsablesxprovincia(Authentication authentication,
			@RequestParam("estado") String estado,  @RequestParam( "provincia") Integer provincia) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
			String campoFecha ="";
			if(estado.equals("registrado")) {
				campoFecha= "ins.inst_fecha_registro";
			}else if(estado.equals("activo")){
				campoFecha= "ins.inst_fecha_activar";
			}
			List<Object[]> listaRegistros = gcs.obtenerIntitucionesDatosResponsablesxP(estado, Constantes.periodo(),campoFecha,  provincia);


			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[5] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[5]);
					}

					resultado.append("{\"inst_cod\":\"" + datos[0] + "\",\"" 
					+ "contador\":\"" + (listaRegistros.indexOf(datos) + 1) + "\",\"" 
					+ "ruc\":\"" + (datos[2] == null ? "" : datos[2]) + "\",\"" 
					+ "provincia\":\"" + datos[3]
					+ "\",\"" + "nombre\":\"" + datos[1].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3) + "\",\"" 
					+ "estado\":\"" + datos[6].toString().toUpperCase() + "\",\"" 
					+ "funcion\":\"" + datos[4]	+ "\",\"" 
							+ "fecha\":\"" + fechaSolicitud + "\",\""
									+ "NombreRepresentante\":\"" + datos[7].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "EmailRepresentante\":\""		+ datos[8].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "TelenofnoRepresentante\":\""+ datos[9].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "NombreResponsable\":\""+ datos[10].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "EmailResponsable\":\""+ datos[11].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "TelenofnoResponsable\":\""+ datos[12].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "NombreRegistro\":\""+ datos[13].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "EmailRegistro\":\""+ datos[14].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
									+ "TelenofnoRegistro\":\""+ datos[15].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1)
									.replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2)
									.replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)
							
							+ "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}
	
	
	@RequestMapping(value = { "/obtenerAutoridadesDatosResponsables" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerAutoridadesDatosResponsables(Authentication authentication,
			@RequestParam("estado") String estado) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
			List<Object[]> listaRegistros = autori.buscarAutoridadDatosContactoXEstadoPeriodo(estado, Constantes.periodo());

			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[6] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[6]);
					}

					resultado.append("{\"aut_codigo\":\"" + datos[0] + "\",\"" + "contador\":\""
							+ (listaRegistros.indexOf(datos) + 1) + "\",\"" 
							+ "nombre\":\""	+ datos[1].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
							+ "ruc\":\"" + (datos[2] == null ? "" : datos[2]) + "\",\"" 
							+ "provincia\":\"" + datos[4] + "\",\""
							+ "funcion\":\"" + datos[3].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
							+ "fecha\":\"" + fechaSolicitud + "\",\""
							+ "estado\":\"" + datos[5] + "\",\""
							+ "email\":\"" + datos[7].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3) + "\",\""
							+ "celular\":\"" + datos[8].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3) + "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}
	
	@RequestMapping(value = { "/obtenerAutoridadesCumplimiento" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerAutoridadesCumplimiento(Authentication authentication,
			@RequestParam("estado") String autVerificador) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
			List<Object[]> listaRegistros = autori.buscarAutoridadCumplimiento(autVerificador, Constantes.periodo());

			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[6] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[7]);
					}

					resultado.append("{\"aut_codigo\":\"" + datos[0] + "\",\"" 
							+ "contador\":\"" + (listaRegistros.indexOf(datos) + 1) + "\",\"" 
							+ "cedula\":\"" + (datos[1] == null ? "" : datos[1]) + "\",\"" 
							+ "nombre\":\""	+ datos[2].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
							+ "dignidad\":\"" + datos[3].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
							+ "institucion\":\"" + datos[4].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\""
							+ "provincia\":\"" + datos[5] + "\",\""
							+ "numeroInforme\":\"" + datos[6] + "\",\""
							+ "fecha\":\"" + fechaSolicitud + "\",\""
							+ "cumplimiento\":\"" + datos[8] + "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}
	
	
	@RequestMapping(value = { "/obtenerAutoridadesInCumplimiento" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerAutoridadesInCumplimiento(Authentication authentication,
			@RequestParam("estado") String autVerificador) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
			List<Object[]> listaRegistros = autori.buscarAutoridadInCumplimiento(autVerificador, Constantes.periodo());

			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[6] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[7]);
					}

					resultado.append("{\"aut_codigo\":\"" + datos[0] + "\",\"" 
							+ "contador\":\"" + (listaRegistros.indexOf(datos) + 1) + "\",\"" 
							+ "cedula\":\"" + (datos[1] == null ? "" : datos[1]) + "\",\"" 
							+ "nombre\":\""	+ datos[2].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
							+ "dignidad\":\"" + datos[3].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
							+ "institucion\":\"" + datos[4].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\""
							+ "provincia\":\"" + datos[5] + "\",\""
							+ "numeroInforme\":\"" + datos[6] + "\",\""
							+ "fecha\":\"" + fechaSolicitud + "\",\""
							+ "cumplimiento\":\"" + datos[8] + "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}
	
	
	@RequestMapping(value = { "/obtenerAutoridadesCumplimientoProvincia" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerAutoridadesCumplimientoProvincia(Authentication authentication,
			@RequestParam("estado") String autVerificador,  @RequestParam( "provincia") Integer provincia) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
			List<Object[]> listaRegistros = autori.buscarAutoridadCumplimientoProvincia(autVerificador, Constantes.periodo(), provincia);

			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[6] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[7]);
					}

					resultado.append("{\"aut_codigo\":\"" + datos[0] + "\",\"" 
							+ "contador\":\"" + (listaRegistros.indexOf(datos) + 1) + "\",\"" 
							+ "cedula\":\"" + (datos[1] == null ? "" : datos[1]) + "\",\"" 
							+ "nombre\":\""	+ datos[2].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
							+ "dignidad\":\"" + datos[3].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
							+ "institucion\":\"" + datos[4].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\""
							+ "provincia\":\"" + datos[5] + "\",\""
							+ "numeroInforme\":\"" + datos[6] + "\",\""
							+ "fecha\":\"" + fechaSolicitud + "\",\""
							+ "cumplimiento\":\"" + datos[8] + "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}
	
	
	@RequestMapping(value = { "/obtenerAutoridadesInCumplimientoProvincia" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerAutoridadesInCumplimientoProvinciao(Authentication authentication,
			@RequestParam("estado") String autVerificador,  @RequestParam( "provincia") Integer provincia) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
			List<Object[]> listaRegistros = autori.buscarAutoridadInCumplimientoProvincia(autVerificador, Constantes.periodo(), provincia);

			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[6] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[7]);
					}

					resultado.append("{\"aut_codigo\":\"" + datos[0] + "\",\"" 
							+ "contador\":\"" + (listaRegistros.indexOf(datos) + 1) + "\",\"" 
							+ "cedula\":\"" + (datos[1] == null ? "" : datos[1]) + "\",\"" 
							+ "nombre\":\""	+ datos[2].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
							+ "dignidad\":\"" + datos[3].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
							+ "institucion\":\"" + datos[4].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\""
							+ "provincia\":\"" + datos[5] + "\",\""
							+ "numeroInforme\":\"" + datos[6] + "\",\""
							+ "fecha\":\"" + fechaSolicitud + "\",\""
							+ "cumplimiento\":\"" + datos[8] + "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}
	
	
	@RequestMapping(value = { "/obtenerAutoridadesDatosResponsablesProvincia" }, method = RequestMethod.POST)
	@ResponseBody
	public String obtenerAutoridadesDatosResponsablesProvincia(Authentication authentication,
			@RequestParam("estado") String estado, @RequestParam("provincia") Integer provincia) {
		String json;
		try {
			StringBuilder resultado = new StringBuilder();
			List<Object[]> listaRegistros = autori.buscarAutoridadDatosContactoXEstadoPeriodo(estado, Constantes.periodo(), provincia);

			if (listaRegistros.size() > 0) {
				for (Object[] datos : listaRegistros) {
					String fechaSolicitud = "";

					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (datos[6] == null) {
						fechaSolicitud = "";
					} else {
						fechaSolicitud = df.format(datos[6]);
					}

					resultado.append("{\"aut_codigo\":\"" + datos[0] + "\",\"" + "contador\":\""
							+ (listaRegistros.indexOf(datos) + 1) + "\",\"" 
							+ "nombre\":\""	+ datos[1].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
							+ "ruc\":\"" + (datos[2] == null ? "" : datos[2]) + "\",\"" 
							+ "provincia\":\"" + datos[4] + "\",\""
							+ "funcion\":\"" + datos[3].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3)+ "\",\"" 
							+ "fecha\":\"" + fechaSolicitud + "\",\""
							+ "estado\":\"" + datos[5] + "\",\""
							+ "email\":\"" + datos[7].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3) + "\",\""
							+ "celular\":\"" + datos[8].toString().replaceAll(Constantes.CADENA1, Constantes.REMPLAZO1).replaceAll(Constantes.CADENA2, Constantes.REMPLAZO2).replaceAll(Constantes.CADENA3, Constantes.REMPLAZO3) + "\"}").append(",");

				}

				json = "{\"data\": [" + resultado.toString().substring(0, resultado.toString().length() - 1) + "]}";
			} else {
				json = "{\"data\": []}";
			}

		} catch (Exception e) {
			json = "{\"error\" : \"true\", \"message\": " + "ERROR:--> " + e.getMessage() + "}";

		}

		return json;
	}
	
	@RequestMapping("/view/tecnicoNacional/DashboardAutoridades")
    public String DashboardAutoridades(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		
		List<Integer> list = new ArrayList<Integer>();
		TblUsuario identificadorlogin = us.buscarUsuarioXEmail(authentication.getName(), Constantes.periodo());
		if (hasRole("ROLE_NACIONAL")) {
			model.addAttribute("rol", "Nacional");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_NACIONAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		Integer cumplidasAtiempo = autori.conteoEstadosProcesoInformesAutoridades(Constantes.periodo(), Constantes.ESTADO_INFORME_A_TIEMPO);
		model.addAttribute("cumplidasAtiempo", cumplidasAtiempo);
		Integer cumplidasAdestiempo = autori.conteoEstadosProcesoInformesAutoridades(Constantes.periodo(), Constantes.ESTADO_INFORME_A_DESTIEMPO);
		model.addAttribute("cumplidasAdestiempo", cumplidasAdestiempo);
		Integer incumplidas = autori.conteoEstadosProcesoAutoridades(Constantes.periodo(), Constantes.ESTADO_PROCESO_INCUMPLIDO);
		model.addAttribute("incumplidas", incumplidas);
		
		Integer finalizadas = cumplidasAtiempo+cumplidasAdestiempo;
		model.addAttribute("finalizadas", finalizadas);
		Integer activas = autori.conteoEstadosAutoridades(Constantes.periodo(), Constantes.ESTADO);
		model.addAttribute("activas", activas);
		Integer registradas = autori.conteoEstadosAutoridades(Constantes.periodo(), Constantes.ESTADO_REGISTRADO);
		model.addAttribute("registradas", registradas);
		
		
		Integer catastradas = autori.conteoCatastroAutoridades(Constantes.periodo());
		model.addAttribute("catastradas", catastradas);

		if (catastradas==0) {
			Integer porcentajeAtiempo = 0;
			model.addAttribute("porcentajeAtiempo", porcentajeAtiempo);
			Integer porcentajeAdestiempo =   0;
			model.addAttribute("porcentajeAdestiempo", porcentajeAdestiempo);
			Integer porcentajeIncumplidas =   0;
			model.addAttribute("porcentajeIncumplidas", porcentajeIncumplidas);
			Integer porcentajeFinalizadas =   0;
			model.addAttribute("porcentajeFinalizadas", porcentajeFinalizadas);
			Integer porcentajeActivas =  0;
			model.addAttribute("porcentajeActivas", porcentajeActivas);
			Integer porcentajeIncactivas =  0;
			model.addAttribute("porcentajeIncactivas", porcentajeIncactivas);
			Integer porcentajeRegistradas =  0;
			model.addAttribute("porcentajeRegistradas", porcentajeRegistradas);
		}else {
			Integer porcentajeAtiempo =  (cumplidasAtiempo*100)/catastradas;
			model.addAttribute("porcentajeAtiempo", porcentajeAtiempo);
			Integer porcentajeAdestiempo =  (cumplidasAdestiempo*100)/catastradas;
			model.addAttribute("porcentajeAdestiempo", porcentajeAdestiempo);
			Integer porcentajeIncumplidas =  (incumplidas*100)/catastradas;
			model.addAttribute("porcentajeIncumplidas", porcentajeIncumplidas);
			Integer porcentajeFinalizadas =  (finalizadas*100)/catastradas;
			model.addAttribute("porcentajeFinalizadas", porcentajeFinalizadas);
			Integer porcentajeActivas =  (activas*100)/catastradas;
			model.addAttribute("porcentajeActivas", porcentajeActivas);
			Integer porcentajeIncactivas = 100;
			model.addAttribute("porcentajeIncactivas", porcentajeIncactivas);
			Integer porcentajeRegistradas =  (registradas*100)/catastradas;
			model.addAttribute("porcentajeRegistradas", porcentajeRegistradas);
		}
		
		}else if (hasRole("ROLE_PROVINCIAL")) {
			model.addAttribute("rol", "Provincial");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_PROVINCIAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}
			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
			
			
			
			
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Administrador");
			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_ADMINISTRADOR);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
		
		
		}		
         return "tecnicoNacional/DashboardAutoridades";
    }
	
	@RequestMapping("/view/rendicion/DashboardAutoridadesS")
    public String DashboardAutoridadesS(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
		
		List<Integer> list = new ArrayList<Integer>();
		TblUsuario identificadorlogin = us.buscarUsuarioXEmail(authentication.getName(), Constantes.periodo());
		if (hasRole("ROLE_NACIONAL")) {
			model.addAttribute("rol", "Nacional");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_NACIONAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
		Integer cumplidasAtiempo = autori.conteoEstadosProcesoInformesAutoridades(Constantes.periodo(), Constantes.ESTADO_INFORME_A_TIEMPO);
		model.addAttribute("cumplidasAtiempo", cumplidasAtiempo);
		Integer cumplidasAdestiempo = autori.conteoEstadosProcesoInformesAutoridades(Constantes.periodo(), Constantes.ESTADO_INFORME_A_DESTIEMPO);
		model.addAttribute("cumplidasAdestiempo", cumplidasAdestiempo);
		Integer incumplidas = autori.conteoEstadosProcesoAutoridades(Constantes.periodo(), Constantes.ESTADO_PROCESO_INCUMPLIDO);
		model.addAttribute("incumplidas", incumplidas);
		
		Integer finalizadas = cumplidasAtiempo+cumplidasAdestiempo;
		model.addAttribute("finalizadas", finalizadas);
		Integer activas = autori.conteoEstadosAutoridades(Constantes.periodo(), Constantes.ESTADO);
		model.addAttribute("activas", activas);
		Integer registradas = autori.conteoEstadosAutoridades(Constantes.periodo(), Constantes.ESTADO_REGISTRADO);
		model.addAttribute("registradas", registradas);
		
		
		Integer catastradas = autori.conteoCatastroAutoridades(Constantes.periodo());
		model.addAttribute("catastradas", catastradas);

		if (catastradas==0) {
			Integer porcentajeAtiempo = 0;
			model.addAttribute("porcentajeAtiempo", porcentajeAtiempo);
			Integer porcentajeAdestiempo =   0;
			model.addAttribute("porcentajeAdestiempo", porcentajeAdestiempo);
			Integer porcentajeIncumplidas =   0;
			model.addAttribute("porcentajeIncumplidas", porcentajeIncumplidas);
			Integer porcentajeFinalizadas =   0;
			model.addAttribute("porcentajeFinalizadas", porcentajeFinalizadas);
			Integer porcentajeActivas =  0;
			model.addAttribute("porcentajeActivas", porcentajeActivas);
			Integer porcentajeIncactivas =  0;
			model.addAttribute("porcentajeIncactivas", porcentajeIncactivas);
			Integer porcentajeRegistradas =  0;
			model.addAttribute("porcentajeRegistradas", porcentajeRegistradas);
		}else {
			Integer porcentajeAtiempo =  (cumplidasAtiempo*100)/catastradas;
			model.addAttribute("porcentajeAtiempo", porcentajeAtiempo);
			Integer porcentajeAdestiempo =  (cumplidasAdestiempo*100)/catastradas;
			model.addAttribute("porcentajeAdestiempo", porcentajeAdestiempo);
			Integer porcentajeIncumplidas =  (incumplidas*100)/catastradas;
			model.addAttribute("porcentajeIncumplidas", porcentajeIncumplidas);
			Integer porcentajeFinalizadas =  (finalizadas*100)/catastradas;
			model.addAttribute("porcentajeFinalizadas", porcentajeFinalizadas);
			Integer porcentajeActivas =  (activas*100)/catastradas;
			model.addAttribute("porcentajeActivas", porcentajeActivas);
			Integer porcentajeIncactivas = 100;
			model.addAttribute("porcentajeIncactivas", porcentajeIncactivas);
			Integer porcentajeRegistradas =  (registradas*100)/catastradas;
			model.addAttribute("porcentajeRegistradas", porcentajeRegistradas);
		}
		
		}else if (hasRole("ROLE_PROVINCIAL")) {
			model.addAttribute("rol", "Provincial");

			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_PROVINCIAL);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}
			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
			model.addAttribute("listadoLocalizacionProvincia", listadoLocalizacionProvincia);
			
			
			
			
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Administrador");
			List<TblUsuarioLocalizacion> localidad = tecsv.obtenerLocalizacionXtecnico(
					identificadorlogin.getIdentificador(), Constantes.periodo(), Constantes.ROL_ADMINISTRADOR);
			for (TblUsuarioLocalizacion datos : localidad) {
				list.add(datos.getProvCod());
			}

			List<TblLocalizacion> listadoLocalizacionProvincia = gcs.obtenerLocalizacionfuncionarios(1, list, "activo");
		
		
		}		
         return "rendicion/DashboardAutoridadesS";
    }
	
	@RequestMapping("/view/tecnicoNacional/DashboardAutoridadesProvincia")
    public String DashboardAutoridadesProvincia(Model model,  @Param(value = "provincia") Integer provincia, Authentication authentication) {	
		
		model.addAttribute("provincia",provincia);
		String cumplidasAtiempo = autori.conteoEstadosProcesoInformesAutoridadesxProvincia(Constantes.periodo(), Constantes.ESTADO_INFORME_A_TIEMPO, provincia).get(0).toString();
		model.addAttribute("cumplidasAtiempo", cumplidasAtiempo);
		String cumplidasAdestiempo = autori.conteoEstadosProcesoInformesAutoridadesxProvincia(Constantes.periodo(), Constantes.ESTADO_INFORME_A_DESTIEMPO, provincia).get(0).toString();
		model.addAttribute("cumplidasAdestiempo", cumplidasAdestiempo);
		String incumplidas = autori.conteoEstadosProcesoInformesAutoridadesxProvincia(Constantes.periodo(), Constantes.ESTADO_PROCESO_INCUMPLIDO, provincia).get(0).toString();
		model.addAttribute("incumplidas", incumplidas);
		
		
	
		Integer scat = Integer.parseInt(cumplidasAtiempo);
		Integer scad = Integer.parseInt(cumplidasAdestiempo);
		String sincumplidas = incumplidas.toString();
		Integer sin = Integer.parseInt(sincumplidas);
		
		Integer finalizadas = scat  + scad;
		
		
		model.addAttribute("finalizadas", finalizadas);
		Integer activas = autori.conteoEstadosAutoridadesxProvincia(Constantes.periodo(), Constantes.ESTADO, provincia);
		model.addAttribute("activas", activas);
		Integer registradas = autori.conteoEstadosAutoridadesxProvincia(Constantes.periodo(), Constantes.ESTADO_REGISTRADO, provincia);
		model.addAttribute("registradas", registradas);
		
		
		Integer catastradas = autori.conteoCatastroAutoridadesxProvincia(Constantes.periodo(), Constantes.ESTADO_ELIMINADO, provincia);
		model.addAttribute("catastradas", catastradas);

		if (catastradas==0) {
			Integer porcentajeAtiempo = 0;
			model.addAttribute("porcentajeAtiempo", porcentajeAtiempo);
			Integer porcentajeAdestiempo =   0;
			model.addAttribute("porcentajeAdestiempo", porcentajeAdestiempo);
			Integer porcentajeIncumplidas =   0;
			model.addAttribute("porcentajeIncumplidas", porcentajeIncumplidas);
			Integer porcentajeFinalizadas =   0;
			model.addAttribute("porcentajeFinalizadas", porcentajeFinalizadas);
			Integer porcentajeActivas =  0;
			model.addAttribute("porcentajeActivas", porcentajeActivas);
			Integer porcentajeIncactivas =  0;
			model.addAttribute("porcentajeIncactivas", porcentajeIncactivas);
			Integer porcentajeRegistradas =  0;
			model.addAttribute("porcentajeRegistradas", porcentajeRegistradas);
		}else {
			Integer porcentajeAtiempo =  (scat*100)/catastradas;
			model.addAttribute("porcentajeAtiempo", porcentajeAtiempo);
			Integer porcentajeAdestiempo =  (scad*100)/catastradas;
			model.addAttribute("porcentajeAdestiempo", porcentajeAdestiempo);
			Integer porcentajeIncumplidas =  (sin*100)/catastradas;
			model.addAttribute("porcentajeIncumplidas", porcentajeIncumplidas);
			Integer porcentajeFinalizadas =  (finalizadas*100)/catastradas;
			model.addAttribute("porcentajeFinalizadas", porcentajeFinalizadas);
			Integer porcentajeActivas =  (activas*100)/catastradas;
			model.addAttribute("porcentajeActivas", porcentajeActivas);
			Integer porcentajeIncactivas = 100;
			model.addAttribute("porcentajeIncactivas", porcentajeIncactivas);
			Integer porcentajeRegistradas =  (registradas*100)/catastradas;
			model.addAttribute("porcentajeRegistradas", porcentajeRegistradas);
		}
		
		
         return "tecnicoNacional/DashboardAutoridadesProvincia";
    }
}
