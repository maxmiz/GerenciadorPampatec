/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
public class SessionExcepitionHandler extends ExceptionHandlerWrapper {

    private ExceptionHandler wrapped;
    private static final Logger log = Logger.getLogger(SessionExcepitionHandler.class.getCanonicalName());

    public SessionExcepitionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

    @Override
    public void handle() {
        //Iterate over all unhandeled exceptions
        Iterator i = getUnhandledExceptionQueuedEvents().iterator();
        while (i.hasNext()) {
            ExceptionQueuedEvent event = (ExceptionQueuedEvent) i.next();
            ExceptionQueuedEventContext context
                    = (ExceptionQueuedEventContext) event.getSource();

            //obtain throwable object
            Throwable t = context.getException();
            Throwable tCausa = retornaCausa(t);

            //here you do what ever you want with exception
            try {
                //log error
                //log.log(Level.SEVERE, "Critical Exception!", t);

                mudaStatusProjeto();
                lidaExcepition(tCausa.getClass().toString());
            } finally {
                //after exception is handeled, remove it from queue
                i.remove();
            }
        }
        //let the parent handle the rest
        getWrapped().handle();
    }

    /**
     * Redireciona o usuário para uma tela dependendo da excepition que ele
     * recebe.
     *
     * @param nomeExecption
     */
    private void lidaExcepition(String nomeExecption) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String errorPageLocation = null;
        if (nomeExecption.equals("javax.faces.application.ViewExpiredException")) {
            errorPageLocation = "/WEB-INF/errorpages/expired.xhtml";
            redirecionaPagina(facesContext, errorPageLocation);
        } else if (nomeExecption.equals("com.sun.faces.mgbean.ManagedBeanCreationException")) {
            errorPageLocation = "/WEB-INF/errorpages/expired.xhtml";
            redirecionaPagina(facesContext, errorPageLocation);
        } else {
            try {
                facesContext.getExternalContext().redirect("loginEmpreendedor.jsf");
            } catch (IOException ex) {
                Logger.getLogger(SessionExcepitionHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Redireciona para a página especificada.
     * @param errorPageLocation 
     */
    private void redirecionaPagina(FacesContext facesContext, String errorPageLocation) {
        facesContext.setViewRoot(facesContext.getApplication().getViewHandler().createView(facesContext, errorPageLocation));
        facesContext.getPartialViewContext().setRenderAll(true);
        facesContext.renderResponse();
    }

    /**
     * Muda o status do projeto para em pré-avaliação quando o gerente recebe
     * uma excepition na página de pré-avaliar.
     */
    private void mudaStatusProjeto() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        GerenteDeRelacionamentosBean gerente = (GerenteDeRelacionamentosBean) session.getAttribute("gerente");
        Projeto projeto = (Projeto) session.getAttribute("projetoSelecionado");

        if (gerente != null && projeto != null && projeto.getStatus() == Projeto.SENDO_AVALIADO) {
            projeto.setStatus(Projeto.EM_PRE_AVALIACAO);
            session.removeAttribute("projetoSelecionado");
        }
    }

    /**
     * Procura a causa de uma exeção jogada.
     *
     * @param t
     * @return
     */
    public Throwable retornaCausa(Throwable t) {
        Throwable tCausa = t.getCause();
        if (tCausa == null) {
            return t;
        } else {
            return retornaCausa(tCausa);
        }
    }
}
