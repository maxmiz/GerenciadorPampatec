/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import com.ideiah.gerenciadorpampatec.util.EmailUtil;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Pedro
 */
public class Teste {
    
    public static void main(String args[]) {
        
       Empreendedor empreendedor = Empreendedor.buscaPorEmail("joao@gmail.com");
       empreendedor.setBairro("alegrete baita chao");
             
       empreendedor.atualizarEmpreendedor(empreendedor);
    }

}
