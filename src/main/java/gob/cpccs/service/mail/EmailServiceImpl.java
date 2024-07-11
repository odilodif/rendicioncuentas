package gob.cpccs.service.mail;

import java.io.File;
import java.text.SimpleDateFormat;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import gob.cpccs.utilidades.Constantes;
import java.util.Date;

@Service
public class EmailServiceImpl implements EmailService {

     @Autowired(required=false)
     public JavaMailSender emailSender;
    
     @Override
     public void sendSimpleMessage(String to, String subject, String text) {
          try{
               SimpleMailMessage message = new SimpleMailMessage();
               message.setTo(to);
               message.setSubject(subject);
               message.setText(text);

               emailSender.send(message);
              
          } catch (MailException exception){
               exception.printStackTrace();
          }

     }

     @Override
     public void sendSimpleMessageBcc(String to, String bcc, String subject, String text) {
          try{
               SimpleMailMessage message = new SimpleMailMessage();
               message.setTo(to);
               message.setBcc(bcc);
               message.setSubject(subject);
               message.setText(text);
               emailSender.send(message);
          } catch (MailException exception){
               exception.printStackTrace();
          }

     }

     @Override
     public void sendSimpleMessageCc(String to, String cc, String subject, String text) {
          try{
               SimpleMailMessage message = new SimpleMailMessage();
               message.setTo(to);
               message.setCc(cc);
               message.setSubject(subject);
               message.setText(text);
               emailSender.send(message);
          } catch (MailException exception){
               exception.printStackTrace();
          }

     }

     @Override
     public void sendSimpleMessageUsingTemplate(String to, String subject, SimpleMailMessage template, String templateArgs) {
          String text = String.format(template.getText(), templateArgs);
          sendSimpleMessage(to, subject, text);

     }

