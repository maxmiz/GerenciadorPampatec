package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.EmpreendedorEmail;
import com.ideiah.gerenciadorpampatec.util.CpfUtil;
import com.ideiah.gerenciadorpampatec.util.TelefoneUtil;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "editarEmpreendedorBean")
@SessionScoped

public class EditarEmpreendedorBean {

    private Empreendedor empreendedor;
    private EmpreendedorEmail empreendedorEmail;
    private HttpSession session;
    private String nome;
    private String cpf;
    private long telefone;
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
        telefone = Long.parseLong(empreendedor.getTelefone());

    }

    public void setEmpreendedor(Empreendedor empreendedor) {
        this.empreendedor = empreendedor;
    }

    public Empreendedor getEmpreendedor() {
        return empreendedor;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public long getTelefone() {
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
                    FacesUtil.addSuccessMessage("Edição realizada com sucesso!", "formularioCadastro:botaoEnviar");
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
