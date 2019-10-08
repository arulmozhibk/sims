package com.sims.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.bean.UserBean;
import com.sims.dao.UserDao;
import com.sims.service.AdminService;

/**
 * Servlet implementation class RegistrationSevlet
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		String username=request.getParameter("username");
		String dob=request.getParameter("dob");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String courseid=request.getParameter("courseid");
		String designationid=request.getParameter("designationid");
		int designationId=Integer.parseInt(designationid);
		String strUsertype=request.getParameter("usertype");
		int courseId=Integer.parseInt(courseid);
		int usertype=0;
		if(strUsertype!=null)
		{usertype=Integer.parseInt(strUsertype);}
		System.out.println(" Usertype :"+usertype);
		AdminService as=new AdminService();
		UserBean ub=new UserBean();
		ub.setUsername(username);
		ub.setDob(dob);
		ub.setEmail(email);
		ub.setPassword(password);
		ub.setCourse_id(courseId);
		ub.setDesignation_id(usertype);
		String alert=" ";String falert=" ";
		
		try {
			boolean status=as.createUser(ub);
			if(status==true)
			{
				
				if(designationId!=5)
				{ alert="User Created";
					RequestDispatcher red=request.getRequestDispatcher("registration.jsp?alert="+alert+"&designationId="+designationId);
				System.out.println("User Registration Success");
				red.forward(request, response);
				}
				else if(designationId==5)
				{
					System.out.println("Student Registration Success");
					alert="Student Created";
					RequestDispatcher rd=request.getRequestDispatcher("createUser.jsp?alert="+alert+"& designationId="+designationId);
					rd.forward(request, response);
				}
				}
			else{
				
				System.out.println("Registration Failed.! Please Try Again..!");
				if(designationId==5)
				{falert="Failed to Create Student";
			RequestDispatcher rd1=request.getRequestDispatcher("createUser.jsp?falert="+falert+"&designationId="+designationId);
			rd1.forward(request, response);
				}
				else{
					falert="Failed to Create User";
					RequestDispatcher red1=request.getRequestDispatcher("registration.jsp?falert="+falert+"&designationId="+designationId);
			System.out.println("Registration Success");
			red1.forward(request, response);
			}
			}
			
		} catch (SQLException e) {
			if(designationId==5){
			falert="Student Registration Failed. Please Try Again.";
			RequestDispatcher rd2=request.getRequestDispatcher("createUser.jsp?falert="+falert+"&designationId="+designationId);
			rd2.forward(request, response);
				e.printStackTrace();
			}else{
				falert="User Registration Failed. Please Try Again.";
				RequestDispatcher rd2=request.getRequestDispatcher("registration.jsp?falert="+falert+"&designationId="+designationId);
				rd2.forward(request, response);
					e.printStackTrace();
			}
		}
		
		catch (Exception ne) {
			if(designationId==5){
				falert="Student Registration Failed. Please Try Again.";
				RequestDispatcher rd3=request.getRequestDispatcher("createUser.jsp?falert="+falert+"&designationId="+designationId);
				rd3.forward(request, response);
					ne.printStackTrace();
				}else{
					falert="User Registration Failed. Please Try Again.";
					RequestDispatcher rd3=request.getRequestDispatcher("registration.jsp?falert="+falert+"&designationId="+designationId);
					rd3.forward(request, response);
						ne.printStackTrace();
				}
	
		}
		
	}
	
	

}
