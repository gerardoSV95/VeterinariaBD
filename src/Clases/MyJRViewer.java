
package Clases;

import java.util.Locale;
import java.util.ResourceBundle;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.swing.JRViewerToolbar;
import net.sf.jasperreports.view.JRSaveContributor;
import net.sf.jasperreports.view.save.JRPdfSaveContributor;

/**
 *
 * @author Carlos
 * Esta clase permite poner un filtro al guardar el reporte en PDF
 */
public class MyJRViewer extends JRViewer {
    //define the constructor that you use
    public MyJRViewer(JasperPrint jasperPrint) {
        super(jasperPrint);
    }

    @Override
    protected JRViewerToolbar createToolbar() {
        JRViewerToolbar toolbar = super.createToolbar();
        Locale locale = viewerContext.getLocale();
        ResourceBundle resBundle = viewerContext.getResourceBundle();
        // PDF
        JRPdfSaveContributor pdf = new JRPdfSaveContributor(locale, resBundle);
        toolbar.setSaveContributors(new JRSaveContributor[] {pdf});
        return toolbar;
    }   
}