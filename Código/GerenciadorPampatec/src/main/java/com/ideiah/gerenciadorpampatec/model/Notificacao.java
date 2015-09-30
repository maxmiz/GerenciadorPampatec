/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

/**
 *
 * @author Edison Moura
 */
public class Notificacao implements java.io.Serializable {

    private int idNotificacao;
    private String descricao;
    private int idEmpreendedor;
    
    public Notificacao () {
        
    }
    
    /**
     * 
     * @param idNotificao
     * @param idEmpreendedor 
     */
    public Notificacao (int idNotificao, int idEmpreendedor) {
        this.idNotificacao = idNotificao;
        this.idEmpreendedor = idEmpreendedor;
    }
    
    /**
     * 
     * @param idNotificacao
     * @param descricao
     * @param idEmpreendedor 
     */
    public Notificacao (int idNotificacao, String descricao, int idEmpreendedor) {
        this.idNotificacao = idNotificacao;
        this.descricao = descricao;
        this.idEmpreendedor = idEmpreendedor;
    }

    /**
     * @return the idNotificacao
     */
    public int getIdNotificacao() {
        return idNotificacao;
    }

    /**
     * @param idNotificacao the idNotificacao to set
     */
    public void setIdNotificacao(int idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the idEmpreendedor
     */
    public int getIdEmpreendedor() {
        return idEmpreendedor;
    }

    /**
     * @param idEmpreendedor the idEmpreendedor to set
     */
    public void setIdEmpreendedor(int idEmpreendedor) {
        this.idEmpreendedor = idEmpreendedor;
    }
    
    

}
