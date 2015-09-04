/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.util.Auxiliar;
import com.ideiah.gerenciadorpampatec.dao.EmpreendedorDao;
import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Augusto César Görgen
 * classe usada para realizar login do empreendedor no sistema
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    private static EmpreendedorDao empreededorDao;
    private String user; //pode ser email ou senha
    private String senha;

    public void submit() {
        try {
            fazLogin(user, senha);
        } catch (Exception e) {
            System.out.println("Exceção inesperada" + e);
        }
    }

    public String fazLogin(String user, String senha) {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            Empreendedor empreendedor = new Empreendedor();
            if (soContemNumeros(user)) {
                if (Auxiliar.isValidCPF(user)) {
                    empreendedor = empreendedor.buscarPorCpf(user);
                } else {
                    FacesUtil.addErrorMessage("CPF Invalido");
                }
            } else {
                empreendedor = empreendedor.buscarPorEmail(user);
            }
            if (empreendedor.getSenha().equals(senha)) {
                FacesUtil.addSuccessMessage("Logado");
                session.setAttribute("empreendedor", empreendedor);
                return "success";

            } else {
                FacesUtil.addSuccessMessage("Senha incorreta");
                return "failure";
            }
        } catch (NullPointerException nullpointer) {
            FacesUtil.addErrorMessage("Empreendedor não cadastro");
            return "failure";
        }

    }
    
    //VERIFICA SE A STRING CONTEM APENAS NÚMEROS
    public static boolean soContemNumeros(String texto) {
        if (texto == null) {
            return false;
        }
        for (char letra : texto.toCharArray()) {
            if (letra < '0' || letra > '9') {
                return false;
            }
        }
        return true;

    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

}
