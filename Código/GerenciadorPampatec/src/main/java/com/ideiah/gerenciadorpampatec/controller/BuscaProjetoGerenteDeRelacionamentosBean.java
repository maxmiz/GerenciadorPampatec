/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.util.ArrayList;

/**
 *
 * @author Edison Moura
 */
public class BuscaProjetoGerenteDeRelacionamentosBean {

    private ArrayList<Projeto> listaProjetos;
    private ProjetoDao projeto;

    public BuscaProjetoGerenteDeRelacionamentosBean() {
        projeto = new ProjetoDao();
        listaProjetos = buscaProjetoPorStatus();
    }

    public void setListaProjetos(ArrayList<Projeto> listaProjetos) {
        this.listaProjetos = listaProjetos;
    }

    /**
     *
     * @return Lista de projetos com o status igual à 1 (EM_PRE_AVALIAÇÃO)
     */
    public ArrayList<Projeto> buscaProjetoPorStatus() {
        return Projeto.buscarProjetoPorStatus(Projeto.EM_PRE_AVALIACAO);

    }
}
