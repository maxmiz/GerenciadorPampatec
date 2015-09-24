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

    private static SimpleEmail emailSimples;
    private static HtmlEmail emailHtml;

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

//        mandarEmail("Este é o assunto", "Esta é a mensagem");
//        mandarHtml();
//        EmailUtil.mandarEmailConcluirCadastro("Pedro", "Ideiah", "edisonjhonatan@gmail.com");

    }

    /*
    * Testes de envio de cod html via emaail
    */

}
