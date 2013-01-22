/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

/**
 *
 * @author Roger
 */

import clio.Entities.Laboratorio;
import clio.dao.LaboratorioDAO;
import java.util.ListIterator;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
import javax.inject.Named;
import org.primefaces.component.menuitem.MenuItem;  
import org.primefaces.component.submenu.Submenu;  
import org.primefaces.model.DefaultMenuModel;  
import org.primefaces.model.MenuModel;  
@Named (value = "MenuLabBean")

public class MenuLabBean {  
  
    private MenuModel model;  
  
    public MenuLabBean() {  
            model = new DefaultMenuModel();  
            Submenu submenu = new Submenu();  
            submenu.setLabel("Ver Laboratorios Disponibles");  
            LaboratorioDAO l=new LaboratorioDAO();      
            ListIterator <Laboratorio>itr=l.list().listIterator();
            while(itr.hasNext()){
            Laboratorio lab=itr.next();             
            Submenu item = new Submenu();  
            item.setLabel(lab.getLabNombre());               
            MenuItem subitem1=new MenuItem();
            subitem1.setValue("Ver Laboratorio");
            subitem1.setUrl("laboratorios_1.xhtml");
            MenuItem subitem2=new MenuItem();
            subitem2.setValue("Administrar Laboratorio");
            subitem2.setUrl("laboratorios_1.xhtml");            
            item.getChildren().add(subitem1);
            item.getChildren().add(subitem2);
            submenu.getChildren().add(item);            
        }
         model.addSubmenu(submenu);                  
        submenu = new Submenu();  
        submenu.setLabel("Opciones");  
          
        MenuItem item = new MenuItem();  
        item.setValue("Resumen de Laboratorios");  
        item.setUrl("#");  
        submenu.getChildren().add(item);  
        
        item = new MenuItem();  
        item.setValue("Crear Laboratorio");  
        item.setUrl("#");  
        
        submenu.getChildren().add(item);
                 
          
        model.addSubmenu(submenu);
    }  
  
    public MenuModel getModel() {  
        return model;  
    }     
      
    public void save() {  
        addMessage("Data saved");  
    }  
      
    public void update() {  
        addMessage("Data updated");  
    }  
      
    public void delete() {  
        addMessage("Data deleted");  
    }  
      
    public void addMessage(String summary) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
}  