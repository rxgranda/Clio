/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import clio.Entities.Laboratorio;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author HARRY
 */
public class LaboratorioBeanTest extends TestCase {
    
    public LaboratorioBeanTest(String testName) {
        super(testName);
    }

    /**
     * Test of prepararSave method, of class LaboratorioBean.
     */
    public void testPrepararSave() {
        System.out.println("prepararSave");
        LaboratorioBean instance = new LaboratorioBean();
        instance.prepararSave();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepararUpdate method, of class LaboratorioBean.
     */
    public void testPrepararUpdate() {
        System.out.println("prepararUpdate");
        long id = 0L;
        LaboratorioBean instance = new LaboratorioBean();
        instance.prepararUpdate(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepararDelete method, of class LaboratorioBean.
     */
    public void testPrepararDelete() {
        System.out.println("prepararDelete");
        long id = 0L;
        LaboratorioBean instance = new LaboratorioBean();
        instance.prepararDelete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class LaboratorioBean.
     */
    public void testSave() {
        System.out.println("save");
        LaboratorioBean instance = new LaboratorioBean();
        instance.save();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class LaboratorioBean.
     */
    public void testUpdate() {
        System.out.println("update");
        LaboratorioBean instance = new LaboratorioBean();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class LaboratorioBean.
     */
    public void testDelete() {
        System.out.println("delete");
        LaboratorioBean instance = new LaboratorioBean();
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLaboratorio method, of class LaboratorioBean.
     */
    public void testGetLaboratorio() {
        System.out.println("getLaboratorio");
        LaboratorioBean instance = new LaboratorioBean();
        Laboratorio expResult = null;
        Laboratorio result = instance.getLaboratorio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLaboratorio method, of class LaboratorioBean.
     */
    public void testSetLaboratorio() {
        System.out.println("setLaboratorio");
        Laboratorio laboratorio = null;
        LaboratorioBean instance = new LaboratorioBean();
        instance.setLaboratorio(laboratorio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLaboratoriosList method, of class LaboratorioBean.
     */
    public void testGetLaboratoriosList() {
        System.out.println("getLaboratoriosList");
        LaboratorioBean instance = new LaboratorioBean();
        List expResult = null;
        List result = instance.getLaboratoriosList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of matrizLab method, of class LaboratorioBean.
     */
    public void testMatrizLab() {
        System.out.println("matrizLab");
        LaboratorioBean instance = new LaboratorioBean();
        List expResult = null;
        List result = instance.matrizLab();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
