<%@page import="com.sims.service.AdministrationService"%>
<%@page import="com.sims.service.ViewService"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
<link rel="stylesheet" type="text/css" href="css/panel.css">
<link rel="stylesheet" type="text/css" href="css/hoverbule.css">
<title>Insert title here</title>
</head>
<body><%

String strDesignationId=request.getParameter("designationid");
System.out.println("strDesignationId in update "+strDesignationId);
int designationId=Integer.parseInt(strDesignationId);
AdministrationService ats=new AdministrationService();
ResultSet rset=ats.getUserAccessByDesignation(designationId);

String strCourseId=request.getParameter("editCourseId");
int courseId=Integer.parseInt(strCourseId);
System.out.println("courseId in updateCourse.jsp :"+courseId);
ViewService vs=new ViewService();
ResultSet rs=vs.getCourseService(courseId);
String alert=request.getParameter("alert");
String falert=request.getParameter("falert");
int i=0;

%>
<jsp:include page="editCourse.jsp"></jsp:include>
	<div id="subcontent" class="subcontent"><br>
	 <% while(rset.next())
	{
		boolean read=rset.getBoolean("canread");
		boolean edit=rset.getBoolean("canedit");
		boolean create=rset.getBoolean("cancreate");
		boolean delete=rset.getBoolean("candelete");
		
	%><%if(read && edit) {%>
		<div align="center"><table class="tbl">
			<%
				while (rs.next()) {
					i++;
					int courseID=rs.getInt(1);%>
			<tr>
				<td>Course Name
				<td><input type="text" id="courseName" name="courseName"
					value="<%=rs.getString(2)%>" size="35" width="90%" style="background-color: #FFF" ></td>
			</tr>
			<tr>
				<td>Course Fees</td>
				<td><input type="text" id="courseFees" name="courseFees"
					value="<%=rs.getDouble(3)%>" size="35"></td>
			</tr>
			<tr>
			<td></td>
				<td><a href="#"
					onclick="updateCourseAction(<%=courseId%>,<%=designationId %>)" class="button1"> Update </a>
					<%} %>
		</table> <%} } %>
			
	</div>
	<div align="center">
<%if(alert!=null) {%>
	<span style='color:#3ADF00'> <%=alert%> </span>
<% }else if(falert!=null) { %> <span style='color:#FF0000'> <%=falert%> </span>
<% }else { out.print(" "); } %>
</div>
	</div>
</body>
</html>