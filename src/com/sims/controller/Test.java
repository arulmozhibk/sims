package com.sims.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.service.AdministrationService;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		System.out.println("SearchUser Servlet execution");
		String strUserid=request.getParameter("UserID");
		int userId=Integer.parseInt(strUserid.trim());
					
		String strDesignationId=request.getParameter("designationId");
		int designationID=Integer.parseInt(strDesignationId);
		System.out.println("user id "+ userId +"designationId "+designationID);
		AdministrationService ats=new AdministrationService();
		String alert="";String falert="";
		ResultSet rst;
		int userCount=0;
		String designationName="";int designation_id=0;
		try {
			rst = ats.getDesignationByUser(userId);
			
			while(rst.next())
			{	
				designationName=rst.getString("designation_name");
				designation_id=rst.getInt("designation_id");
				System.out.println("designationName "+designationName+"designation_id "+designation_id);
				userCount++;
			}
			System.out.println("designationName "+designationName);
			
		if(userCount>0)
		{
			System.out.println("User found");
			if(designation_id==5)
			{
			alert="Valid User";
			response.sendRedirect("feesConfiguration.jsp?userid="+userId+"&designationId="+designationID+"&alert="+alert);
			System.out.println("Valid user");
			}
			else
			{
				falert="Invalid User";
				response.sendRedirect("feesConfiguration.jsp?userid="+userId+"&designationId="+designationID+"&falert="+falert);
				System.out.println("Invalid user");
			}
			
			
		}
		else{
			falert="User not found";
			System.out.println("User not found");
			response.sendRedirect("feesConfiguration.jsp?userid="+userId+"&designationId="+designationID+"&falert="+falert);
		}
		
		
		}catch (SQLException e) {
			System.out.println("User can not found");
			falert="User not found , Please enter the valid user id";
			System.out.println("User not found");
			response.sendRedirect("feesConfiguration.jsp?userid="+userId+"&designationId="+designationID+"&falert="+falert);
		e.printStackTrace();}
		
		
	}
	}


