/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import com.ideiah.gerenciadorpampatec.dao.EmpreendedorDao;
import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

/**
 *
 * @author Ideiah
 */
public class EmpreendedorTest {
    
    public EmpreendedorTest() {
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
     * Test of getEmpreededorDao method, of class Empreendedor.
     */
    @Ignore
    public void testGetEmpreededorDao() {
        System.out.println("getEmpreededorDao");
        EmpreendedorDao expResult = null;
        EmpreendedorDao result = Empreendedor.getEmpreededorDao();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setIdUnico method, of class Empreendedor.
     */
    @Ignore
    public void testSetIdUnico() {
        System.out.println("setIdUnico");
        String idUnico = "";
        Empreendedor instance = new Empreendedor();
        instance.setIdUnico(idUnico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdUnico method, of class Empreendedor.
     */
    @Ignore
    public void testGetIdUnico() {
        System.out.println("getIdUnico");
        Empreendedor instance = new Empreendedor();
        String expResult = "";
        String result = instance.getIdUnico();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjetoDao method, of class Empreendedor.
     */
    @Ignore
    public void testGetProjetoDao() {
        System.out.println("getProjetoDao");
        ProjetoDao expResult = null;
        ProjetoDao result = Empreendedor.getProjetoDao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornaStatus method, of class Empreendedor.
     */
    @Ignore
    public void testRetornaStatus() {
        System.out.println("retornaStatus");
        Empreendedor instance = new Empreendedor();
        String expResult = "";
        String result = instance.retornaStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornaTipoEmpreendedor method, of class Empreendedor.
     */
    @Ignore
    public void testRetornaTipoEmpreendedor() {
        System.out.println("retornaTipoEmpreendedor");
        Empreendedor empreendedorCorrespondente = null;
        Empreendedor instance = new Empreendedor();
        String expResult = "";
        String result = instance.retornaTipoEmpreendedor(empreendedorCorrespondente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaTipoEmpreendedor method, of class Empreendedor.
     */
    @Ignore
    public void testVerificaTipoEmpreendedor() {
        System.out.println("verificaTipoEmpreendedor");
        Empreendedor empreendedorCorrespondente = null;
        Empreendedor instance = new Empreendedor();
        boolean expResult = false;
        boolean result = instance.verificaTipoEmpreendedor(empreendedorCorrespondente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFormacao method, of class Empreendedor.
     */
    @Ignore
    public void testGetFormacao() {
        System.out.println("getFormacao");
        Empreendedor instance = new Empreendedor();
        String expResult = "";
        String result = instance.getFormacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFormacao method, of class Empreendedor.
     */
    @Ignore
    public void testSetFormacao() {
        System.out.println("setFormacao");
        String formacao = "";
        Empreendedor instance = new Empreendedor();
        instance.setFormacao(formacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExperiencia method, of class Empreendedor.
     */
    @Ignore
    public void testGetExperiencia() {
        System.out.println("getExperiencia");
        Empreendedor instance = new Empreendedor();
        String expResult = "";
        String result = instance.getExperiencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExperiencia method, of class Empreendedor.
     */
    @Ignore
    public void testSetExperiencia() {
        System.out.println("setExperiencia");
        String experiencia = "";
        Empreendedor instance = new Empreendedor();
        instance.setExperiencia(experiencia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjetos method, of class Empreendedor.
     */
    @Ignore
    public void testGetProjetos() {
        System.out.println("getProjetos");
        Empreendedor instance = new Empreendedor();
        Set expResult = null;
        Set result = instance.getProjetos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProjetos method, of class Empreendedor.
     */
    @Ignore
    public void testSetProjetos() {
        System.out.println("setProjetos");
        Set projetos = null;
        Empreendedor instance = new Empreendedor();
        instance.setProjetos(projetos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvarProjeto method, of class Empreendedor.
     */
    @Ignore
    public void testSalvarProjeto() {
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizarProjeto method, of class Empreendedor.
     */
    @Ignore
    public void testAtualizarProjeto() {
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornarEmpreendedores method, of class Empreendedor.
     */
    @Ignore
    public void testRetornarEmpreendedores() {
        System.out.println("retornarEmpreendedores");
        List<Empreendedor> expResult = null;
        List<Empreendedor> result = Empreendedor.retornarEmpreendedores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cadastrarEmpreendedor method, of class Empreendedor.
     */
    @Ignore
    public void testCadastrarEmpreendedor() {
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enviarProjeto method, of class Empreendedor.
     */
    @Ignore
    public void testEnviarProjeto() {
        System.out.println("enviarProjeto");
        Projeto projeto = null;
        Empreendedor instance = new Empreendedor();
        int expResult = 0;
        int result = instance.enviarProjeto(projeto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaDadosEmpreendedores method, of class Empreendedor.
     */
    @Ignore
    public void testVerificaDadosEmpreendedores() {
        System.out.println("verificaDadosEmpreendedores");
        Projeto projeto = null;
        Empreendedor instance = new Empreendedor();
        boolean expResult = false;
        boolean result = instance.verificaDadosEmpreendedores(projeto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaDadosEmpreendedor method, of class Empreendedor.
     */
    @Ignore
    public void testVerificaDadosEmpreendedor() {
        System.out.println("verificaDadosEmpreendedor");
        Empreendedor empreendedor = null;
        boolean expResult = false;
        boolean result = Empreendedor.verificaDadosEmpreendedor(empreendedor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizarEmpreendedor method, of class Empreendedor.
     */
    @Ignore
    public void testAtualizarEmpreendedor() {
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorEmail method, of class Empreendedor.
     */
    @Ignore
    public void testBuscarPorEmail() {
        System.out.println("buscarPorEmail");
        String user = "";
        Empreendedor instance = new Empreendedor();
        Empreendedor expResult = null;
        Empreendedor result = instance.buscarPorEmail(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorCpf method, of class Empreendedor.
     */
    @Ignore
    public void testBuscarPorCpf() {
        System.out.println("buscarPorCpf");
        String user = "";
        Empreendedor instance = new Empreendedor();
        Empreendedor expResult = null;
        Empreendedor result = instance.buscarPorCpf(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of realizarCadastro method, of class Empreendedor.
     */
    @Ignore
    public void testRealizarCadastro() {
        System.out.println("realizarCadastro");
        Empreendedor instance = new Empreendedor();
        instance.realizarCadastro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaEmpreendedores method, of class Empreendedor.
     */
    @Ignore
    public void testBuscaEmpreendedores() {
        System.out.println("buscaEmpreendedores");
        ArrayList<Empreendedor> expResult = null;
        ArrayList<Empreendedor> result = Empreendedor.buscaEmpreendedores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class Empreendedor.
     */
    @Ignore
    public void testGetNumero() {
        System.out.println("getNumero");
        Empreendedor instance = new Empreendedor();
        Integer expResult = null;
        Integer result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class Empreendedor.
     */
    @Ignore
    public void testSetNumero() {
        System.out.println("setNumero");
        Integer numero = null;
        Empreendedor instance = new Empreendedor();
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComplemento method, of class Empreendedor.
     */
    @Ignore
    public void testGetComplemento() {
        System.out.println("getComplemento");
        Empreendedor instance = new Empreendedor();
        String expResult = "";
        String result = instance.getComplemento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComplemento method, of class Empreendedor.
     */
    @Ignore
    public void testSetComplemento() {
        System.out.println("setComplemento");
        String complemento = "";
        Empreendedor instance = new Empreendedor();
        instance.setComplemento(complemento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBairro method, of class Empreendedor.
     */
    @Ignore
    public void testGetBairro() {
        System.out.println("getBairro");
        Empreendedor instance = new Empreendedor();
        String expResult = "";
        String result = instance.getBairro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBairro method, of class Empreendedor.
     */
    @Ignore
    public void testSetBairro() {
        System.out.println("setBairro");
        String bairro = "";
        Empreendedor instance = new Empreendedor();
        instance.setBairro(bairro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRua method, of class Empreendedor.
     */
    @Ignore
    public void testGetRua() {
        System.out.println("getRua");
        Empreendedor instance = new Empreendedor();
        String expResult = "";
        String result = instance.getRua();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRua method, of class Empreendedor.
     */
    @Ignore
    public void testSetRua() {
        System.out.println("setRua");
        String rua = "";
        Empreendedor instance = new Empreendedor();
        instance.setRua(rua);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletarEmpreendedor method, of class Empreendedor.
     */
    @Ignore
    public void testDeletarEmpreendedor() {
        System.out.println("deletarEmpreendedor");
        Empreendedor empreendedor = null;
        Empreendedor instance = new Empreendedor();
        boolean expResult = false;
        boolean result = instance.deletarEmpreendedor(empreendedor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarProjetoHasEmpreendedor method, of class Empreendedor.
     */
    @Ignore
    public void testVerificarProjetoHasEmpreendedor() {
        System.out.println("verificarProjetoHasEmpreendedor");
        Empreendedor empreendedor = null;
        Empreendedor instance = new Empreendedor();
        boolean expResult = false;
        boolean result = instance.verificarProjetoHasEmpreendedor(empreendedor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaProjetoEmpreendedor method, of class Empreendedor.
     */
    @Ignore
    public void testVerificaProjetoEmpreendedor() {
        System.out.println("verificaProjetoEmpreendedor");
        Empreendedor empreendedor = null;
        Projeto proj = null;
        Empreendedor instance = new Empreendedor();
        boolean expResult = false;
        boolean result = instance.verificaProjetoEmpreendedor(empreendedor, proj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaEmpreendedorID method, of class Empreendedor.
     */
    @Ignore
    public void testBuscaEmpreendedorID() {
        System.out.println("buscaEmpreendedorID");
        String id = "";
        Empreendedor expResult = null;
        Empreendedor result = Empreendedor.buscaEmpreendedorID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaPorEmail method, of class Empreendedor.
     */
    @Ignore
    public void testBuscaPorEmail() {
        System.out.println("buscaPorEmail");
        String email = "";
        Empreendedor expResult = null;
        Empreendedor result = Empreendedor.buscaPorEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNotificacoes method, of class Empreendedor.
     */
    @Ignore
    public void testGetNotificacoes() {
        System.out.println("getNotificacoes");
        Empreendedor instance = new Empreendedor();
        Set<Notificacao> expResult = null;
        Set<Notificacao> result = instance.getNotificacoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNotificacoes method, of class Empreendedor.
     */
    @Ignore
    public void testSetNotificacoes() {
        System.out.println("setNotificacoes");
        Set<Notificacao> notificacoes = null;
        Empreendedor instance = new Empreendedor();
        instance.setNotificacoes(notificacoes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantidadeDeNotificacoes method, of class Empreendedor.
     */
    @Ignore
    public void testGetQuantidadeDeNotificacoes() {
        System.out.println("getQuantidadeDeNotificacoes");
        Empreendedor instance = new Empreendedor();
        int expResult = 0;
        int result = instance.getQuantidadeDeNotificacoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescricaoDasNotificacoes method, of class Empreendedor.
     */
    @Ignore
    public void testGetDescricaoDasNotificacoes() {
        System.out.println("getDescricaoDasNotificacoes");
        Empreendedor instance = new Empreendedor();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getDescricaoDasNotificacoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCustoProjeto method, of class Empreendedor.
     */
    @Ignore
    public void testRemoveCustoProjeto() {
        System.out.println("removeCustoProjeto");
        Custo custo = null;
        Empreendedor instance = new Empreendedor();
        instance.removeCustoProjeto(custo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
