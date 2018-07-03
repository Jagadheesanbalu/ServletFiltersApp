<%-- 
    Document   : LoginSuccess
    Created on : Nov 29, 2017, 7:46:13 AM
    Author     : Jagadheesan Balu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Success</title>
    </head>
    <body>
        <% String user = (String) session.getAttribute("user");
            String userName = null;
            String sessionID = null;
            Cookie[] cookie = request.getCookies();
            
            if( cookie != null ) {
                for(Cookie c : cookie) {
                    if(c.getName().equals("user")) userName = c.getValue();
                    if(c.getName().equals("JSESSIONID")) sessionID = c.getValue();
                }
            }
         %>
         
         <h3>Hi <%= userName %>. Login Successful with SessionID - <%= sessionID %></h3>
         <br>
        User=<%=user %>
        <br>
        <a href="CheckOut.jsp">Checkout Page</a>
        <form action="LogoutServlet" method="post">
        <input type="submit" value="Logout" >
        </form>
    </body>
</html>
