/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ideiah.gerenciadorpampatec.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * 
 * @author Jhonatan 
 */
@ManagedBean(name = "gerenteDeRelacionamentosBean")
@ViewScoped
public class GerenteDeRelacionamentosBean implements Serializable {
    
    /**
     * Retorna a tela de visualização da lista de planos de negócio
     */
    public void visualizarProjetos() {
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("avaliarPlanoDeNegocio.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ProjetoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
