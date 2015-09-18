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
//        return super.salvar(projeto);
        return super.salvar(projeto);
    }
    public boolean update(Projeto projeto){
        return super.update(projeto);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Buscar">
    public ArrayList<Projeto> buscar() {
        return (ArrayList<Projeto>) buscarObjetos(Projeto.class);
    }

    public Projeto buscar(int codigo) {
        return (Projeto) buscarObjeto(codigo, Projeto.class);
    }

    public boolean verificaEmpreendedor(Empreendedor empreendedor, Projeto projeto) {
//        Projeto[] listaOriginal = (Projeto[]) empreendedor.getProjetos().toArray();
//        ArrayList<Projeto> listaOriginal = (ArrayList<Projeto>) empreendedor.getProjetos().toArray();
        
        for (Object obj : empreendedor.getProjetos().toArray()) {
            Projeto proj = (Projeto) obj;
            if(proj.getIdProjeto() == projeto.getIdProjeto()){
                return false;
            }
        }   
        return true;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Deletar">
    public boolean deletar(int codigo) {
        return excluir(codigo, Projeto.class);
    }
//</editor-fold>
}
