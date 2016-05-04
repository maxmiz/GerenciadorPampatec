/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Pedro
 */
public class Textocomentario  implements java.io.Serializable {


     private int idtextocomentario;
     private GerenteRelacionamento gerenteRelacionamento;
     private String texto;
     private Date dataAlteracao;
     private Date dataSubmissao;
     private Integer tipo;
     private Set comentarioprojetos = new HashSet(0);

    public Textocomentario() {
    }

	
    public Textocomentario(int idtextocomentario, GerenteRelacionamento gerenteRelacionamento) {
        this.idtextocomentario = idtextocomentario;
        this.gerenteRelacionamento = gerenteRelacionamento;
    }
    public Textocomentario(int idtextocomentario, GerenteRelacionamento gerenteRelacionamento, String texto, Date dataAlteracao, Date dataSubmissao, Integer tipo, Set comentarioprojetos) {
       this.idtextocomentario = idtextocomentario;
       this.gerenteRelacionamento = gerenteRelacionamento;
       this.texto = texto;
       this.dataAlteracao = dataAlteracao;
       this.dataSubmissao = dataSubmissao;
       this.tipo = tipo;
       this.comentarioprojetos = comentarioprojetos;
    }
   
    public int getIdtextocomentario() {
        return this.idtextocomentario;
    }
    
    public void setIdtextocomentario(int idtextocomentario) {
        this.idtextocomentario = idtextocomentario;
    }
    public GerenteRelacionamento getGerenteRelacionamento() {
        return this.gerenteRelacionamento;
    }
    
    public void setGerenteRelacionamento(GerenteRelacionamento gerenteRelacionamento) {
        this.gerenteRelacionamento = gerenteRelacionamento;
    }
    public String getTexto() {
        return this.texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public Date getDataAlteracao() {
        return this.dataAlteracao;
    }
    
    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
    public Date getDataSubmissao() {
        return this.dataSubmissao;
    }
    
    public void setDataSubmissao(Date dataSubmissao) {
        this.dataSubmissao = dataSubmissao;
    }
    public Integer getTipo() {
        return this.tipo;
    }
    
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    public Set getComentarioprojetos() {
        return this.comentarioprojetos;
    }
    
    public void setComentarioprojetos(Set comentarioprojetos) {
        this.comentarioprojetos = comentarioprojetos;
    }
}
