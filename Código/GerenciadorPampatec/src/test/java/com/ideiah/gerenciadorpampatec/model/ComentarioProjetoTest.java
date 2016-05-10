/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.util.Date;
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
 * @author Pedro
 */
@Ignore
public class ComentarioProjetoTest {
    
    public ComentarioProjetoTest() {
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
     * Teste se o texto do comentário é cncontrado.
     */
    @Test
    public void testRetornarTextoComentario1() {
        System.out.println("testRetornarTextoComentarioVazio");
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com o texto preechido.
     */
    @Test
    public void testRetornarTextoComentario2() {
        System.out.println("testRetornarTextoComentarioPreechido");
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.SEGMENTO_CLIENTE, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a data
     * de alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentario3() {
        System.out.println("testRetornarTextoComentarioDataAlteracaoPreechida");
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date =  new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.SEGMENTO_CLIENTE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        assertEquals(expResult, result.getDataAlteracao());
    }
    
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a data
     * de submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentario4() {
        System.out.println("testRetornarTextoComentarioDataSubmissaoPreechida");
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date =  new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.SEGMENTO_CLIENTE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        assertEquals(expResult, result.getDataSubmissao());
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentario5() {
        System.out.println("testRetornarTextoComentarioGerente");
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.SEGMENTO_CLIENTE, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }
    
    /**
     * Teste se o texto do comentário é cncontrado.
     */
    @Test
    public void testRetornarTextoComentario6() {
        System.out.println("testRetornarTextoComentarioNull");
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        assertEquals(expResult, result);
    }

    
}
