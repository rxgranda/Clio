/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.dao;


import clio.interfaces.DAOInterface;
import clio.Entities.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import clio.util.HibernateUtil;
import org.hibernate.Query;

/**
 *
 * @author CLIO's Developer Team
 * 
 * Clase:       UsuarioDAO
 * Descripcion: Implementa DAOInterface esto hace que entre otras cosas pueda manejar la persistencia 
				con la base de datos.
 * ultima 
 * modificacion:22 de Enero del 2013
 */
public class UsuarioDAO implements DAOInterface{
    
    @Override
    public void save(Object user) throws Exception {
       Usuario usuario=(Usuario)user;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.merge(usuario);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }

    @Override
    public Usuario getByID(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Usuario) session.load(Usuario.class, id);
    }
     
    @Override
    public List<Usuario> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();       
        List lista = session.createQuery("from Usuario").list();      
        return lista;
    }
     
    @Override
    public void remove(Object user) throws Exception {
         Usuario usuario=(Usuario)user;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.delete(usuario);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }

    @Override
    public void update(Object user) throws Exception {
         Usuario usuario=(Usuario)user;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.merge(usuario);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }   
     public Usuario getUsuarioByUsername(String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery ("from Usuario as s where  s.usUsername='"+username+"'");
        List<Usuario> pro = q.list();
         System.out.println("1");
         t.commit();
        if(pro!=null){
            if(pro.size()>0){
                System.out.println("2");
                return pro.listIterator().next();
            }else{
                System.out.println("3");           
                return null;
            }
        } 
        return null;
    }
     
     public boolean existeUsuario(String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery ("from Usuario as s where  s.usUsername='"+username+"'");
        List<Usuario> pro = q.list();
         //System.out.println("1");
         t.commit();
        if(pro!=null){
            if(pro.size()>0){
               // System.out.println("2");
                return true;
            }else{
                //System.out.println("3");           
                return false;
            }
        } 
        return false;
    }
}
