/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import com.ideiah.gerenciadorpampatec.util.FacesUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GUTO
 */
@ManagedBean
public class PreAvaliarPlanoBean {

    private Projeto projeto;

    public PreAvaliarPlanoBean() {
//        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//        projeto = (Projeto) sessao.getAttribute("projetoSelecionado");

        /**
         * apenas para testes
         */
        ProjetoDao dao = new ProjetoDao();
        projeto = dao.buscar(113);
    }

    /**
     * Método para verificar qual o tido de estágio a empressa sem encontra 
     * @return 
     */
    public String verificaEstagioEvolucao() {
        String status = projeto.getProdutoouservico().verificaStatusProjeto(projeto.getProdutoouservico().getEstagioEvolucao());
        if(status.equals("Outro:")){
            return projeto.getProdutoouservico().getEstagioEvolucao();
        }else{
            return status;
        }
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
}
