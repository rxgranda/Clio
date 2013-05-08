/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClioWebService;


import clio.Entities.Conexion;
import clio.Entities.Laboratorio;
import clio.Entities.Pc;
import clio.Entities.Usuario;
import clio.beans.PcClienteBean;
import clio.dao.ConexionDAO;
import clio.dao.LaboratorioDAO;
import clio.dao.PcDAO;
import clio.dao.UsuarioDAO;
import java.util.Date;
import java.util.ListIterator;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author CLIO's Developer Team
 * 
 *Nombre:       ClioWebService
 * Descripcion: Servicio Web consumido por el cliente al momemto en que hace login/logout.
 *				
 * ultima 
 * modificacion:22 de Enero del 2013
 */
@WebService(serviceName = "ClioWebService")
public class ClioWebService {

   
   
    @Resource
    WebServiceContext wsContext;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "hello")
    public Boolean hello() {
        //TODO write your implementation code here:       
        //try{
        /*    MessageContext mc = wsContext.getMessageContext();
            HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST); 
            String ip=req.getRemoteAddr(); 
            PcDAO ins=new PcDAO();
            Pc pc=ins.PcByIP(ip); 
            System.out.println(pc.getPcIp());
            SocketClientHello socket=new SocketClientHello(ip,pc);
            //(new Thread(socket)).start(); 
        //} catch (Exception e){
                System.out.println("false");*/
          return true;
        //}
       // System.out.println("true");
        //return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public Boolean login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        boolean response;
      //  try{
           
            MessageContext mc = wsContext.getMessageContext();
            HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST); 
            String ip=req.getRemoteAddr(); 
            PcDAO ins=new PcDAO();
            Pc pc=ins.PcByIP(ip); 
           
                UsuarioDAO ins2=new UsuarioDAO();
                if(ins2.existeUsuario(username)){
                    Usuario user=ins2.getUsuarioByUsername(username);
                    if(user.getUsEnabled().equals("false")) {
                        return false;
                    }
                Conexion con = new Conexion();
                con.setPc(pc);
                con.setUsuario(user);
                con.setInicio(new Date());
                PcClienteBean.AgregarConexion(con); 
                //System.out.println("EEEEEEEEEEEEEE");
                return true;
            }else{
                return false;
            }                             
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registrarClienteClio")
    public Boolean registrarClienteClio(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") String apellidos, @WebParam(name = "matricula") String matricula, @WebParam(name = "cedula") String cedula, @WebParam(name = "email") String email, @WebParam(name = "facultad") String facultad) {
        //TODO write your implementation code here:
        UsuarioDAO ins=new UsuarioDAO();       
        boolean existe=ins.existeUsuario(username);
        if(existe){
            return false;
        }
        Usuario user= new Usuario();
        user.setUsNombres(nombres);
        user.setUsApellidos(apellidos);
        user.setUsCedula(cedula);
        user.setUsEmail(email);
        user.setUsEnabled("true");
        user.setUsFacultad(facultad);
        user.setUsMatricula(matricula);
        user.setUsUsername(username);                        
        try {      
            ins.save(user, "ROLE_CLIENT");
        } catch (Exception ex) {
           return false;
        }
        return true;
    }

    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "laboratoriosDisponibles")
    public String laboratoriosDisponibles() {
        //TODO write your implementation code here:
        String response="";
        LaboratorioDAO ins= new LaboratorioDAO();
        ListIterator <Laboratorio>itr=ins.list().listIterator();
        while(itr.hasNext()){
            Laboratorio lb=itr.next();
            if(itr.hasNext()) {
                response+=lb.getLabId()+"$"+lb.getLabNombre()+"|";
            }
            else {
                response+=lb.getLabId()+"$"+lb.getLabNombre();
            }
        }
        return response;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registrarPC")
    public Boolean registrarPC(@WebParam(name = "nombrePC") String nombrePC, @WebParam(name = "idLab") String idLab) {
        //TODO write your implementation code here:
        try{
            MessageContext mc = wsContext.getMessageContext();
            HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST); 
            String ip=req.getRemoteAddr(); 
            PcDAO ins=new PcDAO();
            LaboratorioDAO ins2=new LaboratorioDAO();
            Laboratorio lab=ins2.getByID(Long.parseLong(idLab));
            Pc pc=new Pc();
            pc.setLaboratorio(lab);
            pc.setPcNombre(nombrePC);
            pc.setPcEstado("1");
            pc.setPcIp(ip);
            if(ins.PcByIP(ip)==null){                
                ins.save(pc);
            }else
                return false;
        }catch(Exception e){
            return false;
        }
        return true;
    }

    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "logout")
    public Boolean logout(@WebParam(name = "username") String username) {
        MessageContext mc = wsContext.getMessageContext();
        HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST); 
        String ip=req.getRemoteAddr();    
        return PcClienteBean.ElimiarConexion(ip);    
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login2")
    public Long login2(@WebParam(name = "username") String username) {
        //TODO write your implementation code here:
        MessageContext mc = wsContext.getMessageContext();
            HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST); 
            String ip=req.getRemoteAddr(); 
            PcDAO ins=new PcDAO();
             Pc pc;
            try{
                 pc=ins.PcByIP(ip); } 
            catch (Exception e){
                return (long)0;
            }           
            UsuarioDAO ins2=new UsuarioDAO();
            if(ins2.existeUsuario(username)){
                Usuario user=ins2.getUsuarioByUsername(username);
                ConexionDAO inscon= new ConexionDAO();
                Long tiempo=inscon.duracionConexion(user,ip);
                if(user.getUsEnabled().equals("false") ||(tiempo<1000 && tiempo>=0)) {
                    return (long)0; // retornar 0 es decir no se inicia sesion
                }                    
                Conexion con = new Conexion();
                con.setPc(pc);
                con.setUsuario(user);
                con.setInicio(new Date());
                PcClienteBean.AgregarConexion(con); 
                //System.out.println("EEEEEEEEEEEEEE");
                if(tiempo>=1000) {
                        return tiempo;
                    }
                
                return (long)-100; //tiempo infinito
                    
                
            }else{
               
                        return (long)0;
            }  
               // return (long) 0;                
    }
}
