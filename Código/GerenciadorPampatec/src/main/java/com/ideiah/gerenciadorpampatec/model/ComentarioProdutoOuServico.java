/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Edison Jhonatan
 * @since 10/11/15
 */
public class ComentarioProdutoOuServico implements java.io.Serializable {

    private int idcomentarioprodutoouservico;
    private String estagioEvolucao;
    private String tecnologiaProcessos;
    private String potencialInovacaoTecnologica;
    private String aplicacoes;
    private String dificuldadesEsperadas;
    private String interacaoEmpresaUniversidade;
    private String interacaoEmpresaComunidadeGoverno;
    private String infraestrutura;
    private Set comentarioprojetos;

    public ComentarioProdutoOuServico() {
        estagioEvolucao = "";
        tecnologiaProcessos = "";
        potencialInovacaoTecnologica = "";
        aplicacoes = "";
        dificuldadesEsperadas = "";
        interacaoEmpresaUniversidade = "";
        interacaoEmpresaComunidadeGoverno = "";
        infraestrutura = "";
        comentarioprojetos = new HashSet(0);
    }

    public ComentarioProdutoOuServico(int idcomentarioprodutoouservico) {
        this.idcomentarioprodutoouservico = idcomentarioprodutoouservico;
    }

    public ComentarioProdutoOuServico(int idcomentarioprodutoouservico, String estagioEvolucao, String tecnologiaProcessos, String potencialInovacaoTecnologica, String aplicacoes, String dificuldadesEsperadas, String interacaoEmpresaUniversidade, String interacaoEmpresaComunidadeGoverno, String infraestrutura, Set comentarioprojetos) {
        this.idcomentarioprodutoouservico = idcomentarioprodutoouservico;
        this.estagioEvolucao = estagioEvolucao;
        this.tecnologiaProcessos = tecnologiaProcessos;
        this.potencialInovacaoTecnologica = potencialInovacaoTecnologica;
        this.aplicacoes = aplicacoes;
        this.dificuldadesEsperadas = dificuldadesEsperadas;
        this.interacaoEmpresaUniversidade = interacaoEmpresaUniversidade;
        this.interacaoEmpresaComunidadeGoverno = interacaoEmpresaComunidadeGoverno;
        this.infraestrutura = infraestrutura;
        this.comentarioprojetos = comentarioprojetos;
    }

    public int getIdcomentarioprodutoouservico() {
        return this.idcomentarioprodutoouservico;
    }

    public void setIdcomentarioprodutoouservico(int idcomentarioprodutoouservico) {
        this.idcomentarioprodutoouservico = idcomentarioprodutoouservico;
    }

    public String getEstagioEvolucao() {
        return this.estagioEvolucao;
    }

    public void setEstagioEvolucao(String estagioEvolucao) {
        this.estagioEvolucao = estagioEvolucao;
    }

    public String getTecnologiaProcessos() {
        return this.tecnologiaProcessos;
    }

    public void setTecnologiaProcessos(String tecnologiaProcessos) {
        this.tecnologiaProcessos = tecnologiaProcessos;
    }

    public String getPotencialInovacaoTecnologica() {
        return this.potencialInovacaoTecnologica;
    }

    public void setPotencialInovacaoTecnologica(String potencialInovacaoTecnologica) {
        this.potencialInovacaoTecnologica = potencialInovacaoTecnologica;
    }

    public String getAplicacoes() {
        return this.aplicacoes;
    }

    public void setAplicacoes(String aplicacoes) {
        this.aplicacoes = aplicacoes;
    }

    public String getDificuldadesEsperadas() {
        return this.dificuldadesEsperadas;
    }

    public void setDificuldadesEsperadas(String dificuldadesEsperadas) {
        this.dificuldadesEsperadas = dificuldadesEsperadas;
    }

    public String getInteracaoEmpresaUniversidade() {
        return this.interacaoEmpresaUniversidade;
    }

    public void setInteracaoEmpresaUniversidade(String interacaoEmpresaUniversidade) {
        this.interacaoEmpresaUniversidade = interacaoEmpresaUniversidade;
    }

    public String getInteracaoEmpresaComunidadeGoverno() {
        return this.interacaoEmpresaComunidadeGoverno;
    }

    public void setInteracaoEmpresaComunidadeGoverno(String interacaoEmpresaComunidadeGoverno) {
        this.interacaoEmpresaComunidadeGoverno = interacaoEmpresaComunidadeGoverno;
    }

    public String getInfraestrutura() {
        return this.infraestrutura;
    }

    public void setInfraestrutura(String infraestrutura) {
        this.infraestrutura = infraestrutura;
    }

    public Set getComentarioprojetos() {
        return this.comentarioprojetos;
    }

    public void setComentarioprojetos(Set comentarioprojetos) {
        this.comentarioprojetos = comentarioprojetos;
    }
}
