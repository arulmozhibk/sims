package com.sims.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.service.AdminService;

/**
 * Servlet implementation class MoveUser
 */
public class MoveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveUser() {
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
		// TODO Auto-generated method stub
		String strDesignationId=request.getParameter("designationId");
				int designationID=Integer.parseInt(strDesignationId);
				
		String strEditCourseId=request.getParameter("moveCourseId");
		int moveCourseId=Integer.parseInt(strEditCourseId);
		
		java.util.List<String> al=new ArrayList<>();
		AdminService as=new AdminService();
		String alert=" "; 
		String falert=" ";
		
		String[] strEditUserId=request.getParameterValues("moveUserId");
		String editUser="";
		for(int i=0;i<strEditUserId.length;i++)
		{
			editUser=editUser+strEditUserId[i];
			System.out.println("editUser"+editUser);
		}
		//List <String> al=new ArrayList<>();
		for(String userId:editUser.split(","))
		{
			userId.trim();
			if(userId.equals(""))
			{
				
			}else
			{
				al.add(userId);
			}
			
		}
		
		Iterator<String> iter=al.iterator();
		
		for(int i=0;i<al.size();i++)
		{
			String editUserId=iter.next();
			System.out.println("editUserId"+editUserId);
		
		try {
			
			boolean status=as.moveUser(editUserId,moveCourseId);
			if(status==true){
				alert="User moved to another course";
				System.out.println("User Moved");
				RequestDispatcher rd=request.getRequestDispatcher("moveUser.jsp?designationId="+designationID+"&alert="+alert);
				rd.include(request, response);
				
			}
			else
			{ falert="User can not Move.!";
				System.out.println("Error in moving");
				RequestDispatcher rd2=request.getRequestDispatcher("moveUser.jsp?designationId="+designationID+"&falert="+falert);
				rd2.include(request, response);
			}
			
			
		} catch (SQLException e) {
			falert="User can not Move ";
			System.out.println("Exception in moving");
			response.sendRedirect("moveUser.jsp?designationId="+designationID+"&falert="+falert);

		}
		
	}

}}
