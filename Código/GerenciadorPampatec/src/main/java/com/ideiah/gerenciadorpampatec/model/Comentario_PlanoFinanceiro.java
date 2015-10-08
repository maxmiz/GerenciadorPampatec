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
public class Comentario_PlanoFinanceiro implements Serializable{
    private String fontesReceita;
    private String estruturaCusto;
    private String investimentoInicial;
    private String custosFixos;
    private String custosVariaveis;
    private int idcomentario_planofinanceiro;
    private ComentarioProjeto comentarioProjeto;

    /**
     * @return the fontesReceita
     */
    public String getFontesReceita() {
        return fontesReceita;
    }

    /**
     * @param fontesReceita the fontesReceita to set
     */
    public void setFontesReceita(String fontesReceita) {
        this.fontesReceita = fontesReceita;
    }

    /**
     * @return the estruturaCusto
     */
    public String getEstruturaCusto() {
        return estruturaCusto;
    }

    /**
     * @param estruturaCusto the estruturaCusto to set
     */
    public void setEstruturaCusto(String estruturaCusto) {
        this.estruturaCusto = estruturaCusto;
    }

    /**
     * @return the investimentoInicial
     */
    public String getInvestimentoInicial() {
        return investimentoInicial;
    }

    /**
     * @param investimentoInicial the investimentoInicial to set
     */
    public void setInvestimentoInicial(String investimentoInicial) {
        this.investimentoInicial = investimentoInicial;
    }

    /**
     * @return the custosFixos
     */
    public String getCustosFixos() {
        return custosFixos;
    }

    /**
     * @param custosFixos the custosFixos to set
     */
    public void setCustosFixos(String custosFixos) {
        this.custosFixos = custosFixos;
    }

    /**
     * @return the custosVariaveis
     */
    public String getCustosVariaveis() {
        return custosVariaveis;
    }

    /**
     * @param custosVariaveis the custosVariaveis to set
     */
    public void setCustosVariaveis(String custosVariaveis) {
        this.custosVariaveis = custosVariaveis;
    }

    /**
     * @return the idcomentario_planofinanceiro
     */
    public int getIdcomentario_planofinanceiro() {
        return idcomentario_planofinanceiro;
    }

    /**
     * @param idcomentario_planofinanceiro the idcomentario_planofinanceiro to set
     */
    public void setIdcomentario_planofinanceiro(int idcomentario_planofinanceiro) {
        this.idcomentario_planofinanceiro = idcomentario_planofinanceiro;
    }

    /**
     * @return the comentarioProjeto
     */
    public ComentarioProjeto getComentarioProjeto() {
        return comentarioProjeto;
    }

    /**
     * @param comentarioProjeto the comentarioProjeto to set
     */
    public void setComentarioProjeto(ComentarioProjeto comentarioProjeto) {
        this.comentarioProjeto = comentarioProjeto;
    }
}
