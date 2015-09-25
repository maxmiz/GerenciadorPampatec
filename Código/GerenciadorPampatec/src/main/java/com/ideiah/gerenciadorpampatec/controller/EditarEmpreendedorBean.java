package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.EmpreendedorEmail;
import com.ideiah.gerenciadorpampatec.util.CpfUtil;
import com.ideiah.gerenciadorpampatec.util.TelefoneUtil;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "editarEmpreendedorBean")
@SessionScoped

public class EditarEmpreendedorBean {

    private Empreendedor empreendedor;
    private EmpreendedorEmail empreendedorEmail;
    private HttpSession session;
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
    

    public EditarEmpreendedorBean() {
        session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        this.empreendedor = (Empreendedor) session.getAttribute("empreendedor");
        if (empreendedor != null) {
            empreendedor.getEmail();
        }
        this.telefone = empreendedor.getTelefone();
        this.nome = empreendedor.getNome();
        this.bairro = empreendedor.getBairro();
        this.cpf = empreendedor.getCpf();
        this.email = empreendedor.getEmail();
        this.formacao = empreendedor.getFormacao();
        this.rua = empreendedor.getRua();
        this.complemento = empreendedor.getComplemento();
        this.numero = String.valueOf(empreendedor.getNumero());
        this.experiencia = empreendedor.getExperiencia();
        this.competencia = empreendedor.getCompetencia();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getFormacao() {
        return formacao;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public String getCompetencia() {
        return competencia;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setEmpreendedor(Empreendedor empreendedor) {
        this.empreendedor = empreendedor;
    }

    public Empreendedor getEmpreendedor() {
        return empreendedor;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void editarEmpreendedor() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        empreendedor = (Empreendedor) secao.getAttribute("empreendedor");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("editarDadosEmpreendedor.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(EditarEmpreendedorBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void finalizarEdicao() {
        String numeroTelefone;
        this.empreendedor.setNome(nome);
        cpf = FacesUtil.removeCaracteres(cpf);
        if (empreendedor.buscarPorCpf(cpf) != null) {
            if (!empreendedor.getCpf().equals(cpf)) {
                FacesUtil.addErrorMessage("CPF já cadastrado!", "formularioCadastro:cpf");
            } else {
                empreendedor.setCpf(cpf);
                empreendedor.setFormacao(formacao);
                if (CpfUtil.isValidCPF(cpf) == false) {
                    FacesUtil.addErrorMessage("CPF invalido!", "formularioCadastro:cpf");
                } else {
                    numeroTelefone = String.valueOf(telefone);
                    empreendedor.setTelefone(TelefoneUtil.removeParentesesTelefone(numeroTelefone));

                    empreendedor.setRua(rua);
                    empreendedor.setNumero(Integer.parseInt(numero));
                    empreendedor.setBairro(bairro);
                    empreendedor.setComplemento(complemento);
                    empreendedor.setExperiencia(experiencia);
                    empreendedor.setCompetencia(competencia);

                    if (empreendedor.atualizarEmpreendedor(empreendedor)) {
                        try {
                            LoginBean.MudarNome(empreendedor.getNome());
                            LoginBean.MudarSenha(empreendedor.getSenha());
                            LoginBean.MudarUser(empreendedor.getEmail());
                            session.setAttribute("empreendedor", empreendedor);
                            FacesContext.getCurrentInstance().getExternalContext().dispatch("/faces/view/homeEmpreendedor.xhtml");
                        } catch (IOException ex) {
                            Logger.getLogger(EmpreendedorBean.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        FacesUtil.addErrorMessage("Cadastro não realizado!", "formularioCadastro:botaoEnviar");
                    }
                }
            }

        }
    }

    public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Edição", "Edição realizda com sucesso!");
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
}
