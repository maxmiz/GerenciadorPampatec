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

/**
 *
 * @author unipampa
 */
public class TelefoneUtilTest {
    
    public TelefoneUtilTest() {
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
     * Test of removeParentesesTelefone method, of class TelefoneUtil.
     */
    @Test
    public void testRemoveParentesesTelefone() {
        System.out.println("removeParentesesTelefone");
        TelefoneUtil result = new TelefoneUtil();
        assertNotNull(result);
    }
    
    /**
     * Test of removeParentesesTelefone method, of class TelefoneUtil.
     */
    @Test
    public void testRemoveParentesesTelefone1() {
        System.out.println("removeParentesesTelefone1");
        String telefone = null;
        String expResult = "";
        String result = TelefoneUtil.removeParentesesTelefone(telefone);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of removeParentesesTelefone method, of class TelefoneUtil.
     */
    @Test
    public void testRemoveParentesesTelefone2() {
        System.out.println("removeParentesesTelefone2");
        String telefone = "";
        String expResult = "";
        String result = TelefoneUtil.removeParentesesTelefone(telefone);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of removeParentesesTelefone method, of class TelefoneUtil.
     */
    @Test
    public void testRemoveParentesesTelefone3() {
        System.out.println("removeParentesesTelefone3");
        String telefone = "(55) 5555-5555";
        String expResult = "5555555555";
        String result = TelefoneUtil.removeParentesesTelefone(telefone);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of removeParentesesTelefone method, of class TelefoneUtil.
     */
    @Test
    public void testRemoveParentesesTelefone4() {
        System.out.println("removeParentesesTelefone4");
        String telefone = "(55) 55555555";
        String expResult = "5555555555";
        String result = TelefoneUtil.removeParentesesTelefone(telefone);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of removeParentesesTelefone method, of class TelefoneUtil.
     */
    @Test
    public void testRemoveParentesesTelefone5() {
        System.out.println("removeParentesesTelefone5");
        String telefone = "(ABC) ABCD-EFGH";
        String expResult = "";
        String result = TelefoneUtil.removeParentesesTelefone(telefone);
        assertEquals(expResult, result);
    }
}
