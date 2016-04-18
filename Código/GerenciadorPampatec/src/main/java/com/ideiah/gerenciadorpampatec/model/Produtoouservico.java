package com.ideiah.gerenciadorpampatec.model;
// Generated 31/08/2015 13:49:28 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Produtoouservico generated by hbm2java
 */
public class Produtoouservico implements java.io.Serializable {

    public static final String IDEIA_BASICA = "Ideia Básica";
    public static final String PROJETO_BASICO = "Projeto básico";
    public static final String PROJETO_DETALHADO = "Projeto detalhado";
    public static final String PROTOTIPO_DESENVOLVIDO = "Protótipo desenvolvido";
    public static final String EM_TESTE_NO_MERCADO = "Em teste no mercado";
    public static final String CLIENTES_PAGANDO = "Clientes Pagando";
    private int idProdutoOuServico;
    private String estagioEvolucao;
    private String tecnologiaProcessos;
    private String potencialInovacaoTecnologica;
    private String aplicacoes;
    private String dificuldadesEsperadas;
    private String interacaoEmpresaUniversidade;
    private String interacaoEmpresaComunidadeGoverno;
    private String infraestrutura;
    private Set projetos = new HashSet(0);

    public Produtoouservico() {
    }
//    Metodo para verificar qual o status do estagio de evolucao do projeto

    public String verificaStatusProjeto(String status) {
        switch (status) {
            case "Ideia Básica":
                return IDEIA_BASICA;
            case "Projeto Básico":
                return PROJETO_BASICO;
            case "Projeto Detalhado":
                return PROJETO_DETALHADO;
            case "Protótipo Desenvolvido":
                return PROTOTIPO_DESENVOLVIDO;
            case "Em teste no mercado":
                return EM_TESTE_NO_MERCADO;
            case "Clientes Pagando":
                return CLIENTES_PAGANDO;
            default:
                break;
        }
        return "Outro:";
    }

    public Produtoouservico(int idProdutoOuServico, String estagioEvolucao) {
        this.idProdutoOuServico = idProdutoOuServico;
        this.estagioEvolucao = verificaStatusProjeto(estagioEvolucao);       
    }

    public Produtoouservico(int idProdutoOuServico, String estagioEvolucao, String tecnologiaProcessos, String potencialInovacaoTecnologica, String aplicacoes, String dificuldadesEsperadas, String interacaoEmpresaUniversidade, String interacaoEmpresaComunidadeGoverno, String infraestrutura, Set projetos) {
        this.idProdutoOuServico = idProdutoOuServico;
//        this.estagioEvolucao = estagioEvolucao;
        this.tecnologiaProcessos = tecnologiaProcessos;
        this.potencialInovacaoTecnologica = potencialInovacaoTecnologica;
        this.aplicacoes = aplicacoes;
        this.dificuldadesEsperadas = dificuldadesEsperadas;
        this.interacaoEmpresaUniversidade = interacaoEmpresaUniversidade;
        this.interacaoEmpresaComunidadeGoverno = interacaoEmpresaComunidadeGoverno;
        this.infraestrutura = infraestrutura;
        this.projetos = projetos;
        this.estagioEvolucao = verificaStatusProjeto(estagioEvolucao);       

    }

    public int getIdProdutoOuServico() {
        return this.idProdutoOuServico;
    }

    public void setIdProdutoOuServico(int idProdutoOuServico) {
        this.idProdutoOuServico = idProdutoOuServico;
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

    public Set getProjetos() {
        return this.projetos;
    }

    public void setProjetos(Set projetos) {
        this.projetos = projetos;
    }

}
