<%@page import="com.sims.service.AdministrationService"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.sims.service.ViewService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
<link rel="stylesheet" type="text/css" href="css/table.css">
<title>Edit Course</title>

</head>
<body>
<% 
String strDesignationId=request.getParameter("designationid");
System.out.println("strDesignationId in edit "+strDesignationId);

int designationId=Integer.parseInt(strDesignationId);

AdministrationService ats=new AdministrationService();
ResultSet rset=ats.getUserAccessByDesignation(designationId);

ViewService vs=new ViewService();
ResultSet rs=vs.getCourseNameList();
int i=0;
String alert=request.getParameter("alert");
String falert=request.getParameter("falert");
%>
<div id="subcontent" class="subcontent">
 <% while(rset.next())
	{
		boolean read=rset.getBoolean("canread");
		boolean edit=rset.getBoolean("canedit");
		boolean create=rset.getBoolean("cancreate");
		boolean delete=rset.getBoolean("candelete");
		
	%>

	<% if(read) {%>
<div align="center">
<table class="tbl">
<thead >
<tr><td align="center" colspan="4" bgcolor="#FFFFFF"><center><strong>List of Courses</strong></center></td></tr>
<tr style="color: #FFFFFF"><th bgcolor="#0A82BC">Course NO</th> <th bgcolor="#0A82BC">Course Name</th> <th bgcolor="#0A82BC">Course Fees</th></tr></thead>
<tbody align="center">
<% while(rs.next()) { i++; int courseId=rs.getInt(1);%>
<tr><td align="center" ><%=i %></td><td align="justify"><input type="hidden" name="hiddenCourseId" id="hiddenCourseId" value="<%=courseId%>"><a href="#" onclick="editCourseAction(<%=courseId %>,<%=designationId%>)"><%=rs.getString("course_name") %></a></td><td><%=rs.getDouble("fees") %></td></tr>
<%} %>
</tbody>
 </table>
 <% } } %>
 <div align="center">
<%if(alert!=null) {%>
	<span style='color:#3ADF00'> <%=alert%> </span>
<% }else if(falert!=null) { %> <span style='color:#FF0000'> <%=falert%> </span>
<% }else { out.print(" "); } %>
</div>
</div></div>
</body>
</html>