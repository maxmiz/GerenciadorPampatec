/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.util;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import java.util.ArrayList;
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
        Empreendedor empreendedor = new Empreendedor();
        empreendedor.setNome(null);
        empreendedor.setEmail(null);
        String projetoNome = null;

        EmailUtil.mandarEmailAvaliacao(empreendedor, projetoNome);
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
        Empreendedor empreendedor = new Empreendedor();
        empreendedor.setNome("");
        empreendedor.setEmail("");
        String projetoNome = "";

        EmailUtil.mandarEmailAvaliacao(empreendedor, projetoNome);
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
        Empreendedor empreendedor = new Empreendedor();
        empreendedor.setNome("Dev Empreendedor");
        empreendedor.setEmail("ideiahdev@gmail.com");
        String projetoNome = "Ideiah Dev Testes";

        EmailUtil.mandarEmailAvaliacao(empreendedor, projetoNome);
    }

    /**
     * Test of mandarEmailAvaliacao method, of class EmailUtil.
     * <p>
     * Teste para verificar o envio de email para um endereço inexistente.</p>
     */
    @Ignore
    public void testMandarEmailAvaliacao4() {
        System.out.println("mandarEmailAvaliacao");
        Empreendedor empreendedor = new Empreendedor();
        empreendedor.setNome("Dev Empreendedor");
        empreendedor.setEmail("vitor@gerente.com");
        String projetoNome = "Ideiah Dev Testes";
        EmailUtil.mandarEmailAvaliacao(empreendedor, projetoNome);
    }

    /**
     * Test of enviaEmailParaGerentes method, of class EmailUtil.
     */
    @Test
    public void testEnviaEmailParaGerentes() {
        System.out.println("enviaEmailParaGerentes");
        String projetoNome = null;
        String statusProjeto = null;
        ArrayList<GerenteRelacionamento> listaDeGerentes = new ArrayList<>();
        EmailUtil.enviaEmailParaGerentes(projetoNome, statusProjeto, listaDeGerentes);
    }

    /**
     * Test of enviaEmailParaGerentes method, of class EmailUtil.
     */
    @Test
    public void testEnviaEmailParaGerentes2() {
        System.out.println("enviaEmailParaGerentes2");
        String projetoNome = "";
        String statusProjeto = "";
        ArrayList<GerenteRelacionamento> listaDeGerentes = new ArrayList<>();
        EmailUtil.enviaEmailParaGerentes(projetoNome, statusProjeto, listaDeGerentes);
    }

    /**
     * Test of enviaEmailParaGerentes method, of class EmailUtil.
     */
    @Ignore
    public void testEnviaEmailParaGerentes3() {
        System.out.println("enviaEmailParaGerentes3");
        String projetoNome = "Ideiah Dev Testes";
        String statusProjeto = "Aceito para Avaliação";

        ArrayList<GerenteRelacionamento> listaDeGerentes = new ArrayList<>();
        GerenteRelacionamento gr = new GerenteRelacionamento();
        GerenteRelacionamento gr2 = new GerenteRelacionamento();
        GerenteRelacionamento gr3 = new GerenteRelacionamento();

        gr.setEmail("teste1@gerente.com");
        gr.setNome("Gerente Teste 01");
        gr2.setEmail("teste2@gerente.com");
        gr2.setNome("Gerente Teste 02");
        gr3.setEmail("teste3@gerente.com");
        gr3.setNome("Gerente Teste 03");

        listaDeGerentes.add(gr);
        listaDeGerentes.add(gr2);
        listaDeGerentes.add(gr3);

        EmailUtil.enviaEmailParaGerentes(projetoNome,
                statusProjeto, listaDeGerentes);
    }

}
