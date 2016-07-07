/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author unipampa
 */
public class NegocioTest {

    public NegocioTest() {
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
     * Test of getIdNegocio method, of class Negocio.
     */
    @Test
    public void testGetIdNegocio() {
        System.out.println("getIdNegocio");
        Negocio instance = new Negocio();
        int expResult = 0;
        int result = instance.getIdNegocio();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdNegocio method, of class Negocio.
     */
    @Test
    public void testConstrutorNegocio() {
        System.out.println("getIdNegocio");
        int idNegocio = 0;
        String segmentoClientes = "";
        String propostaValor = "";
        String atividadesChaves = "";
        Negocio instance = new Negocio(idNegocio,
                segmentoClientes, propostaValor, atividadesChaves);

        assertNotNull(instance);
    }

    /**
     * Test of getIdNegocio method, of class Negocio.
     */
    @Test
    public void testConstrutorNegocio2() {
        System.out.println("getIdNegocio");
        String segmentoClientes = "";
        String propostaValor = "";
        String atividadesChaves = "";
        Set projetos = new HashSet(0);
        Negocio instance = new Negocio(0, segmentoClientes, propostaValor, atividadesChaves, projetos);
        assertNotNull(instance);
    }

    /**
     *
     * Test of setIdNegocio method, of class Negocio.
     */
    @Test
    public void testSetIdNegocio() {
        System.out.println("setIdNegocio");
        int idNegocio = 0;
        Negocio instance = new Negocio();
        instance.setIdNegocio(idNegocio);
    }

    /**
     * Test of getSegmentoClientes method, of class Negocio.
     */
    @Test
    public void testGetSegmentoClientes() {
        System.out.println("getSegmentoClientes");
        Negocio instance = new Negocio();
        String expResult = "";
        instance.setSegmentoClientes(expResult);
        String result = instance.getSegmentoClientes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSegmentoClientes method, of class Negocio.
     */
    @Test
    public void testSetSegmentoClientes() {
        System.out.println("setSegmentoClientes");
        Negocio instance = new Negocio();
        String segmentoClientes = "";
        instance.setSegmentoClientes(segmentoClientes);
    }

    /**
     * Test of getPropostaValor method, of class Negocio.
     */
    @Test
    public void testGetPropostaValor() {
        System.out.println("getPropostaValor");
        Negocio instance = new Negocio();
        String expResult = "";
        instance.setPropostaValor(expResult);
        String result = instance.getPropostaValor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPropostaValor method, of class Negocio.
     */
    @Test
    public void testSetPropostaValor() {
        System.out.println("setPropostaValor");
        String propostaValor = "";
        Negocio instance = new Negocio();
        instance.setPropostaValor(propostaValor);
    }

    /**
     * Test of getAtividadesChaves method, of class Negocio.
     */
    @Test
    public void testGetAtividadesChaves() {
        System.out.println("getAtividadesChaves");
        Negocio instance = new Negocio();
        String expResult = "";
        instance.setAtividadesChaves(expResult);
        String result = instance.getAtividadesChaves();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAtividadesChaves method, of class Negocio.
     */
    @Test
    public void testSetAtividadesChaves() {
        System.out.println("setAtividadesChaves");
        String atividadesChaves = "";
        Negocio instance = new Negocio();
        instance.setAtividadesChaves(atividadesChaves);
    }

    /**
     * Test of getProjetos method, of class Negocio.
     */
    @Test
    public void testGetProjetos() {
        System.out.println("getProjetos");
        Negocio instance = new Negocio();
        Set expResult = null;
        instance.setProjetos(expResult);
        Set result = instance.getProjetos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProjetos method, of class Negocio.
     */
    @Test
    public void testSetProjetos() {
        System.out.println("setProjetos");
        Set projetos = null;
        Negocio instance = new Negocio();
        instance.setProjetos(projetos);
    }

}
