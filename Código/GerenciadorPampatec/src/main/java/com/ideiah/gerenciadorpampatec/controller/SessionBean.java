
package com.ideiah.gerenciadorpampatec.controller;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
@ManagedBean
@SessionScoped
public class SessionBean {

    /**
     * Creates a new instance of SessionBean
     */
    public SessionBean() {
    }
    
    /**
     * @return Retorna a sessão do sistema
     */
    public HttpSession getSession(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return session;
    }
    
    /**
     * @return Retorna o FacesContext
     */
    public FacesContext getFacesContext(){
        return FacesContext.getCurrentInstance();
    }
    
}
