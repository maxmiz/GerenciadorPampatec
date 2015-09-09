/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Analiseemprego;
import com.ideiah.gerenciadorpampatec.model.Custo;
import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Negocio;
import com.ideiah.gerenciadorpampatec.model.Planofinanceiro;
import com.ideiah.gerenciadorpampatec.model.Produtoouservico;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
        System.out.println(empreendedorSelected);
        for (Empreendedor empreendedor : listaEmpreendedor) {
            if (empreendedor.getEmail().equals(empreendedorSelected.getEmail())) {
                getEmpreedendoresAdicionados().remove(empreendedor);
                break;
            }
        }
    }

    /**
     * Adiciona o Empreendedor ao projeto.
     */
    public void adicionarEmpreendedor() {
        boolean existe = false;
        for (Empreendedor empreendedor : listaEmpreendedor) {
            if (empreendedor.getEmail().equals(emailEmpreendedor)) {
                getEmpreedendoresAdicionados().add(empreendedor);
                existe = true;
                break;
            }
        }
        if (existe == false) {
            Empreendedor empreendedor = new Empreendedor();
            empreendedor.setEmail(emailEmpreendedor);
            getEmpreedendoresAdicionados().add(empreendedor);
            empreendedor.cadastrarEmpreendedor(empreendedor);
        }
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
}
