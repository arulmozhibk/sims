package com.sims.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.bean.CourseBean;
import com.sims.service.AdminService;


/**
 * Servlet implementation class CreateCourse
 */
public class CreateCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCourse() {
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
		String strDesignationId=request.getParameter("designationId");
		
		String strCourseName=request.getParameter("coursename");
		String strCourseFees=request.getParameter("coursefees");
		Double fees=Double.parseDouble(strCourseFees);
		int designationId=Integer.parseInt(strDesignationId);
		
		AdminService as=new AdminService();
		CourseBean cb=new CourseBean();
		cb.setCourse_name(strCourseName);
		cb.setFees(fees);
		String alert=" ";String falert="";
		try {
			boolean  status=as.createCourseService(cb);
			System.out.println("status"+status);
			
			if(status==true){
				alert="Course Created";
				RequestDispatcher rd=request.getRequestDispatcher("createCourse.jsp?designationId="+designationId+"&alert="+alert);
				rd.include(request, response);
			}
			
		} catch (SQLException e) {
			falert="Failed to Create Course ";
			RequestDispatcher rd=request.getRequestDispatcher("createCourse.jsp?designationId="+designationId+"&falert="+falert);
			rd.include(request, response);
			e.printStackTrace();
		}

	}

}
