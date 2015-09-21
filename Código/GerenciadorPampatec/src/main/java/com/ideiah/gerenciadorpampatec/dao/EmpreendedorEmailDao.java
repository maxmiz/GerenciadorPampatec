/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.EmpreendedorEmail;
import java.util.ArrayList;

/**
 *
 * @author Jhonatan Moura
 */
public class EmpreendedorEmailDao extends Dao {
    
    
    //<editor-fold defaultstate="collapsed" desc="Salvar">
    public boolean salvar(EmpreendedorEmail empreendedorEmail) {
        return super.salvar(empreendedorEmail);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Buscar">
    public ArrayList<EmpreendedorEmail> buscar() {
        return (ArrayList<EmpreendedorEmail>) buscarObjetos(EmpreendedorEmail.class);
    }
    
    public EmpreendedorEmail buscar(int codigo) {
        return (EmpreendedorEmail) buscarObjeto(codigo, EmpreendedorEmail.class);
    }
    
    public EmpreendedorEmail buscarPorIdUnico(String idUnico) {
        return (EmpreendedorEmail) buscarObjetoCriteria("idUnico", idUnico, EmpreendedorEmail.class);
        
    }
    
    //</editor-fold>
    
}
