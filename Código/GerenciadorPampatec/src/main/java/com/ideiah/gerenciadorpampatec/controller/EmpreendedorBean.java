/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.ideiah.gerenciadorpampatec.dao.EmpreendedorDao;
import com.ideiah.gerenciadorpampatec.dao.EmpreendedorEmailDao;
import com.ideiah.gerenciadorpampatec.model.EmpreendedorEmail;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import com.ideiah.gerenciadorpampatec.util.CpfUtil;
import com.ideiah.gerenciadorpampatec.util.CriptografiaUtil;
import com.ideiah.gerenciadorpampatec.util.EmailUtil;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import com.ideiah.gerenciadorpampatec.util.TelefoneUtil;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedProperty;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.primefaces.expression.impl.ThisExpressionResolver;

/**
 *
 * @author AugustoCesar
 */
@ManagedBean(name = "empreendedorBean")
@SessionScoped
public class EmpreendedorBean {

    private String outcome = "LoginEmpreendedor";
    private String userInput = "";
    private String senhaInput = "";
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String formacao;
    private String experiencia;
    private String competencia;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    private Empreendedor empreendedor;
    private EmpreendedorEmailDao empreendedorEmailDao;
    private EmpreendedorEmail empreendedorEmail;
    private HttpSession session;
    private EmailUtil emailUtil;
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean; // +setter

