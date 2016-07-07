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
    @Ignore
    public void testRetornaNomeLogado() {
        System.out.println("retornaNomeLogado");
        UserBean instance = new UserBean();
        String expResult = "";
        String result = instance.retornaNomeLogado();
        assertEquals(expResult, result);
    }

    /**
     * Test of tempoMaximoSessao method, of class UserBean.
     */
    @Ignore
    public void testTempoMaximoSessao() {
        System.out.println("tempoMaximoSessao");
        UserBean instance = new UserBean();
        int expResult = 0;
        int result = instance.tempoMaximoSessao();
        assertEquals(expResult, result);
    }

    /**
     * Test of finalizaSessao method, of class UserBean.
     */
    @Test
    public void testFinalizaSessao() {
        System.out.println("finalizaSessao");
        UserBean instance = new UserBean();
        instance.finalizaSessao();
    }

    /**
     * Test of MudarUser method, of class UserBean.
     */
    @Test
    public void testMudarUser() {
        System.out.println("MudarUser");
        String user = "";
        UserBean.MudarUser(user);
    }

    /**
     * Test of MudarSenha method, of class UserBean.
     */
    @Test
    public void testMudarSenha() {
        System.out.println("MudarSenha");
        String senha = "";
        UserBean.MudarSenha(senha);
    }

    /**
     * Test of getNome method, of class UserBean.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        UserBean instance = new UserBean();
        String expResult = "";
        instance.setNome(expResult);
        String result = instance.getNome();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of getUser method, of class UserBean.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        UserBean instance = new UserBean();
        String expResult = "";
        instance.setUser(expResult);
        String result = instance.getUser();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of getSenha method, of class UserBean.
     */
    @Test
    public void testGetSenha() {
        System.out.println("getSenha");
        UserBean instance = new UserBean();
        String expResult = "";
        instance.setSenha(expResult);
        String result = instance.getSenha();
        assertEquals(expResult, result);
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
    }
}