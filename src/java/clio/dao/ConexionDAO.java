/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.dao;

import clio.interfaces.DAOInterface;
import clio.Entities.Conexion;
import clio.Entities.Laboratorio;
import clio.Entities.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import clio.util.HibernateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ListIterator;

/**
 *
 * @author CLIO's Developer Team
 * 
 * Clase:       ConexionDAO
 * Descripcion: Implementa DAOInterface esto hace que entre otras cosas pueda manejar la persistencia 
				con la base de datos.
 * ultima 
 * modificacion:22 de Enero del 2013
 */
public class ConexionDAO implements DAOInterface {

    @Override
    public void save(Object conection) throws Exception {
        Conexion conexion = (Conexion) conection;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t;
        try {
            t = session.beginTransaction();
            session.merge(conexion);
            t.commit();
        } catch (Exception e) {
            t = session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }
    }

    @Override
    public Conexion getByID(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Conexion) session.load(Conexion.class, id);
    }

    @Override
    public List<Conexion> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List lista = session.createQuery("from Conexion").list();
        return lista;
    }

    @Override
    public void remove(Object conection) throws Exception {
        Conexion conexion = (Conexion) conection;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t;
        try {
            t = session.beginTransaction();
            Object flag= session.merge(conexion);
            session.delete(flag);
       
            t.commit();
        } catch (Exception e) {
            t = session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }
    }

    @Override
    public void update(Object conection) throws Exception {
        Conexion conexion = (Conexion) conection;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t;
        try {
            t = session.beginTransaction();
            session.merge(conexion);
            t.commit();
        } catch (Exception e) {
            t = session.beginTransaction();
            t.rollback();
            throw new Exception("");
        }
    }

    public List<Conexion> listByTerm(String term) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from Conexion c where year(c.inicio) = '0'";
        if (!term.equalsIgnoreCase(" ")) {
            String[] terminoSplit = term.split("[ ]+");
            if (terminoSplit[0].equalsIgnoreCase("Primer")) {
                query = ("from Conexion c where year(c.inicio) = '" + terminoSplit[2]
                        + "' and month(c.inicio)>='05' and month(c.inicio)<='09' "
                        + "group by month(c.inicio) order by month(c.inicio)");
            } else if (terminoSplit[0].equalsIgnoreCase("Segundo")) {
                int anio = Integer.parseInt(terminoSplit[2]) + 1;
                System.out.println(terminoSplit[0] + "++++++++++++" + anio);
                query = ("from Conexion c where ((year(c.inicio) = '" + Integer.parseInt(terminoSplit[2])
                        + "' and month(c.inicio)>='10' and month(c.inicio)<='12') "
                        + "or (year(c.inicio) = '" + anio
                        + "' and month(c.inicio)<'3')) "
                        + "group by month(c.inicio) order by c.inicio");
            }
        }
        List lista = session.createQuery(query).list();
        System.out.println(lista);
        return lista;
    }

    public List<Conexion> listByYear(int year, int month) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from Conexion c";
        //By Year String 
        if ((year != 0) || (month != 0)) {
            query = "from Conexion c where";
        }
        if (year != 0) {
            query = query.concat(" year(c.inicio) = '" + year + "'");
        }
        if ((year != 0) && (month != 0)) {
            query = query.concat(" and");
        }
        if (month != 0) {
            query = query.concat(" month(c.inicio) = '" + month + "'");
        }
        List lista = session.createQuery(query).list();
        System.out.println(lista);
        return lista;
    }

    public List<Conexion> listCountYear(int year) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "Select count(*) as cantidad, month(c.inicio) from Conexion c group by month(c.inicio) order by year(c.inicio)";
        //By Year String 
        if (year != 0) {
            query = "Select count(*) as cantidad, month(c.inicio) from Conexion c where year(c.inicio) = '" + year + "' group by month(c.inicio) order by month(c.inicio)";
        }

        List lista = session.createQuery(query).list();
        System.out.println(lista);
        return lista;
    }

    public List<Conexion> listCountTerm(String term) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "Select count(*) as cantidad, month(c.inicio) from Conexion c where year(c.inicio) = '0'";
        if (!term.equalsIgnoreCase(" ")) {
            String[] terminoSplit = term.split("[ ]+");
            System.out.println("++++++++++++" + terminoSplit[0] + "````" + terminoSplit[1] + "aaa" + terminoSplit[2]);
            if (terminoSplit[0].equalsIgnoreCase("Primer")) {
                query = ("Select count(*) as cantidad, month(c.inicio) from Conexion c where year(c.inicio) = '" + terminoSplit[2]
                        + "' and month(c.inicio)>='05' and month(c.inicio)<='09' "
                        + "group by month(c.inicio) order by month(c.inicio)");
            } else if (terminoSplit[0].equalsIgnoreCase("Segundo")) {
                int anio = Integer.parseInt(terminoSplit[2]) + 1;
                System.out.println(terminoSplit[0] + "++++++++++++" + anio);
                query = ("Select count(*) as cantidad, month(c.inicio) from Conexion c where (year(c.inicio) = '" + Integer.parseInt(terminoSplit[2])
                        + "' and month(c.inicio)>='10' and month(c.inicio)<='12') "
                        + "or (year(c.inicio) = '" + anio
                        + "' and month(c.inicio)<='2') "
                        + "group by month(c.inicio) order by c.inicio");
                //By Year String 
                //String query="from Conexion c where year(c.inicio) = '2012'";
                //By Year group by month 
                //String query = "Select count(*) as cantidad, month(c.inicio) as mes from Conexion c where year(c.inicio) = '2012' group by month(c.inicio) order by month(c.inicio)";
                //By Primer Termino group by month
                //String query="Select count(*) as Cantidad, month(c.inicio) as Mes from Conexion c where year(c.inicio) = '2012' and month(c.inicio)>='05' and month(c.inicio)<='09' group by month(c.inicio) order by month(c.inicio)";
                //By Segundo Termino group by month
                //String query="Select count(*) as Cantidad, month(c.inicio) as Mes from Conexion c where (year(c.inicio) = '2012' and month(c.inicio)>'10' and month(c.inicio)<'12') or "
                //        + "                                                    (year(c.inicio) = '2013' and month(c.inicio)='1' or month(c.inicio)='2') group by month(c.inicio)  order by month(c.inicio)";
            }
        }
        List lista = session.createQuery(query).list();
        System.out.println(lista);
        return lista;
    }

    public long duracionConexion(Usuario usuario, String ip) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        PcDAO pc = new PcDAO();
        Laboratorio lab = pc.PcByIP(ip).getLaboratorio();
        Long horasUso = lab.getLabTiempoUso();
        try{
        if (horasUso <= 0 || horasUso == null) {
            return -100; // Horas uso <=0 indica que no hay control de tiempo
        }}catch(Exception e){
             return -100; 
        }
        Date actual = new Date();
        SimpleDateFormat inicio = new SimpleDateFormat("yyyy-MM-dd");
        String inicio2 = inicio.format(actual);
        Date fecha = null;
        try {
            fecha = inicio.parse(inicio2);
        } catch (ParseException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
        SimpleDateFormat inicio3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // long diferencia= ( fecha.getTime() - actual.getTime() );

        List<Conexion> lista = session.createQuery("from Conexion con where con.usuario.usId= " + usuario.getUsId() + " and " + "con.inicio BETWEEN '" + inicio3.format(fecha) + "' and '" + inicio3.format(actual) + "'").list();
        ListIterator<Conexion> itr = lista.listIterator();
        long diferencia = 0;
        while (itr.hasNext()) {
            Conexion con = itr.next();
            diferencia += (con.getFin().getTime() - con.getInicio().getTime());
        }
        System.out.println(diferencia);

        long tiempo = horasUso - diferencia;
        if (tiempo < 0) {
            return (long) 0;
        }
        System.out.println(tiempo);
        return tiempo;
    }
}
