/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import clio.Entities.Usuario;
import clio.dao.UsuarioDAO;
import clio.interfaces.EntitiesBeanInterface;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author CLIO's Developer Team
 * 
 * Clase:       UsuarioBean
 * Descripción: Clase que utiliza UsuarioDAO para realizar operaciones con
 *              los datos en la Base de Datos.
 * Última 
 * modificación:22 de Enero del 2013
 */
@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable, EntitiesBeanInterface {

    /**
     * Creates a new instance of UsuarioBean
     */
    private  String role_user="ROLE_USER";

    public String getRole_user() {
        return role_user;
    }

    public void setRole_user(String role_user) {
        this.role_user = role_user;
    }

  
   
    UsuarioDAO ins=new UsuarioDAO();
    private Usuario usuario;
    private List<Usuario> usuariosList;
    private String rol;

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

  
    
    public UsuarioBean() {
         usuario= new Usuario();  
        
    }
    
    @Override
    public void prepararSave(){
        usuario=new Usuario();
         rol=null;
    }
    
    @Override
    public void prepararUpdate( long id){
        usuario=null;
        usuario=ins.getByID(id);
        rol=usuario.getRolesUsuarioses().iterator().next().getRuAuthority();
    }
    
    @Override
    public void prepararDelete(long id){        
        usuario=ins.getByID(id);
    }
    
    @Override
    public void save() {
        FacesContext context = FacesContext.getCurrentInstance();            
        try {
            ins.save(usuario,rol);             
            context.addMessage(null, new FacesMessage("¡Éxito!", "Usuario creado exitosamente"));
        } catch (Exception ex) {
             context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al guardar")); 
          
        }
     }
    
    @Override
     public void update(){
        FacesContext context = FacesContext.getCurrentInstance();            
        try {
            ins.update(usuario,rol);             
            context.addMessage(null, new FacesMessage("¡Éxito!", "Usuario modificado exitosamente"));
        }catch (Exception ex) {
            context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al guardar"));
        }                           
     }
      
    @Override
     public void delete(){
        FacesContext context = FacesContext.getCurrentInstance();            
         try {
             ins.remove(usuario);             
             context.addMessage(null, new FacesMessage("¡Éxito!", "Usuario eliminado exitosamente"));               
         }catch (Exception ex) {
              context.addMessage(null, new FacesMessage("¡Error!", "Ha ocurrido un error al tratar de eliminar"));               
         }
     }
     
     public Usuario getUsuario() {
        return usuario;
     }

     public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
     }

     public List<Usuario> getUsuariosList() {
        UsuarioDAO lista=new UsuarioDAO();
        usuariosList=lista.list();
        return usuariosList;
     }      
     /**
      * 
      * @param matricula
      * @return 
      */
     public Usuario searchUser(String matricula){
        List<Usuario> lista = getUsuariosList();

        for (Usuario usuario : lista) {
            if(usuario.getUsMatricula()!=null){
                if(usuario.getUsMatricula().equals(matricula)){
                     return usuario;
                }
            }
        }
        return null;
     }
}
