/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import clio.Entities.RolesUsuarios;
import clio.dao.RolesUsuariosDAO;
import clio.interfaces.EntitiesBeanInterface;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Manuel
 * 
 * Clase:       RolesUsuariosBean
 * Descripción: Clase que utiliza RolesUsuariosDAO para realizar operaciones con
 *              los datos en la Base de Datos.
 * Última 
 * modificación:22 de Enero del 2013
 */
@Named(value = "rolBean")
@SessionScoped
public class RolesUsuariosBean implements Serializable, EntitiesBeanInterface {

    /**
     * Creates a new instance of RolesUsuariosBean
     */
    RolesUsuariosDAO ins=new RolesUsuariosDAO();
    private RolesUsuarios rol;
    private List<RolesUsuarios> rolesList;
    
    
    public RolesUsuariosBean() {
         rol= new RolesUsuarios();         
    }
    
    @Override
    public void prepararSave(){
        rol=new RolesUsuarios();
    }
    
    @Override
    public void prepararUpdate( long id){
        rol=null;
        rol=ins.getByID(id);
    }
    
    @Override
    public void prepararDelete(long id){        
        rol=ins.getByID(id);
    }
    
    @Override
    public void save(){
        FacesContext context = FacesContext.getCurrentInstance();            
        try {
            ins.save(rol);             
            context.addMessage(null, new FacesMessage("¡Éxito!", "Rol creado exitosamente"));
        } catch (Exception ex) {
             context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al guardar"));   
        }
     }
    
    @Override
     public void update(){
        FacesContext context = FacesContext.getCurrentInstance();            
        try {
            ins.update(rol);             
            context.addMessage(null, new FacesMessage("¡Éxito!", "Rolmodificado exitosamente"));
        }catch (Exception ex) {
            context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al guardar"));
        }                           
     }
      
    @Override
     public void delete(){
        FacesContext context = FacesContext.getCurrentInstance();            
         try {
             ins.remove(rol);             
             context.addMessage(null, new FacesMessage("¡Éxito!", "Se ha eliminado el rol exitosamente"));               
         }catch (Exception ex) {
              context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al tratar de eliminar"));               
         }
     }
     
     public RolesUsuarios getRolesUsuarios() {
        return rol;
     }

     public void setRolesUsuarios(RolesUsuarios rol) {
        this.rol = rol;
     }

     public List<RolesUsuarios> getRolesUsuariossList() {
        RolesUsuariosDAO lista=new RolesUsuariosDAO();
        rolesList=lista.list();
        return rolesList;
     }       
}
