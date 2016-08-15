/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.EmpreendedorEmail;
import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import com.ideiah.gerenciadorpampatec.util.CpfUtil;
import com.ideiah.gerenciadorpampatec.util.CriptografiaUtil;
import com.ideiah.gerenciadorpampatec.util.EmailUtil;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import java.io.Serializable;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * <p>
 * Classe responsÃ¡vel por gerenciar o acesso dos usuÃ¡rios ao sistema.
 * </p>
 *
 * @author unipampa
 * @since 16-06-2016
 */
@ManagedBean
@RequestScoped
public class SystemAccessBean implements Serializable {

    private String user;
    private String passphrase;
    private String nome;
    private String emailRecuperarSenha;
    boolean cadastroIncompleto;

    public SystemAccessBean() {
    }

    /**
     * <p>
     * MÃ©todo que executa a chamada para verificar a existÃªncia do usuÃ¡rio que
     * estÃ¡ realizando Login no sistema.</p>
     */
    public void submit() {
        try {
            if (loginGerente(user, passphrase)) {
            } else if (loginEmpreendedor(user, passphrase)) {
            }
        } catch (Exception e) {
            System.out.println("Origem: " + this.getClass().getName()
                    + ":: \t ExceÃ§Ã£o inesperada" + e);
        }
    }

