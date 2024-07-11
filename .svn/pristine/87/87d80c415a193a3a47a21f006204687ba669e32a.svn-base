package gob.cpccs.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import gob.cpccs.utilidades.Constantes;

/**
 * Controlador FileUploadController
 *
 * Este archivo contiene métodos para el controlador FileUploadController
 * 
 * @version 1.0
 * @copyright : Copyright (C) 2019 CPCCS. Todos los derechos reservados
 * @author Carlos Anchundia
 * @email e.du.ingcharles@hotmail.com
 * @date 01/02/2019, 11:16:39
 * @document FileUploadController
 * @package gob.cpccs.controller
 * @subpackage
 * 
 */

@Controller
public class FileUploadController {


     @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
     public @ResponseBody String fileUpload(@RequestParam("file") MultipartFile file,
          @RequestParam("identificador") String identificador,
          @RequestParam("rutaCarpeta") String rutaCarpeta, @RequestParam("tamanio") String tamanio) {
          String nombreArchivo = file.getOriginalFilename();
          String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1);
          nombreArchivo = identificador + "." + extension;

          if (!file.getOriginalFilename().isEmpty()){
               try{
                    Date fechaActual = new Date();
                    DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");

                    Boolean cumpleTamanio = false;
                    Integer tamanoMaximo = 0;

                    // tamanio*1024*1024
                    if (tamanio.equals("1MB")){
                         tamanoMaximo = 1048576;
                    } else if (tamanio.equals("2MB")){
                         tamanoMaximo = 2097152;
                    } else if (tamanio.equals("3MB")){
                         tamanoMaximo = 3145728;
                    } else if (tamanio.equals("4MB")){
                         tamanoMaximo = 4194304;
                    } else if (tamanio.equals("5MB")){
                         tamanoMaximo = 5242880;
                    }
                    else if (tamanio.equals("25MB")){
                         tamanoMaximo = 26214400;
                    }
                    else if (tamanio.equals("50MB")){
                         tamanoMaximo = 52428800;
                    }

                    if (file.getSize() <= tamanoMaximo){
                         cumpleTamanio = true;
                    }

                    String rutaFisica = Constantes.RUTA_ARCHIVOS_APLICACION + rutaCarpeta + formatoFecha.format(fechaActual);
                    File dir = new File(rutaFisica);
                    if (!dir.exists())
                         if (dir.mkdirs()){
                            System.out.println("El directorio ha sido creado con exito!");
                         } else{
                              System.out.println("Fallo al crear el directorio!");
                              cumpleTamanio = false;
                         }

                    if (cumpleTamanio){
                         BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(dir, nombreArchivo)));
                         outputStream.write(file.getBytes());
                         outputStream.flush();
                         outputStream.close();
                         return rutaCarpeta + formatoFecha.format(fechaActual) + "/" + nombreArchivo;
                    } else{
                         return "tamaño de archivo superado";
                    }
               } catch (IOException e){
                    e.printStackTrace();
                    return "No has podido subir el archivo.";
               }
          } else{
               return "El archivo se encuentra vacio.";
          }
     }
     @RequestMapping(value = "/fileUploadQuipux", method = RequestMethod.POST)
     public @ResponseBody String fileUploadQuipux(@RequestParam("file") MultipartFile file,
          @RequestParam("identificador") String identificador,
          @RequestParam("rutaCarpeta") String rutaCarpeta, @RequestParam("tamanio") String tamanio,@RequestParam("area") String area,@RequestParam("areapadre") String areapadre) {
          String nombreArchivo = file.getOriginalFilename();
          String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1);
          nombreArchivo = identificador + "." + extension;

          if (!file.getOriginalFilename().isEmpty()){
               try{
                    Date fechaActual = new Date();
                    DateFormat formatoFecha = new SimpleDateFormat("yyyy");

                    Boolean cumpleTamanio = false;
                    Integer tamanoMaximo = 0;

                    // tamanio*1024*1024
                    if (tamanio.equals("1MB")){
                         tamanoMaximo = 1048576;
                    } else if (tamanio.equals("2MB")){
                         tamanoMaximo = 2097152;
                    } else if (tamanio.equals("3MB")){
                         tamanoMaximo = 3145728;
                    } else if (tamanio.equals("4MB")){
                         tamanoMaximo = 4194304;
                    } else if (tamanio.equals("5MB")){
                         tamanoMaximo = 5242880;
                    }
                    else if (tamanio.equals("25MB")){
                         tamanoMaximo = 26214400;
                                       
                    }

                    if (file.getSize() <= tamanoMaximo){
                         cumpleTamanio = true;
                    }

                    String rutaFisica = Constantes.RUTA_ARCHIVOS_APLICACION + rutaCarpeta+areapadre+"/"+formatoFecha.format(fechaActual)+"/"+area;
                    File dir = new File(rutaFisica);
                    if (!dir.exists())
                         if (dir.mkdirs()){
                            System.out.println("El directorio ha sido creado con exito!");
                         } else{
                              System.out.println("Fallo al crear el directorio!");
                              cumpleTamanio = false;
                         }

                    if (cumpleTamanio){
                         BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(dir, nombreArchivo)));
                         outputStream.write(file.getBytes());
                         outputStream.flush();
                         outputStream.close();
                         return rutaCarpeta  +areapadre+"/"+ formatoFecha.format(fechaActual)+"/"+area+"/"+ nombreArchivo;
                    } else{
                         return "tamaño de archivo superado";
                    }
               } catch (IOException e){
                    e.printStackTrace();
                    return "No has podido subir el archivo.";
               }
          } else{
               return "El archivo se encuentra vacio.";
          }
     }
     @RequestMapping(value = "/fileUploaddelete", method = RequestMethod.POST)
     public @ResponseBody String fileUploaddelete(@RequestParam("file") String file) {    	     	 
          String nombreArchivo = file;
          File archivo =new File(Constantes.RUTA_ARCHIVOS_APLICACION+nombreArchivo);
          if (archivo.delete())
               return   "El fichero ha sido borrado satisfactoriamente";
            else
                 return "El fichero no puede ser borrado";
     }
}
