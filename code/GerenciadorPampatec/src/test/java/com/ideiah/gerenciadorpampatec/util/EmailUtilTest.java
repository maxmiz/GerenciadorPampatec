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
import org.junit.Ignore;

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
    public void testConstrutorEmailUtil() {
        System.out.println("testConstrutorEmailUtil");
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
    public void testMandarEmailConcluirCadastro() {
        System.out.println("mandarEmailConcluirCadastro_Null");
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
    public void testMandarEmailConcluirCadastro2() {
        System.out.println("mandarEmailConcluirCadastro_StringVazia");
        String empreendedorNome = "";
        String projetoNome = "";
        String email = "";
        String idUnico = "";
        EmailUtil.mandarEmailConcluirCadastro(empreendedorNome, projetoNome, email, idUnico);
    }

    /**
     * Test of mandarEmailConcluirCadastro method, of class EmailUtil.
     * <p>
     * Teste para validar o envio de emails para conclusão do cadastro.</p>
     */
    @Ignore
    public void testMandarEmailConcluirCadastro3() {
        System.out.println("mandarEmailConcluirCadastro_EnvioEmail");
        String empreendedorNome = "Ideiah Dev Tests";
        String projetoNome = "Projeto Email Teste";
        String email = "ideiahdev@gmail.com";
        String idUnico = "2";
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
        System.out.println("enviarEmailRecuperarSenha_Null");
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
        System.out.println("enviarEmailRecuperarSenha_StringVazia");
        String email = "";
        String idUnico = "";
        EmailUtil.enviarEmailRecuperarSenha(email, idUnico);
    }

    /**
     * Test of enviarEmailRecuperarSenha method, of class EmailUtil.
     * <p>
     * Teste para validar o envio de email para recuperação de senha.
     * </p>
     */
    @Ignore
    public void testEnviarEmailRecuperarSenha3() {
        System.out.println("enviarEmailRecuperarSenha_EnvioEmail");
        String email = "ideiahdev@gmail.com";
        String idUnico = "1";
        EmailUtil.enviarEmailRecuperarSenha(email, idUnico);
    }

    /**
     * Test of mandarEmailAvaliacao method, of class EmailUtil.
     * <p>
     * Teste para validar se o método evita o lançamento de
     * <code>nullPointerException</code>.</p>
     */
    @Test
    public void testMandarEmailAvaliacao() {
        System.out.println("mandarEmailAvaliacao_Null");
        String empreendedorNome = null;
        String projetoNome = null;
        String email = null;
        EmailUtil.mandarEmailAvaliacao(empreendedorNome, projetoNome, email);
    }

    /**
     * Test of mandarEmailAvaliacao method, of class EmailUtil.
     * <p>
     * Teste para validar se o método evita a tentativa de envio de email com
     * todos os campos vazios.</p>
     */
    @Test
    public void testMandarEmailAvaliacao2() {
        System.out.println("mandarEmailAvaliacao_StringVazia");
        String empreendedorNome = "";
        String projetoNome = "";
        String email = "";
        EmailUtil.mandarEmailAvaliacao(empreendedorNome, projetoNome, email);
    }

    /**
     * Test of mandarEmailAvaliacao method, of class EmailUtil.
     * <p>
     * Teste para verificar o correto funcionamento do método que envia email
     * após um plano de negócio ser Avaliado.</p>
     */
    @Ignore
    public void testMandarEmailAvaliacao3() {
        System.out.println("mandarEmailAvaliacao");
        String empreendedorNome = "Dev Empreendedor";
        String projetoNome = "Ideiah Dev Testes";
        String email = "ideiahdev@gmail.com";
        EmailUtil.mandarEmailAvaliacao(empreendedorNome, projetoNome, email);
    }

}
