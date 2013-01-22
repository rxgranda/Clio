/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Manuel
 */
@Named(value = "formatoDocBean")
@Dependent
public class FormatoDocBean {

    /**
     * Creates a new instance of FormatoDocBean
     */
    public FormatoDocBean() {
    }

    public void preProcessPDF(Object document) throws IOException, DocumentException {

        final Document pdf = (Document) document;

        pdf.setPageSize(PageSize.A4.rotate());
        pdf.open();

        Phrase phrase = new Phrase("Reporte Generado por CLIO");
        pdf.add(phrase);

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = servletContext.getRealPath("") + File.separator + "img" + File.separator + "encabezado.png";
        Image imagen = Image.getInstance(logo);

        pdf.add(imagen);
        pdf.addAuthor("CLIO");
        pdf.addCreator("CIB");
    }

}