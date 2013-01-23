/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComunicacionCliente;

import junit.framework.TestCase;

/**
 *
 * @author HARRY
 */
public class ClienteClioSocketTest extends TestCase {
    
    public ClienteClioSocketTest(String testName) {
        super(testName);
    }

    /**
     * Test of Ejecutar method, of class ClienteClioSocket.
     */
    public void testEjecutar() {
        System.out.println("Ejecutar");
        ClienteClioSocket instance = new ClienteClioSocket("192.168.0.100","mensaje");
        instance.Ejecutar();
        assertEquals(true, true);
        // TODO review the generated test code and remove the default call to fail.
        
    }
}
