/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import clio.Entities.Conexion;
import clio.Entities.Pc;
import clio.dao.PcDAO;
import java.util.LinkedList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Clio
 */
public class PcClienteBeanTest extends TestCase {
    
    public PcClienteBeanTest(String testName) {
        super(testName);
    }

    /**
     * Test of AgregarPc method, of class PcClienteBean.
     */
    public void testAgregarPc() {
        System.out.println("AgregarPc");
        Pc pc = null;
        PcClienteBean.AgregarPc(pc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ElimiarPc method, of class PcClienteBean.
     */
    public void testElimiarPc() {
        System.out.println("ElimiarPc");
        Pc pc = null;
        PcClienteBean.ElimiarPc(pc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarConexion method, of class PcClienteBean.
     */
    public void testAgregarConexion() {
        System.out.println("AgregarConexion");
        Conexion con = null;
        PcClienteBean.AgregarConexion(con);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ElimiarConexion method, of class PcClienteBean.
     */
    public void testElimiarConexion() {
        System.out.println("ElimiarConexion");
        String ip = "";
        boolean expResult = false;
        boolean result = PcClienteBean.ElimiarConexion(ip);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ExistePcActiva method, of class PcClienteBean.
     */
    public void testExistePcActiva_Pc() {
        System.out.println("ExistePcActiva");
        Pc pc = null;
        boolean expResult = false;
        boolean result = PcClienteBean.ExistePcActiva(pc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existePcActiva method, of class PcClienteBean.
     */
    public void testExistePcActiva_Long() {
        System.out.println("existePcActiva");
        Long id = (long)31;
     
                PcDAO a= new PcDAO();
                Pc ap=a.getByID((long)31);
                Conexion conect=new Conexion();
                conect.setPc(ap);
                PcClienteBean.AgregarConexion(conect);
        boolean expResult = true;
        boolean result = PcClienteBean.existePcActiva(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getPcActivas method, of class PcClienteBean.
     */
    public void testGetPcActivas() {
        System.out.println("getPcActivas");
        PcClienteBean instance = new PcClienteBean();
        List expResult = null;
        List result = instance.getPcActivas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientesActivos method, of class PcClienteBean.
     */
    public void testGetClientesActivos() {
        System.out.println("getClientesActivos");
        List expResult = null;
        List result = PcClienteBean.getClientesActivos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
