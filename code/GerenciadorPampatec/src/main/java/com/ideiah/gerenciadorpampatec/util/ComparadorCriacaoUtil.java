/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.util;

import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.util.Comparator;

/**
 *
 * @author Claudio
 */
public class ComparadorCriacaoUtil implements Comparator<Projeto>{

    @Override
    public int compare(Projeto o1, Projeto o2) {
        return o1.getDataCriacao().compareTo(o2.getDataCriacao());
    }
    
}
