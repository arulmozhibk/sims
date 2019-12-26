<%@page import="java.sql.ResultSet"%>
<%@page import="com.sims.service.ViewService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/table.css" />
<title>Course List</title>
</head>
<body><%
String alert=request.getParameter("alert");
String falert=request.getParameter("falert");
ViewService vs=new ViewService();
ResultSet rs=vs.getCourseList();
int i=0;%>
<div align="center"><br>
<table class="tbl">
<thead align="center">
<tr><td align="center" colspan="4" bgcolor="#FFFFFF"><center><strong>List of Courses</strong></center></td></tr>
<tr align="left" valign="top" style="color: #FFFFFF">
<th align="center" bgcolor="#0A82BC">Course No<th bgcolor="#0A87C2" align="center">Course Name</th><th bgcolor="#0A87C2" align="center"> Course Fees</th>
</tr>
</thead>
<tbody><% while(rs.next())
{i++;  %>
<tr><td align="center"><%=i %></td><td><%=rs.getString(2)%></td><td><%=rs.getDouble(3)%></td></tr>
<%}  %>
</tbody>
</table>
<div align="center">
<%if(alert!=null) {%>
	<span style='color:#3ADF00'> <%=alert%> </span>
<% }else if(falert!=null) { %> <span style='color:#FF0000'> <%=falert%> </span>
<% }else { out.print(" "); } %>
</div>
</div>
</body>
</html>