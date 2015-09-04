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
public class EmpreendedorDao extends Dao {

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
    
    /*
    * Verificação se o email e o nome já estão 
    * cadastrados no sistema.
    */
    public boolean buscarDados(String email, String nome){
        System.out.println("Entrou na BuscarDados na DAO");
        boolean resultado = true;
        //TRUE -> Não está cadastrado
        //FALSE -> Está cadastrado
        
        for (int i = 0; i < this.buscar().size(); i++) {
            if (this.buscar().get(i).getEmail() == email || this.buscar().get(i).getNome() == nome) {
                resultado = false;
            } else {
                resultado = true;
            }
            return resultado;
        }
        return resultado;
    }
    
    
    public Empreendedor buscarPorCpf(String cpf) {

        System.out.println("ouo");
        if (soContemNumeros(cpf)) {
            System.out.println("passou1");
            return (Empreendedor) buscarObjetoCriteria("cpf", cpf, Empreendedor.class);

        } else {
            System.out.println("passou2");
            return (Empreendedor) buscarObjetoCriteria("email", cpf, Empreendedor.class);

        }

    }
    
    public static boolean soContemNumeros(String texto) {
//        return texto.matches("[0-9]");
        if (texto == null) {
            return false;
        }
        for (char letra : texto.toCharArray()) {
            if (letra < '0' || letra > '9') {
                return false;
            }
        }
        return true;
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Deletar">
    public
            boolean deletar(int codigo) {
        return excluir(codigo, Empreendedor.class
        );
    }
//</editor-fold>

}
