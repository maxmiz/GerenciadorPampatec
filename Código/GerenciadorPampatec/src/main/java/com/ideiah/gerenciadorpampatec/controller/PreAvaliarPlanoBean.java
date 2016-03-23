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
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
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
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;
    private int resultadoPreAvaliacao;
    private int contAnterior;

    public PreAvaliarPlanoBean() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projeto = (Projeto) session.getAttribute("projetoSelecionado");
        ComentarioDao comentarioDao = new ComentarioDao();

        //Gambiarra para resolver o problema do usuário deixar a página.
        //Quando o usuário acessa a pagina de pré-avaliar ou atualiza a
        //página, o construtor é chamado adionando um ao contador de acessos do projeto.
        //Se ele sair pra qualquer página esse contrutor não será chamado.
        //Com isso é possível identificar quando a página foi atualizada, pois
        //o contador de acesso será incrementado quando isso acontecer.
        //Para saber se o status deve ser mudado ou não é necessessário comparar
        //o contador do projeto e o valor desse contador anteriormente(contAnterior). 
        projeto.setContAcesso(projeto.getContAcesso() + 1);
        contAnterior = projeto.getContAcesso();

        buscarComentarioProjeto(projeto);
        
        mudaStatus();

        if (comentarioProjeto == null) {
            comentarioProjeto = new ComentarioProjeto();
            comentarioProjeto.setProjeto(projeto);
            comentarioProjeto = comentarioDao.salvarRetornandoComentarioProjeto(comentarioProjeto);          
        }
    }

    public void mudaStatus() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        projeto.setStatus(Projeto.SENDO_AVALIADO);
        ProjetoDao dao = new ProjetoDao();
        dao.update(projeto);
        session.setAttribute("projetoSelecionado", projeto);
    }

    public void buscarComentarioProjeto(Projeto projetoSelecionado) {

        ComentarioDao comentDao = new ComentarioDao();

        for (ComentarioProjeto comentarioProjeto : projetoSelecionado.getComentarioProjeto()) {
            if (comentarioProjeto.getStatus() == ComentarioProjeto.EM_ANDAMENTO) {
                this.comentarioProjeto = comentarioProjeto;
            }
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
     * Muda o status do projeto em pré avaliação e redireciona para o início
     */
    public void mudaStatusRedirecionaInicio() {
        mudaStatusProjetoParaEmPreAvaliacao(projeto);
        loginBean.getInicioGerente();

    }

    public void mudaStatusRedirecionaLista() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        //Gambiarra para resolver o problema do usuário deixar a página
        if (contAnterior == projeto.getContAcesso()) {
            mudaStatusProjetoParaEmPreAvaliacao(projeto);
            session.removeAttribute("projetoSelecionado");
        }
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("buscarPlanoDeNegocio.jsf");
        } catch (Exception ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mudaStatusFazLogout() {
        mudaStatusProjetoParaEmPreAvaliacao(projeto);
        loginBean.fazLogout();
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
        FacesContext.getCurrentInstance().addMessage("formulario_comentarpreavalizar:tituloMensagem", msg);
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

    public int getResultadoPreAvaliacao() {
        return resultadoPreAvaliacao;
    }

    public void setResultadoPreAvaliacao(int resultadoPreAvaliacao) {
        this.resultadoPreAvaliacao = resultadoPreAvaliacao;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    /**
     *
     * @param projSelect
     */
    public void mudaStatusProjetoParaSendoAvaliado(Projeto projSelect) {

        if (projSelect.getStatus() == Projeto.EM_PRE_AVALIACAO) {
            projSelect.setStatus(Projeto.SENDO_AVALIADO);
            ProjetoDao dao = new ProjetoDao();
            dao.update(projSelect);
        }
    }

    public void mudaStatusProjetoParaEmPreAvaliacao(Projeto projSelect) {
        if (projSelect.getStatus() == Projeto.SENDO_AVALIADO) {
            projSelect.setStatus(Projeto.EM_PRE_AVALIACAO);
            ProjetoDao dao = new ProjetoDao();
            dao.update(projSelect);
        }
    }

    /**
     * <p>
     * Método que finaliza a avaliação do projeto, muda o seu status, bem como o
     * dos comentários.</p>
     */
    public void terminarPreAvaliacao() {
        if (getResultadoPreAvaliacao() != 0) {
            if (projeto.getStatus() == Projeto.SENDO_AVALIADO) {
//                System.out.println("\t>>>> Entrou no terminarPreAvaliação! "
//                        + "\t Status= " + projeto.getStatus()
//                        + "\t Status selecionado: " + getResultadoPreAvaliacao());
                projeto.setStatus(getResultadoPreAvaliacao());
                mudaStatusComentarioProjetoFinalizar();
                ProjetoDao projDao = new ProjetoDao();
                projDao.update(projeto);
            }
        }
    }

    /**
     * <p>
     * Método para atualizar o status dos comentários ao finalizar a avaliação.
     * </p>
     */
    private void mudaStatusComentarioProjetoFinalizar() {
        if (Objects.equals(comentarioProjeto.getProjeto().getIdProjeto(), projeto.getIdProjeto())) {
            comentarioProjeto.setStatus(ComentarioProjeto.FINALIZADO);
            getBuscarPlanoDeNegocio();
        }
    }

    /**
     * Redireciona para a página de lista de Planos de Negócio.
     */
    private void getBuscarPlanoDeNegocio() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("buscarPlanoDeNegocio.jsf");
        } catch (Exception e) {
            Logger.getLogger(PreAvaliarPlanoBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
