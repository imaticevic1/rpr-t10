package ba.unsa.etf.rpr;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import net.sf.jasperreports.repo.JasperDesignReportResource;
import net.sf.jasperreports.swing.JRViewer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class GradoviReport {
    public void showReport(GeografijaDAO geo){
        try {
            new PrintReport().showReport(geo.getConn());
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
    public void saveAs(String format) throws JRException {
        GeografijaDAO geo = GeografijaDAO.getInstance();
        String reportSrcFile = getClass().getResource("/reports/gradovi.jrxml").getFile();
        String reportsDir = getClass().getResource("/reports/").getFile();
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
// Fields for resources path
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("reportsDirPath", reportsDir);
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        list.add(parameters);
        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, geo.getConn());
        if(format.equals("docx")) {
            JRDocxExporter doc = new JRDocxExporter();
            doc.setExporterInput(new SimpleExporterInput(print));
            doc.setExporterOutput(new SimpleOutputStreamExporterOutput(new File("C:\\Users\\Goran\\IdeaProjects\\rpr-t10\\resources\\reports\\gradovi.docx")));
            SimpleDocxReportConfiguration config = new SimpleDocxReportConfiguration();
//config.setFlexibleRowHeight(true); //Set desired configuration
            doc.setConfiguration(config);
            doc.exportReport();
        }
        if(format.equals("xlsx")) {
            JRXlsxExporter xlsx = new JRXlsxExporter();
            xlsx.setExporterInput(new SimpleExporterInput(print));
            xlsx.setExporterOutput(new SimpleOutputStreamExporterOutput(new File("C:\\Users\\Goran\\IdeaProjects\\rpr-t10\\resources\\reports\\gradovi.docx")));
            SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
//config.setFlexibleRowHeight(true); //Set desired configuration
            xlsx.setConfiguration(config);
            xlsx.exportReport();
        }
        if(format.equals("pdf"))
        JasperExportManager.exportReportToPdfFile(print,"C:\\Users\\Goran\\IdeaProjects\\rpr-t10\\resources\\reports\\gradovi.pdf");
    }
}
