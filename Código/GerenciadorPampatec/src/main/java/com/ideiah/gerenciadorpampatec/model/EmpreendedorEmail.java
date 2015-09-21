/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import com.ideiah.gerenciadorpampatec.dao.EmpreendedorDao;
import com.ideiah.gerenciadorpampatec.dao.EmpreendedorEmailDao;
import static com.ideiah.gerenciadorpampatec.model.Empreendedor.getEmpreededorDao;

/**
 *
 * @author Jhonatan Moura
 */
public class EmpreendedorEmail {
    
    private String idEmpreendedorEmail;
    private String tipo;
    private Integer idEmpreendedor;
    
    /**
     * @return the empreededorDao
     */
    public static EmpreendedorEmailDao getEmpreededorEmailDao() {
        return new EmpreendedorEmailDao();
    }
    
    /**
     * @return the idEmpreendedorEmail
     */
    public String getIdEmpreendedorEmail() {
        return idEmpreendedorEmail;
    }

    /**
     * @param idEmpreendedorEmail the idEmpreendedorEmail to set
     */
    public void setIdEmpreendedorEmail(String idEmpreendedorEmail) {
        this.idEmpreendedorEmail = idEmpreendedorEmail;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the idEmpreendedor
     */
    public Integer getIdEmpreendedor() {
        return idEmpreendedor;
    }

    /**
     * @param idEmpreendedor the idEmpreendedor to set
     */
    public void setIdEmpreendedor(Integer idEmpreendedor) {
        this.idEmpreendedor = idEmpreendedor;
    }
    
    public static EmpreendedorEmail buscaEmpreendedorMailID(String id) {
        return getEmpreededorEmailDao().buscarPorIdUnico(id);
    }
    
}
