/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * Classe para gerenciar o status do projeto em todo o sistema.</p>
 *
 * @author unipampa
 */
public class ProjectSatusManagerBean {

    public ProjectSatusManagerBean() {
    }

    /**
     * <p>
     * Muda o status do projeto para em pré-avaliação quando a sessão do gerente
     * é finalizada.
     * </p>
     */
    public void tratamentoSessaoSendoAvaliado() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        GerenteRelacionamento gerente = (GerenteRelacionamento) session.getAttribute("gerente");
        Projeto projeto = (Projeto) session.getAttribute("projetoSelecionado");

        if (gerente != null && projeto != null && projeto.getStatus() == Projeto.SENDO_AVALIADO) {
            projeto.setStatus(Projeto.EM_PRE_AVALIACAO);
            session.removeAttribute("projetoSelecionado");
        }
    }
}
