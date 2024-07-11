package gob.cpccs.service.mail;

import java.util.Date;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
     
     
     
     void sendSimpleMessage(String to, String subject, String text);

     void sendSimpleMessageBcc(String to, String bcc, String subject, String text);

     void sendSimpleMessageCc(String to, String cc, String subject, String text);

     void sendSimpleMessageUsingTemplate(String to, String subject, SimpleMailMessage template, String templateArgs);

     void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);

     void prepareAndSend(String to, String subject, String text, Boolean html);

     void mailRegistroAutoridad(String mailCiudadano, String nombreCiudadano, String numeroDI, String password, String pregunta1, String pregunta2, String dignidad, String fecha_registro, Boolean html);
     
     void mailActivacionIntitucion(String mailCiudadano, String nombreCiudadano, String nombreinstitucion, String ruc,String estado,String razon, Boolean html);
     
     void mailActivacionAutoridad(String mailCiudadano, String nombreCiudadano, String ruc,String resultado,String razon, Boolean html);
     
     void mailFinalziarInforme(String mailCiudadano, String nombreCiudadano, String ruc, Date fechaFin, String razon, String tipo, Boolean html);

     void mailFinalziarInformeInstitucion(String mailCiudadano, String nombreCiudadano, String ruc, String nombreInstitucion, Date fechaFin, String razon, Boolean html);

     void mailRegistroIntitucionResponRegis(String mailCiudadano, String nombreCiudadano,String nombreinstitucion, String numeroDI, String password, Date pregunta2, Boolean html);

     void mailRegistroIntitucionResponbles(String mailCiudadano, String nombreCiudadano,String nombreinstitucion, Boolean html);
     
     void mailReseteoclavePerfil(String mailUsuario, String NombreResponRegis,String Nuevopass, Boolean html);
     
     void mailCreacionPerfil(String mailUsuario, String NombreResponRegis,String Nuevopass, Boolean html);
     
     void mailAperturaInformeInstitucion(String mailResponable, String nombre, String cargo, String nombreinstitucion, String Ruc, Date FechaApertura, Boolean html);

     void mailAperturaInformeAutoridad(String mailResponable, String nombre, String cargo, String nombreinstitucion, String Ruc, Date FechaApertura, Boolean html);

     
     void mailNotificacionTecnico(String mailTecnico, String nombreTecnico,  String nombreinstitucion, String Ruc, Date FechaApertura, Boolean html);

}