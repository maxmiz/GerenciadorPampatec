/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.io.Serializable;

/**
 *
 * @author GUTO
 */
public class ComentarioProjeto implements Serializable{
 
    private String participacaoAcionaria;
    private String potencialEmprego;
    private String comentarioGeral;
    private int id_comentarioProjeto;
    private ComentarioAnaliseEmprego comentario_AnaliseEmprego;
    private ComentarioNegocio comentario_Negocio;
    private ComentarioPlanoFinanceiro comentario_PlanoFinanceiro;
    private ComentarioProdutoOuServico comentario_ProdutoOuServico;
    private Projeto projeto;

    public ComentarioProjeto() {
    }

    public ComentarioProjeto(String participacaoAcionaria, String potencialEmprego, String comentarioGeral, int id_comentarioProjeto, ComentarioAnaliseEmprego comentario_AnaliseEmprego, ComentarioNegocio comentario_Negocio, ComentarioPlanoFinanceiro comentario_PlanoFinanceiro, ComentarioProdutoOuServico comentario_ProdutoOuServico, Projeto projeto) {
        this.participacaoAcionaria = participacaoAcionaria;
        this.potencialEmprego = potencialEmprego;
        this.comentarioGeral = comentarioGeral;
        this.id_comentarioProjeto = id_comentarioProjeto;
        this.comentario_AnaliseEmprego = comentario_AnaliseEmprego;
        this.comentario_Negocio = comentario_Negocio;
        this.comentario_PlanoFinanceiro = comentario_PlanoFinanceiro;
        this.comentario_ProdutoOuServico = comentario_ProdutoOuServico;
        this.projeto = projeto;
    }

    
    /**
     * @return the participacaoAcionaria
     */
    public String getParticipacaoAcionaria() {
        return participacaoAcionaria;
    }

    /**
     * @param participacaoAcionaria the participacaoAcionaria to set
     */
    public void setParticipacaoAcionaria(String participacaoAcionaria) {
        this.participacaoAcionaria = participacaoAcionaria;
    }

    /**
     * @return the potencialEmprego
     */
    public String getPotencialEmprego() {
        return potencialEmprego;
    }

    /**
     * @param potencialEmprego the potencialEmprego to set
     */
    public void setPotencialEmprego(String potencialEmprego) {
        this.potencialEmprego = potencialEmprego;
    }

    /**
     * @return the comentarioGeral
     */
    public String getComentarioGeral() {
        return comentarioGeral;
    }

    /**
     * @param comentarioGeral the comentarioGeral to set
     */
    public void setComentarioGeral(String comentarioGeral) {
        this.comentarioGeral = comentarioGeral;
    }

    /**
     * @return the id_comentarioProjeto
     */
    public int getId_comentarioProjeto() {
        return id_comentarioProjeto;
    }

    /**
     * @param id_comentarioProjeto the id_comentarioProjeto to set
     */
    public void setId_comentarioProjeto(int id_comentarioProjeto) {
        this.id_comentarioProjeto = id_comentarioProjeto;
    }

    /**
     * @return the comentario_AnaliseEmprego
     */
    public ComentarioAnaliseEmprego getComentario_AnaliseEmprego() {
        return comentario_AnaliseEmprego;
    }

    /**
     * @param comentario_AnaliseEmprego the comentario_AnaliseEmprego to set
     */
    public void setComentario_AnaliseEmprego(ComentarioAnaliseEmprego comentario_AnaliseEmprego) {
        this.comentario_AnaliseEmprego = comentario_AnaliseEmprego;
    }

    /**
     * @return the comentario_Negocio
     */
    public ComentarioNegocio getComentario_Negocio() {
        return comentario_Negocio;
    }

    /**
     * @param comentario_Negocio the comentario_Negocio to set
     */
    public void setComentario_Negocio(ComentarioNegocio comentario_Negocio) {
        this.comentario_Negocio = comentario_Negocio;
    }

    /**
     * @return the comentario_PlanoFinanceiro
     */
    public ComentarioPlanoFinanceiro getComentario_PlanoFinanceiro() {
        return comentario_PlanoFinanceiro;
    }

    /**
     * @param comentario_PlanoFinanceiro the comentario_PlanoFinanceiro to set
     */
    public void setComentario_PlanoFinanceiro(ComentarioPlanoFinanceiro comentario_PlanoFinanceiro) {
        this.comentario_PlanoFinanceiro = comentario_PlanoFinanceiro;
    }

    /**
     * @return the comentario_ProdutoOuServico
     */
    public ComentarioProdutoOuServico getComentario_ProdutoOuServico() {
        return comentario_ProdutoOuServico;
    }

    /**
     * @param comentario_ProdutoOuServico the comentario_ProdutoOuServico to set
     */
    public void setComentario_ProdutoOuServico(ComentarioProdutoOuServico comentario_ProdutoOuServico) {
        this.comentario_ProdutoOuServico = comentario_ProdutoOuServico;
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
    
}
