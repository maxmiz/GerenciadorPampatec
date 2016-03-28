/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import com.ideiah.gerenciadorpampatec.model.ComentarioProjeto;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Claudio
 */
public class PreAvaliarPlanoBeanTest {

    PreAvaliarPlanoBean instance;
    Projeto projeto;
    ComentarioProjeto comentarioProjeto;
    ProjetoDao projDao;

    public PreAvaliarPlanoBeanTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        projeto = new Projeto();
        projDao = new ProjetoDao();
        
        projeto = projDao.buscar(1);
        
        instance = new PreAvaliarPlanoBean(projeto);

    }

    @After
    public void tearDown() {
    }

   

    /**
     * Test of buscarComentarioProjeto method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testBuscarComentarioProjeto() {
        System.out.println("buscar Comentario do Projeto");
        instance.buscarComentarioProjeto(projeto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaEstagioEvolucao method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testVerificaEstagioEvolucao() {
        System.out.println("verificaEstagioEvolucao");
        PreAvaliarPlanoBean instance = new PreAvaliarPlanoBean();
        String expResult = "";
        String result = instance.verificaEstagioEvolucao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mudaStatusRedirecionaInicio method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testMudaStatusRedirecionaInicio() {
        System.out.println("mudaStatusRedirecionaInicio");
        PreAvaliarPlanoBean instance = new PreAvaliarPlanoBean();
        instance.mudaStatusRedirecionaInicio();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mudaStatusRedirecionaLista method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testMudaStatusRedirecionaLista() {
        System.out.println("mudaStatusRedirecionaLista");
        PreAvaliarPlanoBean instance = new PreAvaliarPlanoBean();
        instance.mudaStatusRedirecionaLista();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mudaStatusFazLogout method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testMudaStatusFazLogout() {
        System.out.println("mudaStatusFazLogout");
        PreAvaliarPlanoBean instance = new PreAvaliarPlanoBean();
        instance.mudaStatusFazLogout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvar method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        PreAvaliarPlanoBean instance = new PreAvaliarPlanoBean();
        instance.salvar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mudaStatusProjetoParaSendoAvaliado method, of class
     * PreAvaliarPlanoBean.
     */
    @Test
    public void testMudaStatusProjetoParaSendoAvaliado() {
        System.out.println("mudaStatusProjetoParaSendoAvaliado");
        Projeto projSelect = null;
        PreAvaliarPlanoBean instance = new PreAvaliarPlanoBean();
        instance.mudaStatusProjetoParaSendoAvaliado(projSelect);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mudaStatusProjetoParaEmPreAvaliacao method, of class
     * PreAvaliarPlanoBean.
     */
    @Test
    public void testMudaStatusProjetoParaEmPreAvaliacao() {
        System.out.println("mudaStatusProjetoParaEmPreAvaliacao");
        Projeto projSelect = null;
        PreAvaliarPlanoBean instance = new PreAvaliarPlanoBean();
        instance.mudaStatusProjetoParaEmPreAvaliacao(projSelect);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of terminarPreAvaliacao method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testTerminarPreAvaliacao() {
        System.out.println("terminarPreAvaliacao");
        PreAvaliarPlanoBean instance = new PreAvaliarPlanoBean();
        instance.terminarPreAvaliacao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjeto method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testGetProjeto() {
        System.out.println("getProjeto");
        PreAvaliarPlanoBean instance = new PreAvaliarPlanoBean();
        Projeto expResult = null;
        Projeto result = instance.getProjeto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProjeto method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testSetProjeto() {
        System.out.println("setProjeto");
        Projeto projeto = null;
        PreAvaliarPlanoBean instance = new PreAvaliarPlanoBean();
        instance.setProjeto(projeto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComentarioProjeto method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testGetComentarioProjeto() {
        System.out.println("getComentarioProjeto");
        PreAvaliarPlanoBean instance = new PreAvaliarPlanoBean();
        ComentarioProjeto expResult = null;
        ComentarioProjeto result = instance.getComentarioProjeto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComentarioProjeto method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testSetComentarioProjeto() {
        System.out.println("setComentarioProjeto");
        ComentarioProjeto comentarioProjeto = null;
        PreAvaliarPlanoBean instance = new PreAvaliarPlanoBean();
        instance.setComentarioProjeto(comentarioProjeto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResultadoPreAvaliacao method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testGetResultadoPreAvaliacao() {
        System.out.println("getResultadoPreAvaliacao");
        PreAvaliarPlanoBean instance = new PreAvaliarPlanoBean();
        int expResult = 0;
        int result = instance.getResultadoPreAvaliacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResultadoPreAvaliacao method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testSetResultadoPreAvaliacao() {
        System.out.println("setResultadoPreAvaliacao");
        int resultadoPreAvaliacao = 0;
        PreAvaliarPlanoBean instance = new PreAvaliarPlanoBean();
        instance.setResultadoPreAvaliacao(resultadoPreAvaliacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoginBean method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testGetLoginBean() {
        System.out.println("getLoginBean");
        PreAvaliarPlanoBean instance = new PreAvaliarPlanoBean();
        LoginBean expResult = null;
        LoginBean result = instance.getLoginBean();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoginBean method, of class PreAvaliarPlanoBean.
     */
    @Test
    public void testSetLoginBean() {
        System.out.println("setLoginBean");
        LoginBean loginBean = null;
        PreAvaliarPlanoBean instance = new PreAvaliarPlanoBean();
        instance.setLoginBean(loginBean);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
