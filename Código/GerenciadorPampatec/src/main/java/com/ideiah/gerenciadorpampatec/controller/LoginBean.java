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
import com.mysql.jdbc.Util;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AugustoCesar
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    private static EmpreendedorDao empreededorDao;
    private String user; //pode ser email ou senha
    private String senha;
//    Empreendedor empreendedor = new Empreendedor();
//    public HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

//    public void verificar(){
//        FacesUtil.addSuccessMessage(">>>"+session.getAttribute("empreendedor"));
//    }
    public void submit() {
        try {
//            System.out.println(getUserInput());
//       empreendedor.fazLogin(getUserInput(), getSenhaInput());
            fazLogin(user, senha);

        } catch (Exception e) {
            System.out.println("?????" + e);
        }
//        this.userInput = "The user has entered \"" + this.userInput + " \"";
//        return "";
    }

    public String fazLogin(String user, String senha) {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

            System.out.println("chegou");

            Empreendedor empreendedor = new Empreendedor();
            if (soContemNumeros(user)) {
                System.out.println("passou1");
                if (Auxiliar.isValidCPF(user)) {
                    empreendedor = empreendedor.buscarPorCpf(user);
                } else {
                    FacesUtil.addErrorMessage("CPF Invalido");
                    System.out.println("CPF invalido");
                }
            } else {
                empreendedor = empreendedor.buscarPorEmail(user);

            }
            System.out.println(empreendedor.getEmail() + "   " + empreendedor.getSenha());
            if (empreendedor.getSenha().equals(senha)) {
                FacesUtil.addSuccessMessage("Logado");
                System.out.println("senha correta");
                session.setAttribute("empreendedor", empreendedor);
                return "success";

            } else {
                FacesUtil.addSuccessMessage("Senha incorreta");
                System.out.println("senha incorreta");
                return "failure";

            }
        } catch (NullPointerException nullpointer) {
            FacesUtil.addErrorMessage("Empreendedor não cadastro");
            System.out.println("Esse empreendedor não existe!");
//            return false;
            return "failure";
        }
    
}

public static boolean soContemNumeros(String texto) {
//        return texto.matches("[0-9]");
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
