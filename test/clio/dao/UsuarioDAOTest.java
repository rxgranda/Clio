/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.dao;

import clio.Entities.Usuario;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author HARRY
 */
public class UsuarioDAOTest extends TestCase {
    
    public UsuarioDAOTest(String testName) {
        super(testName);
    }

    /**
     * Test of save method, of class UsuarioDAO.
     */
    public void testSave() throws Exception {
        System.out.println("save");
        Object user = null;
        UsuarioDAO instance = new UsuarioDAO();
        instance.save(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByID method, of class UsuarioDAO.
     */
    public void testGetByID() {
        System.out.println("getByID");
        long id = 4;
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = null;
        Usuario result = instance.getByID(id);
        assertEquals(expResult.getUsUsername(), "rxgranda");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class UsuarioDAO.
     */
    public void testList() {
        System.out.println("list");
        UsuarioDAO instance = new UsuarioDAO();
        List expResult = null;
        List result = instance.list();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class UsuarioDAO.
     */
    public void testRemove() throws Exception {
        System.out.println("remove");
        Object user = null;
        UsuarioDAO instance = new UsuarioDAO();
        instance.remove(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class UsuarioDAO.
     */
    public void testUpdate() throws Exception {
        System.out.println("update");
        UsuarioDAO instance = new UsuarioDAO();
          Usuario lab = instance.getByID(12);
          lab.setUsNombres("nuevo");
        instance.update(lab);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(lab.getUsNombres(), "nombre");
    }

    /**
     * Test of getUsuarioByUsername method, of class UsuarioDAO.
     */
    public void testGetUsuarioByUsername() {
        System.out.println("getUsuarioByUsername");
        String username = "rxgranda";
        UsuarioDAO instance = new UsuarioDAO();
        Usuario expResult = null;
        Usuario result = instance.getUsuarioByUsername(username);
        assertNotNull( result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of existeUsuario method, of class UsuarioDAO.
     */
    public void testExisteUsuario() {
        System.out.println("existeUsuario");
        String username = "rxgranda";
        UsuarioDAO instance = new UsuarioDAO();
        boolean expResult = false;
        boolean result = instance.existeUsuario(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
