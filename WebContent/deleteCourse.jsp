<%@page import="com.sims.service.AdministrationService"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.sims.service.ViewService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
<link rel="stylesheet" type="text/css" href="css/table.css" />
<title>DeleteCourse</title>
</head>

<body>
	<%
		String strDesignationId = request.getParameter("designationId");
		System.out.println("strDesignationId " + strDesignationId);
		int designationId = Integer.parseInt(strDesignationId);
		AdministrationService ats = new AdministrationService();
		ResultSet rset = ats.getUserAccessByDesignation(designationId);

		ViewService vs = new ViewService();
		ResultSet rs = vs.getCourseList();
		int i = 0;
	%>
	<div id="subcontent" class="subcontent">

		<form action="">
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
					<thead>
						<tr>
							<td colspan="4" bgcolor="#FFFFFF"><center>List Of
									Available Courses</center></td>
						<tr style="color: #FFFFFF">
							<th align="center" bgcolor="#0A82BC"></th>
							<th align="center" bgcolor="#0A82BC">Course No</th>
							<th align="center" bgcolor="#0A82BC">Course Name</th>
						</tr>
					</thead>
					<tbody>
						<%
							while (rs.next()) {
										int deleteCourse = rs.getInt(1);
										i++;
						%>
						<tr>
							<td width="10%"><input type="checkbox"
								value="<%=deleteCourse%>" name="deleteCourse" id="deleteCourse"></td>
							<td><%=i%></td>
							<td><%=rs.getString(2)%></td>
						</tr>
						<%
							}
								}
						%>
						<%
							if (read) {
						%>
						<tr>
							<td colspan="4"><center>
									<a href="#" class="button1" onclick="deleteCourse()">Delete
										Course</a>
								</center></td>
						</tr>
					</tbody>
				</table>
				<% } } %>
			</div>
		</form>
	</div>
	<div id="CourseList"></div>

</body>
</html>
