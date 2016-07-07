/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.model;

import com.ideiah.gerenciadorpampatec.dao.EmpreendedorDao;
import com.ideiah.gerenciadorpampatec.dao.ProjetoDao;
import java.util.ArrayList;
import java.util.HashSet;
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
 * @author Unipampa
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
    @Test
    public void testConstrutorEmpreededor() {
        System.out.println("testConstrutorEmpreededor");
        String nome = "";
        String cpf = "";
        String formacao = "";
        String email = "";
        String telefone = "";
        String experiencia = "";
        String participacaoAcionaria = "";
        Set projetos = new HashSet(0);
        Set<Notificacao> notificacoes = new HashSet<>();

        Empreendedor empreendedor = new Empreendedor(Integer.MIN_VALUE,
                nome, telefone, cpf, email, formacao, experiencia, participacaoAcionaria, projetos, notificacoes);
        assertNotNull(empreendedor);
    }

    /**
     * Test of getEmpreededorDao method, of class Empreendedor.
     */
    @Test
    public void testConstrutorEmpreededor2() {
        System.out.println("testConstrutorEmpreededor2");
        String nome = "";
        String cpf = "";
        String formacao = "";
        String email = "";
        String senha = "";
        String telefone = "";
        String rua = "";
        String bairro = "";
        String complemento = "";
        Empreendedor empreendedor = new Empreendedor(Integer.MIN_VALUE,
                nome, cpf, formacao, email, senha, telefone, rua, 0, bairro, complemento);
        assertNotNull(empreendedor);
    }

    /**
     * Test of getEmpreededorDao method, of class Empreendedor.
     */
    @Test
    public void testConstrutorEmpreededor3() {
        System.out.println("testConstrutorEmpreededor3");
        String nome = "";
        String cpf = "";
        String formacao = "";
        String email = "";
        String senha = "";
        String telefone = "";
        String experiencia = "";
        String participacaoAcionaria = "";
        String competencia = "";
        Set projetos = new HashSet(0);
        Set<Notificacao> notificacoes = new HashSet<>();
        Empreendedor empreendedor = new Empreendedor(Integer.MIN_VALUE,
                nome, telefone, cpf, email, formacao, experiencia, competencia, participacaoAcionaria, projetos, notificacoes, senha);
        assertNotNull(empreendedor);
    }

    /**
     * Test of getEmpreededorDao method, of class Empreendedor.
     */
    @Test
    public void testGetEmpreededorDao() {
        System.out.println("getEmpreededorDao");
        EmpreendedorDao result = Empreendedor.getEmpreededorDao();
        assertNotNull(result);

    }

    /**
     * Test of setIdUnico method, of class Empreendedor.
     */
    @Test
    public void testSetIdUnico() {
        System.out.println("setIdUnico");
        String idUnico = "";
        Empreendedor instance = new Empreendedor();
        instance.setIdUnico(idUnico);
    }

    /**
     * Test of getIdUnico method, of class Empreendedor.
     */
    @Test
    public void testGetIdUnico() {
        System.out.println("getIdUnico");
        Empreendedor instance = new Empreendedor();
        String expResult = "";
        instance.setIdUnico(expResult);
        String result = instance.getIdUnico();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProjetoDao method, of class Empreendedor.
     */
    @Test
    public void testGetProjetoDao() {
        System.out.println("getProjetoDao");
        ProjetoDao result = Empreendedor.getProjetoDao();
        assertNotNull(result);
    }

    /**
     * Test of retornaStatus method, of class Empreendedor.
     */
    @Test
    public void testRetornaStatus() {
        System.out.println("retornaStatus");
        Empreendedor instance = new Empreendedor();
        String expResult = "Cadastro Incompleto";
        String result = instance.retornaStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornaStatus method, of class Empreendedor.
     */
    @Test
    public void testRetornaStatus2() {
        System.out.println("retornaStatus2");
        Empreendedor instance = new Empreendedor();
        instance.setCpf("000.000.000-00");
        String expResult = "Cadastro Completo";
        String result = instance.retornaStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of retornaTipoEmpreendedor method, of class Empreendedor.
     */
    @Test
    public void testRetornaTipoEmpreendedor() {
        System.out.println("retornaTipoEmpreendedor");
        Empreendedor empreendedorCorrespondente = new Empreendedor();
        Empreendedor instance = new Empreendedor();
        String expResult = "Empreendedor Correspondente";
        String result = instance.retornaTipoEmpreendedor(empreendedorCorrespondente);
        assertEquals(expResult, result);
    }

    /**
     * Test of retornaTipoEmpreendedor method, of class Empreendedor.
     */
    @Test
    public void testRetornaTipoEmpreendedor2() {
        System.out.println("retornaTipoEmpreendedor2");
        Empreendedor empreendedorCorrespondente = new Empreendedor();
        empreendedorCorrespondente.setIdUsuario(10);
        Empreendedor instance = new Empreendedor();
        instance.setIdUsuario(5);
        String expResult = "Empreendedor Observador";
        String result = instance.retornaTipoEmpreendedor(empreendedorCorrespondente);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaTipoEmpreendedor method, of class Empreendedor.
     */
    @Test
    public void testVerificaTipoEmpreendedor() {
        System.out.println("verificaTipoEmpreendedor");
        Empreendedor empreendedorCorrespondente = new Empreendedor();
        String idUnico = "1003";
        empreendedorCorrespondente.setIdUnico(idUnico);
        Empreendedor instance = new Empreendedor();
        boolean expResult = true;
        boolean result = instance.verificaTipoEmpreendedor(empreendedorCorrespondente);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormacao method, of class Empreendedor.
     */
    @Test
    public void testGetFormacao() {
        System.out.println("getFormacao");
        Empreendedor instance = new Empreendedor();
        String expResult = "";
        instance.setFormacao(expResult);
        String result = instance.getFormacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFormacao method, of class Empreendedor.
     */
    @Test
    public void testSetFormacao() {
        System.out.println("setFormacao");
        String formacao = "";
        Empreendedor instance = new Empreendedor();
        instance.setFormacao(formacao);
    }

    /**
     * Test of getExperiencia method, of class Empreendedor.
     */
    @Test
    public void testGetExperiencia() {
        System.out.println("getExperiencia");
        Empreendedor instance = new Empreendedor();
        String expResult = "";
        instance.setExperiencia(expResult);
        String result = instance.getExperiencia();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExperiencia method, of class Empreendedor.
     */
    @Test
    public void testSetExperiencia() {
        System.out.println("setExperiencia");
        String experiencia = "";
        Empreendedor instance = new Empreendedor();
        instance.setExperiencia(experiencia);
    }

    /**
     * Test of getProjetos method, of class Empreendedor.
     */
    @Test
    public void testGetProjetos() {
        System.out.println("getProjetos");
        Empreendedor instance = new Empreendedor();
        Set expResult = null;
        instance.setProjetos(expResult);
        Set result = instance.getProjetos();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of verificaDadosEmpreendedores method, of class Empreendedor.
     */
    @Test
    public void testVerificaDadosEmpreendedores() {
        System.out.println("verificaDadosEmpreendedores");
        Empreendedor instance = new Empreendedor();
        Projeto projeto = new Projeto();
        Set empreendedores = new HashSet(0);
        empreendedores.add(instance);
        projeto.setEmpreendedores(empreendedores);
        boolean expResult = false;
        boolean result = instance.verificaDadosEmpreendedores(projeto);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaDadosEmpreendedores method, of class Empreendedor.
     */
    @Test
    public void testVerificaDadosEmpreendedores2() {
        System.out.println("verificaDadosEmpreendedores2");
        Empreendedor instance = new Empreendedor();
        instance.setCpf("");
        Projeto projeto = new Projeto();
        Set empreendedores = new HashSet(0);
        empreendedores.add(instance);
        projeto.setEmpreendedores(empreendedores);
        boolean expResult = true;
        boolean result = instance.verificaDadosEmpreendedores(projeto);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificaDadosEmpreendedor method, of class Empreendedor.
     */
    @Test
    public void testVerificaDadosEmpreendedor() {
        System.out.println("verificaDadosEmpreendedor");
        Empreendedor empreendedor = new Empreendedor();
        String cpf = null;
        boolean expResult = false;
        empreendedor.setCpf(cpf);
        boolean result = Empreendedor.verificaDadosEmpreendedor(empreendedor);
        assertEquals(expResult, result);
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
    }

    /**
     * Test of realizarCadastro method, of class Empreendedor.
     */
    @Ignore
    public void testRealizarCadastro() {
        System.out.println("realizarCadastro");
        Empreendedor instance = new Empreendedor();
        instance.realizarCadastro();
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
    }

    /**
     * Test of getNumero method, of class Empreendedor.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        Empreendedor instance = new Empreendedor();
        Integer expResult = null;
        instance.setNumero(expResult);
        Integer result = instance.getNumero();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumero method, of class Empreendedor.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        Integer numero = null;
        Empreendedor instance = new Empreendedor();
        instance.setNumero(numero);
    }

    /**
     * Test of getComplemento method, of class Empreendedor.
     */
    @Test
    public void testGetComplemento() {
        System.out.println("getComplemento");
        Empreendedor instance = new Empreendedor();
        String expResult = "";
        instance.setComplemento(expResult);
        String result = instance.getComplemento();
        assertEquals(expResult, result);
    }

    /**
     * Test of setComplemento method, of class Empreendedor.
     */
    @Test
    public void testSetComplemento() {
        System.out.println("setComplemento");
        String complemento = "";
        Empreendedor instance = new Empreendedor();
        instance.setComplemento(complemento);
    }

    /**
     * Test of getBairro method, of class Empreendedor.
     */
    @Test
    public void testGetBairro() {
        System.out.println("getBairro");
        Empreendedor instance = new Empreendedor();
        String expResult = "";
        instance.setBairro(expResult);
        String result = instance.getBairro();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBairro method, of class Empreendedor.
     */
    @Test
    public void testSetBairro() {
        System.out.println("setBairro");
        String bairro = "";
        Empreendedor instance = new Empreendedor();
        instance.setBairro(bairro);
    }

    /**
     * Test of getRua method, of class Empreendedor.
     */
    @Test
    public void testGetRua() {
        System.out.println("getRua");
        Empreendedor instance = new Empreendedor();
        String expResult = "";
        instance.setRua(expResult);
        String result = instance.getRua();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRua method, of class Empreendedor.
     */
    @Test
    public void testSetRua() {
        System.out.println("setRua");
        String rua = "";
        Empreendedor instance = new Empreendedor();
        instance.setRua(rua);
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
    }

    /**
     * Test of getNotificacoes method, of class Empreendedor.
     */
    @Test
    public void testGetNotificacoes() {
        System.out.println("getNotificacoes");
        Empreendedor instance = new Empreendedor();
        Set<Notificacao> expResult = new HashSet<>();

        instance.setNotificacoes(expResult);
        Set<Notificacao> result = instance.getNotificacoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNotificacoes method, of class Empreendedor.
     */
    @Test
    public void testSetNotificacoes() {
        System.out.println("setNotificacoes");
        Set<Notificacao> notificacoes = null;
        Empreendedor instance = new Empreendedor();
        instance.setNotificacoes(notificacoes);
    }

    /**
     * Test of getQuantidadeDeNotificacoes method, of class Empreendedor.
     */
    @Test
    public void testGetQuantidadeDeNotificacoes() {
        System.out.println("getQuantidadeDeNotificacoes");
        Empreendedor instance = new Empreendedor();
        Set<Notificacao> ns;
        ns = new HashSet<>();
        Notificacao notificacao = new Notificacao();
        ns.add(notificacao);
        instance.setNotificacoes(ns);
        int expResult = ns.size();
        int result = instance.getQuantidadeDeNotificacoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuantidadeDeNotificacoes method, of class Empreendedor.
     */
    @Test
    public void testGetQuantidadeDeNotificacoes2() {
        System.out.println("getQuantidadeDeNotificacoes2");
        Empreendedor instance = new Empreendedor();
        Set<Notificacao> ns;
        ns = new HashSet<>();
        Notificacao notificacao = new Notificacao();
        notificacao.setVisualizado(true);
        ns.add(notificacao);
        instance.setNotificacoes(ns);
        int expResult = ns.size();
        int result = instance.getQuantidadeDeNotificacoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescricaoDasNotificacoes method, of class Empreendedor.
     */
    @Test
    public void testGetDescricaoDasNotificacoes() {
        System.out.println("getDescricaoDasNotificacoes");
        Empreendedor instance = new Empreendedor();
        Set<Notificacao> ns = new HashSet<>();
        Notificacao notificacao = new Notificacao();
        ns.add(notificacao);
        instance.setNotificacoes(ns);
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add(null);
        ArrayList<String> result = instance.getDescricaoDasNotificacoes();
        assertEquals(expResult, result);
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
    }

}
