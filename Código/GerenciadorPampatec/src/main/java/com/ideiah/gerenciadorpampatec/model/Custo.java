/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ideiah.gerenciadorpampatec.model;

/**
 *
 * @author AndersonR
 */
public class Custo {
    
    public static final int CUSTO_FIXO = 0;
    public static final int CUSTO_VARIAVEL = 1;
    
    private Integer idCusto; 
    private String descricao;
    private float valor;
    private int tipo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Integer getIdCusto() {
        return idCusto;
    }

    public void setIdCusto(Integer idCusto) {
        this.idCusto = idCusto;
    }
    
}
