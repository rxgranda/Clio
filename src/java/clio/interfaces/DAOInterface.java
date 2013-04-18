/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.interfaces;

import clio.Entities.Laboratorio;
import java.util.List;

/**
 *
 * @author CLIO's Developer Team
 * 
 * Interface:       DAOInterface
 * Descripcion: 	Declara las operaciones que deben implementar las clases DAO
					para manejar la persisntencia con los datos de en la base.
 * ultima 
 * modificacion:22 de Enero del 2013
 */
public interface DAOInterface {
    public void save(Object lab) throws Exception;    
    public List list();
    public void remove(Object lab)throws Exception;
    public void update(Object lab)throws Exception;
    public Object getByID(long id); 
    
}
