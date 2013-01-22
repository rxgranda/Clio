/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.dao;


import clio.interfaces.DAOInterface;
import clio.Entities.RolesUsuarios;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import clio.util.HibernateUtil;

/**
 *
 * @author Roger
 */
public class RolesUsuariosDAO implements DAOInterface{
    
    @Override
    public void save(Object rolUser) throws Exception {
       RolesUsuarios roles=(RolesUsuarios)rolUser;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.merge(roles);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }

    @Override
    public RolesUsuarios getByID(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (RolesUsuarios) session.load(RolesUsuarios.class, id);
    }
     
    @Override
    public List<RolesUsuarios> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();       
        List lista = session.createQuery("from RolesUsuarios").list();      
        return lista;
    }
     
    @Override
    public void remove(Object rolUser) throws Exception {
         RolesUsuarios roles=(RolesUsuarios)rolUser;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.delete(roles);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }

    @Override
    public void update(Object rolUser) throws Exception {
         RolesUsuarios roles=(RolesUsuarios)rolUser;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t ;
        try{
            t= session.beginTransaction();
            session.merge(roles);
            t.commit();
        }catch(Exception e){
            t=session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }     
    }      
}
