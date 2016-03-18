/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ComentarioDao;
import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.ComentarioProjeto;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author GUTO
 */
@ManagedBean
@ViewScoped
public class PreAvaliarPlanoBean implements Serializable {

    private Projeto projeto;
    private ComentarioProjeto comentarioProjeto;
//    private String comentSegClientes;
//    private String comentPropValor;
//    private String comentAtivChaves;
//    private String comentRelClientes;
//    private String comentParcChaves;
//    private String comentCanais;
//    private String comentRecPrincipais;
//    private String comentConcorrentes;
//    private String comentEstEvolucao;
//    private String comentTecProcessos;
//    private String comentPotInovacao;
//    private String comentAplicacoes;
//    private String comentDifEsperadas;
//    private String comentIntEmpUniversidade;
//    private String comentIntEmpEmpComGov;
//    private String comentInfEstrutura;
//    private String comentDescParticipacao;
//    private String comentPotGerEmpRenda;
//    private String comentFontReceitas;
//    private String comentEstCustos;
//    private String comentInvInicial;
//    private String comentCustFixos;
//    private String comentCustVariaveis;
//    private String comentObservacoes;

    public PreAvaliarPlanoBean() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projeto = (Projeto) session.getAttribute("projetoSelecionado");
        buscarComentarioProjeto();
        if (comentarioProjeto == null) {
            comentarioProjeto = new ComentarioProjeto();
        }
    }

    public void buscarComentarioProjeto() {
        ComentarioDao comentDao = new ComentarioDao();

        comentarioProjeto = comentDao.buscarPorStatus(ComentarioProjeto.EM_ANDAMENTO);
    }

    /**
     * Método para chamar a página de pré-avalização do pré-projeto selecionado.
     * ATENÇÃO: As validações do projeto selecionado em avaliação foram
     * comentadas para simplificar o debug das demais funções relacionadas. Para
     * entrar o projeto, é necessário descomentar tais validçaões.
     *
     * @param projSelec
     */
    public void enviarPreAvaliacaoPreProjeto(Projeto projSelec) {
        /**
         * Gambiarra para resolver o problema do Ajax+Filtro.
         */
        if (projSelec != null) {
            projSelec.setStatus(Projeto.SENDO_AVALIADO);
            ProjetoDao dao = new ProjetoDao();
            dao.update(projSelec);

            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("projetoSelecionado", projSelec);

            getPreAvaliarProjeto();
        }
    }

    /**
     * Redireciona para a página de Pre-Avaliação do Pré-Projeto.
     */
    private void getPreAvaliarProjeto() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("preAvaliarPlanoDeNegocio.xhtml");
        } catch (Exception e) {
            Logger.getLogger(PreAvaliarPlanoBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Método para verificar qual o tipo de estégio a empressa sem encontra
     *
     * @return
     */
    public String verificaEstagioEvolucao() {
        String status = projeto.getProdutoouservico().verificaStatusProjeto(projeto.getProdutoouservico().getEstagioEvolucao());
        if (status.equals("Outro:")) {
            return projeto.getProdutoouservico().getEstagioEvolucao();
        } else {
            return status;
        }
    }

    /**
     * salva a preavaliao do projeto realizada pelo Gerente de Relacionamentos
     * para posterior continuar editando o mesmo
     */
    public void salvar() {

        ComentarioDao comentDao = new ComentarioDao();
        comentarioProjeto.setProjeto(projeto);
        comentDao.salvar(comentarioProjeto);

        /**
         * Para exibir a mensagem de salvo com sucesso.
         */
        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Sua alteração foi salva com sucesso.");
        FacesContext.getCurrentInstance().addMessage("formulario_cadastro_projeto:tituloMensagem", msg);

//        System.out.println("projeto = " + projeto);
//        System.out.println("segclientes = " + comentSegClientes);
//        System.out.println("comentPropValor = " + comentPropValor);
//        System.out.println("comentAtivChaves = " + comentAtivChaves);
//        System.out.println("comentRelClientes = " + comentRelClientes);
//        System.out.println("comentParcChaves = " + comentParcChaves);
//        System.out.println("comentCanais = " + comentCanais);
//        System.out.println("comentRecPrincipais = " + comentRecPrincipais);
//        System.out.println("comentConcorrentes = " + comentConcorrentes);
//        System.out.println("comentEstEvolucao = " + comentEstEvolucao);
//        System.out.println("comentTecProcessos = " + comentTecProcessos);
//        System.out.println("comentPotInovacao = " + comentPotInovacao);
//        System.out.println("comentAplicacoes = " + comentAplicacoes);
//        System.out.println("comentDifEsperadas = " + comentDifEsperadas);
//        System.out.println("comentIntEmpUniversidade = " + comentIntEmpUniversidade);
//        System.out.println("comentIntEmpEmpComGov = " + comentIntEmpEmpComGov);
//        System.out.println("comentInfEstrutura = " + comentInfEstrutura);
//        System.out.println("comentDescParticipacao = " + comentDescParticipacao);
//        System.out.println("comentPotGerEmpRenda = " + comentPotGerEmpRenda);
//        System.out.println("comentFontReceitas = " + comentFontReceitas);
//        System.out.println("comentEstCustos = " + comentEstCustos);
//        System.out.println("comentInvInicial = " + comentInvInicial);
//        System.out.println("comentCustFixos = " + comentCustFixos);
//        System.out.println("comentCustVariaveis = " + comentCustVariaveis);
//        System.out.println("comentObservacoes = " + comentObservacoes);
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

    public ComentarioProjeto getComentarioProjeto() {
        return comentarioProjeto;
    }

    public void setComentarioProjeto(ComentarioProjeto comentarioProjeto) {
        this.comentarioProjeto = comentarioProjeto;
    }

    /**
     *  
     * @param projSelect  
     */
    public void mudaStatusProjetoSendoAvaliado(Projeto projSelect) {

       if(projSelect.getStatus() == Projeto.EM_PRE_AVALIACAO){
           projSelect.setStatus(Projeto.SENDO_AVALIADO);
       }
    }
    public void mudaStatusProjetoEmPreAvaliacao(Projeto projSelect) {

       if(projSelect.getStatus() == Projeto.SENDO_AVALIADO){
           projSelect.setStatus(Projeto.EM_PRE_AVALIACAO);
       }
    }

    /**
     * @return the comentSegClientes
     */
//    public String getComentSegClientes() {
//        return comentSegClientes;
//    }
//
//    /**
//     * @param comentSegClientes the comentSegClientes to set
//     */
//    public void setComentSegClientes(String comentSegClientes) {
//        this.comentSegClientes = comentSegClientes;
//    }
//
//    /**
//     * @return the comentPropValor
//     */
//    public String getComentPropValor() {
//        return comentPropValor;
//    }
//
//    /**
//     * @param comentPropValor the comentPropValor to set
//     */
//    public void setComentPropValor(String comentPropValor) {
//        this.comentPropValor = comentPropValor;
//    }
//
//    /**
//     * @return the comentAtivChaves
//     */
//    public String getComentAtivChaves() {
//        return comentAtivChaves;
//    }
//
//    /**
//     * @param comentAtivChaves the comentAtivChaves to set
//     */
//    public void setComentAtivChaves(String comentAtivChaves) {
//        this.comentAtivChaves = comentAtivChaves;
//    }
//
//    /**
//     * @return the comentRelClientes
//     */
//    public String getComentRelClientes() {
//        return comentRelClientes;
//    }
//
//    /**
//     * @param comentRelClientes the comentRelClientes to set
//     */
//    public void setComentRelClientes(String comentRelClientes) {
//        this.comentRelClientes = comentRelClientes;
//    }
//
//    /**
//     * @return the comentParcChaves
//     */
//    public String getComentParcChaves() {
//        return comentParcChaves;
//    }
//
//    /**
//     * @param comentParcChaves the comentParcChaves to set
//     */
//    public void setComentParcChaves(String comentParcChaves) {
//        this.comentParcChaves = comentParcChaves;
//    }
//
//    /**
//     * @return the comentCanais
//     */
//    public String getComentCanais() {
//        return comentCanais;
//    }
//
//    /**
//     * @param comentCanais the comentCanais to set
//     */
//    public void setComentCanais(String comentCanais) {
//        this.comentCanais = comentCanais;
//    }
//
//    /**
//     * @return the comentRecPrincipais
//     */
//    public String getComentRecPrincipais() {
//        return comentRecPrincipais;
//    }
//
//    /**
//     * @param comentRecPrincipais the comentRecPrincipais to set
//     */
//    public void setComentRecPrincipais(String comentRecPrincipais) {
//        this.comentRecPrincipais = comentRecPrincipais;
//    }
//
//    /**
//     * @return the comentConcorrentes
//     */
//    public String getComentConcorrentes() {
//        return comentConcorrentes;
//    }
//
//    /**
//     * @param comentConcorrentes the comentConcorrentes to set
//     */
//    public void setComentConcorrentes(String comentConcorrentes) {
//        this.comentConcorrentes = comentConcorrentes;
//    }
//
//    /**
//     * @return the comentEstEvolucao
//     */
//    public String getComentEstEvolucao() {
//        return comentEstEvolucao;
//    }
//
//    /**
//     * @param comentEstEvolucao the comentEstEvolucao to set
//     */
//    public void setComentEstEvolucao(String comentEstEvolucao) {
//        this.comentEstEvolucao = comentEstEvolucao;
//    }
//
//    /**
//     * @return the comentTecProcessos
//     */
//    public String getComentTecProcessos() {
//        return comentTecProcessos;
//    }
//
//    /**
//     * @param comentTecProcessos the comentTecProcessos to set
//     */
//    public void setComentTecProcessos(String comentTecProcessos) {
//        this.comentTecProcessos = comentTecProcessos;
//    }
//
//    /**
//     * @return the comentPotInovacao
//     */
//    public String getComentPotInovacao() {
//        return comentPotInovacao;
//    }
//
//    /**
//     * @param comentPotInovacao the comentPotInovacao to set
//     */
//    public void setComentPotInovacao(String comentPotInovacao) {
//        this.comentPotInovacao = comentPotInovacao;
//    }
//
//    /**
//     * @return the comentAplicacoes
//     */
//    public String getComentAplicacoes() {
//        return comentAplicacoes;
//    }
//
//    /**
//     * @param comentAplicacoes the comentAplicacoes to set
//     */
//    public void setComentAplicacoes(String comentAplicacoes) {
//        this.comentAplicacoes = comentAplicacoes;
//    }
//
//    /**
//     * @return the comentDifEsperadas
//     */
//    public String getComentDifEsperadas() {
//        return comentDifEsperadas;
//    }
//
//    /**
//     * @param comentDifEsperadas the comentDifEsperadas to set
//     */
//    public void setComentDifEsperadas(String comentDifEsperadas) {
//        this.comentDifEsperadas = comentDifEsperadas;
//    }
//
//    /**
//     * @return the comentIntEmpUniversidade
//     */
//    public String getComentIntEmpUniversidade() {
//        return comentIntEmpUniversidade;
//    }
//
//    /**
//     * @param comentIntEmpUniversidade the comentIntEmpUniversidade to set
//     */
//    public void setComentIntEmpUniversidade(String comentIntEmpUniversidade) {
//        this.comentIntEmpUniversidade = comentIntEmpUniversidade;
//    }
//
//    /**
//     * @return the comentIntEmpEmpComGov
//     */
//    public String getComentIntEmpEmpComGov() {
//        return comentIntEmpEmpComGov;
//    }
//
//    /**
//     * @param comentIntEmpEmpComGov the comentIntEmpEmpComGov to set
//     */
//    public void setComentIntEmpEmpComGov(String comentIntEmpEmpComGov) {
//        this.comentIntEmpEmpComGov = comentIntEmpEmpComGov;
//    }
//
//    /**
//     * @return the comentInfEstrutura
//     */
//    public String getComentInfEstrutura() {
//        return comentInfEstrutura;
//    }
//
//    /**
//     * @param comentInfEstrutura the comentInfEstrutura to set
//     */
//    public void setComentInfEstrutura(String comentInfEstrutura) {
//        this.comentInfEstrutura = comentInfEstrutura;
//    }
//
//    /**
//     * @return the comentDescParticipacao
//     */
//    public String getComentDescParticipacao() {
//        return comentDescParticipacao;
//    }
//
//    /**
//     * @param comentDescParticipacao the comentDescParticipacao to set
//     */
//    public void setComentDescParticipacao(String comentDescParticipacao) {
//        this.comentDescParticipacao = comentDescParticipacao;
//    }
//
//    /**
//     * @return the comentPotGerEmpRenda
//     */
//    public String getComentPotGerEmpRenda() {
//        return comentPotGerEmpRenda;
//    }
//
//    /**
//     * @param comentPotGerEmpRenda the comentPotGerEmpRenda to set
//     */
//    public void setComentPotGerEmpRenda(String comentPotGerEmpRenda) {
//        this.comentPotGerEmpRenda = comentPotGerEmpRenda;
//    }
//
//    /**
//     * @return the comentFontReceitas
//     */
//    public String getComentFontReceitas() {
//        return comentFontReceitas;
//    }
//
//    /**
//     * @param comentFontReceitas the comentFontReceitas to set
//     */
//    public void setComentFontReceitas(String comentFontReceitas) {
//        this.comentFontReceitas = comentFontReceitas;
//    }
//
//    /**
//     * @return the comentEstCustos
//     */
//    public String getComentEstCustos() {
//        return comentEstCustos;
//    }
//
//    /**
//     * @param comentEstCustos the comentEstCustos to set
//     */
//    public void setComentEstCustos(String comentEstCustos) {
//        this.comentEstCustos = comentEstCustos;
//    }
//
//    /**
//     * @return the comentInvInicial
//     */
//    public String getComentInvInicial() {
//        return comentInvInicial;
//    }
//
//    /**
//     * @param comentInvInicial the comentInvInicial to set
//     */
//    public void setComentInvInicial(String comentInvInicial) {
//        this.comentInvInicial = comentInvInicial;
//    }
//
//    /**
//     * @return the comentCustFixos
//     */
//    public String getComentCustFixos() {
//        return comentCustFixos;
//    }
//
//    /**
//     * @param comentCustFixos the comentCustFixos to set
//     */
//    public void setComentCustFixos(String comentCustFixos) {
//        this.comentCustFixos = comentCustFixos;
//    }
//
//    /**
//     * @return the comentCustVariaveis
//     */
//    public String getComentCustVariaveis() {
//        return comentCustVariaveis;
//    }
//
//    /**
//     * @param comentCustVariaveis the comentCustVariaveis to set
//     */
//    public void setComentCustVariaveis(String comentCustVariaveis) {
//        this.comentCustVariaveis = comentCustVariaveis;
//    }
//
//    /**
//     * @return the comentObservacoes
//     */
//    public String getComentObservacoes() {
//        return comentObservacoes;
//    }
//
//    /**
//     * @param comentObservacoes the comentObservacoes to set
//     */
//    public void setComentObservacoes(String comentObservacoes) {
//        this.comentObservacoes = comentObservacoes;
//    }
}
