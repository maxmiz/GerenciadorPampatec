/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Planofinanceiro;
import java.util.ArrayList;
import java.util.HashMap;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Peterson
 */
public class DaoTest {

    Dao instance;

    public DaoTest() {
    }

    @Before
    public void setUp() {
        instance = new DaoImpl();

    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Salvar um Empreendedor sem setar o e-mail;
     */
    @Ignore
    public void testSalvar1() {
        Empreendedor empreendedor = new Empreendedor();
        boolean result = instance.salvar(empreendedor);
        assertFalse("Criando um empreendedor não adicionando e-mail. Espero que não salve", result);
    }

    /**
     * Salvar um Empreendedor setando e-mail. OBS.: A validação do e-mail deve
     * estar na classe empreendedor, logo independe do formato do E-mail a Dao
     * vai aceitar sempre qualquer e-mail.
     */
    @Ignore
    public void testSalvar2() {
        Empreendedor empreendedor = new Empreendedor();
        empreendedor.setEmail("teste@gmail.com");
        boolean result = instance.salvar(empreendedor);
        assertTrue("Criando um empreendedor adicionando e-mail. Espero que salve", result);
    }

    /**
     * Salvar um Empreendedor setando e-mail. OBS.: A validação do e-mail deve
     * estar na classe empreendedor, logo independe do formato do E-mail a Dao
     * vai aceitar sempre qualquer e-mail.
     */
    @Ignore
    public void testSalvar3() {
        Empreendedor empreendedor = new Empreendedor();
        empreendedor.setEmail("teste...");
        boolean result = instance.salvar(empreendedor);
        assertTrue("Criando um empreendedor adicionando e-mail inválido. Espero que salve", result);
    }

    /**
     * Test of salvarComArquivo method, of class Dao.
     */
    @Ignore
    public void testSalvarComArquivo() {
        System.out.println("salvarComArquivo");
        Object obj = null;
        Dao instance = new DaoImpl();
        int expResult = 0;
        int result = instance.salvarComArquivo(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Dao.
     */
    @Ignore
    public void testUpdate() {
        System.out.println("update");
        Object obj = null;
        Dao instance = new DaoImpl();
        boolean expResult = false;
        boolean result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class Dao.
     */
    @Ignore
    public void testExcluir() {
        System.out.println("excluir");
        int codigo = 0;
        Class type = null;
        Dao instance = new DaoImpl();
        boolean expResult = false;
        boolean result = instance.excluir(codigo, type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarObjeto method, of class Dao.
     */
    @Ignore
    public void testBuscarObjeto_int_Class() {
        System.out.println("buscarObjeto");
        int codigo = 0;
        Class classe = null;
        Dao instance = new DaoImpl();
        Object expResult = null;
        Object result = instance.buscarObjeto(codigo, classe);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarObjetoCriteria method, of class Dao.
     */
    @Ignore
    public void testBuscarObjetoCriteria() {
        System.out.println("buscarObjetoCriteria");
        String propriedade = "";
        String valor = "";
        Class classe = null;
        Dao instance = new DaoImpl();
        Object expResult = null;
        Object result = instance.buscarObjetoCriteria(propriedade, valor, classe);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarObjetoCriteriaINT method, of class Dao.
     */
    @Ignore
    public void testBuscarObjetoCriteriaINT() {
        System.out.println("buscarObjetoCriteriaINT");
        String propriedade = "";
        int valor = 0;
        Class classe = null;
        Dao instance = new DaoImpl();
        Object expResult = null;
        Object result = instance.buscarObjetoCriteriaINT(propriedade, valor, classe);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarObjeto method, of class Dao.
     */
    @Ignore
    public void testBuscarObjeto_String_Class() {
        System.out.println("buscarObjeto");
        String codigo = "";
        Class classe = null;
        Dao instance = new DaoImpl();
        Object expResult = null;
        Object result = instance.buscarObjeto(codigo, classe);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarObjeto method, of class Dao.
     */
    @Ignore
    public void testBuscarObjeto_HashMap_Class() {
        System.out.println("buscarObjeto");
        HashMap<String, Object> filtros = null;
        Class classe = null;
        Dao instance = new DaoImpl();
        Object expResult = null;
        Object result = instance.buscarObjeto(filtros, classe);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarObjetos method, of class Dao.
     */
    @Ignore
    public void testBuscarObjetos_HashMap_Class() {
        System.out.println("buscarObjetos");
        HashMap<String, Object> filtros = null;
        Class classe = null;
        Dao instance = new DaoImpl();
        Object expResult = null;
        Object result = instance.buscarObjetos(filtros, classe);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarObjetos method, of class Dao.
     */
    @Ignore
    public void testBuscarObjetos_Class() {
        System.out.println("buscarObjetos");
        Class classe = null;
        Dao instance = new DaoImpl();
        ArrayList expResult = null;
        ArrayList result = instance.buscarObjetos(classe);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTx method, of class Dao.
     */
    @Ignore
    public void testGetTx() {
        System.out.println("getTx");
        Dao instance = new DaoImpl();
        Transaction expResult = null;
        Transaction result = instance.getTx();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTx method, of class Dao.
     */
    @Ignore
    public void testSetTx() {
        System.out.println("setTx");
        Transaction tx = null;
        Dao instance = new DaoImpl();
        instance.setTx(tx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSession method, of class Dao.
     */
    @Ignore
    public void testGetSession() {
        System.out.println("getSession");
        Dao instance = new DaoImpl();
        Session expResult = null;
        Session result = instance.getSession();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSession method, of class Dao.
     */
    @Ignore
    public void testSetSession() {
        System.out.println("setSession");
        Session session = null;
        Dao instance = new DaoImpl();
        instance.setSession(session);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class DaoImpl extends Dao {
    }

}
