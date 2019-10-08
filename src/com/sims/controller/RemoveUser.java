package com.sims.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.service.AdminService;

/**
 * Servlet implementation class RemoveUser
 */
public class RemoveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveUser() {
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
		String designationid=request.getParameter("designationId");
		int designationId=Integer.parseInt(designationid);
		
		String[] strUserId=request.getParameterValues("removeUserId");
		String removeId="";
		for(int i=0;i<strUserId.length;i++)
		{
			removeId=removeId+strUserId[i];
		}
		for(String UserId:removeId.split(","))
		{
			UserId.trim();
			if(UserId.equals(""))
			{
				
			}
			else
			{
				System.out.println("UserId to remove "+UserId);
			
		
		AdminService as=new AdminService();		
		String alert="";String falert="";
		try {
			boolean status=as.removeUser(UserId);
			if(status==true)
			{ alert="User Removed";
				RequestDispatcher rd=request.getRequestDispatcher("removeUser.jsp?alert="+alert+"&designationId="+designationId);
				rd.include(request, response);
				System.out.println("Servlet : User Removed");
				
			}
			else{
				falert="User can not be Removed";
				RequestDispatcher rd1=request.getRequestDispatcher("removeUser.jsp?falert="+falert+"&designationId="+designationId);
				rd1.include(request, response);
				System.out.println("User can not be Removed");

			}
		} catch (SQLException e) {
			falert="User can not Remove";
			RequestDispatcher rd=request.getRequestDispatcher("removeUser.jsp?falert="+falert+"&designationId="+designationId);
			rd.include(request, response);
			e.printStackTrace();

		}
			} }
	}

}
