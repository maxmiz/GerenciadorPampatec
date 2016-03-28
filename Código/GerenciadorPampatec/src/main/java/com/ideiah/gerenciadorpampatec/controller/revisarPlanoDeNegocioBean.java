/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.ComentarioProjeto;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ideiah Computer
 */
@ManagedBean
@ViewScoped

public class revisarPlanoDeNegocioBean implements Serializable {

    @ManagedProperty(value = "#{loginBean}")
    private Projeto projeto;
    private ComentarioProjeto comentarioProjeto;
    private LoginBean loginBean;

    public revisarPlanoDeNegocioBean() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projeto = (Projeto) session.getAttribute("projetoSelecionado");
        
        
        
    }
    

    /**
     * <p>
     * Método para verificar qual o tipo de estégio a empressa se encontra.
     * </p>
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
     * <p>
     * Muda o status do projeto em pré avaliação e redireciona para o início.
     * </p>
     */
    public void mudaStatusRedirecionaInicio() {
        getLoginBean().getInicio();

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

    /**
     * @return the comentarioProjeto
     */
    public ComentarioProjeto getComentarioProjeto() {
        return comentarioProjeto;
    }

    /**
     * @param comentarioProjeto the comentarioProjeto to set
     */
    public void setComentarioProjeto(ComentarioProjeto comentarioProjeto) {
        this.comentarioProjeto = comentarioProjeto;
    }

    /**
     * @return the loginBean
     */
    public LoginBean getLoginBean() {
        return loginBean;
    }

    /**
     * @param loginBean the loginBean to set
     */
    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

}
