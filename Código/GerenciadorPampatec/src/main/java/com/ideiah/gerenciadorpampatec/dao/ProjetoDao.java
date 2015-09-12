/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class ProjetoDao extends Dao {
//<editor-fold defaultstate="collapsed" desc="Salvar">

    public boolean salvar(Projeto projeto) {
        return super.salvar(projeto);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Buscar">
    public ArrayList<Projeto> buscar() {
        return (ArrayList<Projeto>) buscarObjetos(Projeto.class);
    }

    public Projeto buscar(int codigo) {
        return (Projeto) buscarObjeto(codigo, Projeto.class);
    }

    public ArrayList<Projeto> buscarPorEmpreendedor(Empreendedor empreendedor) {
        ArrayList<Projeto> novaLista = new ArrayList();
        ArrayList<Projeto> listaOriginal;
        listaOriginal = (ArrayList<Projeto>) buscarObjetos(Projeto.class);
        
        for (Projeto projeto : listaOriginal) {
           if(projeto.getEmpreendedors().contains(empreendedor)){
               novaLista.add(projeto);
           }
        }
        return novaLista;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Deletar">
    public boolean deletar(int codigo) {
        return excluir(codigo, Projeto.class);
    }
//</editor-fold>
}
