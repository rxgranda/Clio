/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.dao;


import clio.interfaces.DAOInterface;
import clio.Entities.Modulo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import clio.util.HibernateUtil;

/**
 *
 * @author CLIO's Developer Team
 * 
 * Clase:       ModuloDAO
 * Descripcion: Implementa DAOInterface esto hace que entre otras cosas pueda manejar la persistencia 
				con la base de datos.
 * ultima 
 * modificaci�n:22 de Enero del 2013
 */
public class ModuloDAO implements DAOInterface{
    
    @Override
    public void save(Object mod) throws Exception {
       Modulo modulo=(Modulo)mod;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.merge(modulo);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }

    @Override
    public Modulo getByID(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Modulo) session.load(Modulo.class, id);
    }
     
    @Override
    public List<Modulo> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();       
        List lista = session.createQuery("from Modulo").list();      
        return lista;
    }
     
    @Override
    public void remove(Object mod) throws Exception {
         Modulo modulo=(Modulo)mod;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.delete(modulo);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }

    @Override
    public void update(Object mod) throws Exception {
         Modulo modulo=(Modulo)mod;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.merge(modulo);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }      
}
