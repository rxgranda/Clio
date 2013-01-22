/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import clio.Entities.Conexion;
import clio.dao.ConexionDAO;
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
@Named(value = "conexionBean")
@SessionScoped
public class ConexionBean implements Serializable, EntitiesBeanInterface {

    /**
     * Creates a new instance of ConexionBean
     */
    ConexionDAO ins=new ConexionDAO();
    private Conexion conexion;
    private List<Conexion> conexionsList,conexionsListByParam;
      
    public ConexionBean() {
         conexion= new Conexion();         
    }
    
    @Override
    public void prepararSave(){
        conexion=new Conexion();
    }
    
    @Override
    public void prepararUpdate( long id){
        conexion=null;
        conexion=ins.getByID(id);
    }
    
    @Override
    public void prepararDelete(long id){        
        conexion=ins.getByID(id);
    }
    
    @Override
    public void save(){
        FacesContext context = FacesContext.getCurrentInstance();            
        try {
            ins.save(conexion);             
            context.addMessage(null, new FacesMessage("¡Éxito!", "Conexion creado exitosamente"));
        } catch (Exception ex) {
             context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al guardar"));   
        }
     }
    
    @Override
     public void update(){
        FacesContext context = FacesContext.getCurrentInstance();            
        try {
            ins.update(conexion);             
            context.addMessage(null, new FacesMessage("¡Éxito!", "Conexion modificado exitosamente"));
        }catch (Exception ex) {
            context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al guardar"));
        }                           
     }
      
    @Override
     public void delete(){
        FacesContext context = FacesContext.getCurrentInstance();            
         try {
             ins.remove(conexion);             
             context.addMessage(null, new FacesMessage("¡Éxito!", "Conexion eliminado exitosamente"));               
         }catch (Exception ex) {
              context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al tratar de eliminar"));               
         }
     }
     
     public Conexion getConexion() {
        return conexion;
     }

     public void setConexion(Conexion conexion) {
        this.conexion = conexion;
     }

     public List<Conexion> getConexionsList() {
        ConexionDAO lista=new ConexionDAO();
        conexionsList=lista.list();
        return conexionsList;
     }  
     
     public List<Conexion> getConexionsListReporte() {
        List<Conexion> listaReporte = null;
        if (conexion.getTipoBuscar().equals("termino")){
            listaReporte=getConexionsListByTerm();
        }
        if (conexion.getTipoBuscar().equals("mes")){
            listaReporte=getConexionsListByYear();
        }
        return listaReporte;
     }
     
     public List<Conexion> getConexionsListByYear() {
        ConexionDAO lista=new ConexionDAO();
        conexionsList=lista.listByYear(conexion.getAnio(),conexion.getMes());
        return conexionsList;
     }
     
     public List<Conexion> getConexionsListByTerm() {
        ConexionDAO lista=new ConexionDAO();
        conexionsListByParam=lista.listByTerm(conexion.getTermino());
        return conexionsListByParam;
    }
     
     public List<Conexion> getConexionsCountReporte() {
        List<Conexion> listaReporte = null;
        if (conexion.getTipoBuscar().equals("termino")){
            listaReporte=getConexionsListCountTerm();
        }
        if (conexion.getTipoBuscar().equals("mes")){
            listaReporte=getConexionsListCountYear();
        }
        return listaReporte;
     }
     
     public List<Conexion> getConexionsListCountYear() {
        ConexionDAO lista=new ConexionDAO();
        conexionsList=lista.listCountYear(conexion.getAnio());
        return conexionsList;
     }
     
     public List<Conexion> getConexionsListCountTerm() {
        ConexionDAO lista=new ConexionDAO();
        conexionsListByParam=lista.listCountTerm(conexion.getTermino());
        return conexionsListByParam;
    }
}
