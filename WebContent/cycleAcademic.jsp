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
<link rel="stylesheet" type="text/css" href="css/hoverbule.css">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/table.css" />
<title>Insert title here</title>

</head>
<body>
	<%
		int i = 0;
		ViewService vs = new ViewService();
		ResultSet rs = vs.getCycleExam();

		String strDesignationID = request.getParameter("designationId");
		int designationid = Integer.parseInt(strDesignationID);

		AdministrationService ats = new AdministrationService();
		ResultSet rset = ats.getUserAccessByDesignation(designationid);
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
			if (read) {
		%>
		<div align="center">
			<table class="tbl">
				<thead align="left">
					<tr>
						<td colspan="3"><center>
								<strong>List of Cycle Examination</strong>
							</center></td>
					</tr>
					<tr style="color: #FFFFFF">
						<th align="center" bgcolor="#0A82BC">Serial.No</th>
						<th align="center" bgcolor="#0A82BC">Exam Name</th>
					</tr>
				</thead>
				<tbody class="tablebody">
					<%
						while (rs.next()) {
									i++;
					%>
					<tr>
						<td><%=i%></td>
						<td><a href="#"
							onclick="coursesList(<%=rs.getInt("exam_id")%>,<%=designationid%>)"><%=rs.getString("exam_name") %></a></td>
					</tr>
					<%} %>
				</tbody>
			</table>
			<%} } %>
		</div>
	</div>
</body>
</html>