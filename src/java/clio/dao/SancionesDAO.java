/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.dao;


import clio.interfaces.DAOInterface;
import clio.Entities.Sanciones;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import clio.util.HibernateUtil;

/**
 *
 * @author CLIO's Developer Team
 * 
 * Clase:       SancionesDAO
 * Descripción: Implementa DAOInterface esto hace que entre otras cosas pueda manejar la persistencia 
				con la base de datos.
 * Última 
 * modificación:22 de Enero del 2013
 */
public class SancionesDAO implements DAOInterface{
    
    @Override
    public void save(Object sancionUser) throws Exception {
       Sanciones sancion=(Sanciones)sancionUser;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.merge(sancion);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }

    @Override
    public Sanciones getByID(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Sanciones) session.load(Sanciones.class, id);
    }
     
    @Override
    public List<Sanciones> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();       
        List lista = session.createQuery("from Sanciones").list();      
        return lista;
    }
     
    @Override
    public void remove(Object sancionUser) throws Exception {
         Sanciones sancion=(Sanciones)sancionUser;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.delete(sancion);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }

    @Override
    public void update(Object sancionUser) throws Exception {
         Sanciones sancion=(Sanciones)sancionUser;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.merge(sancion);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }    
    public List<Sanciones> listVigentes() {
        Session session = HibernateUtil.getSessionFactory().openSession();       
        List lista = session.createQuery("from Sanciones where saVigencia like 'Vigente'").list();      
        System.out.println("Numero de filas: "+lista.size());
        return lista;
    }
}
