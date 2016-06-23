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
import javax.faces.context.FacesContext;

/**
 * <p>
 * Classe responsável por manipular os redirecionamentos dentro do sistema, 
 * futuramente ela irá utilizar o mapeamento de URLs também.</p>
 *
 * @author PC Unipampa
 */
@ManagedBean
public class RedirectManager implements Serializable {

    public RedirectManager() {
    }

    /**
     * <p>
     * Método responsável por redirecionar para a página inicial do sistema.</p>
     *
     */
    public static void getLogout() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/GerenciadorPampatec");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Método que redireciona para a página inicial do empreendedor.</p>
     */
    public static void getInicio() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("homeEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Método que redireciona para a página inicial do empreendedor, voltando da
     * página de revisar plano de negócio.</p>
     */
    public void getInicioRevisar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../homeEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Método que redireciona para a página inicial do empreendedor.</p>
     */
    public static void getInicioEmpreendedor() {
        try {
            SessionManager.getFacesContext().getExternalContext().redirect("view/empreendedor/homeEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(SystemAccessBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Método que redireciona para a página inicial do gerente.</p>
     */
    public static void getInicioGerente() {
        try {
            SessionManager.getFacesContext().getExternalContext().redirect("view/gerentederelacionamento/homeGerenteDeRelacionamentos.jsf");
        } catch (IOException ex) {
            Logger.getLogger(SystemAccessBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * <p>
     * Método que redireciona para a página inicial do gerente após estar logado.</p>
     */
    public static void getInicioGerenteLogado() {
        try {
            SessionManager.getFacesContext().getExternalContext().redirect("homeGerenteDeRelacionamentos.jsf");
        } catch (IOException ex) {
            Logger.getLogger(SystemAccessBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * <p>
     * Método que redireciona para a página de criar planos de negócio do
     * empreendedor.</p>
     */
    public void getEnviarProjeto() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("empreendedor/enviarProjeto.jsf");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Redireciona para a página que contem a tabela de de plano de negócio, na
     * visão do Gerente de Relacionamento.
     * </p>
     */
    public void getVisualizarPlanosGerente() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("buscarPlanoDeNegocio.jsf");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Redireciona para a página que contem a tabela de de plano de negócio do
     * empreendedor.</p>
     */
    public void getVisualizarPlanos() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("paginaBuscaPlanoDeNegocio.jsf");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * </p>
     *
     */
    public void getVisualizarPlanosRevisar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../paginaBuscaPlanoDeNegocio.jsf");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *<p>Método que redireciona para a página com a Lista de Planos de Negócio. </p>
     */
    public static void enviaBuscaProjeto() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("paginaBuscaPlanoDeNegocio.jsf");
        } catch (IOException ex) {
            Logger.getLogger(RedirectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
