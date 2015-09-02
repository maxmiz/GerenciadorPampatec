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
import com.ideiah.gerenciadorpampatec.dao.EmpreededorDao;

/**
 *
 * @author AugustoCesar
 */
@ManagedBean (name = "empreendedorBean")
@SessionScoped
public class EmpreendedorBean {

    private String outcome = "LoginEmpreendedor";
    private String userInput = "";
    private String senhaInput = "";
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
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

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
