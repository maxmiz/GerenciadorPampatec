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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.flow.builder.NavigationCaseBuilder;
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
    private static String user; //pode ser email ou senha
    private static String senha;
    private static String nome;

    private FacesContext fc = FacesContext.getCurrentInstance();
    private HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

    public void submit() {
        try {
            fazLogin(user, senha);
        } catch (Exception e) {
            System.out.println("Exceção inesperada" + e);
        }
    }

    public String fazLogout() {

        session.removeAttribute("empreendedor");
        LoginBean.MudarNome(null);
        LoginBean.MudarSenha(null);
        LoginBean.MudarUser(null);

        return "/loginEmpreendedor.xhtml";

    }
    
    public String getInicio(){
        return "homeEmpreendedor.xhtml";
    }
    
    public String getEnviarProjeto(){
        return "enviarProjeto.xhtml";
    }
    
    public String getVisualizarPlanos(){
        return "PaginaBuscaProjeto.xhtml";
    }
    
    public String voltar(){
        return "/loginEmpreendedor.xhtml";
    }
    
    public String fazLogin(String user, String senha) {
        try {
//            FacesContext fc = FacesContext.getCurrentInstance();
//            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            Empreendedor empreendedor = new Empreendedor();

            
            if (soContemNumeros(user)) {
                if (CpfUtil.isValidCPF(user)) {
                    System.out.println("..>"+user);
                    empreendedor = empreendedor.buscarPorCpf(user);
                } else {
                    FacesUtil.addErrorMessage(" CPF Inválido ", "formularioDeLogin:botaoLogin");
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
                this.setNome(empreendedor.getNome());
                try {
                    //                return "success";
                    FacesContext.getCurrentInstance().getExternalContext().dispatch("view/homeEmpreendedor.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                FacesUtil.addSuccessMessage(" Senha incorreta ", "formularioDeLogin:botaoLogin");
                System.out.println("senha incorreta");
                System.out.println(senha);
                return "failure";
            }
        } catch (NullPointerException nullpointer) {
            FacesUtil.addErrorMessage(" Empreendedor não cadastrado ", "formularioDeLogin:botaoLogin");
            System.out.println("Empreendedor não cadastro");
            return "failure";
        }

        return null;

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
    
    public static void MudarNome(String nome){
        LoginBean.nome = nome;
    }
    
    public static void MudarSenha(String senha){
        LoginBean.senha = senha;
    }
    
    public static void MudarUser(String user){
        LoginBean.user = user;
    }

}
