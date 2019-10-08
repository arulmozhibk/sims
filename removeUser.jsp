<%@page import="com.sims.service.AdministrationService"%>
<%@page import="com.sims.service.ViewService"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/table.css">
<title>Remove User</title>
</head>
<body>
	<%
		ViewService vs = new ViewService();
		ResultSet rs = vs.getCourseList();
		int noOfUsers=0;
		int i=0;
		
		String strDesignationID=request.getParameter("designationId"); 
		int designationid=Integer.parseInt(strDesignationID); 

		AdministrationService ats=new AdministrationService();
		ResultSet rset=ats.getUserAccessByDesignation(designationid);
		 String alert=request.getParameter("alert");
		 String falert=request.getParameter("falert");
	%>
	<div id="maincontent" class="subcontent">
	
	<br>
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
				<tr class="tabletitle">
					<td colspan="3" bgcolor="#FFFFFF"><center><strong>List of
							Courses</strong></center></td>
				</tr>
				<tr style="color: #FFFFFF">
					<th align="center" bgcolor="#0A82BC" >Course No</th>
					<th align="center" bgcolor="#0A82BC">Course Name</th>
					<th align="center" bgcolor="#0A82BC">No Of Users</th>	
				</tr>
			</thead>
			<tbody>
				<%
				while (rs.next()) { i++; int courseIdCount=rs.getInt(1);
				List<Object> l=vs.getUserListofCourse(courseIdCount);
				noOfUsers=l.size()/6;				%>
				<tr>
					<td><%=i%></td>
					
					<td><a href="#" onclick="showCourseWiseUser(<%=rs.getInt(1)%>,<%=designationid%>)"><%=rs.getString(2)%></a>
					</td>
					<td><%=noOfUsers %>
				</tr>
				<%
					}
				%>
			</tbody>
		</table><%}} %></div>
		<div align="center">
<%if(alert!=null) {%>
	<span style='color:#3ADF00'> <%=alert%> </span>
<% }else if(falert!=null) { %> <span style='color:#FF0000'> <%=falert%> </span>
<% }else { out.print(" "); } %>
</div>
	</div>
	
</body>
</html>