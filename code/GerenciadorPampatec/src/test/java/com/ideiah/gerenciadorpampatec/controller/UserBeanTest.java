/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author unipampa
 */
@Ignore
public class UserBeanTest {
    
    public UserBeanTest() {
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
     * Test of retornaNomeLogado method, of class UserBean.
     */
    @Test
    public void testRetornaNomeLogado() {
        System.out.println("retornaNomeLogado");
        UserBean instance = new UserBean();
        String expResult = "";
        String result = instance.retornaNomeLogado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tempoMaximoSessao method, of class UserBean.
     */
    @Test
    public void testTempoMaximoSessao() {
        System.out.println("tempoMaximoSessao");
        UserBean instance = new UserBean();
        int expResult = 0;
        int result = instance.tempoMaximoSessao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finalizaSessao method, of class UserBean.
     */
    @Test
    public void testFinalizaSessao() {
        System.out.println("finalizaSessao");
        UserBean instance = new UserBean();
        instance.finalizaSessao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MudarUser method, of class UserBean.
     */
    @Test
    public void testMudarUser() {
        System.out.println("MudarUser");
        String user = "";
        UserBean.MudarUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MudarSenha method, of class UserBean.
     */
    @Test
    public void testMudarSenha() {
        System.out.println("MudarSenha");
        String senha = "";
        UserBean.MudarSenha(senha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class UserBean.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        UserBean instance = new UserBean();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class UserBean.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        String user = "";
        UserBean instance = new UserBean();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class UserBean.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        UserBean instance = new UserBean();
        String expResult = "";
        String result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MudarNome method, of class UserBean.
     */
    @Test
    public void testMudarNome() {
        System.out.println("MudarNome");
        String nome = "";
        UserBean instance = new UserBean();
        instance.MudarNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSenha method, of class UserBean.
     */
    @Test
    public void testGetSenha() {
        System.out.println("getSenha");
        UserBean instance = new UserBean();
        String expResult = "";
        String result = instance.getSenha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSenha method, of class UserBean.
     */
    @Test
    public void testSetSenha() {
        System.out.println("setSenha");
        String senha = "";
        UserBean instance = new UserBean();
        instance.setSenha(senha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class UserBean.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        UserBean instance = new UserBean();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
