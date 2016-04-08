/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ComentarioDao;
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

    private Projeto projeto;
    private ComentarioProjeto comentarioProjeto;
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;

    public revisarPlanoDeNegocioBean() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projeto = (Projeto) session.getAttribute("projetoSelecionado");
        recuperaComentarioProjeto();
    }

    /**
     * <p>
     * Método para retornar os comentarios do projeto selecionado que estão com
     * o estatus finalizado.
     * </p>
     */
    public void recuperaComentarioProjeto() {

        for (ComentarioProjeto objetoComentarioprojeto : projeto.getComentarioProjeto()) {
            if (objetoComentarioprojeto.getStatus() == ComentarioProjeto.FINALIZADO) {
                comentarioProjeto = objetoComentarioprojeto;
                break;
            }
        }
    }

    public boolean verificaStatusAceitoAvaliacao(Projeto projetoSelecionado) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projetoSelecionado = (Projeto) session.getAttribute("projetoSelecionado");
        return projetoSelecionado.getStatus() == Projeto.ACEITO_PARA_AVALIACAO;
    }

    public boolean verificaExistenciaComentario() {

        return true;
    }

    /**
     * <p>
     * Método para retornar o resultado da Avaliação em string para a area de
     * Avaliação.
     *
     * @return o resultado da avaliação pelo gerente.
     * </p>
     */
    public String retornaResultadoAvaliacao() {
        String resultadoAvaliacao = "";

        switch (projeto.getStatus()) {
            case Projeto.NECESSITA_MELHORIA:
                resultadoAvaliacao = " Projeto Necessita Realizar Ajustes";
                break;
            case Projeto.REPROVADO:
                resultadoAvaliacao = " Projeto Reprovado";
                break;
            case Projeto.ACEITO_PARA_AVALIACAO:
                resultadoAvaliacao = " Projeto Aceito para Avaliação";
                break;
            default:
                break;
        }
        return resultadoAvaliacao;
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
