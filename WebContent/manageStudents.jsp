<%@page import="com.sims.service.AdministrationService"%>
<%@page import="com.sims.service.ViewService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
<link rel="stylesheet" type="text/css" href="css/table.css">
<title>Insert title here</title>
</head>
<body><%
		String strCourseId = request.getParameter("courseId");
		int courseId = Integer.parseInt(strCourseId);	
		System.out.println(" Course ID:"+courseId);
		int i = 0;
		ViewService vs = new ViewService();
		ResultSet rs = vs.getUsersByCourse(courseId); 

		String strDesignationID=request.getParameter("designationId"); 
		int designationid=Integer.parseInt(strDesignationID); 

		AdministrationService ats=new AdministrationService();
		ResultSet rset=ats.getUserAccessByDesignation(designationid);
		 String alert=request.getParameter("alert");
		 
		 ResultSet result = vs.getCourseService(courseId);
			String courseName="";
			while(result.next())
			{
				courseName=result.getString("course_name");
			}
			System.out.println("coursename : :"+courseName);
	%>
		<div id="subcontent" class="subcontent">
		<form action="">
		<%while(rset.next())
{
	boolean read=rset.getBoolean("canread");
	boolean edit=rset.getBoolean("canedit");
	boolean create=rset.getBoolean("cancreate");
	boolean delete=rset.getBoolean("candelete"); %>
	<%if(delete) {%>
	<div align="center">
			<table class="tbl">
				<thead align="left">
					<tr>			
						<td colspan="4"><center><strong>Available Users in <%=courseName %></strong></center></td>
					</tr>
					<tr style="color: #FFFFFF">
						<th align="center" bgcolor="#0A82BC"></th>
						<th align="center" bgcolor="#0A82BC">S.No</th>
						<th align="center" bgcolor="#0A82BC">User ID</th>
						<th align="center" bgcolor="#0A82BC">User Name</th>
					</tr>
				</thead>
				<tbody >
					<%
						while (rs.next()) {
							i++;
							int userid=rs.getInt(2);
					%>
					<tr>
						<td><input type="checkbox" value="<%=userid%>"
							name="userList"></td>
						<td><%=i %></td>	
						<td><%=userid%></td>
						<td><%=rs.getString(3)%></td>
					</tr>
					<%
						}
					%>
					<tr align="center">
						<td colspan="4"><center><a href="#" onclick="removeUser(<%=designationid%>)" class="button1">Remove User</a></center></td>
					</tr>

				</tbody>
							</table><%}} %></div>
		</form> 
	</div>
</body>
</html>