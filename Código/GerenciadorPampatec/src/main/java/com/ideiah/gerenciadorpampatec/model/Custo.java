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
     private Integer tipo;
     private Float valorMes1;
     private Float valorMes2;
     private Float valorMes3;
     private Float valorMes4;
     private Float valorMes5;
     private Float valorMes6;
     public static final int CUSTO_FIXO = 0;
     public static final int CUSTO_VARIAVEL = 1;
     

    public Custo() {
    }

	
    public Custo(Planofinanceiro planofinanceiro) {
        this.planofinanceiro = planofinanceiro;
    }
    public Custo(Planofinanceiro planofinanceiro, String descricao, Float total, Integer tipo, Float valorMes1, Float valorMes2, Float valorMes3, Float valorMes4, Float valorMes5, Float valorMes6) {
       this.planofinanceiro = planofinanceiro;
       this.descricao = descricao;
       this.total = total;
       this.tipo = tipo;
       this.valorMes1 = valorMes1;
       this.valorMes2 = valorMes2;
       this.valorMes3 = valorMes3;
       this.valorMes4 = valorMes4;
       this.valorMes5 = valorMes5;
       this.valorMes6 = valorMes6;
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
        return this.tipo;
    }
    
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    public Float getValorMes1() {
        return this.valorMes1;
    }
    
    public void setValorMes1(Float valorMes1) {
        this.valorMes1 = valorMes1;
    }
    public Float getValorMes2() {
        return this.valorMes2;
    }
    
    public void setValorMes2(Float valorMes2) {
        this.valorMes2 = valorMes2;
    }
    public Float getValorMes3() {
        return this.valorMes3;
    }
    
    public void setValorMes3(Float valorMes3) {
        this.valorMes3 = valorMes3;
    }
    public Float getValorMes4() {
        return this.valorMes4;
    }
    
    public void setValorMes4(Float valorMes4) {
        this.valorMes4 = valorMes4;
    }
    public Float getValorMes5() {
        return this.valorMes5;
    }
    
    public void setValorMes5(Float valorMes5) {
        this.valorMes5 = valorMes5;
    }
    public Float getValorMes6() {
        return this.valorMes6;
    }
    
    public void setValorMes6(Float valorMes6) {
        this.valorMes6 = valorMes6;
    }




}


