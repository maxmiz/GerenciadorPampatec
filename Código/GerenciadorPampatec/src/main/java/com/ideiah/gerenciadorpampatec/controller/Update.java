/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ideiah.gerenciadorpampatec.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * 
 * @author Edison Moura 
 */
@ManagedBean(name = "update")
@ViewScoped
public abstract class Update {

    public abstract void update(String name);
    
}
