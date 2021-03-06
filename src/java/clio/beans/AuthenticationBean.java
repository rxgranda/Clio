/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clio.beans;

import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author CLIO's Developer Team
 * 
 * Clase:       AuthenticationBean
 * Descripción: Clase que obtiene los parametros ingresados para iniciar sesión de 
				administrador y hace llamdo a String Security para que los autentique.
 * Última 
 * modificación:22 de Enero del 2013
 */

@Named("authenticationbean")
@SessionScoped
public class AuthenticationBean implements Serializable
{
    public String doLogin() throws IOException, ServletException
    {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest)context.getRequest()).getRequestDispatcher("/j_spring_security_check");
        dispatcher.forward((ServletRequest)context.getRequest(), (ServletResponse)context.getResponse());
        FacesContext.getCurrentInstance().responseComplete();
        return null;
    }

    public String doLogout()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/error.jsp";
    }
}