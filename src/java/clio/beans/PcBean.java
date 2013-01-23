/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import clio.Entities.Pc;
import clio.dao.LaboratorioDAO;
import clio.dao.PcDAO;
import clio.interfaces.EntitiesBeanInterface;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Harry
 * 
 * Clase:       PCBean
 * Descripción: Clase que utiliza PcDAO para dar tramiento a los datos 
 *              en la Base.
 * Última 
 * modificación:22 de Enero del 2013
 */
@Named(value = "pcBean")
@SessionScoped
public class PcBean implements Serializable, EntitiesBeanInterface {

    /**
     * Creates a new instance of PcBean
     */
    PcDAO ins=new PcDAO();
    private Pc pc;
    private List<Pc> pcsList;
    private Long iDlab;
    
    
    public PcBean() {
         pc= new Pc();         
    }
    
    @Override
    public void prepararSave(){
        pc=new Pc();
    }
    
    @Override
    public void prepararUpdate( long id){
        pc=null;
        pc=ins.getByID(id);
    }
    
    @Override
    public void prepararDelete(long id){        
        pc=ins.getByID(id);
    }
    
    @Override
    public void save(){
        FacesContext context = FacesContext.getCurrentInstance();            
        try { 
            LaboratorioDAO inslabdao=new LaboratorioDAO();
            pc.setLaboratorio(inslabdao.getByID(iDlab));
            ins.save(pc);             
            context.addMessage(null, new FacesMessage("¡Éxito!", "Pc creado exitosamente"));
        } catch (Exception ex) {
             context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al guardar"));   
        }
     }
    
    @Override
     public void update(){
        FacesContext context = FacesContext.getCurrentInstance();            
        try {
            LaboratorioDAO inslabdao=new LaboratorioDAO();
            pc.setLaboratorio(inslabdao.getByID(iDlab));
            ins.update(pc);             
            context.addMessage(null, new FacesMessage("¡Éxito!", "Pc modificado exitosamente"));
        }catch (Exception ex) {
            context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al guardar"));
        }                           
     }
      
    @Override
     public void delete(){
        FacesContext context = FacesContext.getCurrentInstance();            
         try {
             ins.remove(pc);             
             context.addMessage(null, new FacesMessage("¡Éxito!", "Pc eliminado exitosamente"));               
         }catch (Exception ex) {
              context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al tratar de eliminar"));               
         }
     }
     
     public Pc getPc() {
        return pc;
     }

     public void setPc(Pc pc) {
        this.pc = pc;
     }

     public List<Pc> getPcsList() {
        PcDAO lista=new PcDAO();
        pcsList=lista.list();
        return pcsList;
     }   

    public Long getiDlab() {
        return iDlab;
    }

    public void setiDlab(Long iDlab) {
        this.iDlab = iDlab;
    }

    
    
     
}
