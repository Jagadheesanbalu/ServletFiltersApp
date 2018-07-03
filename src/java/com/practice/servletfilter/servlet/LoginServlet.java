/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.servletfilter.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jagadheesan Balu
 */
public class LoginServlet extends HttpServlet{
    
    public String userid = "admin";
    public String password = "pass";
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        
        if(userid.equals(user) && password.equals(pwd)) {
            // Successful Login
            HttpSession session = req.getSession();
            
            session.setAttribute("user", "Jaggy");
            session.setMaxInactiveInterval(10);
            
            Cookie userName = new Cookie("user", user);
            userName.setMaxAge(10);
            
            res.addCookie(userName);
            res.sendRedirect("LoginSuccess.jsp");     
        } else {
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = res.getWriter();
            
            out.println("<font color=red>Either user name or password is wrong.</font>");
            
            rd.include(req, res);
            
        }
        
    }
}
