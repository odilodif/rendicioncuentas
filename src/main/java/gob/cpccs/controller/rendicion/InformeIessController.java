package gob.cpccs.controller.rendicion;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import gob.cpccs.controller.HomeController;
import gob.cpccs.model.catalogos.TblInstitucion;
import gob.cpccs.model.dto.rendicion.TblFinanciamientoDTO;
import gob.cpccs.model.dto.rendicion.TblFondoPrestacionalDTO;
import gob.cpccs.model.dto.rendicion.TblSeguroCampesinoDTO;
import gob.cpccs.model.dto.rendicion.TblSeguroGeneralDTO;
import gob.cpccs.model.rendicion.TblCoberturaGeografica;
import gob.cpccs.model.rendicion.TblFinanciamiento;
import gob.cpccs.model.rendicion.TblFondoPrestacional;
import gob.cpccs.model.rendicion.TblInforme;
import gob.cpccs.model.rendicion.TblSeguroCampesino;
import gob.cpccs.model.rendicion.TblSeguroGeneral;
import gob.cpccs.model.usuario.TblResponables;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.service.catalogos.CatalogosServicio;
import gob.cpccs.service.catalogos.InstitucionServicio;
import gob.cpccs.service.mail.EmailService;
import gob.cpccs.service.rendicion.FondoPrestacionalService;
import gob.cpccs.service.rendicion.InformeServicio;
import gob.cpccs.service.rendicion.SeguroCampesinoService;
import gob.cpccs.service.rendicion.SeguroGeneralService;
import gob.cpccs.service.usuario.ResponsableServicio;
import gob.cpccs.service.usuario.UsuarioServicio;
import gob.cpccs.utilidades.Constantes;

@Controller
public class InformeIessController {
	@Autowired
    private HomeController hc;
	@Autowired
	private UsuarioServicio usu;
	@Autowired
	private InformeServicio infor;
	@Autowired
	private CatalogosServicio gcs;
	@Autowired
	private FondoPrestacionalService fondoPrestaconal;
	@Autowired
	private SeguroGeneralService SeguroGeneral;
	@Autowired
	private SeguroCampesinoService SeguroCampesino;
	@Autowired
	private ResponsableServicio respon;
	@Autowired
    private EmailService ms;
	@Autowired
	private InstitucionServicio servicioinstitucion;
	
	
	private static final String MESSAGE_OK_JSON = "{\"data\": ";
	private static final String MESSAGE_EMPTY_JSON = "{\"data\": []}";
	private static final String MESSAGE_ERROR_JSON = "{\"error\" : \"true\", \"message\": " + "ERROR:--> ";	
	
	//Fondo Prestacional//
	 @RequestMapping(value = {"/obtenerRegistrosFondoPrestacional"}, method = RequestMethod.POST)
	    @ResponseBody
	    public String obtenerRegistrosFondoPrestacional(Authentication authentication,@RequestParam("infCod") Integer infCod) {
			 String json;
	         ObjectMapper mapper = new ObjectMapper();
	         List<TblFondoPrestacionalDTO> listaFondoPrestacionalDTO = new ArrayList<>();
	     	try {
	     		List<TblFondoPrestacional> listaRegistrosFondoPretacional =fondoPrestaconal.obtenerRegistrosFondoPrestacionalXInfCod(infCod);	 
	     		DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
                simbolo.setDecimalSeparator('.');
                 simbolo.setGroupingSeparator(',');
					DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
	     		listaFondoPrestacionalDTO = listaRegistrosFondoPretacional.stream()
						.map(obj -> TblFondoPrestacionalDTO.builder()
								.fpCod(obj.getFpCod())
								.fpDesc(obj.getFpDesc())
								.fpPresins(formateador.format(obj.getFpPresins()))
								.fpGastcp(formateador.format(obj.getFpGastcp()))
								.fpGastce(formateador.format(obj.getFpGastce()))
								.fpGastip(formateador.format(obj.getFpGastip()))
								.fpGastie(formateador.format(obj.getFpGastie()))
								.build())
						.collect(Collectors.toList());
				json = (!listaFondoPrestacionalDTO.isEmpty())
						? MESSAGE_OK_JSON + mapper.writeValueAsString(listaFondoPrestacionalDTO) + "}"
						: MESSAGE_EMPTY_JSON;
	
			} catch (Exception e) {
				json = MESSAGE_ERROR_JSON + e.getMessage() + "}";
			}     

	         return json;
	    }
	
