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
    private Comentario_AnaliseEmprego comentario_AnaliseEmprego;
    private Comentario_Negocio comentario_Negocio;
    private Comentario_PlanoFinanceiro comentario_PlanoFinanceiro;
    private Comentario_ProdutoOuServico comentario_ProdutoOuServico;

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
    public Comentario_AnaliseEmprego getComentario_AnaliseEmprego() {
        return comentario_AnaliseEmprego;
    }

    /**
     * @param comentario_AnaliseEmprego the comentario_AnaliseEmprego to set
     */
    public void setComentario_AnaliseEmprego(Comentario_AnaliseEmprego comentario_AnaliseEmprego) {
        this.comentario_AnaliseEmprego = comentario_AnaliseEmprego;
    }

    /**
     * @return the comentario_Negocio
     */
    public Comentario_Negocio getComentario_Negocio() {
        return comentario_Negocio;
    }

    /**
     * @param comentario_Negocio the comentario_Negocio to set
     */
    public void setComentario_Negocio(Comentario_Negocio comentario_Negocio) {
        this.comentario_Negocio = comentario_Negocio;
    }

    /**
     * @return the comentario_PlanoFinanceiro
     */
    public Comentario_PlanoFinanceiro getComentario_PlanoFinanceiro() {
        return comentario_PlanoFinanceiro;
    }

    /**
     * @param comentario_PlanoFinanceiro the comentario_PlanoFinanceiro to set
     */
    public void setComentario_PlanoFinanceiro(Comentario_PlanoFinanceiro comentario_PlanoFinanceiro) {
        this.comentario_PlanoFinanceiro = comentario_PlanoFinanceiro;
    }

    /**
     * @return the comentario_ProdutoOuServico
     */
    public Comentario_ProdutoOuServico getComentario_ProdutoOuServico() {
        return comentario_ProdutoOuServico;
    }

    /**
     * @param comentario_ProdutoOuServico the comentario_ProdutoOuServico to set
     */
    public void setComentario_ProdutoOuServico(Comentario_ProdutoOuServico comentario_ProdutoOuServico) {
        this.comentario_ProdutoOuServico = comentario_ProdutoOuServico;
    }
    
}
