/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.ComentarioProjeto;
import com.ideiah.gerenciadorpampatec.model.Custo;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.mockito.Mockito;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Pedro
 */
public class revisarPlanoDeNegocioBeanTest {
    
    public SessionBean sb;
    
    public revisarPlanoDeNegocioBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //Simula a criação da classe SessionBean para possibilitar os testes unitários
        sb = Mockito.mock(SessionBean.class);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of verificaExistenciaComentarioProjeto method, of class revisarPlanoDeNegocioBean.
     */
    @Test
    public void testVerificaExistenciaComentarioProjeto() {
        System.out.println("verificaExistenciaComentarioProjeto");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.setSessionBean(sb);
        Projeto projetoSelecionado = new Projeto();
        projetoSelecionado.setStatus(Projeto.ACEITO_PARA_AVALIACAO);
        boolean expResult = false;
        boolean result = instance.verificaExistenciaComentarioProjeto(projetoSelecionado);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaStatusSendoAvaliado method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testVerificaStatusSendoAvaliado() {
        System.out.println("verificaStatusSendoAvaliado");
        Projeto projetoSelecionado = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        boolean expResult = false;
        boolean result = instance.verificaStatusSendoAvaliado(projetoSelecionado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaStatusAceitoAvaliacao method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testVerificaStatusAceitoAvaliacao() {
        System.out.println("verificaStatusAceitoAvaliacao");
        Projeto projetoSelecionado = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        boolean expResult = false;
        boolean result = instance.verificaStatusAceitoAvaliacao(projetoSelecionado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaStatusRevisando method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testVerificaStatusRevisando() {
        System.out.println("verificaStatusRevisando");
        Projeto projetoSelecionado = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        boolean expResult = false;
        boolean result = instance.verificaStatusRevisando(projetoSelecionado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaStatusSubmetido method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testVerificaStatusSubmetido() {
        System.out.println("verificaStatusSubmetido");
        Projeto projetoSelecionado = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        boolean expResult = false;
        boolean result = instance.verificaStatusSubmetido(projetoSelecionado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaStatusReSubmetido method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testVerificaStatusReSubmetido() {
        System.out.println("verificaStatusReSubmetido");
        Projeto projetoSelecionado = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        boolean expResult = false;
        boolean result = instance.verificaStatusReSubmetido(projetoSelecionado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaStatusEmPreAvaliacao method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testVerificaStatusEmPreAvaliacao() {
        System.out.println("verificaStatusEmPreAvaliacao");
        Projeto projetoSelecionado = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        boolean expResult = false;
        boolean result = instance.verificaStatusEmPreAvaliacao(projetoSelecionado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaStatusNecessitaMelhoria method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testVerificaStatusNecessitaMelhoria() {
        System.out.println("verificaStatusNecessitaMelhoria");
        Projeto projetoSelecionado = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        boolean expResult = false;
        boolean result = instance.verificaStatusNecessitaMelhoria(projetoSelecionado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornaStatusProjeto method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testRetornaStatusProjeto() {
        System.out.println("retornaStatusProjeto");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        int expResult = 0;
        int result = instance.retornaStatusProjeto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornaResultadoAvaliacao method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testRetornaResultadoAvaliacao() {
        System.out.println("retornaResultadoAvaliacao");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        String expResult = "";
        String result = instance.retornaResultadoAvaliacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mudaStatusRedirecionaInicio method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testMudaStatusRedirecionaInicio() {
        System.out.println("mudaStatusRedirecionaInicio");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.mudaStatusRedirecionaInicio();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvarRevisaoProjeto method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSalvarRevisaoProjeto() {
        System.out.println("salvarRevisaoProjeto");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.salvarRevisaoProjeto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarCampos method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testVerificarCampos() {
        System.out.println("verificarCampos");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        int expResult = 0;
        int result = instance.verificarCampos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of terminarRevisaoProjeto method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testTerminarRevisaoProjeto() {
        System.out.println("terminarRevisaoProjeto");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.terminarRevisaoProjeto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of redirecionaPaginaAvaliacao method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testRedirecionaPaginaAvaliacao() {
        System.out.println("redirecionaPaginaAvaliacao");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.redirecionaPaginaAvaliacao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exibeCampoOutro method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testExibeCampoOutro() {
        System.out.println("exibeCampoOutro");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        boolean expResult = false;
        boolean result = instance.exibeCampoOutro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of caucularProjecaoCustoFixo method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testCaucularProjecaoCustoFixo() {
        System.out.println("caucularProjecaoCustoFixo");
        Custo custo = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.caucularProjecaoCustoFixo(custo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of caucularProjecaoCustoVariavel method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testCaucularProjecaoCustoVariavel() {
        System.out.println("caucularProjecaoCustoVariavel");
        Custo custo = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.caucularProjecaoCustoVariavel(custo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onRowEdit method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testOnRowEdit() {
        System.out.println("onRowEdit");
        RowEditEvent event = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.onRowEdit(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onRowCancel method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testOnRowCancel() {
        System.out.println("onRowCancel");
        RowEditEvent event = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.onRowCancel(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletarLinha method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testDeletarLinha() {
        System.out.println("deletarLinha");
        Custo custo = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.deletarLinha(custo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionarLinhaFixo method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testAdicionarLinhaFixo() {
        System.out.println("adicionarLinhaFixo");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.adicionarLinhaFixo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionarLinhaVariavel method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testAdicionarLinhaVariavel() {
        System.out.println("adicionarLinhaVariavel");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.adicionarLinhaVariavel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularValorColunaCustoFixo method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testCalcularValorColunaCustoFixo() {
        System.out.println("calcularValorColunaCustoFixo");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        int expResult = 0;
        int result = instance.calcularValorColunaCustoFixo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularValorColunaCustoVariavel method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testCalcularValorColunaCustoVariavel() {
        System.out.println("calcularValorColunaCustoVariavel");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        int expResult = 0;
        int result = instance.calcularValorColunaCustoVariavel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjeto method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetProjeto() {
        System.out.println("getProjeto");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        Projeto expResult = null;
        Projeto result = instance.getProjeto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProjeto method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetProjeto() {
        System.out.println("setProjeto");
        Projeto projeto = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.setProjeto(projeto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComentarioProjeto method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetComentarioProjeto() {
        System.out.println("getComentarioProjeto");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        ComentarioProjeto expResult = null;
        ComentarioProjeto result = instance.getComentarioProjeto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComentarioProjeto method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetComentarioProjeto() {
        System.out.println("setComentarioProjeto");
        ComentarioProjeto comentarioProjeto = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.setComentarioProjeto(comentarioProjeto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoginBean method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetLoginBean() {
        System.out.println("getLoginBean");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        LoginBean expResult = null;
        LoginBean result = instance.getLoginBean();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoginBean method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetLoginBean() {
        System.out.println("setLoginBean");
        LoginBean loginBean = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.setLoginBean(loginBean);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstagioEvolucao method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetEstagioEvolucao() {
        System.out.println("getEstagioEvolucao");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        String expResult = "";
        String result = instance.getEstagioEvolucao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstagioEvolucao method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetEstagioEvolucao() {
        System.out.println("setEstagioEvolucao");
        String estagioEvolucao = "";
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.setEstagioEvolucao(estagioEvolucao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstagioEvolucaoOutro method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetEstagioEvolucaoOutro() {
        System.out.println("getEstagioEvolucaoOutro");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        String expResult = "";
        String result = instance.getEstagioEvolucaoOutro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstagioEvolucaoOutro method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetEstagioEvolucaoOutro() {
        System.out.println("setEstagioEvolucaoOutro");
        String estagioEvolucaoOutro = "";
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.setEstagioEvolucaoOutro(estagioEvolucaoOutro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCustoFixo method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetListaCustoFixo() {
        System.out.println("getListaCustoFixo");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        List<Custo> expResult = null;
        List<Custo> result = instance.getListaCustoFixo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaCustoFixo method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetListaCustoFixo() {
        System.out.println("setListaCustoFixo");
        List<Custo> listaCustoFixo = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.setListaCustoFixo(listaCustoFixo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCustoVariavel method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetListaCustoVariavel() {
        System.out.println("getListaCustoVariavel");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        List<Custo> expResult = null;
        List<Custo> result = instance.getListaCustoVariavel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaCustoVariavel method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetListaCustoVariavel() {
        System.out.println("setListaCustoVariavel");
        List<Custo> listaCustoVariavel = null;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.setListaCustoVariavel(listaCustoVariavel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSomatorioFixo method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetSomatorioFixo() {
        System.out.println("getSomatorioFixo");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        int expResult = 0;
        int result = instance.getSomatorioFixo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSomatorioFixo method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetSomatorioFixo() {
        System.out.println("setSomatorioFixo");
        int somatorioFixo = 0;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.setSomatorioFixo(somatorioFixo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSomatorioVariavel method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetSomatorioVariavel() {
        System.out.println("getSomatorioVariavel");
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        int expResult = 0;
        int result = instance.getSomatorioVariavel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSomatorioVariavel method, of class revisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetSomatorioVariavel() {
        System.out.println("setSomatorioVariavel");
        int somatorioVariavel = 0;
        revisarPlanoDeNegocioBean instance = new revisarPlanoDeNegocioBean();
        instance.setSomatorioVariavel(somatorioVariavel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
