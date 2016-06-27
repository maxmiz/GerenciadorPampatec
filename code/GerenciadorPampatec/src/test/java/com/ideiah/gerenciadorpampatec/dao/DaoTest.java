/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import com.ideiah.gerenciadorpampatec.model.Planofinanceiro;
import com.ideiah.gerenciadorpampatec.model.Projeto;
import com.ideiah.gerenciadorpampatec.model.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Peterson
 */
public class DaoTest {

    private static final int CODIGO_EMPREENDEDOR = 99999999;

    Dao instance;

    public DaoTest() {
    }

    @Before
    public void setUp() {
        instance = new DaoImpl();

    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Salvar um Empreendedor;
     */
    @Test
    public void testSalvar1() {
        Usuario empreendedor = new Empreendedor();
        Usuario result = (Usuario) instance.salvar(empreendedor);
        assertNotNull("Criando um obj não adicionando e-mail. Espero que salve", result);
        instance.excluir(result.getIdUsuario(), Usuario.class);
    }

    /**
     * Salvar um Empreendedor nulo;
     */
    @Test
    public void testSalvar2() {
        Empreendedor empreendedor = null;
        Usuario result = (Usuario) instance.salvar(empreendedor);
        assertNull("Criando um obj vazio. Espero que não salve", result);
        if (result != null) {
            instance.excluir(result.getIdUsuario(), Usuario.class);
        }
    }

    /**
     * Test of update method, of class Dao.
     */
    @Test
    public void testUpdate() {
        Usuario empreendedor = new Empreendedor();
        empreendedor.setNome("Nome Antes");
        Usuario result = (Usuario) instance.salvar(empreendedor);
        result.setNome("Nome Depois");
        result = (Usuario) instance.update(result);
        assertEquals("Criando um obj não adicionando e-mail. Espero que salve","Nome Depois", result.getNome());
        instance.excluir(result.getIdUsuario(), Usuario.class);
    }

    /**
     * Teste de excluir um objeto da dao.
     */
    @Test
    public void testExcluir1() {
        Usuario usuario = new Empreendedor();
        usuario = (Usuario) instance.salvar(usuario);
        boolean result = instance.excluir(usuario.getIdUsuario(), Empreendedor.class);
        assertTrue("Excluindo objeto. Espero que exclua", result);
    }
    
    /**
     * Teste de excluir um objeto da dao que não existe.
     */
    @Test
    public void testExcluir2() {
        boolean result = instance.excluir(-1, Empreendedor.class);
        assertFalse("Excluindo objeto que não existe. Espero que não exclua", result);
    }
    
    /**
     * Teste de excluir um objeto da dao.
     */
    @Test
    public void testExcluirString1() {
        Usuario usuario = new Empreendedor();
        String id;
        usuario = (Usuario) instance.salvar(usuario);
        id = ""+usuario.getIdUsuario();
        boolean result = instance.excluir(id, Empreendedor.class);
        assertTrue("Excluindo objeto. Espero que exclua", result);
    }
    
    /**
     * Teste de excluir um objeto da dao que não existe.
     */
    @Test
    public void testExcluir2String() {
        boolean result = instance.excluir("1", Empreendedor.class);
        assertFalse("Excluindo objeto que não existe. Espero que não exclua", result);
    }

    /**
     * Testa busca Objetos no banco de dados.
     */
    @Test
    public void testBuscarObjetos() {
        ArrayList result = instance.buscarObjetos(Usuario.class);
        assertNotNull(result);
    }
    
    /**
     * Testa o método de buscar objetos com critérios. Primeiro cria objetos no
     * banco com status diferentes para garantir que o banco esteja preenchdi.
     * Depois busca os objetos com um critério definido. Depois se os objetos
     * retornados respeitam os critérios estabelecidos. Depois apaga os registros
     * criados.
     */
    @Test
    public void testBuscarObjetosCriteria() {
        boolean flag = false;
        Projeto projeto = new Projeto();
        Projeto projetoStatus2 = new Projeto();
        projeto.setStatus(1);
        projetoStatus2.setStatus(2);
        projeto = (Projeto) instance.salvar(projeto);
        projetoStatus2 = (Projeto) instance.salvar(projetoStatus2);
        ArrayList<Projeto> result = (ArrayList<Projeto>) instance.buscarObjetosCritera("status",
                1,Projeto.class);
        for (Projeto projetoLaco : result) {
            if(projetoLaco.getStatus() != 1){
                flag = true;
                break;
            }
        }
        assertFalse(flag);
        instance.excluir(projeto.getIdProjeto(), Projeto.class);
        instance.excluir(projetoStatus2.getIdProjeto(), Projeto.class);
    }

    /**
     * Test of getTx method, of class Dao.
     */
    @Ignore
    public void testGetTx() {
        System.out.println("getTx");
        Dao instance = new DaoImpl();
        Transaction expResult = null;
        Transaction result = instance.getTx();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTx method, of class Dao.
     */
    @Ignore
    public void testSetTx() {
        System.out.println("setTx");
        Transaction tx = null;
        Dao instance = new DaoImpl();
        instance.setTx(tx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSession method, of class Dao.
     */
    @Ignore
    public void testGetSession() {
        System.out.println("getSession");
        Dao instance = new DaoImpl();
        Session expResult = null;
        Session result = instance.getSession();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSession method, of class Dao.
     */
    @Ignore
    public void testSetSession() {
        System.out.println("setSession");
        Session session = null;
        Dao instance = new DaoImpl();
        instance.setSession(session);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class DaoImpl extends Dao {
    }

}
