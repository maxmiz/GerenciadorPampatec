/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.Dao;
import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Edison Moura
 */
@ManagedBean(name = "buscaProjetoGerenteDeRelacionamentosBean")
@ViewScoped
public class BuscaProjetoGerenteDeRelacionamentosBean implements Serializable {

    private ArrayList<Projeto> listaProjetos;
    private Projeto projetoSelecionado;
    private ProjetoDao projetoDao;
    private ProjetoBean projetoBean;
    private boolean testeBoolean = false;
    private boolean avaliar = false;

    public BuscaProjetoGerenteDeRelacionamentosBean() {
        projetoDao = new ProjetoDao();
        this.atualizaListaProjetosPreAvaliacao();

    }

    public void setListaProjetos(ArrayList<Projeto> listaProjetos) {
        this.listaProjetos = listaProjetos;
    }

    public ArrayList<Projeto> getListaProjetos() {
        System.out.println("busco planos");
        return listaProjetos;
    }

    public Projeto getProjetoSelecionado() {
        return projetoSelecionado;
    }

    /**
     * Atualiza lista de projeto para projetos que podem ou estão sendo
     * avaliados.
     */
    public void atualizaListaProjetosPreAvaliacao() {
        setAvaliar(true);
        this.setListaProjetos(buscaProjetoPorStatusPreAvaliacao());

    }

    public void atualizaListaProjetosPreAvaliacaoFLAG() {
        if (isAvaliar()) {
            this.setListaProjetos(buscaProjetoPorStatusPreAvaliacao());
        }
    }

    /**
     * Atualiza lista de projeto para projetos que não estão em elaboração
     */
    public void atualizaListaProjetosTodos() {
        setAvaliar(true);
        this.setListaProjetos(buscaProjetoPorStatusTodos());
    }

    /**
     * Atualiza lista de projeto para projetos aprovados.
     */
    public void atualizaListaProjetosAprovados() {
        setAvaliar(false);
        System.out.println("teste entrando atualizar");

        this.setListaProjetos(buscaProjetoPorStatusAprovado());
    }

    /**
     * Atualiza lista de projeto para projetos Reprovados
     */
    public void atualizaListaProjetosReprovados() {
        setAvaliar(false);
        this.setListaProjetos(buscaProjetoPorStatusReprovado());
    }

    /**
     * Atualiza lista de projeto para projetos em melhoria
     */
    public void atualizaListaProjetosnelhoria() {
        setAvaliar(true);
        this.setListaProjetos(buscaProjetoPorStatusMelhoria());
    }

    /**
     *
     * @return Lista de projetos com o status igual à 1 (EM_PRE_AVALIAÇÃO) e 10
     * (SENDO AVALIADO)
     */
    public ArrayList<Projeto> buscaProjetoPorStatusPreAvaliacao() {
        projetoDao = new ProjetoDao();
        ArrayList<Projeto> listaProjetosPorStatus = projetoDao.buscarListaProjetoPorStatus(Projeto.EM_PRE_AVALIACAO);
        ArrayList<Projeto> listaProjetosSendoAvaliado = projetoDao.buscarListaProjetoPorStatus(Projeto.SENDO_AVALIADO);
        for (Projeto projeto : listaProjetosSendoAvaliado) {
            listaProjetosPorStatus.add(projeto);
        }

        return listaProjetosPorStatus;
    }

    /**
     *
     * @return Lista de todos projetos Aprovados
     */
    public ArrayList<Projeto> buscaProjetoPorStatusAprovado() {
        return projetoDao.buscarListaProjetoPorStatus(Projeto.AVALIACAO);
    }

    /**
     *
     * @return Lista de todos projetos Reprovados
     */
    public ArrayList<Projeto> buscaProjetoPorStatusReprovado() {
        return projetoDao.buscarListaProjetoPorStatus(Projeto.REPROVADO);
    }

    /**
     *
     * @return Lista de todos projetos em Melhoria
     */
    public ArrayList<Projeto> buscaProjetoPorStatusMelhoria() {
        return projetoDao.buscarListaProjetoPorStatus(Projeto.PRE_MELHORIA);
    }

