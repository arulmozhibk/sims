<%@page import="com.sims.service.AdministrationService"%>
<%@page import="com.sims.service.ViewService"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
<link rel="stylesheet" type="text/css" href="tcal1.css" />
<link rel="stylesheet" type="text/css" href="css/usertable.css">
<title>courseWisePayment</title>
</head>
<body >
<% 
ViewService vs=new ViewService();
ResultSet rs=vs.getCourseNameList();

String strDesignationId=request.getParameter("designationId");
System.out.println("strDesignationId  in course wise payment "+strDesignationId);
int designationid=1;/* Integer.parseInt(strDesignationId); */
AdministrationService ats=new AdministrationService();
ResultSet rset=ats.getUserAccessByDesignation(designationid);


%>
<div class="maincontent" id="maincontent">
 <% while(rset.next())
	{
		boolean read=rset.getBoolean("canread");
		boolean edit=rset.getBoolean("canedit");
		boolean create=rset.getBoolean("cancreate");
		boolean delete=rset.getBoolean("candelete");
		
	%>
	<%if(read) {%>
<table align="center" bgcolor="#F0F0F0" style="color: #4c4c4c" width="100%"> <tr>
<td>From date :</td><td><input type="text" name="fromDate" id="fromDate"  class="tcal" onclick="f_tcalInit ()"/></td>
<td>To date:</td><td><input type="text" name="toDate" id="toDate" class="tcal" onclick="f_tcalInit ()"/></td>
<td>Course</td>
<td>
<select name="courseId" id="courseId">
<%while(rs.next())
{
 %>
<option value=<%=rs.getInt(1) %>> <%=rs.getString("course_name")%></option>

<% } %>
</select></td>
</tr>
<tr><td align="center" colspan="6"><a href="#" onclick="paymentByCourse(<%=designationid%>)" class="button1">Search</a></td></tr>
</table><%}} %>
<div id="dashboard"> </div>
</div>
</body>
</html>