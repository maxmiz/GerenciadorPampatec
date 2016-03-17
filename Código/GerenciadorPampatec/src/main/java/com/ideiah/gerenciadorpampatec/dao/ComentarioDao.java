/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.ComentarioAnaliseEmprego;
import com.ideiah.gerenciadorpampatec.model.ComentarioNegocio;
import com.ideiah.gerenciadorpampatec.model.ComentarioPlanoFinanceiro;
import com.ideiah.gerenciadorpampatec.model.ComentarioProdutoOuServico;
import com.ideiah.gerenciadorpampatec.model.ComentarioProjeto;
import java.io.Serializable;

/**
 *
 * @author MAICON
 */
public class ComentarioDao extends Dao implements Serializable{
    
//<editor-fold defaultstate="collapsed" desc="Salvar">
    
    
    public boolean salvarComentarioAnalise(ComentarioAnaliseEmprego comentarioanaliseemprego){
        return super.salvar(comentarioanaliseemprego);
    }
    
  
    public boolean salvarComentarioNegocio(ComentarioNegocio comentarionegocio){
        return super.salvar(comentarionegocio);
    }
       
    
    public boolean salvarComentarioPlanoFinanceiro(ComentarioPlanoFinanceiro comentarioplanofinanceiro){
        return super.salvar(comentarioplanofinanceiro);
    }   
    
    
    public boolean salvarComentarioProdutoOuServico(ComentarioProdutoOuServico comentarioproduto){
        return super.salvar(comentarioproduto);
    }
     
    //salva o objeto comentario inteiro no banco
    public boolean salvarComentarioProjeto(ComentarioProjeto comentarioprojeto){
        return super.salvar(comentarioprojeto);
       
    }
    
//</editor-fold>
     
    
//<editor-fold defaultstate="collapsed" desc="Buscar">
    
    //busca comentario pelo codigo
    public ComentarioProjeto buscar(int codigo) {
        return (ComentarioProjeto) buscarObjeto(codigo, ComentarioProjeto.class);
    }
    
    //busca comentario pelo status
    public ComentarioProjeto buscarPorStatus(int status) {
        return (ComentarioProjeto) buscarObjetoCriteriaINT("status", status, ComentarioProjeto.class);
    }
    
    //busca comentario pelo projeto
    
//</editor-fold>

}