    public EmpreendedorBean() {
        session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        this.empreendedor = (Empreendedor) session.getAttribute("empreendedor");
        if (empreendedor != null) {
            empreendedor.getEmail();
        }
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public boolean verificaProjetoEmpreededor(Empreendedor emp) {
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Projeto projeto = (Projeto) sessao.getAttribute("projetoSelecionado");

        System.out.println("projeto=" + projeto);
        System.out.println("empreendedor=" + emp);

        return empreendedor.verificaProjetoEmpreendedor(emp, projeto);
    }

    public void chamaCadastro() {
        System.out.println("Entrou no CHAMA CADASTRO da Bean");
        empreendedor = new Empreendedor();
        empreendedor.setNome(nome);
        cpf = FacesUtil.removeCaracteres(cpf);
        if (empreendedor.buscarPorCpf(cpf) != null) {
            FacesUtil.addErrorMessage("CPF já cadastrado!", "formularioCadastro:cpf");
        } else {
            empreendedor.setCpf(cpf);
            empreendedor.setFormacao(formacao);
            if (empreendedor.buscarPorEmail(email) != null) {
                FacesUtil.addErrorMessage("Email já cadastrado!", "formularioCadastro:email");
            } else if (CpfUtil.isValidCPF(cpf) == false) {
                FacesUtil.addErrorMessage("CPF invalido!", "formularioCadastro:cpf");
            } else {
                empreendedor.setEmail(email);
                empreendedor.setTelefone(TelefoneUtil.removeParentesesTelefone(telefone));
                empreendedor.setSenha(CriptografiaUtil.md5(senhaInput));
                empreendedor.setRua(rua);
                empreendedor.setNumero(Integer.parseInt(numero));
                empreendedor.setBairro(bairro);
                empreendedor.setComplemento(complemento);
                empreendedor.setExperiencia(experiencia);

                if (empreendedor.cadastrarEmpreendedor(empreendedor)) {
                    FacesUtil.addSuccessMessage("Cadastro realizado com sucesso!", "formularioCadastro:botaoEnviar");
//                        depois do processamento, aqui ele coloca os campos que vão ser recuperados para tela
//                        como nulos. Portanto, ele salva no banco depois limpa a tela. (só funciona com refresh)

                    nome = null;
                    cpf = null;
                    rua = null;
                    email = null;
                    senhaInput = null;
                    telefone = null;
                    numero = null;
                    bairro = null;
                    complemento = null;
                    experiencia = null;
                    formacao = null;

                    try {
                        // LoginBean.MudarNome(empreendedor.getNome());
                        LoginBean.MudarSenha(empreendedor.getSenha());
                        LoginBean.MudarUser(empreendedor.getEmail());
                        empreendedor = empreendedor.buscarPorEmail(empreendedor.getEmail());
                        session.setAttribute("empreendedor", empreendedor);
                        FacesContext.getCurrentInstance().getExternalContext().redirect("view/empreendedor/homeEmpreendedor.xhtml");
                    } catch (IOException ex) {
                        Logger.getLogger(EmpreendedorBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    FacesUtil.addErrorMessage("Cadastro não realizado.!", "formularioCadastro:botaoEnviar");
                }
            }
        }
    }

    /**
     * Método para salvar a nova senha do usuário a partir da recuperação pelo
     * link submetido para o email
     */
    public void terminarRecuperacaoDeSenha() {

        if (empreendedor != null) {

            this.empreendedor.setSenha(CriptografiaUtil.md5(senhaInput));
            empreendedor.atualizarEmpreendedor(empreendedor);

            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/loginEmpreendedor.xhtml");

            } catch (IOException ex) {
                Logger.getLogger(EmpreendedorBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void terminarCadastro() {
        this.empreendedor.setIdUnico(null);
        this.empreendedor.setNome(nome);
        cpf = FacesUtil.removeCaracteres(cpf);
        if (empreendedor.buscarPorCpf(cpf) != null) {
            FacesUtil.addErrorMessage("CPF já cadastrado!", "formularioCadastro:cpf");
        } else {
            empreendedor.setCpf(cpf);
            empreendedor.setFormacao(formacao);
            if (CpfUtil.isValidCPF(cpf) == false) {
                FacesUtil.addErrorMessage("CPF invalido!", "formularioCadastro:cpf");
            } else {
                empreendedor.setTelefone(TelefoneUtil.removeParentesesTelefone(telefone));
                empreendedor.setSenha(CriptografiaUtil.md5(senhaInput));
                empreendedor.setRua(rua);
                empreendedor.setNumero(Integer.parseInt(numero));
                empreendedor.setBairro(bairro);
                empreendedor.setComplemento(complemento);
                empreendedor.setExperiencia(experiencia);

                if (empreendedor.atualizarEmpreendedor(empreendedor)) {
                    FacesUtil.addSuccessMessage("Cadastro finalizado com sucesso!", "formularioCadastro:botaoEnviar");

                    try {
                        // LoginBean.MudarNome(empreendedor.getNome());
                        getLoginBean().setNome(nome);
                        LoginBean.MudarSenha(empreendedor.getSenha());
                        LoginBean.MudarUser(empreendedor.getEmail());
                        session.setAttribute("empreendedor", empreendedor);
                        empreendedor.setTelefone(null);
                        empreendedor.setSenha(CriptografiaUtil.md5(null));
                        empreendedor.setRua(null);
                        empreendedor.setNumero(Integer.parseInt(null));
                        empreendedor.setBairro(null);
                        empreendedor.setComplemento(null);
                        empreendedor.setExperiencia(null);
                        FacesContext.getCurrentInstance().getExternalContext().dispatch("/faces/view/empreendedor/homeEmpreendedor.xhtml");
                    } catch (IOException ex) {
                        Logger.getLogger(EmpreendedorBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    FacesUtil.addErrorMessage("Cadastro não realizado!", "formularioCadastro:botaoEnviar");
                }
            }
        }

    }

    /**
     *
     * @param email
     * @param id
     */
    public void recuperarSenha(String email, String id) {
        empreendedor.buscaPorEmail(email);
        this.empreendedorEmail.setEmpreendedor(empreendedor);
        this.empreendedorEmail.setIdEmpreendedorEmail(id);
        this.empreendedorEmail.setTipo("Recuperação de Senha");
    }

//    public void chamaLogin() {
//        empreendedor.fazLogin();
//    }
    /**
     * @return the senhaInput
     */
    public String getSenhaInput() {
        return senhaInput;
    }

    /**
     * @param senhaInput the senhaInput to set
     */
    public void setSenhaInput(String senhaInput) {
        this.senhaInput = senhaInput;
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

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the formacao
     */
    public String getFormacao() {
        return formacao;
    }

    /**
     * @param formacao the formacao to set
     */
    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the empreendedor
     */
    public Empreendedor getEmpreendedor() {
        return empreendedor;
    }

    /**
     * @param empreendedor the empreendedor to set
     */
    public void setEmpreendedor(Empreendedor empreendedor) {
        this.empreendedor = empreendedor;
    }

    /**
     * @return the experiencia
     */
    public String getExperiencia() {
        return experiencia;
    }

    /**
     * @param experiencia the experiencia to set
     */
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * @return the competencia
     */
    public String getCompetencia() {
        return competencia;
    }

    /**
     * @param competencia the competencia to set
     */
    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    /**
     * @return the loginBean
     */
    public LoginBean getLoginBean() {
        return loginBean;
    }

    /**
     * @param loginBean the loginBean to set
     */
    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

}
