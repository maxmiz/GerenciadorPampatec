/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class EmpreededorDao extends Dao{

//<editor-fold defaultstate="collapsed" desc="Salvar">
    public boolean salvar(Empreendedor empreendedor) {
        return super.salvar(empreendedor);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Buscar">
    public ArrayList<Empreendedor> buscar() {
        return (ArrayList<Empreendedor>) buscarObjetos(Empreendedor.class);
    }

    public Empreendedor buscar(int codigo) {
        return (Empreendedor) buscarObjeto(codigo, Empreendedor.class);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Deletar">
    public boolean deletar(int codigo) {
        return excluir(codigo, Empreendedor.class);
    }
//</editor-fold>
    
}
