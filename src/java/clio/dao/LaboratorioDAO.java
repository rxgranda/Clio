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
 * @author CLIO's Developer Team
 * 
 * Clase:       LaboratorioDAO
 * Descripcion: Implementa DAOInterface esto hace que entre otras cosas pueda manejar la persistencia 
				con la base de datos.
 * ultima 
 * modificacion:22 de Enero del 2013
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
         
            t= session.beginTransaction();
            Object flag= session.merge(laboratorio);
            session.delete(flag);
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
