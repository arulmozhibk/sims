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
<link rel="stylesheet" type="text/css" href="css/button.css">
<link rel="stylesheet" type="text/css" href="css/usertable.css">

<title>Insert title here</title>
</head>
<body>
<% String alert="";
	String strExamid=request.getParameter("examid");
String strUserid=request.getParameter("userid");
int examid=Integer.parseInt(strExamid);
System.out.println("exam id :::"+examid);
int userid=Integer.parseInt(strUserid);
System.out.println("user id :::"+userid);

 ViewService vs=new ViewService();
ResultSet rs=vs.getExamUserDetails(userid);
String strDesignationID=request.getParameter("designationId"); 
int designationid=Integer.parseInt(strDesignationID); 
AdministrationService ats=new AdministrationService();
ResultSet rset=ats.getUserAccessByDesignation(designationid);
 alert=request.getParameter("alert ");
 String falert=request.getParameter("falert");
 int desigId=0;int count=0;
 ResultSet rst = ats.getDesignationByUser(userid);
 		
 		while(rst.next())
 		{	
 			desigId=rst.getInt("designation_id");
 			System.out.println("desigId "+desigId);
 			count++;
 		}
  
%>
<div align="center">
<% if(count>0){
if(desigId==5)
	{ %> 
<%while(rset.next())
{
	boolean read=rset.getBoolean("canread");
	boolean edit=rset.getBoolean("canedit");
	boolean create=rset.getBoolean("cancreate");
	boolean delete=rset.getBoolean("candelete"); %>
	<%if(read) {%>
<table class="usertable" width="60%">
<thead ><tr><td  colspan="2" bgcolor="#0A82BC" style="color: #FFFFFF"><center>View User Details</center></td></tr>
</thead>
<tbody class="tablebody">
<% while(rs.next()){ %>
<tr ><td>Register No  </td><td><%=rs.getInt(1) %></td>
<tr><td>Name </td><td><%=rs.getString(2) %></td></tr>
<tr><td>Department</td><td><%=rs.getString(3) %></td></tr>
<tr><td>Payment </td><td><%=rs.getDouble(4) %></td></tr>
 </tbody><%} %></table><%}  %>
  <br>
<%if(create){ %>
<form action="" name="mark">
 <table class="usertable" width="60%">
<thead><tr><td  colspan="3" align="center" bgcolor="#0A82BC" style="color: #FFFFFF"><center>ADD MARK DETAILS</center></td></tr>
</thead>
 <tbody>
 <tr><td>Subject 1:</td><td><input type="text" name="sub1" id="sub1" onkeyup="showTotal()" onblur="mark1Check()"><br><span id="mark1" style="color:red;font-size: 12px "></span></td><td>/100</td></tr>
<tr><td>Subject 2:</td><td><input type="text" name="sub2" id="sub2" onkeyup="showTotal()" onblur="mark2Check()"><br><span id="mark2" style="color:red;font-size: 12px "></span></td><td>/100</td></tr>
<tr><td>Subject 3:</td><td><input type="text" name="sub3" id="sub3" onkeyup="showTotal()" onblur="mark3Check()"><br><span id="mark3" style="color:red;font-size: 12px "></span></td><td>/100</td></tr>
<tr><td>Subject 4:</td><td><input type="text" name="sub4" id="sub4" onkeyup="showTotal()" onblur="mark4Check()"><br><span id="mark4" style="color:red;font-size: 12px "></span></td><td>/100</td></tr>
<tr><td>Subject 5:</td><td><input type="text" name="sub5" id="sub5" onkeyup="showTotal()" onblur="mark5Check()"><br><span id="mark5" style="color:red;font-size: 12px "></span></td><td>/100</td></tr>
<tr><td>Total :</td><td><input type="text" name="total" id="total" onblur="totalCheck()"><br><span id="atotal" style="color:red;font-size: 12px "></span></td><td>500<br></td></tr>
<tr><td colspan="3"><center><a href="#" onclick="addMarks(<%=examid%>,<%=userid %>,<%=designationid %>)" class="button1">Add Marks</a></center></td></tr>
</tbody></table><% } } %></form>
<% } else {	%>

<div align="center"><span style='color:#FF0000'> <% out.print("Invalid User for Adding Mark Details"); }%> </span></div>


<div align="center">
<%if(alert!=null) {%>
	<span style='color:#3ADF00'> <%=alert%> </span>
<% }else if(falert!=null) { %> <span style='color:#FF0000'> <%=falert%> </span>
<% }else { out.print(" "); } %>
<%} else{	%>
<div align="center"><span style='color:#FF0000'> <% out.print("User Not found"); }%> </span></div>
</div>

</div>
</body>
</html>