    private ArrayList<Projeto> buscaTodosProjetos() {
        projetoDao = new ProjetoDao();
        return projetoDao.buscar();
    }

    /**
     *
     * @return Lista de todos projetos menos os que estão em elaboração
     */
    public ArrayList<Projeto> buscaProjetoPorStatusTodos() {

        ArrayList<Projeto> listaProjetosMenosElaboracao = new ArrayList<>();
        for (Projeto projeto : this.buscaTodosProjetos()) {
            if (projeto.getStatus() != 0) {
                listaProjetosMenosElaboracao.add(projeto);
            }
        }

        return listaProjetosMenosElaboracao;
    }

    /**
     * Atualiza o status do projeto base para SENDO_AVALIADO caso esteja sendo
     * avaliado ou EM_PRE_AVALIACAO caso a avaliação seja interrompida
     *
     * @param projeto
     */
    public void atualizaStatusProjeto(Projeto projeto) {
        if (projeto.getStatus() == Projeto.EM_PRE_AVALIACAO) {
            projeto.setStatus(Projeto.SENDO_AVALIADO);
        }

        projetoDao.salvar(projeto);

        atualizarProjetoSessao();
        listaProjetos = buscaProjetoPorStatusPreAvaliacao();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("buscarPlanoDeNegocio.jsf");
        } catch (IOException ex) {
            Logger.getLogger(ProjetoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Atualiza o projeto que está na sessão.
     */
    public void atualizarProjetoSessao() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        secao.setAttribute("projetoSelecionado", projetoSelecionado);
    }

    /**
     * Atualiza a página que chamar esse método. Para que o método seja chamado
     * repetidas vezes, quando uma atualização da página de forma periódica for
     * necessária, basta chama-lo no listener de um componente p:poll. Fica a
     * sugestão.
     */
    public void refresh() {
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        context.renderResponse();
    }

    public boolean isAvaliar() {
        return avaliar;
    }

    public void setAvaliar(boolean avaliar) {
        this.avaliar = avaliar;
    }

    /**
     * @return the testeBoolean
     */
    public boolean isTesteBoolean() {
        return testeBoolean;
    }

    /**
     * @param testeBoolean the testeBoolean to set
     */
    public void setTesteBoolean(boolean testeBoolean) {
        this.testeBoolean = testeBoolean;
    }

    public boolean verificaStatusProjeto(Projeto projeto) {
        return projeto.getStatus() == Projeto.SENDO_AVALIADO;
    }

    public void atualizaListaDeProjetos() {
        listaProjetos = buscaProjetoPorStatusPreAvaliacao();
    }

    /**
     * <p>
     * Método que muda o status do projeto, atualizar essa informação no banco e
     * chama o método para redirecionar para a página de pré-avalização do
     * pré-projeto selecionado.</p>
     *
     * @param projSelec
     */
    public void enviarPreAvaliacaoPreProjeto(Projeto projSelec) {
        /**
         * Gambiarra para resolver o problema do Ajax+Filtro.
         */
        if (projSelec != null) {
            ProjetoDao dao = new ProjetoDao();
            /**
             * Nesse if de baixo ele garante que 2 gerentes não poderão avaliar
             * o mesmo plano ao mesmo tempo.PS: Somente se eles clicarem para
             * avaliar no mesmo tempo, bemm no mesmo tempo, tipo juntos, se
             * tiver diferença de meio segundo já não cai no if de baixo.
             *
             */
            if (dao.buscar(projSelec.getIdProjeto()).getStatus() != Projeto.SENDO_AVALIADO) {
                projSelec.setStatus(Projeto.SENDO_AVALIADO);
                dao.update(projSelec);
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("projetoSelecionado", projSelec);
                getPreAvaliarProjeto();
            }

        }
    }

    /**
     * Redireciona para a página de Pre-Avaliação do Pré-Projeto.
     */
    private void getPreAvaliarProjeto() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("preAvaliarPlanoDeNegocio.jsf");
        } catch (Exception e) {
            Logger.getLogger(PreAvaliarPlanoBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
