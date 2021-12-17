/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.SimpleFileResolver;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
/**
 *
 * @author Gerardo
 */

public class reporteHistorialP {
    ConexionDB conexion = null;
    
    public JRViewer getHistorialP(String name){
        conexion = new ConexionDB();
        try {
           JasperDesign desing = JRXmlLoader.load(getClass().getResource("/reportes/historial.jrxml").getPath());
           JasperReport jr = JasperCompileManager.compileReport(desing);
           Map<String, Object> parametros = new HashMap<>();
           parametros.put("NOMBRE",name);
           String reportsDirPath = getClass().getResource("/reportes").getPath();
           File reportsDir = new File(reportsDirPath);
           parametros.put(JRParameter.REPORT_FILE_RESOLVER, new SimpleFileResolver(reportsDir));
           JasperPrint jp = JasperFillManager.fillReport(jr, parametros,conexion.conecta);
           MyJRViewer myjrv = new MyJRViewer(jp);
           JRViewer jrv = myjrv;           
           return jrv;
        } catch (Exception e) {
            //System.out.println("Error " + e);
           return null;
        }
        
    }
    
}
