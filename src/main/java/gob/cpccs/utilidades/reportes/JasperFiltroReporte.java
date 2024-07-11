package gob.cpccs.utilidades.reportes;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class JasperFiltroReporte {

     private String reportFileName;

     private JasperReport jasperReport;

     private JasperPrint jasperPrint;
     private HttpServletRequest request;

     private String rutaArchivoNuevo;
     private String tituloArchivo;
     private String tipoDocumentoExportar;
     private String logoReporte;
     
     private JRBeanCollectionDataSource jRBeanCollectionDataSource;
     
     public JRBeanCollectionDataSource getJRBeanCollectionDataSource() {
          return jRBeanCollectionDataSource;
     }

     public void setJRBeanCollectionDataSource(JRBeanCollectionDataSource jRBeanCollectionDataSource) {
          this.jRBeanCollectionDataSource = jRBeanCollectionDataSource;
     }

     public String getLogoReporte() {
          return logoReporte;
     }

     public void setLogoReporte(String logoReporte) {
          this.logoReporte = logoReporte;
     }

     public String getTipoDocumentoExportar() {
          return tipoDocumentoExportar;
     }

     public void setTipoDocumentoExportar(String tipoDocumentoExportar) {
          this.tipoDocumentoExportar = tipoDocumentoExportar;
     }

     public String getTituloArchivo() {
          return tituloArchivo;
     }

     public void setTituloArchivo(String tituloArchivo) {
          this.tituloArchivo = tituloArchivo;
     }

     public String getRutaArchivoNuevo() {
          return rutaArchivoNuevo;
     }

     public void setRutaArchivoNuevo(String rutaArchivoNuevo) {
          this.rutaArchivoNuevo = rutaArchivoNuevo;
     }

     @Autowired
     private DataSource dataSource;



     /*
      * public JdbcConexion getConnection() { return connection; }
      * 
      * public void setConnection(JdbcConexion connection) { this.connection = connection; }
      */

     private Map<String, Object> parameters;

     public JasperFiltroReporte() {
          parameters = new HashMap<>();
     }

     public HttpServletRequest getRequest() {
          return request;
     }

     public void setRequest(HttpServletRequest request) {
          this.request = request;
     }

     public void prepareReport() {
          compileReport();
          fillReportDataSource();
     }


     // ***************** parametros para esta funcion jasper sin conexion genera pdf*******************************
     /*
      *JasperFiltroReporte simpleReportFilter= new JasperFiltroReporte();
         simpleReportFilter.setRequest(request);
         simpleReportFilter.setReportFileName("/WEB-INF/vistas/prueba/reporte/report3.jrxml");
         Map<String, Object> parameter = new HashMap<>();
         //parameter.put("dos", 2);
         //simpleReportFilter.setParameters(parameter);
         simpleReportFilter.setRutaArchivoNuevo("holla.PDF");
         simpleReportFilter.setTituloArchivo("Documento pdf de prueba");
         simpleReportFilter.setTipoDocumentoExportar("PDF");
         simpleReportFilter.setLogoReporte("defecto");
         simpleReportFilter.generarReporteJasperSinConexion();
    */
     public void generarReporteJasperSinConexion() {
          compileReport();
          fillReportSinConexion();
          JasperExportarReporte jasperExportarReporte = new JasperExportarReporte();
          jasperExportarReporte.setJasperPrint(this.getJasperPrint());
          switch (tipoDocumentoExportar) {
               case "PDF":
                    jasperExportarReporte.exportToPdf(rutaArchivoNuevo, tituloArchivo);
               break;
               case "XLSX":
                    jasperExportarReporte.exportToXlsx(rutaArchivoNuevo, tituloArchivo);
               break;
               case "CSV":
                    jasperExportarReporte.exportToCsv(rutaArchivoNuevo);
               break;
               case "HTML":
                    jasperExportarReporte.exportToHtml(rutaArchivoNuevo);
               break;
               default:

          }

     }

     // ***************** parametros para esta funcion jasper con conexion genera pdf*******************************
     /*
       *JasperFiltroReporte simpleReportFilter= new JasperFiltroReporte();
      simpleReportFilter.setRequest(request);
      simpleReportFilter.setReportFileName("/WEB-INF/vistas/prueba/reporte/report3.jrxml");
      Map<String, Object> parameter = new HashMap<>();
      //parameter.put("dos", 2);
      //simpleReportFilter.setParameters(parameter);
      simpleReportFilter.setRutaArchivoNuevo("holla.PDF");
      simpleReportFilter.setTituloArchivo("Documento pdf de prueba");
      simpleReportFilter.setTipoDocumentoExportar("PDF");
      simpleReportFilter.setLogoReporte("defecto");
      simpleReportFilter.generarReporteJasperConConexion();
    */
     public void generarReporteJasperConConexion() {
          compileReport();
          fillReportConConexion();
          JasperExportarReporte jasperExportarReporte = new JasperExportarReporte();
          jasperExportarReporte.setJasperPrint(this.getJasperPrint());
          switch (tipoDocumentoExportar) {
               case "PDF":
                    jasperExportarReporte.exportToPdf(rutaArchivoNuevo, tituloArchivo);
               break;
               case "XLSX":
                    jasperExportarReporte.exportToXlsx(rutaArchivoNuevo, tituloArchivo);
               break;
               case "CSV":
                    jasperExportarReporte.exportToCsv(rutaArchivoNuevo);
               break;
               case "HTML":
                    jasperExportarReporte.exportToHtml(rutaArchivoNuevo);
               break;
               default:

          }
     }
     
     public void generarReporteJasperSinConexionDataSource() {
          compileReport();
          fillReportDataSource();
          JasperExportarReporte jasperExportarReporte = new JasperExportarReporte();
          jasperExportarReporte.setJasperPrint(this.getJasperPrint());
          switch (tipoDocumentoExportar) {
               case "PDF":
                    jasperExportarReporte.exportToPdf(rutaArchivoNuevo, tituloArchivo);
               break;
               case "XLSX":
                    jasperExportarReporte.exportToXlsx(rutaArchivoNuevo, tituloArchivo);
               break;
               case "CSV":
                    jasperExportarReporte.exportToCsv(rutaArchivoNuevo);
               break;
               case "HTML":
                    jasperExportarReporte.exportToHtml(rutaArchivoNuevo);
               break;
               default:

          }
     }
     
     
     public void generarReporteFacturaJasperSinConexionDataSource() {
        
          compileReportFactura();
          fillReportDataSource();
          JasperExportarReporte jasperExportarReporte = new JasperExportarReporte();
          jasperExportarReporte.setJasperPrint(this.getJasperPrint());
          switch (tipoDocumentoExportar) {
               case "PDF":
                    jasperExportarReporte.exportToPdf(rutaArchivoNuevo, tituloArchivo);
               break;
               case "XLSX":
                    jasperExportarReporte.exportToXlsx(rutaArchivoNuevo, tituloArchivo);
               break;
               case "CSV":
                    jasperExportarReporte.exportToCsv(rutaArchivoNuevo);
               break;
               case "HTML":
                    jasperExportarReporte.exportToHtml(rutaArchivoNuevo);
               break;
               default:

          }
     }
     
     public void generarReporteFactura1JasperSinConexionDataSource( String Ruc_Institucion,  String Nombre_TIpoDocumento, String N_SecuencialFactura,
          String No_Autorizacion, String Fecha_Autorizacion, String Ambiente, String Estado_Emision, String Clave_Acceso,
          String Direccion_Matriz, String Direccion_Sucursal, String Obligacion_Contabilidad,
          String Nombres_Cliente, String Identificacion_Cliente, String FechaEmision_Cliente,
          String Direccion_cliente,String iva
          ,int[] Cant, int[] item , String[] Detalle, Double[] Precio,Double[] Valor_Venta) 
            {
          compileReportFactura();
      
         /* SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
          String fecha=formatter.format(matricula.getFechaMatricula());
          String fecha_nacimiento=formatter.format(fechanac);*/
         // Map<String, Object> registros = new HashMap<String, Object>();
          parameters.put("Ruc_Institucion", Ruc_Institucion);
          parameters.put("Nombre_TIpoDocumento", Nombre_TIpoDocumento);
          parameters.put("N_SecuencialFactura", N_SecuencialFactura);
          parameters.put("No_Autorizacion", No_Autorizacion);
          parameters.put("Fecha_Autorizacion", Fecha_Autorizacion);
          parameters.put("Ambiente", Ambiente);
          parameters.put("Estado_Emision", Estado_Emision);
          parameters.put("Clave_Acceso", Clave_Acceso);
          parameters.put("Direccion_Matriz", Direccion_Matriz);
          parameters.put("Direccion_Sucursal", Direccion_Sucursal);
          parameters.put("Obligacion_Contabilidad", Obligacion_Contabilidad);
          parameters.put("Nombres_Cliente", Nombres_Cliente);
          parameters.put("Identificacion_Cliente", Identificacion_Cliente);
          parameters.put("FechaEmision_Cliente", FechaEmision_Cliente);
          parameters.put("Direccion_cliente", Direccion_cliente);
          parameters.put("iva", iva);                     
          
          for (int i=0;i < item.length ; i++){ 
              
               parameters.put("Cant", (Cant[i]));
               parameters.put("Detalle", (Detalle[i]));
               parameters.put("Precio", (Precio[i]));
               parameters.put("Valor_Venta", (Valor_Venta[i]));   
              
          }
             
        
          this.setParameters(parameters);
          fillReportDataSource();
          JasperExportarReporte jasperExportarReporte = new JasperExportarReporte();
          jasperExportarReporte.setJasperPrint(this.getJasperPrint());
          switch (tipoDocumentoExportar) {
               case "PDF":
                    jasperExportarReporte.exportToPdf(rutaArchivoNuevo, tituloArchivo);
               break;
               case "XLSX":
                    jasperExportarReporte.exportToXlsx(rutaArchivoNuevo, tituloArchivo);
               break;
               case "CSV":
                    jasperExportarReporte.exportToCsv(rutaArchivoNuevo);
               break;
               case "HTML":
                    jasperExportarReporte.exportToHtml(rutaArchivoNuevo);
               break;
               case "XML":
                   jasperExportarReporte.exportToHtml(rutaArchivoNuevo);
              break;
               default:

          }
     }

     
     

//     public void generarReporteJasperSinConexionDataSourceMenbrete1(TblDenunciasPedidos tbldenunciaspedidos,String NombresCoordinadorSNAOJ,String NombresCoordinadorSNI) {
//          compileReport();
//           parameters.put("codigo",tbldenunciaspedidos.getNumeroExpediente()); 
//           parameters.put("NombresCoordinadorSNAOJ",NombresCoordinadorSNAOJ);
//           parameters.put("NombresCoordinadorSNI",NombresCoordinadorSNI);
//          this.setParameters(parameters);
//          fillReportDataSource();
//      
//          JasperExportarReporte jasperExportarReporte = new JasperExportarReporte();
//          jasperExportarReporte.setJasperPrint(this.getJasperPrint());
//          switch (tipoDocumentoExportar) {
//               case "PDF":
//                    jasperExportarReporte.exportToPdf(rutaArchivoNuevo, tituloArchivo);
//               break;
//               case "XLSX":
//                    jasperExportarReporte.exportToXlsx(rutaArchivoNuevo, tituloArchivo);
//               break;
//               case "CSV":
//                    jasperExportarReporte.exportToCsv(rutaArchivoNuevo);
//               break;
//               case "HTML":
//                    jasperExportarReporte.exportToHtml(rutaArchivoNuevo);
//               break;
//               default:
//
//          }
//     }
//     public void generarReporteMenbrete1(TblDenunciasPedidos tbldenunciaspedidos,TblDatos tbldato,String provincia,String canton,String etnia,String estadocivil,String tipodocumento) {
//          compileReport();
//          SimpleDateFormat formatter = new SimpleDateFormat("dd/MMMM/yyyy");
//          String fecha=formatter.format(tbldato.getFechaNacimiento());
//          parameters.put("idDenunciaPedido",tbldenunciaspedidos.getIdDenunciaPedido()); 
//          parameters.put("numerotramite",tbldenunciaspedidos.getNumeroOficioQuipux()); 
//          parameters.put("numeroexpediente",tbldenunciaspedidos.getNumeroExpediente()); 
//          parameters.put("identificacion",tbldato.getIdentificador()); 
//          parameters.put("tipoIdentificacion",tipodocumento); 
//          parameters.put("nombres",tbldato.getNombreUsuario()); 
//          parameters.put("FechaNacimiento",fecha); 
//          parameters.put("etnia",etnia); 
//          parameters.put("provincia",provincia); 
//          parameters.put("canton",canton); 
//          parameters.put("estadocivil",estadocivil); 
//          parameters.put("celular",tbldato.getCelular()); 
//          parameters.put("email",tbldato.getCorreoElectronico()); 
//          this.setParameters(parameters);
//          fillReportConConexion();
//      
//          JasperExportarReporte jasperExportarReporte = new JasperExportarReporte();
//          jasperExportarReporte.setJasperPrint(this.getJasperPrint());
//          switch (tipoDocumentoExportar) {
//               case "PDF":
//                    jasperExportarReporte.exportToPdf(rutaArchivoNuevo, tituloArchivo);
//               break;
//               case "XLSX":
//                    jasperExportarReporte.exportToXlsx(rutaArchivoNuevo, tituloArchivo);
//               break;
//               case "CSV":
//                    jasperExportarReporte.exportToCsv(rutaArchivoNuevo);
//               break;
//               case "HTML":
//                    jasperExportarReporte.exportToHtml(rutaArchivoNuevo);
//               break;
//               default:
//
//          }
//     }
     public void generarReporteVariable(Integer Periodo) {
       compileReport();
       parameters.put("Periodo",Periodo); 
       this.setParameters(parameters);
       fillReportConConexion();
       JasperExportarReporte jasperExportarReporte = new JasperExportarReporte();
     jasperExportarReporte.setJasperPrint(this.getJasperPrint());
     switch (tipoDocumentoExportar) {
          case "PDF":
              jasperExportarReporte.exportToPdf(rutaArchivoNuevo, tituloArchivo);
          break;
          case "XLSX":
               jasperExportarReporte.exportToXlsx(rutaArchivoNuevo, tituloArchivo);
          break;
          case "CSV":
              jasperExportarReporte.exportToCsv(rutaArchivoNuevo);
          break;
          case "HTML":
               jasperExportarReporte.exportToHtml(rutaArchivoNuevo);
          break;
         default:

        }
     }
     public void generarReportes(Integer Periodo) {
         compileReport();
         parameters.put("Periodo",Periodo); 
         this.setParameters(parameters);
         fillReportConConexion();
         JasperExportarReporte jasperExportarReporte = new JasperExportarReporte();
       jasperExportarReporte.setJasperPrint(this.getJasperPrint());
       switch (tipoDocumentoExportar) {
            case "PDF":
                jasperExportarReporte.exportToPdf(rutaArchivoNuevo, tituloArchivo);
            break;
            case "XLSX":
                 jasperExportarReporte.exportToXlsx(rutaArchivoNuevo, tituloArchivo);
            break;
            case "CSV":
                jasperExportarReporte.exportToCsv(rutaArchivoNuevo);
            break;
            case "HTML":
                 jasperExportarReporte.exportToHtml(rutaArchivoNuevo);
            break;
           default:

          }
       }
     public void compileReport() {
          
          switch (logoReporte) {
               case "defecto":
                    parameters.put("logoInstitucional", request.getServletContext().getRealPath("/")+"/resources/img/cpccsTexto.png");
               break;
              
               case "ninguno":
               default:

          }
          
          this.setParameters(parameters);
          
          try{
               InputStream reportStream = request.getSession().getServletContext().getResourceAsStream(reportFileName);
               jasperReport = JasperCompileManager.compileReport(reportStream);
               JRSaver.saveObject(jasperReport, request.getSession().getServletContext().getRealPath(reportFileName.replace(".jrxml", ".jasper")));
          } catch (JRException ex){
               Logger.getLogger(JasperFiltroReporte.class.getName()).log(Level.SEVERE, null, ex);
          }
     }
     
 public void compileReportFactura() {
          
          switch (logoReporte) {
               case "defecto":
                    parameters.put("Logo_Factura", request.getServletContext().getRealPath("/")+"/resources/img/FacturaSri.png");
               break;
              
               case "ninguno":
               default:

          }
          
          this.setParameters(parameters);
          
          try{
               InputStream reportStream = request.getSession().getServletContext().getResourceAsStream(reportFileName);
               jasperReport = JasperCompileManager.compileReport(reportStream);
               JRSaver.saveObject(jasperReport, request.getSession().getServletContext().getRealPath(reportFileName.replace(".jrxml", ".jasper")));
          } catch (JRException ex){
               Logger.getLogger(JasperFiltroReporte.class.getName()).log(Level.SEVERE, null, ex);
          }
     }

     /*public void fillReportDataSource() {
          try{
               System.out.println(parameters);
               jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource.getConnection());
          } catch (JRException | SQLException ex){
               Logger.getLogger(JasperFiltroReporte.class.getName()).log(Level.SEVERE, null, ex);
          }
     }*/

     public void fillReportDataSource() {
          try{
             //  System.out.println(parameters);
               jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
               
          } catch (JRException  ex){
               Logger.getLogger(JasperFiltroReporte.class.getName()).log(Level.SEVERE, null, ex);
          }
     }
     
     @SuppressWarnings("resource")
     public void fillReportConConexion() {
          Connection conn = null;
          try{
               String xmlPath = request.getServletContext().getRealPath("/") + "/WEB-INF/spring/root-context.xml";
               ApplicationContext context = new FileSystemXmlApplicationContext(xmlPath);
               DriverManagerDataSource dataSource = (DriverManagerDataSource) context.getBean("dataSource");
          
               conn = dataSource.getConnection();
               jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);

          } catch (JRException | SQLException ex){
               Logger.getLogger(JasperFiltroReporte.class.getName()).log(Level.SEVERE, null, ex);
          } finally{
               try{
                    if (conn != null && conn.isClosed() == false){
                         conn.close();
                         conn = null;
                    }
               } catch (SQLException e){
                    e.printStackTrace();
               }
          }
     }

     public void fillReportSinConexion() {
          try{
               jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
          } catch (JRException ex){
               Logger.getLogger(JasperFiltroReporte.class.getName()).log(Level.SEVERE, null, ex);
          }
     }

     public DataSource getDataSource() {
          return dataSource;
     }

     public void setDataSource(DataSource dataSource) {
          this.dataSource = dataSource;
     }

     public Map<String, Object> getParameters() {
          return parameters;
     }

     public void setParameters(Map<String, Object> parameters) {
          this.parameters = parameters;
     }

     public String getReportFileName() {
          return reportFileName;
     }

     public void setReportFileName(String reportFileName) {
          this.reportFileName = reportFileName;
     }

     public JasperPrint getJasperPrint() {
          return jasperPrint;
     }

}
