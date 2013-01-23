/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.dao;

import clio.Entities.Laboratorio;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author HARRY
 */
public class LaboratorioDAOTest extends TestCase {
    
    public LaboratorioDAOTest(String testName) {
        super(testName);
    }

    /**
     * Test of save method, of class LaboratorioDAO.
     */
    public void testSave() throws Exception {
        System.out.println("save");
        Object lab = new Laboratorio();
        LaboratorioDAO instance = new LaboratorioDAO();
        instance.save(lab);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(lab, lab);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByID method, of class LaboratorioDAO.
     */
    public void testGetByID() {
        System.out.println("getByID");
        long id = 1;
        LaboratorioDAO instance = new LaboratorioDAO();
        Laboratorio expResult = null;
        Laboratorio result = instance.getByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class LaboratorioDAO.
     */
    public void testList() {
        System.out.println("list");
        LaboratorioDAO instance = new LaboratorioDAO();
        List expResult = null;
        List result = instance.list();
        assertNotNull(expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class LaboratorioDAO.
     */
    public void testRemove() throws Exception {
        System.out.println("remove");
        LaboratorioDAO a=new LaboratorioDAO();
        
        Object lab = a.getByID(1);
        LaboratorioDAO instance = new LaboratorioDAO();
        instance.remove(lab);
        // TODO review the generated test code and remove the default call to fail.
        assertNotNull(lab);
    }

    /**
     * Test of update method, of class LaboratorioDAO.
     */
    public void testUpdate() throws Exception {
        System.out.println("update");
      
        LaboratorioDAO instance = new LaboratorioDAO();
          Laboratorio lab = instance.getByID(12);
          lab.setLabNombre("nuevo");
        instance.update(lab);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(lab.getLabNombre(), "nombre");
    }
}
