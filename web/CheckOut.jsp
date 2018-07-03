<%-- 
    Document   : CheckOut
    Created on : Nov 29, 2017, 8:43:40 AM
    Author     : Jagadheesan Balu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String userName = null;
            String user = (String) session.getAttribute("user");
            Cookie[] cookie = request.getCookies();
            
            if( cookie != null ) {
                for(Cookie c : cookie) {
                    if(c.getName().equals("user")) userName = c.getValue();
                }
            }
         %>
         
         <h3>Hi <%= userName %>. Wanna checkout?  session user <%= user %></h3>
         <br>
        <form action="LogoutServlet" method="post">
        <input type="submit" value="Logout" >
        </form>
    </body>
</html>
