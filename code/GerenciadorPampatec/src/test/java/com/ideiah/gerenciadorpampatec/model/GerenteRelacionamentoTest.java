/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import com.ideiah.gerenciadorpampatec.dao.GerenteDao;
import java.util.Set;
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
public class GerenteRelacionamentoTest {

    public GerenteRelacionamentoTest() {
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
     * Test of getIdgerente_relacionamento method, of class
     * GerenteRelacionamento.
     */
    @Test
    public void testConstrutorGerenteRelacionamento() {
        System.out.println("getIdgerente_relacionamento");
        int idgerente_relacionamento = 0;
        String senha = "";
        String nome = "";
        String email = "";
        String cpf = "";
        GerenteRelacionamento instance = new GerenteRelacionamento(idgerente_relacionamento,
                senha, nome, email, cpf);
        assertNotNull(instance);
    }

    /**
     * Test of getGerenteDao method, of class GerenteRelacionamento.
     */
    @Ignore
    public void testGetGerenteDao() {
        System.out.println("getGerenteDao");
        GerenteDao expResult = null;
        GerenteDao result = GerenteRelacionamento.getGerenteDao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdgerente_relacionamento method, of class
     * GerenteRelacionamento.
     */
    @Test
    public void testGetIdgerente_relacionamento() {
        System.out.println("getIdgerente_relacionamento");
        GerenteRelacionamento instance = new GerenteRelacionamento();
        int expResult = 0;
        instance.setIdgerente_relacionamento(expResult);
        int result = instance.getIdgerente_relacionamento();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdgerente_relacionamento method, of class
     * GerenteRelacionamento.
     */
    @Test
    public void testSetIdgerente_relacionamento() {
        System.out.println("setIdgerente_relacionamento");
        int idgerente_relacionamento = 0;
        GerenteRelacionamento instance = new GerenteRelacionamento();
        instance.setIdgerente_relacionamento(idgerente_relacionamento);
    }

    /**
     * Test of getSenha method, of class GerenteRelacionamento.
     */
    @Test
    public void testGetSenha() {
        System.out.println("getSenha");
        GerenteRelacionamento instance = new GerenteRelacionamento();
        String expResult = "";
        instance.setSenha(expResult);
        String result = instance.getSenha();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSenha method, of class GerenteRelacionamento.
     */
    @Test
    public void testSetSenha() {
        System.out.println("setSenha");
        String senha = "";
        GerenteRelacionamento instance = new GerenteRelacionamento();
        instance.setSenha(senha);
    }

    /**
     * Test of getNome method, of class GerenteRelacionamento.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        GerenteRelacionamento instance = new GerenteRelacionamento();
        String expResult = "";
        instance.setNome(expResult);
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class GerenteRelacionamento.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        GerenteRelacionamento instance = new GerenteRelacionamento();
        instance.setNome(nome);
    }

    /**
     * Test of getEmail method, of class GerenteRelacionamento.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        GerenteRelacionamento instance = new GerenteRelacionamento();
        String expResult = "";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class GerenteRelacionamento.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        GerenteRelacionamento instance = new GerenteRelacionamento();
        instance.setEmail(email);
    }

    /**
     * Test of getCpf method, of class GerenteRelacionamento.
     */
    @Test
    public void testGetCpf() {
        System.out.println("getCpf");
        GerenteRelacionamento instance = new GerenteRelacionamento();
        String expResult = "";
        instance.setCpf(expResult);
        String result = instance.getCpf();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCpf method, of class GerenteRelacionamento.
     */
    @Test
    public void testSetCpf() {
        System.out.println("setCpf");
        String cpf = "";
        GerenteRelacionamento instance = new GerenteRelacionamento();
        instance.setCpf(cpf);
    }

    /**
     * Test of getProjetos method, of class GerenteRelacionamento.
     */
    @Test
    public void testGetProjetos() {
        System.out.println("getProjetos");
        GerenteRelacionamento instance = new GerenteRelacionamento();
        Set<Notificacao> expResult = null;
        instance.setProjetos(expResult);
        Set<Notificacao> result = instance.getProjetos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProjetos method, of class GerenteRelacionamento.
     */
    @Test
    public void testSetProjetos() {
        System.out.println("setProjetos");
        Set<Notificacao> projetos = null;
        GerenteRelacionamento instance = new GerenteRelacionamento();
        instance.setProjetos(projetos);
    }

    /**
     * Test of buscarPorEmail method, of class GerenteRelacionamento.
     */
    @Ignore
    public void testBuscarPorEmail() {
        System.out.println("buscarPorEmail");
        String user = "";
        GerenteRelacionamento instance = new GerenteRelacionamento();
        GerenteRelacionamento expResult = null;
        GerenteRelacionamento result = instance.buscarPorEmail(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarPorCpf method, of class GerenteRelacionamento.
     */
    @Ignore
    public void testBuscarPorCpf() {
        System.out.println("buscarPorCpf");
        String user = "";
        GerenteRelacionamento instance = new GerenteRelacionamento();
        GerenteRelacionamento expResult = null;
        GerenteRelacionamento result = instance.buscarPorCpf(user);
        assertEquals(expResult, result);
    }

}
