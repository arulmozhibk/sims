<%@page import="com.sims.service.ViewService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="java.sql.ResultSet" %>
        
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css" media="screen" />
 <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" />
<title>Login</title>
<script type="text/javascript" src="js/dashboard.js"></script>
<script type="text/javascript" src="js/sis.js"></script>

</head>
<body>
<%
String msg=request.getParameter("alert");

%>
<div id="headers" class="headerpanel">
<div class="titlefirst floatleft"><br>
 <span class="white large">&nbsp;&nbsp; Blue</span><span class="skyblue large">Whale</span></div>

<table align="center" cellspacing="5" cellpadding="20"><tr><td style="font-size:x-large;font-family:sans-serif;">STUDENT INFORMATION MANAGEMENT SYSTEM</td></tr>
</table>
</div>

<div id="indexmain" class="indexmain"><br><br><br>

<div id="login" class="login">
<div style='color:red' align="center">
<%if(msg!=null){
out.print(msg);}else { out.println(" "); }%>
</div>
<form action="LoginServlet" method="post">
<table border="0" cellspacing="15px" height="120px" width="60px" cellpadding="15" align="center">
<thead style="font-colour:#102947;"><tr><td colspan="2" align="center" style="color:#0B615E; font-size:14;font-family: sans-serif;">LOGIN</td></tr></thead>
<tbody style="color:#0B615E; font-size:10;font-family: sans-serif;" ><tr><td>Email ID </td><td><input type="text" name="uid"></td></tr>
<tr><td>Password </td><td><input type="text" name="password"></td></tr>
<tr><td></td><td><input type="submit" value="SignIn" name="signin">&nbsp;<input type="reset" value="Cancel"></td>  
 </tbody>
</table></form>
<div id="index"></div>
</div>
</div>

<div id="footer" class="footer" > <center style="color: white;font-size: 12px;" > arulmozhibk @ Chennai 2015</center></div>
</body>
</html>r