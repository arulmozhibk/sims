<%@page import="java.sql.ResultSet"%>
<%@page import="com.sims.service.AdministrationService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
<link rel="stylesheet" type="text/css" href="css/hoverbule.css">
<title>Administration</title>
</head>
<body>
<%
String email = null;
String username = null;

  response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setDateHeader("Expires", 0);
    response.setHeader("Pragma","no-cache");
    
HttpSession ssn = request.getSession(false);
System.out.println("session :"+ssn);
if (session != null)
{
	email = (String) ssn.getAttribute("ssnName");
	
	
String strDesignationId=request.getParameter("designationId");
System.out.println("strDesignationId "+strDesignationId);
int designationId=Integer.parseInt(strDesignationId);
AdministrationService ats=new AdministrationService();
ResultSet rs=ats.getUserAccessByDesignation(designationId);
%>
<div class="maincontent" id="maincontent">
<div class="Bule_style_menu clearfix">
<ul class="clearfix">
<% while(rs.next())
	{
		boolean read=rs.getBoolean("canread");
		boolean edit=rs.getBoolean("canedit");
		boolean create=rs.getBoolean("cancreate");
		boolean delete=rs.getBoolean("candelete");
		
	%>
	<%if(create) {%><li><a href="#" onclick="loadCreateCourse(<%=designationId%>)" title="Create Course"><span>Create Course</span></a></li>
	<% } if(edit) { %><li><a href="#" onclick="loadEditCourse(<%=designationId%>)" title="Edit Course"><span>Edit Course</span></a></li>
	<% } if(delete) { %><li><a href="#" onclick="loadDeleteCourse(<%=designationId%>)" title="Delete Course"><span>Delete Course</span></a></li>
	<% } if(create) {%><li><a href="#" onclick="loadCreateExam(<%=designationId%>)"  title="CreateExam"><span>Create Exam</span></a></li>
<%} }%>
</ul>
</div>
<div id="course"></div>
</div>
 


</body>
<% }
			else
			{
				response.sendRedirect("index.jsp");
				out.println("<div  style='color:red'>  ::   Please Login Again   :::   </div>");

			}
			%>
</html>