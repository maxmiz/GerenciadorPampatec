/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Edison Jhonatan
 * @since 10/11/15
 */
public class ComentarioNegocio implements java.io.Serializable {

    private int idcomentarionegocio;
    private String segmentoClientes;
    private String propostaValor;
    private String atividadesChaves;
    private Set comentarioprojetos;

    public ComentarioNegocio() {
        segmentoClientes = "";
        propostaValor = "";
        atividadesChaves = "";
        comentarioprojetos = new HashSet(0);
    }

    public ComentarioNegocio(int idcomentarionegocio) {
        this.idcomentarionegocio = idcomentarionegocio;
    }

    public ComentarioNegocio(int idcomentarionegocio, String segmentoClientes, String propostaValor, String atividadesChaves, Set comentarioprojetos) {
        this.idcomentarionegocio = idcomentarionegocio;
        this.segmentoClientes = segmentoClientes;
        this.propostaValor = propostaValor;
        this.atividadesChaves = atividadesChaves;
        this.comentarioprojetos = comentarioprojetos;
    }

    public int getIdcomentarionegocio() {
        return this.idcomentarionegocio;
    }

    public void setIdcomentarionegocio(int idcomentarionegocio) {
        this.idcomentarionegocio = idcomentarionegocio;
    }

    public String getSegmentoClientes() {
        return this.segmentoClientes;
    }

    public void setSegmentoClientes(String segmentoClientes) {
        this.segmentoClientes = segmentoClientes;
    }

    public String getPropostaValor() {
        return this.propostaValor;
    }

    public void setPropostaValor(String propostaValor) {
        this.propostaValor = propostaValor;
    }

    public String getAtividadesChaves() {
        return this.atividadesChaves;
    }

    public void setAtividadesChaves(String atividadesChaves) {
        this.atividadesChaves = atividadesChaves;
    }

    public Set getComentarioprojetos() {
        return this.comentarioprojetos;
    }

    public void setComentarioprojetos(Set comentarioprojetos) {
        this.comentarioprojetos = comentarioprojetos;
    }
}
