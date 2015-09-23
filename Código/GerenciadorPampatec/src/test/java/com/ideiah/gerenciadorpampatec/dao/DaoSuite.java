/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Peterson
 */
@Ignore
@RunWith(Suite.class)
@Suite.SuiteClasses({com.ideiah.gerenciadorpampatec.dao.EmpreendedorDaoTest.class, com.ideiah.gerenciadorpampatec.dao.ProjetoDaoTest.class, com.ideiah.gerenciadorpampatec.dao.DaoTest.class, com.ideiah.gerenciadorpampatec.dao.HibernateUtilTest.class})
public class DaoSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
