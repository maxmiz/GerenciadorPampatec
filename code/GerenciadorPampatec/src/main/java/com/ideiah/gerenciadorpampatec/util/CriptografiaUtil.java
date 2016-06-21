/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * Classe responsável por aplicar uma função Hash Criptográfica aos dados
 * sensíveis do usuário como modo de segurança dos mesmos. </p>
 *
 * @author AugustoCesar
 */
public final class CriptografiaUtil {

    public static String md5(String senha) {
        MessageDigest m;

        try {
            m = MessageDigest.getInstance("MD5");
            m.update(senha.getBytes(), 0, senha.length());
            BigInteger i = new BigInteger(1, m.digest());

//Formatando o resuldado em uma cadeia de 32 caracteres, completando com 0 caso falte 
            senha = String.format("%1$032X", i);

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erro: " + e);
            e.printStackTrace();
            return null;
        }
        return senha;
    }

}
