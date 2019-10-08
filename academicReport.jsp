<%@page import="com.sims.service.AdministrationService"%>
<%@page import="com.sims.service.ViewService"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/report.css" />

<title>Insert title here</title>
</head>
<body>
	<%
		int i = 0;
		request.setCharacterEncoding("UTF-8");
		String strExamId = request.getParameter("examId");
		String strCourseID = request.getParameter("courseId");
		int examId = Integer.parseInt(strExamId);
		int courseId = Integer.parseInt(strCourseID);
		ViewService vs = new ViewService();
		ResultSet rs = vs.viewCourseResult(courseId, examId);
		System.out.println("In academic report examId : :" + examId
				+ "courseId" + courseId);

		String strDesignationID = request.getParameter("designationId");
		int designationId = Integer.parseInt(strDesignationID);
		AdministrationService ats = new AdministrationService();
		ResultSet rset = ats.getUserAccessByDesignation(designationId);
	%>
	<div id="subcontent " class="subcontent">
		<%
			while (rset.next()) {
				boolean read = rset.getBoolean("canread");
				boolean edit = rset.getBoolean("canedit");
				boolean create = rset.getBoolean("cancreate");
				boolean delete = rset.getBoolean("candelete");
		%>
		<%
			if(read) {
		%>
		<div align="center">
			<table class="tabl" width="100%">
				<thead>
					<tr>
						<td align="center" colspan="11" bgcolor="#ffffff"><center><strong>Academic
								Report Of User</strong></center></td>
					</tr>
					<tr  style="color: #FFFFFF">
						<th  align="center" bgcolor="#0A82BC">Serial.No</th>
						<th  align="center" bgcolor="#0A82BC">User ID</th>
						<th  align="center" bgcolor="#0A82BC">User Name</th>
						<th  align="center" bgcolor="#0A82BC">Exam Name</th>
						<th  align="center" bgcolor="#0A82BC">Subject 1</th>
						<th align="center" bgcolor="#0A82BC">Subject 2</th>
						<th align="center" bgcolor="#0A82BC">Subject 3</th>
						<th align="center" bgcolor="#0A82BC">Subject 4</th>
						<th align="center" bgcolor="#0A82BC">Subject 5</th>
						<th align="center" bgcolor="#0A82BC">Total</th>
						<th align="center" bgcolor="#0A82BC">Percentage</th>
					</tr>
				</thead>
				<tbody >
					<%
						while (rs.next()) {
									i++;
					%>
					<tr>
						<td><%=i%></td>
						<td><%=rs.getInt(1)%></td>
						<td><%=rs.getString(2)%></td>
						<td><%=rs.getString(3)%></td>
						<td><%=rs.getInt(4)%></td>
						<td><%=rs.getInt(5)%></td>
						<td><%=rs.getInt(6) %></td>
						<td><%=rs.getInt(7) %></td>
						<td><%=rs.getInt(8) %></td>
						<td><%=rs.getInt(9) %>
						<td><%=rs.getDouble(10)%></td>
						<%} %>
					
				</tbody>
			</table>
			<% } } %>
		</div>
	</div>
</body>
</html>