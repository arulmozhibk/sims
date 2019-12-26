<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<!-- <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'> -->
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/register.css">
<!-- <script src="https://use.fonticons.com/c6ec89ce.js"></script>
 -->
 <body>
<script type="text/javascript">
function check()
{
	var num=document.getElementById("tx").value;
	if(num>50)
		{
		alert("greater than 50");
		}
	}
</script>


 <input type="text" id="tx" onblur="check()"><input type="text">
 </body>
</html>
 