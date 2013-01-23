/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import clio.Entities.Sanciones;
import clio.Entities.Usuario;
import clio.dao.SancionesDAO;
import clio.dao.UsuarioDAO;
import clio.interfaces.EntitiesBeanInterface;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author CLIO's Developer Team
 * 
 * Clase:       SancionesBean
 * Descripción: Clase que utiliza SancionesDAO para realizar operaciones con
 *              los datos en la Base de Datos, asi también, maneja el estado de
 *              usuario dependiendo de si tiene una sanción vigente o no.
 * Última 
 * modificación:22 de Enero del 2013
 */
@Named(value = "sancionesBean")
@SessionScoped
public class SancionesBean implements Serializable, EntitiesBeanInterface {

    /**
     * Creates a new instance of SancionesBean
     */
    SancionesDAO ins=new SancionesDAO();
    private Sanciones sanciones;
    private List<Sanciones> sancionessList;
    private List<Sanciones> sancionesVigentesList;
    private String matricula;

     
    public SancionesBean() {
         sanciones= new Sanciones();         
    }

    public List<Sanciones> getSancionesVigentesList() {
        SancionesDAO lista=new SancionesDAO();
        sancionesVigentesList=lista.listVigentes();
        return sancionesVigentesList;
    }

    public void setSancionesVigentesList(List<Sanciones> sancionesVigentesList) {
        this.sancionesVigentesList = sancionesVigentesList;
    }
    
    
    @Override
    public void prepararSave(){
        sanciones=new Sanciones();
    }
    
    @Override
    public void prepararUpdate( long id){
        sanciones=null;
        sanciones=ins.getByID(id);
    }
    
    @Override
    public void prepararDelete(long id){        
        sanciones=ins.getByID(id);
    }
    
    @Override
    public void save(){
        UsuarioBean usbean = new UsuarioBean();
        sanciones.setSaVigencia("Vigente");
        FacesContext context = FacesContext.getCurrentInstance();            
        
        try {
            ins.save(sanciones);   
            sanciones.getUsuario().setUsEnabled("false");
            usbean.setUsuario(sanciones.getUsuario());
            usbean.update();
            context.addMessage(null, new FacesMessage("¡Éxito!", "Se ha creado la sancion exitosamente"));
        } catch (Exception ex) {
             context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al guardar"));   
        }
     }
    
    @Override
     public void update(){
        FacesContext context = FacesContext.getCurrentInstance();            
        try {
            ins.update(sanciones);             
            context.addMessage(null, new FacesMessage("¡Éxito!", "Se ha modificado la sancion exitosamente"));
        }catch (Exception ex) {
            context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al guardar"));
        }                           
     }
      
    @Override
     public void delete(){
        FacesContext context = FacesContext.getCurrentInstance();            
         try {
             ins.remove(sanciones);             
             context.addMessage(null, new FacesMessage("¡Éxito!", "Sancion eliminado exitosamente"));               
         }catch (Exception ex) {
              context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al tratar de eliminar"));               
         }
     }
     
     public Sanciones getSanciones() {
        return sanciones;
     }

     public void setSanciones(Sanciones sanciones) {
        this.sanciones = sanciones;
     }

     public List<Sanciones> getSancionessList() {
        SancionesDAO lista=new SancionesDAO();
        sancionessList=lista.list();
        return sancionessList;
     }       
     
     public String getMatricula() {
         return matricula;
     }

     public void setMatricula(String matricula) {
         this.matricula = matricula;
     }
     public void setUsuarioSancionado(){
         UsuarioBean userbean = new UsuarioBean();
         this.sanciones.setUsuario(userbean.searchUser(matricula));
         System.out.println(sanciones.getUsuario().getUsApellidos());
     }
     public void quitarSancion(){
         sanciones.setSaVigencia("Cumplida");
         
         Usuario user=sanciones.getUsuario();
         user.setUsEnabled("true");
         UsuarioDAO ins2=new UsuarioDAO();
         try{
            ins2.save(user);
         }catch(Exception e){
         }
         update();
     }
}