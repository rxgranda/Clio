/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import clio.Entities.Laboratorio;
import clio.Entities.Pc;
import clio.dao.LaboratorioDAO;
import clio.interfaces.EntitiesBeanInterface;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author CLIO's Developer Team
 * 
 * Clase:       LaboratorioBean
 * Descripción: Clase que utiliza LaboratorioDAO para dar tratamiento de los
 *              latos de laboratorios en la Base.
 * Última 
 * modificación:22 de Enero del 2013
 */
@Named(value = "laboratorioBean")
@SessionScoped
public class LaboratorioBean implements Serializable, EntitiesBeanInterface {

    /**
     * Creates a new instance of LaboratorioBean
     */
    LaboratorioDAO ins=new LaboratorioDAO();
    private Laboratorio laboratorio;
    private List<Laboratorio> laboratoriosList;
    
    
    public LaboratorioBean() {
         laboratorio= new Laboratorio();         
    }
    
    @Override
    public void prepararSave(){
        laboratorio=new Laboratorio();
    }
    
    @Override
    public void prepararUpdate( long id){
        laboratorio=null;      
        laboratorio=ins.getByID(id);
    }
    
    @Override
    public void prepararDelete(long id){        
        laboratorio=ins.getByID(id);
    }
    
    @Override
    public void save(){
        FacesContext context = FacesContext.getCurrentInstance();            
        try {
            ins.save(laboratorio);             
            context.addMessage(null, new FacesMessage("¡Éxito!", "Laboratorio creado exitosamente"));
        } catch (Exception ex) {
             context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al guardar"));   
        }
     }
    
    @Override
     public void update(){
        FacesContext context = FacesContext.getCurrentInstance();            
        try {
            ins.update(laboratorio);             
            context.addMessage(null, new FacesMessage("¡Éxito!", "Laboratorio modificado exitosamente"));
        }catch (Exception ex) {
            context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al guardar"));
        }                           
     }
      
    @Override
     public void delete(){
        FacesContext context = FacesContext.getCurrentInstance();            
         try {
             ins.remove(laboratorio);             
             context.addMessage(null, new FacesMessage("¡Éxito!", "Laboratorio eliminado exitosamente"));               
         }catch (Exception ex) {
             ex.printStackTrace();
              context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al tratar de eliminar"));               
         }
     }
     
     public Laboratorio getLaboratorio() {
        return laboratorio;
     }

     public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
     }

     public List<Laboratorio> getLaboratoriosList() {
        LaboratorioDAO lista=new LaboratorioDAO();
        laboratoriosList=lista.list();
        return laboratoriosList;
     }     
     public List <Pc> matrizLab(){
         System.out.println(laboratorio.getLabNombre());
         Iterator <Pc>itr=laboratorio.getPcs().iterator();
         Map<String,Pc> mp=new HashMap<String,Pc>();
         while(itr.hasNext()){
             Pc pc=itr.next();
             mp.put(pc.getPcFila()+"_"+pc.getPcColumna(), pc);
         }
         List <Pc> matriz= new LinkedList<Pc>();
         for(int i=0;i<laboratorio.getLabCantFila();i++){
            
             for(int j=0;j<laboratorio.getLabCantColumna();j++){ 
                 int ia=i+1;
                 int ja=j+1;
                 Pc pc=mp.get(ia+"_"+ja);  
                 if(pc!=null) {
                      matriz.add(pc);
                 }
                 else {
                      matriz.add(null);
                 }
             }
            
         }
         System.out.println(matriz.size());
         return matriz;
     }
}
