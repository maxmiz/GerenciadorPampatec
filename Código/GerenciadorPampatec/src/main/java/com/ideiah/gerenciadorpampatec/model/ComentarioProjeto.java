/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
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
    private Set<Textocomentario> textocomentarios = new HashSet(0);

    public ComentarioProjeto() {
        nome = "";
        participacaoacionaria = "";
        potencialemprego = "";
        consideracoes = "";
        consideracoesPersonalizadas = "";
        status = EM_ANDAMENTO;
        adicionaListaComentario();
    }

    public ComentarioProjeto(int idcomentario) {
        this.idcomentario = idcomentario;
    }

    public ComentarioProjeto(int idcomentario, String nome, String participacaoacionaria, String potencialemprego, String consideracoes) {
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
        if (!retornaTextoComentario(Textocomentario.SEGMENTO_CLIENTE).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.PROPOSTA_VALOR).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.ATIVIDADES_CHAVE).equals("")) {
            FLAG++;
        }
        //ANALISE DE MERCADO
        if (!retornaTextoComentario(Textocomentario.RELACOES_CLIENTE).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.PARCERIAS_CHAVE).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.CANAIS).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.CONCORRENTES).equals("")) {
            FLAG++;
        }
        //PRODUTO OU SERVIÇO
        if (!retornaTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.APLICACOES).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.INFRAESTRUTURA).equals("")) {
            FLAG++;
        }
        //GESTAO DE PESSOAS
        if (!retornaTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.POTENCIAL_EMPREGO).equals("")) {
            FLAG++;
        }
        //PLANO FINANCEIRO
        if (!retornaTextoComentario(Textocomentario.FONTES_RECEITA).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.ESTRUTURA_CUSTO).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.INVESTIMENTO_INICIAL).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.CUSTOS_FIXOS).equals("")) {
            FLAG++;
        }

        if (!retornaTextoComentario(Textocomentario.CUSTOS_VARIAVEISS).equals("")) {
            FLAG++;
        }
        return FLAG;
    }

    /**
     * @return the textocomentarios
     */
    public Set<Textocomentario> getTextocomentarios() {
        return textocomentarios;
    }

    /**
     * @param textocomentarios the textocomentarios to set
     */
    public void setTextocomentarios(Set<Textocomentario> textocomentarios) {
        this.textocomentarios = textocomentarios;
    }

    /**
     * Retorna o texto do comentario segundo seu tipo (segmento de cliente,
     * proposta de valor, etc..)
     *
     * @param tipo
     * @return textoCoentario
     */
    public String retornaTextoComentario(int tipo) {

        String textoComentario = null;

        for (Textocomentario objetoTextoComentario : textocomentarios) {
            if (objetoTextoComentario.getTipo() == tipo) {
                textoComentario = objetoTextoComentario.getTexto();
            }
        }
        return textoComentario;
    }

    /**
     * Retorna o objeto texto comentário
     *
     * @param tipo tipo para se retornar
     * @return objeto encontrado
     */
    public Textocomentario retornarTextoComentario(int tipo) {
        for (Textocomentario objetoTextoComentario : textocomentarios) {
            if (objetoTextoComentario.getTipo() == tipo) {
                return objetoTextoComentario;
            }
        }
        return null;
    }

    /**
     * @return Retorna o valor do comentário relacionado ao segmento de
     * clientes.
     */
    public String retornarSegmentosClientes() {
        return retornaTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao proposta de valor.
     */
    public String retornarPropostaValor() {
        return retornaTextoComentario(Textocomentario.PROPOSTA_VALOR);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao atividades chaves.
     */
    public String retornarAtividadesChave() {
        return retornaTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao relações de
     * clientes.
     */
    public String retornarRelacoesClientes() {
        return retornaTextoComentario(Textocomentario.RELACOES_CLIENTE);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao parcerias chaves.
     */
    public String retornarParceriasChave() {
        return retornaTextoComentario(Textocomentario.PARCERIAS_CHAVE);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao canais.
     */
    public String retornarCanais() {
        return retornaTextoComentario(Textocomentario.CANAIS);
    }

    /**
     * @return Retorna o valor do comentário relacionado a recursos principais.
     */
    public String retornarRecursosPrincipais() {
        return retornaTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS);
    }

    /**
     * @return Retorna o valor do comentário relacionado a concorrentes.
     */
    public String retornarConcorrentes() {
        return retornaTextoComentario(Textocomentario.CONCORRENTES);
    }

    /**
     * @return Retorna o valor do comentário relacionado a estagio de evolução.
     */
    public String retornarEstagioEvolucao() {
        return retornaTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO);
    }

    /**
     * @return Retorna o valor do comentário relacionado a tecnologia e
     * processos.
     */
    public String retornarTecnologiaProcesso() {
        return retornaTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao potencial em
     * inovação e tecnologia..
     */
    public String retornarPotencialInovacaoTecnologia() {
        return retornaTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA);
    }

    /**
     * @return Retorna o valor do comentário relacionado a aplicações.
     */
    public String retornarAplicacoes() {
        return retornaTextoComentario(Textocomentario.APLICACOES);
    }

    /**
     * @return Retorna o valor do comentário relacionado a difilcudades
     * esperadas.
     */
    public String retornarDifilcudadesEsperadas() {
        return retornaTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS);
    }

    /**
     * @return Retorna o valor do comentário relacionado a interacao entre a
     * empresa e universidade.
     */
    public String retornarInteracaoEmpresaUniversidade() {
        return retornaTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE);
    }

    /**
     * @return Retorna o valor do comentário relacionado a interacao entre a
     * empresa, a comunidade e o governo.
     */
    public String retornarInteracaoEmpresaComunidadeGoverno() {
        return retornaTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO);
    }

    /**
     * @return Retorna o valor do comentário relacionado a infraestrutura.
     */
    public String retornarInfraEstrutura() {
        return retornaTextoComentario(Textocomentario.INFRAESTRUTURA);
    }

    /**
     * @return Retorna o valor do comentário relacionado a participacao
     * acionário.
     */
    public String retornarParticipacaoAcionaria() {
        return retornaTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA);
    }

    /**
     * @return Retorna o valor do comentário relacionado o potencial de emprego.
     */
    public String retornarPotencialEmprego() {
        return retornaTextoComentario(Textocomentario.POTENCIAL_EMPREGO);
    }

    /**
     * @return Retorna o valor do comentário relacionado a fontes de receitas.
     */
    public String retornarFontesReceitas() {
        return retornaTextoComentario(Textocomentario.FONTES_RECEITA);
    }

    /**
     * @return Retorna o valor do comentário relacionado a estrutura de custos..
     */
    public String retornarEstruturaCustos() {
        return retornaTextoComentario(Textocomentario.ESTRUTURA_CUSTO);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao investimento
     * inicial.
     */
    public String retornarInvestimentoInicial() {
        return retornaTextoComentario(Textocomentario.INVESTIMENTO_INICIAL);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao custos fixos.
     */
    public String retornarCustosFixos() {
        return retornaTextoComentario(Textocomentario.CUSTOS_FIXOS);
    }

    /**
     * @return Retorna o valor do comentário relacionado ao custos variáveis.
     */
    public String retornarCustosVariaveis() {
        return retornaTextoComentario(Textocomentario.CUSTOS_VARIAVEISS);
    }

    /**
     * Cria um texto de comentário.
     *
     * @param tipo tipo do comentário a ser criado
     * @return comentário criado
     */
    private Textocomentario criaTextoComentario(int tipo) {

        Textocomentario textoComentario = new Textocomentario();
        textoComentario.setTipo(tipo);
        textoComentario.setTexto("");

        return textoComentario;
    }

    /**
     * Faz a inicialização dos campos de comentários.
     */
    private void adicionaListaComentario() {
        textocomentarios.add(criaTextoComentario(Textocomentario.SEGMENTO_CLIENTE));
        textocomentarios.add(criaTextoComentario(Textocomentario.PROPOSTA_VALOR));
        textocomentarios.add(criaTextoComentario(Textocomentario.ATIVIDADES_CHAVE));
        textocomentarios.add(criaTextoComentario(Textocomentario.RELACOES_CLIENTE));
        textocomentarios.add(criaTextoComentario(Textocomentario.PARCERIAS_CHAVE));
        textocomentarios.add(criaTextoComentario(Textocomentario.CANAIS));
        textocomentarios.add(criaTextoComentario(Textocomentario.RECURSOS_PRINCIPAIS));
        textocomentarios.add(criaTextoComentario(Textocomentario.CONCORRENTES));
        textocomentarios.add(criaTextoComentario(Textocomentario.ESTAGIO_EVOLUCAO));
        textocomentarios.add(criaTextoComentario(Textocomentario.TECNOLOGIA_PROCESSOS));
        textocomentarios.add(criaTextoComentario(Textocomentario.POTENCIAL_INOVACAO_TECNOLOGICA));
        textocomentarios.add(criaTextoComentario(Textocomentario.APLICACOES));
        textocomentarios.add(criaTextoComentario(Textocomentario.DIFICULDADES_ESPERADAS));
        textocomentarios.add(criaTextoComentario(Textocomentario.INTERACAO_EMPRESA_UNIVERSIDADE));
        textocomentarios.add(criaTextoComentario(Textocomentario.INTERACAO_EMPRESA_COMUNIDADE_GOVERNO));
        textocomentarios.add(criaTextoComentario(Textocomentario.INFRAESTRUTURA));
        textocomentarios.add(criaTextoComentario(Textocomentario.PARTICIPACAO_ACIONARIA));
        textocomentarios.add(criaTextoComentario(Textocomentario.POTENCIAL_EMPREGO));
        textocomentarios.add(criaTextoComentario(Textocomentario.FONTES_RECEITA));
        textocomentarios.add(criaTextoComentario(Textocomentario.ESTRUTURA_CUSTO));
        textocomentarios.add(criaTextoComentario(Textocomentario.INVESTIMENTO_INICIAL));
        textocomentarios.add(criaTextoComentario(Textocomentario.CUSTOS_FIXOS));
        textocomentarios.add(criaTextoComentario(Textocomentario.CUSTOS_VARIAVEISS));

    }

    /**
     * Procura um texto comentário em uma lista e atualiza ele com o
     * texto comentério fornecido.
     * @param textocomentario 
     */
    public void atualizarTextoComentario(Textocomentario textocomentario) {
        for (Textocomentario textocomentarioLaco : textocomentarios) {
            if (Objects.equals(textocomentario.getTipo(), textocomentarioLaco.getTipo())) {
                textocomentarioLaco.setTexto(textocomentario.getTexto());
                textocomentarioLaco.setDataSubmissao(textocomentario.getDataSubmissao());
                textocomentarioLaco.setDataAlteracao(textocomentario.getDataAlteracao());
                break;
            }
        }
    }

    /**
     * Muda o texto de um TextoComentário dependendo do tipo.
     *
     * @param tipo tipo do comentário
     * @param texto texto para se colocar.
     */
    public void setTextoComentario(int tipo, String texto) {
        for (Textocomentario textocomentario : textocomentarios) {
            if (textocomentario.getTipo() == tipo) {
                textocomentario.setTexto(texto);
            }
        }
    }

    /**
     * Muda o gerente de um TextoComentário dependendo do tipo.
     *
     * @param tipo tipo do comentário
     * @param gerenteRelacionamento gerente para se adicionar
     */
    public void setTextoComentario(int tipo, GerenteRelacionamento gerenteRelacionamento) {
        for (Textocomentario textocomentario : textocomentarios) {
            if (textocomentario.getTipo() == tipo) {
                textocomentario.setGerenteRelacionamento(gerenteRelacionamento);
            }
        }
    }

    /**
     * Muda a data de alteração de um TextoComentário dependendo do tipo.
     *
     * @param tipo tipo do comentário
     * @param dataAlteracao
     */
    public void setTextoComentarioDataAlteracao(int tipo, Date dataAlteracao) {
        for (Textocomentario textocomentario : textocomentarios) {
            if (textocomentario.getTipo() == tipo) {
                textocomentario.setDataAlteracao(dataAlteracao);
            }
        }
    }

    /**
     * Muda a data de alteração de um TextoComentário dependendo do tipo.
     *
     * @param tipo tipo do comentário
     * @param dataSubmissao
     */
    public void setTextoComentarioDataSubmissao(int tipo, Date dataSubmissao) {
        for (Textocomentario textocomentario : textocomentarios) {
            if (textocomentario.getTipo() == tipo) {
                textocomentario.setDataSubmissao(dataSubmissao);
            }
        }
    }
}