    /**
     * <p>
     * MÃ©todo que realiza o login do Gerente no sistema.</p>
     *
     * @param user
     * @param senha
     * @return <code>True</code> caso o usuÃ¡rio exista e seja um gerente,
     * <code>False</code> para todos os demais casos.
     */
    private boolean loginGerente(String user, String senha) {
        try {
            GerenteRelacionamento gerente = new GerenteRelacionamento();

            if (soContemNumeros(user)) {
                if (CpfUtil.isValidCPF(user)) {
                    gerente = gerente.buscarPorCpf(user);
                } else {
                    FacesUtil.addErrorMessage(" UsuÃ¡rio ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
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
                    RedirectManager.getInicioGerente();
                    return true;
                } catch (Exception ex) {
                    Logger.getLogger(SystemAccessBean.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                FacesUtil.addErrorMessage(" UsuÃ¡rio ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
                return false;
            }
        } catch (NullPointerException nullpointer) {
            FacesUtil.addErrorMessage(" UsuÃ¡rio ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
            return false;
        }
        return false;
    }

    /**
     * <p>
     * MÃ©todo que realiza o login do empreendedor no sistema.</p>
     *
     * @param user
     * @param senha
     * @return <code>True</code> caso o usuÃ¡rio exista e seja empreendedor,
     * <code>False</code> para todos os demais casos.
     */
    private boolean loginEmpreendedor(String user, String senha) {
        try {
            Empreendedor empreendedor = new Empreendedor();

            if (soContemNumeros(user)) {
                if (CpfUtil.isValidCPF(user)) {
                    empreendedor = empreendedor.buscarPorCpf(user);
                } else {
                    FacesUtil.addErrorMessage(" UsuÃ¡rio ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
                }
            } else {
                empreendedor = empreendedor.buscarPorEmail(user);
            }
            senha = CriptografiaUtil.md5(senha);
            if (empreendedor.getSenha().equals(senha)) {
                if (empreendedor.getIdUnico() == null) {

                    FacesUtil.addSuccessMessage("Logado");

                    SessionManager.getCreateSession().setAttribute("empreendedor", empreendedor);

                    this.setNome(empreendedor.getNome());
                    try {
                        RedirectManager.getInicioEmpreendedor();
                        return true;
                    } catch (Exception ex) {
                        Logger.getLogger(SystemAccessBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    SessionManager.getCreateSession().setAttribute("empreendedorIncompleto", empreendedor);
                    RedirectManager.getConfirmaEmail();
                    return true;
                }
            } else {
                FacesUtil.addErrorMessage(" UsuÃ¡rio ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
                return false;
            }
        } catch (NullPointerException nullpointer) {
            FacesUtil.addErrorMessage(" UsuÃ¡rio ou Senha incorreto(s) ", "formularioDeLogin:botaoLogin");
            return false;
        }
        return false;
    }

    /**
     * <p>
     * Verifica se a <code>String</code> contem apenas nÃºmeros.<p>
     *
     * @param texto
     * @return <code>True</code> caso existam apenas nÃºmeros na frase, e
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
     * MÃ©todo que realiza logout do sistema, garantindo o status correto do
     * projeto, finalizando a sessÃ£o do usuÃ¡rio e chamando o mÃ©todo para
     * redirecionar para a pÃ¡gina inicial do sistema.</p>
     *
     */
    public static void fazLogout() {
        ProjectSatusManager.tratamentoStatusSendoAvaliado();
        SessionManager.finalizaSessao();

        RedirectManager.getLogout();
    }

    /**
     * <p>
     * MÃ©todo para recuperaÃ§Ã£o de senha do usuÃ¡rio. Envia um email para o
     * destino inserido (email) com um link para alterar a senha. Cria um novo
     * empreendedorEmail e seta os valores com tipo (recuperaÃ§Ã£o de senha),
     * idEmpreendedor (chave estrangeira = ID do empreendedor que possui o email
     * inserido e gera um idUnico que Ã© setado no campo de id do
     * empreendedorEmail.</p>
     *
     */
    public void recuperarSenha() {
        Empreendedor empreendedor;
        empreendedor = Empreendedor.buscaPorEmail(emailRecuperarSenha);
        if (emailRecuperarSenha == null || emailRecuperarSenha.equals("")) {
            FacesUtil.addErrorMessage("Insira um email!", "formularioRecuperarSenha:botaoRecuperarSenha");
        } else if (empreendedor != null) {
            if (!Empreendedor.verificaDadosEmpreendedor(empreendedor)) {
                cadastroIncompleto = true;
                FacesUtil.addErrorMessage("Alguem j\u00e1 adicionou voc\u00ea ao plano ", "formularioRecuperarSenha:botaoRecuperarSenha");
            } else {
                String idUnico = UUID.randomUUID().toString();
                EmpreendedorEmail empreendedorEmail = new EmpreendedorEmail();
                empreendedorEmail.setEmpreendedor(empreendedor);
                empreendedorEmail.setIdEmpreendedorEmail(idUnico);
                empreendedorEmail.setTipo("Recupera\u00e7\u00e3o de Senha");
                empreendedorEmail.salvarEmpreendedorEmail(empreendedorEmail);
                EmailUtil.enviarEmailRecuperarSenha(emailRecuperarSenha, idUnico);
                FacesUtil.addSuccessMessage("Um e-mail foi enviado para a sua caixa de e-mail contendo as instru\u00e7\u00f5es para recuperar sua senha de acesso.", "formularioRecuperarSenha:botaoRecuperarSenha");
            }
        } else {
            FacesUtil.addErrorMessage("O e-mail inserido n\u00e3o est\u00e1 cadastrado!", "formularioRecuperarSenha:botaoRecuperarSenha");
        }
    }

    /**
     * <p>
     * Retorna o valor da variÃ¡vel <code>user</code> para manipulaÃ§Ã£o no sistema
     * de login.</p>
     *
     * @return O valor da variÃ¡vel <code>user</code> do tipo
     * <code>String</code>.
     */
    public String getUser() {
        return user;
    }

    /**
     * <p>
     * Define o valor da variÃ¡vel <code>user</code> para manipulaÃ§Ã£o no sistema
     * de login.</p>
     *
     * @param aUser
     */
    public void setUser(String aUser) {
        user = aUser;
    }

    /**
     * <p>
     * Retorna o valor da variÃ¡vel <code>passphrase</code> para manipulaÃ§Ã£o no
     * sistema de login.</p>
     *
     * @return O valor da variÃ¡vel <code>passphrase</code> do tipo
     * <code>String</code>.
     */
    public String getPassphrase() {
        return passphrase;
    }

    /**
     * <p>
     * Define o valor da variÃ¡vel <code>passphrase</code> para manipulaÃ§Ã£o no
     * sistema de login.</p>
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

    /**
     * <p>
     * Verifica se o empreendedor estÃ¡ com o cadastro completo.</p>
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

    public boolean isCadastroIncompleto() {
        return cadastroIncompleto;
    }

    public void setCadastroIncompleto(boolean cadastroIncompleto) {
        this.cadastroIncompleto = cadastroIncompleto;
    }
}
