/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import clio.Entities.Pc;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author HARRY
 */
public class PcBeanTest extends TestCase {
    
    public PcBeanTest(String testName) {
        super(testName);
    }

    /**
     * Test of prepararSave method, of class PcBean.
     */
    public void testPrepararSave() {
        System.out.println("prepararSave");
        PcBean instance = new PcBean();
        instance.prepararSave();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepararUpdate method, of class PcBean.
     */
    public void testPrepararUpdate() {
        System.out.println("prepararUpdate");
        long id = 0L;
        PcBean instance = new PcBean();
        instance.prepararUpdate(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepararDelete method, of class PcBean.
     */
    public void testPrepararDelete() {
        System.out.println("prepararDelete");
        long id = 0L;
        PcBean instance = new PcBean();
        instance.prepararDelete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class PcBean.
     */
    public void testSave() {
        System.out.println("save");
        PcBean instance = new PcBean();
        instance.save();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class PcBean.
     */
    public void testUpdate() {
        System.out.println("update");
        PcBean instance = new PcBean();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class PcBean.
     */
    public void testDelete() {
        System.out.println("delete");
        PcBean instance = new PcBean();
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPc method, of class PcBean.
     */
    public void testGetPc() {
        System.out.println("getPc");
        PcBean instance = new PcBean();
        Pc expResult = null;
        Pc result = instance.getPc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPc method, of class PcBean.
     */
    public void testSetPc() {
        System.out.println("setPc");
        Pc pc = null;
        PcBean instance = new PcBean();
        instance.setPc(pc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPcsList method, of class PcBean.
     */
    public void testGetPcsList() {
        System.out.println("getPcsList");
        PcBean instance = new PcBean();
        List expResult = null;
        List result = instance.getPcsList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getiDlab method, of class PcBean.
     */
    public void testGetiDlab() {
        System.out.println("getiDlab");
        PcBean instance = new PcBean();
        Long expResult = null;
        Long result = instance.getiDlab();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setiDlab method, of class PcBean.
     */
    public void testSetiDlab() {
        System.out.println("setiDlab");
        Long iDlab = null;
        PcBean instance = new PcBean();
        instance.setiDlab(iDlab);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
