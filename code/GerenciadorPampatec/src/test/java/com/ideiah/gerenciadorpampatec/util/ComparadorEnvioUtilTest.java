/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.util;

import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.util.Date;
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
public class ComparadorEnvioUtilTest {
    
    public ComparadorEnvioUtilTest() {
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
     * 
     */
    @Test
    public void testConstrutorComparadorEnvioUtil(){
        System.out.println("testConstrutorComparadorEnvioUtil");
        ComparadorEnvioUtil expResult = new ComparadorEnvioUtil();
        assertNotNull(expResult);
    }
    
    
    /**
     * Test of compare method, of class ComparadorEnvioUtil.
     */
    @Test(expected = NullPointerException.class)
    public void testCompare() {
        System.out.println("compare_Null");
        Projeto o1 = null;
        Projeto o2 = null;
        ComparadorEnvioUtil instance = new ComparadorEnvioUtil();
        int expResult = 0;
        int result = instance.compare(o1, o2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compare method, of class ComparadorEnvioUtil.
     */
    @Test
    public void testCompare2() {
        System.out.println("compare");
        
        Projeto o1 = new Projeto();
        Projeto o2 = new Projeto();
        
        Date date = new Date();
        o1.setDataEnvio(date);
        o2.setDataEnvio(date);
        
        ComparadorEnvioUtil instance = new ComparadorEnvioUtil();
        int expResult = 0;
        int result = instance.compare(o1, o2);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of compare method, of class ComparadorEnvioUtil.
     */
    @Test(expected = NullPointerException.class)
    public void testCompare3() {
        System.out.println("compare");
        
        Projeto o1 = new Projeto();
        Projeto o2 = new Projeto();
        
        Date date = new Date();
        o1.setDataEnvio(date);
        o2.setDataEnvio(null);
        
        ComparadorEnvioUtil instance = new ComparadorEnvioUtil();
        int expResult = 0;
        int result = instance.compare(o1, o2);
        assertEquals(expResult, result);
    }
    
}