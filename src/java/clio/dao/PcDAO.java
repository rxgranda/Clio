/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.dao;


import clio.interfaces.DAOInterface;
import clio.Entities.Pc;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import clio.util.HibernateUtil;
import org.hibernate.Query;

/**
 *
 * @author Roger
 */
public class PcDAO implements DAOInterface{
    
    @Override
    public void save(Object pca) throws Exception {
       Pc pc=(Pc)pca;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.merge(pc);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }

    @Override
    public Pc getByID(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Pc) session.load(Pc.class, id);
    }
     
    @Override
    public List<Pc> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();       
        List lista = session.createQuery("from Pc").list();      
        return lista;
    }
     
    @Override
    public void remove(Object pca) throws Exception {
         Pc pc=(Pc)pca;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.delete(pc);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }

    @Override
    public void update(Object pca) throws Exception {
         Pc pc=(Pc)pca;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.merge(pc);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }   
     public List<Pc> pcXLabortorio(long idLab) {
        Session session = HibernateUtil.getSessionFactory().openSession();       
        List lista = session.createQuery("from Pc as p where p.laboratorio.labId="+idLab).list();      
        return lista;
    }
      public Pc PcByIP(String ip) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery ("from Pc as s where  s.pcIp='"+ip+"'");
        List lista = q.list();
        Pc pc;
        try{
            pc=(Pc) lista.listIterator().next();
        }catch( Exception e){
            return null;
        }
        t.commit();
        return pc;
    }
}
