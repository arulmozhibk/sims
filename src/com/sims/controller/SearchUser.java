                                    package com.sims.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.service.AdministrationService;

/**
 * Servlet implementation class SearchUser
 */
@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUser() {
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
		
		String strUserid=request.getParameter("userid");
		int userId=Integer.parseInt(strUserid.trim());
		
		String strExamid=request.getParameter("examid");
		int examid=Integer.parseInt(strExamid);
		
		
		
		String strDesignationId=request.getParameter("designationId");
		int designationID=Integer.parseInt(strDesignationId);
		System.out.println("examid"+examid+" userid "+userId+"designationId "+designationID);
		AdministrationService ats=new AdministrationService();
		String alert="";String falert="";
		ResultSet rst;
		int userCount=0;
		String designationName="";
		try {
			rst = ats.getDesignationByUser(userId);
			
			while(rst.next())
			{	
				designationName=rst.getString("designation_name");
				System.out.println("designationName "+designationName);
				userCount++;
			}
			System.out.println("designationName "+designationName);
			
		if(userCount>0)
		{
			System.out.println("User found");
			if(designationName.equals("Student"))
			{
			alert="Valid User";
			RequestDispatcher rd=request.getRequestDispatcher("searchUser.jsp?userid="+userId+"& examid=" + examid+"&designationId="+designationID+"&alert="+alert);
			rd.include(request, response);	
			System.out.println("Valid user");
			}
			else
			{
				falert="Invalid User";
				RequestDispatcher rdp=request.getRequestDispatcher("searchUser.jsp?userid="+userId+"& examid=" + examid+"&designationId="+designationID+"&falert="+falert);
				rdp.include(request, response);	
				System.out.println("Invalid user");
			}
			
			
		}
		else{
			falert="User not found";
			System.out.println("User not found");
			RequestDispatcher rd1=request.getRequestDispatcher("searchUser.jsp?userid="+userId+"& examid=" + examid+"&designationId="+designationID+"&falert="+falert);
			rd1.include(request, response);	
		}
		
		
		}catch (SQLException e) {
			System.out.println("User can not found");
			alert="User not found , Please enter the valid user id";
			System.out.println("User not found");
			RequestDispatcher rd1=request.getRequestDispatcher("searchUser.jsp?userid="+userId+"& examid=" + examid+"&designationId="+designationID+"&falert="+falert);
			rd1.include(request, response);	
		e.printStackTrace();}
		
		
	}

}
