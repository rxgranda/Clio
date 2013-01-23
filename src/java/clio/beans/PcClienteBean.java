/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;


import clio.Entities.Conexion;
import clio.Entities.Pc;
import clio.dao.ConexionDAO;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author CLIO's Developer Team
 * 
 * Clase:       PcClienteBean
 * Descripción: Clase usada para obtener los parametros de renderización de la 
 *              la vista de los laboratorios.
 * Última 
 * modificación:22 de Enero del 2013
 */
@Named(value = "pcClienteBean")
@ApplicationScoped
public class PcClienteBean {

    /**
     * Creates a new instance of PcClienteBean
     */
    private static List <Pc> pcActivas=new LinkedList<Pc>();
    private static List <Conexion> clientesActivos=new LinkedList<Conexion>(); 
    
    public PcClienteBean() {
    }
    
    public static void AgregarPc(Pc pc){
        pcActivas.add(pc);
    }
    
    public static void ElimiarPc(Pc pc){
        pcActivas.remove(pc);
    }
    
    public static void AgregarConexion(Conexion con){
       // System.out.println(con.getPc().getPcIp());
        clientesActivos.add(con);
        //ListIterator<Conexion>  itr=clientesActivos.listIterator();
      //  while(itr.hasNext())
          //  System.out.println(itr.next().getUsuario().getUsUsername());
    }
    
    public static boolean ElimiarConexion(String ip){
        ListIterator <Conexion> itr=clientesActivos.listIterator();
        while(itr.hasNext()){
            Conexion con=itr.next();
            if(con.getPc().getPcIp().equals(ip)){
                clientesActivos.remove(con);
                con.setFin(new Date());
                ConexionDAO ins=new ConexionDAO();
                try {
                    ins.save(con);
                } catch (Exception ex) {
                    //Logger.getLogger(PcClienteBean.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
                return true;
            }                   
        }
        return false;
        //
    }
    
    public static boolean ExistePcActiva(Pc pc){
        
        ListIterator <Pc> iterador=pcActivas.listIterator();
        while(iterador.hasNext()){
            Pc pc2=iterador.next();
            if (pc2.equals(pc))
                return true;
        }
        return false;
        
    }
    public List<Pc> getPcActivas() {
        return pcActivas;
    }

   

    public static List<Conexion> getClientesActivos() {
        return clientesActivos;
    }

}
