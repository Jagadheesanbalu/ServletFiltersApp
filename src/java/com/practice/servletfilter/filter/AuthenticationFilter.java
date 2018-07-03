/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.servletfilter.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jagadheesan Balu
 */
public class AuthenticationFilter implements Filter{
    private ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		this.context.log("Requested Resource::"+uri);
		
		HttpSession session = req.getSession(false);
		          System.out.println("Authentic Filter enters context path:"+req.getContextPath());
		if(session == null && !(uri.endsWith("html") || uri.endsWith("LoginServlet") || uri.endsWith(req.getContextPath()+"/"))){
			this.context.log("Unauthorized access request");
                        System.out.println("Authentic Filter if");
			res.sendRedirect("login.html");
		} else {
                    System.out.println("Authentic Filter else");
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
                
        }

	

	public void destroy() {
		//close any resources here
	}
}
