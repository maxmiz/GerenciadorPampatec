/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideiah.gerenciadorpampatec.controller;

import com.ideiah.gerenciadorpampatec.model.Empreendedor;
import java.io.IOException;
import java.util.logging.LogRecord;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AugustoCesar
 */
public class LoginFilter implements Filter {

    @Override
    public void destroy() { // TODO Auto-generated method stub 

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        User user = null;
        Empreendedor user = null;
        HttpSession sess = ((HttpServletRequest) request).getSession(false);
        if (sess != null) {
            System.out.println("ccccccccccccccccc");

            user = (Empreendedor) sess.getAttribute("empreendedor");
        }
        if (user == null) {

            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");

//            FacesContext.getCurrentInstance().getExternalContext().redirect("/loginEmpreendedor.xhtml");
            
            String contextPath = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse) response).sendRedirect(contextPath+"/view/loginEmpreendedor.xhtml");

        } else {
            System.out.println("bbbbbbbbbbbbbbbbbb");

            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException { // TODO Auto-generated method stub 

    }

    public boolean isLoggable(LogRecord record) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
