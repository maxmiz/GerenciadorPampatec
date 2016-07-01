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
@Ignore
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
    
     public class DaoImpl extends Dao {
    }

    /**
     * Salvar um Empreendedor;
     */
    @Test
    public void testSalvar1() {
        Usuario empreendedor = new Empreendedor();
        empreendedor.setCpf("71957794240");
        Usuario result = (Usuario) instance.salvar(empreendedor);
        Usuario expected = (Usuario) instance.buscarObjetoCriteria("cpf", "71957794240", Empreendedor.class);
        assertEquals(expected, result);
        instance.excluir(result.getIdUsuario(), Usuario.class);
    }

    /**
     * Salvar um Empreendedor nulo;
     */
    @Test
    public void testSalvar2() {
        Empreendedor empreendedor = null;
        Usuario result = (Usuario) instance.salvar(empreendedor);
        assertNull(result);
        if (result != null) {
            instance.excluir(result.getIdUsuario(), Usuario.class);
        }
    }

    /**
     * Test of update method, of class Dao.
     */
    @Test
    public void testUpdatePositivo() {
        Usuario empreendedor = new Empreendedor();
        empreendedor.setNome("Nome Antes");
        Usuario result = (Usuario) instance.salvar(empreendedor);
        result.setNome("Nome Depois");
        instance.update(result);
        Usuario expected = (Usuario) instance.buscarObjetoCriteria("nome", "Nome Depois", Empreendedor.class);
        assertEquals(expected.getNome(), result.getNome());
        instance.excluir(result.getIdUsuario(), Usuario.class);
    }

    /**
     * Teste de excluir um objeto da dao.
     */
    @Test
    public void testExcluirPositivo() {
        Usuario usuario = new Empreendedor();
        instance.salvar(usuario);
        int id = usuario.getIdUsuario();
        instance.excluir(usuario.getIdUsuario(), Empreendedor.class);
        Usuario result = (Usuario) instance.buscarObjeto(id, Empreendedor.class);
        assertNull(result);
    }
    
    /**
     * Teste de excluir um objeto da dao que não existe.
     */
    @Test
    public void testExcluirNegativo() {
        
        Usuario usuario = new Empreendedor();       
        boolean result = instance.excluir(usuario.getIdUsuario(), Empreendedor.class);
        assertFalse(result);
    }
    

//    /**
//     * Testa busca Objetos no banco de dados.
//     */
//    @Test
//    public void testBuscarObjetos() {
//        
//        Usuario usuario1 = new Empreendedor();        
//        instance.salvar(usuario1);        
//        Usuario usuario2 = new Empreendedor();        
//        instance.salvar(usuario2);
//        
//        ArrayList list = instance.buscarObjetos(Empreendedor.class);       
//        assertNotNull(list);
//        
//        instance.excluir(usuario1.getIdUsuario(), Empreendedor.class);
//        instance.excluir(usuario2.getIdUsuario(), Empreendedor.class);
//        
//    }
    
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
}
