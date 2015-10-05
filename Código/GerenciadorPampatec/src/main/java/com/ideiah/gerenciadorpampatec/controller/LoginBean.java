/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.util.CpfUtil;
import com.ideiah.gerenciadorpampatec.dao.EmpreendedorDao;
import com.ideiah.gerenciadorpampatec.dao.EmpreendedorEmailDao;
import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.EmpreendedorEmail;
import com.ideiah.gerenciadorpampatec.util.CriptografiaUtil;
import com.ideiah.gerenciadorpampatec.util.EmailUtil;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
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
    private static EmpreendedorEmailDao empreendedorEmailDao;
    private static String user; //pode ser email ou senha
    private static String senha;
    private static String nome;
    private String emailRecuperarSenha;
    private static EmpreendedorBean empreendedorBean;

    private FacesContext fc = FacesContext.getCurrentInstance();
    private HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

    public void submit() {
        try {
            fazLogin(user, senha);
        } catch (Exception e) {
            System.out.println("Exceção inesperada" + e);
        }
    }
    
    /**
     * 
     * @return O número total de notificações
     */
    public int getQuantidadeDeNotificacoes(){
        Empreendedor empreendedor = (Empreendedor) session.getAttribute("empreendedor");
        return empreendedor.getQuantidadeDeNotificacoes(empreendedor);
        
    }
    
    public ArrayList<String> getDescricaoNotificacoes(){
        Empreendedor empreendedor = (Empreendedor) session.getAttribute("empreendedor");
        return empreendedor.getDescricaoDasNotificacoes(empreendedor);
    }

    public void fazLogout() {

        session.removeAttribute("empreendedor");
        session.removeAttribute("projetoSelecionado");
        LoginBean.MudarNome(null);
        LoginBean.MudarSenha(null);
        LoginBean.MudarUser(null);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/view/loginEmpreendedor.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getInicio() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("homeEmpreendedor.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getEnviarProjeto() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("enviarProjeto.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getVisualizarPlanos() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("paginaBuscaProjeto.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void voltar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("loginEmpreendedor.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String fazLogin(String user, String senha) {
        try {
            Empreendedor empreendedor = new Empreendedor();

            if (soContemNumeros(user)) {
                if (CpfUtil.isValidCPF(user)) {
                    System.out.println("..>" + user);
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
                    FacesContext.getCurrentInstance().getExternalContext().redirect("view/homeEmpreendedor.xhtml");
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
    
    /**
     * Método para recuparação de senha do usuário.
     * Envia um email para o destino inserido (email) com um link para alterar a senha.
     * Cria um novo empreendedorEmail e seta os valores com tipo (recuperação de senha),
     * idEmpreendedor (chave estrangeira = ID do empreendedor que possui o email inserido e
     * gera um idUnico que é setado no campo de id do empreendedorEmail.
     */
    public void recuperarSenha(){
        
        Empreendedor empreendedor;
        
        empreendedor = Empreendedor.buscaPorEmail(emailRecuperarSenha);
        
        String idUnico = UUID.randomUUID().toString();
        
        EmpreendedorEmail empreendedorEmail = new EmpreendedorEmail();
        
        empreendedorEmail.setEmpreendedor(empreendedor);
        empreendedorEmail.setIdEmpreendedorEmail(idUnico);
        empreendedorEmail.setTipo("Recuperação de Senha");
        
        empreendedorEmail.salvarEmpreendedorEmail(empreendedorEmail);
       
        EmailUtil.enviarEmailRecuperarSenha(emailRecuperarSenha, idUnico);
        
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
        session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Empreendedor emp = (Empreendedor) session.getAttribute("empreendedor");
        return emp.getNome();
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void MudarNome(String nome) {
        LoginBean.nome = nome;
    }

    public static void MudarSenha(String senha) {
        LoginBean.senha = senha;
    }

    public static void MudarUser(String user) {
        LoginBean.user = user;
    }

    public void enviaBuscaProjeto() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("PaginaBuscaProjeto.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the emailRecuperarSenha
     */
    public String getEmailRecuperarSenha() {
        return emailRecuperarSenha;
    }

    /**
     * @param emailRecuperarSenha the emailRecuperarSenha to set
     */
    public void setEmailRecuperarSenha(String emailRecuperarSenha) {
        this.emailRecuperarSenha = emailRecuperarSenha;
    }
}
