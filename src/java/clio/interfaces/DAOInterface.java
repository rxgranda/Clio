/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.interfaces;

import clio.Entities.Laboratorio;
import java.util.List;

/**
 *
 * @author Clio
 */
public interface DAOInterface {
    public void save(Object lab) throws Exception;    
    public List list();
    public void remove(Object lab)throws Exception;
    public void update(Object lab)throws Exception;
    public Object getByID(long id); 
    
}
