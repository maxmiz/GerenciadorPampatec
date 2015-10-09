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
public class ComentarioNegocio implements Serializable {

    private String segmentoClientes;
    private String propostaValor;
    private String atividadesChaves;
    private int idcomentario_negocio;
    private ComentarioProjeto comentarioProjeto;

    public ComentarioNegocio() {
    }

    public ComentarioNegocio(String segmentoClientes, String propostaValor, String atividadesChaves, int idcomentario_negocio, ComentarioProjeto comentarioProjeto) {
        this.segmentoClientes = segmentoClientes;
        this.propostaValor = propostaValor;
        this.atividadesChaves = atividadesChaves;
        this.idcomentario_negocio = idcomentario_negocio;
        this.comentarioProjeto = comentarioProjeto;
    }

    
    /**
     * @return the segmentoClientes
     */
    public String getSegmentoClientes() {
        return segmentoClientes;
    }

    /**
     * @param segmentoClientes the segmentoClientes to set
     */
    public void setSegmentoClientes(String segmentoClientes) {
        this.segmentoClientes = segmentoClientes;
    }

    /**
     * @return the propostaValor
     */
    public String getPropostaValor() {
        return propostaValor;
    }

    /**
     * @param propostaValor the propostaValor to set
     */
    public void setPropostaValor(String propostaValor) {
        this.propostaValor = propostaValor;
    }

    /**
     * @return the atividadesChaves
     */
    public String getAtividadesChaves() {
        return atividadesChaves;
    }

    /**
     * @param atividadesChaves the atividadesChaves to set
     */
    public void setAtividadesChaves(String atividadesChaves) {
        this.atividadesChaves = atividadesChaves;
    }

    /**
     * @return the idcomentario_negocio
     */
    public int getIdcomentario_negocio() {
        return idcomentario_negocio;
    }

    /**
     * @param idcomentario_negocio the idcomentario_negocio to set
     */
    public void setIdcomentario_negocio(int idcomentario_negocio) {
        this.idcomentario_negocio = idcomentario_negocio;
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
