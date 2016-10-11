/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.math.BigInteger;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;

/**
 *
 * @author Peterson
 */
@Ignore
public class ProjetoDaoTest {
    
    public ProjetoDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of salvar method, of class ProjetoDao.
     */
    @Ignore
    public void testSalvar() {
        System.out.println("salvar");
        Projeto projeto = null;
        ProjetoDao instance = new ProjetoDao();
        boolean expResult = false;
        boolean result = instance.salvar(projeto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvarRetornandoProjeto method, of class ProjetoDao.
     */
    @Ignore
    public void testSalvarRetornandoProjeto() {
        System.out.println("salvarRetornandoProjeto");
        Projeto projeto = null;
        ProjetoDao instance = new ProjetoDao();
        Projeto expResult = null;
        Projeto result = instance.salvarRetornandoProjeto(projeto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ProjetoDao.
     */
    @Ignore
    public void testUpdate() {
        System.out.println("update");
        Projeto projeto = null;
        ProjetoDao instance = new ProjetoDao();
        boolean expResult = false;
        boolean result = instance.update(projeto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class ProjetoDao.
     */
    @Ignore
    public void testBuscar_0args() {
        System.out.println("buscar");
        ProjetoDao instance = new ProjetoDao();
        ArrayList<Projeto> expResult = null;
        ArrayList<Projeto> result = instance.buscar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class ProjetoDao.
     */
    @Ignore
    public void testBuscar_int() {
        System.out.println("buscar");
        int codigo = 0;
        ProjetoDao instance = new ProjetoDao();
        Projeto expResult = null;
        Projeto result = instance.buscar(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaEmpreendedor method, of class ProjetoDao.
     */
    @Ignore
    public void testVerificaEmpreendedor() {
        System.out.println("verificaEmpreendedor");
        Empreendedor empreendedor = null;
        Projeto projeto = null;
        ProjetoDao instance = new ProjetoDao();
        boolean expResult = false;
        boolean result = instance.verificaEmpreendedor(empreendedor, projeto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornarUltimoId method, of class ProjetoDao.
     */
    @Ignore
    public void testRetornarUltimoId() {
        System.out.println("retornarUltimoId");
        ProjetoDao instance = new ProjetoDao();
        BigInteger expResult = null;
        BigInteger result = instance.retornarUltimoId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class ProjetoDao.
     */
    @Ignore
    public void testDeletar() {
        System.out.println("deletar");
        int codigo = 0;
        ProjetoDao instance = new ProjetoDao();
        boolean expResult = false;
        boolean result = instance.deletar(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorStatus method, of class ProjetoDao.
     */
    @Test
    public void testBuscarPorStatus() {
        System.out.println("buscarPorStatus");
        int status = 0;
        ProjetoDao instance = new ProjetoDao();
        Projeto expResult = null;
        Projeto result = instance.buscarPorStatus(status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarListaProjetoPorStatus method, of class ProjetoDao.
     */
    @Test
    public void testBuscarListaProjetoPorStatus() {
        System.out.println("buscarListaProjetoPorStatus");
        int status = 0;
        ProjetoDao instance = new ProjetoDao();
        ArrayList<Projeto> expResult = null;
        ArrayList<Projeto> result = instance.buscarListaProjetoPorStatus(status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
