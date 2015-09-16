/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.Analiseemprego;
import com.ideiah.gerenciadorpampatec.model.Custo;
import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Negocio;
import com.ideiah.gerenciadorpampatec.model.Planofinanceiro;
import com.ideiah.gerenciadorpampatec.model.Produtoouservico;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    private Custo custo;
    private String emailEmpreendedor;
    private List<Empreendedor> listaEmpreendedor;
    private List<Empreendedor> empreedendoresAdicionados;

    public ProjetoBean() {
        projeto = new Projeto();
        analiseEmprego = new Analiseemprego();
        negocio = new Negocio();
        produtoOuSevico = new Produtoouservico();
        planoFinanceiro = new Planofinanceiro();
        custo = new Custo();
        listaEmpreendedor = Empreendedor.retornarEmpreendedores();
        empreedendoresAdicionados = new ArrayList<>();
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projeto = (Projeto) secao.getAttribute("projetoSelecionado");
    }

    public void salvarProjeto() {

        ProjetoDao daoP = new ProjetoDao();
        projeto = (Projeto) daoP.buscarObjetoCriteriaINT("id", 2, Projeto.class);

        projeto.setPlanofinanceiro(planoFinanceiro);
        projeto.setAnaliseemprego(analiseEmprego);
        projeto.setNegocio(negocio);
        projeto.setPotencialEmprego(emailEmpreendedor);
        projeto.setProdutoouservico(produtoOuSevico);
        projeto.setStatus(Integer.SIZE);

//        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//        Projeto projeto = (Projeto) sessao.getAttribute("projetoEditado");
//        projeto.getEmpreendedors().add(empreedendoresAdicionados);
//        System.out.println("nome" + projeto.getNome() + " id " + projeto.getIdProjeto());
//        empreendedorAchado.atualizarProjeto(projeto);
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
            empreendedorDeletar = empreendedor;
            if (empreendedor.getEmail().equals(empreendedorSelected.getEmail())) {
                if (empreendedor.getCpf() != null) {
                    System.out.println("entrou no if 1");
                    break;
                } else if (!empreendedor.verificarProjetoHasEmpreendedor(empreendedorSelected)) {
                    empreendedor.deletarEmpreendedor(empreendedor);
                    break;
                }
            }
        }
        System.out.println("Saiu");
        projeto.getEmpreendedors().remove(empreendedorDeletar);
        getEmpreedendoresAdicionados().remove(empreendedorDeletar);
    }

    /**
     * Adiciona o Empreendedor ao projeto.
     */
    public void adicionarEmpreendedor() {
        System.out.println("------ 0000 -----");
        boolean existe = false;
        Empreendedor empreendedorAchado = null;
        System.out.println("----- 1111 -----");
        for (Empreendedor empreendedor : listaEmpreendedor) {
            if (empreendedor.getEmail().equals(emailEmpreendedor)) {
//                listaEmpreendedor.add(empreendedor);
                System.out.println("--- 2 -----");
                existe = true;
                empreendedorAchado = empreendedor;
                break;
            }
        }

        if (existe == false) {
            System.out.println("---- 3 -----");
            Empreendedor empreendedor = new Empreendedor();
            empreendedor.setEmail(emailEmpreendedor);
            empreendedor.cadastrarEmpreendedor(empreendedor);
            empreendedorAchado = empreendedor;
        }

        if (!verificarLista(empreedendoresAdicionados, empreendedorAchado)) {
            System.out.println("");

            if (!verificarLista(empreedendoresAdicionados, empreendedorAchado)) {
                System.out.println("------ 4 ------");
                getEmpreedendoresAdicionados().add(empreendedorAchado);
                projeto.getEmpreendedors().add(empreendedorAchado);
            } else {
                FacesUtil.addErrorMessage("Empreendedor já adicionado", "formPlanoNegocio:autocomplete");
            }
            System.out.println("----- 5 -------");
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
     * @return the custo
     */
    public Custo getCusto() {
        return custo;
    }

    /**
     * @param custo the custo to set
     */
    public void setCusto(Custo custo) {
        this.custo = custo;
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
        ProjetoDao daoP = new ProjetoDao();
        daoP.salvar(pjto);

        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        secao.setAttribute("projetoSelecionado", pjto);
        return "/faces/view/enviarProjeto.xhtml";

    }
}
