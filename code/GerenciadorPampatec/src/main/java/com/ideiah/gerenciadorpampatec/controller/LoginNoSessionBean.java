/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author unipampa
 */
@ManagedBean
@RequestScoped
public class LoginNoSessionBean {

    private static String user; //pode ser email ou senha
    private static String senha;

    public LoginNoSessionBean() {
    }

    public void submit() {
        try {
            if (loginEmpreendedor(user, senha)) {
            } else if (loginGerente(user, senha)) {
            }
        } catch (Exception e) {
            System.out.println("Origem: " + this.getClass().getName()
                    + ":: \t Exceção inesperada" + e);
        }
    }

    private boolean loginEmpreendedor(String user, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean loginGerente(String user, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String aUser) {
        user = aUser;
    }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String aSenha) {
        senha = aSenha;
    }

}
