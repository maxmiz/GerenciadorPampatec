/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * <p>
 * Classe para implementação dos testes unitários da classe
 * <code>EmailUtil</code>.</p>
 *
 * @author unipampa
 */
public class EmailUtilTest {

    public EmailUtilTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of mandarEmailConcluirCadastro method, of class EmailUtil.
     * <p>
     * Teste para validar se o objeto da classe é gerado corretamente.</p>
     */
    @Test
    public void testMandarEmailConcluirCadastro() {
        System.out.println("mandarEmailConcluirCadastro");
        EmailUtil result = new EmailUtil();
        assertNotNull(result);
    }

    /**
     * Test of mandarEmailConcluirCadastro method, of class EmailUtil.
     * <p>
     * Teste para validar se o método evita o lançamento de
     * <code>nullPointerException</code>.</p>
     */
    @Test
    public void testMandarEmailConcluirCadastro2() {
        System.out.println("mandarEmailConcluirCadastro2");
        String empreendedorNome = null;
        String projetoNome = null;
        String email = null;
        String idUnico = null;
        EmailUtil.mandarEmailConcluirCadastro(empreendedorNome, projetoNome, email, idUnico);
    }

    /**
     * Test of mandarEmailConcluirCadastro method, of class EmailUtil.
     * <p>
     * Teste para validar se o método evita a tentativa de envio de email com
     * todos os campos vazios.</p>
     */
    @Test
    public void testMandarEmailConcluirCadastro3() {
        System.out.println("mandarEmailConcluirCadastro3");
        String empreendedorNome = "";
        String projetoNome = "";
        String email = "";
        String idUnico = "";
        EmailUtil.mandarEmailConcluirCadastro(empreendedorNome, projetoNome, email, idUnico);
    }

    /**
     * Test of enviarEmailRecuperarSenha method, of class EmailUtil.
     * <p>
     * Teste para validar se o método evita o lançamento de
     * <code>nullPointerException</code>.
     * </p>
     */
    @Test
    public void testEnviarEmailRecuperarSenha() {
        System.out.println("enviarEmailRecuperarSenha");
        String email = null;
        String idUnico = null;
        EmailUtil.enviarEmailRecuperarSenha(email, idUnico);
    }

    /**
     * Test of enviarEmailRecuperarSenha method, of class EmailUtil.
     * <p>
     * Teste para validar se o método evita a tentativa de envio de email com
     * todos os campos vazios.
     * </p>
     */
    @Test
    public void testEnviarEmailRecuperarSenha2() {
        System.out.println("enviarEmailRecuperarSenha2");
        String email = "";
        String idUnico = "";
        EmailUtil.enviarEmailRecuperarSenha(email, idUnico);
    }

    /**
     * Test of enviarEmailRecuperarSenha method, of class EmailUtil.
     * <p>
     * </p>
     */
    @Test
    public void testEnviarEmailRecuperarSenha3() {
        System.out.println("enviarEmailRecuperarSenha3");
        String email = "";
        String idUnico = "";
        EmailUtil.enviarEmailRecuperarSenha(email, idUnico);
    }

}