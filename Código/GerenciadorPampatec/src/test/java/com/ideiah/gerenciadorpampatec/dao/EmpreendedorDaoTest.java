/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Peterson
 */
public class EmpreendedorDaoTest {

    EmpreendedorDao instance;

    public EmpreendedorDaoTest() {
    }

    @Before
    public void setUp() {
        instance = new EmpreendedorDao();
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of salvar method, of class EmpreendedorDao.
     */
    @Ignore
    public void testSalvar() {

        Empreendedor empreendedor = null;

        boolean expResult = false;
        boolean result = instance.salvar(empreendedor);
        assertEquals(expResult, result);

    }

    /**
     * Test of buscar method, of class EmpreendedorDao.
     */
    @Ignore
    public void testBuscar_0args() {
        System.out.println("buscar");
        EmpreendedorDao instance = new EmpreendedorDao();
        ArrayList<Empreendedor> expResult = null;
        ArrayList<Empreendedor> result = instance.buscar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class EmpreendedorDao.
     */
    @Ignore
    public void testBuscar_int() {
        System.out.println("buscar");
        int codigo = 0;
        EmpreendedorDao instance = new EmpreendedorDao();
        Empreendedor expResult = null;
        Empreendedor result = instance.buscar(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorIdUnico method, of class EmpreendedorDao.
     */
    @Ignore
    public void testBuscarPorIdUnico() {
        System.out.println("buscarPorIdUnico");
        String idUnico = "";
        EmpreendedorDao instance = new EmpreendedorDao();
        Empreendedor expResult = null;
        Empreendedor result = instance.buscarPorIdUnico(idUnico);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaPorEmail method, of class EmpreendedorDao.
     */
    @Ignore
    public void testBuscaPorEmail() {
        System.out.println("buscaPorEmail");
        String email = "";
        EmpreendedorDao instance = new EmpreendedorDao();
        Empreendedor expResult = null;
        Empreendedor result = instance.buscaPorEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorCpf method, of class EmpreendedorDao.
     */
    @Ignore
    public void testBuscarPorCpf() {
        System.out.println("buscarPorCpf");
        String cpf = "";
        EmpreendedorDao instance = new EmpreendedorDao();
        Empreendedor expResult = null;
        Empreendedor result = instance.buscarPorCpf(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorEmail method, of class EmpreendedorDao.
     */
    @Ignore
    public void testBuscarPorEmail() {
        System.out.println("buscarPorEmail");
        String email = "";
        EmpreendedorDao instance = new EmpreendedorDao();
        Empreendedor expResult = null;
        Empreendedor result = instance.buscarPorEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of soContemNumeros method, of class EmpreendedorDao.
     */
    @Ignore
    public void testSoContemNumeros() {
        System.out.println("soContemNumeros");
        String texto = "";
        boolean expResult = false;
        boolean result = EmpreendedorDao.soContemNumeros(texto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class EmpreendedorDao.
     */
    @Ignore
    public void testDeletar() {
        System.out.println("deletar");
        int codigo = 0;
        EmpreendedorDao instance = new EmpreendedorDao();
        boolean expResult = false;
        boolean result = instance.deletar(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletarPorEmail method, of class EmpreendedorDao.
     */
    @Ignore
    public void testDeletarPorEmail() {
        System.out.println("deletarPorEmail");
        String email = "";
        EmpreendedorDao instance = new EmpreendedorDao();
        boolean expResult = false;
        boolean result = instance.deletarPorEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}
