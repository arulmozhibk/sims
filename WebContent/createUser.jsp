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
<link rel="stylesheet" type="text/css" href="css/usertable.css">
<title>Insert title here</title>
</head>
<body>
<% 
String strDesignationID=request.getParameter("designationId"); 
int designationid=Integer.parseInt(strDesignationID);
ViewService vs=new ViewService();
ResultSet rs=vs.getCourseNameList();
AdministrationService ats=new AdministrationService();
ResultSet rset=ats.getUserAccessByDesignation(designationid);
String alert=request.getParameter("alert");
String falert=request.getParameter("falert");
%>

<div class="subcontent"><br>


<% while(rset.next())
{
	boolean read=rset.getBoolean("canread");
	boolean edit=rset.getBoolean("canedit");
	boolean create=rset.getBoolean("cancreate");
	boolean delete=rset.getBoolean("candelete"); %>
<%if(create) {%>
<div >
<center>
<form action="" name="CreateUser">
  <table border="0" class="usertable" width="30%" height="100%">
  <thead><tr><td colspan="4" bgcolor="#0A82BC" style="color: #FFFFFF"><center> <strong>Student Registration</strong></center></td></tr></thead>
<tr><td width="30%">User Name</td><td>  <input type="text" name="username" id="username" size="18" placeholder="User Name" onblur="userNameValidate1()"><br><span id="aname" style="color:red;font-size: 12px "></span></td></tr>
<tr><td>DOB  </td><td> <input type="text" name="dob" id="dob" size="18" placeholder="dd/mm/yyyy" onblur="isValidDate1()"><br><span id="adob" style="color:red;font-size: 12px "></span></td></tr>
<tr><td>Email </td><td> <input type="text" name="email" id="email" size="18" placeholder="xxx@yyy.com" onblur="emailValidate1()"><br><span id="aemail" style="color:red;font-size: 12px "></span></td></tr>
<tr><td>Password</td><td> <input type="password" name="password" id="password" size="18" placeholder="password" onblur="passwordValidate1()"><br><span id="apassword" style="color:red;font-size: 12px "></span></td></tr>
<tr><td>Course </td> <td>
<select name="courseid" id="courseid" title="Select the course" tabindex="50" onblur="courseValidate()" >
<option value="" >Select the Course</option>
<%while(rs.next())
{
 %>
<option value=<%=rs.getInt(1) %>> <%=rs.getString("course_name")%></option>
<% } %>
</select><br><span id="ac" style="color:red;font-size: 12px "></span></td></tr>

<tr><td></td><td bordercolor="#0B615E"><a href="#" onclick="registerUser(<%=designationid %>)" class="button1">Create User</a>
 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="reset" value="Cancel" class="button1" onclick="resetCreateUSer()"></td></tr>  
</tbody>
</table><%} }  %></form></center></div>

<br>
<div align="center">
<%if(alert!=null) {%>
	<span style='color:#3ADF00'> <%=alert%> </span>
<% }else if(falert!=null) { %> <span style='color:#FF0000'> <%=falert%> </span>
<% }else { out.print("  "); } %>
</div>
</div>
</body>
</html>