/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Comentarioplanofinanceiro generated by hbm2java
 * 
 * @author Edison Jhonatan
 * @since 10/11/15
 */
public class ComentarioAnaliseEmprego  implements java.io.Serializable {


     private int idcomentarioanaliseemprego;
     private String relacoesClientes;
     private String parceriasChaves;
     private String canais;
     private String recursosPrincipais;
     private String concorrentes;
     private Set comentarioprojetos = new HashSet(0);

    public ComentarioAnaliseEmprego() {
    }

	
    public ComentarioAnaliseEmprego(int idcomentarioanaliseemprego) {
        this.idcomentarioanaliseemprego = idcomentarioanaliseemprego;
    }
    public ComentarioAnaliseEmprego(int idcomentarioanaliseemprego, String relacoesClientes, String parceriasChaves, String canais, String recursosPrincipais, String concorrentes, Set comentarioprojetos) {
       this.idcomentarioanaliseemprego = idcomentarioanaliseemprego;
       this.relacoesClientes = relacoesClientes;
       this.parceriasChaves = parceriasChaves;
       this.canais = canais;
       this.recursosPrincipais = recursosPrincipais;
       this.concorrentes = concorrentes;
       this.comentarioprojetos = comentarioprojetos;
    }
   
    public int getIdcomentarioanaliseemprego() {
        return this.idcomentarioanaliseemprego;
    }
    
    public void setIdcomentarioanaliseemprego(int idcomentarioanaliseemprego) {
        this.idcomentarioanaliseemprego = idcomentarioanaliseemprego;
    }
    public String getRelacoesClientes() {
        return this.relacoesClientes;
    }
    
    public void setRelacoesClientes(String relacoesClientes) {
        this.relacoesClientes = relacoesClientes;
    }
    public String getParceriasChaves() {
        return this.parceriasChaves;
    }
    
    public void setParceriasChaves(String parceriasChaves) {
        this.parceriasChaves = parceriasChaves;
    }
    public String getCanais() {
        return this.canais;
    }
    
    public void setCanais(String canais) {
        this.canais = canais;
    }
    public String getRecursosPrincipais() {
        return this.recursosPrincipais;
    }
    
    public void setRecursosPrincipais(String recursosPrincipais) {
        this.recursosPrincipais = recursosPrincipais;
    }
    public String getConcorrentes() {
        return this.concorrentes;
    }
    
    public void setConcorrentes(String concorrentes) {
        this.concorrentes = concorrentes;
    }
    public Set getComentarioprojetos() {
        return this.comentarioprojetos;
    }
    
    public void setComentarioprojetos(Set comentarioprojetos) {
        this.comentarioprojetos = comentarioprojetos;
    }




}


