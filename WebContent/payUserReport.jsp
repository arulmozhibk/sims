<%@page import="com.sims.service.AdministrationService"%>
<%@page import="com.sims.service.ViewService"%>
<%@page import="java.sql.ResultSet"%>
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
System.out.println("Pay User Report Executuion");

String strUserId=request.getParameter("UserId");
int userId=Integer.parseInt(strUserId);
System.out.println("User Id"+userId);

ViewService vs=new ViewService();
ResultSet rs=vs.getUserPayment(userId);

String strDesignationID=request.getParameter("designationId"); 
int designationid=Integer.parseInt(strDesignationID); 

AdministrationService ats=new AdministrationService();
ResultSet rset=ats.getUserAccessByDesignation(designationid);
 String alert=request.getParameter("alert");
%>
<div id="subcontent"><br>
<%while(rset.next())
{
	boolean read=rset.getBoolean("canread");
	boolean edit=rset.getBoolean("canedit");
	boolean create=rset.getBoolean("cancreate");
	boolean delete=rset.getBoolean("candelete"); %>
	<%if(create) {%>
	<div align="center">
<table class="usertable" width="60%">
<thead ><tr class="tabletitle"><td  colspan="2" bgcolor="#0A82BC" style="color: #FFFFFF"> <center>View User Fees Details</center></td></tr>
</thead>
<tbody>
<%
while(rs.next()){
 %>

 <tr><td colspan="2"><center>Student RegNo : <%=rs.getInt(1) %></center></td></tr>
<tr><td width="50%">Name </td><td width="50%"><%=rs.getString(2) %></td></tr>
<tr><td>DOB </td><td><%=rs.getString(3) %></td></tr>
<tr><td>Email </td><td><%=rs.getString(4) %></td></tr>
<tr><td>Total Fees</td><td><%=rs.getDouble(5) %></td>
<tr><td>Paid Amount</td><td><%=rs.getDouble(6) %></td>
<tr><td>Remaining Amount</td><td><%=rs.getDouble(7) %></td><% } } }%>
</tbody>
</table>
<br><div style='color:green' align="center"><%if(alert!=null){
out.println(alert);}
else { out.println(""); }%></div></div>
</div>
</body>
</html>