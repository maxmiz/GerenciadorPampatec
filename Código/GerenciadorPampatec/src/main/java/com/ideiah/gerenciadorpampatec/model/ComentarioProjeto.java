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
 * @author Ideiah
 * @since 10/11/15
 */
public class ComentarioProjeto implements java.io.Serializable {

    public static final int EM_ANDAMENTO = 1;
    public static final int FINALIZADO = 2;

    private int idcomentario;
    private String nome;
    private String participacaoacionaria;
    private String potencialemprego;
    private String consideracoes;
    private Projeto projeto;
    private Integer status;
    private String consideracoesPersonalizadas;
    private Set textocomentarios = new HashSet(0);
    public static final int SEGMENTO_CLIENTE = 1;
    public static final int PROPOSTA_VALOR = 2;
    public static final int ATIVIDADES_CHAVE = 3;
    public static final int RELACOES_CLIENTE = 4;
    public static final int PARCERIAS_CHAVE = 5;
    public static final int CANAIS = 6;
    public static final int RECURSOS_PRINCIPAIS = 7;
    public static final int CONCORRENTES = 8;
    public static final int ESTAGIO_EVOLUCAO = 9;
    public static final int TECNOLOGIA_PROCESSOS = 10;
    public static final int POTENCIAL_INOVACAO_TECNOLOGICA = 11;
    public static final int APLICACOES = 12;
    public static final int DIFICULDADES_ESPERADAS = 13;
    public static final int INTERACAO_EMPRESA_UNIVERSIDADE = 14;
    public static final int INTERACAO_EMPRESA_COMUNIDADE_GOVERNO = 15;
    public static final int INFRAESTRUTURA = 16;
    public static final int PARTICIPACAO_ACIONARIA = 17;
    public static final int POTENCIAL_EMPREGO = 18;
    public static final int FONTES_RECEITA = 19;
    public static final int ESTRUTURA_CUSTO = 20;
    public static final int INVESTIMENTO_INICIAL = 21;
    public static final int CUSTOS_FIXOS = 22;
    public static final int CUSTOS_VARIAVEISS = 23;

    public ComentarioProjeto() {
        nome = "";
        participacaoacionaria = "";
        potencialemprego = "";
        consideracoes = "";
        consideracoesPersonalizadas = "";
        status = EM_ANDAMENTO;

    }

    public ComentarioProjeto(int idcomentario, ComentarioAnaliseEmprego comentarioanaliseemprego, ComentarioNegocio comentarionegocio, ComentarioPlanoFinanceiro comentarioplanofinanceiro, ComentarioProdutoOuServico comentarioprodutoouservico) {
        this.idcomentario = idcomentario;
    }

    public ComentarioProjeto(int idcomentario, ComentarioAnaliseEmprego comentarioanaliseemprego, ComentarioNegocio comentarionegocio, ComentarioPlanoFinanceiro comentarioplanofinanceiro, ComentarioProdutoOuServico comentarioprodutoouservico, String nome, String participacaoacionaria, String potencialemprego, String consideracoes) {
        this.idcomentario = idcomentario;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusString(int status) {
        String statusDescricao = "";
        switch (status) {
            case EM_ANDAMENTO:
                statusDescricao = "Em andamento";
                break;
            case FINALIZADO:
                statusDescricao = "Finalizado";
                break;
        }
        return statusDescricao;
    }

    /**
     * @return the consideracoesPersonalizadas
     */
    public String getConsideracoesPersonalizadas() {
        return consideracoesPersonalizadas;
    }

    /**
     * @param consideracoesPersonalizadas the consideracoesPersonalizadas to set
     */
    public void setConsideracoesPersonalizadas(String consideracoesPersonalizadas) {
        this.consideracoesPersonalizadas = consideracoesPersonalizadas;
    }

    public String todasConsideracoes() {
        return consideracoes + "\n" + consideracoesPersonalizadas;
    }

    /**
     * <p>
     * Retorna a quantidade de campos comentário vazios
     * </p>
     */
    public int verificaCampos() {
        int FLAG = 0;

        //NEGOCIO
        if (!this.getComentarionegocio().getSegmentoClientes().equals("")) {
            FLAG++;
        }

        if (!this.getComentarionegocio().getPropostaValor().equals("")) {
            FLAG++;
        }

        if (!this.getComentarionegocio().getAtividadesChaves().equals("")) {
            FLAG++;
        }
        //ANALISE DE MERCADO
        if (!this.getComentarioanaliseemprego().getRelacoesClientes().equals("")) {
            FLAG++;
        }

        if (!this.getComentarioanaliseemprego().getParceriasChaves().equals("")) {
            FLAG++;
        }

        if (!this.getComentarioanaliseemprego().getCanais().equals("")) {
            FLAG++;
        }

        if (!this.getComentarioanaliseemprego().getRecursosPrincipais().equals("")) {
            FLAG++;
        }

        if (!this.getComentarioanaliseemprego().getConcorrentes().equals("")) {
            FLAG++;
        }
        //PRODUTO OU SERVIÇO
        if (!this.getComentarioprodutoouservico().getEstagioEvolucao().equals("")) {
            FLAG++;
        }

        if (!this.getComentarioprodutoouservico().getTecnologiaProcessos().equals("")) {
            FLAG++;
        }

        if (!this.getComentarioprodutoouservico().getPotencialInovacaoTecnologica().equals("")) {
            FLAG++;
        }

        if (!this.getComentarioprodutoouservico().getAplicacoes().equals("")) {
            FLAG++;
        }

        if (!this.getComentarioprodutoouservico().getDificuldadesEsperadas().equals("")) {
            FLAG++;
        }

        if (!this.getComentarioprodutoouservico().getInteracaoEmpresaUniversidade().equals("")) {
            FLAG++;
        }

        if (!this.getComentarioprodutoouservico().getInteracaoEmpresaComunidadeGoverno().equals("")) {
            FLAG++;
        }

        if (!this.getComentarioprodutoouservico().getInfraestrutura().equals("")) {
            FLAG++;
        }
        //GESTAO DE PESSOAS
        if (!this.getParticipacaoacionaria().equals("")) {
            FLAG++;
        }

        if (!this.getPotencialemprego().equals("")) {
            FLAG++;
        }
        //PLANO FINANCEIRO
        if (!this.getComentarioplanofinanceiro().getFontesReceita().equals("")) {
            FLAG++;
        }

        if (!this.getComentarioplanofinanceiro().getEstruturaCusto().equals("")) {
            FLAG++;
        }

        if (!this.getComentarioplanofinanceiro().getInvestimentoInicial().equals("")) {
            FLAG++;
        }

        if (!this.getComentarioplanofinanceiro().getCustosfixos().equals("")) {
            FLAG++;
        }

        if (!this.getComentarioplanofinanceiro().getCustosvariaveis().equals("")) {
            FLAG++;
        }
        return FLAG;
    }

    /**
     * @return the textocomentarios
     */
    public Set getTextocomentarios() {
        return textocomentarios;
    }

    /**
     * @param textocomentarios the textocomentarios to set
     */
    public void setTextocomentarios(Set textocomentarios) {
        this.textocomentarios = textocomentarios;
    }

}
