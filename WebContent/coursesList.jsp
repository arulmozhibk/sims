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
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/table.css" />
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String strExamId = request.getParameter("examId");
		int examId = Integer.parseInt(strExamId);
		System.out.println("Exam ID: " + examId);

		String strDesignationID = request.getParameter("designationId");
		int designationid = Integer.parseInt(strDesignationID);

		AdministrationService ats = new AdministrationService();
		ResultSet rset = ats.getUserAccessByDesignation(designationid);

		ViewService vs = new ViewService();
		ResultSet rs = vs.getCourseList();

		int i = 0;
	%>

	<div id="subcontent " class="subcontent">
		<br>


		<%
			while (rset.next()) {
				boolean read = rset.getBoolean("canread");
				boolean edit = rset.getBoolean("canedit");
				boolean create = rset.getBoolean("cancreate");
				boolean delete = rset.getBoolean("candelete");
		%>
		<%
			if (read) {
		%>
		<div align="center">
			<table class="tbl">
				<thead align="left">
					<tr>
						<td colspan="3"><center>
								<strong>List of Available Courses</strong>
							</center></td>
					</tr>
					<tr style="color: #FFFFFF">
						<th align="center" bgcolor="#0A82BC">Serial.No</th>
						<th align="center" bgcolor="#0A82BC">Course Name</th>
				</thead>
				<tbody>
					<%
						while (rs.next()) {
									i++;
					%>
					<tr>
						<td><%=i%></td>
						<td><a href="#"
							onclick="academicReport(<%=designationid%>,<%=rs.getInt("course_id")%>)"><%=rs.getString("course_name")%></a></td>
					</tr>
				</tbody>
				<%
					}
				%>
				
			</table><input type="hidden" name="hiddenExamId" id="hiddenExamId"
						value="<%=examId%>">
			<%}} %>
		</div>
	</div>
	<br>
	<br>
	<div id="report"></div>
</body>
</html>