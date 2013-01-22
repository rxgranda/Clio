/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import clio.Entities.Modulo;
import clio.dao.ModuloDAO;
import clio.interfaces.EntitiesBeanInterface;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Roger
 */
@Named(value = "moduloBean")
@SessionScoped
public class ModuloBean implements Serializable, EntitiesBeanInterface {

    /**
     * Creates a new instance of ModuloBean
     */
    ModuloDAO ins=new ModuloDAO();
    private Modulo modulo;
    private List<Modulo> modulosList;
    
    
    public ModuloBean() {
         modulo= new Modulo();         
    }
    
    @Override
    public void prepararSave(){
        modulo=new Modulo();
    }
    
    @Override
    public void prepararUpdate( long id){
        modulo=null;
        modulo=ins.getByID(id);
    }
    
    @Override
    public void prepararDelete(long id){        
        modulo=ins.getByID(id);
    }
    
    @Override
    public void save(){
        FacesContext context = FacesContext.getCurrentInstance();            
        try {
            ins.save(modulo);             
            context.addMessage(null, new FacesMessage("¡Éxito!", "Modulo creado exitosamente"));
        } catch (Exception ex) {
             context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al guardar"));   
        }
     }
    
    @Override
     public void update(){
        FacesContext context = FacesContext.getCurrentInstance();            
        try {
            ins.update(modulo);             
            context.addMessage(null, new FacesMessage("¡Éxito!", "Modulo modificado exitosamente"));
        }catch (Exception ex) {
            context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al guardar"));
        }                           
     }
      
    @Override
     public void delete(){
        FacesContext context = FacesContext.getCurrentInstance();            
         try {
             ins.remove(modulo);             
             context.addMessage(null, new FacesMessage("¡Éxito!", "Modulo eliminado exitosamente"));               
         }catch (Exception ex) {
              context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al tratar de eliminar"));               
         }
     }
     
     public Modulo getModulo() {
        return modulo;
     }

     public void setModulo(Modulo modulo) {
        this.modulo = modulo;
     }

     public List<Modulo> getModulosList() {
        ModuloDAO lista=new ModuloDAO();
        modulosList=lista.list();
        return modulosList;
     }       
}
