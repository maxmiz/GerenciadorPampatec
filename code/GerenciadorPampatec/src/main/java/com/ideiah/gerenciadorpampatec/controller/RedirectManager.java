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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * <p>
 * Classe com código legado, pois no futuro ela deverá se chamar
 * <code>RedirectManager</code> a qual manipulará somente os redirecionamentos
 * dentro do sistema, juntamente com o mapeamento das URLs do mesmo. A tag
 * @Deprecated foi utilizada para demarcar que essa é uma classe com depreciada
 * e que deve ser refatorada.</p>
 *
 * @author Augusto César Görgen
 */
@Deprecated
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    public LoginBean() {
    }

    /**
     * <p>
     * Método que realiza logout do sistema, garantido o status correto do
     * projeto e finalizando a sessão do usuário. ESSE MÉTODO DEVE SER MOVIDO PARA A CLASSE <code>LoginNoSessionBean</code></p>
     */
    public void fazLogout() {
        ProjectSatusManager.tratamentoStatusSendoAvaliado();
        SessionManager.finalizaSessao();
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/GerenciadorPampatec");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * <p>
     * Método que redireciona para a página inicial do empreendedor.</p>
     */
    public void getInicio() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("homeEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Método que redireciona para a página inicial do gerente.</p>
     */
    public void getInicioGerente() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("homeGerenteDeRelacionamentos.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getVisualizarPlanosRevisar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../paginaBuscaPlanoDeNegocio.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void voltar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("loginEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Método para redirecionar o usuário para a página de login, invocado de
     * uma das páginas de erro do diretório WEB-INF.</p>
     */
    public void voltarDoErroParaLogin() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/GerenciadorPampatec/loginEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviaBuscaProjeto() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("paginaBuscaPlanoDeNegocio.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
