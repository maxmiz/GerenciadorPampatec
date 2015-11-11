/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ideiah.gerenciadorpampatec.model;

import java.io.Serializable;


/**
 * 
 * @author Edison Jhonatan
 * @since 10/11/15
 */
public class Custo  implements java.io.Serializable {


     private Integer idCusto;
     private Planofinanceiro planofinanceiro;
     private String descricao;
     private Float total;
     private Float projecao;
     private Integer tipo;
     public static final int CUSTO_FIXO = 0;
     public static final int CUSTO_VARIAVEL = 1;
     

    public Custo() {
    }

	
    public Custo(Planofinanceiro planofinanceiro) {
        this.planofinanceiro = planofinanceiro;
    }
    public Custo(Planofinanceiro planofinanceiro, String descricao, Float total, Integer tipo) {
       this.planofinanceiro = planofinanceiro;
       this.descricao = descricao;
       this.total = total;
       this.tipo = tipo;
    }
   
    public Integer getIdCusto() {
        return this.idCusto;
    }
    
    public void setIdCusto(Integer idCusto) {
        this.idCusto = idCusto;
    }
    public Planofinanceiro getPlanofinanceiro() {
        return this.planofinanceiro;
    }
    
    public void setPlanofinanceiro(Planofinanceiro planofinanceiro) {
        this.planofinanceiro = planofinanceiro;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Float getTotal() {
        return this.total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Float getProjecao() {
        return projecao;
    }

    public void setProjecao(Float projecao) {
        this.projecao = projecao;
    }
      
}


