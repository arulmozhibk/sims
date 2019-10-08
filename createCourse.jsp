<%@page import="java.sql.ResultSet"%>
<%@page import="com.sims.service.AdministrationService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
<link rel="stylesheet" type="text/css" href="css/table.css">
<title>Create Batch</title>
</head>

<body>
<%
String alert=request.getParameter("alert");
String strDesignationId=request.getParameter("designationId");
System.out.println("strDesignationId  "+strDesignationId);
int designationId=Integer.parseInt(strDesignationId);
AdministrationService ats=new AdministrationService();
ResultSet rs=ats.getUserAccessByDesignation(designationId);

%>
<div class="subcontent">
<% while(rs.next())
	{
		boolean read=rs.getBoolean("canread");
		boolean edit=rs.getBoolean("canedit");
		boolean create=rs.getBoolean("cancreate");
		boolean delete=rs.getBoolean("candelete");
		
	%>
	<%if(create) {%>

<table class="" width="50%">

<tr><td>Enter the Course Name :</td><td width="20%"><input type="text" id="coursename" name="coursename" ></td><td>
</td></tr>
<tr><td>Enter the Fees :</td><td width="20%"><input type="text" id="coursefees" name="coursefees" ></td></tr>
<tr>
<td></td><td width="50%" align="left"><a href="#" onclick="createCourseAction(<%=designationId %>)" class="button1">Create Course</a>
</td></tr>
</table><% } } %>
<jsp:include page="courseList.jsp"></jsp:include>
</div>

</body>
</html>

