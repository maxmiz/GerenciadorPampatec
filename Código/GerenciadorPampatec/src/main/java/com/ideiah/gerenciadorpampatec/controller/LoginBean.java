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
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
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
    private boolean cadastroIncompleto;

    private FacesContext fc = FacesContext.getCurrentInstance();
    private HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

    public boolean submit() {
        try {
            if (fazLoginEmpreendedor(user, senha)) {
                System.out.println("entrou no if do empreendedor");
                return true;
            } else if (fazLoginGerente(user, senha)) {

                System.out.println("entrou no if do gerente");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Exceção inesperada" + e);
        }
        return false;
    }

    public void fazLogout() {

        session.removeAttribute("empreendedor");
        session.removeAttribute("projetoSelecionado");
        LoginBean.MudarNome(null);
        LoginBean.MudarSenha(null);
        LoginBean.MudarUser(null);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/GerenciadorPampatec/faces/loginEmpreendedor.xhtml");
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

    public void getInicioGerente() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("homeGerenteDeRelacionamentos.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getEnviarProjeto() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("empreendedor/enviarProjeto.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Página inicial redirecionada para lista de projetos para pré-avaliar.
    //Razão: O gerente recebia uma tela em branco ao logar no sistema. Agora redireciona para a função principal do Sprint 2016/
     public void getVisualizarPlanosGerente() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("view/gerentederelacionamento/buscarPlanoDeNegocio.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getVisualizarPlanos() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("paginaBuscaPlanoDeNegocio.xhtml");
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
                    System.out.println("..>" + user);
                    gerente = gerente.buscarPorCpf(user);
                } else {
                    FacesUtil.addErrorMessage(" CPF Inválido ", "formularioDeLogin:botaoLogin");
                    System.out.println("cpf invalido");
                }
            } else {
                gerente = gerente.buscarPorEmail(user);
            }
            senha = CriptografiaUtil.md5(senha);
            System.out.println(senha);
            if (gerente.getSenha().equals(senha)) {
                FacesUtil.addSuccessMessage("Logado");
                System.out.println("Logado");
                session.setAttribute("gerente", gerente);
                this.setNome(gerente.getNome());

                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("view/gerentederelacionamento/homeGerenteDeRelacionamentos.xhtml");
                    return true;
                } catch (IOException ex) {
                    Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
                }

                getVisualizarPlanosGerente();
//                try {
//                    FacesContext.getCurrentInstance().getExternalContext().redirect("view/gerentederelacionamento/buscarPlanodeNegocio.xhtml");
//                    return true;
//                } catch (IOException ex) {
//                    Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
//                }

            } else {
                FacesUtil.addErrorMessage(" Senha incorreta ", "formularioDeLogin:botaoLogin");
                System.out.println("senha incorreta");
                System.out.println(senha);
                return false;

            }
        } catch (NullPointerException nullpointer) {
            FacesUtil.addErrorMessage(" Usuário não cadastrado ", "formularioDeLogin:botaoLogin");
            System.out.println("gerente não cadastrado");
            return false;

        }

        return false;

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
                    FacesContext.getCurrentInstance().getExternalContext().redirect("view/empreendedor/homeEmpreendedor.xhtml");
                    return true;
                } catch (IOException ex) {
                    Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                FacesUtil.addErrorMessage(" Senha incorreta ", "formularioDeLogin:botaoLogin");
                System.out.println("senha incorreta");
                System.out.println(senha);
                return false;

            }
        } catch (NullPointerException nullpointer) {
            FacesUtil.addErrorMessage(" Usuário não cadastrado ", "formularioDeLogin:botaoLogin");
            System.out.println("Empreendedor não cadastro");
            return false;

        }

        return false;

    }

    /**
     * Método para recuparação de senha do usuário. Envia um email para o
     * destino inserido (email) com um link para alterar a senha. Cria um novo
     * empreendedorEmail e seta os valores com tipo (recuperação de senha),
     * idEmpreendedor (chave estrangeira = ID do empreendedor que possui o email
     * inserido e gera um idUnico que é setado no campo de id do
     * empreendedorEmail.
     */
    public void recuperarSenha() {

        Empreendedor empreendedor;

        empreendedor = Empreendedor.buscaPorEmail(emailRecuperarSenha);
        if(emailRecuperarSenha == null || emailRecuperarSenha.equals("")){
            FacesUtil.addErrorMessage("Insira um email!", "formularioRecuperarSenha:botaoRecuperarSenha");
        }else if (empreendedor != null) {

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

            FacesContext.getCurrentInstance().getExternalContext().redirect("paginaBuscaPlanoDeNegocio.xhtml");
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
     * @return 
     */
    public boolean verificaCadastroIncompleto(){
        if(cadastroIncompleto){
            cadastroIncompleto = false;
            return true;
        }else{
            return false;
        }
    }
}
