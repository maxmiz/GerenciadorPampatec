
package com.ideiah.gerenciadorpampatec.util;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import javax.servlet.http.Part;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Pedro
 */
public class EmailUtil {

    private static SimpleEmail emailSimples;
    private static MultiPartEmail emailAnexo;

    /**
     * Manda um email simples para a ideiah.
     *
     * @param assunto
     * @param mensagem
     */
    public static void mandarEmail(String assunto, String mensagem) {
        try {
            emailSimples = new SimpleEmail();
            emailSimples.setHostName("smtp.googlemail.com");
            emailSimples.setSmtpPort(465);
            emailSimples.setAuthenticator(new DefaultAuthenticator("contato@ideiah.com", "uniideiahpampa"));
            emailSimples.setSSLOnConnect(true);
            emailSimples.setFrom("contato@ideiah.com");
            emailSimples.setSubject("EMAIL DO SITE: " + assunto);
            emailSimples.setMsg(mensagem);
            emailSimples.addTo("contato@ideiah.com");
            emailSimples.send();
        } catch (EmailException ex) {
            ex.printStackTrace();
        }
    }
    
    public void mandarEmailCompletarCadastro(String assunto){
        //String idUnico = UUID.randomUUID().toString();
        String idUnico = "Oi";
        try {
            emailSimples = new SimpleEmail();
            emailSimples.setHostName("smtp.googlemail.com");
            emailSimples.setSmtpPort(465);
            emailSimples.setAuthenticator(new DefaultAuthenticator("contato@ideiah.com", "uniideiahpampa"));
            emailSimples.setSSLOnConnect(true);
            emailSimples.setFrom("contato@ideiah.com");
            emailSimples.setSubject("EMAIL DO SITE: " + assunto);
            emailSimples.setMsg("http://localhost:8084/GerenciadorPampatec/faces/view/terminarCadastroEmpreendedor.xhtml?id=" + idUnico);
            emailSimples.addTo("contato@ideiah.com");
            emailSimples.send();
        } catch (EmailException ex) {
            ex.printStackTrace();
        }
    }
}
