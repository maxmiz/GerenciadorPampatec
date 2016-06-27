/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.GerenteRelacionamento;
import javax.servlet.http.HttpSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author unipampa
 */
public class SystemAccessBeanTest {

    @Mock
    private HttpSession mockedSession;
    
    public SystemAccessBeanTest() {
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
     * Test of submit method, of class SystemAccessBean.
     */
    @Ignore
    public void testSubmit() {
        System.out.println("submit");
        SystemAccessBean instance = new SystemAccessBean();
        instance.submit();
    }

    /**
     * <p>Teste para verificar se texto inserido contem apenas números.</p>
     */
    @Test
    public void testSoContemNumeros() {
        System.out.println("soContemNumeros");
        String texto = "1234567890";
        boolean expResult = false;
        boolean result = SystemAccessBean.soContemNumeros(texto);
        assertNotSame(expResult, result);
    }

    /**
     * <p>Teste para verificar se o texto inserido contém letras.</p>
     */
    @Test
    public void testSoContemNumeros2() {
        System.out.println("soContemNumeros");
        String texto = "Teste com Letras";
        boolean expResult = false;
        boolean result = SystemAccessBean.soContemNumeros(texto);
        assertEquals(expResult, result);
    }    
    
    /**
     * <p>Teste para verificar se o método identifica e trata corretamente um texto nulo.</p>
     */
    @Test
    public void testSoContemNumeros3() {
        System.out.println("soContemNumeros");
        String texto = null;
        boolean expResult = false;
        boolean result = SystemAccessBean.soContemNumeros(texto);
        assertEquals(expResult, result);
    }      
    
    /**
     * Test of fazLogout method, of class SystemAccessBean.
     */
    @Ignore
    public void testFazLogout() {
        System.out.println("fazLogout");
        when(SessionManager.getCreateSession()).thenReturn(mockedSession);
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        mockedSession.setAttribute("gerente", gerente);
        SystemAccessBean.fazLogout();
    }

    /**
     * Test of recuperarSenha method, of class SystemAccessBean.
     */
    @Ignore
    public void testRecuperarSenha() {
        System.out.println("recuperarSenha");
        SystemAccessBean instance = new SystemAccessBean();
        instance.setEmailRecuperarSenha("vitor@gerente.com");
        instance.recuperarSenha();
    }

    /**
     * <p>Teste para verificar user vazio.</p>
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        SystemAccessBean instance = new SystemAccessBean();
        String expResult = "";
        instance.setUser(expResult);
        String result = instance.getUser();
        assertEquals(expResult, result);
    }
    
    /**
     * <p>Teste para user nulo</p>
     */
    @Test
    public void testGetUser2() {
        System.out.println("getUser");
        SystemAccessBean instance = new SystemAccessBean();
        String expResult = null;
        String result;
        result = instance.getUser();
        assertEquals(expResult, result);
    }
    

    /**
     * Test of setUser method, of class SystemAccessBean.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        String aUser = "";
        SystemAccessBean instance = new SystemAccessBean();
        instance.setUser(aUser);
    }

    /**
     * Test of getPassphrase method, of class SystemAccessBean.
     */
    @Test
    public void testGetPassphrase() {
        System.out.println("getPassphrase");
        SystemAccessBean instance = new SystemAccessBean();
        String expResult = "";
        instance.setPassphrase(expResult);        
        String result = instance.getPassphrase();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getPassphrase method, of class SystemAccessBean.
     */
    @Test
    public void testGetPassphrase2() {
        System.out.println("getPassphrase");
        SystemAccessBean instance = new SystemAccessBean();
        String expResult = null;
        String result = instance.getPassphrase();
        assertEquals(expResult, result);
    }
    

    /**
     * Test of setPassphrase method, of class SystemAccessBean.
     */
    @Test
    public void testSetPassphrase() {
        System.out.println("setPassphrase");
        String aSenha = "";
        SystemAccessBean instance = new SystemAccessBean();
        instance.setPassphrase(aSenha);
    }

    /**
     * Test of getNome method, of class SystemAccessBean.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        SystemAccessBean instance = new SystemAccessBean();
        String expResult = null;
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNome method, of class SystemAccessBean.
     */
    @Test
    public void testGetNome2() {
        System.out.println("getNome");
        SystemAccessBean instance = new SystemAccessBean();
        String expResult = "";
        instance.setNome(expResult);
        String result = instance.getNome();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setNome method, of class SystemAccessBean.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        SystemAccessBean instance = new SystemAccessBean();
        instance.setNome(nome);
    }

    /**
     * Test of getEmailRecuperarSenha method, of class SystemAccessBean.
     */
    @Test
    public void testGetEmailRecuperarSenha() {
        System.out.println("getEmailRecuperarSenha");
        SystemAccessBean instance = new SystemAccessBean();
        String expResult = "";
        String result = instance.getEmailRecuperarSenha();
        assertNotSame(expResult, result);
    }

    /**
     * Test of setEmailRecuperarSenha method, of class SystemAccessBean.
     */
    @Test
    public void testSetEmailRecuperarSenha() {
        System.out.println("setEmailRecuperarSenha");
        String emailRecuperarSenha = "";
        SystemAccessBean instance = new SystemAccessBean();
        instance.setEmailRecuperarSenha(emailRecuperarSenha);
    }

    /**
     * Test of verificaCadastroIncompleto method, of class SystemAccessBean.
     */
    @Test
    public void testVerificaCadastroIncompleto() {
        System.out.println("verificaCadastroIncompleto");
        SystemAccessBean instance = new SystemAccessBean();
        boolean expResult = false;
        boolean result = instance.verificaCadastroIncompleto();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of verificaCadastroIncompleto method, of class SystemAccessBean.
     */
    @Test
    public void testVerificaCadastroIncompleto2() {
        System.out.println("verificaCadastroIncompleto");
        SystemAccessBean instance = new SystemAccessBean();
        boolean expResult = true;
        instance.setCadastroIncompleto(true);
        boolean result;
        result = instance.verificaCadastroIncompleto();
        assertEquals(expResult, result);
    }    

    /**
     * Test of isCadastroIncompleto method, of class SystemAccessBean.
     */
    @Test
    public void testIsCadastroIncompleto() {
        System.out.println("isCadastroIncompleto");
        SystemAccessBean instance = new SystemAccessBean();
        boolean expResult = false;
        boolean result = instance.isCadastroIncompleto();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCadastroIncompleto method, of class SystemAccessBean.
     */
    @Test
    public void testSetCadastroIncompleto() {
        System.out.println("setCadastroIncompleto");
        boolean cadastroIncompleto = false;
        SystemAccessBean instance = new SystemAccessBean();
        instance.setCadastroIncompleto(cadastroIncompleto);
    }
}
