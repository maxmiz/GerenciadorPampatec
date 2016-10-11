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
import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import com.ideiah.gerenciadorpampatec.util.CriptografiaUtil;
import com.ideiah.gerenciadorpampatec.util.EmailUtil;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 * <p>
 * Classe usada para realizar login do empreendedor no sistema</p>
 *
 * @author Augusto César Görgen
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    private static EmpreendedorDao empreededorDao;
    private static EmpreendedorEmailDao empreendedorEmailDao;
    private static String user; //pode ser email ou senha
    private static String senha;
    private String nome;
    private String emailRecuperarSenha;
    private static EmpreendedorBean empreendedorBean;
    private boolean cadastroIncompleto;
    private PreAvaliarPlanoBean preAvaliarBean;

    private FacesContext fc;
    private HttpSession session;

    public LoginBean() {
        fc = FacesContext.getCurrentInstance();
        session = (HttpSession) fc.getExternalContext().getSession(true);
    }

    public boolean submit() {
        try {
            if (fazLoginEmpreendedor(user, senha)) {
                return true;
            } else if (fazLoginGerente(user, senha)) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Origem: " + this.getClass().getName() + ":: \t Exceção inesperada" + e);
        }
        return false;
    }

    /**
     * <p>
     * Método que realiza logout do sistema, garantido o status correto do
     * projeto e finalizando a sessão do usuário.</p>
     */
    public void fazLogout() {
        ProjectSatusManager managerBean = new ProjectSatusManager();
        managerBean.tratamentoSessaoSendoAvaliado();

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/GerenciadorPampatec");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * <p>
     * Método que redireciona para a página inicial do empreendedor.</p>
     */
    public void getInicio() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("homeEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Método que redireciona para a página inicial do empreendedor, voltando da
     * página de revisar plano de negócio.</p>
     */
    public void getInicioRevisar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../homeEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Método que redireciona para a página inicial do gerente.</p>
     */
    public void getInicioGerente() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("homeGerenteDeRelacionamentos.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Método que redireciona para a página de criar planos de negócio do
     * empreendedor.</p>
     */
    public void getEnviarProjeto() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("empreendedor/enviarProjeto.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Redireciona para a página que contem a tabela de de plano de negócio, na
     * visão do Gerente de Relacionamento.
     * </p>
     */
    public void getVisualizarPlanosGerente() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("buscarPlanoDeNegocio.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Redireciona para a página que contem a tabela de de plano de negócio do
     * empreendedor.</p>
     */
    public void getVisualizarPlanos() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("paginaBuscaPlanoDeNegocio.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getVisualizarPlanosRevisar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../paginaBuscaPlanoDeNegocio.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void voltar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("loginEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * Método para redirecionar o usuário para a página de login, invocado de
     * uma das páginas de erro do diretório WEB-INF.</p>
     */
    public void voltarDoErroParaLogin() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/GerenciadorPampatec/loginEmpreendedor.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param user
     * @param senha
     * @return true se o login for de um Gerente de Relacionamento existente
     */
    public Boolean fazLoginGerente(String user, String senha) {
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
                getSession().setAttribute("gerente", gerente);
                this.setNome(gerente.getNome());

                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("view/gerentederelacionamento/homeGerenteDeRelacionamentos.jsf");
                    return true;
                } catch (IOException ex) {
                    Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
                }

                getVisualizarPlanosGerente();
//                try {
//                    FacesContext.getCurrentInstance().getExternalContext().redirect("view/gerentederelacionamento/buscarPlanodeNegocio.jsf");
//                    return true;
//                } catch (IOException ex) {
//                    Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
//                }

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
     * método verifica a pessoa se a pessoa logada na sessao é um empreendedor,
     * se for, retorna seu nome. se não, retorna o nome do gerente logado na
     * sessao
     *
     * @return usuario Logado
     */
    public String retornaNomeLogado() {

        String usuarioLogado;
        GerenteRelacionamento gerente;
        Empreendedor empreendedor = (Empreendedor) getSession().getAttribute("empreendedor");

        if (empreendedor == null) {
            gerente = (GerenteRelacionamento) getSession().getAttribute("gerente");
            usuarioLogado = gerente.getNome();

        } else {
            usuarioLogado = empreendedor.getNome();
        }
        return usuarioLogado;
    }

    /**
     *
     * @param user
     * @param senha
     * @return se o login for de um Empreendedor existente
     */
    public Boolean fazLoginEmpreendedor(String user, String senha) {
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
                getSession().setAttribute("empreendedor", empreendedor);
                this.setNome(empreendedor.getNome());
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("view/empreendedor/homeEmpreendedor.jsf");
                    return true;
                } catch (IOException ex) {
                    Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
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
     * Método para recuperação de senha do usuário. Envia um email para o
     * destino inserido (email) com um link para alterar a senha. Cria um novo
     * empreendedorEmail e seta os valores com tipo (recuperação de senha),
     * idEmpreendedor (chave estrangeira = ID do empreendedor que possui o email
     * inserido e gera um idUnico que é setado no campo de id do
     * empreendedorEmail.
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
     * Verifica se a String contem apenas números.
     * </p>
     *
     * @param texto
     * @return
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
     *
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

    public void MudarNome(String nome) {
        this.nome = nome;
    }

    public static void MudarSenha(String senha) {
        LoginBean.senha = senha;
    }

    public static void MudarUser(String user) {
        LoginBean.user = user;
    }

    public void enviaBuscaProjeto() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("paginaBuscaPlanoDeNegocio.jsf");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Mostra a mensagem de fim de sessão chamando um método do javascript e
     * invalidando a sessão.
     */
    public void mostraMensagemSessao() {
        session.invalidate();
        RequestContext.getCurrentInstance().execute("mostraMensagemFimSessao();");
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

    /**
     * @return the cadastroIncompleto
     */
    public boolean isCadastroIncompleto() {
        return cadastroIncompleto;
    }

    /**
     * @param cadastroIncompleto the cadastroIncompleto to set
     */
    public void setCadastroIncompleto(boolean cadastroIncompleto) {
        this.cadastroIncompleto = cadastroIncompleto;
    }

    /**
     * Verifica se o empreendedor está com o cadastro completo.
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
     * @return the session
     */
    public HttpSession getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(HttpSession session) {
        this.session = session;
    }

    /**
     * <p>
     * Método que renova a sessão do usuário, pois ele é chamado pelo botão
     * "Renovar Sessão" presente no relógio da sessão, e ao realizar uma
     * requisição no servidor, a mesma é renovada.</p>
     */
    public void renovaSessaoUsuario() {
        System.out.println("From: LoginBean Method: renovaSessaoUsuario()"
                + "\t Message: Sessão renovada com sucesso!");
    }

    /**
     * <p>
     * Método verifica se a sessão existe, caso positivo chama o método que
     * trabalha com a sessão e o status do projeto, da classe
     * <code>ProjectSatusManager</code>.</p>
     */
    public synchronized void mataSessao() {
        if (getSession() != null) {

            ProjectSatusManager psmb = new ProjectSatusManager();
            psmb.tratamentoSessaoSendoAvaliado();

            System.out.println("From: LoginBean,  Method: mataSessao(), Message: Finalizou a Sessão");
        } else {
            System.out.println("From: LoginBean,  Method: mataSessao(), Message: Sessão Já Finalizada");
        }
    }
}
