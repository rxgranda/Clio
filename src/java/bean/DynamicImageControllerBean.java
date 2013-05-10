
package bean;

import ComunicacionCliente.DesktopSocket;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;  
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;  
import javax.imageio.ImageIO;
import javax.inject.Named;
 
import org.primefaces.model.DefaultStreamedContent;  
import org.primefaces.model.StreamedContent;  

/**
 *
 * @author Roger
 */
@Named(value = "desktopBean")
@SessionScoped
public class DynamicImageControllerBean implements Serializable{
    
    private StreamedContent desktop;
    private String ip;
    
    
    /**
     *
     */
    public DynamicImageControllerBean() {
       
    }
    public void construirDesktop(){
         try {
            //Graphic Text
         //    System.out.println(ip+"construir");
            DesktopSocket obj= new DesktopSocket(ip);
            BufferedImage bufferedImg = obj.Ejecutar();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bufferedImg, "png", os);
            desktop = new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), "image/png");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public StreamedContent getDesktop() {
        construirDesktop();
        return desktop;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
       //   System.out.println(ip+"getter");
        this.ip = ip;
    }
    

}

