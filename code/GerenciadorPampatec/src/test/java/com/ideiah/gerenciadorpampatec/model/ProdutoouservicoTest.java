/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrigo
 */
public class ProdutoouservicoTest {
    
    int id = 1;
    String estagioEvolucao = "estagio";
    String tecnologiaProcessos = "tecnologia";
    String potencialInovacaoTecnologica = "potencial";
    String aplicacoes = "aplicacoes";
    String dificuldadesEsperadas = "dificuldades";
    String interacaoEmpresaUniversidade = "interacaoEU";
    String interacaoEmpresaComunidadeGoverno = "interacaoECG";
    String infraestrutura = "infra";
    Set<Projeto> projetos = new HashSet<>();
    Projeto projeto = new Projeto();
    
    public ProdutoouservicoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        projetos.add(projeto);
    }
    
    @After
    public void tearDown() {
    }

    
    
    
    /**
     * Test of verificaStatusProjeto method, of class Produtoouservico.
     * case Ideiah Basica
     */
    @Test
    public void testVerificaStatusProjeto() {
        String status = "Ideia Básica";
        Produtoouservico instance = new Produtoouservico();
        String expResult = Produtoouservico.IDEIA_BASICA;
        String result = instance.verificaStatusProjeto(status);
        assertEquals(expResult, result);
    }
    /**
     * Test of verificaStatusProjeto method, of class Produtoouservico.
     * case Cliente Pagando
     */
    @Test
    public void testVerificaStatusProjeto2() {
        String status = "Clientes Pagando";
        Produtoouservico instance = new Produtoouservico();
        String expResult = Produtoouservico.CLIENTES_PAGANDO;
        String result = instance.verificaStatusProjeto(status);
        assertEquals(expResult, result);
    }
     /**
     * Test of verificaStatusProjeto method, of class Produtoouservico.
     * case Projeto Básico
     */
    @Test
    public void testVerificaStatusProjeto3() {
        String status = "Projeto Básico";
        Produtoouservico instance = new Produtoouservico();
        String expResult = Produtoouservico.PROJETO_BASICO;
        String result = instance.verificaStatusProjeto(status);
        assertEquals(expResult, result);
    }
     /**
     * Test of verificaStatusProjeto method, of class Produtoouservico.
     * case Em teste no mercado
     */
    @Test
    public void testVerificaStatusProjeto4() {
        String status = "Em teste no mercado";
        Produtoouservico instance = new Produtoouservico();
        String expResult = Produtoouservico.EM_TESTE_NO_MERCADO;
        String result = instance.verificaStatusProjeto(status);
        assertEquals(expResult, result);
    }
     /**
     * Test of verificaStatusProjeto method, of class Produtoouservico.
     * case Projeto Detalhado
     */
    @Test
    public void testVerificaStatusProjeto5() {
        String status = "Projeto Detalhado";
        Produtoouservico instance = new Produtoouservico();
        String expResult = Produtoouservico.PROJETO_DETALHADO;
        String result = instance.verificaStatusProjeto(status);
        assertEquals(expResult, result);
    }
     /**
     * Test of verificaStatusProjeto method, of class Produtoouservico.
     * case Protótipo Desenvolvido
     */
    @Test
    public void testVerificaStatusProjeto6() {
        String status = "Protótipo Desenvolvido";
        Produtoouservico instance = new Produtoouservico();
        String expResult = Produtoouservico.PROTOTIPO_DESENVOLVIDO;
        String result = instance.verificaStatusProjeto(status);
        assertEquals(expResult, result);
    }
     /**
     * Test of verificaStatusProjeto method, of class Produtoouservico.
     * case Protótipo Desenvolvido
     */
    @Test
    public void testVerificaStatusProjeto7() {
        String status = "AEHOOOO";
        Produtoouservico instance = new Produtoouservico();
        String expResult = "Outro:";
        String result = instance.verificaStatusProjeto(status);
        assertEquals(expResult, result);
    }
         /**
     * Test of verificaStatusProjeto method, of class Produtoouservico.
     * com status null
     */
    @Test
    public void testVerificaStatusProjeto8() {
        String status = null;
        Produtoouservico instance = new Produtoouservico();
        String expResult = "Status Indefinido";
        String result = instance.verificaStatusProjeto(status);
        assertEquals(expResult, result);
    }
    /**
     * Test do Construtor
     */
    public void testProdutoServico1(){
        Produtoouservico produtoouservico = new Produtoouservico(id, estagioEvolucao);
    
        assertEquals(id, produtoouservico.getIdProdutoOuServico());
        assertEquals(estagioEvolucao, produtoouservico.getEstagioEvolucao());
}
    /**
     * Test de Contrutor
     */
    public void testProdutoServico2(){
        Produtoouservico produtoouservico = new Produtoouservico(id, estagioEvolucao, tecnologiaProcessos, potencialInovacaoTecnologica, aplicacoes, dificuldadesEsperadas, interacaoEmpresaUniversidade, interacaoEmpresaComunidadeGoverno, infraestrutura, projetos);
    
        assertEquals(id, produtoouservico.getIdProdutoOuServico());
        assertEquals(estagioEvolucao, produtoouservico.getEstagioEvolucao());
        assertEquals(tecnologiaProcessos, produtoouservico.getTecnologiaProcessos());
        assertEquals(potencialInovacaoTecnologica, produtoouservico.getPotencialInovacaoTecnologica());
        assertEquals(aplicacoes, produtoouservico.getAplicacoes());
        assertEquals(dificuldadesEsperadas, produtoouservico.getDificuldadesEsperadas());
        assertEquals(interacaoEmpresaUniversidade, produtoouservico.getInteracaoEmpresaUniversidade());
        assertEquals(interacaoEmpresaComunidadeGoverno, produtoouservico.getInteracaoEmpresaComunidadeGoverno());
        assertEquals(infraestrutura, produtoouservico.getInfraestrutura());
        assertEquals(projetos, produtoouservico.getProjetos());
}
        
}
