/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.EmpreendedorEmail;
import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import com.ideiah.gerenciadorpampatec.util.EmailUtil;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import java.io.Serializable;
import java.util.UUID;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * <p>
 * Classe responsável por manipular as informações do usuário no sistema,
 * principalmente os dados sensíveis do mesmo.
 * </p>
 *
 * @author unipampa
 * @since 20-06-2016
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    private static String senha;
    private static String user; //pode ser email ou senha
    private String nome;
    private String emailRecuperarSenha;
    private boolean cadastroIncompleto;

    public UserBean() {
    }

    /**
     * <p>
     * Método verifica a pessoa se a pessoa logada na sessão é um empreendedor,
     * se for, retorna seu nome. se não, retorna o nome do gerente logado na
     * sessao.</p>
     *
     * @return usuario Logado
     */
    public String retornaNomeLogado() {
        String usuarioLogado;
        GerenteRelacionamento gerente;
        Empreendedor empreendedor = (Empreendedor) SessionManager.getAttribute("empreendedor");

        if (empreendedor == null) {
            gerente = (GerenteRelacionamento) SessionManager.getAttribute("gerente");
            usuarioLogado = gerente.getNome();
        } else {
            usuarioLogado = empreendedor.getNome();
        }
        return usuarioLogado;
    }

    /**
     * <p>
     * Método para recuperação de senha do usuário. Envia um email para o
     * destino inserido (email) com um link para alterar a senha. Cria um novo
     * empreendedorEmail e seta os valores com tipo (recuperação de senha),
     * idEmpreendedor (chave estrangeira = ID do empreendedor que possui o email
     * inserido e gera um idUnico que é setado no campo de id do
     * empreendedorEmail.</p>
     */
    public void recuperarSenha() {
        Empreendedor empreendedor;

        empreendedor = Empreendedor.buscaPorEmail(emailRecuperarSenha);
        if (emailRecuperarSenha == null || emailRecuperarSenha.equals("")) {
            FacesUtil.addErrorMessage("Insira um email!", "formularioRecuperarSenha:botaoRecuperarSenha");
        } else if (empreendedor != null) {

            if (!Empreendedor.verificaDadosEmpreendedor(empreendedor)) {
                cadastroIncompleto = true;
                FacesUtil.addErrorMessage("Alguem já adicionou você ao plano ", "formularioRecuperarSenha:botaoRecuperarSenha");
            } else {
                String idUnico = UUID.randomUUID().toString();

                EmpreendedorEmail empreendedorEmail = new EmpreendedorEmail();

                empreendedorEmail.setEmpreendedor(empreendedor);
                empreendedorEmail.setIdEmpreendedorEmail(idUnico);
                empreendedorEmail.setTipo("Recuperação de Senha");

                empreendedorEmail.salvarEmpreendedorEmail(empreendedorEmail);

                EmailUtil.enviarEmailRecuperarSenha(emailRecuperarSenha, idUnico);
                FacesUtil.addSuccessMessage("Um e-mail foi enviado para a sua caixa de e-mail contendo as instruções para recuperar sua senha de acesso.", "formularioRecuperarSenha:botaoRecuperarSenha");
            }
        } else {
            FacesUtil.addErrorMessage("O e-mail inserido não está cadastrado!", "formularioRecuperarSenha:botaoRecuperarSenha");
        }
    }

    /**
     * <p>
     * Método que acessa a classe <code>SessioManager</code> para retorna o
     * tempo máximo da sessão no sistema.</p>
     *
     * @return O tempo da sessão em segundos. Tipo <code>int</code>.
     */
    public int tempoMaximoSessao() {
        return SessionManager.getMaxInactiveInterval();
    }

    /**
     * <p>
     * Método que acessa a classe responsável por manipular a sessão, e finaliza
     * a mesma chamando o método <code>finalizaSessao</code>.</p>
     */
    public void finalizaSessao() {
        SessionManager.finalizaSessao();
    }

    /**
     * <p>
     * Verifica se o empreendedor está com o cadastro completo.</p>
     *
     * @return
     */
    public boolean verificaCadastroIncompleto() {
        if (cadastroIncompleto) {
            cadastroIncompleto = false;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param user
     */
    public static void MudarUser(String user) {
        UserBean.user = user;
    }

    /**
     *
     * @param senha
     */
    public static void MudarSenha(String senha) {
        UserBean.senha = senha;
    }

    public String getEmailRecuperarSenha() {
        return emailRecuperarSenha;
    }

    public void setEmailRecuperarSenha(String emailRecuperarSenha) {
        this.emailRecuperarSenha = emailRecuperarSenha;
    }

    public boolean isCadastroIncompleto() {
        return cadastroIncompleto;
    }

    public void setCadastroIncompleto(boolean cadastroIncompleto) {
        this.cadastroIncompleto = cadastroIncompleto;
    }

    /**
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param user the user to set
     */
    public void setUser(String user) {
        UserBean.user = user;
    }

    /**
     *
     *
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @param nome the value of nome
     */
    public void MudarNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     *
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        UserBean.senha = senha;
    }

    /**
     *
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
