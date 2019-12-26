<%@page import="com.sims.service.AdministrationService"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.sims.service.ViewService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/table.css" />
</head>
<body>
<%
String alert=request.getParameter("alert");
ViewService vs=new ViewService();
ResultSet rs=vs.getExamList();

String strDesignationID=request.getParameter("designationId"); 
int designationid=Integer.parseInt(strDesignationID); 

AdministrationService ats=new AdministrationService();
ResultSet rset=ats.getUserAccessByDesignation(designationid);

 %>
<div id="subcontent" class="subcontent">
<%while(rset.next())
{
	boolean read=rset.getBoolean("canread");
	boolean edit=rset.getBoolean("canedit");
	boolean create=rset.getBoolean("cancreate");
	boolean delete=rset.getBoolean("candelete"); %>
	<%if(read) {%>
	<div align="center">
<table class="tbl">
<thead align="left">
<tr><td colspan="3" bgcolor="#FFFFFF"><center><strong>List of All Examination</strong></center></td></tr>
<tr style="color: #FFFFFF">
<th align="center" bgcolor="#0A82BC">Exam.No</th><th align="center" bgcolor="#0A82BC">Exam Name</th>
</tr>
</thead>
<tbody>
<%int i=0;
while(rs.next())
	{i++;
	%>
<tr class="tablebody"><td><%=i %></td><td><%=rs.getString("exam_name") %></td></tr>
<%} %>
</tbody>

</table><%}} %> </div>
</div>
</body>
</html>