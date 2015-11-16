/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.util.Date;

/**
 *
 * @author Edison Jhonatan
 * @since 10/11/15
 */
public class ProjetoBase implements java.io.Serializable {

    public static final int PENDENTE = 1;
    public static final int SENDO_AVALIADO = 2;
    
    private int idprojetobase;
    private ComentarioProjeto comentarioprojeto;
    private Projeto projeto;
    private Projeto projetoReferencia;
    private Date dataAvaliacao;
    private Integer status;
    private Date dataUltimaAlteracao;
    private GerenteRelacionamento gerenteRelacionamento;


    public ProjetoBase() {
    }
    
    public ProjetoBase(Projeto projeto){   
        this.projetoReferencia = projeto;
        projeto.setIdProjeto(null);
        projeto.setStatus(Projeto.LINHA_DE_BASE);
        this.projeto = projeto;
        this.status = PENDENTE;
    }
    public ProjetoBase(int idprojetobase, ComentarioProjeto comentarioprojeto, Projeto projeto) {
        this.idprojetobase = idprojetobase;
        this.comentarioprojeto = comentarioprojeto;
        this.projeto = projeto;
    }

    public ProjetoBase(int idprojetobase, ComentarioProjeto comentarioprojeto, Projeto projeto, Date dataAvaliacao, Integer status) {
        this.idprojetobase = idprojetobase;
        this.comentarioprojeto = comentarioprojeto;
        this.projeto = projeto;
        this.dataAvaliacao = dataAvaliacao;
        this.status = status;
    }
    public int getIdprojetobase() {
        return this.idprojetobase;
    }

    public void setIdprojetobase(int idprojetobase) {
        this.idprojetobase = idprojetobase;
    }

    public ComentarioProjeto getComentarioprojeto() {
        return this.comentarioprojeto;
    }

    public void setComentarioprojeto(ComentarioProjeto comentarioprojeto) {
        this.comentarioprojeto = comentarioprojeto;
    }

    public Projeto getProjeto() {
        return this.projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Date getDataAvaliacao() {
        return this.dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public GerenteRelacionamento getGerenteRelacionamento() {
        return gerenteRelacionamento;
    }

    public void setGerenteRelacionamento(GerenteRelacionamento gerenteRelacionamento) {
        this.gerenteRelacionamento = gerenteRelacionamento;
    }

    public Projeto getProjetoReferencia() {
        return projetoReferencia;
    }

    public void setProjetoReferencia(Projeto projetoReferencia) {
        this.projetoReferencia = projetoReferencia;
    }

}
