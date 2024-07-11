package gob.cpccs.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gob.cpccs.model.aplicacion.TblAplicaciones;
import gob.cpccs.service.aplicacion.AplicacionesServicio;

@Controller
public class LoginController {
	@Autowired
    private AplicacionesServicio as;
	
     @RequestMapping(value = {"/login", "/loginn"})
     public ModelAndView login(@RequestParam(value = "error", required = false) Integer error,
          @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request, HttpServletResponse response) {
         TblAplicaciones listaAplicaciones = as.obtenerRegistrosAplicacionesPorid(11);

          ModelAndView model = new ModelAndView();
          String version = listaAplicaciones.getVersionApp();
          if (error != null){
               if (error.equals(1)){
                    model.addObject("error", "Usuario y contraseña inválidos");
               } else if (error.equals(2)){
                    model.addObject("error", "El tiempo ha expirado, vuelva a ingresar los datos");
               } else if (error.equals(3)){
                    model.addObject("error", "No existe conexión, vuelva a ingresar");
               } else if (error.equals(4)){
                    model.addObject("error", "La sesión ha caducado, vuelva a ingresar");
               } else if (error.equals(5)){
                    model.addObject("error", "Tiene una sesión activa, intente en cinco minutos");
               } else if (error.equals(6)){
                    model.addObject("error", "Problemas de conexión,  vuelva a ingresar los datos");
               } else if (error.equals(7)){
                    model.addObject("error", "Código 7, no existe conexión, intente en cinco minutos");
               } else if (error.equals(8)){
                    model.addObject("error", "Acceso denegado, ingrese al sistema");
               } else if (error.equals(9)){
                    model.addObject("error", "Usuario inactivo, espere el correo electrónico de activación");
               } else if (error.equals(10)){
              model.addObject("error", "Su usuario se encuentra en estado registrado, espere a ser activado");
          	   }
          }

          if (logout != null){
               
               
               model.addObject("message", "Usted ha salido exitosamente");
               model.addObject("version", version);

          }
          Date date = new Date();
          DateFormat formatter = new SimpleDateFormat("yyyy");
          String anio = formatter.format(date);
          model.addObject("anio", anio);
          model.setViewName("login");  
          model.addObject("version", version);
          return model;
     }



}
