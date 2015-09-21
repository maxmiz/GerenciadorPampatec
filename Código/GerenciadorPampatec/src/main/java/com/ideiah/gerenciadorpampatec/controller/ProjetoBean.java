/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.Analiseemprego;
import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Negocio;
import com.ideiah.gerenciadorpampatec.model.Planofinanceiro;
import com.ideiah.gerenciadorpampatec.model.Produtoouservico;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import com.ideiah.gerenciadorpampatec.util.EmailUtil;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
@ManagedBean(name = "projetoBean")
@ViewScoped
public class ProjetoBean {

    private Empreendedor empreendedorSelected;
    private Projeto projeto;
    private Analiseemprego analiseEmprego;
    private Negocio negocio;
    private Produtoouservico produtoOuSevico;
    private Planofinanceiro planoFinanceiro;
    private String emailEmpreendedor;
    private List<Empreendedor> listaEmpreendedor;
    private List<Empreendedor> empreedendoresAdicionados;
    private String selectedButton;
    private String descricaoButtonOutro;
    private Empreendedor empreendedorSession;

    public ProjetoBean() {
        listaEmpreendedor = Empreendedor.retornarEmpreendedores();
        empreedendoresAdicionados = new ArrayList<>();
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projeto = (Projeto) secao.getAttribute("projetoSelecionado");
        empreendedorSession = (Empreendedor) secao.getAttribute("empreendedor");
        preecheRadioButton();
    }

    /**
     * Atualiza o projeto que está na sessão.
     */
    public void atualizarProjetoSessao() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        secao.setAttribute("projetoSelecionado", projeto);
    }

    /**
     * Preeche o radio button se o projeto já estiver com ele preenchido
     */
    public void preecheRadioButton() {
        if (projeto != null && projeto.getProdutoouservico() != null && projeto.getProdutoouservico().getEstagioEvolucao() != null) {
            if (projeto.getProdutoouservico().verificaStatusProjeto(projeto.getProdutoouservico().getEstagioEvolucao()).equals("Outro:")) {
                selectedButton = projeto.getProdutoouservico().verificaStatusProjeto(projeto.getProdutoouservico().getEstagioEvolucao());
                descricaoButtonOutro = projeto.getProdutoouservico().getEstagioEvolucao();
            } else {
                selectedButton = projeto.getProdutoouservico().verificaStatusProjeto(projeto.getProdutoouservico().getEstagioEvolucao());
            }
        }
    }

    public void pegaValorRadioButton() {
        switch (selectedButton) {
            case "Ideia Básica":
                projeto.getProdutoouservico().setEstagioEvolucao("1");
                descricaoButtonOutro = null;
                break;
            case "Projeto básico":
                projeto.getProdutoouservico().setEstagioEvolucao("2");
                descricaoButtonOutro = null;
                break;
            case "Projeto detalhado":
                projeto.getProdutoouservico().setEstagioEvolucao("3");
                descricaoButtonOutro = null;
                break;
            case "Protótipo desenvolvido":
                projeto.getProdutoouservico().setEstagioEvolucao("4");
                descricaoButtonOutro = null;
                break;
            case "Em teste no mercado":
                projeto.getProdutoouservico().setEstagioEvolucao("5");
                descricaoButtonOutro = null;
                break;
            case "Clientes Pagando":
                projeto.getProdutoouservico().setEstagioEvolucao("6");
                descricaoButtonOutro = null;
                break;
            case "Outro:":
                projeto.getProdutoouservico().setEstagioEvolucao(descricaoButtonOutro);
                descricaoButtonOutro = null;
                break;
            default:
        }
    }

    public void salvarProjeto() {
        pegaValorRadioButton();
        EnviaEmails(projeto);
        projeto.SalvarProjeto(projeto);
        atualizarProjetoSessao();
    }

    /**
     * Envia emails de termino de cadastro para os empreendedores necessários
     * dentro do projeto e atauliza os empreendedores.
     *
     * @param projeto Projeto que contém os empreendedores para se envar os
     * emails
     */
    public void EnviaEmails(Projeto projeto) {
        Empreendedor empreendedor, empreendedorCadastrado;
        
        for (Object object : projeto.getEmpreendedores()) {
            empreendedor = (Empreendedor) object;
            empreendedorCadastrado = Empreendedor.buscaEmpreendedorID(empreendedor.getIdUnico());
            enviarEmailCadastro(empreendedor.getEmail());
        }
    }

    /**
     * Envia um email para que o empreendedor possa terminar o seu cadastro.
     *
     * @param emailEmpreendedor email para se enviar
     */
    public void enviarEmailCadastro(String emailEmpreendedor) {
        String idUnico;
        Empreendedor empreendedor = Empreendedor.buscaPorEmail(emailEmpreendedor);
        if (!Empreendedor.verificaDadosEmpreendedor(empreendedor)) {
            if (empreendedor.getIdUnico() == null) {
                idUnico = UUID.randomUUID().toString();
                EmailUtil.mandarEmailConcluirCadastro(empreendedorSession.getNome(), projeto.getNome(), empreendedor.getEmail(), idUnico);
                empreendedor.setIdUnico(idUnico);
                empreendedor.atualizarEmpreendedor(empreendedor);
            }
        }
    }

    public List<String> completarEmpreendedor(String busca) {
        List<String> listaFiltrada = new ArrayList<>();

        for (Empreendedor empreendedor : getListaEmpreendedor()) {
            if (empreendedor.getEmail().toLowerCase().startsWith(busca)) {
                listaFiltrada.add(empreendedor.getEmail());
            }
        }

        return listaFiltrada;
    }

