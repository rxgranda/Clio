/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.interfaces;


/**
 *
 * @author Roger
 */
public interface EntitiesBeanInterface {      
    public void prepararSave();    
    public void prepararUpdate(long id);    
    public void prepararDelete(long id);    
    public void save();    
    public void update();      
    public void delete();             
}