     @Override
     public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) {
          try{
               MimeMessage message = emailSender.createMimeMessage();
               // pass 'true' to the constructor to create a multipart message
               MimeMessageHelper helper = new MimeMessageHelper(message, true);
               helper.setTo(to);
               helper.setSubject(subject);
               helper.setText(text);
               FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
               // Archivo adjunto
               helper.addAttachment("Invoice", file);
               emailSender.send(message);
          } catch (MessagingException e){
               e.printStackTrace();
          }

     }

     @Override
     public void prepareAndSend(String to, String subject, String text, Boolean html) {
          MimeMessagePreparator messagePreparator = mimeMessage -> {
        	 
               MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
               messageHelper.setFrom(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setTo(to);
               messageHelper.setBcc(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setSubject(subject);
               messageHelper.setText(text, html);
               // messageHelper.setText("Your username: " + "<b>" + username + "</b>", true);
          };
          try{
               emailSender.send(messagePreparator);
          } catch (MailException e){
               // runtime exception; compiler will not force you to handle it
          }
     }

     @Override //ok
     public void mailRegistroAutoridad(String mailCiudadano, String nombreCiudadano, String numeroDI, String password, String pregunta1, String pregunta2, String dignidad, String fecha_registro, Boolean html) {
        
          String subject = "notificación de registro en el "+Constantes.NOMBRE_MODULO_MINUSCULA+"";
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
               "      <tr><td colspan=\"2\" class='cuerpoDestinatarioMail familiaLetra'><b>Estimado(a): "+nombreCiudadano+"</b>,</td></tr>\r\n" +
               "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Dignidad:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+dignidad+"</td></tr>\r\n" +
               "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Cédula de ciudadania:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+numeroDI+"</td></tr>\r\n" +
               "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Confirmamos que usted se registró exitosamente en el "+Constantes.NOMBRE_MODULO_MINUSCULA+". "+Constantes.fechaRegistroEmail()+" </td></tr>\r\n" +
               "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Para acceder al sistema informático, por favor, espere la notificación de activación.</td></tr>\r\n" +
               "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>A continuación, sus datos de usuario:</td></tr>\r\n" +
               "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Usuario:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+mailCiudadano+"</td></tr>\r\n" +
               "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Contraseña:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+password+"</td></tr>\r\n" + 
               "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>¿Cuál es el nombre de su abuela materna?:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+pregunta1+"</td></tr>\r\n" +
               "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>¿Cuál es su fecha de nacimiento?:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+pregunta2+"</td></tr>\r\n" +
               "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Recuerde que cada usuario es responsable del manejo de sus credenciales de acceso del Sistema.</td></tr>\r\n" + 
               "      <tr><td colspan=\"2\" class='cuerpoPieMail familiaLetra'>Saludos cordiales,<br>"+Constantes.NOMBRE_INSTITUCION_SIGLAS+"</td></tr>\r\n" + 
               "      <tr><td colspan=\"2\" class='pieMail familiaLetra'><b>Nota: </b>"+ Constantes.NOTA_CORREOS_SISTEMA +"<b> "+Constantes.URL_DIRECTORIO_ASITENCIAS_TECNICAS+"</b>\r\n" + 
               "      </td></tr>\r\n" + 
               "    </table>\r\n" + 
               "  </body>\r\n" + 
               "</html>";
          
          MimeMessagePreparator messagePreparator = mimeMessage -> {
               MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
               messageHelper.setFrom(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setTo(mailCiudadano);
               messageHelper.setBcc(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setSubject(subject);
               messageHelper.setText(text, html);
          };
          try{
               emailSender.send(messagePreparator);
          } catch (MailException e){
          }
     }

     SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
     @Override //ok
     public void mailRegistroIntitucionResponRegis(String mailCiudadano, String nombreCiudadano, String nombreinstitucion, String ruc, String password, Date pregunta2, Boolean html) {
    	 String fechaNacimiento1 = df.format(pregunta2);
    	 String subject = "notificación de registro en el "+Constantes.NOMBRE_MODULO_MINUSCULA+"";
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
              "      <tr><td colspan=\"2\" class='cuerpoDestinatarioMail familiaLetra'><b>Estimado(a): "+nombreCiudadano+"</b>,</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Dignidad:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+nombreinstitucion+"</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>RUC:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+ruc+"</td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Confirmamos que usted se registró exitosamente en el "+Constantes.NOMBRE_MODULO_MINUSCULA+". "+Constantes.fechaRegistroEmail()+" </td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Para acceder al sistema informático, por favor, espere la notificación de activación.</td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>A continuación, sus datos de usuario:</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Usuario:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+mailCiudadano+"</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Contraseña:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+password+"</td></tr>\r\n" + 
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>¿Cuál es su fecha de nacimiento?:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+ fechaNacimiento1 +"</td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Recuerde que cada usuario es responsable del manejo de sus credenciales de acceso del Sistema.</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoPieMail familiaLetra'>Saludos cordiales,<br>"+Constantes.NOMBRE_INSTITUCION_SIGLAS+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='pieMail familiaLetra'><b>Nota: </b>"+ Constantes.NOTA_CORREOS_SISTEMA +"<b> "+Constantes.URL_DIRECTORIO_ASITENCIAS_TECNICAS+"</b>\r\n" + 
              "      </td></tr>\r\n" + 
              "    </table>\r\n" + 
              "  </body>\r\n" + 
              "</html>";
          
          MimeMessagePreparator messagePreparator = mimeMessage -> {
               MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
               messageHelper.setFrom(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setTo(mailCiudadano);
               messageHelper.setBcc(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setSubject(subject);
               messageHelper.setText(text, html);
          };
          try{
               emailSender.send(messagePreparator);
          } catch (MailException e){
          }
     }
     
     @Override //ok
     public void mailActivacionIntitucion(String mailCiudadano, String nombreCiudadano, String nombreinstitucion, String ruc,String resultado,String razon, Boolean html) {
      String estado="",mensaje="",Proceso="";
    	 if(resultado=="activada") {
    		 mensaje="activación";
    		 estado="Confirmamos que su institución ha sido activada con éxito ";
    		 Proceso="Proceda a llenar su informe en el sistema informático, de acuerdo al cronograma establecido en el Reglamento de Rendición de Cuentas.";
        }else if(resultado=="negada") {
        	mensaje="NEGACIÓN DE REGISTRO";
   		 estado="Su registro ha sido negado, debido al siguiente detalle: "+razon;
   		 Proceso="Por favor, vuelva al modulo del registro y complete nuevamente el formulario asignado";
        }
    	 String subject = "notificación de "+mensaje+" en el "+Constantes.NOMBRE_MODULO_MINUSCULA+"";
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
              "      <tr><td colspan=\"2\" class='cuerpoDestinatarioMail familiaLetra'><b>Estimado(a): "+nombreCiudadano+"</b>,</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Nombre:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+nombreinstitucion+"</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>RUC:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+ruc+"</td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>"+estado+Constantes.NOMBRE_MODULO_MINUSCULA+". "+Constantes.fechaRegistroEmail()+" </td></tr>\r\n" +  
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>"+Proceso+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Recuerde que cada usuario es responsable del manejo de sus credenciales de acceso del Sistema.</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoPieMail familiaLetra'>Saludos cordiales,<br>"+Constantes.NOMBRE_INSTITUCION_SIGLAS+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='pieMail familiaLetra'><b>Nota: </b>"+ Constantes.NOTA_CORREOS_SISTEMA +"<b> "+Constantes.URL_DIRECTORIO_ASITENCIAS_TECNICAS+"</b>\r\n" + 
              "      </td></tr>\r\n" + 
              "    </table>\r\n" + 
              "  </body>\r\n" + 
              "</html>";
          
          MimeMessagePreparator messagePreparator = mimeMessage -> {
               MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
               messageHelper.setFrom(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setTo(mailCiudadano);
               messageHelper.setBcc(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setSubject(subject);
               messageHelper.setText(text, html);
          };
          try{
               emailSender.send(messagePreparator);
          } catch (MailException e){
        	  System.out.print(e);
          }
     }
     
     @Override //ok
     public void mailActivacionAutoridad(String mailCiudadano, String nombreCiudadano, String ruc,String resultado,String razon, Boolean html) {
      String estado="",mensaje="",Proceso="";
    	 if(resultado=="activada") {
    		 mensaje="activación de Autoridades";
    		 estado="Usted ha sido Activado/a exitosamente en el ";
    		 Proceso="Proceda a llenar su informe  en el sistema informático, de acuerdo al cronograma establecido en el Reglamento de Rendición de Cuentas";
        }else if(resultado=="negada") {
        	mensaje="NEGACIÓN DE REGISTRO DE AUTORIDADES";
      		 estado="Su registro ha sido negado, debido al siguiente detalle: "+razon;
      		 Proceso="Por favor, vuelva al modulo del registro y complete nuevamente el formulario asignado";
        }
    	 String subject = "notificación de "+mensaje+" en el "+Constantes.NOMBRE_MODULO_MINUSCULA+"";
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
              "      <tr><td colspan=\"2\" class='cuerpoDestinatarioMail familiaLetra'><b>Estimado(a): "+nombreCiudadano+"</b>,</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Cédula:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+ruc+"</td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>"+estado+Constantes.NOMBRE_MODULO_MINUSCULA+". "+Constantes.fechaRegistroEmail()+" </td></tr>\r\n" +  
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>"+Proceso+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Recuerde que cada usuario es responsable del manejo de sus credenciales de acceso del Sistema.</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoPieMail familiaLetra'>Saludos cordiales,<br>"+Constantes.NOMBRE_INSTITUCION_SIGLAS+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='pieMail familiaLetra'><b>Nota: </b>"+ Constantes.NOTA_CORREOS_SISTEMA +"<b> "+Constantes.URL_DIRECTORIO_ASITENCIAS_TECNICAS+"</b>\r\n" + 
              "      </td></tr>\r\n" + 
              "    </table>\r\n" + 
              "  </body>\r\n" + 
              "</html>";
          
          MimeMessagePreparator messagePreparator = mimeMessage -> {
               MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
               messageHelper.setFrom(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setTo(mailCiudadano);
               messageHelper.setBcc(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setSubject(subject);
               messageHelper.setText(text, html);
          };
          try{
               emailSender.send(messagePreparator);
          } catch (MailException e){
        	  System.out.print(e);
          }
     }
     
     
     @Override //ok
     public void mailFinalziarInforme(String mailCiudadano, String nombreCiudadano, String ruc,Date fechaFin,String razon, String tipo, Boolean html) {
    	 String estado="",mensaje="",Proceso="";
    	 if (tipo.equals("AutoridadFinInformeRC")){
    		 mensaje="Informe de Autoridades Finalizado";
    		 Proceso="Guarde el informe en formato pdf, este será su respaldo de haber culminado el proceso de rendición de cuentas.";
    	 }else {
    		 mensaje="Informe de Fin de Gestión Autoridades Finalizado";
    		 Proceso="Guarde el informe en formato pdf, este será su respaldo de haber culminado el proceso de fin de gestión rendición de cuentas.";
    	 }   	    		 
    		 estado="Informe finalizado exitosamente en el ";    		 
    	 String subject = "notificación de "+mensaje+" en el "+Constantes.NOMBRE_MODULO_MINUSCULA+"";
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
              "      <tr><td colspan=\"2\" class='cuerpoDestinatarioMail familiaLetra'><b>Estimado(a): "+nombreCiudadano+"</b>,</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Cédula:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+ruc+"</td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoDestinatarioMail familiaLetra'><b>Estado del informe: FINALIZADO "+razon+"</b>,</td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>"+estado+Constantes.NOMBRE_MODULO_MINUSCULA+". "+ fechaFin +" </td></tr>\r\n" +  
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>"+Proceso+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Recuerde que cada usuario es responsable del manejo de sus credenciales de acceso del Sistema.</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoPieMail familiaLetra'>Saludos cordiales,<br>"+Constantes.NOMBRE_INSTITUCION_SIGLAS+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='pieMail familiaLetra'><b>Nota: </b>"+ Constantes.NOTA_CORREOS_SISTEMA +"<b> "+Constantes.URL_DIRECTORIO_ASITENCIAS_TECNICAS+"</b>\r\n" + 
              "      </td></tr>\r\n" + 
              "    </table>\r\n" + 
              "  </body>\r\n" + 
              "</html>";
          
          MimeMessagePreparator messagePreparator = mimeMessage -> {
               MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
               messageHelper.setFrom(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setTo(mailCiudadano);
               messageHelper.setBcc(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setSubject(subject);
               messageHelper.setText(text, html);
          };
          try{
               emailSender.send(messagePreparator);
          } catch (MailException e){
        	  System.out.print(e);
          }
     }
     
     
     @Override //ok
     public void mailFinalziarInformeInstitucion(String mailCiudadano, String nombreCiudadano, String ruc, String nombreInstitucion, Date fechaFin, String razon, Boolean html) {
      String estado="",mensaje="",Proceso="";
    		 mensaje="Informe de Institución Finalizado";
    		 estado="Informe finalizado exitosamente en el ";
    		 Proceso="Guarde el informe en formato pdf, este será su respaldo de haber culminado el proceso de rendición de cuentas.";
    	 String subject = "notificación de "+mensaje+" en el "+Constantes.NOMBRE_MODULO_MINUSCULA+"";
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
              "      <tr><td colspan=\"2\" class='cuerpoDestinatarioMail familiaLetra'><b>Estimado(a): "+nombreCiudadano+"</b>,</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Ruc:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+ruc+"</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Institución:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+nombreInstitucion+"</td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoDestinatarioMail familiaLetra'><b>Estado del informe: FINALIZADO "+razon+"</b>,</td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>"+estado+Constantes.NOMBRE_MODULO_MINUSCULA+". "+ fechaFin +" </td></tr>\r\n" +  
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>"+Proceso+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Recuerde que cada usuario es responsable del manejo de sus credenciales de acceso del Sistema.</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoPieMail familiaLetra'>Saludos cordiales,<br>"+Constantes.NOMBRE_INSTITUCION_SIGLAS+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='pieMail familiaLetra'><b>Nota: </b>"+ Constantes.NOTA_CORREOS_SISTEMA +"<b> "+Constantes.URL_DIRECTORIO_ASITENCIAS_TECNICAS+"</b>\r\n" + 
              "      </td></tr>\r\n" + 
              "    </table>\r\n" + 
              "  </body>\r\n" + 
              "</html>";
          
          MimeMessagePreparator messagePreparator = mimeMessage -> {
               MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
               messageHelper.setFrom(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setTo(mailCiudadano);
               messageHelper.setBcc(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setSubject(subject);
               messageHelper.setText(text, html);
          };
          try{
               emailSender.send(messagePreparator);
          } catch (MailException e){
        	  System.out.print(e);
          }
     }
     
     @Override //ok
     public void mailRegistroIntitucionResponbles(String mailCiudadano, String nombreCiudadano,String nombreinstitucion, Boolean html) {
        
          String subject = "notificación de registro en el "+Constantes.NOMBRE_MODULO_MINUSCULA+"";
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
               "      <tr><td colspan=\"2\" class='cuerpoDestinatarioMail familiaLetra'><b>Estimado(a): "+nombreCiudadano+"</b>,</td></tr>\r\n" +
               "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Institución:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+nombreinstitucion+"</td></tr>\r\n" +
               "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Su institución ha sido registrada exitosamente en el "+Constantes.NOMBRE_MODULO_MINUSCULA+", "+Constantes.fechaRegistroEmail()+". </td></tr>\r\n" +
               "      <tr><td colspan=\"2\" class='cuerpoPieMail familiaLetra'>Saludos cordiales,<br>"+Constantes.NOMBRE_INSTITUCION_SIGLAS+"</td></tr>\r\n" + 
               "      <tr><td colspan=\"2\" class='pieMail familiaLetra'><b>Nota: </b>"+ Constantes.NOTA_CORREOS_SISTEMA +"<b> "+Constantes.URL_DIRECTORIO_ASITENCIAS_TECNICAS+"</b>\r\n" + 
               "      </td></tr>\r\n" + 
               "    </table>\r\n" + 
               "  </body>\r\n" + 
               "</html>";
          
          MimeMessagePreparator messagePreparator = mimeMessage -> {
               MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
               messageHelper.setFrom(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setTo(mailCiudadano);
               messageHelper.setBcc(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setSubject(subject);
               messageHelper.setText(text, html);
          };
          try{
               emailSender.send(messagePreparator);
          } catch (MailException e){
          }
     }

     @Override //ok
     public void mailReseteoclavePerfil(String mailUsuario, String NombreResponRegis,String Nuevopass, Boolean html) {
        
    	 String subject = "notificación de cambio de clave en el "+Constantes.NOMBRE_MODULO_MINUSCULA+"";
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
              "      <tr><td colspan=\"2\" class='cuerpoDestinatarioMail familiaLetra'><b>Estimado(a): "+NombreResponRegis+"</b>,</td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Confirmamos que usted solicituto cambio de contraseña en el "+Constantes.NOMBRE_MODULO_MINUSCULA+". "+Constantes.fechaRegistroEmail()+" </td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Para acceder el sistema informático, por favor, ingresar con su nueva usuario o contraseña.</td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>A continuación, sus datos de usuario:</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Usuario:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+mailUsuario+"</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Contraseña:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+Nuevopass+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Recuerde que cada usuario es responsable del manejo de sus credenciales de acceso del Sistema.</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoPieMail familiaLetra'>Saludos cordiales,<br>"+Constantes.NOMBRE_INSTITUCION_SIGLAS+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='pieMail familiaLetra'><b>Nota: </b>"+ Constantes.NOTA_CORREOS_SISTEMA +"<b> "+Constantes.URL_DIRECTORIO_ASITENCIAS_TECNICAS+"</b>\r\n" + 
              "      </td></tr>\r\n" + 
              "    </table>\r\n" + 
              "  </body>\r\n" + 
              "</html>";
          
          MimeMessagePreparator messagePreparator = mimeMessage -> {
               MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
               messageHelper.setFrom(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setTo(mailUsuario);
               messageHelper.setBcc(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setSubject(subject);
               messageHelper.setText(text, html);
          };
          try{
               emailSender.send(messagePreparator);
          } catch (MailException e){
          }
     }
     
     @Override //ok
     public void mailCreacionPerfil(String mailUsuario, String NombreResponRegis,String Nuevopass, Boolean html) {
        
    	 String subject = "notificación de cambio de clave en el "+Constantes.NOMBRE_MODULO_MINUSCULA+"";
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
              "      <tr><td colspan=\"2\" class='cuerpoDestinatarioMail familiaLetra'><b>Estimado(a): "+NombreResponRegis+"</b>,</td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Confirmamos la creacion de superfil en el "+Constantes.NOMBRE_MODULO_MINUSCULA+". "+Constantes.fechaRegistroEmail()+" </td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Para acceder el sistema informático, por favor, ingresar su usuario y contraseña.</td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>A continuación, sus datos de usuario:</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Usuario:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+mailUsuario+"</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Contraseña:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+Nuevopass+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Recuerde que cada usuario es responsable del manejo de sus credenciales de acceso del Sistema.</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoPieMail familiaLetra'>Saludos cordiales,<br>"+Constantes.NOMBRE_INSTITUCION_SIGLAS+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='pieMail familiaLetra'><b>Nota: </b>"+ Constantes.NOTA_CORREOS_SISTEMA +"<b> "+Constantes.URL_DIRECTORIO_ASITENCIAS_TECNICAS+"</b>\r\n" + 
              "      </td></tr>\r\n" + 
              "    </table>\r\n" + 
              "  </body>\r\n" + 
              "</html>";
          
          MimeMessagePreparator messagePreparator = mimeMessage -> {
               MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
               messageHelper.setFrom(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setTo(mailUsuario);
               messageHelper.setBcc(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setSubject(subject);
               messageHelper.setText(text, html);
          };
          try{
               emailSender.send(messagePreparator);
          } catch (MailException e){
          }
     }

     
     @Override //ok
     public void mailAperturaInformeInstitucion(String mailResponable, String nombre, String cargo, String nombreinstitucion, String Ruc, Date FechaApertura, Boolean html) {
      String estado="",mensaje="",Proceso="";
      mensaje=" Apertura de Informe ";
      estado=" Confirmamos que su informe ha sido habilitado en el ";
      Proceso="Proceda con la corrección de su informe el sistema informático y recuerde finalizar su informe dentro del plazo establecido para su sector. De lo contrario, quedará como incumplido según lo dispuesto por el Reglamento de Rendición de Cuentas del proceso vigente.";
    
    	 String subject = "notificación de "+mensaje+" en el "+Constantes.NOMBRE_MODULO_MINUSCULA+"";
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
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Cargo:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+cargo+"</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Institución:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+nombreinstitucion+"</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>RUC:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+Ruc+"</td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>"+estado+Constantes.NOMBRE_MODULO_MINUSCULA+" el. "+FechaApertura+" </td></tr>\r\n" +  
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>"+Proceso+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Recuerde que cada usuario es responsable del manejo de sus credenciales de acceso del Sistema.</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoPieMail familiaLetra'>Saludos cordiales,<br>"+Constantes.NOMBRE_INSTITUCION_SIGLAS+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='pieMail familiaLetra'><b>Nota: </b>"+ Constantes.NOTA_CORREOS_SISTEMA +"<b> "+Constantes.URL_DIRECTORIO_ASITENCIAS_TECNICAS+"</b>\r\n" + 
              "      </td></tr>\r\n" + 
              "    </table>\r\n" + 
              "  </body>\r\n" + 
              "</html>";
          
          MimeMessagePreparator messagePreparator = mimeMessage -> {
               MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
               messageHelper.setFrom(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setTo(mailResponable);
               messageHelper.setBcc(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setSubject(subject);
               messageHelper.setText(text, html);
          };
          try{
               emailSender.send(messagePreparator);
          } catch (MailException e){
        	  System.out.print(e);
          }
     }
     
     @Override //ok
     public void mailAperturaInformeAutoridad(String mailResponable, String nombre, String cargo, String nombreinstitucion, String Ruc, Date FechaApertura, Boolean html) {
      String estado="",mensaje="",Proceso="";
      mensaje=" Apertura de Informe ";
      estado=" Confirmamos que su informe ha sido habilitado en el ";
      Proceso="Proceda con la corrección de su informe el sistema informático y recuerde finalizar su informe dentro del plazo establecido para su sector. De lo contrario, quedará como incumplido según lo dispuesto por el Reglamento de Rendición de Cuentas del proceso vigente.";
    
    	 String subject = "notificación de "+mensaje+" en el "+Constantes.NOMBRE_MODULO_MINUSCULA+"";
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
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Cédula:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+Ruc+"</td></tr>\r\n" +
              "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Dignidad:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+nombreinstitucion+"</td></tr>\r\n" +
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>"+estado+Constantes.NOMBRE_MODULO_MINUSCULA+" el. "+FechaApertura+" </td></tr>\r\n" +  
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>"+Proceso+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>Recuerde que cada usuario es responsable del manejo de sus credenciales de acceso del Sistema.</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='cuerpoPieMail familiaLetra'>Saludos cordiales,<br>"+Constantes.NOMBRE_INSTITUCION_SIGLAS+"</td></tr>\r\n" + 
              "      <tr><td colspan=\"2\" class='pieMail familiaLetra'><b>Nota: </b>"+ Constantes.NOTA_CORREOS_SISTEMA +"<b> "+Constantes.URL_DIRECTORIO_ASITENCIAS_TECNICAS+"</b>\r\n" + 
              "      </td></tr>\r\n" + 
              "    </table>\r\n" + 
              "  </body>\r\n" + 
              "</html>";
          
          MimeMessagePreparator messagePreparator = mimeMessage -> {
               MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
               messageHelper.setFrom(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setTo(mailResponable);
               messageHelper.setBcc(Constantes.EMAIL_NOTIFICACION);
               messageHelper.setSubject(subject);
               messageHelper.setText(text, html);
          };
          try{
               emailSender.send(messagePreparator);
          } catch (MailException e){
        	  System.out.print(e);
          }
     }
     
     public void mailNotificacionTecnico(String mailTecnico, String nombreTecnico,  String nombreinstitucion, String Ruc, Date FechaApertura, Boolean html) {
         String estado="",mensaje="",Proceso="";
         mensaje=" Apertura de Informe ";
         estado=" Confirmamos que usted realizó la aprobación/apertura de un informe en el  ";
         Proceso="Recuerde guardar los respaldos necesarios de está acción y que cada usuario es responsable del manejo de sus credenciales de acceso del Sistema.";
       
       	 String subject = "notificación de "+mensaje+" en el "+Constantes.NOMBRE_MODULO_MINUSCULA+"";
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
                 "      <tr><td colspan=\"2\" class='cuerpoDestinatarioMail familiaLetra'><b>Estimado(a): "+nombreTecnico+"</b>,</td></tr>\r\n" +
                 "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>Institución:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+nombreinstitucion+"</td></tr>\r\n" +
                 "      <tr><td class='cuerpoDatosColUnaMail familiaLetra'>RUC:</td><td class='cuerpoDatosColDosMail familiaLetra'>"+Ruc+"</td></tr>\r\n" +
                 "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>"+estado+Constantes.NOMBRE_MODULO_MINUSCULA+" el. "+FechaApertura+" </td></tr>\r\n" +  
                 "      <tr><td colspan=\"2\" class='cuerpoMail familiaLetra'>"+Proceso+"</td></tr>\r\n" + 
                 "      <tr><td colspan=\"2\" class='cuerpoPieMail familiaLetra'>Saludos cordiales,<br>"+Constantes.NOMBRE_INSTITUCION_SIGLAS+"</td></tr>\r\n" + 
                 "      <tr><td colspan=\"2\" class='pieMail familiaLetra'><b>Nota: </b>"+ Constantes.NOTA_CORREOS_SISTEMA +"<b> "+Constantes.URL_DIRECTORIO_ASITENCIAS_TECNICAS+"</b>\r\n" + 
                 "      </td></tr>\r\n" + 
                 "    </table>\r\n" + 
                 "  </body>\r\n" + 
                 "</html>";
             
             MimeMessagePreparator messagePreparator = mimeMessage -> {
                  MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                  messageHelper.setFrom(Constantes.EMAIL_NOTIFICACION);
                  messageHelper.setTo(mailTecnico);
                  messageHelper.setBcc(Constantes.EMAIL_NOTIFICACION);
                  messageHelper.setSubject(subject);
                  messageHelper.setText(text, html);
             };
             try{
                  emailSender.send(messagePreparator);
             } catch (MailException e){
           	  System.out.print(e);
             }
        }
}
