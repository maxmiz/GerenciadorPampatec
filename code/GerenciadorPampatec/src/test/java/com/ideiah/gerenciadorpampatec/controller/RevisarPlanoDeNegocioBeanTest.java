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
@Ignore
public class RevisarPlanoDeNegocioBeanTest {
    
    public SessionBean sb;
    
    public RevisarPlanoDeNegocioBeanTest() {
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
     * Test of verificaExistenciaComentarioProjeto method, of class RevisarPlanoDeNegocioBean.
     */
    @Test
    public void testVerificaExistenciaComentarioProjeto() {
        System.out.println("verificaExistenciaComentarioProjeto");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
//        instance.setSessionBean(sb);
        Projeto projetoSelecionado = new Projeto();
        projetoSelecionado.setStatus(Projeto.ACEITO_PARA_AVALIACAO);
        boolean expResult = false;
        boolean result = instance.verificaExistenciaComentarioProjeto(projetoSelecionado);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaStatusSendoAvaliado method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testVerificaStatusSendoAvaliado() {
        System.out.println("verificaStatusSendoAvaliado");
        Projeto projetoSelecionado = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        boolean expResult = false;
        boolean result = instance.verificaStatusSendoAvaliado(projetoSelecionado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaStatusAceitoAvaliacao method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testVerificaStatusAceitoAvaliacao() {
        System.out.println("verificaStatusAceitoAvaliacao");
        Projeto projetoSelecionado = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        boolean expResult = false;
        boolean result = instance.verificaStatusAceitoAvaliacao(projetoSelecionado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaStatusRevisando method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testVerificaStatusRevisando() {
        System.out.println("verificaStatusRevisando");
        Projeto projetoSelecionado = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        boolean expResult = false;
        boolean result = instance.verificaStatusRevisando(projetoSelecionado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaStatusSubmetido method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testVerificaStatusSubmetido() {
        System.out.println("verificaStatusSubmetido");
        Projeto projetoSelecionado = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        boolean expResult = false;
        boolean result = instance.verificaStatusSubmetido(projetoSelecionado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaStatusReSubmetido method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testVerificaStatusReSubmetido() {
        System.out.println("verificaStatusReSubmetido");
        Projeto projetoSelecionado = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        boolean expResult = false;
        boolean result = instance.verificaStatusReSubmetido(projetoSelecionado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaStatusEmPreAvaliacao method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testVerificaStatusEmPreAvaliacao() {
        System.out.println("verificaStatusEmPreAvaliacao");
        Projeto projetoSelecionado = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        boolean expResult = false;
        boolean result = instance.verificaStatusEmPreAvaliacao(projetoSelecionado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaStatusNecessitaMelhoria method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testVerificaStatusNecessitaMelhoria() {
        System.out.println("verificaStatusNecessitaMelhoria");
        Projeto projetoSelecionado = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        boolean expResult = false;
        boolean result = instance.verificaStatusNecessitaMelhoria(projetoSelecionado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornaStatusProjeto method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testRetornaStatusProjeto() {
        System.out.println("retornaStatusProjeto");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        int expResult = 0;
        int result = instance.retornaStatusProjeto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retornaResultadoAvaliacao method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testRetornaResultadoAvaliacao() {
        System.out.println("retornaResultadoAvaliacao");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        String expResult = "";
        String result = instance.retornaResultadoAvaliacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mudaStatusRedirecionaInicio method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testMudaStatusRedirecionaInicio() {
        System.out.println("mudaStatusRedirecionaInicio");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.mudaStatusRedirecionaInicio();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvarRevisaoProjeto method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSalvarRevisaoProjeto() {
        System.out.println("salvarRevisaoProjeto");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.salvarRevisaoProjeto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarCampos method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testVerificarCampos() {
        System.out.println("verificarCampos");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        int expResult = 0;
        int result = instance.verificarCampos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of terminarRevisaoProjeto method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testTerminarRevisaoProjeto() {
        System.out.println("terminarRevisaoProjeto");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.terminarRevisaoProjeto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of redirecionaPaginaAvaliacao method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testRedirecionaPaginaAvaliacao() {
        System.out.println("redirecionaPaginaAvaliacao");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.redirecionaPaginaAvaliacao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exibeCampoOutro method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testExibeCampoOutro() {
        System.out.println("exibeCampoOutro");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        boolean expResult = false;
        boolean result = instance.exibeCampoOutro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of caucularProjecaoCustoFixo method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testCaucularProjecaoCustoFixo() {
        System.out.println("caucularProjecaoCustoFixo");
        Custo custo = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.caucularProjecaoCustoFixo(custo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of caucularProjecaoCustoVariavel method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testCaucularProjecaoCustoVariavel() {
        System.out.println("caucularProjecaoCustoVariavel");
        Custo custo = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.caucularProjecaoCustoVariavel(custo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onRowEdit method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testOnRowEdit() {
        System.out.println("onRowEdit");
        RowEditEvent event = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.onRowEdit(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onRowCancel method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testOnRowCancel() {
        System.out.println("onRowCancel");
        RowEditEvent event = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.onRowCancel(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletarLinha method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testDeletarLinha() {
        System.out.println("deletarLinha");
        Custo custo = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.deletarLinha(custo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionarLinhaFixo method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testAdicionarLinhaFixo() {
        System.out.println("adicionarLinhaFixo");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.adicionarLinhaFixo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionarLinhaVariavel method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testAdicionarLinhaVariavel() {
        System.out.println("adicionarLinhaVariavel");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.adicionarLinhaVariavel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularValorColunaCustoFixo method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testCalcularValorColunaCustoFixo() {
        System.out.println("calcularValorColunaCustoFixo");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        int expResult = 0;
        int result = instance.calcularValorColunaCustoFixo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularValorColunaCustoVariavel method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testCalcularValorColunaCustoVariavel() {
        System.out.println("calcularValorColunaCustoVariavel");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        int expResult = 0;
        int result = instance.calcularValorColunaCustoVariavel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProjeto method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetProjeto() {
        System.out.println("getProjeto");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        Projeto expResult = null;
        Projeto result = instance.getProjeto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProjeto method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetProjeto() {
        System.out.println("setProjeto");
        Projeto projeto = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.setProjeto(projeto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComentarioProjeto method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetComentarioProjeto() {
        System.out.println("getComentarioProjeto");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        ComentarioProjeto expResult = null;
        ComentarioProjeto result = instance.getComentarioProjeto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComentarioProjeto method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetComentarioProjeto() {
        System.out.println("setComentarioProjeto");
        ComentarioProjeto comentarioProjeto = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.setComentarioProjeto(comentarioProjeto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoginBean method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetLoginBean() {
        System.out.println("getLoginBean");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
//        RedirectManager expResult = null;
//        RedirectManager result = instance.getLoginBean();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoginBean method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetLoginBean() {
        System.out.println("setLoginBean");
        RedirectManager loginBean = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
//        instance.setLoginBean(loginBean);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstagioEvolucao method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetEstagioEvolucao() {
        System.out.println("getEstagioEvolucao");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        String expResult = "";
        String result = instance.getEstagioEvolucao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstagioEvolucao method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetEstagioEvolucao() {
        System.out.println("setEstagioEvolucao");
        String estagioEvolucao = "";
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.setEstagioEvolucao(estagioEvolucao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstagioEvolucaoOutro method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetEstagioEvolucaoOutro() {
        System.out.println("getEstagioEvolucaoOutro");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        String expResult = "";
        String result = instance.getEstagioEvolucaoOutro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstagioEvolucaoOutro method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetEstagioEvolucaoOutro() {
        System.out.println("setEstagioEvolucaoOutro");
        String estagioEvolucaoOutro = "";
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.setEstagioEvolucaoOutro(estagioEvolucaoOutro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCustoFixo method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetListaCustoFixo() {
        System.out.println("getListaCustoFixo");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        List<Custo> expResult = null;
        List<Custo> result = instance.getListaCustoFixo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaCustoFixo method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetListaCustoFixo() {
        System.out.println("setListaCustoFixo");
        List<Custo> listaCustoFixo = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.setListaCustoFixo(listaCustoFixo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCustoVariavel method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetListaCustoVariavel() {
        System.out.println("getListaCustoVariavel");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        List<Custo> expResult = null;
        List<Custo> result = instance.getListaCustoVariavel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaCustoVariavel method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetListaCustoVariavel() {
        System.out.println("setListaCustoVariavel");
        List<Custo> listaCustoVariavel = null;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.setListaCustoVariavel(listaCustoVariavel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSomatorioFixo method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetSomatorioFixo() {
        System.out.println("getSomatorioFixo");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        int expResult = 0;
        int result = instance.getSomatorioFixo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSomatorioFixo method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetSomatorioFixo() {
        System.out.println("setSomatorioFixo");
        int somatorioFixo = 0;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.setSomatorioFixo(somatorioFixo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSomatorioVariavel method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testGetSomatorioVariavel() {
        System.out.println("getSomatorioVariavel");
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        int expResult = 0;
        int result = instance.getSomatorioVariavel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSomatorioVariavel method, of class RevisarPlanoDeNegocioBean.
     */
    @Ignore
    public void testSetSomatorioVariavel() {
        System.out.println("setSomatorioVariavel");
        int somatorioVariavel = 0;
        RevisarPlanoDeNegocioBean instance = new RevisarPlanoDeNegocioBean();
        instance.setSomatorioVariavel(somatorioVariavel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
