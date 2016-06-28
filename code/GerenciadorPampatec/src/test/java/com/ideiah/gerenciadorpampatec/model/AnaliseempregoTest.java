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


public class AnaliseempregoTest {
    
    int id = 1;
    String relacoesClientes = "Relacoes";
    String parceriasChaves = "Parcerias";
    String canais = "Canais";
    String recursosPrincipais = "Recursos";
    String concorrentes = "Concorrentes";
    Set<Projeto> projetos = new HashSet<>();
    Projeto projeto = new Projeto();
    
    
    public AnaliseempregoTest() {
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
 * test do construtor
 */
@Test
public void testAnaliseEmprego(){
    
    Analiseemprego analise = new Analiseemprego(id);
    
    assertEquals(id, analise.getIdAnaliseEmprego());
}
 /**
 * test do construtor
 */   
@Test
public void testAnaliseEmprego2(){
    Analiseemprego analise = new Analiseemprego(id, relacoesClientes, parceriasChaves, canais, recursosPrincipais, concorrentes, projetos);
    
    assertEquals(id, analise.getIdAnaliseEmprego());
    assertEquals(relacoesClientes, analise.getRelacoesClientes());
    assertEquals(parceriasChaves, analise.getParceriasChaves());
    assertEquals(canais, analise.getCanais());
    assertEquals(recursosPrincipais, analise.getRecursosPrincipais());
    assertEquals(concorrentes, analise.getConcorrentes());
    assertEquals(projetos, analise.getProjetos());
}

}
