package gob.cpccs.utilidades;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class ConsultaValidarIdentificacion {

       
     /**
      * @param número de cédula
      * @return true si es un documento v&aacutelido
      * @throws Exception
      */
     public static boolean validarCedula(String numero) throws Exception{   
           try {
             validarInicial(numero, 10);
               validarCodigoProvincia(numero.substring(0, 2));
               validarTercerDigito(String.valueOf(numero.charAt(2)), "cedula");
               algoritmoModulo10(numero, Integer.parseInt(String.valueOf(numero.charAt(9))));
           } catch (Exception e) {
             e.printStackTrace();
               return false; 
           }

           return true;
       }
     
     /**
      * @param numero de ruc persona natural
      * @return true si es un documento v&aacutelido
      * @throws Exception
      */
     public static boolean validarRucPersonaNatural(String numero) throws Exception{
           try {
               validarInicial(numero, 13);
               validarCodigoProvincia(numero.substring(0, 2));
               validarTercerDigito(String.valueOf(numero.charAt(2)), "ruc_natural");
               validarCodigoEstablecimiento(numero.substring(10, 13));
               algoritmoModulo10(numero.substring(0, 9), Integer.parseInt(String.valueOf(numero.charAt(9))));
           } catch (Exception e) {
               e.printStackTrace();
               return false; 
           }

           return true;
       }
     
     /**
      * 
      * @param numero ruc empresa privada
      * @return
      * @throws Exception
      */
     public static boolean validarRucSociedadPrivada(String numero) throws Exception{
       
           try {
               validarInicial(numero, 13);
               validarCodigoProvincia(numero.substring(0, 2));
               validarTercerDigito(String.valueOf(numero.charAt(2)), "ruc_privada");
               validarCodigoEstablecimiento(numero.substring(10, 13));
               algoritmoModulo11(numero.substring(0, 9), Integer.parseInt(String.valueOf(numero.charAt(9))), "ruc_privada");
           } catch (Exception e) {
               return false; 
           }

           return true;
       }
     
     public static boolean validarRucSociedadPublica(String numero) throws Exception{
          
          try {
              validarInicial(numero, 13);
              validarCodigoProvincia(numero.substring(0, 2));
              validarTercerDigito(String.valueOf(numero.charAt(2)), "ruc_publica");
              validarCodigoEstablecimiento(numero.substring(9, 13));
              algoritmoModulo11(numero.substring(0, 8), Integer.parseInt(String.valueOf(numero.charAt(8))), "ruc_publica");
            
          } catch (Exception e) {
              return false; 
          }

          return true;
      }
     
     /**
      * @param numero
      * @param caracteres
      * @return
      * @throws Exception
      */
     protected static boolean validarInicial(String numero, int caracteres) throws Exception {   
           if (StringUtils.isEmpty(numero)) {
               throw new Exception("Valor no puede estar vacio");
           }
           
           if (! NumberUtils.isDigits(numero)) {
               throw new Exception("Valor ingresado solo puede tener dígitos");
           }

           if (numero.length() != caracteres) {
               throw new Exception("Valor ingresado debe tener "+ caracteres + " caracteres");
           }

           return true;
       }
     
     /**
      * @param número en el rango de números de provincias del ecuador 
      * @return
      * @throws Exception
      */
     protected static boolean validarCodigoProvincia(String numero) throws Exception{
           if (Integer.parseInt(numero) < 0 || Integer.parseInt(numero) > 24) {
               throw new Exception("Codigo de Provincia (dos primeros dígitos) no deben ser mayor a 24 ni menores a 0");
           }
           
           return true;
       }
     
     /**
      * @param numero
      * @param tipo de documento cedula, ruc
      * @return
      * @throws Exception
      */
     protected static boolean validarTercerDigito(String numero, String tipo) throws Exception{
           switch (tipo) {
               case "cedula":
               case "ruc_natural":
                 
                   if (Integer.parseInt(numero) < 0 || Integer.parseInt(numero) > 5) {
                       
                       throw new Exception("Tercer dígito debe ser mayor o igual a 0 y menor a 6 para cédulas y RUC de persona natural ... permitidos de 0 a 5");
                   }
                   break;
               case "ruc_privada":
                   if (Integer.parseInt(numero) != 9) {
                       throw new Exception("Tercer dígito debe ser igual a 9 para sociedades privadas");
                   }
                   break;

               case "ruc_publica":
                   if (Integer.parseInt(numero) != 6) {
                       throw new Exception("Tercer dígito debe ser igual a 6 para sociedades públicas");
                   }
                   break;
               default:
                   throw new Exception("Tipo de Identificacion no existe.");
           }

           return true;
       }
     
     /**
      * @param digitosIniciales
      * @param digitoVerificador
      * @return
      * @throws Exception
      */
     protected static boolean algoritmoModulo10(String digitosIniciales, int digitoVerificador) throws Exception{
           Integer [] arrayCoeficientes = new Integer[]{2,1,2,1,2,1,2,1,2};
           
           Integer [] digitosInicialesTMP = new Integer[digitosIniciales.length()];
           int indice=0;
           for(char valorPosicion: digitosIniciales.toCharArray()){
             digitosInicialesTMP[indice] = NumberUtils.createInteger(String.valueOf(valorPosicion));
             indice++;
           }
           
           int total = 0;
           int key = 0;
           for(Integer valorPosicion: digitosInicialesTMP){
             if(key<arrayCoeficientes.length){
               valorPosicion = (digitosInicialesTMP[key] * arrayCoeficientes[key] );
               
               if (valorPosicion >= 10) {
                     char[] valorPosicionSplit = String.valueOf(valorPosicion).toCharArray();
                       valorPosicion = (Integer.parseInt(String.valueOf(valorPosicionSplit[0]))) + (Integer.parseInt(String.valueOf(valorPosicionSplit[1])));
                       
                   }
                   total = total + valorPosicion;
             }
               
               key++;
           }
           int residuo =  total % 10;
           int resultado ;

           if (residuo == 0) {
               resultado = 0;        
           } else {
               resultado = 10 - residuo;
           }

           if (resultado != digitoVerificador) {
              //  return false;
              throw new Exception("Dígitos iniciales no validan contra Dígito Identificador");
           }

           return true;
       }
     
     /**
      * @param numero
      * @return
      * @throws Exception
      */
     protected static boolean validarCodigoEstablecimiento(String numero) throws Exception{
           if (Integer.parseInt(numero) < 1) {
               throw new Exception("Código de establecimiento no puede ser 0");
           }
           return true;
       }
     
     protected static boolean algoritmoModulo11(String digitosIniciales, int digitoVerificador, String tipo) throws Exception {
          Integer[] coefArray = null;
          switch (tipo) {
               case "ruc_privada":
                  coefArray = new Integer[]{4, 3, 2, 7, 6, 5, 4, 3, 2};
                  break;
               case "ruc_publica":
                  coefArray = new Integer[]{3, 2, 7, 6, 5, 4, 3, 2};
                  break;
          }
          Integer[] tmpDigIniciales = new Integer[digitosIniciales.length()];
          int indice = 0;
          for (char valPos : digitosIniciales.toCharArray()) {
              tmpDigIniciales[indice] = NumberUtils.createInteger(String.valueOf(valPos));
              indice++;
          }
          int total = 0;
          int key = 0;
          for (Integer valPos : tmpDigIniciales) {
              if (key < coefArray.length) {
                  valPos = (tmpDigIniciales[key] * coefArray[key]);
                  total = total + valPos;
              }

              key++;
          }
          int residuo = total % 11;
          int valor;

          if (residuo == 0) {
              valor = 0;
          } else {
              valor = (11 - residuo);
          }

          if (valor != digitoVerificador) {
               throw new Exception("Dígitos iniciales no validan contra Dígito Idenficador");
          }

          return true;
      }
   
     public static boolean isNum(String dato) {
          boolean digitoDato = false;
          boolean letraDato = false;
          for (int i = 0; i < dato.length(); i++) {
              if (Character.isDigit(dato.charAt(i))) {
                  digitoDato = true;
              } else {
                  letraDato = true;
              }

          }
          return digitoDato && !letraDato;
      }

      public static boolean validarNumero(String dato) {
          boolean validado = false;
          try {
              @SuppressWarnings("unused")
          Integer numero = Integer.parseInt(dato);
              validado = true;
          } catch (Exception e) {
              try {
                  @SuppressWarnings("unused")
               Double numero = Double.parseDouble(dato);
                  validado = true;
              } catch (Exception ex) {

              }
          }
          return validado;
      }

      /**
       * Método para determinar si es solo texto
       *
       * @param dato
       * @return true si es solo texto y false si no lo es
       */
      public static boolean isTexto(String dato) {
          boolean digitoDato = false;
          boolean letraDato = false;
          for (int i = 0; i < dato.length(); i++) {
              if (Character.isDigit(dato.charAt(i))) {
                  digitoDato = true;
              } else {
                  letraDato = true;
              }

          }
          return !digitoDato && letraDato;
      }
     
}
