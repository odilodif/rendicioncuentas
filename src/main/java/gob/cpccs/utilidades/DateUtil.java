package gob.cpccs.utilidades;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
     private int year;
     private int pascuaMonth;
     @SuppressWarnings("unused")
     private int pascuaDay;
     private ArrayList<String> diasFestivos;

     public DateUtil() {
          Date date = new Date();
          DateFormat formatter = new SimpleDateFormat("yyyy");
          String anio = formatter.format(date);
          int year = Integer.parseInt(anio);
          this.year = year;
          this.diasFestivos = new ArrayList<String>();
          int a = year % 19;
          int b = year / 100;
          int c = year % 100;
          int d = b / 4;
          int e = b % 4;
          int g = (8 * b + 13) / 25;
          int h = (19 * a + b - d - g + 15) % 30;
          int j = c / 4;
          int k = c % 4;
          int m = (a + 11 * h) / 319;
          int r = (2 * e + 2 * j - k - h + m + 32) % 7;
          this.pascuaMonth = (h - m + r + 90) / 25;
          this.pascuaDay = (h - m + r + this.pascuaMonth + 19) % 32;
          this.pascuaMonth--;
          this.diasFestivos.add("0:1"); // Primero de Enero
          this.diasFestivos.add("4:1"); // Dia del trabajo 1 de mayo
          this.diasFestivos.add("4:24"); // Batalla del Pichincha 24 de mayo
          this.diasFestivos.add("11:25"); // Navidad 25 de diciembre
          this.diasFestivos.add("11:31"); // Fin de año 31 de diciembre

          this.calculateOtrosDiasFestivos(2, 4); // Carnaval 4 de marzo
          this.calculateOtrosDiasFestivos(2, 5); // Carnaval 5 de marzo
          this.calculateOtrosDiasFestivos(3, 19); // Viernes santos 19 de abril
          this.calculateOtrosDiasFestivos(7, 9); // Primer Grito de la Independencia trasladado al 9 de agosto
          this.calculateOtrosDiasFestivos(9, 11); // Independencia de Guayaquil trasladado al 11 de octubre
          this.calculateOtrosDiasFestivos(10, 1); // Día de los difuntos trasladado al 1 de noviembre
          this.calculateOtrosDiasFestivos(10, 4); // Independencia de Cuenca trasladado al 4 de noviembre

          // calculas - y + dias festivos de la fecha actual
          // this.calcularOtroFeriado(-3, false);//jueves santos
          // this.calcularOtroFeriado(-2, false);//viernes santo
          // this.calcularOtroFeriado(36, true);//Asención del señor de pascua
          // this.calcularOtroFeriado(60, true);//Corpus cristi
          // this.calcularOtroFeriado(68, true);//Sagrado corazon

     }

     private void calculateOtrosDiasFestivos(int month, int day) {
          Calendar date = Calendar.getInstance();
          date.set(this.year, month, day);
          int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
          switch (dayOfWeek) {
               case 1:
                    date.add(Calendar.DATE, 1);
               break;
               case 3:
                    date.add(Calendar.DATE, 6);
               break;
               case 4:
                    date.add(Calendar.DATE, 5);
               break;
               case 5:
                    date.add(Calendar.DATE, 4);
               break;
               case 6:
                    date.add(Calendar.DATE, 3);
               break;
               case 7:
                    date.add(Calendar.DATE, 2);
               break;
          }
          this.diasFestivos.add(date.get(Calendar.MONTH) + ":" + date.get(Calendar.DATE));

     }

     @SuppressWarnings("unused")
     private void calcularOtroFeriado(int days, boolean religioso) {
          Calendar date = Calendar.getInstance();
          // día de pascua
          // date.set(this.year, this.pascuaMonth, this.pascuaDay);
          date.add(Calendar.DATE, days);

          if (religioso){
               this.calculateOtrosDiasFestivos(date.get(Calendar.MONTH), date.get(Calendar.DATE));
          } else{
               this.diasFestivos.add(date.get(Calendar.MONTH) + ":" + date.get(Calendar.DATE));
          }
     }

     public boolean esDiaFestivo(int month, int day) {
          return this.diasFestivos.contains(month + ":" + day);
     }

     public int getYear() {
          return year;
     }

     public int obtenerDiasLaborables(Date startDate, Date endDate) throws ParseException {
          
          Calendar startCal = Calendar.getInstance();
          startCal.setTime(startDate);

          Calendar endCal = Calendar.getInstance();
          endCal.setTime(endDate);
          int diaTrabajo = 0;

          // Return 0 if start and end are the same
          SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
          String fechaActual = formatter.format(endDate);
          String fechaInicio = formatter.format(startDate);
          Date dateStart1 = formatter.parse(fechaInicio);
          Date dateEnd1 = formatter.parse(fechaActual);
        
          if (dateStart1.getTime() == dateEnd1.getTime()){
               diaTrabajo = 0;
          } else{
               DateUtil dateUtil = new DateUtil();
               do{
                    // excluding start date
                    startCal.add(Calendar.DAY_OF_MONTH, 1);
                    if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
                         && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
                         && !dateUtil.esDiaFestivo(startCal.get(Calendar.MONTH), startCal.get(Calendar.DATE))){
                         ++diaTrabajo;
                    }
               } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); // excluding end date
          }
          return diaTrabajo;
     }

     public static int obtenerDiasSinFinSemana(Date startDate, Date endDate) {
          
          Calendar startCal = Calendar.getInstance();
          startCal.setTime(startDate);
          Calendar endCal = Calendar.getInstance();
          endCal.setTime(endDate);
          int diaTrabajo = 0;

          if (startCal.getTimeInMillis() != endCal.getTimeInMillis()){
               do{
                    // excluding start date
                    startCal.add(Calendar.DAY_OF_MONTH, 1);
                    if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
                         && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
                         ++diaTrabajo;
                    }
               } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); // excluding end date
          }
          return diaTrabajo;
     }

     public static int obtenerDiasConFinSemana(Date startDate, Date endDate) {
        
          Calendar startCal = Calendar.getInstance();
          startCal.setTime(startDate);

          Calendar endCal = Calendar.getInstance();
          endCal.setTime(endDate);
          int diaTrabajo = 0;

          if (startCal.getTimeInMillis() != endCal.getTimeInMillis()){
               do{
                    // excluding start date
                    startCal.add(Calendar.DAY_OF_MONTH, 1);
                    ++diaTrabajo;
               } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); // excluding end date

          }

          return diaTrabajo;
     }

     public static Date obtenerSiguienteFechaLaborableConDias(Date startDate, int diaTrabajo) {

          Calendar startCal = Calendar.getInstance();
          startCal.setTime(startDate);
          DateUtil dateUtil = new DateUtil();
          while (diaTrabajo > 0){
               if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
                    && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && !dateUtil.esDiaFestivo(startCal.get(Calendar.MONTH), startCal.get(Calendar.DATE))){
                    diaTrabajo--;
               }
               startCal.add(Calendar.DATE, 1);
          }
          return startCal.getTime();
     }

     public String sumarRestarDiasFecha(String fecha, int dias) {
          Calendar calendar = Calendar.getInstance();
          SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
          Date fechaR = null;
          try{
               fechaR = formatter.parse(fecha);
          } catch (ParseException e){
               e.printStackTrace();
          }
          calendar.setTime(fechaR); // Configuramos la fecha que se recibe
          calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de días a añadir, o restar en caso de días<0

          return formatter.format(calendar.getTime()); // Devuelve el objeto Date con los nuevos días añadidos
     }
     
     public Date convertirFecha(String strFecha) {
          SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
          Date fechaDate = null;
          try {
              if (strFecha != null) {
                  fechaDate = formato.parse(strFecha);
              }
          } catch (ParseException ex) {
          }
          return fechaDate;
      }

}
