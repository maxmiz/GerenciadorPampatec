package com.ideiah.gerenciadorpampatec.util;

import com.ideiah.gerenciadorpampatec.controller.EmpreendedorBean;
import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import javax.servlet.http.Part;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Pedro
 */
public class EmailUtil {

    private static SimpleEmail emailSimples;
    private static HtmlEmail emailHtml;
    private static MultiPartEmail emailAnexo;

    /**
     * Manda um email simples para a ideiah.
     *
     * @param assunto
     * @param mensagem
     */
//    public static void mandarEmail(String assunto, String mensagem) {
//        try {
//            emailSimples = new SimpleEmail();
//            emailSimples.setHostName("smtp.googlemail.com");
//            emailSimples.setSmtpPort(465);
//            emailSimples.setAuthenticator(new DefaultAuthenticator("contato@ideiah.com", "uniideiahpampa"));
//            emailSimples.setSSLOnConnect(true);
//            emailSimples.setFrom("contato@ideiah.com");
//            emailSimples.setSubject("EMAIL DO SITE: " + assunto);
//            emailSimples.setMsg(mensagem);
//            emailSimples.addTo("contato@ideiah.com");
//            emailSimples.send();
//        } catch (EmailException ex) {
//            ex.printStackTrace();
//        }
//    }
    /**
     * Envio de email para concluir o cadastro
     */
    public static void mandarEmailConcluirCadastro(String empreendedorNome, String projetoNome, String email, String idUnico) {

        emailHtml = new HtmlEmail();
        try {
            emailHtml.setHostName("smtp.googlemail.com");
            emailHtml.setSmtpPort(465);
            emailHtml.setAuthenticator(new DefaultAuthenticator("contato@ideiah.com", "uniideiahpampa"));
            emailHtml.setSSLOnConnect(true);
            emailHtml.addTo(email);
            emailHtml.setFrom("contato@ideah.com", "Ideiah");
            emailHtml.setSubject("PampaTec - Gerenciador de Projetos");

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
                    + "            <h1 class=\"fonteBranca\">Concluir cadastro</h1>\n"
                    + "            <form class=\"form-horizontal\">\n"
                    + "                    <div class=\"form-group\" style=\"margin-bottom: 15px\">\n"
                    + "                        <a>Olá!</a><br/><br/><a>O empreendedor <strong>" + empreendedorNome + "</strong> adicionou você\n"
                    + "                        como sócio em seu novo projeto.\n"
                    + "                        <br/><br/>Para que você possa utilizar o Sistema de Gerenciamento de Projetos do \n"
                    + "                        PampaTec é necessário confirmar o seu e-mail e realizar o seu cadastro.\n"
                    + "                        <br/><br/>Para realizar o seu cadastro clique na opção abaixo.</a><br/><br/><a class=\"btn btn-success\" href=\"http://localhost:8084/GerenciadorPampatec/faces/terminarCadastroEmpreendedor.xhtml?id=" + idUnico + " \"  style=\"color: #fff;background-color: #3fb618;border-color: #3fb618;display: inline-block;margin-bottom: 0;font-weight: normal;text-align: center;vertical-align: middle;-ms-touch-action: manipulation;touch-action: manipulation;cursor: pointer;background-image: none;border: 1px solid transparent;white-space: nowrap;padding: 10px 18px;font-size: 15px;line-height: 1.428571;border-radius: 0;-webkit-user-select: none;-moz-user-select: none;-ms-user-select: none;user-select: none\"><strong>Realizar o meu cadastro</strong></a>\n"
                    + "                    </div>\n"
                    + "                     <div class=\"footer\" style=\"padding: 20px;text-align: center;border-top: 1px solid #e5e5e5\">\n"
                    + "                         <img src=\"http://i.imgur.com/4c1IDDR.jpg\" alt=\"Logotipo da Unipampa\" style=\"width:80px;height:45px;\"/>\n"
                    + "                         <img src=\"http://i.imgur.com/g9hBPAV.jpg\" alt=\"Logotipo do PampaTec\" style=\"width:80px;height:45px;\">\n"
                    + "                      </div>\n"
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

    /**
     * @param email
     * @param idUnico 
     */
    public static void enviarEmailRecuperarSenha(String email, String idUnico) {

        emailHtml = new HtmlEmail();
        try {
            emailHtml.setHostName("smtp.googlemail.com");
            emailHtml.setSmtpPort(465);
            emailHtml.setAuthenticator(new DefaultAuthenticator("contato@ideiah.com", "uniideiahpampa"));
            emailHtml.setSSLOnConnect(true);
            emailHtml.addTo(email);
            emailHtml.setFrom("contato@ideah.com", "Ideiah");
            emailHtml.setSubject("PampaTec - Gerenciador de Projetos");

            StringBuffer msg = new StringBuffer();

            msg.append("<html lang=\"pt-br\">\n"
                    + "  <head>\n"
                    + "    <meta charset=\"utf-8\"/>\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                    + "  </head>\n"
                    + "            <div class=\"col-md-4\"></div>-->\n"
                    + "  <body style=\"margin: 0;padding-top: 10px\"><div class=\"col-md-4\" style=\"width: 66.333333%\"/>\n"
                    + "    <div class=\"col-md-4 text-center well\" style=\"text-align: center;width: 66.333333%;min-height: 20px;padding: 19px;margin-bottom: 20px;background-color: #f5f5f5;border: 2px solid #3FB618;border-radius: 0;-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05)\">\n"
                    + "        <h1 class=\"fonteBranca\">Alterar Senha</h1>\n"
                    + "        <form class=\"form-horizontal\">\n"
                    + "            <div class=\"form-group\" style=\"margin-bottom: 15px\">\n"
                    + "                <a>Olá!</a><br/><br/><a>Verificamos que você esqueceu a sua senha. Por favor, <strong>clique na opção a baixo</strong> para redefinir uma nova senha e continuar.</a><br/><br/>\n"
                    + "                 <a class=\"btn btn-success focus\" href=\"http://localhost:8889/GerenciadorPampatec/faces/recuperarSenha.xhtml?id=" + idUnico + " \"  style=\"color: #fff;background-color: #3fb618;border-color: #3fb618;display: inline-block;margin-bottom: 0;font-weight: normal;text-align: center;vertical-align: middle;-ms-touch-action: manipulation;touch-action: manipulation;cursor: pointer;background-image: none;border: 1px solid transparent;white-space: nowrap;padding: 10px 18px;font-size: 15px;line-height: 1.428571;border-radius: 0;-webkit-user-select: none;-moz-user-select: none;-ms-user-select: none;user-select: none\"><strong>Redefinir minha senha</strong></a>\n"
                    + "                    </div>\n"
                    + "                     <div class=\"footer\" style=\"padding: 20px;text-align: center;border-top: 1px solid #e5e5e5\">\n"
                    + "                         <img src=\"http://i.imgur.com/4c1IDDR.jpg\" alt=\"Logotipo da Unipampa\" style=\"width:80px;height:45px;\"/>\n"
                    + "                         <img src=\"http://i.imgur.com/g9hBPAV.jpg\" alt=\"Logotipo do PampaTec\" style=\"width:80px;height:45px;\">\n"
                    + "                     </div>\n"
                    + "        </form></div>\n"
                    + "    <div class=\"col-md-4\" style=\"width: 66.333333%\"/>\n"
                    + "\n"
                    + "    </body>\n"
                    + "</html>");

            emailHtml.setHtmlMsg(msg.toString());

            emailHtml.send();

        } catch (EmailException ex) {
            ex.printStackTrace();
        }
    }

}
