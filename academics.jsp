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

<title>Academic Report</title>
<body>
<%String strDesignationID=request.getParameter("designationId"); 
int designationid=Integer.parseInt(strDesignationID); 
String alert=request.getParameter("alert ");
%>
<div class="maincontent">
<div class="Bule_style_menu clearfix">
<ul class="clearfix">
<li><a href="#" onclick="cycleCourse(<%=designationid %>)" title="cycle" ><span>Cycle Test</span></a></li>
<li><a href="#" onclick="semCourse(<%=designationid %>)" title="Sem"><span>Semester Exam</span></a></li>
</ul>
</div>
<div id="academics"></div>
</div>
</body>
</html>