//    Deleta Empreendedor da Lista
    public void deletarEmpreendedor() {
        System.out.println("Entrou Deletar");
        Empreendedor empreendedorDeletar = null;
        for (Empreendedor empreendedor : getEmpreedendoresAdicionados()) {
            System.out.println("deletar 111");
            empreendedorDeletar = empreendedor;
            System.out.println("deletar 222" + empreendedor.getEmail());

//            if (empreendedor.getEmail().equals(empreendedorSelected.getEmail())) {
            System.out.println("xii");
            if (empreendedor.getCpf() != null) {
                System.out.println("entrou no if 1");
                break;
//                } else if (!empreendedor.verificarProjetoHasEmpreendedor(empreendedorSelected)) {
            } else if (!empreendedor.verificarProjetoHasEmpreendedor(empreendedorDeletar)) {
                System.out.println("entrou no has");
                empreendedor.deletarEmpreendedor(empreendedor);
                break;
            }
        }
//        }

        projeto.getEmpreendedores().remove(empreendedorDeletar);
        getEmpreedendoresAdicionados().remove(empreendedorDeletar);
        System.out.println("Saiu");
    }

    /**
     * Adiciona o Empreendedor ao projeto.
     */
    public void adicionarEmpreendedor() {
        boolean existe = false;
        Empreendedor empreendedorAchado = null;
        for (Empreendedor empreendedor : listaEmpreendedor) {
            if (empreendedor.getEmail().equals(emailEmpreendedor)) {
                existe = true;
                empreendedorAchado = empreendedor;
                break;
            }
        }

        if (existe == false) {
            Empreendedor empreendedor = new Empreendedor();
            empreendedor.setEmail(emailEmpreendedor);
            empreendedorAchado = empreendedor;
        }
        if (!verificarLista(empreedendoresAdicionados, empreendedorAchado)) {
            if (!existe) {
                empreendedorAchado.cadastrarEmpreendedor(empreendedorAchado);
                empreendedorAchado = Empreendedor.buscaPorEmail(emailEmpreendedor);
            }
            getEmpreedendoresAdicionados().add(empreendedorAchado);
            projeto.getEmpreendedores().add(empreendedorAchado);
        } else {
            FacesUtil.addErrorMessage("Empreendedor já adicionado", "formPlanoNegocio:autocomplete");
        }
    }

    /**
     * Verifica se o empreendedor disponibilizado está na lista.
     *
     * @param empreendedores
     * @param empreendedorAchado
     * @return True se ele está presente na lista.
     */
    public boolean verificarLista(List<Empreendedor> empreendedores, Empreendedor empreendedorAchado) {
        for (Empreendedor empreendedore : empreendedores) {
            if (empreendedore.getEmail().equals(empreendedorAchado.getEmail())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the projeto
     */
    public Projeto getProjeto() {
        return projeto;
    }

    /**
     * @param projeto the projeto to set
     */
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    /**
     * @return the analiseEmprego
     */
    public Analiseemprego getAnaliseEmprego() {
        return analiseEmprego;
    }

    /**
     * @param analiseEmprego the analiseEmprego to set
     */
    public void setAnaliseEmprego(Analiseemprego analiseEmprego) {
        this.analiseEmprego = analiseEmprego;
    }

    /**
     * @return the negocio
     */
    public Negocio getNegocio() {
        return negocio;
    }

    /**
     * @param negocio the negocio to set
     */
    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    /**
     * @return the produtoOuSevico
     */
    public Produtoouservico getProdutoOuSevico() {
        return produtoOuSevico;
    }

    /**
     * @param produtoOuSevico the produtoOuSevico to set
     */
    public void setProdutoOuSevico(Produtoouservico produtoOuSevico) {
        this.produtoOuSevico = produtoOuSevico;
    }

    /**
     * @return the planoFinanceiro
     */
    public Planofinanceiro getPlanoFinanceiro() {
        return planoFinanceiro;
    }

    /**
     * @param planoFinanceiro the planoFinanceiro to set
     */
    public void setPlanoFinanceiro(Planofinanceiro planoFinanceiro) {
        this.planoFinanceiro = planoFinanceiro;
    }

    /**
     * @return the emailEmpreendedor
     */
    public String getEmailEmpreendedor() {
        return emailEmpreendedor;
    }

    /**
     * @param emailEmpreendedor the emailEmpreendedor to set
     */
    public void setEmailEmpreendedor(String emailEmpreendedor) {
        this.emailEmpreendedor = emailEmpreendedor;
    }

    /**
     * @return the listaEmpreendedor
     */
    public List<Empreendedor> getListaEmpreendedor() {
        return listaEmpreendedor;
    }

    /**
     * @param listaEmpreendedor the listaEmpreendedor to set
     */
    public void setListaEmpreendedor(List<Empreendedor> listaEmpreendedor) {
        this.listaEmpreendedor = listaEmpreendedor;
    }

    /**
     * @return the empreedendoresAdicionados
     */
    public List<Empreendedor> getEmpreedendoresAdicionados() {
        return empreedendoresAdicionados;
    }

    /**
     * @param empreedendoresAdicionados the empreedendoresAdicionados to set
     */
    public void setEmpreedendoresAdicionados(List<Empreendedor> empreedendoresAdicionados) {
        this.empreedendoresAdicionados = empreedendoresAdicionados;
    }

    /**
     * @return the empreendedorSelected
     */
    public Empreendedor getEmpreendedorSelected() {
        return empreendedorSelected;
    }

    /**
     * @param empreendedorSelected the empreendedorSelected to set
     */
    public void setEmpreendedorSelected(Empreendedor empreendedorSelected) {
        this.empreendedorSelected = empreendedorSelected;
    }

    public String enviaNovoProjetoCadastrar() {
        Projeto pjto = new Projeto();
        Analiseemprego analiseemprego = new Analiseemprego();
        Produtoouservico produtoouservico = new Produtoouservico();
        Negocio negocio = new Negocio();
        Planofinanceiro planofinanceiro = new Planofinanceiro();
        ProjetoDao daoP = new ProjetoDao();

        pjto.setAnaliseemprego(analiseemprego);
        pjto.setNegocio(negocio);
        pjto.setPlanofinanceiro(planofinanceiro);
        pjto.setProdutoouservico(produtoouservico);
        pjto.getEmpreendedores().add(empreendedorSession);
        pjto.setStatus(Projeto.EM_EDICAO);
        pjto.setNome("Nome do Projeto");
        pjto = (Projeto) daoP.salvarRetornandoProjeto(pjto);
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        empreendedorSession = Empreendedor.buscaPorEmail(empreendedorSession.getEmail());
        secao.setAttribute("empreendedor", empreendedorSession);
        secao.setAttribute("projetoSelecionado", pjto);
        return "/faces/view/enviarProjeto.xhtml";

    }

    public boolean verificaCadastroProjeto() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Empreendedor emp = (Empreendedor) secao.getAttribute("empreendedor");
        return emp.getProjetos().isEmpty();
    }

    /**
     * Envia o projeto para a avaliação.
     */
    public void enviarProjeto() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Empreendedor emp = (Empreendedor) secao.getAttribute("empreendedor");
        emp.enviarProjeto(projeto);
    }

    /**
     * @return the selectedButton
     */
    public String getSelectedButton() {
        return selectedButton;
    }

    /**
     * @param selectedButton the selectedButton to set
     */
    public void setSelectedButton(String selectedButton) {
        this.selectedButton = selectedButton;
    }

    /**
     * @return the descricaoButtonOutro
     */
    public String getDescricaoButtonOutro() {
        return descricaoButtonOutro;
    }

    /**
     * @param descricaoButtonOutro the descricaoButtonOutro to set
     */
    public void setDescricaoButtonOutro(String descricaoButtonOutro) {
        this.descricaoButtonOutro = descricaoButtonOutro;
    }
}
