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
public class ComentarioProdutoOuServico implements Serializable {

    private String estagioEvolucao;
    private String tecnologiaProcessos;
    private String potencialInovacaoTecnologica;
    private String aplicacoes;
    private String dificuldadesEsperadas;
    private String interacaoEmpresauniversidade;
    private String interacaoEmpresaComunidadeGoverno;
    private String infraestrutura;
    private int idcomentario_produtoouservico;
    private ComentarioProjeto comentarioProjeto;

    public ComentarioProdutoOuServico() {
    }

    public ComentarioProdutoOuServico(String estagioEvolucao, String tecnologiaProcessos, String potencialInovacaoTecnologica, String aplicacoes, String dificuldadesEsperadas, String interacaoEmpresauniversidade, String interacaoEmpresaComunidadeGoverno, String infraestrutura, int idcomentario_produtoouservico, ComentarioProjeto comentarioProjeto) {
        this.estagioEvolucao = estagioEvolucao;
        this.tecnologiaProcessos = tecnologiaProcessos;
        this.potencialInovacaoTecnologica = potencialInovacaoTecnologica;
        this.aplicacoes = aplicacoes;
        this.dificuldadesEsperadas = dificuldadesEsperadas;
        this.interacaoEmpresauniversidade = interacaoEmpresauniversidade;
        this.interacaoEmpresaComunidadeGoverno = interacaoEmpresaComunidadeGoverno;
        this.infraestrutura = infraestrutura;
        this.idcomentario_produtoouservico = idcomentario_produtoouservico;
        this.comentarioProjeto = comentarioProjeto;
    }

    
    /**
     * @return the estagioEvolucao
     */
    public String getEstagioEvolucao() {
        return estagioEvolucao;
    }

    /**
     * @param estagioEvolucao the estagioEvolucao to set
     */
    public void setEstagioEvolucao(String estagioEvolucao) {
        this.estagioEvolucao = estagioEvolucao;
    }

    /**
     * @return the tecnologiaProcessos
     */
    public String getTecnologiaProcessos() {
        return tecnologiaProcessos;
    }

    /**
     * @param tecnologiaProcessos the tecnologiaProcessos to set
     */
    public void setTecnologiaProcessos(String tecnologiaProcessos) {
        this.tecnologiaProcessos = tecnologiaProcessos;
    }

    /**
     * @return the potencialInovacaoTecnologica
     */
    public String getPotencialInovacaoTecnologica() {
        return potencialInovacaoTecnologica;
    }

    /**
     * @param potencialInovacaoTecnologica the potencialInovacaoTecnologica to set
     */
    public void setPotencialInovacaoTecnologica(String potencialInovacaoTecnologica) {
        this.potencialInovacaoTecnologica = potencialInovacaoTecnologica;
    }

    /**
     * @return the aplicacoes
     */
    public String getAplicacoes() {
        return aplicacoes;
    }

    /**
     * @param aplicacoes the aplicacoes to set
     */
    public void setAplicacoes(String aplicacoes) {
        this.aplicacoes = aplicacoes;
    }

    /**
     * @return the dificuldadesEsperadas
     */
    public String getDificuldadesEsperadas() {
        return dificuldadesEsperadas;
    }

    /**
     * @param dificuldadesEsperadas the dificuldadesEsperadas to set
     */
    public void setDificuldadesEsperadas(String dificuldadesEsperadas) {
        this.dificuldadesEsperadas = dificuldadesEsperadas;
    }

    /**
     * @return the interacaoEmpresauniversidade
     */
    public String getInteracaoEmpresauniversidade() {
        return interacaoEmpresauniversidade;
    }

    /**
     * @param interacaoEmpresauniversidade the interacaoEmpresauniversidade to set
     */
    public void setInteracaoEmpresauniversidade(String interacaoEmpresauniversidade) {
        this.interacaoEmpresauniversidade = interacaoEmpresauniversidade;
    }

    /**
     * @return the interacaoEmpresaComunidadeGoverno
     */
    public String getInteracaoEmpresaComunidadeGoverno() {
        return interacaoEmpresaComunidadeGoverno;
    }

    /**
     * @param interacaoEmpresaComunidadeGoverno the interacaoEmpresaComunidadeGoverno to set
     */
    public void setInteracaoEmpresaComunidadeGoverno(String interacaoEmpresaComunidadeGoverno) {
        this.interacaoEmpresaComunidadeGoverno = interacaoEmpresaComunidadeGoverno;
    }

    /**
     * @return the infraestrutura
     */
    public String getInfraestrutura() {
        return infraestrutura;
    }

    /**
     * @param infraestrutura the infraestrutura to set
     */
    public void setInfraestrutura(String infraestrutura) {
        this.infraestrutura = infraestrutura;
    }

    /**
     * @return the idcomentario_produtoouservico
     */
    public int getIdcomentario_produtoouservico() {
        return idcomentario_produtoouservico;
    }

    /**
     * @param idcomentario_produtoouservico the idcomentario_produtoouservico to set
     */
    public void setIdcomentario_produtoouservico(int idcomentario_produtoouservico) {
        this.idcomentario_produtoouservico = idcomentario_produtoouservico;
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
