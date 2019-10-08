<%@page import="com.sims.service.AdministrationService"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.sims.service.ViewService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
<link rel="stylesheet" type="text/css" href="css/register.css">

<title>Insert title here</title>
</head>
<body>
<% 
ViewService vs=new ViewService();
ResultSet rs=vs.getCourseNameList();
String alert=request.getParameter("alert");
AdministrationService ast=new AdministrationService();
ResultSet rst=ast.getDesignation();

AdministrationService ats=new AdministrationService();
String strDesignationID=request.getParameter("designationId"); 
int designationid=Integer.parseInt(strDesignationID);
ResultSet rset=ats.getUserAccessByDesignation(designationid);
%>

<div class="maincontent">
<%while(rset.next())
{
	boolean read=rset.getBoolean("canread");
	boolean edit=rset.getBoolean("canedit");
	boolean create=rset.getBoolean("cancreate");
	boolean delete=rset.getBoolean("candelete"); %>
<%if(create) {%>
<div class="testbox">
<center>
<hr>
 <h1> User Registration</h1><hr>
 <form name="registration">
  <table border="0">
<tr><td width="30%">User Name</td><td>  <input type="text" name="username" id="username" size="18" placeholder="User Name" onblur="userNameValidate()"><span id="aname" style="color:red;font-size: 12px "></span></td></tr>
<tr><td>DOB  </td><td> <input type="text" name="dob" id="dob" size="18" placeholder="dd/mm/yyyy" onblur="isValidDate()"><span id="adob" style="color:red;font-size: 12px "></span></td></tr>
<tr><td>Email </td><td> <input type="text" name="email" id="email" size="18" placeholder="xxx@yyy.com" onblur="emailValidate()"><span id="aemail" style="color:red;font-size: 12px "></span></td></tr>
<tr><td>Password</td><td> <input type="password" name="password" id="password" size="18" placeholder="password" onblur="passwordValidate()"><span id="apassword" style="color:red;font-size: 12px "></span></td></tr>
<tr><td>Designation</td><td> <select name=usertype id="usertype" title="Select the User Type" onblur="designationValidate()">
<option value="" >&nbsp; &nbsp;Select the User Type&nbsp; &nbsp;</option>
<% while(rst.next()) { %>
<option value=<%=rst.getInt("designation_id") %>><%=rst.getString("designation_name") %> </option><%} %>
</select><span id="adesignation" style="color:red;font-size: 12px "></span></td></tr> 
<tr> <td><br><br><td></tr></table><table>
<tr><td></td><td><a href="#" class="button1" onclick="registerAdmin(<%=designationid %>)">Create User</a>&nbsp; &nbsp; &nbsp;&nbsp; <input type="reset" value="Cancel" class="button1" onclick="resetRegistration()"> </td></tr>
</table></form>
</center><%}} %></div>
<div style='color:green' align="center"><%if(alert!=null){
out.println(alert);}
else { out.println(); }%></div>
</div>
</body>
</html>