	@RequestMapping("/view/rendicion/Frm_FondoPrestacional")
    public String Frm_FondoPrestacional(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   	 
   		List<TblFondoPrestacional> listaFondoPrestacional= fondoPrestaconal.obtenerRegistrosFondoPrestacionalXInfCod(verificarInforme.getInfCod());    
 
   		if(listaFondoPrestacional.size() ==0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("inf_Cod", verificarInforme.getInfCod());
		}
		else {
			model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_MATRIZ);
			 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			model.addAttribute("inf_Cod", verificarInforme.getInfCod());
		}		
		}
         return "rendicion/Frm_FondoPrestacional";
    }
	
	
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarFondoPrestacional")
    public @ResponseBody String guardarFondoPrestacional(HttpServletRequest request,@RequestParam("infCod") int infCod,
    		@RequestParam("fpDesc[]") String[] fpDesc,
    		@RequestParam("fpPresins[]") String[] fpPresins,
    		@RequestParam("fpGastcp[]") String[] fpGastcp,
    		@RequestParam("fpGastce[]") String[] fpGastce,
    		@RequestParam("fpGastip[]") String[] fpGastip,
    		@RequestParam("fpGastie[]") String[] fpGastie) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
        	   
 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
 			   for (int i = 0; i < fpDesc.length; i++){
 				   
 			    String fpPresins1=fpPresins[i].toString().replace(",", "").trim(); 
 			    String fpGastcp1=fpGastcp[i].toString().replace(",", "").trim();
 			    String fpGastce1=fpGastce[i].toString().replace(",", "").trim();
 			    String fpGastip1=fpGastip[i].toString().replace(",", "").trim();
 			    String fpGastie1=fpGastie[i].toString().replace(",", "").trim();
 				TblFondoPrestacional tblFondoPrestacional = new TblFondoPrestacional();
 			  	tblFondoPrestacional.setFpDesc(fpDesc[i]);
 			  	tblFondoPrestacional.setFpPresins(new BigDecimal(fpPresins1));
 			  	tblFondoPrestacional.setFpGastcp(new BigDecimal(fpGastcp1)); 			  	
 			  	tblFondoPrestacional.setFpGastce(new BigDecimal(fpGastce1)); 
 			  	tblFondoPrestacional.setFpGastip(new BigDecimal(fpGastip1)); 
 			  	tblFondoPrestacional.setFpGastie(new BigDecimal(fpGastie1));
 			  	tblFondoPrestacional.setInfCod(tblInforme);
 			  	fondoPrestaconal.guardarFondoPrestacional(tblFondoPrestacional);
 			  }
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
				 
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }
	//Fin Fondo Prestacional//
	
	// Seguro General //
	@RequestMapping(value = {"/obtenerSeguroGeneral"}, method = RequestMethod.POST)
	@ResponseBody 
	public String obtenerSeguroGeneral(Authentication authentication,@Param(value = "infCod") Integer infCod) {
		 String json;
         ObjectMapper mapper = new ObjectMapper();
         List<TblSeguroGeneralDTO> listaSeguroGeneralDTO = new ArrayList<>();
     	try {
     		List<TblSeguroGeneral> listaSeguroGeneral= SeguroGeneral.obtenerRegistrosSEguroGeneralXinfCod(infCod); 	 
     		DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
            simbolo.setGroupingSeparator(',');
			DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
     		listaSeguroGeneralDTO = listaSeguroGeneral.stream()
					.map(obj -> TblSeguroGeneralDTO.builder()
							.sgCod(obj.getSgCod())
							.sgPresin(formateador.format(obj.getSgPresin()))
							.sgAposr(formateador.format(obj.getSgAposr()))
							.sgApopp(formateador.format(obj.getSgApopp()))
							.sgIngfr(formateador.format(obj.getSgIngfr()))
							.sgUtilinv(formateador.format(obj.getSgUtilinv()))
							.sgJubil(formateador.format(obj.getSgJubil()))
							.sgPcod(formateador.format(obj.getSgPcod()))
							.sgPejec(formateador.format(obj.getSgPejec()))
							.build())
					.collect(Collectors.toList());
			json = (!listaSeguroGeneralDTO.isEmpty())
					? MESSAGE_OK_JSON + mapper.writeValueAsString(listaSeguroGeneralDTO) + "}"
					: MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = MESSAGE_ERROR_JSON + e.getMessage() + "}";
		}  
		
		 return json;
	} 
	@RequestMapping("/view/rendicion/Frm_SeguroGeneral")
    public String Frm_SeguroGeneral(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   	 
   		List<TblSeguroGeneral> listaSeguroGenesarl= SeguroGeneral.obtenerRegistrosSEguroGeneralXinfCod(verificarInforme.getInfCod());    
 
   		if(listaSeguroGenesarl.size() ==0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("inf_Cod", verificarInforme.getInfCod());
		}
		else {			
			model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_MATRIZ);
			 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			model.addAttribute("inf_Cod", verificarInforme.getInfCod());
		}		
		}
         return "rendicion/Frm_SeguroGeneral";
    }
	
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarSeguroGeneral")
    public @ResponseBody String guardarSeguroGeneral(HttpServletRequest request,@RequestParam("infCod") int infCod,
    		@RequestParam("sgPresin") String sgPresin,
    		@RequestParam("sgPcod") String sgPcod,
    		@RequestParam("sgPejec") String sgPejec,
    		@RequestParam("sgAposr") String sgAposr,
    		@RequestParam("sgApopp") String sgApopp,
    		@RequestParam("sgIngfr") String sgIngfr,
    		@RequestParam("sgUtilinv") String sgUtilinv,
    		@RequestParam("sgJubil") String sgJubil) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
        	   
 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
 			 
 				   
 			    String sgPresin1=sgPresin.toString().replace(",", "").trim(); 
 			    String sgPcod1=sgPcod.toString().replace(",", "").trim();
 			    String sgPejec1=sgPejec.toString().replace(",", "").trim();
 			    String sgAposr1=sgAposr.toString().replace(",", "").trim();
 			    String sgApopp1=sgApopp.toString().replace(",", "").trim();
 			    String sgIngfr1=sgIngfr.toString().replace(",", "").trim();
 			    String sgUtilinv1=sgUtilinv.toString().replace(",", "").trim();
 			    String sgJubil1=sgJubil.toString().replace(",", "").trim();
 				
 			 TblSeguroGeneral tblSeguroGeneral = new TblSeguroGeneral();
 			    tblSeguroGeneral.setSgPresin(new BigDecimal(sgPresin1));
 			    tblSeguroGeneral.setSgPcod(new BigDecimal(sgPcod1));
 			    tblSeguroGeneral.setSgPejec(new BigDecimal(sgPejec1));
 			    tblSeguroGeneral.setSgAposr(new BigDecimal(sgAposr1));
 			    tblSeguroGeneral.setSgApopp(new BigDecimal(sgApopp1));
 			    tblSeguroGeneral.setSgIngfr(new BigDecimal(sgIngfr1));
 			    tblSeguroGeneral.setSgUtilinv(new BigDecimal(sgUtilinv1));
 			    tblSeguroGeneral.setSgJubil(new BigDecimal(sgJubil1));
 			    tblSeguroGeneral.setInfCod(tblInforme);
 			  	SeguroGeneral.guardarSEguroGeneral(tblSeguroGeneral);
 			  
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
				 
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }
	
	
	//Fin Seguro General //
	
	//Seguro General Campesino //
	@RequestMapping(value = {"/obtenerSeguroCampesino"}, method = RequestMethod.POST)
	@ResponseBody 
	public String obtenerSeguroCampesino(Authentication authentication,@Param(value = "infCod") Integer infCod) {
		 String json;
         ObjectMapper mapper = new ObjectMapper();
         List<TblSeguroCampesinoDTO> listaSeguroCampesinoDTO = new ArrayList<>();
     	try {
     		List<TblSeguroCampesino> listaSeguroCampesino= SeguroCampesino.obteberRegistrosSeguroCampesinoXinfCod(infCod);  	 
     		DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
            simbolo.setGroupingSeparator(',');
			DecimalFormat formateador = new DecimalFormat("###,###.##",simbolo);
     		listaSeguroCampesinoDTO = listaSeguroCampesino.stream()
					.map(obj -> TblSeguroCampesinoDTO.builder()
							.scCod(obj.getScCod())
							.scPresins(formateador.format(obj.getScPresins()) )
							.scConjf(formateador.format(obj.getScConjf()))
							.scConpat(formateador.format(obj.getScConpat()))
							.scConest(formateador.format(obj.getScConest()))
							.scConsp(formateador.format(obj.getScConsp()))
							.scPresc(formateador.format(obj.getScPresc()))
							.scPrese(formateador.format(obj.getScPrese()))
							.scContraba(formateador.format(obj.getScContraba()))
							.build())
					.collect(Collectors.toList());
			json = (!listaSeguroCampesinoDTO.isEmpty())
					? MESSAGE_OK_JSON + mapper.writeValueAsString(listaSeguroCampesinoDTO) + "}"
					: MESSAGE_EMPTY_JSON;

		} catch (Exception e) {
			json = MESSAGE_ERROR_JSON + e.getMessage() + "}";
		}  
		
		 return json;
	} 
	
	@RequestMapping("/view/rendicion/Frm_SeguroCampesino")
    public String Frm_SeguroCampesino(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {		
		TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
   	 	TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(),Constantes.periodo());
   	 TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
		if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){   	   	 	model.addAttribute("inf_estado", Constantes.TIPO_INFORME_ESTADO_VACIO);		
   	 	}else {
   	 
   		List<TblSeguroCampesino> listaSeguroCampesino= SeguroCampesino.obteberRegistrosSeguroCampesinoXinfCod(verificarInforme.getInfCod());    
 
   		if(listaSeguroCampesino.size() ==0) {
   	 	 model.addAttribute("inf_estado", verificarInforme.getInfEstado());
 		model.addAttribute("inf_Cod", verificarInforme.getInfCod());
		}
		else {			
			model.addAttribute("inf_estado",Constantes.TIPO_INFORME_ESTADO_MATRIZ);
			 model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
			model.addAttribute("inf_Cod", verificarInforme.getInfCod());
		}		
		}
         return "rendicion/Frm_SeguroCampesino";
    }
	
	@SuppressWarnings("finally")
    @RequestMapping(value = "/view/rendicion/guardarSeguroCampesino")
    public @ResponseBody String guardarSeguroCampesino(HttpServletRequest request,@RequestParam("infCod") int infCod,
    		@RequestParam("scPresins") String scPresins,
    		@RequestParam("scConjf") String scConjf,
    		@RequestParam("scConpat") String scConpat,
    		@RequestParam("scConest") String scConest,
    		@RequestParam("scConsp") String scConsp,
    		@RequestParam("scPresc") String scPresc,
    		@RequestParam("scPrese") String scPrese,
    		@RequestParam("scContraba") String scContraba) {
         JSONObject mensaje = new JSONObject();
         mensaje.put("estado", "error");
         mensaje.put("mensaje", "Ha ocurrido un error!");	        
         try{
        	 
 			    TblInforme tblInforme = infor.obtenerRegistroInformeXcodPeriodo(infCod, Constantes.periodo());
 			 
 				   
 			    String scPresins1=scPresins.toString().replace(",", "").trim(); 
 			    String scConjf1=scConjf.toString().replace(",", "").trim();
 			    String scConpat1=scConpat.toString().replace(",", "").trim();
 			    String scConest1=scConest.toString().replace(",", "").trim();
 			    String scConsp1=scConsp.toString().replace(",", "").trim();
 			    String scPresc1=scPresc.toString().replace(",", "").trim();
 			    String scPrese1=scPrese.toString().replace(",", "").trim();
 			    String scContraba1=scContraba.toString().replace(",", "").trim();
 				
 			    TblSeguroCampesino tblSeguroCampesino = new TblSeguroCampesino();
	 			tblSeguroCampesino.setScPresins(new BigDecimal(scPresins1));
	 			tblSeguroCampesino.setScConjf(new BigDecimal(scConjf1));
	 			tblSeguroCampesino.setScConpat(new BigDecimal(scConpat1));
	 			tblSeguroCampesino.setScConest(new BigDecimal(scConest1));
	 			tblSeguroCampesino.setScConsp(new BigDecimal(scConsp1));
	 			tblSeguroCampesino.setScPresc(new BigDecimal(scPresc1));
	 			tblSeguroCampesino.setScPrese(new BigDecimal(scPrese1));
	 			tblSeguroCampesino.setScContraba(new BigDecimal(scContraba1));
	 			tblSeguroCampesino.setInfCod(tblInforme);
 			  	SeguroCampesino.guardarSeguroCampesino(tblSeguroCampesino);
 			  
				mensaje.put("estado", "exito");
				mensaje.put("mensaje", "Los datos se han guardado correctamente.! "); 
				 
         } catch (Exception e){
              mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
         } finally{
              return mensaje.toString();
         }
    }
	//Fin Seguro General Campesino //
	 @RequestMapping("/view/rendicion/Frm_Finalizar_IESS")
	    public String Frm_Finalizar_IESS(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {	
			model.addAttribute("email", authentication.getName());
			TblUsuario datosUsuario = usu.BuscarUsuarioEmailXperido(authentication.getName(), Constantes.periodo());
			TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(datosUsuario.getCodigoIntitucionAutorida(), Constantes.periodo());

	   	     ArrayList matriz = new ArrayList();
	   	  TblInstitucion datosInstitucion = servicioinstitucion.ObtenerInstitucionesXIdcodigo(datosUsuario.getCodigoIntitucionAutorida());
			if (verificarInforme==null||datosInstitucion.getInstEstado().equals(Constantes.ESTADO_ELIMINADO)){	 
				model.addAttribute("inf_estado",Constantes.ESTADO_SIN_INFORME);		
	   	 	}else {
	   	 	String periodo = String.valueOf(Constantes.periodo());
			List<TblResponables> datosResponsables = respon.buscarResponsableXcodigoInstitucion(verificarInforme.getInstCod(), periodo);

			for (TblResponables datos : datosResponsables) {
				if (datos.getResponEmail() != null && !datos.getResponEmail().equals("")) {
					
				}

			}
	   	 		
	   	 		
	   	 		Integer codigoInforme = verificarInforme.getInfCod();
	   	 	 	String verificador = verificarInformeIESS(codigoInforme, Constantes.periodo());
		   	 	model.addAttribute("infestadoinforme", verificarInforme.getInfEstado());
				model.addAttribute("infAutCod", verificarInforme.getInstCod());
				model.addAttribute("infAutPeriodo", verificarInforme.getInfPeriodo());
	   	 	 	if(verificador.equals("completo") && !verificarInforme.getInfEstado().trim().equals("finalizado")) {
	   	 	 	model.addAttribute("inf_estado", "completo");	 		
	   	 	 	}else {
	   	 	 	model.addAttribute("inf_estado",verificarInforme.getInfEstado());
	   	 	 
	   	 	 	model.addAttribute("mensaje", verificador);
	   	 	 	
				
	   	 	 	}
	   	 	}
	         return "rendicion/Frm_Finalizar_IESS";
	    }
		
		@RequestMapping(value = "view/rendicion/verificarInformeIESS")
		public @ResponseBody String verificarInformeIESS(@RequestParam(value = "infAutCod") Integer infCod,  @RequestParam(value = "infAutPeriodo") Integer infAutPeriodo) {
			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			String resultado="";
		
			try {
				String verificaInfAut = infor.listarInstitucionIESS(infCod, infAutPeriodo);
				Integer contador = verificaInfAut.length();
				if (contador==65) {
					resultado ="completo";
				}else {
					resultado = verificaInfAut;
					String[] items = resultado.split("NO");
					for (String item: items) {
				
					}
				}
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			}
			return resultado;
		} 
		
		
		@SuppressWarnings("finally")
		@RequestMapping(value = "view/rendicion/FinalizarInformeIESS")
		public @ResponseBody String FinalizarInformeIESS(Authentication authentication,@RequestParam(value = "infAutCod") Integer instCod,  @RequestParam(value = "infAutPeriodo") Integer infPeriodo
				) {

			JSONObject mensaje = new JSONObject();
			mensaje.put("estado", "error");
			mensaje.put("mensaje", "Ha ocurrido un error!");
			try {

				TblInforme verificarInforme = infor.obtenerRegistroInformeInstitucion(instCod, infPeriodo);
				if (verificarInforme==null) {
					
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "No hay informe!");
				}else {
					mensaje.put("estado", "exito");
					mensaje.put("mensaje", "Los datos se han guardado correctamente.! ");
					Date infAutFechafin = new Date();
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date fechaControl = format.parse(Constantes.FECHA_CIERRE_INFORME_IESS);
					if(infAutFechafin.before(fechaControl)) {
						infor.finalizarInformeInstitucion(instCod, Constantes.ESTADO_INFORME_FINALIZADO, infAutFechafin, Constantes.ESTADO_INFORME_A_TIEMPO);	
						servicioinstitucion.actualizarInstVerificador(instCod, infPeriodo, Constantes.ESTADO_PROCESO_CUMPLIDO);

					}else
					{
						
						infor.finalizarInformeInstitucion(instCod, Constantes.ESTADO_INFORME_FINALIZADO, infAutFechafin, Constantes.ESTADO_INFORME_A_DESTIEMPO);
						servicioinstitucion.actualizarInstVerificador(instCod, infPeriodo, Constantes.ESTADO_PROCESO_INCUMPLIDO);

					}
					
					
					
				}
				TblInforme verificarInformeFinalizado = infor.obtenerRegistroInformeInstitucion(instCod, infPeriodo);
				
				if (verificarInformeFinalizado.getInfEstado().trim().equals(Constantes.ESTADO_INFORME_FINALIZADO)) {
					
					String periodo = String.valueOf(Constantes.periodo());
					List<TblResponables> datosResponsables = respon.buscarResponsableXcodigoInstitucion(verificarInforme.getInstCod(), periodo);
					TblInstitucion datosInstitucion = gcs.ObtenerInstitucionesXidEstado(instCod,Constantes.ESTADO, Constantes.periodo());
					for (TblResponables datos : datosResponsables) {
						if (datos.getResponEmail() != null && !datos.getResponEmail().equals("")) {
							
							ms.mailFinalziarInformeInstitucion(datos.getResponEmail(), datos.getResponNombre(), datosInstitucion.getInstRuc(),datosInstitucion.getInstNom() ,verificarInformeFinalizado.getInfFechafin(), verificarInformeFinalizado.getInfVerificador(), true);

						}

					}
					
					
				}else
				{
					mensaje.put("estado", "error");
					mensaje.put("mensaje", "no se finalilzo el informe vuelva a intetarlo!");
				}
				
				
				
				
			} catch (Exception e) {
				mensaje.put("mensaje", "ERROR:--> " + e.getMessage());
			} finally {
				return mensaje.toString();
			}

		}

}
