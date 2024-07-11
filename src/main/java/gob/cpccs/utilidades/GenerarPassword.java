package gob.cpccs.utilidades;

import java.util.Random;

public class GenerarPassword {
     
     public static String NUMEROS = "0123456789";
     
     public  static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
     public static  String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    
     public static String ESPECIALES = "#$@!%*.?&";
    
     public  String getPinNumber() {
       return getPassword(NUMEROS, 4);
     }
    
     public  String getPassword() {
       return getPassword(8);
     }
    
     public String getPassword(int length) {
       return getPassword(NUMEROS + MINUSCULAS, length);
     }
    
     public static String getPassword(String key, int length) {
       String pswd = "";
    
       for (int i = 0; i < length; i++) {
         pswd+=(key.charAt((int)(Math.random() * key.length())));
       }
    
       return pswd;
     }
     
     public static String restablecerContrasenia() {
          String key= getPassword(NUMEROS,2)+getPassword(MINUSCULAS,5);
          
          Random r = new Random();
          char[] pswd = key.toCharArray();
          for (int i=0; i<pswd.length; i++) {
               int posAleatoria = r.nextInt(pswd.length);
               char temp = pswd[i];
               pswd[i] = pswd[posAleatoria];
               pswd[posAleatoria] = temp;
           }
          
          return String.valueOf(pswd);
         
     }
     
}
