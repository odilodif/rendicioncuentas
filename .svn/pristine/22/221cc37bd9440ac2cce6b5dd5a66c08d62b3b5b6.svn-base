package gob.cpccs.utilidades.reportes;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.stereotype.Component;

@Component
public class JasperExportarReporte {

    private JasperPrint jasperPrint;

    public JasperExportarReporte() {
    }

    public JasperExportarReporte(JasperPrint jasperPrint) {
        this.jasperPrint = jasperPrint;
    }

    public JasperPrint getJasperPrint() {
        return jasperPrint;
    }

    public void setJasperPrint(JasperPrint jasperPrint) {
        this.jasperPrint = jasperPrint;
    }

    public void exportToPdf(String fileName, String tituloDocumento) {

        // print report to file
        JRPdfExporter exporter = new JRPdfExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(fileName));

        SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);

        SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
        exportConfig.setMetadataTitle(tituloDocumento);
        exportConfig.setMetadataAuthor("CPCCS");
        exportConfig.setMetadataCreator("SUDAPPS");
        exportConfig.setMetadataSubject("Documento PDF.");
       // exportConfig.setUserPassword("HOLA");
      
        exportConfig.setEncrypted(true);
        //Una propiedad de sugerencia de exportador que representa los permisos denegados para el documento PDF generado. Los permisos denegados para el documento pueden ser PRINTING, MODIFY_CONTENTS, COPY, MODIFY_ANNOTATIONS, FILL_IN, SCREENREADERS, ASSEMBLY, DEGRADED_PRINTING y ALL. Los diferentes permisos están separados por un carácter de tubería (|).
        exportConfig.setAllowedPermissionsHint("PRINTING");

        exporter.setConfiguration(reportConfig);
        exporter.setConfiguration(exportConfig);
        try {
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(JasperFiltroReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void exportToPdfsave(String fileName, String tituloDocumento) {

         // print report to file
         JRPdfExporter exporter = new JRPdfExporter();

         exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
         exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(fileName));

         SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
         reportConfig.setSizePageToContent(true);
         reportConfig.setForceLineBreakPolicy(false);

         SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
         exportConfig.setMetadataTitle(tituloDocumento);
         exportConfig.setMetadataAuthor("CPCCS");
         exportConfig.setMetadataCreator("SUDAPPS");
         exportConfig.setMetadataSubject("Documento PDF.");
        // exportConfig.setUserPassword("HOLA");
       
         exportConfig.setEncrypted(true);
         //Una propiedad de sugerencia de exportador que representa los permisos denegados para el documento PDF generado. Los permisos denegados para el documento pueden ser PRINTING, MODIFY_CONTENTS, COPY, MODIFY_ANNOTATIONS, FILL_IN, SCREENREADERS, ASSEMBLY, DEGRADED_PRINTING y ALL. Los diferentes permisos están separados por un carácter de tubería (|).
         exportConfig.setAllowedPermissionsHint("PRINTING");

         exporter.setConfiguration(reportConfig);
         exporter.setConfiguration(exportConfig);
         try {
             exporter.exportReport();
             
         } catch (JRException ex) {
             Logger.getLogger(JasperFiltroReporte.class.getName()).log(Level.SEVERE, null, ex);
         }
     }

    public void exportToXlsx(String fileName, String sheetName) {
        JRXlsxExporter exporter = new JRXlsxExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(fileName));

        SimpleXlsxReportConfiguration reportConfig = new SimpleXlsxReportConfiguration();
        reportConfig.setSheetNames(new String[] { sheetName });

        exporter.setConfiguration(reportConfig);

        try {
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(JasperFiltroReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exportToCsv(String fileName) {
        JRCsvExporter exporter = new JRCsvExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(fileName));

        try {
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(JasperFiltroReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exportToHtml(String fileName) {
        HtmlExporter exporter = new HtmlExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleHtmlExporterOutput(fileName));

        try {
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(JasperFiltroReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
