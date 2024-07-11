package gob.cpccs.utilidades.jdbcConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConexion {

     public Connection  getConnection()   {
          try { 
               Class.forName("org.postgresql.Driver");
           } catch (ClassNotFoundException ex) {
               System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
           }
          
          Connection connection = null;
        
     
         try{
          connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cpccsdb","usercpccs", "CpCcS#19*");
    
          boolean valid = connection.isValid(50000);
          System.out.println(valid ? "CONEXION OK" : "CONEXION FALLO");
         } catch (SQLException e){
          // TODO Auto-generated catch block
          e.printStackTrace();
     }
         
         
         
         
         return connection;
              
     }
}
