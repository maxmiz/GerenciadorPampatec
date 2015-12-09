/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ProjetoBaseDao;
import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import com.ideiah.gerenciadorpampatec.model.ProjetoBase;
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

    private ArrayList<ProjetoBase> listaProjetos;
    private Projeto projetoSelecionado;
    private ProjetoDao projeto;
    private ProjetoBean projetoBean;
    private ProjetoBaseDao projetoBaseDao;
    private boolean testeBoolean = false;

    public BuscaProjetoGerenteDeRelacionamentosBean() {
        projeto = new ProjetoDao();
        listaProjetos = buscaProjetoBasePorStatus();
        projetoBaseDao = new ProjetoBaseDao();
    }

    public void setListaProjetos(ArrayList<ProjetoBase> listaProjetos) {
        this.listaProjetos = listaProjetos;
    }

    public ArrayList<ProjetoBase> getListaProjetos() {
        return listaProjetos;
    }

    public Projeto getProjetoSelecionado() {
        return projetoSelecionado;
    }

    /**
     *
     * @return Lista de projetos com o status igual à 1 (EM_PRE_AVALIAÇÃO)
     */
    public ArrayList<ProjetoBase> buscaProjetoBasePorStatus() {
        ProjetoBaseDao dao = new ProjetoBaseDao();
        return dao.buscar();

    }

    /**
     * Atualiza o status do projeto base para SENDO_AVALIADO caso não esteja
     * sendo avaliado ou PENDENTE caso a avaliação seja interrompida
     *
     * @param projetoBase
     */
    public void atualizaStatusProjetoBase(ProjetoBase projetoBase) {
        if (projetoBase.getStatus() == ProjetoBase.PENDENTE) {
            projetoBase.setStatus(ProjetoBase.SENDO_AVALIADO);
        }

        projetoBaseDao.salvar(projetoBase);

        atualizarProjetoSessao();
        listaProjetos = buscaProjetoBasePorStatus();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("buscarPlanoDeNegocio.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ProjetoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Atualiza o projeto que está na sessão.
     */
    public void atualizarProjetoSessao() {
        HttpSession secao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        secao.setAttribute("projetoSelecionado", projeto);
    }

    public void locao() {
        System.out.println("PASSOU AQUI O POLLLLLLLLLLLLLLL FUNCIONOU");
        refresh();
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


    public boolean verificaStatusProjetoBase(ProjetoBase projetoBase) {
        if (projetoBase.getStatus() == ProjetoBase.SENDO_AVALIADO) {
            return true;
        } else {
            return false;
        }
    }

    public void atualizaListaDeProjetos() {
        listaProjetos = buscaProjetoBasePorStatus();
    }

}
