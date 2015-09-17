/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

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
        mandarHtml();

    }

    /*
    * Testes de envio de cod html via emaail
    */
    
    public static void mandarHtml() {
        emailHtml = new HtmlEmail();
        try {
            emailHtml.setHostName("smtp.googlemail.com");
            emailHtml.setSmtpPort(465);
            emailHtml.setAuthenticator(new DefaultAuthenticator("contato@ideiah.com", "uniideiahpampa"));
            emailHtml.setSSLOnConnect(true);
            emailHtml.addTo("edisonjhonatan@gmail.com", "Jhonatan");
            emailHtml.setFrom("contato@ideah.com", "Ideiah");
            emailHtml.setSubject("EMAIL TESTE");

            StringBuffer msg = new StringBuffer();

            msg.append("<html lang=\"pt-br\">\n"
                    + "  <head>\n"
                    + "    <meta charset=\"utf-8\"/>\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                    + "  </head>\n"
                    + "  <body background=\"resources/imagens/21.jpg\" style=\"margin: 0;padding-top: 10px\">\n"
                    + "\n"
                    + "        <div class=\"col-md-4\" style=\"width: 66.333333%\"/>\n"
                    + "        <div class=\"col-md-4 text-center well\" style=\"text-align: center;width: 66.333333%;min-height: 20px;padding: 19px;margin-bottom: 20px;background-color: #f5f5f5;border: 2px solid #3FB618;border-radius: 0;-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05)\">\n"
                    + "            <h1 class=\"fonteBranca\">Título do E-mail</h1>\n"
                    + "            <form class=\"form-horizontal\">\n"
                    + "                    <div class=\"form-group\" style=\"margin-bottom: 15px\">\n"
                    + "                        <a>Olá!</a><br/><br/><a>O empreendedor <strong>\"nome do empreendedor\"</strong> adicionou você\n"
                    + "                        como sócio no projeto <strong>\"nome do projeto\"</strong>.\n"
                    + "                        <br/><br/>Para que você possa utilizar o Sistema de Gerenciamento de Projetos do \n"
                    + "                        PampaTec é necessário confirmar o seu e-mail e realizar o seu cadastro.\n"
                    + "                        <br/><br/>Para realizar o seu cadastro clique na opção abaixo.</a><br/><br/><button class=\"btn btn-success\" style=\"color: #fff;background-color: #3fb618;border-color: #3fb618;display: inline-block;margin-bottom: 0;font-weight: normal;text-align: center;vertical-align: middle;-ms-touch-action: manipulation;touch-action: manipulation;cursor: pointer;background-image: none;border: 1px solid transparent;white-space: nowrap;padding: 10px 18px;font-size: 15px;line-height: 1.428571;border-radius: 0;-webkit-user-select: none;-moz-user-select: none;-ms-user-select: none;user-select: none\"><strong>Realizar o meu cadastro</strong></button>\n"
                    + "                    </div>\n"
                    + "\n"
                    + "        </form></div>\n"
                    + "        <div class=\"col-md-4\" style=\"width: 66.333333%\"/>\n"
                    + "\n"
                    + "        <!-- CSS embutido in line -->\n"
                    + "\n"
                    + "        </body>\n"
                    + "</html>");

            emailHtml.setHtmlMsg(msg.toString());

            emailHtml.send();

        } catch (EmailException ex) {
            ex.printStackTrace();
        }

    }

    /*
    Teste de envio de email simples
    */
    
    public static void mandarEmail(String assunto, String mensagem) {
        emailSimples = new SimpleEmail();
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
