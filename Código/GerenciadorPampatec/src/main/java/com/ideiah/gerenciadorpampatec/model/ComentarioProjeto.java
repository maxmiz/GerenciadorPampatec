/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import com.ideiah.gerenciadorpampatec.util.StatusUtil;
import java.util.Set;

/**
 *
 * @author Edison Jhonatan
 * @since 10/11/15
 */
public class ComentarioProjeto implements java.io.Serializable {

    private int idcomentario;
    private ComentarioAnaliseEmprego comentarioanaliseemprego;
    private ComentarioNegocio comentarionegocio;
    private ComentarioPlanoFinanceiro comentarioplanofinanceiro;
    private ComentarioProdutoOuServico comentarioprodutoouservico;
    private String nome;
    private String participacaoacionaria;
    private String potencialemprego;
    private String consideracoes;
    private Projeto projeto;
    private StatusUtil status;

    public ComentarioProjeto() {
        comentarioanaliseemprego = new ComentarioAnaliseEmprego();
        comentarionegocio = new ComentarioNegocio();
        comentarioplanofinanceiro = new ComentarioPlanoFinanceiro();
        comentarioprodutoouservico = new ComentarioProdutoOuServico();
        nome = "";
        participacaoacionaria = "";
        potencialemprego = "";
        consideracoes = "";
        status = StatusUtil.EM_ANDAMENTO;
        
    }

    public ComentarioProjeto(int idcomentario, ComentarioAnaliseEmprego comentarioanaliseemprego, ComentarioNegocio comentarionegocio, ComentarioPlanoFinanceiro comentarioplanofinanceiro, ComentarioProdutoOuServico comentarioprodutoouservico) {
        this.idcomentario = idcomentario;
        this.comentarioanaliseemprego = comentarioanaliseemprego;
        this.comentarionegocio = comentarionegocio;
        this.comentarioplanofinanceiro = comentarioplanofinanceiro;
        this.comentarioprodutoouservico = comentarioprodutoouservico;
    }

    public ComentarioProjeto(int idcomentario, ComentarioAnaliseEmprego comentarioanaliseemprego, ComentarioNegocio comentarionegocio, ComentarioPlanoFinanceiro comentarioplanofinanceiro, ComentarioProdutoOuServico comentarioprodutoouservico, String nome, String participacaoacionaria, String potencialemprego, String consideracoes, Set projetobases) {
        this.idcomentario = idcomentario;
        this.comentarioanaliseemprego = comentarioanaliseemprego;
        this.comentarionegocio = comentarionegocio;
        this.comentarioplanofinanceiro = comentarioplanofinanceiro;
        this.comentarioprodutoouservico = comentarioprodutoouservico;
        this.nome = nome;
        this.participacaoacionaria = participacaoacionaria;
        this.potencialemprego = potencialemprego;
        this.consideracoes = consideracoes;
    }

    public int getIdcomentario() {
        return this.idcomentario;
    }

    public void setIdcomentario(int idcomentario) {
        this.idcomentario = idcomentario;
    }

    public ComentarioAnaliseEmprego getComentarioanaliseemprego() {
        return this.comentarioanaliseemprego;
    }

    public void setComentarioanaliseemprego(ComentarioAnaliseEmprego comentarioanaliseemprego) {
        this.comentarioanaliseemprego = comentarioanaliseemprego;
    }

    public ComentarioNegocio getComentarionegocio() {
        return this.comentarionegocio;
    }

    public void setComentarionegocio(ComentarioNegocio comentarionegocio) {
        this.comentarionegocio = comentarionegocio;
    }

    public ComentarioPlanoFinanceiro getComentarioplanofinanceiro() {
        return this.comentarioplanofinanceiro;
    }

    public void setComentarioplanofinanceiro(ComentarioPlanoFinanceiro comentarioplanofinanceiro) {
        this.comentarioplanofinanceiro = comentarioplanofinanceiro;
    }

    public ComentarioProdutoOuServico getComentarioprodutoouservico() {
        return this.comentarioprodutoouservico;
    }

    public void setComentarioprodutoouservico(ComentarioProdutoOuServico comentarioprodutoouservico) {
        this.comentarioprodutoouservico = comentarioprodutoouservico;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParticipacaoacionaria() {
        return this.participacaoacionaria;
    }

    public void setParticipacaoacionaria(String participacaoacionaria) {
        this.participacaoacionaria = participacaoacionaria;
    }

    public String getPotencialemprego() {
        return this.potencialemprego;
    }

    public void setPotencialemprego(String potencialemprego) {
        this.potencialemprego = potencialemprego;
    }

    public String getConsideracoes() {
        return this.consideracoes;
    }

    public void setConsideracoes(String consideracoes) {
        this.consideracoes = consideracoes;
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
     * @return the status
     */
    public StatusUtil getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(StatusUtil status) {
        this.status = status;
    }

}
