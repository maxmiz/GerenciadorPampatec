/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.io.Serializable;

/**
 *
 * @author GUTO
 */
public class Comentario_AnaliseEmprego implements Serializable{

    private String relacoesClientes;
    private String parceriasChaves;
    private String canais;
    private String recursosprincipais;
    private String concorrentes;
    private int id_comentarioAnaliseEmprego;
    private ComentarioProjeto comentarioProjeto;

    /**
     * @return the relacoesClientes
     */
    public String getRelacoesClientes() {
        return relacoesClientes;
    }

    /**
     * @param relacoesClientes the relacoesClientes to set
     */
    public void setRelacoesClientes(String relacoesClientes) {
        this.relacoesClientes = relacoesClientes;
    }

    /**
     * @return the parceriasChaves
     */
    public String getParceriasChaves() {
        return parceriasChaves;
    }

    /**
     * @param parceriasChaves the parceriasChaves to set
     */
    public void setParceriasChaves(String parceriasChaves) {
        this.parceriasChaves = parceriasChaves;
    }

    /**
     * @return the canais
     */
    public String getCanais() {
        return canais;
    }

    /**
     * @param canais the canais to set
     */
    public void setCanais(String canais) {
        this.canais = canais;
    }

    /**
     * @return the recursosprincipais
     */
    public String getRecursosprincipais() {
        return recursosprincipais;
    }

    /**
     * @param recursosprincipais the recursosprincipais to set
     */
    public void setRecursosprincipais(String recursosprincipais) {
        this.recursosprincipais = recursosprincipais;
    }

    /**
     * @return the concorrentes
     */
    public String getConcorrentes() {
        return concorrentes;
    }

    /**
     * @param concorrentes the concorrentes to set
     */
    public void setConcorrentes(String concorrentes) {
        this.concorrentes = concorrentes;
    }

    /**
     * @return the id_comentarioAnaliseEmprego
     */
    public int getId_comentarioAnaliseEmprego() {
        return id_comentarioAnaliseEmprego;
    }

    /**
     * @param id_comentarioAnaliseEmprego the id_comentarioAnaliseEmprego to set
     */
    public void setId_comentarioAnaliseEmprego(int id_comentarioAnaliseEmprego) {
        this.id_comentarioAnaliseEmprego = id_comentarioAnaliseEmprego;
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

}
