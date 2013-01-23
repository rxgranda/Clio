/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import ComunicacionCliente.ClienteClioSocket;
import clio.Entities.Conexion;
import clio.Entities.Laboratorio;
import clio.Entities.Pc;
import clio.dao.ConexionDAO;
import clio.interfaces.EntitiesBeanInterface;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author CLIO's Developer Team
 * 
 * Clase:       SocketBean
 * Descripción: Clase que maneja el envio de mensajes hacia los clientes por 
 *              medio del uso de Sockets.
 * Última 
 * modificación:22 de Enero del 2013
 */
@Named(value = "socketBean")
@SessionScoped
public class SocketBean implements Serializable {

    /**
     * Creates a new instance of ConexionBean
     */    
    private String mensaje;
    private String ip;
    
   public void logout(String ip2){
       ClienteClioSocket obj= new ClienteClioSocket(ip2,"logout");
       obj.Ejecutar();
   }
   public void enviarMensaje(){
       FacesContext context = FacesContext.getCurrentInstance();    
       if (mensaje.equals("")||mensaje.equals(" ") ||mensaje==null){                            
              context.addMessage(null, new FacesMessage("¡Error!", "Mensaje vacio"));                        
       }else{
           try{
            ClienteClioSocket obj= new ClienteClioSocket(ip," "+mensaje);
            obj.Ejecutar();
             context.addMessage(null, new FacesMessage("¡Exito!", "Se ha enviado el mensaje"));                        
           }catch(Exception e){
            context.addMessage(null, new FacesMessage("¡Error!", "No se pudo enviar el mensaje"));                        
           }
       }
      
   }
   public void apagarPC(){
       FacesContext context = FacesContext.getCurrentInstance();    
       
           try{
            ClienteClioSocket obj= new ClienteClioSocket(ip,"apagpc");
            
            obj.Ejecutar();
             context.addMessage(null, new FacesMessage("¡Exito!", "Se ha enviado la órden"));                        
           }catch(Exception e){
             e.printStackTrace();
            context.addMessage(null, new FacesMessage("¡Error!", "No se pudo enviar la órden"));                        
           }  
   }

   public void enviarMensajeTodos(){
       List <Conexion>conexiones=PcClienteBean.getClientesActivos();
       ListIterator <Conexion>itr=conexiones.listIterator();
       FacesContext context = FacesContext.getCurrentInstance();
        LaboratorioBean laboratorioBean = (LaboratorioBean) context.getApplication().evaluateExpressionGet(context, "#{laboratorioBean}", LaboratorioBean.class);        
       Laboratorio labActual=laboratorioBean.getLaboratorio();
        while(itr.hasNext()){
           Conexion con=itr.next();
           Pc pc=con.getPc();           
           String currentip=pc.getPcIp();
           if(labActual.getLabId().equals(pc.getLaboratorio().getLabId())){
                final ClienteClioSocket obj= new ClienteClioSocket(currentip," "+mensaje);            
                Thread sender= new Thread(){
                    @Override
                    public void run(){ 	
                     obj.Ejecutar();
                   }
                }; 
                try{
                sender.start();
                }catch(Exception e){
                    System.out.println("Error al enviar mensaje a:"+currentip);
                }
           }
       }
        context.addMessage(null, new FacesMessage("¡Exito!", "Se han enviado los mensajes a los PCs"));                        
   }
   
   public void apagarTodos(){
       FacesContext context = FacesContext.getCurrentInstance();
       LaboratorioBean laboratorioBean = (LaboratorioBean) context.getApplication().evaluateExpressionGet(context, "#{laboratorioBean}", LaboratorioBean.class);        
       Laboratorio labActual=laboratorioBean.getLaboratorio();
       Iterator <Pc>itr=labActual.getPcs().iterator();
        while(itr.hasNext()){
           
           Pc pc=itr.next();           
           String currentip=pc.getPcIp();
           
                final ClienteClioSocket obj= new ClienteClioSocket(currentip,"apagpc");            
                Thread sender= new Thread(){
                    @Override
                    public void run(){ 	
                     obj.Ejecutar();
                   }
                }; 
                try{
                sender.start();
                }catch(Exception e){
                    System.out.println("Error al enviar mensaje a:"+currentip);
                } 
       }
        context.addMessage(null, new FacesMessage("¡Exito!", "Se han enviado la órden a los PCs"));                        
   }
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
   
}
