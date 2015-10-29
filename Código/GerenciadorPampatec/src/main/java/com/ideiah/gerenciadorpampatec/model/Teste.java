/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import com.ideiah.gerenciadorpampatec.dao.EmpreendedorDao;
import com.ideiah.gerenciadorpampatec.util.EmailUtil;
import java.util.ArrayList;
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
        EmpreendedorDao dao = new EmpreendedorDao();
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) dao.buscarObjetos(Usuario.class);
        System.out.println("sdadasdasdsadasdas");
        for (Usuario usuario : usuarios) {
            System.out.println("Usuaaaaario = " + usuario);
        }

    }

    /*
     * Testes de envio de cod html via emaail
     */
}
