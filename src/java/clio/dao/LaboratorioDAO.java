/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.dao;


import clio.interfaces.DAOInterface;
import clio.Entities.Laboratorio;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import clio.util.HibernateUtil;

/**
 *
 * @author Roger
 */
public class LaboratorioDAO implements DAOInterface{
    
    @Override
    public void save(Object lab) throws Exception {
       Laboratorio laboratorio=(Laboratorio)lab;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.merge(laboratorio);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }

    @Override
    public Laboratorio getByID(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Laboratorio) session.load(Laboratorio.class, id);
    }
     
    @Override
    public List<Laboratorio> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();       
        List lista = session.createQuery("from Laboratorio").list();      
        return lista;
    }
     
    @Override
    public void remove(Object lab) throws Exception {
         Laboratorio laboratorio=(Laboratorio)lab;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            System.out.println(laboratorio.getLabId());
            t= session.beginTransaction();
            session.delete(laboratorio);
            t.commit();
        }catch(Exception e){
            e.printStackTrace();
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }

    @Override
    public void update(Object lab) throws Exception {
         Laboratorio laboratorio=(Laboratorio)lab;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.merge(laboratorio);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }      
}
