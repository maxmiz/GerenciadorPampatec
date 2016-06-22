/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import com.ideiah.gerenciadorpampatec.util.CpfUtil;
import com.ideiah.gerenciadorpampatec.util.CriptografiaUtil;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * <p></p>
 * 
 * @author unipampa
 * @since 16-06-2016
 */
@ManagedBean
@RequestScoped
public class LoginNoSessionBean implements Serializable {

    private String user;
    private String passphrase;
    private String nome;
    private String emailRecuperarSenha;

    public LoginNoSessionBean() {
    }

    /**
     * <p>
     * Método que executa a chamada para verificar a existência do usuário que
     * está realizando Login no sistema.</p>
     */
    public void submit() {
        try {
            if (loginGerente(user, passphrase)) {
            } else if (loginEmpreendedor(user, passphrase)) {
            }
        } catch (Exception e) {
            System.out.println("Origem: " + this.getClass().getName()
                    + ":: \t Exceção inesperada" + e);
        }
    }

    /**
     * <p>
     * Método que realiza o login do Gerente no sistema.</p>
     *
     * @param user
     * @param senha
     * @return <code>True</code> caso o usuário exista e seja um gerente,
     * <code>False</code> para todos os demais casos.
     */
    private boolean loginGerente(String user, String senha) {
        try {
            GerenteRelacionamento gerente = new GerenteRelacionamento();

            if (soContemNumeros(user)) {
                if (CpfUtil.isValidCPF(user)) {
                    gerente = gerente.buscarPorCpf(user);
                } else {
                    FacesUtil.addErrorMessage(" Usuário ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
                }
            } else {
                gerente = gerente.buscarPorEmail(user);
            }
            senha = CriptografiaUtil.md5(senha);
            if (gerente.getSenha().equals(senha)) {
                FacesUtil.addSuccessMessage("Logado");
                SessionManager.getCreateSession().setAttribute("gerente", gerente);
                this.setNome(gerente.getNome());

                try {
                    getInicioGerente();
                    return true;
                } catch (Exception ex) {
                    Logger.getLogger(LoginNoSessionBean.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                FacesUtil.addErrorMessage(" Usuário ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
                return false;
            }
        } catch (NullPointerException nullpointer) {
            FacesUtil.addErrorMessage(" Usuário ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
            return false;
        }
        return false;
    }

    /**
     * <p>
     * Método que redireciona para a página inicial do gerente.</p>
     */
    private void getInicioGerente() {
        try {
            SessionManager.getFacesContext().getExternalContext().redirect("view/gerentederelacionamento/homeGerenteDeRelacionamentos.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginNoSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Método que realiza o login do empreendedor no sistema.</p>
     *
     * @param user
     * @param senha
     * @return <code>True</code> caso o usuário exista e seja empreendedor,
     * <code>False</code> para todos os demais casos.
     */
    private boolean loginEmpreendedor(String user, String senha) {
        try {
            Empreendedor empreendedor = new Empreendedor();

            if (soContemNumeros(user)) {
                if (CpfUtil.isValidCPF(user)) {
                    empreendedor = empreendedor.buscarPorCpf(user);
                } else {
                    FacesUtil.addErrorMessage(" Usuário ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
                }
            } else {
                empreendedor = empreendedor.buscarPorEmail(user);
            }
            senha = CriptografiaUtil.md5(senha);
            if (empreendedor.getSenha().equals(senha)) {
                FacesUtil.addSuccessMessage("Logado");

                SessionManager.getCreateSession().setAttribute("empreendedor", empreendedor);

                this.setNome(empreendedor.getNome());
                try {
                    getInicioEmpreendedor();
                    return true;
                } catch (Exception ex) {
                    Logger.getLogger(LoginNoSessionBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                FacesUtil.addErrorMessage(" Usuário ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
                return false;
            }
        } catch (NullPointerException nullpointer) {
            FacesUtil.addErrorMessage(" Usuário ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
            return false;
        }
        return false;
    }

    /**
     * <p>
     * Método que redireciona para a página inicial do empreendedor.</p>
     */
    private void getInicioEmpreendedor() {
        try {
            SessionManager.getFacesContext().getExternalContext().redirect("view/empreendedor/homeEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginNoSessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Verifica se a <code>String</code> contem apenas números.<p>
     *
     * @param texto
     * @return <code>True</code> caso existam apenas números na frase, e
     * <code>False</code> para todos os demais casos.
     */
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
     * <p>
     * Retorna o valor da variável <code>user</code> para manipulação no sistema
     * de login.</p>
     *
     * @return O valor da variável <code>user</code> do tipo  <code>String</code>.
     */
    public String getUser() {
        return user;
    }

    /**
     * <p>
     * Define o valor da variável <code>user</code> para manipulação no sistema
     * de login.</p>
     *
     * @param aUser
     */
    public void setUser(String aUser) {
        user = aUser;
    }

    /**
     * <p>
     * Retorna o valor da variável <code>passphrase</code> para manipulação no sistema
     * de login.</p>
     * 
     * @return O valor da variável <code>passphrase</code> do tipo  <code>String</code>.
     */
    public String getPassphrase() {
        return passphrase;
    }

    /**
     * <p>
     * Define o valor da variável <code>passphrase</code> para manipulação no sistema
     * de login.</p>
     * 
     * @param aSenha
     */
    public void setPassphrase(String aSenha) {
        passphrase = aSenha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmailRecuperarSenha() {
        return emailRecuperarSenha;
    }

    public void setEmailRecuperarSenha(String emailRecuperarSenha) {
        this.emailRecuperarSenha = emailRecuperarSenha;
    }
}
