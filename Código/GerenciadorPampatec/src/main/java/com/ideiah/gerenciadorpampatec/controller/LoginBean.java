/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.util.CpfUtil;
import com.ideiah.gerenciadorpampatec.dao.EmpreendedorDao;
import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.util.CriptografiaUtil;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Augusto César Görgen classe usada para realizar login do empreendedor
 * no sistema
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
                if (CpfUtil.isValidCPF(user)) {
                    empreendedor = empreendedor.buscarPorCpf(user);
                } else {
                    FacesUtil.addErrorMessage("CPF Invalido");
                    System.out.println("cpf invalido");
                }
            } else {
                empreendedor = empreendedor.buscarPorEmail(user);
            }
            senha = CriptografiaUtil.md5(senha);
            System.out.println(senha);
            if (empreendedor.getSenha().equals(senha)) {
                FacesUtil.addSuccessMessage("Logado");
                System.out.println("Logado");
                session.setAttribute("empreendedor", empreendedor);
                return "success";
                
//              return "redirect:homeEmpreendedor";
                
            } else {
                FacesUtil.addSuccessMessage("Senha incorreta");
                System.out.println("senha incorreta");
                System.out.println(senha);
                return "failure";
            }
        } catch (NullPointerException nullpointer) {
            FacesUtil.addErrorMessage("Empreendedor não cadastro");
            System.out.println("Empreendedor não cadastro");
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
