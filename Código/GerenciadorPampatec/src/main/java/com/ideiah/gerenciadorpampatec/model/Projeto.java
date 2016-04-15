package com.ideiah.gerenciadorpampatec.model;
// Generated 31/08/2015 13:49:28 by Hibernate Tools 4.3.1

import com.ideiah.gerenciadorpampatec.controller.NotificacoesEmpreendedorBean;
import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import javax.faces.context.FacesContext;

/**
 * Projeto generated by hbm2java
 */
public class Projeto implements java.io.Serializable {

    public static final int ELABORACAO = 0;
    public static final int SUBMETIDO = 1;
    public static final int RESUBMETIDO = 11;
    public static final int SENDO_AVALIADO = 10;
    public static final int ACEITO_PARA_AVALIACAO = 2;
    public static final int FORMALIZACAO = 3;
    public static final int INCUBACAO = 4;
    public static final int REPROVADO = 6;
    public static final int NECESSITA_MELHORIA = 7;
    public static final int DEFININDO_EQUIPE = 8;
    public static final int EM_PRE_AVALIACAO = 12;

    private Integer idProjeto;
    private Analiseemprego analiseemprego;
    private Negocio negocio;
    private Planofinanceiro planofinanceiro;
    private Produtoouservico produtoouservico;
    private String nome;
    private Date dataEnvio;
    private Integer status;
    private String potencialEmprego;
    private Set empreendedores = new HashSet(0);
    private String participacaoacionaria;
    private String edital;
    private Date dataCriacao;
    private GerenteRelacionamento gerenteRelacionamento;
    private NotificacoesEmpreendedorBean notificacoesBean;
    private Empreendedor empreendedorCorrespondente;
   //Contador de acesso serve como gambiarra para verificar se o projeto está
    //aberto para outro gerente no atualizar a página
    private int contAcesso;
    private Set<ComentarioProjeto> comentarioProjeto = new HashSet(0);
    private Integer statusTemp;

    public Projeto() {
        //pegaObserver();
        contAcesso = 0;
        /**
         * O 99 é um status inexistente para definir a variável com um status
         * inexistente como padrão inicial.
         */
        statusTemp = 99;
    }

    public Projeto(Integer idProjeto, Analiseemprego analiseemprego, Negocio negocio, Planofinanceiro planofinanceiro, Produtoouservico produtoouservico, String participacaoacionaria) {
        this.idProjeto = idProjeto;
        this.analiseemprego = analiseemprego;
        this.negocio = negocio;
        this.planofinanceiro = planofinanceiro;
        this.produtoouservico = produtoouservico;
        this.participacaoacionaria = participacaoacionaria;
        contAcesso = 0;
        pegaObserver();
        statusTemp = 99;
    }

    public Projeto(Integer idProjeto, Analiseemprego analiseemprego, Negocio negocio, Planofinanceiro planofinanceiro, Produtoouservico produtoouservico, String nome, Date dataEnvio, Integer status, String potencialEmprego, Set empreendedors, String participacaoacionaria, String edital,
            Date dataCriacao, GerenteRelacionamento gerenteDeRelacionamento) {
        this.idProjeto = idProjeto;
        this.analiseemprego = analiseemprego;
        this.negocio = negocio;
        this.planofinanceiro = planofinanceiro;
        this.produtoouservico = produtoouservico;
        this.nome = nome;
        this.dataEnvio = dataEnvio;
        this.status = status;
        this.potencialEmprego = potencialEmprego;
        this.empreendedores = empreendedors;
        this.participacaoacionaria = participacaoacionaria;
        this.edital = edital;
        this.dataCriacao = dataCriacao;
        this.gerenteRelacionamento = gerenteDeRelacionamento;
        pegaObserver();
        contAcesso = 0;
        statusTemp = 99;
    }

