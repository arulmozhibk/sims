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
<link rel="stylesheet" type="text/css" href="css/usertable.css">

<title>PayUser</title></head>
<body>
<%
String strUserId=request.getParameter("userId");
int userId=Integer.parseInt(strUserId);
ViewService vs=new ViewService();
ResultSet rs=vs.getUserPayment(userId);
String strDesignationID=request.getParameter("designationId"); 
int designationid=Integer.parseInt(strDesignationID); 
AdministrationService ats=new AdministrationService();
ResultSet rset=ats.getUserAccessByDesignation(designationid);
 String alert=request.getParameter("alert");
 int desigId=0;int count=0;
ResultSet rst = ats.getDesignationByUser(userId);
		
		while(rst.next())
		{	
			desigId=rst.getInt("designation_id");
			System.out.println("desigId "+desigId);
			count++;
		}
 
%>
<div id="content" class="subcontent">
<% if(count>0){
	
	if(desigId==5)
	{%>
<div align="center">
<table width="30%" class="usertable">
<thead ><tr ><td colspan="2" align="center"  bgcolor="#0A82BC" style="color: #FFFFFF"><center>View User</center></td></tr>
</thead>
<tbody>
<%while(rset.next())
{
	boolean read=rset.getBoolean("canread");
	boolean edit=rset.getBoolean("canedit");
	boolean create=rset.getBoolean("cancreate");
	boolean delete=rset.getBoolean("candelete"); %><%
	
	
while(rs.next()){
 %>
 
<%if(read) {%>
 <tr><td colspan="2"><center><strong>Student RegNo : <%=rs.getInt(1) %></strong></center><input type="hidden" id="hiddenUserId" name="hiddenUserId" value="<%=rs.getInt(1) %>"> </td></tr>
<tr><td width="50%">Name </td><td width="50%"><%=rs.getString(2) %></td></tr>
<tr><td>DOB </td><td><%=rs.getString(3) %></td></tr>
<tr><td>Email </td><td><%=rs.getString(4) %></td></tr>
<tr><td>Total Fees</td><td><%=rs.getDouble(5) %></td>
<tr><td>Paid Amount</td><td><%=rs.getDouble(6) %></td>
<tr><td>Remaining Amount</td><td><%=rs.getDouble(7) %></td><% } %>
<% } if(create) {%>
<tr><td>Amount to Pay</td><td><input type="text" name="PaidAmount" id="paidAmount"></td></tr>
 <tr><td></td><td ><a href="#" class="button1" onclick="payAmountforUser(<%=designationid%>)">PayAmount</a></td></tr><%} } %>
</tbody>
 </table>
</div>
<%} else{	%>

<div align="center"><span style='color:#FF0000'> <% out.print("Invalid User for Payment"); }%> </span></div>
<%} else{	%>

<div align="center"><span style='color:#FF0000'> <% out.print("User Not found"); }%> </span></div>

</div>

</body>
</html>