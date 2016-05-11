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
    
    public void testComentarioGiganteSegmentaoCliente() {
        System.out.println("testComentarioGiganteSegmentaoCliente");
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        textocomentario.setTexto("textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante ");
        String expResult = "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante "
                + "textoGigante textoGigante textoGigante ";
        String result = instance.retornaTextoComentario(Textocomentario.SEGMENTO_CLIENTE);
        assertEquals(expResult, result);
    }
    
    /**
     * teste se o texto do comentario Proposta valor é encontrado.
     */
        public void testRetornarTextoComentarioPropostaValor() {
        System.out.println("testRetornarTextoComentarioVazio");
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.PROPOSTA_VALOR);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com o texto preechido.
     */
    @Test
    public void testRetornarTextoComentarioPropostaValor2() {
        System.out.println("testRetornarTextoComentarioPreechido");
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.PROPOSTA_VALOR, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.PROPOSTA_VALOR);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a data
     * de alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioPropostavalor3() {
        System.out.println("testRetornarTextoComentarioDataAlteracaoPreechida");
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date =  new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.PROPOSTA_VALOR, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.PROPOSTA_VALOR);
        assertEquals(expResult, result.getDataAlteracao());
    }
    
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a data
     * de submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioPropostaValor4() {
        System.out.println("testRetornarTextoComentarioDataSubmissaoPreechida");
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date =  new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.PROPOSTA_VALOR, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.PROPOSTA_VALOR);
        assertEquals(expResult, result.getDataSubmissao());
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioPropostavalor5() {
        System.out.println("testRetornarTextoComentarioGerente");
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.PROPOSTA_VALOR, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.PROPOSTA_VALOR);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }
    
    /**
     * Teste se o texto do comentário é cncontrado.
     */
    @Test
    public void testRetornarTextoComentarioPropostavalor6() {
        System.out.println("testRetornarTextoComentarioNull");
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.PROPOSTA_VALOR);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.PROPOSTA_VALOR);
        assertEquals(expResult, result);
    }
    
    public void testRetornarTextoComentarioAtividadesChave1() {
        System.out.println("testRetornarTextoComentarioVazio");
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com o texto preechido.
     */
    @Test
    public void testRetornarTextoComentarioAtividadesChave2() {
        System.out.println("testRetornarTextoComentarioPreechido");
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.ATIVIDADES_CHAVE, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a data
     * de alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioAtividadesChave3() {
        System.out.println("testRetornarTextoComentarioDataAlteracaoPreechida");
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date =  new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.ATIVIDADES_CHAVE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        assertEquals(expResult, result.getDataAlteracao());
    }
    
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a data
     * de submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioAtividadesChave4() {
        System.out.println("testRetornarTextoComentarioDataSubmissaoPreechida");
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date =  new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.ATIVIDADES_CHAVE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        assertEquals(expResult, result.getDataSubmissao());
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioAtividadesChave5() {
        System.out.println("testRetornarTextoComentarioGerente");
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.ATIVIDADES_CHAVE, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }
    
    /**
     * Teste se o texto do comentário é cncontrado.
     */
    @Test
    public void testRetornarTextoComentarioAtividadesChave6() {
        System.out.println("testRetornarTextoComentarioNull");
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.ATIVIDADES_CHAVE);
        assertEquals(expResult, result);
    }
    
        public void testRetornarTextoComentarioRelacaoCliente1() {
        System.out.println("testRetornarTextoComentarioVazio");
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.RELACOES_CLIENTE);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com o texto preechido.
     */
    @Test
    public void testRetornarTextoComentarioRelacaoCliente2() {
        System.out.println("testRetornarTextoComentarioPreechido");
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.RELACOES_CLIENTE, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.RELACOES_CLIENTE);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a data
     * de alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioRelacaoCliente3() {
        System.out.println("testRetornarTextoComentarioDataAlteracaoPreechida");
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date =  new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.RELACOES_CLIENTE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.RELACOES_CLIENTE);
        assertEquals(expResult, result.getDataAlteracao());
    }
    
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a data
     * de submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioRelacaoCliente4() {
        System.out.println("testRetornarTextoComentarioDataSubmissaoPreechida");
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date =  new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.RELACOES_CLIENTE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.RELACOES_CLIENTE);
        assertEquals(expResult, result.getDataSubmissao());
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioRelacaoCliente5() {
        System.out.println("testRetornarTextoComentarioGerente");
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.RELACOES_CLIENTE, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.RELACOES_CLIENTE);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }
    
    /**
     * Teste se o texto do comentário é cncontrado.
     */
    @Test
    public void testRetornarTextoComentarioRelacaoCliente6() {
        System.out.println("testRetornarTextoComentarioNull");
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.RELACOES_CLIENTE);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.RELACOES_CLIENTE);
        assertEquals(expResult, result);
    }
    
    
        public void testRetornarTextoComentarioParceriasChave1() {
        System.out.println("testRetornarTextoComentarioVazio");
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com o texto preechido.
     */
    @Test
    public void testRetornarTextoComentarioParceriasChave2() {
        System.out.println("testRetornarTextoComentarioPreechido");
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.PARCERIAS_CHAVE, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a data
     * de alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioParceriasChave3() {
        System.out.println("testRetornarTextoComentarioDataAlteracaoPreechida");
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date =  new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.PARCERIAS_CHAVE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        assertEquals(expResult, result.getDataAlteracao());
    }
    
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a data
     * de submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioParceriasChave4() {
        System.out.println("testRetornarTextoComentarioDataSubmissaoPreechida");
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date =  new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.PARCERIAS_CHAVE, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        assertEquals(expResult, result.getDataSubmissao());
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioParceiasChave5() {
        System.out.println("testRetornarTextoComentarioGerente");
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.PARCERIAS_CHAVE, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }
    
    /**
     * Teste se o texto do comentário é cncontrado.
     */
    @Test
    public void testRetornarTextoComentarioParceriasChave6() {
        System.out.println("testRetornarTextoComentarioNull");
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.PARCERIAS_CHAVE);
        assertEquals(expResult, result);
    }
    
        public void testRetornarTextoComentarioCanais1() {
        System.out.println("testRetornarTextoComentarioVazio");
        ComentarioProjeto instance = new ComentarioProjeto();
        String expResult = "";
        String result = instance.retornaTextoComentario(Textocomentario.CANAIS);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com o texto preechido.
     */
    @Test
    public void testRetornarTextoComentarioCanais2() {
        System.out.println("testRetornarTextoComentarioPreechido");
        ComentarioProjeto instance = new ComentarioProjeto();
        instance.setTextoComentario(Textocomentario.CANAIS, "Texto");
        String expResult = "Texto";
        String result = instance.retornaTextoComentario(Textocomentario.CANAIS);
        assertEquals(expResult, result);
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a data
     * de alteração preenchida.
     */
    @Test
    public void testRetornarTextoComentarioCanais3() {
        System.out.println("testRetornarTextoComentarioDataAlteracaoPreechida");
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date =  new Date();
        instance.setTextoComentarioDataAlteracao(Textocomentario.CANAIS, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.CANAIS);
        assertEquals(expResult, result.getDataAlteracao());
    }
    
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a data
     * de submissão preenchida.
     */
    @Test
    public void testRetornarTextoComentarioCanais4() {
        System.out.println("testRetornarTextoComentarioDataSubmissaoPreechida");
        ComentarioProjeto instance = new ComentarioProjeto();
        Date date =  new Date();
        instance.setTextoComentarioDataSubmissao(Textocomentario.CANAIS, date);
        Date expResult = date;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.CANAIS);
        assertEquals(expResult, result.getDataSubmissao());
    }
    
    /**
     * Teste se o texto do comentário é cncontrado quando está com a o gerente
     * preenchido
     */
    @Test
    public void testRetornarTextoComentarioCanais5() {
        System.out.println("testRetornarTextoComentarioGerente");
        ComentarioProjeto instance = new ComentarioProjeto();
        GerenteRelacionamento gerente = new GerenteRelacionamento();
        gerente.setIdgerente_relacionamento(2);
        instance.setTextoComentario(Textocomentario.CANAIS, gerente);
        GerenteRelacionamento expResult = gerente;
        Textocomentario result = instance.retornarTextoComentario(Textocomentario.CANAIS);
        assertEquals(expResult, result.getGerenteRelacionamento());
    }
    
    /**
     * Teste se o texto do comentário é cncontrado.
     */
    @Test
    public void testRetornarTextoComentarioCanais6() {
        System.out.println("testRetornarTextoComentarioNull");
        ComentarioProjeto instance = new ComentarioProjeto();
        Textocomentario textocomentario = instance.retornarTextoComentario(Textocomentario.CANAIS);
        textocomentario.setTexto(null);
        String expResult = null;
        String result = instance.retornaTextoComentario(Textocomentario.CANAIS);
        assertEquals(expResult, result);
    }
    
}
