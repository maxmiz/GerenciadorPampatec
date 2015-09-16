package com.ideiah.gerenciadorpampatec.model;
// Generated 31/08/2015 13:49:28 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Projeto generated by hbm2java
 */
public class Projeto implements java.io.Serializable {

    public static final int EM_EDICAO = 0;
    public static final int EM_AVALIACAO = 1;
    public static final int APROVADO = 2;
    public static final int REPROVADO = 3;
    public static final int EM_CORRECAO = 4;

    private int idProjeto;
    private Analiseemprego analiseemprego;
    private Negocio negocio;
    private Planofinanceiro planofinanceiro;
    private Produtoouservico produtoouservico;
    private String nome;
    private Date dataEnvio;
    private Integer status;
    private String potencialEmprego;
    private Set empreendedors = new HashSet(0);

    public Projeto() {
    }

    public Projeto(int idProjeto, Analiseemprego analiseemprego, Negocio negocio, Planofinanceiro planofinanceiro, Produtoouservico produtoouservico) {
        this.idProjeto = idProjeto;
        this.analiseemprego = analiseemprego;
        this.negocio = negocio;
        this.planofinanceiro = planofinanceiro;
        this.produtoouservico = produtoouservico;
    }

    public Projeto(int idProjeto, Analiseemprego analiseemprego, Negocio negocio, Planofinanceiro planofinanceiro, Produtoouservico produtoouservico, String nome, Date dataEnvio, Integer status, String potencialEmprego, Set empreendedors) {
        this.idProjeto = idProjeto;
        this.analiseemprego = analiseemprego;
        this.negocio = negocio;
        this.planofinanceiro = planofinanceiro;
        this.produtoouservico = produtoouservico;
        this.nome = nome;
        this.dataEnvio = dataEnvio;
        this.status = status;
        this.potencialEmprego = potencialEmprego;
        this.empreendedors = empreendedors;
    }

    public int getIdProjeto() {
        return this.idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public Analiseemprego getAnaliseemprego() {
        return this.analiseemprego;
    }

    public void setAnaliseemprego(Analiseemprego analiseemprego) {
        this.analiseemprego = analiseemprego;
    }

    public Negocio getNegocio() {
        return this.negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    public Planofinanceiro getPlanofinanceiro() {
        return this.planofinanceiro;
    }

    public void setPlanofinanceiro(Planofinanceiro planofinanceiro) {
        this.planofinanceiro = planofinanceiro;
    }

    public Produtoouservico getProdutoouservico() {
        return this.produtoouservico;
    }

    public void setProdutoouservico(Produtoouservico produtoouservico) {
        this.produtoouservico = produtoouservico;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataEnvio() {
        return this.dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getStatusString(int status) {
        String statusDescricao = "";

        switch (status) {
            case 0:
                statusDescricao = "Em edição";
                break;
            case 1:
                statusDescricao = "Em avaliação";
                break;
            case 2:
                statusDescricao = "Aprovado";
                break;
            case 3:
                statusDescricao = "Reprovado";
                break;
            case 4:
                statusDescricao = "Em correção";
                break;
        }

        return statusDescricao;

    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPotencialEmprego() {
        return this.potencialEmprego;
    }

    public void setPotencialEmprego(String potencialEmprego) {
        this.potencialEmprego = potencialEmprego;
    }

    public Set getEmpreendedors() {
        return this.empreendedors;
    }

    public void setEmpreendedors(Set empreendedors) {
        this.empreendedors = empreendedors;
    }

}
