<%@page import="java.sql.ResultSet"%>
<%@page import="com.sims.service.ViewService"%>
<%@page import="com.sims.service.AdministrationService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
<link rel="stylesheet" type="text/css" href="css/table.css">

<title>Payment Report By Course</title>
</head>
<body>
	<%
		String strCourseId = request.getParameter("courseId");
		String strFromDate = request.getParameter("fromDate");
		String strToDate = request.getParameter("toDate");
		System.out.println("strCourseId  :" + strCourseId
				+ " strFromDate : " + strFromDate + " strToDate : :"
				+ strToDate);
		int courseId = Integer.parseInt(strCourseId);
		int i = 0;
		ViewService vs = new ViewService();
		ResultSet rs = vs.getPaymentOfCourse(courseId, strFromDate,
				strToDate);

		String strDesignationId = request.getParameter("designationId");
		System.out.println("strDesignationId " + strDesignationId);
		int designationid = 1;/* Integer.parseInt(strDesignationId); */
		AdministrationService ats = new AdministrationService();
		ResultSet rset = ats.getUserAccessByDesignation(designationid);
	
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
			<br>
			<table width="100%" id="payment" class="tbl">
				<thead>
					<tr>
						<td colspan="5" bgcolor="#FFFFFF"><center>
								<strong>List Of Payment</strong>
							</center></td>
					</tr>
					<tr style="color: #FFFFFF">
						<th  align="center" bgcolor="#0A82BC">S.No</th>
						<th align="center" bgcolor="#0A82BC">User Name</th>
						<th align="center" bgcolor="#0A82BC">Course Name</th>
						<th align="center" bgcolor="#0A82BC">Paid Amount</th>
						<th align="center" bgcolor="#0A82BC">Payment Date</th>
					</tr>
				</thead>
				<tbody>
					<%
						while (rs.next()) {
									i++;
					%>
					<tr>
						<td><%=i%></td>
						<td><%=rs.getString(1)%></td>
						<td><%=rs.getString(2)%></td>
						<td><%=rs.getDouble(3)%></td>
						<td><%=rs.getDate(4)%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<table width="100%">
				<tfoot>
					<tr>
						<td colspan="5" align="center"><a href="#"
							onclick="ExcelReport()">Export To Excel</a></td>
					</tr>
				</tfoot>
			</table>
			<%}} %>
		</div>
</body>
</html>