/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author AugustoCesar
 */
@ManagedBean
@SessionScoped
public class EmpreendedorBean {

    private String outcome = "LoginEmpreendedor";
    private String userInput = "";
    private String senhaInput = "";
//    private static Empreendedor empreendedor;
    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
    /**
     * @param u usuário que será adicionado na sessão
     */
//    public void efetuarLogin(Empreendedor emp) {
//        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", emp);
//    }

    public void chamaCadastro() {

    }

//    public void chamaLogin() {
//        empreendedor.fazLogin();
//    }
    /**
     * @return the senhaInput
     */
    public String getSenhaInput() {
        return senhaInput;
    }

    /**
     * @param senhaInput the senhaInput to set
     */
    public void setSenhaInput(String senhaInput) {
        this.senhaInput = senhaInput;
    }
}
