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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
        if (projetoBase.getStatus() == ProjetoBase.SENDO_AVALIADO) {
            projetoBase.setStatus(ProjetoBase.PENDENTE);
        } else {
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

}
