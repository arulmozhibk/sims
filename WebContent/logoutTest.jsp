<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
LOGIN.JSP FILE
 
<%@page language="java" session="true" contentType="text/html" pageEncoding="UTF-8"%>
 
<HTML>
    <HEAD> 
        <TITLE>Login using jsp</TITLE>
    </HEAD>
 
    <BODY>
        <%
            if(request.getParameter("submit")==null){
        %>
        <H1>LOGIN FORM</H1>
        
            <form action="login.jsp" method="get">
                <table>
                    <tr>
                        <td> Username  : </td><td> <input name="username" size=15 type="text" /> </td>
                    </tr>
                    <tr>
                        <td> Password  : </td><td> <input name="password" size=15 type="text" /> </td>
                    </tr>
                </table>
                <input type="submit" name="submit" value="login" />
            </form>
            <%
            }else{
 
            String username = request.getParameter("username");
            String password = request.getParameter("password");
 
            if (username == null || password == null) {
 
                out.print("Invalid paramters ");
            }
 
            // Here you put the check on the username and password
            if (username.toLowerCase().trim().equals("admin") && password.toLowerCase().trim().equals("admin")) {
                    session.setAttribute("username", username);
                    response.sendRedirect("secure1.jsp");
 
            }else{
                    out.println("Invalid username and password");
                    out.print("<a href=\"login.jsp\">back</a>");
                }
            }
           %>
    </BODY>
</HTML>
 
 
 
 
 
 
LOGOUT.JSP FILE
 
<%@page language="java" session="true" contentType="text/html" pageEncoding="UTF-8"%>
 
<HTML>
    <HEAD>
        <TITLE></TITLE>
    </HEAD>
 
    <BODY>
<H1>LOGOUT FORM</H1>
<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setDateHeader("Expires", 0);
    response.setHeader("Pragma","no-cache");
 
     //request.getAttribute("username");
            if(session.getAttribute("username")== null){
                session.setAttribute("username", null);
                out.print("you have already been logged out <a href=\"login.jsp\">Back to Login<a/>");
            }
                else{
                    session.setAttribute("username", null);
                    out.print(" you have now been logged out <a href=\"login.jsp\">Back to Login<a/>");
            }
    
%> 
    </BODY>
</HTML>
 
 
 
 
 
SECURE1.JSP
 
<%@page language="java" session="true" contentType="text/html" pageEncoding="UTF-8"%>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%
            response.setHeader("Cache-Control","no-cache");
            response.setHeader("Cache-Control","no-store");
            response.setDateHeader("Expires", 0);
            response.setHeader("Pragma","no-cache");
 
            out.print(session.getAttribute("username"));
 
            if(session.getAttribute("username")== null){
                response.sendRedirect("logout.jsp");
            }else{
        %>
        <h1>SECURE PAGE 1</h1><br>
        <a href="secure2.jsp">Secure2.jsp</a><br>
        <a href="logout.jsp">Logout</a>
        <%
            }
        %>
    </body>
</html>
 
 
 
 
 
SECURE2.JSP FILE
 
<%@page language="java" session="true" contentType="text/html" pageEncoding="UTF-8"%>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%
            response.setHeader("Cache-Control","no-cache");
            response.setHeader("Cache-Control","no-store");
            response.setDateHeader("Expires", 0);
            response.setHeader("Pragma","no-cache");
 
            out.print(session.getAttribute("username"));
 
            if(session.getAttribute("username")== null){
                response.sendRedirect("logout.jsp");
            }else{
        %>
        <h1>SECURE PAGE 2</h1><br>
        <a href="secure1.jsp">Secure1</a><br>
        <a href="logout.jsp">Logout</a>
        <%
            }
        %>
    </body>
</html>
</body>
</html> --%>