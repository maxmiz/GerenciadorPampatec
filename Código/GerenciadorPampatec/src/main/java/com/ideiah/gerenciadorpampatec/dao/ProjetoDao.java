/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import org.hibernate.HibernateException;

/**
 *
 * @author Pedro
 */
public class ProjetoDao extends Dao implements Serializable {
//<editor-fold defaultstate="collapsed" desc="Salvar">

    public boolean salvar(Projeto projeto) {
        return super.salvar(projeto);
    }

    public Projeto salvarRetornandoProjeto(Projeto projeto) {
        try {
            setTx(getSession().getTransaction());
            getTx().begin();
            projeto = (Projeto) getSession().merge(projeto);
            getTx().commit();
            return projeto;
        } catch (HibernateException e) {
            e.printStackTrace();
            getSession().getTransaction().rollback();
        }
        return null;
    }

    public boolean update(Projeto projeto) {
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
    
    public Projeto buscarPorStatus(int status) {
        return (Projeto) buscarObjetoCriteriaINT("status", status, Projeto.class);
    }

    public boolean verificaEmpreendedor(Empreendedor empreendedor, Projeto projeto) {
//        Projeto[] listaOriginal = (Projeto[]) empreendedor.getProjetos().toArray();
//        ArrayList<Projeto> listaOriginal = (ArrayList<Projeto>) empreendedor.getProjetos().toArray();

        for (Object obj : empreendedor.getProjetos().toArray()) {
            Projeto proj = (Projeto) obj;
            if (proj.getIdProjeto() == projeto.getIdProjeto()) {
                return false;
            }
        }
        return true;
    }
    
    public BigInteger retornarUltimoId(){
        return (BigInteger) getSession().createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Deletar">
    public boolean deletar(int codigo) {
        return excluir(codigo, Projeto.class);
    }
//</editor-fold>
}
