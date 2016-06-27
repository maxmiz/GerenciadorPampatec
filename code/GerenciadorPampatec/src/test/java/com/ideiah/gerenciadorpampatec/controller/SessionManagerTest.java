/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import java.util.Enumeration;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * <p>
 * Classe para testar a criação da sessão no sistema. Está incompleta, seria
 * necessário montar um container para simular a aplicação e conseguir acessar a
 * classe SessionManager, que é abstrata.</p>
 *
 * @author unipampa
 */
@Ignore
public class SessionManagerTest {

    @Mock
    private HttpSession mockedSession;

    public SessionManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(SessionManager.getCreateSession()).thenReturn(mockedSession);        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCreateSession method, of class SessionManager.
     */
    @Test
    public void testGetCreateSession() {
        System.out.println("getCreateSession");
        HttpSession expResult = null;
        assertNotSame(expResult, mockedSession);
    }

    /**
     * Test of getSession method, of class SessionManager.
     */
    @Test
    public void testGetSession() {
        System.out.println("getSession");
        HttpSession expResult = null;
        HttpSession result = SessionManager.getSession();
        assertNotSame(expResult, result);
    }

    /**
     * Test of getFacesContext method, of class SessionManager.
     */
    @Test
    public void testGetFacesContext() {
        System.out.println("getFacesContext");
        FacesContext expResult = null;
        FacesContext result = SessionManager.getFacesContext();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAttribute method, of class SessionManager.
     */
    @Test
    public void testGetAttribute() {
        System.out.println("getAttribute");
        String attribute = "";
        Object expResult = null;
        Object result = SessionManager.getAttribute(attribute);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAttributeNames method, of class SessionManager.
     */
    @Test
    public void testGetAttributeNames() {
        System.out.println("getAttributeNames");
        Enumeration<String> expResult = null;
        Enumeration<String> result = SessionManager.getAttributeNames();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxInactiveInterval method, of class SessionManager.
     */
    @Test
    public void testGetMaxInactiveInterval() {
        System.out.println("getMaxInactiveInterval");
        int expResult = 0;
        int result = SessionManager.getMaxInactiveInterval();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeAttribute method, of class SessionManager.
     */
    @Test
    public void testRemoveAttribute() {
        System.out.println("removeAttribute");
        String string = "";
        SessionManager.removeAttribute(string);
    }

    /**
     * Test of renovaSessaoUsuario method, of class SessionManager.
     */
    @Test
    public void testRenovaSessaoUsuario() {
        System.out.println("renovaSessaoUsuario");
        SessionManager.renovaSessaoUsuario();
    }

    /**
     * Test of finalizaSessao method, of class SessionManager.
     */
    @Test
    public void testFinalizaSessao() {
        System.out.println("finalizaSessao");
        SessionManager.finalizaSessao();
    }
}
