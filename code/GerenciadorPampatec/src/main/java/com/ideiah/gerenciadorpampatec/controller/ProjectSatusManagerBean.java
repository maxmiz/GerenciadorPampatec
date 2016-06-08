/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * Classe para gerenciar o status do projeto em todo o sistema. Migrar para essa
 * classe os tratamentos de status do projeto.</p>
 *
 * @author Ideiah PC
 * @since 07-06-2016
 */
public class ProjectSatusManagerBean {

    public ProjectSatusManagerBean() {
    }

    /**
     * <p>
     * Muda o status do projeto para em pré-avaliação antes da sessão do gerente
     * ser finalizada. Caso o usuário logado seja um Empreendedor, a sessão é
     * encerrada sem alterar os dados dos projetos.
     * </p>
     */
    public synchronized void tratamentoSessaoSendoAvaliado() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
            GerenteRelacionamento gerente = (GerenteRelacionamento) session.getAttribute("gerente");
            Projeto projeto = (Projeto) session.getAttribute("projetoSelecionado");

            if (gerente != null && projeto != null
                    && projeto.getStatus() == Projeto.SENDO_AVALIADO) {

                projeto.setStatus(Projeto.EM_PRE_AVALIACAO);
                session.removeAttribute("projetoSelecionado");
            }
            /**
             * É executado de qualquer forma, independente se é um gerente ou
             * empreendedor.
             */
            session.invalidate();
        } catch (Exception e) {
            Logger.getLogger(ProjectSatusManagerBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
