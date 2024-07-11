package gob.cpccs.utilidades;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class ValidaEmail {
   
     public boolean emailValida(String email) {
          boolean isValid = false;
          try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
            isValid = true;
          } catch (AddressException e) {
               e.printStackTrace();
           // System.out.println("Ocurrio una excepción para el mail: " + email);
          }
          return isValid;
        }

}
