/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class TextocomentarioTest {
    
    public TextocomentarioTest() {
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
     * Test of getDataAlteracaoFormatada method, of class Textocomentario.
     */
    @Test
    public void testGetDataAlteracaoFormatada() {
        Textocomentario instance = new Textocomentario();
        instance.setDataAlteracao(new Date());
        
        String stringDataAlteracao, Data, Hora;
        Date dataDiaMesAno, dataHoraMinSeg;
        
        SimpleDateFormat diaMesAno = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat horaMinSeg = new SimpleDateFormat("HH:mm:ss");
       
            dataHoraMinSeg = instance.getDataAlteracao();
            dataDiaMesAno = instance.getDataAlteracao();

            Hora = horaMinSeg.format(dataHoraMinSeg);
            Data = diaMesAno.format(dataDiaMesAno);

            stringDataAlteracao = (Hora + " em " + Data);

        String result = instance.getDataAlteracaoFormatada();
        
        System.out.println(""+result);
        
        assertEquals(stringDataAlteracao, result);
    }

    /**
     * Test of getIdtextocomentario method, of class Textocomentario.
     */
    @Test
    public void testGetIdtextocomentario() {
        Textocomentario instance = new Textocomentario();
        Integer expResult = 1;
        instance.setIdtextocomentario(expResult);
        Integer result = instance.getIdtextocomentario();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdtextocomentario method, of class Textocomentario.
     */
    @Test
    public void testSetIdtextocomentario() {
        Textocomentario instance = new Textocomentario();
        Integer expResult = 1;
        instance.setIdtextocomentario(expResult);
        Integer result = instance.getIdtextocomentario();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of getComentarioprojetos method, of class Textocomentario.
     */
    @Test
    public void testGetComentarioprojetos() {
        Textocomentario instance = new Textocomentario();
        Set expResult = null;
        instance.setComentarioprojetos(expResult);
        Set result = instance.getComentarioprojetos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setComentarioprojetos method, of class Textocomentario.
     */
    @Test
    public void testSetComentarioprojetos() {
        Textocomentario instance = new Textocomentario();
        Set expResult = null;
        instance.setComentarioprojetos(expResult);
        Set result = instance.getComentarioprojetos();
        assertEquals(expResult, result);
    }
    
}
