/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.servletfilter.servlet;

import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jagadheesan Balu
 */
public class LogoutServlet extends HttpServlet {
    
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        
        res.setContentType("text/html");
        
        Cookie[] cookies = req.getCookies();
        
        if(cookies != null) {
           for(Cookie c : cookies) {
               if(c.getName().equals("JSESSIONID")) {
                   System.out.println("JSESSIONID :"+c.getValue());
                   break;
               }
           }
        }
        
        // session invalidate
        HttpSession session = req.getSession(false);
        
        if(session != null){
            session.invalidate();
        }
        
        res.sendRedirect("login.html");
        
    }
    
}
