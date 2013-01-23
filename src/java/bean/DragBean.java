package bean;

/**
 *
 * @author Clio
 */
import clio.Entities.Laboratorio;
import clio.Entities.Pc;
import clio.beans.LaboratorioBean;
import clio.dao.PcDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;  
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;  
import javax.inject.Named;
import org.primefaces.event.DragDropEvent;  

/**
 *
 * @author CLIO's Developer Team
 * 
 * Clase:       DragBean
 * Descripción: Tiene como objetivo manejar el drag&drop usado en la Administración de
 *				laboratorios para situar las PCs en la ubicación que les corresponda.
 * Última 
 * modificación:22 de Enero del 2013
 */
@Named(value = "dragBean")
@SessionScoped    
public class DragBean implements Serializable {  
  
    private List<Pc> pcs;  
  
    private List<Pc> selectedPcs;  
  
    public DragBean() {  
        pcs = new ArrayList<Pc>();  
        selectedPcs = new ArrayList<Pc>();  
      
        
      
    }  
    public List<Pc> pcByLab(){
    
        try{
             FacesContext context = FacesContext.getCurrentInstance();
             LaboratorioBean laboratorioBean = (LaboratorioBean) context.getApplication().evaluateExpressionGet(context, "#{laboratorioBean}", LaboratorioBean.class);
             Laboratorio lab=laboratorioBean.getLaboratorio();
             long id= lab.getLabId();
             ListIterator <Pc>itr=new PcDAO().pcXLabortorio(id).listIterator();
             System.out.println("Esssssssssss:"+id);
             pcs = new ArrayList<Pc>(); 
//             selectedPcs= new ArrayList<Pc>();
             while(itr.hasNext()){     
                 System.out.println("q");               
                pcs.add(itr.next());    
             }  
             }catch(Exception e){
                 pcs = new ArrayList<Pc>(); 
                  System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");            
             }
        return pcs;
    }
    public void selectedPcEmpty(){
        System.out.println("UUUUUUUUUUUUUUUUUUUUUUUU");
      selectedPcs= new ArrayList<Pc>();
    }
    public List<Pc> getPcs() {          
         return pcs;  
    }  
  
    public List<Pc> getSelectedPcs() {  
        return selectedPcs;  
    }  
  
    public void onDrop(DragDropEvent event) {  
        Pc pc = (Pc) event.getData();       
        String pos=event.getDropId();
        String []rex;
        rex = pos.split("j");
        int fila=Integer.parseInt(rex[1]);
        int columna=Integer.parseInt(rex[2]);  
        pc.setPcFila(fila);
        pc.setPcColumna(columna);
        boolean flag=false;
        if(selectedPcs.size()>0){
            ListIterator <Pc> itr2=selectedPcs.listIterator();
            while(itr2.hasNext()){
                Pc pccom=itr2.next();
                if(pccom.getPcId().equals(pc.getPcId())){
                    flag=true;
                    pccom.setPcFila(fila);
                    pccom.setPcColumna(columna);
                }
            }            
        }
            
        if(!flag) {
            selectedPcs.add(pc);
        }    
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(pc.getPcNombre() + " añadido", "Posición:" +"fila: "+fila +" columna: "+columna));  
    }  
    public void guardarEdicion(){
        System.out.println("TTTTTTTTTTTTTTTTTTTTTTT"+selectedPcs.size());
        if(selectedPcs.size()>0&&selectedPcs.size()==pcs.size()){
            PcDAO ins=new PcDAO();
            ListIterator <Pc>itr=selectedPcs.listIterator();
            while(itr.hasNext()){
                try {
                    ins.update(itr.next());
                } catch (Exception ex) {
                    System.out.println("Error al guardar");
                }
            }           
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("¡Éxito!","Se organizaron las Pcs Exitosamente"));    
        }else{
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("¡Error!","Debe dar una ubicación a todas las PCs"));         
        }
    }
}  
