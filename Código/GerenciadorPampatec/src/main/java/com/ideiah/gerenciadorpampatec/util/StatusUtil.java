/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.util;

/**
 *
 * @author Claudio
 */
public enum StatusUtil {
    
        EM_ANDAMENTO(1), FINALIZADO(2);
        
        private final int status_numero;
        
        StatusUtil(int valor){
            status_numero = valor;
        }
        
        public int getStatus(){
            return status_numero;
        }
    
}
