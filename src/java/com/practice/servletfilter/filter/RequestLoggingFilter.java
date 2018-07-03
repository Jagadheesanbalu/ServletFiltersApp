/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.servletfilter.filter;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author Jagadheesan Balu
 */
public class RequestLoggingFilter implements Filter {

    private ServletContext sc;
    @Override
    public void init(FilterConfig fc) {
        
        this.sc = fc.getServletContext();
        this.sc.log("RequestLoggingFilter initialized");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        
        Enumeration<String> params = req.getParameterNames();
        
        while(params.hasMoreElements()) {
            String name = params.nextElement();
            String value = req.getParameter(name);
            this.sc.log(req.getRemoteAddr() + "::Request Params::{"+name+"="+value+"}");
        }
        
        Cookie[] cookies = req.getCookies();
        
        if(cookies!=null) {
            for(Cookie c : cookies) {
                this.sc.log(req.getRemoteAddr() + "::Cookie::{"+c.getName()+","+c.getValue()+"}");
            }
        }
        
        chain.doFilter(req, res);      
    }
    
    @Override
    public void destroy() {
        
    }
}
