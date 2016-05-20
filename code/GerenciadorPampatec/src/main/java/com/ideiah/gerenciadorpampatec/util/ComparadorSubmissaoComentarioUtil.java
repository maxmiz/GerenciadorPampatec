/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.util;

import com.ideiah.gerenciadorpampatec.model.Textocomentario;
import java.util.Comparator;

/**
 *
 * @author Maicon Alves
 */
public class ComparadorSubmissaoComentarioUtil implements Comparator<Textocomentario>{

    @Override
    public int compare(Textocomentario o1, Textocomentario o2) {
        return o1.getDataSubmissao().compareTo(o2.getDataSubmissao());
    }
    
}
