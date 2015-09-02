/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author AugustoCesar
 */
@ManagedBean(name = "candidatoBean")
@ViewScoped
public class EmpreendedorBean {
    
    Empreendedor empreendedor = new Empreendedor();//Temporario.
    public void chamaCadastro(){
        
    }
    public void chamaLogin(){
        empreendedor.fazLogin();
    }
}
