/**
 *
 */
package com.ideiah.gerenciadorpampatec.util;

import com.ideiah.gerenciadorpampatec.dao.EmailDao;
import com.ideiah.gerenciadorpampatec.model.EmailSystemConfig;
import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 * <p>
 * Classe responsável por gerenciar o envio de emails no sistema.
 * </p>
 *
 * @author Pedro
 */
public class EmailUtil {

    private static SimpleEmail emailSimples;
    private static HtmlEmail emailHtml;
    private static MultiPartEmail emailAnexo;

    /**
     * Variáveis para manipular o email do sistema.
     */
    private static String authEmail;
    private static String authPassphrase;

    public EmailUtil() {
    }

    /**
     * <P>
     * Método responsável por enviar email ao empreendedor quando o projeto
     * associado a ele foi avaliado.</P>
     *
     * @param empreendedor
     * @param projetoNome
     * 
     */
    public synchronized static void mandarEmailAvaliacao(Empreendedor empreendedor,
            String projetoNome) {

        if (empreendedor != null
                && projetoNome != null) {
            if (!empreendedor.getEmail().isEmpty()
                    && !empreendedor.getNome().isEmpty()
                    && !projetoNome.isEmpty()) {

                emailHtml = new HtmlEmail();
                try {
                    emailHtml.setHostName("smtp.googlemail.com");
                    emailHtml.setSmtpPort(465);
                    emailHtml.setAuthenticator(
                            new DefaultAuthenticator(getAuthEmail(), getAuthPassphrase())
                    );
                    emailHtml.setSSLOnConnect(true);
                    emailHtml.addTo(empreendedor.getEmail());
                    emailHtml.setFrom(getAuthEmail(), "Ideiah Developer");
                    emailHtml.setSubject("PampaTec - Gerenciador de Projetos");

                    StringBuffer msg = new StringBuffer();

                    // <editor-fold defaultstate="collapsed" desc="Mensagem do Email"> 
                    msg.append("<!DOCTYPE html>\n"
                            + "<html lang=\"pt-br\">\n"
                            + "	<head>\n"
                            + "		<meta charset=\"utf-8\"/>\n"
                            + "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                            + "    </head>\n"
                            + "    <body style=\"margin: 0;padding-top: 10px;\">                    \n"
                            + "		<div style=\"width: 15%;\"></div>\n"
                            + "		<div style=\"text-align: center; width: 70%; min-height: 20px; padding: 19px; margin-bottom: 20px; background-color: #f5f5f5; border: 2px solid #3FB618; border-radius: 0; -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05); box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);\">\n"
                            + "			<h1>Boas notícias!</h1>\n"
                            + "			<form>\n"
                            + "				<div style=\"margin-bottom: 15px;\">\n"
                            + "					<a>Olá <strong>" + empreendedor.getNome() + "</strong>! Notificamos que o projeto <strong><i>" + projetoNome + "</i></strong> foi pré-avaliado e está a sua disposição.\n"
                            + "							<br/>\n"
                            + "							<br/>Para acessar o sistema gerenciador de projetos, clique na opção abaixo.</a>\n"
                            + "							<br/>\n"
                            + "							<br/>\n"
                            + "							<a style=\"display: inline-block; margin-bottom: 0; font-weight: normal; text-align: center; "
                            + "                                                 vertical-align: middle; -ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; "
                            + "                                                 background-image: none; border: 1px solid transparent; white-space: nowrap; padding: 10px 18px; font-size: 15px; "
                            + "                                                 line-height: 1.42857143; border-radius: 0; -webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; "
                            + "                                                 user-select: none; color: #ffffff; background-color: #3fb618; border-color: #3fb618;\" "
                            + "                                                 href=\"http://localhost:8080/GerenciadorPampatec\">\n"
                            + "								<strong>Acessar o sistema</strong>\n"
                            + "							</a>\n"
                            + "				</div>\n"
                            + "			</form>\n"
                            + "			<div style=\"padding: 10px; overflow: auto; border-top: 1px solid #e5e5e5;\">\n"
                            + "				<img src=\"http://i.imgur.com/4c1IDDR.jpg\" alt=\"Logotipo da Unipampa\" style=\"width: 100px;height: 65px;float: left;\"/>\n"
                            + "				\n"
                            + "				<img src=\"http://i.imgur.com/g9hBPAV.jpg\" alt=\"Logotipo do PampaTec\" style=\"width: 100px;height: 65px;float: right;\"/> \n"
                            + "			</div>\n"
                            + "		</div>\n"
                            + "		<div style=\"width: 15%;\"></div>\n"
                            + "		<!-- CSS embutido in line -->               \n"
                            + "    </body>\n"
                            + "</html>");
                    // </editor-fold>

                    emailHtml.setHtmlMsg(msg.toString());

                    emailHtml.send();

                } catch (EmailException ex) {
                    Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * <P>
     * Método responsável por enviar email à todos os GERENTES quando um projeto
     * é submetido, ressubmetido e etc.</P>
     *
     * @param listaDeGerentes
     * @param statusProjeto
     * @param projetoNome
     */
    public synchronized static void enviaEmailParaGerentes(String projetoNome,
            String statusProjeto, ArrayList<GerenteRelacionamento> listaDeGerentes) {

        if (projetoNome != null && listaDeGerentes != null) {
            if (!projetoNome.isEmpty() && !listaDeGerentes.isEmpty()) {

                for (int i = 0; i < listaDeGerentes.size(); i++) {

                    emailHtml = new HtmlEmail();
                    try {
                        emailHtml.setHostName("smtp.googlemail.com");
                        emailHtml.setSmtpPort(465);
                        emailHtml.setAuthenticator(
                                new DefaultAuthenticator(getAuthEmail(), getAuthPassphrase())
                        );
                        emailHtml.setSSLOnConnect(true);
                        emailHtml.addTo(listaDeGerentes.get(i).getEmail());
                        emailHtml.setFrom(getAuthEmail(), "Ideiah Developer");
                        emailHtml.setSubject("PampaTec - Gerenciador de Projetos");

                        StringBuffer msg = new StringBuffer();

                        // <editor-fold defaultstate="collapsed" desc="Mensagem do Email"> 
                        msg.append("<!DOCTYPE html>\n"
                                + "<html lang=\"pt-br\">\n"
                                + "	<head>\n"
                                + "		<meta charset=\"utf-8\"/>\n"
                                + "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                                + "    </head>\n"
                                + "    <body style=\"margin: 0;padding-top: 10px;\">                    \n"
                                + "		<div style=\"width: 15%;\"></div>\n"
                                + "		<div style=\"text-align: center; width: 70%; min-height: 20px; padding: 19px; margin-bottom: 20px; background-color: #f5f5f5; border: 2px solid #3FB618; border-radius: 0; -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05); box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);\">\n"
                                + "			<h1>Plano de negócio disponível para avaliação!</h1>\n"
                                + "			<form>\n"
                                + "				<div style=\"margin-bottom: 15px;\">\n"
                                + "					<a>Olá <strong>" + listaDeGerentes.get(i).getNome() + "</strong>! Notificamos que Plano de Negócio chamado <strong><i>" + projetoNome + "</i></strong> atualizou seu status para " + statusProjeto + ".\n"
                                + "							<br/>\n"
                                + "							<br/>Para acessar o sistema Gerenciador Pampatec, clique na opção abaixo.</a>\n"
                                + "							<br/>\n"
                                + "							<br/>\n"
                                + "							<a style=\"display: inline-block; margin-bottom: 0; font-weight: normal; text-align: center; "
                                + "                                                     vertical-align: middle; -ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; "
                                + "                                                     background-image: none; border: 1px solid transparent; white-space: nowrap; padding: 10px 18px; font-size: 15px; "
                                + "                                                     line-height: 1.42857143; border-radius: 0; -webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; "
                                + "                                                     user-select: none; color: #ffffff; background-color: #3fb618; border-color: #3fb618;\" "
                                + "                                                     href=\"http://localhost:8080/GerenciadorPampatec\">\n"
                                + "								<strong>Acessar o sistema</strong>\n"
                                + "							</a>\n"
                                + "				</div>\n"
                                + "			</form>\n"
                                + "			<div style=\"padding: 10px; overflow: auto; border-top: 1px solid #e5e5e5;\">\n"
                                + "				<img src=\"http://i.imgur.com/4c1IDDR.jpg\" alt=\"Logotipo da Unipampa\" style=\"width: 100px;height: 65px;float: left;\"/>\n"
                                + "				\n"
                                + "				<img src=\"http://i.imgur.com/g9hBPAV.jpg\" alt=\"Logotipo do PampaTec\" style=\"width: 100px;height: 65px;float: right;\"/> \n"
                                + "			</div>\n"
                                + "		</div>\n"
                                + "		<div style=\"width: 15%;\"></div>\n"
                                + "		<!-- CSS embutido in line -->               \n"
                                + "    </body>\n"
                                + "</html>");
                        // </editor-fold>

                        emailHtml.setHtmlMsg(msg.toString());

                        emailHtml.send();

                    } catch (EmailException ex) {
                        Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
    }

    /**
     * <p>
     * Envio de email para empreendedor após avaliar plano.
     * </p>
     *
     * @param email
     * @param idUnico
     */
    public static void enviarEmailRecuperarSenha(String email, String idUnico) {
        if (email != null && idUnico != null) {
            if (!email.isEmpty() && !idUnico.isEmpty()) {

                emailHtml = new HtmlEmail();
                try {
                    emailHtml.setHostName("smtp.googlemail.com");
                    emailHtml.setSmtpPort(465);
                    emailHtml.setAuthenticator(
                            new DefaultAuthenticator(getAuthEmail(), getAuthPassphrase())
                    );
                    emailHtml.setSSLOnConnect(true);
                    emailHtml.addTo(email);
                    emailHtml.setFrom(getAuthEmail(), "Ideiah Developer");
                    emailHtml.setSubject("PampaTec - Gerenciador de Projetos");

                    StringBuffer msg = new StringBuffer();

                    // <editor-fold defaultstate="collapsed" desc="Mensagem do Email">
                    msg.append("<html lang=\"pt-br\">\n"
                            + "  <head>\n"
                            + "    <meta charset=\"utf-8\"/>\n"
                            + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                            + "  </head>\n"
                            + "            <div class=\"col-md-4\"></div>\n"
                            + "  <body style=\"margin: 0;padding-top: 10px\"><div class=\"col-md-4\" style=\"width: 66.333333%\"/>\n"
                            + "    <div class=\"col-md-4 text-center well\" style=\"text-align: center;width: 66.333333%;min-height: 20px;padding: 19px;margin-bottom: 20px;background-color: #f5f5f5;border: 2px solid #3FB618;border-radius: 0;-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05)\">\n"
                            + "        <h1 class=\"fonteBranca\">Alterar Senha</h1>\n"
                            + "        <form class=\"form-horizontal\">\n"
                            + "            <div class=\"form-group\" style=\"margin-bottom: 15px\">\n"
                            + "                <a>Olá!</a><br/><br/><a>Verificamos que você esqueceu a sua senha. Por favor, <strong>clique na opção a baixo</strong> para redefinir uma nova senha e continuar.</a><br/><br/>\n"
                            + "                 <a class=\"btn btn-success focus\" href=\"http://localhost:8080/GerenciadorPampatec/recuperarSenha.jsf?id=" + idUnico + " \"  style=\"color: #fff;background-color: #3fb618;border-color: #3fb618;display: inline-block;margin-bottom: 0;font-weight: normal;text-align: center;vertical-align: middle;-ms-touch-action: manipulation;touch-action: manipulation;cursor: pointer;background-image: none;border: 1px solid transparent;white-space: nowrap;padding: 10px 18px;font-size: 15px;line-height: 1.428571;border-radius: 0;-webkit-user-select: none;-moz-user-select: none;-ms-user-select: none;user-select: none\"><strong>Redefinir minha senha</strong></a>\n"
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
                    // </editor-fold>

                    emailHtml.setHtmlMsg(msg.toString());

                    emailHtml.send();

                } catch (EmailException ex) {
                    Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * <p>
     * Envio de email para concluir o cadastro.</p>
     *
     * @param empreendedorNome
     * @param projetoNome
     * @param email
     * @param idUnico
     */
    public static void mandarEmailConcluirCadastro(String empreendedorNome,
            String projetoNome, String email, String idUnico) {
        if (empreendedorNome != null && projetoNome != null && email != null && idUnico != null) {
            if (!empreendedorNome.isEmpty() && !projetoNome.isEmpty() && !email.isEmpty() && !idUnico.isEmpty()) {

                emailHtml = new HtmlEmail();
                try {
                    emailHtml.setHostName("smtp.googlemail.com");
                    emailHtml.setSmtpPort(465);
                    emailHtml.setAuthenticator(
                            new DefaultAuthenticator(getAuthEmail(), getAuthPassphrase())
                    );
                    emailHtml.setSSLOnConnect(true);
                    emailHtml.addTo(email);
                    emailHtml.setFrom(getAuthEmail(), "Ideiah Developer");
                    emailHtml.setSubject("PampaTec - Gerenciador de Projetos");

                    StringBuffer msg = new StringBuffer();

                    // <editor-fold defaultstate="collapsed" desc="Mensagem do Email">
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
                            + "                        <br/><br/>Para realizar o seu cadastro clique na opção abaixo.</a><br/><br/><a class=\"btn btn-success\" href=\"http://localhost:8080/GerenciadorPampatec/terminarCadastroEmpreendedor.jsf?id=" + idUnico + " \"  style=\"color: #fff;background-color: #3fb618;border-color: #3fb618;display: inline-block;margin-bottom: 0;font-weight: normal;text-align: center;vertical-align: middle;-ms-touch-action: manipulation;touch-action: manipulation;cursor: pointer;background-image: none;border: 1px solid transparent;white-space: nowrap;padding: 10px 18px;font-size: 15px;line-height: 1.428571;border-radius: 0;-webkit-user-select: none;-moz-user-select: none;-ms-user-select: none;user-select: none\"><strong>Realizar o meu cadastro</strong></a>\n"
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
                    // </editor-fold>

                    emailHtml.setHtmlMsg(msg.toString());

                    emailHtml.send();

                } catch (EmailException ex) {
                    Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    /**
     * <p>
     * Envio de email para confirmacao de email.</p>
     *
     * @param empreendedorNome
     * @param email
     * @param idUnico
     */
    public static void mandarEmailConfirmacao(String empreendedorNome,
            String email, String idUnico) {
        if (empreendedorNome != null && email != null && idUnico != null) {
            if (!empreendedorNome.isEmpty() && !email.isEmpty() && !idUnico.isEmpty()) {

                emailHtml = new HtmlEmail();
                try {
                    emailHtml.setHostName("smtp.googlemail.com");
                    emailHtml.setSmtpPort(465);
                    emailHtml.setAuthenticator(
                            new DefaultAuthenticator(getAuthEmail(), getAuthPassphrase())
                    );
                    emailHtml.setSSLOnConnect(true);
                    emailHtml.addTo(email);
                    emailHtml.setFrom(getAuthEmail(), "Ideiah Developer");
                    emailHtml.setSubject("PampaTec - Gerenciador de Projetos");

                    StringBuffer msg = new StringBuffer();

                    // <editor-fold defaultstate="collapsed" desc="Mensagem do Email">
                    msg.append("<html lang=\"pt-br\">\n"
                            + "  <head>\n"
                            + "    <meta charset=\"utf-8\"/>\n"
                            + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                            + "  </head>\n"
                            + "  <body background=\"resources/imagens/21.jpg\" style=\"margin: 0;padding-top: 10px\">\n"
                            + "\n"
                            + "        <div class=\"col-md-4\" style=\"width: 66.333333%\"/>\n"
                            + "        <div class=\"col-md-4 text-center well\" style=\"text-align: center;width: 66.333333%;min-height: 20px;padding: 19px;margin-bottom: 20px;background-color: #f5f5f5;border: 2px solid #3FB618;border-radius: 0;-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05)\">\n"
                            + "            <h1 class=\"fonteBranca\">Confirmar email</h1>\n"
                            + "            <form class=\"form-horizontal\">\n"
                            + "                    <div class=\"form-group\" style=\"margin-bottom: 15px\">\n"
                            + "                        <a>Olá, " + empreendedorNome + "!</a><br/><br/>"
                            + "                        Você se cadastrou no Sistema de gerenciamento de projetos do PampaTec, mas nós ainda precisamos verificar seu e-mail.\n"
                            + "                        <br/><br/>Para confirmar o seu email clique na opção abaixo.</a><br/><br/><a class=\"btn btn-success\" href=\"http://localhost:8080/GerenciadorPampatec/verificarEmail.jsf?id=" + idUnico + " \"  style=\"color: #fff;background-color: #3fb618;border-color: #3fb618;display: inline-block;margin-bottom: 0;font-weight: normal;text-align: center;vertical-align: middle;-ms-touch-action: manipulation;touch-action: manipulation;cursor: pointer;background-image: none;border: 1px solid transparent;white-space: nowrap;padding: 10px 18px;font-size: 15px;line-height: 1.428571;border-radius: 0;-webkit-user-select: none;-moz-user-select: none;-ms-user-select: none;user-select: none\"><strong>Confirmar o email</strong></a>\n"
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
                    // </editor-fold>

                    emailHtml.setHtmlMsg(msg.toString());

                    emailHtml.send();

                } catch (EmailException ex) {
                    Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * <p>
     * Método para recuperar o email que o sistema utilizará para enviar
     * notificações.</p>
     *
     * @return o email do sistema do tipo <code>String</code>.
     */
    private static String getAuthEmail() {
        EmailDao emailDao = new EmailDao();
        ArrayList<EmailSystemConfig> buscarTodosEmailsSystema;
        buscarTodosEmailsSystema = emailDao.buscarTodosEmailsSystema();

        for (EmailSystemConfig emailSystemConfig : buscarTodosEmailsSystema) {
            authEmail = emailSystemConfig.getEmail();
            break;
        }
        return authEmail;
    }

    /**
     * <p>
     * Método para recuperar a senha do email que o sistema utilizará para
     * enviar notificações.</p>
     *
     * @return a senha do email do sistema do tipo <code>String</code>.
     */
    private static String getAuthPassphrase() {
        EmailDao emailDao = new EmailDao();
        ArrayList<EmailSystemConfig> buscarTodosEmailsSystema;
        buscarTodosEmailsSystema = emailDao.buscarTodosEmailsSystema();

        for (EmailSystemConfig emailSystemConfig : buscarTodosEmailsSystema) {
            authPassphrase = emailSystemConfig.getPassphrase();
            break;
        }
        return authPassphrase;
    }
}
