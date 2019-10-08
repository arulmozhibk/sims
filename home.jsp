<%@page import="java.text.SimpleDateFormat"%>
<%@page import="sun.java2d.pipe.SpanShapeRenderer.Simple"%>
<%@page import="java.util.Date"%>
<%@page import="com.sims.service.AdministrationService"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.sims.service.ViewService"%>
<%@ page language="java" session="true" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SIMS Home Screen</title>
 <link rel="stylesheet" type="text/css" href="css/layoutstyle.css" media="screen" />
 <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" />
 <link rel="stylesheet" type="text/css" href="css/panel.css">
 <link rel="stylesheet" type="text/css" href="css/hoverbule.css">
 <link rel="stylesheet" type="text/css" href="css/button.css">
<link rel="stylesheet" type="text/css" href="css/togglebox.css">
<link rel="stylesheet" type="text/css" href="css/tcal.css" />
 
 <script type="text/javascript" src="js/sims.js"></script>
 <script type="text/javascript" src="js/sims2.js"></script>  
 <script type="text/javascript" src="js/sims3.js"></script>  
 <script type="text/javascript" src="js/dashboard.js"></script>
<script type="text/javascript" src="js/tcal.js"></script> 
<script type="text/javascript" src="js/excellentexport.js"></script>
</head>
<body>
<%

		
		ResultSet rset = null;
		String email = null;
		String username = null;
		int designationId=0;
		
		  response.setHeader("Cache-Control","no-cache");
		    response.setHeader("Cache-Control","no-store");
		    response.setDateHeader("Expires", 0);
		    response.setHeader("Pragma","no-cache");
		    
		HttpSession ssn = request.getSession(false);
		System.out.println("session :"+ssn);
		if (session != null)
		{
			ViewService vs = new ViewService();
			email = (String) ssn.getAttribute("ssnName");
			/* Long ltime=session.getCreationTime();
			Date date=new Date(ltime);
			SimpleDateFormat sd=new SimpleDateFormat("dd/mm/yyyy");
			final int timel=SimpleDateFormat.TIMEZONE_FIELD;
			sd.format(date);
			System.out.println("ltime :"+date+" "+ltime+" "+timel);
			
			long lasttime=ssn.getLastAccessedTime();
			System.out.println("last logintime :"+lasttime);
			Date date1=new Date(lasttime);
			SimpleDateFormat sd1=new SimpleDateFormat("dd/mm/yyyy");
			String sf=sd.format(date);
			System.out.println("2 : last time :"+date1+" "+lasttime+" "+sf);
			Date curDate=new Date(); */
			
			rset = vs.getUserDetails(email);
			while (rset.next()) {
				username = rset.getString("username");
				designationId=rset.getInt("designation_id");
				System.out.println("designationId in home "+designationId); }
			
		
		
		
	%>
	<%
	AdministrationService ads=new AdministrationService();
	ResultSet rs=ads.getMenusOfDesignation(designationId);
	System.out.println("designationId in home : : "+designationId);
	 %>
 <div class="headerpanel">
 <div class="titlefirst floatleft"><br>
 <span class="white large">&nbsp;&nbsp; Blue</span><span class="skyblue large">Whale&nbsp;&nbsp;&nbsp;&nbsp;</span></div>
 <div class="menubar">	
  <div class="grid_12">
  
            <ul class="nav main">
            <li class="ic-form-style"><a href="javascript:"><span>Typography</span></a>
                    
                </li>
                <li class="ic-dashboard"><a href="javascript:"><span>Dashboard</span></a>
                <ul>
                    <li><a href="#" onclick="dashboardPayment(<%=designationId%>)"><span>Course-wise Payment</span></a></li>
                        
                    </ul></li>
                
                <li class="ic-charts"><a href=""><span>Charts and Graphs</span></a></li>
                <li class="ic-grid-tables"><a href=""><span>Data Table</span></a></li>
                <li class="ic-gallery dd"><a href="javascript:"><span>Image Galleries</span></a></li>               		
                <li class="ic-notifications"><a href=""><span>Notifications</span></a></li>
            </ul>
        </div></div>        
            <div id="branding">
                <div class="floatright">
                   
                <div class="floatright">
                    <div class="floatleft">
                        <img src="images/profile.jpg" alt="Profile Pic" /></div>
                    <div class="floatleft marginleft10">
                       <form action="Logout" method="post"> <ul class="inline-ul floatleft small">
                            <li>Hello <%=username%></li>
                            <li> <a href="#" style="font-size: 12px">Config</a></li>
                            <li><a><input class="buttontolink" type="submit" value="Logout"></a></li>
                        </ul></form>
                        <br>
                        <span class="extrasmall grey">Last Login: 3 hours ago</span>
                    </div>
                </div>
                
            </div>
        </div>
        </div>
  <div class="clear"></div>
		
 <div id="main" class="mainlayout"></div>  
  
 <div id="modules" class="modulesbar">
<div class="Blue_panel_with_menu clearfix">
<h2><span>Modules</span></h2>
			<div class="panel_blue_container">
				<ul class="left_navigation clearfix">

					<%while(rs.next())
				{
					int menu=(int) rs.getInt("menu_rights_id");
					
					switch (menu) {
					case 1:%>
					<li> <input class="toggle-box" id="header1" type="checkbox">
						<label for="header1"> <%=rs.getString("menu_rights_name") %></label>
						<div>

							<a href="#" onclick="adminRegistration(<%=designationId%>)"
								title="Administration" class="active">
								User Registration
							</a>

						</div>
			
			
			<%		break;
					case 2:%>
				
					<li><a href="#" onclick="loadAdmin(<%=designationId%>)" title="Administration"
						class="active"><%=rs.getString("menu_rights_name") %> </a></li>
						<%		break;
					case 3: %>
					<li><a href="#"  class="active" onclick="loadManageUser(<%=designationId%>)" title="ManageUser"><%=rs.getString("menu_rights_name")%>
							</a></li>
							<%		break;
					case 4:%>
					<li><a href="#" class="active" onclick="loadFeesConfiguration(<%=designationId%>)" title="Fees"><%=rs.getString("menu_rights_name")%></a></li>
							<%		break;
					case 5:%>
					<li><a href="#" class="active" onclick="loadExamination(<%=designationId%>)"
						title="Examination"><%=rs.getString("menu_rights_name")%></a></li>
						<%		break;
					case 6:%>
					<li><a href="#" class="active" onclick="loadAcademics(<%=designationId%>)"
						title="Academic Report"><%=rs.getString("menu_rights_name")%></a></li>
						
						<% default:
							System.out.println(" ");
							break;
						}
					} %>
					
						
				</ul></div>
<div class="bl"></div>
<input type="hidden" id="hiddenDesignationID" value="designationId">
<div class="br"></div>
</div></div>
 

</body><% }
			else
			{
				response.sendRedirect("index.jsp");
				out.println("<div  style='color:red'>  ::   Please Login Again   :::   </div>");

			}
			%>
</html>