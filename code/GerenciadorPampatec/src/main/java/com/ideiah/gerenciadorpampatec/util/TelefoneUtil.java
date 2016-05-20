package com.ideiah.gerenciadorpampatec.util;

public class TelefoneUtil {

    public static String removeParentesesTelefone(String telefone) {
        String numero = "";
        for (int i = 0; i < telefone.length(); i++) {
           if(Character.isDigit(telefone.charAt( i ))){
          numero = numero.concat(String.valueOf(telefone.charAt( i )));
           }  
        }
        return numero;
    }
}
