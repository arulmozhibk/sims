<%@page import="java.sql.ResultSet"%>
<%@page import="com.sims.service.AdministrationService"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/button.css">

<title>Create Exam</title>
</head>

<body>
<%
String strDesignationId=request.getParameter("designationId");
String alert=request.getParameter("alert");
String falert=request.getParameter("falert");
System.out.println("strDesignationId "+strDesignationId);
int designationId=Integer.parseInt(strDesignationId);
AdministrationService ats=new AdministrationService();
ResultSet rs=ats.getUserAccessByDesignation(designationId);
%>
<div id="subcontent" class="subcontent">

 <form action="" target="">
 <% while(rs.next())
	{
		boolean read=rs.getBoolean("canread");
		boolean edit=rs.getBoolean("canedit");
		boolean create=rs.getBoolean("cancreate");
		boolean delete=rs.getBoolean("candelete");
		
	%>
	<%if(create) {%>
<table border="0"><tr><td>Enter the Exam Name :</td><td><input type="text" name="examname" id="examname"></td>
<td><a href="#" onclick="createExamAction(<%=designationId %>)" class="button1">Create Exam</a>
</td></tr>
</table><% } } %>
</form> 
<jsp:include page="examList.jsp"></jsp:include>
<br><div align="center">
<%if(alert!=null) {%>
	<span style='color:#3ADF00'> <%=alert%> </span>
<% }else if(falert!=null) { %> <span style='color:#FF0000'> <%=falert%> </span>
<% }else { out.print("sample"); } %>
</div>
<div id="examList"> </div>

</div>
</body>
</html>
