/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Edison Jhonatan
 * @since 10/11/15
 */
public class ComentarioPlanoFinanceiro implements java.io.Serializable {

    private int idcomentarioplanofinanceiro;
    private String fontesReceita;
    private String estruturaCusto;
    private String investimentoInicial;
    private String custosfixos;
    private String custosvariaveis;
    private Set comentarioprojetos;

    public ComentarioPlanoFinanceiro() {
        fontesReceita = "";
        estruturaCusto = "";
        investimentoInicial = "";
        custosfixos = "";
        custosvariaveis = "";
        comentarioprojetos = new HashSet(0);
    }

    public ComentarioPlanoFinanceiro(int idcomentarioplanofinanceiro) {
        this.idcomentarioplanofinanceiro = idcomentarioplanofinanceiro;
    }

    public ComentarioPlanoFinanceiro(int idcomentarioplanofinanceiro, String fontesReceita, String estruturaCusto, String investimentoInicial, String custosfixos, String custosvariaveis, Set comentarioprojetos) {
        this.idcomentarioplanofinanceiro = idcomentarioplanofinanceiro;
        this.fontesReceita = fontesReceita;
        this.estruturaCusto = estruturaCusto;
        this.investimentoInicial = investimentoInicial;
        this.custosfixos = custosfixos;
        this.custosvariaveis = custosvariaveis;
        this.comentarioprojetos = comentarioprojetos;
    }

    public int getIdcomentarioplanofinanceiro() {
        return this.idcomentarioplanofinanceiro;
    }

    public void setIdcomentarioplanofinanceiro(int idcomentarioplanofinanceiro) {
        this.idcomentarioplanofinanceiro = idcomentarioplanofinanceiro;
    }

    public String getFontesReceita() {
        return this.fontesReceita;
    }

    public void setFontesReceita(String fontesReceita) {
        this.fontesReceita = fontesReceita;
    }

    public String getEstruturaCusto() {
        return this.estruturaCusto;
    }

    public void setEstruturaCusto(String estruturaCusto) {
        this.estruturaCusto = estruturaCusto;
    }

    public String getInvestimentoInicial() {
        return this.investimentoInicial;
    }

    public void setInvestimentoInicial(String investimentoInicial) {
        this.investimentoInicial = investimentoInicial;
    }

    public String getCustosfixos() {
        return this.custosfixos;
    }

    public void setCustosfixos(String custosfixos) {
        this.custosfixos = custosfixos;
    }

    public String getCustosvariaveis() {
        return this.custosvariaveis;
    }

    public void setCustosvariaveis(String custosvariaveis) {
        this.custosvariaveis = custosvariaveis;
    }

    public Set getComentarioprojetos() {
        return this.comentarioprojetos;
    }

    public void setComentarioprojetos(Set comentarioprojetos) {
        this.comentarioprojetos = comentarioprojetos;
    }

}
