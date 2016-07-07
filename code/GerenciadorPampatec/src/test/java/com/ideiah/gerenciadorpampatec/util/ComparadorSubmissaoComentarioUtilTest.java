/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.util;

import com.ideiah.gerenciadorpampatec.model.Textocomentario;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maicon Alves
 */
public class ComparadorSubmissaoComentarioUtilTest {
    
    public ComparadorSubmissaoComentarioUtilTest() {
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
     * teste para comparação de data de submissão quando não contem data
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        Textocomentario o1 = new Textocomentario();
        Textocomentario o2 = new Textocomentario();
        o1.setDataSubmissao(null);
        o2.setDataSubmissao(null);
        ComparadorSubmissaoComentarioUtil instance = new ComparadorSubmissaoComentarioUtil();
        int expResult = 0;
        int result = instance.compare(o1, o2);
        assertEquals(expResult, result);
        
    }
    
     /**
     * teste para comparação de data de submissão válida
     */
    @Test
    public void testCompare2() {
        System.out.println("compare");
        Textocomentario o1 = new Textocomentario();
        Textocomentario o2 = new Textocomentario();
        
        
        Date data = new Date();
        data.setHours(8);
        o1.setDataSubmissao(new Date());
        o2.setDataSubmissao(data);
        ComparadorSubmissaoComentarioUtil instance = new ComparadorSubmissaoComentarioUtil();
        int expResult = 0;
        int result = instance.compare(o1, o2);
        assertNotSame(expResult, result);
        
    }
    
}