    private void pegaObserver() {
        FacesContext context = FacesContext.getCurrentInstance();
        NotificacoesEmpreendedorBean bean = context.getApplication().evaluateExpressionGet(context, "#{notificacoesEmpreendedorBean}", NotificacoesEmpreendedorBean.class);
        notificacoesBean = bean;
    }

    public boolean SalvarProjeto(Projeto projeto) {
        ProjetoDao projetoDao = new ProjetoDao();
        try {
            projetoDao.update(projeto);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
        public String formatarDataEnvio() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        if (getDataEnvio() != null) {
            return formato.format(getDataEnvio());
        } else {
            return "Plano não enviado.";
        }
    }

    public Integer getIdProjeto() {
        return this.idProjeto;
    }

    public void setIdProjeto(Integer idProjeto) {
        this.idProjeto = idProjeto;
    }

    public Analiseemprego getAnaliseemprego() {
        return this.analiseemprego;
    }

    public void setAnaliseemprego(Analiseemprego analiseemprego) {
        this.analiseemprego = analiseemprego;
    }

    public Negocio getNegocio() {
        return this.negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    public Planofinanceiro getPlanofinanceiro() {
        return this.planofinanceiro;
    }

    public void setPlanofinanceiro(Planofinanceiro planofinanceiro) {
        this.planofinanceiro = planofinanceiro;
    }

    public Produtoouservico getProdutoouservico() {
        return this.produtoouservico;
    }

    public void setProdutoouservico(Produtoouservico produtoouservico) {
        this.produtoouservico = produtoouservico;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataEnvio() {
        return this.dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getStatusString(int status) {
        String statusDescricao = "";

        switch (status) {
            case ELABORACAO:
                statusDescricao = "Em elaboração";
                break;
            case SENDO_AVALIADO:
                statusDescricao = "Sendo Avaliado";
                break;
            case SUBMETIDO:
                statusDescricao = "Submetido";
                break;
            case ACEITO_PARA_AVALIACAO:
                statusDescricao = "Aceito para Avaliação";
                break;
            case NECESSITA_MELHORIA:
                statusDescricao = "Necessita Melhoria";
                break;
            case FORMALIZACAO:
                statusDescricao = "Em Formalização";
                break;
            case INCUBACAO:
                statusDescricao = "Incubação";
                break;
            case REPROVADO:
                statusDescricao = "Reprovado";
                break;
            case EM_PRE_AVALIACAO:
                statusDescricao = "Em Pré-Avaliação";
                break;
            case RESUBMETIDO:
                statusDescricao = "Ressubmetido";
        }

        return statusDescricao;

    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Muda o status do Projeto ativando os observadores.
     *
     * @param status
     */
    public void mudarStatus(Integer status) {
        setStatus(status);
        //notificacoesBean.update(null, this);
    }

    public String getPotencialEmprego() {
        return this.potencialEmprego;
    }

    public void setPotencialEmprego(String potencialEmprego) {
        this.potencialEmprego = potencialEmprego;
    }

    public Set getEmpreendedores() {
        return this.empreendedores;
    }

    public void setEmpreendedores(Set empreendedors) {
        this.empreendedores = empreendedors;
    }

    /**
     * @return the participacaoacionaria
     */
    public String getParticipacaoacionaria() {
        return participacaoacionaria;
    }

    /**
     * @param participacaoacionaria the participacaoacionaria to set
     */
    public void setParticipacaoacionaria(String participacaoacionaria) {
        this.participacaoacionaria = participacaoacionaria;
    }

    /**
     * @return the edital
     */
    public String getEdital() {
        return edital;
    }

    /**
     * @param edital the edital to set
     */
    public void setEdital(String edital) {
        this.edital = edital;
    }

    /**
     * @return the dataCriacao
     */
    public Date getDataCriacao() {
        return dataCriacao;
    }

    /**
     * @param dataCriacao the dataCriacao to set
     */
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    /**
     * @return the gerenteRelacionamento
     */
    public GerenteRelacionamento getGerenteRelacionamento() {
        return gerenteRelacionamento;
    }

    /**
     * @param gerenteRelacionamento the gerenteRelacionamento to set
     */
    public void setGerenteRelacionamento(GerenteRelacionamento gerenteRelacionamento) {
        this.gerenteRelacionamento = gerenteRelacionamento;
    }

    /**
     *
     * @param status
     * @return lista de projeto com o status inserido
     */
    public static ArrayList<Projeto> buscarProjetoPorStatus(int status) {
        ArrayList<Projeto> listaDeProjetos;
        ProjetoDao projetoDao = new ProjetoDao();
        listaDeProjetos = projetoDao.buscar();

        ArrayList<Projeto> projetosGerente = new ArrayList<>();

        for (Projeto projeto : listaDeProjetos) {
            if (projeto.status == status) {
                projetosGerente.add(projeto);
            }
        }

        return projetosGerente;

    }
    
    public ArrayList<Empreendedor> retornaListaEmpreendedores(){
        ArrayList<Empreendedor> listaEmpreendedores =  new ArrayList<>();
        for (Object objeto : empreendedores) {
            Empreendedor empreendedor = (Empreendedor) objeto;
            listaEmpreendedores.add(empreendedor);
        }
        return listaEmpreendedores;
    }

    /**
     * @return the empreendedorCorrespondente
     */
    public Empreendedor getEmpreendedorCorrespondente() {
        return empreendedorCorrespondente;
    }

    /**
     * @param empreendedorCorrespondente the empreendedorCorrespondente to set
     */
    public void setEmpreendedorCorrespondente(Empreendedor empreendedorCorrespondente) {
        this.empreendedorCorrespondente = empreendedorCorrespondente;
    }

    
    /**
     * Verifica se o projeto está em pré-avaliação
     * @return 
     */
    public boolean verificaSubmetido(){
        return this.getStatus() != Projeto.SUBMETIDO;
    }
    public boolean verificaReSubmetido(){
        return this.getStatus() != Projeto.RESUBMETIDO;
    }
    
        /**
     * Verifica se o projeto está em sendo avaliado
     * @return 
     */
    
    public boolean verificarSendoAvaliado(){
        return this.getStatus() != Projeto.SENDO_AVALIADO;
    }
        /**
     * Verifica se o projeto está em pré-melhoria
     * @return 
     */
        public boolean verificarNecessitaAvaliacao(){
        return this.getStatus() != Projeto.NECESSITA_MELHORIA;
    }
            /**
     * Verifica se o projeto está em avaliação
     * @return 
     */
    public boolean verificarAceitoParaAvaliacao(){
        return this.getStatus() != Projeto.ACEITO_PARA_AVALIACAO;
    }
    
        /**
     * Verifica se o projeto foi reprovado
     * @return 
     */
    public boolean verificarReprovado(){
        return this.getStatus() != Projeto.REPROVADO;
    }
    
    /**
     * @return the comentarioProjeto
     */
    public Set<ComentarioProjeto> getComentarioProjeto() {
        return comentarioProjeto;
    }

    /**
     * @param comentarioProjeto the comentarioProjeto to set
     */
    public void setComentarioProjeto(Set<ComentarioProjeto> comentarioProjeto) {
        this.comentarioProjeto = comentarioProjeto;
    }

    /**
     * @return the contAcesso
     */
    public int getContAcesso() {
        return contAcesso;
    }

    /**
     * @param contAcesso the contAcesso to set
     */
    public void setContAcesso(int contAcesso) {
        this.contAcesso = contAcesso;
    }

    /**
     * @return the statusTemp
     */
    public Integer getStatusTemp() {
        return statusTemp;
    }

    /**
     * @param statusTemp the statusTemp to set
     */
    public void setStatusTemp(Integer statusTemp) {
        this.statusTemp = statusTemp;
    }

}
