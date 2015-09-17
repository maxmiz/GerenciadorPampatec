/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Pedro
 */
public class Teste {
    
    private static SimpleEmail emailSimples;

    public static void main(String args[]) {
        Empreendedor empreendedor = new Empreendedor();
        empreendedor.setCpf("dsadas");
        empreendedor.setEmail("dasdasda");
        empreendedor.setNome("dsadasda");
        empreendedor.setSenha("dasdasda");
        empreendedor.setFormacao("dasda");
        empreendedor.setBairro("dsadas");
        empreendedor.setRua("dasdasdasda");
        empreendedor.setComplemento("dsadsadas");
        empreendedor.setNumero(32131231);
        
        mandarEmail("teste", "teste");

    }

    public static void mandarEmail(String assunto, String mensagem) {
        try {
            
            emailSimples.setHostName("smtp.googlemail.com");
            emailSimples.setSmtpPort(465);
            emailSimples.setAuthenticator(new DefaultAuthenticator("contato@ideiah.com", "uniideiahpampa"));
            emailSimples.setSSLOnConnect(true);
            emailSimples.setFrom("edisonjhonatan@gmail.com");
            emailSimples.setSubject("EMAIL DO SITE: " + assunto);
            emailSimples.setMsg(mensagem);
            emailSimples.addTo("edisonjhonatan@gmail.com");
            emailSimples.send();
        } catch (EmailException ex) {
            ex.printStackTrace();
        }
    }

}
