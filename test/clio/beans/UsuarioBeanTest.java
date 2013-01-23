/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import clio.Entities.Usuario;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author HARRY
 */
public class UsuarioBeanTest extends TestCase {
    
    public UsuarioBeanTest(String testName) {
        super(testName);
    }

    /**
     * Test of prepararSave method, of class UsuarioBean.
     */
    public void testPrepararSave() {
        System.out.println("prepararSave");
        UsuarioBean instance = new UsuarioBean();
        instance.prepararSave();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepararUpdate method, of class UsuarioBean.
     */
    public void testPrepararUpdate() {
        System.out.println("prepararUpdate");
        long id = 0L;
        UsuarioBean instance = new UsuarioBean();
        instance.prepararUpdate(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepararDelete method, of class UsuarioBean.
     */
    public void testPrepararDelete() {
        System.out.println("prepararDelete");
        long id = 0L;
        UsuarioBean instance = new UsuarioBean();
        instance.prepararDelete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class UsuarioBean.
     */
    public void testSave() {
        System.out.println("save");
        UsuarioBean instance = new UsuarioBean();
        instance.save();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class UsuarioBean.
     */
    public void testUpdate() {
        System.out.println("update");
        UsuarioBean instance = new UsuarioBean();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class UsuarioBean.
     */
    public void testDelete() {
        System.out.println("delete");
        UsuarioBean instance = new UsuarioBean();
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario method, of class UsuarioBean.
     */
    public void testGetUsuario() {
        System.out.println("getUsuario");
        UsuarioBean instance = new UsuarioBean();
        Usuario expResult = null;
        Usuario result = instance.getUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuario method, of class UsuarioBean.
     */
    public void testSetUsuario() {
        System.out.println("setUsuario");
        Usuario usuario = null;
        UsuarioBean instance = new UsuarioBean();
        instance.setUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuariosList method, of class UsuarioBean.
     */
    public void testGetUsuariosList() {
        System.out.println("getUsuariosList");
        UsuarioBean instance = new UsuarioBean();
        List expResult = null;
        List result = instance.getUsuariosList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchUser method, of class UsuarioBean.
     */
    public void testSearchUser() {
        System.out.println("searchUser");
        String matricula = "";
        UsuarioBean instance = new UsuarioBean();
        Usuario expResult = null;
        Usuario result = instance.searchUser(matricula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
