/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import clio.Entities.Laboratorio;
import clio.Entities.Pc;
import clio.beans.LaboratorioBean;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

/**
 *
 * @author Clio
 */
@Named(value = "dashboardBean")
@SessionScoped
public class DashboardBean implements Serializable {  
  
    private DashboardModel model;  
      
    public DashboardBean() {  
        model = new DefaultDashboardModel(); 
                                
    }  
      public void contruir(){
        model = new DefaultDashboardModel(); 
        FacesContext context = FacesContext.getCurrentInstance();
        LaboratorioBean laboratorioBean = (LaboratorioBean) context.getApplication().evaluateExpressionGet(context, "#{laboratorioBean}", LaboratorioBean.class);
        List <Pc> lab=laboratorioBean.matrizLab();
        int colum=laboratorioBean.getLaboratorio().getLabCantColumna();
        int fila=laboratorioBean.getLaboratorio().getLabCantFila();
        //for(int j=0;j<fila;j++){
            //for(int i=0;i<colum;i++){
        ListIterator <Pc> itr=lab.listIterator();
        int i=1;
        LinkedList <DefaultDashboardColumn> columnas=new LinkedList<DefaultDashboardColumn>() ;
        for(int k=0;k<colum;k++){
            columnas.add(new DefaultDashboardColumn());
        }
        ListIterator <DefaultDashboardColumn>itrC=columnas.listIterator();
        
       /* while(itrC.hasNext()){
            DefaultDashboardColumn colw=new DefaultDashboardColumn();
            for(int i=0;i<fila*colum;i=i+colum){
            }
        }*/
        while(itr.hasNext()){ 
            
            DefaultDashboardColumn columna;
            if(itrC.hasNext()){
                columna= itrC.next(); 
            } else{
                itrC=columnas.listIterator();
                columna= itrC.next(); 
            }   
            Pc pc=itr.next();
                 
                 if(pc!=null) {
                    columna.addWidget("a"+pc.getPcId());
                }
                 else {
                    columna.addWidget("b"+i);
                }
                 i++;
                
        }
         itrC=columnas.listIterator();
                
        while(itrC.hasNext()){
         DefaultDashboardColumn columna=itrC.next();
         model.addColumn(columna);
        }
      }
    public void handleReorder(DashboardReorderEvent event) {  
        FacesMessage message = new FacesMessage();  
        message.setSeverity(FacesMessage.SEVERITY_INFO);  
        message.setSummary("Reordered: " + event.getWidgetId());  
        message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());  
          
        addMessage(message);  
    }  
      
      
    private void addMessage(FacesMessage message) {  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
      
    public DashboardModel getModel() {  
        return model;  
    }  
}  
