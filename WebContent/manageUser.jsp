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
<link rel="stylesheet" type="text/css" href="css/hoverbule.css">
<title>Manage User</title>

</head>

<body>
<% 
String strDesignationID=request.getParameter("designationId"); 
int designationid=Integer.parseInt(strDesignationID); 

AdministrationService ats=new AdministrationService();
ResultSet rs=ats.getUserAccessByDesignation(designationid);
%>
<div id="maincontent" class="maincontent" align="left">
 <div class="Bule_style_menu clearfix">
<ul class="clearfix">
<%while(rs.next())
{
	boolean read=rs.getBoolean("canread");
	boolean edit=rs.getBoolean("canedit");
	boolean create=rs.getBoolean("cancreate");
	boolean delete=rs.getBoolean("candelete"); %>
	
<%if(create) {%><li><a href="#" onclick="createUser(<%=designationid%>)"><span>Create Student</span></a></li>
<% }if(edit) {%><li><a href="#" onclick="moveUserCourse(<%=designationid%>)"><span>Move Student</span></a></li>
<% }if(delete) {%><li><a href="#" onclick="loadRemoveUser(<%=designationid%>)"><span>Remove Student</span></a></li>
<%} } %>
</ul>
</div>
<div id="manageUser"> 
</div>
</div>



</body>
</html>