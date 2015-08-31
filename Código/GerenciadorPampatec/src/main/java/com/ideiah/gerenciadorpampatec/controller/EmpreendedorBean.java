/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;

/**
 *
 * @author AugustoCesar
 */
public class EmpreendedorBean {
    
    Empreendedor empreendedor = new Empreendedor();
    public void chamaCadastro(){
        
    }
    public void chamaLogin(){
        empreendedor.fazLogin();
    }
}
