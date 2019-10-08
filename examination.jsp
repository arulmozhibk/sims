<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/layoutstyle.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
<link rel="stylesheet" type="text/css" href="css/hoverbule.css">

<title>Examination</title>

</head>
<body>
<%String strDesignationID=request.getParameter("designationId"); 
int designationid=Integer.parseInt(strDesignationID); 
String alert=request.getParameter("alertmsg");
String falert=request.getParameter("falertmsg");
System.out.println("alert :"+alert);
%>
<div id="maincontent" class="maincontent">

 <div class="Bule_style_menu clearfix">
<ul class="clearfix">
<li><a href="#" onclick="CycleTests(<%=designationid %>)" title="CT" ><span>Cycle Test</span></a></li>
<li><a href="#" onclick="SemExams(<%=designationid %>)" title="SE" ><span>Semester Exam</span></a></li>
</ul>

</div>
<div align="center">
<%if(alert!=null) {%>
	<span style='color:#3ADF00'> <%=alert%> </span>
<% }else if(falert!=null) { %> <span style='color:#FF0000'> <%=falert%> </span>
<% }else { out.print(" "); } %>
</div>
<div id="exam" ></div>
</div>


</body>
</html>