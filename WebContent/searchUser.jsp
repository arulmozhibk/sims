<%@page import="java.sql.ResultSet"%>
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
<title>Insert title here</title>
</head>
<body>
<%
 String strExamid=request.getParameter("examid");
 int examid=Integer.parseInt(strExamid);
System.out.println("Exam id:"+examid);

String strDesignationID=request.getParameter("designationId"); 
int designationid=Integer.parseInt(strDesignationID); 
AdministrationService ats=new AdministrationService();
ResultSet rset=ats.getUserAccessByDesignation(designationid);
String userID=request.getParameter("userid");
String alert=request.getParameter("alert");
String falert=request.getParameter("falert");
int userid=0;
if(userID==null)
{
	userID=" ";
}
 %> 
 <div class="subcontent">

<%while(rset.next())
{
	boolean read=rset.getBoolean("canread");
	boolean edit=rset.getBoolean("canedit");
	boolean create=rset.getBoolean("cancreate");
	boolean delete=rset.getBoolean("candelete"); %>
	<%if(read) {%>
<table border="0" cellpadding="1" cellspacing="1" bgcolor="#F2F2F2" width="100%"  bordercolor="#FFFFFF">
<tr><td >Register No :</td><td><input type="text" name="userid" id="userid" value="<%=userID%>" onblur="searchUserById(<%=examid%>,<%=designationid %>)"></td>
<td><a href="#"  onclick="addMarkDetails(<%=examid%>,<%=designationid %>)" class="button1">Search </a></td>
</tr>
</table><%}} %>
<div id="searchuser"></div>
<div align="center">
<%if(alert!=null) {%>
	<span style='color:#3ADF00'> <%=alert%> </span>
<% }else if(falert!=null) { %> <span style='color:#FF0000'> <%=falert%> </span>
<% }else { out.print(" "); } %>
</div>
</div><br>
</body>
</html>